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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operateinfo.css" />
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=629Um5l2umNbmEo10SfHQjgM4cGtQe7b"></script>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			<table class="groud" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<td>项目名称</td>
					<td>${projectModel.name }</td>
					<th rowspan="7"><div id="container"></div></th>
				</tr>
				<tr>
					<td>所在区域</td>
					<td>${projectModel.provinceChn}${projectModel.cityChn}</td>
				</tr>
				<tr>
					<td>项目地址</td>
					<td>${projectModel.street }</td>
				</tr>
				<tr>
					<td>联系人</td>
					<td>${projectModel.leaderName }</td>
				</tr>
				<tr>
					<td>联系人身份证</td>
					<td>${projectModel.identity }</td>
				</tr>
				<tr>
					<td>手机号</td>
					<td>${projectModel.userId }</td>
				</tr>
				<tr>
					<td>合同价</td>
					<td>${projectModel.price }万</td>
				</tr>
			</table>
			<div>
				<!-- <label>经度</label> -->
				<input id="lonlat" type="hidden" value="${projectModel.longitude }">
			</div>
			<div>
				<!-- <label>纬度</label> -->
				<input id="lonlat2" type="hidden" value="${projectModel.latitude }">
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/map.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			var map = new BMap.Map("map");
			var point = new BMap.Point($("#lonlat").val().trim(), $("#lonlat2").val().trim());
			map.centerAndZoom(point, 11);
		</script>
	</body>

</html>