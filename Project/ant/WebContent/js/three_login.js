// 轮播图
window.onload = function() {
	var list = document.getElementById('list');
	var prev = document.getElementById('prev');
	var next = document.getElementById('next');
	function animate(offset) {
		/*
		 * 获取的是style.left，是相对左边获取距离，所以第一张图后style.left都为负值，
		 * 且style.left获取的是字符串，需要用parseInt()取整转化为数字。
		 */

		var newLeft = parseInt(list.style.left) + offset;

		list.style.left = newLeft + '%';

		if (newLeft < -500) {
			list.style.left = -100 + '%';
		}
		if (newLeft > -100) {
			list.style.left = -500 + '%';
		}
	}
	/* 需要定位到按钮的样式 */
	var buttons = document.getElementById('buttons').getElementsByTagName(
			'span');
	var index = 1;

	function buttonShow() {
		/* console.log(buttons.length); */
		/* 清除之前的样式 */
		for (var i = 0; i < buttons.length; i++) {
			if (buttons[i].className === 'on') {
				buttons[i].className = '';
			}
		}
		/* 数组从0开始，temp从-1开始 */
		buttons[index - 1].className = 'on';
	}
	/* 上一步 */
	prev.onclick = function() {
		index = index - 1;
		if (index < 1) {
			index = 5;
		}
		buttonShow();
		animate(100);
	}
	/* 下一步 */
	next.onclick = function() {
		index = index + 1;
		if (index > 5) {
			index = 1;
		}
		buttonShow();
		animate(100);
	}
	/* 自动循环播放 */
	var timer;

	function play() {
		timer = setInterval(function() {
			next.onclick();
		}, 8000)
	}
	play();
	/* 鼠标放上（离开）对应轮播暂停（播放） */
	var container = document.getElementById('container_img');

	function stop() {
		clearInterval(timer);
	}
	container.onmouseover = stop;
	container.onmouseout = play;

	/* 小圆点的点击事件 */
	for (var i = 0; i < buttons.length; i++) {
		/* 使用立即函数 */
		(function(i) {
			buttons[i].onclick = function() {
				console.log(i);
				/* 偏移量的获取：获取鼠标的小圆点的位置，用this把index绑定到对象buttons[i]上 */
				/* 由于index是自定义属性，需要用到getAttribute()这个dom的2级方法，去获取自定义的index属性 */
				var clickIndex = parseInt(this.getAttribute('index'));
				var offset = 100 * (index - clickIndex);
				animate(offset);
				index = clickIndex;
				buttonShow();
			}
		})(i)
	}
}
// 切换验证码
function change() {
	var img = document.getElementById("image");
	// 切换验证码的原理是点击就重新将src设置一下，但是浏览器有缓存，所以我们需要在后面添加一个参数来让浏览器不断发送请求，后面加的参数为时间，因为时间是不断变化的
	img.src = "vert?t=" + Math.random();
}
function change1() {
	var img = document.getElementById("image1");
	// 切换验证码的原理是点击就重新将src设置一下，但是浏览器有缓存，所以我们需要在后面添加一个参数来让浏览器不断发送请求，后面加的参数为时间，因为时间是不断变化的
	img.src = "vert?t=" + Math.random();
}
function change2() {
	var img = document.getElementById("image2");
	// 切换验证码的原理是点击就重新将src设置一下，但是浏览器有缓存，所以我们需要在后面添加一个参数来让浏览器不断发送请求，后面加的参数为时间，因为时间是不断变化的
	img.src = "vert?t=" + Math.random();
}
// 日历
var month_olypic = [ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];// 闰年每个月份的天数
var month_normal = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];
var month_name = [ "January", "Febrary", "March", "April", "May", "June",
		"July", "Auguest", "September", "October", "November", "December" ];
// 获取以上各个部分的id
var holder = document.getElementById("days");
var cprev = document.getElementById("cprev");
var cnext = document.getElementById("cnext");
var ctitle = document.getElementById("calendar-title");
var cyear = document.getElementById("calendar-year");
// 获取当天的年月日
var my_date = new Date();
var my_year = my_date.getFullYear();// 获取年份
var my_month = my_date.getMonth(); // 获取月份，一月份的下标为0
var my_day = my_date.getDate();// 获取当前日期

