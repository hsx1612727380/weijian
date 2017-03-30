<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8" />
<title>乐建平台</title>
<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript"
	charset="utf-8"></script>
<!-- 针对不同的登录用户类型隐藏左侧菜单的js -->
<script src="resource/js/front_person/person_left_handler.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="resource/css/front_person/personAddgroud.css" />
<link rel="stylesheet" type="text/css" href="resource/css/tabfooter.css" />
<script src="resource/js/front_person/idperson.js"
	type="text/javascript" charset="utf-8"></script>
<script src="resource/js/front_person/teamApplyProject.js"
	type="text/javascript"></script>

</head>

<body>
	<input id="isLeader" type="hidden" value='${isLeader}' />
	<jsp:include page="../top.jsp" flush="true" />
	<div class="title">
		<div class="content">
			<span>个人中心</span>
		</div>
	</div>
	<div class="content personal">
		<div class="autstate">
			<span>认证状态：</span><span>已认证 &nbsp;&nbsp;&nbsp;</span> <span>角色：</span><span>班组长</span>&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="darkblue">项目招聘班组</font>
		</div>
		<div class="detail">
			<jsp:include page="person_left.jsp" flush="true" />
			<div class="detailright">
				<div class="derighttop">
				<form action="recruitTeamProjectForm.html">
					<input id="SmallTypeBack" type="hidden" value="${skillSmallType}"/>
					<input type="hidden" id="userIdVal" value="${userId }" />
					<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>项目名称</td>
							<td><input name="pName" type="text" value="${pName}"/></td>
							<td>技能类别</td>
							<td>
								<select id="skillBigType" onclick="skillBigType1()" name="skillBigType" style="width: 100px"> 
									<option value=0 <c:if test="${skillBigType==0}" >selected</c:if> >技能类别</option>
									<option value=1 <c:if test="${skillBigType==1}" >selected</c:if>>土建</option>
									<option value=2 <c:if test="${skillBigType==2}" >selected</c:if>>管理</option>
									<option value=3 <c:if test="${skillBigType==3}" >selected</c:if>>安装</option>
									<option value=4 <c:if test="${skillBigType==4}" >selected</c:if>>其他</option>
								</select>
							</td>
								<td>技能类型</td>
							<td>
								<select id="smalltype" name="skillSmallType" style="width: 100px">
									<option  value=0>技能类型</option>
								</select>
							<td>
							<td><input type="submit" value="查询"/></td>
						</tr>
						<tr></tr>
					</table>
				</form>
				</div>
				<table class="addground" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td>项目名称</td>
						<td>负责人名称</td>
						<td>负责人手机号</td>
						<td>项目地址</td>
						<td>技能大类型</td>
						<td>技能小类型</td>
						<td>招聘人数</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${tlist}" var="tmodel">
						<tr>
							<td>${tmodel.projectModel.name}</td>
							<td style="width: 80px">${tmodel.projectModel.leaderName}</td>
							<td>${tmodel.projectModel.userId}</td>
							<td>${tmodel.projectModel.provinceChn}${tmodel.projectModel.cityChn}${tmodel.projectModel.street}</td>
							<td style="width: 80px">${tmodel.requireModel.skillBigTypeName}</td>
							<td style="width: 80px">${tmodel.requireModel.skillSmallTypeName}</td>
							<td style="width: 80px">${tmodel.requireModel.num}</td>
							<td style="width: 120px">
								<input type="hidden" value="${userId}" /> 
								<input type="hidden" value="${tmodel.projectModel.id}" />
								<c:if test="${tmodel.status==0}">
									<span class="applySapn">申请 </span>
								</c:if> 
								<span class="">
									<a href="web_project_info.html?id=${tmodel.projectModel.id}"><span>详情</span></a>
								</span>
							</td>
						</tr>
					</c:forEach>
				</table>

				<div class="tabfooter">
					<form action="recruitTeamProjectForm.html" method="post">
					
						<div class="footerl">
							<span>每页：</span> <input type="text" value="${page.pageSize}"
								name="pageSize" style="width: 30px" /> <span>条</span>
							<button>确定</button>
							<span>共有</span> <span class="footernum">${page.dataCount}</span>
							<span>条记录，当前有</span> <span>${page.pageNow}</span><span>/</span><span>${page.pageCount}</span>
							<span>页</span>
						</div>
						<input type="hidden" name="dataCount" value="${page.dataCount}">
						<input type="hidden" name="pageCount" value="${page.pageCount}">
						<div class="footer2">
							<button value="1" name="pageNow">首页</button>
							<button value="${page.prePage}" name="pageNow">上一页</button>
							<button value="${page.nextPage}" name="pageNow">下一页</button>
							<button value="${page.lastPage}" name="pageNow">尾页</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../down.jsp" flush="true" />
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="resource/js/team_add.js" charset="utf-8"></script>
	<script src="resource/js/front_person/front_team_recuited.js" type="text/javascript"></script>
</body>

</html>