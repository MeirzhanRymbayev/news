package com.epam.mrymbayev.bo.impl;

import com.epam.mrymbayev.entity.News;

import java.util.List;

public interface NewsBo {

    News getById(long id);

    News insert(News news);

    News update(News news);

    News save(News news);

    List<News> getAll();

    boolean delete(long id);

}
