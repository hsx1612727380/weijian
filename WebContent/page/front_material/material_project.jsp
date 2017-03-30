<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.fengyun.web.hardcode.IMageUploadInfo"%> 
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
<link rel="stylesheet" type="text/css" href="../resource/css/front_equipment/equipFile.css" />
<link rel="stylesheet" type="text/css" href="../resource/css/tabfooter.css" />	

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
			<span>认证状态：</span><span>材料班组</span>
		</div>
		<div class="detail">
			<jsp:include page="material_left.jsp" flush="true" />
			<div class="detailright">
				<div class="persontitle">
					<div class="filetile">当前工程</div>
				</div>
				<table class="invite" border="0" cellspacing="1" cellpadding="5">
					<tr>
						<th>序号</th>
						<th>项目名称</th>
						<th>项目地址</th>
						<th>备注</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${projectVotList}" varStatus="status" var="projectVo">
					<tr>
						<td>${status.index+1}</td>
						<td>${projectVo.projectModel.name}</td>
						<td>${projectVo.projectModel.provinceChn}${projectVo.projectModel.cityChn}${projectVo.projectModel.street}</td>
						<td>
							${projectVo.remark}
							<input type="hidden" id="visitAddress" value="<%=IMageUploadInfo.VISITADDRESS.getValue()%>" />
							<input type="hidden" id="materialPath" value="<%=IMageUploadInfo.MATERIALPROJECTPATH.getValue()%>" />
						</td>
						<td>
							<c:if test="${projectVo.imageName==null}">
								<form action="material_uploadImage.html?projectId=${projectVo.projectModel.id}" method="post" enctype="multipart/form-data">
									<input type="file"  name="imageFile"> 
									<input type="submit">
								</form>
							</c:if> 
							<c:if test="${projectVo.imageName==''}">
								<form action="material_uploadImage.html?projectId=${projectVo.projectModel.id}" method="post" enctype="multipart/form-data">
									<input type="file"  name="imageFile"> 
									<input type="submit">
								</form>
							</c:if> 
							<c:if test="${projectVo.imageName!=null }">
								<c:if test="${projectVo.imageName!='' }">
									<input type="button" id="identTitydemo" class="identTitydemo" value="查看" style="margin-left: 0;" />
									<input type="hidden" id="imageName" class="imageNameHidden" value="${projectVo.imageName }">
									<input type="hidden" id="projectImag" class="projectHidden"  value="${projectVo.projectModel.id}">
								</c:if>
							</c:if>

							</td>
					</tr>
					</c:forEach>
				</table>
				<div class="persontitle">
					<div class="filetile">工程历史 </div>
				</div>
				<table class="invite" border="0" cellspacing="1" cellpadding="5">
					<tr>
						<th>序号</th>
						<th>项目名称</th>
						<th>项目地址</th>
						<th>备注</th>
						<th>图片</th>
					</tr>
					<c:forEach items="${pastList}" var="project">
					<tr>
						<td>${status.index+1}</td>
						<td>${project.name}</td>
						<td>${project.provinceChn}${project.cityChn}${project.street}</td>
						<td>${project.note}</td>
						<td>
						<c:if test="${projectVo.imageName==null }">
							<div id="userIdentity">
							</div>
						</c:if> 
						<c:if test="${projectVo.imageName=='' }">
							<div id="userIdentity">
							</div>
						</c:if>
						<c:if test="${projectVo.imageName!=null }">
							<c:if test="${projectVo.imageName!='' }">
								<input type="button" id="identTitydemo" class="identTitydemo" value="查看" style="margin-left: 0;" />
								<input type="hidden" id="imageName" class="imageNameHidden" value="${projectVo.imageName }">
								<input type="hidden" id="projectImag" class="projectHidden"  value="${projectVo.projectModel.id}">
							</c:if>
						</c:if>
					</td>
					</tr>
					</c:forEach>
				</table>
				<%-- <div class="tabfooter">
					<form action="materialSupply.html" method="post">
						<button value="1" name="pageNow">首页</button>
						<button value="${page.prePage}" name="pageNow">上一页</button>
						<span>当前有</span>
						<span>${page.pageNow}</span><span>/</span><span>${page.pageCount}</span>
						<span>页</span>
						<button value="${page.nextPage}" name="pageNow">下一页</button>
						<button value="${page.lastPage}" name="pageNow">尾页</button>
					</form>
				</div> --%>
			</div>
		</div>
	</div>
	<jsp:include page="../down.jsp" flush="true" />
	<script src="../resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="../resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/area.js" type="text/javascript" ></script>
	<script src="<%=basePath%>/resource/js/front_material/teampast.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" >
	$(function(){
		$('.identTitydemo').on('click',function ()
		{
			 var imageName = $(this).siblings(".imageNameHidden").val();
			 var projectId = $(this).siblings(".projectHidden").val();
			 var materialPath = $("#materialPath").val();
			 var visitAddress = $("#visitAddress").val();
			 var filePath=visitAddress+materialPath+projectId+"/";
// 			 window.open("../resource/images/front_material/"+projectId+"/"+imageName,"newwindow","height=400, width=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");	
			window.open(filePath+imageName);	
		})
	});
</script>
</body>

</html>