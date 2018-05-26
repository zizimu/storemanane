<%@page contentType="text/html"%>
<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>订单新增</title>
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
	$(function() {
		$("#submit").click(
						function() {
							var data = {
								"goodsId" : $("#goodsId").val(),
								"goodsNum" : $("#goodsNum").val(),
							 	"store_id" : $("#store_id").val(), 
								/* "totalPrice" : $("#totalPrice").val(), */
								"mark" : $("#mark").val()
							};
							$.ajax({
										url : "${pageContext.request.contextPath}/Order",
										type : 'POST',
										dataType : "json",
										data : JSON.stringify(data),
										contentType : 'application/json;charset=UTF-8',
										beforeSend : function() {
											console.log("正在进行，请稍候");
										},
										success : function(responseStr) {
											if (responseStr['stat'] == 200) {
												window.location.href = "${pageContext.request.contextPath}/Order";
											} else {
												alert(responseStr['message']);
											}
										},
										error : function() {
											console.log("error!");
										}
									})
						})
	})
</script>
</head>
<body>
	<input type="hidden" name="id" value="{$menu.id}" />
	<table class="table table-bordered table-hover m10">
		<tr>
			<td width="10%" class="tableleft">商品名称</td>
			<td><select type="text" id="goodsId" style="width: 210px;">
				<c:forEach items="${goods}" var="p">
					<option value="${p.goodsId}">${p.goodsName}</option>
					<%-- <option value="${p.key}">${p.value}</option> --%>
				</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td class="tableleft">商品数量</td>
			<td><input type="text" id="goodsNum" /></td>
		</tr>
		 <tr>
			<td class="tableleft">门店编号</td>
			<td><input type="text" id="store_id" value="${user.storeid}"/></td>
		</tr> 
		<!-- <tr>
			<td class="tableleft">总价</td>
			<td><input type="text" id="totalPrice" /></td>
		</tr> -->
		<tr>
			<td class="tableleft">备注</td>
			<td><input type="text" id="mark" /></td>
		</tr>

		<tr>
			<td class="tableleft"></td>
			<td>
				<button id="submit" class="btn btn-primary" type="button">保存</button>
				&nbsp;&nbsp;
				<button type="button" class="btn btn-success" name="backid"
					id="backid">返回列表</button>
			</td>
		</tr>
	</table>
</body>
</html>
<script>
	$(function() {
		$('#backid').click(function() {
			window.location.href = "${pageContext.request.contextPath}/Order";
		});

	});
</script>