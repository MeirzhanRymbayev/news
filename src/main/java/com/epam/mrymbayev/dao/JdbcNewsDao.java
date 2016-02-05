package com.epam.mrymbayev.dao;

import com.epam.mrymbayev.dao.exception.NewsDaoException;
import com.epam.mrymbayev.entity.News;
import com.epam.mrymbayev.pm.PropertyManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcNewsDao implements NewsDao {

    private PropertyManager pm;
    private static final Logger log = Logger.getLogger(JdbcNewsDao.class);
    private static final String SQL_PROPERTIES = "sql.properties";
    private static String jdbcDriver;
    private static String username;
    private static String password;
    private static String url;

    private Connection connection;

    public JdbcNewsDao(){
        try {
            pm = PropertyManager.getInstance();
            pm.loadProperties(SQL_PROPERTIES);
            jdbcDriver = pm.getProperty("db.jdbc.driver");
            Class.forName(jdbcDriver);
            username = pm.getProperty("db.username");
            password = pm.getProperty("db.password");
            url = pm.getProperty("db.url");
        } catch (ClassNotFoundException e) {
            log.error("Jdbc driver was not found.");
            throw new NewsDaoException();
        }
        log.info("JDBC driver was loaded successfully.");
    }

    public void getConnection(){
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            log.error("Can't get the connection.");
            e.printStackTrace();
        }
    }

    @Override
    public News getById(long id) {
        News news = new News();
        String sql = pm.getProperty("news.getById");
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            news.setId(resultSet.getLong(1));
            news.setTitle(resultSet.getString(2));
            news.setContent(resultSet.getString(3));
            news.setBrief(resultSet.getString(4));
            news.setDateOfCreation(resultSet.getDate(5));
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NewsDaoException("Can't fulfil this request", e);
        }
        return news;
    }

    @Override
    public News insert(News news) {
        String sql = pm.getProperty("news.insert");
        String generatedColumns[] = {"ID"};
        try {
            PreparedStatement ps = connection.prepareStatement(sql, generatedColumns);
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getContent());
            ps.setString(3, news.getBrief());
            ps.setDate(4, new java.sql.Date(news.getDateOfCreation().getTime()));
            int affectedRowsCount = ps.executeUpdate();
            if(affectedRowsCount == 1) log.trace("News was successfully created.");
            ResultSet generatedKeys = ps.getGeneratedKeys();
            long id;
            if (generatedKeys.next()) {
                id = generatedKeys.getLong(1);
                news.setId(id);
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NewsDaoException("Can't perform insert operation.");
        }
        return news;
    }

    @Override
    public News update(News news) {
        String sql = pm.getProperty("news.update");//update NEWS set TITLE = ?, CONTENT = ? WHERE ID = ?;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getContent());
            ps.setString(3, news.getBrief());
            ps.setDate(4, new java.sql.Date(news.getDateOfCreation().getTime()));
            ps.setLong(5, news.getId());
            int affectedRowsCount = ps.executeUpdate();
            if(affectedRowsCount == 1) log.trace("News was successfully updated.");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NewsDaoException("Can't perform update operation");
        }
        return news;
    }

    @Override
    public News save(News news) {
        return (news.isNotPersisted())? insert(news) : update(news);
    }

    @Override
    public List<News> getAll() {
        List<News> newsList = new ArrayList<>();
        String sql = pm.getProperty("news.getAll");
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                long id = rs.getLong(1);
                String title = rs.getString(2);
                String content = rs.getString(3);
                Date date = rs.getDate(5);
                String brief = rs.getString(4);
                News news = new News();
                news.setId(id);
                news.setTitle(title);
                news.setContent(content);
                news.setBrief(brief);
                news.setDateOfCreation(date);
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NewsDaoException("NewsDaoException error", e);
        }
        return newsList;
    }

    @Override
    public boolean delete(long id){
        String sql = pm.getProperty("news.delete");// delete from news where id = ?
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            int affectedRowsCount = ps.executeUpdate();
            if(affectedRowsCount == 1) log.trace("News was successfully deleted.");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
//            throw new NewsDaoException("Can't perform delete operation.");
        }
        return true;
    }
}
