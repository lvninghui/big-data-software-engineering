<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!--header -->
<head>
<meta charset="UTF-8">
<title>login-小蚂蚁</title>
<link rel="stylesheet" href="css/three_login.css">
</head>
<body>
	<header>
		<nav class="b_clear">
			<div class="nav_logo l_float">
				<img src="images/logo2.png" alt="">
			</div>
		</nav>
	</header>
	<!--轮播图-->
	<div class="container">
		<div class="login_body l_clear">
			<div id="container_img">
				<div id="list" style="left: -100%;">
					<img src="images/bj5.jpg" alt="1" /> <img src="images/bj1.jpg"
						alt="1" /> <img src="images/bj2.jpg" alt="2" /> <img
						src="images/bj3.jpg" alt="3" /> <img src="images/bj4.jpg" alt="4" />
					<img src="images/bj5.jpg" alt="5" /> <img src="images/bj1.jpg"
						alt="5" />
				</div>
				<div id="buttons">
					<span index="1" class="on"></span> <span index="2"></span> <span
						index="3"></span> <span index="4"></span> <span index="5"></span>
				</div>
				<a href="javascript:;" id="prev" class="arrow">&lt;</a> <a
					href="javascript:;" id="next" class="arrow">&gt;</a>
			</div>
			<!--小container-->
			<div class="littlecon">
				<!--日历-->
				<div class="calendar">
					<div class="title">
						<h1 class="orange" id="calendar-title">Month</h1>
						<h2 class="orange" id="calendar-year">Year</h2>
						<a href="" id="cpre">&lt;</a> <a href="" id="cnext">&gt;</a>
					</div>

					<div class="body">
						<div class="lightgrey body-list">
							<ul>
								<li>SUN</li>
								<li>MON</li>
								<li>TUE</li>
								<li>WED</li>
								<li>THU</li>
								<li>FRI</li>
								<li>SAT</li>
							</ul>
						</div>

						<div class="darkgrey body-list">
							<ul id="days">

							</ul>
						</div>
					</div>
				</div>
				<!--登录界面-->
				<div class="login_form l_float">

					<div class="login_top">

						<div class="login_tags b_clear">
							<span class="top_tag l_float active" onClick="PwdLogin()">个人登录</span>
							<span class="top_tag m_float" onClick="QrcodeLogin()">班委登录</span>
							<span class="top_tag r_float" onClick="OgniLogin()">组织登录</span>
						</div>
					</div>
					<div class="login_con">
						<form action="stu_login" method="POST">
							<div>
								<label for="user_name">用户名</label> <input type="text" name="id"
									id="user_name" placeholder="账号为学号"> <img
									src="images/icons/user.svg">
								<p class="tips hidden">请检查您的账号</p>

								<!-- 获取信息和显示错误信息 -->
								<font color="red"> ${message1 } </font>
							</div>
							<div>
								<label for="user_pwd">密码</label> <input type="password"
									name="pwd" id="user_pwd" placeholder="请输入账户密码"> <img
									src="images/icons/lock.svg">
								<p class="tips hidden">请检查您的密码</p>
								<!-- 获取信息和显示错误信息 -->
								<font color="red"> ${message2 } </font>
							</div>
							<div class="b_clear">
								<label for="auth_code" class="b_clear">验证码</label> <input
									type="text" name="vcode" id="auth_code" class="l_float"
									maxlength="5" size="3"> <img src="vert"
									onclick="this.src='vert?'+Math.random()" id="image"
									class="auth_code l_float" /> &nbsp;<a
									href="javascript:void(0);" onclick="change()" class="l_float1">看不清，换一张</a>
								&nbsp;<br />

							</div>
							<br>
							<!-- 获取信息和显示错误信息 -->
							<font color="red"> ${message } </font>

							<div class="b_clear submit">
								<label for="remmber"> <input class="remmber"
									type="checkbox" name="remmber" id="remmber"> <span></span>
									记住密码
								</label> <a href="toRegister" class="r_float">注册账号</a> <a
									href="three_sendemail.jsp" class="r_float">忘记密码？</a>
								<button type="submit">登&nbsp;&nbsp;录</button>

								<p class="tips hidden">登录失败，请检查您的账户与密码</p>
							</div>
						</form>
					</div>
					<div class="login_con hidden">
						<form action="mon_login" method="POST">
							<div>
								<label for="user_name">用户名</label> <input type="text"
									name="email" id="user_name" placeholder="账号为班委邮箱"> <img
									src="images/icons/user.svg">
								<p class="tips hidden">请检查您的账号</p>
								<!-- 获取信息和显示错误信息 -->
								<font color="red"> ${message3 } </font>
							</div>
							<div>
								<label for="user_pwd">密码</label> <input type="password"
									name="pwd" id="user_pwd" placeholder="请输入账户密码"> <img
									src="images/icons/lock.svg">
								<p class="tips hidden">请检查您的密码</p>
								<!-- 获取信息和显示错误信息 -->
								<font color="red"> ${message4 } </font>
							</div>
							<div class="b_clear">
								<label for="auth_code" class="b_clear">验证码</label> <input
									type="text" name="vcode" id="auth_code" class="l_float"
									maxlength="5" size="3"> <img src="vert"
									onclick="this.src='vert?'+Math.random()" id="image1"
									class="auth_code l_float" /> &nbsp;<a
									href="javascript:void(0);" onclick="change1()" class="l_float1">看不清，换一张</a>
								&nbsp;<br />

							</div>
							<br>
							<!-- 获取信息和显示错误信息 -->
							<font color="red"> ${message } </font>
							<div class="b_clear submit">
								<label for="remmber"> <input class="remmber"
									type="checkbox" name="remmber" id="remmber"> <span></span>
									记住密码
								</label> <a href="toRegister" class="r_float" id="orange">注册账号</a> <a
									href="three_sendemail.jsp" class="r_float" id="orange">忘记密码？</a>

								<button type="submit">登&nbsp;&nbsp;录</button>

								<p class="tips hidden">登录失败，请检查您的账户与密码</p>
							</div>
						</form>

					</div>
					<div class="login_con hidden">
						<form action="org_login" method="POST">
							<div>
								<label for="user_name">用户名</label> <input type="text"
									name="email" id="user_name" placeholder="账号为组织邮箱"> <img
									src="images/icons/user.svg">
								<p class="tips hidden">请检查您的账号</p>
								<!-- 获取信息和显示错误信息 -->
								<font color="red"> ${message5 } </font>
							</div>
							<div>
								<label for="user_pwd">密码</label> <input type="password"
									name="pwd" id="user_pwd" placeholder="请输入账户密码"> <img
									src="images/icons/lock.svg">
								<p class="tips hidden">请检查您的密码</p>
								<!-- 获取信息和显示错误信息 -->
								<font color="red"> ${message6 } </font>
							</div>
							<div class="b_clear">
								<label for="auth_code" class="b_clear">验证码</label> <input
									type="text" name="vcode" id="auth_code" class="l_float"
									maxlength="5" size="3"> <img src="vert"
									onclick="this.src='vert?'+Math.random()" id="image2"
									class="auth_code l_float" /> &nbsp;<a
									href="javascript:void(0);" onclick="change2()" class="l_float1">看不清，换一张</a>
								&nbsp;<br />

							</div>
							<br>
							<!-- 获取信息和显示错误信息 -->
							<font color="red"> ${message } </font>
							<div class="b_clear submit">
								<label for="remmber"> <input class="remmber"
									type="checkbox" name="remmber" id="remmber"> <span></span>
									记住密码
								</label> <a href="toRegister" class="r_float">注册账号</a> <a
									href="three_sendemail.jsp" class="r_float">忘记密码？</a>
								<button type="submit">登&nbsp;&nbsp;录</button>

								<p class="tips hidden">登录失败，请检查您的账户与密码</p>
							</div>
						</form>



					</div>
				</div>
			</div>

			<!-- 页尾 -->
			<%@include file="footer.jsp"%>
</body>

<script src="js/three_login.js"></script>
<script type="text/javascript"
	src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</html>
