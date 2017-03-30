<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>新增供需信息</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />

	</head>

	<body>
	<form action="job_team_add2.html" method="post">
				<div class='search clearfix'>
					<h3>求职</h3>
					<span class="datum">求职>>班组求职</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="uid">求职标题:</label></td>
						<td><input class="val" type="text" name="title" /></td>
					</tr>
					<tr>
						<td><label for="uid">班组编号:</label></td>
						<td><input class="val" type="text" name="code" /></td>
					</tr>
					
					<tr>
					<td><label for="bigtype">技能类型:</label></td>
					<td><select id="skillBigType" onchange="skillBigType1()"
						name="skillBigType" style="width: 96px">
							<option value="222" selected="selected">--请选择技能大类型--</option>
							<option value="1">--土建--</option>
							<option value="2">--管理--</option>
							<option value="3">--安装--</option>
							<option value="4">--其他--</option>
					</select></td>
				</tr>
				<tr>
					<td><label for="smalltype">技能类别:</label></td>
					<td><select name="smalltype" id="smalltype">
							<option value="-1">请选择技能小类型</option>
					</select></td>
				</tr>
					
					
					<tr>
						<td><label for="province">求职省份:</label></td>
						<td><select id="province" onchange="setCity(this.value);getArea();" name="province" style="width: 96px" runat="server" >
                              <option value="${province}" selected="selected">--请选择省份--</option>
                    		</select></td>
				</tr>
				<tr>
						<td><label for="city">城市:</label></td>
						<td><select id="city" onchange="setCounty(this.value);getArea();" name="city" style="width: 96px" runat="server">
                              <option value="${city}" selected="selected">--请选择城市--</option>
                            </select></td>
				</tr>
				
				<tr>
						<td><label for="name">详细地址:</label></td>
						<td><input class="val" type="text" name="street" /></td>
					</tr>
					<tr>
						<td colspan="2"><label for="name">备注:</label>
						<textarea rows="10" cols="50" name="desc">
							</textarea>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><button class="add">添加</button></td>
					</tr>
				</table>
				
				</div>
				
				
		</form>
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/area.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="resource/js/team_add.js" charset="utf-8"></script>
</html>


