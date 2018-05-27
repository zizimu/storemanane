<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>登录</title>
	<script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/jquery.js"></script>
	<link rel="stylesheet" href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/login.css" ,type="text/css">
	<script type="text/javascript">
        $(function () {
            $("#submit").click(function () {
                if (checkName() && checkPsw()) {
                    post();
                }
            });
        });

        function checkName() {
            var name = $("#loginname").val();
            if (name !== null && name !== "") {
                $("#check").text("");
                return true;
            } else {
                $("#check").text("请输入ID或登录名!");
            }
            return false;
        };

        function checkPsw() {
            var name = $("#loginpwd").val();
            if (name !== null && name !== "") {
                $("#check").text("");
                return true;
            } else {
                $("#check").text("请输入密码!");
            }
            return false;
        };

        function post() {
            var data = {
                "loginname": $("#loginname").val(),
                "password": $("#loginpwd").val(),
            };
            $.ajax({
                url: "${pageContext.request.contextPath}/login",
                type: 'POST',
                dataType: "json",
                data: JSON.stringify(data),
                contentType: 'application/json;charset=UTF-8',
                success: function (responseStr) {
                    if (responseStr['stat'] == 200) {
                        window.location.href = responseStr['url'];
                    } else {
                        $("#check").text(responseStr['message']);
                    }
                },
                error: function () {
                    $("#check").text('登录失败请重试！');
                }
            })
        };
	</script>
</head>
<body class="bgimg" style="background: url(../../img/back.ico) no-repeat;background-size:cover;width:100%;height: auto;">
<div id="content">

	<div class="centerText"></div>
	<div class="centerText">
		<input class="textStyle" type="text" id="loginname" placeholder="ID或登录名">
	</div>
	<div class="centerText">
		<input class="textStyle" type="password" id="loginpwd" placeholder="密码">
	</div>
	<div class="centerText">
		<input type="button" id="submit" value="登录" class="btn">
	</div>
	<div class="centerText">
		<a href="${pageContext.request.contextPath}/register">没有账号？请注册</a>
	</div>
	<div class="centerText">
		<span id="check" style="margin-top:5px;color: red; font-size: 15px;"></span>
	</div>
</div>
</body>
</html>
