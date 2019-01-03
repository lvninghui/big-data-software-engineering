<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>报名活动成功</title>
	<link rel="stylesheet" type="text/css" href="css/organization_successfulpublish.css">
	<link rel="stylesheet" type="text/css" href="css/header_footer.css">
</head>
<body>
	<!--header-->
	<%@include file="organization_header.jsp"%>
	<div class="content">
		 <img src="images/404.png"> 
		<!-- 报名失败 -->
		<p>报名失败！<a href="activitydetail?actid=${activityId}">点我重新报名</a></p>
	</div>
	<!--footer-->
		<%@include file="footer.jsp"%>
</body>
<script type="text/javascript" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</html>