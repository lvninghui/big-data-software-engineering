<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>500</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script language="javascript" type="text/javascript">
	setTimeout(function() {
		this.location.href = "three_login.jsp"
	}, 5000);
</script>
<link rel="stylesheet" type="text/css" href="css/500.css">
</head>
<body>
	<div class="center">
		<div class="center_img">
			<img src="images/500.png">
		</div>
		<div class="center_text">
			<p class="center_fail">500</p>
			<p class="center_p">呀！出错了！</p>
			<p class="center_p1">亲爱的用户，我们的服务器出错啦...</p>
			<p class="center_p2">
				<span class="time"></span>秒后将跳回登录页面
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
<script type="text/javascript"
	src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</html>
