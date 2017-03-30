<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="resource/css/index.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/web/team_info.css"/>
		<script type="text/javascript">
			function submitForm() {
				return document.form1.submit();
			}
		</script>
		<style type="text/css">
			.keyword{color: yellow;font-weight: bold }
		</style>
	</head>

	<body>
		<div class="content clearfix navbox">
			<div class="nav clearfix" id="nav clearfix" >
				<h1><a href="index.html"></a></h1>
				
				<form name="form1" action="web_search.html" method="post">
				<div class="searchbar" id="searchbar">
					<div class="searchsel" id="searchsel">
						
						<select name="type" style="height:30px;width:100px">
						    <option value="1" <c:if test="${type=='1'}">selected</c:if>>工程信息</option>
						    <option value="2" <c:if test="${type=='2'}">selected</c:if>>施工队伍</option>
						    <option value="3" <c:if test="${type=='3'}">selected</c:if>>个人劳务</option>
						    
						</select>
						
					</div>
					<div class="searchcol"><input type="text" name="text" value="${text}"/></div>
					<button>搜索</button>
				</div>
				</form>
				<div class='login' id='login'><a href="from_RegFrom.html">注册</a><a href="toLogin.html">登录</a></div>
				<div class='logout' id='logout'><a href="logout.html">注销</a></div>
			</div>
		</div>
		<div class="title">
			<div class="content">
				<span>站内搜索</span>
			</div>
		</div>
		<div class="content personal" id="ss">
			<div class="enter">查询结果</div>
			<table border="0" cellspacing="1" cellpadding="0">
				
			<c:if test="${type=='1'}">
				<tr>
					<th>项目编号</th>
					<th>项目名称</th>
					<th>状态</th>
					<th>所在区域</th>
				</tr>
				<c:forEach items="${pList}" var="model"> 
				<tr onclick='location.href="web_project_info.html?id=${model.id}"'>
					<td>${model.code}</td>
					<td>${model.name}</td>
					<td>${model.status}</td>
					<td>${model.provinceChn}${model.cityChn}</td>
				</tr>
				</c:forEach>
			</c:if>
			<c:if test="${type=='2'}">
						<tr>
							<th>所在区域</th>
							<th>班组名称</th>
							<th>班组类型</th>
							<th>技能类别</th>
							<th>技能类型</th>
							<th>班组长姓名</th>
							<th>诚信度</th>
							<th>班组人数</th>
							<th>在职状态</th>
						</tr>
						<c:forEach items="${tList}" var="model"> 
						<tr onclick='location.href="web_team_info.html?tId=${model.id}"'>
							<td>${model.provinceChn}${model.cityChn}</td>
							<td>${model.name}</td>
							<td>施工班组</td>
							<td>${model.skillBigTypeName}</td>
							<td>${model.skillSmallTypeName}</td>
							<td>${model.leaderName}</td>
							<td><c:forEach begin="1" end="${model.reliableStar}">
									   <span><img src="resource/images/u662.png"/></span>
									</c:forEach>
									<c:forEach begin="1" end="${model.noreliableStar}">
									   <span><img src="resource/images/u663.fw.png"/></span>
									</c:forEach></td>
							<td>${model.num}</td>
							<td><c:if test="${model.status=='1'}">工作中</c:if>
								<c:if test="${model.status=='0'}">找项目</c:if></td>
						</tr>
						</c:forEach>
						
				
				</c:if>
				<c:if test="${type=='3'}">
					<tr>
					<th>姓名</th>
					<th>性别</th>
					<th>手机号</th>
					<th>技能类别</th>
					<th>技能类型</th>
					<th>求职区域</th>
					<th>诚信度</th>
				</tr>
				<c:forEach items="${uList}" var="model"> 
				<tr  onclick='location.href="web_person_info.html?userId=${model.userId}"'>
					<td>${model.userName}</td>
					<td>${model.userSex}</td>
					<td>${model.userId}</td>
					<td>${model.skillBigTypeName}</td>
					<td>${model.skillSmallTypeName}</td>
					<td>${model.userProvinceStr}${model.userCityStr}</td>
					<td><c:forEach begin="1" end="${model.reliableStar}">
								   <span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="1" end="${model.noreliableStar}">
								   <span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach>
					</td>
					
				</tr>
				</c:forEach>
				</c:if>
			</table>
			
		</div>
		 <jsp:include page="down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/web/team_info.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" >
			
				var ym=document.getElementById('ss').innerHTML;//ss是要高亮的区域，div的id值
				document.getElementById('ss').innerHTML=ym.replace(/${text}/g, "<span style='background:yellow'>${text}</span>");
		</script>
	</body>

</html>