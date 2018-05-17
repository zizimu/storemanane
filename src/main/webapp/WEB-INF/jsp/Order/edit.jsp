<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>修改订单信息</title>
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
                    "orderId":${order.orderId},
                    "goodsId" : $("#goodsId").val(),
                    "goodsNum" : $("#goodsNum").val(),
                    "activityId" : $("#activityId").val(),
                    "totalPrice" : $("#totalPrice").val(),
                    "createTime" : $("#createTime").val(),
                    "mark": $("#mark").val()                };
                $.ajax({
                    url: "${pageContext.request.contextPath}/Order/"+${order.orderId},
                    type: 'PUT',
                    dataType: "json",
                    data: JSON.stringify(data),
                    contentType: 'application/json;charset=UTF-8',
                    beforeSend: function () {
                        console.log("正在进行，请稍候");
                    },
                    success: function (responseStr) {
                        if (responseStr['stat'] == 200) {
                            window.location.href="${pageContext.request.contextPath}/Order";
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
		<input type="hidden" name="id" value="{$menu.id}" />
		<table class="table table-bordered table-hover m10">
			<tr>
				<td width="10%" class="tableleft">商品名称</td>
				<td><select type="text" id="goodsId" style="width: 210px;">
						<c:forEach items="${goods}" var="p">
							<option value="${p.key}">${p.value}</option>
						</c:forEach>
					</select></td>
			</tr>
			<tr>
				<td class="tableleft">商品数量</td>
				<td><input type="text" id="goodsNum" value="${order.goodsNum}" /></td>
			</tr>
			<tr>
				<td class="tableleft">活动名称</td>
				<td><input type="text" id="activityId" value="${order.activityId}" /></td>
			</tr>
			<tr>
				<td class="tableleft">总价</td>
				<td><input type="text" id="totalPrice" value="${order.totalPrice}" /></td>
			</tr>
			<tr>
				<td class="tableleft">备注</td>
				<td><input type="text" id="mark" value="${order.mark}" /></td>
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
$(function () {       
	$('#backid').click(function(){
			window.location.href="${pageContext.request.contextPath}/Order";
	 });
    var selBrand = "${order.goodsId}";
    $("#goodsId").find("option[value=" + selBrand + "]").attr("selected", true);
});
</script>