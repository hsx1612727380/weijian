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
			<span>新增企业资质及资信</span>
		</div>
	</div>
	<div class="content personal">
		<div class="detail">
			<div class="detailright">
				<form method="post" action="company_creditAdd2.html">
					<input type="hidden" name="code" value="${aptitudeModel.code }"/>
					<div>
						<label>证书编号</label>
						<input id="certificate" type="text" name="certificate" placeholder="必填"/>
					</div>
					<div>
						<label>资质(信)类别</label>
						<select name="adtype" id="adtype" onchange="getAdlevel();">
							<option value="">--请选择类别--</option>
							<option value="1">招标代理</option>
							<option value="2">造价咨询</option>
							<option value="3">木工作业</option>
							<option value="4">施工总承包</option>
							<option value="5">专业承包</option>
							<option value="6">劳务分包</option>
							<option value="7">工程勘察综合类</option>
							<option value="8">工程勘察专业类</option>
							<option value="9">工程勘察劳务类</option>
							<option value="10">审图</option>
							<option value="11">检测</option>
						</select>
					</div>
					<div>
						<label>资质(信)等级</label>
						<select name="adlevel" id="adlevel">
							<c:choose>
								<c:when test="${aptitudeModel.adlevel==0}">
									<option selected="selected" value="">--请选择等级--</option>
								</c:when>
								<c:otherwise>
									<option selected="selected" value="${aptitudeModel.adlevel}">${aptitudeModel.adlevelName}</option>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
					<div>
						<label>资质(信)审批机关</label>
						<input id="approval" type="text" name="approval" placeholder="必填"/>
					</div>
					<div>
						<label>资质(信)最新批准日期</label>
						<input id="approvalTime" type="text" name="approvalTime" placeholder="必填"/>
						<span>例如:2010-10-16</span>
					</div>
					<div>
						<label>资质(信)有效期</label>
						<input id="validity" type="text"  name="validity" placeholder="必填"/>
						<span>例如:2020-10-15</span>
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
	<script src="<%=basePath%>/resource/js/fcompany/addAdlevel.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/fcompany/companyAptitude.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>