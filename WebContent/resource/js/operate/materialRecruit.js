$(function(){
	$("#materialRecruitAddSubmit").click(function() {
		var title = $("#title").val().trim();
		var shopName = $("#shopName").val().trim();
		var province = $("#province").val().trim();
		var city = $("#city").val().trim();
		if (title == "") {
			alert("材料采购主题不能为空");
			return false;
		}
		if (shopName == "") {
			alert("材料名称不能为空");
			return false;
		}
		if (province == "") {
			alert("请选择采购地区省份");
			return false;
		}
		if (province == "110000" || province == "120000" || province == "500000" || province == "310000" || province == "810000" || province == "820000") {
			if (city == "") {
				
			}
		} else {
			if (city == "") {
				alert("请选择采购地区城市");
				return false;
			}
		} 
	});
});
