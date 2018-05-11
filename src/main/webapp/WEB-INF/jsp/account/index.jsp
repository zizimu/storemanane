<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>账号总览</title>
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
	<script type="text/javascript">
		/*TODO 测试layer弹窗控件 已知bug：在confirm框下不会跳alert框*/
        function del(id) {
            layer.confirm('确定要删除吗？', {
                icon: 0,
	            title:'删除',
                btn: ['确定', '取消'] //按钮
            },function () {
                deleteGoods(id);
            });
        };
        function deleteGoods(id) {
            layer.load();
            $.ajax({
                url: "${pageContext.request.contextPath}/Goods/" + id,
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
<table class="table table-bordered table-hover definewidth m10">
	<thead>
	<tr>
		<th style="text-align: center">登陆名</th>
		<th style="text-align: center">手机</th>
		<th style="text-align: center">通讯地址</th>
		<th style="text-align: center">类型</th>
		<th style="text-align: center">所属门店</th>
		<th style="text-align: center">备注</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${goodsList}" var="p" varStatus="st">
		<tr>
			<td style="text-align: center">${p.goodsId}</td>
			<td style="text-align: center">${p.goodsName}</td>
			<td style="text-align: right">￥${p.goodsPrice}</td>
			<td style="text-align: center">${types[p.goodsType]}</td>
			<td style="text-align: center">${brands[p.goodsBrand]}</td>
			<td style="text-align: right">${p.goodsSpc}${units[p.goodsType]}</td>
			<td style="text-align: center">${p.goodsCreatedate}</td>
			<td style="text-align: right">${p.goodsShelflife}年</td>
			<td style="text-align: center">
				<a href="${pageContext.request.contextPath}/Goods/edit/${p.goodsId}">
					<button class="btn btn-primary" style="margin-left: 5px;">
						编辑
					</button>
				</a>
				<button class="btn btn-success" style="margin-left: 5px;" onclick="del(${p.goodsId})">
					删除
				</button>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<div class="inline pull-right page">
	总共${page.total}条记录 第 ${page.pageNum}/${page.pages} 页
	<c:choose>
		<c:when test="${wd!=null}">
			<a href="${pageContext.request.contextPath}/Goods/s?wd=${wd}&page=${page.firstPage}">第一页</a>
			<c:choose>
				<c:when test="${!page.isFirstPage}">
					<a href="${pageContext.request.contextPath}/Goods/s?wd=${wd}&page=${page.prePage}">上一页</a>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!page.isLastPage}">
					<a href="${pageContext.request.contextPath}/Goods/s?wd=${wd}&page=${page.nextPage}">下一页</a>
				</c:when>
			</c:choose>
			<a href="${pageContext.request.contextPath}/Goods/s?wd=${wd}&page=${page.lastPage}">最后页</a>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/Goods?page=${page.firstPage}">第一页</a>
			<c:choose>
				<c:when test="${!page.isFirstPage}">
					<a href="${pageContext.request.contextPath}/Goods?page=${page.prePage}">上一页</a>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!page.isLastPage}">
					<a href="${pageContext.request.contextPath}/Goods?page=${page.nextPage}">下一页</a>
				</c:when>
			</c:choose>
			<a href="${pageContext.request.contextPath}/Goods?page=${page.lastPage}">最后页</a>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>
