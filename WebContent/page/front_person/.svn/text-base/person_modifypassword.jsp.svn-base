<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script> 
		<script src="resource/js/front_person/person_left_handler.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/idperson.css" />
	</head>

	<body>
	<input id="isLeader" type="hidden" value='${isLeader}'/> 
	<jsp:include page="../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>个人中心</span>
			</div>
		</div>
		<div class="content personal">
		<div class="autstate">
			<c:if test="${isLeader=='1'}">
				<span>认证状态：已认证</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>角色：班组长</span>
			</c:if>
			<c:if test="${isLeader!='1'}">
				<span>认证状态：已认证</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>角色：个人</span>
			</c:if>
			&nbsp;&nbsp;&nbsp;&nbsp;<font color="darkblue">修改密码</font>
		</div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
				<div class="detailright" >
					<form action="modifyPassword.html"  name="passForm">
						<div id="pass">
							<label>原始密码：</label>
							<input type="password" name='oldpassword' id='password' placeholder="必填"  onchange="passCheck()"/>
							<input type="hidden" name='userId' id='userId' value='${model.userId }' />
							<span></span>
						</div>
						<div id="newPass">
							<label>新密码：</label>
							<input type="password" name="password" value="" placeholder="必填" />
							<span></span>
						</div>
						<div id="repass">
							<label>确认新密码：</label>
							<input type="password" name="repassword" placeholder="必填" />
							<span></span>	
						</div>
						<input type="submit"  value="提交" class="next" onclick="return passCheck()"/>
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_person/passModify.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>