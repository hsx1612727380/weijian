<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>供应商诚信档案表</title>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/records.css"/>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />
	</head>

	<body>
		<form action="merchant_form2.html" method="post">
		<input type="hidden" name="id" value="${id}"> 
		<table border="0" cellspacing="1" cellpadding="0">
			<tr><th colspan="8">供应商档案</th></tr>
			<tr><td colspan="8">供应商资料</td></tr>
			<tr>
				<td>供应商名称</td>
				<td>${model.supplier}</td>
				<td>设备商代号</td>
				<td>${model.code}</td>
				<td>设备名称</td>
				<td>${model.itemname}</td>
				<td>供货地区</td>
				<td >${model.supply}</td>
			</tr>
			<tr>
				<td>营业执照</td>
				<td>${model.licence}</td>
				<td>成立日期</td>
				<td>${model.build}</td>
				<td>注册资金（万）</td>
				<td>${model.registercapital}</td>
				<td>实缴（万）</td>
				<td>${model.paid}</td>
			</tr>
			<tr>
				<td colspan="1">注册地址</td>
				<td colspan="3">${model.registeraddress}</td>
				<td>结算方式</td>
				<td>${model.paytype}</td>
				<td>期初应付</td>
				<td>${model.cope}</td>
			</tr>
			<tr>
				<td>电话/传真号</td>
				<td colspan="2">${model.phone}</td>
				<td>邮箱</td>
				<td colspan="2">${model.email}</td>
				<td>供货状态</td>
				<td colspan="1">
					<c:if test="${model.status=='0'}">停供中</c:if>
					<c:if test="${model.status=='1'}">供货中</c:if>
				</td>
			</tr>
			<tr><td colspan="8">联系方式及帐号</td></tr>
			<tr>
				<td>联系人</td>
				<td>${model.name}</td>
				<td colspan="2">联系人地址</td>
				<td colspan="4">${model.address}</td>
			</tr>
			<tr>
				<td>支付账号</td>
				<td>${model.payment}</td>
				<td>开户行</td>
				<td>${model.depositBank}</td>
				<td>银行账号</td>
				<td>${model.bankaccount}</td>
				<td>备注</td>
				<td colspan="3">${model.note}</td>
			</tr>
			<tr>
				<td>手机</td>
				<td>${model.mobile}</td>
				<td>QQ</td>
				<td>${model.qq}</td>
				<td>微信</td>
				<td>${model.wetchat}</td>
				<td>支付宝</td>
				<td>${model.paytreasure}</td>
			</tr>
			<tr>
				<td>身份证号码</td>
				<td colspan="3">${model.identification}</td>
				<td>是否公开</td>
				<td colspan="3">
					<c:if test="${model.open=='1'}">公开</c:if>
					<c:if test="${model.open=='0'}">不公开</c:if>
				</td>
			</tr>
			<tr><th colspan="8">项目的评价</th></tr>
			<tr>
				<td colspan="2">时间</td>
				<td colspan="2">项目</td>
				<td>技能</td>
				<td>勤劳</td>
				<td>态度</td>
				<td>备注</td>
			</tr>
			<c:forEach items="${comments}" var="comment"> 
				<tr>
					<td colspan="2">${comment.startTime}-${comment.endTime}</td>
					<td colspan="2">${comment.projectName}</td>
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
			<tr>
				<td colspan="8">
					<span class="items">
						<a href="merchant_list.html?pageNow=1&pageSize=20&dataCount=0" style="color:white">返回</a>
					</span>
				</td>
			</tr>
			
		</table>
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
</html>