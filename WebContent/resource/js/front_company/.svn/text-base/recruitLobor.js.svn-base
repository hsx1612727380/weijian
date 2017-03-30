$(function(){
	$("#recruitLoborAddSubmit").click(function() {
		var title = $("#title").val().trim();
		var province = $("#province").val().trim();
		var city = $("#city").val().trim();
		var street = $("#street").val().trim();
		var teamType = $("#eqtime").val().trim();
		var skillBigType = $("#skillBigType").val().trim();
		var skillSmallType = $("#skillSmallType").val().trim();
		var shopNameMaterial = $("#shopNameMaterial").val().trim();
		var shopNameEquip = $("#shopNameEquip").val().trim();
		if (title == "") {
			alert("用工主题不能为空");
			return false;
		}
		if (province == "") {
			alert("请选择招聘地区省份");
			return false;
		}
		else if (province == "110000" || province == "120000" || province == "500000" || province == "310000" || province == "810000" || province == "820000") {
			if (city == "") {
				
			}
		} 
		else {
			if (city == "") {
				alert("请选择城市");
				return false;
			}
		}
		if (street == "") {
			alert("请填写招聘的详细地址");
			return false;
		}
		if (teamType == "1") {
			if (skillBigType == "") {
				alert("请选择技能类别");
				return false;
			}
			if (skillSmallType == "--请选择技能类型--") {
				alert("请选择技能类型");
				return false;
			}
		}
		else if (teamType == "2") {
			if (shopNameMaterial == "") {
				alert("请填写材料商名称");
				return false;
			}
		}
		else {
			if (shopNameEquip == "") {
				alert("请填写设备商名称");
				return false;
			}
		}
	});
});
