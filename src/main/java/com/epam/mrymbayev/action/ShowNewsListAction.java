package com.epam.mrymbayev.action;

import com.epam.mrymbayev.service.NewsService;
import com.epam.mrymbayev.model.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowNewsListAction extends ActionSupport {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsService newsService = (NewsService) getWebApplicationContext().getBean("newsService");
        if (request.getAttribute("id") != null) {
            long id = (long) request.getAttribute("id");
            News newsById = newsService.getById(id);
            request.setAttribute("news", newsById);
            return mapping.findForward("viewNewsById");
        }
        List<News> newsList = newsService.getAll();
        request.setAttribute("newsList", newsList);
        return mapping.findForward("success");
    }
}
