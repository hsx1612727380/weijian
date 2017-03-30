<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.fengyun.web.hardcode.IMageUploadInfo" %>
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
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<!-- 针对不同的登录用户类型隐藏左侧菜单的js -->
	<script src="resource/js/front_person/person_left_handler.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="resource/css/normalize.css"/>
	<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
	<link rel="stylesheet" type="text/css" href="resource/css/tabfooter.css" />	
	<link rel="stylesheet" type="text/css" href="resource/css/front_person/teamFile.css" />	
	<style>
		.personal .detailright td, .personal .detailright th{
			width:auto;
		}
	</style>
</head>

<body>
	<input id="isLeader" type="hidden" value='${isLeader}'/>
	<jsp:include page="../top.jsp" flush="true" />
	<div class="title">
		<div class="content">
			<span>个人中心</span>
		</div>
	</div>
	
	<div class="content personal">
		<div class="autstate">
			<span>认证状态：</span><span>已认证 &nbsp;&nbsp;&nbsp;</span>
				<span>角色：</span><span>班组长</span>&nbsp;&nbsp;&nbsp;&nbsp;<font color="darkblue">工程项目</font>
		</div>
		<div class="detail">
			<jsp:include page="person_left.jsp" flush="true" />
			<div class="detailright">
				<div class="persontitle">
					<div class="filetile">当前工程</div>
				</div>
				<input type="hidden" id="visitAddress" value="<%=IMageUploadInfo.VISITADDRESS.value%>" />
				<input type="hidden" id="teamproject" value="<%=IMageUploadInfo.TEAMPROJECT.value%>" />
				<table class="invite" border="0" cellspacing="1" cellpadding="5">
					<tr>
						<th>序号</th>
						<th>项目名称</th>
						<th>项目地址</th>
						<th>备注</th>
						<th>图片</th>
					</tr>
					<!-- currentList是 Map<ProjectModel,ProjectDepartmentModel>  -->
					<c:forEach items="${currentList}" varStatus="status" var="project_department">
					<tr>
						<td>${status.index+1}</td>
						<td>${project_department.key.name}</td>
						<td>${project_department.key.provinceChn}${project_department.key.cityChn}${project_department.key.street}</td>
						<td>${project_department.key.note}</td>
						<td>
							<input type="hidden" class="imageName"  value="${project_department.value.imageName}">
							<c:choose>
								<c:when test="${project_department.value.imageName ==null||project_department.value.imageName == ''}">
									<form action="project_uploadImageName.html?id=${project_department.value.id}" method="post" enctype="multipart/form-data">
										<div class="files" style="float:left;margin-left:14px">
											<input type="file" name="imageName"/>
										</div>
										<div class="submit" style="float:left;margin-left:4px">
											<input type="submit">
										</div>
									</form>
								</c:when>
								<c:when test="${project_department.value.imageName!= null }">
									<div>
										<input type="hidden" value="${project_department.value.id}"><!-- 用户通过下面的兄弟元素获取值，来显示图片 -->
										<input type="button" class="file" style="margin-left: 0;" value="查看"/>
										<input type="hidden" value="${project_department.value.imageName}">
									</div>
								</c:when>
								<c:otherwise >其他</c:otherwise>
							</c:choose>
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
					<c:forEach items="${pastList}" var="projectdepartmentp">
					<tr>
						<td>${status.index+1}</td>
						<td>${projectdepartmentp.key.name}</td>
						<td>${projectdepartmentp.key.provinceChn}${projectdepartmentp.key.cityChn}${projectdepartmentp.key.street}</td>
						<td>${projectdepartmentp.key.note}</td>
						<td>
							<input type="hidden" class="imageName"  value="${project_departmentp.value.imageName}">
							<c:if test="${projectdepartmentp.value.imageName!= null} && ${projectdepartmentp.value.imageName!= ''}">
								<div>
									<input type="hidden" value="${projectdepartmentp.value.id}"><!-- 用户通过下面的兄弟元素获取值，来显示图片 -->
									<input type="button" class="file" style="margin-left: 0;" value="查看"/>
									<input type="hidden" value="${projectdepartmentp.value.imageName}">
								</div>
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
	<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/area.js" type="text/javascript" ></script>
	<script src="<%=basePath%>/resource/js/front_material/teampast.js" type="text/javascript" charset="utf-8"></script>
</body>
<script>
	//查看上传的图片
	$('.file').on('click',function(){
		var id=$(this).siblings().eq(0).val();
		var imageName=$(this).siblings().eq(1).val();	//和下面两行的效果一样，通过当前点击元素的兄弟元素来获取隐藏的兄弟元素。
		//var index=$(this).parent().parent().parent().children().first().html();
		//var imageName=$(".imageName").eq(index-1).val(); //获取到循环列出的所有imageName中的第index-1次循环中的imageName
		var teamproject=$("#teamproject").val();
		var visitAddress=$("#visitAddress").val();
		window.open(visitAddress+teamproject+id+"\\"+imageName);	
	});
	
</script>
</html>