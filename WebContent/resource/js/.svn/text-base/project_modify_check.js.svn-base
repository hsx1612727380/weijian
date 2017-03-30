(function($) {
	$(function(){
		var msg ="";
		var initialcode = $("#Code").val();
		var initialname = $("#Name").val();
		var initialpcode = $("#pCode").val();
		var initialuserId = $("#UserId").val();
		$("#Code").on('blur',function(){
			var code = $("#Code").val();
			//先判断是否修改了公司代码
			if(code === initialcode){
				msg = "";
			} else {
				if($.trim(code) == ""){//trim函数是取出字符串前后的空格
					msg = "*公司代码不能空！";
				} else {
					$.ajax({
						type: "GET",
						url : "modifyCompanyCode.html",
						data : {Code : code}, 
						dataType : 'text',
						async: false,
						success : function(flag){
							console.log(flag);
							//数据返回成功，可以根据flag数据内容做相应的逻辑
						
							if(flag == 1){
								console.log(flag);
								msg ="*该公司代码已存在*";
							}else if(flag ==2){
								msg="*公司代码可用*";
							}
						},
						error:function(){
							alert("数据加载失败！");
							//将页面重定向到新的地址（如果是原地址相当于刷新功能）
							//document.location.href = "materialJoinProject.html";
						}
					});
				}
			}
			$("#Code").siblings().eq(0).html(msg);
		});
		$("#Name").on('blur',function(){
			var name = $("#Name").val();
			//先判断是否修改了项目名称
			if(name === initialname){
				msg = "";
			} else{
				if($.trim(name) == ""){//trim函数是取出字符串前后的空格
					msg = "项目名称不能空！";
				} else {
					console.log(msg);
					$.ajax({
						type: "GET",
						url : "modifyProjectName.html",
						data : {Name : name}, 
						dataType : 'text',
						async: false,
						success : function(flag){
							console.log(flag);
							//数据返回成功，可以根据flag数据内容做相应的逻辑
							if(flag == 1){
								console.log(flag);
								msg ="*项目名称已经存在*";
							}else if(flag ==2){
								msg="*该名称可用*";
							}
						},
						error:function(){
							alert("数据加载失败！");
							//将页面重定向到新的地址（如果是原地址相当于刷新功能）
							//document.location.href = "materialJoinProject.html";
						}
					});
				}
			}
			$("#Name").siblings().eq(0).html(msg);
		});
		$("#pCode").on('blur',function(){
			var pcode = $("#pCode").val();
			//先判断是否修改了项目编号
			if(pcode === initialpcode){
				msg = "";
			} else {
			console.log("pcode=="+pcode);
				if($.trim(pcode) == ""){//trim函数是取出字符串前后的空格
					msg = "项目编号不能空！";
				} else {
					console.log(msg);
					$.ajax({
						type: "GET",
						url : "modifyProjectpCode.html",
						data : {pCode : pcode}, 
						dataType : 'text',
						async: false,
						success : function(flag){
							console.log(flag);
							//数据返回成功，可以根据flag数据内容做相应的逻辑
							if(flag == 1){
								console.log(flag);
								msg ="*项目编号已经存在*";
							}else if(flag ==2){
								msg="*该编号可用*";
							}
						},
						error:function(){
							alert("数据加载失败！");
							//将页面重定向到新的地址（如果是原地址相当于刷新功能）
							//document.location.href = "materialJoinProject.html";
						}
					});
				}
			}
			$("#pCode").siblings().eq(0).html(msg);
		});
		$("#UserId").on('blur',function(){
			var userId = $("#UserId").val();
			//先判断是否修改了负责人电话
			if(userId === initialuserId){
				msg = "";
			} else {
			console.log("userId=="+userId);
				if($.trim(userId) == ""){//trim函数是取出字符串前后的空格
					msg = "负责人电话不能空！";
				} else {
					console.log(msg);
					$.ajax({
						type: "GET",
						url : "modifyProjectUserId.html",
						data : {UserId : userId}, 
						dataType : 'text',
						async: false,
						success : function(flag){
							console.log(flag);
							//数据返回成功，可以根据flag数据内容做相应的逻辑
							if(flag == 1){
								console.log(flag);
								msg ="*负责人电话已经注册过*";
							}else if(flag ==2){
								msg="*负责人电话可以注册*";
							}
						},
						error:function(){
							alert("数据加载失败！");
							//将页面重定向到新的地址（如果是原地址相当于刷新功能）
							//document.location.href = "materialJoinProject.html";
						}
					});
				}
			}
			$("#UserId").siblings().eq(0).html(msg);
		});
		$("#Identity").on('blur',function(){
			var identity = $("#Identity").val();
			console.log("identity=="+identity);
			if($.trim(identity) == ""){//trim函数是取出字符串前后的空格
				msg = "负责人身份证不能空！";
			} 
			$("#Identity").siblings().eq(0).html(msg);
		});
		
	});
	
})(jQuery);
