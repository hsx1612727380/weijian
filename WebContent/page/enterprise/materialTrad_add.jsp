<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>新增材料商出入库记录</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />

	</head>

	<body>
	<form name="reg_testdate" action="materialTrad_add2.html" method="post">
				<div class='search clearfix'>
					<h3>材料商管理</h3>
					<span class="datum">材料商管理>>新增材料商出入库记录</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="code">材料商代码:</label></td>
						<td style="color:red"><input class="inp" type="text" name="code" placeholder="请输入材料商代码"/><span>*必须填写</span></td>
						<td><label for="pCode">项目代号:</label></td>
						<td style="color:red"><input class="inp" type="text" name="pCode" placeholder="请输入项目代号"/><span>*必须填写</span></td>
					</tr>
					<tr>
						<td><label for="uid">项目名称:</label></td>
						<td style="color:red"><input class="inp" type="text" name="pName" placeholder="请输入项目名称"/>*必须填写</td>
						<td><label for="uid">材料商名称:</label></td>
						<td style="color:red"><input class="inp" type="text" name="mName" placeholder="请输入材料商名称"/>*必须填写</td>
					</tr>
					<tr>
						<td><label for="name">材料名称:</label></td>
						<td style="color:red"><input class="inp" type="text" name="itemName" /></td>
						<td><label for="gender">经办人:</label></td>
						<td style="color:red"><input class="inp" type="text" name="principal" />*必须填写</td>
					</tr>
					<tr>
						<td><label for="year">日期:</label></td>
						<td>
							<select name="YYYY" onChange="YYYYDD(this.value)">
								<option value="year">请选择 年</option>
							</select>
						</td>
						<td>
							<select name="MM" onChange="MMDD(this.value)">
								<option value="month">选择 月</option>
							</select>
						</td>
						<td>
							<select name="DD">
								<option value="day">选择 日</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="uid">出库时间:</label></td>
						<td><input class="inp" type="text" name="outTime" /></td>
					</tr>
					<tr>
						<td><label for="uid">出库量:</label></td>
						<td><input class="inp" type="text" name="outNum" /></td>
						<td><label for="uid">累计出库:</label></td>
						<td><input class="inp" type="text" name="allease" /></td>
					</tr>
					<tr>
						<td><label for="uid">本次付款:</label></td>
						<td><input class="inp" type="text" name="thispay" /></td>
						<td><label for="uid">累计付款:</label></td>
						<td><input class="inp" type="text" name="culapay" /></td>
					</tr>
					<tr>
						<td><label for="uid">其它款:</label></td>
						<td><input class="inp" type="text" name="otherpay" /></td>
						<td><label for="uid">余款:</label></td>
						<td><input class="inp" type="text" name="restpay" /></td>
					</tr>
					<tr>
						<td><label for="uid">发票:</label></td>
						<td><input class="inp" type="text" name="invoice" /></td>
						<td><label for="uid">备注:</label></td>
						<td><input class="inp" type="text" name="note" /></td>
					</tr>
					<tr>
						<td><label for="uid">付款人:</label></td>
						<td><input class="inp" type="text" name="drawee" /></td>
						<td><label for="uid">付款方式:</label></td>
						<td><input class="inp" type="text" name="payment" /></td>
					</tr>
					<tr>
						<td><label for="uid">流水号:</label></td>
						<td><input class="inp" type="text" name="serial" /></td>
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
	<script src="resource/js/area.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/time.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


