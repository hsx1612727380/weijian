<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<!-- 针对不同的登录用户类型隐藏左侧菜单的js -->
		<script src="resource/js/front_person/person_left_handler.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/personAddgroud.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/web/employ_menber.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/tabfooter.css" />
		<script src="resource/js/front_person/applyTeam.js" type="text/javascript" charset="utf-8"></script>
		
	</head>

<body>
	<input id="isLeader" type="hidden" value='${isLeader}' />
	<jsp:include page="../top.jsp" flush="true" />
	<div class="title">
		<!-- <div class="content">
				<span>个人中心</span>
			</div> -->
	</div>
	<div class="content personal">
		<span>认证状态：</span><span>已认证 &nbsp;&nbsp;&nbsp;</span> <span>角色：</span><span>班组长</span>&nbsp;
		<div class="detail">
			<jsp:include page="person_left.jsp" flush="true" />
			<div class="detailright" style="width: 945px; margin-left: 15px">
				<div class="content personal clearfix" style="width: 100%">
					<div class="content personal clearfix">
						<div class="clearfix">
							<table class="entermenber" border="0" cellspacing="1"
								cellpadding="5">
								<tr>
									<th style="font-size: 20px;" colspan="6">广州烨阳建材有限公司</th>
								</tr>
								<tr>
									<th>供应商名称</th>
									<td>${companyModel.name}</td>
									<td style="text-align: center;" rowspan="5"><img
										src="resource/images/front_person/474temp.png" /></td>
								</tr>
								<tr>
									<th>班组类型</th>
									<td>${requirementsModel.skillBigTypeName}${requirementsModel.skillSmallTypeName}</td>
								</tr>
								<%-- <tr>
						<th>区域</th>
						<td>${requirementsModel.provinceStr}${requirementsModel.cityStr}${requirementsModel.streetStr}</td>
					</tr> --%>
								<tr>
									<th>所在区域</th>
									<td>广东省广州市</td>
									<td></td>
								</tr>
								<tr>
									<th>招聘要求</th>
									<td>${requirementsModel.desc}</td>
									<td></td>
								</tr>
								<tr>
									<th>项目地址</th>
									<td>${requirementsModel.provinceStr}${requirementsModel.cityStr}${requirementsModel.streetStr}</td>
									<td></td>
								</tr>
							</table>
							<div class="credit">
								<img src="../images/credit.jpg" />
								<div class="creditname">
									<span></span> <span class="creditrecord">信用记录</span> <span></span>
								</div>
								<div class="records clearfix">
									<div>
										<img src="resource/images/front_person/c_ico1.png" />
										<div>身份证</div>
									</div>
									<div>
										<img src="resource/images/front_person/c_ico1.png" />
										<div>营业执照</div>
									</div>
									<div>
										<img src="resource/images/front_person/c_ico2.png" />
										<div>建程信用</div>
									</div>
								</div>
							</div>

						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="../down.jsp" flush="true" />
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript"
		charset="utf-8"></script>
</body>

</html>