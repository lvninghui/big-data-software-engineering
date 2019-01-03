$(function() {

	var slider = $('#scrollPics .slider');
	var imgCon = $('#scrollPics .slider li'); // 获取图片
	imgCon.not(imgCon.eq(0)).hide(); // 除第一张其它隐藏
	var num = $('#scrollPics .num'); // 定义页码
	var len = slider.find('li').length;
	var html_page = '', index = 0;
	// 添加页码
	for (var i = 0; i < len; i++) {
		if (i === 0) {
			// html_page += '<li class=on >' + (i + 1) + '</li>';
			html_page += '<li class=on >' + '</li>';
		} else {
			// html_page += '<li>' + (i + 1) + '</li>';
			html_page += '<li>' + '</li>';
		}
	}
	num.html(html_page);
	// num.html(1);
	// 显示索引对应的图片
	function showPic(index) {
		imgCon.eq(index).show().siblings("li").hide();
		num.find("li").eq(index).addClass('on').siblings("li")
				.removeClass("on");
	}
	// 页码按钮移入
	$('.num li').mouseover(function() {
		index = $(this).index(); // 获取索引
		showPic(index);
	})
	$('#scrollPics').hover(function() {
		clearInterval(window.timer);
	}, function() {
		window.timer = setInterval(function() {
			showPic(index);
			index++;
			if (index === len) {
				index = 0;
			}
		}, 2000);
	}).trigger('mouseleave'); // 触发被选元素的指定事件
});