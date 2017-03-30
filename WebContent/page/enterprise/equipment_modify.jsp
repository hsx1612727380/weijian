<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>修改设备商信息</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />

	</head>

	<body>
	<form action="equipment_modify2.html" method="post">
				<div class='search clearfix'>
					<h3>设备商管理</h3>
					<span class="datum">设备商管理>>修改设备商</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="uid">设备商代码:</label></td>
						<td><input class="inp" type="text" name="code" value="${model.code}"/></td>
					</tr>
					<tr>
						<td><label for="uid">设备商名称:</label></td>
						<td><input class="inp" type="text" name="name" value="${model.name}"/></td>
					</tr>
					<tr>
						<td><label for="uid">统一社会信用代码:</label></td>
						<td><input class="inp" type="text" name="licence" value="${model.licence}"/></td>
					</tr>
					<tr>
						<td><label for="uid">注册资金:</label></td>
						<td><input class="inp" type="text" name="regcapital" value="${model.regcapital}"/></td>
					</tr>
					<tr>
						<td><label for="uid">成立日期:</label></td>
						<td><input class="inp" type="text" name="establishDate" value="${model.establishDate}"/></td>
					</tr>
					<tr>
						<td><label for="name">负责人:</label></td>
						<td><input class="inp" type="text" name="leaderName" value="${model.leaderName}"/></td>
					</tr>
					<tr>
						<td><label for="gender">联系方式:</label></td>
						<td>${model.userId}</td>
					</tr>
					<tr>
						<td><label for="gender">设备名称:</label></td>
						<td><input class="inp" type="text" name="shopName" value="${model.shopName}"/></td>
					</tr>
					<tr>
					<td><label for="gender">省:</label></td>
					<td><select id="province"
						onchange="setCity(this.value);getArea();" name="province"
						runat="server">
							<option value="${model.province}">${model.provinceChn}</option>
						</select></td>
					</tr>
					<tr>
						<td><label for="gender">市:</label></td>
						<td><select id="city"
						onchange="setCounty(this.value);getArea();" name="city"
						runat="server">
							<option value="${model.city}" selected="selected">${model.cityChn}</option>
					</select></td>
				</tr>
					<tr>
						<td><label for="phone">地址街道:</label></td>
						<td><input class="val" type="text" name="street" value="${model.street}"/></td>
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


