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
<form action="/login/seller" method="post">

    <input type="hidden" name="action" value="delete">

    Property ID:
    <input type="text" name="propertyId" value="${property.id}"><br>

    <input type="submit" value="Delete Property">

</form>
<%
    PropertyDAO propertyDAO= new PropertyDAO();
    List<Property> properties = propertyDAO.getAllProperty();
    request.setAttribute("properties", properties);
%>
<div class="property-list">

    <h2>Properties</h2>

    <c:forEach items="${properties}" var="property">
        <div class="property-item">
            <h3><c:out value="${property.propertyName}"/></h3>
            <p>id: <c:out value="${property.propertyId}"/></p>
            <p>address: <c:out value="${property.address}"/></p>
            <p>area: <c:out value="${property.area}"/></p>
            <p>Price: <c:out value="${property.propertyPrice}"/></p>
        </div>

    </c:forEach>

</div>


</body>
</html>
