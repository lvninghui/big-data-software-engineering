<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh_cn">
<head>
<meta charset="utf-8">
<link type="text/css" href="css/monitor_comprehensive.css"
	rel="stylesheet">
<link type="text/css" href="css/header_footer.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
<title>班委页面_评奖评优_生成综测成绩单</title>
</head>
<body>
	<%@include file="monitor_header.jsp"%>
	<div class="content">
		<div id="steps">
			<ol class="ui-step ui-step-yellow ui-step-3">
				<li class="step-start step-done">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont">
						<a class="ui-step-cont-number" href="monitor_participationsituation.jsp">1</a> <a
							class="ui-step-cont-text" href="monitor_participationsituation.jsp">核对活动参与情况</a>
					</div>
				</li>
				<li class="step-start step-done">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont">
						<a class="ui-step-cont-number" href="monitor_awardstudy.jsp">2</a> <a
							class="ui-step-cont-text" href="monitor_awardstudy.jsp">导入学业水平成绩</a>
					</div>
				</li>
				<li class="step-active">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont">
						<a class="ui-step-cont-number" href="monitor_awardcharacter.jsp">3</a> <a
							class="ui-step-cont-text" href="monitor_awardcharacter.jsp">导入品德表现测评结果</a>
					</div>
				</li>
				<li class="step-end">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont">
						<a class="ui-step-cont-number" href="addressComprehensive">4</a> <a
							class="ui-step-cont-text" href="addressComprehensive">生成综测成绩单</a>
					</div>
				</li>
			</ol>
		</div>
		<div class="tips">
			<img src="images/tips.svg"> <span>提示：在生成综测成绩表之前，请先核对之前的信息</span>
		</div>
		<div class="button1">
			<a href="downloadComprehensive" id="btn_study">生成综测汇总表</a>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script type="text/javascript"
	src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</html>