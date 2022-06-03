
    console.log('dom loaded');
    function showLoginForm() {
        var loginclicked = document.getElementById('form-container');
        var signupclicked = document.getElementById('signup-form');
        var signupbuttonstyle = window.getComputedStyle(signupclicked);
        var loginButtonStyle = window.getComputedStyle(loginclicked);
        if (loginButtonStyle.display == 'none' && signupbuttonstyle.display == 'block') {
            signupclicked.style.display = 'none';
            loginclicked.style.display = 'block';
            loginclicked.style.animation = 'fade_in_show 1.5s';
        } else {
            loginclicked.style.display = 'block';
            loginclicked.style.animation = 'fade_in_show 1.5s';
        }
        //document.getElementById('form-container').setAttribute("style","display:block;");

    }

    function showSignupForm() {
        var loginclicked = document.getElementById('form-container');
        var signupclicked = document.getElementById('signup-form');
        var signupbuttonstyle = window.getComputedStyle(signupclicked);
        var loginButtonStyle = window.getComputedStyle(loginclicked);

        if (signupbuttonstyle.display == 'none' && loginButtonStyle.display == 'block') {
            loginclicked.style.display = 'none';
            signupclicked.style.display = 'block';
            signupclicked.style.animation = 'fade_in_show 1.5s';
        } else {
            signupclicked.style.display = 'block';
            signupclicked.style.animation = 'fade_in_show 1.5s';

        }
    }

    function showpassword() {
        var element = document.getElementById('password-field');
        element.type = 'text';
    }

    function hidepassword() {
        var element = document.getElementById('password-field');
        element.type = 'password';
    }

    function hideConfirmPassword() {
        var element = document.getElementById('Confirm-password')
        element.type = 'password';
    }

    function showConfirmPassword() {
        var element = document.getElementById('Confirm-password')
        element.type = 'text';
    }

    function matchPassword() {
        var pass1 = document.getElementById('password').value;
        var pass2 = document.getElementById('Confirm-password').value;
        var color = document.getElementById('Confirm-password').style.borderColor;
        if (pass1 !== pass2 && pass2 != '') {
            document.getElementById('Confirm-password').style.borderColor = 'red';
        } else {
            document.getElementById('Confirm-password').style.borderColor = '';
        }
    }

    function closeLoginForm() {
        document.getElementById('form-container').style.display = 'none';
    }

    function closeSignupForm() {
        document.getElementById('signup-form').style.display = 'none';
    }

    document.getElementById('login-submit')?.addEventListener("click", function () {

        console.log('login button clicked');
        $.ajax({
            url: 'api/userlogin',
            method: 'POST',
            data: JSON.stringify(
                {
                    username: $('#username-field').val(),
                    password: $('#password-field').val()
                }),
            contentType: 'application/json; charset=utf-8',
            success: function (response) {
                console.log(response);
                $('#responseData').text(response);
                var data = JSON.parse(response);
                if (data.LoginFlag === 'TRUE') {
                    sessionStorage.setItem('userdata', response);
                    location.href = 'home.jsp';
                } else {
                    alert("Incorrect username/password!");
                    // location.href = 'index.jsp';
                }

            }
        })

    });
    document.getElementById('signup_submitbutton')?.addEventListener("click", function () {
        console.log('signup button clicked');
        $.ajax(
            {
                url: 'api/usersignup',
                method: 'POST',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify({
                    username: $('#username').val(),
                    password: $('#password').val()
                }),
                success: (response) => {
                    console.log(response);
                },
                error: () => {
                    alert('error in Registered ! Please try again');
                }
            }
        )
    });

