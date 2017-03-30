$(function(){
	var userIdOk = false;
	$('#joinBuildLeaderphone2>input').on('blur', function() {
		isphone2($('#joinBuildLeaderphone2>input').val().trim());
	});
	$('#joinBuildLeaderphone>input').on('blur', function() {
		isphone($('#joinBuildLeaderphone>input').val().trim(), $("#joinBuildId").val().trim());
	});
	function isphone2(obj) {
		$.ajax({
		    type : 'post',
		    url : 'operate_joinBuildAddLeaderphoneRepCHeck.html',
		    dataType : 'text',
		    data : {"leaderphone" : obj},
		    success : function (date) {
		    	if(date == "0") {
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
		    url : 'operate_joinBuildModefiyLeaderphoneRepCHeck.html',
		    dataType : 'text',
		    data : {"leaderphone" : obj,
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
	$("#joinBuildAddSubmit").click(function() {
		var jName = $("#jName2").val().trim();
		var jNum = $("#jNum2").val().trim();
		var leaderphone = $("#leaderphone2").val().trim();
		var jType = $("#jType2").val().trim();
		if (jName == "") {
			alert("请填写单位名称");
			return false;
		}
		if (jNum == "") {
			alert("请填写组织机构代码");
			return false;
		}
		if (leaderphone == "") {
			alert("手机号不能为空");
			return false;
		}
		else if(leaderphone != "") {
			var phone = $("#leaderphone2").val();
			var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
			if(!myreg.test(phone)) {
				alert("请输入正确的手机号码");
				return false;
			}
			if (userIdOk) {
				alert("手机号码已经被注册");
				return false;
			}
		}
		if (jType == "单位类型") {
			alert("请选择单位类型");
			return false;
		}
		if (!userIdOk && (jType != "") && (jName != "") && (jNum != "") && (leaderphone != "")) {
			$('form').submit();
		}
	});
	$("#joinBuildModfiySubmit").click(function() {
		var jType = $("#jType").val().trim();
		var jName = $("#jName").val().trim();
		var jNum = $("#jNum").val().trim();
		var leaderphone = $("#leaderphone").val().trim();
		if (jType == "单位类型") {
			alert("请选择单位类型");
			return false;
		}
		if (jName == "") {
			alert("请填写单位名称");
			return false;
		}
		if (jNum == "") {
			alert("请填写组织机构代码");
			return false;
		}
		if (leaderphone == "") {
			alert("手机号不能为空");
			return false;
		}
		else if(leaderphone != "") {
			var phone = $("#leaderphone").val();
			var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
			if(!myreg.test(phone)) {
				alert("请输入正确的手机号码");
				return false;
			}
			if (userIdOk) {
				alert("手机号码已经被注册");
				return false;
			}
		}
		if (!userIdOk && (jType != "") && (jName != "") && (jNum != "") && (leaderphone != "")) {
			$('form').submit();
		}
	});
});