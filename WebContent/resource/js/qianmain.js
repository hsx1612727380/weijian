(function($){
	$('.navbar>li').on('mouseenter',function(){
		$(this).css('color','red').children('ul').stop().show();
	});
	$('.navbar>li').on('mouseleave',function(){
		$(this).css('color','black').children('ul').stop().hide();
	})
})(jQuery)
