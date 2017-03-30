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
		<link rel="stylesheet" type="text/css" href="resource/css/web/guide.css"/>
	</head>

	<body >
		<jsp:include page="../../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span><c:if test="${type == 1}">金融保险</c:if>
					  <c:if test="${type == 2}">法律咨询</c:if>
				</span>
			</div>
		</div>
		<div class="textcontent content" style="min-height: 82%;box-sizing: border-box;">
			<h3>${model.title}</h3>
			${model.note}			
		</div>
		<jsp:include page="../../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>








