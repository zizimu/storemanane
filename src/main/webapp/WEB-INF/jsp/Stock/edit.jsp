<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
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
</head>
<body>
<table class="table table-bordered table-hover definewidth m10">
   <%--  <tr>
        <td width="10%" class="tableleft">批次</td>
        <td>
            <input id="batchId" readOnly="true" value="第${stock.batchId}批次"/>
        </td>
    </tr> --%>
    <tr>
        <td class="tableleft">商品名称</td>
        <td>
            <input id="gname" readonly="true" value="${goods[stock.goodsId]}"/>
        </td>
    </tr>
    <tr>
        <td class="tableleft">库存</td>
        <td><input type="number" id="gstock" onblur="checkStock()" value="${stock.goodsStock}"/>
            <span id="stockCheck" style="color: red; font-size: 15px;"></span></td>
    </tr>
   <%--  <tr>
        <td class="tableleft">已售数量</td>
        <td><input type="number" id="gsold" onblur="checkSoldNum()" value="${stock.goodsSold}"/>
            <span id="soldCheck" style="color: red; font-size: 15px;"></span></td>
    </tr> --%>
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
        <td><input type="text" id="mark" value="${stock.mark}"/></td>
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
<script>
    $(function () {
		$('#backid').click(function(){
            window.location.href="${pageContext.request.contextPath}/Stock";
        });
        $("#submit").click(function () {
            if(checkStock()){
                put();
            }
        });
        $("#gstock").focus(function () {
            $("#stockCheck").text('');
        });
        /* $("#gsold").focus(function () {
            $("#soldCheck").text('');
        }); */
        var sel="${stock.storeId}";
        $("#sid").find("option[value="+sel+"]").attr("selected",true);
    });
    function checkStock() {
        var reg =/^[1-9]\d{0,4}$/;
        var stock = $("#gstock").val();
        if(stock==null||stock==""){
            $("#stockCheck").text("请输入库存数！");
        }else if(!reg.test(stock)&&stock!=0){
            $("#stockCheck").text('请输入0或六位以内正整数！');
        }else {
            $("#stockCheck").text('');
            return true;
        }
        return false;
    }
  /*   function checkSoldNum() {
        var reg =/^[1-9]\d{0,4}$/;
        var stock = $("#gsold").val();
        if(stock==null||stock==""){
            $("#soldCheck").text("请输入已售数量！");
        }else if(!reg.test(stock)&&stock!=0){
            $("#soldCheck").text('请输入0或六位以内正整数！');
        }else {
            $("#soldCheck").text('');
            return true;
        }
        return false;
    } */
    function put() {
        var data = {
            "batchId": ${stock.batchId},
            "goodsId": ${stock.goodsId},
            "goodsStock": $("#gstock").val(),
          /*   "goodsSold": $("#gsold").val(), */
            "storeId": $("#sid").val(),
            "mark": $("#mark").val()
        };
        $.ajax({
            url: "${pageContext.request.contextPath}/Stock",
            type: 'PUT',
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