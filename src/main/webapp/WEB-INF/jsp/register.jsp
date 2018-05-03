<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/2
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>注册</title>
	<script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/jquery.js"></script>
	<link rel="stylesheet" href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/login.css" ,type="text/css">
	<script type="text/javascript">
        $(function () {
            $("#submit").click(function () {
                if (checkName() && checkPsw() && checkPhone() && checkAddress()) {
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
                $("#check").text("请输入登陆名!");
            }
            return false;
        };

        function checkAddress() {
            var name = $("#address").val();
            if (name !== null && name !== "") {
                $("#check").text("");
                return true;
            } else {
                $("#check").text("请输入地址");
            }
            return false;
        };

        function checkPsw() {
            var name = $("#loginpwd").val();
            var conf = $("#confirmpwd").val();
            if (name == null || name == "") {
                $("#check").text("请输入密码!");
            } else if (conf == null || conf == "") {
                $("#check").text("请输入确认密码!");
            } else if (conf !== name) {
                $("#check").text("密码和确认密码不一致!");
            } else {
                $("#check").text("");
                return true;
            }
            return false;
        };

        function checkPhone() {
            var staffPhone = $("#phone").val();
            var phone = /^[1][3,4,5,7,8,9][0-9]{9}$/;
            if (staffPhone == null || staffPhone == "") {
                $("#check").text("请输入手机号码！");
            } else if (!phone.test(staffPhone)) {
                $("#check").text('请输入正确的手机号码！');
            } else {
                $("#check").text("");
                return true;
            }
            return false;
        };

        function post() {
            var data = {
                "loginname": $("#loginname").val(),
                "password": $("#loginpwd").val(),
                "address": $("#address").val(),
                "phone": $("#phone").val()
            };
            $.ajax({
                url: "${pageContext.request.contextPath}/register",
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
                    $("#check").text('注册失败请重试！');
                }
            })
        };
	</script>
</head>
<body class="bgimg" style="background: url('${BGimage}') no-repeat;background-size:cover;width:100%;height: auto;">
<div id="content" style="margin-top: 160px;">
	<%--<div class="logoNloginText" style="text-align:center;">
		<a href="../index.html"><img src="/shopping/images/logo/logoMiddle.png" alt="logo"></a>
	</div>--%>
	<div class="centerText"></div>
	<div class="centerText">
		<input class="textStyle" type="text" id="loginname" onblur="checkName()" placeholder="登陆名">
	</div>
	<div class="centerText">
		<input class="textStyle" type="tel" id="phone" onblur="checkPhone()" placeholder="手机号">
	</div>
	<div class="centerText">
		<input class="textStyle" type="text" id="address" onblur="checkAddress()" placeholder="通讯地址">
	</div>
	<div class="centerText">
		<input class="textStyle" type="password" id="loginpwd" placeholder="密码">
	</div>
	<div class="centerText">
		<input class="textStyle" type="password" id="confirmpwd" onblur="checkPsw()" placeholder="确认密码">
	</div>
	<div class="centerText">
		<input type="button" id="submit" value="注册" class="btn">
	</div>
	<div class="centerText">
		<a href="${pageContext.request.contextPath}/login">已有账号？请登陆</a>
	</div>
	<div class="centerText">
		<span id="check" style="margin-top:5px;color: red; font-size: 15px;"></span>
	</div>
</div>
</body>
</html>
