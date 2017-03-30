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
				<span>班组信息</span>
			</div>
		</div>
		<div class="content personal clearfix">
			<div class="clearfix">
				<table class="entermenber" border="0" cellspacing="1" cellpadding="5">
					<tr>
						<th style="font-size: 20px;" colspan="6">${tModel.name}</th>
					</tr>
					<tr>
						<th>班组名称</th>
						<td>${tModel.name}</td>
						<td style="text-align: center;" rowspan="5"><img src="resource/images/475temp.png" /></td>
					</tr>
					<tr>
						<th>班组长</th>
						<td>${tModel.leaderName}</td>

					</tr>
					<c:if test="${type==null}">
						<tr>
							<th>技能类别</th>
							<td>${tModel.skillBigTypeName}</td>
						</tr>
						<tr>
							<th>技能类型</th>
							<td>${tModel.skillSmallTypeName}</td>
						</tr>
					</c:if>
					<c:if test="${type!=null}">
						<tr>
							<th>技能类别</th>
							<td>${rModel.skillBigTypeName}</td>
						</tr>
						<tr>
							<th>技能类型</th>
							<td>${rModel.skillSmallTypeName}</td>
						</tr>
					</c:if>
					<c:if test="${type=='2'}">
					<tr>
						<th>招聘人数</th>
						<td>${rModel.num}</td>
					</tr>
					<tr>
						<th>招聘区域</th>
						<td>${rModel.provinceStr}${rModel.cityStr}</td>
						<td></td>
					</tr>
					</c:if>
					<c:if test="${type=='1'}">
					<tr>
						<th>求职区域</th>
						<td>${rModel.provinceStr}${rModel.cityStr}</td>
						<td></td>
					</tr>
					</c:if>
					
					<tr>
						<th>联系方式</th>
						<td>${tModel.leaderMobile}</td>
						<td></td>
					</tr>
					<c:if test="${type!=null}">
					<tr>
						<td>更新时间</td>
						<td>${rModel.createTimeStr}</td>
					</tr>
					</c:if>
					<tr>
						<th>联系地址</th>
						<td>${tModel.provinceChn}${tModel.cityChn}${tModel.street}</td>
						<td></td>
					</tr>
					<tr>
						<th>备注</th>
						<td>${rModel.desc}</td>
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
				<caption>参与的项目</caption>
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