<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册成功</title>
<link rel="stylesheet" type="text/css"
	href="css/organization_successfulpublish.css">
<link rel="stylesheet" type="text/css" href="css/header_footer.css">
</head>
<body>
	<!--content_top-->
	<div class="content_top">
		<a href="#">首页</a> / 注册成功
	</div>
	<!--content-->
	<div class="content">
		<img src="images/success.png">
		<p>${msg }</p>
		<a href="three_login.jsp"><div id="get1">登录</div></a> <a
			href="toRegister"><div id="get2">注册</div></a>
	</div>
	<!--footer-->
	<%@include file="footer.jsp"%>
</body>
</html>