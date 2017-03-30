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
				<div class="filetile">班组进退场记录：<div class="update"><a href="operate_toaddenterandexit.html?id=${id}&type=2"><font color="white">新增班组进退场</font></a></div></div>
			</div>
			<table border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th>序号</th>
					<th>班组名称</th>
					<th>班组长</th>
					<th>联系方式</th>
					<th>进场时间</th>
					<th>退场时间</th>
					<th>技能</th>
					<th>勤劳度</th>
					<th>工作态度</th>
					<th>差评记录</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${leaderMap}" var="leader"  varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${leader.value.teamName}</td>
					<td>${leader.value.name}</td>
					<td>${leader.key.leaderMobile}</td>
					<td>${leader.value.startTime}</td>
					<td>${leader.value.endTime}</td>
					<td>
						<c:forEach begin="1" end="${leader.value.scoreStr1}">
						   <span><img src="resource/images/u662.png"/></span>
						</c:forEach>
						<c:forEach begin="${leader.value.scoreStr1}" end="4">
						   <span><img src="resource/images/u663.fw.png"/></span>
						</c:forEach>
					</td>
					<td>
						<c:forEach begin="1" end="${leader.value.scoreStr2}">
						   <span><img src="resource/images/u662.png"/></span>
						</c:forEach>
						<c:forEach begin="${leader.value.scoreStr2}" end="4">
						   <span><img src="resource/images/u663.fw.png"/></span>
						</c:forEach>
					</td>
					<td>
						<c:forEach begin="1" end="${leader.value.scoreStr3}">
						   <span><img src="resource/images/u662.png"/></span>
						</c:forEach>
						<c:forEach begin="${leader.value.scoreStr3}" end="4">
						   <span><img src="resource/images/u663.fw.png"/></span>
						</c:forEach>
					</td>
					<td>${leader.value.desc}</td>
					<td>
						<div><a href="deleteOneEAE.html?id=${leader.value.id}&pId=${leader.value.pId}"><font color="white">删除</font></a></div>
					</td>
				</tr>
				</c:forEach>
			</table>
			<div class="persontitle clearfix">
				<div class="filetile">个人进退场记录：<div class="update"><a href="operate_toaddenterandexit.html?id=${id}&type=1"><font color="white">新增工人进退场</font></a></div></div>
			</div>
			<table border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th>序号</th>
					<th>班组名称</th>
					<th>姓名</th>
					<th>联系方式</th>
					<th>进场时间</th>
					<th>退场时间</th>
					<th>技能</th>
					<th>勤劳度</th>
					<th>工作态度</th>
					<th>差评记录</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${workerList}" var="worker"  varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${worker.teamName}</td>
					<td>${worker.name}</td>
					<td>${worker.cId}</td>
					<td>${worker.startTime}</td>
					<td>${worker.endTime}</td>
					
					<td>
						<c:forEach begin="1" end="${worker.scoreStr1}">
						   <span><img src="resource/images/u662.png"/></span>
						</c:forEach>
						<c:forEach begin="${worker.scoreStr1}" end="4">
						   <span><img src="resource/images/u663.fw.png"/></span>
						</c:forEach>
					</td>
					<td>
						<c:forEach begin="1" end="${worker.scoreStr2}">
						   <span><img src="resource/images/u662.png"/></span>
						</c:forEach>
						<c:forEach begin="${worker.scoreStr2}" end="4">
						   <span><img src="resource/images/u663.fw.png"/></span>
						</c:forEach>
					</td>
					<td>
						<c:forEach begin="1" end="${worker.scoreStr3}">
						   <span><img src="resource/images/u662.png"/></span>
						</c:forEach>
						<c:forEach begin="${worker.scoreStr3}" end="4">
						   <span><img src="resource/images/u663.fw.png"/></span>
						</c:forEach>
					</td>
					<td>${worker.desc}</td>
					<td>
						<div><a href="deleteOneEAE.html?id=${worker.id}&pId=${worker.pId}"><font color="white">删除</font></a></div>
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