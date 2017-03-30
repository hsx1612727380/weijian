<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>
<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<!--引入Bootstrap -->
			<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />
	
       <script type="text/javascript" src="resource/js/jquery.js"> </script>
       <script type="text/javascript" src="resource/js/xcConfirm.js"></script><!-- alert js引用-->	
</head>
<body>

	
		
		<form action="updatePersonAdmin.html" method="post">
				<div class='search clearfix'>
					<h3>管理员个人信息及权限</h3> 
					<span class="datum">管理员个人信息及权限>>修改个人资料</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="uid">登录帐号:</label></td>
						<td>${admin.accountName}</td>
					</tr>
					<tr>
						<td><label for="uid">真实姓名:</label></td>
						<td><input class="val" type="text" name="name" value="${admin.name}"/></td> 
					</tr>
					<tr>
						<td><label for="uid">手机号:</label></td>
						<td>
							<input class="val" type="text" name="mobile" value="${admin.mobile}"/> 
						</td>
					</tr>
					<tr>
						<td><label for="name">密码:</label></td>
						<td><input class="val" type="text" name="password" value="${admin.password}"/></td>
					</tr>
					
					                 
					<tr>
						<td><input type="hidden" name="id" value="${admin.id}"> </td>
						<td><button class="add">修改</button></td>
					</tr>
				</table>
				
				</div>
				
		</form> 
		</body>
		</html>

 