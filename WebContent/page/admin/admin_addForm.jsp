<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<form action="addAdmin.html" method="post">
				<div class='search clearfix'>
					<h3>管理员管理</h3> 
					<span class="datum">管理员管理>>新增管理员</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="uid">登录帐号:</label></td>
						<td><input class="val" type="text" name="accountName" /></td>
					</tr>
					<tr>
						<td><label for="uid">真实姓名:</label></td>
						<td><input class="val" type="text" name="name" /></td>
					</tr>
					<tr>
						<td><label for="uid">手机号:</label></td>
						<td>
							<input class="val" type="text" name="mobile" />
						</td>
					</tr>
					<tr>
						<td><label for="name">密码:</label></td>
						<td><input class="val" type="text" name="password" /></td>
					</tr>
					<tr>
						<td><label for="gender">权限设置:</label></td>
						<td><input name="popedom" type="checkbox" id="popedom" value="01" />公司管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="02" />项目管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="03" />班组管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="04" />材料商管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="05" />设备商管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="06" />诚信档案<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="07" />考勤和人员出入管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="08" />工资发放管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="09" />用户管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="10" />招聘管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="11" />求职管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="13" />招标/行业动态管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="14" />法律咨询与保险管理<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="15" />消息与公告<br/>
 							 <input name="popedom" type="checkbox" id="popedom" value="16" />管理员修改个人资料<br/>
 						</td>
					</tr>
					                 
					<tr>
						<td></td>
						<td><button class="add">添加</button></td>
					</tr>
				</table>
				
				</div>

				

		</form>
		</body>
		</html>



