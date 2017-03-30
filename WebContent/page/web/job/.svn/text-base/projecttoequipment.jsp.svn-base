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
		<form action="projecttoequipment.html" name="form1" method="post" class="struck">
		<div class="title">
			<div class="content">
				<span>设备供应</span>
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
				<li class="entype">设备名称:</li>
				<li><input type="text" name="shopName" value="${shopName}" placeholder="请输入关键字"/></li>
				<li>
					<div class="search" onClick="submitForm()">搜索</div>
				</li>
			</ul>
			
			<table border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th>公司名称</th>
					<th>负责人</th>
					<th>班组类型</th>
					<th>设备名称</th>
					<th>所在区域</th>
					<th>诚信度</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${clist}" var="model"> 
				<tr >
					<td><a href="job_equip.html?eId=${model.rId}&id=${model.id}" style="color: #4488FF;">${model.equipmentModel.name}</a></td>
					<td><a href="web_person_info.html?userId=${model.equipmentModel.userId}" style="color: #4488FF;">${model.equipmentModel.leaderName}</a></td>
					<td>设备班组</td>
					<td>${model.shopName}</td>
					<td>${model.provinceStr}${model.cityStr}</td>
					<td><c:forEach begin="1" end="${model.equipmentModel.reliableStar}">
								   <span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="1" end="${model.equipmentModel.noreliableStar}">
								   <span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach></td>
					<td>
						<div class="employ">
						<a
							href="javascript:if(confirm('确实要邀请${model.name}吗?'))location='projectapplyequipment.html?rId=${model.rId}'"
							style="color: #4488FF;">邀请</a>
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