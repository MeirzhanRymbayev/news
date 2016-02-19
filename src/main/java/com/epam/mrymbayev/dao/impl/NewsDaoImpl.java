package com.epam.mrymbayev.dao.impl;


import com.epam.mrymbayev.dao.NewsDao;
import com.epam.mrymbayev.model.News;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

public class NewsDaoImpl extends HibernateDaoSupport
        implements NewsDao {

    @Override
    public News getById(long id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        News news = (News) session.get(News.class, id);
        session.getTransaction().commit();
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
        Session session = getSessionFactory().openSession();
        List<News> list = session.createCriteria(News.class)
                .addOrder(Order.asc("dateOfCreation"))
                .list();
        session.close();
        return list;
    }

    @Override
    public void delete(long id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        News newsForDelete = (News) session.get(News.class, id);
        session.delete(newsForDelete);
        session.getTransaction().commit();
        session.close();
    }
}