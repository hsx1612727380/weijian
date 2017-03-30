(function($) {
	$(function(){
		var msg ="";
		$("#pCode").on('blur',function(){
			var pcode = $("#pCode").val();
			console.log("code=="+pcode);
			if($.trim(pcode) == ""){//trim函数是取出字符串前后的空格
				msg = "*项目编号不能空！";
			} else {
				console.log(msg);
				$.ajax({
					type: "GET",
					url : "payrollrecordProjectCode.html",
					data : {pCode : pcode}, 
					dataType : 'text',
					async: false,
					success : function(flag){
						console.log(flag);
						//数据返回成功，可以根据flag数据内容做相应的逻辑
						if(flag == 1){
							console.log(flag);
							msg ="*项目编号可用*";
						}else if(flag ==2){
							msg="*项目编号不存在*";
						}
					},
					error : function(){
						alert("数据加载失败！");
						//将页面重定向到新的地址（如果是原地址相当于刷新功能）
						//document.location.href = "materialJoinProject.html";
					}
				});
			}
			$("#pCode").siblings().eq(0).html(msg);
		});
		$("#tCode").on('blur',function(){
			var pcode = $("#pCode").val();
			var tcode = $("#tCode").val();
			console.log("name=="+name);
			if($.trim(tcode) == ""){//trim函数是取出字符串前后的空格
				msg = "班组编号不能空！";
			} else {
				console.log(msg);
				$.ajax({
					type: "GET",
					url : "payrollrecordTeamCode.html",
					data : {tCode : tcode, pCode : pcode}, 
					dataType : 'text',
					async: false,
					success : function(flag){
						console.log(flag);
						//数据返回成功，可以根据flag数据内容做相应的逻辑
						if(flag == 1){
							console.log(flag);
							msg ="*班组在项目中*";
						}else if(flag ==2){
							msg="*班组不在项目中*";
						}else if(flag ==4){
							msg ="*项目不存在*";
						}else if(flag ==6){
							msg ="*班组不存在*";
						}else if(flag ==5){
							msg ="*上面项目中没有该班组*";
						}
					},
					error:function(){
						alert("数据加载失败！");
						//将页面重定向到新的地址（如果是原地址相当于刷新功能）
						//document.location.href = "materialJoinProject.html";
					}
				});
			}
			$("#tCode").siblings().eq(0).html(msg);
		});
		$("#UserId").on('blur',function(){
			var userId = $("#UserId").val();
			var tcode = $("#tCode").val();
			console.log("userId=="+userId);
			if($.trim(tcode) == ""){
				msg = "请先填写班组编号";
			} else {
				if(!(/^1(3|4|5|7|8)\d{9}$/.test($.trim(userId)))){//trim函数是取出字符串前后的空格
					msg = "*电话输入不正确！";
				} else {
					console.log(msg);
					$.ajax({
						type: "GET",
						url : "payrollrecordTeamMemberUserId.html",
						data : {tCode : tcode, UserId : userId}, 
						dataType : 'text',
						async: false,
						success : function(flag){
							console.log(flag);
							//数据返回成功，可以根据flag数据内容做相应的逻辑
							if(flag == 1){
								console.log(flag);
								msg ="*该用户在上述班组中*";
							}else if(flag ==2){
								msg="*该用户不在上述班组中*";
							}else if(flag ==4){
								msg ="*该用户不在任何班组中*";
							}
						},
						error : function(){
							alert("数据加载失败！");
							//将页面重定向到新的地址（如果是原地址相当于刷新功能）
							//document.location.href = "materialJoinProject.html";
						}
					});
				}
			}
			$("#UserId").siblings().eq(0).html(msg);
		});
		
	});
	
})(jQuery);
