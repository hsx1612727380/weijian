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
		<link rel="stylesheet" type="text/css" href="resource/css/web/tender.css"/>
		<link rel="stylesheet" type="text/css" href="resource/css/web/enter_info.css"/>
		<link rel="stylesheet" type="text/css" href="resource/css/web/employ.css" />
	</head>

	<body>
		<jsp:include page="../../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>行业动态</span>
			</div>
		</div>
		<form action="industry_list.html" name="form1" method="post" class="struck">
		<div class="textcontent content">
			<c:forEach items="${clist}" var="model"> 
			<div class="enterinfo">
				<img src="resource/images/enterinfo1.jpeg" alt="" class="src" />
				<p><a href="${model.URL}">${model.title}</a></p>
				<p class="ptime"><span>发表于</span><span>${model.createTimeStr}</span></p>
			</div>
			</c:forEach>
			<div class="tabfooter">
				<button value="1" name="pageNow">首页</button>
				<button value="${page.prePage}" name="pageNow">上一页</button>
				<span>当前有</span>
						<span>${page.pageNow}</span><span>/</span><span>${page.pageCount}</span>
				<span>页</span>
				<button value="${page.nextPage}" name="pageNow">下一页</button>
				<button value="${page.lastPage}" name="pageNow">尾页</button>

			</div>
			
		</div>
		</form>
		<jsp:include page="../../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>