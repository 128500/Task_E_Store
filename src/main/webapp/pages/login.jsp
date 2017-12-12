
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>LOGIN PAGE</title>
    <link href="${pageContext.servletContext.contextPath}/web_resources/css/admin_style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <h1>WELCOME TO ADMIN LOGIN PAGE</h1>
    <p>Please enter login and password to proceed</p>
    <form name="login_form" action="${pageContext.servletContext.contextPath}/login" method="post">
        <div>
            <label for="login">Login: </label>
            <input type="text" name="username" id="login" value=""/>
        </div>
        <div>
            <label for="password">Password: </label>
            <input type="password" name="password" id="password"/>
        </div>
        <div>
            <input type="submit" value="submit" name="submit"/>
        </div>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    </form>
</body>
</html>
