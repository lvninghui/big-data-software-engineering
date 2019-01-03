function changestatus1() {
	var sign1 = document.getElementById("status1");
	var hidde1 = document.getElementsByName("hidde1");
	if (hidde1[0].style.display == "none") {
		for (var i = 0; i < hidde1.length; i++) {
			hidde1[i].style.display = "block";
		}
		sign1.style.transform = "rotate(360deg)";
	} else {
		for (var i = 0; i < hidde1.length; i++) {
			hidde1[i].style.display = "none";
		}
		sign1.style.transform = "rotate(270deg)";
	}

}
function changestatus2() {
	var sign2 = document.getElementById("status2");
	var hidde2 = document.getElementsByName("hidde2");
	if (hidde2[0].style.display == "none") {
		for (var i = 0; i < hidde2.length; i++) {
			hidde2[i].style.display = "block";
		}
		sign2.style.transform = "rotate(360deg)";
	} else {
		for (var i = 0; i < hidde2.length; i++) {
			hidde2[i].style.display = "none";
		}
		sign2.style.transform = "rotate(270deg)";
	}

}
function changestatus3() {
	var sign3 = document.getElementById("status3");
	var hidde3 = document.getElementsByName("hidde3");
	if (hidde3[0].style.display == "none") {
		for (var i = 0; i < hidde3.length; i++) {
			hidde3[i].style.display = "block";
		}
		sign3.style.transform = "rotate(360deg)";
	} else {
		for (var i = 0; i < hidde3.length; i++) {
			hidde3[i].style.display = "none";
		}
		sign3.style.transform = "rotate(270deg)";
	}

}
 function getactid() {
	var actid = document.getElementById('idvalue').value;
	
}
