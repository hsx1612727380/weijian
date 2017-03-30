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
		<link rel="stylesheet" type="text/css" href="resource/css/web/enter_menber.css" />
	</head>

	<body>
		<jsp:include page="../../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>公司介绍</span>
			</div>
		</div>
		<div class="content personal clearfix">
			<div class="comtitle">
				<div>
					<div class="intitle">
						${model.name}
					</div>
					<ul class="detailtitle clearfix">
						<li data-m="m1">
							<i class="iconfont">&#xe607</i>
							<p>基础信息</p>
						</li>
						<li data-m="m2">
							<i class="iconfont">&#xe623</i>
							<p>企业资质</p>
						</li>
						<li data-m="m3">
							<i class="iconfont">&#xe609</i>
							<p>注册人员</p>
						</li>
						<li data-m="m4">
							<i class="iconfont">&#xe677</i>
							<p>工程项目</p>
						</li>
						<li data-m="m5">
							<i class="iconfont">&#xe88e</i>
							<p>良好行为</p>
						</li>
						<li data-m="m6">
							<i class="iconfont">&#xe730</i>
							<p>不良行为</p>
						</li>
						<li data-m="m7">
							<i class="iconfont">&#xe65a</i>
							<p>欠薪行为</p>
						</li>
					</ul>
				</div>

			</div>
			<div class="column">
				<div class="ntitle m1">
					基本信息
				</div>
				<ul class="basedetail clearfix">
					<li>
						<h3>组织机构代码</h3>
						<p>${model.organization}</p>
					</li>
					<li>
						<h3>注册资金</h3>
						<p>${model.regMoney}万</p>
					</li>
					<li>
						<h3>注册类型</h3>
						<p>${model.regType}</p>
					</li>
					<li>
						<h3>所在地区</h3>
						<p>${model.provinceChn}${model.cityChn}</p>
					</li>
					<li>
						<h3>认证情况</h3>
						<p><c:if test="${model.status=='1'}">已审核</c:if><c:if test="${model.status=='0'}">未审核</c:if></p>
					</li>
					<li>
						<h3>联系人</h3>
						<p>${model.leaderName}</p>
					</li>
					<li>
						<h3>公司类型</h3>
						<p>${model.type}</p>
					</li>
				</ul>
			</div>
			<div class="column m2">
				<div class="ntitle">
					企业资质
				</div>
				<table border="0" cellspacing="2" cellpadding="0">
					<tr>
						<th>证书编号</th>
						<th>资质(信)类别</th>
						<th>资质(信)等级</th>
						<th>资质(信)审批机关</th>
						<th>资质(信)最新批准日期</th>
						<th>资质(信)有效期</th>
					</tr>
					<c:forEach items="${atlist}" var="atmodel"> 
					<tr>
						<td>${atmodel.certificate}</td>
						<td>${atmodel.adtypeName}</td>
						<td>${atmodel.adlevelName}</td>
						<td>${atmodel.approval}</td>
						<td>${atmodel.approvalTime}</td>
						<td>${atmodel.validity}</td>
					</tr>
					</c:forEach>
					
				</table>
			</div>
			<div class="column m3">
				<div class="ntitle">
					注册人员
				</div>
				<table border="0" cellspacing="2" cellpadding="0">
					<tr>
						<th>姓名</th>
						<th>注册类别</th>
						<th>注册编号</th>
					</tr>
					<c:forEach items="${enlist}" var="enmodel">
					<tr>
						<td ><a href="web_person_info.html?userId=${enmodel.userId}" class="fcolor">${enmodel.name}</a></td>
						<td>${enmodel.type}</td>
						<td>${enmodel.registration}</td>
					</tr>
					</c:forEach>
					<tr>
						<td>更多</td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</div>
			<div class="column m4">
				<div class="ntitle">
					工程项目
				</div>
				<p>
					<c:forEach items="${plist}" var="pmodel"> 
						<a href="web_project_info.html?id=${pmodel.id}">${pmodel.name}</a>
					</c:forEach>
				</p>
			</div>
			<div class="column m5">
				<div class="ntitle">
					良好行为
				</div>
				<p>
					<a href="#"></a>
				</p>
			</div>
			<div class="column m6">
				<div class="ntitle">
					不良行为
				</div>
				<p>
					<a href="#"></a>
				</p>
			</div>
			<div class="column m7">
				<div class="ntitle">
					欠薪行为
				</div>
				<p>
					<a href="#"></a>
				</p>
			</div>
		</div>
		<jsp:include page="../../down.jsp" flush="true" />
		<div class="mask"></div>
		

		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/web/enter_menber.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>