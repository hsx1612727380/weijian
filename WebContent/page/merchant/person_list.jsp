<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>个人诚信档案列表</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />

	</head>
	<script type="text/javascript">
		
	</script>
	<body>

				<div class='search clearfix'>
					<h3>诚信档案管理</h3>
					<span class="datum">诚信档案管理>>个人诚信档案列表</span>
					<form action="person_list2.html" method="post">
					<table border="0px" cellspacing="0px" cellpadding="0px">
						<tr>
							<td><label for="name">姓名:</label></td>
							<td><input class="inp" type="text" name="name" value="${name}"/></td>
							<td><label for="userId">电话:</label></td>
							<td><input class="inp" type="text" name="userId" value="${userId}"/></td>
							<td><label for="age">年龄:</label></td>
							<td><input class="inp" type="text" name="age" value="${age}"/></td>
						</tr>
					</table>
					<br />
					<button class="query">查询</button>
					
					
				</div>
				<div class="ifamelayout">
					<table class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
						<tr>
							<th>手机号</th>
							<th>名字</th>
							<th>年龄</th>
							<th>性别</th>
							<th>文化程度</th>
							<th>身体状况</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${pslist}" var="model"> 
						<tr>
							<td><a href="person_form.html?id=${model.id}" style="color:blue">${model.userId}</a></td>
							<td><a href="person_form.html?id=${model.id}" style="color:blue">${model.name}</a></td>
							<td>${model.age}</td>
							<td>
								<c:if test="${model.gender=='1'}">男</c:if>
								<c:if test="${model.gender=='2'}">女</c:if>
							</td>
							<td>${model.education}</td>
							<td>${model.health}</td>
							<td>
								<span class="items">
									<a href="person_form.html?id=${model.id}" style="color:white">查看</a>
								</span>
							&nbsp;&nbsp;
								<span class="add">
									<a href="person_modify.html?id=${model.id}" style="color:white">修改</a>
								</span>
							&nbsp;&nbsp;
								<span class="del">
									<a href="javascript:if(confirm('确实要删除${model.name}吗?'))location='person_del.html?id=${model.id}'" style="color:white">删除</a>
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
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


