<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="voucher" type="java.util.List"--%>
<%--@elvariable id="news" type="kz.epam.mrymbayev.entity.News"--%>

<c:forEach items="${newsList}" var="news">
    ${news.title}<br/>
    ${news.text}<br/>
</c:forEach>
