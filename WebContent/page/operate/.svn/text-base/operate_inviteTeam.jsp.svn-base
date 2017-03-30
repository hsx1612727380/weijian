<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operatemanage.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/newoperate.css" />
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			
			<div class="operate clearfix">
				<div><a href="operate_addInviteTeam.html?projectId=${projectModel.id }&teamType=${teamType}&teamSkillBigType=${teamSkillBigType}&teamSkillSmallType=${teamSkillSmallType}&shopName=${shopName}&province=${province}&city=${city}">新增邀请</a></div>
			</div>
			<div class="construct">
				<div class="profile clearfix">
					<div class="filetile">已邀请施工班组</div>
				</div>
				<table border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td>序号</td>
						<td>班组长</td>
						<td>手机号码</td>
						<td>诚信度</td>
						<td>项目名称</td>
						<td>邀请时间</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${teamCommentVos }" var="teamCommentVo" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<td>${teamCommentVo.teamModel.leaderName }</td>
							<td>${teamCommentVo.teamModel.leaderMobile }</td>
							<td>
								<c:forEach begin="1" end="${teamCommentVo.starNum }">
									<img src="<%=basePath%>/resource/images/u662.png"/>
								</c:forEach>
								<c:forEach begin="${teamCommentVo.starNum + 1}" end="5">
									<img src="<%=basePath%>/resource/images/u663.fw.png"/>
								</c:forEach>
							</td>
							<td>${projectModel.name }</td>
							<td>${teamCommentVo.projectDepartmentModel.createTimeStr }</td> 
							<td>
								<div class="deleted">
									<a href="javascript:if(confirm('确实要撤销这条邀请的消息吗?'))location='operate_delInviteTeam.html?pdmId=${teamCommentVo.projectDepartmentModel.id}&projectId=${projectModel.id }&sUserId=${projectModel.userId }&rUserId=${teamCommentVo.teamModel.leaderMobile }'" style="color: white;">撤销</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="construct">
				<div class="profile clearfix">
					<div class="filetile">已邀请材料商</div>
				</div>
				<table border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td>序号</td>
						<td>材料商</td>
						<td>手机号码</td>
						<td>诚信度</td>
						<td>项目名称</td>
						<td>邀请时间</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${materialCommentVos }" var="materialCommentVo" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<td>${materialCommentVo.materialModel.leaderName }</td>
							<td>${materialCommentVo.materialModel.userId }</td>
							<td>
								<c:forEach begin="1" end="${materialCommentVo.starNum }">
									<img src="<%=basePath%>/resource/images/u662.png"/>
								</c:forEach>
								<c:forEach begin="${materialCommentVo.starNum + 1}" end="5">
									<img src="<%=basePath%>/resource/images/u663.fw.png"/>
								</c:forEach>
							</td>
							<td>${projectModel.name }</td>
							<td>${materialCommentVo.projectDepartmentModel.createTimeStr }</td>
							<td>
								<div class="deleted">
									<a href="javascript:if(confirm('确实要撤销这条邀请的消息吗?'))location='operate_delInviteMaterial.html?pdmId=${materialCommentVo.projectDepartmentModel.id}&projectId=${projectModel.id }&sUserId=${projectModel.userId }&rUserId=${materialCommentVo.materialModel.userId }'" style="color: white;">撤销</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="construct">
				<div class="profile clearfix">
					<div class="filetile">已邀请设备商</div>
				</div>
				<table border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td>序号</td>
						<td>设备商</td>
						<td>手机号码</td>
						<td>诚信度</td>
						<td>申请项目</td>
						<td>申请时间</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${equipmentCommentVos }" var="equipmentCommentVo" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<td>${equipmentCommentVo.equipmentModel.leaderName }</td>
							<td>${equipmentCommentVo.equipmentModel.userId }</td>
							<td>
								<c:forEach begin="1" end="${equipmentCommentVo.starNum }">
									<img src="<%=basePath%>/resource/images/u662.png"/>
								</c:forEach>
								<c:forEach begin="${equipmentCommentVo.starNum + 1}" end="5">
									<img src="<%=basePath%>/resource/images/u663.fw.png"/>
								</c:forEach>
							</td>
							<td>${projectModel.name }</td>
							<td>${equipmentCommentVo.projectDepartmentModel.createTimeStr }</td>
							<td>
								<div class="deleted">
									<a href="javascript:if(confirm('确实要撤销这条邀请的消息吗?'))location='operate_delInviteEquipment.html?pdmId=${equipmentCommentVo.projectDepartmentModel.id}&projectId=${projectModel.id }&sUserId=${projectModel.userId }&rUserId=${equipmentCommentVo.equipmentModel.userId }'" style="color: white;">撤销</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>