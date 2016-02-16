package com.epam.mrymbayev.bo.impl;

import com.epam.mrymbayev.dao.NewsDaoForHiber;
import com.epam.mrymbayev.entity.News;

import java.util.List;

public class NewsBoImpl implements NewsBo {
    private NewsDaoForHiber newsDao;

    public void setNewsDao(NewsDaoForHiber newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    public News getById(long id) {
        return newsDao.getById(id);
    }

    @Override
    public void save(News news) {
        newsDao.save(news);
    }

    @Override
    public List<News> getAll() {
        return newsDao.getAll();
    }

    @Override
    public boolean delete(long id) {
        return newsDao.delete(id);
    }
}
