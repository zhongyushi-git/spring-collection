$(function () {
    $("#login").click(function () {
        var id = $("#id").val();
        var password = $("#password").val();
        if (id == null || id == "") {
            alert("请输入用户名");
            return;
        } else if (password == null || password == "") {
            alert("请输入密码");
            return;
        }
        $.post(applicationName + "/login/login", {
                id: id,
                password: password,
            },
            function (data) {
                if (data.code == 200) {
                    window.location.href = view + "index.html"
                } else {
                    alert("用户名或密码错误");
                }
            }
        )
    })
})