$(function(){
	$('#search').on('click',function(){
		var Sstart=$('#datestart option:selected').text();
		var Send=$('#dateend option:selected').text();
		var Astart=Sstart.substr(-2);
		var Aend=Send.substr(-2);
		$('#datesearch').empty();
		for(var i=0;i<=Aend-Astart;i++){
			var tds=document.createElement('td');
			var divs=document.createElement('div');
			divs.innerHTML=Sstart.slice(0,-2)+(i+1);
			tds.appendChild(divs);
			$('#datesearch').append(tds);
		}
	})
	$('#datesearch').on('click','div',function(){
		$('.chartbox').show();
	})
	$('.closed').on('click',function(){
		$('.chartbox').hide();
	})
})
