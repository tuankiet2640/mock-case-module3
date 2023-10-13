<%@ page import="com.example.mockcasemodule3.model.users.Seller" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/9/2023
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding New Property</title>
</head>
<body>

<%
    Seller seller = (Seller) session.getAttribute("seller");
    int sellerId= seller.getSellerId();
    request.setAttribute("sellerId",sellerId);
%>
<h1>Create Property</h1>
<form action="/seller" method="post">

    <input type="hidden" name="action" value="create">
    <input type="hidden" name="sellerId" value=${sellerId}>

    Name:
    <input type="text" name="propertyName"><br>
    Price:
    <input type="text" name="propertyPrice"><br>

    Area:
    <input type="text" name="area"><br>

    City:
    <input type="text" name="city"><br>
    District:
    <input type="text" name="district"><br>
    House number:
    <input type="text" name="houseNumber"><br>

    <input type="submit" value="Create Property">

</form>

</body>
</html>
