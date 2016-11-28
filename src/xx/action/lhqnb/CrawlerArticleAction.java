package xx.action.lhqnb;

import org.springframework.beans.factory.annotation.Autowired;
import xx.action.BaseAction;
import xx.model.CrawlerArticle;
import xx.model.Page;
import xx.service.CrawlerArticleService;

/**
 * Created by lv on 2016/11/28.
 */
public class CrawlerArticleAction extends BaseAction {
    @Autowired private CrawlerArticleService crawlerArticleService;

    private Page page;
    private Integer id;
    private CrawlerArticle article;
    private Integer p=1;//页码
    private Integer s=10;//每页条数

    public String execute(){
        page= crawlerArticleService.list(p, s);
        return  SUCCESS;
    }
    public String article(){
        article= crawlerArticleService.get(id);
        return SUCCESS;
    }

    public Page getPage() {
        return page;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CrawlerArticle getArticle() {
        return article;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public void setS(Integer s) {
        this.s = s;
    }
}
