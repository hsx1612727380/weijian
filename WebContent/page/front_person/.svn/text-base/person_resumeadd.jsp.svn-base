<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_person/person_left_handler.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/idperson.css" />
		
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
				<span>认证状态：个人</span>
			</div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
				<div class="detailright">
				<form id="form1" action="personResumeAdd.html" method="post">
					<input type="hidden" name="token" value="${token}"/>
					<input type="hidden" name="rId" value="${userModel.userId}"/>
					<input type="hidden" name="userType" value="1"/>
					<input type="hidden" name="type" value="1"/>
					<input type="hidden" name="status" value="1"/>
					<div>
						<label>求职标题</label>
						<span><input name="title" placeholder="求职标题！"/></span>
					</div>
					<div>
						<label>姓名</label>
						<span><input name="name" readonly value="${userModel.userName}"/></span>
					</div>
					<div>
						<label>技能类别</label>
						<span>
							<select id="skillBigType" onchange="skillBigType1()" name="skillBigType" style="width : 123px" > 
								<option value="">选择类别</option>
								<option value="1" >土建</option>
								<option value="2" >管理</option>
								<option value="3" >安装</option>
								<option value="4" >其他</option>
							</select>
						</span>
						<span>
							<select id="smalltype" name="skillSmallType" style="width : 123px" >
								<option value="">技能小类型</option>
							</select>
						</span>
					</div>
					<div>
						<label>求职地区:</label>
						<span >
							<select id="province" onchange="setCity(this.value);getArea();" name="province" style="width : 123px"  >
	                              <option value="">请选择省份</option>
	                        </select>
	                    </span>
	                    <span>
	                        <select id="city" onchange="setCounty(this.value);getArea();" name="city" style="width : 123px">
	                              <option value="">请选择城市</option>
	                        </select>
						</span>
					</div>
					<div>
						<label>诚信度</label>
						<c:forEach begin="1" end="${userModel.reliableStar}">
							<span><img src="resource/images/u662.png" /></span> 
						</c:forEach>
						<c:forEach begin="${userModel.reliableStar}" end="4">
							<span><img src="resource/images/u663.fw.png" /></span> 
						</c:forEach>
					</div>
					<div>
						<label>联系方式</label>
						<input type="text" readonly value="${userModel.userId}"/>
					</div>
					<!-- <div>
						<label>本人地址</label> -->
						<input type="hidden" readonly value="${userModel.userProvinceStr}-${userModel.userCityStr}" />
					<!-- </div> -->
					<div>
						<label>持证情况</label>
						<span><input type="text" name="credential" value="${userModel.credential}"/></span>
					</div>
					<div>
						<label>备注</label>
						<span><input type="text" name="desc" placeholder="求职备注！"/></span>
					</div>
					<input id="submit1" class="sure" value="确认"></input>
					<a href="personResume.html" class="cancel">取消</a>
				</form>
				</div>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true"/>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="resource/js/front_person/skillType.js" charset="utf-8"></script>
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="resource/js/area.js" ></script>
	</body>
<script type="text/javascript">
		$(function(){
			 $("#submit1").on('click',function(){
				var province= $("#province");
				var city = $("#city");
				var skillBigType = $("#skillBigType");
				var smallType = $("#smalltype");
				var msg = "";
				if ($.trim(province.val()) == "") {
					msg="省份还没有选择！";
					province.focus();
				}else if ($.trim(city.val()) == "") {
					msg="城市还没有选择！";
					city.focus();
				}else if($.trim(skillBigType.val()) == ""){
					msg="工作技能类别还没有选择！";
					skillBigType.focus();
				}else
				if ($.trim(smallType.val()) =="") {
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