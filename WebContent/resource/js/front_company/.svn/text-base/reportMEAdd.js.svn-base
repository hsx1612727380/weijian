$(function(){
	var mEAndCmdAddOk;
	$("#existCmdSumm>select").on("blur", function() {
		isMaterialAndCmdSummExist($("#projectId").val().trim(), $("#mECode").val().trim(), $("#year").val().trim(), $("#month").val().trim(), $("#type").val().trim());
	});
	function isMaterialAndCmdSummExist(obj, obj1, obj2, obj3, obj4) {
		$.ajax({
		    type : 'post',
		    url : 'project_addReportTeamAndCmdRepCHeck.html',
		    dataType : 'text',
		    data : {"projectId" : obj,
		    	"code" : obj1,
		    	"year" : obj2,
		    	"month" : obj3,
		    	"type" : obj4},
		    success : function (date) {
		    	if (date == "0"){
		    		mEAndCmdAddOk = "0"; //cmdSummModel中没有记录
		    	}
		    	if (date == "1") {
		    		mEAndCmdAddOk = "1"; //cmdSummModel中有记录
		    	}
		    	if (date == "2") {
		    		mEAndCmdAddOk = "2"; //MaterialModel或EquipmentModel中班组存在
		    	}
		    	if (date == "3") {
		    		mEAndCmdAddOk = "3"; //MaterialModel或EquipmentModel中班组不存在
		    	}
		    },
		    error : function (xmlq, errq) {
		    	//alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});
	}
	$("#addReportMESubmit").on('click',function() {
		var mECode = $("#mECode").val().trim();
		var year = $("#year").val().trim();
		var month = $("#month").val().trim();
		if (mECode == "") {
			alert("编号不能为空");
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
		if (mEAndCmdAddOk === "3") {
			alert("该班组不存在，请输入正确的班组的编号");
			return false;
		}
		if (mEAndCmdAddOk === "1") {
			alert("该班组在这个项目这个月的数据已存在，不能再次添加");
			return false;
		}
	});
	$('#mECode').on('blur',function(){
		$("#year").val("请选择年份"); 
		$("#month").val("请选择月份"); 
	});
});