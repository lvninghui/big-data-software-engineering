<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<title>组织者页面_首页</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<link rel="stylesheet" type="text/css" href="css/index.css" media="all">
<link rel="stylesheet" type="text/css" href="css/header_footer.css"
	media="all">

</head>
<body>

	<%@include file="organization_header.jsp"%>
	<div class="content">
		<div id="scrollPics">
			<ul class="slider">
				<li><img src="images/1.jpg" /></li>
				<li><img src="images/2.jpg" /></li>
				<li><img src="images/3.jpg" /></li>
			</ul>
			<ul class="num"></ul>
		</div>
		<div class="introduce">
			<div id="info">
				<span id="info_text">
					<p>“小蚂蚁”是河北师范大学最权威的校园活动展现和统计平台，以收集与记录校园活动为主要目标。</p>
					<p>
						一、收集河北师范大学各组织发起的各项校园活动展现和统计，以帮助河北师范大学在校生便捷地了解各项精彩活动，便于组织推广活动并提高各项活动的参与度。</p>
					<p>二、记录各项活动的参与情况，在各学年评奖评优之际，工作人员能够方便、准确地在平台中获取评选数据，并得出准确的评选结果。</p>
				</span>
			</div>
			<img src="images/baby.jpg" id="pic_baby">
		</div>
	</div>
	<%@include file="footer.jsp"%>


</body>
<script type="text/javascript"
	src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</html>