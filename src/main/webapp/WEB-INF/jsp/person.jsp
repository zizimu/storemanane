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
	<link href="/css/person/main.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css"
	      href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css"
	      href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/bootstrap-responsive.css"/>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">个人信息</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" name="form1" action="" method="post">
						<input type="hidden" name="model.userid" value="" />
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">登录名</label>
							<div class="col-sm-10">
							</div>
						</div>
						<div class="form-group">
							<label for="old_password" class="col-sm-2 control-label">原始密码</label>
							<div class="col-sm-10">
								<input name="old_password" type="password"class="form-control" id="old_password" placeholder="原始密码">
							</div>
						</div>
						<div class="form-group">
							<label for="new_password" class="col-sm-2 control-label">新密码</label>
							<div class="col-sm-10">
								<input name="new_password" type="password"class="form-control" id="new_password" placeholder="新密码">
							</div>
						</div>
						<div class="form-group">
							<label for="new_password2" class="col-sm-2 control-label">重复密码</label>
							<div class="col-sm-10">
								<input name="new_password2" type="password" class="form-control" id="new_password2" placeholder="重复密码">
							</div>
						</div>
						<div class="form-group">
							<label for="tel" class="col-sm-2 control-label">手机号</label>
							<div class="col-sm-10">
								<input name="model.tel" type="text" class="form-control" id="tel"
								       value="" placeholder="手机号">
							</div>
						</div>
						<div class="form-group">
							<label for="remark" class="col-sm-2 control-label">备注</label>
							<div class="col-sm-10">
							    	<textarea rows="3" cols="30" class="form-control" id="remark"
								              name="model.remark" placeholder="备注"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="button" value="保 存"  class="btn btn-primary" onclick="oper_save();"/>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="重 置"  class="btn btn-default" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								1. 修改基本信息需要输入原始密码。<br>
								2. 修改密码需要输入原始密码、新密码。
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
