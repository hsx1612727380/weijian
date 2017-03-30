(function($) {
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
		} else {
			$("#userPassword").find('span').html("");
		}
	})
	$('#logsure>input').on('blur',function(){
		var reg=/^[a-zA-Z]\w{5,17}$/;
		if($('#logsure>input').val()!=$('#userPassword>input').val()) {
			$("#logsure").find('span').html("与登陆密码不一致");
		} else {
			$("#logsure").find('span').html("");
		}
	})
	function isphone(obj) {
//		var reg = /^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/;
	    var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
		if(!myreg.test(obj)) {
			$("#userId").find('span').html("请输入正确的手机号码");
			$("#userId1").fous();
		} else {
			$("#userId").find('span').html("");
		}
		$.ajax({
		    type : 'post',
		    url : 'mobilRepCHeck.html',
		    dataType : 'text',
		    data : $('#userId1').serialize(),
		    success : function (date) {
		    	if(date=="1")
		    	{
		    		$("#userId").find('span').html("手机号没有被注册");
		    		$("#userId").find('span').css("color:green");
		    	}
		    	else{
		    		$("#userId").find('span').html("该手机号已经注册！");
		    	}
		    },
		    error : function (xmlq, errq) {
		    	alert("xmlq:"+xmlq);
		        alert(errq);
		    }
		});
	}
	
	function isEmpty(value) {
		return /^\s*$/.test(value);
	}
	$('#userType>input').on('blur',function() {
		if(isEmpty(document.myForm.userType.value)){
			$("#userType").find('span').html("请选择用户类型");
			return false;
		}
		else {
			$("#userType").find('span').html("");
		}
	})

})(jQuery)