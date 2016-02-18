<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="news" scope="request" type="com.epam.mrymbayev.model.News"/>

<div class="block">
    <div class="blockLeft"><bean:message key="news.title"/></div>
    <div class="blockRight"><c:out value="${news.title}"/></div>
</div>
<div class="block">
    <div class="blockLeft"><bean:message key="news.date"/></div>
    <div class="blockRight"><c:out value="${news.date}"/></div>
</div>
<div class="block">
    <div class="blockLeft"><bean:message key="news.brief"/></div>
    <div class="blockRight"><c:out value="${news.brief}"/></div>
</div>
<div class="block">
    <div class="blockLeft"><bean:message key="news.content"/></div>
    <div class="blockRight"><c:out value="${news.content}"/></div>
</div>
<div class="links">
    <input type="button" value="<bean:message key="button.edit"/>"
           onclick="window.location = '<c:url value="/editNewsPage.do?id=${news.id}"/>'"/>
    <input type="button" value="<bean:message key="button.delete"/>"
           onclick="window.location = '<c:url value="/deleteNews.do?id=${news.id}"/>'"/>
</div>