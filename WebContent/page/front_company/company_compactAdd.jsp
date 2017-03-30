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
			<span>新增合同</span>
		</div>
	</div>
	<div class="content personal">
		<div class="detail">
			<div class="detailright">
				<form method="post" action="company_compactAdd2.html">
					<input type="hidden" name="code" value="${companyCompactModel.code }"/>
					<div>
						<label>工程名称</label>
						<input id="projectName" type="text" name="projectName" placeholder="必填"/>
					</div>
					<div>
						<label>建设单位</label>
						<input id="buildUnit" type="text" name="buildUnit" placeholder="必填"/>
					</div>
					<div>
						<label>竣工日期</label>
						<input id="achieveWorkDate" type="text" name="achieveWorkDate" placeholder="必填" class="laydate-icon" onClick="laydate({elem:'#achieveWorkDate',istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"/>
					</div>
					<div>
						<label>合同金额</label>
						<input id="compactPrice" type="text" name="compactPrice" placeholder="必填"/>
					</div>
					<div>
						<label>中标书</label>
						<select id="isTender" name="isTender">
							<option value="">==请选择是否有中标书==</option>
							<option value="0">无</option>
							<option value="1">有</option>
						</select>
					</div>
					<div>
						<label>合同书</label>
						<select id="isCompact" name="isCompact">
							<option value="">==请选择是否有合同书==</option>
							<option value="0">无</option>
							<option value="1">有</option>
						</select>
					</div>
					<div>
						<label>骏工报告</label>
						<select id="isAchieveReport" name="isAchieveReport">
							<option value="">==请选择是否有骏工报告==</option>
							<option value="0">无</option>
							<option value="1">有</option>
						</select>
					</div>
					<div>
						<label>开工日期</label>
						<input id="startWorkDate" type="text" name="startWorkDate" placeholder="必填" class="laydate-icon" onClick="laydate({elem:'#startWorkDate',istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"/>
					</div>
					<div>
						<label>项目经理</label>
						<input id="leaderName" type="text" name="leaderName" placeholder="必填"/>
					</div>
					<div>
						<label>执行情况</label>
						<input id="executiveInfo" type="text" name="executiveInfo" placeholder="必填"/>
					</div>
					<input id="addSubmit" type="submit" class="identy" value="发布" />
					<input type="reset"class="cancel" value="取消" />
					<input class="cancel" type="button" value="返回" onclick="JavaScript:history.back(-1);" />
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