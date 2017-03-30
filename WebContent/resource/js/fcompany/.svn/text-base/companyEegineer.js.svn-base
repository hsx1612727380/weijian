$(function(){
	var userIdAddOk = false;
	var userIdModfiyOk = false;
	$('#addEngineerUserId>input').on('blur', function() {
		isphoneAdd($('#addEngineerUserId>input').val().trim());
	});
	$('#modfiyEngineerUserId>input').on('blur', function() {
		isphoneModfiy($('#modfiyEngineerUserId>input').val().trim(), $("#engineerId").val().trim());
	});
	function isphoneAdd(obj) {
		$.ajax({
		    type : 'post',
		    url : 'company_addMemberUserIdRepCHeck.html',
		    dataType : 'text',
		    data : {"userId" : obj},
		    success : function (date) {
		    	if(date == "0")
		    	{
		    		userIdAddOk = true;
		    	}
		    	if (date == "1") {
		    		userIdAddOk = false;
		    	}
		    },
		    error : function (xmlq, errq) {
		    	alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});
	}
	function isphoneModfiy(obj, obj2) {
		$.ajax({
		    type : 'post',
		    url : 'company_modfiyMemberUserIdRepCHeck.html',
		    dataType : 'text',
		    data : {"userId" : obj,
		    	"id": obj2},
		    success : function (date) {
		    	if(date == "0")
		    	{
		    		userIdModfiyOk = true;
		    	}
		    	if (date == "1") {
		    		userIdModfiyOk = false;
		    	}
		    },
		    error : function (xmlq, errq) {
		    	alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});
	}
	$("#addSubmit").click(function() {
		var name = $("#name").val().trim();
		var userId = $("#userId").val().trim();
		var type = $("#type").val().trim();
		var registration = $("#registration").val().trim();
		var certificateorgan = $("#certificateorgan").val().trim();
		var issuancedate = $("#issuancedate").val().trim();
		var effectivedate = $("#effectivedate").val().trim();
		var dateReg = /^([1-2]\d{3})-(0?[1-9]|10|11|12)-([1-2]?[0-9]|0[1-9]|30|31)$/;
		if (name == "") {
			alert("姓名不能为空");
			return false;
		}
		if (userId == "") {
			alert("手机号不能为空");
			return false;
		}
		else if(userId != "") {
			var phone = $("#userId").val();
			var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
			if(!myreg.test(phone)) {
				alert("请输入正确的手机号码");
				return false;
			}
			if (userIdAddOk) {
				alert("手机号码已经被注册");
				return false;
			}
		}
		if (type == "") {
			alert("注册类别不能为空");
			return false;
		}
		if (registration == "") {
			alert("注册编号不能为空");
			return false;
		}
		if (certificateorgan == "") {
			alert("签发机关不能为空");
			return false;
		}
		if (issuancedate == "") {
			alert("签发日期不能为空");
			return false;
		}
		else {
			if (!dateReg.test(issuancedate)) {
				alert("请输入正确的签发日期格式");
				return false;
			}
		}
		if (effectivedate == "") {
			alert("有效日期不能为空");
			return false;
		}
		else {
			if (!dateReg.test(effectivedate)) {
				alert("请输入正确的有效日期格式");
				return false;
			}
		}
		if (!userIdAddOk && (name != "") && (userId != "") && (type != "") && (registration != "") && (certificateorgan != "") && (issuancedate != "") && (effectivedate != "")) {
			$('form').submit();
		}
	});
	
	$("#modifySubmit").click(function() {
		var name = $("#name").val().trim();
		var userId = $("#userId").val().trim();
		var type = $("#type").val().trim();
		var registration = $("#registration").val().trim();
		var certificateorgan = $("#certificateorgan").val().trim();
		var issuancedate = $("#issuancedate").val().trim();
		var effectivedate = $("#effectivedate").val().trim();
		var dateReg = /^([1-2]\d{3})-(0?[1-9]|10|11|12)-([1-2]?[0-9]|0[1-9]|30|31)$/;
		if (name == "") {
			alert("姓名不能为空");
			return false;
		}
		if (userId == "") {
			alert("手机号不能为空");
			return false;
		}
		else if(userId != "") {
			var phone = $("#userId").val();
			var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
			if(!myreg.test(phone)) {
				alert("请输入正确的手机号码");
				return false;
			}
			if (userIdModfiyOk) {
				alert("手机号码已经被注册");
				return false;
			}
		}
		if (type == "") {
			alert("注册类别不能为空");
			return false;
		}
		if (registration == "") {
			alert("注册编号不能为空");
			return false;
		}
		if (certificateorgan == "") {
			alert("签发机关不能为空");
			return false;
		}
		if (issuancedate == "") {
			alert("签发日期不能为空");
			return false;
		}
		else {
			if (!dateReg.test(issuancedate)) {
				alert("请输入正确的签发日期格式");
				return false;
			}
		}
		if (effectivedate == "") {
			alert("有效日期不能为空");
			return false;
		}
		else {
			if (!dateReg.test(effectivedate)) {
				alert("请输入正确的有效日期格式");
				return false;
			}
		}
		if (!userIdModfiyOk && (name != "") && (userId != "") && (type != "") && (registration != "")&& (certificateorgan != "") && (issuancedate != "") && (effectivedate != "")) {
			$('form').submit();
		}
	});
});