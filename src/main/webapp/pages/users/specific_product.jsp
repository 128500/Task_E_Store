

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SPECIFIC PRODUCTS</title>
    <link href="${pageContext.servletContext.contextPath}/web_resources/css/show_all_products.css" rel="stylesheet" type="text/css">
</head>
<body>


<div id="form_div">
    <p>For seeking the appropriate product please use the filters below</p>
    <form action="${pageContext.servletContext.contextPath}/users/specific_products" method="post">
        <label for="manufacturer">MANUFACTURER filter: </label>
        <select  size='1' name = 'manufacturer' id="manufacturer">
            <option disabled>Choose manufacturer</option>
            <option>all</option>
            <c:forEach items="${manufacturers}" var="m" varStatus="status">
                <option value="${m}">${m}</option>
            </c:forEach>
        </select>
        <br/>

        <label for="category">CATEGORY filter: </label>
        <select  size='1' name = 'category' id="category">
            <option disabled>Choose category</option>
            <option>all</option>
            <c:forEach items="${categories}" var="c" varStatus="status">
                <option value="${c}">${c}</option>
            </c:forEach>
        </select>
        <br/>

        <label for="price">PRICE filter: </label>
        <select  size='1' name="price" id="price">
            <option disabled>Choose price</option>
            <option>all</option>
            <c:forEach items="${prices}" var="p" varStatus="status">
                <option value="${p}">${p}</option>
            </c:forEach>
        </select>
        <br/>

        <label>Search only available products: </label>
        <input type="radio" name="available">Yes <br/>

        <input type="submit" value="Find" name="submit">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
<div>
    <h2>E-store products</h2>
</div>
<div>
    <table>
        <tr id="usersTableHeader">
            <th>Category</th>
            <th>Manufacturer</th>
            <th>Name</th>
            <th>Price</th>
            <th>Code</th>
            <th>Available</th>
            <th>View details</th>
        </tr>
        <c:forEach items="${products}" var="p" varStatus="status">
            <tr>
                <td>${p.category}</td>
                <td>${p.manufacturer}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>${p.code}</td>
                <td>${p.flag}</td>
                <td >
                    <a href="${pageContext.servletContext.contextPath}/users/see_detailed_info/${p.getId()}" title="See detailed information about this product">See details</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
