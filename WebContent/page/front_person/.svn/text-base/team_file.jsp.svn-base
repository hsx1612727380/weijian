<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<!-- 针对不同的登录用户类型隐藏左侧菜单的js -->
		<script src="resource/js/front_person/person_left_handler.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/personFile.css" />
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
		
		
	</head>
	<body>
		<input id="isLeader" type="hidden" value='${isLeader}'/> 
		<jsp:include page="../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>个人中心</span>
			</div>
		</div>
		<div class="content personal">
			<div class="autstate">
				<span>认证状态：</span><span>已认证 &nbsp;&nbsp;&nbsp;</span>
				<span>角色：</span><span>班组长</span>&nbsp;&nbsp;&nbsp;&nbsp;<font color="darkblue">诚信档案</font>
			</div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
				<div class="detailright">
					<div class="persontitle">
						<div class="filetile">班组诚信档案</div>
						<div class="print" onclick="printit();">打印</div>
						<div id="change" class="update" >修改</div>&nbsp;&nbsp;&nbsp;
						<div id="update" class="update">更新</div>
					</div>
					<!--startprint-->
					<form action="updatePerson.html" method="post">
					<input type="hidden" name="id" value="${personModel.id}"/>
					
					<table border="0" cellspacing="1" cellpadding="5">
						<tr>
							<th colspan="6" class="thcenter">班组资料</th>
						</tr>
						<tr>
							<th>班组编号:</th>
							<td>
								<span >${personModel.teamCode}</span>
								<span ><input  name="teamCode" type="hidden"  value="${personModel.teamCode}"/></span>
							</td>
							<th>班组名称:</th>
							<td colspan="3">
								<span class="noform">${personModel.teamName}</span>
								<span class="form" ><input name="teamName"  value="${personModel.teamName}"/></span>
							</td>
						</tr>
						<tr>
							<th>技能类别:</th>
							<td>
								<span class="noform">${personModel.skillBigTypeName}</span>
								<span class="form" >
									<%-- <input name="skillBigType" value="${personModel.skillBigType}"/> --%>
									<select class="form" id="skillBigType" onchange="skillBigType1()" name="skillBigType" style="width: 96px"> 
										<option value="0">选择类别</option>
										<option value="1" <c:if test="${personModel.skillBigType=='1'}"> selected </c:if> >土建</option>
										<option value="2" <c:if test="${personModel.skillBigType=='2'}"> selected </c:if>>管理</option>
										<option value="3" <c:if test="${personModel.skillBigType=='3'}"> selected </c:if>>安装</option>
										<option value="4" <c:if test="${personModel.skillBigType=='4'}"> selected </c:if>>其他</option>
									</select>
								</span>
							</td>
							<th>技能类型:</th>
							<td colspan="1">
								<input id="SmallTypeBack" type="hidden" value="${personModel.skillSmallType}"/>
								<span  class="noform">${personModel.skillSmallTypeName}</span>
								<span class="form">
									<%-- <input name="skillSmallType" id="skillSmallType"  type="hidden" value="${personModel.skillSmallType}"/> --%>
									<select  name="skillSmallType" id="smalltype">
										<option >技能小类型</option>
									</select>
								</span>
							</td>
							<th>求职地区:</th>
							<td  colspan="1">
								<span  class="noform">${personModel.provinceChn}${personModel.cityChn}</span>
								<span >
									<%-- <input name="province"  value="${personModel.province}"/>
									<input name="city"  value="${personModel.city}"/> --%>
									<select class="form" id="province" onchange="setCity(this.value);getArea();" name="province" runat="server">
			                              <option value="${personModel.province}">--请选择省份--</option>
			                        </select>
			                        
			                        <select class="form" id="city" onchange="setCounty(this.value);getArea();" name="city" runat="server">
			                              <option value="${personModel.city}" selected="selected">--请选择城市--</option>
			                        </select>
								</span>
							</td>
						</tr>
						<tr>
							<th>工作年限:</th>
							<td>
								<span class="noform">${personModel.worktime}</span>
								<span class="form"><input name="worktime"  value="${personModel.worktime}"/></span>
							</td>
							<th>诚信度:</th>
							<td id="integrity">
								<c:forEach begin="1" end="${personModel.integrity/20}">
									<span><img src="resource/images/u662.png" /></span> 
								</c:forEach>
								<c:forEach begin="${personModel.integrity/20}" end="4">
									<span><img src="resource/images/u663.fw.png" /></span> 
								</c:forEach>
							</td>
							
							<th>求职状态:</th>
							<td><!-- 求职/用工状态 1：正在找工作 ；2：在岗；3：在岗，寻求更好的工作 -->
								<span class="noform"><c:if test="${personModel.jobstatus=='1'}">找工作</c:if></span>
								<span class="noform"><c:if test="${personModel.jobstatus=='2'}">在岗</c:if></span>
								<span class="noform"><c:if test="${personModel.jobstatus=='3'}">寻求更好的工作</c:if></span>
								<span class="form">
									<select name=jobstatus >
										<option value="" <c:if test="${personModel.jobstatus==''}">selected</c:if>>请选择</option>
									    <option value="1" <c:if test="${personModel.jobstatus=='1'}">selected</c:if>>找工作</option>
									    <option value="2" <c:if test="${personModel.jobstatus=='2'}">selected</c:if>>已工作</option>
									    <option value="3" <c:if test="${personModel.jobstatus=='3'}">selected</c:if>>寻求更好的工作</option>
									</select>
								</span>
							</td>
						</tr>
						<tr>
							<th colspan="6" class="thcenter">进/退场时间</th>
						</tr>
						<tr>
							<th>进场时间: </th>
							<td colspan="2" >
								<span class="noform">${personModel.entryTime}</span>
								<%-- <span class="form"><input  name="entryTime"  value="${personModel.entryTime}"/></span> --%>
							</td>
							<th>退场时间: </th>
							<td colspan="2" >
								<span class="noform">${personModel.exitTime}</span>
								<%-- <span class="form"><input  name="exitTime"  value="${personModel.exitTime}"/></span> --%>
							</td>
						</tr>
						<tr>
							<th colspan="6" class="thcenter">班组长资料</th>
						</tr>
						<tr>
							<th>班组长: </th>
							<td >
								<span class="noform">${personModel.name}</span>
								<span class="form"><input  name="name"  value="${personModel.name}"/></span>
							</td>
							<th>家庭住址:</th>
							<td colspan="3">
								<span class="noform">${personModel.address}</span>
								<span class="form" ><input name="address" value = "${personModel.address}"/></span>
							</td>
						</tr>
						<tr>
							<th>性别:</th>
							<td >
								<span class="noform">
									<c:if test="${personModel.gender=='1'}"> 男 </c:if>
									<c:if test="${personModel.gender=='2'}"> 女</c:if>
								</span>
								<span class="form">
									<select name="gender"  > 
										<option value="1" <c:if test="${personModel.gender=='1'}">selected </c:if> >男</option>
										<option value="2" <c:if test="${personModel.gender=='2'}">selected </c:if> >女</option>
									</select>
								</span>
							</td>
							<th>民族:</th>
							<td >
								<span class="noform">${personModel.national}</span>
								<span class="form"><input  name="national"  value="${personModel.national}"/></span>
							</td>
							<th>文化程度:</th>
							<td >
								<span class="noform">${personModel.education}</span>
								<span class="form"><input  name="education"  value="${personModel.education}"/></span>
							</td>
						</tr>
						<tr>
							<th>班长电话:</th>
							<td >
								<span>${userId}</span>
								<%-- <span class="form"><input  name="birth"  value="${personModel.birth}"/></span> --%>
							</td>
							
							<th>年龄:</th>
							<td >
								<span class="noform">${personModel.age}</span>
								<span class="form"><input  name="age"  value="${personModel.age}"/></span>
							</td>
							<th>婚姻状态:</th>
							<td >
								<span class="noform">${personModel.marriage}</span>
								<span class="form"><input  name="marriage"  value="${personModel.marriage}"/></span>
							</td>
						</tr>
						<tr>
							<th>身高:</th>
							<td>
								 <span class="noform">${personModel.height}</span>
								 <span class="form"><input name="height"  value="${personModel.height}"/></span>
							</td>
							<th>体重:</th>
							<td>
								 <span class="noform">${personModel.weight}</span>
								 <span class="form"><input name="weight"  value="${personModel.weight}"/></span>
							</td>
							<th>身体状况:</th>
							<td>
								 <span class="noform">${personModel.health}</span>
								 <span class="form"><input name="health"  value="${personModel.health}"/></span>
							</td>
						</tr>
						<tr>
							<th>身份证号码:</th>
							<td colspan="1">
								 <span >${personModel.identity}</span>
								<%--  <span class="form"><input name="identity"  value="${personModel.identity}"/></span> --%>
							</td>  
							<th>银行卡:</th>
							<td colspan="3">
								<span class="noform">${personModel.bankcard}</span>
								<span class="form" ><input name="bankcard" value = "${personModel.bankcard}"/></span>
							</td>                                                                                                                                                                       
						</tr>
						<tr>
							<th colspan="6" class="thcenter">
								联系方式及帐号
							</th>
						</tr>
						<tr>
							<th>微信:</th>
							<td>
								<span class="noform"></span>
							</td>
							<th>支付宝:</th>
							<td>
								<span class="noform"></span>
							</td>
							<th>其他:</th>
							<td>
								<span class="noform"></span>
							</td>
						</tr>
						<tr class="hide">
							<th colspan="6" class="thcenter">
								电子文档
							</th>
						</tr>
						<tr class="hide">
							<th>上岗证:</th>
							<td></td>
							<th>操作证:</th>
							<td></td>
							<th>平安卡号:</th>
							<td></td>
						</tr>
						<tr class="hide">
							<th>进场须知:</th>
							<td></td>
							<th>安全教育:</th>
							<td></td>
							<th>工资电子文档:</th>
							<td></td>
						</tr>
						<tr class="hide">
							<th>出入电子文档:</th>
							<td></td>
							<th>考勤电子文档:</th>
							<td></td>
							<th>计件计时合同:</th>
							<td></td>
						</tr>
					</table>
					
					</form>
					<div class="persontitle">
						<div class="filetile">项目部对您的评价</div>
					</div>
					<table class="assess" border="0" cellspacing="1" cellpadding="0">
						<tr>
							<td>项目名称</td>
							<td>起止时间</td>
							<td>所在班组</td>
							<td>技能</td>
							<td>勤劳度</td>
							<td>工作态度</td>
							<td>综合评价</td>
						</tr>
						<c:forEach items="${commentsModelList}" var="comment" >
						<tr>
							<td>${comment.projectName}</td>
							<td>${comment.startTime}至${comment.endTime}</td>
							<td>${comment.teamName}</td>
							<td><c:forEach begin="1" end="${comment.scoreStr1}">
									   <span><img src="resource/images/u662.png"/></span>
									</c:forEach></td>
							<td><c:forEach begin="1" end="${comment.scoreStr2}">
									   <span><img src="resource/images/u662.png"/></span>
									</c:forEach></td>
							<td><c:forEach begin="1" end="${comment.scoreStr3}">
									   <span><img src="resource/images/u662.png"/></span>
									</c:forEach></td>
							<td>${comment.desc}</td>
						</tr>
						</c:forEach>
					</table>
					<div  class="hide" class="persontitle">
						<div  class="filetile">您对项目部的评价</div>
					</div>
					<table  class="hide" class="assess" border="1" cellspacing="1" cellpadding="0">
						<tr>
							<td>项目名称</td>
							<td>起止时间</td>
							<td>所在班组</td>
							<td>技能</td>
							<td>勤劳度</td>
							<td>工作态度</td>
							<td>综合评价</td>
							<td>差评记录</td>
						</tr>
						<tr>
							<td>广州名圃花园</td>
							<td>2016年2月至3月</td>
							<td>刘二喜</td>
							<td>良好</td>
							<td>良好</td>
							<td>良好</td>
							<td>良好</td>
							<td>无</td>
						</tr>
					</table>
					<!--endprint-->
				</div>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script type="text/javascript" src="resource/js/team_add.js" charset="utf-8"></script>
		<script type="text/javascript" src="resource/js/area.js" ></script>
		<script src="resource/js/front_person/front_person_file.js" type="text/javascript"></script>
		<script src="resource/js/front_person/front_person_print.js" type="text/javascript"></script>
	</body>
</html>