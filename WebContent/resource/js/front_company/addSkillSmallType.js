function getTeamSkillSmallType() {
	var skillBigType = $('#skillBigType').val();
	$.ajax({
	    type : 'post',
	    url : 'project_getTeamSkillSmallType.html',
	    dataType : 'text',
	    data : {"skillBigType" : skillBigType},
	    success : function (date) {
	    	var msg = eval("("+date+")");
	    	$('#skillSmallType').empty();
	    	$('#skillSmallType').prepend('<option selected="selected">' + "--请选择技能类型--" + '</option>');
	    	for(var i = 0; i < msg.length; i++){
	    		$('#skillSmallType').prepend('<option value="' + msg[i].teamSkillSmallType + '">' + msg[i].teamSkillSmallName + '</option>');
	    	}
	    },
	    error : function (xmlq, errq) {
	    	alert("xmlq:"+xmlq);
	        alert(errq);
	    }
	});
}
