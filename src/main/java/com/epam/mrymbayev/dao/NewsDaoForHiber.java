package com.epam.mrymbayev.dao;

import com.epam.mrymbayev.entity.News;

import java.util.List;

public interface NewsDaoForHiber  {

        News getById(long id);

        void save(News news);

        List<News> getAll();

        boolean delete(long id);

}
