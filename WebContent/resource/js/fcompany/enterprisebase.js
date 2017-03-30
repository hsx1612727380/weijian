(function($) {
	var flag=false;
	$(".identy").on('click',function(){
		if(!flag){
			$('.detailright form input,.detailright form select').show();
			$('.detailright form span').hide();
			flag=true;
		}else{
			$('.detailright form input,.detailright form select').hide();
			$('.detailright form span').show();
			$('.identy,.cancel').show();
			$('.detailright form').submit();
			flag=false;
		}
	})
})(jQuery)