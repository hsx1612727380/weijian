(function($) {
	var phoneok=false;
	var identityok=false;
	var nameok=false;
	var leaderNameok=false;
	var identityRepok=false;
	$('.checkbox').on('click', function() {
		if($('.checkbox')[0].checked) {
			$('#submit')[0].disabled = false;
		} else {
			$('#submit')[0].disabled = true;
		}
	})
	
	$('#identity').blur(function(){
		var identity=$('#identity').val().replace(/\s/g, "");
	    var len = identity.length;  
	    if(len == '18')  
	    {  
	        var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);   
	        var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');   
	        var cardTemp = 0, i, valnum;   
	        for(i = 0; i < 17; i ++)   
	        {   
	            cardTemp += identity.substr(i, 1) * arrInt[i];   
	        }   
	        valnum = arrCh[cardTemp % 11];   
	        if (valnum == identity.substr(17, 1))   
	        {  
	        	$("#identitydiv").find('span').html("");
	        	 var userId=$("#userId").val().replace(/\s/g, "");
	        	 var identity=$('#identity').val().replace(/\s/g, "");
	        	 if(userId!=""){
	        		 $.ajax({ 
	 				    type : 'post',
	 				    url : 'mobilRepCHeck.html',
	 				    dataType : 'text', 
	 					data : {"userId" :userId},
	 					//date:1  手机号没有被注册过，检测身份证号是否已经注册 a已注册，不能注册  b未注册，不能注册
	 					//date:0  手机号已经注册过，检测身份证号是否与原登记身份证一致  c：原身份证号一致   d不一致，不能注册
	 				    success : function (date) {  
	 				    	if(date=="0")
	 				    	{
	 				    		identitySame(identity,userId);
	 				    		
	 				    	}
	 				    	else if(date=="1"){
	 				    		identityHaveReg(identity);
	 				    		
	 				    	}
	 				    },
	 				    error : function (xmlq, errq) {
	 				    	alert("xmlq:"+xmlq+"errq:"+errq);
	 				    }
	 				}); 
	        	 }
	            return true;  
	        }  
	        $("#identitydiv").find('span').html("请输入真实的身份证号");
	        $("#identitydiv").find('span').css("color","red");
	        return false;  
	    }               
	    $("#identitydiv").find('span').html("身份证号必须为18位");
	    $("#identitydiv").find('span').css("color","red");
	    return false;  
	}	
   )
    
    
    $('#userId').blur(function(){
			var userId=$("#userId").val().replace(/\s/g, "");
			var identity=$("#identity").val().replace(/\s/g, "");
		  	var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
			if(!myreg.test(userId)) {
				$("#userIdDiv").find('span').html("请输入正确手机号码");
	    		$("#userIdDiv").find('span').css("color","red");
			} else {
				$("#userIdDiv").find('span').html("");
				$.ajax({ 
				    type : 'post',
				    url : 'mobilRepCHeck.html',
				    dataType : 'text', 
					data : {"userId" :userId},
					//date:1  手机号没有被注册过，检测身份证号是否已经注册a已注册，不能注册 b未注册，不能注册
					//date:0  手机号已经注册过，检测身份证号是否与原登记身份证一致  a：原身份证号一致 b不一致，不能注册
				    success : function (date) {  
				    	if(date=="0")
				    	{
				    		identitySame(identity,userId);
				    		identityok=true;
 				    		phoneok=true;
				    	}
				    	else if(date=="1"){
				    		identityHaveReg(identity);
				    		identityok=true;
 				    		phoneok=true;
				    	}
				    },
				    error : function (xmlq, errq) {
				    	alert("xmlq:"+xmlq+"errq:"+errq);
				    }
				}); 

			}
    })
    
    $('#name').blur(function(){
			var name=$("#name").val().trim();
			if(name="") {
				$("#namediv").find('span').html("项目名称不能为空");
	        	$("#namediv").find('span').css("color","red");
				return false;
			} else {
				$("#namediv").find('span').html("");
				nameok=true;
			}
    })
    
    
      $('#leaderName').blur(function(){
			var leaderName=$("#leaderName").val().trim();
			if(leaderName="") {
				$("#leaderNamediv").find('span').html("联系人不能为空");
	        	$("#leaderNamediv").find('span').css("color","red");
				return false;
			} else {
				$("#leaderNamediv").find('span').html("");
				leaderNameok=true;
			}
    })
    
    
    
	
	$('#submit').click(function(){
		 if(phoneok && identityok&&leaderNameok&&nameok){
	            $('form').submit();
	        }
		 else if(!nameok)
		 {
			 $("#namediv").find('span').html("项目名称不能为空");
			 $("#namediv").find('span').css("color","red");
			 return false;
		 }
		 else if(!leaderNameok)
		 {
				$("#leaderNamediv").find('span').html("联系人不能为空");
	        	$("#leaderNamediv").find('span').css("color","red");
				return false;
		 }
		 else if(!identityok)
		 {
			 $("#identitydiv").find('span').html("请输入真实身份证号");	
			 $("#identitydiv").find('span').css("color","red");
			 return false;  
		 }
		 else if(!phoneok)
		 {
			 $("#userIdDiv").find('span').html("请输入正确手机号码");
			 $("#userIdDiv").find('span').css("color","red");
			 return false;
		 }
    });
})(jQuery)

function identitySame(identity,userId)
{
	 $.ajax({
		    type : 'post',
		    url : 'identityRep.html',
		    dataType : 'text',
			data : {"identity" : identity,"userId" :userId},
		    success : function (date) {
		    	if(date==0)
		    	{
		    		$("#identitydiv").find('span').html("身份证号码与注册登记的号码不一致");
		    	    $("#identitydiv").find('span').css("color","red");
		    	    return false;
		    	}
		    	else{
		    		$("#identitydiv").find('span').html("");
		    		phoneok=true;
		    		identityok=true;
		    	}
		    },
		    error : function (xmlq, errq) {
		    	alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		}); 

}

function identityHaveReg(identity){
	 $.ajax({
		    type : 'post',
		    url : 'identityHaveReg.html',
		    dataType : 'text',
			data : {"identity" : identity},
		    success : function (date) {
		    	if(date==1)
		    	{
		    		$("#identitydiv").find('span').html("该身份证号已经被注册");
		    	    $("#identitydiv").find('span').css("color","red");
		    	    return false;
		    	}
		    	else{
		    		$("#identitydiv").find('span').html("");
		        	getIDInfo(identity);//获取相关信息
		        	identityok=true;
		    		phoneok=true;
		    	}
		    },
		    error : function (xmlq, errq) {
		    	alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});  
}

