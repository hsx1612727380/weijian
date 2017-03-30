<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>新增法律保险</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />
		<style>
			
			textarea {
				display: block;
			}
		</style>
		<link rel="stylesheet" href="resource/css/default.css" />
		<script charset="utf-8" src="resource/js/kindeditor-all.js"></script>
		<script charset="utf-8" src="resource/js/zh_CN.js"></script>
		<script>
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="content"]', {
					allowFileManager : true
				});
			});
		</script>
		

	</head>

	<body>
	<form  action="lawInsu_add2.html" method="post">
				<div class='search clearfix'>
					<h3>法律保险管理</h3>
					<span class="datum">法律保险管理>>新增法律保险</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="title">标题:</label></td>
						<td><input class="inp" type="text" name="title" style="width:500px" /></td>
					</tr>
					<tr>
						<td>信息类型</td>
						<td>
							<select name="lawtype" >
							<option value="1" <c:if test="${lawtype=='1'}">selected</c:if>>金融保险</option>
							<option value="2" <c:if test="${lawtype=='2'}">selected</c:if>>法律咨询</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><textarea name="content" style="width:800px;height:400px;margin:0 auto;"></textarea></td>
					</tr>
					
					<tr>
						<td></td>
						<td><button class="add">添加</button></td>
					</tr>
				</table>
				
				</div>
	</form>
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/area.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/time.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


