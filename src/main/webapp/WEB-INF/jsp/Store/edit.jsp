<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>修改门店信息</title>
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
                    "storeId":${store.storeId},/* 传过来对象store 以及他的值storeId */
                    "storeName" : $("#storeName").val(),
                    "storeArea" : $("#storeArea").val(),
                    "storeAddress" : $("#storeAddress").val(),
                    "storeManager" : $("#storeManager").val(),
                    "staffPhone" : $("#staffPhone").val(),
                    "createTime" : $("#createTime").val(),
                  
                    "mark": $("#mark").val()       
                };
                $.ajax({
                    url: "${pageContext.request.contextPath}/Store/"+${store.storeId},
                    type: 'PUT',
                    dataType: "json",
                    data: JSON.stringify(data),
                    contentType: 'application/json;charset=UTF-8',
                    beforeSend: function () {
                        console.log("正在进行，请稍候");
                    },
                    success: function (responseStr) {
                        if (responseStr['stat'] == 200) {
                            window.location.href="${pageContext.request.contextPath}/Store";
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
	<form action="{:U('User/edit')}" method="post" class="definewidth m20">
		<input type="hidden" name="id" value="{$user.id}" />
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">门店名称</td>
				<td><input type="text" id="StoreName" value="${store.storeName}"/></td>
			</tr>
			<tr>
				<td class="tableleft">所属地区</td>
				<td><input type="text" id="storeArea" value="${store.storeArea}"/></td>
			</tr>
			<tr>
				<td class="tableleft">详细地址</td>
				<td><input type="text" id="storeAddress" value="${store.storeAddress}"/></td>
			</tr>
			<tr>
				<td class="tableleft">店长</td>
				<td><input type="text" id="storeManager" value="${store.storeManager}"/></td>
			</tr>
			<tr>
				<td class="tableleft">联系方式</td>
				<td><input type="text" id="staffPhone" value="${store.staffPhone}"/></td>
			</tr>
			<tr>
				<td class="tableleft">注册时间</td>
				<td><input type="date" id="createTime" value="${store.createTime}"/></td>
			</tr>
			
			<tr>
				<td class="tableleft">备注</td>
				<td><input type="text" id="mark" value="${store.mark}"/></td>
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
    $(function () {       
		$('#backid').click(function(){
				window.location.href="${pageContext.request.contextPath}/Store";
		 });

    });
</script>