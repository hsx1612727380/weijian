$(function(){
	$('#team').change(function(){
		num1=$('#team').prop('selectedIndex');
		if(num1==0){
			$('#skills').html('技能类别');
			$('#skilltype').html('技能类型');
			var select1=document.createElement('select');
			$('#skillsel').empty().append(select1);
			var select2=document.createElement('select');
			$('#skilltypesel').empty().append(select2);
		}
		if(num1==1){
			$('#skills').html('材料名称');
			$('#skilltype').html('供货地区');
			var inpu1=document.createElement('input');
			$('#skillsel').empty().append(inpu1);
			var inpu2=document.createElement('input');
			$('#skilltypesel').empty().append(inpu2);
		}
		if(num1==2){
			$('#skills').html('设备名称');
			$('#skilltype').html('供货地区');
			var inpu1=document.createElement('input');
			$('#skillsel').empty().append(inpu1);
			var inpu2=document.createElement('input');
			$('#skilltypesel').empty().append(inpu2);
		}
	})
})
