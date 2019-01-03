<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发布活动</title>
<script type="text/javascript" src="js/organization_publishactivity.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/organization_publishactivity.css" />
<link rel="stylesheet" type="text/css" href="css/header_footer.css" />
</head>
<body>
	<!-- header -->
	<%@include file="organization_header.jsp"%>
	<!-- content -->
	<div class="content">
		<!-- content_top -->
		<div class="content_top">
			<a href="#">首页</a> / 发布活动
			<h4>发布活动</h4>
			<p>
				<为保证活动信息的准确性 ，请仔细填写以下内容>
			</p>
		</div>
		<!-- content_main -->
		<div class="content_main">
			<!-- content_main_left -->
			<div class="left">
				<form class="alignform" action="saveActivity" method="post"
					enctype="multipart/form-data">
					<lable class="sign">*</lable>
					<label class="prompt">添加活动海报：</label>
					<lable class="addimg"> <%@include file="image_upload.jsp"%>
					</lable>
					<!-- <lable class="sign">*</lable>
						<label class="prompt">添加活动海报：</label>
				    <lable class="addimg">  <input type="file" name="img"
						class="upimg" /></lable> 
						 -->
					<br/>
					<lable class="sign">*</lable>
					<label class="prompt">活动名称：</label> <input class="inputframe"
						type="text" name="name" placeholder="请输入活动名称" /><br> <label
						class="promptintro"><lable class="sign">*</lable>活动简介：</label>
					<textarea class="textarea" placeholder="请输入活动介绍信息"
						name="description"></textarea>
					<br>
					<lable class="sign">*</lable>
					<label class="prompt">报名开始时间：</label> <input class="inputframe"
						type="date" name="applyBegin" value="2018-01-01" /><br>
					<lable class="sign">*</lable>
					<label class="prompt">报名截止时间：</label> <input class="inputframe"
						type="date" name="applyEnd" value="2018-01-01" /><br>
					<lable class="sign">*</lable>
					<label class="prompt">活动开始时间：</label> <input class="inputframe"
						type="date" name="holdBegin" value="2018-01-01" /><br>
					<lable class="sign">*</lable>
					<label class="prompt">活动结束时间：</label> <input class="inputframe"
						type="date" name="holdEnd" value="2018-01-01" /><br>
					<lable class="sign">*</lable>
					<label class="prompt">活动举办地点：</label> <input class="inputframe"
						type="text" name="holdPlace" placeholder="请输入活动举办地点" /><br>
					<lable class="sign">*</lable>
					<label class="prompt">参与范围：</label> <select class="inputframe1"
						name="participant">
						<option><-请选择活动面向对象范围-></option>
						<option>河北师范大学</option>
						<option>软件学院</option>
						<option>美术与设计学院</option>
						<option>数学与信息技术学院</option>
						<option>音乐学院</option>
					</select><br>
					<lable class="sign">*</lable>
					<label class="prompt">参赛形式：</label> <select class="inputframe1"
						name="style">
						<option><-请选择活动参赛形式-></option>
						<option>团队</option>
						<option>个人</option>
					</select><br>
					<lable class="sign">*</lable>
					<label class="prompt">活动级别：</label> <select class="inputframe1"
						name="level">
						<option><-请选择活动级别-></option>
						<option>国家级</option>
						<option>省级</option>
						<option>市级</option>
						<option>校级</option>
						<option>院级</option>
					</select><br>
					<lable class="sign">*</lable>
					<label class="prompt">活动所属类别：</label> <select class="inputframe1"
						name="searchType">
						<option><-请选择用于展示的活动所属类别-></option>
						<option>志愿活动</option>
						<option>文体竞赛</option>
						<option>学术竞赛</option>
					</select><br>
					<lable class="sign">*</lable>
					<label class="prompt">测评所属类别：</label> <select class="inputframe1"
						name="comprehensiveType">
						<option><-请选择用于综合测评的活动所属类别-></option>
						<option>品行表现</option>
						<option>学业表现</option>
						<option>能力表现</option>
					</select><br>
					<lable class="sign">*</lable>
					<label class="prompt">当前阶段</label> <select class="inputframe1"
						name="stage">
						<option><-请填写当前活动阶段-></option>
						<option name="stage">单次比赛</option>
						<option name="stage">初赛</option>
						<option name="stage">复赛</option>
						<option name="stage">决赛</option>
					</select><br>
					<p class="stagemsg">（ 活动进行到下一阶段时，需在编辑活动信息页面修改活动阶段以及活动综测加分信息 ）</p>
					<lable class="sign">*</lable>
					<label class="prompt">该阶段加分：</label> <input type="button" value="+"
						class="gradebutton" onclick="addgrade()"> <input
						type="text" class="grade" name="score" id="grade" value="1">
					<input type="button" value="-" class="gradebutton"
						onclick="reducegrade()"><br>
					<div class="interview">
						<label class="interview1"><lable class="sign">*</lable>是否需要面试：</label>
						<span class="interview2"><input type="radio"
							name="isInterview" value="是"> 需要面试 <input type="radio"
							name="isInterview" value="否"> 不需要面试</span>
					</div>
					<input class="publishbutton" type="submit" value="发布活动" /><br>
					<i class="icon icon-calendar"></i>
				</form>
			</div>
			<!-- content_main_right -->
			<div class="right">
				<p class="recomm">近期热门活动</p>
				<c:forEach var="activity" items="${hotActivities}">
					<div class="act">
						<img src="images/tag.png" class="sign" /><a href="#">${activity[0]}</a>
						<hr class="hrsty" />
						<p class="intro">${activity[1]}</p>
						<hr class="hrsty" />
						<div class="organ">
							<a href="#">${activity[2].name}</a>
						</div>
					</div>
				</c:forEach>
				<button class="moreact">更多热门活动···</button>
			</div>
		</div>
	</div>
	<!-- footer -->
	<%@include file="footer.jsp"%>
</body>
</html>