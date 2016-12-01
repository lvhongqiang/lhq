package xx.service;

import org.junit.Test;
import xx.BaseTest;

import static org.junit.Assert.*;

/**
 * Created by Lv on 2016/11/30.
 */
public class PostUrlServiceTest extends BaseTest {
    PostUrlService service=ctx.getBean(PostUrlService.class);
    @Test
    public void autoPostToBaidu() throws Exception {
        service.autoPostToBaidu(100);
    }

//    @Test
//    public void buildSitemap() throws Exception {
//        service.buildSitemap("nb/sitemap.txt");
//    }
}