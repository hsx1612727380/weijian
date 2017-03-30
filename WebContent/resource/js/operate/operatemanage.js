(function($){
	$(function(){
		$('.tag').on('click',function(){
			$(this).siblings('.tagbox').find('input')[0].value='';
			$(this).hide().siblings('span').html('').siblings('.tagbox').show().addClass('active').find('input').addClass('active').end().find('img').show();
		});
		$(".tagbox img").on('click',function(){
			$(this).parent().siblings('span').html($(this).siblings('input')[0].value);
			$(this).parent().hide();
			$(this).parent().siblings('img').show();
			$(this).parent().parent().submit();
		});
		$('.menu td span').on('click',function(){
			var pdId = $(this).children()[0].value;
			var teamName = $(this).children()[1].value;
			var teamLeaderName = $(this).children()[2].value;
			getTeamName(pdId, teamName, teamLeaderName);
			$('.chartbox').show();
			$('.mask').show();
		});
		$(' .X').on('click',function(){
			$('.chartbox').hide();
			$('.mask').hide();
		});
	});
	
	function getTeamName(obj, obj2, obj3) {
		$.ajax({
		    type : 'post',
		    url : 'operate_tmeShow.html',
		    dataType : 'text',
		    data : {"pdId" : obj,
		    	"teamName" : obj2,
		    	"teamLeaderName" : obj3},
		    success : function (date) {
		    	str = JSON.parse(date);
		    	var str1='';
		    	var cap = '<tr><th colspan="7">班组花名册</th></tr><tr><td>班组名称:</td><td colspan="6">'+str[0].teamName+'</td></tr><tr><td>班组长:</td><td colspan="6">'+str[0].teamLeaderName+'</td></tr>';
		    	var title = '<tr><td>序号</td><td>班组成员</td><td>性别</td><td>技术类型</td><td>身份证号</td><td>住址</td><td>联系方式</td></tr>';
		    	str1 = str1 + cap + title;
		    	for(var i=1;i<str.length;i++){
		    		var strtd='<tr>'+'<td>'+str[i].index+'</td>'+'<td>'
		    		+str[i].userName+'</td>'+'<td>'
		    		+str[i].userSex+'</td>'+'<td>'
		    		+str[i].skillBigTypeName+'</td>'+'<td>'
		    		+str[i].userIdentity+'</td>'+'<td>'
		    		+str[i].userStreet+'</td>'+'<td>'
		    		+str[i].userId+'</td>'+'</tr>';
		    		str1=str1+strtd;
		    	}
		    	$('.chart').html(str1);
		    },
		    error : function (xmlq, errq) {
		    	//alert("xmlq:"+xmlq+"errq:"+errq);
		    }
		});
	}
})(jQuery);