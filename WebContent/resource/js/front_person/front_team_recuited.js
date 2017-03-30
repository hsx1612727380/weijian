(function($){
	var smalltype = $("#SmallTypeBack").val();
	//获取技能小类型 动态追加
	$.ajax({
	    type : 'post',
	    url : 'team_getSmallSkillType.html',
	    dataType : 'text',
	    data : $('#skillBigType').serialize(),
	    async: true,
	    success : function (data) {
	    	var msg = eval("("+data+")");
	    	//$('#smalltype').empty();//先清空原来的option,再添加新的上去
	    	for(var i=0;i<msg.length;i++){
	    		if(smalltype == msg[i].skillType ){
	    			//追加的过程中，将需要的选中，不需要的直接添加上就可以了。
		    		$('#smalltype').prepend('<option selected='+'"true"'+'value="' + msg[i].skillType + '">' + msg[i].skillName + '</option>');
	    		}else{
		    		$('#smalltype').prepend('<option value="' + msg[i].skillType + '">' + msg[i].skillName + '</option>');
	    		}
	    		$('#smalltype').prepend('<option value=" ">' + 技能类型 + '</option>');
	    	};
	    },
	    error : function (xmlq, errq) {
	    	alert("技能小类型加载出了点小问题，请稍后再试!");
	    }
	});
})(jQuery);
