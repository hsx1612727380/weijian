<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/web/project_menber.css" />
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=629Um5l2umNbmEo10SfHQjgM4cGtQe7b"></script>
	</head>

	<body>
		<jsp:include page="../../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>项目介绍</span>
			</div>
		</div>
		<div class="content personal clearfix">
			<div class="comtitle">
				<div>
					<div class="intitle">
						${model.name}
					</div>
					<ul class="detailtitle clearfix">
						<li data-m="m1">
							<i class="iconfont">&#xe607</i>
							<p>基础信息</p>
						</li>
						<li data-m="m2">
							<i class="iconfont">&#xe784</i>
							<p>项目环节</p>
						</li>
						<li data-m="m3">
							<i class="iconfont">&#xe606</i>
							<p>参建单位</p>
						</li>
						<li data-m="m4">
							<i class="iconfont">&#xe609</i>
							<p>关键岗位人员</p>
						</li>
						<li data-m="m5">
							<i class="iconfont">&#xe88e</i>
							<p>良好行为</p>
						</li>
					</ul>
				</div>

			</div>
			<div class="column">
				<div class="ntitle m1">
					基本信息
				</div>
				<ul class="basedetail clearfix">
					<li>
						<h3>省级项目编号</h3>
						<p>${model.provinceCode}</p>
					</li>
					<li>
						<h3>项目分类</h3>
						<p>${model.type}</p>
					</li>
					
						<input id="lonlat" name="lonlat" type="hidden" value="${model.longitude}">   
						<input id="lonlat2" name="lonlat2" type="hidden" value="${model.latitude}">
						<div id="container"></div>
					
					<li>
						<h3>建设单位</h3>
						<p>${cmodel.name}</p>
					</li>
					<li>
						<h3>组织机构代码</h3>
						<p>${cmodel.organization}</p>
					</li>
					<li>
						<h3>项目所在地</h3>
						<p>${model.provinceChn}${model.cityChn}</p>
					</li>
					<li>
						<h3>详细地址</h3>
						<p>${model.street}</p>
					</li>
					<li>
						<h3>立项文号</h3>
						<p>${model.projectTitanic}</p>
					</li>
					<li>
						<h3>立项级别</h3>
						<p>${model.projectlevel}</p>
					</li>
					<li>
						<h3>立项批复机关</h3>
						<p>${model.projectorgan}</p>
					</li>
					<li>
						<h3>立项批复时间</h3>
						<p>${model.replytime}</p>
					</li>
					<li>
						<h3>总投资（万元）</h3>
						<p>${model.investment}</p>
					</li>
					<li>
						<h3>总面积/长度（平方米/米）</h3>
						<p>${model.totalarea}</p>
					</li>
					<li>
						<h3>建设规模</h3>
						<p>${model.scale}</p>
					</li>
					<li>
						<h3>建设性质</h3>
						<p>${model.nature}</p>
					</li>
					<li>
						<h3>工程用途</h3>
						<p>${model.purpose}</p>
					</li>
					<li>
						<h3>计划开工日期</h3>
						<p>${model.worktime}</p>
					</li>
				</ul>
			</div>
			<div class="column m2">
				<div class="ntitle">
					项目环节
				</div>
				<ul class="prodetail clearfix">
					<li>
						<h3>工程招投标</h3>
						<p>
						<c:if test="${model.getPro('1')!=null}">${model.getPro('1')}</c:if>
						<c:if test="${model.getPro('1')==null}">无</c:if>
						</p>
					</li>
					<li>
						<h3>施工图审查</h3>
						<p><c:if test="${model.getPro('2')!=null}">${model.getPro('2')}</c:if>
						<c:if test="${model.getPro('2')==''}">无</c:if></p>
					</li>
					<li>
						<h3>合同备案</h3>
						<p><c:if test="${model.getPro('3')!=null}">${model.getPro('3')}</c:if>
						<c:if test="${model.getPro('3')==''}">无</c:if></p>
					</li>
					<li>
						<h3>施工许可</h3>
						<p><c:if test="${model.getPro('4')!=null}">${model.getPro('4')}</c:if>
						<c:if test="${model.getPro('4')==''}">无</c:if></p>
					</li>
					<li>
						<h3>质量安全监督</h3>
						<p><c:if test="${model.getPro('5')!=null}">${model.getPro('5')}</c:if>
						<c:if test="${model.getPro('5')==''}">无</c:if></p>
					</li>
					<li>
						<h3>工程竣工验收备案</h3>
						<p><c:if test="${model.getPro('6')!=null}">${model.getPro('6')}</c:if>
						<c:if test="${model.getPro('6')==''}">无</c:if></p>
					</li>
				</ul>
			</div>
			<div class="column m3">
				<div class="ntitle">
					参建单位
				</div>
				<ul class="prodetail clearfix">
					<c:forEach items="${jList}" var="jmodel">
					<li onclick='location.href="web_company_info.html?userId=${jmodel.leaderphone}"'>
						<h2>
						<c:if test="${jmodel.jType=='1'}">建设单位</c:if>
						<c:if test="${jmodel.jType=='2'}">工程监理</c:if>
						<c:if test="${jmodel.jType=='3'}">工程设计</c:if>
						<c:if test="${jmodel.jType=='4'}">建筑施工</c:if>
						<c:if test="${jmodel.jType=='5'}">工程勘察</c:if>
						
						</h2>
						<h3>企业名称</h3>
						<p>${jmodel.jName}</p>
						<h3>组织机构代码</h3>
						<p>${jmodel.jNum}</p>
					</li>
					</c:forEach>
				</ul>
			</div>
			<div class="column m4">
				<div class="ntitle">
					关键岗位人员
				</div>
				<ul class="prodetail clearfix">
					<c:forEach items="${pList}" var="pmodel">
					<li onclick='location.href="web_person_info.html?userId=${pmodel.phone}"'>
						<h2>${pmodel.name}</h2>
						<h3>企业名称</h3>
						<p>${pmodel.cName}</p>
						<h3>担任角色</h3>
						<p>
						<c:if test="${pmodel.role=='1'}">项目经理</c:if>
						<c:if test="${pmodel.role=='2'}">工程协管员</c:if>
						<c:if test="${pmodel.role=='3'}">首席建筑师</c:if>
						<c:if test="${pmodel.role=='4'}">暖通工程师</c:if>
						<c:if test="${pmodel.role=='5'}">机械工程师</c:if>
						<c:if test="${pmodel.role=='6'}">电气工程师</c:if>
						<c:if test="${pmodel.role=='7'}">质量评估或质量控制文档管理员</c:if>
						<c:if test="${pmodel.role=='8'}">质量评估或质量控制经理</c:if>
						<c:if test="${pmodel.role=='9'}">商务经理</c:if>
						<c:if test="${pmodel.role=='10'}">施工经理</c:if>
						<c:if test="${pmodel.role=='11'}">流程协调员</c:if>
						<c:if test="${pmodel.role=='12'}">施工员</c:if>
						<c:if test="${pmodel.role=='13'}">预算员</c:if>
						<c:if test="${pmodel.role=='14'}">安全员</c:if>
						<c:if test="${pmodel.role=='15'}">质检员</c:if>
						<c:if test="${pmodel.role=='16'}">材料员</c:if>
						</p>
					</li>
					</c:forEach>
					
				</ul>
			</div>
			<div class="column m5">
				<div class="ntitle">
					项目规模
				</div>
				<p>
					
				</p>
			</div>
			
		</div>
		<jsp:include page="../../down.jsp" flush="true" />
		<div class="mask"></div>
		
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/web/project_menber.js" type="text/javascript" charset="utf-8"></script>
		<script src="http://api.map.baidu.com/api?v=1.2" type="text/javascript"></script>
		<script src="resource/js/map.js" type="text/javascript" charset="utf-8"></script>
		
	</body>

</html>