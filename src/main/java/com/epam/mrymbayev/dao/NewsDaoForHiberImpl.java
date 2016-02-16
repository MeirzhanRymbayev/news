package com.epam.mrymbayev.dao;


import com.epam.mrymbayev.entity.News;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

public class NewsDaoForHiberImpl extends HibernateDaoSupport
        implements NewsDaoForHiber{

    @Override
    public News getById(long id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        News news = (News) session.get(News.class, id);
        session.close();
        return news;
    }

    @Override
    public void save(News news) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(news);
        session.getTransaction().commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<News> getAll() {
        return (List<News>) getHibernateTemplate().find("from News");
    }

    @Override
    public boolean delete(long id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        News newsForDelete = (News) session.get(News.class, id);
//        News news = getHibernateTemplate().get(News.class, id);
//        getHibernateTemplate().delete(newsForDelete);
        session.delete(newsForDelete);
        session.close();
        return true; // TODO optimize
    }
}
