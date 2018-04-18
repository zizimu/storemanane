<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/style.css" />
    <script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/jquery.js"></script>
    <script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/bootstrap.js"></script>
    <script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/ckform.js"></script>
    <script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/common.js"></script>
    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
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
            $("#pic").change(function () {
                //获取文件对象，files是文件选取控件的属性，存储的是文件选取控件选取的文件对象，类型是一个数组
                var formData = new FormData();
                formData.append("file", $("#pic")[0].files[0]);
                $.ajax({
                    url: "${pageContext.request.contextPath}/upload",
                    type: 'POST',
                    dataType: "json",
                    data: formData,
                    processData: false,
                    contentType: false,
                    beforeSend: function () {
                        console.log("正在进行，请稍候");
                    },
                    success: function (responseStr) {
                        if (responseStr['stat'] == 200) {
                            $("#picUrl").attr("src", responseStr["url"]);
                            $("#gpic").val(responseStr["url"]);
                        } else {
                            alert(responseStr['message'])
                        }
                    },
                    error: function () {
                        console.log("error");
                    }
                });
            });
            $("#submit").click(function () {
                var data = {
                    "goodsId":${goods.goodsId},
                    "goodsName" : $("#goodsName").val(),
                    "goodsPrice": $("#goodsPrice").val(),
                    "goodsType": $("#goodsType").val(),
                    "goodsBrand": $("#goodsBrand").val(),
	                "goodsPic":$("#gpic").val(),
                    "goodsSpc": $("#gspc").val(),
                    "goodsCreateTime": $("#gcreateTime").val(),
                    "goodsShelfilfe": $("#gshelfilfe").val(),
                    "mark": $("#mark").val()
                };
                $.ajax({
                    url: "${pageContext.request.contextPath}/Goods/"+${goods.goodsId},
                    type: 'PUT',
                    dataType: "json",
                    data: JSON.stringify(data),
                    contentType: 'application/json;charset=UTF-8',
                    beforeSend: function () {
                        console.log("正在进行，请稍候");
                    },
                    success: function (responseStr) {
                        if (responseStr['stat'] == 200) {
                            window.location.href="${pageContext.request.contextPath}/Goods";
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
<table class="table table-bordered table-hover ">
   <tr>
		<td width="10%" class="tableleft">商品名称</td>
		<td><input type="text" id="goodsName" name="goodsName" value="${goods.goodsName}"/></td>
	</tr>
	<tr>
		<td class="tableleft">价格</td>
		<td><input type="text" id="goodsPrice" name="goodsPrice" value="${goods.goodsPrice}"/></td>
	</tr>
	<tr>
		<td class="tableleft">类型</td>
		<td><select type="text" id="goodsType" name="goodsType" style="width: 210px;">
				<c:forEach items="${types}" var="p">
					<option value="${p.typeId}">${p.typeName}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td class="tableleft">品牌</td>
		<td><select type="text" id="goodsBrand" name="goodsBrand" style="width: 210px;">
				<c:forEach items="${brands}" var="p">
					<option value="${p.brandId}">${p.brandName}</option>
				</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td class="tableleft">图片</td>
		<td><input type="file" id="pic" name="pic" multiple="multiple"/></td>
	</tr>
	<tr>
		<td class="tableleft">预览</td>
		<td>
			<img id="picUrl" src="${goods.goodsPic}" onerror="this.src='https://1213-1251943624.cos.ap-shanghai.myqcloud.com/default/no_pic.jpg'"
			     style="margin-left: 10px;width: 150px;height: 150px;"/>
			<input type="hidden" id="gpic" value="${goods.goodsPic}">
		</td>
	</tr>
	<tr>
		<td class="tableleft">规格</td>
		<td><input type="text" id="gspc" name="gspc" value="${goods.goodsSpc}"/></td>
	</tr>
	<tr>
		<td class="tableleft">生产日期</td>
		<td><input type="text" id="gcreateTime" name="gcreatedate" value="${goods.goodsCreatedate}"/></td>
	</tr>
	<tr>
		<td class="tableleft">保质期</td>
		<td><input type="text" id="gshelfilfe" name="gshelflife" value="${goods.goodsShelflife}"/></td>
	</tr>
	<tr>
		<td class="tableleft">备注</td>
		<td><input type="text" id="mark" name="mark" value="${goods.mark}"/></td>
	</tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button id="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
	        <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="${pageContext.request.contextPath}/Goods";
		 });
        var selBrand="${goods.goodsBrand}";
        $("#goodsBrand").find("option[value="+selBrand+"]").attr("selected",true);
        var selType="${goods.goodsType}";
        $("#goodsType").find("option[value="+selType+"]").attr("selected",true);
    });
</script>