<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/web/law.css" />
	</head>

	<body>
		<jsp:include page="../../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>法律咨询</span>
			</div>
		</div>
		<div class="textcontent content">
			<h3>法律导读 Introduction To Law</h3>
			<a href="#"><img src="resource/images/u22.png"/></a>
			<a href="#"><img src="resource/images/u24.png"/></a>
			<a href="#"><img src="resource/images/u26.png"/></a>
			<a href="#"><img src="resource/images/u28.png"/></a>
			<h3>法律案例 The Legal Case</h3>
			<c:forEach items="${list}" var="model">
			<p><a href="web_lawer_info.html?id=${model.id}&type=2">${model.title}</a></p>
			</c:forEach>
			
		</div>
		<jsp:include page="../../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>