<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>公司列表</title>
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
					<h3>公司管理</h3>
					<span class="datum">公司管理>>公司列表</span>
					<form action="company_list2.html" method="post">
					<table border="0px" cellspacing="0px" cellpadding="0px">
						<tr>
							<td><label for="gender">公司代码:</label></td>
							<td><input class="inp" type="text" name="code" value="${code}"/></td>
							<td><label for="uid">公司名称:</label></td>
							<td><input class="inp" type="text" name="name" value="${name}"/></td>
							<td><label for="name">负责人:</label></td>
							<td><input class="inp" type="text" name="leaderName" value="${leaderName}"/></td>
						</tr>
						<tr>
							<td><label for="gender">手机号:</label></td>
							<td><input type="text" name="uId" value="${uId}"/></td>
							<td>地区：</td>
							<td colspan="2"><span id="Span2"><select
										id="province" onchange="setCity(this.value);getArea();"
										name="province" runat="server">
											<option value="${province}">--请选择省份--</option>
									</select> </td><td><select id="city" onchange="setCounty(this.value);getArea();"
										name="city" runat="server">
											<option value="${city}" selected="selected">--请选择城市--</option>
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
							<td>公司名称</td>
							<td>公司代码</td>
							<td>联系方式</td>
							<td>负责人</td>
							<td>手机号</td>
							<td>省份</td>
							<td>公司类型</td>
							<td>状态</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${clist}" var="model"> 
						<tr>
							<td><a href="company_projectlist.html?code=${model.code}" style="color:blue">${model.name}</a></td>
							<td>${model.code}</td>
							<td>${model.tel}</td>
							<td>${model.leaderName}</td>
							<td>${model.userId}</td>
							<td>${model.provinceChn}</td>
							<td>${model.type}</td>
							<td><c:choose>
							   <c:when test="${model.status== '2'}">  
							        已审核       
							   </c:when>
							   <c:otherwise> 
							    <span class="del">
									<a href="javascript:if(confirm('确实要审核通过${model.name}吗?'))location='company_pass.html?id=${model.id}'" style="color:white">审核</a>
								</span> 
							   </c:otherwise>
							</c:choose></td>
							<td>
								<span class="items">
									<a href="company_projectlist.html?code=${model.code}" style="color:white">项目</a>
								</span>
								&nbsp;&nbsp;
								<span class="add">
									<a href="company_modify.html?id=${model.id}" style="color:white">修改</a>
								</span>
							&nbsp;&nbsp;
								<span class="del">
									<a href="javascript:if(confirm('确实要删除${model.name}吗?'))location='company_del.html?id=${model.id}'" style="color:white">删除</a>
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
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


