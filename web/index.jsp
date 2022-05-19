<%--
  Created by IntelliJ IDEA.
  User: ELSE
  Date: 18-05-2022
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="index.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="header">
  <div class="heading">
    <span>Attendance App</span>
  </div>
  <div class="login-button"><input id="login-button" type="button" value="Login"></div>
  <div class="signup-button"><input id="signup-button" type="button" value="Sign up"></div>
</div>

<div class="section">

</div>
<div class="footer">
  <div class="copyright">
    <span>@ShivamSGokagfdrankar</span>
  </div>
</div>
</body>
<script>
  $('#login-button').click(function ()
  {
    console.log('Loggin button clicked');
    location.href='login.jsp';
  })
  $('#signup-button').click(function ()
  {
    console.log('Loggin button clicked');
    location.href='signup.html';
  })

</script>
</html>
