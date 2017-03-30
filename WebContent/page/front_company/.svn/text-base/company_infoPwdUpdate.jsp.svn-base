<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>

<head>
	<meta charset="utf-8" />
	<title>乐建平台</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/common.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/fcompany/enterpriseadd.css" />
</head>

<body>
	<jsp:include page="../top.jsp" flush="true" />
	<div class="title">
		<div class="content">
			<span>企业账号修改密码</span>
		</div>
	</div>
	<div class="content personal">
		<div class="detail">
			<div class="detailright">
				<form method="post" action="company_infoPwdUpdate2.html">
					<input type="hidden" name="userId" value="${companyModel.userId }">
					<div id="pass">
						<label>原密码：</label>
						<input type="password" name='oldpassword' id='password' placeholder="必填" />
						<input type="hidden" name='datapassword' id='datapassword' value="${companyModel.password }" />
						<span></span>
					</div>
					<div id="newPass">
						<label>新密码：</label>
						<input type="password" name="password" id='newpassword' placeholder="必填" />
						<span></span>	
					</div>
					<div id="repass">
						<label>确认新密码：</label>
						<input type="password" name="repassword" id='repassword' placeholder="必填" />
						<span></span>	
					</div>
					<input id="modfiyPasswordSubmit" type="submit" class="identy" value="确认" />
					<input type="reset" class="cancel" value="取消" />
					<input class="cancel" type="button" value="返回" onclick="JavaScript:history.back(-1);" />
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../down.jsp" flush="true" />
		
	<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/fcompany/companyPasswordModfiy.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>