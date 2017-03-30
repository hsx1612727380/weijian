<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>后台登录</title>
		<style type="text/css">
			*{
				margin: 0;
			}
			html,body{
				height: 100%;
			}
			.layout{
				height: 100%;
				background: url(resource/images/101.jpg) no-repeat center center;
				background-size: cover;
				overflow: hidden;
			}
			h1{
				margin-top: 80px;
				margin-left: 150px;
				color: white;
				font-size: 50px;
			}
			form{
				background-color: white;
				width: 400px;
				height: 300px;
				border: 1px solid white;
				border-radius: 10px;
				position: absolute;
				left: 50%;
				top: 30%;
			}
			.login{
				height: 50px;
				line-height: 50px;
				text-align: center;
				font-size: 20px;
				font-weight: 700;
				border-bottom: 2px solid #003366;
			}
			input{
				width: 200px;
				height: 25px;
				margin-left: 100px;
				margin-top: 20px;
			}
			.log{
				background-color: #00529C;
				color: white;
				height: 30px;
				cursor: pointer;
				border: 1px solid #00529C;
				border-radius: 3px;
				font-size: 20px;
				margin-top: 50px;
			}
		</style>
		
	</head>
	<body>
		<div class="layout">
			<h1>乐建后台系统</h1>
			<form id="background_loginForm" method="post">
				<div class='login'>用户登录</div>
				<div>
					<input type="text" name="accountName"  id ="accountName" placeholder="请输入账号"/><span></span>
				</div>
				<div>
					<input type="password" name="password" id ="password" placeholder="请输入密码"/><span></span>
				</div>
				<div class="sumbit">
					<input type="button" value="登 录" id="background_login_btn"/>
				</div>
			</form>
		</div>
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/background_login_request.js" type="text/javascript" charset="utf-8"></script>
</html>


