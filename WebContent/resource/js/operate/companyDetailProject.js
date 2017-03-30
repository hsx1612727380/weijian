$(function(){
	var userIdOk = false;
	$('#projectUserId>input').on('blur', function() {
		var userId1 = $('#projectUserId>input').val().trim();
		var leaderName1 = $("#projectLeaderName>input").val().trim();
		isphone(userId1, leaderName1);
	});
	function isphone(obj, obj2) {
		$.ajax({
		    type : 'post',
		    url : 'operate_projectUserIdReg.html',
		    dataType : 'text',
		    data : {"userId" : obj,
		    	"leaderName" : obj2},
		    success : function (date) {
		    	if(date == "0") {
		    		userIdOk = true;
		    	}
		    	else {
		    		userIdOk = false;
		    	}
		    },
		    error : function (xmlq, errq) {
		    	//alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});
	}
	
	$("#baseInfoModfiySubmit").click(function() {
		if (userIdOk) {
			alert("修改手机号已经注册过了");
			return false;
		}
		var name = $("#name").val().trim();
		var price = $("#price").val().trim();
		var prepaid = $("#prepaid").val().trim();
		var province = $("#province").val().trim();
		var city = $("#city").val().trim();
		var street = $("#street").val().trim();
		var leaderName = $("#leaderName").val().trim();
		var userId = $("#userId").val().trim();
		if (name == "") {
			alert("项目名称不能为空");
			return false;
		}
		if (price == "") {
			alert("合同价不能为空");
			return false;
		}
		if (prepaid == "") {
			alert("预付款不能为空");
			return false;
		}
		if (province == "") {
			alert("请选择省份");
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
			alert("请填写具体地址");
			return false;
		}
		if (leaderName == "") {
			alert("项目负责人不能为空");
			return false;
		}
		if (userId == "") {
			alert("项目负责人联系方式不能为空");
			return false;
		} else if(userId != "") {
			var phone = $("#userId").val();
			var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
			if(!myreg.test(phone)) {
				alert("请输入正确的手机号码");
				return false;
			}
		}
	});
	
});