(function($) {
	$(function(){
		var msg ="";
		$("#TeamName").on('blur',function(){
			var name = $("#TeamName").val();
			console.log("name=="+name);
			if($.trim(name) == ""){//trim函数是取出字符串前后的空格
				msg = "*班组名称不能空！";
			} else {
				console.log(msg);
				$.ajax({
					type: "GET",
					url : "verifyTeamName.html",
					data : {TeamName : name}, 
					dataType : 'text',
					async: false,
					success : function(flag){
						console.log(flag);
						//数据返回成功，可以根据flag数据内容做相应的逻辑
						if(flag == 1){
							console.log(flag);
							msg ="*该班组名称已存在*";
						}else if(flag ==2){
							msg="*班组名称可用*";
						}
					},
					error:function(){
						alert("数据加载失败！");
						//将页面重定向到新的地址（如果是原地址相当于刷新功能）
						//document.location.href = "materialJoinProject.html";
					}
				});
			}
			$("#TeamName").siblings().eq(0).html(msg);
		});
		$("#leaderMobile").on('blur',function(){
			var mobile = $("#leaderMobile").val();
			console.log("mobile=="+mobile);
			if(!(/^1(3|4|5|7|8)\d{9}$/.test($.trim(mobile)))){//trim函数是取出字符串前后的空格
				msg = "请重新输入班组长电话！";
			} else {
				console.log(msg);
				$.ajax({
					type: "GET",
					url : "verifyTeamLeaderMobile.html",
					data : {leaderMobile : mobile}, 
					dataType : 'text',
					async: false,
					success : function(flag){
						console.log(flag);
						//数据返回成功，可以根据flag数据内容做相应的逻辑
						if(flag == 1){
							console.log(flag);
							msg ="*已经存在该班组长*";
						}else if(flag ==2){
							msg="*可以创建班组长*";
						}
					},
					error:function(){
						alert("数据加载失败！");
						//将页面重定向到新的地址（如果是原地址相当于刷新功能）
						//document.location.href = "materialJoinProject.html";
					}
				});
			}
			$("#leaderMobile").siblings().eq(0).html(msg);
		});
		
		
	});
	
})(jQuery);
