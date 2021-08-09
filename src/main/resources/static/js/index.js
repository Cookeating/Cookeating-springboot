$("#sign-up-button").click(function () {

    var data = {
        loginId: $('#loginId').val(),
        password: $('#password').val()
    };

    $.ajax({
        url: '/api/user/signUp',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data)
    }).done(function (data) {
        console.log("done : ", data);
        alert('회원가입이 완료되었습니다.');
        window.location.href = '/';

    }).fail(function (error) {
        console.log("error : ", error);
        $("span[class=err]").text("");
        var errorList = error.responseJSON;
        if (errorList != null) {
            console.log(errorList);
            for (var i = 0; i < errorList.length; i += 2) {
                $("#" + errorList[i] + "-err").text(errorList[i + 1]);
            }
        }
    });
})