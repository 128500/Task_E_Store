
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ADMIN HOMEPAGE</title>
    <link href="${pageContext.servletContext.contextPath}/web_resources/css/admin_style.css" rel="stylesheet" type="text/css">

</head>
<body>
<div id="content">
    <h1>WELCOME ADMIN</h1>
    <br/>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/admin/add_manufacturer_page">Add new manufacturer</a>
    <br/>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/admin/add_category_page">Add new category</a>
    <br/>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/admin/add_product_page">Add new product</a>
    <br/>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/admin/edit_product_page">Edit or delete existing products</a>
    <br/>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/admin/delete_page">Delete existing categories/manufacturers</a>
</div>
</body>
</html>
