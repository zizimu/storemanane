<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>库存管理</title>
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
        function del(batchid,goodsid) {
            layer.confirm('确定要删除吗？', {
                icon: 0,
                title:'删除',
                btn: ['确定', '取消'] //按钮
            },function () {
                deleteGoods(batchid,goodsid);
            });
        };
        function deleteGoods(batchid,goodsid) {
            layer.load();
            $.ajax({
                url: "${pageContext.request.contextPath}/Stock",
                type: 'DELETE',
                dataType: "json",
                processData: false,
	            data:{
                    "batchId":batchid,
		            "goodsId":goodsid
	            },
                contentType: 'application/json;charset=UTF-8',
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
<form class="form-inline definewidth m20" action="${pageContext.request.contextPath}/Stock/s"
      method="get">
	批次/商品编号： <input type="text" name="wd" id="wd" class="abc input-default" placeholder="批次/商品编号：">&nbsp;&nbsp;
	<button type="submit" class="btn btn-primary">查询</button>
	&nbsp;&nbsp;
	<button type="button" class="btn btn-success" id="addnew">库存新增</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
	<thead>
	<tr>
		<th style="text-align: center">库存批次</th>
		<th style="text-align: center">商品编号</th>
		<th style="text-align: center">库存数量</th>
		<th style="text-align: center">已售数量</th>
		<th style="text-align: center">所属门店</th>
		<th style="text-align: center">进货时间</th>
		<th style="text-align: center">备注</th>
		<th style="text-align: center">管理操作</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${stocksList}" var="p" varStatus="st">
		<tr>
			<td style="text-align: center">${p.batchId}</td>
			<td style="text-align: center">${goods[p.goodsId]}</td>
			<td style="text-align: center">${p.goodsStock}</td>
			<td style="text-align: center">${p.goodsSold}</td>
			<td style="text-align: center">${p.storeId}</td>
			<td style="text-align: center">${p.createTime}</td>
			<td style="text-align: center">${p.mark}</td>
			<td style="text-align: center">
				<a href="${pageContext.request.contextPath}/Stock/edit?batchId=${p.batchId}&goodsId=${p.goodsId}">
					<button class="btn btn-primary" style="margin-left: 5px;">
						编辑
					</button>
				</a>
				<button class="btn btn-success" style="margin-left: 5px;" onclick="del(${p.batchId},${p.goodsId})">
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
			<a href="${pageContext.request.contextPath}/Stock/s?wd=${wd}&page=${page.firstPage}">第一页</a>
			<c:choose>
				<c:when test="${!page.isFirstPage}">
					<a href="${pageContext.request.contextPath}/Stock/s?wd=${wd}&page=${page.prePage}">上一页</a>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!page.isLastPage}">
					<a href="${pageContext.request.contextPath}/Stock/s?wd=${wd}&page=${page.nextPage}">下一页</a>
				</c:when>
			</c:choose>
			<a href="${pageContext.request.contextPath}/Stock/s?wd=${wd}&page=${page.lastPage}">最后页</a>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/Stock?page=${page.firstPage}">第一页</a>
			<c:choose>
				<c:when test="${!page.isFirstPage}">
					<a href="${pageContext.request.contextPath}/Stock?page=${page.prePage}">上一页</a>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!page.isLastPage}">
					<a href="${pageContext.request.contextPath}/Stock?page=${page.nextPage}">下一页</a>
				</c:when>
			</c:choose>
			<a href="${pageContext.request.contextPath}/Stock?page=${page.lastPage}">最后页</a>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>
<script>
    $(function () {
        $('#addnew').click(function () {
            window.location.href = "${pageContext.request.contextPath}/Stock/add";
        });
    });
</script>