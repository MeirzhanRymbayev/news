<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Success</title>
</head>
<body>
<h1>Congratulations!</h1>

<p>You have successfully logged in.</p>

<p>Your name is: <bean:write name="LoginForm" property="name" />.</p>

<p>Your email address is: <bean:write name="LoginForm" property="email" />.</p>
</body>
