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
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/fcompany/enterpriseCredit.css" />
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
				<li style="background-color: #ABCDEF">
					<a style="color:#4684D9 ;" href="company_project.html">项目信息</a>
				</li>
				<li><a href="company_compact.html">合同管理</a></li>
			</ul>
		</div>
		<div class="operate clearfix">
			<div><a href="company_projectAdd.html">新增项目</a></div>
		</div>
		<table class="condition" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<th>序号</th>
				<th>项目名称</th>
				<th>所在区域</th>
				<th>负责人</th>
				<th>合同价（万）</th>
				<th>预付款（万）</th>
				<th>总工程量</th>
				<th>累计工程量</th>
				<th>累计完成比例%</th>
				<th>工程状态</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${projectModels}" var="projectModel" varStatus="status">
				<tr>
					<td>${status.index + 1 }</td>
					<td>${projectModel.name }</td>
					<td>${projectModel.provinceChn }${projectModel.cityChn }</td>
					<td>${projectModel.leaderName }</td>
					<td>${projectModel.price }</td>
					<td>${projectModel.prepaid }</td>
					<td>${projectModel.allWork }</td>
					<td>${projectModel.accWork }</td>
					<td>${projectModel.progress }</td>
					<td>
						<c:if test="${projectModel.status == 0}">未开始</c:if>
						<c:if test="${projectModel.status == 1}">进行中</c:if>
						<c:if test="${projectModel.status == 2}">已完成</c:if>
					</td>
					<td>
						<div class="update">
							<a
								href="javascript:if(confirm('确实要删除${projectModel.name}吗?'))location='company_projectDel.html?id=${projectModel.id}'">删除项目</a>
						</div>
						<div class="update">
							<a href="company_projectDetail.html?id=${projectModel.id}">项目详情</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="../down.jsp" flush="true" />
		
	<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>