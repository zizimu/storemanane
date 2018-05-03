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
</head>
<body>
<form>
<table class="table table-bordered table-hover definewidth m10">
	<tr>
		<td width="10%" class="tableleft">登录名</td>
		<td><input type="text" id="brandName" onblur="checkName()" value="${account.loginname}"/>
			<span id="namecheck" style="color: red; font-size: 15px;"></span></td>
	</tr>
	<tr>
		<td class="tableleft">原始密码</td>
		<td><input type="password" id="old_password"/></td>
	</tr>
	<tr>
		<td class="tableleft">新密码</td>
		<td><input type="password" id="new_password"/></td>
	</tr>
	<tr>
		<td class="tableleft">确认密码</td>
		<td><input type="password" id="new_password2"/></td>
	</tr>
	<tr>
		<td class="tableleft">电话</td>
		<td><input type="text" id="phone" value="${account.phone}"/></td>
	</tr>
	<tr>
		<td class="tableleft">地址</td>
		<td><input type="text" id="address" value="${account.address}"/></td>
	</tr>
	<tr>
		<td class="tableleft">备注</td>
		<td><input type="text" id="mark" value="${account.mark}"/></td>
	</tr>
	<tr>
		<td class="tableleft"></td>
		<td>
			<button id="submit" class="btn btn-primary" type="button">保存</button>&nbsp;&nbsp;
			<input type="reset" value="重 置"  class="btn btn-success" />&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td class="tableleft"></td>
		<td>
			1. 修改基本信息需要输入原始密码。<br>
			2. 修改密码需要输入原始密码、新密码。
		</td>
	</tr>
</table>
</form>
</body>
</html>
