function skillBigType1()
{
	$.ajax({
	    type : 'post',
	    url : 'user_getSmallSkillType.html',
	    dataType : 'text',
	    data : $('#skillBigType').serialize(),
	    success : function (date) {
	    	var msg = eval("("+date+")");  
	    	$('#smalltype').empty();
	    	$('#smalltype').prepend('<option selected="selected">' + "--请选择细分技能--" + '</option>');
	    	for(var i=0;i<msg.length;i++){
	    		$('#smalltype').prepend('<option value="' + msg[i].skillType + '">' + msg[i].skillName + '</option>') 
	    	}                           
	    },
	    error : function (xmlq, errq) {
	    	alert("xmlq:"+xmlq);
	        alert(errq);
	    }
	});
}

