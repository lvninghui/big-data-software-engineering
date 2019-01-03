// 注册按钮切换

function personReg() {
	var reg = document.getElementsByClassName("reg");
	if (reg[0].className.indexOf("hidden") > -1) {
		reg[0].classList.remove("hidden");
		reg[0].classList.add("show");
	}
	if (reg[1].className.indexOf("show") > -1) {
		reg[1].classList.remove("show");
		reg[1].classList.add("hidden");
	}
	if (reg[2].className.indexOf("show") > -1) {
		reg[2].classList.remove("show");
		reg[2].classList.add("hidden");
	}
	var tags = document.getElementsByClassName("top_tag");
	if (!(tags[0].className.indexOf("active") > -1)) {
		tags[0].classList.add("active");
	}
	if (tags[1].className.indexOf("active") > -1) {
		tags[1].classList.remove("active");
	}
	if (tags[2].className.indexOf("active") > -1) {
		tags[2].classList.remove("active");
	}
}
function classReg() {
	var reg = document.getElementsByClassName("reg");
	if (reg[1].className.indexOf("hidden") > -1) {
		reg[1].classList.remove("hidden");
		reg[1].classList.add("show");
	}
	if (reg[0].className.indexOf("show") > -1) {
		reg[0].classList.remove("show");
		reg[0].classList.add("hidden");
	}
	if (reg[2].className.indexOf("show") > -1) {
		reg[2].classList.remove("show");
		reg[2].classList.add("hidden");
	}
	var tags = document.getElementsByClassName("top_tag");
	if (!(tags[1].className.indexOf("active") > -1)) {
		tags[1].classList.add("active");
	}
	if (tags[0].className.indexOf("active") > -1) {
		tags[0].classList.remove("active");
	}
	if (tags[2].className.indexOf("active") > -1) {
		tags[2].classList.remove("active");
	}
}
function orgReg() {
	var reg = document.getElementsByClassName("reg");
	if (reg[2].className.indexOf("hidden") > -1) {
		reg[2].classList.remove("hidden");
		reg[2].classList.add("show");
	}
	if (reg[1].className.indexOf("show") > -1) {
		reg[1].classList.remove("show");
		reg[1].classList.add("hidden");
	}
	if (reg[0].className.indexOf("show") > -1) {
		reg[0].classList.remove("show");
		reg[0].classList.add("hidden");
	}
	var tags = document.getElementsByClassName("top_tag");
	if (!(tags[2].className.indexOf("active") > -1)) {
		tags[2].classList.add("active");
	}
	if (tags[1].className.indexOf("active") > -1) {
		tags[1].classList.remove("active");
	}
	if (tags[0].className.indexOf("active") > -1) {
		tags[0].classList.remove("active");
	}
}
$(function() {
	$("#student_id").blur(function() {
		var student_id = $("#student_id").val();
		var textId = /^20\d{8}$/;
		if (!textId.test(student_id)) {
			$("#top_id_msg").html("学号必须由10位数字组成,且以20开头");
			$("#top_id_msg").addClass("redWord");
		} else {
			$.ajax({
				url : "checkStudentId",
				type : "POST",
				data : {
					"student_id" : student_id
				},
				success : function(data) {
					if ("no" == data) {
						$("#top_id_msg").html("该学号已被注册");
						$("#top_id_msg").addClass("redWord");
					} else if ("ok" == data) {
						$("#top_id_msg").html("该学号可以注册");
						$("#top_id_msg").removeClass("redWord");
					}
				}
			});
		}
	});
	$("#name").blur(function() {
		var name = $("#name").val();
		var textName =/(^[\u4e00-\u9fa5]{1}[\u4e00-\u9fa5\.·。]{0,8}[\u4e00-\u9fa5]{1}$)|(^[a-zA-Z]{1}[a-zA-Z\s]{0,8}[a-zA-Z]{1}$)/;
		if (!textName.test(name)) {
			$("#name_msg").html("请填写您的真实姓名（中英文），长度在10个字符以内");
			$("#name_msg").addClass("redWord");
		} else {
			$("#name_msg").html("姓名符合要求");
			$("#name_msg").removeClass("redWord");
		}
	});
	$("#psd").blur(function() {
		var psd = $("#psd").val();
		var textPsd = /^[a-zA-Z]\w{5,17}$/;
		if (!textPsd.test(psd)) {
			$("#psd_msg").html("以字母开头，长度在6~18之间，只能包含字母、数字和下划线");
			$("#psd_msg").addClass("redWord");
		} else {
			$("#psd_msg").html("密码符合要求");
			$("#psd_msg").removeClass("redWord");
		}
	});
	$("#againpsd").blur(function() {
		var psd = $("#psd").val();
		var againpsd = $("#againpsd").val();
		if (!(psd == againpsd)) {
			$("#againpsd_msg").html("密码前后不一致");
			$("#againpsd_msg").addClass("redWord");
		} else {
			$("#againpsd_msg").html("密码前后一致");
			$("#againpsd_msg").removeClass("redWord");
		}
	});
	$("#email").blur(function() {
		var email = $("#email").val();
		var textEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if (!textEmail.test(email)) {
			$("#email_psg").html("请填写正确格式的邮箱地址");
			$("#email_psg").addClass("redWord");
		} else {
			$("#email_psg").html("邮箱符合要求");
			$("#email_psg").removeClass("redWord");
		}
	});
	// 班委
	$("#college").blur(function() {
		var college = $('#college').val();
		if (college == "0") {
			$("#college_msg").html("请选择学院");
			$("#college_msg").addClass("redWord");
		} else {
			$("#college_msg").html("学院信息正确");
			$("#college_msg").removeClass("redWord");
		}
	});
	$("#profession").blur(function() {
		var profession = $('#profession').val();
		if (profession == "0") {
			$("#profession_msg").html("请选择专业");
			$("#profession_msg").addClass("redWord");
		} else {
			$("#profession_msg").html("专业信息正确");
			$("#profession_msg").removeClass("redWord");
		}
	});
	$("#grade").blur(function() {
		var grade = $('#grade').val();
		if (grade == "0") {
			$("#grade_msg").html("请选择年级");
			$("#grade_msg").addClass("redWord");
		} else {
			$("#grade_msg").html("年级信息正确");
			$("#grade_msg").removeClass("redWord");
		}
	});
	$("#classes").blur(function() {
		var classes = $('#classes').val();
		if (classes == "0") {
			$("#classes_msg").html("请选择班级");
			$("#classes_msg").addClass("redWord");
		} else {
			$("#classes_msg").html("班级信息正确");
			$("#classes_msg").removeClass("redWord");
		}
	});
	$("#mon_psd").blur(function() {
		var psd = $("#mon_psd").val();
		var textPsd = /^[a-zA-Z]\w{5,17}$/;
		if (!textPsd.test(psd)) {
			$("#mon_psd_msg").html("以字母开头，长度在6~18之间，只能包含字母、数字和下划线");
			$("#mon_psd_msg").addClass("redWord");
		} else {
			$("#mon_psd_msg").html("密码符合要求");
			$("#mon_psd_msg").removeClass("redWord");
		}
	});
	$("#mon_againpsd").blur(function() {
		var psd = $("#mon_psd").val();
		var againpsd = $("#mon_againpsd").val();
		if (!(psd == againpsd)) {
			$("#mon_againpsd_msg").html("密码前后不一致");
			$("#mon_againpsd_msg").addClass("redWord");
		} else {
			$("#mon_againpsd_msg").html("密码前后一致");
			$("#mon_againpsd_msg").removeClass("redWord");
		}
	});
	$("#mon_email").blur(function() {
		var email = $("#mon_email").val();
		var textEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if (!textEmail.test(email)) {
			$("#mon_email_msg").html("请填写正确格式的邮箱地址");
			$("#mon_email_msg").addClass("redWord");
		} else {
			$.ajax({
				url : "checkMonitorEmail",
				type : "POST",
				data : {
					"mon_email" : mon_email
				},
				success : function(data) {
					if ("no" == data) {
						$("#mon_email_msg").html("该邮箱已被注册");
						$("#mon_email_msg").addClass("redWord");
					} else if ("ok" == data) {
						$("#mon_email_msg").html("该邮箱可以注册");
						$("#mon_email_msg").removeClass("redWord");
					}
				}
			});
		}
	});
	// 组织
	$("#belong").blur(function() {
		var belong = $('#belong').val();
		if (belong == "0") {
			$("#belong_msg").html("请选择所属单位");
			$("#belong_msg").addClass("redWord");
		} else {
			$("#belong_msg").html("所属单位正确");
			$("#belong_msg").removeClass("redWord");
		}
	});
	$("#org_name").blur(function() {
		var org_name = $('#org_name').val();
		if (org_name == "0") {
			$("#org_name_msg").html("请选择组织名");
			$("#org_name_msg").addClass("redWord");
		} else {
			$("#org_name_msg").html("组织名正确");
			$("#org_name_msg").removeClass("redWord");
		}
	});
	$("#org_psd").blur(function() {
		var psd = $("#org_psd").val();
		var textPsd = /^[a-zA-Z]\w{5,17}$/;
		if (!textPsd.test(psd)) {
			$("#org_psd_msg").html("以字母开头，长度在6~18之间，只能包含字母、数字和下划线");
			$("#org_psd_msg").addClass("redWord");
		} else {
			$("#org_psd_msg").html("密码符合要求");
			$("#org_psd_msg").removeClass("redWord");
		}
	});
	$("#org_againpsd").blur(function() {
		var psd = $("#org_psd").val();
		var againpsd = $("#org_againpsd").val();
		if (!(psd == againpsd)) {
			$("#org_againpsd_msg").html("密码前后不一致");
			$("#org_againpsd_msg").addClass("redWord");
		} else {
			$("#org_againpsd_msg").html("密码前后一致");
			$("#org_againpsd_msg").removeClass("redWord");
		}
	});	
	$("#org_email").blur(function(){
		var org_email=$("#org_email").val();
		var textEmail=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if(!textEmail.test(org_email)){
			$("#org_email_msg").html("请填写正确格式的邮箱地址");
			$("#org_email_msg").addClass("redWord");
		}else{
			$.ajax({
		    	url:"checkOrganizationEmail",
		        type:"POST",
		        data:{"org_email":org_email},
		        success: function(data) {
		        	if("no"==data){
		        		$("#org_email_msg").html("该邮箱已被注册");
		        		$("#org_email_msg").addClass("redWord");
		        	}else if("ok"==data){
		        		$("#org_email_msg").html("该邮箱可以注册");
		        		$("#org_email_msg").removeClass("redWord");
		        	}
		        }
		    });
		}
	});
})
