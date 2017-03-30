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
		<link rel="stylesheet" type="text/css" href="resource/css/web/enter_info.css"/>
		<link rel="stylesheet" type="text/css" href="resource/css/web/employ.css" />
		<script type="text/javascript">
			function submitForm() {
				return document.form1.submit();
			}
		</script>
	</head>

	<body>
		<jsp:include page="../../top.jsp" flush="true" />
		<form action="web_company_list.html" name="form1" method="post" class="struck">
		<div class="title">
			<div class="content">
				<span>公司信息</span>
			</div>
		</div>
		<div class="content personal">
			<ul class="autotype clearfix">
				<li class="entype">公司类型:</li>
				<li>	<select name="type">
					<option value=""
								<c:if test="${type==''}">selected</c:if>>全部</option>
					   <option value="建筑公司"
								<c:if test="${type=='建筑公司'}">selected</c:if>>建筑公司</option>
							<option value="劳务公司"
								<c:if test="${type=='劳务公司'}">selected</c:if>>劳务公司</option>
							<option value="设计公司"
								<c:if test="${type=='设计公司'}">selected</c:if>>设计公司</option>
							<option value="监理公司"
								<c:if test="${type=='监理公司'}">selected</c:if>>监理公司</option>
							<option value="审图公司"
								<c:if test="${type=='审图公司'}">selected</c:if>>审图公司</option>
							<option value="其他"
								<c:if test="${type=='其他'}">selected</c:if>>其他</option>
					</select></li>
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
				
				<li><input type="text" name="name" value="${name}" placeholder="请输入关键字"/></li>
				<li>
					<div class="search" onClick="submitForm()">搜索</div>
				</li>
				
			</ul>
			<table border="0" cellspacing="1" cellpadding="0">
					<tr>
						<th>公司名</th>
						<th>公司类型</th>
						<th>组织机构代码</th>
						<th>联系人</th>
						<th>认证情况</th>
						<th>所在区域</th>
					</tr>
					<c:forEach items="${clist}" var="model"> 
					<!-- <tr onclick='location.href="web_company_info.html?id=${model.id}"'> -->
					<tr>
						<td><a href="web_company_info.html?id=${model.id}" style="color: #4488FF;">${model.name}</a></td>
						<td>${model.type}</td>
						<td>${model.organization}</td>
						<td>${model.leaderName}</td>
						<td>已审核</td>
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
		<script src="resource/js/web/enter_info.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="resource/js/area.js"></script>
	</body>

</html>