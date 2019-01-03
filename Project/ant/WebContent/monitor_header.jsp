<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery.js"></script>
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
						<form>
							<input type="text" placeholder="  请输入您要搜索的内容...">
							<button type="submit"></button>
						</form>
					</div>
				</td>
				<td class="top_1"><img src="images/message.png" class="message"></td>
				<td class="top_1"><img src="images/person.png" class="head_img"></td>
				<td class="top_1">
					<div class="name">
						<span>${m.email }</span>
					</div>
				</td>
			</tr>
		</table>
	</div>

	<div id="nav">
		<ul>
			<li><a href="#">首页</a></li>
			<li><a href="monitor_participationsituation.jsp">评奖评优</a></li>
		</ul>
	</div>
</div>
</html>