// 根据年月获取当月第一天是周几
function dayStart(month, year) {
	var tmpDate = new Date(year, month, 1);
	return (tmpDate.getDay());
}
// 根据年份判断某月有多少天(11,2018),表示2018年12月
function daysMonth(month, year) {
	var tmp1 = year % 4;
	var tmp2 = year % 100;
	var tmp3 = year % 400;

	if ((tmp1 == 0 && tmp2 != 0) || (tmp3 == 0)) {
		return (month_olypic[month]);// 闰年
	} else {
		return (month_normal[month]);// 非闰年
	}
}
// js实现str插入li+class,不要忘了用innerhtml进行插入
function refreshDate() {
	var str = "";
	// 计算当月的天数和每月第一天都是周几，day_month和day_year都从上面获得
	var totalDay = daysMonth(my_month, my_year);
	var firstDay = dayStart(my_month, my_year);
	// 添加每个月的空白部分
	for (var i = 0; i < firstDay; i++) {
		str += "<li>" + "</li>";
	}

	// 从一号开始添加知道totalDay，并为pre，next和当天添加样式
	var myclass;
	for (var i = 1; i <= totalDay; i++) {
		// 三种情况年份小，年分相等月份小，年月相等，天数小
		// 点击pre和next之后，my_month和my_year会发生变化，将其与现在的直接获取的再进行比较
		// i与my_day进行比较,pre和next变化时，my_day是不变的
		console.log(my_year + " " + my_month + " " + my_day);
		console.log(my_date.getFullYear() + " " + my_date.getMonth() + " "
				+ my_date.getDay());
		if ((my_year < my_date.getFullYear())
				|| (my_year == my_date.getFullYear() && my_month < my_date
						.getMonth())
				|| (my_year == my_date.getFullYear()
						&& my_month == my_date.getMonth() && i < my_day)) {
			myclass = " class='lightgrey'";
		} else if (my_year == my_date.getFullYear()
				&& my_month == my_date.getMonth() && i == my_day) {
			myclass = "class = 'orange orangebox'";
		} else {
			myclass = "class = 'darkgrey'";
		}
		str += "<li " + myclass + ">" + i + "</li>";
	}
	holder.innerHTML = str;
	ctitle.innerHTML = month_name[my_month];
	cyear.innerHTML = my_year;
}
// 调用refreshDate()函数，日历才会出现
refreshDate();

/*
 * //实现onclick向前或向后移动 cpre.onclick = function(e){ e.preventDefault();
 * my_month--; if(my_month < 0){ my_year--; my_month = 11; //即12月份 }
 * refreshDate(); }
 */

cnext.onclick = function(e) {
	e.preventDefault();
	my_month++;
	if (my_month > 11) {
		my_month = 0;
		my_year++;
	}
	refreshDate();
}

// 登录按钮切换

function PwdLogin() {
	var login = document.getElementsByClassName("login_con");
	login[0].classList.remove("hidden");
	login[0].classList.add("show");
	login[1].classList.remove("show");
	login[1].classList.add("hidden");
	login[2].classList.remove("show");
	login[2].classList.add("hidden");
	var tags = document.getElementsByClassName("top_tag");
	tags[0].classList.add("active");
	tags[1].classList.remove("active");
	tags[2].classList.remove("active");
}
function QrcodeLogin() {
	var login = document.getElementsByClassName("login_con");
	login[0].classList.remove("show");
	login[0].classList.add("hidden");
	login[1].classList.remove("hidden");
	login[1].classList.add("show");
	login[2].classList.remove("show");
	login[2].classList.add("hidden");
	var tags = document.getElementsByClassName("top_tag");
	tags[1].classList.add("active");
	tags[0].classList.remove("active");
	tags[2].classList.remove("active");
}
function OgniLogin() {
	var login = document.getElementsByClassName("login_con");
	login[0].classList.remove("show");
	login[0].classList.add("hidden");
	login[1].classList.remove("show");
	login[1].classList.add("hidden");
	login[2].classList.remove("hidden");
	login[2].classList.add("show");
	var tags = document.getElementsByClassName("top_tag");
	tags[0].classList.remove("active");
	tags[1].classList.remove("active");
	tags[2].classList.add("active");
}

// 用户输入错误提示

var inputs = document.getElementsByTagName('input');
var tips = document.getElementsByClassName('tips');

function InputNull(a) {
	tips[a].classList.add('show');
	tips[a].classList.remove('hidden');
}
function InputNoNull(a) {
	tips[a].classList.add('hidden');
	tips[a].classList.remove('show');
}

var UserName = inputs[0];
var UserPwd = inputs[1];
var AuthCode = inputs[2];
var UserNameTips = tips[0];
var UserPwdTips = tips[1];
var AuthCodeTips = tips[2];

UserName.oninput = function() {
	if (UserName.value == '') {
		InputNull(0);
		UserNameTips.innerHTML = "请检查用户名，用户名不能为空";
	} else {
		InputNoNull(0);
	}
}
UserName.onblur = function() {
	if (UserName.value == '') {
		InputNull(0);
		UserNameTips.innerHTML = "请检查用户名，用户名不能为空";

	}
}

UserPwd.oninput = function() {
	if (UserPwd.value == '') {
		InputNull(1);
		UserPwdTips.innerHTML = "请检查您的密码，密码不能为空";
	} else {
		InputNoNull(1);
	}
}
UserPwd.onblur = function() {
	if (UserPwd.value == '') {
		InputNull(1);
		UserPwdTips.innerHTML = "请检查您的密码，密码不能为空";
	}
}
