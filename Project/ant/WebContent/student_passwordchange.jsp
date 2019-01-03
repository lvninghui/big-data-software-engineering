<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>个人页面_更改密码</title>
<link rel="stylesheet" type="text/css" href="css/header_footer.css">
<link rel="stylesheet" type="text/css"
	href="css/student_passwordchange.css">
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
						<!-- 头像 -->
						<div class="photo">
							<div class="blanket"></div>
							<div class="btn">
								<a href="#">更换头像</a>
							</div>
						</div>
						<div class="welcome">
							<p>Welcome,</p>
							<p>XXX</p>
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
							<div class="btn">
								<a href="setInformation.jsp">更改信息</a>
							</div>
							<div class="btn selected">
								<a href="setPsd.jsp">更改密码</a>
							</div>
						</div>
					</div>
				</div>
				<!-- 下右部分 -->
				<div class="bottom_right">
					<div class="nav">
						<span>账户安全</span>
					</div>
					<div class="clear"></div>
					<div class="bottom_right_detail">
						<form action="#" method="post">
							<table>
								<tr class="tr">
									<td class="td1">旧密码:</td>
									<td class="td2"><input type="password"
										placeholder="请输入旧密码"></td>
								</tr>
								<tr class="tr">
									<td class="td1">新密码:</td>
									<td class="td2"><input type="password"
										placeholder="请输入新密码"></td>
								</tr>
								<tr class="tr">
									<td class="td1">确认密码:</td>
									<td class="td2"><input type="password"
										placeholder="请再次输入新密码"></td>
								</tr>
							</table>
						</form>
						<div class="content_submit">
							<input type="submit" name="submit" value="更改密码" class="button">
						</div>
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