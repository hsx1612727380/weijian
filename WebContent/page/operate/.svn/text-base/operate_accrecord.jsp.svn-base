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
			function submitOperateAccForm() {
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
			function accRecordToexcel()
			{
				 var teamName = $("#teamNameSearch").val();
				 var workMonth = $("#workMonthSearch").val();
				 var teamMemberName = $("#teamMemberNameSearch").val();
				 var pCode = $("#pCodeSearch").val();
				 var projectId = $("#projectIdSearch").val();
				 window.location.href="accRecord.html?teamName="+teamName+"&workMonth="+workMonth+"&teamMemberName="+teamMemberName
						 +"&pCode="+pCode +"&projectId="+projectId; 
			}
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
						<form id="myform" action="operate_getAccRecord.html?projectId=${projectModel.id }" method="POST">
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td>项目名称</td>
									<td><span>${projectModel.name }</span></td>
									<td>年月份</td>
									<td><input id="workMonth" type="text" name="workMonth" value="${workMonth }" placeholder="格式：201608"/></td>
									<td>姓名</td>
									<td><input id="teamMemberName" type="text" name="teamMemberName" value="${teamMemberName }"/></td>
									<td>班组名称</td>
									<td>
										<input id="teamName" type="text" name="teamName" value="${teamName }"/>
										<input id="pCodeSearch" type="hidden" name="pCodeSearch" value="${pCode }"/>
										<input id="workMonthSearch" type="hidden" name="workMonthSearch" value="${workMonth }"/>
										<input id="teamNameSearch" type="hidden" name="teamNameSearch" value="${teamName }"/>
										<input id="teamMemberNameSearch" type="hidden" name="teamMemberNameSearch" value="${teamMemberName }"/>
										<input id="projectIdSearch" type="hidden" name="projectIdSearch" value="${projectId }"/>
									</td>
								</tr>
							</table>
							<div class="dsearch" onclick="return submitOperateAccForm();">搜索</div>
							<div>打印</div>
							<div id="toExcel" onclick="return accRecordToexcel();">导出EXCEL</div>
						</form>
						<a href="operate_accrecordDownloadExcel.html" class='chartadd'  style="color: white;">EXCEL模板下载</a>
						<form action="operate_accrecordImportExcel.html?pCode=${projectModel.pCode }" method="post" enctype="multipart/form-data" style='display:inline-block'>
							<i class="chartadd" style='position:relative;margin-right:3px'>
								导入Execl
								<input id="excelAccrecordInput" name="fileInput" type="file" style="position:absolute;width:100%;height:100%;left:0;top:0;opacity:0" />
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
							<span style="color: red; text-align: center;">导入失败&nbsp;*导入的EXCEL中没有任何数据</span>
						</c:if>
						<c:if test="${result == '8' }">
							<span style="color: red; text-align: center;">导入失败&nbsp;*导入的EXCEL模板错误，请下载正确的模板</span>
						</c:if>
					</div>
					<div class="derightbottom">
						<c:if test="${workMonth==null }">
							<!-- 什么也不做 -->
						</c:if>
						<c:if test="${workMonth!=null }">
							<c:if test="${accrecordModels!=null }">
								<table border="0" cellspacing="1" cellpadding="0">
									<caption>出入记录</caption>
									<tr>
										<th>序号</th>
										<th>项目名称</th>
										<th>班组名称</th>
										<th>姓名</th>
										<th>出入时间</th>
										<th>进场/离场</th>
									</tr>
									<c:forEach items="${accrecordModels }" var="accrecordModel" varStatus="status">
										<tr>
											<td>${status.index + 1}</td>
											<td>${projectModel.name }</td>
											<td>${accrecordModel.tName }</td>
											<td>${accrecordModel.name }</td>
											<td>${accrecordModel.recordTimeStr }</td>
											<td>
												<c:if test="${accrecordModel.type==0 }">进场</c:if>
												<c:if test="${accrecordModel.type==1 }">离场</c:if>
											</td>
										</tr>
									</c:forEach>
								</table>
								<form action="operate_getAccRecord.html?projectId=${projectModel.id }" method="post">
									<input type="hidden" name="workMonth" value="${workMonth }"/>
									<input type="hidden" name="teamMemberName" value="${teamMemberName }"/>
									<input type="hidden" name="teamName" value="${teamName }"/>
									<input type="hidden" name="pCode" value="${pCode }"/>
									<div class="tabfooter">
										<div class="footerl">
											<c:if test="${page.pageNow == 1}">[首页]&nbsp;&nbsp;&nbsp;&nbsp;[上一页]&nbsp;</c:if>
											<c:if test="${page.pageNow != 1}">
												<button value="1" name="pageNowFirst" style="color: blue;">[首页]</button>
												<button value="${page.prePage}" name="pageNowPre" style="color: blue;">[上一页]</button>
											</c:if>&nbsp;&nbsp;
											<span>当前有</span><span>${page.pageNow}</span>/<span class="footernum">${pageCount}</span><span>页</span>&nbsp;&nbsp;&nbsp;&nbsp;
											<c:if test="${page.pageNow == page.lastPage}">&nbsp;[下一页]&nbsp;&nbsp;&nbsp;&nbsp;[尾页]</c:if>
											<c:if test="${page.pageNow != page.lastPage}">
												<button value="${page.nextPage}" name="pageNowNext" style="color: blue;">[下一页]</button>
												<button value="${page.lastPage}" name="pageNowLast" style="color: blue;">[尾页]</button>
											</c:if>
										</div>
									</div>
								
								</form>
							</c:if>
							<c:if test="${accrecordModels==null }">
								<span>没有查询到相关记录</span>
							</c:if>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>