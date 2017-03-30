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
			<span>修改合同</span>
		</div>
	</div>
	<div class="content personal">
		<div class="detail">
			<div class="detailright">
				<form method="post" action="company_compactUpdate2.html">
					<input type="hidden" name="id" value="${companyCompactModel.id }"/>
					<input type="hidden" name="pName" value="${pName}"/>
					<div>
						<label>工程名称</label>
						<input id="projectName" type="text" name="projectName" value="${companyCompactModel.projectName }"/>
					</div>
					<div>
						<label>建设单位</label>
						<input id="buildUnit" type="text" name="buildUnit" value="${companyCompactModel.buildUnit }"/>
					</div>
					<div>
						<label>竣工日期</label>
						<input id="achieveWorkDate" type="text" name="achieveWorkDate" value="${companyCompactModel.achieveWorkDate }" class="laydate-icon" onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"/>
					</div>
					<div>
						<label>合同金额</label>
						<input id="compactPrice" type="text" name="compactPrice" value="${companyCompactModel.compactPrice }"/>
					</div>
					<div>
						<label>中标书</label>
						<select id="isTender" name="isTender">
							<option value="0" <c:if test="${companyCompactModel.isTender == 0}">selected</c:if>>无</option>
							<option value="1" <c:if test="${companyCompactModel.isTender == 1}">selected</c:if>>有</option>
						</select>
					</div>
					<div>
						<label>合同书</label>
						<select id="isCompact" name="isCompact">
							<option value="0" <c:if test="${companyCompactModel.isCompact == 0}">selected</c:if>>无</option>
							<option value="1" <c:if test="${companyCompactModel.isCompact == 1}">selected</c:if>>有</option>
						</select>
					</div>
					<div>
						<label>骏工报告</label>
						<select id="isAchieveReport" name="isAchieveReport">
							<option value="0" <c:if test="${companyCompactModel.isAchieveReport == 0}">selected</c:if>>无</option>
							<option value="1" <c:if test="${companyCompactModel.isAchieveReport == 1}">selected</c:if>>有</option>
						</select>
					</div>
					<div>
						<label>开工日期</label>
						<input id="startWorkDate" type="text" name="startWorkDate" value="${companyCompactModel.startWorkDate }" class="laydate-icon" onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"/>
					</div>
					<div>
						<label>项目经理</label>
						<input id="leaderName" type="text" name="leaderName" value="${companyCompactModel.leaderName }"/>
					</div>
					<div>
						<label>附件</label>
						<span class="files">上传附件<input type="file" /></span>
					</div>
					<div>
						<label>执行情况</label>
						<input id="executiveInfo" type="text" name="executiveInfo" value="${companyCompactModel.executiveInfo }"/>
					</div>
					<input id="updateSubmit" type="submit" class="identy" value="确定" />
					<input type="reset"class="cancel" value="取消" />
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../down.jsp" flush="true" />
		
	<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/laydate.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/fcompany/companyCompact.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>