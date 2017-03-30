<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>修改考勤信息</title>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
<link rel="stylesheet" type="text/css" href="resource/css/table.css" />
<script type="text/javascript">
		function submitForm() {
			var startDate = document.getElementById('startDate').value;
			var endDate = document.getElementById('endDate').value;
			var workTime = document.getElementById('workTime').value;
			
			var r = /^\d+(\.\d+)?$/;
			if(r.test(workTime) == false){
				alert('工时输入错误，例如2，2.5等');
		        return false;
			}
			
			return true;
		}
	</script>
</head>

<body>
	<form action="attendanceInfo_modify2.html" method="post" onSubmit="return submitForm()">
		<div class='search clearfix'>
					<h3>考勤和人员出入管理</h3>
					<span class="datum">考勤和人员出入管理>>修改考勤信息</span>
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
						<td><label for="uid">开始时间:</label></td>
						<td><input class="inp" type="text" name="startDate" id="startDate" value="${model.startDateStr}"/>*必须填写,格式2016-08-20 11:00:21</td>
					</tr>
					<tr>
						<td><label for="uid">结束时间:</label></td>
						<td><input class="inp" type="text" name="endDate" id="endDate" value="${model.endDateStr}"/>*必须填写,格式2016-08-20 11:00:21</td>
					</tr>
					<tr>
						<td><label for="uid">工时:</label></td>
						<td><input class="inp" type="text" name="workTime" id="workTime" value="${model.workTime}"/>*必须填写</td>
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


