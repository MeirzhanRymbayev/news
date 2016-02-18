package com.epam.mrymbayev.bo;

import com.epam.mrymbayev.entity.News;

import java.util.List;

public interface NewsBo {

    News getById(long id);

    void save(News news);

    List<News> getAll();

    boolean delete(long id);

}
