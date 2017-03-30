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
		<title>乐建平台——企业注册</title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/signin.css" />
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>企业注册</span>
			</div>
		</div>
		<div class="content personal">
			<form action="front_company_regiter.html" method="post">
				<div id="userId">
					<label>手机号</label>
					<input type="text" name='userId' id="userId1" placeholder="必填"/>
					<span style="color:red">* 必填</span>
				</div>
				<div id="password">
					<label>登陆密码</label>
					<input type="password" name='password' placeholder="必填"/>
					<span></span>
				</div>
				<div id="logsure">
					<label>再次输入密码</label>
					<input type="password" name="logsure" placeholder="必填"/>
					<span></span>
				</div>
				<div id="companytype">
					<label>公司类型</label>
					<select name="type" id="type">
						<option value="">请选择公司类型</option>
						<option value="建筑公司" >建筑公司</option>
					    <option value="劳务公司" >劳务公司</option>
					    <option value="设计公司" >设计公司</option>
					    <option value="监理公司" >监理公司</option>
					    <option value="审图公司" >审图公司</option>
					    <option value="其他" >其他</option>
					</select>
					<span></span>
				</div>
				<div id="companyName">
					<label>公司名称</label>
					<input type="text" name='name' id="nameDiv" placeholder="必填"/>
					<span style="color:red">* 必填</span>
				</div>
				<div id="organizationDiv">
					<label>组织机构代码</label>  
					<input type="text" name='organization' id="organization" placeholder="社会信用代码或营业执照号码"/>
					<span style="color:red">* 必填</span>
				</div> 	
				<div id="leaderName">
					<label>联系人</label>
					<input type="text" name='leaderName'  placeholder="必填"/>
					<span style="color:red">* 必填</span>
				</div> 	
				<div class="sumbit">
					<input type="checkbox" class="checkbox"/>同意<a href="protocol.html">乐建平台注册协议</a>
					<br />
					<br />
					<input type="submit" id="submit" value="注册" disabled="disabled"/>
				</div>
			</form>
		</div>
		 <jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_commpny_register.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>
