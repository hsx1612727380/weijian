<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>修改项目信息</title>
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
	<form action="keyperson_modify2.html" method="post">
				<div class='search clearfix'>
					<h3>项目管理</h3>
					<span class="datum">项目管理>>修改参建单位</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="uid">姓名:</label></td>
						<td><input class="inp" type="text" name="name" value="${model.name}"/></td>
					</tr>
					<tr>
						<td><label for="uid">公司名称:</label></td>
						<td><input class="inp" type="text" name="cName" value="${model.cName}"/></td>
					</tr>
					<tr>
						<td><label for="uid">电话:</label></td>
						<td><input class="inp" type="text" name="phone" value="${model.phone}"/></td>
					</tr>
					<tr>
					<td><label for="uid">项目中担任角色:</label></td>
					<td>
						<select name="role" >
						<option value="1" <c:if test="${role=='1'}">selected</c:if>>项目经理</option>
						<option value="2" <c:if test="${role=='2'}">selected</c:if>>工程协管员</option>
						<option value="3" <c:if test="${role=='3'}">selected</c:if>>首席建筑师</option>
						<option value="4" <c:if test="${role=='4'}">selected</c:if>>暖通工程师</option>
						<option value="5" <c:if test="${role=='5'}">selected</c:if>>机械工程师</option>
						<option value="6" <c:if test="${role=='6'}">selected</c:if>>电气工程师</option>
						<option value="7" <c:if test="${role=='7'}">selected</c:if>>质量评估或质量控制文档管理员</option>
						<option value="8" <c:if test="${role=='8'}">selected</c:if>>质量评估或质量控制经理</option>
						<option value="9" <c:if test="${role=='9'}">selected</c:if>>商务经理</option>
						<option value="10" <c:if test="${role=='10'}">selected</c:if>>施工经理</option>
						<option value="11" <c:if test="${role=='11'}">selected</c:if>>流程协调员</option>
						<option value="12" <c:if test="${role=='12'}">selected</c:if>>施工员</option>
						<option value="13" <c:if test="${role=='13'}">selected</c:if>>预算员</option>
						<option value="14" <c:if test="${role=='14'}">selected</c:if>>安全员</option>
						<option value="15" <c:if test="${role=='15'}">selected</c:if>>质检员</option>
						<option value="16" <c:if test="${role=='16'}">selected</c:if>>材料员</option>
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
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


