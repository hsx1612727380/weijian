<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/recruit_menber.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/tabfooter.css" />
		<script src="resource/js/front_person/applyTeam.js" type="text/javascript" charset="utf-8"></script>
		
	</head>

	<body>
		<input id="isLeader" type="hidden" value='${isLeader}'/> 
		<jsp:include page="../top.jsp" flush="true" />
		<div class="title">
			<!-- <div class="content">
				<span>个人中心</span>
			</div> -->
		</div>
		<div class="content personal">
			<div class="autstate">
				<span>认证状态：</span><span>已认证 &nbsp;&nbsp;&nbsp;</span>
				<span>角色：</span><span>班组长</span>&nbsp;&nbsp;&nbsp;&nbsp;<font color="darkblue">班组。。。</font>
			</div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
				<div class="detailright" style="width:915px;margin-left:15px">
				<div class="content personal clearfix" style="width:100%">
			<div class="clearfix">
				<table class="entermenber" border="0" cellspacing="1" cellpadding="5" style="width:590px;">
					<tr>
					
						<th style="font-size: 20px;" colspan="6">刘明班</th>
					</tr>
					<tr>
						<th>班组名称</th>
						<td>${teamModel.name}</td>
						<td style="text-align: center;" rowspan="5"><img src="resource/images/front_person/475temp.png" /></td>
					</tr>
					<tr>
						<th>班组长</th>
						<td>${teamModel.leaderName}</td>

					</tr>
					<tr>
						<th>技能大类别</th>
						<td>${teamModel.leaderName}</td>
					</tr>
					<tr>
						<th>技能细分类型</th>
						<td>${teamModel.skillSmallTypeName}</td>
					</tr>
					<tr>
						<th>招聘人数</th>
						<td>${requireModel.num}</td>
					</tr>
					<tr>
						<th>所在区域</th>
						<td>${teamModel.provinceChn}${teamModel.cityChn}${teamModel.street}</td>
						<td></td>
					</tr>
					<tr>
						<th>要求诚信度</th>
						<td>4星</td>
						<td></td>
					</tr>
					<tr>
						<th>联系方式</th>
						<td>${teamModel.leaderMobile}</td>
						<td></td>
					</tr>
					<tr>
						<td>更新时间</td>
						<td>${requireModel.createTime}</td>
					</tr>
				</table>
				<div class="credit" style="margin-left:0px">
					<img src="resource/images/front_person/credit.jpg" />
					<div class="creditname">
						<span></span>
						<span class="creditrecord" >信用记录</span>
						<span></span>
					</div>
					<div class="records clearfix" style="margin-left: 35px;">
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
			<div><span class="permit">岗位要求</span></div>
			<div class="column">
				<p>${requireModel.desc}</p>
			</div>
		</div>

					
				</div>
				</div>
			</div>
			</div>
		
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>