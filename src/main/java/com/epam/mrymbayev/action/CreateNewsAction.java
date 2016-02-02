package com.epam.mrymbayev.action;

import com.epam.mrymbayev.dao.JdbcNewsDao;
import com.epam.mrymbayev.entity.News;
import com.epam.mrymbayev.form.NewsForm;
import com.epam.mrymbayev.util.Utilities;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class CreateNewsAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response){

        NewsForm newsForm = (NewsForm) form;
        News news = new News();

        news.setTitle(newsForm.getTitle());
        news.setBrief(newsForm.getBrief());
        news.setContent(newsForm.getContent());
        String dateString = newsForm.getDateOfCreation();
        String dateS = dateString.replaceAll("/", "-");
        Date date = Utilities.getDateFromString(dateS, "yyyy-mm-dd");
        news.setDateOfCreation(date);

        System.out.println(news);
        JdbcNewsDao newsDao = new JdbcNewsDao();
        newsDao.getConnection();
        News savedNews = newsDao.save(news);

        request.setAttribute("savedNews", savedNews); //TODO чтобы отобразить в странице об успешном добавлении

        return mapping.findForward("success");
    }

}
