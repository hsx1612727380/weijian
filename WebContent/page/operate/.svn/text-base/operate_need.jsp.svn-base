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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operateneed.css" />
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			
			<div class="operate clearfix">
				<div>
					<a href="operate_addNeed.html?projectId=${projectModel.id }">新增</a>
				</div>
			</div>
			
			<table class="condition" border="0" cellspacing="1" cellpadding="0">
				<caption>施工班组</caption>
				<tr>
					<th>序号</th>
					<th>项目名称</th>
					<th>所在区域</th>
					<th>标题</th>
					<th>班组类型</th>
					<th>技能类别</th>
					<th>技能类型</th>
					<!-- <th>要求诚信度</th> -->
					<th>联系方式</th>
					<th>联系人</th>
					<th>地址</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${requirementsTeamModels }" var="requirementsTeamModel" varStatus="status">
					<tr>
						<td>${status.index + 1 }</td>
						<td>${projectModel.name }</td>
						<td>${projectModel.provinceChn }${projectModel.cityChn }</td>
						<td>${requirementsTeamModel.title }</td>
						<td>施工班组</td>
						<td>${requirementsTeamModel.skillBigTypeName }</td>
						<td>${requirementsTeamModel.skillSmallTypeName }</td>
						<!-- <td>4星</td> -->
						<td>${projectModel.userId }</td>
						<td>${projectModel.leaderName }</td>
						<td>${requirementsTeamModel.provinceStr }${requirementsTeamModel.cityStr }${requirementsTeamModel.street }</td>
						<td>${requirementsTeamModel.desc }</td>
						<td class="bigtd">
							<div class="need"><a href="javascript:if(confirm('确实要撤销${requirementsTeamModel.title }吗?'))location='operate_delTeamNeed.html?id=${requirementsTeamModel.id}&projectId=${projectModel.id }'" style="color: #FFFFFF;">撤销</a></div>
						</td>
					</tr>
				</c:forEach>
			</table>
			<table class="condition" border="0" cellspacing="1" cellpadding="0">
				<caption>材料班组</caption>
				<tr>
					<th>序号</th>
					<th>项目名称</th>
					<th>所在区域</th>
					<th>标题</th>
					<th>班组类型</th>
					<th>材料名称</th>
					<th>供货地区</th>
					<!-- <th>要求诚信度</th> -->
					<th>联系方式</th>
					<th>联系人</th>
					<th>地址</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${requirementsMaterialModels }" var="requirementsMaterialModel" varStatus="status">
					<tr>
						<td>${status.index + 1 }</td>
						<td>${projectModel.name }</td>
						<td>${projectModel.provinceChn }${projectModel.cityChn }</td>
						<td>${requirementsMaterialModel.title }</td>
						<td>材料班组</td>
						<td>${requirementsMaterialModel.shopName }</td>
						<td>${requirementsMaterialModel.provinceStr }${requirementsMaterialModel.cityStr }</td>
						<!-- <td>4星</td> -->
						<td>${projectModel.userId }</td>
						<td>${projectModel.leaderName }</td>
						<td>${requirementsMaterialModel.provinceStr }${requirementsMaterialModel.cityStr }${requirementsMaterialModel.street }</td>
						<td>${requirementsMaterialModel.desc }</td>
						<td class="bigtd">
							<div class="need"><a href="javascript:if(confirm('确实要撤销${requirementsMaterialModel.title }吗?'))location='operate_delMaterialNeed.html?id=${requirementsMaterialModel.id}&projectId=${projectModel.id }'" style="color: #FFFFFF;">撤销</a></div>
							<!-- <div class="need">删除</div> -->
							<!-- <div class="need">关闭</div> -->
						</td>
					</tr>
				</c:forEach>
			</table>
			<table class="condition" border="0" cellspacing="1" cellpadding="0">
				<caption>设备班组</caption>
				<tr>
					<th>序号</th>
					<th>项目名称</th>
					<th>所在区域</th>
					<th>标题</th>
					<th>班组类型</th>
					<th>材料名称</th>
					<th>供货地区</th>
					<!-- <th>要求诚信度</th> -->
					<th>联系方式</th>
					<th>联系人</th>
					<th>地址</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${requirementsEquipmentModels }" var="requirementsEquipmentModel" varStatus="status">
					<tr>
						<td>${status.index + 1 }</td>
						<td>${projectModel.name }</td>
						<td>${projectModel.provinceChn }${projectModel.cityChn }</td>
						<td>${requirementsEquipmentModel.title }</td>
						<td>设备班组</td>
						<td>${requirementsEquipmentModel.shopName }</td>
						<td>${requirementsEquipmentModel.provinceStr }${requirementsEquipmentModel.cityStr }</td>
						<!-- <td>4星</td> -->
						<td>${projectModel.userId }</td>
						<td>${projectModel.leaderName }</td>
						<td>${requirementsEquipmentModel.provinceStr }${requirementsEquipmentModel.cityStr }${requirementsEquipmentModel.street }</td>
						<td>${requirementsEquipmentModel.desc }</td>
						<td class="bigtd">
							<div class="need"><a href="javascript:if(confirm('确实要撤销${requirementsEquipmentModel.title }吗?'))location='operate_delEquipmentNeed.html?id=${requirementsEquipmentModel.id}&projectId=${projectModel.id }'" style="color: #FFFFFF;">撤销</a></div>
							<!-- <div class="need">删除</div> -->
							<!-- <div class="need">关闭</div> -->
						</td>
					</tr>
				</c:forEach>
			</table>
			<br/>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>