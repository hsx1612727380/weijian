<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operatedemand.css" />
		<style>
			table{
				background-color:#999;
			}
			table td,table th{
				background-color:white;
			}
		</style>
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			function operate_reportMEDetailListToExcel() {
				var year = $("#year").val().trim();
				var month = $("#month").val().trim();
				var projectId = $("#projectId").val().trim();
				var cmdId = $("#cmdId").val().trim();
				var tId = $("#tId").val().trim();
				var teamtype = $("#teamtype").val().trim();
				var type = $("#type").val().trim();
				window.location.href="operate_reportMEDetailListToExcel.html?year="+year+"&month="+month+"&projectId="+projectId+"&cmdId="+cmdId+"&tId="+tId+"&teamtype="+teamtype+"&type="+type;
			}
		</script>
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			<br/><br/>
			<table border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th colspan="24">
						主要材料设备验工计价明细表
					</th>
				</tr>
				<tr>
					<th colspan="24" style="text-align: left;"> 
						<b>项目名称:${projectModel.name}
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${year}年&nbsp;${month}月
						</b>
					</th>
				</tr>
				<input id="year" type="hidden" name="year" value="${year }"/>
				<input id="month" type="hidden" name="month" value="${month }"/>
				<input id="projectId" type="hidden" name="projectId" value="${projectModel.id }"/>
				<input id="cmdId" type="hidden" name="cmdId" value="${cmdId }"/>
				<input id="tId" type="hidden" name="tId" value="${tId }"/>
				<input id="teamtype" type="hidden" name="teamtype" value="${teamtype }"/>
				<input id="type" type="hidden" name="type" value="${type }"/>
				<tr>
					<td rowspan="2">序号</td>
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
					<td style="text-align: left; " colspan="23">
						<c:if test="${type == '2' }">材料费用</c:if>&nbsp;&nbsp;
						<c:if test="${type == '3' }">设备费用</c:if>&nbsp;&nbsp;
						<div><a href="operate_reportMEDetailAdd.html?cmdId=${cmdId }&pId=${pId }&tId=${tId }&teamtype=${teamtype }&type=${type }&year=${year}&month=${month}" style="color:white;">新增</a></div>
						&nbsp;&nbsp;&nbsp;
						<div style="margin-top: 11px;" id="toExcel" onclick="return operate_reportMEDetailListToExcel();">导出EXCEL</div>
						&nbsp;&nbsp;&nbsp;
						<a class="chartadd" href="operate_reportMEDetailDownloadExcel.html" style="color: white; width: 100px;">EXCEL模板下载</a>
						<form action="operate_reportMEDetailImportExcel.html?cmdId=${cmdId }&pId=${pId }&tId=${tId }&type=${type}&teamtype=${teamtype }&year=${year}&month=${month}" method="post" enctype="multipart/form-data" style='display:inline-block'>
							<i class="chartadd" style='position:relative;margin-right:3px'>
								导入Execl
								<input id="excelReportMEDetailInput" name="fileInput" type="file" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0" />
							</i>
							<i class="chartadd" style='position:relative;'>
								提交Execl<input type="submit" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0">
							</i>
						</form>
						<c:if test="${result == '1' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*请保证数据的完整性</span>
						</c:if>
						<c:if test="${result == '2' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*导入的Excel中没有任何数据</span>
						</c:if>
						<c:if test="${result == '3' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*导入的EXCEL模板错误，请下载正确的模板</span>
						</c:if>
					</td>
				</tr>
				<c:forEach items="${userCmdSummDetailVos }" var="userCmdSummDetailVo" varStatus="status">
					<tr>
						<td>${status.index + 1 }</td>
						<c:if test="${type == '2' }">
							<td>${userCmdSummDetailVo.materialModel.name}</td>
						</c:if>
						<c:if test="${type == '3' }">
							<td>${userCmdSummDetailVo.equipmentModel.name}</td>
						</c:if>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.principal}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.cName}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.account}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.unit}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.frequency}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.budget}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.num}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.price}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.subtotal}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.bgpayment}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.receipt}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.cumulative}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.thispay}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.culapay}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.otherpay}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.restpay}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.information}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.invoice}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.settlement}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.using}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.quality}</td>
						<td>${userCmdSummDetailVo.cmdSummSupplierModel.note}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>