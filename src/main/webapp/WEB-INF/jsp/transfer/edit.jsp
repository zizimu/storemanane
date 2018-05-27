<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>修改调货信息</title>
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
</head>
<body>
<table class="table table-bordered table-hover definewidth m10">
	 <tr>
        <td class="tableleft">商品来源</td>
        <td>
        <select id="sid" style="width: 210px;">
			<c:forEach items="${stores}" var="p">
				<option value="${p.storeId}">${p.storeName}</option>
			</c:forEach>
		</select>
            <%-- <input id="sfromid" value="${stores[transfer.storeFromId]}"/> --%>
        </td>
    </tr>
     <tr>
        <td class="tableleft">商品去向</td>
        <td>
            <input id="stoid" readonly="true" value="${transfer.toStore.storeName}" storeid="${transfer.toStore.storeId }"/>
        </td>
    </tr>
    <tr>
        <td class="tableleft">商品名称</td>
        <td>
            <input id="gname" readonly="true" value="${transfer.goods.goodsName}" pid="${transfer.goods.goodsId }"/>
        </td>
    </tr>
    <tr>
        <td class="tableleft">商品数量</td>
        <td><input type="number" id="goodsNum"  value="${transfer.goods_num}"/>
            <span id="stockCheck" style="color: red; font-size: 15px;"></span></td>
    </tr>
   
   <%--  <tr>
        <td class="tableleft">所属门店</td>
        <td><select id="sid" style="width: 210px;">
	        <c:forEach items="${stores}" var="p">
		        <option value="${p.key}">${p.value}</option>
	        </c:forEach>
        </select></td>
    </tr> --%>
    <!-- <tr>
        <td class="tableleft">备注</td>
        <td><input type="text" id="mark" value=""/></td>
    </tr> -->
    <tr>
        <td class="tableleft"></td>
        <td>
            <button id="submit" class="btn btn-primary" type="button">调货</button>&nbsp;&nbsp;
            <button type="button" class="btn btn-success" name="backid" id="backid">
                返回列表
            </button>
        </td>
    </tr>
</table>
</body>
</html>
<script>
    $(function () {
		$('#backid').click(function(){
            window.location.href="${pageContext.request.contextPath}/transfer/listAllTransfer";
        });
        $("#submit").click(function () {
        	put();
        })
           /*  if(checkNum()){
                put();
            } */
        });  
        function checkNum() {
    		var reg = /^[0-9]\d{0,4}$/;
    		var num = $("#goodsNum").val();
    		if (num == null || num == "") {
    			$("#numCheck").text("请输入商品数量！");
    		} else if (!reg.test(num)) {
    			$("#numCheck").text('请输入四位以内非负数！');
    		} else {
    			$("#numCheck").text('');
    			return true;
    		}
    		return false;
    	}
    function put() {
    	var transfer_id="${transfer.transfer_id}";
    	console.log(transfer_id)
        var data = {
            "transfer_id": transfer_id,
            "store_fromid": $("#sid").val(),
            "store_toid":$("#stoid").attr("storeid"),
            "goods_id":$("#gname").attr("pid"),
            "goods_num": $("#goodsNum").val(),
        };
        $.ajax({
            url: "${pageContext.request.contextPath}/transfer/checkTransfer",
            type: 'PUT',
            dataType: "json",
            data: JSON.stringify(data),
            contentType: 'application/json;charset=UTF-8',
            beforeSend: function () {
                console.log("正在进行，请稍候");
            },
            success: function (responseStr) {
                if (responseStr['stat'] == 200) {
                    window.location.href = "${pageContext.request.contextPath}/transfer/listAllTransfer";
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