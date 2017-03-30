$(function(){
	alert("huangshouxi");
	function submitOperateSalaryForm() {
		alert("adfaf");
		var workMonth = $("#workMonth").val().trim();
		var teamMemberName = $("#teamMemberName").val().trim();
		var teamName = $("#teamName").val().trim();
		var monthReg = /^\d{6}$/;
		if (!monthReg.test(workMonth)) {
			alert("请输入正确的月份格式(6位数字，如：201608)");
			return false;
		}
		if (teamMemberName == "" && teamName == "") {
			alert("姓名和班组名称必填一个");
			return false;
		}
	}
});