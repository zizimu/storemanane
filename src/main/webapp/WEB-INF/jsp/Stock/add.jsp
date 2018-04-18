<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="UTF-8">
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
<table class="table table-bordered table-hover definewidth m10">
	<tr>
		<td width="10%" class="tableleft">批次</td>
		<td>
			<select id="batchId" style="width: 210px;">
				<c:forEach items="${batchs}" var="p">
					<option value="${p}">第${p}批次</option>
				</c:forEach>
				<option value="${batchs.get(batchs.size()-1) + 1}">新批次</option>
			</select>
		</td>
	</tr>
	<tr>
		<td class="tableleft">商品名称</td>
		<td>
			<select id="gname" style="width: 210px;">
				<c:forEach items="${goods}" var="p">
					<option value="${p.goodsId}">${p.goodsName}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td class="tableleft">库存</td>
		<td><input type="number" id="gstock"/></td>
	</tr>
	<tr>
		<td class="tableleft">已售数量</td>
		<td><input type="number" id="gsold"/></td>
	</tr>
	<tr>
		<td class="tableleft">所属门店</td>
		<td><input type="number" id="sid"/></td>
	</tr>
	<tr>
		<td class="tableleft">备注</td>
		<td><input type="text" id="mark"/></td>
	</tr>
	<tr>
		<td class="tableleft"></td>
		<td>
			<button id="submit" class="btn btn-primary" type="button">保存</button>&nbsp;&nbsp;
			<button type="button" class="btn btn-success" name="backid" id="backid">
				返回列表
			</button>
		</td>
	</tr>
</table>
</body>
</html>
<script>
    $(function () {
        $('#backid').click(function () {
            window.location.href = "${pageContext.request.contextPath}/Stock";
        });
        $("#submit").click(function () {
            var data = {
                "batchId": $("#batchId").val(),
                "goodsId": $("#gname").val(),
                "goodsStock": $("#gstock").val(),
                "goodsSold": $("#gsold").val(),
                "storeId": $("#sid").val(),
                "mark": $("#mark").val()
            };
            $.ajax({
                url: "${pageContext.request.contextPath}/Stock",
                type: 'POST',
                dataType: "json",
                data: JSON.stringify(data),
                contentType: 'application/json;charset=UTF-8',
                beforeSend: function () {
                    console.log("正在进行，请稍候");
                },
                success: function (responseStr) {
                    if (responseStr['stat'] == 200) {
                        window.location.href = "${pageContext.request.contextPath}/Stock";
                    } else {
                        alert(responseStr['message']);
                    }
                },
                error: function () {
                    console.log("error!");
                }
            })
        })
    });
</script>