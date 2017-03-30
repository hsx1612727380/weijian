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
		<link rel="stylesheet" type="text/css" href="resource/css/web/team_info.css"/>
		<script type="text/javascript">
			function submitForm() {
				return document.form1.submit();
			}
		</script>
	</head>

	<body>
		<jsp:include page="../../top.jsp" flush="true" />
		<form action="web_equip_list.html" name="form1" method="post" class="struck">
		<div class="title">
			<div class="content">
				<span>设备班组</span>
			</div>
		</div>
		<div class="content personal">
			<ul class="autotype clearfix">
				<li class="entype">设备名称:</li>
				<li>
					<input type="text" name="shopName" value="${shopName}"/>
				</li>
				<li class="entype">所在区域:</li>
				<li>
					<select id="province"
						onchange="setCity(this.value);getArea();" name="province"
						style="width: 96px" runat="server">
							<option value="${province}" selected="selected">请选择省份</option>
					</select>
				</li>
				<li>
					<select id="city"
						onchange="setCounty(this.value);getArea();" name="city"
						style="width: 96px" runat="server">
							<option value="${city}" selected="selected">请选择城市</option>
					</select>
				</li>
				<li class="entype">在职状态:</li>
				<li>
					<select name="status">
						<option value="" <c:if test="${status==''}">selected</c:if>>全部</option>
						<option value="1" <c:if test="${status=='1'}">selected</c:if>>工作中</option>
						<option value="0" <c:if test="${status=='0'}">selected</c:if>>找项目</option>
					</select>
				</li>
				
				<li>
					<div class="search" onClick="submitForm()">搜索</div>
				</li>
			</ul>
			<table border="0" cellspacing="1" cellpadding="0">
					
					<tr>
						<th>设备商名称</th>
						<th>设备名称</th>
						<th>所在区域</th>
						<th>班组类型</th>
						<th>班组长姓名</th>
						<th>诚信度</th>
						<th>状态</th>
					</tr>
					<c:forEach items="${clist}" var="model"> 
					<!-- <tr onclick='location.href="web_equip_info.html?id=${model.id}"'> -->
					<tr>
						<td><a href="web_equip_info.html?id=${model.id}" style="color: #4488FF;">${model.name}</a></td>
						<td>${model.shopName}</td>
						<td>${model.provinceChn}${model.cityChn}</td>
						<td>设备班组</td>
						<td><a href="web_person_info.html?userId=${model.userId}" style="color: #4488FF;">${model.leaderName}</a></td>
						<td><c:forEach begin="1" end="${model.reliableStar}">
								   <span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="1" end="${model.noreliableStar}">
								   <span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach></td>
						<td><c:if test="${model.status=='1'}">工作中</c:if>
							<c:if test="${model.status=='0'}">找项目</c:if></td>
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
		<script src="resource/js/web/team_info.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="resource/js/area.js"></script>
	</body>

</html>