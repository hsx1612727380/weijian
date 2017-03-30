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
		<link rel="stylesheet" type="text/css" href="resource/css/web/tender.css" />
	</head>

	<body>
		<jsp:include page="../../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>招投标</span>
			</div>
		</div>
		<div class="textcontent content">
			<table>
				<tr><th>招标信息</th></tr>
				<c:forEach items="${clist}" var="model" varStatus="idx"> 
				<c:if test="${idx.index % 3 == 0}"><tr></c:if>
					<td><a href="${model.URL}">${model.title}</a></td>
				<c:if test="${idx.index % 3 == 2}"></tr></c:if>
				</c:forEach>
			</table>
		</div>
		<jsp:include page="../../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>