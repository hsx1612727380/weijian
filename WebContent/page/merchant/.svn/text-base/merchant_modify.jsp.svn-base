<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>修改供应商诚信档案</title>
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
		<form action="merchant_modify2.html" method="post">
		<div class='search clearfix'> 
		<table border="1px solid #555555" cellspacing="0" cellpadding="0">
			<tr><th colspan="8">供应商档案</th></tr>
			<tr><td colspan="8">供应商资料</td></tr>
			<tr>
				<td>供应商名称</td>
				<td colspan="2"><input class="val" type="text" name="supplier"  value="${model.supplier}"/></td>
				<td>供应商代号</td>
				<td colspan="2"><input class="val" type="text" name="code"  value="${model.code}"/></td>
				<td>类型</td>
				<td>
					<c:if test="${model.type=='1'}">材料商</c:if>
					 <c:if test="${model.type=='2'}">设备商</c:if>
				</td>
			</tr>
			<tr>
				<td>供货名称</td>
				<td colspan="2"><input class="val" type="text" name="itemname"  value="${model.itemname}"/></td>
				<td>供货状态</td>
				<td colspan="1">
					<select name="status">
					    <option value="0" >停供中</option>
					    <option value="1" >供货中</option>
					</select>
				</td>
				<td >供货地区</td>
				<td colspan="3"><input class="val" type="text" name="supply"  value="${model.supply}"/></td>
			</tr>
			
			<tr>
				<td>营业执照</td>
				<td><input class="val" type="text" name="licence" value="${model.licence}" /></td>
				<td>成立日期</td>
				<td><input class="val" type="text" name="build" value="${model.build}" /></td>
				<td>注册资金（万）</td>
				<td><input class="val" type="text" name="registercapital" value="${model.registercapital}" /></td>
				<td>实缴（万）</td>
				<td><input class="val" type="text" name="paid" value="${model.paid}" /></td>
			</tr>
			<tr>
				<td colspan="1">注册地址</td>
				<td colspan="3"><input class="val" type="text" name="registeraddress" value="${model.registeraddress}" /></td>
				<td>结算方式</td>
				<td><input class="val" type="text" name="paytype" value="${model.paytype}" /></td>
				<td>期初应付</td>
				<td><input class="val" type="text" name="cope" value="${model.cope}" /></td>
			</tr>
			<tr>
				<td>电话/传真号</td>
				<td colspan="2"><input class="val" type="text" name="phone" value="${model.phone}" /></td>
				<td>邮箱</td>
				<td colspan="2"><input class="val" type="text" name="email" value="${model.email}" /></td>
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
				<td><input class="val" type="text" name="name" value="${model.name}" /></td>
				<td colspan="2">联系人地址</td>
				<td colspan="4"><input class="val" type="text" name="address" value="${model.address}" /></td>
			</tr>
			<tr>
				<td>支付账号</td>
				<td><input class="val" type="text" name="payment" value="${model.payment}" /></td>
				<td>开户行</td>
				<td><input class="val" type="text" name="depositBank" value="${model.depositBank}" /></td>
				<td>银行账号</td>
				<td><input class="val" type="text" name="bankaccount" value="${model.bankaccount}" /></td>
				<td>备注</td>
				<td colspan="3"><input class="val" type="text" name="note" value="${model.note}" /></td>
			</tr>
			<tr>
				<td>手机</td>
				<td>${model.mobile}</td>
				<td>QQ</td>
				<td><input class="val" type="text" name="qq" value="${model.qq}" /></td>
				<td>微信</td>
				<td><input class="val" type="text" name="wetchat" value="${model.wetchat}" /></td>
				<td>支付宝</td>
				<td><input class="val" type="text" name="paytreasure" value="${model.paytreasure}" /></td>
			</tr>
			<tr>
				<td>身份证号码</td>
				<td colspan="3"><input class="val" type="text" name="identification" value="${model.identification}" /></td>
				<td></td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td colspan="8"><button class="add">修改</button></td>
			</tr>
		</table>
		</div>
		<div class="footer clearfix">
		<input type="hidden" name="id" value="${model.id}"> 
		</div>
	</form>
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
</html>