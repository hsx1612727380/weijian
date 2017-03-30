(function($){
	$(function(){
		$(".hide").hide();
		$(".form").hide();
		
		$("#change").on('click',function(){
			$(".noform").hide();
			$(".form").show();
			
		});
		$("#update").on('click',function(){
			$("form").submit();
			$(".noform").show();
			$(".form").hide();
		});
	});
	var smalltype = $("#SmallTypeBack").val();
	//获取技能小类型 动态追加
	$.ajax({
	    type : 'post',
	    url : 'team_getSmallSkillType.html',
	    dataType : 'text',
	    data : $('#skillBigType').serialize(),
	    async: true,
	    success : function (date) {
	    	var msg = eval("("+date+")");   
	    	$('#smalltype').empty();//先清空原来的option,再添加新的上去
	    	for(var i=0;i<msg.length;i++){
	    		if(smalltype == msg[i].skillType ){
	    			//追加的过程中，将需要的选中，不需要的直接添加上就可以了。
		    		$('#smalltype').prepend('<option selected='+'"true"'+'value="' + msg[i].skillType + '">' + msg[i].skillName + '</option>');
	    		}else{
		    		$('#smalltype').prepend('<option value="' + msg[i].skillType + '">' + msg[i].skillName + '</option>');
	    		}
	    	};
	    },
	    error : function (xmlq, errq) {
	    	alert("xmlq:"+xmlq+"  errq:"+errq);
	    }
	});
})(jQuery);
