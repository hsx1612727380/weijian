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
				<th colspan="16">
					主要人工、材料、机械设备验工计价汇总表
				</th>
			</tr>
			<tr>
				<td colspan="16" style="text-align: left;"> <b>项目名称:${pModel.name}
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${year}年&nbsp;${month}月</b></td>
			</tr>
			<tr>
				<td rowspan="2">序号</td>
				<td rowspan="2">名称</td>
				<td rowspan="2">合同价</td>
				<td rowspan="2">预付款</td>
				<td rowspan="2">次数</td>
				<td colspan="4">工程完成情况</td>
				<td colspan="4">付款情况</td>
				<td rowspan="2">押金</td>
				<td rowspan="2">结算情况</td>
			</tr>
			<tr>
				<td>单位</td>
				<td>总工程量</td>
				<td>本次工程量</td>
				<td>本次工程量占总量%</td>
				<td>本期付款</td>
				<td>累计付款</td>
				<td>余额</td>
				<td>累计付款占总量%</td>
			</tr>
			
			<tr>
				<td>一</td>
				<td style="text-align: left;" colspan="15"><span class="items">
									<a href="personsummary_list.html?year=${year}&month=${month}&pId=${pId}&type=1" style="color:white">人工</a>
								</span></td>
			</tr>
			<tr>
				<td></td>
				<td>本班组</td>
				<td>${rengong_benban.contractPrice}</td>
				<td>${rengong_benban.bgpayment}</td>
				<td>${rengong_benban.frequency}</td>
				<td>${rengong_benban.unit}</td>
				<td>${rengong_benban.total}</td>
				<td>${rengong_benban.nowTotal}</td>
				<td>${rengong_benban.percentage}%</td>
				<td>${rengong_benban.thispay}</td>
				<td>${rengong_benban.culapay}</td>
				<td>${rengong_benban.remain}</td>
				<td>${rengong_benban.culPercentage}%</td>
				<td>${rengong_benban.deposit}</td>
				<td>${rengong_benban.settlement}</td>
			</tr>
			<tr>
				<td></td>
				<td>劳务分包班组</td>
				<td>${rengong_laowu.contractPrice}</td>
				<td>${rengong_laowu.bgpayment}</td>
				<td>${rengong_laowu.frequency}</td>
				<td>${rengong_laowu.unit}</td>
				<td>${rengong_laowu.total}</td>
				<td>${rengong_laowu.nowTotal}</td>
				<td>${rengong_laowu.percentage}%</td>
				<td>${rengong_laowu.thispay}</td>
				<td>${rengong_laowu.culapay}</td>
				<td>${rengong_laowu.remain}</td>
				<td>${rengong_laowu.culPercentage}%</td>
				<td>${rengong_laowu.deposit}</td>
				<td>${rengong_laowu.settlement}</td>
			</tr>
			<tr>
				<td></td>
				<td>专业分包班组</td>
				<td>${rengong_zhuanye.contractPrice}</td>
				<td>${rengong_zhuanye.bgpayment}</td>
				<td>${rengong_zhuanye.frequency}</td>
				<td>${rengong_zhuanye.unit}</td>
				<td>${rengong_zhuanye.total}</td>
				<td>${rengong_zhuanye.nowTotal}</td>
				<td>${rengong_zhuanye.percentage}%</td>
				<td>${rengong_zhuanye.thispay}</td>
				<td>${rengong_zhuanye.culapay}</td>
				<td>${rengong_zhuanye.remain}</td>
				<td>${rengong_zhuanye.culPercentage}%</td>
				<td>${rengong_zhuanye.deposit}</td>
				<td>${rengong_zhuanye.settlement}</td>
			</tr>
			<tr>
				<td></td>
				<td>小计：</td>
				<td>${rengongTotal.contractPrice}</td>
				<td>${rengongTotal.bgpayment}</td>
				<td>${rengongTotal.frequency}</td>
				<td></td>
				<td>${rengongTotal.total}</td>
				<td>${rengongTotal.nowTotal}</td>
				<td>${rengongTotal.percentage}%</td>
				<td>${rengongTotal.thispay}</td>
				<td>${rengongTotal.culapay}</td>
				<td>${rengongTotal.remain}</td>
				<td>${rengongTotal.culPercentage}%</td>
				<td>${rengongTotal.deposit}</td>
				<td></td>
			</tr>
			<tr>
				<td>二</td>
				<td style="text-align: left;" colspan="15"><span class="add">
									<a href="suppliersummary_list.html?year=${year}&month=${month}&pId=${pId}&type=2" style="color:white">材料</a>
								</span></td>
			</tr>
			<tr>
				<td></td>
				<td>本班组</td>
				<td>${cailiao_benban.contractPrice}</td>
				<td>${cailiao_benban.bgpayment}</td>
				<td>${cailiao_benban.frequency}</td>
				<td>${cailiao_benban.unit}</td>
				<td>${cailiao_benban.total}</td>
				<td>${cailiao_benban.nowTotal}</td>
				<td>${cailiao_benban.percentage}%</td>
				<td>${cailiao_benban.thispay}</td>
				<td>${cailiao_benban.culapay}</td>
				<td>${cailiao_benban.remain}</td>
				<td>${cailiao_benban.culPercentage}%</td>
				<td>${cailiao_benban.deposit}</td>
				<td>${cailiao_benban.settlement}</td>
			</tr>
			<tr>
				<td></td>
				<td>劳务分包班组</td>
				<td>${cailiao_laowu.contractPrice}</td>
				<td>${cailiao_laowu.bgpayment}</td>
				<td>${cailiao_laowu.frequency}</td>
				<td>${cailiao_laowu.unit}</td>
				<td>${cailiao_laowu.total}</td>
				<td>${cailiao_laowu.nowTotal}</td>
				<td>${cailiao_laowu.percentage}%</td>
				<td>${cailiao_laowu.thispay}</td>
				<td>${cailiao_laowu.culapay}</td>
				<td>${cailiao_laowu.remain}</td>
				<td>${cailiao_laowu.culPercentage}%</td>
				<td>${cailiao_laowu.deposit}</td>
				<td>${cailiao_laowu.settlement}</td>
			</tr>
			<tr>
				<td></td>
				<td>专业分包班组</td>
				<td>${cailiao_zhuanye.contractPrice}</td>
				<td>${cailiao_zhuanye.bgpayment}</td>
				<td>${cailiao_zhuanye.frequency}</td>
				<td>${cailiao_zhuanye.unit}</td>
				<td>${cailiao_zhuanye.total}</td>
				<td>${cailiao_zhuanye.nowTotal}</td>
				<td>${cailiao_zhuanye.percentage}%</td>
				<td>${cailiao_zhuanye.thispay}</td>
				<td>${cailiao_zhuanye.culapay}</td>
				<td>${cailiao_zhuanye.remain}</td>
				<td>${cailiao_zhuanye.culPercentage}%</td>
				<td>${cailiao_zhuanye.deposit}</td>
				<td>${cailiao_zhuanye.settlement}</td>
			</tr>
			<tr>
				<td></td>
				<td>小计：</td>
				<td>${cailiaoTotal.contractPrice}</td>
				<td>${cailiaoTotal.bgpayment}</td>
				<td>${cailiaoTotal.frequency}</td>
				<td></td>
				<td>${cailiaoTotal.total}</td>
				<td>${cailiaoTotal.nowTotal}</td>
				<td>${cailiaoTotal.percentage}%</td>
				<td>${cailiaoTotal.thispay}</td>
				<td>${cailiaoTotal.culapay}</td>
				<td>${cailiaoTotal.remain}</td>
				<td>${cailiaoTotal.culPercentage}%</td>
				<td>${cailiaoTotal.deposit}</td>
				<td></td>
			</tr>
			<tr>
				<td>三</td>
				<td style="text-align: left;" colspan="15"><span class="del">
									<a href="suppliersummary_list.html?year=${year}&month=${month}&pId=${pId}&type=3" style="color:white">设备</a>
								</span></td>
			</tr>
			<tr>
				<td></td>
				<td>本班组</td>
				<td>${shebei_benban.contractPrice}</td>
				<td>${shebei_benban.bgpayment}</td>
				<td>${shebei_benban.frequency}</td>
				<td>${shebei_benban.unit}</td>
				<td>${shebei_benban.total}</td>
				<td>${shebei_benban.nowTotal}</td>
				<td>${shebei_benban.percentage}%</td>
				<td>${shebei_benban.thispay}</td>
				<td>${shebei_benban.culapay}</td>
				<td>${shebei_benban.remain}</td>
				<td>${shebei_benban.culPercentage}%</td>
				<td>${shebei_benban.deposit}</td>
				<td>${shebei_benban.settlement}</td>
			</tr>
			<tr>
				<td></td>
				<td>劳务分包班组</td>
				<td>${shebei_laowu.contractPrice}</td>
				<td>${shebei_laowu.bgpayment}</td>
				<td>${shebei_laowu.frequency}</td>
				<td>${shebei_laowu.unit}</td>
				<td>${shebei_laowu.total}</td>
				<td>${shebei_laowu.nowTotal}</td>
				<td>${shebei_laowu.percentage}%</td>
				<td>${shebei_laowu.thispay}</td>
				<td>${shebei_laowu.culapay}</td>
				<td>${shebei_laowu.remain}</td>
				<td>${shebei_laowu.culPercentage}%</td>
				<td>${shebei_laowu.deposit}</td>
				<td>${shebei_laowu.settlement}</td>
			</tr>
			<tr>
				<td></td>
				<td>专业分包班组</td>
				<td>${shebei_zhuanye.contractPrice}</td>
				<td>${shebei_zhuanye.bgpayment}</td>
				<td>${shebei_zhuanye.frequency}</td>
				<td>${shebei_zhuanye.unit}</td>
				<td>${shebei_zhuanye.total}</td>
				<td>${shebei_zhuanye.nowTotal}</td>
				<td>${shebei_zhuanye.percentage}%</td>
				<td>${shebei_zhuanye.thispay}</td>
				<td>${shebei_zhuanye.culapay}</td>
				<td>${shebei_zhuanye.remain}</td>
				<td>${shebei_zhuanye.culPercentage}%</td>
				<td>${shebei_zhuanye.deposit}</td>
				<td>${shebei_zhuanye.settlement}</td>
			</tr>
			<tr>
				<td></td>
				<td>小计：</td>
				<td>${shebeiTotal.contractPrice}</td>
				<td>${shebeiTotal.bgpayment}</td>
				<td>${shebeiTotal.frequency}</td>
				<td></td>
				<td>${shebeiTotal.total}</td>
				<td>${shebeiTotal.nowTotal}</td>
				<td>${shebeiTotal.percentage}%</td>
				<td>${shebeiTotal.thispay}</td>
				<td>${shebeiTotal.culapay}</td>
				<td>${shebeiTotal.remain}</td>
				<td>${shebeiTotal.culPercentage}%</td>
				<td>${shebeiTotal.deposit}</td>
				<td></td>
			</tr>
		</table>
	</body>
</html>
