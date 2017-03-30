(function($) {
	var phoneok=false;
	var passwordok=false;
	var repasswordok=false;
	var userType=false;
	var identityok=false;
	$('#userId>input').on('blur', function() {
		isphone($('#userId>input').val());
	})
	$('.checkbox').on('click', function() {
		if($('.checkbox')[0].checked) {
			$('#submit')[0].disabled = false;
		} else {
			$('#submit')[0].disabled = true;
		}
	})
	$('#userPassword>input').on('blur',function(){
		var reg=/^[0-9A-Za-z]{6,18}$/;
		if(!reg.test($('#userPassword>input').val())) {
			$("#userPassword").find('span').html("密码长度应为6-18位");
    		$("#userPassword").find('span').css("color","red");
		} else {
			$("#userPassword").find('span').html("");
			passwordok=true;
		}
	})
	$('#logsure>input').on('blur',function(){
		var reg=/^[a-zA-Z]\w{5,17}$/;
		if($('#logsure>input').val()!=$('#userPassword>input').val()) {
			$("#logsure").find('span').html("与登陆密码不一致");
    		$("#logsure").find('span').css("color","red");
		} else {
			$("#logsure").find('span').html("");
			repasswordok=true;
		}
	})
	function isphone(obj) {
		var myreg = /^(((13[0-9]{1})|(14[0-9]{1})||(19[0-9]{1})||(17[0-9]{1})||(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
		obj=obj.replace(/\s/g, "");
		if(!myreg.test(obj)) {
			$("#userId").find('span').html("请输入正确的手机号码");
    		$("#userId").find('span').css("color","red");
			$("#userId1").fous();
		} else {
			$("#userId").find('span').html("");
		}
		$.ajax({
		    type : 'post',
		    url : 'mobilRepCHeck.html',
		    dataType : 'text',
		    data : {"userId":obj},
		    success : function (date) {
		    	if(date=="1")
		    	{
		    		$("#userId").find('span').html("手机号没有被注册");
		    		$("#userId").find('span').css("color","green");
		    		phoneok=true;
		    	}
		    	else{
		    		$("#userId").find('span').html("该手机号已经注册！");
		    		$("#userId").find('span').css("color","red");
		    	}
		    },
		    error : function (xmlq, errq) {
		    	//alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});
	}
	
	function isEmpty(value) {
		return /^\s*$/.test(value);
	}
	$('#userType>select').on('blur',function() {
		var num=$('#type').prop('selectedIndex');
		if(num==0){
			$("#userType").find('span').html("请选择用户类型");
			$('#type').focus();
		}
		else {
			$("#userType").find('span').html("");
			userType=true;
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
        			    	    $("#identity").focus();
        			    	    
        			    	    return false;
        			    	}
        			    	else{
        			    		$("#identitydiv").find('span').html("");
        			        	identityok=true;
        			        	getIDInfo(identity);//获取相关信息
        			    	}
        			    },
        			    error : function (xmlq, errq) {
        			    	//alert("xmlq:"+xmlq+"errq:"+errq);
        			    }
        			});    
	                return true;  
	        }  
	        $("#identitydiv").find('span').html("请输入真实的身份证号");
	        $("#identitydiv").find('span').css("color","red");
	        $("#identitydiv").focus();
	        return false;  
	    }               
	    $("#identitydiv").find('span').html("身份证号必须为18位数字");
	    $("#identitydiv").find('span').css("color","red");
	    $("#identitydiv").focus();
	    return false;  
	}	
   )
	
	$('#submit').click(function(){
        if(phoneok && passwordok&& repasswordok&&userType&&identityok){
            $('form').submit();
        }else if(!phoneok){	
        	$("#userId").find('span').html("请输入正确的手机号码");
        	$("#userId").find('span').css("color","red");
        	return false;
        }
        else if(!identityok){	
//        	alert(123);
        	$("#identitydiv").find('span').html("请输入真实的身份证号");
 	        $("#identitydiv").find('span').css("color","red");
 	        $("#identity").focus();
 	        return false;
        }
        else if(!passwordok){
        	$("#userPassword").find('span').html("密码长度应为6-18位");
        	$("#userPassword").find('span').css("color","red");
            return false;
        }else if(!repasswordok){
        	$("#logsure").find('span').html("密码不一致");
        	$("#logsure").find('span').css("color","red");
            return false;
        }
        else if(!userType){
        	$("#userType").find('span').html("请选择用户类型");
        	$("#userType").find('span').css("color","red");
            return false;
        }
        else{
        	return false;
        }
    });
})(jQuery)

	/**
	 * 根据身份证获取年龄、性别、出生日期，户籍所在地
	 * @param identity
	 */
	function getIDInfo(identity) {  
	    //获取输入身份证号码  
	    var ic = identity; 
	   /*  ic = checkId(ic);  
	    if (isNaN(ic)) return;   */
	    var ic = String(ic);  
	    //获取出生日期  
	    var birth = ic.substring(6, 10) + "-" + ic.substring(10, 12) + "-" + ic.substring(12, 14);  
	    //获取性别  
	    var gender = ic.slice(14, 17) % 2 ? "1" : "2"; // 1代表男性，2代表女性  
	    if(gender==1){
	    	$("#userSex").val("1");
	    }
	    else if(gender==2){
	    	$("#userSex").val("2");
	    }
	    var sexOption = document.getElementsByName("rabSex");  
	    for (var i = 0; i < sexOption.length; i++) {  
	        if (sexOption[i].value == gender) {  
	            sexOption[i].checked = true;  
	            break;  
	        }  
	    }  
	    //获取年龄  
	    var myDate = new Date();  
	    var month = myDate.getMonth() + 1;  
	    var day = myDate.getDate();  	
	    var age = myDate.getFullYear() - ic.substring(6, 10) - 1;  
	    if (ic.substring(10, 12) < month || ic.substring(10, 12) == month && ic.substring(12, 14) <= day) {  
	        age++;  
	    }  
	    $("#age").val(age);
	} 
