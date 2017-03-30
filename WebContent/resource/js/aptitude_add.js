function adtype1()
{
	$.ajax({
	    type : 'post',
	    url : 'aptitude_getadlevel.html',
	    dataType : 'text',
	    data : $('#adtype').serialize(),
	    success : function (date) {
	    	var msg = eval("("+date+")"); 
	    	$('#level').empty();//先清空原来的,再添加新的上去
	    	for(var i=0;i<msg.length;i++){
	    		$('#level').prepend('<option value="' + msg[i].skillType + '">' + msg[i].skillName + '</option>') 
	    	}
	    },
	    error : function (xmlq, errq) {
	    	alert("xmlq:"+xmlq);
	        alert(errq);
	    }
	});
}

