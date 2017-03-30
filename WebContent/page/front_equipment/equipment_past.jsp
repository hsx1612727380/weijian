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
<link rel="stylesheet" type="text/css" href="../resource/css/front_equipment/idequip.css" />

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
			<span>认证状态：</span><span>设备班组</span>
		</div>
		<div class="detail">
			<jsp:include page="equipment_left.jsp" flush="true" />
			<div class="detailright">
					<form method="post" enctype="multipart/form-data">
						<div>
							<label>项目名称</label>
							<input type="text" / value="广东省河源市天地花园项目">
						</div>
						<div>
							<label>项目地址</label>
							<input type="text" / value="广东省河源市源城区和平村自编1巷21号">
						</div>
						<div>
							<label>备注</label>
							<input type="text" value="取得圆满成果"/>
						</div>
					
						<input type="submit" class="identy" value="保存" />
					</form>
				</div>
		</div>
	</div>
	<jsp:include page="../down.jsp" flush="true" />
	<script src="../resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="../resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	<script src="../resource/js/front_equipment/idequip.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>