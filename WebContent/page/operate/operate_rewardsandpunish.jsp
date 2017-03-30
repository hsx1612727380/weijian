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
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/operate/operateenter.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/operate/newoperate.css" />
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			<div class="persontitle clearfix">
				<div class="filetile">班组奖惩记录：<div class="update" ><a href="toAddRewardsAndPunish.html?type=1&pId=${projectModel.id}"><font color="white">新增班组奖惩</font></a></div></div>
			</div>
			<table border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th>序号</th>
					<th>班组名称</th>
					<th>班组长</th>
					<th>联系方式</th>
					<th>性质</th>
					<th>行为</th>
					<th>操作</th>
				</tr>
				
				<c:forEach items="${leaderList}" var="leader" varStatus="status" >
				<tr>
					<td>${status.index}</td>
					<td>${leader.teamName}</td>
					<td>${leader.name}</td>
					<td>${leader.userId}</td>
					<td>${leader.character}</td>
					<td>${leader.measure}</td>
					<td>
						<div><a href="deleteOne.html?id=${leader.id}&pId=${leader.pId}"><font color="white">删除</font></a></div>
					</td>
				</tr>
				</c:forEach>
			</table>
			<div class="persontitle clearfix">
				<div class="filetile">个人奖惩记录：<div class="update"><a href="toAddRewardsAndPunish.html?type=0"><font color="white">新增个人奖惩</font></a></div></div>
			</div>
			<table border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th>序号</th>
					<th>班组名称</th>
					<th>姓名</th>
					<th>联系方式</th>
					<th>性质</th>
					<th>行为</th>
					<th>操作</th>
				</tr>
				
				<c:forEach items="${workerList}" var="worker" varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td>${worker.teamName}</td>
					<td>${worker.name}</td>
					<td>${worker.userId}</td>
					<td>${worker.character}</td>
					<td>${worker.measure}</td>
					<td>
						<div><a href="deleteOne.html?id=${worker.id}&pId=${worker.pId}"><font color="white">删除</font></a></div>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_company/identerprise.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>