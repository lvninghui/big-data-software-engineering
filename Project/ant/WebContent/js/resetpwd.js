function check() {
	var first = document.getElementById("set");
	var second = document.getElementById("confirm");
	if (first.value != second.value) {
		document.getElementById("check").style.display = "block";
	} else {
		document.getElementById("check").style.display = "none";
	}
}