
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <style>

        body {
            margin: 0;
            padding: 0;
            background: #f2f2f2;
        }

        .login-box {
            width: 300px;
            padding: 20px;
            background: #fff;
            margin: 100px auto;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.3);
        }

        h2 {
            text-align: center;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
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
        <jsp:include page="navbar.jsp"/>
    </div>
    <h2>LOGIN</h2>
</header>
<div class="login-box">
    <form action="${pageContext.request.contextPath}/login" method="post">

        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>
