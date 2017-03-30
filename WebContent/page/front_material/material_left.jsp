<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div id="user_info_left">

	<ul class="detailbar">
		<li><a href="info.html">基本信息</a></li>
		<li><a href="materialModifyPassword.html">修改密码</a></li> 
		<li><a href="materialFile.html">诚信档案</a></li>
		<li><a href="materialLog.html">出库记录</a></li>
		<li><a href="materialJoinProject.html">加入项目</a></li>
		<li><a href="materialInvite.html">邀请列表</a></li>
		<li><a href="materialPast.html">工程项目</a></li>
		<li><a href="materialSupply.html">材料供应</a></li>
	</ul>

</div>