<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>修改项目环节</title>
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
	<form action="link_modify2.html" method="post">
				<div class='search clearfix'>
					<h3>项目管理</h3>
					<span class="datum">项目管理>>修改项目环节</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="uid">项目报建:</label></td>
						<td><input class="inp" type="text" name="num1" value="${model.pro.get("1")}"/></td>
					</tr>
					<tr>
						<td><label for="uid">资信证明:</label></td>
						<td><input class="inp" type="text" name="num2" value="${model.pro.get("2")}"/></td>
					</tr>
					<tr>
						<td><label for="uid">立项文号:</label></td>
						<td><input class="inp" type="text" name="num3" value="${model.pro.get("3")}"/></td>
					</tr>
					<tr>
						<td><label for="uid">用地规划许可证:</label></td>
						<td><input class="inp" type="text" name="num4" value="${model.pro.get("4")}"/></td>
					</tr>
					<tr>
						<td><label for="uid">工程规划许可证:</label></td>
						<td><input class="inp" type="text" name="num5" value="${model.pro.get("5")}"/></td>
					</tr>
					<tr>
						<td><label for="uid">施工图审查:</label></td>
						<td><input class="inp" type="text" name="num6" value="${model.pro.get("6")}"/></td>
					</tr>
					<tr>
						<td><label for="uid">工程招投标:</label></td>
						<td><input class="inp" type="text" name="num7" value="${model.pro.get("7")}"/></td>
					</tr>
					<tr>
						<td><label for="uid">合同备案:</label></td>
						<td><input class="inp" type="text" name="num8" value="${model.pro.get("8")}"/></td>
					</tr>
					<tr>
						<td><label for="uid">施工许可:</label></td>
						<td><input class="inp" type="text" name="num9" value="${model.pro.get("9")}"/></td>
					</tr>
					<tr>
						<td><label for="uid">质量安全监督:</label></td>
						<td><input class="inp" type="text" name="num10" value="${model.pro.get("10")}"/></td>
					</tr>
					<tr>
						<td><label for="uid">勘验评估合格证:</label></td>
						<td><input class="val" type="text" name="num11" value="${model.pro.get("11")}"/></td>
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


