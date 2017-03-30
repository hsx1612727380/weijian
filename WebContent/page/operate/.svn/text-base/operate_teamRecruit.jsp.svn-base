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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operatemanage.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operateadd.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/newoperate.css" />
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			
			<div class="detail">
				<div class="detailright">
					<form action="operate_teamRecruit2.html" method="post">
						<input type="hidden" name="projectId" value="${projectModel.id }"/>
						<div>
							<label>公司名称</label>
							<span>${companyModel.name }</span>
						</div>
						<div>
							<label>项目名称</label>
							<span>${projectModel.name }</span>
						</div>
						<div>
							<label>班组类型</label>
							<span>施工班组</span>
						</div>
						<div>
							<label>招聘主题</label>
							<input id="title" type="text" name="title" placeholder="必填"/>
						</div>
						<div>
							<label>技能类别</label>
							<select id="skillBigType" name="skillBigType" onchange="getTeamSkillSmallType();">
								<option value="">--请选择技能类别--</option>
								<option value="1">土建</option>
								<option value="2">管理</option>
								<option value="3">安装</option>
								<option value="4">其他</option>
							</select>
						</div>
						<div>
							<label>技能类型</label>
							<select id="skillSmallType" name="skillSmallType">
								<c:choose>
									<c:when test="${requirementsModel.skillSmallType==0}">
										<option selected="selected" value="">--请选择技能类型--</option>
									</c:when>
									<c:otherwise>
										<option selected="selected" value="${requirementsModel.skillSmallType}">${requirementsModel.skillBigTypeName}</option>
									</c:otherwise>
								</c:choose>
							</select>
						</div>
						<div>
							<label>招聘区域</label>
							<span>
								<select id="province" onchange="setCity(this.value);getArea();" name="province" style="width: 156px;" runat="server">
									<option value="" selected="selected">--请选择省份--</option>
								</select>
								<select id="city" onchange="setCounty(this.value);getArea();" name="city" style="width: 156px;" runat="server">
									<option value="" selected="selected">--请选择城市--</option>
								</select>
							</span>
						</div>
						<div>
							<label>联系人</label>
							<span>${projectModel.leaderName }</span>
						</div>
						<div>
							<label>联系方式</label>
							<span>${projectModel.userId }</span>
						</div>
						<div>
							<label>项目详细地址</label>
							<span>${projectModel.provinceChn }${projectModel.cityChn }${projectModel.street }</span>
						</div>
						<div>
							<label>备注</label>
							<input id="desc" type="text" name="desc"/>
						</div>
						<input id="teamRecruitAddSubmit" type="submit" class="identy" value="保存" />
						<input type="reset" class="cancel" value="取消" />
					</form>
				</div>
			</div>
			
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/area.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/operate/teamRecruit.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/operate/addSkillSmallType.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>