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
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			<div class="operate clearfix">
				<div><a href="operate_inviteTeam.html?projectId=${projectModel.id }">邀请班组</a></div>
				<div><a href="operate_auditTeam.html?projectId=${projectModel.id }">审核班组</a></div>
				<div><a href="operate_leaveTeam.html?projectId=${projectModel.id }">已退场班组</a></div>
			</div>
			<div class="construct">
				<div class="profile clearfix">
					<div class="filetile">施工班组</div>
				</div>
				<table class="menu" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td>序号</td>
						<td>班组名称</td>
						<td>班组长</td>
						<td>联系方式</td>
						<td>求职地区</td>
						<td>技能类别</td>
						<td>技能类型</td>
						<td class="tdstar">技能</td>
						<td class="tdstar">勤劳度</td>
						<td class="tdstar">工作记录</td>
						<td>差评记录</td>
						<td class="tdblock">标签</td>
						<td class="tdaudit">操作</td>
					</tr>
					<c:forEach items="${teamCommentVos }" var="teamCommentVo" varStatus="status"> 
						<tr>
							<td>${status.index + 1 }</td>
							<td><span style="color: blue;">
								<input type="hidden" value="${teamCommentVo.projectDepartmentModel.id }">
								<input type="hidden" value="${teamCommentVo.teamModel.name }">
								<input type="hidden" value="${teamCommentVo.teamModel.leaderName }">
								${teamCommentVo.teamModel.name }
							</span></td>
							<td>${teamCommentVo.teamModel.leaderName }</td>
							<td>${teamCommentVo.teamModel.leaderMobile }</td>
							<td>${teamCommentVo.teamModel.provinceChn }${teamCommentVo.teamModel.cityChn }</td>
							<td>${teamCommentVo.teamModel.skillBigTypeName }</td>
							<td>${teamCommentVo.teamModel.skillSmallTypeName }</td>
							<td>
								<c:forEach begin="1" end="${teamCommentVo.commentsModel.scoreStr1 }">
								   	<span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="${teamCommentVo.commentsModel.scoreStr1 + 1}" end="5">
									<span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach>
							</td>
							<td>
								<c:forEach begin="1" end="${teamCommentVo.commentsModel.scoreStr2 }">
								   	<span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="${teamCommentVo.commentsModel.scoreStr2 + 1}" end="5">
									<span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach>
							</td>
							<td>
								<c:forEach begin="1" end="${teamCommentVo.commentsModel.scoreStr3 }">
								   	<span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="${teamCommentVo.commentsModel.scoreStr3 + 1}" end="5">
									<span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach>
							</td>
							<td>${teamCommentVo.commentsModel.desc }</td>
							<td>
								<form action="operate_tmeUpdateLabel.html?projectDepartmentId=${teamCommentVo.projectDepartmentModel.id }&pId=${teamCommentVo.projectDepartmentModel.pId }" method="post">
									<span class="spanblock">${teamCommentVo.projectDepartmentModel.label }</span>
									<div class="tagbox">
										<input type="text" name="label"/>
										<img src="<%=basePath%>/resource/images/get.png" alt="" />
									</div>
									<img class="tag" src="<%=basePath%>/resource/images/label.png" />
								</form>
							</td>
							<td>
								<div class="audit"><a href="operate_tmeSC.html?projectDepartmentId=${teamCommentVo.projectDepartmentModel.id }" style="color: white;">安全交底</a></div>
								<div class="audit"><a href="operate_tmeQC.html?projectDepartmentId=${teamCommentVo.projectDepartmentModel.id }" style="color: white;">质量交底</a></div>
							</td>
							<%-- <td>
								<div class="deleted">
									<a href="javascript:if(confirm('确实要删除${teamCommentVo.teamModel.name}吗?'))location='operate_delTeam.html?vId=${teamCommentVo.projectDepartmentModel.vId}&pId=${teamCommentVo.projectDepartmentModel.pId }&type=${teamCommentVo.projectDepartmentModel.type }'">删除</a>
								</div>
							</td> --%>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="construct">
				<div class="profile clearfix">
					<div class="filetile">材料班组</div>
					<%-- <div class="audit"><a href="operate_materialRecruit.html?projectId=${projectModel.id }">材料采购</a></div> --%>
				</div>
				<table class="menu" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td>序号</td>
						<td>班组名称</td>
						<td>班组长</td>
						<td>联系方式</td>
						<td>材料名称</td>
						<td>供货地区</td>
						<td class="tdstar">质量</td>
						<td class="tdstar">价格</td>
						<td class="tdstar">售后服务</td>
						<td>差评记录</td>
						<!-- <td class="tdblock">标签</td> -->
						<td class="tdaudit">操作</td>
					</tr>
					<c:forEach items="${materialCommentVos }" var="materialCommentVo" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<td>${materialCommentVo.materialModel.name }</td>
							<td>${materialCommentVo.materialModel.leaderName }</td>
							<td>${materialCommentVo.materialModel.userId }</td>
							<td>${materialCommentVo.materialModel.shopName }</td>
							<td>${materialCommentVo.materialModel.provinceChn }${materialCommentVo.materialModel.cityChn }</td>
							<td>
								<c:forEach begin="1" end="${materialCommentVo.commentsModel.scoreStr1 }">
								   	<span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="${materialCommentVo.commentsModel.scoreStr1 + 1}" end="5">
									<span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach>
							</td>
							<td>
								<c:forEach begin="1" end="${materialCommentVo.commentsModel.scoreStr2 }">
								   	<span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="${materialCommentVo.commentsModel.scoreStr2 + 1}" end="5">
									<span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach>
							</td>
							<td>
								<c:forEach begin="1" end="${materialCommentVo.commentsModel.scoreStr3 }">
								   	<span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="${materialCommentVo.commentsModel.scoreStr3 + 1}" end="5">
									<span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach>
							</td>
							<td>${materialCommentVo.commentsModel.desc }</td>
							<%-- <td>
								<form action="operate_tmeUpdateLabel.html?projectDepartmentId=${materialCommentVo.projectDepartmentModel.id }&pId=${materialCommentVo.projectDepartmentModel.pId }" method="post">
									<span class="spanblock">${materialCommentVo.projectDepartmentModel.label }</span>
									<div class="tagbox">
										<input type="text" name="label"/>
										<img src="<%=basePath%>/resource/images/get.png" alt="" />
									</div>
									<img class="tag" src="<%=basePath%>/resource/images/label.png" />
								</form>
							</td> --%>
							<td>
								<div class="audit"><a href="operate_tmeSC.html?projectDepartmentId=${materialCommentVo.projectDepartmentModel.id }" style="color: white;">安全交底</a></div>
								<div class="audit"><a href="operate_tmeQC.html?projectDepartmentId=${materialCommentVo.projectDepartmentModel.id }" style="color: white;">质量交底</a></div>
							</td>
							<%-- <td>
								<div class="deleted">
									<a href="javascript:if(confirm('确实要删除${materialCommentVo.materialModel.name}吗?'))location='operate_delMaterial.html?vId=${materialCommentVo.projectDepartmentModel.vId}&pId=${materialCommentVo.projectDepartmentModel.pId }&type=${materialCommentVo.projectDepartmentModel.type }'">删除</a>
								</div>
							</td> --%>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="construct">
				<div class="profile clearfix">
					<div class="filetile">设备班组</div>
					<%-- <div class="audit"><a href="operate_equipmentRecruit.html?projectId=${projectModel.id }">设备租赁</a></div> --%>
				</div>
				<table class="menu" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td>序号</td>
						<td>班组名称</td>
						<td>班组长</td>
						<td>联系方式</td>
						<td>材料名称</td>
						<td>供货地区</td>
						<td class="tdstar">质量</td>
						<td class="tdstar">价格</td>
						<td class="tdstar">售后服务</td>
						<td>差评记录</td>
						<!-- <td class="tdblock">标签</td> -->
						<td class="tdaudit">操作</td>
					</tr>
					<c:forEach items="${equipmentCommentVos }" var="equipmentCommentVo" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<td>${equipmentCommentVo.equipmentModel.name }</td>
							<td>${equipmentCommentVo.equipmentModel.leaderName }</td>
							<td>${equipmentCommentVo.equipmentModel.userId }</td>
							<td>${equipmentCommentVo.equipmentModel.shopName }</td>
							<td>${equipmentCommentVo.equipmentModel.provinceChn }${equipmentCommentVo.equipmentModel.cityChn }</td>
							<td>
								<c:forEach begin="1" end="${equipmentCommentVo.commentsModel.scoreStr1 }">
								   	<span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="${equipmentCommentVo.commentsModel.scoreStr1 + 1}" end="5">
									<span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach>
							</td>
							<td>
								<c:forEach begin="1" end="${equipmentCommentVo.commentsModel.scoreStr2 }">
								   	<span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="${equipmentCommentVo.commentsModel.scoreStr2 + 1}" end="5">
									<span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach>
							</td>
							<td>
								<c:forEach begin="1" end="${equipmentCommentVo.commentsModel.scoreStr3 }">
								   	<span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="${equipmentCommentVo.commentsModel.scoreStr3 + 1}" end="5">
									<span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach>
							</td>
							<td>${equipmentCommentVo.commentsModel.desc }</td>
							<%-- <td>
								<form action="operate_tmeUpdateLabel.html?projectDepartmentId=${equipmentCommentVo.projectDepartmentModel.id }&pId=${equipmentCommentVo.projectDepartmentModel.pId }" method="post">
									<span class="spanblock">${equipmentCommentVo.projectDepartmentModel.label }</span>
									<div class="tagbox">
										<input type="text" name="label"/>
										<img src="<%=basePath%>/resource/images/get.png" alt="" />
									</div>
									<img class="tag" src="<%=basePath%>/resource/images/label.png" />
								</form>							
							</td> --%>
							<td>
								<div class="audit"><a href="operate_tmeSC.html?projectDepartmentId=${equipmentCommentVo.projectDepartmentModel.id }" style="color: white;">安全交底</a></div>
								<div class="audit"><a href="operate_tmeQC.html?projectDepartmentId=${equipmentCommentVo.projectDepartmentModel.id }" style="color: white;">质量交底</a></div>
							</td>
							<%-- <td>
								<div class="deleted">
									<a href="javascript:if(confirm('确实要删除${equipmentCommentVo.equipmentModel.name}吗?'))location='operate_delEquipment.html?vId=${equipmentCommentVo.projectDepartmentModel.vId}&pId=${equipmentCommentVo.projectDepartmentModel.pId }&type=${equipmentCommentVo.projectDepartmentModel.type }'">删除</a>
								</div>
							</td> --%>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<div class="chartbox">
			<table id="chart" class="chart" border="0" cellspacing="1" cellpadding="0">
			</table>
			<div class="X">×</div>
		</div>
		<div class="mask"></div>
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/operate/operatemanage.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>