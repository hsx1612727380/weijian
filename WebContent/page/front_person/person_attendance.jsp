<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_person/person_left_handler.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/personAttendance.css" />
	</head>
	<body>
		<input id="isLeader" type="hidden" value='${isLeader}'/> 
 		<jsp:include page="../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>个人中心</span>
			</div>
		</div>
		<div class="content personal">
			<div class="autstate">
				<span>认证状态：</span><span>已认证 &nbsp;&nbsp;&nbsp;</span>
				<span>角色：</span><span>班组长</span>&nbsp;&nbsp;&nbsp;&nbsp;<font color="darkblue">考勤记录</font>
			</div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
				<div class="detailright">
					<div class="derighttop clearfix">
					<form id="queryform" name="form" action="personAttendance.html" method="post">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>班组号：<b>${teamCode}</b></td>
								<td>班组名称：<b>${teamName}</b></td>
								<td>班组长：<b>${userName}</b></td>
							</tr>
							<tr>
								<td>工人姓名：<input id="name" type="text"  name="name" value="${name}" style="width:60px" /></td>
								<td>项目名称：<input id="pName" type="text"  name="pName" value="${pName}" style="width:160px"/></td>
								<td>
									<label for="strDateBegin">开始时间 ：</label>
									<input type="text" id="startDate" name="startDate" value="${startDate}" placeholder="格式20160201" style="width:100px"/>
								</td>
								<td>
									<label for="strDateEnd">结束时间 ：</label>
									<input type="text" id="endDate" name="endDate" value="${endDate}" placeholder="格式20160201" style="width:100px" />
								</td>
							</tr>
						</table>
					</form>
					<div onClick="submitForm()"><font color="white">搜索</font></div>
					<div onclick="printit();">打印</div>
					<div><a href="personAttendance.html?export=1" style="color:white">导出EXCEL</a></div>
					</div>
					
					<div class="derightbottom">
				<!--startprint-->
				<table  border="0"  cellpadding="0" cellspacing="1"> 
				<tr>
					<th colspan="6">考勤记录</th>
				</tr>
				<tr>
					<td>项目名称</td>
					<td>工人姓名</td>
					<td>手机号</td>
					<td>开始时间</td>
					<td>结束时间</td>
					<td>工时</td>
				</tr>
				<c:forEach items="${attendanceInfoList}" var="attendanceInfo"  >
					<tr>
						<td>${attendanceInfo.pName}</td>
						<td>${attendanceInfo.name}</td>
						<td>${attendanceInfo.userId}</td>
						<td> <fmt:formatDate value="${attendanceInfo.startDate}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td> <fmt:formatDate value="${attendanceInfo.endDate}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td>${attendanceInfo.workTime}小时</td>
					</tr>
				</c:forEach>
				</table>
				<div class="tabfooter">
					<form action="personAttendance.html" method="post">
						<div class="footerl">
							<span>每页：</span>
							<input type="text" value="${page.pageSize}" name="pageSize" style="width:30px"/>
							<span>条</span>
							<button>确定</button>
							<span>共有</span>
							<span class="footernum">${page.dataCount}</span>
							<span>条记录，当前有</span>
							<span>${page.pageNow}</span><span>/</span><span>${page.pageCount}</span>
							<span>页</span>
						</div>
						<input type="hidden" name="dataCount" value="${page.dataCount}">
						<div class="footer2">
							<button value="1" name="pageNow">首页</button>
							<button value="${page.prePage}" name="pageNow">上一页</button>
							<button value="${page.nextPage}" name="pageNow">下一页</button>
							<button value="${page.lastPage}" name="pageNow">尾页</button>
						</div>
					</form>
				</div>
				<!--endprint-->
			</div>
			</div>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>resource/js/front_person/front_person_print.js" type="text/javascript"></script>
	</body>
	
		<script type="text/javascript">
			function submitForm() {
				var startDate = document.getElementById('startDate').value;
				var endDate = document.getElementById('endDate').value;
				if((startDate!="" && startDate !=null)|| (endDate!="" && endDate !=null)){
					if(/^\d{8}$/g.test(startDate)==false ) {
						alert('开始时间输入错误,请重新输入(8位日期数字,如:20160201)');
						return false;
					}
					if(/^\d{8}$/g.test(endDate)==false) {
						alert('结束时间输入错误,请重新输入(8位日期数字,如:20160201)');
						return false;
					}
					if(parseInt(endDate)<parseInt(startDate)){
						alert('开始时间不能大于结束时间');
						return false;
					}
					if(parseInt(endDate)>parseInt(startDate) + 10000){
						alert('时间间隔不能大于1年');
						return false;
					}
				}
				return document.form.submit(); //提交名字为form的表单
			}
		</script>
</html>