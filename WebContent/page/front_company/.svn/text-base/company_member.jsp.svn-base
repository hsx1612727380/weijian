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
				<li style="background-color: #ABCDEF">
					<a style="color:#4684D9 ;" href="company_member.html">企业人员</a>
				</li>
				<li><a href="company_credit.html">企业资信</a></li>
				<li><a href="company_project.html">项目信息</a></li>
				<li><a href="company_compact.html">合同管理</a></li>
			</ul>
		</div>	
		<div class="operate clearfix">
			<div><a href="company_memberAdd.html">新增人员</a></div>
		</div>
		
		<table class="condition" border="0" cellspacing="1" cellpadding="0">
			<tr>
				<th>序号</th>
				<th>姓名</th>
				<th>注册类别</th>
				<th>注册编号</th>
				<th>签发机关</th>
				<th>签发日期</th>
				<th>有效日期 </th>
				<th>操作</th>
			</tr>
			<c:forEach items="${engineerModels}" var="engineerModel" varStatus="status">
				<tr>
					<td>${status.index + 1 }</td>
					<td>${engineerModel.name }</td>
					<td>${engineerModel.type }</td>
					<td>${engineerModel.registration }</td>
					<td>${engineerModel.certificateorgan }</td>
					<td>${engineerModel.issuancedate }</td>
					<td>${engineerModel.effectivedate }</td>
					<td>
						<div class="update">
							<a href="javascript:if(confirm('确实要删除${engineerModel.name}吗?'))location='company_memberDel.html?id=${engineerModel.id}'">删除</a>
						</div>
						<div class="update">
							<a href="company_memberUpdate.html?id=${engineerModel.id}">修改</a>
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