<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/front_project/idprincipal.css" />
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>个人中心</span>
			</div>
		</div>
		<div class="content personal">

			<div class="autstate"><span>认证状态：</span><span>项目负责人</span></div>
			<div class="personaltop">
				<div class="persontitle clearfix">
					<div class="filetile">基础资料管理：</div>
					<div class="update">更新</div>
					<div class="update">修改密码</div>
					<div class="update">授权管理</div>
				</div>
				<table class="basedata" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<th>区域</th>
						<td>浙江省杭州市</td>
						<th>项目名称</th>
						<td>深圳湾创新科技中心</td>
						<th>公司类型</th>
						<td>建筑公司 </td>
						<th>公司名称</th>
						<td>浙江中成建筑工程有限公司</td>
					</tr>
					<tr>
						<th>组织机构代码</th>
						<td>630214770</td>
						<th>负责人</th>
						<td>李先生</td>
						<th>联系方式</th>
						<td>13755163210</td>
						
					</tr>
				</table>
			</div>
			<div class="personalbot">
				<div class="persontitle clearfix">
					<div class="filetile">项目管理：</div>
				</div>
				<div class="project clearfix">
					<div><a href="#">项目详情</a></div>
					<div><a href="#">班组管理</a></div>
				</div>
				<table border="0" cellspacing="1" cellpadding="0">
					<tr>
						<th>项目名称</th>
						<th>所在区域</th>
						<th>合同价（万）</th>
						<th>预付款（万）</th>
						<th>总工程量</th>
						<th>累计工程量</th>
						<th>累计完成比例</th>
						<th>工程状态</th>
					</tr>
					<tr>
						<td>深圳湾创新科技中心</td>
						<td>广东省深圳市</td>
						<td>1500</td>
						<td>900</td>
						<td>200</td>
						<td>200</td>
						<td>100%</td>
						<td>已结束</td>
					</tr>
				</table>
			</div>
		</div>
		 <jsp:include page="../down.jsp" flush="true" />
		<div class="bdchange" id="bdchange">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>手机号</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>公司类型</td>
					<td>
						<select>
							<option>建筑公司</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>联系方式</td>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td>联系人</td>
					<td><input type="text" /></td>
				</tr>
			</table>
			<div class="set">保存</div>
			<div class="del">取消</div>
		</div>
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/front_project/identerprise.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>