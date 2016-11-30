package xx.model.vo;

import java.util.List;

/**
 * Created by Lv on 2016/11/30.
 */

public class BaiduResponse{
    public Integer statusCode;

    //推送成功
    public Integer remain;
    public Integer success;
    public List<String> not_same_site;
    public List<String> not_valid;

    //推送失败
    public Integer error;
    public String message;
}
