<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>新增供应商诚信档案</title>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/records.css"/>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<style type="text/css">
			td input{
			border:none;
			width:100%;
			}
		</style>
	</head>

	<body>
		<form action="merchant_add2.html" method="post">
		<div class='search clearfix'> 
		<table border="0" cellspacing="1" cellpadding="0">
			<tr><th colspan="8">供应商档案</th></tr>
			<tr><td colspan="8">供应商资料</td></tr>
			<tr>
				<td>供应商名称</td>
				<td colspan="2"><input class="inp" type="text" name="supplier"  /></td>
				<td>供应商代号</td>
				<td colspan="2"><input class="inp" type="text" name="code"  /></td>
				<td>类型</td>
				<td>
					<select name="type">
					    <option value="1" >材料商</option>
					    <option value="2" >设备商</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>供货名称</td>
				<td colspan="2"><input class="inp" type="text" name="itemname"  /></td>
				<td>供货状态</td>
				<td colspan="1">
					<select name="status">
					    <option value="0" >停供中</option>
					    <option value="1" >供货中</option>
					</select>
				</td>
				<td >供货地区</td>
				<td colspan="2"><input class="inp" type="text" name="supply"  /></td>
			</tr>
			<tr>
				<td>营业执照</td>
				<td><input class="inp" type="text" name="licence"  /></td>
				<td>成立日期</td>
				<td><input class="inp" type="text" name="build"  /></td>
				<td>注册资金（万）</td>
				<td><input class="inp" type="text" name="registercapital"  /></td>
				<td>实缴（万）</td>
				<td><input class="inp" type="text" name="paid"  /></td>
			</tr>
			<tr>
				<td colspan="1">注册地址</td>
				<td colspan="3"><input class="inp" type="text" name="registeraddress"  /></td>
				<td>结算方式</td>
				<td><input class="inp" type="text" name="paytype"  /></td>
				<td>期初应付</td>
				<td><input class="inp" type="text" name="cope"  /></td>
			</tr>
			<tr>
				<td>电话/传真号</td>
				<td colspan="2"><input class="inp" type="text" name="phone"  /></td>
				<td>邮箱</td>
				<td colspan="2"><input class="inp" type="text" name="email"  /></td>
				<td>是否公开</td>
				<td colspan="1">
					<select name="open">
					    <option value="1" >公开</option>
					    <option value="0" >不公开</option>
					</select>
				</td>
			</tr>
			<tr><td colspan="8">联系方式及帐号</td></tr>
			<tr>
				<td>联系人</td>
				<td><input class="inp" type="text" name="name" /></td>
				<td colspan="2">联系人地址</td>
				<td colspan="4"><input class="inp" type="text" name="address"  /></td>
			</tr>
			<tr>
				<td>支付账号</td>
				<td><input class="inp" type="text" name="payment"  /></td>
				<td>开户行</td>
				<td><input class="inp" type="text" name="depositBank"  /></td>
				<td>银行账号</td>
				<td><input class="inp" type="text" name="bankaccount"  /></td>
				<td>备注</td>
				<td><input class="inp" type="text" name="note"  /></td>
			</tr>
			<tr>
				<td>手机</td>
				<td><input class="inp" type="text" name="mobile" /></td>
				<td>QQ</td>
				<td><input class="inp" type="text" name="qq"  /></td>
				<td>微信</td>
				<td><input class="inp" type="text" name="wetchat"  /></td>
				<td>支付宝</td>
				<td><input class="inp" type="text" name="paytreasure"  /></td>
			</tr>
			<tr>
				<td>身份证号码</td>
				<td colspan="3"><input class="inp" type="text" name="identification"  /></td>
				<td colspan="4"></td>
			</tr>
			<tr>
				<td colspan="8"><button class="add" style="background-color:#39B3D7;border:0;color:white;width:44px;">添加</button></td>
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
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>