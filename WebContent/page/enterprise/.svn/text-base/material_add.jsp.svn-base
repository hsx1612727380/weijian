<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>新增材料商</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />

	</head>

	<body>
	<form action="material_add2.html" method="post">
				<div class='search clearfix'>
					<h3>材料商管理</h3>
					<span class="datum">材料商管理>>新增材料商</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="uid">材料商代码:</label></td>
						<td style="color:red"><input id="Code" class="inp" type="text" name="code" placeholder="请输入材料商代码"/><span>*必须填写</span></td>
					</tr>
					<tr>
						<td><label for="uid">材料商名称:</label></td>
						<td style="color:red"><input id="Name" class="inp" type="text" name="name" placeholder="请输入材料商名称"/><span>*必须填写</span></td>
					</tr>
					<tr>
						<td><label for="uid">统一社会信用代码:</label></td>
						<td style="color:red"><input id="Licence" class="inp" type="text" name="licence" placeholder="请输入统一社会信用代码"/><span>*必须填写，且为18位</span></td>
					</tr>
					<tr>
						<td><label for="uid">注册资金:</label></td>
						<td><input class="inp" type="text" name="regcapital"/></td>
					</tr>
					<tr>
						<td><label for="uid">成立日期:</label></td>
						<td><input class="inp" type="text" name="establishDate"/></td>
					</tr>
					<tr>
						<td><label for="name">负责人:</label></td>
						<td style="color:red"><input class="inp" type="text" name="leaderName"/></td>
					</tr>
					<tr>
						<td><label for="gender">联系方式:</label></td>
						<td style="color:red"><input id="UserId" class="inp" type="text" name="userId" placeholder="请输入负责人电话"/><span>*必须填写</span></td>
					</tr>
					<tr>
						<td><label for="gender">材料名称:</label></td>
						<td><input class="inp" type="text" name="shopName"/></td>
					</tr>
					<tr>
						<td><label for="province">省份:</label></td>
						<td><select id="province" onchange="setCity(this.value);getArea();" name="province" style="width: 96px" runat="server" >
                              <option value="${province}" selected="selected">--请选择省份--</option>
                    		</select></td>
					</tr>
					<tr>
							<td><label for="city">城市:</label></td>
							<td><select id="city" onchange="setCounty(this.value);getArea();" name="city" style="width: 96px" runat="server">
	                              <option value="${city}" selected="selected">--请选择城市--</option>
	                            </select></td>
					</tr>
					<tr>
							<td><label for="phone">县级:</label></td>
							<td><select id="county" name="county"  style="width: 96px" runat="server" onchange="getArea();">
	                              <option value="${county}" selected="selected" >--请选择县--</option>
	                            </select></td>
					</tr>
					<tr>
						<td><label for="phone">地址街道:</label></td>
						<td><input class="val" type="text" name="street" /></td>
					</tr>
					
					<tr>
						<td></td>
						<td><button class="add">添加</button></td>
					</tr>
				</table>
				
				</div>
				
				<div class="footer clearfix">
				
				</div>
				
				
			</div>
		</div>
		</form>
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/area.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/material_add_check.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>

</html>


