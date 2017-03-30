<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String type = request.getParameter("type");
%>

<div class="autstate">
	<ul class=" clearfix">
		<!-- 
		<li style="background-color: #ABCDEF">
			<a style="color:#4684D9 ;" href="operate_info.html">项目信息</a>
		</li>
		 -->
		<li>
			<a href="operate_info.html?id=${projectModel.id }">项目信息</a>
		</li>
		<li>
			<a href="operate_manage.html?id=${projectModel.id }">项目管理</a>
		</li>
		<li>
			<a href="operate_schedule.html?id=${projectModel.id }">项目进度</a>
		</li>
		<li>
			<a href="operate_report.html?id=${projectModel.id }">统计报表</a>
		</li>
		<li>
			<a href="operate_team.html?id=${projectModel.id }">班组信息</a>
		</li>
		<li>
			<a href="operate_need.html?id=${projectModel.id }">用工需求</a>
		</li>
		<li>
			<a href="operate_attendence.html?id=${projectModel.id }&result=-1">考勤记录</a>
		</li>
		<li>
			<a href="operate_salary.html?id=${projectModel.id }&result=-1">工资发放</a>
		</li>
		<li>
			<a href="operate_accrecord.html?id=${projectModel.id }&result=-1">出入记录</a>
		</li>
		<li>
			<a href="operate_enterandexit.html?id=${projectModel.id }">进退场管理</a>
		</li>
		<li>
			<a href="operate_rewardsandpunish.html?id=${projectModel.id }">奖惩管理</a>
		</li>
		<li>
			<a href="operate_compact.html?id=${projectModel.id }">合同管理</a>
		</li>

	</ul>
</div>