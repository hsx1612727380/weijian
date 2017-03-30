$(function(){
	$('.detailbar li:even').css('background-color','#DBE5F1');
	$('.apply>div').on('click',function(){
		$(this).addClass('active').siblings().removeClass('active');
	});
});