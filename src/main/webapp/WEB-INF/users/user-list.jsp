<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/5/2023
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="C"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
    <table class="table table-striped">
        <thead>
        <tr>
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
            </tr>

        </C:forEach>
        </tbody>
    </table>
<%--    <div>--%>
<%--        <form action="AdminController" method="get">--%>
<%--            <input type="hidden" name="action" value="create">--%>
<%--            <input type="submit" value="Create Property">--%>
<%--        </form>--%>

<%--        <form action="AdminController" method="get">--%>
<%--            <input type="hidden" name="action" value="edit">--%>
<%--            <input type="submit" value="Edit Property">--%>
<%--        </form>--%>

<%--        <form action="AdminController" method="get">--%>
<%--            <input type="hidden" name="action" value="delete">--%>
<%--            <input type="submit" value="Delete Userty">--%>
<%--        </form>--%>
<%--    </div>--%>
</body>
</html>
