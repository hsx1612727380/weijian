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
				<th colspan="18">
					主要人工验工计价明细表
				</th>
			</tr>
			<tr>
				<td rowspan="2">序号</td>
				<td rowspan="2">人员姓名</td>
				<td rowspan="2">身份证号码</td>
				<td rowspan="2">支付账号</td>
				<td rowspan="2">支付凭证</td>
				<td rowspan="2">进场时间</td>
				<td rowspan="2">是否安全教育</td>
				<td rowspan="2">退场时间</td>
				<td rowspan="2">出入记录</td>
				<td rowspan="2">考勤记录</td>
				<td rowspan="2">工作内容</td>
				<td colspan="4">付款</td>
				<td rowspan="2">未付工资</td>
				<td rowspan="2">签名指纹</td>
				<td rowspan="2">备注</td>
			</tr>
			<tr>
				<td>次数</td>
				<td>应发工资</td>
				<td>扣款</td>
				<td>实发工资</td>
			</tr>
			<tr>
				<td>一</td>
				<td style="text-align: left;" colspan="17">
				<c:if test="${teamtype=='1'}">本班组</c:if>
				<c:if test="${teamtype=='2'}">劳务班组</c:if>
				<c:if test="${teamtype=='3'}">专业班组</c:if>
				人工费用
				</td>
			</tr>
			<c:forEach items="${cplist}" var="model">
			<tr>
				<td></td>
				<td>${model.name}</td>
				<td>${model.identity}</td>
				<td>${model.account}</td>
				<td>${model.voucher}</td>
				<td>${model.inTime}</td>
				<td>${model.safe}</td>
				<td>${model.outTime}</td>
				<td>${model.access}</td>
				<td>${model.attendance}</td>
				<td>${model.workContent}</td>
				<td>${model.count}</td>
				<td>${model.salary}</td>
				<td>${model.deduct}</td>
				<td>${model.realSalary}</td>
				<td>${model.noSalary}</td>
				<td>${model.flag}</td>
				<td>${model.note}</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>
