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

				<div class='search clearfix'>
					<h3>用户管理</h3>
					<span class="datum">用户管理>>用户列表</span>
					<form action="user_list_submit.html" method="post">
					<table border="0px" cellspacing="0px" cellpadding="0px">
						<tr>
							<td><label for="uid">姓名:</label></td>
							<td><input class="inp" type="text" name="name" value="${name}"/></td>
							<td><label for="code">手机号:</label></td>
							<td><input class="inp" type="text" name="uId" value="${uId}"/></td>
							<td><label for="name">技能类型:</label></td>
							<td><input class="inp" type="text" name="skillSmallType" value="${skillSmallType}"/></td>
						</tr>
						<tr>
							<td><label for="gender">状态:</label></td>
							<td><select name=userStatus>
								<option value="" <c:if test="${userStatus==''}">selected</c:if>>请选择</option>
							    <option value="找工作" <c:if test="${userStatus=='找工作'}">selected</c:if>>找工作</option>
							    <option value="已工作" <c:if test="${userStatus=='已工作'}">selected</c:if>>已工作</option>
							</select></td>
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
					
					<br/>
					<button class="query" >查询</button>
				</div>
				<div class="ifamelayout">
					<table class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
						<tr>
							<td>姓名</td>
							<td>用户类型</td>
							<td>性别</td>
							<td>手机号</td>
							<td>地区</td>
							<td>诚信度</td>
							<td>技能类型</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${ulist}" var="tmodel"> 
						<tr>
							<td><a href="user_info.html?userId=${tmodel.userId}" style="color:blue">${tmodel.userName}&nbsp;&nbsp;</a></td>
							<td>
							<c:if test="${tmodel.userType=='0' || tmodel.userType=='' || tmodel.userType==null}">个人/班组</c:if>
							<c:if test="${tmodel.userType=='1'}">材料商</c:if>
							<c:if test="${tmodel.userType=='2'}">设备商</c:if>
							<c:if test="${tmodel.userType=='4'}">项目负责人</c:if>
							</td>
							<td><c:if test="${tmodel.userSex=='1'}">男</c:if>
							<c:if test="${tmodel.userSex=='2'}">女</c:if></td>
							<td>${tmodel.userId}&nbsp;&nbsp;</td>
							<td>${tmodel.userProvinceStr}${tmodel.userCityStr}&nbsp;&nbsp;</td>
							<td>
								<c:forEach begin="1" end="${tmodel.reliableStar}">
								   <span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="1" end="${tmodel.noreliableStar}">
								   <span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach>
							</td>
							<td>${tmodel.skillSmallTypeName}&nbsp;&nbsp;</td>
							
							<td>
								<span class="items">
									<a href="user_info.html?userId=${tmodel.userId}" style="color:white">详细</a>
								</span>
							&nbsp;&nbsp;
								<span class="del">
									<a href="javascript:if(confirm('确实要删除${tmodel.userName}吗?'))location='user_del.html?id=${tmodel.id}'" style="color:white">删除</a>
								</span>
							</td>
						</tr>
					</c:forEach> 
					</table>
					
				</div>
				<div class="footer clearfix">
					<div class="footerl">
						<span>每页：</span>
						<input type="text" value="${page.pageSize}" name="${page.pageSize}"/>
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

	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="resource/js/area.js"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


