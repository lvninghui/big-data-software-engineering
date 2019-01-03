<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>活动分类</title>
<link rel="stylesheet" type="text/css"
	href="css/student_activityclassify.css">

</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/JsonpAjax.js"></script>
<body>
	<!-- header -->
	<%@include file="student_header.jsp"%>
	<!--type-->
	<div class="assembly">
		<div class="breadcrumb">
			<a href="student_index.jsp" class="toplink">首页</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a
				href="beforeSearch?pageNo=1" id="orange" class="currentpage">活动</a>
		</div>
		<div id="search">
			<form action="searchByName" method="get">
				<input type="text" placeholder="请输入您要搜索的活动关键字" class="text"
					autocomplete="off" name="name">
				<button type="submit">搜&nbsp;&nbsp;索</button>
			</form>
		</div>
		<div class="label">分&nbsp;类</div>
	</div>
	<%@include file="student_activityclassify_ul.jsp"%>
	<script type="text/javascript" src="js/student_activityclassify_ul.js"></script>

	<!--center-->
	<div class="activities_conter">
		<div class="activities">
			<c:forEach var="activity" items="${activities}">
				<%-- 	<c:forEach var="c" items="${popcake}"> --%>
				<div class="activity_object">
					<a href="activitydetail?actid=${activity[0]}"><img
						src="${activity[2]}"></a>
					<ul>
						<li><a href="activitydetail?actid=${activity[0]}">${activity[1]}</a></li>
						<li><p id="grey">${activity[3]}</p></li>
						<li id="grey">报名人数:${activity[4]}</li>
					</ul>
				</div>
			</c:forEach>
		</div>
		<div class="clear"></div>
		<!--  <a class="nextPage" href="#"> 下一页</a> -->
		<div class="page">

			<div class="lastPage">
				<c:if test="${pageNo>1}">
					<a href="beforeSearch?pageNo=${pageNo-1}">上一页</a>
				</c:if>
			</div>
			<div class="pageNo">
				<c:if test="${pageNo!=null}">
					<span>${pageNo}</span>/<span>${pageNum}</span>
				</c:if>
			</div>
			<div class="nextPage">
				<c:if test="${pageNo<pageNum}">
					<a href="beforeSearch?pageNo=${pageNo+1}">下一页</a>
				</c:if>
			</div>

		</div>
	</div>

	<!--footer-->
	<%@include file="footer.jsp"%>

</body>

</html>