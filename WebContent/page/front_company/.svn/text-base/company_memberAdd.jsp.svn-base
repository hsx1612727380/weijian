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
			<span>新增企业人员</span>
		</div>
	</div>
	<div class="content personal">
		<div class="detail">
			<div class="detailright">
				<form method="post" action="company_memberAdd2.html">
					<input type="hidden" name="code" value="${engineerModel.code }"/>
					<div>
						<label>姓名</label>
						<input id="name" type="text" name="name" placeholder="必填"/>
					</div>
					<div id="addEngineerUserId">
						<label>手机号</label>
						<input id="userId" type="text" name="userId" placeholder="必填"/>
					</div>
					<div>
						<label>注册类别</label>
						<input id="type" type="text" name="type" placeholder="必填"/>
					</div>
					<div>
						<label>注册编号</label>
						<input id="registration" type="text" name="registration" placeholder="必填"/>
					</div>
					<div>
						<label>签发机关</label>
						<input id="certificateorgan" type="text" name="certificateorgan" placeholder="必填"/>
					</div>
					<div>
						<label>签发日期</label>
						<input id="issuancedate" type="text" name="issuancedate" placeholder="必填"/>
						<span>例如:2010-10-17</span>
					</div>
					<div>
						<label>有效日期</label>
						<input id="effectivedate" type="text" name="effectivedate" placeholder="必填"/>
						<span>例如:2020-10-16</span>
					</div>
					<input id="addSubmit" type="submit" class="identy" value="增加" />
					<input type="reset"class="cancel" value="取消" />
					<input class="cancel" type="button" value="返回" onclick="JavaScript:history.back(-1);" />
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../down.jsp" flush="true" />
		
	<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/fcompany/companyEegineer.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>