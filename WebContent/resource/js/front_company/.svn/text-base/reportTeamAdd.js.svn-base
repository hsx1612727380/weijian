$(function(){
	var teamAndCmdAddOk;
	$("#existCmdSumm>select").on("blur", function() {
		isTeamAndCmdSummExist($("#projectId").val().trim(), $("#teamCode").val().trim(), $("#year").val().trim(), $("#month").val().trim(), $("#type").val().trim());
	});
	function isTeamAndCmdSummExist(obj, obj1, obj2, obj3, obj4) {
		$.ajax({
		    type : 'post',
		    url : 'operate_addReportTeamAndCmdRepCHeck.html',
		    dataType : 'text',
		    data : {"projectId" : obj,
		    	"code" : obj1,
		    	"year" : obj2,
		    	"month" : obj3,
		    	"type" : obj4},
		    success : function (date) {
		    	if (date == "0"){
		    		teamAndCmdAddOk = "0"; //cmdSummModel中没有记录
		    	}
		    	if (date == "1") {
		    		teamAndCmdAddOk = "1"; //cmdSummModel中有记录
		    	}
		    	if (date == "2") {
		    		teamAndCmdAddOk = "2"; //TeamModel中班组存在
		    	}
		    	if (date == "3") {
		    		teamAndCmdAddOk = "3"; //TeamModel中班组不存在
		    	}
		    },
		    error : function (xmlq, errq) {
		    	//alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});
	}
	$("#addReportTeamSubmit").on('click',function() {
		var teamCode = $("#teamCode").val().trim();
		var year = $("#year").val().trim();
		var month = $("#month").val().trim();
		if (teamCode == "") {
			alert("班组的编号不能为空");
			return false;
		}
		if (year == "请选择年份") {
			alert("请选择年份");
			return false;
		}
		if (month == "请选择月份") {
			alert("请选择月份");
			return false;
		}
		if (teamAndCmdAddOk === "3") {
			alert("该班组不存在，请输入正确的班组的编号");
			return false;
		}
		if (teamAndCmdAddOk === "1") {
			alert("该班组在这个项目这个月的数据已存在，不能再次添加");
			return false;
		}
	});
	$('#teamCode').on('blur',function(){
		$("#year").val("请选择年份"); 
		$("#month").val("请选择月份"); 
	});
});