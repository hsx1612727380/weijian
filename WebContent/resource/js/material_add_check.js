(function($) {
	$(function(){
		var msg ="";
		$("#Code").on('blur',function(){
			var code = $("#Code").val();
			console.log("code=="+code);
			if($.trim(code) == ""){//trim函数是取出字符串前后的空格
				msg = "*材料商代码不能空！";
			} else {
				console.log(msg);
				$.ajax({
					type: "GET",
					url : "verifyMaterialCode.html",
					data : {Code : code}, 
					dataType : 'text',
					async: false,
					success : function(flag){
						console.log(flag);
						//数据返回成功，可以根据flag数据内容做相应的逻辑
						if(flag == 1){
							console.log(flag);
							msg ="*该材料商代码已存在*";
						}else if(flag ==2){
							msg="*材料商代码可用*";
						}
					},
					error:function(){
						alert("数据加载失败！");
						//将页面重定向到新的地址（如果是原地址相当于刷新功能）
						//document.location.href = "materialJoinProject.html";
					}
				});
			}
			$("#Code").siblings().eq(0).html(msg);
		});
		$("#Name").on('blur',function(){
			var name = $("#Name").val();
			console.log("name=="+name);
			if($.trim(name) == ""){//trim函数是取出字符串前后的空格
				msg = "材料商名称不能空！";
			} else {
				console.log(msg);
				$.ajax({
					type: "GET",
					url : "verifyMaterialName.html",
					data : {Name : name}, 
					dataType : 'text',
					async: false,
					success : function(flag){
						console.log(flag);
						//数据返回成功，可以根据flag数据内容做相应的逻辑
						if(flag == 1){
							console.log(flag);
							msg ="*材料商名称已经存在*";
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
			$("#Name").siblings().eq(0).html(msg);
		});
		$("#UserId").on('blur',function(){
			var userId = $("#UserId").val();
			console.log("userId=="+userId);
			if(!(/^1(3|4|5|7|8)\d{9}$/.test($.trim(userId)))){//trim函数是取出字符串前后的空格
				msg = "请重新输入负责人电话！";
			} else {
				console.log(msg);
				$.ajax({
					type: "GET",
					url : "verifyMaterialUserId.html",
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
			$("#UserId").siblings().eq(0).html(msg);
		});
		$("#Licence").on('blur',function(){
			var licence = $("#Licence").val();
			if(/[A-Z0-9]{18}/g.test(licence)==false) {
		        msg ="*统一社会信用代码输入错误,请重新输入";
		        
		    }else {
		    	msg ="*输入正确";
		    }
			$("#Licence").siblings().eq(0).html(msg);
		});
		
	});
	
})(jQuery);
