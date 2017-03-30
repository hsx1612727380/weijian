<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>项目详细信息</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/records.css" />
		<style>
			.querytable th{
				color:white;
				font-size:16px;
			}
		</style>
	</head>
	
	<body>

				<div>
				<h3>项目管理</h3>
				<br/>
					<span class="datum">项目管理>>项目详细信息>>${model.name}</span>
					<span class="add" style="width:125px;text-align:center;">
						<a href="attendanceInfo_project.html?pCode=${pCode}" style="color:white;">查询考勤记录</a>
					</span>
					<span class="del" style="width:133px;text-align:center;">
						<a href="payrollrecord_project.html?pCode=${pCode}" style="color:white">查询工资发放记录</a>
					</span>
					<span class="items" style="width:125px;text-align:center;">
						<a href="accrecord_project.html?pCode=${pCode}" style="color:white;">查询出入记录</a>
					</span>
					<table class="querytable" border="0" cellspacing="1" cellpadding="3px" style="text-align: center;">
						<tr style="background-color:#6E7B8B">
							<th>项目名称</th>
							<th>负责人</th>
							<th>省份</th>
							<th>城市</th>
						</tr>
						<tr>
							<td>${model.name}</td>
							<td>${model.leaderName}</td>
							<td>${model.provinceChn}</td>
							<td>${model.cityChn}</td>
						</tr>
						<tr  style="background-color:#6E7B8B">
							<th>合同价(万)</th>
							<th>预付款(万)</th>
							<th>完成度</th>
							<th>状态</th>
						</tr>
						<tr>
							<td>${model.price}</td>
							<td>${model.prepaid}</td>
							<td>${model.progress}%</td>
							<td><c:choose>
							   <c:when test="${model.check== '1'}">  
							        已审核       
							   </c:when>
							   <c:otherwise> 
							    未审核
							   </c:otherwise>
							</c:choose></td>
						</tr>
						<tr style="background-color:#6E7B8B">
							<th>计划开工日期</th>
							<th>建设单位</th>
							<th>省级项目编号</th>
							<th>项目分类</th>
						</tr>
						<tr>
							<td>${model.worktime}</td>
							<td>${model.buildUnit}</td>
							<td>${model.provinceCode}</td>
							<td>${model.type}</td>
						</tr>
						<tr style="background-color:#6E7B8B">
							<th>立项文号</th>
							<th>立项级别</th>
							<th>立项批复机关</th>
							<th>立项批复时间</th>
							
						</tr>
						<tr>
							<td>${model.projectTitanic}</td>
							<td>${model.projectlevel}</td>
							<td>${model.projectorgan}</td>
							<td>${model.replytime}</td>
						</tr>
						<tr style="background-color:#6E7B8B">
							<th>总投资（万元）</th>
							<th>总面积/长度（平方米/米）</th>
							<th>建设规模</th>
							<th>建设性质</th>
						</tr>
						<tr>
							<td>${model.investment}</td>
							<td>${model.totalarea}</td>
							<td>${model.scale}</td>
							<td>${model.nature}</td>
						</tr>
						
						
					</table>
					<br/>
					<span class="datum">项目环节</span>
					<span class="add">
						<a href="link_modify.html?id=${model.id}" style="color:white">修改</a>
					</span>
					<table class="querytable" border="0" cellspacing="1" cellpadding="3px" style="text-align: center;">
						<tr>
							<th>项目报建</th>
							<th>资信证明</th>
							<th>立项文号</th>
							<th>用地规划许可证</th>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td>${model.pro.get("1")}</td>
							<td>${model.pro.get("2")}</td>
							<td>${model.pro.get("3")}</td>
							<td>${model.pro.get("4")}</td>
						</tr>
						<tr>
							<th>工程规划许可证</th>
							<th>施工图审查</th>
							<th>工程招投标</th>
							<th>合同备案</th>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td>${model.pro.get("5")}</td>
							<td>${model.pro.get("6")}</td>
							<td>${model.pro.get("7")}</td>
							<td>${model.pro.get("8")}</td>
						</tr>
						<tr>
							<th>施工许可</th>
							<th>质量安全监督</th>
							<th>勘验评估合格证</th>
							<th></th>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td>${model.pro.get("9")}</td>
							<td>${model.pro.get("10")}</td>
							<td>${model.pro.get("11")}</td>
							<td>&nbsp;&nbsp;</td>
						</tr>
					</table>
					<br/>
					<span class="datum">参建单位</span>
					<span class="add">
						<a href="joinbuild_add.html?pCode=${pCode}" style="color:white">新增</a>
					</span>
					<table class="querytable" border="0" cellspacing="1" cellpadding="3px" style="text-align: center;">
						<tr>
							<th>单位名称</th>
							<th>单位类型</th>
							<th>负责人电话</th>
							<th>统一社会信用代码</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${jlist}" var="jmodel"> 
						<tr bgcolor="#FFFFFF">
							<td>${jmodel.jName}</td>
							<td>
							<c:if test="${jmodel.jType=='1'}">建设单位</c:if>
							<c:if test="${jmodel.jType=='2'}">工程监理</c:if>
							<c:if test="${jmodel.jType=='3'}">工程设计</c:if>
							<c:if test="${jmodel.jType=='4'}">建筑施工</c:if>
							<c:if test="${jmodel.jType=='5'}">工程勘察</c:if>
							</td>
							<td>${jmodel.leaderphone}</td>
							<td>${jmodel.jNum}</td>
							<td>
								<span class="add">
									<a href="joinbuild_modify.html?id=${jmodel.id}" style="color:white">修改</a>
								</span>
								<span class="items">
									<a href="joinbuild_del.html?id=${jmodel.id}" style="color:white">删除</a>
								</span>
							&nbsp;&nbsp;
							</td>
						</tr>
						</c:forEach>
					</table>
					<br/>
					<span class="datum">关键岗位人员</span>
					<span class="add">
						<a href="keyperson_add.html?pCode=${pCode}" style="color:white">新增</a>
					</span>
					<table class="querytable" border="0" cellspacing="1" cellpadding="3px" style="text-align: center;">
						<tr>
							<th>姓名</th>
							<th>公司名称</th>
							<th>电话</th>
							<th>项目中担任角色</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${klist}" var="kmodel"> 
						<tr bgcolor="#FFFFFF">
							<td>${kmodel.name}</td>
							<td>${kmodel.cName}</td>
							<td>${kmodel.phone}</td>
							<td>
							<c:if test="${kmodel.role=='1'}">项目经理</c:if>
							<c:if test="${kmodel.role=='2'}">工程协管员</c:if>
							<c:if test="${kmodel.role=='3'}">首席建筑师</c:if>
							<c:if test="${kmodel.role=='4'}">暖通工程师</c:if>
							<c:if test="${kmodel.role=='5'}">机械工程师</c:if>
							<c:if test="${kmodel.role=='6'}">电气工程师</c:if>
							<c:if test="${kmodel.role=='7'}">质量评估或质量控制文档管理员</c:if>
							<c:if test="${kmodel.role=='8'}">质量评估或质量控制经理</c:if>
							<c:if test="${kmodel.role=='9'}">商务经理</c:if>
							<c:if test="${kmodel.role=='10'}">施工经理</c:if>
							<c:if test="${kmodel.role=='11'}">流程协调员</c:if>
							<c:if test="${kmodel.role=='12'}">施工员</c:if>
							<c:if test="${kmodel.role=='13'}">预算员</c:if>
							<c:if test="${kmodel.role=='14'}">安全员</c:if>
							<c:if test="${kmodel.role=='15'}">质检员</c:if>
							<c:if test="${kmodel.role=='16'}">材料员</c:if>
							</td>
							<td>
								<span class="add">
									<a href="keyperson_modify.html?id=${kmodel.id}" style="color:white">修改</a>
								</span>
								<span class="items">
									<a href="keyperson_del.html?id=${kmodel.id}" style="color:white">删除</a>
								</span>
								
							&nbsp;&nbsp;
							
							</td>
						</tr>
						</c:forEach>
					</table>
					<br/>
					
					<form action="query_team.html" method="post">
					<tr>
						<td>请输入班组长手机号：<input class="inp" type="text" name="leaderMobile"/></td>
					</tr>
					<button >查询</button>
					
					<div class="footer clearfix">
						<input type="hidden" name="id" value="${model.id}">
					</div>
					<c:if test="${teammodel != null}">
						<table class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
							<tr>
								<td>班组名</td>
								<td>班组编号</td>
								<td>班组长</td>
								<td>联系方式</td>
								<td>技能类别</td>
								<td>技能类型</td>
								<td>班组诚信度</td>
								<td>操作</td>
							</tr>
							<tr>
								<td>${teammodel.name}</td>
								<td>${teammodel.code}</td>
								<td>${teammodel.leaderName}</td>
								<td>${teammodel.leaderMobile}</td>
								<td>${teammodel.skillBigTypeName}</td>
								<td>${teammodel.skillSmallTypeName}</td>
								<td><c:forEach begin="1" end="${teammodel.reliableStar}">
									   <span><img src="resource/images/u662.png"/></span>
									</c:forEach></td>
								<td>
								<c:if test="${canInvite == 'true'}"><a href="team_invite.html?teamId=${teammodel.id}&&id=${model.id}" style="color:blue">可邀请</a></c:if>
								<c:if test="${canInvite == 'false'}">班组已在项目</c:if>
								</td>
								
							</tr>
						</table>
					</c:if>
					</form>
					<span class="datum">已加入项目的班组</span>
					<table class="querytable" border="0" cellspacing="1" cellpadding="3px" style="text-align: center;">
						<tr>
							<th>班组名称</th>
							<th>班组长</th>
							<th>联系方式</th>
							<th>技能类别</th>
							<th>技能类型</th>
							<th>诚信度</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${teams}" var="tmodel"> 
						<tr bgcolor="#FFFFFF">
							<td><a href="team_memberlist.html?id=${tmodel.id}" style="color:green">${tmodel.name}</a></td>
							<td>${tmodel.leaderName}</td>
							<td>${tmodel.leaderMobile}</td>
							<td>${tmodel.skillBigTypeName}</td>
							<td>${tmodel.skillSmallTypeName}</td>
							<td>
								<c:forEach begin="1" end="${tmodel.reliableStar}">
								   <span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="1" end="${tmodel.noreliableStar}">
								   <span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach>
							</td>
							<td>
								<span class="items">
									<a href="team_memberlist.html?id=${tmodel.id}" style="color:white">详情</a>
								</span>
								
							&nbsp;&nbsp;
							
							</td>
						</tr>
						</c:forEach>
					</table>
					<br/>
					<form action="query_material.html" method="post">
					<tr>
						<td>请输入材料商负责人手机号：<input class="inp" type="text" name="materialuserId"/></td>
					</tr>
					<button >查询</button>
					
					<div class="footer clearfix">
						<input type="hidden" name="id" value="${model.id}">
					</div>
					<c:if test="${materialmodel != null}">
						<table class="querytable" border="0" cellspacing="1" cellpadding="3px" style="text-align: center;">
							<tr>
								<td>材料商名称</td>
								<td>材料商编号</td>
								<td>材料名称</td>
								<td>负责人</td>
								<td>联系方式</td>
								<td>供货地区</td>
								<td>材料商诚信度</td>
								<td>操作</td>
							</tr>
							<tr>
								<td>${materialmodel.name}</td>
								<td>${materialmodel.code}</td>
								<td>${materialmodel.shopName}</td>
								<td>${materialmodel.leaderName}</td>
								<td>${materialmodel.userId}</td>
								<td>${materialmodel.provinceChn}${materialmodel.cityChn}</td>
								<td><c:forEach begin="1" end="${teammodel.reliableStar}">
									   <span><img src="resource/images/u662.png"/></span>
									</c:forEach></td>
								<td>
								<c:if test="${materialcanInvite == 'true'}"><a href="material_invite.html?materialId=${materialmodel.id}&&id=${model.id}" style="color:blue">可邀请</a></c:if>
								<c:if test="${materialcanInvite == 'false'}">材料商已在项目</c:if>
								</td>
								
							</tr>
						</table>
					</c:if>
					</form>
					<span class="datum">已加入项目的材料商</span>
					<table class="querytable" border="0" cellspacing="1" cellpadding="3px" style="text-align: center;">
						<tr >
							<th>材料商名</th>
							<th>负责人</th>
							<th>联系方式</th>
							<th>材料名称</th>
							<th>供货地址</th>
							<th>诚信度</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${materials}" var="mmodel"> 
						<tr bgcolor="#FFFFFF">
							<td><a href="merchant_form.html?id=${mmodel.id}&code=${mmodel.code}&type=1" style="color:blue">${mmodel.name}</a></td>
							<td>${mmodel.leaderName}</td>
							<td>${mmodel.userId}</td>
							<td>${mmodel.shopName}</td>
							<td>${mmodel.provinceChn}${mmodel.cityChn}</td>
							<td>
							<c:forEach begin="1" end="${mmodel.reliableStar}">
								   <span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="1" end="${mmodel.noreliableStar}">
								   <span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach>
							</td>
							<td>
								<span class="add">
									<a href="materialTrad_form.html?id=${mmodel.id}&pId=${pId}" style="color:white">记录</a>
								</span>
								<span class="items">
									<a href="merchant_form.html?id=${mmodel.id}&code=${mmodel.code}&type=1" style="color:white">详情</a>
								</span>
								
							&nbsp;&nbsp;
							
							</td>
						</tr>
						</c:forEach>
					</table>
					<br/>
					<form action="query_equipment.html" method="post">
					<tr>
						<td>请输入设备商负责人手机号：<input class="inp" type="text" name="equipmentuserId"/></td>
					</tr>
					<button >查询</button>
					
					<div class="footer clearfix">
						<input type="hidden" name="id" value="${model.id}">
					</div>
					<c:if test="${equipmentmodel != null}">
						<table class="querytable" border="0" cellspacing="1" cellpadding="3px" style="text-align: center;">
							<tr>
								<td>设备商名称</td>
								<td>设备商编号</td>
								<td>设备名称</td>
								<td>负责人</td>
								<td>联系方式</td>
								<td>供货地区</td>
								<td>设备商诚信度</td>
								<td>操作</td>
							</tr>
							<tr>
								<td>${equipmentmodel.name}</td>
								<td>${equipmentmodel.code}</td>
								<td>${equipmentmodel.shopName}</td>
								<td>${equipmentmodel.leaderName}</td>
								<td>${equipmentmodel.userId}</td>
								<td>${equipmentmodel.provinceChn}${equipmentmodel.cityChn}</td>
								<td><c:forEach begin="1" end="${equipmentmodel.reliableStar}">
									   <span><img src="resource/images/u662.png"/></span>
									</c:forEach></td>
								<td>
								<c:if test="${equipmentcanInvite == 'true'}"><a href="equipment_invite.html?equipmentId=${equipmentmodel.id}&&id=${model.id}" style="color:blue">可邀请</a></c:if>
								<c:if test="${equipmentcanInvite == 'false'}">设备商已在项目</c:if>
								</td>
								
							</tr>
						</table>
					</c:if>
					</form>
					<span class="datum">已加入项目的设备商</span>
					<table class="querytable" border="0" cellspacing="1" cellpadding="3px" style="text-align: center;">
						<tr>
							<th>设备商名</th>
							<th>负责人</th>
							<th>联系方式</th>
							<th>设备名称</th>
							<th>供货地址</th>
							<th>诚信度</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${equips}" var="emodel"> 
						<tr bgcolor="#FFFFFF">
							<td><a href="merchant_form.html?id=${emodel.id}&code=${emodel.code}&type=2" style="color:purple">${emodel.name}</a></td>
							<td>${emodel.leaderName}</td>
							<td>${emodel.userId}</td>
							<td>${emodel.shopName}</td>
							<td>${emodel.provinceChn}${emodel.cityChn}</td>
							<td>
								<c:forEach begin="1" end="${emodel.reliableStar}">
								   <span><img src="resource/images/u662.png"/></span>
								</c:forEach>
								<c:forEach begin="1" end="${emodel.noreliableStar}">
								   <span><img src="resource/images/u663.fw.png"/></span>
								</c:forEach>
							</td>
							<td>
								<span class="add">
									<a href="equipmentTrad_form.html?id=${emodel.id}&pId=${pId}" style="color:white">记录</a>
								</span>
								<span class="items">
									<a href="merchant_form.html?id=${emodel.id}&code=${emodel.code}&type=2" style="color:white">详情</a>
								</span>
								
							&nbsp;&nbsp;
							
							</td>
						</tr>
						</c:forEach>
					</table>
				</div>
				
			</div>
		</div>

	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
</html>


