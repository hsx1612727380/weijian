/*判断是否为数字*/
	function isNumber(str) {
		var Letters = "1234567890";
		for (var i = 0; i < str.length; i = i + 1) {
			var CheckChar = str.charAt(i);
			if (Letters.indexOf(CheckChar) == -1) {
				return false;
			}
		}
		return true;
	}
	/*判断是否为Email*/
	function isEmail(str) {
		var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/;
		if (myReg.test(str)) {
			return true;
		}
		return false;
	}
	/*判断是否为空*/
	function isEmpty(value) {
		return /^\s*$/.test(value);
	}
	
	function userType()
	{
		
	}
	/**
	 * 检查用户类型
	 * @returns {Boolean}
	 */
	function userTypeCheck() {
		if(isEmpty(document.myForm.userType.value)){
			document.myForm.userType.focus();
			document.myForm.userTypeInfo.value="请选择用户类型";
			return false;
		}
		else
		{
			document.myForm.userTypeInfo.value="*";
		}
	}
	/*验证手机号格式*/
	function validatemobile(mobile) 
  	 { 
	       if(mobile.length==0) 
	       { 
	          alert('请输入手机号码！'); 
	          document.myForm.mobilPhoneInfo.value='请输入手机号码！';
	          document.myForm.mobilPhone.focus(); 
	          return false; 
	       }     
	       if(mobile.length!=11) 
	       { 
	           alert('手机号码必须为11位！'); 
	           document.myForm.mobilPhoneInfo.value='手机号码必须为11位！';
	           document.myForm.phone.focus(); 
	           return false; 
	       } 
	        
	       var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
	       if(!myreg.test(mobile)) 
	       { 
	           alert('请输入有效的手机号码！'); 
	           document.myForm.mobilPhoneInfo.value='请输入有效的手机号码！';
	           document.myForm.phone.focus(); 
	           return false; 
	       } 
	       return true;
   	} 
	/**
	 * 验证手机号
	 * @param identity
	 * @returns {Boolean}
	 */
	 function mobilPhoneCheck()
	  { 
			
			

		 		if(!validatemobile(document.myForm.mobilPhone.value)){
					/*alert("手机号格式不正确！");  */
		 			document.myForm.mobilPhoneInfo.focus();
					return false;
				}
		 		else{
		 			document.myForm.mobilPhoneInfo.value="*";
		 		}
		 		$.ajax({
				    type : 'post',
				    url : 'mobilRepCHeck.html',
				    dataType : 'text',
				    data : $('#mobilPhone').serialize(),
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
	      }1
	 /**
	  * 验证密码
	  * @param identity
	  * @returns {Boolean}
	  */

	//Validate password
	function passCheck(){       
		var userpass = document.myForm.password.value;
		var ruserpass = document.myForm.repassword.value;
		var illegalChars = /[\W_]/;// allow only charactors and numbers
		// Check if Password field is blank.
		if(isEmpty(userpass)){
			document.myForm.passwordInfo.value="请输入密码";
			document.myForm.password.focus();
			return false;
		}
		if(isEmpty(ruserpass)){
			document.myForm.repassword.focus();
			return false;
		}
		if(userpass.length < 6){
			alert("密码必须多于或等于 6 个字符。\n");
			document.myForm.passwordInfo.value="密码必须多于或等于 6 个字符。";
			document.myForm.password.focus();
		    return false;
		}
		//check if password contain illigal charactors.
		else if(illegalChars.test(userpass)){
			alert("密码包含非法字符");
			document.myForm.passwordInfo.value="密码只能含有英文字符和数字";
			document.myForm.password.focus();
			return false;
		}
		
		else if(userpass != ruserpass){
			alert("两次输入的密码不一致");
			document.myForm.passwordInfo.value="两次输入的密码不一致";
			document.myForm.password.focus();
			return false;
		}
		return true;
	}
	 
	 
	 
	 
	 
	 
	/*判断身份证号有效性*/
	function checkIdentity(identity)  
	{  
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
	        	getIDInfo(identity);//获取年龄
	            return true;  
	        }  
	        document.myForm.identityInfo.value="请输入正确的身份证号";
			document.myForm.identity.focus();
	        return false;  
	    }               
	    document.myForm.identityInfo.value="身份证号为18位数字";
		document.myForm.identity.focus()
	    return false;  
	};  
	
	/*
	根据身份证取年龄，性别  
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
	    	document.myForm.userSex.value=1;
	    }
	    else if(gender==2){
	    	document.myForm.userSex.value=2;
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
	  /*   $("#txtAge").val(age);  */ 
	  alert(birth);
	  alert(age);
	  
	} 

	
	
	

	
	function check(){
		mobilPhoneCheck();
		passCheck();
		userTypeCheck();
	}	