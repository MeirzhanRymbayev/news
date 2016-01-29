<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--jquery lib should be first in line--%>
    <script src="js/jquery-1.12.0.min.js" type="text/javascript"></script>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <%--<script src="js/equalHeights.js" type="text/javascript"></script>--%>
    <title><tiles:getAsString name="title" ignore="true"/></title>
</head>
<body>
<div class="container">
    <tiles:insert attribute="header"/>
    <div class="row">
        <tiles:insert attribute="menu"/>
        <tiles:insert attribute="body"/>
    </div>
    <tiles:insert attribute="footer"/>
</div>
</body>
</html>
