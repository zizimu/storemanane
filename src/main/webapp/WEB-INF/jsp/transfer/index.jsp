<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>调货管理</title>
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
                title: '删除',
                btn: ['确定', '取消'] //按钮
            }, function () {
                deleteByID(id);
            });
        };
        function deleteByID(id) {
            layer.load();
            $.ajax({
                url: "${pageContext.request.contextPath}/transfer/deleteTransfer/" + id,
                type: 'DELETE',
                dataType: "json",
                async: false,
                processData: false,
                contentType: false,
                beforeSend: function () {
                    console.log("正在进行，请稍候");
                },
                success: function (responseStr) {
                    if (responseStr['stat'] == 200) {
                        layer.msg(responseStr['message'], {
                            icon: 2,
                            btn: ['确定']
                        }, function () {
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
<form class="form-inline definewidth m20" action="${pageContext.request.contextPath}/transfer/s"
      method="get">
	来源及去向： <input type="text" name="wd" id="wd" class="abc input-default" placeholder="商品来源门店：">&nbsp;&nbsp;
	&nbsp;&nbsp;
	 <input type="text" name="wd" id="wd" class="abc input-default" placeholder="商品去向门店：">&nbsp;&nbsp;
	<button type="submit" class="btn btn-primary">查询</button>
	&nbsp;&nbsp;
	<button type="button" class="btn btn-success" id="addnew">新增调货</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
	<thead>
	<tr>
		<th style="text-align: center">编号</th>
		<th style="text-align: center">商品来源</th>
		<th style="text-align: center">商品去向</th>
		<th style="text-align: center">商品名称</th>
		<th style="text-align: center">商品数量</th>
		<th style="text-align: center">创建时间</th>
		<th style="text-align: center">状态</th>
		<th style="text-align: center">管理操作</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${transferList}" var="p" varStatus="st">
		<tr>
			<td style="text-align: center">${p.transfer_id}</td>
			<td style="text-align: center">${p.store.storeName}</td>
			<td style="text-align: center">${p.toStore.storeName}</td>
			<td style="text-align: center">${p.goods.goodsName}</td>
			<td style="text-align: center">${p.goods_num}</td>
			<td style="text-align: center">${p.createtime}</td>
			<td style="text-align: center">
			<c:if test="${p.status==1 }">待审核</c:if>
			<c:if test="${p.status==2 }">通过</c:if>
			<c:if test="${p.status==3 }">不通过</c:if>
			</td>
			<td style="text-align: center">
				<a href="${pageContext.request.contextPath}/transfer/edit/${p.transfer_id}">
					<button class="btn btn-primary" style="margin-left: 5px;">
						审核
					</button>
				</a>
				<button class="btn btn-success" style="margin-left: 5px;" onclick="del(${p.transfer_id})">
					不通过
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
			<a href="${pageContext.request.contextPath}/Type/s?wd=${wd}&page=${page.firstPage}">第一页</a>
			<c:choose>
				<c:when test="${!page.isFirstPage}">
					<a href="${pageContext.request.contextPath}/transfer/s?wd=${wd}&page=${page.prePage}">上一页</a>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!page.isLastPage}">
					<a href="${pageContext.request.contextPath}/transfer/s?wd=${wd}&page=${page.nextPage}">下一页</a>
				</c:when>
			</c:choose>
			<a href="${pageContext.request.contextPath}/transfer/s?wd=${wd}&page=${page.lastPage}">最后页</a>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/transfer?page=${page.firstPage}">第一页</a>
			<c:choose>
				<c:when test="${!page.isFirstPage}">
					<a href="${pageContext.request.contextPath}/transfer?page=${page.prePage}">上一页</a>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!page.isLastPage}">
					<a href="${pageContext.request.contextPath}/transfer?page=${page.nextPage}">下一页</a>
				</c:when>
			</c:choose>
			<a href="${pageContext.request.contextPath}/transfer?page=${page.lastPage}">最后页</a>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>
<script>
    $(function () {
        $('#addnew').click(function () {
            window.location.href = "${pageContext.request.contextPath}/transfer/add";
        });
    });
</script>