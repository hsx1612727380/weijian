<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台-班组招聘</title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/web/employ_menber2.css" />
	</head>

	<body>
	<jsp:include page="../../top.jsp" flush="true" />
	<div class="title">
			<div class="content">
				<span>班组招聘</span>
			</div>
		</div>
		<div class="content personal clearfix">
			<div class="intitle colcenter">
				招聘标题：${rModel.title}
			</div>
			<div class="column clearfix colcenter">
				<div class="colright">
					<img src="resource/images/credit.jpg"/>
				</div>
				<div class="colleft">
					<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<th>班组名称</th>
							<td><a href="web_team_info.html?tId=${rModel.rId}" style="color: #4488FF;">${tModel.name}</a></td>
						</tr>
						<tr>
							<th>班组长</th>
							<td>${tModel.leaderName}</td>
						</tr>
						<tr>
							<th>所需技能类别</th>
							<td>${rModel.skillBigTypeName}</td>
						</tr>
						<tr>
							<th>所需技能类型</th>
							<td>${rModel.skillSmallTypeName}</td>
						</tr>
						<tr>
							<th>招聘人数</th>
							<td>${rModel.num}</td>
						</tr>
						<tr>
							<th>招聘区域</th>
							<td>${rModel.provinceStr}${rModel.cityStr}</td>
						</tr>
						<tr>
							<th>联系方式</th>
							<td>${tModel.leaderMobile}</td>
						</tr>
						<tr>
							<th>更新时间</th>
							<td>${rModel.createTimeStr}</td>
						</tr>
						<tr>
							<th>地址</th>
							<td>${rModel.street}</td>
						</tr>
					</table>
				</div>
			</div>
			
			<div class="intitle colcenter">
				备注
			</div>
			<div class="column clearfix colcenter">
				${rModel.desc}
			</div>
		</div>
			<jsp:include page="../../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>