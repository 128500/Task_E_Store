
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD PRODUCT</title>
    <link href="${pageContext.servletContext.contextPath}/web_resources/css/admin_style.css" rel="stylesheet" type="text/css">
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/admin/homepage">Back to homepage</a>

<div id="content">
    <a href="${pageContext.servletContext.contextPath}/admin/add_manufacturer_page">Add new manufacturer</a>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/admin/add_category_page">Add new category</a>

    <div>
        <h2>Adding new product</h2>
    </div>
    <p>For adding new product please fill and submit the form below</p>
    <div>
        <p>NOTE! If there is not the appropriate category/manufacturer or there are not
            categories/manufacturers at all, you first should include one on the corresponding page
            using links above "Add new manufacturer" of "Add new category"</p>

        <form action="${pageContext.servletContext.contextPath}/admin/add_product" method="post">

            <label for="manufacturer">Choose MANUFACTURER: </label>
            <select  size='1' name = 'manufacturer' id="manufacturer">
                <option disabled>Choose manufacturer</option>
                <c:forEach items="${manufacturers}" var="m" varStatus="status">
                    <option value="${m}">${m}</option>
                </c:forEach>
            </select>
            <br/>

            <label for="category">Choose CATEGORY: </label>
            <select  size='1' name = 'category' id="category">
                <option disabled>Choose category</option>
                <c:forEach items="${categories}" var="c" varStatus="status">
                    <option value="${c}">${c}</option>
                </c:forEach>
            </select>
            <br/>

            <label for="name">PRODUCT name: </label>
            <input required type="text" name="name" id="name"/>
            <br/>
            <label for="price">PRODUCT price: </label>
            <input required type="number" step="0.01" name="price" id="price" value="0,00"/>
            <br/>
            <label for="code">PRODUCT code: </label>
            <input required type="number" name="code" id="code"/>
            <br/>
            <label>PRODUCT description: </label>
            <br/>
            <textarea name="description" placeholder="Enter description here!!!" rows="10" cols="45" id="description"></textarea>
            <br/>
            <label for="radiobtn">Product available at the store:</label>
            <div id="radiobtn">
                <input type="radio" name="available" >Yes <br/>
            </div>
            <input type="submit" value="Submit" name="submit">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
    <div>
        <h3>Latest products</h3>
    </div>
    <div>
    <p>???????</p>
    </div>
</div>
</body>
</html>
