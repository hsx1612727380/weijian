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
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/fcompany/enterprisebase.css" />
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
				<li style="background-color: #ABCDEF">
					<a style="color:#4684D9 ;" href="company_info.html">基础资料</a>
				</li>
				<li><a href="company_member.html">企业人员</a></li>
				<li><a href="company_credit.html">企业资信</a></li>
				<li><a href="company_project.html">项目信息</a></li>
				<li><a href="company_compact.html">合同管理</a></li>
			</ul>
		</div>
		<div class="detail">
			<div class="detailright">
				<div>
					<label>基础资料管理</label>
					<a class="identy" href="company_infoUpdate.html" style="color: blue;">更新</a>
					<a class="identy" href="company_infoPwdUpdate.html" style="color: blue;">修改密码</a>
				</div>
				<div>
					<label>手机号</label>
					<span>${companyModel.userId }</span>
				</div>
				<div>
					<label>公司类型</label>
					<span>${companyModel.type }</span>
				</div>
				<div>
					<label>公司名称</label>
					<span>${companyModel.name }</span>
				</div>
				<div>
					<label>所在区域</label>
					<span>${companyModel.provinceChn }${companyModel.cityChn }</span>
				</div>
				<div>
					<label>统一社会信用代码</label>
					<span>${companyModel.organization }</span>
				</div>
				<div>
					<label>注册资金(万)</label>
					<span>${companyModel.regMoney }</span>
				</div>
				<div>
					<label>注册类型</label>
					<span>${companyModel.regType }</span>
				</div>
				<div>
					<label>联系人</label>
					<span>${companyModel.leaderName }</span>
				</div>
				<div>
					<label>联系方式</label>
					<span>${companyModel.tel }</span>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../down.jsp" flush="true" />
		
	<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>