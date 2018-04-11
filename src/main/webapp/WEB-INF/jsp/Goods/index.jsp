<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>商品总览</title>
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
	function deleteGoods(id) {
		$.ajax({
			url:"",
		})
    }
</script>
</head>
<body>
	<form class="form-inline definewidth m20" action="index.html"
		method="get">
		商品名称： <input type="text" name="rolename" id="rolename"
			class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">新增商品</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th style="text-align: center">商品编号</th>
				<th style="text-align: center">商品名称</th>
				<th style="text-align: center">价格</th>
				<th style="text-align: center">类型</th>
				<th style="text-align: center">品牌</th>
				<th style="text-align: center">规格</th>
				<th style="text-align: center">生产日期</th>
				<th style="text-align: center">保质期</th>
				<th style="text-align: center">管理操作</th>
			</tr>
				<c:forEach items="${goodsList}" var="p" varStatus="st">
					<tr>
						<td style="text-align: center">${p.gid}</td>
						<td style="text-align: center">${p.gname}</td>
						<td style="text-align: right">￥${p.gprice}</td>
						<td style="text-align: center">${p.gtype}</td>
						<td style="text-align: center">${p.gbrand}</td>
						<td style="text-align: right">${p.gspc}ml</td>
						<td style="text-align: center">${p.gcreatedate}</td>
						<td style="text-align: right">${p.gshelflife}年</td>
						<td style="text-align: center">
							<a href="edit.html?id=${p.gid}">
								<button class="btn btn-primary" style="margin-left: 5px;">
									编辑
								</button>
							</a>
							<button class="btn btn-success" style="margin-left: 5px;" onclick="deleteGoods(${p.gid})">
								删除
							</button>
						</td>
					</tr>
				</c:forEach>
		</thead>
	</table>
	<div class="inline pull-right page">
		总共${page.total} 条记录 ${page.pageNum}/${page.pages} 页
		<a href="${pageContext.request.contextPath}/Goods/index?page=${page.firstPage}">第一页</a>
		<a href="${pageContext.request.contextPath}/Goods/index?page=${page.nextPage}">下一页</a>
		<a href="${pageContext.request.contextPath}/Goods/index?page=${page.prePage}">上一页</a>
		<a href="${pageContext.request.contextPath}/Goods/index?page=${page.lastPage}">最后页</a>
	</div>
</body>
</html>
<script>
	$(function() {

		$('#addnew').click(function() {

			window.location.href = "add.html";
		});

	});

	function del(id) {

		if (confirm("确定要删除吗？")) {

			var url = "index.html";

			window.location.href = url;

		}

	}
</script>