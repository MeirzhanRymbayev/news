package com.epam.mrymbayev.service;

import com.epam.mrymbayev.model.News;

import java.util.List;

public interface NewsService {

    News getById(long id);

    void save(News news);

    List<News> getAll();

    void delete(long id);

}
