<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>员工信息</title>
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
			deleteStaff(id);
		}); */
		deleteStaff(id);
	};
	function deleteStaff(id){
	/* layer.load(); 控件的加载框 */
	$.ajax({
		url:"${pageContext.request.contextPath}/Staff/" + id,
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
		action="${pageContext.request.contextPath}/Staff/s" method="get">
		员工编号/名称： <input type="text" name="wd" id="wd"
			class="abc input-default" placeholder="员工编号/名称" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/Staff/add">
			<button type="button" class="btn btn-success" id="addnew">新增员工</button>
		</a>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th style="text-align: center">员工编号</th>
				<th style="text-align: center">员工姓名</th>
				<th style="text-align: center">联系电话</th>
				<th style="text-align: center">所属门店</th>
				<th style="text-align: center">入职时间</th>
				<th style="text-align: center">角色</th>
				<th style="text-align: center">创建时间</th>
				<th style="text-align: center">备注</th>
				<th style="text-align: center">管理操作</th>
			</tr>
			<c:forEach items="${staffList}" var="s" varStatus="st">
				<tr>
					<td style="text-align: center">${s.staffId}</td>
					<td style="text-align: center">${s.staffName}</td>
					<td style="text-align: center">${s.staffPhone}</td>
					<td style="text-align: center">${s.storeId}</td>
					<td style="text-align: center">${s.entryTime}</td>
					<td style="text-align: center">${s.role}</td>
					<td style="text-align: center">${s.createTime}</td>
					<td style="text-align: center">${s.mark}</td>
					<td style="text-align: center">
						<a href="${pageContext.request.contextPath}/Staff/edit/${s.staffId}">
							<button class="btn btn-primary" style="margin-left: 5px;">
								编辑
							</button>
						</a>
							<button class="btn btn-success" style="margin-left: 5px;" onclick="del(${s.staffId})">
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
			<a href="${pageContext.request.contextPath}/Staff/s?wd=${wd}&page=${page.firstPage}">第一页</a>
			<c:choose>
				<c:when test="${!page.isFirstPage}">
					<a href="${pageContext.request.contextPath}/Staff/s?wd=${wd}&page=${page.prePage}">上一页</a>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!page.isLastPage}">
					<a href="${pageContext.request.contextPath}/Staff/s?wd=${wd}&page=${page.nextPage}">下一页</a>
				</c:when>
			</c:choose>
			<a href="${pageContext.request.contextPath}/Staff/s?wd=${wd}&page=${page.lastPage}">最后页</a>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/Staff?page=${page.firstPage}">第一页</a>
			<c:choose>
				<c:when test="${!page.isFirstPage}">
					<a href="${pageContext.request.contextPath}/Staff?page=${page.prePage}">上一页</a>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!page.isLastPage}">
					<a href="${pageContext.request.contextPath}/Staff?page=${page.nextPage}">下一页</a>
				</c:when>
			</c:choose>
			<a href="${pageContext.request.contextPath}/Staff?page=${page.lastPage}">最后页</a>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>