package com.epam.mrymbayev.dao;

import com.epam.mrymbayev.dao.exception.NewsDaoException;
import com.epam.mrymbayev.entity.News;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.List;

public class JdbcNewsDao implements NewsDao {

    private static final Logger log = Logger.getLogger(JdbcNewsDao.class);
    public static final String ORACLE_JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String username = "MEIR";
    private static final String password = "sa";
    private static final String url = "jdbc:oracle:thin:@//localhost:1521/XE";

    Connection connection;

    public JdbcNewsDao(){
        try {
            Class.forName(ORACLE_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            log.error("Jdbc driver was not found.");
            throw new NewsDaoException();
        }
        log.info("JDBC driver was loaded succesfully.");//TODO I'm here
    }

    @Override
    public News getById(long id) {
        return null;
    }

    @Override
    public News create(News news) {
        return null;
    }

    @Override
    public News update(long id) {
        return null;
    }

    @Override
    public News save(News news) {
        return null;
    }

    @Override
    public List<News> getAll() {
        return null;
    }

}
