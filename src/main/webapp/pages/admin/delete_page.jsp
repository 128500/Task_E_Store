
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DELETE PAGE</title>
    <link href="${pageContext.servletContext.contextPath}/web_resources/css/delete_page.css" rel="stylesheet" type="text/css">
</head>
<body>

<div id="content">
    <a href="${pageContext.servletContext.contextPath}/admin/homepage">Back to homepage</a>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/admin/add_product_page">Add new product</a>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/admin/add_category_page">Add new category</a>
    <div>
        <h2>DELETING MANUFACTURER/CATEGORY</h2>
    </div>
    <h2>NOTE! As deleting manufacturer/category automatically will be deleted all related to it products</h2>
        <table>
            <tr>
                <td class="no_border">
            <table id="manufacturers">
                <th>Existing manufacturers</th>
                <th>Delete</th>
            <c:forEach items="${manufacturers}" var="m" varStatus="status">
                <tr>
                    <td>${m}</td>
                    <td>
                        <a href="${pageContext.servletContext.contextPath}/admin/delete_manufacturer/${m}" title="Delete this manufacturer and related products"><img src="${pageContext.servletContext.contextPath}/web_resources/images/delete.png" alt=""></a>
                    </td>
                </tr>
                <br/>
            </c:forEach>
            </table>
                </td>
                <td class="no_border">
            <table id="categories">
            <th>Existing categories</th>
            <th>Delete</th>
            <c:forEach items="${categories}" var="c" varStatus="status">
                <tr><td>${c}</td>
                    <td>
                        <a href="${pageContext.servletContext.contextPath}/admin/delete_category/${c}" title="Delete this manufacturer and related products"><img src="${pageContext.servletContext.contextPath}/web_resources/images/delete.png" alt=""></a>
                    </td>
                </tr>
                <br/>
            </c:forEach>
            </table>
                </td>
            </tr>
        </table>
</div>

</body>
</html>
