<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<title>出入记录列表</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/dataFormat.css" />
	<script type="text/javascript">
			function submitForm() {
				var startDate = document.getElementById('startDate').value;
				var endDate = document.getElementById('endDate').value;
				if(/^\d{8}$/g.test(startDate)==false) {
			        alert('开始时间输入错误,请重新输入(8位数字,如:20160201)');
			        return false;
			    }
				if(/^\d{8}$/g.test(endDate)==false) {
			        alert('结束时间输入错误,请重新输入(8位数字,如:20160201)');
			        return false;
			    }
				if(parseInt(endDate)>parseInt(startDate) + 10000){
					alert('时间间隔不能大于1年');
			        return false;
				}
				return true;
			}
		</script>
	</head>
	
	<body>

				<div class='search clearfix'>
						<h3>考勤和人员出入管理</h3>
						<span>项目名称:${pmodel.name}</span>
						<form action="accrecord_project2.html"  name="reg_testdate" method="post" onSubmit="return submitForm()">
						<table border="0px" cellspacing="0px" cellpadding="0px">
							<tr>
								<td><label for="code">班组编号:</label></td>
								<td><input type="text" name="code" value="${code}"/></td>
								<td><label for="userId">手机号:</label></td>
								<td><input type="text" name="uId" value="${uId}"/></td>
								<td><label for="name">姓名:</label></td>
								<td><input type="text" name="name" value="${name}" /></td>
							</tr>
							<tr>
								<td><label for="strDateBegin">开始时间:</label></td>
								<td><%-- <input type="text" id="startDate" name="startDate" value="${startDate}"/> --%>
									<input  name="startDate" type="text" value="${startDate}" size="14"
										readonly onclick="showcalendar(event,this);"
										onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''" />*不能为空</td>
								<td><label for="strDateEnd">结束时间:</label></td>
								<td><%-- <input type="text" id="endDate" name="endDate" value="${endDate}"/>*格式20160201</td> --%>
									<input  name="endDate" type="text" value="${endDate}" size="14"
										readonly onclick="showcalendar(event,this);"
										onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''" />*不能为空</td>
							</tr>
						</table>
						<button class="query">查询</button>
						<div class="footer clearfix">
							<input type="hidden" name="pCode" value="${pmodel.pCode}">
							<input type="hidden" name="code" value="${code}"> 
						</div>
					</form>
				</div>
				<div class="textcontent content">
				<table class="querytable" border="2px" cellspacing="0" cellpadding="3px" style="text-align: center;">
					<tr>
						<c:forEach items="${teams}" var="tmodel" varStatus="idx"> 
							<c:if test="${idx.index % 3 == 0}"><tr></c:if>
								<td><a href="accrecord_project.html?pCode=${pmodel.pCode}&code=${tmodel.code}" style="color:blue">${tmodel.name}</a>(${tmodel.code})</td>
							<c:if test="${idx.index % 3 == 2}"></tr></c:if>
						</c:forEach>
					</tr>
				</div>
			
				
				</table>
				
		
				<div class="ifamelayout">
					<table class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
						<tr>
							<th>班组名称</th>
							<th>姓名</th>
							<th>手机号</th>
							<th>出入时间记录</th>
						</tr>
						<c:forEach items="${aplist}" var="model"> 
						<tr>
							<td>${model.tName}</td>
							<td>${model.name}</td>
							<td>${model.userId}</td>
							<td>${model.recordTimeStr}<c:choose>
							<c:when test="${model.type==1}">  
							       退场       
							 </c:when>
							  <c:otherwise> 
							    进场
							   </c:otherwise>
							</c:choose></td>
						</tr>
						</c:forEach>
						
					</table>
				<div class="footer clearfix">
					<div class="footerl">
						<span>每页：</span>
						<input type="text" value="20" name="pageSize"/>
						<span>条</span>
						<button>确定</button>
						<span>共有</span>
						<span class="footernum">${page.dataCount}</span>
						<span>条记录，当前有</span>
						<span>${page.pageNow}</span><span>/</span><span>${page.pageCount}</span>
						<span>页</span>
					</div>
					<input type="hidden" name="dataCount" value="${page.dataCount}"> 
					<div class="footerr">
						<button value="1" name="pageNow">首页</button>
						<button value="${page.prePage}" name="pageNow">上一页</button>
						<button value="${page.nextPage}" name="pageNow">下一页</button>
						<button value="${page.lastPage}" name="pageNow">尾页</button>
					</div>

				</div>
					
				
			</div>
			</form>
		</div>

	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/time.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/dateFormat.js" type="text/javascript"></script>
	
</html>

