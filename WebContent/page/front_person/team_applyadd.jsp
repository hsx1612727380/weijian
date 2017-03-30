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
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/idteam.css" />
		<style>
			.personal .detailright input, .personal .detailright select{
				box-sizing:content-box;
			}
		</style>
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
				<span>角色：</span><span>班组长</span>
			</div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
				<div class="detailright">
					
					<div class="persontitle">
						<div class="filetile">班组发布对项目求职</div>
						<div id="submit1" class="print" >发布</div>
					</div>
					<form id="form1" action="applyforproject.html" method="post">
						<input type="hidden" name="token" value="${token}"/>
						<div>
							<label>求职标题</label>
							<span><input name="title" id="title" value="" style="width : 240px" placeholder="求职标题 必填"/></span>
						</div>
						<div>
							<label>班组长</label>
							<span><input name="leaderName" readonly value="${teamModel.leaderName}" style="width : 240px"/></span>
						</div>
						<div>
							<label>班组名称:</label>
							<span><input name="teamName" readonly value="${teamModel.name}" style="width : 240px"/></span>
						</div>
						<div>
							<label>班长电话:</label>
							<span><input name="teamName" readonly value="${teamModel.leaderMobile}" style="width : 240px"/></span>
						</div>
						<div>
							<label>技能类别:</label>
							<span>
								<select id="skillBigType" onchange="skillBigType1()" name="skillBigType" style="width : 107px" > 
									<option value="0">选择类别</option>
									<option value="1" >土建</option>
									<option value="2" >管理</option>
									<option value="3" >安装</option>
									<option value="4" >其他</option>
								</select>
							</span>
							<span>
								<input id="SmallTypeBack" type="hidden" value="${personModel.skillSmallType}" />
								<select id="smalltype" name="skillSmallType"  style="width : 107px">
									<option  value="">技能小类型</option>
								</select>
							</span>
						</div>
						<div>
							<label>求职地区:</label>
							<span >
								<select id="province" onchange="setCity(this.value);getArea();" name="province" style="width : 107px"  >
		                              <option value="">请选择省份</option>
		                        </select>
		                    </span>
		                    <span>
		                        <select id="city" onchange="setCounty(this.value);getArea();" name="city" style="width : 107px">
		                              <option value="" selected="selected">请选择城市</option>
		                        </select>
							</span>
						</div>
						<div>
							<label>班组地址:</label>
							<span ><input name="street" value="${personModel.address}" style="width : 240px"/></span>
						</div>
						<div>
							<label>备注:</label>
							<span><input name="desc"  placeholder="求职备注"  style="width : 240px"/></span>
						</div>
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script type="text/javascript" src="resource/js/team_add.js" charset="utf-8"></script>
		<script type="text/javascript" src="resource/js/area.js" ></script>
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
	</body>
	<script type="text/javascript">
		$(function(){
			 $("#submit1").on('click',function(){
				var title = $("#title");
				var province= $("#province");
				var city = $("#city");
				var skillBigType = $("#skillBigType");
				var smallType = $("#smalltype");
				var msg = "";
				if($.trim(title.val()) == ""){
					msg="请写求职标题！";
					title.focus();
				}else if ($.trim(province.val()) == "") {
					msg="省份还没有选择！";
					province.focus();
				}else if ($.trim(city.val()) == "") {
					msg="城市还没有选择！";
					city.focus();
				}else if($.trim(skillBigType.val()) == ""){
					msg="工作技能类别还没有选择！";
					skillBigType.focus();
				}else if ($.trim(smallType.val()) =="") {
					msg="工作技能类型还没有选择！";
					smallType.focus();
				}
				if(msg!=""){
					alert(msg);
				} else{
					$("#form1").submit();
				}
			 });
		 });
		</script>
</html>