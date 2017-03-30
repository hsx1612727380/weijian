$(function() {
	var consearch;
	$('.consearch').on('change', function() {
		consearch = $(this).prop('selectedIndex');
		if(!consearch){
			$('.datehide').show();
		}else{
			$('.datehide').hide();
		}
	});
	$('.closed').on('click', function() {
		$(this).parent().hide();
	});
	if($('.chartbox').data('flag')===1){
		$('.chartbox').show();
	}else if($('.chartbox').data('flag')===2){
		$('.chartboxtwo').show();
		$('.datehide').hide();
	}else if($('.chartbox').data('flag')===3){
		$('.chartboxthree').show();
		$('.datehide').hide();
	}else if($('.chartbox').data('flag')===4){
		$('.chartboxfour').show();
		$('.datehide').hide();
	}
});