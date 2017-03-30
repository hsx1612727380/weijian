$(function(){
	$("#teamRecruitAddSubmit").click(function() {
		var title = $("#title").val().trim();
		var skillBigType = $("#skillBigType").val().trim();
		var skillSmallType = $("#skillSmallType").val().trim();
		var province = $("#province").val().trim();
		var city = $("#city").val().trim();
		if (title == "") {
			alert("招聘主题不能为空");
			return false;
		}
		if (skillBigType == "") {
			alert("请选择技能类别");
			return false;
		}
		if (skillSmallType == "--请选择技能类型--") {
			alert("请选择技能类型");
			return false;
		}
		if (province == "") {
			alert("请选择招聘地区省份");
			return false;
		}
		if (province == "110000" || province == "120000" || province == "500000" || province == "310000" || province == "810000" || province == "820000") {
			if (city == "") {
				
			}
		} else {
			if (city == "") {
				alert("请选择城市");
				return false;
			}
		} 
	});
});
