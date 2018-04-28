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
	<link rel="stylesheet" type="text/css" href="https://cdn-1251943624.file.myqcloud.com/storeManage/Css/style.css"/>
	<script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/jquery.js"></script>
	<script type="text/javascript"
	        src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/jquery.sorted.js"></script>
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
			.navbar-text.pull-right {
				float: none;
				padding-left: 5px;
				padding-right: 5px;
			}
		}
	</style>
</head>
<table class="table table-bordered table-hover definewidth m10">
	<tr>
		<td width="10%" class="tableleft">批次</td>
		<td>
			<select id="batchId" style="width: 210px;">
				<c:forEach items="${batchs}" var="p">
					<option value="${p}">第${p}批次</option>
				</c:forEach>
				<option value="${batchs.get(batchs.size()-1) + 1}">新批次</option>
			</select>
		</td>
	</tr>
	<tr>
		<td class="tableleft">商品名称</td>
		<td>
			<select id="gname" style="width: 210px;">
				<c:forEach items="${goods}" var="p">
					<option value="${p.goodsId}">${p.goodsName}</option>
				</c:forEach>
			</select>
			<span id="goodsCheck" style="color: red; font-size: 15px;"></span>
		</td>
	</tr>
	<tr>
		<td class="tableleft">库存</td>
		<td><input type="number" min="0" max="99999" id="gstock" onblur="checkStock()"/>
			<span id="stockCheck" style="color: red; font-size: 15px;"></span></td>
	</tr>
	<tr>
		<td class="tableleft">已售数量</td>
		<td><input type="number" min="0" maxlength="5" id="gsold" onblur="checkSoldNum()"/>
			<span id="soldCheck" style="color: red; font-size: 15px;"></span></td>
	</tr>
	<tr>
		<td class="tableleft">所属门店</td>
		<td><select id="sid" style="width: 210px;">
			<c:forEach items="${stores}" var="p">
				<option value="${p.key}">${p.value}</option>
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td class="tableleft">备注</td>
		<td><input type="text" id="mark"/>
	</tr>
	<tr>
		<td class="tableleft"></td>
		<td>
			<button id="submit" class="btn btn-primary" type="button">保存</button>&nbsp;&nbsp;
			<button type="button" class="btn btn-success" name="backid" id="backid">
				返回列表
			</button>
		</td>
	</tr>
</table>
</body>
</html>
<script type="text/javascript">
	var isGoodsExit = 0;
    $(function () {
        $('#backid').click(function () {
            window.location.href = "${pageContext.request.contextPath}/Stock";
        });
        $("#submit").click(function () {
			if(isGoodsExit>0&checkStock()&checkSoldNum()){
			    post();
			}
        });
        $("#gstock").focus(function () {
	        $("#stockCheck").text('');
        });
        $("#gsold").focus(function () {
            $("#soldCheck").text('');
        });
        $("#gname").change(function () {
            checkGoods();
        });
        $("#batchId").change(function () {
	        checkGoods();
        })
    });
    function checkGoods() {
        var data = {
            "batchID": $("#batchId").val(),
            "goodsID": $("#gname").val()
        };
        $.ajax({
            url: "${pageContext.request.contextPath}/Stock/check",
            type: 'GET',
            dataType: "json",
            data: data,
            contentType: false,
            success: function (responseStr) {
                if (responseStr['stat'] == 200) {
                    $("#goodsCheck").text('');
                    isGoodsExit = 1;
                } else {
                    $("#goodsCheck").text(responseStr['message']);
                    isGoodsExit = 0;
                }
            },
	        error:function () {
                $("#goodsCheck").text('网络错误！');
            }
        })
    }
    function checkStock() {
	    var reg =/^[1-9]\d{0,4}$/;
	    var stock = $("#gstock").val();
	    if(stock==null||stock==""){
	        $("#stockCheck").text("请输入库存数！");
	    }else if(!reg.test(stock)){
	        $("#stockCheck").text('请输入六位以内正整数！');
	    }else {
	        $("#stockCheck").text('');
	        return true;
	    }
	    return false;
    }
    function checkSoldNum() {
        var reg =/^[1-9]\d{0,4}$/;
        var stock = $("#gsold").val();
        if(stock==null||stock==""){
            $("#soldCheck").text("请输入已售数量！");
        }else if(!reg.test(stock)){
            $("#soldCheck").text('请输入六位以内正整数！');
        }else {
            $("#soldCheck").text('');
            return true;
        }
        return false;
    }
    function post() {
        var data = {
            "batchId": $("#batchId").val(),
            "goodsId": $("#gname").val(),
            "goodsStock": $("#gstock").val(),
            "goodsSold": $("#gsold").val(),
            "storeId": $("#sid").val(),
            "mark": $("#mark").val()
        };
        $.ajax({
            url: "${pageContext.request.contextPath}/Stock",
            type: 'POST',
            dataType: "json",
            data: JSON.stringify(data),
            contentType: 'application/json;charset=UTF-8',
            beforeSend: function () {
                console.log("正在进行，请稍候");
            },
            success: function (responseStr) {
                if (responseStr['stat'] == 200) {
                    window.location.href = "${pageContext.request.contextPath}/Stock";
                } else {
                    alert(responseStr['message']);
                }
            },
            error: function () {
                console.log("error!");
            }
        })
    }
</script>