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
			<div style="font-size:20px;color:#555;font-weight:bold;">
				已退场班组
			</div>
			<div class="construct">
				<div class="profile clearfix">
					<div class="filetile">施工班组</div>
				</div>
				<table border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td>序号</td>
						<td>班组名称</td>
						<td>班组长</td>
						<td>联系方式</td>
						<td>求职地区</td>
						<td>技能类别</td>
						<td>技能类型</td>
						<td>技能</td>
						<td>勤劳度</td>
						<td>工作记录</td>
						<td>差评记录</td>
						<!-- <td>操作</td> -->
					</tr>
					<c:forEach items="${teamCommentVos }" var="teamCommentVo" varStatus="status"> 
						<tr>
							<td>${status.index + 1 }</td>
							<td>${teamCommentVo.teamModel.name }</td>
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
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="construct">
				<div class="profile clearfix">
					<div class="filetile">材料班组</div>
					<%-- <div class="audit"><a href="operate_materialRecruit.html?projectId=${projectModel.id }">材料采购</a></div> --%>
				</div>
				<table border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td>序号</td>
						<td>班组名称</td>
						<td>班组长</td>
						<td>联系方式</td>
						<td>材料名称</td>
						<td>供货地区</td>
						<td>质量</td>
						<td>价格</td>
						<td>售后服务</td>
						<td>差评记录</td>
						<!-- <td>操作</td> -->
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
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="construct">
				<div class="profile clearfix">
					<div class="filetile">设备班组</div>
					<%-- <div class="audit"><a href="operate_equipmentRecruit.html?projectId=${projectModel.id }">设备租赁</a></div> --%>
				</div>
				<table border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td>序号</td>
						<td>班组名称</td>
						<td>班组长</td>
						<td>联系方式</td>
						<td>材料名称</td>
						<td>供货地区</td>
						<td>质量</td>
						<td>价格</td>
						<td>售后服务</td>
						<td>差评记录</td>
						<!-- <td>操作</td> -->
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
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>