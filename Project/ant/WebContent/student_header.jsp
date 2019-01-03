<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/JsonpAjax.js"></script>
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/header_footer.css">
</head>
<div class="header">
	<div class="top">
		<table>
			<tr class="top_lenght">
				<td class="top_1">
					<div class="logo">
						<img src="images/logo2.png">
					</div>
				</td>
				<td class="top_1">
					<div class="search">
						<form action="searchByName" method="get">
							 <input type="text" placeholder="       请输入您要搜索的内容..." id="text" autocomplete="off" name="name" > 
						     <button type="submit"></button> 
						</form>
						 <div id="word"></div>
					</div>
				</td>
				<td class="top_1"><img src="images/message.png" class="message"></td>
				<td class="top_1"><img src="images/person.png" class="head_img"></td>
				<td class="top_1">
					<div class="name">
						<span>${s.name }</span>
					</div>
				</td>
			</tr>
		</table>
	</div>

	<div id="nav">
		<ul>
			<li><a href="student_index.jsp">首页</a></li>
			<li><a href="beforeSearch?pageNo=1">活动</a></li>
			<li><a href="personalcenter">个人中心</a></li>
			<li><a href="personalinformation">个人信息</a></li>
		</ul>
	</div>
</div>
</html>