
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD CATEGORY</title>
    <link href="${pageContext.servletContext.contextPath}/web_resources/css/admin_style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="content">
    <a href="${pageContext.servletContext.contextPath}/admin/homepage">Back to homepage</a>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/admin/add_manufacturer_page">Add new manufacturer</a>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/admin/add_product_page">Add new product</a>
    <div>
        <h2>Adding new category</h2>
    </div>
    <p>For adding new category please fill and submit the form below</p>
    <div>
        <form action="${pageContext.servletContext.contextPath}/admin/add_category" method="post">
            <label for="new_category">New CATEGORY: </label>
            <input required type="text" name="new_category" id="new_category"/>
            <br/>
            <input type="submit" value="Submit" name="submit">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
    <div>
        <h3>Existing categories</h3>
    </div>
    <div>
        <table id="categories">
            <c:forEach items="${categories}" var="category" varStatus="status">
                <tr>${category}</tr>
                <br/>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
