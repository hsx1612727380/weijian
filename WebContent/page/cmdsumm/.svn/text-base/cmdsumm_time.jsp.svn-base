<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			table {
				background-color: #D9D9D9;
				width: 800px;
			}
			table td,table th{
				background-color: white;
				text-align: center;
			}
			table th {
				height: 40px;
				font-size: 30px;
			}
			table td {
				height: 30px;
			}
			button{
				width: 100%;
				height: 30px;
				background-color: white;
				border: 0 none;
				cursor: pointer;
			}
			.special{
				text-align: left;
				padding-left: 10px;
				font-size: 18px;
				font-weight: bold;
			}
		</style>
	</head>
	<body>
		<table border="0" cellspacing="1" cellpadding="0">
			<tr>
				<th colspan="10">主要人工`材料`设备汇总表</th>
			</tr>
			<tr>
				<td for="pName" class="special" colspan="10"><a href="personsummary_add.html?pId=${pModel.id}&pName=${pModel.name}">(新增人工汇总)</a><a href="suppliersummary_add.html?pId=${pModel.id}&pName=${pModel.name}">(新增供应商汇总)</a> &nbsp;&nbsp; 项目名称:${pModel.name}</td>
				
			</tr>
			
			<tr>
				<c:forEach items="${clist}" var="model">
				<td> &nbsp;&nbsp; <span class="add"> <a href="cmdsumm_list.html?year=${model.year}&month=${model.month}&pId=${pId}" style="color: green">${model.year}年${model.month}月</a></span></td>
				</c:forEach>
			</tr>
			
			
		</table>
		
		
	</body>
</html>

