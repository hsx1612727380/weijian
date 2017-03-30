<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_person/person_left_handler.js" type="text/javascript"></script>
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/idteam.css" />
		<script type="text/javascript">
			$(function(){
			 $("#save").on('click',function(){
				var name = $("#name");
				console.log($("#name").val());
				var province= $("#province");
				var city = $("#city");
				var skillBigType = $("#skillBigType");
				var smalltype = $("#smalltype");
				var msg = "";
				$.ajax({
					url : "checkTeamName.html",
					type : "get",
					dataType : 'text',
					async : false,//这个要同步执行，否则，后面判断msg="",就提交了，之后在返回的异步请求值就没意义了
					data : {"name":$("#name").val()},
					success : function(data){
						if(data=="1"){
							msg = "班组名称已被占用,请使用其他名称!";
						}
					},
					error : function(){
						msg = "班组名称重复性校验失败，请稍候再尝试创建！";
						console.log("班组名称重复性校验失败，请稍候再尝试创建！");
					}
				});
				if($.trim(name.val()) == ""){
					msg="班组名称不能为空！";
					name.focus();
				}else if ($.trim(province.val()) == "") {
					msg="省份还没有选择！";
					province.focus();
				}else if ($.trim(city.val()) == "") {
					msg="城市还没有选择！";
					city.focus();
				}else if($.trim(skillBigType.val()) == ""){
					msg="工作技能类别还没有选择！";
					skillBigType.focus();
				}
				if ($.trim(smalltype.val()) =="") {
					alert($.trim(smalltype.val()));
					msg="工作技能类型还没有选择！";
					smallType.focus();
				}
				if(msg!=""){
					alert(msg);
				} else{
					//alert("通过校验了，可以提交了。");
					$("#createform").submit();
				}
			 });
			});
		</script>
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
			<div class="autstate"><span>认证状态：</span><span>个人</span></div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
				<div class="detailright">
					<div class="filetitle">创建班组：</div>
					<form id="createform" action="saveCreatedTeam.html" method="post">
					<div>
						<label>班组名称</label>
						<input id="name" type="text" name="name" value="${name}" placeholder="班组名称为必填项">
					</div>
					<!-- 班组编号自动生成 -->
					<div>
						<label>班组长姓名</label>
						<input type="text" name="leaderName" value="${userName}" placeholder="班组长姓名为必填项"><!-- 从session中获取userName 就是leaderName -->
					</div>
					<div>
						<label>班组长电话</label>
						<input type="text" readonly="readonly" name="leaderMobile" value="${userId}"/>
					</div>
					<div>
						<label>班组长地址</label>
						<select id="province" onchange="setCity(this.value);getArea();" name="province" >
                              <option value="${personModel.province}">--请选择省份--</option>
                        </select>
                    </div>
					<div> 
                        <select id="city" onchange="setCounty(this.value);getArea();" name="city" style="margin-left:204px">
                              <option value="${personModel.city}" selected="selected">--请选择城市--</option>
                        </select>
					</div>
					<div>
						<input name="street" value="${teamModel.street}" style="margin-left:204px" placeholder="街道"/>
					</div>
					<div>
						<label>班组类型</label>
						<span>施工班组</span>
					</div>
					<!-- <div>
						<label>班组类别</label>
						<select  id="skilltype" name="skilltype" style="width: 96px">
							<option>本公司班组</option>
							<option>劳务班组</option>
							<option>专业班组</option>
						</select>
					</div> -->
					<div>
						<label>技能类别</label>
						<select id="skillBigType" onchange="skillBigType1()" name="skillBigType" style="width: 250px"> 
							<option value="0">选择类别</option>
							<option value="1">土建</option>
							<option value="2">管理</option>
							<option value="3">安装</option>
							<option value="4">其他</option>
						</select>
					</div>
					<div>
						<label>技能类型</label>
						<select id="smalltype" name="skillSmallType">
							<option >技能类型</option>
						</select>
					</div>
					<input id="save" class="identy" value="保存" /> <!-- type="submit" -->
				</form>
				</div>
			</div>
		</div>
		 <jsp:include page="../down.jsp" flush="true" />
		<script type="text/javascript" src="resource/js/team_add.js" charset="utf-8"></script>
		<script type="text/javascript" src="resource/js/area.js" ></script>
	</body>

</html>