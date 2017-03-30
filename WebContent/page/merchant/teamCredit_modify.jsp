<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>修改班组诚信档案表</title>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/records.css"/>
		<link rel="stylesheet" type="text/css" href="resource/css/input.css"/>
		
		<style type="text/css">
			td input{
			border:none;
			width:100%;
			}
		</style>
	</head>

	<body>
		<form action="teamCredit_modify2.html" method="post">
		<div class='search clearfix manage'> 
		<table border="1px solid #555555" cellspacing="0" cellpadding="0" >
			<tr><th colspan="8">班组档案</th></tr>
			<tr>
				<th>班组编号</th>
				<td>${model.teamCode}</td>
				<th colspan="2">班组名称</th>
				<td colspan="4">${model.teamName}</td>
			</tr>
			<tr>
				<th>班组长</th>
				<td><input class="inp" type="text" name="name" value="${model.name}" /></td>
				<th>性别</th>
				<td><input class="inp" type="text" name="gender" value="${model.gender}" /></td>
				<th>民族</th>
				<td><input class="inp" type="text" name="national" value="${model.national}" /></td>
				<th>文化程度</th>
				<td><input class="inp" type="text" name="education" value="${model.education}" /></td>
			</tr>
			<tr>
				<th>出生日期</th>
				<td><input class="inp" type="text" name="birth" value="${model.birth}" /></td>
				<th>年龄</th>
				<td><input class="inp" type="text" name="age" value="${model.age}" /></td>
				<th>身高</th>
				<td><input class="inp" type="text" name="height" value="${model.height}" /></td>
				<th>体重</th>
				<td><input class="inp" type="text" name="weight" value="${model.weight}" /></td>
			</tr>
			<tr>
				<th colspan="2">身份证号码</th>
				<td colspan="2"><input class="inp" type="text" name="identity" value="${model.identity}" /></td>
				<th>身体状况</th>
				<td><input class="inp" type="text" name="health" value="${model.health}" /></td>
				<th>婚姻状态</th>
				<td><input class="inp" type="text" name="marriage" value="${model.marriage}" /></td>
			</tr>
			
			<tr><th colspan="8">技能</th></tr>
			<tr>
				<th>技能类别</th>
				<td>${model.skillBigTypeName}</td>
				<th>技能类型</th>
				<td>${model.skillSmallTypeName}</td>
				<th>求职地区</th>
				<td colspan="2"><span id="Span2"><select
										id="province" onchange="setCity(this.value);getArea();"
										name="province" runat="server">
											<option value="${model.province}">--请选择省份--</option>
									</select> </td>
									<td><select id="city" onchange="setCounty(this.value);getArea();"
										name="city" runat="server">
											<option value="${model.city}" selected="selected">--请选择城市--</option>
						</select>
					</span></td>
			</tr>
			<tr>
				<th>求职状态</th>
				<td><input class="val" type="text" name="jobstatus" value="${model.jobstatus}" /></td>
				<th>诚信度</th>
				<td colspan="5">
				<c:forEach begin="1" end="${tModel.reliableStar}">
						   <span><img src="resource/images/u662.png"/></span>
						</c:forEach>
						<c:forEach begin="1" end="${tModel.noreliableStar}">
						   <span><img src="resource/images/u663.fw.png"/></span>
						</c:forEach>
				</td>
			</tr>
			<tr><th colspan="8">联系方式及帐号</th></tr>
			<tr>
				<th>银行卡</th>
				<td><input class="inp" type="text" name="bankcard" value="${model.bankcard}" /></td>
				<th colspan="2">家庭住址</th>
				<td colspan="4"><input class="inp" type="text" name="address" value="${model.address}" /></td>
			</tr>



			<tr><th colspan="8">电子文档</th></tr>
			<tr>
				<th>进场须知</th>
				<td><input class="inp" type="text" name="guidelines" value="${model.guidelines}" /></td>
				<th>安全教育</th>
				<td><input class="inp" type="text" name="safety" value="${model.safety}" /></td>
				<th colspan="2">劳动计件计时合同</th>
				<td colspan="2"><input class="inp" type="text" name="contract" value="${model.contract}" /></td>
			</tr>
			
			<tr>
				<th colspan='8'><button class="add" style="background-color:white;">修改</button></th>
			</tr>
		</table>
		</div>
			<div class="footer clearfix">
				<input type="hidden" name="id" value="${model.id}"> 
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