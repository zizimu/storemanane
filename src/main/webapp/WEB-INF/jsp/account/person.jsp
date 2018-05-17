<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/3
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>个人信息</title>
	<link rel="stylesheet" type="text/css"
	      href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css"
	      href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/bootstrap-responsive.css"/>
	<link rel="stylesheet" type="text/css" href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/style.css"/>
	<script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/jquery.js"></script>
	<script type="text/javascript"
	        src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/jquery.sorted.js"></script>
	<script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/bootstrap.js"></script>
	<script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/ckform.js"></script>
	<script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/common.js"></script>
	<script type="text/javascript"
	        src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/jquery.form.min.js"></script>
	<style type="text/css">
		body {
			padding-bottom: 40px;
		}

		.sidebar-nav {
			padding: 9px 0;
		}

		@media (max-width: 980px) {
			.navbar-text.pull-right {
				float: none;
				padding-left: 5px;
				padding-right: 5px;
			}
		}
	</style>
	<script type="text/javascript">
        var pwdIsTrue = false;
        $(function () {
            $("#submit").click(function () {
                checkOldPwd();
                if (pwdIsTrue) {
                    if (checkName() & checkAddress() & checkTel()) {
                        put();
                    }
                }
            })
        });

        function checkName() {
            var name = $("#loginName").val();
            if (name !== null && name !== "") {
                $("#nameCheck").text("");
                return true;
            } else {
                $("#nameCheck").text("请输入登录名!");
            }
            return false;
        }

        function checkAddress() {
            var name = $("#address").val();
            if (name !== null && name !== "") {
                $("#addCheck").text("");
                return true;
            } else {
                $("#addCheck").text("请输入通讯地址!");
            }
            return false;
        }

        function checkNewPwd() {
            var new_pwd = $("#new_password").val();
            var new_pwd2 = $("#new_password2").val();
            if (new_pwd == null || new_pwd == "") {
                $("#newPwdCheck").text("请输入新密码！");
                return false;
            } else if (new_pwd === new_pwd2) {
                return true;
            } else {
                $("#newPwdConfirm").text("两次密码不一致!");
            }
            return false;
        }

        function checkTel() {
            var name = $("#phone").val();
            if (name !== null && name !== "") {
                $("#telCheck").text("");
                return true;
            } else {
                $("#telCheck").text("请输入手机号!");
            }
            return false;
        }

        function checkOldPwd() {
            var old_password = $("#old_password").val();
            if (old_password == null || old_password == "") {
                $("#pwdcheck").text('原密码不能为空');
                pwdIsTrue = false;
            } else {
                $.ajax({
                    url: "${pageContext.request.contextPath}/account/pwdCheck",
                    type: 'POST',
                    dataType: "json",
                    data: {
                        'pwd': old_password
                    },
                    beforeSend: function () {
                        console.log("正在进行，请稍候");
                    },
                    success: function (responseStr) {
                        if (responseStr['stat'] == 200) {
                            $("#pwdcheck").text('');
                            $("#pwdcheck2").text('✔');
                            pwdIsTrue = true;
                        } else {
                            pwdIsTrue = false;
                            $("#pwdcheck2").text('');
                            $("#pwdcheck").text(responseStr['message']);
                        }
                    },
                    error: function () {
                        console.log("error!");
                    }
                })
            }
        }

        function isPwdEx() {
            var account = {
                "sid":${account.sid},
                "loginname": $("#loginName").val(),
                "phone": $("#phone").val(),
                "address": $("#address").val(),
                "mark": $("#mark").val()
            };
            var new_password = $("#new_password").val();
            var new_password2 = $("#new_password2").val();
            if (new_password != null && new_password !== '' && new_password === new_password2) {
                account['password'] = new_password;
            }
            return account;
        }

        function put() {
            $.ajax({
                url: "${pageContext.request.contextPath}/account",
                type: 'PUT',
                dataType: "json",
                data: JSON.stringify(isPwdEx()),
                contentType: 'application/json;charset=UTF-8',
                beforeSend: function () {
                    console.log("正在进行，请稍候");
                },
                success: function (responseStr) {
                    if (responseStr['stat'] == 200) {
                        alert('修改成功！');
                        window.location.href = "${pageContext.request.contextPath}/account/information";
                    } else {
                        alert(responseStr['message']);
                    }
                },
                error: function () {
                    console.log("error!");
                }
            })
        }
	</script>
</head>
<body>
<form>
	<table class="table table-bordered table-hover definewidth m10">
		<tr>
			<td width="10%" class="tableleft">登录名</td>
			<td><input type="text" id="loginName" onblur="checkName()" value="${account.loginname}"/>
				<span id="nameCheck" style="color: red; font-size: 15px;"></span></td>
		</tr>
		<tr>
			<td class="tableleft">原始密码</td>
			<td><input type="password" onblur="checkOldPwd()" id="old_password"/>
				<span id="pwdcheck" style="color: red; font-size: 15px;"></span>
				<span id="pwdcheck2" style="color: green; font-size: 20px;margin-left: 5px"></span></td>
		</tr>
		<tr>
			<td class="tableleft">新密码</td>
			<td><input type="password" id="new_password"/>
			<span id="newPwdCheck" style="color: red; font-size: 15px;"></span></td>
		</tr>
		<tr>
			<td class="tableleft">确认密码</td>
			<td><input type="password" onblur="checkNewPwd()" id="new_password2"/>
			<span id="newPwdConfirm" style="color: red; font-size: 15px;"></span></td>
		</tr>
		<tr>
			<td class="tableleft">电话</td>
			<td><input type="text" id="phone" onblur="checkTel()" value="${account.phone}"/>
			<span id="telCheck" style="color: red; font-size: 15px;"></span></td>
		</tr>
		<tr>
			<td class="tableleft">地址</td>
			<td><input type="text" id="address" onblur="checkAddress()" value="${account.address}"/>
			<span id="addCheck" style="color: red; font-size: 15px;"></span></td>
		</tr>
		<tr>
			<td class="tableleft">备注</td>
			<td><input type="text" id="mark" value="${account.mark}"/></td>
		</tr>
		<tr>
			<td class="tableleft">操作</td>
			<td>
				<button id="submit" class="btn btn-primary" type="button">保存</button>&nbsp;&nbsp;
				<input type="reset" value="重 置" class="btn btn-success"/>&nbsp;&nbsp;
			</td>
		</tr>
		<tr>
			<td class="tableleft">提示</td>
			<td>
				1. 修改基本信息需要输入原始密码。<br>
				2. 修改密码需要输入原始密码、新密码。
			</td>
		</tr>
	</table>
</form>
</body>
</html>
