<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="C"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Login</title>
</head>
<body>
<h1>admin login</h1>

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
            <td><a href="/user?action=edit&id=${user.getId()}">edit</a></td>

            <td><a href="/user?action=remove&id=${user.getId()}">remove</a></td>

        </tr>

    </C:forEach>
    </tbody>
</table>
</body>
</html>
