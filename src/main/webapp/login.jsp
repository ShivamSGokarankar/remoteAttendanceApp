<%@ page import="jakarta.servlet.http.HttpSession"%><%--
  Created by IntelliJ IDEA.
  User: ELSE
  Date: 18-05-2022
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Login jsp</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%--    <script src="index.js"></script>--%>

</head>
<body>
	Username :
	<input type="text" id="login_username" name="username" value="Shivam8">
	Password:
	<input type="password" id="login_password" name="password"
		value="Smart@123">
	<input type="button" id="login_submit" value="Login">
	<p id=responseData></p>
</body>

</html>
<script>
    var username = $('#login_username').val();
    var password = $('#login_password').val();
    $(document)
	    .ready(
		    function() {
			$('#login_submit')
				.click(
					function() {
					    console.log('button clicked');
					    $
						    .ajax({
							url : 'api/userlogin',
							method : 'POST',
							data : JSON
								.stringify({
								    username : $(
									    '#login_username')
									    .val(),
								    password : $(
									    '#login_password')
									    .val()
								}),
							contentType : 'application/json; charset=utf-8',
							success : function(
								response) {
							    console
								    .log(response);
							    $('#responseData')
								    .text(
									    response);
							    var data = JSON
								    .parse(response);
							    if (data.LoginFlag === 'TRUE') {
								sessionStorage
									.setItem(
										'userdata',
										response);
								location.href = 'home.jsp';
<%HttpSession httpSession = request.getSession();
// httpSession.setAttribute();%>
    } else {
								location.href = 'index.html';
							    }

							}
						    })
					})

		    });
</script>
