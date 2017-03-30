<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台-登录</title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/login.css" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/login.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/login_request.js" type="text/javascript" charset="utf-8"></script>
	
	</head>

	<body>
		<jsp:include page="top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>用户登录</span>
			</div>
		</div>
		<div class="content personal">
			<form id="loginForm" method="post"><!-- action="login.html"  使用异步请求-->
				<div id="phone">
					<label>账号</label>
					<input type="text" name='userId'  id ='userId' placeholder="手机号或者身份证号"/>
					<span></span>
				</div>
				<div>
					<label>密码</label>
					<input type="password" name="password" id ="password" placeholder="必填"/>
					<span></span>
				</div>
				<div class="sumbit">
					&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
					<a href="from_RegFrom.html">注册</a>
					<input type="button" value="登 录" id="login_btn"/>
				</div>

			</form>
		</div>
		 <jsp:include page="down.jsp" flush="true" />
	</body>
	
</html>

