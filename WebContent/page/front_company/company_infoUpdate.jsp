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
			<span>更新基础资料</span>
		</div>
	</div>
	<div class="content personal">
		<div class="detail">
			<div class="detailright">
				<form method="post" action="company_infoUpdate2.html">
					<input type="hidden" name="companyId" value="${companyModel.id }"/>
					<div id="updateInfoUserId">
						<label>手机号</label>
						<span>${companyModel.userId }</span>
					</div>
					<div>
						<label>公司类型</label>
						<select id="type" name="type">
							<option value="建筑公司"
								<c:if test="${companyModel.type=='建筑公司'}">selected</c:if>>建筑公司</option>
							<option value="劳务公司"
								<c:if test="${companyModel.type=='劳务公司'}">selected</c:if>>劳务公司</option>
							<option value="设计公司"
								<c:if test="${companyModel.type=='设计公司'}">selected</c:if>>设计公司</option>
							<option value="监理公司"
								<c:if test="${companyModel.type=='监理公司'}">selected</c:if>>监理公司</option>
							<option value="审图公司"
								<c:if test="${companyModel.type=='审图公司'}">selected</c:if>>审图公司</option>
							<option value="其他"
								<c:if test="${companyModel.type=='其他'}">selected</c:if>>其他</option>
						</select>
					</div>
					<div>
						<label>公司名称</label>
						<input id="name" type="text" name="name" value="${companyModel.name }"/>
					</div>
					<div>
						<label>所在区域</label>
						<select class="baseeditinput" id="province" name="province" style="width: 125px;">
							<c:choose>
								<c:when test="${companyModel.province } == ''">
									<option selected="selected" value="">请选择省份</option>
								</c:when>
								<c:otherwise>
									<option selected="selected" value="${companyModel.province}">${companyModel.provinceChn}</option>
								</c:otherwise>
							</c:choose>
						</select>
						<select class="baseeditinput" id="city" name="city" style="width: 125px;">
							<c:choose>
								<c:when test="${companyModel.city } == ''">
									<option selected="selected" value="">请选择城市</option>
								</c:when>
								<c:otherwise>
									<option selected="selected" value="${companyModel.city}">${companyModel.cityChn}</option>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
					<div>
						<label>统一社会信用代码</label>
						<input id="organization" type="text" name="organization" value="${companyModel.organization }"/>
					</div>
					<div>
						<label>注册资金(万)</label>
						<input id="regMoney" type="text" name="regMoney" value="${companyModel.regMoney }"/>
					</div>
					<div>
						<label>注册类型</label>
						<input id="regType" type="text" name="regType" value="${companyModel.regType }"/>
					</div>
					<div>
						<label>联系人</label>
						<input id="leaderName" type="text" name="leaderName" value="${companyModel.leaderName }"/>
					</div>
					<div>
						<label>联系方式</label>
						<input id="tel" type="text" name="tel" value="${companyModel.tel }"/>
					</div>
					<input id="updateSubmit" type="submit" class="identy" value="保存"/>
					<input type="reset" class="cancel" value="取消"/>
					<input class="cancel" type="button" value="返回" onclick="JavaScript:history.back(-1);" />
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../down.jsp" flush="true" />
		
	<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/area.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/fcompany/companyUpdateBaseInfo.js" type="text/javascript" charset="utf-8"></script>
	
</body>

</html>