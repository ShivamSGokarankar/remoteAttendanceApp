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
</head>
<body>
<p id="welcome">Hello user </p>
</body>
</html>
<script>
    var data=sessionStorage.getItem('userdata');
    data=JSON.parse(data);
    document.getElementById('welcome').innerHTML+=data.username;
</script>
