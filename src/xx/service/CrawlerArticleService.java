package xx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xx.dao.BaseDao;
import xx.model.CrawlerArticle;
import xx.model.Page;

/**
 * Created by lv on 2016/11/28.
 */
@Service
public class CrawlerArticleService {
    @Autowired private BaseDao baseDao;

    public Page list(Integer pageNo,Integer pageSize){
        return baseDao.findPage("from CrawlerArticle","select count(*) from CrawlerArticle",pageNo, pageSize);
    }

    public CrawlerArticle get(Integer id) {
        return (CrawlerArticle)baseDao.get(CrawlerArticle.class,id);
    }
}
