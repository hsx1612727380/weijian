function skillBigType()
{	
	alert("1111111");
	$.ajax({
	    type : 'post',
	    url : 'mobilRepCHeck.html',
	    dataType : 'text',
	    data : $('#skillBigType').serialize(),
	    success : function (date) {
	    	if(date=="1")
	    	{
	    		document.myForm.mobilPhoneInfo.value="手机号没有被注册";
		    	return true;
	    	}
	    	else{
	    		 document.myForm.mobilPhoneInfo.value='该手机号已经注册！';
	    		 document.myForm.mobilPhone.focus();
	    		return false;
	    	}
	 
	
	    },
	    error : function (xmlq, errq) {
	    	alert("xmlq:"+xmlq);
	        alert(errq);
	    }
	});
}