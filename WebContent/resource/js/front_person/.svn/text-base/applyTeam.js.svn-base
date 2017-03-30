(function($) {
		$(function(){
			//预加载正在申请数据
			var userId = $('#userIdVal').val();
			$.ajax({
			    type : 'post',
			    url : 'personApplyIng.html',
			    dataType : 'text',
			    data :{"userId": userId},
			    success : function (Date) {
			    	var date=$.parseJSON( Date ); 
			    	console.log(date);
			    	var tab=$("#applyIngTable");
			    	for(var i=0;i<date.length;i=i+1 ){
			    		var trs=document.createElement('tr');
			    		var str="<td>"+
			    		date[i].teamModel.skillBigTypeName+"</td><td>"+
			    		date[i].teamModel.skillSmallTypeName+"</td><td>"+
			    		date[i].teamModel.leaderName+"</td><td>"+
			    		date[i].teamModel.leaderMobile+"</td><td>"+
			    		date[i].createTime+"</td><td>"+
			    		"<a href='rejectInvite.html?teamMemberId="+date[i].teamMemberId+"' style='color: #4488FF;'>"+
			    		"撤销申请"+"</a></td><td></td>";
			    		trs.innerHTML=str;
			    		tab.append(trs);
			    	}
			    },
			    error : function (xmlq, errq) {
			    }
			});
	
			$('#applyIng').on('click',function(){
				$('.applyIng').toggle();
				$('.applyHistory').hide();
			})
			$(".applySapn").on('click',function(){
//				var userId = $(this).parent().children().eq(0).attr('value');
//				var id = $(this).parent().children().eq(1).attr('value');
//				
				var userId=$(this).parent().children().eq(0).attr('value');
				var id=$(this).parent().children().eq(1).attr('value');
				$.ajax({
				    type : 'post',
				    url : 'personApplyTeam.html', 
				    dataType : 'text',
				    data :{"id": id,"userId":userId},
				    success : function () {
				    	alert("您已申请成功！");
				    	window.location.href="personApplyTeamForm.html";
				    },
				    error : function (xmlq, errq) {
				    	alert("xmlq:"+xmlq);
				        alert(errq);
				    }
				});
		    });
		})
	})(jQuery)

	