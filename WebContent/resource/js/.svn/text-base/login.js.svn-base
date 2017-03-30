(function($) {
	$('#phone>input').on('blur',function(){
		isphone($('#phone>input').val());
	});
	function isphone(obj) {
		reg = /^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/;
		if(!reg.test(obj)) {
			$("#phone").find('span').html("请输入正确的手机号码");
		} else {
			$("#phone").find('span').html("");
		}
	}
	
	
	
})(jQuery);
