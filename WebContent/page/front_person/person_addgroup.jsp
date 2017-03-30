<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<!-- 针对不同的登录用户类型隐藏左侧菜单的js -->
		<script src="resource/js/front_person/person_left_handler.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/personAddgroud.css" />
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<input type="hidden" id="type2" name="type2" value="${type}"/> 
	 	<jsp:include page="../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>个人中心</span>
			</div>
		</div>
		<div class="content personal">
			<div class="autstate">
				<span>认证状态：已认证</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>角色：个人</span>
				&nbsp;&nbsp;&nbsp;&nbsp;<font color="darkblue">创建班组</font>
			</div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
			</div>
			<div id="main">
					<div class="detailright">
					<div class="persontitle">
						<div class="filetile">申请加入班组</div>
					</div>
					<table class="addground" border="0" cellspacing="1" cellpadding="0">
						<tr>
							<td>班组名称</td>
							<td>班组编号</td>
							<td>班组长名称</td>
							<td>负责人电话</td>
							<td>技能大类型</td>
							<td>技能小类型</td>
							<td>状态</td>
							<td>所在地区</td>
							<td>详细地址</td>
							<td>诚信度</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${tlist}" var="tmodel"> 
						<tr>
							<td>${tmodel.name}1111111111111</td>
							<td>${tmodel.code}</td>
							<td>${tmodel.leaderName}</td>
							<td>${tmodel.leaderMobile}</td>
							<td>${tmodel.skillBigTypeName}</td>
							<td>${tmodel.skillSmallTypeName}</td>
							<td>${tmodel.status}</td>
							<td>${tmodel.provinceChn}${tmodel.cityChn}</td>
							<td>${tmodel.street}</td>
							<td>
								<c:forEach begin="1" end="${tmodel.reliableStar}">
								   <span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="1" end="${tmodel.noreliableStar}">
								   <span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach>
								
							</td>
							<td>
								
								
								<span class="add">
									<a href="team_memberlist.html?id=${tmodel.id}" style="color:white">查看</a>
								</span>
							
								<span class="del">
									<a href="javascript:if(confirm('确实要删除${tmodel.name}吗?'))location='team_del.html?id=${tmodel.id}'" style="color:white">删除</a>
								</span>
							</td>
						</tr>
					</c:forEach> 
					</table>
					
					
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
		</div>
		<jsp:include page="../down.jsp" flush="true" />
</body>
</html>