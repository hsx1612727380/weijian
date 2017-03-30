<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.fengyun.web.hardcode.IMageUploadInfo"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8" />
	<title>乐建平台</title>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<!-- 针对不同的登录用户类型隐藏左侧菜单的js -->
	<script src="resource/js/front_person/person_left_handler.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
	<link rel="stylesheet" type="text/css" href="resource/css/front_person/idperson.css" />
	<link rel="stylesheet" type="text/css" href="resource/css/tabfooter.css" />
	<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
</head>
	<script type="text/javascript" >
		if('${msg}'!='' && '${msg}'!=null ){
			alert('${msg}');
		}
	
		function myfunciton()
		{	
			console.log(1);
			var imageName=$("#imageName").val();
			var countyCode=$("#userIdentity1").val().substr(0,4);
			var visitAddress=$("#visitAddress").val();
			var itentityPath=$("#itentityPath").val()+countyCode+"/";
// 			window.open("resource/images/front_person/IdentityImage/"+countyCode+"/"+imageName,"newwindow","height=400, width=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");	
			window.open(visitAddress+itentityPath+imageName);	
		}
	
		function addModify()
		{
			$(".addressModify").toggle();
		}
	</script>
<body>
	<input type="hidden" id="type2" name="type2" value="${type}" />
	<input id="isLeader" type="hidden" value='${isLeader}'/> 
	<jsp:include page="../top.jsp" flush="true" />
	<div class="title">
		<div class="content">
			<span>个人中心</span>
		</div>
	</div>
	<div class="content personal">
	<div class="autstate">
		<c:if test="${isLeader=='1'}">
			<span>认证状态：已认证</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>角色：班组长</span>
			&nbsp;&nbsp;&nbsp;&nbsp;<font color="darkblue">班组信息</font>
		</c:if>
		<c:if test="${isLeader!='1'}">
			<span>认证状态：已认证</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>角色：个人</span>
			&nbsp;&nbsp;&nbsp;&nbsp;<font color="darkblue">个人信息</font>
		</c:if>
	</div>
		<div class="detail">
			<jsp:include page="person_left.jsp" flush="true" />
			<div class="detailright">
				<form method="post" action="personModify.html" name="userForm" enctype="multipart/form-data">
					<div>
						<label>手机号：</label> 
						<input type="text" value="${model.userId}" disabled="disabled"></input> 
						<input type="hidden" value="${model.userId}" name="userId"></input>
					</div>
					<div>
						<label>姓名：</label>
						<input type="text" value="${model.userName}" name="userName"></input>
					</div>
					<div id="userIdentity">
						<label>身份证：</label> 
						<input type="hidden" id="visitAddress" value="<%=IMageUploadInfo.VISITADDRESS.value%>" />
						<input type="hidden" id="itentityPath" value="<%=IMageUploadInfo.PERSONITENDITYBASEPATH.value%>" />
						<input type="text" id="userIdentity1" name="userIdentity" value="${model.userIdentity}" onchange="checkIdentity()"/> <span></span>
					</div>
					<c:if test="${model.getIdentityImageName()==null }">
						<div id="userIdentity">
							<label>上传身份证照片：</label> <input type="file" name="imageFile"> <span></span>
						</div>
					</c:if>
					<c:if test="${model.getIdentityImageName()=='' }">
						<div id="userIdentity">
							<label>上传身份证照片：</label> <input type="file" name="imageFile"> <span></span>
						</div>
					</c:if>
					<c:if test="${model.getIdentityImageName()!=null }">
						<c:if test="${model.getIdentityImageName()!='' }">
							<div id="identityImage">
								<label>查看身份证照片：</label>
								<span>
									<input type="button" id="identTitydemo" class="identy" value="查看" onclick="myfunciton()" style="margin-left: 0;" />
									<input type="hidden" id="imageName" value="${model.getIdentityImageName()}">
								</span>
							</div>
						</c:if>
					</c:if>
					<div id="ageDiv">
						<label>年龄：</label> <input type="text" id="age" name="age"
							value="${model.age}" readonly="readonly"></input> <input
							type="hidden" value="${model.userSex}" name="userSex"
							id="userSex"></input> <span></span>
					</div>
					<input type="hidden" value="${model.age}" name="age" id="age"></input>
					<div>
						<label>现地址:</label> <span>${model.userProvinceStr}${model.userCityStr}${model.userStreet}</span>
						<span>
						<input type="button" id="ikk" class="identy"
							value="修改"  onclick="addModify()" style="margin-left: 0;" />
						</span>
					</div>
					<div class="addressModify" style="display: none;">
						<div style="margin-bottom: 20px;">
							<label for="province">省份:</label> <select id="province"
								onchange="setCity(this.value);getArea();" name="province"
								style="width: 96px;" runat="server">
								<option value="" selected="selected">--请选择省份--</option>
							</select>
						</div>

						<div style="margin-bottom: 20px;">
							<label for="city"">城市:</label> <select id="city"
								onchange="setCounty(this.value);getArea();" name="userCity"
								style="width: 96px;" runat="server">
								<option value="" selected="selected">--请选择城市--</option>
								
							</select>
						</div>
						<div>
							<label for="phone">详细地址:</label> <input class="val" type="text"
								name="userStreet" value=""/>
						</div>
					</div>

					<div>
						<label>技能大类别:</label> <select name="skillBigType"
							id="skillBigType" onchange="skillBigType1()">
							<c:choose>
								<c:when test="${model.skillBigTypeName==''}" >
									<option selected="selected" value="">请选择技能类型</option>
								</c:when>
								<c:otherwise>
									<option selected="selected" value="${model.skillBigType}">${model.skillBigTypeName}</option>
								</c:otherwise>
							</c:choose>
							<option value="1">--土建--</option>
							<option value="2">--管理--</option>
							<option value="3">--安装--</option>
							<option value="4">--其他--</option>
						</select>
					</div>
					<div>
						<label for="smalltype">技能小类型:</label> <select
							name="skillSmallType" id="smalltype">
							<c:choose>
								<c:when test="${model.skillSmallTypeName==''}" >
									<option selected="selected" value="">请选择技能细分类型</option>
								</c:when>
								<c:otherwise>
									<option selected="selected" value="${model.skillSmallType}">${model.skillSmallTypeName}</option>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
					<div>
						<label>诚信度:</label> <span><img
							src="resource/images/u662.png" /></span> <span><img
							src="resource/images/u662.png" /></span> <span><img
							src="resource/images/u662.png" /></span>
					</div>
					<div>
						<label>是否正在找工作:</label> 
						<select name="userStatus" id="userStatus">
							 <c:choose>
								<c:when test="${model.userStatus=='3'}">
									<option selected="selected" value="3">在岗，寻求更好的工作</option>
									<option value="2">在岗</option>
									<option value="1">正在找工作</option>
								</c:when>
								<c:when test="${model.userStatus==2}">
									<option value="3">在岗，寻求更好的工作</option>
									<option selected="selected"  value="2">在岗</option>
									<option value="1">正在找工作</option>
								</c:when>
								<c:otherwise>
									<option value="3">在岗，寻求更好的工作</option>
									<option value="2">在岗</option>
									<option selected="selected"  value="1">正在找工作</option>
								</c:otherwise>
							</c:choose> 
						</select>
					</div>
					<div>
						<label id="teamOrProject">所在项目/班组</label>
						<font color="blue">${projectName}</font>
					</div>
					<input type="submit" class="identy"  value="更新"/>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../down.jsp" flush="true" />
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/front_person/skillType.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/area.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>
