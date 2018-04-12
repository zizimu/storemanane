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
<form action="index.html" method="post" class="definewidth m20">
<input type="hidden" name="id" value="" />
<table class="table table-bordered table-hover ">
   <tr>
		<td width="10%" class="tableleft">商品名称</td>
		<td><input type="text" id="gname" name="gname"/></td>
	</tr>
	<tr>
		<td class="tableleft">价格</td>
		<td><input type="text" id="gprice" name="gprice"/></td>
	</tr>
	<tr>
		<td class="tableleft">类型</td>
		<td><input type="text" id="gtype" name="gtype"/></td>
	</tr>
	<tr>
		<td class="tableleft">品牌</td>
		<td><input type="text" id="gbrand" name="gbrand"/></td>
	</tr>
	<tr>
		<td class="tableleft">图片</td>
		<td><input type="file" id="pic" name="pic" multiple="multiple"/></td>
	</tr>
	<tr>
		<td class="tableleft">预览</td>
		<td>
			<img id="picUrl" src="https://1213-1251943624.cos.ap-shanghai.myqcloud.com/default/no_pic.jpg"
			     style="margin-left: 10px;width: 150px;height: 150px;"/>
			<input type="hidden" id="picurl">
		</td>
	</tr>
	<tr>
		<td class="tableleft">规格</td>
		<td><input type="text" id="gspc" name="gspc"/></td>
	</tr>
	<tr>
		<td class="tableleft">生产日期</td>
		<td><input type="text" id="gcreateTime" name="gcreatedate"/></td>
	</tr>
	<tr>
		<td class="tableleft">保质期</td>
		<td><input type="text" id="gshelfilfe" name="gshelflife"/></td>
	</tr>
	<tr>
		<td class="tableleft">备注</td>
		<td><input type="text" id="mark" name="mark"/></td>
	</tr>
	<tr>
		<td class="tableleft">状态</td>
		<td>
			<input type="radio" name="status" value="1" checked/> 启用
			<input type="radio" name="status" value="0"/> 禁用
		</td>
	</tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="index.html";
		 });

    });
</script>