<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/web/employ_menber.css" />
	</head>

	<body>
		<jsp:include page="../../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>个人信息</span>
			</div>
		</div>
		<div class="content personal clearfix">
			<div class="clearfix">
				<table class="entermenber" border="0" cellspacing="1" cellpadding="5">
					<tr>
						<th style="font-size: 20px;" colspan="6">${uModel.userName}</th>
					</tr>
					<tr>
						<th>姓名</th>
						<td>${uModel.userName}</td>
						<td style="text-align: center;" rowspan="5"><img src="resource/images/473temp.png" /></td>
					</tr>
					<tr>
						<th>技能类别</th>
						<td>${uModel.skillBigTypeName}</td>
					</tr>
					<tr>
						<th>技能类型</th>
						<td>${uModel.skillSmallTypeName}</td>
					</tr>
					<tr>
						<th>所在区域</th>
						<td>${uModel.userProvinceStr}${uModel.userCityStr}</td>
						<td></td>
					</tr>
					
					<tr>
						<th>联系方式</th>
						<td>${uModel.userId}</td>
						<td></td>
					</tr>
					<tr>
						<td>注册时间</td>
						<td>${uModel.createTimeStr}</td>
					</tr>
					<tr>
						<th>地址</th>
						<td>${uModel.userStreet}</td>
						<td></td>
					</tr>
				</table>
				<div class="credit">
					<img src="resource/images/credit.jpg" />
					<div class="creditname">
						<span></span>
						<span class="creditrecord">信用记录</span>
						<span></span>
					</div>
					<div class="records clearfix">
						<div>
							<img src="resource/images/c_ico1.png" />
							<div>身份证</div>
						</div>
						<div>
							<img src="resource/images/c_ico1.png" />
							<div>营业执照</div>
						</div>
						<div>
							<img src="resource/images/c_ico2.png" />
							<div>建程信用</div>
						</div>
					</div>
				</div>

			</div>
			<table class="entermenber" id="entermenber" border="0" cellspacing="1" cellpadding="0">
				<caption>个人说明</caption>
				<tr class="pointer">
					<td></td>
				</tr>
			</table>
		</div>
		<jsp:include page="../../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>