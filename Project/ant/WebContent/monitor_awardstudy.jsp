<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh_cn">
<head>
<meta charset="utf-8">
<link type="text/css" href="css/monitor_awardstudy.css" rel="stylesheet">
<link type="text/css" href="css/header_footer.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
<title>班委页面_评奖评优_导入学业成绩</title>
<script>
	$(document).ready(function() {
		$('#btn_study').click(function() {
			$('#excel_file').click();
		});

	});
	function changeName(e){
		var span = document.getElementById('span');
		span.innerHTML = e.currentTarget.files[0].name;
	}
	//JS校验form表单信息  
    function checkData(){  
       var fileDir = $("#excel_file").val();  
       var suffix = fileDir.substr(fileDir.lastIndexOf("."));  
       if("" == fileDir){  
           alert("选择需要导入的Excel文件！");  
           return false;  
       }  
       if(".xls" != suffix && ".xlsx" != suffix ){  
           alert("选择Excel格式的文件导入！");  
           return false;  
       }  
       return true;  
    }   
</script>
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
				<li class="step-active">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont">
						<a class="ui-step-cont-number" href="monitor_awardstudy.jsp">2</a> <a
							class="ui-step-cont-text" href="monitor_awardstudy.jsp">导入学业水平成绩</a>
					</div>
				</li>
				<li class="step-end1">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont">
						<a class="ui-step-cont-number">3</a> <a
							class="ui-step-cont-text">导入品德表现测评结果</a>
					</div>
				</li>
				<li class="step-end2">
					<div class="ui-step-line"></div>
					<div class="ui-step-cont">
						<a class="ui-step-cont-number">4</a> <a
							class="ui-step-cont-text">生成综测成绩单</a>
					</div>
				</li>
			</ol>
		</div>
		<div class="tips">
			<img src="images/tips.svg"> <span>提示：在导入学业水平成绩之前，请确认核对活动参与情况</span>
		</div>
		<div class="button1">
			<a href="#" id="btn_study">导入学生学业水平成绩</a>
		</div>
		<div class="span_msg">
			<span id="span"></span>
		</div>
		<div class="upload_btn">
			<form action="addressSubmitStudy" method="post" enctype="multipart/form-data">
				<input id="excel_file" type="file" name="upfile" accept="xlsx" size="80" onchange="changeName(event)"/> 
				<input id="excel_button" type="submit" value="提交" onclick="return checkData()"/>
			</form>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script type="text/javascript"
	src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</html>