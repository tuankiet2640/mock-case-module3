<%@ page import="com.example.mockcasemodule3.model.properties.Property" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.mockcasemodule3.model.users.Seller" %>
<%@ page import="com.example.mockcasemodule3.dao.impl.SellerDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.mockcasemodule3.model.properties.Address" %>
<%@ page import="com.example.mockcasemodule3.dao.impl.AddressDAO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="C"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Seller Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin-top: 60px;
            padding: 0;
        }

        header {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px;
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
    <div id="navbar">
        <jsp:include page="/navbar.jsp"/>
    </div>
</header>

<%
    String username= (String) session.getAttribute("loggedUser");
%>
<%
    Seller seller= (Seller)session.getAttribute("seller");
    int sellerId= seller.getSellerId();
    SellerDAO sellerDAO=new SellerDAO();
    List<Property> properties= null;

    try {
        properties = sellerDAO.getAllPropertyBySellerId(sellerId);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    request.setAttribute("properties", properties);
%>

<c:set var="loggedUser" value="${loggedUser}" scope="session" />

<h1>Welcome seller <%= username %></h1>
<div>
    <form action="${pageContext.request.contextPath}/seller" method="get">
        <input type="hidden" name="action" value="create">

        <input type="submit" value="Create Property">
    </form>


    <h2>Những bất động sản bạn bày bán: </h2>

    <c:forEach items="${properties}" var="property">
        <div class="property-item">
            <h3><c:out value="${property.propertyName}"/></h3
            <p>address: <c:out value="${property.address}"/></p>
            <p>area: <c:out value="${property.area}"/></p>
            <p>Price: <c:out value="${property.propertyPrice}"/></p>
            <td>
                <a href="/seller?action=edit&propertyId=${property.propertyId}">Edit</a>
            </td>

            <td>
                <a href="/seller?action=delete&propertyId=${property.propertyId}">Delete</a>
            </td>


        </div>

    </c:forEach>


</div>


</body>
</html>
