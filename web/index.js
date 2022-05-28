
    function showLoginForm() {
        var loginclicked=document.getElementById('form-container');
        var signupclicked=document.getElementById('signup-form');
        var signupbuttonstyle=window.getComputedStyle(signupclicked);
        var loginButtonStyle = window.getComputedStyle(loginclicked);
        if(loginButtonStyle.display=='none' && signupbuttonstyle.display=='block')
        {
            signupclicked.style.display='none';
            loginclicked.style.display='block';
        }
        else
        {
            loginclicked.style.display='block';
        }
        //document.getElementById('form-container').setAttribute("style","display:block;");

    }
    function showSignupForm() {
        var loginclicked=document.getElementById('form-container');
        var signupclicked=document.getElementById('signup-form');
        var signupbuttonstyle=window.getComputedStyle(signupclicked);
        var loginButtonStyle = window.getComputedStyle(loginclicked);

        if(signupbuttonstyle.display=='none' && loginButtonStyle.display=='block')
        {
            loginclicked.style.display='none';
            signupclicked.style.display='block';
        }
        else
        {
            signupclicked.style.display='block';
        }
    }
    function showpassword() {
        var element=document.getElementById('password-field');
        element.type = 'text';
    }
    function hidepassword() {
        var element=document.getElementById('password-field');
        element.type = 'password';
    }
    function hideConfirmPassword() {
        var element=document.getElementById('Confirm-password')
        element.type='password';
    }
    function showConfirmPassword() {
        var element=document.getElementById('Confirm-password')
        element.type='text';
    }
    function matchPassword() {
        var pass1=document.getElementById('password').value;
        var pass2 =document.getElementById('Confirm-password').value;
        var color=document.getElementById('Confirm-password').style.borderColor;
        if(pass1!==pass2 && pass2!='')
        {
            document.getElementById('Confirm-password').style.borderColor= 'red';
        }
        else{
            document.getElementById('Confirm-password').style.borderColor= '';
        }
    }

         document.getElementById('login-submit').addEventListener("click",function(){
            {
                console.log('button clicked');
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
            }
        });
