function getAdlevel() {
	var adType=$('#adtype').val().trim();
	$.ajax({
	    type : 'post',
	    url : 'company_getAdType.html',
	    dataType : 'text',
	    data : {"adType" : adType},
	    success : function (date) {
	    	var msg = eval("("+date+")");
	    	$('#adlevel').empty();
	    	$('#adlevel').prepend('<option selected="selected">' + "--请选择等级--" + '</option>');
	    	for(var i = 0; i < msg.length; i++){
	    		$('#adlevel').prepend('<option value="' + msg[i].adlevelType + '">' + msg[i].adlevelName + '</option>');
	    	}
	    },
	    error : function (xmlq, errq) {
	    	alert("xmlq:"+xmlq);
	    }
	});
}
