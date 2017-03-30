<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operatedemand.css" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			function submitProjectReportForm() {
				var conSearch = $(".consearch").prop("selectedIndex");
				if(!conSearch){
					$('.datehide').show();
				}else{
					$('.datehide').hide();
				}
				if (!conSearch) {
					var searchDate = $("#searchDate").val().trim();
					var monthReg = /^\d{6}$/;
					if (!monthReg.test(searchDate)) {
						alert("请输入正确的月份格式(6位数字，如：201608)");
						return false;
					}
					var monthRegLastTwo = searchDate.substring(4, 6);
					if (monthRegLastTwo != "01" && monthRegLastTwo != "02" && monthRegLastTwo != "03" && monthRegLastTwo != "04" &&
							monthRegLastTwo != "05" && monthRegLastTwo != "06" && monthRegLastTwo != "07" && monthRegLastTwo != "08" &&
							monthRegLastTwo != "09" && monthRegLastTwo != "10" && monthRegLastTwo != "11" && monthRegLastTwo != "12") {
						alert("月份为01到12之间");
						return false;
					}
				}
				document.getElementById('myform').submit();
			}
		</script>
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		
		<div class="title">
			<div class="content">
				<span><a href='<%=basePath%>person.html' style="color: #FFFFFF;">${projectModel.name}</a></span>
			</div>
		</div>
		<div class="content personal">
			
			<table class="groud" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<td>项目名称</td>
					<td>所在区域</td>
					<td>合同价（万）</td>
					<td>预付款（万）</td>
					<td>次数</td>
					<td>单位</td>
					<td>总工程量</td>
					<td>本次工程量</td>
					<td>累计工程量</td>
					<td>累计完成比例(%)</td>
					<td>工程状态</td>
				</tr>
				<tr>
					<td>${projectModel.name }</td>
					<td>${projectModel.provinceChn }${projectModel.cityChn }</td>
					<td>${projectModel.price }</td>
					<td>${projectModel.prepaid }</td>
					<td>${projectModel.times }</td>
					<td>${projectModel.unit }</td>
					<td>${projectModel.allWork }</td>
					<td>${projectModel.thsWork }</td>
					<td>${projectModel.accWork }</td>
					<td>${projectModel.progress }%</td>
					<td>
						<c:if test="${projectModel.status==0 }">未开始</c:if>
						<c:if test="${projectModel.status==1 }">进行中</c:if>
						<c:if test="${projectModel.status==2 }">已完成</c:if>
					</td>
				</tr>
			</table>
			<div class="search">
				查询条件
			</div>
			<form id="myform" action="project_getReport.html?projectId=${projectModel.id }&flag=0&result=0" method="POST">
				<table class="condition" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>报表类型</td>
						<td style="text-align: left;">
							<select class="consearch" name="conSelect">
								<option value="1" <c:if test="${flag == '1' }">selected</c:if>>人工、材料、设备验工计价汇总表</option>
								<option value="2" <c:if test="${flag == '2' }">selected</c:if>>项目花名册</option>
								<option value="3" <c:if test="${flag == '3' }">selected</c:if>>工人花名册</option>
								<option value="4" <c:if test="${flag == '4' }">selected</c:if>>供应商花名册</option>
							</select>
						</td>
						<td class='datehide' style="text-align: right;">日期</td>
						<td class='datehide'>
							<input id="searchDate" type="text" name="searchDate" value="${searchDate }" placeholder="必填(例如：201608)"/>
							<span>例如：201608</span>
						</td>
						<td style="text-align: right;">
							<div id="search" onclick="return submitProjectReportForm();">查询</div>
						</td>
						<td></td>
					</tr>
				</table>
			</form>
			<table id="datesearch">
				
			</table>
			<div class="chartbox" data-flag=${flag }>
				<table class="chart" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<th colspan="16">
							主要人工、材料、机械设备验工计价汇总表
						</th>
					</tr>
					<tr>
						<td style="text-align: left;" colspan="16">项目名称：${projectModel.name}
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${year}年&nbsp;${month}月
						</td>
					</tr>
					<tr>
						<td rowspan="2">序号</td>
						<td rowspan="2">名称</td>
						<td rowspan="2">合同价(万)</td>
						<td rowspan="2">预付款(万)</td>
						<td rowspan="2">次数</td>
						<td colspan="4">工程完成情况</td>
						<td colspan="4">付款情况</td>
						<td rowspan="2">押金(万)</td>
						<td rowspan="2">结算情况</td>
						<td rowspan="2">备注</td>
					</tr>
					<tr>
						<td>单位</td>
						<td>总工程量</td>
						<td>本次工程量</td>
						<td>本次工程量占总量%</td>
						<td>本期付款(万)</td>
						<td>累计付款(万)</td>
						<td>余额(万)</td>
						<td>累计付款占总量%</td>
					</tr>
					<tr>
						<td>一</td>
						<td style="text-align: left;" colspan="16">
							<span class="items">
								&nbsp;&nbsp;<div><a href="project_reportTeamList.html?year=${year}&month=${month}&projectId=${projectModel.id}&type=1&result=0" style="color: white;">人工费</a></div>
							</span>
						</td>
					</tr>
					<tr>
						<td>1</td>
						<td>本班组</td>
						<td>${teamBenCmdSummModel.contractPrice}</td>
						<td>${teamBenCmdSummModel.bgpayment}</td>
						<td>${teamBenCmdSummModel.frequency}</td>
						<td></td>
						<td>${teamBenCmdSummModel.total}</td>
						<td>${teamBenCmdSummModel.nowTotal}</td>
						<td>${teamBenCmdSummModel.percentage}%</td>
						<td>${teamBenCmdSummModel.thispay}</td>
						<td>${teamBenCmdSummModel.culapay}</td>
						<td>${teamBenCmdSummModel.remain}</td>
						<td>${teamBenCmdSummModel.culPercentage}%</td>
						<td>${teamBenCmdSummModel.deposit}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>2</td>
						<td>劳务分包班组</td>
						<td>${teamLaoCmdSummModel.contractPrice}</td>
						<td>${teamLaoCmdSummModel.bgpayment}</td>
						<td>${teamLaoCmdSummModel.frequency}</td>
						<td></td>
						<td>${teamLaoCmdSummModel.total}</td>
						<td>${teamLaoCmdSummModel.nowTotal}</td>
						<td>${teamLaoCmdSummModel.percentage}%</td>
						<td>${teamLaoCmdSummModel.thispay}</td>
						<td>${teamLaoCmdSummModel.culapay}</td>
						<td>${teamLaoCmdSummModel.remain}</td>
						<td>${teamLaoCmdSummModel.culPercentage}%</td>
						<td>${teamLaoCmdSummModel.deposit}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>3</td>
						<td>专业分包班组</td>
						<td>${teamZhuCmdSummModel.contractPrice}</td>
						<td>${teamZhuCmdSummModel.bgpayment}</td>
						<td>${teamZhuCmdSummModel.frequency}</td>
						<td></td>
						<td>${teamZhuCmdSummModel.total}</td>
						<td>${teamZhuCmdSummModel.nowTotal}</td>
						<td>${teamZhuCmdSummModel.percentage}%</td>
						<td>${teamZhuCmdSummModel.thispay}</td>
						<td>${teamZhuCmdSummModel.culapay}</td>
						<td>${teamZhuCmdSummModel.remain}</td>
						<td>${teamZhuCmdSummModel.culPercentage}%</td>
						<td>${teamZhuCmdSummModel.deposit}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td>小计：</td>
						<td>${cmdSummTotalEmployeeModel.contractPrice}</td>
						<td>${cmdSummTotalEmployeeModel.bgpayment}</td>
						<td>${cmdSummTotalEmployeeModel.frequency}</td>
						<td></td>
						<td>${cmdSummTotalEmployeeModel.total}</td>
						<td>${cmdSummTotalEmployeeModel.nowTotal}</td>
						<td>${cmdSummTotalEmployeeModel.percentage}%</td>
						<td>${cmdSummTotalEmployeeModel.thispay}</td>
						<td>${cmdSummTotalEmployeeModel.culapay}</td>
						<td>${cmdSummTotalEmployeeModel.remain}</td>
						<td>${cmdSummTotalEmployeeModel.culPercentage}%</td>
						<td>${cmdSummTotalEmployeeModel.deposit}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>二</td>
						<td style="text-align: left;" colspan="15">
							<span class="items">
								&nbsp;&nbsp;<div><a href="project_reportMaterialList.html?year=${year}&month=${month}&projectId=${projectModel.id}&type=2&result=0" style="color:white;">材料费</a></div>
							</span>
						</td>
					</tr>
					<tr>
						<td>1</td>
						<td>本班组</td>
						<td>${materialBenCmdSummModel.contractPrice}</td>
						<td>${materialBenCmdSummModel.bgpayment}</td>
						<td>${materialBenCmdSummModel.frequency}</td>
						<td></td>
						<td>${materialBenCmdSummModel.total}</td>
						<td>${materialBenCmdSummModel.nowTotal}</td>
						<td>${materialBenCmdSummModel.percentage}%</td>
						<td>${materialBenCmdSummModel.thispay}</td>
						<td>${materialBenCmdSummModel.culapay}</td>
						<td>${materialBenCmdSummModel.remain}</td>
						<td>${materialBenCmdSummModel.culPercentage}%</td>
						<td>${materialBenCmdSummModel.deposit}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>2</td>
						<td>劳务分包班组</td>
						<td>${materialLaoCmdSummModel.contractPrice}</td>
						<td>${materialLaoCmdSummModel.bgpayment}</td>
						<td>${materialLaoCmdSummModel.frequency}</td>
						<td></td>
						<td>${materialLaoCmdSummModel.total}</td>
						<td>${materialLaoCmdSummModel.nowTotal}</td>
						<td>${materialLaoCmdSummModel.percentage}%</td>
						<td>${materialLaoCmdSummModel.thispay}</td>
						<td>${materialLaoCmdSummModel.culapay}</td>
						<td>${materialLaoCmdSummModel.remain}</td>
						<td>${materialLaoCmdSummModel.culPercentage}%</td>
						<td>${materialLaoCmdSummModel.deposit}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>3</td>
						<td>专业分包班组</td>
						<td>${materialZhuCmdSummModel.contractPrice}</td>
						<td>${materialZhuCmdSummModel.bgpayment}</td>
						<td>${materialZhuCmdSummModel.frequency}</td>
						<td>${materialZhuCmdSummModel.unit}</td>
						<td>${materialZhuCmdSummModel.total}</td>
						<td>${materialZhuCmdSummModel.nowTotal}</td>
						<td>${materialZhuCmdSummModel.percentage}%</td>
						<td>${materialZhuCmdSummModel.thispay}</td>
						<td>${materialZhuCmdSummModel.culapay}</td>
						<td>${materialZhuCmdSummModel.remain}</td>
						<td>${materialZhuCmdSummModel.culPercentage}%</td>
						<td>${materialZhuCmdSummModel.deposit}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td>小计：</td>
						<td>${cmdSummTotalMaterialModel.contractPrice}</td>
						<td>${cmdSummTotalMaterialModel.bgpayment}</td>
						<td>${cmdSummTotalMaterialModel.frequency}</td>
						<td></td>
						<td>${cmdSummTotalMaterialModel.total}</td>
						<td>${cmdSummTotalMaterialModel.nowTotal}</td>
						<td>${cmdSummTotalMaterialModel.percentage}%</td>
						<td>${cmdSummTotalMaterialModel.thispay}</td>
						<td>${cmdSummTotalMaterialModel.culapay}</td>
						<td>${cmdSummTotalMaterialModel.remain}</td>
						<td>${cmdSummTotalMaterialModel.culPercentage}%</td>
						<td>${cmdSummTotalMaterialModel.deposit}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>三</td>
						<td style="text-align: left;" colspan="15">
							<span class="items">
								&nbsp;&nbsp;<div><a href="project_reportEquipmentList.html?year=${year}&month=${month}&projectId=${projectModel.id}&type=3&result=0" style="color:white;">设备费</a></div>
							</span>
						</td>
					</tr>
					<tr>
						<td>1</td>
						<td>本班组</td>
						<td>${equipmentBenCmdSummModel.contractPrice}</td>
						<td>${equipmentBenCmdSummModel.bgpayment}</td>
						<td>${equipmentBenCmdSummModel.frequency}</td>
						<td></td>
						<td>${equipmentBenCmdSummModel.total}</td>
						<td>${equipmentBenCmdSummModel.nowTotal}</td>
						<td>${equipmentBenCmdSummModel.percentage}%</td>
						<td>${equipmentBenCmdSummModel.thispay}</td>
						<td>${equipmentBenCmdSummModel.culapay}</td>
						<td>${equipmentBenCmdSummModel.remain}</td>
						<td>${equipmentBenCmdSummModel.culPercentage}%</td>
						<td>${equipmentBenCmdSummModel.deposit}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>2</td>
						<td>劳务分包班组</td>
						<td>${equipmentLaoCmdSummModel.contractPrice}</td>
						<td>${equipmentLaoCmdSummModel.bgpayment}</td>
						<td>${equipmentLaoCmdSummModel.frequency}</td>
						<td></td>
						<td>${equipmentLaoCmdSummModel.total}</td>
						<td>${equipmentLaoCmdSummModel.nowTotal}</td>
						<td>${equipmentLaoCmdSummModel.percentage}%</td>
						<td>${equipmentLaoCmdSummModel.thispay}</td>
						<td>${equipmentLaoCmdSummModel.culapay}</td>
						<td>${equipmentLaoCmdSummModel.remain}</td>
						<td>${equipmentLaoCmdSummModel.culPercentage}%</td>
						<td>${equipmentLaoCmdSummModel.deposit}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>3</td>
						<td>专业分包班组</td>
						<td>${equipmentZhuCmdSummModel.contractPrice}</td>
						<td>${equipmentZhuCmdSummModel.bgpayment}</td>
						<td>${equipmentZhuCmdSummModel.frequency}</td>
						<td></td>
						<td>${equipmentZhuCmdSummModel.total}</td>
						<td>${equipmentZhuCmdSummModel.nowTotal}</td>
						<td>${equipmentZhuCmdSummModel.percentage}%</td>
						<td>${equipmentZhuCmdSummModel.thispay}</td>
						<td>${equipmentZhuCmdSummModel.culapay}</td>
						<td>${equipmentZhuCmdSummModel.remain}</td>
						<td>${equipmentZhuCmdSummModel.culPercentage}%</td>
						<td>${equipmentZhuCmdSummModel.deposit}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td>小计：</td>
						<td>${cmdSummTotalEquipmentModel.contractPrice}</td>
						<td>${cmdSummTotalEquipmentModel.bgpayment}</td>
						<td>${cmdSummTotalEquipmentModel.frequency}</td>
						<td></td>
						<td>${cmdSummTotalEquipmentModel.total}</td>
						<td>${cmdSummTotalEquipmentModel.nowTotal}</td>
						<td>${cmdSummTotalEquipmentModel.percentage}%</td>
						<td>${cmdSummTotalEquipmentModel.thispay}</td>
						<td>${cmdSummTotalEquipmentModel.culapay}</td>
						<td>${cmdSummTotalEquipmentModel.remain}</td>
						<td>${cmdSummTotalEquipmentModel.culPercentage}%</td>
						<td>${cmdSummTotalEquipmentModel.deposit}</td>
						<td></td>
						<td></td>
					</tr>
				</table>
				<div class="closed">关闭</div>
			</div>
			<div class="chartboxtwo" data-flag=${flag }>
				<div class="chartadd"><a href="project_posterProjectAdd.html?projectId=${projectModel.id }&flag=${flag }" style="color: white;">新增</a></div>
				<a class='chartadd' href="project_posterProjectDownloadExcel.html" style="color: white; width: 100px;">EXCEL模板下载</a>
				<form action="project_posterProjectImportExcel.html?projectId=${projectModel.id }&flag=${flag }" method="post" enctype="multipart/form-data" style='display:inline-block'>
					<i class="chartadd" style='position:relative;margin-right:3px'>
						导入Execl
						<input id="excelRosterProjectInput" name="fileInput" type="file" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0" />
					</i>
					<i class="chartadd" style='position:relative;'>
						提交Execl<input type="submit" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0">
					</i>
				</form>
				<c:if test="${result == '1' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*请保证数据的完整性</span>
				</c:if>
				<c:if test="${result == '2' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*请保证身份证号或者手机号数据的正确性</span>
				</c:if>
				<c:if test="${result == '3' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*某身份证号或者手机号已经注册</span>
				</c:if>
				<c:if test="${result == '4' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*导入的EXCEL中没有任何数据</span>
				</c:if>
				<c:if test="${result == '5' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*导入的EXCEL模板错误，请下载正确的模板</span>
				</c:if>
				<table class="chart" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<th colspan="8">项目花名册</th>
					</tr>
					<tr>
						<td>项目名称:</td>
						<td colspan="7">${projectModel.name }</td>
					</tr>
					<tr>
						<td>序号</td>
						<td>姓名</td>
						<td>性别</td>
						<td>职位</td>
						<td>身份证号</td>
						<td>住址</td>
						<td>联系方式</td>
					</tr>
					<c:forEach items="${projectRosterModels }" var="projectRosterModel" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<td>${projectRosterModel.name }</td>
							<td>
								<c:if test="${projectRosterModel.sex == 1 }">男</c:if>
								<c:if test="${projectRosterModel.sex == 2 }">女</c:if>
							</td>
							<td>${projectRosterModel.position }</td>
							<td>${projectRosterModel.identity }</td>
							<td>${projectRosterModel.address }</td>
							<td>${projectRosterModel.phone }</td>
						</tr>
					</c:forEach>
				</table>
				<form action="project_getReport.html?projectId=${projectModel.id }&flag=${flag }&result=0" method="post">
					<div class="tabfooter">
						<div class="footerl">
							<span>每页：</span>
							<input type="text" value="${page.pageSize }" name="pageSizeTotal" style="width:30px"/>
							<span>条,第</span><!-- 这里最好做个输入的数据不能超过记录的总数处于一页显示的条数AJAX，暂时没有做 -->
							<input type="text" value="${page.pageNow}" name="pageNowSelect" style="width:30px"/>
							<span>页</span>
							<button style="color: blue;">[确定]</button>
							<span>共有</span>
							<span class="footernum">${page.dataCount}</span>
							<span>条记录，当前是第</span><span>${page.pageNow}</span><span>页</span>&nbsp;&nbsp;&nbsp;&nbsp;
							<c:if test="${page.pageNow == 1}">[首页]&nbsp;&nbsp;&nbsp;&nbsp;[上一页]&nbsp;</c:if>
							<c:if test="${page.pageNow != 1}">
								<button value="1" name="pageNowFirst" style="color: blue;">[首页]</button>
								<button value="${page.prePage}" name="pageNowPre" style="color: blue;">[上一页]</button>
							</c:if>
							<c:if test="${page.pageNow == page.lastPage}">&nbsp;[下一页]&nbsp;&nbsp;&nbsp;&nbsp;[尾页]</c:if>
							<c:if test="${page.pageNow != page.lastPage}">
								<button value="${page.nextPage}" name="pageNowNext" style="color: blue;">[下一页]</button>
								<button value="${page.lastPage}" name="pageNowLast" style="color: blue;">[尾页]</button>
							</c:if>
						</div>
					</div>
				</form>
				<div class="closed">关闭</div>
			</div>
			<div class="chartboxthree" data-flag=${flag }>
				<div class="chartadd"><a href="project_posterUserAdd.html?projectId=${projectModel.id }&flag=${flag }" style="color: white;">新增</a></div>
				<a class='chartadd' href="project_posterUserDownloadExcel.html" style="color: white; width: 100px;">EXCEL模板下载</a>
				<form action="project_posterUserImportExcel.html?projectId=${projectModel.id }&flag=${flag }" method="post" enctype="multipart/form-data" style='display:inline-block'>
					<i class="chartadd" style='position:relative;margin-right:3px'>
						导入Execl
						<input id="excelRosterUserInput" name="fileInput" type="file" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0" />
					</i>
					<i class="chartadd" style='position:relative;'>
						提交Execl<input type="submit" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0">
					</i>
				</form>
				<c:if test="${result == '1' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*请保证数据的完整性</span>
				</c:if>
				<c:if test="${result == '2' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*输入的某个班组名称不存在</span>
				</c:if>
				<c:if test="${result == '3' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*输入的某个班组名称与当前项目没有关系</span>
				</c:if>
				<c:if test="${result == '4' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*请保证身份证号或者手机号数据的正确性</span>
				</c:if>
				<c:if test="${result == '5' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*某身份证号或者手机号已经注册</span>
				</c:if>
				<c:if test="${result == '6' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*导入的Excel中没有任何数据</span>
				</c:if>
				<c:if test="${result == '7' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*导入的EXCEL模板错误，请下载正确的模板</span>
				</c:if>
				<table class="chart" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<th colspan="9">工人花名册</th>
					</tr>
					<tr>
						<td>项目名称:</td>
						<td colspan="8">${projectModel.name }</td>
					</tr>
					<tr>
						<td>序号</td>
						<td>班组名称</td>
						<td>姓名</td>
						<td>性别</td>
						<td>技术类别</td>
						<td>技术类型</td>
						<td>身份证号</td>
						<td>住址</td>
						<td>联系方式</td>
					</tr>
					<c:forEach items="${showUserTeamRosterVos }" var="showUserTeamRosterVo" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<td>${showUserTeamRosterVo.name }</td>
							<td>${showUserTeamRosterVo.userModel.userName }</td>
							<td>
								<c:if test="${showUserTeamRosterVo.userModel.userSex == '1'}">男</c:if>
								<c:if test="${showUserTeamRosterVo.userModel.userSex == '2'}">女</c:if>
							</td>
							<td>${showUserTeamRosterVo.userModel.skillBigTypeName }</td>
							<td>${showUserTeamRosterVo.userModel.skillSmallTypeName }</td>
							<td>${showUserTeamRosterVo.userModel.userIdentity }</td>
							<td>${showUserTeamRosterVo.userModel.userProvinceStr }${showUserTeamRosterVo.userModel.userCityStr }${showUserTeamRosterVo.userModel.userStreetStr }</td>
							<td>${showUserTeamRosterVo.userModel.userId }</td>
						</tr>
					</c:forEach>
				</table>
				<form action="project_getReport.html?projectId=${projectModel.id }&flag=${flag }&result=0" method="post">
					<div class="tabfooter">
						<div class="footerl">
							<span>每页：</span>
							<input type="text" value="${page.pageSize }" name="pageSizeTotal" style="width:30px"/>
							<span>条,第</span>
							<input type="text" value="${page.pageNow}" name="pageNowSelect" style="width:30px"/>
							<span>页</span>
							<button style="color: blue;">[确定]</button>
							<span>共有</span>
							<span class="footernum">${page.dataCount}</span>
							<span>条记录，当前是第</span><span>${page.pageNow}</span><span>页</span>&nbsp;&nbsp;&nbsp;&nbsp;
							<c:if test="${page.pageNow == 1}">[首页]&nbsp;&nbsp;&nbsp;&nbsp;[上一页]&nbsp;</c:if>
							<c:if test="${page.pageNow != 1}">
								<button value="1" name="pageNowFirst" style="color: blue;">[首页]</button>
								<button value="${page.prePage}" name="pageNowPre" style="color: blue;">[上一页]</button>
							</c:if>
							<c:if test="${page.pageNow == page.lastPage}">&nbsp;[下一页]&nbsp;&nbsp;&nbsp;&nbsp;[尾页]</c:if>
							<c:if test="${page.pageNow != page.lastPage}">
								<button value="${page.nextPage}" name="pageNowNext" style="color: blue;">[下一页]</button>
								<button value="${page.lastPage}" name="pageNowLast" style="color: blue;">[尾页]</button>
							</c:if>
						</div>
					</div>
				</form>
				<div class="closed">关闭</div>
			</div>
			<div class="chartboxfour" data-flag=${flag }>
				<div class="chartadd"><a href="project_posterMEAdd.html?projectId=${projectModel.id }&flag=${flag }" style="color: white;">新增</a></div>
				<a class="chartadd" href="project_posterMEDownloadExcel.html" style="color: white; width: 100px;">EXCEL模板下载</a>
				<form action="project_posterMEImportExcel.html?projectId=${projectModel.id }&flag=${flag }" method="post" enctype="multipart/form-data" style='display:inline-block'>
					<i class="chartadd" style='position:relative;margin-right:3px'>
						导入Execl
						<input id="excelRosterMEInput" name="fileInput" type="file" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0" />
					</i>
					<i class="chartadd" style='position:relative;'>
						提交Execl<input type="submit" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0">
					</i>
				</form>
				<c:if test="${result == '1' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*请保证数据的完整性</span>
				</c:if>
				<c:if test="${result == '2' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*某个材料商或设备商的机构代码已经注册</span>
				</c:if>
				<c:if test="${result == '3' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*请保手机号数据的正确性</span>
				</c:if>
				<c:if test="${result == '4' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*某个手机号已经注册</span>
				</c:if>
				<c:if test="${result == '5' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*导入的Excel中没有任何数据</span>
				</c:if>
				<c:if test="${result == '6' }">
					<span style="color: red; text-align: center;">导入失败&nbsp;&nbsp;&nbsp;*导入的EXCEL模板错误，请下载正确的模板</span>
				</c:if>
				<table class="chart" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<th colspan="5">供应商花名册</th>
					</tr>
					<tr>
						<td>项目名称:</td>
						<td colspan="4">${projectModel.name }</td>
					</tr>
					<tr>
						<td>序号</td>
						<td>供应商名称</td>
						<td>住址</td>
						<td>联系人</td>
						<td>联系方式</td>
					</tr>
					<c:forEach items="${showMERosterVos }" var="showMERosterVo" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<c:if test="${showMERosterVo.type == 2 }">
								<td>${showMERosterVo.materialModel.name }</td>
								<td>${showMERosterVo.materialModel.provinceChn }${showMERosterVo.materialModel.cityChn }${showMERosterVo.materialModel.street }</td>
								<td>${showMERosterVo.materialModel.leaderName }</td>
								<td>${showMERosterVo.materialModel.userId }</td>
							</c:if>
							<c:if test="${showMERosterVo.type == 3 }">
								<td>${showMERosterVo.equipmentModel.name }</td>
								<td>${showMERosterVo.equipmentModel.provinceChn }${showMERosterVo.equipmentModel.cityChn }${showMERosterVo.equipmentModel.street }</td>
								<td>${showMERosterVo.equipmentModel.leaderName }</td>
								<td>${showMERosterVo.equipmentModel.userId }</td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
				<form action="project_getReport.html?projectId=${projectModel.id }&flag=${flag }&result=0" method="post">
					<div class="tabfooter">
						<div class="footerl">
							<span>每页：</span>
							<input type="text" value="${page.pageSize }" name="pageSizeTotal" style="width:30px"/>
							<span>条,第</span>
							<input type="text" value="${page.pageNow}" name="pageNowSelect" style="width:30px"/>
							<span>页</span>
							<button style="color: blue;">[确定]</button>
							<span>共有</span>
							<span class="footernum">${page.dataCount}</span>
							<span>条记录，当前是第</span><span>${page.pageNow}</span><span>页</span>&nbsp;&nbsp;&nbsp;&nbsp;
							<c:if test="${page.pageNow == 1}">[首页]&nbsp;&nbsp;&nbsp;&nbsp;[上一页]&nbsp;</c:if>
							<c:if test="${page.pageNow != 1}">
								<button value="1" name="pageNowFirst" style="color: blue;">[首页]</button>
								<button value="${page.prePage}" name="pageNowPre" style="color: blue;">[上一页]</button>
							</c:if>
							<c:if test="${page.pageNow == page.lastPage}">&nbsp;[下一页]&nbsp;&nbsp;&nbsp;&nbsp;[尾页]</c:if>
							<c:if test="${page.pageNow != page.lastPage}">
								<button value="${page.nextPage}" name="pageNowNext" style="color: blue;">[下一页]</button>
								<button value="${page.lastPage}" name="pageNowLast" style="color: blue;">[尾页]</button>
							</c:if>
						</div>
					</div>
				</form>
				<div class="closed">关闭</div>
			</div>
		</div>
		
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/front_company/projectchart.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>