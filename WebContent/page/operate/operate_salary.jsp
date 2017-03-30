<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.fengyun.web.hardcode.IMageUploadInfo"%> 
<%@ page import="java.util.List"%>
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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operatelog.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/newoperate.css" />
		<style>
			.chartadd{
				display:inline-block;
				margin-left: 20px;
				margin-top: 15px;
				height: 25px;
				line-height: 25px;
				text-align: center;
				width: 100px;
				border: none;
				border-radius: 3px;
				background-color: #3399FF;
				color: white;
				cursor: pointer;
				font-size: 14px;
			}		
		</style>
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			function submitOperateSalaryForm() {
				var workMonth = $("#workMonth").val().trim();
				var teamMemberName = $("#teamMemberName").val().trim();
				var teamName = $("#teamName").val().trim();
				var monthReg = /^\d{6}$/;
				if (!monthReg.test(workMonth)) {
					alert("请输入正确的月份格式(6位数字，如：201608)");
					return false;
				}
				var monthRegLastTwo = workMonth.substring(4, 6);
				if (monthRegLastTwo != "01" && monthRegLastTwo != "02" && monthRegLastTwo != "03" && monthRegLastTwo != "04" &&
						monthRegLastTwo != "05" && monthRegLastTwo != "06" && monthRegLastTwo != "07" && monthRegLastTwo != "08" &&
						monthRegLastTwo != "09" && monthRegLastTwo != "10" && monthRegLastTwo != "11" && monthRegLastTwo != "12") {
					alert("月份为01到12之间");
					return false;
				}
				if (teamMemberName == "" && teamName == "") {
					alert("姓名和班组名称必填一个");
					return false;
				}
				document.getElementById('myform').submit();
			}
		</script> 
		<script type="text/javascript" >
			function salaryToexcel()
			{
				 var teamName = $("#teamNameSearch").val();
				 var workMonth = $("#workMonthSearch").val();
				 var teamMemberName = $("#teamMemberNameSearch").val();
				 var projectId = $("#projectIdSearch").val();
				 var pCode = $("#pCodeSearch").val();
				 window.location.href="salry_toExcle.html?teamName="+teamName+"&workMonth="+workMonth+"&teamMemberName="+teamMemberName
						 +"&projectId="+projectId+"&pCode="+pCode; 
			}
			
		</script>
		<script type="text/javascript" >
			$(function(){
				$('.identy').on('click',function ()
				{
					 var imageName = $(this).siblings().val();
					 var projectUserId = $("#projectUserId").val();
					 var sarypath = $("#sarypath").val();
					 var visitAddress = $("#visitAddress").val();
					 var vistPath=visitAddress+sarypath+projectUserId+"/";
					 window.open(vistPath+imageName);
				});
			});
		</script>
	
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />

			<div class="detail">
				<div class="detailright">
					<div class="derighttop clearfix">
						<form id="myform" action="operate_getSalaryRecord.html?projectId=${projectModel.id }" method="POST">
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td>项目名称</td>
									<td><span>${projectModel.name }</span></td>
									<td>发放年月</td>
									<td><input id="workMonth" type="text" name="workMonth" value="${workMonth }" placeholder="格式：201608"/></td>
									<td>姓名</td>
									<td><input id="teamMemberName" type="text" name="teamMemberName" value="${teamMemberName }"/></td>
									<td>班组名称</td>
									<td>
										<input id="teamName" type="text" name="teamName" value="${teamName }"/>
										<input id="teamNameSearch" type="hidden" name="teamNameSearch" value="${teamName }"/>
										<input id="workMonthSearch" type="hidden" name="workMonthSearch" value="${workMonth }"/>
										<input id="teamMemberNameSearch" type="hidden" name="teamMemberNameSearch" value="${teamMemberName }"/>
										<input id="projectIdSearch" type="hidden" name="projectIdSearch" value="${projectId }"/>
										<input type="hidden" value="${projectModel.userId }" id="projectUserId">
										<input id="pCodeSearch" type="hidden" name="pCodeSearch" value="${pCode }"/>
									</td>
								</tr>
							</table>
							<div class="dsearch" onclick="return submitOperateSalaryForm();">搜索</div>
							<div onclick="printit();">打印</div>
							<div id="toExcel" onclick="return salaryToexcel();">导出EXCEL</div>
						</form>
						<a href="operate_salaryDownloadExcel.html" class='chartadd'  style="color: white;">EXCEL模板下载</a>
						<form action="operate_salaryImportExcel.html?pCode=${projectModel.pCode }" method="post" enctype="multipart/form-data" style='display:inline-block'>
							<i class="chartadd" style='position:relative;margin-right:3px'>
								导入Execl
								<input id="excelSalaryInput" name="fileInput" type="file" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0" />
							</i>
							<i class="chartadd" style='position:relative; margin-left: 2px;'>
								提交Execl<input type="submit" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0">
							</i>
						</form>
						<c:if test="${result == '0' }">
							<span style="color: red; text-align: center;">导入成功</span>
						</c:if>
						<c:if test="${result == '1' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*请保证数据的完整性</span>
						</c:if>
						<c:if test="${result == '2' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*请工人手机号数据的正确性</span>
						</c:if>
						<c:if test="${result == '3' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*某手机号的工人还没有注册</span>
						</c:if>
						<c:if test="${result == '4' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*某班组名称不存在</span>
						</c:if>
						<c:if test="${result == '5' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*某工人并不在输入对应的班组中</span>
						</c:if>
						<c:if test="${result == '6' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*请保证日期格式的正确性</span>
						</c:if>
						<c:if test="${result == '7' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*某工人的这个月的工资发放记录已存在</span>
						</c:if>
						<c:if test="${result == '8' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*导入的EXCEL中没有任何数据</span>
						</c:if>
						<c:if test="${result == '9' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*导入的EXCEL模板错误，请下载正确的模板</span>
						</c:if>
						<br/>
						<c:forEach items="${projectDepartmentModels }" var="projectDepartmentModel">
							<span>
								<a href="operate_salaryLabel.html?tId=${projectDepartmentModel.vId }&pId=${projectDepartmentModel.pId }">${projectDepartmentModel.label }</a>
							</span>&nbsp;&nbsp;&nbsp;&nbsp;
						</c:forEach>
					</div>
					<div class="derightbottom">
						<c:if test="${workMonth==null}">
							<!-- 什么也不做 -->
						</c:if>
							<!--startprint-->
						<c:if test="${workMonth!=null}">
							<c:if test="${payrollRecordModels!=null}">	
								<table border="0" cellspacing="1" cellpadding="0">
									<caption>工资发放记录</caption>
									<tr>
										<th>序号</th>
										<th>班组名称</th>
										<%
											String prModelsJson1=(String)request.getAttribute("prModelsJson1");
										%>
										<th>姓名</th>
										<th>发放日期</th>
										<th>应发金额</th>
										<th>个人所得税</th>
										<th>实发金额</th>
										<th>欠发金额</th>
										<th>付款人</th>
										<th>付款方式</th>
										<th>流水号</th>
										<th>收款人帐号</th>
										<th>
											上传附件 
											<input type="hidden" id="visitAddress" value="<%=IMageUploadInfo.VISITADDRESS.getValue()%>" />
											<input type="hidden" id="sarypath" value="<%=IMageUploadInfo.SARYPATH.getValue()%>" />
										</th>
									</tr>
									<c:forEach items="${payrollRecordModels }" var="payrollRecordModel" varStatus="status">
										<tr>    
											<td>${status.index + 1}</td>
											<td>${payrollRecordModel.tName }</td>
											<td>${payrollRecordModel.name }</td>
											<td>${payrollRecordModel.payTimeStr }</td>
											<td>${payrollRecordModel.salary }</td>
											<td>${payrollRecordModel.tax }</td>
											<td>${payrollRecordModel.realSalary }</td>
											<td>${payrollRecordModel.noSalary }</td>
											<td>${payrollRecordModel.drawee }</td>
											<td>
												<c:if test="${payrollRecordModel.paytype==1 }">支付宝</c:if>
												<c:if test="${payrollRecordModel.paytype==2 }">微信</c:if>
												<c:if test="${payrollRecordModel.paytype==3 }">银行卡</c:if>
												<c:if test="${payrollRecordModel.paytype==4 }">现金</c:if>
											</td>
											<td>${payrollRecordModel.serial }</td>
											<td>${payrollRecordModel.payAccont }</td>
											<td>
												<c:if test="${payrollRecordModel.imageName==null}">
													<form action="operate_uploadSalaryImage.html?
													projectUserId=${projectModel.userId }&payrollRecordId=${payrollRecordModel.id }
													&teamMemberName=${teamMemberName }&teamName=${teamName }&projectId=${projectId }&workMonth=${workMonth }" 
															method="post" enctype="multipart/form-data">
											    		<input type="hidden" value="${payrollRecordModel.id }" id="payrollRecordId">
											    		<input type="file" name="imageFile">
											    		<input type="submit" >
											    	</form>
										   		 </c:if>
										   		 <c:if test="${payrollRecordModel.imageName==''}">
													<form action="operate_uploadSalaryImage.html?
													projectUserId=${projectModel.userId }&payrollRecordId=${payrollRecordModel.id }
													&teamMemberName=${teamMemberName }&teamName=${teamName }&projectId=${projectId }&workMonth=${workMonth }" 
															method="post" enctype="multipart/form-data">
											    		<input type="hidden" value="${payrollRecordModel.id }" id="payrollRecordId">
											    		<input type="file" name="imageFile">
											    		<input type="submit" >
											    	</form>
										   		</c:if>
										    	<c:if test="${payrollRecordModel.imageName!=null }">
										    		<c:if test="${payrollRecordModel.imageName!='' }">
											     		<input type="button" id="identTitydemo" class="identy" value="查看" style="margin-left: 0;" />
											    		<input type="hidden" id="imageName" value="${payrollRecordModel.imageName }">
											    	</c:if>
										    	</c:if>
											</td>
										</tr>
										<div class="demo" >
										</div>
									</c:forEach>
								</table>
							</c:if>
							<c:if test="${payrollRecordModels==null }">
								<span>没有查询到相关记录</span>
							</c:if>
						</c:if>
						
						<c:if test="${label == 'label' }">
							<c:if test="${LabelPayrollRecordModels==null }">
								该标签的班组没有工资发放记录
							</c:if>
							<c:if test="${LabelPayrollRecordModels!=null }">
								<table border="0" cellspacing="1" cellpadding="0">
									<tr>
										<th>序号</th>
										<th>班组名称</th>
										<%
											String prModelsJson1=(String)request.getAttribute("prModelsJson1");
										%>
										<th>姓名</th>
										<th>发放日期</th>
										<th>应发金额</th>
										<th>个人所得税</th>
										<th>实发金额</th>
										<th>欠发金额</th>
										<th>付款人</th>
										<th>付款方式</th>
										<th>流水号</th>
										<th>收款人帐号</th>
										<th>
											上传附件 
											<input type="hidden" id="visitAddress" value="<%=IMageUploadInfo.VISITADDRESS.getValue()%>" />
											<input type="hidden" id="sarypath" value="<%=IMageUploadInfo.SARYPATH.getValue()%>" />
										</th>
									</tr>
									<c:forEach items="${LabelPayrollRecordModels }" var="payrollRecordModel" varStatus="status">
										<tr>    
											<td>${status.index + 1}</td>
											<td>${payrollRecordModel.tName }</td>
											<td>${payrollRecordModel.name }</td>
											<td>${payrollRecordModel.payTimeStr }</td>
											<td>${payrollRecordModel.salary }</td>
											<td>${payrollRecordModel.tax }</td>
											<td>${payrollRecordModel.realSalary }</td>
											<td>${payrollRecordModel.noSalary }</td>
											<td>${payrollRecordModel.drawee }</td>
											<td>
												<c:if test="${payrollRecordModel.paytype==1 }">支付宝</c:if>
												<c:if test="${payrollRecordModel.paytype==2 }">微信</c:if>
												<c:if test="${payrollRecordModel.paytype==3 }">银行卡</c:if>
												<c:if test="${payrollRecordModel.paytype==4 }">现金</c:if>
											</td>
											<td>${payrollRecordModel.serial }</td>
											<td>${payrollRecordModel.payAccont }</td>
											<td>
												<c:if test="${payrollRecordModel.imageName==null}">
													<form action="operate_uploadSalaryImage.html?
													projectUserId=${projectModel.userId }&payrollRecordId=${payrollRecordModel.id }
													&teamMemberName=${teamMemberName }&teamName=${teamName }&projectId=${projectId }&workMonth=${workMonth }" 
															method="post" enctype="multipart/form-data">
											    		<input type="hidden" value="${payrollRecordModel.id }" id="payrollRecordId">
											    		<input type="file" name="imageFile">
											    		<input type="submit" >
											    	</form>
										   		 </c:if>
										   		 <c:if test="${payrollRecordModel.imageName==''}">
													<form action="operate_uploadSalaryImage.html?
													projectUserId=${projectModel.userId }&payrollRecordId=${payrollRecordModel.id }
													&teamMemberName=${teamMemberName }&teamName=${teamName }&projectId=${projectId }&workMonth=${workMonth }" 
															method="post" enctype="multipart/form-data">
											    		<input type="hidden" value="${payrollRecordModel.id }" id="payrollRecordId">
											    		<input type="file" name="imageFile">
											    		<input type="submit" >
											    	</form>
										   		</c:if>
										    	<c:if test="${payrollRecordModel.imageName!=null }">
										    		<c:if test="${payrollRecordModel.imageName!='' }">
											     		<input type="button" id="identTitydemo" class="identy" value="查看" style="margin-left: 0;" />
											    		<input type="hidden" id="imageName" value="${payrollRecordModel.imageName }">
											    	</c:if>
										    	</c:if>
											</td>
										</tr>
										<div class="demo" >
										</div>
									</c:forEach>
								</table>
							</c:if>
						</c:if>
						<!--endprint-->
					</div>
				</div>
			</div>
		</div>
		
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>resource/js/front_person/front_person_print.js" type="text/javascript"></script>
		<%-- <script src="<%=basePath%>/resource/js/operate/operatelog.js" type="text/javascript" charset="utf-8"></script> --%>
		<%-- <script src="<%=basePath%>/resource/js/operate/operatesalary.js" type="text/javascript" charset="utf-8"></script> --%>
	</body>

</html>