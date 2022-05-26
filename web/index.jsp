<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="index.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="index.js"></script>
</head>
<body>
<div class="header">
    <div class="navbar-container" >
        <div class="navbar">
            <div class="login"><input id="login-button" onclick="showLoginForm()" type="button" value="Login"></div>
            <div class="span"><span>OR</span></div>
            <div class="signup"><input id="signup-button" type="button" value="Sign up"></div>
        </div>
    </div>
</div>

<div class="section">
    <div class="login-form-container" id="form-container">
        <div class="login-form-element username-label"><label>Username </label></div>
        <div class="login-form-element"><input type="text" ></div>
        <div class="login-form-element password-label"><label>Password</label></div>
        <div class="login-form-element"><input id="password-field" type="password"><label id="show_password_label">Show password &nbsp</label><i id="" class="fa fa-eye fa-5xs" style="padding:0px 0px" onmouseup="hidepassword();" onmousedown="showpassword();"></i></div>
        <div class="login-submitbutton"><input type="button" value="Login"></div>
    </div>
    <div class="signup-form-container" id ="signup-form">
        <div class="signup-form-element-label">Username</div>
        <div class="signup-form-element"><input type="text"></div>
        <div class="signup-form-element-label">Password</div>
        <div class="signup-form-element"><input id="password" type="password"></div>
        <div class="signup-form-element-label">Confirm Password</div>
        <div class="signup-form-element"><input type="password" placeholder="Re-enter password" id="Confirm-password" onkeyup="matchPassword();">
            <label id="show_password_label1">Show password &nbsp</label>
            <i class="fa fa-eye fa-5xs" onmouseup="hideConfirmPassword();" onmousedown="showConfirmPassword();"></i></div>
        <span id='message'></span>
        <div class="signup-submit-button"><input type="button" value="Sign Up"></div>

    </div>
</div>

<div class="footer">

</div>
</body>
</html>
