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
					<form method="post" action="operate_posterUserAdd2.html">
						<input type="hidden" name="pId" value="${projectModel.id }"/>
						<input type="hidden" name="flag" value="${flag }"/>
						<div>
							<label>项目名称</label>
							<span>${projectModel.name }</span>
						</div>
						<div>
							<label>班组名称</label>
							<span>
								<select id="teamName" name="teamName">
									<option value="">--请选择班组名称--</option>
									<c:forEach items="${teamModels }" var="teamModel">
										<option value="${teamModel.id }">${teamModel.name }</option>
									</c:forEach>
								</select>
							</span>
						</div>
						<div>
							<label>姓名</label>
							<span><input id="userName" type="text" name="userName" placeholder="必填"/></span>
						</div>
						<div>
							<label>性别</label>
							<span>
								<select name="userSex">
									<option value="1">男</option>
									<option value="2">女</option>
								</select>
							</span>
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
							<label>身份证号</label>
							<span id="posterUserIdentity"><input id="userIdentity" type="text" name="userIdentity" placeholder="必填"/></span>
						</div>
						<div>
							<label>省份</label>
							<span>
								<select id="province" onchange="setCity(this.value);getArea();" name="userProvince" style="width: 156px;" runat="server">
									<option value="" selected="selected">--请选择省份--</option>
								</select>
							</span>
						</div>
						<div>
							<label>城市</label>
							<span>
								<select id="city" onchange="setCounty(this.value);getArea();" name="userCity" style="width: 156px;" runat="server">
									<option value="" selected="selected">--请选择城市--</option>
								</select>
							</span>
						</div>
						<div>
							<label>街道</label>
							<span><input id="userStreet" type="text" name="userStreet" placeholder="必填"/></span>
						</div>
						<div>
							<label>联系方式</label>
							<span id="posteUserId"><input id="userId" type="text" name="userId" placeholder="必填"/></span>
						</div>
						<input id="userPosterAddSubmit" type="submit" class="identy" value="保存" />
						<input type="reset"class="cancel" value="取消" />
					</form>
				</div>
			</div>
			
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/area.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/operate/posterUserAdd.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/operate/addSkillSmallType.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>