<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.fengyun.web.hardcode.IMageUploadInfo"%>
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
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/fcompany/enterpriseContract.css" />
	<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		function submitCompanyCompactSearchForm() {
			document.getElementById('myform').submit();
		}
	</script>
	<script type="text/javascript" >
		$(function(){
			$('.identy').on('click',function () {
				 var imageName = $(this).siblings().val();
				 var companyId = $("#companyId").val();
				 var companyCompactPath = $("#companyCompactPath").val();
				 var visitAddress = $("#visitAddress").val();
				 var vistPath = visitAddress + companyCompactPath + companyId + "/";
				 window.open(vistPath + imageName);
			});
		});
	</script>
	
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
				<li style="background-color: #ABCDEF">
					<a style="color:#4684D9 ;" href="company_compact.html">合同管理</a>
				</li>
			</ul>
		</div>
		<input type="hidden" id="companyId" name="companyId" value="${companyModel.id }"/>
		<form id="myform" action="company_getCompact.html" method="POST">
			<table class="condition" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<div><a href="company_compactAdd.html">新增合同</a></div>
					</td>
					<td>
						<span>工程名称</span>
						<input id="pName" type="text" name="pName" value="${pName }"/>
						<div onclick="return submitCompanyCompactSearchForm();">搜索</div>
					</td>
				</tr>
			</table>
		</form>
		<c:if test="${pName != null }">
			<c:if test="${companyCompactModel != null }">
				<table class="searchtype" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<th>工程名称</th>
						<th>建设单位</th>
						<th>竣工日期</th>
						<th>合同金额</th>
						<th>中标书</th>
						<th>合同书</th>
						<th>骏工报告</th>
						<th>开工日期</th>
						<th>项目经理</th>
						<th>
							附件
							<input type="hidden" id="visitAddress" value="<%=IMageUploadInfo.VISITADDRESS.getValue()%>" />
							<input type="hidden" id="companyCompactPath" value="<%=IMageUploadInfo.COMPANYCOMPACTPATH.getValue()%>" />
						</th>
						<th>执行情况</th>
						<th>操作</th>
					</tr>
					<tr>
						<td>${companyCompactModel.projectName }</td>
						<td>${companyCompactModel.buildUnit }</td>
						<td>${companyCompactModel.achieveWorkDate }</td>
						<td>${companyCompactModel.compactPrice }</td>
						<td>
							<c:if test="${companyCompactModel.isTender == 0}">无</c:if>
							<c:if test="${companyCompactModel.isTender == 1}">有</c:if>
						</td>
						<td>
							<c:if test="${companyCompactModel.isCompact == 0}">无</c:if>
							<c:if test="${companyCompactModel.isCompact == 1}">有</c:if>
						</td>
						<td>
							<c:if test="${companyCompactModel.isAchieveReport == 0}">无</c:if>
							<c:if test="${companyCompactModel.isAchieveReport == 1}">有</c:if>
						</td>
						<td>${companyCompactModel.startWorkDate }</td>
						<td>${companyCompactModel.leaderName }</td>
						<td>
							<c:if test="${companyCompactModel.attachment == null }">
								<form action="company_compactUploadImage.html?companyCompactId=${companyCompactModel.id }&companyId=${companyModel.id }" method="post" enctype="multipart/form-data">
								 	<div class="files">
								 		<input type="file" name="attachment" />
								 	</div>
								 	<div class="submit">
								 		<input type="submit" >
								 	</div>
								</form>
							</c:if>
							<c:if test="${companyCompactModel.attachment == '' }">
								<form action="company_compactUploadImage.html?companyCompactId=${companyCompactModel.id }&companyId=${companyModel.id }" method="post" enctype="multipart/form-data">
								 	<div class="files">
								 		<input type="file" name="attachment" />
								 	</div>
								 	<div class="submit">
								 		<input type="submit" >
								 	</div>
								</form>
							</c:if>
							<c:if test="${companyCompactModel.attachment != null }">
								<c:if test="${companyCompactModel.attachment != '' }">
									<div class='files identy'>
										<input type="button" id="identTitydemo" class="file" value="查看" style="margin-left: 0;" />
									</div>
									<input type="hidden" id="imageName" value="${companyCompactModel.attachment }">
								</c:if>
							</c:if>
						</td>
						<td>${companyCompactModel.executiveInfo }</td>
						<td>
							<div class="update">
								<a href="company_compactUpdate.html?id=${companyCompactModel.id}&pName=${pName}">编辑</a>
							</div>
						</td>
					</tr>
				</table>
			</c:if>
			<c:if test="${companyCompactModel == null }">
				<br/>
				没有查询到结果，输入的工程名称有误，请重新输入
			</c:if>
		</c:if>
		<c:if test="${pName == null }">
			<table class="searchtype" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th>序号</th>
					<th>工程名称</th>
					<th>建设单位</th>
					<th>竣工日期</th>
					<th>合同金额</th>
					<th>中标书</th>
					<th>合同书</th>
					<th>骏工报告</th>
					<th>开工日期</th>
					<th>项目经理</th>
					<th>
						附件
						<input type="hidden" id="visitAddress" value="<%=IMageUploadInfo.VISITADDRESS.getValue()%>" />
						<input type="hidden" id="companyCompactPath" value="<%=IMageUploadInfo.COMPANYCOMPACTPATH.getValue()%>" />
					</th>
					<th>执行情况</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${companyCompactModels}" var="companyCompactModel" varStatus="status">
					<tr>
						<td>${status.index + 1 }</td>
						<td>${companyCompactModel.projectName }</td>
						<td>${companyCompactModel.buildUnit }</td>
						<td>${companyCompactModel.achieveWorkDate }</td>
						<td>${companyCompactModel.compactPrice }</td>
						<td>
							<c:if test="${companyCompactModel.isTender == 0}">无</c:if>
							<c:if test="${companyCompactModel.isTender == 1}">有</c:if>
						</td>
						<td>
							<c:if test="${companyCompactModel.isCompact == 0}">无</c:if>
							<c:if test="${companyCompactModel.isCompact == 1}">有</c:if>
						</td>
						<td>
							<c:if test="${companyCompactModel.isAchieveReport == 0}">无</c:if>
							<c:if test="${companyCompactModel.isAchieveReport == 1}">有</c:if>
						</td>
						<td>${companyCompactModel.startWorkDate }</td>
						<td>${companyCompactModel.leaderName }</td>
						<td>
							<c:if test="${companyCompactModel.attachment == null }">
								<form action="company_compactUploadImage.html?companyCompactId=${companyCompactModel.id }&companyId=${companyModel.id }" method="post" enctype="multipart/form-data">
								 	<div class="files">
								 		<input type="file" name="attachment" />
								 	</div>
								 	<div class="submit">
								 		<input type="submit" >
								 	</div>
								</form>
							</c:if>
							<c:if test="${companyCompactModel.attachment == '' }">
								<form action="company_compactUploadImage.html?companyCompactId=${companyCompactModel.id }&companyId=${companyModel.id }" method="post" enctype="multipart/form-data">
								 	<div class="files">
								 		<input type="file" name="attachment" />
								 	</div>
								 	<div class="submit">
								 		<input type="submit" >
								 	</div>
								</form>
							</c:if>
							<c:if test="${companyCompactModel.attachment != null }">
								<c:if test="${companyCompactModel.attachment != '' }">
									<div class='files identy'>
										<input type="button" id="identTitydemo" class="file" value="查看" style="margin-left: 0;" />
									</div>
									<input type="hidden" id="imageName" value="${companyCompactModel.attachment }">
								</c:if>
							</c:if>
						</td>
						<td>${companyCompactModel.executiveInfo }</td>
						<td>
							<div class="update">
								<a href="company_compactUpdate.html?id=${companyCompactModel.id}">编辑</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<jsp:include page="../down.jsp" flush="true" />
		
	<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>