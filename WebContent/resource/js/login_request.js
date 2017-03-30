(function($){
	//异步登录请求
	$(document).ready(function(){
		var msg ="";
		$("#userId").on('blur',function(){
			console.log("msg="+msg);
			var userId  = $("#userId");
			if($.trim(userId.val()) == ""){//trim函数是取出字符串前后的空格
				msg = "*用户名不能空！";
				$("#userId").siblings().eq(1).html("<font color='red'>"+msg+"</font>");
				//让文本框获得焦点
				userId.focus();
			}else if(!/^1[3,5,8]\d{9}$/.test($.trim(userId.val()))){
				msg="*请输入正的手机号！";
				$("#userId").siblings().eq(1).html("<font color='red'>"+msg+"</font>");
				//让文本框获得焦点
				userId.focus();
			}else if(/^1[3,5,8]\d{9}$/.test($.trim(userId.val()))){
				msg = "";
				//$("#userId").siblings().eq(1).html("<font color='red'>"+msg+"</font>");
				//验证是否存在此用户
				$.ajax({
					url : "isUser.html", // 请求URL
					type : "get", // 请求方式
					data : {userId:userId.val()}, // 请求参数: key=value&key=value|{key:value,key:value}
					dataType : "text", // 服务器响应回来的数据类型
					async :false, 
					success : function(data){ // 请求成功
						//alert(data);
						/** 登录成功 */
						if(data=="1"){
							$("#userId").siblings().eq(1).html("<font color='red'>"+""+"</font>");
							return;
						}if(data=="0"){
							$("#userId").siblings().eq(1).html("<font color='red'>"+"*用户不存在"+"</font>");
						}
					},
					error : function(){ // 请求失败
						alert("数据加载失败！请稍候重试！");
					}
				});
			}
		});
		$("#password").on('blur',function(){
			console.log("msg="+msg);
			var password = $("#password");
			if($.trim(password.val()) == ""){
				msg = "*密码不能空！";
				$("#password").siblings().eq(1).html("<font color='red'>"+msg+"</font>");
				//让文本框获得焦点
				//password.focus();
			}else if(!/^[A-Za-z0-9]{6,20}$/.test($.trim(password.val()))){
				msg="*密码格式不正确 请输入6~20位数字、字母密码";
				$("#password").siblings().eq(1).html("<font color='red'>"+msg+"</font>");
				//让文本框获得焦点
				//password.focus();
			}else if(/^[A-Za-z0-9]{6,20}$/.test($.trim(password.val()))){
				msg = "";
				$("#password").siblings().eq(1).html("<font color='red'>"+msg+"</font>");
			}
		});
		/** 为登录按钮绑定点击事件 */
		$("#login_btn").click(function(){
			if(msg!=""){
				alert(msg);
			}else{
				/** 把表单中的input元素序列化成get请求字符串 */
				var params = $("#loginForm").serialize();
				//alert(params);
				/** 异步请求登录 */
				$.ajax({
					url : "login.html", // 请求URL
					type : "post", // 请求方式
					data : params, // 请求参数: key=value&key=value|{key:value,key:value}
					dataType : "text", // 服务器响应回来的数据类型
					async :true, // 异步请求
					success : function(data){ // 请求成功
						//alert(data); 
						// data : 响应数据 "1"时说明登录成功,为"0"登录失败
						/** 登录成功 */
						if(data=="1"){
							document.location.href = "person.html";
							
							/* window.location.href="index.html"; */
						}if(data=="0"){
							alert("用户名或密码不正确！");
						}
					},
					error : function(){ // 请求失败
						alert("数据加载失败！可能网络不稳定哦！");
					}
				});
			}
		});
		/** 监听用户是不是按了回车键 */
		$(document).keydown(function(event){
			/** 回车键  == 13 */
			if (event.keyCode === 13){
				/** 触发登录按钮的点击事件 */
				$("#login_btn").trigger("click");
			}
		});
	});
})(jQuery);