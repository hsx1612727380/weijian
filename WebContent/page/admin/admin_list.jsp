<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<title>管理员列表</title>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
<link rel="stylesheet" type="text/css" href="resource/css/table.css" />

</head>

<body>

		<form action="listAdmin.html" method="post">
			<div class='search clearfix'>
					<h3>管理员管理</h3>
					<span class="datum">管理员管理>>管理员列表</span>
					
					<table border="0px" cellspacing="0px" cellpadding="0px">
						<tr>
							<td><label for="gender">真实姓名:</label></td>
							<td><input type="text" name="name" value="${name}" /></td>
							<td><label for="uid">手机号:</label></td>
							<td><input type="text" name="mobile" value="${mobile}" /></td>
							
						</tr>
						
					</table>
					<br />
					<button class="query" >查询</button>
				</div>
				<div class="ifamelayout">
					<table class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
						<tr>
							<td>登录ID&nbsp;&nbsp;</td>
							<td>真实姓名&nbsp;&nbsp;</td>
							<td>联系手机号&nbsp;&nbsp;</td>
							<td>管理员权限&nbsp;&nbsp;</td>
							<td>&nbsp;&nbsp;操作&nbsp;&nbsp;</td>
						</tr>
						<c:forEach items="${adminList}" var="adminModel">
					<tr>	
						<td>${adminModel.accountName}&nbsp;&nbsp;</td>
						<td>${adminModel.name}&nbsp;&nbsp;</td>
						<td>${adminModel.mobile}&nbsp;&nbsp;</td> 
						<td>
						<c:if test="${fn:contains(adminModel.popedom,'01')}">公司管理,</c:if>              
						<c:if test="${fn:contains(adminModel.popedom,'02')}">项目管理,</c:if>
						<c:if test="${fn:contains(adminModel.popedom,'03')}">班组管理,</c:if>  
						<c:if test="${fn:contains(adminModel.popedom,'04')}">材料商管理,</c:if>
						<c:if test="${fn:contains(adminModel.popedom,'05')}">设备商管理,</c:if>
						<c:if test="${fn:contains(adminModel.popedom,'06')}">诚信档案,</c:if>
						<c:if test="${fn:contains(adminModel.popedom,'07')}">考勤和人员出入管理,</c:if>
						<c:if test="${fn:contains(adminModel.popedom,'08')}">工资发放管理,</c:if>
						<c:if test="${fn:contains(adminModel.popedom,'09')}">用户管理,</c:if>
						<c:if test="${fn:contains(adminModel.popedom,'10')}">招聘,</c:if>
						<c:if test="${fn:contains(adminModel.popedom,'11')}">求职,</c:if>
						<c:if test="${fn:contains(adminModel.popedom,'13')}">招标/行业动态,</c:if>
						<c:if test="${fn:contains(adminModel.popedom,'14')}">法律咨询与保险,</c:if>
						<c:if test="${fn:contains(adminModel.popedom,'15')}">消息与公告,</c:if>
						
						</td>
						<td>
						<span class="add">
							<a href="showAdmin.html?id=${adminModel.id}" style="color:white">修改</a>
						</span>
						<span class="del">
							<a href="delAdmin.html?id=${adminModel.id}" style="color:white">删除</a>
						</span>
  						 </td>
					</tr>
					</c:forEach>
					</table>
					
					
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
			
		</form>

</body>
<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="resource/js/silder.js" type="text/javascript"
	charset="utf-8"></script>
<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="resource/js/area.js"></script>
</html>


