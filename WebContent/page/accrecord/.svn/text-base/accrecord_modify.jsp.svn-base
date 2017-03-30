<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>修改人员出入记录</title>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
<link rel="stylesheet" type="text/css" href="resource/css/table.css" />

</head>

<body>
	<form action="accrecord_modify2.html" method="post">
		<div class='search clearfix'>
			<h3>考勤和人员出入管理</h3>
			<span class="datum">考勤和人员出入管理>>修改人员出入记录</span>
			<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="uid">项目编号:</label></td>
						<td><input class="inp" type="text" name="pCode" value="${model.pCode}"/></td>
						<td style="color:red">*必须填写</td>
					</tr>
					<tr>
						<td><label for="uid">班组编号:</label></td>
						<td><input class="inp" type="text" name="code" value="${model.code}"/></td>
						<td style="color:red">*必须填写</td>
					</tr>
					<tr>
						<td><label for="uid">姓名:</label></td>
						<td><input class="inp" type="text" name="name" value="${model.name}"/></td>
					</tr>
					<tr>
						<td><label for="uid">手机号:</label></td>
						<td><input class="inp" type="text" name="userId" value="${model.userId}"/></td>
						<td style="color:red">*必须填写</td>
					</tr>
					<tr>
						<td><label for="uid">出入时间记录:</label></td>
						<td><input class="inp" type="text" name="recordTime" value="${model.recordTimeStr}"/>*格式2016-08-02 10:30:20</td>
					</tr>
					<tr>
						<td>类型</td>
						<td>
							<select name="type" >
							<option value="0" <c:if test="${confirm==0}">selected</c:if>>进场</option>
							<option value="1" <c:if test="${confirm==1}">selected</c:if>>退场</option>
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
<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="resource/js/silder.js" type="text/javascript"
	charset="utf-8"></script>
<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
<script src="resource/js/area.js" type="text/javascript" charset="utf-8"></script>
<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


