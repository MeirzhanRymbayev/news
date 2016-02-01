<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-md-9" style="border: 1px solid black;">
    <bean:write name="news" property="title"/>
    <%--<bean:write name="news" property="brief"/>--%>
    <%--<bean:write name="news" property="content"/>--%>
</div>