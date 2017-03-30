<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>修改公司注册人员信息</title>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
<link rel="stylesheet" type="text/css" href="resource/css/table.css" />

</head>

<body>
	<form action="payrollrecord_modify2.html" method="post">
		<div class='search clearfix'>
					<h3>工资发放管理</h3>
					<span class="datum">工资发放管理>>新增工资发放记录</span>
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
						<td><input class="inp" type="text" name="startTime" value="${model.startTime}"/></td>
					</tr>
					<tr>
						<td><label for="uid">结束时间:</label></td>
						<td><input class="inp" type="text" name="endTime" value="${model.endTime}"/></td>
					</tr>
					<tr>
						<td><label for="uid">应发工资:</label></td>
						<td><input class="inp" type="text" name="salary" value="${model.salary}"/></td>
					</tr>
					<tr>
						<td><label for="uid">实发工资:</label></td>
						<td><input class="inp" type="text" name="realSalary" value="${model.realSalary}"/></td>
					</tr>
					<tr>
						<td><label for="uid">未付工资:</label></td>
						<td><input class="inp" type="text" name="noSalary" value="${model.noSalary}"/></td>
					</tr>
					<tr>
						<td><label for="uid">税款:</label></td>
						<td><input class="inp" type="text" name="tax" value="${model.tax}"/></td>
					</tr>
					<tr>
						<td><label for="uid">付款人:</label></td>
						<td><input class="inp" type="text" name="drawee" value="${model.drawee}"/></td>
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
						<td><input class="inp" type="text" name="serial" value="${model.serial}"/></td>
					</tr>
					
					<tr>
						<td><label for="time">发放日期:</label></td>
						<td>
							<input class="inp" type="text" name="payTime" value="${model.payTimeStr}"/>*格式2016-08-02 10:30:00
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


