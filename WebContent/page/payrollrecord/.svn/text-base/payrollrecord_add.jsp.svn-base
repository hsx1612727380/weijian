<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>新增工资发放记录</title>
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
	<form name="reg_testdate"  action="payrollrecord_add2.html" method="post">
				<div class='search clearfix'>
					<h3>工资发放管理</h3>
					<span class="datum">工资发放管理>>新增工资发放记录</span>
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
						<td><label for="uid">开始时间:</label></td>
						<td><input class="inp" type="text" name="startTime" /></td>
					</tr>
					<tr>
						<td><label for="uid">结束时间:</label></td>
						<td><input class="inp" type="text" name="endTime" /></td>
					</tr>
					<tr>
						<td><label for="uid">应发工资:</label></td>
						<td><input class="inp" type="text" name="salary" /></td>
					</tr>
					<tr>
						<td><label for="uid">实发工资:</label></td>
						<td><input class="inp" type="text" name="realSalary" /></td>
					</tr>
					<tr>
						<td><label for="uid">未付工资:</label></td>
						<td><input class="inp" type="text" name="noSalary" /></td>
					</tr>
					<tr>
						<td><label for="uid">税款:</label></td>
						<td><input class="inp" type="text" name="tax" /></td>
					</tr>
					<tr>
						<td><label for="uid">付款人:</label></td>
						<td><input class="inp" type="text" name="drawee" /></td>
					</tr>
					<tr>
						<td><label for="uid">支付方式:</label></td>
						<td>
							<select name="paytype" >
							<option value="1" <c:if test="${paytype=='1'}">selected</c:if>>支付宝</option>
							<option value="2" <c:if test="${paytype=='2'}">selected</c:if>>微信</option>
							<option value="3" <c:if test="${paytype=='3'}">selected</c:if>>银行卡</option>
							<option value="4" <c:if test="${paytype=='4'}">selected</c:if>>现金</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="uid">流水号:</label></td>
						<td><input class="inp" type="text" name="serial" /></td>
					</tr>
					
					<tr>
						<td><label for="time">发放日期:</label></td>
						<td style="color:red"><input name="payTime" placeholder="请输入日期" class="laydate-icon" onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">*必须填写</td>
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
	<script src="resource/js/payrollrecord_add_check.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/laydate.js" type="text/javascript" charset="utf-8"></script>
	

</html>


