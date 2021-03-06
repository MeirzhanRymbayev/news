package com.epam.mrymbayev.action;

import com.epam.mrymbayev.dao.impl.JdbcNewsDao;
import com.epam.mrymbayev.model.News;
import com.epam.mrymbayev.form.NewsForm;
import com.epam.mrymbayev.util.Utilities;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class EditNewsAction extends ActionSupport {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {
        JdbcNewsDao newsDao = (JdbcNewsDao) getWebApplicationContext().getBean("jbdcNewsDao");
        newsDao.getConnection();
        NewsForm newsForm = (NewsForm) form;
        News news = new News();
        String idString = request.getParameter("id");

        if(idString != null && !idString.isEmpty()) {
            long id;
            try {
                id = Long.parseLong(idString);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
            news.setId(id);
        }
        news.setTitle(newsForm.getTitle());
        news.setBrief(newsForm.getBrief());
        news.setContent(newsForm.getContent());
        String dateString = newsForm.getDateOfCreation();
        String dateS = dateString.replaceAll("/", "-");
        Date date = Utilities.getDateFromString(dateS, "MM-dd-yyyy");
        news.setDateOfCreation(date);

        News savedNews = newsDao.save(news);

        request.setAttribute("savedNews", savedNews); //TODO чтобы отобразить в странице об успешном добавлении

        return mapping.findForward("edited");
    }
}
