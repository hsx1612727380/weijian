(function($) {
	$(function(){
		var msg ="";
		var initialcode = $("#Code").val();
		var initialname = $("#CompanyName").val();
		var initialuserId = $("#UserId").val();
		$("#Code").on('blur',function(){
			var code = $("#Code").val();
			//判断是否修改了公司编号
			if(code === initialcode){
				msg = "";
			} else {
				console.log("code=="+code);
				if($.trim(code) == ""){//trim函数是取出字符串前后的空格
					msg = "*公司编号不能空！";
				} else {
					console.log(msg);
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
								msg ="*该公司编号已存在*";
							}else if(flag ==2){
								msg="*公司编号可用*";
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
			$("#Code").siblings().eq(0).html(msg);
		});
		$("#CompanyName").on('blur',function(){
			var name = $("#CompanyName").val();
			//判断是否修改了公司名称
			if(name === initialname){
				msg = "";
			} else {
				console.log("name=="+name);
				if($.trim(name) == ""){//trim函数是取出字符串前后的空格
					msg = "公司名称不能空！";
				} else {
					console.log(msg);
					$.ajax({
						type: "GET",
						url : "modifyCompanyName.html",
						data : {CompanyName : name}, 
						dataType : 'text',
						async: false,
						success : function(flag){
							console.log(flag);
							//数据返回成功，可以根据flag数据内容做相应的逻辑
							if(flag == 1){
								console.log(flag);
								msg ="*公司名称已经存在*";
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
			$("#CompanyName").siblings().eq(0).html(msg);
		});
		$("#UserId").on('blur',function(){
			var userId = $("#UserId").val();
			//判断负责人电话是否修改过
			if(userId === initialuserId){
				msg = "";
			} else {
				console.log("userId=="+userId);
				if($.trim(userId) == ""){//trim函数是取出字符串前后的空格
					msg = "*负责人电话不能空！";
				} else {
					console.log(msg);
					$.ajax({
						type: "GET",
						url : "modifyCompanyUserId.html",
						data : {UserId : userId}, 
						dataType : 'text',
						async: false,
						success : function(flag){
							console.log(flag);
							//数据返回成功，可以根据flag数据内容做相应的逻辑
							if(flag == 1){
								console.log(flag);
								msg ="*该负责人电话已存在*";
							}else if(flag ==2){
								msg="*该电话可用*";
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
		$("#organization").on('blur',function(){
			var num = $("#organization").val();
			if(/[A-Z0-9]{18}/g.test(num)==false) {
		        msg ="*统一社会信用代码输入错误,请重新输入";
		        
		    }else {
		    	msg ="*输入正确";
		    }
			$("#organization").siblings().eq(0).html(msg);
		});
		
	});
	
})(jQuery);
