<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Форма входа в систему</title>

</head>
<body>
<html:form action="/Login">

    <table border="0">

    <tr>
        <td>Enter your name:</td>
        <td><html:text property="name" /></td>
    </tr>
    <tbody>
    <tr>
        <td>Enter your email:</td>
        <td><html:text property="email" /></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td><html:submit value="Login"/></td>
    </tr>
    </tbody>
</table>


</html:form>

</body>
</html>
