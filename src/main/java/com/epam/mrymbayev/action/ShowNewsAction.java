package com.epam.mrymbayev.action;

import com.epam.mrymbayev.dao.impl.JdbcNewsDao;
import com.epam.mrymbayev.model.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowNewsAction extends ActionSupport {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JdbcNewsDao newsDao = (JdbcNewsDao) getWebApplicationContext().getBean("jbdcNewsDao");
        newsDao.getConnection();
        String id = request.getParameter("id");

        News newsById = newsDao.getById(Long.parseLong(id));
        request.setAttribute("news", newsById);
        return mapping.findForward("success");
    }
}
