<%@ page import="com.example.mockcasemodule3.model.properties.Property" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.mockcasemodule3.dao.impl.PropertyDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="C"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete property</title>
    <style>
        .property-list {
            margin: 20px;
        }
        .property-item {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 10px;
            background-color: #f9f9f9;
        }
    </style>

</head>
<body>

<h1>DELETE PROPERTY</h1>
<div>
    <h3>${property.propertyName}</h3>
    <p>Property name: ${property.address}</p>
    <p>Property area: ${property.area}</p>
    <p>Property price: ${property.propertyPrice}</p>

</div>
<form action="${pageContext.request.contextPath}/seller" method="post">
    <h2>BAN CO CHAC KHONG</h2>

    <input type="hidden" name="propertyId" value="${property.propertyId}"><br>
    <input type="hidden" name="action" value="delete">

    <input type="submit" name="choice" value="YES">
    <input type="submit" name="choice" value="NO" >

</form>


</body>
</html>
