package com.epam.mrymbayev.action;

import com.epam.mrymbayev.bo.impl.NewsBo;
import com.epam.mrymbayev.dao.JdbcNewsDao;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteNewsAction extends ActionSupport {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsBo newsBo = (NewsBo) getWebApplicationContext().getBean("newsBo");

//        newsDao.getConnection();

        String[] ids = request.getParameterValues("checkbox");
        if (ids.length > 1) {
            for (String id : ids) {
                newsBo.delete(Long.parseLong(id));
            }
        } else {
            String id = request.getParameter("checkbox");
            newsBo.delete(Long.parseLong(id));
        }
        return mapping.findForward("success");
    }
}
