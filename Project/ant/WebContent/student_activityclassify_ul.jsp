<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>个人页面_活动分类_ul</title>
<link rel="stylesheet" type="text/css"
	href="css/student_activityclassify_ul.css">




</head>
<body>
	<div class="activity_type">
		<ul class="big_type">
			<li>
				<ul class="small_type" id="types">
					<span class="type_header">按类别:</span>
					<li><a href="#" class="normal">全部</a></li>
					<li><a href="#" class="normal">志愿活动</a></li>
					<li><a href="#" class="normal">文体竞赛</a></li>
					<li><a href="#" class="normal">学术竞赛</a></li>
				</ul>
			</li>
			<div class="clear"></div>
			<li>
				<ul class="small_type" id="levels">
					<span class="type_header">按级别:</span>
					<li><a href="#" class="normal">全部</a></li>
					<li><a href="#" class="normal">国家级</a></li>
					<li><a href="#" class="normal">省级</a></li>
					<li><a href="#" class="normal">市级</a></li>
					<li><a href="#" class="normal">校级</a></li>
					<li>
						<div class="college">
							<input id="ipt" type="text" placeholder="院级" />
							<ul id="ul">
								<li><a href="javascript:;" class="normal">软件学院</a></li>
								<li><a href="javascript:;" class="normal">马克思主义学院</a></li>
								<li><a href="javascript:;" class="normal">教育学院</a></li>
								<li><a href="javascript:;" class="normal">文学院</a></li>
								<li><a href="javascript:;" class="normal">国际文化交流学院</a></li>
								<li><a href="javascript:;" class="normal">历史文化学院</a></li>
								<li><a href="javascript:;" class="normal">外国语学院</a></li>
								<li><a href="javascript:;" class="normal">音乐学院</a></li>
								<li><a href="javascript:;" class="normal">美术与设计学院</a></li>
								<li><a href="javascript:;" class="normal">新闻传播学院</a></li>
								<li><a href="javascript:;" class="normal">商学院</a></li>
								<li><a href="javascript:;" class="normal">法政与公共管理学院</a></li>
								<li><a href="javascript:;" class="normal">数学与信息科学学院</a></li>
								<li><a href="javascript:;" class="normal">物理科学与信息工程学院</a></li>
								<li><a href="javascript:;" class="normal">化学与材料科学学院</a></li>
								<li><a href="javascript:;" class="normal">生命科学学院</a></li>
								<li><a href="javascript:;" class="normal">资源与环境科学学院</a></li>
								<li><a href="javascript:;" class="normal">体育学院</a></li>

							</ul>
						</div>
					</li>

				</ul>
			</li>
			<div class="clear"></div>
			<li>
				<ul class="small_type">
					<span class="type_header" id="timers">按时间:</span>
					<li><a href="#" class="normal">全部</a></li>
					<li><a href="#" class="normal">报名中</a></li>
					<li><a href="#" class="normal">进行中</a></li>
					<li><a href="#" class="normal">已结束</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<script type="text/javascript" src="js/search.js"></script>
	<script type="text/javascript" src="js/student_activityclassify_ul.js"></script>
</body>
<!-- <script type="text/javascript" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script> -->
</html>