function projectTeamAgreeAll() {
	var ids = "";
	for(var i=0;i<$(".isSelected").length;i++){
		var isSelected = $(".isSelected").eq(i).prop("checked");
		if (isSelected) {
			ids += $(".isSelected").eq(i).parent().siblings('.cursorIdTeam').val() + "&";
		}
	}
	ids = ids.substring(0, ids.length-1);
	$.ajax({
		type : 'post',
		url : 'project_teamAgreeAll.html',
		dataType : 'text',
		data : {"ids" : ids},
		success : function (date) {
			if (date == 1) {
				window.location.reload(true);
			}
			else {
				alert("请选择要批量同意的施工班组");
			}
		},
		error : function (xmlq, errq) {
			//alert("请选择要批量同意的施工班组");
		}
	});
};


function projectTeamRejectAll() {
	var ids = "";
	for(var i=0;i<$(".isSelected").length;i++){
		var isSelected = $(".isSelected").eq(i).prop("checked");
		if (isSelected) {
			ids += $(".isSelected").eq(i).parent().siblings('.cursorIdTeam').val() + "&";
		}
	}
	ids = ids.substring(0, ids.length-1);
	$.ajax({
		type : 'post',
		url : 'project_teamRejectAll.html',
		dataType : 'text',
		data : {"ids" : ids},
		success : function (date) {
			if (date == 1) {
				window.location.reload(true);
			}
			else {
				alert("请选择要批量拒绝的施工班组");
			}
		},
		error : function (xmlq, errq) {
			//alert("请选择要批量拒绝的施工班组");
		}
	});
}

function projectMaterialAgreeAll() {
	var ids = "";
	for(var i=0;i<$(".isSelected2").length;i++){
		var isSelected = $(".isSelected2").eq(i).prop("checked");
		if (isSelected) {
			ids += $(".isSelected2").eq(i).parent().siblings('.cursorIdMaterial').val() + "&";
		}
	}
	ids = ids.substring(0, ids.length-1);
	$.ajax({
		type : 'post',
		url : 'project_materialAgreeAll.html',
		dataType : 'text',
		data : {"ids" : ids},
		success : function (date) {
			if (date == 1) {
				window.location.reload(true);
			}
			else {
				alert("请选择要批量同意的材料商");
			}
		},
		error : function (xmlq, errq) {
			//alert("请选择要批量同意的材料商");
		}
	});
};

function projectMaterialRejectAll() {
	var ids = "";
	for(var i=0;i<$(".isSelected2").length;i++){
		var isSelected = $(".isSelected2").eq(i).prop("checked");
		if (isSelected) {
			ids += $(".isSelected2").eq(i).parent().siblings('.cursorIdMaterial').val() + "&";
		}
	}
	ids = ids.substring(0, ids.length-1);
	$.ajax({
		type : 'post',
		url : 'project_materialRejectAll.html',
		dataType : 'text',
		data : {"ids" : ids},
		success : function (date) {
			if (date == 1) {
				window.location.reload(true);
			}
			else {
				alert("请选择要批量拒绝的材料商");
			}
		},
		error : function (xmlq, errq) {
			//alert("请选择要批量拒绝的材料商");
		}
	});
};

function projectEquipmentAgreeAll() {
	var ids = "";
	for(var i=0;i<$(".isSelected3").length;i++){
		var isSelected = $(".isSelected3").eq(i).prop("checked");
		if (isSelected) {
			ids += $(".isSelected3").eq(i).parent().siblings('.cursorIdEquipment').val() + "&";
		}
	}
	ids = ids.substring(0, ids.length-1);
	$.ajax({
		type : 'post',
		url : 'project_equipmentAgreeAll.html',
		dataType : 'text',
		data : {"ids" : ids},
		success : function (date) {
			if (date == 1) {
				window.location.reload(true);
			}
			else {
				alert("请选择要批量同意的材料商");
			}
		},
		error : function (xmlq, errq) {
			//alert("请选择要批量同意的材料商");
		}
	});
};

function projectEquipmentRejectAll() {
	var ids = "";
	for(var i=0;i<$(".isSelected3").length;i++){
		var isSelected = $(".isSelected3").eq(i).prop("checked");
		if (isSelected) {
			ids += $(".isSelected3").eq(i).parent().siblings('.cursorIdEquipment').val() + "&";
		}
	}
	ids = ids.substring(0, ids.length-1);
	$.ajax({
		type : 'post',
		url : 'project_equipmentRejectAll.html',
		dataType : 'text',
		data : {"ids" : ids},
		success : function (date) {
			if (date == 1) {
				window.location.reload(true);
			}
			else {
				alert("请选择要批量拒绝的材料商");
			}
		},
		error : function (xmlq, errq) {
			//alert("请选择要批量拒绝的材料商");
		}
	});
};
