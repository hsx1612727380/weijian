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
					主要${type}验工计价汇总表
				</th>
			</tr>
			<tr>
				<td colspan="24" style="text-align: left;"> <b>项目名称:${pModel.name}
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${year}年&nbsp;${month}月</b></td>
			</tr>
			<tr>
				<td rowspan="2">序号</td>
				<td rowspan="2">名称</td>
				<td rowspan="2">委托/经办人</td>
				<td rowspan="2">支付宝账户或凭证</td>
				<td rowspan="2">合同价</td>
				<td rowspan="2">预付款</td>
				<td rowspan="2">次数</td>
				<td colspan="4">工程完成情况</td>
				<td colspan="4">付款情况</td>
				<td rowspan="2">结算情况</td>
				<td rowspan="2">发票情况</td>
				<td rowspan="2">备注</td>
			</tr>
			<tr>
				<td>单位</td>
				<td>总工程量</td>
				<td>本次工程量</td>
				<td>累计完成%</td>
				<td>本期付款</td>
				<td>累计付款</td>
				<td>余额</td>
				<td>累计付款占总量%</td>
			</tr>
			<tr>
				<td>一</td>
				<td style="text-align: left;" colspan="22">${type}本班组费</td>
			</tr>
			<c:forEach items="${benban}" var="model">
			<tr>
				<td><span class="items"><a href="supplierdetail_add.html?id=${model.id}&teamtype=1&tId=${model.tNum}&type=${model.type}" style="color:white">新增</a></span></td>
				<td><a href="supplierdetail_list.html?id=${model.id}&tNum=${model.tNum}&teamtype=1" style="color:orange">${model.tName}</a></td>
				<td>${model.principal}</td>
				<td>${model.account}</td>
				<td>${model.contractPrice}</td>
				<td>${model.bgpayment}</td>
				<td>${model.frequency}</td>
				<td>${model.unit}</td>
				<td>${model.total}</td>
				<td>${model.nowTotal}</td>
				<td>${model.percentage}%</td>
				<td>${model.thispay}</td>
				<td>${model.culapay}</td>
				<td>${model.remain}</td>
				<td>${model.culPercentage}</td>
				<td>${model.settlement}</td>
				<td>${model.invoice}</td>
				<td>${model.note}</td>
			</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td>小计：</td>
				<td></td>
				<td></td>
				<td>${benbanTotal.contractPrice}</td>
				<td>${benbanTotal.bgpayment}</td>
				<td>${benbanTotal.frequency}</td>
				<td></td>
				<td>${benbanTotal.total}</td>
				<td>${benbanTotal.nowTotal}</td>
				<td>${benbanTotal.percentage}%</td>
				<td>${benbanTotal.thispay}</td>
				<td>${benbanTotal.culapay}</td>
				<td>${benbanTotal.remain}</td>
				<td>${benbanTotal.culPercentage}</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>二</td>
				<td style="text-align: left;" colspan="22">${type}劳务班组费</td>
			</tr>
			<c:forEach items="${laowu}" var="model"> 
			<tr>
				<td><span class="add"><a href="supplierdetail_add.html?id=${model.id}&teamtype=3&tId=${model.tNum}&type=${model.type}" style="color:white">新增</a></span></td>
				<td><a href="supplierdetail_list.html?id=${model.id}&tNum=${model.tNum}&teamtype=2" style="color:red">${model.tName}</a></td>
				<td>${model.principal}</td>
				<td>${model.account}</td>
				<td>${model.contractPrice}</td>
				<td>${model.bgpayment}</td>
				<td>${model.frequency}</td>
				<td>${model.unit}</td>
				<td>${model.total}</td>
				<td>${model.nowTotal}</td>
				<td>${model.percentage}%</td>
				<td>${model.thispay}</td>
				<td>${model.culapay}</td>
				<td>${model.remain}</td>
				<td>${model.culPercentage}</td>
				<td>${model.settlement}</td>
				<td>${model.invoice}</td>
				<td>${model.note}</td>
			</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td>小计：</td>
				<td></td>
				<td></td>
				<td>${laowuTotal.contractPrice}</td>
				<td>${laowuTotal.bgpayment}</td>
				<td>${laowuTotal.frequency}</td>
				<td></td>
				<td>${laowuTotal.total}</td>
				<td>${laowuTotal.nowTotal}</td>
				<td>${benbanTotal.percentage}%</td>
				<td>${laowuTotal.thispay}</td>
				<td>${laowuTotal.culapay}</td>
				<td>${laowuTotal.remain}</td>
				<td>${laowuTotal.culPercentage}</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>三</td>
				<td style="text-align: left;" colspan="22">${type}专业班组费</td>
			</tr>
			
			<c:forEach items="${zhuanye}" var="model"> 
			<tr>
				<td><span class="del"><a href="supplierdetail_add.html?id=${model.id}&teamtype=3&tId=${model.tNum}" style="color:white">新增</a></span></td>
				<td><a href="supplierdetail_list.html?id=${model.id}&tNum=${model.tNum}&teamtype=3" style="color:red">${model.tName}</a></td>
				<td>${model.principal}</td>
				<td>${model.account}</td>
				<td>${model.contractPrice}</td>
				<td>${model.bgpayment}</td>
				<td>${model.frequency}</td>
				<td>${model.unit}</td>
				<td>${model.total}</td>
				<td>${model.nowTotal}</td>
				<td>${model.percentage}%</td>
				<td>${model.thispay}</td>
				<td>${model.culapay}</td>
				<td>${model.remain}</td>
				<td>${model.culPercentage}</td>
				<td>${model.settlement}</td>
				<td>${model.invoice}</td>
				<td>${model.note}</td>
			</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td>小计：</td>
				<td></td>
				<td></td>
				<td>${zhuanyeTotal.contractPrice}</td>
				<td>${zhuanyeTotal.bgpayment}</td>
				<td>${zhuanyeTotal.frequency}</td>
				<td></td>
				<td>${zhuanyeTotal.total}</td>
				<td>${zhuanyeTotal.nowTotal}</td>
				<td>${zhuanyeTotal.percentage}%</td>
				<td>${zhuanyeTotal.thispay}</td>
				<td>${zhuanyeTotal.culapay}</td>
				<td>${zhuanyeTotal.remain}</td>
				<td>${zhuanyeTotal.culPercentage}</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			
		</table>
	</body>
</html>
