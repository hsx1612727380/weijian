<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/records.css" />

	</head>
	<body>

				<div>
					<h3>班组管理</h3>
					<br/>
					<span class="datum">班组管理>>班组成员列表>>${name}</span>
					<span style="color:red">(<img src="resource/images/leader.png"/>表示班组长)</span><br/>
					<br/>
					<form action="team_memberlist2.html" method="post">
					
					<tr>
						<td>请输入手机号：<input class="inp" type="text" name="userId"/></td>
					</tr>
					<button >查询</button>
					
					<div class="footer clearfix">
						<input type="hidden" name="id" value="${id}">
					</div>
					<c:if test="${usermodel != null}">
						<table class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
							<tr>
								<td>姓名</td>
								<td>性别</td>
								<td>手机号</td>
								<td>技能类别</td>
								<td>技能类型</td>
								<td>个人诚信度</td>
								<td>操作</td>
							</tr>
							<tr>
								<td>${usermodel.userName}</td>
								<td>${usermodel.userSex}</td>
								<td>${usermodel.userId}</td>
								<td>${usermodel.skillBigTypeName}</td>
								<td>${usermodel.skillSmallTypeName}</td>
								<td><c:forEach begin="1" end="${usermodel.reliableStar}">
									   <span><img src="resource/images/u662.png"/></span>
									</c:forEach></td>
								<td>
								<c:if test="${canInvite == 'true'}"><a href="teammember_invite.html?userId=${usermodel.userId}&&id=${id}" style="color:blue">可邀请</a></c:if>
								<c:if test="${canInvite == 'false'}">已在班组</c:if>
								</td>
								
							</tr>
						</table>
					</c:if>
					<table class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
						<tr>
							<td>姓名&nbsp;&nbsp;</td>
							<td>手机号&nbsp;&nbsp;</td>
							<td>是否骨干&nbsp;&nbsp;</td>
							<td>技能类别&nbsp;&nbsp;</td>
							<td>技能类型&nbsp;&nbsp;</td>
							<td>所在区域&nbsp;&nbsp;</td>
							<td>诚信度&nbsp;&nbsp;</td>
							<td>&nbsp;&nbsp;操作&nbsp;&nbsp;</td>
						</tr>
						<c:forEach items="${mlist}" var="mModel"> 
						<tr>
							<td><a href="user_info.html?userId=${mModel.model.userId}" style="color:blue"><c:if test="${mModel.model.userId==userId}"><img src="resource/images/leader.png"/></c:if>${mModel.model.userName}&nbsp;&nbsp;</a></td>
							<td>${mModel.model.userId}&nbsp;&nbsp;</td>
							<td><c:choose>
							<c:when test="${mModel.backbone== '0'}">  
							        不是     
							   </c:when>
							<c:otherwise>
								是
							</c:otherwise>
						</c:choose></td>&nbsp;&nbsp;</td>
							<td>${mModel.model.skillBigTypeName}&nbsp;&nbsp;</td>
							<td>${mModel.model.skillSmallTypeName}&nbsp;&nbsp;</td>
							<td>${mModel.model.userProvinceStr}${mModel.model.userCityStr}</td>
							<td>
								<c:forEach begin="1" end="${mModel.model.reliableStar}">
								   <span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="1" end="${mModel.model.noreliableStar}">
								   <span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach>
								
							</td>
							<td>
								<span class="items">
									<a href="user_info.html?userId=${mModel.model.userId}" style="color:white">详细</a>
								</span>
								<span class="del">
									<a href="javascript:if(confirm('确实要删除${mModel.model.userName}吗?'))location='team_del_user.html?id=${tId}&userId=${mModel.model.userId}'" style="color:white">删除</a>
								</span>
							</td>
						</tr>
						</c:forEach> 
					</table>
					
					<table border="0" cellspacing="1" cellpadding="0" width="100%">
					<tr><th colspan="8">班组评价</th></tr>
					<tr>
						<td colspan="2">时间</td>
						<td>项目</td>
						<td>班组</td>
						<td>技能</td>
						<td>勤劳</td>
						<td>态度</td>
						<td>备注</td>
					</tr>
					<c:forEach items="${comments}" var="comment"> 
					<tr>
						<td colspan="2">${comment.startTime}-${comment.endTime}</td>
						<td>${comment.projectName}</td>
						<td>${comment.teamName}</td>
						<td><c:forEach begin="1" end="${comment.scoreStr1}">
									   <span><img src="resource/images/u662.png"/></span>
									</c:forEach></td>
						<td><c:forEach begin="1" end="${comment.scoreStr2}">
									   <span><img src="resource/images/u662.png"/></span>
									</c:forEach></td>
						<td><c:forEach begin="1" end="${comment.scoreStr3}">
									   <span><img src="resource/images/u662.png"/></span>
									</c:forEach></td>
						<td >${comment.desc}</td>
					</tr>
					</c:forEach>
					
					
					
				</table>
				</div>
				
				
			</div>
		</div>

	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="resource/js/team.js" ></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


