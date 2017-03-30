(function($){
	$('#eqtime').on('change',function(){
				var eq=$('#eqtime option:selected').html();
				if(eq==='退场'){
					$('.enter').hide();
					$('.quit').show();
				}else{
					$('.enter').show();
					$('.quit').hide();
				}
			})
})(jQuery)
