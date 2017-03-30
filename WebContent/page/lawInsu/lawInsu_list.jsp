<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>法律保险</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />

	</head>
	<body>

				<div class='search clearfix'>
					<h3>法律保险管理</h3>
					<span class="datum">法律保险管理>>法律保险记录</span>
					<form name="reg_testdate" action="lawInsu_list2.html" method="post">
					<table border="0px" cellspacing="0px" cellpadding="0px">
						<tr>
							<td ><label for="title">标题:</label></td>
							<td><input class="inp" type="text" name="title" value="${title}"/></td>
							<td>信息类型</td>
							<td>
								<select name="lawtype" >
								<option value="1" <c:if test="${lawtype=='1'}">selected</c:if>>金融保险</option>
								<option value="2" <c:if test="${lawtype=='2'}">selected</c:if>>法律咨询</option>
								</select>
							</td>
						</tr>
					</table>
					<br />
					<button class="query">查询</button>
					
					
					
				</div>
				<div class="ifamelayout">
					<table class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
						<tr>
							<td>标题</td>
							<td>信息类型</td>
							<td>发布时间</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${lalist}" var="model"> 
						<tr>
							<td align="left">${model.title}</td>
							<td><c:choose>
							<c:when test="${model.lawtype == '1'}">金融保险</c:when>
							<c:otherwise>法律咨询</c:otherwise></c:choose>
							</td>
							<td>${model.createTimeStr}</td>
							<td>
								<span class="add">
									<a href="lawInsu_modify.html?id=${model.id}" style="color:white">修改</a>
								</span>
							&nbsp;&nbsp;
								<span class="del">
									<a href="javascript:if(confirm('确实要删除${model.title}吗?'))location='lawInsu_del.html?id=${model.id}'" style="color:white">删除</a>
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
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


