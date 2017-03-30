<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>用户详细信息</title>
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

				<div class="ifamelayout">
				<h3>用户管理</h3>
					<span class="datum">用户管理>>用户详细信息>>${model.userName}</span>
					<form action="" method="post">
					 
					<table border="1px solid #555555" cellspacing="0" cellpadding="0">
					<tr><th colspan="8">个人资料</th></tr>
					<tr>
						<td>姓名</td>
						<td>${model.userName}</td>
						<td>性别</td>
						<td>
							<c:if test="${model.userSex=='1'}">男</c:if>
							<c:if test="${model.userSex=='2'}">女</c:if>
						</td>
						<td>年龄</td>
						<td>${model.age}</td>
						<td>用户类型</td>
						<td>
							<c:if test="${model.userType=='0'}">用户</c:if>
							<c:if test="${model.userType=='1'}">材料商</c:if>
							<c:if test="${model.userType=='2'}">设备商</c:if>
							<c:if test="${model.userType=='3'}">公司负责人</c:if>
							<c:if test="${model.userType=='4'}">项目负责人</c:if>
						</td>
					</tr>
					<tr>
						<td>手机号</td>
						<td>${model.userId}</td>
						<td>密码</td>
						<td>${model.userPassword}</td>
						<td>所在地区</td>
						<td>${model.userProvinceStr}${model.userCityStr}</td>
						<td>详细地址</td>
						<td>${model.userStreetStr}</td>
						
					</tr>
					<tr>
						<td colspan="2">身份证号</td>
						<td colspan="2">${model.userIdentity}</td>
						<td>技能类别</td>
						<td>${model.skillBigTypeName}</td>
						<td>技能类型</td>
						<td>${model.skillSmallTypeName}</td>
					</tr>
					<tr>
						<td colspan="8">诚信度:
						
							<c:forEach begin="1" end="${model.reliableStar}">
								   <span><img src="resource/images/u662.png"/></span>
							</c:forEach>
							<c:forEach begin="1" end="${model.noreliableStar}">
							   <span><img src="resource/images/u663.fw.png"/></span>
							</c:forEach>
						</td>
					</tr>
					<tr><td colspan="8" style="background-color:white"></td></tr>
					<tr><td colspan="8">个人评价</td></tr>
					<tr>
						<td>时间</td>
						<td>项目</td>
						<td>班组</td>
						<td>技能</td>
						<td>勤劳</td>
						<td>态度</td>
						<td colspan="2">备注</td>
					</tr>
					<c:forEach items="${comments}" var="comment"> 
					<tr>
						<td>${comment.startTime}-${comment.endTime}</td>
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
						<td colspan="2">${comment.desc}</td>
					</tr>
					</c:forEach>
					<tr>
						<td colspan="8" style="background-color:white">
							<span class="items">
								<a href="user_list.html?pageNow=1&pageSize=20&dataCount=0" style="color:white">返回</a>
							</span>
						</td>
					</tr>
					
					
				</table>
				</div>
				
			</div>
			</form>
		</div>

	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
</html>


