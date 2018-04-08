<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="https://cdn-1251943624.file.myqcloud.com/storeManage/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="https://cdn-1251943624.file.myqcloud.com/storeManage/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="https://cdn-1251943624.file.myqcloud.com/storeManage/assets/css/main-min.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        a{
            text-decoration: none;
            color: white;
        }
        .img-item{
            float: left;
            margin-left: 10px;
        }
        .img-head{
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
            <a href="#">
            <img class="img-head" src="https://cdn-1251943624.file.myqcloud.com/storeManage/Images/actionIcons_013.png">
            <br>主&nbsp;页
            </a>
        </div>
        <div class="img-item">
            <a href="#">
            <img class="img-head" src="https://cdn-1251943624.file.myqcloud.com/storeManage/Images/actionIcons_014.png" >
            <br>个人信息
            </a>
        </div>

        <div class="img-item">
            <a href="#">
            <img class="img-head" src="https://cdn-1251943624.file.myqcloud.com/storeManage/Images/actionIcons_016.png" >
            <br>退&nbsp;出
            </a>
        </div>
    </div>
</div>

<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">系统管理</div></li>		<li class="nav-item dl-selected"><div class="nav-item-inner nav-order">业务管理</div></li>

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/assets/js/bui-min.js"></script>
<script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="https://cdn-1251943624.file.myqcloud.com/storeManage/assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [{id:'1',menu:[{text:'系统管理',items:[{id:'12',text:'商品管理',href:'Node/index.html'},{id:'3',text:'库存管理',href:'Role/index.html'},{id:'4',text:'用户管理',href:'User/index.html'},{id:'6',text:'销售管理',href:'Menu/index.html'}]}]},{id:'7',homePage : '9',menu:[{text:'业务管理',items:[{id:'9',text:'查询业务',href:'Node/index.html'}]}]}];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
<div style="text-align:center;">
</div>
</body>
</html>