<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>查看个人资料及权限</title>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/records.css"/>
	</head>

	<body>
		<input type="hidden" > 
		<table border="1px solid #555555" cellspacing="0" cellpadding="0" >
			<tr><th colspan="16">个人信息</th></tr>
			<tr>
				<td>账号</td>
				<td>${admin.accountName}</td>
				<td>密码</td>
				<td>${admin.password}</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td>${admin.name}</td>
				<td>电话</td>
				<td>${admin.mobile}</td>
			</tr>
			<tr><th colspan="16" ><a href="showPersonAdmin.html?id=${admin.id}"   style="color:red">修改个人资料</a></th></tr>
		</table>
		
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
</html>