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

    public void autoPostToBaidu(){
        logger.info("提交url到百度开始......");
        postUrlService.autoPostToBaidu(postSize);
        logger.info("提交url到百度结束......");
    }

    public void setPostSize(Integer postSize) {
        this.postSize = postSize;
    }
}
