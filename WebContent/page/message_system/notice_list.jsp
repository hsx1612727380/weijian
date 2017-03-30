<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>消息与公告</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/dataFormat.css" />
	</head>
	<body>

				<div class='search clearfix'>
					<h3>公告列表</h3>
					<span class="datum">公告列表>>公告发布记录</span>
					<form name="reg_testdate" action="notice_list2.html" method="post">
					<table border="0px" cellspacing="0px" cellpadding="0px">
						<tr>
							<td><label for="strDateBegin">有效开始时间:</label></td>
							<td><%-- <input type="text" id="startDate" name="startDate" value="${startDate}"/> --%>
									<input  name="startDate" type="text" value="${startDate}" size="14"
										readonly onclick="showcalendar(event,this);"
										onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''" /></td>
							<td><label for="strDateEnd">有效结束时间:</label></td>
							<td><%-- <input type="text" id="endDate" name="endDate" value="${endDate}"/>*格式20160201</td> --%>
								<input  name="endDate" type="text" value="${endDate}" size="14"
									readonly onclick="showcalendar(event,this);"
									onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''" /></td>
						</tr>
					</table>
					<br />
					<button class="query">查询</button>
					
					
					
				</div>
				<div class="ifamelayout">
					<table class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
						<tr>
							<td>公告消息标题</td>
							<td>公告消息的创建时间</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${notlist}" var="model"> 
						<tr>
							<td align="left">${model.noticeTitle}</td>
							<td>${model.createTimeStr}</td>
							<td>
								<span class="add">
									<a href="" style="color:white">查看内容</a>
								</span>
							</td>
						</tr>
						</c:forEach>
					</table>
					<div class="delnote" id="delnote">
						<p>确定删除信息？</p>
						<button class="sure" >确定</button>
						<button class="cancel">取消</button>
					</div>
					
					
				</div>
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
	<script type="text/javascript" src="resource/js/area.js"></script>
	<script src="resource/js/time.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/dateFormat.js" type="text/javascript" ></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


