
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
		<title>乐建平台——个人注册</title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/signin.css" />
	</head>

	<body>
		<jsp:include page="top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>个人注册</span>
			</div>
		</div>
		<div class="content personal">
			<form action="front_user_register.html" method="post">
				<div id="userId">
					<label>手机号</label>
					<input type="text" name='userId' id="userId1" placeholder="必填"/>
					<span style="color:red"></span>
				</div>
				<div id="userNamediv">
					<label>姓名</label>
					<input type="text" name='userName' id="userName" placeholder="选填"/>
					<span style="color:red"></span>
				</div>
				<div id="identitydiv">
						<label>身份证：</label> 
						<input type="text" id="identity" name="userIdentity" value=" " onchange="checkIdentity()"/>
						<input type="hidden" id="age" name="age" value="" readonly="readonly"/> 
						<input type="hidden" value="" name="userSex" id="userSex"> 
						<span ></span>
				</div>
				<!-- <div>
					<label>手机验证码</label>
					<input type="text" name="vertify" placeholder="必填"/>
					<button id="vertify">获取验证码</button>
				</div> -->
				<div id="userPassword">
					<label>登陆密码</label>
					<input type="password" name="userPassword" value="" placeholder="必填"/>
					<span></span>
				</div>
				<div id="logsure">
					<label>再次输入密码</label>
					<input type="password" name="logsure" placeholder="必填"/>
					<span></span>
				</div>
				<div id="userType">
					<label>用户类型</label>
					<select name="userType" id="type" >
						<option value="">请选择注册类型</option>
						<option value="0">班组/个人</option>
						<option value="1">材料商</option>
						<option value="2">设备商</option>
					</select>
					<span></span>
				</div>
				<div class="sumbit">
					<input type="checkbox" class="checkbox"/>同意<a href="protocol.html">乐建平台注册协议</a>
					<br />
					<br />
					<input type="submit" id="submit" value="注册" disabled="disabled"/>
					<a href="front_project_regForm.html" class="companysign">>>项目注册</a>
					<a href="front_company_regForm.html" class="companysign">>>企业注册</a>
				</div>
			</form>
		</div>
		 <jsp:include page="down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/signin.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>
