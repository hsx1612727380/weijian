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
			function operate_reportTeamDetailListToExcel() {
				var year = $("#year").val().trim();
				var month = $("#month").val().trim();
				var projectId = $("#projectId").val().trim();
				var tId = $("#tId").val().trim();
				var cmdId = $("#cmdId").val().trim();
				var teamtype = $("#teamtype").val().trim();
				window.location.href="operate_reportTeamDetailListToExcel.html?year="+year+"&month="+month+"&projectId="+projectId+"&tId="+tId+"&cmdId="+cmdId+"&teamtype="+teamtype;
			}
		</script>
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			
			<table border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th colspan="18">
						主要人工验工计价明细表
					</th>
				</tr>
				<tr>
					<th colspan="18" style="text-align: left;"> 
						<b>项目名称:${projectModel.name}
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${year}年&nbsp;${month}月
						</b>
					</th>
				</tr>
				<input id="year" type="hidden" name="year" value="${year }"/>
				<input id="month" type="hidden" name="month" value="${month }"/>
				<input id="projectId" type="hidden" name="projectId" value="${projectModel.id }"/>
				<input id="tId" type="hidden" name="tId" value="${tId }"/>
				<input id="cmdId" type="hidden" name="cmdId" value="${cmdId }"/>
				<input id="teamtype" type="hidden" name="teamtype" value="${teamtype }"/>
				<tr>
					<td rowspan="2">序号</td>
					<td rowspan="2">名称</td>
					<td rowspan="2">身份证号码</td>
					<td rowspan="2">支付账号</td>
					<td rowspan="2">支付凭证</td>
					<td rowspan="2">进场时间</td>
					<td rowspan="2">是否安全教育</td>
					<td rowspan="2">退场时间</td>
					<td rowspan="2">出入记录</td>
					<td rowspan="2">考勤记录</td>
					<td rowspan="2">工作内容</td>
					<td rowspan="2">次数</td>
					<td colspan="4">付款</td>
					<td rowspan="2">签名指纹</td>
					<td rowspan="2">备注</td>
				</tr>
				<tr>
					<td>应发工资</td>
					<td>扣款</td>
					<td>实发工资</td>
					<td>未付工资</td>
				</tr>
				<tr>
					<td>一</td>
					<td style="text-align: left;" colspan="17">
						人工费用&nbsp;&nbsp;
						<div><a href="operate_reportTeamDetailAdd.html?cmdId=${cmdId }&pId=${pId }&tId=${tId }&teamtype=${teamtype }&year=${year}&month=${month}" style="color:white;">新增</a></div>
						&nbsp;&nbsp;&nbsp;
						<div style="margin-top: 11px;" id="toExcel" onclick="return operate_reportTeamDetailListToExcel();">导出EXCEL</div>
						&nbsp;&nbsp;&nbsp;
						<a class="chartadd" href="operate_reportTeamDetailDownloadExcel.html" style="color: white; width: 100px;">EXCEL模板下载</a>
						<form action="operate_reportTeamDetailImportExcel.html?cmdId=${cmdId }&pId=${pId }&tId=${tId }&teamtype=${teamtype }&flag=1&year=${year}&month=${month}" method="post" enctype="multipart/form-data" style='display:inline-block'>
							<i class="chartadd" style='position:relative;margin-right:3px'>
								导入Execl
								<input id="excelReportTeamDetailInput" name="fileInput" type="file" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0" />
							</i>
							<i class="chartadd" style='position:relative;'>
								提交Execl<input type="submit" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0">
							</i>
						</form>
						<c:if test="${result == '1' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*请保证数据的完整性</span>
						</c:if>
						<c:if test="${result == '2' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*某工人的身份证填写不正确</span>
						</c:if>
						<c:if test="${result == '3' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*某工人不存在</span>
						</c:if>
						<c:if test="${result == '4' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*某个施工班组名称不存在</span>
						</c:if>
						<c:if test="${result == '5' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*某工人该项目下的这个月的数据已经存在</span>
						</c:if>
						<c:if test="${result == '6' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*请保证日期格式的正确性</span>
						</c:if>
						<c:if test="${result == '7' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*导入的Excel中没有任何数据</span>
						</c:if>
						<c:if test="${result == '8' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*导入的EXCEL模板错误，请下载正确的模板</span>
						</c:if>
					</td>
				</tr>
				<c:forEach items="${userCmdSummDetailVos }" var="userCmdSummDetailVo" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${userCmdSummDetailVo.userModel.userName}</td>
						<td>${userCmdSummDetailVo.userModel.userIdentity}</td>
						<td>${userCmdSummDetailVo.cmdSummPersonModel.account}</td>
						<td>${userCmdSummDetailVo.cmdSummPersonModel.voucher}</td>
						<td>${userCmdSummDetailVo.cmdSummPersonModel.inTime}</td>
						<td>${userCmdSummDetailVo.cmdSummPersonModel.safe}</td>
						<td>${userCmdSummDetailVo.cmdSummPersonModel.outTime}</td>
						<td>${userCmdSummDetailVo.cmdSummPersonModel.access}</td>
						<td>${userCmdSummDetailVo.cmdSummPersonModel.attendance}</td>
						<td>${userCmdSummDetailVo.cmdSummPersonModel.workContent}</td>
						<td>${userCmdSummDetailVo.cmdSummPersonModel.count}</td>
						<td>${userCmdSummDetailVo.cmdSummPersonModel.salary}</td>
						<td>${userCmdSummDetailVo.cmdSummPersonModel.deduct}</td>
						<td>${userCmdSummDetailVo.cmdSummPersonModel.realSalary}</td>
						<td>${userCmdSummDetailVo.cmdSummPersonModel.noSalary}</td>
						<td>${userCmdSummDetailVo.cmdSummPersonModel.flag}</td>
						<td>${userCmdSummDetailVo.cmdSummPersonModel.note}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>