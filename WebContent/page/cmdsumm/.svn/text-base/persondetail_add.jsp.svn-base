<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>新增人工费明细</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />

	</head>

	<body>
	<form action="persondetail_add2.html" method="post">
				<div class='search clearfix'>
					<h3>项目明细管理</h3>
					<span class="datum">项目管理>>新增人工费明细信息</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="name">人员姓名:</label></td>
						<td><input class="inp" type="text" name="name" /></td>
						<td><label for="userId">手机号:</label></td>
						<td><input class="inp" type="text" name="userId" /></td>
					</tr>
					<tr>
						<td><label for="identity">身份证号码:</label></td>
						<td><input class="inp" type="text" name="identity" /></td>
					</tr>
					<tr>
						<td><label for="drawee">付款人:</label></td>
						<td><input class="inp" type="text" name="drawee" /></td>
						<td><label for="payTime">发放时间:</label></td>
						<td><input class="inp" type="text" name="payTime" /></td>
					</tr>
					<tr>
						<td>支付方式</td>
						<td>
							<select name="paytype" >
							<option value="1" <c:if test="${paytype=='1'}">selected</c:if>>支付宝</option>
							<option value="2" <c:if test="${paytype=='2'}">selected</c:if>>微信</option>
							<option value="3" <c:if test="${paytype=='3'}">selected</c:if>>银行卡</option>
							<option value="4" <c:if test="${paytype=='4'}">selected</c:if>>现金</option>
							</select>
						</td>
						<td><label for="account">支付账号:</label></td>
						<td><input class="inp" type="text" name="account" /></td>
					</tr>
					<tr>
						<td><label for="voucher">支付凭证:</label></td>
						<td><input class="inp" type="text" name="voucher" /></td>
						<td><label for="safe">是否安全教育:</label></td>
						<td><input class="inp" type="text" name="safe" /></td>
					</tr>
					<tr>
						<td><label for="inTime">进场时间:</label></td>
						<td><input class="inp" type="text" name="inTime" /></td>
						<td><label for="outTime">退场时间:</label></td>
						<td><input class="inp" type="text" name="outTime" /></td>
					</tr>
					<tr>
						<td><label for="access">出入记录:</label></td>
						<td><input class="inp" type="text" name="access" /></td>
						<td><label for="attendance">考勤记录:</label></td>
						<td><input class="inp" type="text" name="attendance" /></td>
					</tr>
					<tr>
						<td><label for="workContent">工作内容:</label></td>
						<td><input class="inp" type="text" name="workContent" /></td>
					</tr>
					<tr>
						<td><label for="count">次数:</label></td>
						<td><input class="inp" type="text" name="count" /></td>
						<td><label for="salary">应发工资:</label></td>
						<td><input class="inp" type="text" name="salary" /></td>
					</tr>
					<tr>
						<td><label for="deduct">扣款:</label></td>
						<td><input class="inp" type="text" name="deduct" /></td>
						<td><label for="realSalary">实发工资:</label></td>
						<td><input class="inp" type="text" name="realSalary" /></td>
					</tr>
					<tr>
						<td><label for="noSalary">未付工资:</label></td>
						<td><input class="inp" type="text" name="noSalary" /></td>
						<td><label for="flag">签名指纹:</label></td>
						<td><input class="inp" type="text" name="flag" /></td>
					</tr>
					<tr>
						<td><label for="note">备注:</label></td>
						<td><input class="inp" type="text" name="note" /></td>
					</tr>
					<tr>
						<td></td>
						<td><button  class="add">添加</button></td>
					</tr>
				</table>
				
				</div>
				
				<div class="footer clearfix">
					<input type="hidden" name="cmdId" value="<%=request.getAttribute("cmdId")%>">
					<input type="hidden" name="teamtype" value="<%=request.getAttribute("teamtype")%>">
					<input type="hidden" name="tId" value="<%=request.getAttribute("tId")%>">
				</div>
		</form>
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/area.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>

</html>


