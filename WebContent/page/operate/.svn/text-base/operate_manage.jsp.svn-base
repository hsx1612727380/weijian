<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operatemanage.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/projectdetail.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/newoperate.css" />
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			
			<form action="operate_modfiyProject2.html" method="post">
				<input type="hidden" name="code" value="${projectModel.code }"/>
				<input type="hidden" name="id" value="${projectModel.id }"/>
				<div class="column">
					<div class="intitle">
						基本信息 <img class="smallimg editimg" src="<%=basePath%>/resource/images/front_company/edit.png" />
					</div>
					<table class="basedetail" border="0" cellspacing="1" cellpadding="0">
						<tr>
							<th><span class="red">*</span>项目名称</th>
							<td>
								<span class="baseedits">${projectModel.name }</span>
								<input id="name" class="baseeditinput" type="text" name="name" value="${projectModel.name }"/>
							</td>
							<th><span class="red">*</span>合同价(万)</th>
							<td>
								<span class="baseedits ">${projectModel.price }</span>
								<input id="price" class="baseeditinput" type="text" name="price" value="${projectModel.price }"/>
							</td>
							<th><span class="red">*</span>预付款(万)</th>
							<td>
								<span class="baseedits ">${projectModel.prepaid}</span>
								<input id="prepaid" class="baseeditinput" type="text" name="prepaid" value="${projectModel.prepaid}"/>
							</td>
						</tr>
						<tr>
							<th><span class="red">*</span>所在区域</th>
							<td>
								<span class="baseedits">${projectModel.provinceChn}${projectModel.cityChn}</span>
								<select class="baseeditinput" id="province" name="province" style="width: 105px;">
									<c:choose>
										<c:when test="${projectModel.province } == ''">
											<option selected="selected" value="">请选择省份</option>
										</c:when>
										<c:otherwise>
											<option selected="selected" value="${projectModel.province}">${projectModel.provinceChn}</option>
										</c:otherwise>
									</c:choose>
								</select>
								<select class="baseeditinput" id="city" name="city" style="width: 105px;">
									<c:choose>
										<c:when test="${projectModel.city } == ''">
											<option selected="selected" value="">请选择城市</option>
										</c:when>
										<c:otherwise>
											<option selected="selected" value="${projectModel.city}">${projectModel.cityChn}</option>
										</c:otherwise>
									</c:choose>
								</select>
							</td>
							<th><span class="red">*</span>详细地址</th>
							<td colspan="3">
								<span class="baseedits" style="width: 616px;">${projectModel.street}</span>
								<input id="street" type="text" name="street" class="baseeditinput" style="width: 616px;" value="${projectModel.street}"/>
							</td>
						</tr>
						<tr>
							<th><span class="red">*</span>项目负责人</th>
							<td id="projectLeaderName">
								<span class="baseedits ">${projectModel.leaderName}</span>
								<input id="leaderName" class="baseeditinput" type="text" name="leaderName" value="${projectModel.leaderName}"/>
							</td>
							<th><span class="red">*</span>负责人联系方式</th>
							<td id="projectUserId">
								<span class="baseedits ">${projectModel.userId}</span>
								<input id="userId" class="baseeditinput" type="text" name="userId" value="${projectModel.userId}"/>
							</td>
							<th>工程状态</th>
							<td>
								<span class="baseedits ">
									<c:if test="${projectModel.status == '0'}">未开始</c:if>
									<c:if test="${projectModel.status == '1'}">进行中</c:if>
									<c:if test="${projectModel.status == '2'}">进行中</c:if>
								</span>
								<select class="baseeditinput" id="status" name="status" onchange="getStatus();">
									<option value="" <c:if test="${projectModel.status==''}">selected</c:if>>请选择工程状态</option>
									<option value="0" <c:if test="${projectModel.status=='0'}">selected</c:if>>未开始</option>
									<option value="1" <c:if test="${projectModel.status=='1'}">selected</c:if>>进行中</option>
									<option value="2" <c:if test="${projectModel.status=='2'}">selected</c:if>>已完成</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>次数</th>
							<td>
								<span class="baseedits ">${projectModel.times}</span>
								<input class="baseeditinput" type="text" name="times" value="${projectModel.times}"/>
							</td>
							<th>累计完成比例%</th>
							<td>
								<span class="baseedits ">${projectModel.progress}</span>
								<input type="text" class="baseeditinput" name="progress" value="${projectModel.progress}"/>
							</td>
							<th>省级项目编号</th>
							<td>
								<span class="baseedits ">${projectModel.provinceCode}</span>
								<input class="baseeditinput" type="text" name="provinceCode" value="${projectModel.provinceCode}"/>
							</td>
						</tr>
						<tr>
							<th>立项文号</th>
							<td>
								<span class="baseedits ">${projectModel.projectTitanic}</span>
								<input class="baseeditinput" type="text" name="projectTitanic" value="${projectModel.projectTitanic}"/>
							</td>
							<th>立项级别</th>
							<td>
								<span class="baseedits ">${projectModel.projectlevel}</span>
								<input class="baseeditinput" type="text" name="projectlevel" value="${projectModel.projectlevel}"/>
							</td>
							<th>立项批复机关</th>
							<td>
								<span class="baseedits ">${projectModel.projectorgan}</span>
								<input class="baseeditinput" type="text" name="projectorgan" value="${projectModel.projectorgan}"/>
							</td>
						</tr>
						<tr>
							<th>立项批复时间</th>
							<td>
								<span class="baseedits ">${projectModel.replytime}</span>
								<input class="baseeditinput" type="text" name="replytime" value="${projectModel.replytime}"/>
							</td>
							<th>总面积/长度</th>
							<td>
								<span class="baseedits ">${projectModel.totalarea}</span>
								<input class="baseeditinput" type="text" name="totalarea" value="${projectModel.totalarea}"/>
							</td>
							<th>工程用途</th>
							<td>
								<span class="baseedits ">${projectModel.purpose}</span>
								<select class="baseeditinput" id="purpose" name="purpose" onchange="getPurpose();">
									<option value="" <c:if test="${projectModel.purpose==''}">selected</c:if>>请选择工程用途</option>
									<option value="民用建筑" <c:if test="${projectModel.purpose=='民用建筑'}">selected</c:if>>民用建筑</option>
									<option value="工业建筑" <c:if test="${projectModel.purpose=='工业建筑'}">selected</c:if>>工业建筑</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>建设性质</th>
							<td>
								<span class="baseedits ">${projectModel.nature}</span>
								<select class="baseeditinput" id="nature" name="nature" onchange="getNature();">
									<option value="" <c:if test="${projectModel.nature==''}">selected</c:if>>请选择建设性质</option>
									<option value="新建" <c:if test="${projectModel.nature=='新建'}">selected</c:if>>新建</option>
									<option value="扩建" <c:if test="${projectModel.nature=='扩建'}">selected</c:if>>扩建</option>
									<option value="改建" <c:if test="${projectModel.nature=='改建'}">selected</c:if>>改建</option>
									<option value="迁建" <c:if test="${projectModel.nature=='迁建'}">selected</c:if>>迁建</option>
									<option value="恢复" <c:if test="${projectModel.nature=='恢复'}">selected</c:if>>恢复</option>
								</select>
							</td>
							<th>计划开工日期</th>
							<td>
								<span class="baseedits ">${projectModel.worktime }</span>
								<input class="baseeditinput" type="text" name="worktime" value="${projectModel.worktime }"/>
							</td>
							<th>项目分类</th>
							<td>
								<span class="baseedits ">${projectModel.type}</span>
								<select class="baseeditinput" id="type" name="type" onchange="getType();">
									<option value="" <c:if test="${projectModel.type==''}">selected</c:if>>请选择项目分类</option>
									<option value="房屋建筑工程" <c:if test="${projectModel.type=='房屋建筑工程'}">selected</c:if>>房屋建筑工程</option>
									<option value="冶炼工程" <c:if test="${projectModel.type=='冶炼工程'}">selected</c:if>>冶炼工程</option>
									<option value="矿山工程" <c:if test="${projectModel.type=='矿山工程'}">selected</c:if>>矿山工程</option>
									<option value="化工石油工程" <c:if test="${projectModel.type=='化工石油工程'}">selected</c:if>>化工石油工程</option>
									<option value="水利水电工程" <c:if test="${projectModel.type=='水利水电工程'}">selected</c:if>>水利水电工程</option>
									<option value="电力工程" <c:if test="${projectModel.type=='电力工程'}">selected</c:if>>电力工程</option>
									<option value="农林工程" <c:if test="${projectModel.type=='农林工程'}">selected</c:if>>农林工程</option>
									<option value="铁路工程" <c:if test="${projectModel.type=='铁路工程'}">selected</c:if>>铁路工程</option>
									<option value="公路工程" <c:if test="${projectModel.type=='公路工程'}">selected</c:if>>公路工程</option>
									<option value="港口与航道工程" <c:if test="${projectModel.type=='港口与航道工程'}">selected</c:if>>港口与航道工程</option>
									<option value="航天航空工程" <c:if test="${projectModel.type=='航天航空工程'}">selected</c:if>>航天航空工程</option>
									<option value="通信工程" <c:if test="${projectModel.type=='通信工程'}">selected</c:if>>通信工程</option>
									<option value="市政公用工程" <c:if test="${projectModel.type=='市政公用工程'}">selected</c:if>>市政公用工程</option>
									<option value="机电安装工程" <c:if test="${projectModel.type=='机电安装工程'}">selected</c:if>>机电安装工程</option>
								</select>
							</td>
						</tr>
					</table>
				</div>
				<div class="columnthree">
					<input id="baseInfoModfiySubmit" class="cancel  baseeditinput" type="submit" value="保存" />
					<input class="cancel  baseeditinput baseeditcancel" type="reset" value="重置" />
				</div>
			</form>
			
			<form action="operate_addOrModfiyProject2.html" method="post">
				<input type="hidden" name="code" value="${projectModel.code }"/>
				<input type="hidden" name="id" value="${projectModel.id }"/>
				<div class="column">
					<div class="intitle">
						基本信息 <img class="smallimg editimg" src="<%=basePath%>/resource/images/front_company/edit.png" />
					</div>
					<table class="basedetail" border="0" cellspacing="1" cellpadding="0">
						<tr>
							<th>项目报建</th>
							<td>
								<span class="baseedits">${projectModel.pro.get('1') }</span>
								<input class="baseeditinput" type="text" name="num1" value="${projectModel.pro.get('1') }"/>
							</td>
							<th>资信证明</th>
							<td>
								<span class="baseedits">${projectModel.pro.get('2') }</span>
								<input class="baseeditinput" type="text" name="num2" value="${projectModel.pro.get('2') }"/>
							</td>
							<th>立项文号</th>
							<td>
								<span class="baseedits ">${projectModel.pro.get('3') }</span>
								<input class="baseeditinput" type="text" name="num3" value="${projectModel.pro.get('3') }"/>
							</td>
						</tr>
						<tr>
							<th>用地规划许可证</th>
							<td>
								<span class="baseedits ">${projectModel.pro.get('4') }</span>
								<input class="baseeditinput" type="text" name="num4" value="${projectModel.pro.get('4') }"/>
							</td>
							<th>工程规划许可证</th>
							<td>
								<span class="baseedits ">${projectModel.pro.get('5') }</span>
								<input class="baseeditinput" type="text" name="num5" value="${projectModel.pro.get('5') }"/>
							</td>
							<th>施工图审查</th>
							<td>
								<span class="baseedits ">${projectModel.pro.get('6') }</span>
								<input class="baseeditinput" type="text" name="num6" value="${projectModel.pro.get('6') }"/>
							</td>
						</tr>
						<tr>
							<th>工程招投标</th>
							<td>
								<span class="baseedits ">${projectModel.pro.get('7') }</span>
								<input class="baseeditinput" type="text" name="num7" value="${projectModel.pro.get('7') }"/>
							</td>
							<th>合同备案</th>
							<td>
								<span class="baseedits ">${projectModel.pro.get('8') }</span>
								<input class="baseeditinput" type="text" name="num8" value="${projectModel.pro.get('8') }"/>
							</td>
							<th>施工许可</th>
							<td>
								<span class="baseedits ">${projectModel.pro.get('9') }</span>
								<input class="baseeditinput" type="text" name="num9" value="${projectModel.pro.get('9') }"/>
							</td>
						</tr>
						<tr>
							<th>质量安全监督</th>
							<td>
								<span class="baseedits ">${projectModel.pro.get('10') }</span>
								<input class="baseeditinput" type="text" name="num10" value="${projectModel.pro.get('10') }"/>
							</td>
							<th>勘验评估合格证</th>
							<td>
								<span class="baseedits ">${projectModel.pro.get('11') }</span>
								<input class="baseeditinput" type="text" name="num11" value="${projectModel.pro.get('11') }"/>
							</td>
						</tr>
					</table>
				</div>
				<div class="columnthree">
					<input id="addSubmit" class="cancel  baseeditinput" type="submit" value="保存" />
					<input class="cancel  baseeditinput baseeditcancel" type="reset" value="重置" />
				</div>
			</form>
			
			<div class="column">
				<div class="intitle">
					参建单位
					<img class="addimg simg" data-value="joinBuild" src="<%=basePath%>/resource/images/front_company/add.png" />
				</div>
				<table class="basedetail">
					<c:forEach items="${joinBuildModels }" var="joinBuildModel">
						<form action="operate_modfiyBuildUnit.html" method="post">
							<input type="hidden" name="pCode" value="${projectModel.pCode }"/>
							<input type="hidden" name="id" value="${projectModel.id }"/>
							<tr>
								<td><input id="joinBuildId" type="hidden" name="joinBuildId " value="${joinBuildModel.id }"></td>
								<td>企业名称:</td>
								<td>
									<span class="baseedits ">${joinBuildModel.jName } </span>
									<input id="jName" class="baseeditinput" type="text" name="jName" value="${joinBuildModel.jName }"/>
								</td>
								<td>企业类型:</td>
								<td>
									<span class="baseedits " style="width: auto;">${joinBuildModel.jType }</span>
									<select id="jType" class="baseeditinput" name="jType" style="width: 120px;">
										<option value="" <c:if test="${joinBuildModel.jType==''}">selected</c:if>>请选择企业类型</option>
										<option value="工程监理" <c:if test="${joinBuildModel.jType=='工程监理'}">selected</c:if>>工程监理</option>
										<option value="工程设计" <c:if test="${joinBuildModel.jType=='工程设计'}">selected</c:if>>工程设计</option>
										<option value="建设施工" <c:if test="${joinBuildModel.jType=='建设施工'}">selected</c:if>>建设施工</option>
										<option value="工程勘察" <c:if test="${joinBuildModel.jType=='工程勘察'}">selected</c:if>>工程勘察</option>
									</select>
								</td>
								<td>组织机构代码:</td>
								<td>
									<span class="baseedits " style="width: auto;">${joinBuildModel.jNum }</span>
									<input id="jNum" class="baseeditinput" style="width: 120px;" type="text" name="jNum" value="${joinBuildModel.jNum }"/>
								</td>
								<td>联系方式:</td>
								<td id="joinBuildLeaderphone">
									<span class="baseedits " style="width: auto;">${joinBuildModel.leaderphone }</span>
									<input id="leaderphone" class="baseeditinput" style="width: 120px;" type="text" name="leaderphone" value="${joinBuildModel.leaderphone }"/>
								</td>
								<td>
									<img class="editimgone smallimg" src="<%=basePath%>/resource/images/front_company/edit.png"/>
									<input type="button" class="subcancel" value="" />
									<input id="joinBuildModfiySubmit" class="subhide"  type="submit" value=""/>
								</td>
							</tr>
						</form>
					</c:forEach>
				</table>
			</div>
			
			<div class="column">
				<div class="intitle">
					关键岗位人员
					<img class="addimg simg" data-value="keyPerson" src="<%=basePath%>/resource/images/front_company/add.png" />
				</div>
				<table class="basedetail keymen">
					<c:forEach items="${keyPersonModels }" var="keyPersonModel">
						<form action="operate_modfiyStaffPosition.html" method="post">
							<input type="hidden" name="pCode" value="${projectModel.pCode }"/>
							<input type="hidden" name="id" value="${projectModel.id }"/>
							<tr>
								<td><input id="keyPersonId" type="hidden" name="keyPersonId" value="${keyPersonModel.id }"></td>
								<td>姓名:</td>
								<td>
									<span class="baseedits " style="width: auto;">${keyPersonModel.name }</span>
									<input id="kname" class="baseeditinput" type="text" style="width: 120px;" name="kname" value="${keyPersonModel.name }"/>
								</td>
								<td>企业名称:</td>
								<td>
									<span class="baseedits " style="width: auto;">${keyPersonModel.cName } </span>
									<input id="cName" class="baseeditinput" type="text" style="width: auto;" name="cName" value="${keyPersonModel.cName }"/>
								</td>
								<td>担任角色:</td>
								<td>
									<span class="baseedits " style="width: auto;">
										<c:if test="${keyPersonModel.role=='1'}">项目经理</c:if>
										<c:if test="${keyPersonModel.role=='2'}">工程协管员</c:if>
										<c:if test="${keyPersonModel.role=='3'}">首席建筑师</c:if>
										<c:if test="${keyPersonModel.role=='4'}">暖通工程师</c:if>
										<c:if test="${keyPersonModel.role=='5'}">机械工程师</c:if>
										<c:if test="${keyPersonModel.role=='6'}">电气工程师</c:if>
										<c:if test="${keyPersonModel.role=='7'}">质量评估或质量控制文档管理员</c:if>
										<c:if test="${keyPersonModel.role=='8'}">质量评估或质量控制经理</c:if>
										<c:if test="${keyPersonModel.role=='9'}">商务经理</c:if>
										<c:if test="${keyPersonModel.role=='10'}">施工经理</c:if>
										<c:if test="${keyPersonModel.role=='11'}">流程协调员</c:if>
										<c:if test="${keyPersonModel.role=='12'}">施工员</c:if>
										<c:if test="${keyPersonModel.role=='13'}">预算员</c:if>
										<c:if test="${keyPersonModel.role=='14'}">安全员</c:if>
										<c:if test="${keyPersonModel.role=='15'}">质检员</c:if>
										<c:if test="${keyPersonModel.role=='16'}">材料员</c:if>
									</span>
									<select id="role" class="baseeditinput" name="role" style="width: 120px;">
										<option value="" <c:if test="${keyPersonModel.role==''}">selected</c:if>>请选择角色类型</option>
										<option value="1" <c:if test="${keyPersonModel.role=='1'}">selected</c:if>>项目经理</option>
										<option value="2" <c:if test="${keyPersonModel.role=='2'}">selected</c:if>>工程协管员</option>
										<option value="3" <c:if test="${keyPersonModel.role=='3'}">selected</c:if>>首席建筑师</option>
										<option value="4" <c:if test="${keyPersonModel.role=='4'}">selected</c:if>>暖通工程师</option>
										<option value="5" <c:if test="${keyPersonModel.role=='5'}">selected</c:if>>机械工程师</option>
										<option value="6" <c:if test="${keyPersonModel.role=='6'}">selected</c:if>>电气工程师</option>
										<option value="7" <c:if test="${keyPersonModel.role=='7'}">selected</c:if>>质量评估或质量控制文档管理员</option>
										<option value="8" <c:if test="${keyPersonModel.role=='8'}">selected</c:if>>质量评估或质量控制经理</option>
										<option value="9" <c:if test="${keyPersonModel.role=='9'}">selected</c:if>>商务经理</option>
										<option value="10" <c:if test="${keyPersonModel.role=='10'}">selected</c:if>>施工经理</option>
										<option value="11" <c:if test="${keyPersonModel.role=='11'}">selected</c:if>>流程协调员</option>
										<option value="12" <c:if test="${keyPersonModel.role=='12'}">selected</c:if>>施工员</option>
										<option value="13" <c:if test="${keyPersonModel.role=='13'}">selected</c:if>>预算员</option>
										<option value="14" <c:if test="${keyPersonModel.role=='14'}">selected</c:if>>安全员</option>
										<option value="15" <c:if test="${keyPersonModel.role=='15'}">selected</c:if>>质检员</option>
										<option value="16" <c:if test="${keyPersonModel.role=='16'}">selected</c:if>>材料员</option>					
									</select>
								</td>
								<td>联系方式:</td>
								<td id="keyPersonPhone">
									<span class="baseedits " style="width: auto;">${keyPersonModel.phone } </span>
									<input id="phone" class="baseeditinput" type="text" style="width: auto;" name="phone" value="${keyPersonModel.phone }"/>
								</td>
								<td>
									<img class="editimgone smallimg" src="<%=basePath%>/resource/images/front_company/edit.png" />
									<input type="button" class="subcancel" value="" />
									<input id="keyPersonModfiySubmit" class="subhide"  type="submit" value=""/>
								</td>
							</tr>
						</form>
					</c:forEach>
				</table>
			</div>
			
			<form action="operate_modfiyProjectNote.html" method="post">
				<input type="hidden" name="pCode" value="${projectModel.pCode }"/>
				<input type="hidden" name="id" value="${projectModel.id }"/>
				<div class="columntwo">
					<div class="intitle">项目规模
					<img class="smallimg editimgtwo" src="<%=basePath%>/resource/images/front_company/edit.png" /></div>
					<span class="describe">描述</span>
					<span class="des baseedits">${projectModel.note }</span>
					<textarea class="baseeditinput" style="display: none;" name="note">${projectModel.note }</textarea>
				</div>
				<div class="columnthree">
					<input class="cancel baseeditinput" type="submit" value="保存" />
					<input class="cancel baseeditinput baseeditcancel" type="reset" value="重置" />
				</div>
			</form>
			
			<!-- hidden -->
			<form class="addform" id="joinBuild" action="operate_addBuildUnit.html" method="post">
				<input type="hidden" name="pCode" value="${projectModel.pCode }"/>
				<input type="hidden" name="id" value="${projectModel.id }"/>
				<table class="basedetail">
					<tr>
						<td class="intitle">参建单位</td>
					</tr>
					<tr>
						<td>企业名称</td>
						<td><input id="jName2" type="text" name="jName"/></td>
					</tr>
					<tr>
						<td>组织机构代码</td>
						<td><input id="jNum2" type="text" name="jNum"/></td>
					</tr>
					<tr>
						<td>联系方式</td>
						<td id="joinBuildLeaderphone2"><input id="leaderphone2" type="text" name="leaderphone"/></td>
					</tr>
					<tr>
						<td>单位类型</td>
						<td>
							<select id="jType2" name="jType">
								<option>单位类型</option>
								<option>工程监理</option>
								<option>工程设计</option>
								<option>建设施工</option>
								<option>工程勘察</option>
							</select>
						</td>
					</tr>
				</table>
				<div class="columnthree">
					<input id="joinBuildAddSubmit" class="cancel" type="submit" value="保存" />
					<input class="cancel addcancel" type="button" value="取消" />
				</div>
			</form>
			
			<form class="addform" id="keyPerson" action="operate_addStaffPosition.html" method="post">
				<input type="hidden" name="pCode" value="${projectModel.pCode }"/>
				<input type="hidden" name="id" value="${projectModel.id }"/>
				<table class="basedetail">
					<tr>
						<td class="intitle">关键岗位人员</td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input id="name2" type="text" name="name"/></td>
					</tr>
					<tr>
						<td>公司名称</td>
						<td><input id="cName2" type="text" name="cName"/></td>
					</tr>
					<tr>
						<td>联系方式</td>
						<td id="keyPersonPhone2"><input id="phone2" type="text" name="phone"/></td>
					</tr>
					<tr>
						<td>担任角色</td>
						<td>
							<select id="role2" name="role">
								<option value="">角色类型</option>
								<option value="1">项目经理</option>
								<option value="2">工程协管员</option>
								<option value="3">首席建筑师</option>
								<option value="4">暖通工程师</option>
								<option value="5">机械工程师</option>
								<option value="6">电气工程师</option>
								<option value="7">质量评估或质量控制文档管理员</option>
								<option value="8">质量评估或质量控制经理</option>
								<option value="9">商务经理</option>
								<option value="10">施工经理</option>
								<option value="11">流程协调员</option>
								<option value="12">施工员</option>
								<option value="13">预算员</option>
								<option value="14">安全员</option>
								<option value="15">质检员</option>
								<option value="16">材料员</option>
							</select>
						</td>
					</tr>
				</table>
				<div class="columnthree">
					<input id="keyPersonAddSubmit" class="cancel" type="submit" value="保存" />
					<input class="cancel addcancel" type="button" value="取消" />
				</div>
			</form>

		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/area.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/main.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/operate/companyDetailProject.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/operate/projectdetail.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/operate/joinBuild.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/operate/keyPerson.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>