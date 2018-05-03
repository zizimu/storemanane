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
    <script type="text/javascript">
        $(function () {
            $("#submit").click(function () {
                if(checkName()&checkUnits()){
                    put();
                }
            });
            $("#TypeName").focus(function () {
                $("#namecheck").text('');
            })
        });
        function checkName() {
            var name = $("#TypeName").val();
            if(name == null || name ==""){
                $("#namecheck").text("请输入名称!");
            }else{
                $("#namecheck").text('');
                return true;
            }
            return false;
        };
        function checkUnits() {
            var name = $("#units").val();
            if(name == null || name ==""){
                $("#unitsCheck").text("请输入规格名!");
            }else{
                $("#unitsCheck").text('');
                return true;
            }
            return false;
        };
        function put() {
            var data = {
                "typeId":${type.typeId},
                "typeName" : $("#TypeName").val(),
	            "units":$("#units").val(),
                "mark": $("#mark").val()
            };
            $.ajax({
                url: "${pageContext.request.contextPath}/Type/"+${type.typeId},
                type: 'PUT',
                dataType: "json",
                data: JSON.stringify(data),
                contentType: 'application/json;charset=UTF-8',
                beforeSend: function () {
                    console.log("正在进行，请稍候");
                },
                success: function (responseStr) {
                    if (responseStr['stat'] == 200) {
                        window.location.href="${pageContext.request.contextPath}/Type";
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
</head>
<body>
<input type="hidden" name="id" value="" />
<table class="table table-bordered table-hover ">
	<tr>
		<td width="10%" class="tableleft">类型名称</td>
		<td><input type="text" id="TypeName" value="${type.typeName}"/>
			<span id="namecheck" style="color: red; font-size: 15px;"></span></td>
	</tr>
	<tr>
		<td width="10%" class="tableleft">规格</td>
		<td><input type="text" id="units" value="${type.units}"/>
			<span id="unitscheck" style="color: red; font-size: 15px;"></span></td>
	</tr>
	<tr>
		<td class="tableleft">备注</td>
		<td><input type="text" id="mark" value="${type.mark}"/></td>
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
				window.location.href="${pageContext.request.contextPath}/Type";
		 });

    });
</script>