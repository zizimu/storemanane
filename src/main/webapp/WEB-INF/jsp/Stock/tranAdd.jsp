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

	<%-- <tr>
		<td width="10%" class="tableleft">新批次</td>
		<td><input type="text" disabled value="${batchs.get(batchs.size()-1) + 1}"/>
	</tr> --%>
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
		<td class="tableleft">调货数量</td>
		<td><input type="number" min="0" max="9999" id="gstock" onblur="checkStock()"/>
			<span id="stockCheck" style="color: red; font-size: 15px;"></span></td>
	</tr>
	
	<!-- <tr>
		<td class="tableleft">调货门店</td>
		<td><input type="text" name="storeid" id="sid" value="总店" storename="8"></td>
	</tr> -->
	
	<tr>
		<td class="tableleft"></td>
		<td>
			<button id="submit" class="btn btn-primary" type="button">申请</button>&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-success" name="backid" id="backid">
				返回
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
        	 post();
			/* if(isGoodsExit>0&checkStock()&checkSoldNum()){
			    post();
			} */
        });
        /* $("#gstock").focus(function () {
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
        }) */
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
	        $("#stockCheck").text('请输入四位以内正整数！');
	    }else {
	        $("#stockCheck").text('');
	        return true;
	    }
	    return false;
    }
   
    function post() {
    	console.log("申请调货")
        var data = {
            "goodsId": $("#gname").val(),
            "goodsStock": $("#gstock").val(),
            "storeId": $("#sid").attr("storename"),
            "mark": $("#mark").val()
        };
        $.ajax({
            url: "${pageContext.request.contextPath}/Stock/transfer",
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
                    alert(responseStr['message']);
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