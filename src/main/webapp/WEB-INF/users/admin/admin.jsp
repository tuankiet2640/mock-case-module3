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
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style>
        body{
            padding-top: 60px;
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
    <table class="table table-dark table-hover">
        <thead>
        <tr >
            <th>ID</th>
            <th>username</th>
            <th>password</th>
            <th>usertype</th>
        </tr>
        </thead>
        <tbody>
        <C:forEach var="user" items="${userList}">
            <tr>
                <td>
                    <c:out value="${user.id}"></c:out>
                </td>
                <td>
                    <c:out value="${user.username}"></c:out>
                </td>
                <td>
                    <c:out value="${user.password}"></c:out>
                </td>
                <td>
                    <c:out value="${user.role}"></c:out>
                </td>
                <td>
                    <c:out value="${user.is_deleted}"></c:out>
                </td>

                <td>
                    <a href="/admin?action=delete&userId=${user.id}">Delete</a>
                </td>
            </tr>

        </C:forEach>
        </tbody>
    </table>

</body>
</html>
