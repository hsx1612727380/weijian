<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>班组诚信档案表</title>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/records.css"/>
	</head>

	<body>
		<form action="teamCredit_form2.html" method="post">
		<input type="hidden" name="id" value="${id}"> 
		<table border="1px solid #555555" cellspacing="0" cellpadding="0" >
			<tr><th colspan="8"><b>班组档案</b></th></tr>
			<tr>
				<td>班组编号</td>
				<td>${model.teamCode}</td>
				<td>班组名称</td>
				<td>${model.teamName}</td>
				<td>技能类别</td>
				<td>${model.skillBigTypeName}</td>
				<td>技能类型</td>
				<td>${model.skillSmallTypeName}</td>
			</tr>
			
			<tr>
				<td colspan="8">诚信度:
						<c:forEach begin="1" end="${tModel.reliableStar}">
						   <span><img src="resource/images/u662.png"/></span>
						</c:forEach>
						<c:forEach begin="1" end="${tModel.noreliableStar}">
						   <span><img src="resource/images/u663.fw.png"/></span>
						</c:forEach>
				</td>
			</tr>
			<tr>
				<td>班组长</td>
				<td>${model.name}</td>
				<td>性别</td>
				<td>${model.gender}</td>
				<td>民族</td>
				<td>${model.national}</td>
				<td>文化程度</td>
				<td>${model.education}</td>
			</tr>
			<tr>
				<td>出生日期</td>
				<td>${model.birth}</td>
				<td>年龄</td>
				<td>${model.age}</td>
				<td>身高</td>
				<td>${model.height}</td>
				<td>体重</td>
				<td>${model.weight}</td>
			</tr>
			<tr>
				<td colspan="2">身份证号码</td>
				<td colspan="2">${model.identity}</td>
				<td>身体状况</td>
				<td>${model.health}</td>
				<td>婚姻状态</td>
				<td>${model.marriage}</td>
			</tr>
			
			<tr>
				<td>求职状态</td>
				<td>${model.jobstatus}</td>
				<td>求职地区</td>
				<td colspan="5">${model.provinceChn}${model.cityChn}</td>
			</tr>
			
			
			<tr><th colspan="8">联系方式及帐号</th></tr>
			<tr>
				<td>银行卡</td>
				<td colspan="2">${model.bankcard}</td>
				<td >家庭住址</td>
				<td colspan="4">${model.address}</td>
			</tr>
			<tr><th colspan="8"><b>骨干成员</b></th></tr>
			<tr >
				<td>姓名&nbsp;&nbsp;</td>
				<td>手机号&nbsp;&nbsp;</td>
				<td>技能类别&nbsp;&nbsp;</td>
				<td>技能类型&nbsp;&nbsp;</td>
				<td>所在区域&nbsp;&nbsp;</td>
				<td>诚信度&nbsp;&nbsp;</td>
				<td colspan="2">&nbsp;&nbsp;操作&nbsp;&nbsp;</td>
			</tr>
			<c:forEach items="${mlist}" var="mModel">
			<c:if test="${mModel.backbone == '1'}">
			<tr>
				<td><span class="items">
						<a href="user_info.html?userId=${mModel.userId}" style="color:blue">${mModel.userName}&nbsp;&nbsp;</a>
					</span></td>
				<td>${mModel.userId}&nbsp;&nbsp;</td>
				<td>${mModel.skillBigTypeName}&nbsp;&nbsp;</td>
				<td>${mModel.skillSmallTypeName}&nbsp;&nbsp;</td>
				<td>${mModel.userProvinceStr}${mModel.userCityStr}</td>
				<td>
					<c:forEach begin="1" end="${mModel.reliableStar}">
						<span><img src="resource/images/u662.png"/></span>
					</c:forEach>
					<c:forEach begin="1" end="${mModel.noreliableStar}">
						<span><img src="resource/images/u663.fw.png"/></span>
					</c:forEach>
				</td>
				<td colspan="2">
					<span class="items">
						<a href="user_info.html?userId=${mModel.userId}" style="color:green">详细</a>
					</span>
				</td>
			</tr>
			</c:if>
			</c:forEach> 



			<tr><th colspan="8">电子文档</th></tr>
			<tr>
				<td>进场须知</td>
				<td>${model.guidelines}</td>
				<td>安全教育</td>
				<td>${model.safety}</td>
				<td colspan="2">劳动计件计时合同</td>
				<td colspan="2">${model.contract}</td>
			</tr>
			<tr><th colspan="8">项目的评价</th></tr>
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
					<td>${model.teamName}</td>
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
		</form>
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
</html>