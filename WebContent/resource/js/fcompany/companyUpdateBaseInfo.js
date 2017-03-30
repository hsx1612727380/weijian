$(function(){
	$("#updateSubmit").click(function() {
		var type = $("#type").val().trim();
		var name = $("#name").val().trim();
		var province = $("#province").val().trim();
		var city = $("#city").val().trim();
		var organization = $("#organization").val().trim();
		var regMoney = $("#regMoney").val().trim();
		var regType = $("#regType").val().trim();
		var leaderName = $("#leaderName").val().trim();
		var tel = $("#tel").val().trim();
		if (type == "") {
			alert("注册类别不能为空");
			return false;
		}
		if (name == "") {
			alert("公司名称不能为空");
			return false;
		}
		if (province == "") {
			alert("请选择省份");
			return false;
		} else if (province == "110000" || province == "120000" || province == "500000" || province == "310000" || province == "810000" || province == "820000") {
			if (city == "") {
				
			}
		} else {
			if (city == "") {
				alert("请选择城市");
				return false;
			}
		} 
		if (organization == "") {
			alert("请填写统一社会信用代码");
			return false;
		} else {
			var myreg = /[A-Z0-9]{18}/g;
			if (!myreg.test(organization)) {
				alert("请输入正确的统一社会信用代码");
				return false;
			}
		}
		if (regMoney == "") {
			alert("请填写注册资金");
			return false;
		}
		if (regType == "") {
			alert("请填写注册类型");
			return false;
		}
		if (leaderName == "") {
			alert("联系人不能为空");
			return false;
		}
		if (tel == "") {
			alert("联系方式不能为空");
			return false;
		}
	});
});