
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PRODUCT INFO</title>
    <link href="${pageContext.servletContext.contextPath}/web_resources/css/detailed_prod_info.css" rel="stylesheet" type="text/css">

</head>
<body>
<div align="center">
<h1>Detailed info about the product</h1>
</div>

    <div id="content">
        <div>
            <h2>${product.name}</h2>
        </div>
        <div>
            <h3>Category of the product: ${product.category}</h3>
        </div>
        <div>
            <h3> Product's manufacturer: ${product.manufacturer}</h3>
        </div>
        <div>
            <h3> Price: ${product.price}</h3>
        </div>
        <div>
            <h3>Code: ${product.code}</h3>
        </div>
        <div>
            <h3>Available: ${product.flag}</h3>
        </div>
        <div>
            <h3>Description: ${product.description}</h3>
        </div>
    </div>
    <br/>
<input type="button" onclick="history.back();" value="Назад" id="btn"/>
</body>
</html>
