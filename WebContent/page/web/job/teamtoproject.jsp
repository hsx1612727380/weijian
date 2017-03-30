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
		<link rel="stylesheet" type="text/css" href="resource/css/web/recruit.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/web/enter_info.css"/>
		<script type="text/javascript">
			var msg = "${msg}";
			if(msg != "")
				alert(msg);
			if(msg == "您还没有登录,请登录后再操作！")
				window.location.href="toLogin.html";
			function submitForm() {
				return document.form1.submit();
			}
		</script>
	</head>

	<body>
		<jsp:include page="../../top.jsp" flush="true" />
		<form action="teamtoproject.html" name="form1" method="post" class="struck">
		<div class="title">
			<div class="content">
				<span><c:if test="${teamType=='1'}">班组招聘</c:if>
				<c:if test="${teamType=='2'}">材料采购</c:if>
				<c:if test="${teamType=='3'}">设备租赁</c:if></span>
			</div>
		</div>
		<div class="content personal">
			<ul class="autotype clearfix">
				<li class="entype">所在区域:</li>
				<li>
					<select id="province"
						onchange="setCity(this.value);getArea();" name="province"
						style="width: 96px" runat="server">
							<option value="${province}" selected="selected">请选择省份</option>
					</select>
					<select id="city"
						onchange="setCounty(this.value);getArea();" name="city"
						style="width: 96px" runat="server">
							<option value="${city}" selected="selected">请选择城市</option>
					</select>
				</li>
				<input type="hidden" name="teamType" value="${teamType}">
				<c:if test="${teamType=='1'}">
				<li>技能类别:</li>
				<li>
					<select id="skillBigType" onchange="skillBigType1()"
						name="skillBigType" style="width: 96px">
							<option value="" <c:if test="${skillBigType==''}">selected</c:if>>请选择</option>
							<option value="1" <c:if test="${skillBigType=='1'}">selected</c:if>>--土建--</option>
							<option value="2" <c:if test="${skillBigType=='2'}">selected</c:if>>--管理--</option>
							<option value="3" <c:if test="${skillBigType=='3'}">selected</c:if>>--安装--</option>
							<option value="4" <c:if test="${skillBigType=='4'}">selected</c:if>>--其他--</option>
					</select>
				</li>
				<li class="entype">技能类型:</li>
				<li>
					<select name="smalltype" id="smalltype">
							<option value="${smalltype}" selected="selected">请选择</option>
					</select>
				</li>
				</c:if>
				<li>
					<div class="search" onClick="submitForm()">搜索</div>
				</li>
			</ul>
			
			<table border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th>公司名称</th>
					<th>项目名称</th>
					<th>班组类型</th>
					<c:if test="${teamType=='1'}">
					<th>技能类别</th>
					<th>技能类型</th>
					</c:if>
					<c:if test="${teamType=='2'}">
					<th>材料名称</th>
					</c:if>
					<c:if test="${teamType=='3'}">
					<th>设备名称</th>
					</c:if>
					<th>所在区域</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${clist}" var="model"> 
				<tr>
					<c:if test="${teamType=='1'}">
						<td><a href="recruit_team.html?pId=${model.rId}&id=${model.id}" style="color: #4488FF;">${model.cModel.name}</a></td>
						<td><a href="recruit_team.html?pId=${model.rId}&id=${model.id}" style="color: #4488FF;">${model.name}</a></td>
						<td>施工班组</td>
					</c:if>
					<c:if test="${teamType=='2'}">
						<td><a href="recruit_material.html?pId=${model.rId}&id=${model.id}" style="color: #4488FF;">${model.cModel.name}</a></td>
						<td><a href="recruit_material.html?pId=${model.rId}&id=${model.id}" style="color: #4488FF;">${model.name}</a></td>
						<td>材料班组</td>
					</c:if>
					<c:if test="${teamType=='3'}">
						<td><a href="recruit_equip.html?pId=${model.rId}&id=${model.id}" style="color: #4488FF;">${model.cModel.name}</a></td>
						<td><a href="recruit_equip.html?pId=${model.rId}&id=${model.id}" style="color: #4488FF;">${model.name}</a></td>
						<td>设备班组</td>
					</c:if>
					<c:if test="${teamType=='1'}">
						<td>${model.skillBigTypeName}</td>
						<td>${model.skillSmallTypeName}</td>
					</c:if>
					<c:if test="${teamType=='2' || teamType=='3'}">
						<td>${model.shopName}</td>
					</c:if>
					<td>${model.provinceStr}${model.cityStr}</td>
					<td>
						<div class="employ">
						<a
							href="javascript:if(confirm('确实要申请${model.name}吗?'))location='teamapplyproject.html?id=${model.id}'"
							style="color: #4488FF;">申请</a>
						
						</div>
					</td>
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
		<script src="resource/js/web/recruit_team.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="resource/js/area.js"></script>
		<script type="text/javascript" src="resource/js/team_add.js" charset="utf-8"></script>
		<script src="resource/js/web/enter_info.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>