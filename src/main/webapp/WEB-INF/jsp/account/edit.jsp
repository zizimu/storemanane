<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                put();
            });
        });
        function put() {
            var data = {
                "sid":${account.sid},
                "status": $("#status").val(),
                "storeid": $("#storeName").val(),
                "mark": $("#mark").val()
            };
            $.ajax({
                url: "${pageContext.request.contextPath}/account/" +${account.sid},
                type: 'PUT',
                dataType: "json",
                data: JSON.stringify(data),
                contentType: 'application/json;charset=UTF-8',
                beforeSend: function () {
                    console.log("正在进行，请稍候");
                },
                success: function (responseStr) {
                    if (responseStr['stat'] == 200) {
                        window.location.href = "${pageContext.request.contextPath}/account";
                    } else {
                        alert(responseStr['message']);
                    }
                },
                error: function () {
                    console.log("error!");
                }
            })
        };
	</script>
</head>
<body>
<table class="table table-bordered table-hover ">
	<tr>
		<td width="10%" class="tableleft">账号ID</td>
		<td><input type="text" disabled value="${account.loginname}"/>
	</tr>
	<tr>
		<td width="10%" class="tableleft">手机</td>
		<td><input type="text" disabled value="${account.phone}"/>
	</tr>
	<tr>
		<td width="10%" class="tableleft">通讯地址</td>
		<td><input type="text" disabled value="${account.address}"/>
	</tr>
	<tr>
		<td class="tableleft">所属门店</td>
		<td><select type="text" id="storeName" style="width: 210px;">
			<c:forEach items="${stores}" var="p">
				<option value="${p.key}">${p.value}</option>
			</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td class="tableleft">账号状态</td>
		<td><select type="text" id="status" style="width: 210px;">
			<c:forEach items="${status}" var="p">
				<option value="${p.key}">${p.value}</option>
			</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td class="tableleft">备注</td>
		<td><input type="text" id="mark" value="${account.mark}"/></td>
	</tr>
	<tr>
		<td class="tableleft"></td>
		<td>
			<button id="submit" class="btn btn-primary" type="button">保存</button>&nbsp;&nbsp;
			<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
		</td>
	</tr>
</table>
</body>
</html>
<script>
    $(function () {
        $('#backid').click(function () {
            window.location.href = "${pageContext.request.contextPath}/account";
        });
        var selBrand = "${account.storeid}";
        $("#goodsBrand").find("option[value=" + selBrand + "]").attr("selected", true);
        var selType = "${account.status}";
        $("#goodsType").find("option[value=" + selType + "]").attr("selected", true);
    });
</script>