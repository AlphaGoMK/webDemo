<%--
  Created by IntelliJ IDEA.
  User: AlphaGoMK
  Date: 11/27/2018
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Hello World From Struts2</h1>
    <form action="login">
        <%--@declare id="username"--%>
        <label for="username">Please enter your name</label><br/>
        <input type="text" name="username"/>
        <input type="text" name="passcode"/>
        <input type="submit" value="Say Hello"/>
    </form>
</body>
</html>
