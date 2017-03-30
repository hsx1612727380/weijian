$(function(){
	var posterIdentityOK = "0";
	var posterPhoneOK = "0";
	$("#posterIdentity>input").on("blur", function() {
		isPosterIdentity($("#identity").val().trim());
	});
	$("#posterPhone>input").on("blur", function() {
		isPosterPhone($("#phone").val().trim());
	});
	function isPosterIdentity(obj) {
		$.ajax({
		    type : 'post',
		    url : 'project_posterIdentityReg.html',
		    dataType : 'text',
		    data : {"identity" : obj},
		    success : function (date) {
		    	posterIdentityOK = date;
		    	//alert("posterIdentityOK = " + posterIdentityOK);
		    },
		    error : function (xmlq, errq) {
		    	//alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});
	}
	function isPosterPhone(obj) {
		$.ajax({
		    type : 'post',
		    url : 'project_posterPhoneReg.html',
		    dataType : 'text',
		    data : {"phone" : obj},
		    success : function (date) {
		    	posterPhoneOK = date;
		    	//alert("posterPhoneOK = " + posterPhoneOK);
		    },
		    error : function (xmlq, errq) {
		    	//alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});
	}
	$("#projectPosterAddSubmit").click(function() {
		var name = $("#name").val().trim();
		var position = $("#position").val().trim();
		var identity = $("#identity").val().trim();
		var address = $("#address").val().trim();
		var phone = $("#phone").val().trim();
		if (name == "") {
			alert("项目人员姓名不能为空");
			return false;
		}
		if (position == "") {
			alert("项目人员职位不能为空");
			return false;
		}
		if (identity == "") {
			alert("项目人员身份证不能为空");
			return false;
		} 
		else {
			var identityReg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
			if(identityReg.test(identity) === false) {  
			    alert("身份证输入不合法");  
			    return false;  
			}
			if (posterIdentityOK === "1") {
				alert("该身份证已经注册过了");
				return false;
			}
		}
		if (address == "") {
			alert("项目人员的地址不能为空");
			return false;
		}
		if (phone == "") {
			alert("项目人员的手机号不能为空");
			return false;
		}
		else {
			var phoneReg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;  
			if(phoneReg.test(phone) === false) {  
			    alert("手机号输入不合法");  
			    return  false;  
			}
			if (posterPhoneOK === "1") {
				alert("该手机号已经注册过了");
				return false;
			}
		}
	});
});