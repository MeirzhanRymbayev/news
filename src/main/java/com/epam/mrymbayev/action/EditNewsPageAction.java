package com.epam.mrymbayev.action;

import com.epam.mrymbayev.bo.impl.NewsBo;
import com.epam.mrymbayev.dao.JdbcNewsDao;
import com.epam.mrymbayev.dao.NewsDao;
import com.epam.mrymbayev.entity.News;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditNewsPageAction extends ActionSupport {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {
        NewsBo newsBo = (NewsBo) getWebApplicationContext().getBean("newsBo");
        String id = request.getParameter("id");
        if(id != null && !id.isEmpty()){
            News news = newsBo.getById(Long.parseLong(id));
            request.setAttribute("news", news);
            return mapping.findForward("success");
        } else {
            return mapping.findForward("success");
        }
    }
}
