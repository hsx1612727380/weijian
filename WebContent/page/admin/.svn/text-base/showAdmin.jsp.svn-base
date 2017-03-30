<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>
<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<!--引入Bootstrap -->
			<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />
	
       <script type="text/javascript" src="resource/js/jquery.js"> </script>
         <script type="text/javascript" src="resource/js/xcConfirm.js"></script><!-- alert js引用-->	
</head>
<body>

	
		
		<form action="updateAdmin.html" method="post">
				<div class='search clearfix'>
					<h3>管理员管理</h3> 
					<span class="datum">管理员管理>>查看管理员</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="uid">登录帐号:</label></td>
						<td>${admin.accountName}</td>
					</tr>
					<tr>
						<td><label for="uid">真实姓名:</label></td>
						<td><input class="val" type="text" name="name" value="${admin.name}"/></td> 
					</tr>
					<tr>
						<td><label for="uid">手机号:</label></td>
						<td>
							<input class="val" type="text" name="mobile" value="${admin.mobile}"/> 
						</td>
					</tr>
					<tr>
						<td><label for="name">密码:</label></td>
						<td><input class="val" type="text" name="password" value="${admin.password}"/></td>
						 
					</tr>
					<tr>
						<td><label for="gender">权限设置:</label></td>
						<td><input name="popedom" type="checkbox" id="popedom" value="01" <c:if test="${fn:contains(admin.popedom,'01')}">checked="checked"</c:if>/>公司管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="02" <c:if test="${fn:contains(admin.popedom,'02')}">checked="checked"</c:if>/>项目管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="03" <c:if test="${fn:contains(admin.popedom,'03')}">checked="checked"</c:if>/>班组管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="04" <c:if test="${fn:contains(admin.popedom,'04')}">checked="checked"</c:if>/>材料商管理<br/> 
 							 <input name="popedom" type="checkbox" id="popedom" value="05" <c:if test="${fn:contains(admin.popedom,'05')}">checked="checked"</c:if>/>设备商管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="06" <c:if test="${fn:contains(admin.popedom,'06')}">checked="checked"</c:if>/>诚信档案<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="07" <c:if test="${fn:contains(admin.popedom,'07')}">checked="checked"</c:if>/>考勤和人员出入管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="08" <c:if test="${fn:contains(admin.popedom,'08')}">checked="checked"</c:if>/>工资发放管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="09" <c:if test="${fn:contains(admin.popedom,'09')}">checked="checked"</c:if>/>用户管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="10" <c:if test="${fn:contains(admin.popedom,'10')}">checked="checked"</c:if>/>招聘<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="11" <c:if test="${fn:contains(admin.popedom,'11')}">checked="checked"</c:if>/>求职<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="13" <c:if test="${fn:contains(admin.popedom,'13')}">checked="checked"</c:if>/>招标/行业动态<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="14" <c:if test="${fn:contains(admin.popedom,'14')}">checked="checked"</c:if>/>法律咨询与保险<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="15" <c:if test="${fn:contains(admin.popedom,'15')}">checked="checked"</c:if>/>消息与公告<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="16" <c:if test="${fn:contains(admin.popedom,'16')}">checked="checked"</c:if>/>管理员修改个人资料<br/>
 						</td>
					</tr>
					                 
					<tr>
						<td><input type="hidden" name="id" value="${admin.id}"> </td>
						<td><button class="add">修改</button></td>
					</tr>
				</table>
				
				</div>
				
		</form> 
		</body>
		</html>

 