<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_person/person_left_handler.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/personGroup.css" />
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<input id="isLeader" type="hidden" value='${isLeader}'/> 
		<jsp:include page="../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>个人中心</span>
			</div>
		</div>
		<div class="content personal">
			<div class="autstate">
				<span>认证状态：</span><span>已认证 &nbsp;&nbsp;&nbsp;</span>
				<span>角色：</span><span>班组长</span>&nbsp;&nbsp;&nbsp;&nbsp;<font color="darkblue">班组及成员</font>
			</div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
				<div class="detailright">
					<div class="groupform">班组信息与管理：
						&nbsp;&nbsp;
						<span><a class="leaderinvite" href="invitePerson.html" style="border: none;border-radius: 3px;background-color: #3399FF;padding:4px 8px;color:white;font-size:12px;">班组长邀请工人</a></span>
					</div>
					
					<table class="groupdetail">
						<tr>
							<td>班组名称</td>
							<td>${teamModel.name}</td>
						</tr>
						<tr>
							<td>班组长</td>
							<td>${teamModel.leaderName}</td>
						</tr>
						<tr>
							<td>电话</td>
							<td>${teamModel.leaderMobile}</td>
						</tr>
						<tr>
							<td>地址</td>
							<td>${teamModel.provinceChn}&nbsp;${teamModel.cityChn}&nbsp;${teamModel.countyChn}&nbsp;${teamModel.street}</td>
						</tr>
						<tr>
							<td>技能类别</td>
							<td>${teamModel.skillBigTypeName}</td>
						</tr>
						<tr>
							<td>技能类型</td>
							<td>${teamModel.skillSmallTypeName}</td>
						</tr>
					</table>
					<div class="groupmenber">班组成员：&nbsp;<font color="red">${msg}</font></div> 
					
					<table class="menberdata" cellpadding="0" cellspacing="1"> 
						<tr>
							<td>序号</td>
							<td>姓名</td>
							<td>手机号</td>
							<td>移出班组</td>
						</tr>
						<c:forEach var="userModel" items="${uerModelList}" varStatus="status">
							<tr>
								<td><c:out value="${status.count}"></c:out></td>
								<td><c:out value="${userModel.userName}" ></c:out></td>
								<td><c:out value="${userModel.userId}"></c:out></td>
								<td><span style="margin:8px 0;display:inline-block"><a style="border-radius: 3px;background-color: #3399FF;padding: 4px 8px;color: white;font-size: 12px;" href="deleteMember.html?userId=${userModel.userId}"> 移出  </a></span></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		 <jsp:include page="../down.jsp" flush="true" />
		
	</body>

</html>