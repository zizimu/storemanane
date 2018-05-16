<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>参数总览</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css"
	      href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css"
	      href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/bootstrap-responsive.css"/>
	<link rel="stylesheet" type="text/css"
	      href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/style.css"/>
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

		@media ( max-width: 980px) {
			/* Enable use of floated navbar text */
			.navbar-text.pull-right {
				float: none;
				padding-left: 5px;
				padding-right: 5px;
			}
		}
	</style>
</head>
<body>
<div style="margin-top: 5%">
<table class="table table-bordered table-hover definewidth m10">
	<thead>
	<tr>
		<th style="text-align: center">参数名</th>
		<th style="text-align: center">参数内容</th>
		<th style="text-align: center">创建时间</th>
		<th style="text-align: center">备注</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${params}" var="p" varStatus="st">
		<tr>
			<td style="text-align: center">${p.parametername}</td>
			<td style="text-align: center">${p.parametercontent}</td>
			<td style="text-align: center">${p.createtime}</td>
			<td style="text-align: center">${p.mark}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>
<div class="inline pull-right page" style="margin-top: 30px;">
	总共${page.total}条记录 第 ${page.pageNum}/${page.pages} 页
	<a href="${pageContext.request.contextPath}/param?page=${page.firstPage}">第一页</a>
	<c:choose>
		<c:when test="${!page.isFirstPage}">
			<a href="${pageContext.request.contextPath}/param?page=${page.prePage}">上一页</a>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${!page.isLastPage}">
			<a href="${pageContext.request.contextPath}/param?page=${page.nextPage}">下一页</a>
		</c:when>
	</c:choose>
	<a href="${pageContext.request.contextPath}/param?page=${page.lastPage}">最后页</a>
</div>
</body>
</html>
