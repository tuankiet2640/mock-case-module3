<%--
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
<h1>Create Property</h1>
<form action="/login/seller" method="post">

    <input type="hidden" name="action" value="edit">

    Property ID:
    <input type="text" name="propertyId" value="${property.id}"><br>

    Name:
    <input type="text" name="name" value="${property.name}"><br>

    City:
    <input type="text" name="city" value="${property.address.city}"><br>
    Name:
    <input type="text" name="district" value="${property.address.district}"><br>
    Name:
    <input type="text" name="houseNumber" value="${property.address.houseNumber}"><br>

    Price:
    <input type="text" name="price" value="${property.price}"><br>

    Area:
    <input type="text" name="area" value="${property.area}"><br>

    <input type="submit" value="Create Property">

</form>

</body>
</html>
