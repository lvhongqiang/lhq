package xx.service;

import com.google.gson.GsonBuilder;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import xx.model.vo.BaiduResponse;

import java.io.*;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Lv on 2016/11/30.
 */
@Service
public class PostUrlService extends BaseService {
    private final Logger logger=Logger.getLogger(PostUrlService.class);
    private final String baiduAPI ="http://data.zz.baidu.com/urls?site=www.lhqnb.com&token=sBJEGoSbcdq2KGWa";
    //被提交的url模板
    private final String postUrl="http://www.lhqnb.com/nb{{id}}.html";
    //每次提交url数量。
    private final Integer defaultPostSize=100;

    private CloseableHttpClient httpclient = HttpClients.createDefault();

    /**
     * 如果24小时内有新数据，则重新生成sitemap.txt
     * @param filePath
     */
    public void autoBuildSitemap(String filePath){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-1);
        Integer count=baseDao.countHql("select count(*) from CrawlerArticle where insertTime>?",calendar.getTime());
        if(count>0){
            logger.info("生成sitemap.txt开始......");
            buildSitemap(filePath);
            logger.info("生成sitemap.txt结束......");
        }
    }

    /**
     * 生成sitemap.txt
     * @param filePath
     * @return
     */
    public boolean buildSitemap(String filePath){
        try {
            String realPath= System.getProperty("user.dir")+"/../webapps/ROOT/"+filePath;
            logger.debug("准备将sitemap.txt写入到"+realPath);
            File dir=new File(realPath.substring(0,realPath.lastIndexOf("/")));
            if(!dir.exists()){
                dir.mkdirs();
            }
            FileWriter out = new FileWriter(realPath);
            BufferedWriter writer = new BufferedWriter(out);
            List<Integer> idList=baseDao.find("select id from CrawlerArticle");
            String url;
            for (Integer id : idList) {
                url=postUrl.replace("{{id}}",id.toString());
                writer.write(url+"\r\n");
            }
            writer.close();
            out.close();
            logger.debug("成功将sitemap.txt写入到"+realPath);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 自动读取未提交的url，并提交到百度。
     */
    public void autoPostToBaidu(Integer postSize){
        if(postSize==null)postSize=defaultPostSize;
        List<Integer> idList=baseDao.findList("select id from CrawlerArticle where baiduPost is null order by id desc",
                0,postSize);
        for (Integer id : idList) {
            if(postUrlToBaidu(id)){
                baseDao.executeHql("update CrawlerArticle set baiduPost=1 where id=?",id);
            }
        }
    }

    /**
     * 提交某一url到百度
     * @param id
     * @return
     */
    private boolean postUrlToBaidu(Integer id){
        if(id==null) return false;
        String url=postUrl.replace("{{id}}",id.toString());
        StringEntity entity = new StringEntity(url,ContentType.create("text/plain", Consts.UTF_8));
        HttpPost httppost = new HttpPost(baiduAPI);
        httppost.setEntity(entity);
        try {
            BaiduResponse response = httpclient.execute(httppost, baiduResponseHandler());
            if(response.statusCode==200&&response.success>=1){
                logger.info("成功提交url:"+url);
                return true;
            }else {
                logger.error("提交url失败，url:"+url+";\n返回信息:"+ new GsonBuilder().create().toJson(response));
                return false;
            }
        } catch (IOException e) {
            logger.error("提交url失败，url:"+url,e);
            return false;
        }
    }

    /**
     * 返回信息处理函数
     * @return
     */
    private ResponseHandler<BaiduResponse> baiduResponseHandler() {
        return new ResponseHandler<BaiduResponse>() {
            @Override
            public BaiduResponse handleResponse(HttpResponse response) throws IOException {
                StatusLine statusLine = response.getStatusLine();
                HttpEntity entity = response.getEntity();
                if (entity == null) {
                    throw new ClientProtocolException("Response contains no content");
                }
                Reader reader = new InputStreamReader(entity.getContent());
                BaiduResponse baidu = new GsonBuilder().create().fromJson(reader, BaiduResponse.class);
                baidu.statusCode=statusLine.getStatusCode();
                return baidu;
            }
        };
    }

}
