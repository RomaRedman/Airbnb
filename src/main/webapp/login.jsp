<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Login</title>

        <link rel="stylesheet" href="css/styleLogin.css">
  </head>

  <body>

    <div class='wrap'>
  Login
    <form action="/login" method="POST">
        <input type='text' id='login' name = "login" placeholder='login'>
        <input type='password' id='password' name  = "password" placeholder='password'>

  <a href="/login"><button class='login' >LOG IN</button></a>
  <tr>
    <td></td>
    <td style="color: red"><c:out value="${requestScope.loginError}"/></td>
  </tr>
  </form>
  <a href="registration.jsp"><button class='forgot'>Registration</button></a>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/login.js"></script>
  </body>
</html>
