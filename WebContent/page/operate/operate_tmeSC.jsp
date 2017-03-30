<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.fengyun.web.hardcode.IMageUploadInfo"%>
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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operatesafety.css" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" >
			$(function(){
				$('.identy').on('click',function () {
					 var imageName = $(this).siblings().val();
					 var projectDepartmentId = $("#projectDepartmentId").val();
					 var securityClarificaitonPath = $("#securityClarificaitonPath").val();
					 var visitAddress = $("#visitAddress").val();
					 var vistPath = visitAddress + securityClarificaitonPath + projectDepartmentId + "/";
					 window.open(vistPath + imageName);
				});
			});
		</script>
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			<div class="texttitle">安全交底</div>
			<table class="searchtype" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th class="thpname">项目名称</th>
					<th class="thtmename">班组名称</th>
					<th class="thattach">
						附件上传
						<input type="hidden" id="projectDepartmentId" value="${projectDepartmentModel.id }">
						<input type="hidden" id="visitAddress" value="<%=IMageUploadInfo.VISITADDRESS.getValue()%>" />
						<input type="hidden" id="securityClarificaitonPath" value="<%=IMageUploadInfo.TMESECURITYCLARIFICAITON.getValue()%>" />
					</th>
					<th class="thdate">更新时间</th>
				</tr>
				<tr>
					<td>${projectModel.name }</td>
					<td>${tmeName }</td>
					<td>
						<c:if test="${projectDepartmentModel.securityClarificaiton == null }">
							<form action="operate_securityUploadImage.html?projectDepartmentId=${projectDepartmentModel.id }" method="post" enctype="multipart/form-data">
								<div class="files">
									<input type="file" name="securityClarificaiton" />
								</div>
								<div class="submit">
									<input type="submit" >
								</div>
							</form>
						</c:if>
						<c:if test="${projectDepartmentModel.securityClarificaiton == '' }">
							<form action="operate_securityUploadImage.html?projectDepartmentId=${projectDepartmentModel.id }" method="post" enctype="multipart/form-data">
								<div class="files">
									<input type="file" name="securityClarificaiton" />
								</div>
								<div class="submit">
									<input type="submit" >
								</div>
							</form>
						</c:if>
						<c:if test="${projectDepartmentModel.securityClarificaiton != null }">
							<div class='files identy'>
								<input type="button" id="identTitydemo" class="file" value="查看" style="margin-left: 0;" />
							</div>
							<input type="hidden" id="imageName" value="${projectDepartmentModel.securityClarificaiton }">
						</c:if>
					</td>
					<td>${projectDepartmentModel.securityDate }</td>
				</tr>
			</table>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>