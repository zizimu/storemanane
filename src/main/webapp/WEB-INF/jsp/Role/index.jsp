<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>角色管理</title>
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
	src="https://cdn-1251943624.file.myqcloud.com/layer/layer.js"></script>



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
        function del(id) {
            layer.confirm('确定要删除吗？', {
                icon: 0,
                title:'删除',
                btn: ['确定', '取消'] //按钮
            },function () {
                deleteRole(id);
            });
        };
        function deleteRole(id) {
            layer.load();
            $.ajax({
                url: "${pageContext.request.contextPath}/Role/" + id,
                type: 'DELETE',
                dataType: "json",
                async:false,
                processData: false,
                contentType: false,
                beforeSend: function () {
                    console.log("正在进行，请稍候");
                },
                success: function (responseStr) {
                    if (responseStr['stat'] == 200) {
                        layer.msg(responseStr['message'], {
                            icon:2,
                            btn: ['确定']
                        },function () {
                            location.reload();
                        });
                    } else {
                        layer.open(responseStr['message'], {
                            icon: 2,
                            btn: ['确定']
                        });
                    }
                },
                error: function (responseStr) {
                    console.log("error");
                }
            });
            layer.closeAll();
        };
	</script>
</head>
<body>
	<div class="form-inline definewidth m20">
		<a href="${pageContext.request.contextPath}/Role/add">	
			<button type="button" class="btn btn-success" id="addnew">新增角色</button>	
		</a>	
	</div>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th style="text-align: center">角色编号</th>
				<th style="text-align: center">角色名称</th>
				<th style="text-align: center">创建时间</th>
				<!-- <th style="text-align: center">备注</th> -->
				<th style="text-align: center">管理操作</th>
			</tr>
			<c:forEach items="${roleList}" var="s" varStatus="st">
				<tr>
					<td style="text-align: center">${s.roleId}</td>
					<td style="text-align: center">${s.roleName}</td>
					<td style="text-align: center">${s.createTime}</td>
					<%-- <td style="text-align: center">${s.mark}</td> --%>
					<td style="text-align: center">
						<a href="${pageContext.request.contextPath}/Role/edit/${s.roleId}">
							<button class="btn btn-primary" style="margin-left: 5px;">
								编辑
							</button>
						</a>
							<button class="btn btn-success" style="margin-left: 5px;" onclick="del(${s.roleId})">
								删除
							</button>
						</td>
					</tr>
			</c:forEach>
		</thead>
	</table>
</body>
</html>