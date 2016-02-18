package com.epam.mrymbayev.service.impl;

import com.epam.mrymbayev.service.NewsService;
import com.epam.mrymbayev.dao.NewsDao;
import com.epam.mrymbayev.model.News;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    private NewsDao newsDao;

    public void setNewsDao(NewsDao newsDao) {
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
    public void delete(long id) {
        newsDao.delete(id);
    }
}
