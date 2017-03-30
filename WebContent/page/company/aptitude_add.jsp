<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>新增公司资质与资信</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />

	</head>

	<body>
	<form action="aptitude_add2.html" method="post">
				<div class='search clearfix'>
					<h3>公司管理</h3>
					<span class="datum">公司管理>>新增公司资质与资信</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="uid">证书编号:</label></td>
						<td><input class="inp" type="text" name="certificate" /></td>
					</tr>
					<tr>
						<td><label for="adtype">资质类别:</label></td>
						<td><select id="adtype" onchange="adtype1()"
							name="adtype" style="width: 96px">
								<option value="222" selected="selected">--请选择资质类别--</option>
								<option value="1">--招标代理--</option>
								<option value="2">--造价咨询--</option>
								<option value="3">--木工作业--</option>
								<option value="4">--施工总承包--</option>
								<option value="5">--专业承包--</option>
								<option value="6">--劳务分包--</option>
								<option value="7">--工程勘察综合类--</option>
								<option value="8">--工程勘察专业类--</option>
								<option value="9">--工程勘察劳务类--</option>
								<option value="10">--审图--</option>
								<option value="11">--检测--</option>
							</select></td>
					</tr>
					<tr>
						<td><label for="level">资质等级:</label></td>
						<td><select name="level" id="level">
								<option value="-1">请选择资质等级</option>
						</select></td>
					</tr>
					<tr>
						<td><label for="uid">审批机关:</label></td>
						<td><input class="inp" type="text" name="approval" /></td>
					</tr>
					<tr>
						<td><label for="uid">资质最新批准日期:</label></td>
						<td><input class="inp" type="text" name="approvalTime" /></td>
					</tr>
					<tr>
						<td><label for="uid">资质有效期:</label></td>
						<td><input class="inp" type="text" name="validity" /></td>
					</tr>
					
					
					<tr>
						<td></td>
						<td><button class="add">添加</button></td>
					</tr>
				</table>
				
				</div>
				
				<div class="footer clearfix">
					<input type="hidden" name="code" value="<%=request.getAttribute("code")%>">
					<input type="hidden" name="cName" value="<%=request.getAttribute("cName")%>">
				</div>
				
				
			</div>
		</div>
		</form>
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/area.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/aptitude_add.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>

</html>


