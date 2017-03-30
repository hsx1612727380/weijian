(function($){
	var iframe=document.getElementsByTagName('iframe')[0];
	$('.submenu li a').on('click',function(){
		var therf=$(this).attr("href");
		iframe.src=therf;
		return false;
	})
})(jQuery)
