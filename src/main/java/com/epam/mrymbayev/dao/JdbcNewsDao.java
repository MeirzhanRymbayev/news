package com.epam.mrymbayev.dao;

import com.epam.mrymbayev.dao.exception.NewsDaoException;
import com.epam.mrymbayev.entity.News;
import com.epam.mrymbayev.pm.PropertyManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcNewsDao implements NewsDao {

    private static final Logger log = Logger.getLogger(JdbcNewsDao.class);
    PropertyManager propertyManager;
    public static final String ORACLE_JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String USERNAME = "MEIR";
    private static final String PASSWORD = "sa";
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";

    Connection connection;

    public JdbcNewsDao(){
        try {
            Class.forName(ORACLE_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            log.error("Jdbc driver was not found.");
            throw new NewsDaoException();
        }
        log.info("JDBC driver was loaded successfully.");//TODO I'm here
    }

    public void getConnection(){
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            log.error("Can't get the connection.");
            e.printStackTrace();
        }
    }

    @Override
    public News getById(long id) {
        News news = new News();
        PropertyManager pm = PropertyManager.getInstance();
        pm.loadProperties("sql.properties");
        String sql = pm.getProperty("news.getById");
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            news.setTitle(resultSet.getString(2));
            news.setText(resultSet.getString(3));
//            news.setChecked(resultSet.getBoolean(4));
            news.setId(resultSet.getLong(1));

//            resultSet.close();
//            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NewsDaoException("Can't fulfil this request", e);
        }
        return news;
    }

    @Override
    public News insert(News news) {
        PropertyManager pm = PropertyManager.getInstance();
        pm.loadProperties("sql.properties");
        String sql = pm.getProperty("news.create");
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, news.getTitle());
            int affectedRowsCount = ps.executeUpdate();
            if(affectedRowsCount == 1) log.trace("News was successfully created.");
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            long id = rs.getLong(1);
            news.setId(id);
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    @Override
    public News update(News news) {
        return null;
    }

    @Override
    public News save(News news) {
        return (news.isNotPersisted())? insert(news) : update(news);
    }

    @Override
    public List<News> getAll() {
        List<News> newsList = new ArrayList<>();
        PropertyManager propertyManager = PropertyManager.getInstance();
        propertyManager.loadProperties("sql.properties");
        String sql = propertyManager.getProperty("news.getAll");
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            while (rs.next()){
                long id = rs.getLong(1);
                String title = rs.getString(2);
                String text = rs.getString(3);
                News news = new News();
                news.setId(id);
                news.setTitle(title);
                news.setText(text);
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NewsDaoException("NewsDaoException error", e);
        }
        return newsList;
    }

}
