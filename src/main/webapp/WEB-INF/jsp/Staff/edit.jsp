<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>修改员工信息</title>
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
        $(function () {
            $("#submit").click(function () {
                var data = {
                    "staffId":${staff.staffId},
                    "staffName" : $("#staffName").val(),
                    "staffPhone" : $("#staffPhone").val(),
                    "storeId" : $("#storeId").val(),
                    "role" : $("#role").val(),
                    "mark": $("#mark").val()                };
                $.ajax({
                    url: "${pageContext.request.contextPath}/Staff/"+${staff.staffId},
                    type: 'PUT',
                    dataType: "json",
                    data: JSON.stringify(data),
                    contentType: 'application/json;charset=UTF-8',
                    beforeSend: function () {
                        console.log("正在进行，请稍候");
                    },
                    success: function (responseStr) {
                        if (responseStr['stat'] == 200) {
                            window.location.href="${pageContext.request.contextPath}/Staff";
                        } else {
                            alert(responseStr['message']);
                        }
                    },
                    error: function () {
                        console.log("error!");
                    }
                })
            })
        })
    </script>
</head>
<body>
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">登录名</td>
				<td><input type="text" id="staffName" value="${staff.staffName}"/></td>
			</tr>
			<tr>
				<td class="tableleft">联系电话</td>
				<td><input type="text" id="staffPhone" value="${staff.staffPhone}"/></td>
			</tr>
			<tr>
				<td class="tableleft">所属门店</td>
				<td><select type="text" id="storeId" style="width: 210px;">
					<c:forEach items="${stores}" var="s">
						<option value="${s.key}">${s.value}</option>
					</c:forEach>
				</select></td>
			</tr>
			<%-- <tr>
				<td class="tableleft">入职时间</td>
				<td><input type="date" id="entryTime" value="${staff.entryTime}"/></td>
			</tr> --%>
			<tr>
				<td class="tableleft">角色</td>
				<td>
					<select type="text" id="role" style="width: 210px;">
						<c:forEach items="${roles}" var="s">
							<option value="${s.key}">${s.value}</option>
						</c:forEach>
					</select></td>
			</tr>
			<tr>
				<td class="tableleft">备注</td>
				<td><input type="text" id="mark" value="${staff.mark}"/></td>
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
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="${pageContext.request.contextPath}/Staff";
		 });
        var selBrand = "${staff.storeId}";
        $("#storeId").find("option[value=" + selBrand + "]").attr("selected", true);
        var selBrand2 = "${staff.role}";
        $("#role").find("option[value=" + selBrand2 + "]").attr("selected", true);
    });
</script>