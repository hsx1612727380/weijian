<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

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
<form action="recruit_material_list.html" method="post">
					
				<div class='search clearfix'>
					<h3>招聘</h3>
					<span class="datum">招聘>>材料采购</span>
					<table border="0px" cellspacing="0px" cellpadding="0px">
						<tr>
							<td><label for="uid">项目名称:</label></td>
							<td><input type="text" name="name" value="${name}"/></td>
							
							<td>地区：</td>
							<td colspan="2"><span id="Span2"> 省：<select
									id="province" onchange="setCity(this.value);getArea();"
									name="province" runat="server">
										<option value="${province}">--请选择省份--</option>
								</select> </td><td>市：<select id="city" onchange="setCounty(this.value);getArea();"
									name="city" runat="server">
										<option value="${city}" selected="selected">--请选择城市--</option>
								</select>
							</span></td>
						</tr>
						<tr>
							<td><label for="code">项目负责人:</label></td>
							<td><input type="text" name="leaderName" value="${leaderName}"/></td>
							<td><label for="uid">材料名称:</label></td>
							<td><input type="text" name="shopName" value="${shopName}"/></td>
						</tr>
						
						
					</table>
					<br />
					<button class="query" >查询</button>
				</div>
				<div class="ifamelayout">
						<span class="items"><a href="recruit_material_add.html">添加</a></span>
							
					<table class=erytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
						<tr>
							<td>标题</td>
							<td>材料名称</td>
							<td>公司名称</td>
							<td>项目名称</td>
							<td>负责人</td>
							<td>联系方式</td>
							<td>招聘地区</td>
							<td>状态</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${list}" var="model"> 
						<tr>
							<td>${model.title}&nbsp;&nbsp;</td>
							<td>${model.shopName}&nbsp;&nbsp;</td>
							<td>${model.cModel.name}&nbsp;&nbsp;</td>
							<td>${model.name}&nbsp;&nbsp;</td>
							<td>${model.leaderName}&nbsp;&nbsp;</td>
							<td>${model.pModel.userId}&nbsp;&nbsp;</td>
							<td>${model.provinceStr}${model.cityStr}&nbsp;&nbsp;</td>
							<td>
								<c:if test="${model.status=='1'}">进行中</c:if>
								<c:if test="${model.status=='0'}">已失效</c:if>
							</td>
							<td>
								<span class="add">
									<c:if test="${model.status=='1'}">
									<a href="javascript:if(confirm('确实要关闭${model.title}吗?'))location='recruit_material_close.html?id=${model.id}&status=0'" style="color:white">关闭</a>
									</c:if>
									<c:if test="${model.status=='0'}">
									<a href="javascript:if(confirm('确实要开启${model.title}吗?'))location='recruit_material_close.html?id=${model.id}&status=1'" style="color:white">开启</a>
									</c:if>
								</span>
								<span class="del">
									<a href="javascript:if(confirm('确实要删除${model.title}吗?'))location='recruit_material_del.html?id=${model.id}'" style="color:white">删除</a>
								</span>
							</td>
						</tr>
					</c:forEach> 
					</table>
					
				</div>
				<div class="footer clearfix">
					<div class="footerl">
						<span>每页：</span>
						<input type="text" value="20" name="${page.pageSize}"/>
						<span>条</span>
						<button>确定</button>
						<span>共有</span>
						<span class="footernum">${page.dataCount}</span>
						<span>条记录，当前有</span>
						<span>${page.pageNow}</span><span>/</span><span>${page.pageCount}</span>
						<span>页</span>
					</div>
					<input type="hidden" name="dataCount" value="${page.dataCount}">
					<input type="hidden" name="type" value="${type}"> 
					<input type="hidden" name="userType" value="${userType}">  
					<div class="footerr">
						<button value="1" name="pageNow">首页</button>
						<button value="${page.prePage}" name="pageNow">上一页</button>
						<button value="${page.nextPage}" name="pageNow">下一页</button>
						<button value="${page.lastPage}" name="pageNow">尾页</button>
					</div>

				</div>
			</form>

	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="resource/js/area.js"></script>
	<script type="text/javascript" src="resource/js/team_add.js" charset="utf-8"></script>
</html>


