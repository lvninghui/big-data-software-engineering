<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑活动信息</title>
<script type="text/javascript" src="js/organization_editactivity.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/organization_editactivity.css" />
<link rel="stylesheet" type="text/css" href="css/header_footer.css" />
</head>
<body>
	<!-- header -->
	<%@include file="organization_header.jsp"%>
	<!-- content -->
	<div class="content">
		<!-- content_top -->
		<div class="content_top">
			<a href="#">首页</a> / 编辑活动信息
			<h4>编辑活动信息</h4>
			<p>为了能让同学们获得正确的活动信息，修改前请确认活动信息的准确性</p>
		</div>
		<!-- content_main -->
		<div class="content_main">
			<!-- content_main_left -->
			<div class="left">
				<form class="alignform" action="Edit" method="post">
					<input type="hidden" name="id" value="${activity.id }">
					<lable class="sign">*</lable>
					<label class="prompt">活动名称：</label> <input class="inputframe"
						type="text" name="aname" value="${activity.name }" /><br>
					<label class="promptintro"><lable class="sign">*</lable>活动简介：</label>
					<textarea class="textarea" name="adescription">${activity.description }</textarea>
					<br>
					<lable class="sign">*</lable>
					<label class="prompt">报名开始时间：</label> <input class="inputframe"
						type="date" name="applybegintime" value="${ApplyBegin}" /><br>
					<lable class="sign">*</lable>
					<label class="prompt">报名截止时间：</label> <input class="inputframe"
						type="date" name="applyendtime" value="${ApplyEnd}" /><br>
					<lable class="sign">*</lable>
					<label class="prompt">活动开始时间：</label> <input class="inputframe"
						type="date" name="holdontime" value="${HoldBegin}" /><br>
					<lable class="sign">*</lable>
					<label class="prompt">活动结束时间：</label> <input class="inputframe"
						type="date" name="holdendtime" value="${HoldEnd }" /><br>
					<lable class="sign">*</lable>
					<label class="prompt">活动举办地点：</label> <input class="inputframe"
						type="text" name="aplace" value="${activity.holdPlace }" /><br>
					<lable class="sign">*</lable>
					<label class="prompt">参与范围：</label> <select class="inputframe1" name="aparticipant">
						<c:forEach items="${college }" var="col">
						   <option value="${col.name }" <c:if test="${col.name==activity.participant}">selected</c:if>>${col.name }</option>
						</c:forEach>
					</select><br>
					<lable class="sign">*</lable>
					<label class="prompt">参赛形式：</label> <select class="inputframe1" name="astyle">
						<option>${activity.style }</option>
						<option>团队</option>
						<option>个人</option>
					</select><br>
					<lable class="sign">*</lable>
					<label class="prompt">活动级别：</label> <select class="inputframe1" name="alevel">
						<option>${activity.level }</option>
						<option>国家级</option>
						<option>省级</option>
						<option>市级</option>
						<option>校级</option>
						<option>院级</option>
					</select><br>
					<lable class="sign">*</lable>
					<label class="prompt">活动所属类别：</label> <select class="inputframe1" name="asearchtype">
						<option>${activity.searchType }</option>
						<option>志愿活动</option>
						<option>文体竞赛</option>
						<option>学术竞赛</option>
					</select><br>
					<lable class="sign">*</lable>
					<label class="prompt">测评所属类别：</label> <select class="inputframe1" name="acomprehensivetype">
						<option>${activity.comprehensiveType }</option>
						<option>品行表现</option>
						<option>学业表现</option>
						<option>能力表现</option>
					</select><br>
					<lable class="sign">*</lable>
					<label class="prompt">当前阶段</label> <select class="inputframe1" name="astage">
						<option>${Stage}</option>
						<option>单次比赛</option>
						<option>初赛</option>
						<option>复赛</option>
						<option>决赛</option>
					</select><br>
					<p class="stagemsg">（ 活动进行到下一阶段时，需在编辑活动信息页面修改活动阶段以及活动综测加分信息 ）</p>
					<lable class="sign">*</lable>
					<label class="prompt">该阶段加分：</label> <input type="button" value="+"
						class="gradebutton" onclick="addgrade()"> <input
						type="text" class="grade" name="grade" id="grade"
						value="${score }"> <input type="button" value="-"
						class="gradebutton" onclick="reducegrade()"><br>
					<div class="interview">
						<label class="interview1"><lable class="sign">*</lable>是否需要面试：</label>
						<span class="interview2">
							<input type="radio" name="interview" value="是" <c:if test="${activity.isInterview eq '是'}"> checked="checked"</c:if> />需要面试
							<input type="radio" name="interview" value="否" <c:if test="${activity.isInterview eq '否'}"> checked="checked" </c:if> /> 不需要面试
						</span>
					</div>
					<input class="publishbutton" type="submit" value="发布活动" /><br>
					<i class="icon icon-calendar"></i>
				</form>
			</div>
			<!-- content_main_right -->
			<div class="right">
				<p class="recomm">近期热门活动</p>
				<div class="act">
					<img src="images/tag.png" class="sign" /><a href="#">麦“Dream”主持人风采大赛</a>
					<hr class="hrsty" />
					<p class="intro">麦“Dream”主持人风采大赛是面向软件学院全体学生，致力于提升同学们的临场应变能力和语言表达能力并丰富大学生课余活动而产生的活动,活动分为初赛，复赛，决赛三部···</p>
					<hr class="hrsty" />
					<div class="organ">
						<a href="#">软件学院学生会</a>
					</div>
				</div>
				<div class="act">
					<img src="images/tag.png" class="sign" /><a href="#">麦“Dream”主持人风采大赛</a>
					<hr class="hrsty" />
					<p class="intro">麦“Dream”主持人风采大赛是面向软件学院全体学生，致力于提升同学们的临场应变能力和语言表达能力并丰富大学生课余活动而产生的活动,活动分为初赛，复赛，决赛三部···</p>
					<hr class="hrsty" />
					<div class="organ">
						<a href="#">软件学院学生会</a>
					</div>
				</div>
				<div class="act">
					<img src="images/tag.png" class="sign" /><a href="#">麦“Dream”主持人风采大赛</a>
					<hr class="hrsty" />
					<p class="intro">麦“Dream”主持人风采大赛是面向软件学院全体学生，致力于提升同学们的临场应变能力和语言表达能力并丰富大学生课余活动而产生的活动,活动分为初赛，复赛，决赛三部···</p>
					<hr class="hrsty" />
					<div class="organ">
						<a href="#">软件学院学生会</a>
					</div>
				</div>
				<div class="act">
					<img src="images/tag.png" class="sign" /><a href="#">麦“Dream”主持人风采大赛</a>
					<hr class="hrsty" />
					<p class="intro">麦“Dream”主持人风采大赛是面向软件学院全体学生，致力于提升同学们的临场应变能力和语言表达能力并丰富大学生课余活动而产生的活动,活动分为初赛，复赛，决赛三部···</p>
					<hr class="hrsty" />
					<div class="organ">
						<a href="#">软件学院学生会</a>
					</div>
				</div>
				<button class="moreact">更多热门活动···</button>
			</div>
		</div>
	</div>
	<!-- footer -->
	<%@include file="footer.jsp"%>
</body>
</html>