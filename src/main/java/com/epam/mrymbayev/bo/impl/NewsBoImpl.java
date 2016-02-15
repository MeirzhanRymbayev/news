package com.epam.mrymbayev.bo.impl;

import com.epam.mrymbayev.dao.NewsDao;
import com.epam.mrymbayev.entity.News;

import java.util.List;

public class NewsBoImpl implements NewsBo {
    NewsDao newsDao;

    public void setNewsDao(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    public News getById(long id) {
        return newsDao.getById(id);
    }

    @Override
    public News insert(News news) {
        return newsDao.insert(news);
    }

    @Override
    public News update(News news) {
        return newsDao.update(news);
    }

    @Override
    public News save(News news) {
        return newsDao.save(news);
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
