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
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/personAddgroud.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/tabfooter.css" />
		<script src="resource/js/front_person/applyTeam.js" type="text/javascript" charset="utf-8"></script>
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
				<span>认证状态：已认证</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>角色：个人</span>
				&nbsp;&nbsp;&nbsp;&nbsp;<font color="darkblue">招聘信息</font>
			</div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
				<div class="detailright">
				<div class="persontitle">
					</div>
					<table class="addground" border="0" cellspacing="1" cellpadding="0">
						<tr>
							<td>班组名称</td>
							<td>班组长名称</td>
							<td>负责人电话</td>
							<td>技能大类型</td>
							<td>技能小类型</td>
							<td>详细地址</td>
							<td>招聘人数</td>
							<!-- <td>是否能申请</td> -->
							<td>操作</td>
							<input type="hidden" id="userIdVal" value="${userId}" />
						</tr>
						<c:forEach items="${tlist}" var="tmodel"> 
<%-- 						<c:if test="${tmodel.canSupply==true}">
 --%>							<tr>
								<td>${tmodel.teamModel.name} </td>
								<td>${tmodel.teamModel.leaderName}</td>
								<td>${tmodel.teamModel.leaderMobile}</td>
								<td>${tmodel.teamModel.skillBigTypeName}</td>
								<td>${tmodel.teamModel.skillSmallTypeName}</td>
								<td>${tmodel.teamModel.provinceChn}${tmodel.teamModel.cityChn}${tmodel.teamModel.street}</td>
								<td>${tmodel.requireModel.num}</td>
								<td>
									<input type="hidden"  value="${userId}" />
									<input type="hidden"  value="${tmodel.requireModel.rId}" />
									<c:if test="${tmodel.status==0}">
										<c:if test="${existBl==0}">
											<span class="applySapn">申请</span>
										</c:if>
									</c:if>
									<a href="person_teamInfo.html?teamId=${tmodel.teamModel.id}&requireId=${tmodel.requireModel.id}">
										<span>详情${tmodel.canSupply}</span>
									</a>
								</td>
							</tr>
					<%-- 	</c:if> --%>
					</c:forEach> 
					</table>

						<div class="tabfooter">
							<form action="personApplyTeamForm.html" method="post">
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
			<div class="apply clearfix">
						<div class="active" id="applyHistory">申请明细</div> 
						
							
							<table id="applyIngTable" border="0" cellspacing="1" cellpadding="0">
								<tr>
									<td>班组类型</td>
									<td>技能类型</td>
									<td>班组长</td>
									<td>电话</td>
									<td>申请时间</td>
									<td>操作</td>
								</tr>
							</table>
						
					</div>
			</div>
			</div>
		
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>