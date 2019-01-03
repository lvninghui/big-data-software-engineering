<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>个人页面_完善信息</title>
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="css/header_footer.css">
<link rel="stylesheet" type="text/css" href="css/three_register.css">
<script type="text/javascript" src="js/three_register.js"></script>
</head>
<body>
    <script type="text/javascript" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
    <div class="wrapper">
        <div class="logo"><img src="images/logo2.png"></div>
        <div class="msg">
            <span>激活成功，为了统计您的活动参与情况，请完善您的信息
            </span>
        </div>
        <div class="article">
            <div class="reg">
                <form action="afterPerfectInformation">
                	<input type="hidden" name="email" value="${email }">
                    <div class="admitp">
                		<p id="admitStudentPerfect" name="admitStudentPerfect">${admitStudentPerfect }</p>
                	</div>  
                    <div class="select_college">
                        <select id="college" name="college">
                            <option value="0">学院</option>
                            <c:forEach items="${college }" var="col">
						        <option value="${col.name }" <c:if test="${col.name==collegeSelected}">selected</c:if>>${col.name }</option>
						   	</c:forEach>
                        </select>
                        <p id="college_msg"></p>
                    </div>
                    <div class="select_normal">
                        <select id="profession" name="profession">
                            <option value="0">专业</option>
                            <c:forEach items="${college }" var="col">
						        <c:forEach items="${col.professions }" var="pro">
						        	<option value="${pro.name }" <c:if test="${pro.name==professionSelected}">selected</c:if>>${pro.name }</option>
						   		</c:forEach>
						   	</c:forEach>
                        </select>
                        <p id="profession_msg"></p>
                    </div>
                    <div class="select_normal">
                        <select id="grade" name="grade">
                            <option value="0">年级</option>
                            <c:forEach items="${grade }" var="gra">
						        <option value="${gra }" <c:if test="${gra==gradeSelected}">selected</c:if>>${gra }级</option>
						   	</c:forEach>
                        </select>
                        <p id="grade_msg"></p>
                    </div>
                    <div class="select_normal">
                        <select id="classes" name="classes">
                        	<option value="0">班级</option>
	                        <c:forEach items="${classes }" var="cla">
							     <option value="${cla }" <c:if test="${cla==classesSelected}">selected</c:if>>${cla }班</option>
							</c:forEach>  
                        </select>
                        <p id="classes_msg"></p>
                    <div class="submit">
                        <input type="submit" class="submit" value="提交">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- 页尾 -->
    <%@include file="footer.jsp"%>
</body>
</html>
