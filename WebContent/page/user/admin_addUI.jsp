<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>
<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<!--引入Bootstrap -->
		<link href="resource/css/xcConfirm.css" type="text/css" rel="stylesheet"><!-- alert样式引用-->
		<link rel="stylesheet" href="resource/css/bootstrap.min.css" />
		<link rel="stylesheet" href="resource/css/reset.css" />
		<link rel="stylesheet" href="resource/css/login.css" />
		<link rel="stylesheet" href="resource/css/common.css" />
         <script type="text/javascript" src="resource/js/jquery.js"> </script>
         <script type="text/javascript" src="resource/js/xcConfirm.js"></script><!-- alert js引用-->	
</head>
<body>

<div id="addAdmin" class="">
	<form action="addAdmin.html" method="post">
	    accountName:<input type="text" name = "accountName" ><br>
	    name:<input type="text" name = "name" ><br>
	    mobile:<input type="text" name = "mobile" ><br>
	    popedom:<input type="text" name = "popedom" ><br>
	    password:<input type="password" name = "password" ><br>
     <input type="submit" value="添加管理员"> 
	</form>
</div>

</div>


