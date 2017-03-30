$(function(){
	var userIdOk = false;
	$('#keyPersonPhone2>input').on('blur', function() {
		isphone2($('#keyPersonPhone2>input').val().trim());
	});
	$('#keyPersonPhone>input').on('blur', function() {
		isphone($('#keyPersonPhone>input').val().trim(), $("#keyPersonId").val().trim());
	});
	function isphone2(obj) {
		$.ajax({
		    type : 'post',
		    url : 'company_keyPersonAddPhoneRepCHeck.html',
		    dataType : 'text',
		    data : {"phone" : obj},
		    success : function (date) {
		    	if(date == "0")
		    	{
		    		userIdOk = true;
		    	}
		    	if (date == "1") {
		    		userIdOk = false;
		    	}
		    },
		    error : function (xmlq, errq) {
		    	alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});
	}
	function isphone(obj, obj2) {
		$.ajax({
		    type : 'post',
		    url : 'company_keyPersonModefiyPhoneRepCHeck.html',
		    dataType : 'text',
		    data : {"phone" : obj,
		    	"id" : obj2},
		    success : function (date) {
		    	if(date == "0")
		    	{
		    		userIdOk = true;
		    	}
		    	if (date == "1") {
		    		userIdOk = false;
		    	}
		    },
		    error : function (xmlq, errq) {
		    	alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});
	}
	$("#keyPersonAddSubmit").click(function() {
		var name = $("#name2").val().trim();
		var cName = $("#cName2").val().trim();
		var phone = $("#phone2").val().trim();
		var role = $("#role2").val().trim();
		if (name == "") {
			alert("姓名不能为空");
			return false;
		}
		if (cName == "") {
			alert("请填写企业名称");
			return false;
		}
		if (phone == "") {
			alert("手机号不能为空");
			return false;
		}
		else if(phone != "") {
			var phoneReg = $("#phone2").val();
			var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
			if(!myreg.test(phoneReg)) {
				alert("请输入正确的手机号码");
				return false;
			}
			if (userIdOk) {
				alert("手机号码已经被注册");
				return false;
			}
		}
		if (role == "") {
			alert("请选择角色类型");
			return false;
		}
		if (!userIdOk && (name != "") && (cName != "") && (phone != "") && (role != "")) {
			$('form').submit();
		}
	});
	$("#keyPersonModfiySubmit").click(function() {
		var name = $("#kname").val().trim();
		var cName = $("#cName").val().trim();
		var phone = $("#phone").val().trim();
		var role = $("#role").val().trim();
		if (name == "") {
			alert("姓名不能为空");
			return false;
		}
		if (cName == "") {
			alert("请填写企业名称");
			return false;
		}
		if (phone == "") {
			alert("手机号不能为空");
			return false;
		}
		else if(phone != "") {
			var phoneReg = $("#phone").val();
			var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
			if(!myreg.test(phoneReg)) {
				alert("请输入正确的手机号码");
				return false;
			}
			if (userIdOk) {
				alert("手机号码已经被注册");
				return false;
			}
		}
		if (role == "") {
			alert("请选择角色类型");
			return false;
		}
		if (!userIdOk && (name != "") && (cName != "") && (phone != "") && (role != "")) {
			$('form').submit();
		}
	});
});