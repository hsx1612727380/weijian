$(function() {
	$('.detailtitle li').on('click', function() {
		var address = $(this).data('m');
		$('body').scrollTop($('.' + address).offset().top - 120);

	})
	var comheight = $('.comtitle').offset().top;
	var flag = 1;
	$(window).on('scroll', function() {
		var sTOP;
//		console.log(sTop);
		if(flag) {
			sTop=$(window).scrollTop();
			if($(document).scrollTop() > comheight) {
				$('.comtitle>div').css({
					position: 'fixed',
					top: '0',
					zIndex:'10'
				});
				$('.detailtitle li').stop().animate({
					height: '20px'
				}, 50, function() {
					$('.detailtitle i').hide();
					$('.intitle').stop().animate({
						fontSize: '24px'
					}, 50);
				});
			} else if($(document).scrollTop() < comheight) {

				$('.comtitle>div').css({
					position: 'static'
				});
				$('.detailtitle li').stop().animate({
					height: '100px',
				}, 50, function() {
					$('.detailtitle i').show();
					$('.intitle').stop().animate({
						fontSize: '30px'
					}, 50);
				});
			}
		}else{
			$('body').scrollTop(sTop);
		}

	});
	$('#pmore').on('click', function() {
		$('.meninfo').show();
		$('.mask').show();
		flag = 0;
	})
	$('.X').on('click', function() {
		$('.meninfo').hide();
		$('.mask').hide();
		flag = 1;
	});
});