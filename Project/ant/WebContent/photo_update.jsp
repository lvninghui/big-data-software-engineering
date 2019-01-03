﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

#upload_D {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.5);
	display: none;
}

#upload_D>.upload_frame {
	width: 666px;
	height: 634px;
	background: #FFFFFF;
	border-radius: 10px;
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	margin: auto;
	overflow: hidden;
}

#upload_D>.upload_frame>.upload_title {
	padding: 28px 46px 28px 46px;
	border-bottom: 1px solid #e7e7e7;
	overflow: hidden;
}

#upload_D>.upload_frame>.upload_title>.upload_title_left {
	float: left;
	line-height: 24px;
	font-size: 18px;
}

#upload_D>.upload_frame>.upload_title>.upload_title_right {
	float: right;
	cursor: pointer;
}

#upload_D>.upload_frame>.upload_fileBtn {
	padding: 24px 46px;
	line-height: 34px;
	font-size: 16px;
}

#upload_D>.upload_frame>.upload_fileBtn>input {
	display: none;
}

#upload_D>.upload_frame>.upload_fileBtn>label {
	display: inline-block;
	width: 88px;
	height: 34px;
	text-align: center;
	border-radius: 5px;
	background: #ff5757;
	margin-left: 22px;
	color: #FFFFFF;
}

#upload_D>.upload_frame>.upload_content {
	padding: 0 46px;
}

#upload_D>.upload_frame>.upload_content>#clipArea {
	width: 388px;
	height: 388px;
	float: left;
	margin-left: 20px;
}

#upload_D>.upload_frame>.upload_content .upload_content_right {
	float: right;
	width: 120px;
	margin-right: 20px;
	text-align: center;
}

#upload_D>.upload_frame>.upload_content .upload_content_right .upload_view
	{
	width: 120px;
	height: 120px;
	border-radius: 50%;
}

#upload_D>.upload_frame>.upload_content .upload_content_right #clipBtn {
	width: 90px;
	height: 34px;
	border: none;
	outline: none;
	border-radius: 5px;
	background: #FF5757;
	color: #FFFFFF;
	margin-top: 196px;
}

#upload_D>.upload_frame>.upload_content .upload_content_right label {
	display: block;
	margin-top: 14px;
	font-size: 16px;
	color: #666666;
}

#view {
	width: 60px;
	height: 60px;
	border-radius: 50%;
	/* background-image: url(images/photo.jpg) ! important;  */
	background-image: url(${s.photo});
	margin-left: 50px;
}

.open {
	width: 100px;
	background-color: #fc9700;
	color: #fff;
	margin-left: 40px;
	margin-top: 10px;
}
</style>
</head>
<body>
	<div class="upload_view" id="view"></div>
	<button class="open">修改头像</button>
	<!-- <input class="open" type="button" value="修改头像"/> -->
	<div id="upload_D">
		<div class="upload_frame">
			<div class="upload_title">
				<span class="upload_title_left">请选择图片</span> <span
					class="upload_title_right"><img src="images/x.jpg"></span>
			</div>
			<div class="upload_fileBtn">
				图片上传 <input type="file" id="file" name="file" /> <label for="file">选择图片</label>
			</div>
			<div class="upload_content">
				<div id="clipArea"></div>
				<div class="upload_content_right">
					<p class="upload_view"></p>
					<button id="clipBtn">保存修改</button>
					<!-- <input id="clipBtn" value="保存修改" /> -->
					<label for="file">重新选图片</label>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.js"></script>
	<script src="js/iscroll-zoom.js"></script>
	<script src="js/hammer.js"></script>
	<script src="js/lrz.all.bundle.js"></script>
	<script src="js/jquery.photoClip.min.js"></script>
	<script>
		$(function() {
			var file1;
			//document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
			var clipArea = new bjj.PhotoClip("#clipArea", {
				size : [ 300, 300 ],// 截取框的宽和高组成的数组。默认值为[260,260]
				outputSize : [ 300, 300 ], // 输出图像的宽和高组成的数组。默认值为[0,0]，表示输出图像原始大小
				//outputType: "jpg", // 指定输出图片的类型，可选 "jpg" 和 "png" 两种种类型，默认为 "jpg"
				file : "#file", // 上传图片的<input type="file">控件的选择器或者DOM对象
				view : ".upload_view", // 显示截取后图像的容器的选择器或者DOM对象
				ok : "#clipBtn", // 确认截图按钮的选择器或者DOM对象
				loadStart : function() {
					// 开始加载的回调函数。this指向 fileReader 对象，并将正在加载的 file 对象作为参数传入
					$('.cover-wrap').fadeIn();
					console.log("照片读取中");
				},
				loadComplete : function() {
					// 加载完成的回调函数。this指向图片对象，并将图片地址作为参数传入
					console.log("照片读取完成");
				},
				//loadError: function(event) {}, // 加载失败的回调函数。this指向 fileReader 对象，并将错误事件的 event 对象作为参数传入
				clipFinish : function(dataURL) {
					// 裁剪完成的回调函数。this指向图片对象，会将裁剪出的图像数据DataURL作为参数传入
					console.log(dataURL);
					file1 = dataURL;
				}
			});

			//var file=$(".upload_view").text();

			$("#clipBtn").click(function() {
				$.ajax({
					type : 'POST',
					//async : 'false',
					url : 'imageUpload1',
					data : {
						'file' : file1
					},

				//dataType : 'json',
				//traditional : true,//阻止深度序列化，可以传递数组
				})
			});
			$(".upload_title_right").click(function() {
				$("#upload_D").fadeOut();
			});

			$(".open").click(function() {
				$("#upload_D").fadeIn();
			});
		})
	</script>
</body>
</html>
