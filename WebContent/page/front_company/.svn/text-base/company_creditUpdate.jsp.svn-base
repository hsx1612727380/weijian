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
			<span>修改企业资质及资信</span>
		</div>
	</div>
	<div class="content personal">
		<div class="detail">
			<div class="detailright">
				<form method="post" action="company_creditUpdate2.html">
					<input type="hidden" name="id" value="${aptitudeModel.id }"/>
					<div>
						<label>证书编号</label>
						<input id="certificate" type="text" name="certificate" value="${aptitudeModel.certificate }"/>
					</div>
					<div>
						<label>资质(信)类别</label>
						<select name="adtype" id="adtype" onchange="getAdlevel();">
							<!-- <option value="" selected="selected">--请选择类别--</option> -->
							<option value="1" <c:if test="${aptitudeModel.adtypeName=='招标代理'}">selected</c:if>>招标代理</option>
							<option value="2" <c:if test="${aptitudeModel.adtypeName=='造价咨询'}">selected</c:if>>造价咨询</option>
							<option value="3" <c:if test="${aptitudeModel.adtypeName=='木工作业'}">selected</c:if>>木工作业</option>
							<option value="4" <c:if test="${aptitudeModel.adtypeName=='施工总承包'}">selected</c:if>>施工总承包</option>
							<option value="5" <c:if test="${aptitudeModel.adtypeName=='专业承包'}">selected</c:if>>专业承包</option>
							<option value="6" <c:if test="${aptitudeModel.adtypeName=='劳务分包'}">selected</c:if>>劳务分包</option>
							<option value="7" <c:if test="${aptitudeModel.adtypeName=='工程勘察综合类'}">selected</c:if>>工程勘察综合类</option>
							<option value="8" <c:if test="${aptitudeModel.adtypeName=='工程勘察专业类'}">selected</c:if>>工程勘察专业类</option>
							<option value="9" <c:if test="${aptitudeModel.adtypeName=='工程勘察劳务类'}">selected</c:if>>工程勘察劳务类</option>
							<option value="10" <c:if test="${aptitudeModel.adtypeName=='审图'}">selected</c:if>>审图</option>
							<option value="11" <c:if test="${aptitudeModel.adtypeName=='检测'}">selected</c:if>>检测</option>
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
						<input id="approval" type="text" name="approval" value="${aptitudeModel.approval }"/>
					</div>
					<div>
						<label>资质(信)最新批准日期</label>
						<input id="approvalTime" type="text" name="approvalTime" value="${aptitudeModel.approvalTime }"/>
						<span>例如:2010-10-16</span>
					</div>
					<div>
						<label>资质(信)有效期</label>
						<input id="validity" type="text" name="validity" value="${aptitudeModel.validity }">
						<span>例如:2020-10-15</span>
					</div>
					<input id="updateSubmit" type="submit" class="identy" value="修改" />
					<input type="reset"class="cancel" value="取消" />
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