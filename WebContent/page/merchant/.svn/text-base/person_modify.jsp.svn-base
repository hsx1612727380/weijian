<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>修改个人诚信档案表</title>
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
		<form action="person_modify2.html" method="post">
		<div class='search clearfix manage'> 
		<table border="1px solid #555555" cellspacing="0" cellpadding="0" >
			<tr><th colspan="8">个人档案</th></tr>
			<tr>
				<th>姓名</th>
				<td><input class="inp" type="text" name="name" value="${model.name}" /></td>
				<th>性别</th>
				<td><select name="gender">
					    <option value="1" >男</option>
					    <option value="2" >女</option>
					</select></td>
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
			<tr>
				<th>电话</th>
				<td colspan='7'>${model.userId}</td>
			</tr>
			<tr><th colspan="8">技能</th></tr>
			<tr>
				<th>技能类别:</th>
				<td>
					<span>
					<%-- <input name="skillBigType" value="${personModel.skillBigType}"/> --%>
						<select id="skillBigType" onchange="skillBigType1()" name="skillBigType" style="width: 96px"> 
							<option value="0">选择类别</option>
							<option value="1" <c:if test="${model.skillBigType=='1'}"> selected </c:if> >土建</option>
							<option value="2" <c:if test="${model.skillBigType=='2'}"> selected </c:if>>管理</option>
							<option value="3" <c:if test="${model.skillBigType=='3'}"> selected </c:if>>安装</option>
							<option value="4" <c:if test="${model.skillBigType=='4'}"> selected </c:if>>其他</option>
						</select>
					</span>
				</td>
				<th>技能类型:</th>
				<td colspan="1">
					<span>
					<%-- <input name="skillSmallType" id="skillSmallType"  type="hidden" value="${personModel.skillSmallType}"/> --%>
						<select  name="skillSmallType" id="smalltype">
							<option >技能小类型</option>
						</select>
					</span>
				</td>
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
				<td><input class="inp" type="text" name="jobstatus" value="${model.jobstatus}" /></td>
				<th>诚信度</th>
				<td colspan="5">
					<c:forEach begin="1" end="${uModel.reliableStar}">
						   <span><img src="resource/images/u662.png"/></span>
						</c:forEach>
						<c:forEach begin="1" end="${uModel.noreliableStar}">
						   <span><img src="resource/images/u663.fw.png"/></span>
						</c:forEach>
				</td>
			</tr>
			<tr><th colspan="8">进出场时间</th></tr>
			<tr>
				<th colspan="2">进场时间</th>
				<td colspan="2"><input class="inp" type="text" name="entryTime" value="${model.entryTime}"/></td>
				<th colspan="2">退场时间</th>
				<td colspan="2"><input class="inp" type="text" name="exitTime" value="${model.exitTime}"/></td>
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
				<th colspan="8" align=center><button class="add" style="background-color:white;">修改</button></th>
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
	<script type="text/javascript" src="resource/js/area.js"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/front_person/front_person_file.js" type="text/javascript"></script>
</html>