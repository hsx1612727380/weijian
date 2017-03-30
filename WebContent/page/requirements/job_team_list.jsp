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
<form action="job_team_list.html" method="post">
				<div class='search clearfix'>
					<h3>求职</h3>
					<span class="datum">求职>>班组求职</span>
					
					<table border="0px" cellspacing="0px" cellpadding="0px">
						<tr>
							<td><label for="uid">班组名称:</label></td>
							<td><input type="text" name="name" value="${name}"/></td>
							
							<td><label for="name">技能类型:</label></td>
							<td><select id="skillBigType" onchange="skillBigType1()"
								name="skillBigType" >
									<option value="" selected="selected">--请选择技能大类型--</option>
									<option value="1">--土建--</option>
									<option value="2">--管理--</option>
									<option value="3">--安装--</option>
									<option value="4">--其他--</option>
									
									<option value="1"
									<c:if test="${skillBigType=='1'}">selected</c:if>>--土建--</option>
									<option value="2"
									<c:if test="${skillBigType=='2'}">selected</c:if>>--管理--</option>
									<option value="3"
									<c:if test="${skillBigType=='3'}">selected</c:if>>--安装--</option>
									<option value="4"
									<c:if test="${skillBigType=='4'}">selected</c:if>>--其他--</option>
									
							</select></td>
							<td><label for="smalltype">技能小类型:</label></td>
							<td><select name="smalltype" id="smalltype">
									<option value="${smalltype}" selected="selected">请选择技能小类型</option>
							</select></td>
							
						</tr>
						<tr>
							<td><label for="code">班组长:</label></td>
							<td><input type="text" name="leaderName" value="${leaderName}"/></td>
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
						
					</table>
					<br />
					<button class="query" >查询</button>
				</div>
				<div class="ifamelayout">
						<span class="items"><a href="job_team_add.html">添加</a></span>
							
					<table class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
						<tr>
							<td>标题</td>
							<td>班组名称</td>
							<td>班组长</td>
							<td>联系方式</td>
							<td>班组人数</td>
							<td>求职地区</td>
							<td>技能类型</td>
							<td>技能类别</td>
							<td>状态</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${list}" var="tmodel"> 
						<tr>
							<td>${tmodel.title}&nbsp;&nbsp;</td>
							<td>${tmodel.name}&nbsp;&nbsp;</td>
							<td>${tmodel.teamModel.leaderName}&nbsp;&nbsp;</td>
							<td>${tmodel.teamModel.leaderMobile}&nbsp;&nbsp;</td>
							<td>${tmodel.teamModel.num}&nbsp;&nbsp;</td>
							<td>${tmodel.provinceStr}${tmodel.cityStr}&nbsp;&nbsp;</td>
							<td>${tmodel.skillBigTypeName}</td>
							<td>${tmodel.skillSmallTypeName}</td>
							<td>
								<c:if test="${tmodel.status=='1'}">进行中</c:if>
								<c:if test="${tmodel.status=='0'}">已失效</c:if>
							</td>
							<td>
								<span class="add">
									<c:if test="${tmodel.status=='1'}">
									<a href="javascript:if(confirm('确实要关闭${tmodel.title}吗?'))location='job_team_close.html?id=${tmodel.id}&status=0'" style="color:white">关闭</a>
									</c:if>
									<c:if test="${tmodel.status=='0'}">
									<a href="javascript:if(confirm('确实要开启${tmodel.title}吗?'))location='job_team_close.html?id=${tmodel.id}&status=1'" style="color:white">开启</a>
									</c:if>
								</span>
								<span class="del">
									<a href="javascript:if(confirm('确实要删除${tmodel.title}吗?'))location='job_team_del.html?id=${tmodel.id}'" style="color:white">删除</a>
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


