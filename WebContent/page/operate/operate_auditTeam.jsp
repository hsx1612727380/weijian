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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operateaudit.css" />
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			
			<div class="batch clearfix">
				<div class="team">审核施工班组</div>
				<div class="auditer" onclick="operateTeamAgreeAll();">批量同意</div>
				<div class="auditer" onclick="operateTeamRejectAll();">批量拒绝</div>
			</div>
			<table border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th></th>
					<td>序号</td>
					<td>班组长</td>
					<td>手机号码</td>
					<td>诚信度</td>
					<td>申请项目</td>
					<td>申请时间</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${teamCommentVos }" var="teamCommentVo" varStatus="status">
					<tr>
						<th><input class="isSelected" type="checkbox"/></th>
						<input class="cursorIdTeam" type="hidden" name="id" value="${teamCommentVo.projectDepartmentModel.id }"/>
						<td>${status.index + 1}</td>
						<td class="cursor">${teamCommentVo.teamModel.leaderName }</td>
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
							<div><a href="operate_teamAgree.html?pdmId=${teamCommentVo.projectDepartmentModel.id }&projectId=${projectModel.id}" style="color: white;">同意</a></div>
							<div><a href="operate_teamReject.html?pdmId=${teamCommentVo.projectDepartmentModel.id }&projectId=${projectModel.id}" style="color: white;">拒绝</a></div>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="batch clearfix">
				<div class="team">审核材料班组</div>
				<div class="auditer" onclick="operateMaterialAgreeAll();">批量同意</div>
				<div class="auditer" onclick="operateMaterialRejectAll();">批量拒绝</div>
			</div>
			<table border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th></th>
					<td>序号</td>
					<td>班组长</td>
					<td>手机号码</td>
					<td>诚信度</td>
					<td>申请项目</td>
					<td>申请时间</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${materialCommentVos }" var="materialCommentVo" varStatus="status">
					<tr>
						<th><input class="isSelected2" type="checkbox" /></th>
						<input class="cursorIdMaterial" type="hidden" name="id" value="${materialCommentVo.projectDepartmentModel.id }"/>
						<td>${status.index + 1}</td>
						<td class="cursor">${materialCommentVo.materialModel.leaderName }</td>
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
							<div><a href="operate_materialAgree.html?pdmId=${materialCommentVo.projectDepartmentModel.id }&projectId=${projectModel.id}" style="color: white;">同意</a></div>
							<div><a href="operate_materialReject.html?pdmId=${materialCommentVo.projectDepartmentModel.id }&projectId=${projectModel.id}" style="color: white;">拒绝</a></div>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="batch clearfix">
				<div class="team">审核设备班组</div>
				<div class="auditer" onclick="operateEquipmentAgreeAll();">批量同意</div>
				<div class="auditer" onclick="operateEquipmentRejectAll();">批量拒绝</div>
			</div>
			<table border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th></th>
					<th>序号</th>
					<td>班组长</td>
					<td>手机号码</td>
					<td>诚信度</td>
					<td>申请项目</td>
					<td>申请时间</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${equipmentCommentVos }" var="equipmentCommentVo" varStatus="status">
					<tr>
						<th><input class="isSelected3" type="checkbox" /></th>
						<input class="cursorIdEquipment" type="hidden" name="id" value="${equipmentCommentVo.projectDepartmentModel.id }"/>
						<td>${status.index + 1}</td>
						<td class="cursor">${equipmentCommentVo.equipmentModel.leaderName }</td>
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
							<div><a href="operate_equipmentAgree.html?pdmId=${equipmentCommentVo.projectDepartmentModel.id }&projectId=${projectModel.id}" style="color: white;">同意</a></div>
							<div><a href="operate_equipmentReject.html?pdmId=${equipmentCommentVo.projectDepartmentModel.id }&projectId=${projectModel.id}" style="color: white;">拒绝</a></div>
						</td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/operate/auditTeam.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>