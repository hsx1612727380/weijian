<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />
		<style type="text/css">
			table {
				width: 100%;
			}
			th {
				font:700 24px sans-serif;
				color: red;
			}
			td{
				text-align: center;
				padding: 2px 4px;
			}
		</style>
	</head>
	<body>
		<table border="1" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="24">
					主要材料设备验工计价明细表
				</th>
			</tr>
			<tr>
				<td rowspan="2">供应商</td>
				<td rowspan="2">经办人</td>
				<td rowspan="2">名称/规格/型号</td>
				<td rowspan="2">支付账号和凭证</td>
				<td rowspan="2">单位</td>
				<td rowspan="2">次数</td>
				<td rowspan="2">预算量</td>
				<td colspan="3">合同价</td>
				<td rowspan="2">预付款</td>
				<td colspan="2">入库量</td>
				<td colspan="4">付款情况</td>
				<td rowspan="2">资料情况</td>
				<td rowspan="2">发票情况</td>
				<td rowspan="2">结算情况</td>
				<td rowspan="2">用途</td>
				<td rowspan="2">质量</td>
				<td rowspan="2">备注</td>
			</tr>
			<tr>
				<td>数量</td>
				<td>单价</td>
				<td>小计</td>
				<td>本次入库量</td>
				<td>累计入库量</td>
				<td>本次付款</td>
				<td>累计付款</td>
				<td>其它款</td>
				<td>余款</td>
			</tr>
			
			<tr>
				<td>一</td>
				<td style="text-align: left;" colspan="24">
				<c:if test="${csmodel.teamtype=='1'}">本班组</c:if>
				<c:if test="${csmodel.teamtype=='2'}">劳务班组</c:if>
				<c:if test="${csmodel.teamtype=='3'}">专业班组</c:if>
				供应商费用
				</td>
			</tr>
			<c:forEach items="${cslist}" var="model">
			<tr>
				<td></td>
				<td>${model.tName}</td>
				<td>${model.principal}</td>
				<td>${model.cName}</td>
				<td>${model.account}</td>
				<td>${model.unit}</td>
				<td>${model.frequency}</td>
				<td>${model.budget}</td>
				<td>${model.num}</td>
				<td>${model.price}</td>
				<td>${model.subtotal}</td>
				<td>${model.bgpayment}</td>
				<td>${model.receipt}</td>
				<td>${model.cumulative}</td>
				<td>${model.thispay}</td>
				<td>${model.culapay}</td>
				<td>${model.otherpay}</td>
				<td>${model.restpay}</td>
				<td>${model.information}</td>
				<td>${model.invoice}</td>
				<td>${model.settlement}</td>
				<td>${model.using}</td>
				<td>${model.quality}</td>
				<td>${model.note}</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>
