
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
    </style>
</head>
<body>
<ul>
    <li>
        <a href="navigate?page=index">Home</a>
    </li>
    <li>
        <a href="navigate?page=about">About</a>
    </li>
    <li>
        <%
            if(session.getAttribute("loggedUser") != null){
        %>
        WELCOME <%=
            ((String)session.getAttribute("loggedUser")).toUpperCase()
        %>
        <li>
        <a href="/logout">Logout</a>
        </li>
        <li>
            <a href="/seller">Profile</a>
        </li>
        <%
            }
        %>


        <%
            if(session.getAttribute("loggedUser") == null){
        %>
        <li>
        <a href="login.jsp">Login</a>
        </li>
        <li>
        <a href="register.jsp">Register</a>
        </li>
        <%
            }
        %>
    </li>

</ul>
</body>
</html>
