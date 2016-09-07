<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Registration</title>

        <link rel="stylesheet" href="css/styleLogin.css">
  </head>

  <body>

    <div class='wrap'>
  Login
    <form action="/registration" method="POST">
        <input type='text' id='login' name="login" placeholder='login' >
        <input type='password' id='password' name="password" placeholder='password' >
        <input type='text' id='email' name="email" placeholder='email' >
        <input type='text' id='name' name="name" placeholder='name' >
        <input type='text' id='surname' name="surname" placeholder='surname' >

    <button class='login'>Confirm registration</button>
    </form>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/login.js"></script>
  </body>
</html>
