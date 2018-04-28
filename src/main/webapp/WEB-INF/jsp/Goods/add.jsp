<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>添加商品</title>
	<meta charset="UTF-8" http-equiv="Content-Type" content="multipart/form-data; charset=utf-8">
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
	<script type="text/javascript"
	        src="https://cdn-1251943624.file.myqcloud.com/storeManage/Js/jquery.form.min.js"></script>
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
	<script type="text/javascript">
        $(function () {
            $("#pic").change(function () {
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
                            alert(responseStr['message']);
                        }
                    },
                    error: function (responseStr) {
                        console.log("error");
                    }
                });
            });
            $("#submit").click(function () {
                if (checkName() & checkPrice() & checkDate() & checkShelfLife() & checkSpc()) {
                    post();
                }
            });
            $("#gname").focus(function () {
                $("#nameCheck").text('');
            });
            $("#gprice").focus(function () {
                $("#priceCheck").text("");
            });
            $("#gspc").focus(function () {
                $("#unitsCheck").text("");
            });
            $("#gcreateTime").focus(function () {
                $("#dateCheck").text('');
            });
            $("#gshelfilfe").focus(function () {
                $("#shelflifeCheck").text("");
            });
        });
        function checkName() {
            var name = $("#gname").val();
            if (name !== null && name !== "") {
                $("#nameCheck").text(""); return true;
            } else {
                $("#nameCheck").text("请输入商品名称!");
            }
            return false;
        };
        function checkPrice() {
            var reg = /^(0|([1-9]\d{0,6}(\.\d{1,2})?))$/;
            var price = $("#gprice").val();
            if (price == null || price == "") {
                $("#priceCheck").text("请输入价格!");
            } else if(!reg.test(price)) {
                $("#priceCheck").text("金额不正确!");
            }else{
                $("#priceCheck").text(""); return true;
	        }
            return false;
        };
        function checkSpc() {
            var reg = /^[1-9]\d{1,4}$/;
            var spc = $("#gspc").val();
            if (spc == null || spc == "") {
                $("#unitsCheck").text('请输入规格!');
            }else if(!reg.test(spc)){
                $("#unitsCheck").text('格式不正确!');
            }else {
                $("#unitsCheck").text(""); return true;
            }
            return false;
        };
        function checkDate() {
            var date = new Date($("#gcreateTime").val());
            var today = new Date();
            if(date==null || date=='Invalid Date'){
                $("#dateCheck").text('请选择日期！');
            } else if(date > today) {
                $("#dateCheck").text('生产日期不能超过今天！');
            } else {
                $("#dateCheck").text(''); return true;
            }
            return false;
        };
        function checkShelfLife() {
            var reg = /^[1-9]\d?$/;
            var shelfLife = $("#gshelfilfe").val();
            if (shelfLife == null || shelfLife == "") {
                $("#shelflifeCheck").text('请输入!');
            }else if(!reg.test(shelfLife)){
                $("#shelflifeCheck").text('格式不正确!');
            } else {
                $("#shelflifeCheck").text("");
                return true;
            }
            return false;
        };
        function post() {
            var data = {
                "goodsName": $("#gname").val(),
                "goodsPrice": $("#gprice").val(),
                "goodsType": $("#gtype").val(),
                "goodsBrand": $("#gbrand").val(),
                "goodsSpc": $("#gspc").val(),
                "goodsPic": $("#gpic").val(),
                "goodsCreatedate": $("#gcreateTime").val(),
                "goodsShelfilfe": $("#gshelfilfe").val(),
                "mark": $("#mark").val()
            };
            $.ajax({
                url: "${pageContext.request.contextPath}/Goods",
                type: 'POST',
                dataType: "json",
                data: JSON.stringify(data),
                contentType: 'application/json;charset=UTF-8',
                beforeSend: function () {
                    console.log("正在进行，请稍候");
                },
                success: function (responseStr) {
                    if (responseStr['stat'] == 200) {
                        window.location.href = "${pageContext.request.contextPath}/Goods";
                    } else {
                        alert(responseStr['message']);
                    }
                },
                error: function () {
                    console.log("error!");
                }
            })
        };
	</script>
</head>
<table class="table table-bordered table-hover definewidth m10">
	<tr>
		<td width="10%" class="tableleft">商品名称</td>
		<td><input type="text" id="gname" onblur="checkName()"/>
			<span id="nameCheck" style="color: red; font-size: 15px;"></span></td>
	</tr>
	<tr>
		<td class="tableleft">价格</td>
		<td><input type="number" maxlength="9" onblur="checkPrice()" step="0.01" max="999999.99" min="0" id="gprice"/>
			<span id="priceCheck" style="color: red; font-size: 15px;"></span></td>
	</tr>
	<tr>
		<td class="tableleft">类型</td>
		<td><select type="text" id="gtype">
			<c:forEach items="${types}" var="p">
				<option value="${p.typeId}">${p.typeName}</option>
			</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td class="tableleft">品牌</td>
		<td><select type="text" id="gbrand">
			<c:forEach items="${brands}" var="p">
				<option value="${p.brandId}">${p.brandName}</option>
			</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td class="tableleft">图片</td>
		<td><input type="file" id="pic" multiple="multiple"/></td>
	</tr>
	<tr>
		<td class="tableleft">预览</td>
		<td>
			<img id="picUrl" src="https://1213-1251943624.cos.ap-shanghai.myqcloud.com/default/no_pic.jpg"
			     style="margin-left: 10px;width: 150px;height: 150px;"/>
			<input type="hidden" id="gpic"/>
		</td>
	</tr>
	<tr>
		<td class="tableleft">规格</td>
		<td><input type="tel" maxlength="5" id="gspc" onblur="checkSpc()"/>
			<span id="units" style="margin-left: 3px;font-size: 15px;"></span>
			<span id="unitsCheck" style="color: red; font-size: 15px;"></span></td>
	</tr>
	<tr>
		<td class="tableleft">生产日期</td>
		<td><input type="date" value="" id="gcreateTime" onblur="checkDate()"/>
			<span id="dateCheck" style="color: red; font-size: 15px;"></span></td>
	</tr>
	<tr>
		<td class="tableleft">保质期</td>
		<td><input type="text" maxlength="2" value="1" id="gshelfilfe" onblur="checkShelfLife()"/>
			<span id="shelflifeCheck" style="color: red; font-size: 15px;"></span></td>
	</tr>
	<tr>
		<td class="tableleft">备注</td>
		<td><input type="text" id="mark"/></td>
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
        $('#backid').click(function () {
            window.location.href = "${pageContext.request.contextPath}/Goods";
        });
        var units = {};
        <c:forEach items="${units}" var="p">units['${p.key}'] = '${p.value}';
        </c:forEach>
        setUnits(getFirstAttr(units));
        $("#gtype").change(function () {
            var index = $("#gtype option:selected").val();
            setUnits(units[index]);
        });
    });
    function getFirstAttr(obj) {
        for (var k in obj) return obj[k];
    };
    function setUnits(str) {
        $("#gspc").attr('placeholder', str);
        $("#units").text(str);
    };
</script>