(function($){
	$(function(){
		$('.addbtn').on('click',function(){
			$('.mask').show();
			$('.addform').show();
		});
		$('.addcancel').on('click',function(){
			$('.mask').hide();
			$('.addform')[0].reset();
			$('.addform').hide();
		});
	});
})(jQuery);
