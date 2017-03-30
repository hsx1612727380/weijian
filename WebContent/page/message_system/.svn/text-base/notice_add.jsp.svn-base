<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>发布公告</title>
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
		<script type="text/javascript">
			!function(){
				laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
				laydate({elem: '#demo'});//绑定元素

		}();
		</script>
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
	<form  action="notice_add2.html" method="post">
				<div class='search clearfix'>
					<h3>消息与公告</h3>
					<span class="datum">消息与公告>>发布公告</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="noticeTitle">公告消息标题:</label></td>
						<td><input class="inp" type="text" name="noticeTitle" style="width:500px" /></td>
					</tr>
					<tr>
						<td><label for="uid">开始时间:</label></td>
						<td style="color:red"><input name="beginTime" placeholder="请输入日期" class="laydate-icon" onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">*必须填写</td>
					</tr>
					<tr>
						<td><label for="uid">结束时间:</label></td>
						<td style="color:red"><input name="endTime" placeholder="请输入日期" class="laydate-icon" onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">*必须填写</td>
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
	<script src="resource/js/laydate.js" type="text/javascript" charset="utf-8"></script>
</html>


