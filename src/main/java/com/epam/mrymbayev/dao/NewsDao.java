package com.epam.mrymbayev.dao;

import com.epam.mrymbayev.entity.News;

import java.util.List;

public interface NewsDao {

    News getById(long id);

    News create(News news);

    News update(long id);

    News save(News news);

    List<News> getAll();

}
