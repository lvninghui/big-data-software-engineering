<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>PersonalSatge</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="css/organization_personalstage.css">
</head>
<body>
	<table class="table3-0" cellspacing="0" cellpadding="0">
		<tr style="background-color: #e5e5e5">
			<td style="width: 25%">学号</td>
			<td style="width: 25%">姓名</td>
			<td style="width: 25%">活动详情</td>
			<td style="width: 25%"></td>
		</tr>
		
	  	<c:forEach items="${participation.list }" var="parter">
	  	<form action="toparticipation?activityid=${activityid }&&pageNum=${participation.currentPageNum}" method="post">
		<tr>
			<td>${parter[0].id }<input name="stuid" type="hidden" value="${parter[0].id }"></td>
			<td>${parter[0].name }</td>
			<td><select name="stustage" class="sty1">
			<option>${parter[1] }</option>
					<option>单次比赛</option>
					<option>参加</option>
					<option>初赛</option>
					<option>决赛</option></select></td>
			<td><button class="button">保存</button></td>
		</tr>
		</form>
		</c:forEach>
		<tr height="75" class="changecolor">
			<td colspan="4"><a href="toparticipationall?activityid=${activityid }&&pageNum=${participation.prePageNum}" class="previous"> 上一页 </a> 
			${participation.currentPageNum}/${participation.totalPageNum } 
			<a href="toparticipationall?activityid=${activityid }&&pageNum=${participation.nextPageNum}" class="next"> 下一页 </a></td>
		</tr>
	</table>
	<button class="button-submit" onclick="location.href='toDisplayOrganizationMine'">提交</button>
	
	
</body>
<script type="text/javascript"
	src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</html>