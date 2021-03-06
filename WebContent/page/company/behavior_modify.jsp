<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>修改公司行为</title>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
<link rel="stylesheet" type="text/css" href="resource/css/table.css" />

</head>

<body>
	<form action="behavior_modify2.html" method="post">
		<div class='search clearfix'>
			<h3>公司管理</h3>
			<span class="datum">公司管理>>修改公司行为</span>
			<table border="0" cellspacing="0" cellpadding="0"
				style="display: table; margin: 0 auto;">
				<tr>
					<td><label for="title">标题:</label></td>
					<td><input class="inp" type="text" name="title"
						value="${model.title}" /></td>
				</tr>
				<tr>
					<td><label for="type">行为类型:</label></td>
					<td>
						<select name="type" >
							<option value="1" <c:if test="${type=='1'}">selected</c:if>>良好行为</option>
							<option value="2" <c:if test="${type=='2'}">selected</c:if>>不良行为</option>
							<option value="3" <c:if test="${type=='3'}">selected</c:if>>欠薪行为</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label for="behaviorTime">行为时间:</label></td>
					<td><input class="inp" type="text" name="behaviorTime"
						value="${model.behaviorTime}" /></td>
				</tr>
				<tr>
					<td><label for="content">行为内容:</label></td>
					<td><input class="inp" type="text" name="content"
						value="${model.content}" /></td>
				</tr>
				





				<tr>
					<td></td>
					<td><button class="add">修改</button></td>
				</tr>
			</table>

		</div>

		<div class="footer clearfix">
			<input type="hidden" name="id" value="${model.id}">
			<input type="hidden" name="code" value="${model.code}">
		</div>


		</div>
		</div>
	</form>
</body>
<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="resource/js/silder.js" type="text/javascript"
	charset="utf-8"></script>
<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
<script src="resource/js/area.js" type="text/javascript" charset="utf-8"></script>
<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


