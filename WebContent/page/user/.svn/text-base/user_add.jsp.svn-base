<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>新增用户</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />
	
	</head>
	<script>
	
	</script>
	<body>
	<form action="user_add_submit.html" method="post">
				<div class='search clearfix'>
					<h3>用户管理</h3>
					<span class="datum">用户管理>>新增用户</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="uid">姓名:</label></td>
						<td><input class="inp" type="text" name="userName" /></td>
					</tr>
					<tr>
						<td><label for="code">手机号(登录账号,唯一):</label></td>
						<td><input class="inp" type="text" name="userId" /></td>
					</tr>
					<tr>
						<td><label for="mobile">密码:</label></td>
						<td><input class="inp" type="text" name="userPassword" /></td>
					</tr>
					<tr>
						<td><label for="name">用户类型:</label></td>
						<td><select name="userType">
							    <option value="0" >个人/班组</option>
							    <option value="1" >材料商</option>
							    <option value="2" >设备商</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="mobile">身份证号:</label></td>
						<td><input class="inp" type="text" name="userIdentity" /></td>
					</tr>
				<tr>
					<td><label for="bigtype">技能大类型:</label></td>
					<td><select id="skillBigType" onchange="skillBigType1()" name="skillBigType"
						style="width: 96px">
							<option value="" selected="selected">--请选择技能大类型--</option>
							<option value="1">--土建--</option>
							<option value="2">--管理--</option>
							<option value="3">--安装--</option>
							<option value="4">--其他--</option>
					</select></td>
				</tr>
				<tr>
						<td><label for="smalltype">技能小类型:</label></td>
						<td><select name="skillSmallType" id="smalltype">
      								<option value="-1">请选择技能小类型</option>
   						</select></td>
					</tr>
					<tr>
						<td><label for="province">省份:</label></td>
						<td><select id="province" onchange="setCity(this.value);getArea();" name="userProvince" style="width: 96px" runat="server" >
                              <option value="${province}" selected="selected">--请选择省份--</option>
                    		</select></td>
					</tr>
					<tr>
						<td><label for="city">城市:</label></td>
						<td><select id="city" onchange="setCounty(this.value);getArea();" name="userCity" style="width: 96px" runat="server">
                              <option value="${city}" selected="selected">--请选择城市--</option>
                            </select></td>
					</tr>
					<tr>
						<td><label for="phone">地址街道:</label></td>
						<td><select id="county" name="userStreet"  style="width: 96px" runat="server" onchange="getArea();">
                              <option value="${street}" selected="selected" >--请选择地区--</option>
                            </select></td>
					</tr>
					
					<tr>
						<td></td>
						<td><button class="add">添加</button></td>
					</tr>
				</table>
				
				</div>
				
			</div>
		</div>
		</form>
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="resource/js/area.js" ></script>
	<script type="text/javascript" src="resource/js/team_add.js" charset="utf-8"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>

</html>


