<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta contentType="text/html;charset=UTF-8" pageEncoding="UTF-8">
	<title>出错啦！</title>
	<style type="text/css">
		#area-a {
			position: absolute;
			left: 30%;
			top: 164px;
			height: 128px;
			width: 480px;
			font-weight: bold;
			background-color: #fff;
			padding: 16px;
			border-left: 2px solid #ff9101;
			width: 480px
		}

		#area-a h1 {
			height: 96px;
			font-size: 96px;
			line-height: 96px;
			margin-right: 8px;
			margin-top: 10px;
			color: #333;
			text-shadow: 0 0 1px rgba(51, 51, 51, 0.5);
		}

		.l {
			float: left;
		}

		#area-a h1 span {
			color: #ff9101;
			text-shadow: 0 0 1px rgba(255, 145, 1, 0.5);
		}

		#area-a .a {
			color: #ccc;
			height: 24px;
			font-size: 24px;
			line-height: 24px;
			text-shadow: 0 0 1px rgba(204, 204, 204, 0.5);
			margin-top: 12px;
		}

		#area-a .b {
			color: #333;
			height: 32px;
			font-size: 32px;
			line-height: 32px;
			text-shadow: 0 0 1px rgba(51, 51, 51, 0.5);
			margin-top: 8px;
		}

		#area-b {
			position: absolute;
			left: 30%;
			top: 340px;
			width: 480px;
			background-color: #fff;
			padding: 16px;
			border-left: 2px solid #08c;
			float: left;
		}

		.icon {
			display: inline-block;
			font: normal normal normal 14px/1 FontAwesome;
			font-size: inherit;
			text-rendering: auto;
			-webkit-font-smoothing: antialiased;
		}

		#area-b p {
			color: #08c;
			font-size: 24px;
			font-weight: bold;
			text-shadow: 0 0 1px rgba(0, 136, 204, 0.5);
			text-align: left;
		}

		#area-b ul {
			margin: 16px 0 0 8px;
			font-size: 14px;
			line-height: 1.6;
			list-style: square inside;
			color: #333;
			text-shadow: 0 0 1px rgba(51, 51, 51, 0.2);
		}

		li {
			display: list-item;
			text-align: left;
		}

		.icon-info-circle:before {
			content: \f05a;
		}

		a {
			color: #369;
			white-space: normal;
			word-break: break-all;
			cursor: pointer;
		}

		#mainer-inner {
			height: 590px;
			margin-top: 184px;
		}
	</style>
</head>
<body>
<table style="height: 600px;">
	<tr>
		<td align="center" valign="middle">
			<div id="area-a">
				<h1 class="l">4<span>0</span>4</h1>
				<div class="l">
					<p class="a">Not Found</p>
					<p class="b">未找到访问页面</p>
				</div>
				<span class="clearfix"></span>
			</div>
			<div id="area-b">
				<p>
					<i class="icon icon-info-circle"></i>该错误可能由于如下原因所致
				</p>
				<ul>
					<li>页面已失效</li>
					<li>页面已被修改或删除</li>
				</ul>
			</div>
			<span class="clearfix"></span>
		</td>
	</tr>
</table>
</body>
</html>