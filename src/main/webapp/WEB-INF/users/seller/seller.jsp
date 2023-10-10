<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/8/2023
  Time: 1:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Seller Login</title>
</head>
<body>
<%@ page import="com.example.mockcasemodule3.model.users.User" %>
<%@ page import="com.example.mockcasemodule3.model.users.Seller" %>

<%--<%--%>
<%--    User seller = (Seller) session.getAttribute("user");--%>
<%--%>--%>

<%--<h1>Welcome <%= seller.getUsername() %></h1>--%>

<%
    Seller seller = (Seller) session.getAttribute("user");
    String username= (String) session.getAttribute("username");
%>

<h1>Welcome seller <%= username %></h1>
<div>
    <form action="/login/seller" method="get">
        <input type="hidden" name="action" value="create">
        <input type="submit" value="Create Property">
    </form>

    <form action="/login/seller" method="get">
        <input type="hidden" name="action" value="edit">
        <input type="submit" value="Edit Property">
    </form>

    <form action="/login/seller" method="get">
        <input type="hidden" name="action" value="delete">
        <input type="submit" value="Delete Property">
    </form>
</div>


</body>
</html>
