<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>新增人员出入记录</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />
		<script type="text/javascript">
			!function(){
				laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
				laydate({elem: '#demo'});//绑定元素

		}();
		</script>

	</head>

	<body>
	<form name="reg_testdate"  action="accrecord_add2.html" method="post">
				<div class='search clearfix'>
					<h3>考勤和人员出入管理</h3>
					<span class="datum">考勤和人员出入管理>>新增人员出入记录</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="uid">项目编号:</label></td>
						<td style="color:red"><input id="pCode" class="inp" type="text" name="pCode" /><span>*必须填写</span></td>
					</tr>
					<tr>
						<td><label for="uid">班组编号:</label></td>
						<td style="color:red"><input id="tCode" class="inp" type="text" name="code" /><span>*必须填写</span></td>
					</tr>
					<tr>
						<td><label for="uid">姓名:</label></td>
						<td><input class="inp" type="text" name="name" /></td>
					</tr>
					<tr>
						<td><label for="uid">手机号:</label></td>
						<td style="color:red"><input id="UserId" class="inp" type="text" name="userId" /><span>*必须填写</span></td>
					</tr>
					<tr>
						<td><label for="uid">出入时间记录:</label></td>
						<td style="color:red"><input name="recordTime" placeholder="请输入日期" class="laydate-icon" onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">*必须填写</td>
					</tr>
					<tr>
						<td>类型</td>
						<td>
							<select name="type" >
							<option value="0">进场</option>
							<option value="1">退场</option>
							</select>
						</td>
					</tr>
					
					
					
					<tr>
						<td></td>
						<td><button class="add">添加</button></td>
					</tr>
				</table>
				
				</div>
				
				<div class="footer clearfix">
				</div>
				
				
			
		</form>
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/time.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/accrecord_add_check.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/laydate.js" type="text/javascript" charset="utf-8"></script>
	

</html>


