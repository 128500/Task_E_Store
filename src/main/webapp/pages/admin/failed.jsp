
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>FAILED PAGE</title>
    <link href="${pageContext.servletContext.contextPath}/web_resources/css/admin_style.css" rel="stylesheet" type="text/css">

</head>
<body>
<div id="content">
    <h1>FAILED TO ADD (EDIT/DELETE)  THIS "${message}"</h1>
    <h2> It might be because ${message} already exists in the database or internal error</h2>
    <br/>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/admin/homepage">Back to homepage</a>
    <a href="${pageContext.servletContext.contextPath}/admin/add_manufacturer_page">Add new manufacturer</a>
    <a href="${pageContext.servletContext.contextPath}/admin/add_category_page">Add new category</a>
    <a href="${pageContext.servletContext.contextPath}/admin/add_product_page">Add new product</a>
    <a href="${pageContext.servletContext.contextPath}/admin/edit_product_page">Edit or delete existing products</a>
</div>
</body>
</html>
