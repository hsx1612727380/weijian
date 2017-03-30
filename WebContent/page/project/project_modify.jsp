<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>修改项目信息</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=629Um5l2umNbmEo10SfHQjgM4cGtQe7b"></script>
	</head>

	<body>
	<form action="project_modify2.html" method="post">
				<div class='search clearfix'>
					<h3>项目管理</h3>
					<span class="datum">项目管理>>修改项目</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="uid">公司代码:</label></td>
						<td style="color:red"><input id="Code" class="inp" type="text" name="code" value="${model.code}"/><span></span></td>
						<td><label for="uid">总工作量:</label></td>
						<td><input class="inp" type="text" name="allWork" value="${model.allWork}" /></td>
					</tr>
					<tr>
						<td><label for="uid">项目名称:</label></td>
						<td><input id="Name" class="inp" type="text" name="name" value="${model.name}"/></td>
						<td><label for="uid">累计工作量:</label></td>
						<td><input class="inp" type="text" name="accWork" value="${model.accWork}"/></td>
					</tr>
					<tr>
						<td><label for="uid">项目编号:</label></td>
						<td style="color:red"><input id="pCode" class="inp" type="text" name="pCode" value="${model.pCode}"/><span></span></td>
						<td><label for="uid">省级项目编号:</label></td>
						<td><input class="inp" type="text" name="provinceCode" value="${model.provinceCode}"/></td>
					</tr>
					<tr>
						<td><label for="phone">合同价(万):</label></td>
						<td><input class="inp" type="text" name="price" value="${model.price}"/></td>
						<td><label for="uid">项目分类:</label></td>
						<td><input class="inp" type="text" name="type" value="${model.type}"/></td>
					</tr>
					<tr>
						<td><label for="phone">预付款(万):</label></td>
						<td><input class="inp" type="text" name="prepaid" value="${model.prepaid}"/></td>
						<td><label for="uid">立项文号:</label></td>
						<td><input class="inp" type="text" name="projectTitanic" value="${model.projectTitanic}"/></td>
					</tr>
					<tr>
						<td><label for="name">负责人:</label></td>
						<td><input class="inp" type="text" name="leaderName" value="${model.leaderName}"/></td>
						<td><label for="uid">负责人身份证:</label></td>
						<td style="color:red"><input id="Identity" class="inp" type="text" name="identity" /><span></span></td>
					</tr>
					<tr>
						<td><label for="gender">联系方式:</label></td>
						<td>${model.userId}</td>
						<td><label for="uid">立项批复机关:</label></td>
						<td><input class="inp" type="text" name="projectorgan" value="${model.projectorgan}"/></td>
					</tr>
					<tr>
						<td><label for="gender">省:</label></td>
						<td><select id="province" onchange="setCity(this.value);getArea();" name="province" runat="server">
								<option value="${model.province}">${model.provinceChn}</option>
							</select></td>
                   		 <td><label for="uid">立项批复时间:</label></td>
						<td><input class="inp" type="text" name="replytime" value="${model.replytime}"/></td>
					</tr>
					<tr>
						<td><label for="gender">市:</label></td>
						<td><select id="city" onchange="setCounty(this.value);getArea();" name="city" runat="server">
								<option value="${model.city}" selected="selected">${model.cityChn}</option>
							</select></td>
                   		<td><label for="uid">总投资（万元）:</label></td>
						<td><input class="inp" type="text" name="investment" value="${model.investment}"/></td>
					</tr>
					<tr>
						<td><label for="uid">详细地址:</label></td>
						<td><input class="inp" type="text" name="street" value="${model.street}"/></td>
						<td><label for="uid">总面积/长度（平方米/米）:</label></td>
						<td><input class="inp" type="text" name="totalarea" value="${model.totalarea}"/></td>
					</tr>
					<tr>
						<td><label for="uid">建设规模:</label></td>
						<td><input class="inp" type="text" name="scale" value="${model.scale}"/></td>
						<td><label for="uid">建设性质:</label></td>
						<td><input class="inp" type="text" name="nature" value="${model.nature}"/></td>
					</tr>
					<tr>
						<td><label for="uid">工程用途:</label></td>
						<td><input class="inp" type="text" name="purpose" value="${model.purpose}"/></td>
						<td><label for="uid">计划开工日期:</label></td>
						<td><input class="inp" type="text" name="worktime" value="${model.worktime}"/></td>
					</tr>
					<tr>
						<td><label for="uid">本次工程量:</label></td>
						<td><input class="inp" type="text" name="thsWork" value="${model.thsWork}"/></td>
						<td><label for="uid">次数:</label></td>
						<td><input class="inp" type="text" name="times" value="${model.times}"/></td>
					</tr>
					<tr>
						<td><label for="uid">单位(公司):</label></td>
						<td><input class="inp" type="text" name="unit" value="${model.unit}"/></td>
						<td><label for="uid">建设单位:</label></td>
						<td><input class="inp" type="text" name="buildUnit" value="${model.buildUnit}"/></td>
					</tr>
					<tr>
						<td><label for="uid">立项级别:</label></td>
						<td><input class="inp" type="text" name="projectlevel" value="${model.projectlevel}"/></td>
					</tr>
					<tr>
						<th colspan="2">经度：<input id="lonlat" name="lonlat" type="text" value="${model.longitude}">   
						纬度：<input id="lonlat2" name="lonlat2" type="text" value="${model.latitude}"></th>
					</tr>
					<tr>
						<td  colspan="2">
					 	 <div style="width:520px;height:340px;border:1px solid gray" id="container"></div>
						</td>
					</tr>
				
					<tr>
						<td><label for="phone">状态:</label></td>
						<td align="justify">
							<select name="status">
						   	 	<option value="0" <c:if test="${model.status==0}">selected</c:if>>未开始</option>
						    	<option value="1" <c:if test="${model.status==1}">selected</c:if>>已开始</option>
						    	<option value="2" <c:if test="${model.status==2}">selected</c:if>>已完成</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td></td>
						<td><button class="add">修改</button></td>
					</tr>
				</table>
				
				</div>
				
				<div class="footer clearfix">
				<input type="hidden" name="id" value="${model.id}"> 
				</div>
				
				
			</div>
		</div>
		</form>
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/area.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/map.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


