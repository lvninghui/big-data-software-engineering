<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/resetpwd.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/three_resetpassword.css">
<meta charset="UTF-8">
<title>忘记密码_重置密码</title>
</head>
<body>
	<div class="top">
		<img src="images/logo2.png" class="logo">
	</div>
	<form action="updatepwd" method="post" class="formsty">
		<p class="mailid">Email&nbsp;:&nbsp;${param.email}</p>
		<input type="hidden" name="email" value="${param.email}" />
		<div class="prompt">新密码：</div>
		<input type="password" name="pwd" class="pwd" id="set" />
		<div class="prompt">确认密码：</div>
		<input type="password" name="pwd2" class="pwd" id="confirm"
			onmouseleave="check()" />
		<div class="message" id="check">两次输入的密码不一致，请重输</div>
		<input type="submit" value="提交修改" class="sub" />
	</form>
</body>
<script type="text/javascript"
	src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</html>