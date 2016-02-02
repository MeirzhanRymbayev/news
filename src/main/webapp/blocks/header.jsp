<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal-header" style="border: 1px solid black"><h1><bean:message key="header.text"/></h1>
<div id="setLanguage">
    <a href="<c:url value="/Locale.do?lang=english"/>"><bean:message key="header.lang.english"/></a>
    <a href="<c:url value="/Locale.do?lang=russian"/>"><bean:message key="header.lang.russian"/></a>
</div>
</div>