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
			function operate_reportBenEquipmentListToExcel() {
				var year = $("#year").val().trim();
				var month = $("#month").val().trim();
				var projectId = $("#projectId").val().trim();
				window.location.href="operate_reportBenEquipmentListToExcel.html?year="+year+"&month="+month+"&projectId="+projectId;
			}
			function operate_reportLaoEquipmentListToExcel() {
				var year = $("#year").val().trim();
				var month = $("#month").val().trim();
				var projectId = $("#projectId").val().trim();
				window.location.href="operate_reportLaoEquipmentListToExcel.html?year="+year+"&month="+month+"&projectId="+projectId;
			}
			function operate_reportZhuEquipmentListToExcel() {
				var year = $("#year").val().trim();
				var month = $("#month").val().trim();
				var projectId = $("#projectId").val().trim();
				window.location.href="operate_reportZhuEquipmentListToExcel.html?year="+year+"&month="+month+"&projectId="+projectId;
			}
		</script>
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			
			<table id="datesearch">
				
			</table>
			<table border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th colspan="20">
						主要设备费验工计价汇总表
					</th>
				</tr>
				<tr>
					<td colspan="20" style="text-align: left;"> 
						<b>项目名称:${projectModel.name}
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${year}年&nbsp;${month}月
						</b>
					</td>
				</tr>
				<input id="year" type="hidden" name="year" value="${year }"/>
				<input id="month" type="hidden" name="month" value="${month }"/>
				<input id="projectId" type="hidden" name="projectId" value="${projectModel.id }"/>
				<tr>
					<td rowspan="2">序号</td>
					<td rowspan="2">供应商</td>
					<td rowspan="2">委托/经办人</td>
					<td rowspan="2">支付帐号及凭证</td>
					<td rowspan="2">单位</td>
					<td rowspan="2">次数</td>
					<td rowspan="2">预算量</td>
					<td colspan="3">合同价</td>
					<td rowspan="2">预付款</td>
					<td colspan="2">入口量</td>
					<td colspan="4">付款情况</td>
					<td rowspan="2">结算情况</td>
					<td rowspan="2">发票情况</td>
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
					<td>其他款</td>
					<td>余款</td>
				</tr>
				<tr>
					<td>一</td>
					<td style="text-align: left;" colspan="20">
						&nbsp;&nbsp;本班组设备费&nbsp;&nbsp;&nbsp;
						<span class="items">
							<div><a href="operate_reportMEAdd.html?projectId=${projectModel.id }&teamtype=1&type=3" style="color:white;">新增</a></div>
							&nbsp;&nbsp;&nbsp;
							<div style="margin-top: 11px;" id="toExcel" onclick="return operate_reportBenEquipmentListToExcel();">导出EXCEL</div>
							&nbsp;&nbsp;&nbsp;
							<a class="chartadd" href="operate_reportMEDownloadExcel.html" style="color: white; width: 100px;">EXCEL模板下载</a>
							<form action="operate_reportMEImportExcel.html?projectId=${projectModel.id }&flag=1&year=${year}&month=${month}&teamtype=1&type=3" method="post" enctype="multipart/form-data" style='display:inline-block'>
								<i class="chartadd" style='position:relative;margin-right:3px'>
									导入Execl
									<input id="excelReportMEInput" name="fileInput" type="file" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0" />
								</i>
								<i class="chartadd" style='position:relative;'>
									提交Execl<input type="submit" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0">
								</i>
							</form>
							<c:if test="${result == '11' }">
								<span style="color: red; text-align: center;">导入失败&nbsp;*请保证数据的完整性</span>
							</c:if>
							<c:if test="${result == '12' }">
								<span style="color: red; text-align: center;">导入失败&nbsp;*某个材料商名称不存在</span>
							</c:if>
							<c:if test="${result == '13' }">
								<span style="color: red; text-align: center;">导入失败&nbsp;*某材料商在该项目下的这个月的数据已经存在</span>
							</c:if>
							<c:if test="${result == '14' }">
								<span style="color: red; text-align: center;">导入失败&nbsp;*导入的Excel中没有任何数据</span>
							</c:if>
							<c:if test="${result == '15' }">
								<span style="color: red; text-align: center;">导入失败&nbsp;*导入的EXCEL模板错误，请下载正确的模板</span>
							</c:if>
						</span>
					</td>
				</tr>
				<c:forEach items="${benCmdSummModels}" var="benCmdSummModel" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td><a href="operate_reportMEDetailList.html?projectId=${projectModel.id }&cmdId=${benCmdSummModel.id}&tId=${benCmdSummModel.tId}&teamtype=1&type=3&year=${year}&month=${month}&result=0" style="color:orange">${benCmdSummModel.tName}</a></td>
						<td>${benCmdSummModel.principal}</td>
						<td>${benCmdSummModel.account}</td>
						<td>${benCmdSummModel.unit}</td>
						<td>${benCmdSummModel.frequency}</td>
						<td>${benCmdSummModel.budget}</td>
						<td>${benCmdSummModel.num}</td>
						<td>${benCmdSummModel.price}</td>
						<td>${benCmdSummModel.subtotal}</td>
						<td>${benCmdSummModel.bgpayment}</td>
						<td>${benCmdSummModel.receipt}</td>
						<td>${benCmdSummModel.cumulative}</td>
						<td>${benCmdSummModel.thispay}</td>
						<td>${benCmdSummModel.culapay}</td>
						<td>${benCmdSummModel.otherpay}</td>
						<td>${benCmdSummModel.restpay}</td>
						<td>${benCmdSummModel.settlement}</td>
						<td>${benCmdSummModel.invoice }</td>
						<td>${benCmdSummModel.note}</td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td><b>小计：</b></td>
					<!-- <td>principal</td>
					<td>account</td> 
					<td>${benTotalCmdSummModel.unit}</td> -->
					<td></td>
					<td></td>
					<td></td>
					<td>${benTotalCmdSummModel.frequency}</td>
					<td>${benTotalCmdSummModel.budget}</td>
					<td>${benTotalCmdSummModel.num}</td>
					<td>${benTotalCmdSummModel.price}</td>
					<td>${benTotalCmdSummModel.subtotal}</td>
					<td>${benTotalCmdSummModel.bgpayment}</td>
					<td>${benTotalCmdSummModel.receipt}</td>
					<td>${benTotalCmdSummModel.cumulative}</td>
					<td>${benTotalCmdSummModel.thispay}</td>
					<td>${benTotalCmdSummModel.culapay}</td>
					<td>${benTotalCmdSummModel.otherpay}</td>
					<td>${benTotalCmdSummModel.restpay}</td>
					<%-- <td>${benTotalCmdSummModel.settlement}</td>
					<td>${benTotalCmdSummModel.invoice }</td>
					<td>${benTotalCmdSummModel.note}</td> --%>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>二</td>
					<td style="text-align: left;" colspan="20">
						劳务班组设备费&nbsp;
						<span class="items">
							<div><a href="operate_reportMEAdd.html?projectId=${projectModel.id }&teamtype=2&type=3" style="color:white;">新增</a></div>
							&nbsp;&nbsp;&nbsp;
							<div style="margin-top: 11px;" id="toExcel" onclick="return operate_reportLaoEquipmentListToExcel();">导出EXCEL</div>
							&nbsp;&nbsp;&nbsp;
							<a class="chartadd" href="operate_reportMEDownloadExcel.html" style="color: white; width: 100px;">EXCEL模板下载</a>
							<form action="operate_reportMEImportExcel.html?projectId=${projectModel.id }&flag=1&year=${year}&month=${month}&teamtype=2&type=3" method="post" enctype="multipart/form-data" style='display:inline-block'>
								<i class="chartadd" style='position:relative;margin-right:3px'>
									导入Execl
									<input id="excelReportMEInput" name="fileInput" type="file" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0" />
								</i>
								<i class="chartadd" style='position:relative;'>
									提交Execl<input type="submit" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0">
								</i>
							</form>
							<c:if test="${result == '21' }">
								<span style="color: red; text-align: center;">导入失败&nbsp;*请保证数据的完整性</span>
							</c:if>
							<c:if test="${result == '22' }">
								<span style="color: red; text-align: center;">导入失败&nbsp;*某个材料商名称不存在</span>
							</c:if>
							<c:if test="${result == '23' }">
								<span style="color: red; text-align: center;">导入失败&nbsp;*某材料商在该项目下的这个月的数据已经存在</span>
							</c:if>
							<c:if test="${result == '24' }">
								<span style="color: red; text-align: center;">导入失败&nbsp;*导入的Excel中没有任何数据</span>
							</c:if>
							<c:if test="${result == '25' }">
								<span style="color: red; text-align: center;">导入失败&nbsp;*导入的EXCEL模板错误，请下载正确的模板</span>
							</c:if>
						</span>
					</td>
				</tr>
				<c:forEach items="${laoCmdSummModels}" var="laoCmdSummModel" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td><a href="operate_reportMEDetailList.html?projectId=${projectModel.id }&cmdId=${laoCmdSummModel.id}&tId=${laoCmdSummModel.tId}&teamtype=2&type=3&year=${year}&month=${month}&result=0" style="color:green">${laoCmdSummModel.tName}</a></td>
						<td>${laoCmdSummModel.principal}</td>
						<td>${laoCmdSummModel.account}</td>
						<td>${laoCmdSummModel.unit}</td>
						<td>${laoCmdSummModel.frequency}</td>
						<td>${laoCmdSummModel.budget}</td>
						<td>${laoCmdSummModel.num}</td>
						<td>${laoCmdSummModel.price}</td>
						<td>${laoCmdSummModel.subtotal}</td>
						<td>${laoCmdSummModel.bgpayment}</td>
						<td>${laoCmdSummModel.receipt}</td>
						<td>${laoCmdSummModel.cumulative}</td>
						<td>${laoCmdSummModel.thispay}</td>
						<td>${laoCmdSummModel.culapay}</td>
						<td>${laoCmdSummModel.otherpay}</td>
						<td>${laoCmdSummModel.restpay}</td>
						<td>${laoCmdSummModel.settlement}</td>
						<td>${laoCmdSummModel.invoice }</td>
						<td>${laoCmdSummModel.note}</td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td><b>小计：</b></td>
					<!-- <td>principal</td>
					<td>account</td> 
					<td>${laoTotalCmdSummModel.unit}</td> -->
					<td></td>
					<td></td>
					<td></td>
					<td>${laoTotalCmdSummModel.frequency}</td>
					<td>${laoTotalCmdSummModel.budget}</td>
					<td>${laoTotalCmdSummModel.num}</td>
					<td>${laoTotalCmdSummModel.price}</td>
					<td>${laoTotalCmdSummModel.subtotal}</td>
					<td>${laoTotalCmdSummModel.bgpayment}</td>
					<td>${laoTotalCmdSummModel.receipt}</td>
					<td>${laoTotalCmdSummModel.cumulative}</td>
					<td>${laoTotalCmdSummModel.thispay}</td>
					<td>${laoTotalCmdSummModel.culapay}</td>
					<td>${laoTotalCmdSummModel.otherpay}</td>
					<td>${laoTotalCmdSummModel.restpay}</td>
					<%-- <td>${laoTotalCmdSummModel.settlement}</td>
					<td>${laoTotalCmdSummModel.invoice }</td>
					<td>${laoTotalCmdSummModel.note}</td> --%>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>三</td>
					<td style="text-align: left;" colspan="20">
						专业班组设备费&nbsp;
						<span class="items">
							<div><a href="operate_reportMEAdd.html?projectId=${projectModel.id }&teamtype=3&type=3" style="color:white;">新增</a></div>
							&nbsp;&nbsp;&nbsp;
							<div style="margin-top: 11px;" id="toExcel" onclick="return operate_reportZhuEquipmentListToExcel();">导出EXCEL</div>
							&nbsp;&nbsp;&nbsp;
							<a class="chartadd" href="operate_reportMEDownloadExcel.html" style="color: white; width: 100px;">EXCEL模板下载</a>
							<form action="operate_reportMEImportExcel.html?projectId=${projectModel.id }&flag=1&year=${year}&month=${month}&teamtype=3&type=3" method="post" enctype="multipart/form-data" style='display:inline-block'>
								<i class="chartadd" style='position:relative;margin-right:3px'>
									导入Execl
									<input id="excelReportMEInput" name="fileInput" type="file" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0" />
								</i>
								<i class="chartadd" style='position:relative;'>
									提交Execl<input type="submit" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0">
								</i>
							</form>
							<c:if test="${result == '31' }">
								<span style="color: red; text-align: center;">导入失败&nbsp;*请保证数据的完整性</span>
							</c:if>
							<c:if test="${result == '32' }">
								<span style="color: red; text-align: center;">导入失败&nbsp;*某个材料商名称不存在</span>
							</c:if>
							<c:if test="${result == '33' }">
								<span style="color: red; text-align: center;">导入失败&nbsp;*某材料商在该项目下的这个月的数据已经存在</span>
							</c:if>
							<c:if test="${result == '34' }">
								<span style="color: red; text-align: center;">导入失败&nbsp;*导入的Excel中没有任何数据</span>
							</c:if>
							<c:if test="${result == '35' }">
								<span style="color: red; text-align: center;">导入失败&nbsp;*导入的EXCEL模板错误，请下载正确的模板</span>
							</c:if>
						</span>
					</td>
				</tr>
				<c:forEach items="${zhuCmdSummModels}" var="zhuCmdSummModel" varStatus="status"> 
					<tr>
						<td>${status.index + 1}</td>
						<td><a href="operate_reportMEDetailList.html?projectId=${projectModel.id }&cmdId=${zhuCmdSummModel.id}&tId=${zhuCmdSummModel.tId}&teamtype=3&type=3&year=${year}&month=${month}&result=0" style="color:red">${zhuCmdSummModel.tName}</a></td>
						<td>${zhuCmdSummModel.principal}</td>
						<td>${zhuCmdSummModel.account}</td>
						<td>${zhuCmdSummModel.unit}</td>
						<td>${zhuCmdSummModel.frequency}</td>
						<td>${zhuCmdSummModel.budget}</td>
						<td>${zhuCmdSummModel.num}</td>
						<td>${zhuCmdSummModel.price}</td>
						<td>${zhuCmdSummModel.subtotal}</td>
						<td>${zhuCmdSummModel.bgpayment}</td>
						<td>${zhuCmdSummModel.receipt}</td>
						<td>${zhuCmdSummModel.cumulative}</td>
						<td>${zhuCmdSummModel.thispay}</td>
						<td>${zhuCmdSummModel.culapay}</td>
						<td>${zhuCmdSummModel.otherpay}</td>
						<td>${zhuCmdSummModel.restpay}</td>
						<td>${zhuCmdSummModel.settlement}</td>
						<td>${zhuCmdSummModel.invoice }</td>
						<td>${zhuCmdSummModel.note}</td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td><b>小计：</b></td>
					<!-- <td>principal</td>
					<td>account</td> 
					<td>${zhuTotalCmdSummModel.unit}</td> -->
					<td></td>
					<td></td>
					<td></td>
					<td>${zhuTotalCmdSummModel.frequency}</td>
					<td>${zhuTotalCmdSummModel.budget}</td>
					<td>${zhuTotalCmdSummModel.num}</td>
					<td>${zhuTotalCmdSummModel.price}</td>
					<td>${zhuTotalCmdSummModel.subtotal}</td>
					<td>${zhuTotalCmdSummModel.bgpayment}</td>
					<td>${zhuTotalCmdSummModel.receipt}</td>
					<td>${zhuTotalCmdSummModel.cumulative}</td>
					<td>${zhuTotalCmdSummModel.thispay}</td>
					<td>${zhuTotalCmdSummModel.culapay}</td>
					<td>${zhuTotalCmdSummModel.otherpay}</td>
					<td>${zhuTotalCmdSummModel.restpay}</td>
					<%-- <td>${zhuTotalCmdSummModel.settlement}</td>
					<td>${zhuTotalCmdSummModel.invoice }</td>
					<td>${zhuTotalCmdSummModel.note}</td> --%>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>