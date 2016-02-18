package com.epam.mrymbayev.dao;

import com.epam.mrymbayev.model.News;

import java.util.List;

public interface NewsDao {

        News getById(long id);

        void save(News news);

        List<News> getAll();

        void delete(long id);

}
