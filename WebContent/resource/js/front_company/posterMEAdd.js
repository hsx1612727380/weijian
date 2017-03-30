$(function(){
	var posterCodeOK = "0";
	var posterUserIdOK = "0";
	$("#posterCode>input").on("blur", function() {
		isPosterCode($("#code").val().trim(), $("#type").val().trim(), $("#mePId").val().trim());
	});
	$("#posterUserId>input").on("blur", function() {
		isPosterUserId($("#userId").val().trim(), $("#type").val().trim());
	});
	function isPosterCode(obj, obj2, obj3) {
		$.ajax({
		    type : 'post',
		    url : 'project_posterMECodeReg.html',
		    dataType : 'text',
		    data : {"code" : obj,
		    	"type" : obj2,
		    	"pId" : obj3},
		    success : function (date) {
		    	posterCodeOK = date;
		    },
		    error : function (xmlq, errq) {
		    	//alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});
	}
	function isPosterUserId(obj, obj2) {
		$.ajax({
		    type : 'post',
		    url : 'project_posterMEUserIdReg.html',
		    dataType : 'text',
		    data : {"userId" : obj,
		    	"type" : obj2},
		    success : function (date) {
		    	posterUserIdOK = date;
		    },
		    error : function (xmlq, errq) {
		    	//alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});
	}
	$("#projectMEAddSubmit").click(function() {
		var name = $("#name").val().trim();
		var code = $("#code").val().trim();
		var licence = $("#licence").val().trim();
		var shopName = $("#shopName").val().trim();
		var province = $("#province").val().trim();
		var city = $("#city").val().trim();
		var street = $("#street").val().trim();
		var leaderName = $("#leaderName").val().trim();
		var userId = $("#userId").val().trim();
		if (name == "") {
			alert("供应商名称不能为空");
			return false;
		}
		if (code == "") {
			alert("供应商机构代码不能为空");
			return false;
		} else {
			if (posterCodeOK === "1") {
				setTimeout(alert(" 该供应商已经注册过了\n已把该供应商加入贵公司"), 1000);
				return true;
			}
			else if (posterCodeOK === "2") {
				setTimeout(alert("该供应商已经加入贵公司了"), 1000);
				return true;
			}
		}
		if (licence == "") {
			alert("统一社会信用代码不能为空");
			return false;
		}
		if (shopName == "") {
			alert("供应材料/设备名称不能为空");
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
		if (street == "") {
			alert("供应商地址街道不能为空");
			return false;
		}
		if (leaderName == "") {
			alert("供应商联系人不能为空");
			return false;
		}
		if (userId == "") {
			alert("供应商的联系方式不能为空");
			return false;
		} else {
			var userIdReg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;  
			if(userIdReg.test(userId) === false) {  
			    alert("联系方式输入不合法");  
			    return false;  
			}
			if (posterUserIdOK === "1") {
				alert("       该手机号已经注册过了\n请输入正确的供应商机构代码或手机号");
				return false;
			}
		}
	});
	
});