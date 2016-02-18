package com.epam.mrymbayev.action;

import com.epam.mrymbayev.service.NewsService;
import com.epam.mrymbayev.model.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditNewsPageAction extends ActionSupport {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {
        NewsService newsService = (NewsService) getWebApplicationContext().getBean("newsService");
        String id = request.getParameter("id");
        if(id != null && !id.isEmpty()){
            News news = newsService.getById(Long.parseLong(id));
            request.setAttribute("news", news);
            return mapping.findForward("success");
        } else {
            return mapping.findForward("success");
        }
    }
}
