<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>新增人工费汇总</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />

	</head>

	<body>
	<form action="personsummary_add2.html" method="post">
				<div class='search clearfix'>
					<h3>项目汇总管理</h3>
					<span class="datum">项目管理>>新增人工费信息</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="tNum">班组编号:</label></td>
						<td><input class="inp" type="text" name="tNum" /></td>
					</tr>
					<tr>
						<td><label for="tName">班组名称:</label></td>
						<td><input class="inp" type="text" name="tName" /></td>
						<td><label for="teamtype">班组类型:</label></td>
						<td>
							<select name="teamtype" >
							<option value="1" <c:if test="${teamtype=='1'}">selected</c:if>>本班组</option>
							<option value="2" <c:if test="${teamtype=='2'}">selected</c:if>>劳务班组</option>
							<option value="3" <c:if test="${teamtype=='3'}">selected</c:if>>专业班组</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="bgpayment">预付款:</label></td>
						<td><input class="inp" type="text" name="bgpayment" /></td>
						<td><label for="contractPrice">合同价:</label></td>
						<td><input class="val" type="text" name="contractPrice" /></td>
					</tr>
					<tr>
						<td><label for="unit">单位:</label></td>
						<td><input class="inp" type="text" name="unit" /></td>
						<td><label for="frequency">次数:</label></td>
						<td><input class="inp" type="text" name="frequency" /></td>
						
					</tr>
					<tr>
						<td><label for="nowTotal">本次工程量:</label></td>
						<td><input class="inp" type="text" name="nowTotal" /></td>
						<td><label for="total">总工程量:</label></td>
						<td><input class="inp" type="text" name="total" /></td>
					</tr>
					<tr>
						<td><label for="culPercentage">累计付款百分比:</label></td>
						<td><input class="inp" type="text" name="culPercentage" /></td>
						<td><label for="percentage">累计完成%:</label></td>
						<td><input class="inp" type="text" name="percentage" /></td>
					</tr>
					<tr>
						<td><label for="thispay">本次付款:</label></td>
						<td><input class="inp" type="text" name="thispay" /></td>
						<td><label for="culapay">累计付款:</label></td>
						<td><input class="inp" type="text" name="culapay" /></td>
					</tr>
					<tr>
						<td><label for="thisSalary">已付工资:</label></td>
						<td><input class="inp" type="text" name="thisSalary" /></td>
						<td><label for="noSalary">未付工资:</label></td>
						<td><input class="inp" type="text" name="noSalary" /></td>
					</tr>
					<tr>
						<td><label for="remain">余额:</label></td>
						<td><input class="inp" type="text" name="remain" /></td>
						<td><label for="deposit">押金:</label></td>
						<td><input class="inp" type="text" name="deposit" /></td>
					</tr>
					<tr>
						<td><label for="settlement">结算情况:</label></td>
						<td><input class="inp" type="text" name="settlement" /></td>
						<td><label for="note">备注:</label></td>
						<td><input class="inp" type="text" name="note" /></td>
					</tr>
					<tr>
						<td><label for="year">年:</label></td>
						<td>
							<select name="year" >
							<option value="2010" <c:if test="${year=='2010'}">selected</c:if>>2010</option>
							<option value="2011" <c:if test="${year=='2011'}">selected</c:if>>2011</option>
							<option value="2012" <c:if test="${year=='2012'}">selected</c:if>>2012</option>
							<option value="2013" <c:if test="${year=='2013'}">selected</c:if>>2013</option>
							<option value="2014" <c:if test="${year=='2014'}">selected</c:if>>2014</option>
							<option value="2015" <c:if test="${year=='2015'}">selected</c:if>>2015</option>
							<option value="2016" <c:if test="${year=='2016'}">selected</c:if>>2016</option>
							<option value="2017" <c:if test="${year=='2017'}">selected</c:if>>2017</option>
							<option value="2018" <c:if test="${year=='2018'}">selected</c:if>>2018</option>
							<option value="2019" <c:if test="${year=='2019'}">selected</c:if>>2019</option>
							</select>
						</td>
						<td><label for="month">月:</label></td>
						<td>
							<select name="month" >
							<option value="1" <c:if test="${month=='1'}">selected</c:if>>1</option>
							<option value="2" <c:if test="${month=='2'}">selected</c:if>>2</option>
							<option value="3" <c:if test="${month=='3'}">selected</c:if>>3</option>
							<option value="4" <c:if test="${month=='4'}">selected</c:if>>4</option>
							<option value="5" <c:if test="${month=='5'}">selected</c:if>>5</option>
							<option value="6" <c:if test="${month=='6'}">selected</c:if>>6</option>
							<option value="7" <c:if test="${month=='7'}">selected</c:if>>7</option>
							<option value="8" <c:if test="${month=='8'}">selected</c:if>>8</option>
							<option value="9" <c:if test="${month=='9'}">selected</c:if>>9</option>
							<option value="10" <c:if test="${month=='10'}">selected</c:if>>10</option>
							<option value="11" <c:if test="${month=='11'}">selected</c:if>>11</option>
							<option value="12" <c:if test="${month=='12'}">selected</c:if>>12</option>
							</select>	
						</td>
					</tr>
					<tr>
						<td></td>
						<td><button  class="add">添加</button></td>
					</tr>
				</table>
				
				</div>
				
				<div class="footer clearfix">
					<input type="hidden" name="pId" value="<%=request.getAttribute("pId")%>">
					<input type="hidden" name="pName" value="<%=request.getAttribute("pName")%>">
				</div>
		</form>
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/area.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>

</html>


