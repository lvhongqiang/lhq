package xx.quartz;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import xx.service.PostUrlService;

/**
 * Created by Lv on 2016/11/30.
 */
public class UrlPostJob {
    Logger logger = Logger.getLogger(UrlPostJob.class);
    @Autowired private PostUrlService postUrlService;
    private Integer postSize;
    private String filePath;

    public void autoPostToBaidu(){
        logger.info("提交url到百度开始......");
        postUrlService.autoPostToBaidu(postSize);
        logger.info("提交url到百度结束......");


        logger.info("自动生成sitemap检查开始......");
        postUrlService.autoBuildSitemap(filePath);
        logger.info("自动生成sitemap检查结束......");

    }

    public void setPostSize(Integer postSize) {
        this.postSize = postSize;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
