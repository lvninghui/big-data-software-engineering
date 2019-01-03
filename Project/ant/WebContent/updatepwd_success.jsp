<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>更改成功</title>
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="css/updatepwd_success.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script language="javascript" type="text/javascript">
	setTimeout(function() {
		this.location.href = "three_login.jsp"
	}, 5000);
</script>
</head>
<body>
	<div class="center">
		<div class="center_img">
			<img src="images/success.png">
		</div>
		<div class="center_text">
			<p class="center_p1"">
				更改密码成功，<span class="time"></span>秒后跳回登录页面
			</p>
		</div>
	</div>
	<script type="text/javascript">
		var timeEle = document.querySelector('.time'), count = 5;
		timeEle.innerHTML = count;
		// 设置计时器
		var judge = setInterval(function() {
			count--;
			if (!count) {
				// 清除计时器
				clearInterval(judge);
			}
			;
			// 标签当中显示时间
			timeEle.innerHTML = count;
		}, 1000);
	</script>
</body>
</html>