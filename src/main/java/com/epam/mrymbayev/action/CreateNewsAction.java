package com.epam.mrymbayev.action;

import com.epam.mrymbayev.form.NewsForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateNewsAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response){

        NewsForm newsForm = (NewsForm) form;
        request.setAttribute("news", newsForm);

        return mapping.findForward("success");
    }

}
