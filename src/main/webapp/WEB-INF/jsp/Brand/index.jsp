<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
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
                url: "${pageContext.request.contextPath}/Brand/" + id,
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
<form class="form-inline definewidth m20" action="${pageContext.request.contextPath}/Brand/s"
      method="get">
	品牌编号/名称： <input type="text" name="wd" id="wd" class="abc input-default" placeholder="品牌编号/名称：">&nbsp;&nbsp;
	<button type="submit" class="btn btn-primary">查询</button>
	&nbsp;&nbsp;
	<button type="button" class="btn btn-success" id="addnew">新增品牌</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
	<thead>
	<tr>
		<th style="text-align: center">品牌编号</th>
		<th style="text-align: center">品牌名称</th>
		<th style="text-align: center">创建日期</th>
		<th style="text-align: center">备注</th>
		<th style="text-align: center">管理操作</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${brandsList}" var="p" varStatus="st">
		<tr>
			<td style="text-align: center">${p.brandId}</td>
			<td style="text-align: center">${p.brandName}</td>
			<td style="text-align: center">${p.createTime}</td>
			<td style="text-align: center">${p.mark}</td>
			<td style="text-align: center">
				<a href="${pageContext.request.contextPath}/Brand/edit/${p.brandId}">
					<button class="btn btn-primary" style="margin-left: 5px;">
						编辑
					</button>
				</a>
				<button class="btn btn-success" style="margin-left: 5px;" onclick="del(${p.brandId})">
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
			<a href="${pageContext.request.contextPath}/Brand/s?wd=${wd}&page=${page.firstPage}">第一页</a>
			<c:choose>
				<c:when test="${!page.isFirstPage}">
					<a href="${pageContext.request.contextPath}/Brand/s?wd=${wd}&page=${page.prePage}">上一页</a>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!page.isLastPage}">
					<a href="${pageContext.request.contextPath}/Brand/s?wd=${wd}&page=${page.nextPage}">下一页</a>
				</c:when>
			</c:choose>
			<a href="${pageContext.request.contextPath}/Brand/s?wd=${wd}&page=${page.lastPage}">最后页</a>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/Brand?page=${page.firstPage}">第一页</a>
			<c:choose>
				<c:when test="${!page.isFirstPage}">
					<a href="${pageContext.request.contextPath}/Brand?page=${page.prePage}">上一页</a>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!page.isLastPage}">
					<a href="${pageContext.request.contextPath}/Brand?page=${page.nextPage}">下一页</a>
				</c:when>
			</c:choose>
			<a href="${pageContext.request.contextPath}/Brand?page=${page.lastPage}">最后页</a>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>
<script>
    $(function () {
        $('#addnew').click(function () {
            window.location.href = "${pageContext.request.contextPath}/Brand/add";
        });
    });
</script>