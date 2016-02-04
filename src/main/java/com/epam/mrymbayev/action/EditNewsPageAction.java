package com.epam.mrymbayev.action;

import com.epam.mrymbayev.dao.JdbcNewsDao;
import com.epam.mrymbayev.dao.NewsDao;
import com.epam.mrymbayev.entity.News;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditNewsPageAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        JdbcNewsDao newsDao = new JdbcNewsDao();
        newsDao.getConnection();
        String id = request.getParameter("id");
        if(id != null && !id.isEmpty()){
            News news = newsDao.getById(Long.parseLong(id));
            request.setAttribute("news", news);
            return mapping.findForward("success");
        } else {
            return mapping.findForward("success");
        }
    }
}
