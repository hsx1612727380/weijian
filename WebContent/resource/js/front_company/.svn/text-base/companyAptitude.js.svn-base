$(function(){
	$("#addSubmit").click(function() {
		var certificate = $("#certificate").val().trim();
		var adtype = $("#adtype").val().trim();
		var adlevel = $("#adlevel").val().trim();
		var approval = $("#approval").val().trim();
		var approvalTime = $("#approvalTime").val().trim();
		var validity = $("#validity").val().trim();
		var dateReg = /^([1-2]\d{3})-(0?[1-9]|10|11|12)-([1-2]?[0-9]|0[1-9]|30|31)$/;
		if (certificate == "") {
			alert("证书编号不能为空");
			return false;
		}
		if (adtype == "") {
			alert("请选择资质(信)类别");
			return false;
		}
		if (adlevel == "--请选择等级--") {
			alert("请选择资质(信)等级");
			return false;
		}
		if (approval == "") {
			alert("资质(信)审批机关不能为空");
			return false;
		}
		if (approvalTime == "") {
			alert("资质(信)最新批准日期不能为空");
			return false;
		}
		else {
			if (!dateReg.test(approvalTime)) {
				alert("请填写正确的资质(信)最新批准日期");
				return false;
			}
		}
		if (validity == "") {
			alert("资质(信)有效期不能为空");
			return false;
		}
		else {
			if (!dateReg.test(validity)) {
				alert("请输入正确的资质(信)有效日期");
				return false;
			}
		}
	});
	
	$("#modfiySubmit").click(function() {
		var certificate = $("#certificate").val().trim();
		var adtype = $("#adtype").val().trim();
		var adlevel = $("#adlevel").val().trim();
		var approval = $("#approval").val().trim();
		var approvalTime = $("#approvalTime").val().trim();
		var validity = $("#validity").val().trim();
		var dateReg = /^([1-2]\d{3})-(0?[1-9]|10|11|12)-([1-2]?[0-9]|0[1-9]|30|31)$/;
		if (certificate == "") {
			alert("证书编号不能修改为空");
			return false;
		}
		if (adtype == "") {
			alert("请选择资质(信)类别");
			return false;
		}
		if (adlevel == "--请选择等级--") {
			alert("请选择资质(信)等级");
			return false;
		}
		if (approval == "") {
			alert("资质(信)审批机关不能修改为空");
			return false;
		}
		if (approvalTime == "") {
			alert("资质(信)最新批准日期不能为空");
			return false;
		}
		else {
			if (!dateReg.test(approvalTime)) {
				alert("请填写正确的资质(信)最新批准日期");
				return false;
			}
		}
		if (validity == "") {
			alert("资质(信)有效期不能为空");
			return false;
		}
		else {
			if (!dateReg.test(validity)) {
				alert("请输入正确的资质(信)有效日期");
				return false;
			}
		}
	});
	
});