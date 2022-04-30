var username = $('#login_username').val();
var password = $('#login_password').val();
$(document).ready(function () {
    $('#login_submit').click(function () {
        console.log('button clicked');
        $.ajax({
            url: 'api/userlogin',
            method: 'POST',
            data: JSON.stringify(
                {
                    username: $('#login_username').val(),
                    password: $('#login_password').val()
                }),
            contentType: 'applcation/json; charset=utf-8',
            success: function (response) {
                $('#responseData').text(response);
            }
        })
    })
});