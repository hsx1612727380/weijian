<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>供应商诚信档案列表</title>
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
					<span class="datum">诚信档案管理>>供应商诚信档案列表</span>
					<form action="merchant_list2.html" method="post">
					<table border="0px" cellspacing="0px" cellpadding="0px">
						<tr>
							<td><label for="supplier">供应商名称:</label></td>
							<td><input class="inp" type="text" name="supplier" value="${supplier}"/></td>
							<td><label for="license">营业执照:</label></td>
							<td><input class="inp" type="text" name="licence" value="${licence}"/></td>
							<td><label for="name">负责人:</label></td>
							<td><input class="inp" type="text" name="name" value="${name}"/></td>
						</tr>
						<tr>
							<td><label for="phone">电话:</label></td>
							<td><input class="inp" type="text" name="phone" value="${phone}"/></td>
							<td><label for="email">邮箱:</label></td>
							<td><input class="inp" type="text" name="email" value="${email}"/></td>
							<td><label for="wetchat">微信:</label></td>
							<td><input class="inp" type="text" name="wetchat" value="${wetchat}"/></td>
						</tr>
						
					</table>
					<br />
					<button class="query">查询</button>
					
					
				</div>
				<div class="ifamelayout">
					<table class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
						<tr>
							<th>供应商名称</th>
							<th>供应商代号</th>
							<th>营业执照</th>
							<th>成立日期</th>
							<th>联系人姓名</th>
							<th>联系人地址</th>
							<th>联系人手机号</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${malist}" var="model"> 
						<tr>
							<td><a href="merchant_form.html?type=${model.type}&code=${model.code}" style="color:blue">${model.supplier}</a></td>
							<td>${model.code}</td>
							<td>${model.licence}</td>
							<td>${model.build}</td>
							<td>${model.name}</td>
							<td>${model.supply}</td>
							<td>${model.mobile}</td>
							<td>
								<span class="items">
									<a href="merchant_form.html?type=${model.type}&code=${model.code}" style="color:white">查看</a>
								</span>
							&nbsp;&nbsp;
								<span class="add">
									<a href="merchant_modify.html?id=${model.id}" style="color:white">修改</a>
								</span>
							&nbsp;&nbsp;
								<span class="del">
									<a href="javascript:if(confirm('确实要删除${model.name}吗?'))location='merchant_del.html?id=${model.id}'" style="color:white">删除</a>
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
			</div>
			</form>
		</div>

	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


