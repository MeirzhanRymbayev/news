<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<p class="col-md-9" style="border: 1px solid black;">
<html:form action="/createNews"><br/>
    <div class="form-block">
        <div class="form-group">
            <label for="title"><bean:message key="news.title"/></label>
            <p><html:text property="title" size="20" maxlength="100" styleId="title" styleClass="form-control"/></p>
    </div>
    <div class="form-group">
        <label for="content"><bean:message key="news.date"/></label>
        <p><html:text property="date" size="20" maxlength="100" styleId="content" styleClass="form-control"/></p>
    </div>
    <div class="form-group">
        <label for="content"><bean:message key="news.brief"/></label>
        <p><html:textarea property="brief" styleId="content" styleClass="form-control"/></p>
    </div>
    <div class="form-group">
        <label for="content"><bean:message key="news.content"/></label>
        <p><html:textarea property="content" styleId="content" styleClass="form-control"/></p>
    </div>
    </div>
    <p><html:submit styleClass="btn btn-default"><bean:message key="button.news.create.submit"/></html:submit></p>
    <label><html:reset styleClass="btn btn-default"><bean:message key="button.news.create.reset"/></html:reset></label>


</html:form>

