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
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=629Um5l2umNbmEo10SfHQjgM4cGtQe7b"></script>
</head>

<body>
	<form action="project_add2.html" method="post">
		<div class='search clearfix'>
			<h3>项目管理</h3>
			<span class="datum">项目管理>>新增项目</span>
			<table border="0" cellspacing="0" cellpadding="0"
				style="display: table; margin: 0 auto;">
				<tr>
					<td><label for="uid">公司代码:</label></td>
					<td><input id="Code" class="inp" type="text" name="code" placeholder="请输入公司代码"/></td>
					<td><label for="uid">总投资（万元）:</label></td>
					<td><input class="inp" type="text" name="investment" /></td>
				</tr>
				<tr>
					<td><label for="uid">项目编号:</label></td>
					<td style="color:red"><input id="pCode" class="inp" type="text" name="pCode" placeholder="请输入项目编号"/><span>*必须填写</span></td>
					<td><label for="uid">项目名称:</label></td>
					<td style="color:red"><input id="Name" class="inp" type="text" name="name" placeholder="请输入项目名称"/><span>*必须填写</span></td>
				</tr>
				<tr>
					<td><label for="uid">项目分类:</label></td>
					<td><input class="inp" type="text" name="type" /></td>
					<td><label for="name">负责人:</label></td>
					<td><input class="inp" type="text" name="leaderName" /></td>
				</tr>
				<tr>
					<td><label for="gender">联系方式:</label></td>
					<td style="color:red"><input id="UserId" class="inp" type="text" name="userId" placeholder="请输入负责人联系方式"/><span>*必须填写</span></td>
					<td><label for="uid">负责人身份证:</label></td>
					<td style="color:red"><input id="Identity" class="inp" type="text" name="identity" placeholder="请输入负责人身份证"/><span>*必须填写</span></td>
					
				</tr>
				<tr>
					<td><label for="phone">合同价(万):</label></td>
					<td style="color:red"><input class="inp" type="text" name="price" /><span>*请输入数字</span></td>
					<td><label for="phone">预付款(万):</label></td>
					<td style="color:red"><input class="inp" type="text" name="prepaid" /><span>*请输入数字</span></td>
				</tr>
				<tr>
					<td><label for="uid">本次工程量:</label></td>
					<td><input class="inp" type="text" name="thsWork" /></td>
					<td><label for="uid">累计工作量:</label></td>
					<td><input class="inp" type="text" name="accWork" /></td>
				</tr>
				<tr>
					<td><label for="uid">总工作量:</label></td>
					<td><input class="inp" type="text" name="allWork" /></td>
					<td><label for="uid">计划开工日期:</label></td>
					<td><input class="inp" type="text" name="worktime" /></td>
					
				</tr>
				<tr>
					<td><label for="uid">立项文号:</label></td>
					<td><input class="inp" type="text" name="projectTitanic" /></td>
					<td><label for="uid">立项批复机关:</label></td>
					<td><input class="inp" type="text" name="projectorgan" /></td>
				</tr>
				<tr>
					<td><label for="uid">立项级别:</label></td>
					<td><input class="inp" type="text" name="projectlevel" /></td>
					<td><label for="uid">立项批复时间:</label></td>
					<td><input class="inp" type="text" name="replytime" /></td>
				</tr>
				<tr>
					<td><label for="province">省份:</label></td>
					<td><select id="province" onchange="setCity(this.value);getArea();" name="province" style="width: 96px" runat="server" >
                             <option value="${province}" selected="selected">--请选择省份--</option>
                    	</select></td>
					<td><label for="city">城市:</label></td>
					<td><select id="city" onchange="setCounty(this.value);getArea();" name="city" style="width: 96px" runat="server">
                             <option value="${city}" selected="selected">--请选择城市--</option>
                        </select></td>
				</tr>
				<tr>
					<td><label for="uid">详细地址:</label></td>
					<td><input class="inp" type="text" name="street" /></td>
					<td><label for="uid">总面积/长度（平方米/米）:</label></td>
					<td><input class="inp" type="text" name="totalarea" /></td>
				</tr>
				<tr>
					<td><label for="uid">建设规模:</label></td>
					<td><input class="inp" type="text" name="scale" /></td>
					<td><label for="uid">建设性质:</label></td>
					<td><input class="inp" type="text" name="nature" /></td>
				</tr>
				<tr>
					<td><label for="uid">省级项目编号:</label></td>
					<td><input class="inp" type="text" name="provinceCode" /></td>
					<td><label for="uid">次数:</label></td>
					<td><input class="inp" type="text" name="times" /></td>
				</tr>
				<tr>
					<td><label for="uid">单位(公司):</label></td>
					<td><input class="inp" type="text" name="unit" /></td>
					<td><label for="uid">建设单位:</label></td>
					<td><input class="inp" type="text" name="buildUnit" /></td>
				</tr>
				<tr>
					<td><label for="uid">工程用途:</label></td>
					<td><input class="inp" type="text" name="purpose" /></td>
				</tr>
				<tr>
					<th colspan="2">经度：<input id="lonlat" name="lonlat" type="text" value="113.346715">   
					纬度：<input id="lonlat2" name="lonlat2" type="text" value="23.140517"></th>
				</tr>
				<tr>
					<td  colspan="2">
					  <div style="width:520px;height:340px;border:1px solid gray" id="container"></div>
					</td>
				</tr>
				
				<tr>
					<td></td>
					<td><button class="add" id="btn">添加</button></td>
				</tr>
			</table>

		</div>

		<div class="footer clearfix"></div>


		</div>
		</div>
	</form>
</body>
<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="resource/js/silder.js" type="text/javascript"
	charset="utf-8"></script>
<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
<script src="resource/js/area.js" type="text/javascript" charset="utf-8"></script>
<script src="resource/js/map.js" type="text/javascript" charset="utf-8"></script>
<script src="resource/js/project_add_check.js" type="text/javascript" charset="utf-8"></script>
<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


