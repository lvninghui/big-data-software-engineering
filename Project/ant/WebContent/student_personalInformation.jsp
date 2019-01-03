<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>个人页面_个人信息</title>
<link rel="stylesheet" type="text/css" href="css/header_footer.css">
<link rel="stylesheet" type="text/css"
	href="css/student_personalInformation.css">
	<script src="js/jquery.min.js"></script>
<script src="js/jquery.Jcrop.min.js"></script>
<link rel="stylesheet" href="css/jquery.Jcrop.css" type="text/css" />
	
</head>
<body>
	<div class="wrapper">
		<!-- 页头 -->
		<%@include file="student_header.jsp"%>
		<!-- 主要部分 -->
		<div class="main">
			<!-- 上部分 -->
			<div class="top_set">
				<div class="top_nav">
					<a href="#">首页</a>/ <span>设置</span>
				</div>
			</div>
			<!-- 下部分 -->
			<div class="bottom_set">
				<!-- 下左部分 -->
				<div class="bottom_left">
					<div class="bottom_left_detail">
						<!-- <!-- 头像 -->
						<!-- <div class="photo">
							<image src="images/01.jpg">
						</div>
					 <div class="btn">
								<a href="student_index.jsp">更换头像</a>
							</div> -->
							<%@include file="photo_update.jsp"%>
						<div class="welcome">
							<p>Welcome,</p>
							<p>${s.name }</p>
						</div>
						<div class="activity">
							<div class="activity_word">
								<span>已报名的活动数</span>
							</div>
							<div class="activity_num">
								<span>56</span>
							</div>
						</div>
						<div class="sumbtn">
							<div class="btn selected">
								<a href="setInformation.jsp">更改信息</a>
							</div>
							<div class="btn">
								<a href="setPsd.jsp">更改密码</a>
							</div>
						</div>
					</div>
				</div>
				<!-- 下右部分 -->
				<div class="bottom_right">
					<div class="nav">
						<span>个人信息</span>
					</div>
					<div class="clear"></div>
					<div class="bottom_right_detail">
						<form action="saveSinformation" method="post">
							<table>
								<tr class="tr">
									<td class="td1">姓名:</td>
									<td class="td2"><input type="text" value="${s.name }" name="sname"></td>
								</tr>
								<tr class="tr">
									<td class="td1">学号:</td>
									<td class="td2"><input type="text" value="${s.id }"></td>
								</tr>
								<tr class="tr">
									<td class="td1">邮箱:</td>
									<td class="td2"><input type="text" value="${s.email }" name="semail"></td>
								</tr>
								<tr class="tr">
									<td class="td1">学院:</td>
									<td class="td2"><select>
										<option value="apple">${s.classInfo.profession.college.name}</option>
										<c:forEach items="${college }" var="onecollege">
											<option value="banana" class="">${onecollege.name}</option>
										</c:forEach>
									</select></td>
								</tr>
								<tr class="tr">
									<td class="td1">专业: <%--
									${s.classInfo.profession.college.professions} --%>
									</td>
									<td class="td2"><select name="sprofession">
										<option value="${s.classInfo.profession.name}" name="sprofession">${s.classInfo.profession.name}</option>
<%-- 										<c:forEach items="${s.classInfo.profession.college.professions}" var="oneprofession"> --%>
<%-- 											<option value="banana">${oneprofession.name }</option> --%>
<%-- 										</c:forEach> --%>
											<c:forEach items="${profession}" var="oneprofession">
												<option value="${oneprofession.id }">${oneprofession.name }</option>
											</c:forEach>
									</select></td>
								</tr>
								<tr class="tr">
									<td class="td1">年级:</td>
									<td class="td2"><select name="sgrade">
											<option value="${s.classInfo.grade}">${s.classInfo.grade}级</option>
											<c:forEach var="i" begin="2015" end="2018">
												<option value="${i}"><c:out value="${i}级"></c:out>
												</option>
											</c:forEach>
									</select></td>
								</tr>
								<tr class="tr">
									<td class="td1">班级:</td>
									<td class="td2"><select name="sclass">
										<option value="${s.classInfo.classNo}">${s.classInfo.classNo}</option>
										<c:forEach var="i" begin="1" end="8">
											<option value="${i}"><c:out value="${i}"></c:out>
											</option>
										</c:forEach>
									</select></td>
								</tr>
							</table>
							<div class="content_submit">
								<input type="submit" name="submit" value="保&nbsp&nbsp存" class="button">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<!-- 页尾 -->
		<%@include file="footer.jsp"%>
	</div>
</body>
<script type="text/javascript"
	src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</html>