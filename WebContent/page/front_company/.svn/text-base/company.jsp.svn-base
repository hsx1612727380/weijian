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
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/fcompany/enterprise.css" />
</head>

<body>
	<jsp:include page="../top.jsp" flush="true" />
	<div class="title">
		<div class="content">
			<span><a href="<%=basePath%>person.html"><img src="<%=basePath%>/resource/images/home.png"/></a>
			<a href='<%=basePath%>person.html' style="color: #FFFFFF;">${companyModel.name}</a></span>
		</div>
	</div>
	<div class="content personal">
		<div class="autstate">
			<ul class=" clearfix">
				<li><a href="company_info.html">基础资料</a></li>
				<li><a href="company_member.html">企业人员</a></li>
				<li><a href="company_credit.html">企业资信</a></li>
				<li><a href="company_project.html">项目信息</a></li>
				<li><a href="company_compact.html">合同管理</a></li>
			</ul>
		</div>
		<div class="project clearfix">
			<div class="intitle">
				深圳湾创新科技中心
			</div>
			<ul>
				<li style="background-color: #FF6600;">
					<div>项目数量</div>
					<div>0</div>
				</li>
				<li style="background-color: #C23531;">
					<div>企业人员</div>
					<div>0</div>
				</li>
				<li style="background-color: #2F4554;">
					<div>签订合同</div>
					<div>0</div>
				</li>
			</ul>
		</div>
		<div id="echart"></div>
	</div>
	<jsp:include page="../down.jsp" flush="true" />
		
	<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/echarts.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/fcompany/enterprise.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>