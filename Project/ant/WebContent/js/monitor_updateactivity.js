$(document).ready(function() {
	$('#example').dataTable({
		"scrollX" : true
	});
	var table = $('#example').DataTable();
	$('button').click(function() {
		var data = table.$('input, select').serialize();
		alert("确定修改吗？" + data.substr(0, 120) + '...');
		return false;
	});
});