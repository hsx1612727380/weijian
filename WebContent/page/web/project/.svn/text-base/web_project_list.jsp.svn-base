<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/web/project_info.css"/>
		<link rel="stylesheet" type="text/css" href="resource/css/web/enter_info.css"/>
		<script type="text/javascript">
			function submitForm() {
				return document.form1.submit();
			}
		</script>
	</head>

	<body>
		<jsp:include page="../../top.jsp" flush="true" />
		<form action="web_project_list.html" name="form1" method="post" class="struck">
		<div class="title">
			<div class="content">
				<span>项目列表</span>
			</div>
		</div>
		<div class="content personal">
			<ul class="projecttype clearfix">
				
				<li class="entype">所在区域</li>
				<li>
					 <select
						id="province" onchange="setCity(this.value);getArea();"
						name="province">
							<option value="${province}">--请选择省份--</option>
					</select> 
				    <select id="city" onchange="setCounty(this.value);getArea();"
										name="city" >
											<option value="${city}" selected="selected">--请选择城市--</option>
						</select>
				</li>
				<li class="entype">状态</li>
				<li>
				<select name="status">
				 	<option value="" <c:if test="${status==''}">selected</c:if>>全部</option>
				    <option value="未开始" <c:if test="${status=='未开始'}">selected</c:if>>未开始</option>
				    <option value="已开始" <c:if test="${status=='已开始'}">selected</c:if>>已开始</option>
				    <option value="已完成" <c:if test="${status=='已完成'}">selected</c:if>>已完成</option>
				</select></li>
				<li><input type="text" name="name" value="${name}" placeholder="请输入关键字"/></li>
				<li>
					<div class="search" onClick="submitForm()">搜索</div>
				</li>
			</ul>
			<table border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th>项目编号</th>
					<th>项目名称</th>
					<th>项目负责人</th>
					<th>建设单位</th>
					<th>状态</th>
					<th>所在区域</th>
				</tr>
				<c:forEach items="${clist}" var="model"> 
				<!-- <tr onclick='location.href="web_project_info.html?id=${model.id}"'> -->
				<tr>
					<td><a href="web_project_info.html?id=${model.id}" style="color: #4488FF;">${model.pCode}</a></td>
					<td><a href="web_project_info.html?id=${model.id}" style="color: #4488FF;">${model.name}</a></td>
					<td><a href="web_person_info.html?userId=${model.userId}" style="color: #4488FF;">${model.leaderName}</a></td>
					<td><a href="web_company_info.html?id=${model.companyModel.id}" style="color: #4488FF;">${model.companyModel.name}</a></td>
					<td>
					<c:if test="${model.status==0}">未开始</c:if>
					<c:if test="${model.status==1}">进行中</c:if>
					<c:if test="${model.status==2}">已完成</c:if>
					</td>
					<td>${model.provinceChn}${model.cityChn}</td>
				</tr>
				</c:forEach>
				
			</table>
			<div class="tabfooter">
				<button value="1" name="pageNow">首页</button>
				<button value="${page.prePage}" name="pageNow">上一页</button>
				<span>当前有</span>
						<span>${page.pageNow}</span><span>/</span><span>${page.pageCount}</span>
						<span>页</span>
				<button value="${page.nextPage}" name="pageNow">下一页</button>
				<button value="${page.lastPage}" name="pageNow">尾页</button>

			</div>
		</div>
		</form>
		<jsp:include page="../../down.jsp" flush="true" />
		
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/web/project_info.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="resource/js/area.js"></script>
	</body>

</html>