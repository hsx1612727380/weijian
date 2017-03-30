<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>修改招标信息</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />

	</head>

	<body>
	<form action="bidInfo_modify2.html" method="post">
				<div class='search clearfix'>
					<h3>招标信息管理</h3>
					<span class="datum">招标信息管理>>修改招标信息</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="title">标题:</label></td>
						<td><input class="inp" type="text" name="title" value="${model.title}" style="width:500px"/></td>
					</tr>
					<tr>
						<td><label for="URL">链接地址:</label></td>
						<td><input class="inp" type="text" name="URL" value="${model.URL}" style="width:500px"/></td>
					</tr>
					<tr>
						<td>信息类型</td>
						<td>
							<select name="bidtype" >
							<option value="1" <c:if test="${bidtype=='1'}">selected</c:if>>招投标</option>
							<option value="2" <c:if test="${bidtype=='2'}">selected</c:if>>行业动态</option>
							</select>
						</td>
					</tr>
				
					
					<tr>
						<td></td>
						<td><button class="add">修改</button></td>
					</tr>
				</table>
				
				</div>
				
				<div class="footer clearfix">
				<input type="hidden" name="id" value="${model.id}"> 
				</div>
				
				
			</div>
		</div>
		</form>
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/area.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


