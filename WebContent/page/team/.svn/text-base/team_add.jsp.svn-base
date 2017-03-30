<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>新增项目</title>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
<link rel="stylesheet" type="text/css" href="resource/css/table.css" />
<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
function inputSapceTrim(e,this_temp) 
{ 
this_temp.value = Trim(this_temp.value,"g"); 
var keynum; 
if(window.event) // IE 
{ 
keynum = e.keyCode 
} 
else if(e.which) // Netscape/Firefox/Opera 
{ 
keynum = e.which 
} 
if(keynum == 32){ 
return false; 
} 
return true; 
} 
</script>
</head>

<body>
	<form action="team_add2.html" method="post">
		<div class='search clearfix'>
			<h3>班组管理</h3>
			<span class="datum">班组管理>>新增班组</span>
			<table border="0" cellspacing="0" cellpadding="0"
				style="display: table; margin: 0 auto;">
				<tr>
					<td><label for="name">班组名称:</label></td>
					<td style="color:red"><input class="inp" id="TeamName" type="text" name="name" placeholder="请输入班组名称" onKeyup="return inputSapceTrim(event,this);"/><span>*必须填写</span></td>
				</tr>
<!-- 				<tr> -->
<!-- 					<td><label for="code">班组编号:</label></td> -->
<!-- 					<td>系统自动编号</td> -->
<!-- 				</tr> -->
				<tr>
					<td><label for="leadername">班组长名称:</label></td>
					<td style="color:red"><input class="inp" type="text" name="leaderName" id="leaderName" placeholder="请输入班组长姓名" /></td>
				</tr>
				<tr>
					<td><label for="mobile">班组长电话:</label></td>
					<td style="color:red"><input class="inp" id="leaderMobile" type="text" name="leaderMobile" placeholder="请输入班组长电话" /><span>*必须填写</span></td>
				</tr>
				<tr>
					<td><label for="bigtype">技能大类型:</label></td>
					<td><select id="skillBigType" onchange="skillBigType1()"
						name="skillBigType" style="width: 96px">
							<option value="222" selected="selected">--请选择技能大类型--</option>
							<option value="1">--土建--</option>
							<option value="2">--管理--</option>
							<option value="3">--安装--</option>
							<option value="4">--其他--</option>
					</select></td>
				</tr>
				<tr>
					<td><label for="smalltype">技能小类型:</label></td>
					<td><select name="smalltype" id="smalltype">
							<option value="-1">请选择技能小类型</option>
					</select></td>
				</tr>
				<tr>
					<td><label for="province">省份:</label></td>
					<td><select id="province"
						onchange="setCity(this.value);getArea();" name="province"
						style="width: 96px" runat="server">
							<option value="${province}" selected="selected">--请选择省份--</option>
					</select></td>
				</tr>
				<tr>
					<td><label for="city">城市:</label></td>
					<td><select id="city"
						onchange="setCounty(this.value);getArea();" name="city"
						style="width: 96px" runat="server">
							<option value="${city}" selected="selected">--请选择城市--</option>
					</select></td>
				</tr>
				<tr>
					<td><label for="phone">详细地址:</label></td>
					<td style="color:red"><input class="inp" type="text" name="street" value="请输入详细地址" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999"/></td>
				</tr>

				<tr>
					<td></td>
					<td><button class="add">添加</button></td>
				</tr>
			</table>

		</div>

		<div class="footer clearfix"></div>


		</div>
		</div>
	</form>
</body>
<!-- <script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script> -->
<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="resource/js/area.js"></script>
<script type="text/javascript" src="resource/js/team_add.js" charset="utf-8"></script>
<script type="text/javascript" src="resource/js/team_add_check.js" charset="utf-8"></script>
<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>

</html>


