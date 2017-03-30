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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operate.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/newoperate.css" />
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			<div class="project clearfix">
				<ul>
					<li style="background-color: #FF6600;">
						<div>项目总人数</div>
						<div>0</div>
					</li>
					<li style="background-color: #C23531;">
						<div>施工班组</div>
						<div>0</div>
					</li>
					<li style="background-color: #2F4554;">
						<div>材料班组</div>
						<div>0</div>
					</li>
					<li style="background-color: #336666;">
						<div>设备班组</div>
						<div>0</div>
					</li>
				</ul>
			</div>
			<div id="echart"></div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_company/identerprise.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/echarts.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/operate/operate.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>