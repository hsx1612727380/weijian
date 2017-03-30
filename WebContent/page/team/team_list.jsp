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
	
	<body>
	<form action="team_list2.html" method="post">
					
				<div class='search clearfix'>
					<h3>班组管理</h3>
					<span class="datum">班组管理>>班组列表</span>
					<table border="0px" cellspacing="0px" cellpadding="0px">
						<tr>
							<td><label for="uid">班组名称:</label></td>
							<td><input class="inp" type="text" name="name" value="${name}"/></td>
							<td><label for="code">班组编号:</label></td>
							<td><input class="inp" type="text" name="code" value="${code}"/></td>
							<td><label for="name">班组长姓名:</label></td>
							<td><input class="inp" type="text" name="leaderName" value="${leaderName}"/></td>
							
						</tr>
						<tr>
							<td><label for="gender">手机号:</label></td>
							<td><input class="inp" type="text" name="leaderMobile" value="${leaderMobile}"/></td>
						
			                <td >地区：</td>
			                <td colspan="2">
			                <span id="Span2"><select id="province" onchange="setCity(this.value);getArea();" name="province"runat="server">
						                              <option value="${province}">--请选择省份--</option>
						                            </select>
						
						                           </td><td><select id="city" onchange="setCounty(this.value);getArea();" name="city" runat="server">
						                              <option value="${city}" selected="selected">--请选择城市--</option>
						                            </select>
						       </span>                       
			              </td>
			 			 </tr>
						
					</table>
					<br />
					<button class="query" >查询</button>
				</div>
				<div class="ifamelayout">
					<table class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
						<tr>
							<td>班组名称&nbsp;&nbsp;</td>
							<td>班组编号&nbsp;&nbsp;</td>
							<td>班组长名称&nbsp;&nbsp;</td>
							<td>负责人电话&nbsp;&nbsp;</td>
							<td>技能大类型&nbsp;&nbsp;</td>
							<td>技能小类型&nbsp;&nbsp;</td>
							<td>状态&nbsp;&nbsp;</td>
							<td>所在地区&nbsp;&nbsp;</td>
							<td>诚信度&nbsp;&nbsp;</td>
							<td>&nbsp;&nbsp;操作&nbsp;&nbsp;</td>
						</tr>
						<c:forEach items="${tlist}" var="tmodel"> 
						<tr>
							<td><a href="team_memberlist.html?id=${tmodel.id}" style="color:blue">${tmodel.name}&nbsp;&nbsp;</a></td>
							<td>${tmodel.code}&nbsp;&nbsp;</td>
							<td>${tmodel.leaderName}&nbsp;&nbsp;</td>
							<td>${tmodel.leaderMobile}&nbsp;&nbsp;</td>
							<td>${tmodel.skillBigTypeName}&nbsp;&nbsp;</td>
							<td>${tmodel.skillSmallTypeName}&nbsp;&nbsp;</td>
							<td><c:choose>
							<c:when test="${tmodel.status == '1'}">已工作&nbsp;&nbsp;</c:when>
							<c:otherwise>找工作&nbsp;&nbsp;</c:otherwise></c:choose>
							</td>
							<td>${tmodel.provinceChn}${tmodel.cityChn}</td>
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
							
								<%-- <span class="del">
									<a href="javascript:if(confirm('确实要删除${tmodel.name}吗?'))location='team_del.html?id=${tmodel.id}'" style="color:white">删除</a>
								</span> --%>
							</td>
						</tr>
					</c:forEach> 
					</table>
					
					<div class="delnote" id="delnote">
						<p>确定删除信息？</p>
						<button class="sure">确定</button>
						<button class="cancel">取消</button>
					</div>
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
			</form>
	
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="resource/js/area.js" ></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


