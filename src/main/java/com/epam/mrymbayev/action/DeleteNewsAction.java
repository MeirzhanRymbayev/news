package com.epam.mrymbayev.action;

import com.epam.mrymbayev.service.NewsService;
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
        NewsService newsService = (NewsService) getWebApplicationContext().getBean("newsService");

        String[] ids = request.getParameterValues("id");
        if (ids.length > 1) {
            for (String id : ids) {
                newsService.delete(Long.parseLong(id));
            }
        } else {
            String id = request.getParameter("id");
            newsService.delete(Long.parseLong(id));
        }
        return mapping.findForward("success");
    }
}
