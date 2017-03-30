$(function(){
	$('.detailbar>li:even').css('background-color','#DBE5F1');
	$('#demo').on('click',function(){
		$('.demo').show();
	})
})
 
	/*判断身份证号有效性*/
	function checkIdentity()  
	{  
		var identity=$('#userIdentity1').val();
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
	        	 $("#userIdentity").find('span').html("");
	        	getIDInfo(identity);//获取相关信息
	            return true;  
	        }  
	        $("#userIdentity").find('span').html("请输入正确的身份证号");
	        $("#userIdentity").find('span').css("color","red");
	        $("#userIdentity").focus();
	        return false;  
	    }               
	    $("#userIdentity").find('span').html("身份证号必须为18位数字");
	    $("#userIdentity").find('span').css("color","red");
	    $("#userIdentity").focus();
	    return false;  
	}; 

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
	  /*   $("#txtAge").val(age);  */ 
	} 
	
