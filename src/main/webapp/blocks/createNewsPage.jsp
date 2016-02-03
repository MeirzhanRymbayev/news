<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<font color="red">
    <html:errors></html:errors></font>
<html:form action="/createNews">
    <div class="form-block">
        <div class="form-group">
            <label for="title"><bean:message key="news.title"/></label>
            <html:text property="title" size="20" maxlength="100" styleId="title" styleClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="dateOfCreation"><bean:message key="news.date"/></label>
            <html:text property="dateOfCreation" size="20" maxlength="100" styleId="dateOfCreation"
                       styleClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="brief"><bean:message key="news.brief"/></label>
            <html:textarea property="brief" styleId="brief" styleClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="content"><bean:message key="news.content"/></label>
            <html:textarea property="content" styleId="content" styleClass="form-control"/>
        </div>
        <html:submit styleClass="btn btn-default"><bean:message key="button.news.create.submit"/></html:submit>
        <label><html:reset styleClass="btn btn-default"><bean:message
                key="button.news.create.reset"/></html:reset></label>
    </div>
</html:form>

