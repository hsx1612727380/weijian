$(function() {
	var userIdOk;
	$("#userIdIsExist>input").on('blur', function() {
		var cmdId = $("#cmdId").val().trim();
		var pId = $("#pId").val().trim();
		var tId = $("#tId").val().trim();
		var userId = $("#userId").val().trim();
		var teamtype = $("#teamtype").val().trim();
		var year = $("#year").val().trim();
		var month = $("#month").val().trim();
		isUserExist(cmdId, pId, tId, userId, teamtype, year, month); // 判断用户是否在存在User表中，还需判断用户是否与对应的Team相关联，判断当前月份是否已经存在着记录
	});
	function isUserExist(obj1, obj2, obj3, obj4, obj5, obj6, obj7) {
		$.ajax({
		    type : 'post',
		    url : 'project_isUserExist.html',
		    dataType : 'text',
		    data : {"cmdId" : obj1,
		    	"pId" : obj2,
		    	"tId" : obj3,
		    	"userId" : obj4,
		    	"teamtype" : obj5,
		    	"year" : obj6,
		    	"month" : obj7},
		    success : function (date) {
		    	if(date == "0") {
		    		userIdOk = "0";
		    	}
		    	else if (date == "1") {
		    		userIdOk = "1";
		    	}
		    	else if (date == "2") {
		    		userIdOk = "2";
		    	}
		    	else if (date == "3") {
		    		userIdOk = "3";
		    	}
		    	else if (date == "4") {
		    		userIdOk = "4";
		    	}
		    	else {
		    		userIdOk = "5";
		    	}
		    },
		    error : function (xmlq, errq) {
		    	alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});
	}
	$("#addReportTeamDetailSubmit").click(function() {
		var userId = $("#userId").val().trim();
		if (userId == "") {
			alert("工作人员的名称不能为空");
			return false;
		}
		else if (userId != "") {
			var phone = $("#userId").val().trim();
			var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
			if(!myreg.test(phone)) {
				alert("请输入正确的手机号码");
				return false;
			}
		}
		if (userIdOk == "0") {
			alert("该用户不存在");
			return false;
		}
		else if (userIdOk == "2") {
			alert("该用户存在，但是不存在对应的班组中");
			return false;
		}
		else if (userIdOk == "4") {
			alert("添加的记录在改月份已经存在数据");
			return false;
		}
	});
});