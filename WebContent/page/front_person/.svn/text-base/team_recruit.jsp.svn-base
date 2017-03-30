<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/teamAttendance.css" />
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
				<span>角色：</span><span>班组长</span>&nbsp;&nbsp;&nbsp;&nbsp;<font color="darkblue">班组招聘</font>
			</div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
				
				<div class="detailright">
					<div class="derighttop clearfix">
						<div><a href="personToAddRecruit.html"><font color="white">新增班组招聘</font></a></div>
					</div>
					<div class="derightbottom">
						<table border="0" cellspacing="1" cellpadding="0">
							
							<tr>
								<td>序号</td>
								<td>班组名称</td>
								<td>班组长</td>
								<td>标题</td>
								<td>技能</td>
								<td>人数</td>
								<td>招聘地区</td>
								<td>联系方式</td>
								<td>地址</td>
								<td>备注</td>
								<td>操作</td>
							</tr>
							<c:forEach items="${requirementsList}"  var="requirements" varStatus="status">
							<tr>
								<td>${ status.index + 1}</td>
								<td>${requirements.name}</td>
								<td>${requirements.leaderName}</td>
								<td>${requirements.title}</td>
								<td>${requirements.skillBigTypeName}-${requirements.skillSmallTypeName}</td>
								<td>${requirements.num }</td>
								<td>${requirements.provinceStr}${requirements.cityStr}</td>
								<td>${teamModel.leaderMobile }</td>
								<td>${teamModel.provinceChn}${teamModel.cityChn}</td>
								<td>${requirements.desc}</td>
								<td><div><a href="personDeleteRecruit.html?id=${requirements.id}"><font color="white">撤销</font></a></div></td>
							</tr>
							</c:forEach>
						</table>
						<div class="tabfooter">
							
								
							
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
	</body>
	
</html>