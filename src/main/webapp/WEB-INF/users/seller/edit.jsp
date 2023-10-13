<%@ page import="com.example.mockcasemodule3.model.properties.Property" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.mockcasemodule3.dao.impl.PropertyDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="C"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit property</title>
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
<%

%>

<h1>Edit property</h1>

<form action="${pageContext.request.contextPath}/seller" method="post">

    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="propertyId" value="${property.propertyId}"><br>

    Name:
    <input type="text" name="propertyName" value="${property.propertyName}"><br>

    City:
    <input type="text" name="city" value="${property.address.city}"><br>
    district:
    <input type="text" name="district" value="${property.address.district}"><br>
    houseNumber:
    <input type="text" name="houseNumber" value="${property.address.houseNumber}"><br>

    Price:
    <input type="text" name="price" value="${property.propertyPrice}"><br>

    Area:
    <input type="text" name="area" value="${property.area}"><br>

    <button class="btn btn-lg btn-success">
        <a href="${pageContext.request.contextPath}/seller">Cancel</a>
    </button>

    <input type="submit" value="Update Property">

</form>





</body>
</html>
