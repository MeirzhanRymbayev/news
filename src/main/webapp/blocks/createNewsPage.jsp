<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="col-md-9" style="border: 1px solid black;">
    <html:form action="/createNews"><br/>
        <html:text property="title" size="20" maxlength="100"/><br/><br/>
        <html:text property="brief" size="20" maxlength="500"/><br/><br/>
        <html:textarea property="content" /><br/><br/>
        <html:submit >Submit</html:submit>
        <html:reset>Reset</html:reset>

    </html:form>
</div>
