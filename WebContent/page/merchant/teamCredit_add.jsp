<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>新增班组诚信档案表</title>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/records.css"/>
		
		
		<style type="text/css">
			td input{
			border:none;
			width:100%;
			}
		</style>
	</head>

	<body>
		<form action="teamCredit_add2.html" method="post">
		<div class='search clearfix manage'> 
		<table border="0" cellspacing="1" cellpadding="0" >
			<tr><th colspan="8"><b>班组档案</b></th></tr>
			<tr>
				<td>班组编号</td>
				<td><input class="inp" type="text" name="teamCode" /></td>
				<td colspan="2">班组名称</td>
				<td colspan="4"><input class="inp" type="text" name="teamName"/></td>
			</tr>
			<tr>
				<td>班组长</td>
				<td><input class="inp" type="text" name="name" /></td>
				<td>性别</td>
				<td><input class="inp" type="text" name="gender"/></td>
				<td>民族</td>
				<td><input class="inp" type="text" name="national"/></td>
				<td>文化程度</td>
				<td><input class="inp" type="text" name="education"/></td>
			</tr>
			<tr>
				<td>出生日期</td>
				<td><input class="inp" type="text" name="birth"/></td>
				<td>年龄</td>
				<td><input class="inp" type="text" name="age"/></td>
				<td>身高</td>
				<td><input class="inp" type="text" name="height"/></td>
				<td>体重</td>
				<td><input class="inp" type="text" name="weight"/></td>
			</tr>
			<tr>
				<td colspan="2">身份证号码</td>
				<td colspan="2"><input class="inp" type="text" name="identity"/></td>
				<td>身体状况</td>
				<td><input class="inp" type="text" name="health"/></td>
				<td>婚姻状态</td>
				<td><input class="inp" type="text" name="marriage"/></td>
			</tr>
			
			<tr><th colspan="8"><b>技能</b></th></tr>
			<tr>
				<td colspan="2">技能类别</td>
				<td colspan="2"><select id="skillBigType" onchange="skillBigType1()"
						name="skillBigType">
							<option value="222" selected="selected">--请选择技能大类型--</option>
							<option value="1">--土建--</option>
							<option value="2">--管理--</option>
							<option value="3">--安装--</option>
							<option value="4">--其他--</option>
					</select></td>
				<td colspan="2">技能类型</td>
				<td colspan="2"><select name="smalltype" id="smalltype">
							<option value="-1">请选择技能小类型</option>
					</select></td>
				
			</tr>
			<tr>
				<td>求职状态</td>
				<td><select name="jobstatus">
					    <option value="找工作" >找工作</option>
					    <option value="已工作" >已工作</option>
					</select>
				</td>
				<td>求职地区</td>
				<td colspan="2"><select id="province"
						onchange="setCity(this.value);getArea();" name="province">
							<option value="${province}" selected="selected">--请选择省份--</option>
					</select></td>
					
				<td colspan="3"><select id="city"
					onchange="setCounty(this.value);getArea();" name="city">
						<option value="${city}" selected="selected">--请选择城市--</option>
				</select></td>
	
			</tr>
			<tr><td colspan="8">联系方式及帐号</td></tr>
			<tr>
				<td>银行卡</td>
				<td><input class="inp" type="text" name="bankcard"/></td>
				<td colspan="2">家庭住址</td>
				<td colspan="4"><input class="inp" type="text" name="address"/></td>
			</tr>



			<tr><th colspan="8">电子文档</th></tr>
			<tr>
				<td>进场须知</td>
				<td><input class="inp" type="text" name="guidelines"/></td>
				<td>安全教育</td>
				<td><input class="inp" type="text" name="safety"/></td>
				<td colspan="2">劳动计件计时合同</td>
				<td colspan="2"><input class="inp" type="text" name="contract"/></td>
			</tr>
			
			<tr>
				<td colspan='8'><button class="add" style="background-color:#39B3D7;border:0;color:white;">添加</button></td>
			</tr>
		</table>
		</div>
			<div class="footer clearfix">
			</div>
				
				
		</form>
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="resource/js/team_add.js" charset="utf-8"></script>
	<script type="text/javascript" src="resource/js/area.js"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>