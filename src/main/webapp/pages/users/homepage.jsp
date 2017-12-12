
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title>User Homepage</title>
    <link href="${pageContext.servletContext.contextPath}/web_resources/css/detailed_prod_info.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2>WELCOME USER!</h2>

<a href="${pageContext.servletContext.contextPath}/users/show_all_products">Show all products</a>

</body>
</html>
