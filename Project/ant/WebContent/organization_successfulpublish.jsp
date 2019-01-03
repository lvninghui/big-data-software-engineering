<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>组织者页面_成功发布</title>
<link rel="stylesheet" type="text/css"
	href="css/organization_successfulpublish.css">
<link rel="stylesheet" type="text/css" href="css/header_footer.css">
</head>
<body>
	<!--header-->
	<%@include file="organization_header.jsp"%>
	<!--content_top-->
	<div class="content_top">
		<a href="#">首页</a> / 成功发布活动
	</div>
	<!--content-->
	<div class="content">
		<img src="images/success.png">
		<p>活动已成功发布，在活动详情页可以查看活动的报名情况，去将活动链接发送给同学们来提高活动的参与量吧~</p>
		<a href="#"><div id="get1">查看活动详情</div></a> <a href="#"><div
				id="get2">复制活动链接</div></a>
	</div>
	<!--footer-->
	<%@include file="footer.jsp"%>
</body>
<script type="text/javascript"
	src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</html>