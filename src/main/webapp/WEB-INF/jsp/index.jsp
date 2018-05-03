<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
	<link rel="shortcut icon"
	      href="https://1213-1251943624.cos.ap-shanghai.myqcloud.com/default/R.ico" type="image/x-icon"/>
	<title>后台管理系统</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link href="https://cdn-1251943624.file.myqcloud.com/storeManage/assets/css/dpl-min.css" rel="stylesheet"
	      type="text/css"/>
	<link href="https://cdn-1251943624.file.myqcloud.com/storeManage/assets/css/bui-min.css" rel="stylesheet"
	      type="text/css"/>
	<link href="https://cdn-1251943624.file.myqcloud.com/storeManage/assets/css/main-min.css" rel="stylesheet"
	      type="text/css"/>
	<style type="text/css">
		a {
			text-decoration: none;
			color: white;
		}

		.img-item {
			float: left;
			margin-left: 10px;
		}

		.img-head {
			width: 40px;
			height: 40px;
		}
	</style>
</head>
<body>
<div class="header">
	<div class="dl-title">
		<img src="https://cdn-1251943624.file.myqcloud.com/storeManage/assets/img/top.png">
	</div>
	<div class="dl-log">
		<div class="img-item">
			<a href="${pageContext.request.contextPath}/index">
				<img class="img-head"
				     src="https://cdn-1251943624.file.myqcloud.com/storeManage/Images/actionIcons_016.png">
				<br>刷&nbsp;新
			</a>
		</div>
		<%--<div class="img-item">
			<a href="${pageContext.request.contextPath}/person">
				<img class="img-head"
				     src="https://cdn-1251943624.file.myqcloud.com/storeManage/Images/actionIcons_014.png">
				<br>个人信息
			</a>
		</div>--%>
		<div class="img-item">
			<a href="${pageContext.request.contextPath}/logout">
				<img class="img-head"
				     src="https://cdn-1251943624.file.myqcloud.com/storeManage/Images/actionIcons_014.png">
				<br>退&nbsp;出
			</a>
		</div>
	</div>
</div>

<div class="content">
	<div class="dl-main-nav">
		<div class="dl-inform">
			<div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div>
		</div>
		<ul id="J_Nav" class="nav-list ks-clear">
			<li class="nav-item dl-selected">
				<div class="nav-item-inner nav-home">系统管理</div>
			</li>
			<li class="nav-item dl-selected">
				<div class="nav-item-inner nav-order">业务管理</div>
			</li>
		</ul>
	</div>
	<ul id="J_NavContent" class="dl-tab-conten">
	</ul>
</div>
<script type="text/javascript"
        src="https://cdn-1251943624.file.myqcloud.com/storeManage/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/assets/js/bui-min.js"></script>
<script type="text/javascript"
        src="https://cdn-1251943624.file.myqcloud.com/storeManage/assets/js/common/main-min.js"></script>
<script type="text/javascript"
        src="https://cdn-1251943624.file.myqcloud.com/storeManage/assets/js/config-min.js"></script>
<script>
    BUI.use('common/main', function () {
        var config = [{
            id: '1', homePage: 'person', menu: [{
                text: '系统管理', items: [
                    {id: '10', text: '账号信息', href: 'person'},
                    {id: '11', text: '账号审核', href: 'person'},]
            }, {
                text: '商品管理', items: [
                    {id: '12', text: '商品管理', href: 'Goods'},
                    {id: '13', text: '品牌管理', href: 'Brand'},
                    {id: '14', text: '商品类型', href: 'Type'},]
            }, {
                text: '门店管理', items: [
                    {id: '15', text: '库存管理', href: 'Stock'},
                    {id: '17', text: '销售管理', href: 'Order'},
                    {id: '16', text: '员工管理', href: 'Staff'},]
            }]
        },
            {
                id: '9', menu: [
                    {   text: '系统管理', items: [
                            {id: '12', text: '管理参数', href: 'person'},]
                    },
                    {   text: '业务管理', items: [
                        {id: '21', text: '管理门店', href: 'Store'},
                        {id: '22', text: '管理活动', href: 'Activity'},
                        {id: '23', text: '管理角色', href: 'Role'}]
                    }]
            }];
        new PageUtil.MainPage({
            modulesConfig: config
        });
    });
</script>
<div style="text-align:center;">
</div>
</body>
</html>