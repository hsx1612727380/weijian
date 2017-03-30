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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operateadd.css" />
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			
			<div class="detail">
				<div class="detailright">
					<form method="post" action="operate_posterProjectAdd2.html">
						<input type="hidden" name="pId" value="${projectModel.id }"/>
						<input type="hidden" name="flag" value="${flag }"/>
						<div>
							<label>项目名称</label>
							<span>${projectModel.name }</span>
						</div>
						<div>
							<label>姓名</label>
							<span><input id="name" type="text" name="name" placeholder="必填"/></span>
						</div>
						<div>
							<label>性别</label>
							<span>
								<select name="sex">
									<option value="1">男</option>
									<option value="2">女</option>
								</select>
							</span>
						</div>
						<div>
							<label>职位</label>
							<span><input id="position" type="text" name="position" placeholder="必填"/></span>
						</div>
						<div>
							<label>身份证号</label>
							<span id="posterIdentity"><input id="identity" type="text" name="identity" placeholder="必填"/></span>
						</div>
						<div>
							<label>住址</label>
							<span><input id="address" type="text" name="address" placeholder="必填"/></span>
						</div>
						<div>
							<label>联系方式</label>
							<span id="posterPhone"><input id="phone" type="text" name="phone" placeholder="必填"/></span>
						</div>
						<input id="projectPosterAddSubmit" type="submit" class="identy" value="保存" />
						<input type="reset"class="cancel" value="取消" />
					</form>
				</div>
			</div>
			
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/operate/posterProjectAdd.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>