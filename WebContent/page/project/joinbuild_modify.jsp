<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>修改参建单位</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=629Um5l2umNbmEo10SfHQjgM4cGtQe7b"></script>
	</head>

	<body>
	<form action="joinbuild_modify2.html" method="post">
				<div class='search clearfix'>
					<h3>项目管理</h3>
					<span class="datum">项目管理>>修改参建单位</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="uid">单位名称:</label></td>
						<td><input class="inp" type="text" name="jName" value="${model.jName}"/></td>
					</tr>
					<tr>
						<td>单位类型：</td>
						<td>
							<select name="jType" >
							<option value="1" <c:if test="${bidtype=='1'}">selected</c:if>>建设单位</option>
							<option value="2" <c:if test="${bidtype=='2'}">selected</c:if>>工程监理</option>
							<option value="3" <c:if test="${bidtype=='3'}">selected</c:if>>工程设计</option>
							<option value="4" <c:if test="${bidtype=='4'}">selected</c:if>>建筑施工</option>
							<option value="5" <c:if test="${bidtype=='5'}">selected</c:if>>工程勘察</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="uid">公司负责人电话:</label></td>
						<td><input class="inp" type="text" name="leaderphone" value="${model.leaderphone}"/></td>
					</tr>
					<tr>
						<td><label for="uid">统一社会信用代码:</label></td>
						<td><input class="inp" type="text" name="jNum" value="${model.jNum}"/></td>
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
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


