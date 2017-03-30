(function(){
	var inp = document.getElementsByClassName("inp");
	console.log(inp);
	for( var n=0;n<inp.length;n++){
		inp[n].onblur=inpblur;
	}
	function inpblur(){
			this.value = this.value.split(' ').join('');
		}
})()
