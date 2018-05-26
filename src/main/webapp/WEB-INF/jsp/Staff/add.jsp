<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>添加员工</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/style.css" />
<script type="text/javascript"
	src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/jquery.js"></script>
<script type="text/javascript"
	src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/jquery.sorted.js"></script>
<script type="text/javascript"
	src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/bootstrap.js"></script>
<script type="text/javascript"
	src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/ckform.js"></script>
<script type="text/javascript"
	src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/common.js"></script>
<script type="text/javascript"
	src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/jquery.form.min.js"></script>

<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>

<script type="text/javascript">
	$(function() {
		$("#submit").click(function() {
			if (checkName()  & checkPhone()) {
				post();
			}
		});
		$("#staffName").focus(function() {
			$("#nameCheck").text('');
		});
		/* $("#entryTime").focus(function() {
			$("#dateCheck").text('');
		}); */
		$("#staffPhone").focus(function() {
			$("#phoneCheck").text('');
		});
	});
	function checkName() {
		var name = $("#staffName").val();
		if (name !== null && name !== "") {
			$("#nameCheck").text("");
			return true;
		} else {
			$("#nameCheck").text("请输入员工姓名!");
		}
		return false;
	};
	function checkPhone() {
		var staffPhone = $("#staffPhone").val();
		var phone = /^[1][3,4,5,7,8,9][0-9]{9}$/;
		if (staffPhone == null || staffPhone == "") {
			$("#phoneCheck").text("请输入手机号码！");
		} else if (!phone.test(staffPhone)) {
			$("#phoneCheck").text('请输入正确的手机号码！');
		}else{
			$("#phoneCheck").text("");
			return true;
		}
		return false;
	};
	 function checkDate() {
         var date = new Date($("#entryTime").val());
         var today = new Date();
         if(date==null || date=='Invalid Date'){
             $("#dateCheck").text('请选择日期！');
         } else if(date > today) {
             $("#dateCheck").text('入职时间不能超过今天！');
         } else {
             $("#dateCheck").text(''); return true;
         }
         return false;
	};
	function post() {
		var data = {
			"staffName" : $("#staffName").val(),
			"staffPhone" : $("#staffPhone").val(),
			"storeId" : $("#storeId").val(),
			"createTime" : $("#entryTime").val(),
			"role" : $("#role").val(),
			"mark" : $("#mark").val()
		};
		$.ajax({
			url : "${pageContext.request.contextPath}/Staff",
			type : 'POST',
			dataType : "json",
			data : JSON.stringify(data),
			contentType : 'application/json;charset=UTF-8',
			beforeSend : function() {
				console.log("正在进行，请稍候");
			},
			success : function(responseStr) {
				if (responseStr['stat'] == 200) {
					window.location.href = "${pageContext.request.contextPath}/Staff";
				} else {
					alert(responseStr['message']);
				}
			},
			error : function() {
				console.log("error!");
			}
		})
	};
</script>
</head>
<body>
	<form action="index.html" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">登录名</td>
				<td><input type="text" id="staffName" onblur="checkName()"
					maxlength="4" /> <span id="nameCheck"
					style="color: red; font-size: 15px;"></span></td>
			</tr>
			<tr>
				<td class="tableleft">联系电话</td>
				<td><input type="text" id="staffPhone" onblur="checkPhone()" />
					<span id="phoneCheck" style="color: red; font-size: 15px;"></span>
				</td>
			</tr>
			<tr>
				<td class="tableleft">所属门店</td>
				<td><select type="text" id="storeId" style="width: 210px;">
					<c:forEach items="${stores}" var="s">
						<option value="${s.storeId}">${s.storeName}</option>
					</c:forEach>
				</select></td>
			</tr>
			<!-- <tr>
				<td class="tableleft">入职时间</td>
				<td><input type="date" id="entryTime" onblur="checkDate()"/>
					<span id="dateCheck" style="color: red; font-size: 15px;"></span></td>
				</td>
			</tr>	 -->	
			<tr>
				<td class="tableleft">角色</td>
				<td><select type="text" id="role" style="width: 210px;">
					<c:forEach items="${roles}" var="s">
						<option value="${s.key}">${s.value}</option>
					</c:forEach>
					</select></td>
			</tr>
			<tr>
				<td class="tableleft">备注</td>
				<td><input type="text" id="mark" /></td>
			</tr>
			<tr>
				<td class="tableleft"></td>
				<td>
					<button id="submit" class="btn btn-primary" type="button">保存</button>&nbsp;&nbsp;
					<button type="button" class="btn btn-success" name="backid"
						id="backid">返回列表</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<script>
	$(function() {
		$('#backid').click(function() {
			window.location.href = "${pageContext.request.contextPath}/Staff";
		});
	});
</script>