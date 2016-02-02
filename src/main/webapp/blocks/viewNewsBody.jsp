<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="voucher" type="java.util.List"--%>
<%--@elvariable id="news" type="kz.epam.mrymbayev.entity.News"--%>

<c:forEach items="${newsList}" var="news">
    <div class="newsBlock">
        <div class="title"><c:out value="${news.title}"/></div>
        <div class="date"><c:out value="${news.dateOfCreation}"/></div>
        <div class="post-content"><c:out value="${news.content}"/></div>
        <div class="linksViewAll">
            <a href="<c:url value="/viewNews.do?id=${news.id}"/>"><bean:message
                    key="label.news.body.view.view"/></a>
            <a href="<c:url value="/editNews.do?id=${news.id}"/>"><bean:message
                    key="label.news.body.view.edit"/></a>
            <input type="checkbox" name="checkbox" value="${news.id}" title="checkbox"/>
        </div>
    </div>
</c:forEach>
