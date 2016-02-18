<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="voucher" type="java.util.List"--%>
<%--@elvariable id="news" type="kz.epam.mrymbayev.entity.News"--%>
<%--@elvariable id="newsList" type="java.util.List"--%>
<form action="<c:url value="/deleteNews.do"/>">
<c:forEach items="${newsList}" var="news">
    <div class="newsBlock">
        <div class="title"><c:out value="${news.title}"/></div>
        <div class="date"><c:out value="${news.date}"/></div>
        <div class="post-content"><c:out value="${news.content}"/></div>
        <div class="linksViewAll">
            <a href="<c:url value="/viewNews.do?id=${news.id}"/>"><bean:message
                    key="label.news.body.view.view"/></a>
            <a href="<c:url value="/editNewsPage.do?id=${news.id}"/>"><bean:message
                    key="label.news.body.view.edit"/></a>
            <input type="checkbox" name="id" value="${news.id}" title="checkbox"/>
        </div>
    </div>
</c:forEach>
    <div style="clear: both;"></div>
<div style="float: right; margin: 5px">
    <input type="submit" class="btn btn-default" value="<bean:message key="news.button.delete"/>"/>
</div>
</form>
