(function($) {
	$(function() {
		//预加载正在申请数据
		var userId = $('#userIdVal').val();
		$.ajax({
			type : 'post',
			url : 'personApplyIng.html',
			dataType : 'text',
			data : {
				"userId" : userId
			},
			success : function(Date) {
				var date = $.parseJSON(Date);
				var tab = $("#applyIngTable");
				for ( var i = 0; i < date.length; i++) {
					var trs = document.createElement('tr');
					var str = "<td>" + date[i].tModel.skillBigTypeName
							+ "</td><td>" + date[i].tModel.skillSmallTypeName
							+ "</td><td>" + date[i].tModel.leaderName
							+ "</td><td>" + date[i].tModel.leaderMobile
							+ "</td><td>" + date[i].createTime + "</td>";
					trs.innerHTML = str;
					tab.append(trs);
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
                alert(textStatus);
			}
		});
		$('#applyIng').on('click', function() {
			$('.applyIng').toggle();
			$('.applyHistory').hide();
		})
		$(".applySapn").on('click', function() {
			var userId = $(this).parent().children().eq(0).attr('value');
			var id = $(this).parent().children().eq(1).attr('value');
			$.ajax({
				type : 'post',
				url : 'teamApplyProject.html',
				dataType : 'text',
				data : {
					"pId" : id,
					"userId" : userId
				},
				success : function() {
						alert("您已申请该项目！");
						window.location.href="recruitTeamProjectForm.html";
				},
				error : function(xmlq, errq) {
					alert("申请失败");
				}
			});
		});
	})
})(jQuery)