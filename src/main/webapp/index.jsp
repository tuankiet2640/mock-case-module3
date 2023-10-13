<%@ page import="com.example.mockcasemodule3.model.properties.Property" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.mockcasemodule3.dao.impl.PropertyDAO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="C"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>WINZ REAL ESTAT3</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 60px;
            overflow-y: auto;
        }

        header {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px;
        }

        .login-button {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }

        .property-list {
            margin: 20px;
        }

        .property-item {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 10px;
            background-color: #f9f9f9;
        }
        #navbar {
            background: #333;
            color: #fff;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            max-height: 60px;
        }

        #navbar ul {
            list-style: none;
            margin: 0;
            padding: 0;
        }

        #navbar li {
            display: inline-block;
        }

        #navbar a {
            color: #fff;
            text-decoration: none;
            padding: 15px 20px;
            display: block;
        }

    </style>
</head>
<body>

<header>
    <h1>Welcome to Winz Real Estat3!</h1>
    <div id="navbar">
        <jsp:include page="navbar.jsp"/>
    </div>
</header>

<%
    PropertyDAO propertyDAO= new PropertyDAO();
    List<Property> properties = propertyDAO.getAllProperty();
    request.setAttribute("properties", properties);
%>

<div class="property-list">

    <h2>Properties</h2>

    <c:forEach items="${properties}" var="property">
        <div class="property-item">
            <h3><c:out value="${property.propertyName}"/></h3
            <p>address: <c:out value="${property.address}"/></p>
            <p>area: <c:out value="${property.area}"/></p>
            <p>Price: <c:out value="${property.propertyPrice}"/></p>
            <p>Seller: <c:out value="${property.seller}"/></p>

        </div>

    </c:forEach>

</div>


</body>
</html>
