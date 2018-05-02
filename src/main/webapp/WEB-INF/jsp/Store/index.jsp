<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>门店管理</title>
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
	function del(id){
		/* layer.confirm('确定要删除吗？',{
			icon:0,
			title:'删除',
			btn:['确定','取消']
		},function(){
			deleteStore(id);
		}); */
		deleteStore(id);
	};
	function deleteStore(id){
	/* layer.load(); 控件的加载框 */
	$.ajax({
		url:"${pageContext.request.contextPath}/Store/" + id,
		type:'DELETE',
		dataType:"json",
		async:false,/* 同步 */
		processData:false,/* 不处理传到后台的数据 */
		contentType:false,/* http协议传输的抬头；后台根据设置文件类型 （html，json） */
		beforeSend:function(){
			console.log("正在进行，请稍后")
		},
		success:function(responseStr){
			/* if(responseStr['stat'] == 200){ 
				 layer.msg(responseStr['message'],{
					icon:2,
					btn:['确定']
				}) */
				alert(responseStr['message'],function(){
					title:'313'
				});
			}
		});
	};
</script>
</head>
<body>
	<form class="form-inline definewidth m20"
		action="${pageContext.request.contextPath}/Store/s" method="get">
		门店编号/所属省份： <input type="text" name="wd" id="wd"
			class="abc input-default" placeholder="门店编号/所属省份" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/Store/add">
			<button type="button" class="btn btn-success" id="addnew">新增门店</button>
		</a>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th style="text-align: center">门店编号</th>
				<th style="text-align: center">门店名称</th>
				<th style="text-align: center">所属省份</th>
				<th style="text-align: center">详细地址</th>
				<th style="text-align: center">店长</th>
				<th style="text-align: center">联系方式</th>
				<th style="text-align: center">注册时间</th>
				<th style="text-align: center">备注</th>
				<th style="text-align: center">管理操作</th>
			</tr>
			<c:forEach items="${storeList}" var="s" varStatus="st">
				<tr>
					<td style="text-align: center">${s.storeId}</td>
					<td style="text-align: center">${s.storeName}</td>
					<td style="text-align: center">${s.storeArea}</td>
					<td style="text-align: center">${s.storeAddress}</td>
					<td style="text-align: center">${s.storeManager}</td>
					<td style="text-align: center">${s.staffPhone}</td>
					<td style="text-align: center">${s.createTime}</td>
					<td style="text-align: center">${s.mark}</td>
					<td style="text-align: center">
						<a href="${pageContext.request.contextPath}/Store/edit/${s.storeId}">
							<button class="btn btn-primary" style="margin-left: 5px;">
								编辑
							</button>
						</a>
							<button class="btn btn-success" style="margin-left: 5px;" onclick="del(${s.storeId})">
								删除
							</button>
						</td>
					</tr>
			</c:forEach>
		</thead>
	</table>
<div class="inline pull-right page">
	总共${page.total}条记录 第 ${page.pageNum}/${page.pages} 页
	<c:choose>
		<c:when test="${wd!=null}">
			<a href="${pageContext.request.contextPath}/Store/s?wd=${wd}&page=${page.firstPage}">第一页</a>
			<c:choose>
				<c:when test="${!page.isFirstPage}">
					<a href="${pageContext.request.contextPath}/Store/s?wd=${wd}&page=${page.prePage}">上一页</a>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!page.isLastPage}">
					<a href="${pageContext.request.contextPath}/Store/s?wd=${wd}&page=${page.nextPage}">下一页</a>
				</c:when>
			</c:choose>
			<a href="${pageContext.request.contextPath}/Store/s?wd=${wd}&page=${page.lastPage}">最后页</a>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/Store?page=${page.firstPage}">第一页</a>
			<c:choose>
				<c:when test="${!page.isFirstPage}">
					<a href="${pageContext.request.contextPath}/Store?page=${page.prePage}">上一页</a>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!page.isLastPage}">
					<a href="${pageContext.request.contextPath}/Store?page=${page.nextPage}">下一页</a>
				</c:when>
			</c:choose>
			<a href="${pageContext.request.contextPath}/Store?page=${page.lastPage}">最后页</a>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>