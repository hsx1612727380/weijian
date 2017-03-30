function skillBigType1()
{
	$.ajax({
	    type : 'post',
	    url : 'team_getSmallSkillType.html',
	    dataType : 'text',
	    data : $('#skillBigType').serialize(),
	    success : function (date) {
	    	var msg = eval("("+date+")");  
	    	$('#smalltype').empty();//先清空原来的option,再添加新的上去
	    	for(var i=0;i<msg.length;i++){
	    		$('#smalltype').prepend('<option value="' + msg[i].skillType + '">'+ msg[i].skillName + '</option>'); 
	    	}
	    },
	    error : function (xmlq, errq){
	    	alert("xmlq:"+xmlq);
	        alert(errq);
	    }
	});
}

