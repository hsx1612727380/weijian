(function($){
	$('#eqtime').on('change',function(){
				var eq=$('#eqtime option:selected').html();
				if(eq==='施工班组'){
					$('.material').hide();
					$('.equip').hide();
					$('.team').show();
				}else if(eq==='材料商'){
					$('.material').show();
					$('.equip').hide();
					$('.team').hide();
				}else if(eq==='设备商'){
					$('.material').hide();
					$('.equip').show();
					$('.team').hide();
				}else {
					$('.material').hide();
					$('.equip').hide();
					$('.team').hide();
				}
			});
})(jQuery);