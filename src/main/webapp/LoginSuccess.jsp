<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 24-08-2022
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html ; charset = UC-ASCII">
  <title>Login Success Page</title>
</head>
<body>
<h3> Hi <%= request.getAttribute("user")%>,Login successful.</h3>
<a href="login.html">Login Page</a>
</body>
</html>
