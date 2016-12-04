package xx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xx.dao.BaseDao;
import xx.model.CrawlerArticle;
import xx.model.Page;

import java.util.List;

/**
 * Created by lv on 2016/11/28.
 */
@Service
public class CrawlerArticleService {
    @Autowired private BaseDao baseDao;

    public Page list(Integer pageNo,Integer pageSize){
        return baseDao.findPage("from CrawlerArticle order by id desc","select count(*) from CrawlerArticle",pageNo, pageSize);
    }

    public CrawlerArticle get(Integer id) {
        return (CrawlerArticle)baseDao.get(CrawlerArticle.class,id);
    }
    public CrawlerArticle pre(Integer id) {
        List<CrawlerArticle> list = baseDao.findList("from CrawlerArticle where id>? order by id asc", id, 0, 1);
        if(list!=null&&list.size()>0)
            return list.get(0);
        return null;
    }
    public CrawlerArticle next(Integer id) {
        List<CrawlerArticle> list = baseDao.findList("from CrawlerArticle where id<? order by id desc", id, 0, 1);
        if(list!=null&&list.size()>0)
            return list.get(0);
        return null;
    }
}
