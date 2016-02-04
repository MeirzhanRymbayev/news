package com.epam.mrymbayev.action;

import com.epam.mrymbayev.dao.JdbcNewsDao;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteNewsAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        JdbcNewsDao newsDao = new JdbcNewsDao();
        newsDao.getConnection();

        String[] ids = request.getParameterValues("checkbox");
        if (ids.length > 1) {
            for (String id : ids) {
                newsDao.delete(Long.parseLong(id));
            }
        } else {
            String id = request.getParameter("checkbox");
            newsDao.delete(Long.parseLong(id));
        }
        return mapping.findForward("success");
    }
}
