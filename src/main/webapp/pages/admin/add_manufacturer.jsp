
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD MANUFACTURER</title>
    <link href="${pageContext.servletContext.contextPath}/web_resources/css/admin_style.css" rel="stylesheet" type="text/css">
</head>
<body>

<div id="content">
    <a href="${pageContext.servletContext.contextPath}/admin/homepage">Back to homepage</a>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/admin/add_product_page">Add new product</a>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/admin/add_category_page">Add new category</a>
    <div>
        <h2>Adding new manufacturer</h2>
    </div>
    <p>For adding new manufacturer please fill and submit the form below</p>
    <div>
        <form action="${pageContext.servletContext.contextPath}/admin/add_manufacturer" method="post">
            <label for="new_manufacturer">New MANUFACTURER: </label>
            <input required type="text" name="new_manufacturer" id="new_manufacturer"/>
            <br/>
            <input type="submit" value="Submit" name="submit">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
    <div>
        <h3>Existing manufacturers</h3>
    </div>
    <div>
        <table id="manufacturers">
            <c:forEach items="${manufacturers}" var="manufacturer" varStatus="status">
                <tr>${manufacturer}</tr>
                <br/>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
