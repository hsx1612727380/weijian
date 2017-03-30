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
		<link rel="stylesheet" type="text/css" href="resource/css/web/law.css"/>
	</head>

	<body>
		<jsp:include page="../../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>金融保障</span>
			</div>
		</div>
		<div class="textcontent content">
			<h3>太平洋保险建筑工程险 Construction All Risks Clauses In Pacific Insurance</h3>
			<a href="#"><img src="resource/images/u38.png"/></a>
			<a href="#"><img src="resource/images/u40.png"/></a>
			<a href="#"><img src="resource/images/u42.png"/></a>
			<a href="#"><img src="resource/images/u44.png"/></a>
			<h3>行业资讯Profession News</h3>
			<c:forEach items="${list}" var="model">
			<p><a href="web_lawer_info.html?id=${model.id}&type=1">${model.title}</a></p>
 			</c:forEach>
 			
			<h3>联系方式 Contact Us</h3>
			<p>中国太平洋财产保险股份有限公司</p>
 			<p>深圳分公司中心区支公司</p>
 			<p>联系电话：     4008-6060-25</p>
 			<p>地址：深圳市福田区天安数码创新科技广场I期B座1610室</p>
		</div>
		<jsp:include page="../../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>
