(function($) {
	var ok1 = false;
	var ok2 = false;
	var ok3 = false;
	$('#newPass>input').on('blur', function() {
		var reg = /^[0-9A-Za-z]{6,18}$/;
		if (!reg.test($('#newPass>input').val())) {
			$("#newPass").find('span').html("密码长度应为6-18位");
			$("#newPass").find('span').css("color","red");
		} else {
			$("#newPass").find('span').html("");
			ok1 = true;
		}
	})
	$('#repass>input').on('blur', function() {
		var reg = /^[a-zA-Z]\w{5,17}$/;
		if ($('#repass>input').val() != $('#newPass>input').val()) {
			$("#repass").find('span').html("密码不一致");
			$("#repass").find('span').css("color","red");
		} else {
			$("#repass").find('span').html("");
			ok3=true;
		}
	})

	$('#pass>input').on('change', function() {
		var password = $('#password').val();
		var userId = $('#userId').val();
		$.ajax({
			type : 'post',
			url : 'chenkPassword.html',
			dataType : 'text',
			data : {
				"password" : +password,
				"userId" : +userId
			},
			success : function(date) {
				var msg = eval("(" + date + ")");
				if (date == "1") {
					$("#pass").find('span').html("密码正确");
					$("#pass").find('span').css("color", "green");
					ok2=true;
					return true;
				} else {
					$("#pass").find('span').html("密码错误");
					$("#pass").find('span').css("color", "red");
					$("#password").focus();
					return false;
				}
			},
			error : function(xmlq, errq) {
				return false;
			}
		});
	})
	$('.next').click(function(){
        if(ok1 && ok2&& ok3 ){
            $('form').submit();
        }else{
        	return false;
        }
    });

})(jQuery)
