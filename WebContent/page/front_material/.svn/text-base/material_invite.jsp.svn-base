<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8" />
<title>乐建平台</title>
<link rel="stylesheet" type="text/css" href="../resource/css/normalize.css"/>
<link rel="stylesheet" type="text/css" href="../resource/css/common.css" />
<link rel="stylesheet" type="text/css" href="../resource/css/front_equipment/equipFile.css" />
<script type="text/javascript">
	console.log('${msg}');
</script>
</head>

<body>
	
	<jsp:include page="../top.jsp" flush="true" />
	<div class="title">
		<div class="content">
			<span>个人中心</span>
		</div>
	</div>
	<div class="content personal">
		<div class="autstate">
			<span>认证状态：</span><span>材料班组</span>
		</div>
		<div class="detail">
			<jsp:include page="material_left.jsp" flush="true" />
			<div class="detailright">
				<div class="persontitle">
					<div class="filetile">邀请列表 : <font color="red" size="3px">${msg}</font></div>
				</div>
				<table class="invite" border="0" cellspacing="1" cellpadding="5">
					<tr>
						<th>项目名称</th>
						<th>所在区域</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${projectList}" var="projectModel">
					<tr>
						<td>${projectModel.name}</td>
						<td>${projectModel.provinceChn}${projectModel.cityChn}</td>
						<td>
							<a href="invationfeedback.html?pId=${projectModel.id}&flag=1&name=${projectModel.name}"><span>接受</span></a>
							<a href="invationfeedback.html?pId=${projectModel.id}&flag=0&name=${projectModel.name}"><span>拒绝</span></a>
						</td>
					</tr>
					</c:forEach>
					
				</table>
				
			</div>
		</div>
	</div>
	<jsp:include page="../down.jsp" flush="true" />
	<script src="../resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="../resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	<script src="../resource/js/front_equipment/idequip.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>