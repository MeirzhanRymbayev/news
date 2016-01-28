package com.epam.mrymbayev.action;

import com.epam.mrymbayev.entity.User;
import com.epam.mrymbayev.form.UserForm;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserForm userForm = (UserForm) form;
        User user = new User();
        BeanUtils.copyProperties(user, userForm);

        request.setAttribute("user", user);
        return mapping.findForward("success");
    }
}
