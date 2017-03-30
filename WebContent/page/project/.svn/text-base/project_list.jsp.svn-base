<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>项目列表</title>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
<link rel="stylesheet" type="text/css" href="resource/css/table.css" />



</head>
<script type="text/javascript">
	function del(id) {
		alert("111");
		window.parent.location.href = "project_del.html?id=" + id;
	}
</script>
<body>

	<div class='search clearfix'>
		<h3>项目管理</h3>
		<span class="datum">项目管理>>项目列表</span>
		<form action="project_list2.html" method="post">
			<table border="0px" cellspacing="0px" cellpadding="0px">
				<tr>
					<td><label for="gender">公司代码:</label></td>
					<td><input class="inp" type="text" name="code" value="${code}" /></td>
					<td><label for="uid">项目名称:</label></td>
					<td><input class="inp" type="text" name="name" value="${name}" /></td>
					<td><label for="name">负责人:</label></td>
					<td><input class="inp" type="text" name="leaderName" value="${leaderName}" /></td>
				</tr>
				<tr>
					<td><label for="gender">负责人手机号:</label></td>
					<td><input class="inp" type="text" name="uId" value="${uId}" /></td>
					<!-- <td><label for="province">省份:</label></td>
							<td><input type="text" name="province" value="${province}"/></td>
							<td><label for="city">城市:</label></td>
							<td><input type="text" name="city" value="${city}"/></td>  -->
					<td><label>地区：</label></td>
					
					<td><span id="Span2"> <select
							id="province" onchange="setCity(this.value);getArea();"
							name="province" runat="server">
								<option value="${province}">--请选择省份--</option>
						
						</select> </td>
						<td></td>
						<td><select id="city" onchange="setCounty(this.value);getArea();"
							name="city" runat="server">
								<option value="${city}" selected="selected">--请选择城市--</option>
						</select>
					</span></td>
				</tr>
			</table>
			<br />
			<button class="query">查询</button>
	</div>
	<div class="ifamelayout">
		<table id="mytable"  class="querytable" border="1px" cellspacing="0"
			cellpadding="3px" style="text-align: center;">
			<thead>
			<tr>
				<th>公司代号</th>
				<th>项目名称</th>
				<th>项目编号</th>
				<th>负责人</th>
				<th>负责人电话</th>
				<th>省份</th>
				<th>完成度</th>
				<th>是否审核</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${plist}" var="model">
				<tr>
					<td><a href="company_projectlist.html?code=${model.code}" style="color: green">${model.code}</a></td>
					<td><a href="project_info.html?id=${model.id}" style="color: blue">${model.name}</a></td>
					<td>${model.pCode}</td>
					<td>${model.leaderName}</td>
					<td>${model.userId}</td>
					<td>${model.provinceChn}</td>
					<td>${model.progress}%</td>
					<td><c:choose>
							<c:when test="${model.check== '1'}">  
							        已审核       
							   </c:when>
							<c:otherwise>
								<span class="del"> <a
									href="javascript:if(confirm('确实要审核通过${model.name}吗?'))location='project_pass.html?id=${model.id}'"
									style="color: white">审核</a>
								</span>
							</c:otherwise>
						</c:choose></td>
					<td>
						<c:if test="${model.status=='0'}">未开始</c:if>
						<c:if test="${model.status=='1'}">进行中</c:if>
						<c:if test="${model.status=='2'}">已完成</c:if>
					</td>
					<td><span class="items"> <a
							href="project_info.html?id=${model.id}" style="color: white">详情</a>
					</span> &nbsp;&nbsp; <span class="add"> <a
							href="project_modify.html?id=${model.id}" style="color: white">修改</a>
					</span> &nbsp;&nbsp; <span class="del"> <a
							href="javascript:if(confirm('确实要删除${model.name}吗?'))location='project_del.html?id=${model.id}'"
							style="color: white">删除</a>
					</span> &nbsp;&nbsp; <span class="add"> <a
							href="cmdsumm_time.html?id=${model.id}" style="color: white">汇总</a>
					</span></td>
				</tr>
			</c:forEach>
			</tbody>

		</table>

		<div class="delnote" id="delnote">
			<p>确定删除信息？</p>
			<button class="sure">确定</button>
			<button class="cancel">取消</button>
		</div>
	</div>
	<div class="footer clearfix">
		<div class="footerl">
			<span>每页：</span> <input type="text" value="${page.pageSize}"
				name="pageSize" /> <span>条</span>
			<button>确定</button>
			<span>共有</span> <span class="footernum">${page.dataCount}</span> <span>条记录，当前有</span>
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
<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="resource/js/silder.js" type="text/javascript"
	charset="utf-8"></script>
<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="resource/js/area.js"></script>
<script language="JavaScript" type="text/javascript" src="resource/js/jquery.tablesorter.min.js"></script>
<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
$("#mytable").tablesorter();
</script>

</html>


