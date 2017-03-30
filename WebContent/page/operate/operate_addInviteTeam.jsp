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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operateinvite.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/newoperate.css" />
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			
			<div class="search">
				查询条件
			</div>
			<form action="operate_searchTeam.html?projectId=${projectModel.id }" method="post">
				<table class="condition" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>班组类型<span style="color: red">*</span></td>
						<td>
							<select id="team" name="teamType">
								<option value="0">请选择班组类别</option>
								<option value="1">施工班组</option>
								<option value="2">材料商</option>
								<option value="3">设备商</option>
							</select>
						</td>
						<td id="skills">技能类别<span style="color: red">*</span></td>
						<td id="skillsel">
							<select></select>
						</td>
						<td id="skilltype">技能类型</td>
						<td id="skilltypesel">
							<select></select>
						</td>
						<td>
							<div>
								<input id="searchSubmit" type="submit" value="搜索"/>
							</div>
						</td>
					</tr>
				</table>
			</form>
			<table class="searchtype" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th>班组类型</th>
					<th>求职地区</th>
					<th>班组名称</th>
					<th>班组长</th>
					<th>诚信度</th>
					<th>联系方式</th>
					<th>操作</th>
				</tr>
				<c:if test="${teamType==1 }">
					<c:forEach items="${requirementsTeamVos }" var="requirementsTeamVo">
						<tr>
							<td>施工班组</td>
							<td>${requirementsTeamVo.teamModel.provinceChn }${requirementsTeamVo.teamModel.cityChn }</td>
							<td>${requirementsTeamVo.teamModel.name }</td>
							<td>${requirementsTeamVo.teamModel.leaderName }</td>
							<td>
								<c:forEach begin="1" end="${requirementsTeamVo.starNum }">
									<img src="<%=basePath%>/resource/images/u662.png"/>
								</c:forEach>
								<c:forEach begin="${requirementsTeamVo.starNum + 1}" end="5">
									<img src="<%=basePath%>/resource/images/u663.fw.png"/>
								</c:forEach>
							</td>
							<td>${requirementsTeamVo.teamModel.leaderMobile }</td>
							<td>
								<div>
									<a href="operate_inviteOneTeam.html?vId=${requirementsTeamVo.teamModel.id }&projectId=${projectModel.id}&teamType=${teamType}&sUserId=${projectModel.userId }&rUserId=${requirementsTeamVo.teamModel.leaderMobile }">邀请</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${teamType==2 }">
					<c:forEach items="${requirementsMaterialVos }" var="requirementsMaterialVo">
						<tr>
							<td>材料商</td>
							<td>${requirementsMaterialVo.materialModel.provinceChn }${requirementsMaterialVo.materialModel.cityChn }</td>
							<td>${requirementsMaterialVo.materialModel.name }</td>
							<td>${requirementsMaterialVo.materialModel.leaderName }</td>
							<td>
								<c:forEach begin="1" end="${requirementsMaterialVo.starNum }">
									<img src="<%=basePath%>/resource/images/u662.png"/>
								</c:forEach>
								<c:forEach begin="${requirementsMaterialVo.starNum + 1}" end="5">
									<img src="<%=basePath%>/resource/images/u663.fw.png"/>
								</c:forEach>
							</td>
							<td>${requirementsMaterialVo.materialModel.userId }</td>
							<td>
								<div>
									<a href="operate_inviteOneMaterial.html?vId=${requirementsMaterialVo.materialModel.id }&projectId=${projectModel.id}&teamType=${teamType}&sUserId=${projectModel.userId }&rUserId=${requirementsMaterialVo.materialModel.userId }">邀请</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${teamType==3 }">
					<c:forEach items="${requirementsEquipmentVos }" var="requirementsEquipmentVo">
						<tr>
							<td>设备商</td>
							<td>${requirementsEquipmentVo.equipmentModel.provinceChn }${requirementsEquipmentVo.equipmentModel.cityChn }</td>
							<td>${requirementsEquipmentVo.equipmentModel.name }</td>
							<td>${requirementsEquipmentVo.equipmentModel.leaderName }</td>
							<td>
								<c:forEach begin="1" end="${requirementsEquipmentVo.starNum }">
									<img src="<%=basePath%>/resource/images/u662.png"/>
								</c:forEach>
								<c:forEach begin="${requirementsEquipmentVo.starNum + 1}" end="5">
									<img src="<%=basePath%>/resource/images/u663.fw.png"/>
								</c:forEach>
							</td>
							<td>${requirementsEquipmentVo.equipmentModel.userId }</td>
							<td>
								<div>
									<a href="operate_inviteOneEquipment.html?vId=${requirementsEquipmentVo.equipmentModel.id }&projectId=${projectModel.id}&teamType=${teamType}&sUserId=${projectModel.userId }&rUserId=${requirementsEquipmentVo.equipmentModel.userId }">邀请</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/operate/operateinvite.js" type="text/javascript" charset="utf-8"></script>
		
	</body>

</html>