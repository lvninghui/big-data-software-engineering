function addgrade() {
	var grade = document.getElementById("grade").value;
	grade++;
	document.getElementById("grade").value = grade;
}
function reducegrade() {
	var grade = document.getElementById("grade").value;
	if (grade > 0) {
		grade--;
		document.getElementById("grade").value = grade;
	}
}