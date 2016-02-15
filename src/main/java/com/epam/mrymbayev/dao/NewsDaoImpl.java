package com.epam.mrymbayev.dao;


import com.epam.mrymbayev.entity.News;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

public class NewsDaoImpl extends HibernateDaoSupport
        implements NewsDao{


    @Override
    public News getById(long id) {
        return null;
    }

    @Override
    public News insert(News news) {
        Serializable savedNews = getHibernateTemplate().save(news);
        return (News) savedNews;
    }

    @Override
    public News update(News news) {
        Serializable savedNews = getHibernateTemplate().save(news);
        return (News) savedNews;
    }

    @Override
    public News save(News news) {
        Serializable savedNews = getHibernateTemplate().save(news);
        return (News) savedNews;
    }

    @Override
    public List<News> getAll() {
        return (List<News>) getHibernateTemplate().find("from NEWS");
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
