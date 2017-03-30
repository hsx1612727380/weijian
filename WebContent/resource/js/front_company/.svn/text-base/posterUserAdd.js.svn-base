$(function(){
	var posterUserIdentityOK = "0";
	var posterUserIdOK = "0";
	$("#posterUserIdentity>input").on("blur", function() {
		isPosterUserIdentity($("#userIdentity").val().trim());
	});
	$("#posteUserId>input").on("blur", function() {
		isPosterUserId($("#userId").val().trim());
	});
	function isPosterUserIdentity(obj) {
		$.ajax({
		    type : 'post',
		    url : 'project_posterUserIdentityReg.html',
		    dataType : 'text',
		    data : {"userIdentity" : obj},
		    success : function (date) {
		    	posterUserIdentityOK = date;
		    },
		    error : function (xmlq, errq) {
		    	//alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});
	}
	function isPosterUserId(obj) {
		$.ajax({
		    type : 'post',
		    url : 'project_posterUserIdReg.html',
		    dataType : 'text',
		    data : {"userId" : obj},
		    success : function (date) {
		    	posterUserIdOK = date;
		    },
		    error : function (xmlq, errq) {
		    	//alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});
	}
	$("#userPosterAddSubmit").click(function() {
		var teamName = $("#teamName").val().trim();
		var userName = $("#userName").val().trim();
		var skillBigType = $("#skillBigType").val().trim();
		var skillSmallType = $("#skillSmallType").val().trim();
		var userIdentity = $("#userIdentity").val().trim();
		var province = $("#province").val().trim();
		var city = $("#city").val().trim();
		var userStreet = $("#userStreet").val().trim();
		var userId = $("#userId").val().trim();
		if (teamName == "") {
			alert("请选择班组");
			return false;
		}
		if (userName == "") {
			alert("工人的名字必填");
			return false;
		}
		if (skillBigType == "") {
			alert("请选择技能类别");
			return false;
		}
		if (skillSmallType == "") {
			alert("请选择技能类型");
			return false;
		}
		if (userIdentity == "") {
			alert("工人的身份证不能为空");
			return false;
		}
		else {
			var userIdentityReg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
			if(userIdentityReg.test(userIdentity) === false) {  
			    alert("身份证输入不合法");  
			    return false;  
			}
			if (posterUserIdentityOK === "1") {
				alert("该身份证已经注册过了");
				return false;
			}
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
		if (userStreet == "") {
			alert("地址街道不能为空");
			return false;
		}
		if (userId == "") {
			alert("工人的手机号不能为空");
			return false;
		}
		else {
			var userIdReg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;  
			if(userIdReg.test(userId) === false) {  
			    alert("手机号输入不合法");  
			    return  false;  
			}
			if (posterUserIdOK === "1") {
				alert("该手机号已经注册过了");
				return false;
			}
		}
	});
});