<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-3" style="border: 1px solid black;">
    <div style="border: 1px solid black;">
        <p><bean:message key="news.news"/></p>
        <ul>
            <li><a href="/viewNewsList.do"><bean:message key="menu.news.list"/></a></li>
            <li><a href="/editNewsPage.do"><bean:message key="menu.add.news"/></a></li>
        </ul>
    </div>
</div>