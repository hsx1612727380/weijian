$(function(){
	var ok1 = false; //密码长度应为6-18位
	var ok2 = false; //密码正确or错误
	var ok3 = false; //密码不一致
	var ok4 = false; //与原密码不一致
	$('#newPass>input').on('blur', function() {
		var reg = /^[0-9A-Za-z]{6,18}$/;
		if (!reg.test($('#newPass>input').val())) {
			$("#newPass").find('span').html("密码长度应为6-18位");
			$("#newPass").find('span').css("color","red");
		} else {
			$("#newPass").find('span').html("");
			ok1 = true;
		}
		
		var oldpassword = $("#password").val();
		var newpassword = $("#newpassword").val();
		if (oldpassword != newpassword) {
			ok4 = true;
		} else {
			$("#newPass").find('span').html("不能与原密码相同");
			$("#newPass").find('span').css("color","red");
			ok4 = false;
		}
	});
	
	$('#repass>input').on('blur', function() {
		if ($('#repass>input').val() != $('#newPass>input').val()) {
			$("#repass").find('span').html("密码不一致");
			$("#repass").find('span').css("color","red");
		} else {
			$("#repass").find('span').html("");
			ok3=true;
		}
	});

	$('#pass>input').on('blur', function() {
		var password = $('#password').val();
		var datapassword = $('#datapassword').val();
		if (password != datapassword) {
			$("#pass").find('span').html("密码错误");
			$("#pass").find('span').css("color", "red");
			$("#password").focus();
		} else {
			$("#pass").find('span').html("密码正确");
			$("#pass").find('span').css("color", "green");
			ok2=true;
		}
	});
	
	$('#modfiyPasswordSubmit').click(function(){
		var oldpassword = $("#password").val();
		var newpassword = $("#newpassword").val();
		var repassword = $("#repassword").val();
    	if (oldpassword == "") {
    		$("#pass").find('span').html("密码错误");
			$("#pass").find('span').css("color", "red");
			$("#password").focus();
    	}
    	if (newpassword == "") {
    		$("#newPass").find('span').html("密码长度应为6-18位");
			$("#newPass").find('span').css("color","red");
    	}
    	if (repassword == "") {
    		$("#repass").find('span').html("密码长度应为6-18位");
			$("#repass").find('span').css("color","red");
    	}
        if(ok1 && ok2 && ok3 && ok4){
            $('form').submit();
        }else {
            return false;
        }
    });
});



