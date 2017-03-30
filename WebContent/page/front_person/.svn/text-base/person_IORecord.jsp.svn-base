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

		
		<script type="text/javascript">
			 //表单提交函数  
			 function submitForm() {
				return document.form.submit(); //提交名字为form的表单
			}
			 console.log('${type}');
		</script>
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
				<span>角色：</span><span>班组长</span>&nbsp;&nbsp;&nbsp;&nbsp;<font color="darkblue">出入记录</font>
			</div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
				<div class="detailright">
					<div class="derighttop clearfix">
						<form id="queryform" name="form" action="personIORecord.html" method="post">
						<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>班组号：<b>${teamCode}</b></td>
							<td>班组名称：<b>${teamName}</b></td>
							<td>班组长：<b>${userName}</b></td>
							<td>进/退场：
								<select name="type" style="width:120px">
									<option value="-1">进/退场</option>
									<option value="0" <c:if test="${type==0}" > selected </c:if> >进场</option>
									<option value="1" <c:if test="${type==1}" > selected </c:if> >退场</option>
								</select>
							</td>
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
					<div><a href="personIORecord.html?export=1" style="color:white">导出EXCEL</a></div>
					</div>
					
					<div class="derightbottom">
					<!--startprint-->
				<table  border="0"  cellpadding="0" cellspacing="1"> 
				<tr>
					<th colspan="4">人员出入记录</th>
				</tr>
				<tr>
					<td>项目名称</td>
					<td>工人姓名</td>
					<td>工人电话</td>
					<td>打卡时间</td>
				</tr>
				<c:forEach items="${accrecordModelList}" var="accrecordModel"  >
					<tr>
						<td>${accrecordModel.pName}</td>
						<td>${accrecordModel.name}</td>
						<td>${accrecordModel.userId}</td>
						<td><fmt:formatDate value="${accrecordModel.recordTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					</tr>
				</c:forEach>
				</table>
				<div class="tabfooter">
					<form action="personIORecord.html" method="post">
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
</html>