<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台-个人求职</title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/web/employ_menber2.css" />
	</head>

	<body>
		<jsp:include page="../../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>个人求职</span>
			</div>
		</div>
		<div class="content personal clearfix">
			<div class="intitle colcenter">
				求职标题：${model.title}
			</div>
			<div class="column clearfix colcenter">
				<div class="colright">
					<img src="resource/images/credit.jpg"/>
				</div>
				<div class="colleft">
					<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<th>姓名</th>
							<td>${model.name}</td>
						</tr>
						<tr>
							<th>技能类别</th>
							<td>${model.skillBigTypeName}</td>
						</tr>
						<tr>
							<th>技能类型</th>
							<td>${model.skillSmallTypeName}</td>
						</tr>
						<tr>
							<th>所在区域</th>
							<td>${model.provinceStr}${model.cityStr}</td>
						</tr>
						<tr>
							<th>诚信度</th>
							<td>${uModel.reliableStar}星</td>
						</tr>
						<tr>
							<th>联系方式</th>
							<td>${uModel.userId}</td>
						</tr>
						<tr>
							<th>更新时间</th>
							<td>${model.createTimeStr}</td>
						</tr>
						<tr>
							<th>地址</th>
							<td>${model.street}</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="intitle colcenter">
				持证情况
			</div>
			<div class="column clearfix colcenter">
				<table class="certificate" border="0" cellspacing="1" cellpadding="0">
						<tr>
							<th>证书类型</th>
							<th>证书编号</th>
							<th>发证机关</th>
							<th>发证日期</th>
							<th>有效期</th>
						</tr>
						<c:forEach items="${engineer}" var="eModel"> 
						<tr>
							<td>${eModel.type}</td>
							<td>${eModel.registration}</td>
							<td>${eModel.certificateorgan}</td>
							<td>${eModel.issuancedate}</td>
							<td>${eModel.effectivedate}</td>
						</tr>
						</c:forEach>
				</table>
			</div>
			<div class="intitle colcenter">
				备注
			</div>
			<div class="column clearfix colcenter">
				${model.desc}
			</div>
		</div>
		<jsp:include page="../../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>