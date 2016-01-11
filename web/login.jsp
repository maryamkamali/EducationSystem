<%--
  Created by IntelliJ IDEA.
  User: sedigheh.arabameri
  Date: 10/25/2015
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Latest compiled and minified CSS -->
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>login</title>
</head>
<div>
    <h1 id="liginTitle" align="center">Login</h1>
</div>
<body>
<div align="center">
    <form style="width: 350px;" name="loginForm" action="/loginController" method="post"
          onsubmit="return validateForm()">
        <div class="form-group">
            <input style="width: 100%" type="text" name="userName" placeholder="Username"> <br> <br>
            <input style="width: 100%" type="password" name="password" placeholder="Password"> <br> <br>
            <button style="width: 100%" class="btn btn-primary" type="Submit">Sign In</button>
        </div>
        not a member?<a href="/main.jsp">Join now</a>
    </form>

</div>
</body>
<script>
    function validateForm() {
        var x = document.forms["loginForm"]["userName"].value;
        var y = document.forms["loginForm"]["password"].value;
        if (x == null || x == "" || y == null || y == "") {
            alert("Username or Password is empty");
            return false;
        }
    }
</script>
</html>

