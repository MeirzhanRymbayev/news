package com.epam.mrymbayev.action;

import com.epam.mrymbayev.dao.JdbcNewsDao;
import com.epam.mrymbayev.entity.News;
import com.epam.mrymbayev.form.NewsForm;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

public class CreateNewsAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response){

        NewsForm newsForm = (NewsForm) form;
        News news = new News();
        try {
            BeanUtils.copyProperties(news, newsForm);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(news);
        JdbcNewsDao newsDao = new JdbcNewsDao();
        newsDao.getConnection();
        News savedNews = newsDao.save(news);

        request.setAttribute("news", newsForm);

        return mapping.findForward("success");
    }

}
