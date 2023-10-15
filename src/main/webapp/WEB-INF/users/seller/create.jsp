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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>

<%
    Seller seller = (Seller) session.getAttribute("seller");
    int sellerId= seller.getSellerId();
    request.setAttribute("sellerId",sellerId);
%>
<h1>Create Property</h1>
<form action="/seller" method="post" >

    <input type="hidden" name="action" value="create">
    <input type="hidden" name="sellerId" value=${sellerId}>

    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">Username</span>
        <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" name="username">
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text">Price</span>
        <input type="text" class="form-control" placeholder="Price" aria-label="Price" aria-describedby="basic-addon1" name="price">
    </div>

    Area:
    <input type="text" name="area"><br>

    City:
    <input type="text" name="city"><br>
    District:
    <input type="text" name="district"><br>
    House number:
    <input type="text" name="houseNumber"><br>

    <div class="buttons">
        <button type="button" onclick="window.location='/seller'">Cancel</button>
        <button type="submit">Create Property</button>
    </div>

</form>

</body>
</html>
