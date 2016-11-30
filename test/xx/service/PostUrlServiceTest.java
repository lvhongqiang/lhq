package xx.service;

import org.junit.Test;
import xx.BaseTest;

import static org.junit.Assert.*;

/**
 * Created by Lv on 2016/11/30.
 */
public class PostUrlServiceTest extends BaseTest {
    @Test
    public void autoPostToBaidu() throws Exception {
        PostUrlService service=ctx.getBean(PostUrlService.class);
        service.autoPostToBaidu(100);
    }
}