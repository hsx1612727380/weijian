<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/idteam.css" />
		<script type="text/javascript">
			function skillBigType1(){
				//获取技能小类型 动态追加
		 		$.ajax({
		 		    type : 'post',
		 		    url : 'team_getSmallSkillType.html',
		 		    dataType : 'text',
		 		    data : $('#skillBigType').serialize(),
		 		    async: true,
		 		    success : function (date) {
		 		    	var msg = eval("("+date+")");   
		 		    	$('#smalltype').empty();//先清空原来的option,再添加新的上去
		 		    	for(var i=0;i<msg.length;i++){
		 		    		if(smalltype == msg[i].skillType ){
		 			    		$('#smalltype').prepend('<option selected='+'"true"'+'value="' + msg[i].skillType + '">' + msg[i].skillName + '</option>');
		 		    		}else{
		 			    		$('#smalltype').prepend('<option value="' + msg[i].skillType + '">' + msg[i].skillName + '</option>');
		 		    		}
		 		    	};
		 		    },
		 		    error : function (xmlq, errq) {
		 		    	alert("xmlq:"+xmlq+"  errq:"+errq);
		 		    }
		 		});
			};
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
			<div class="autstate">
				<span>认证状态：</span><span>已认证 &nbsp;&nbsp;&nbsp;</span>
				<span>角色：</span><span>班组长</span>
			</div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
				
				<div class="detailright">
					<form id="addform" action="personAddRecruit.html"  method="post">
					<input type="hidden" name="token" value="${token}"/>
					<div>
						<label>班组名称</label>
						<span><input name="name" readonly value="${teamModel.name}"/></span>
					</div>
					<div>
						<label>班组长</label>
						<span><input name="leaderName" readonly value="${teamModel.leaderName}"/></span>
					</div>
					<div>
						<label>招聘标题</label>
						<span><input name="title" id="title" value="" placeholder="招聘标题" /></span>
					</div>
					<div>
						<label>技能类别</label>
						<select id="skillBigType" onchange="skillBigType1()" name="skillBigType" > 
						<option value="">--选择类别--</option>
						<option value="1">土建</option>
						<option value="2">管理</option>
						<option value="3">安装</option>
						<option value="4">其他</option>
					</select>
					</div>
					<div>
						<label>技能类型</label>
						<select id="smalltype" name="skillSmallType">
						<option value="">--技能小类型--</option>
					</select>
					</div>
					<div>
						<label>招聘人数</label>
						<input name="num" id="num" value="6" placeholder="请填写数字"/>
					</div>
					<div>
						<label>招聘区域</label>
						<select id="province" onchange="setCity(this.value);getArea();" name="province" style="width : 120px"  >
							<option value="${personModel.province}" selected="selected">--请选择省份--</option>
						</select>
						<select id="city" name="city" style="width : 120px">
						  	<option value="${personModel.city}" selected="selected">--请选择城市--</option>
						</select>
					</div>
					<div>
						<label>联系方式</label>
						<input type="text" readonly value="${userId}"/>
					</div>
					<div>
						<label>地址</label>
						<input type="text" readonly value="${teamModel.provinceChn}${teamModel.cityChn}" />
					</div>
					<div>
						<label>备注</label>
						<input type="text" name="desc" value="" placeholder="招聘备注" />
					</div>
					<input type="hidden" name="rId" value="${teamModel.id}" />
					<input type="hidden" name="type" value="2" />
					<input type="hidden" name="userType" value="2" />
					<input type="hidden" name="status" value="1" />
					<input type="hidden" name="teamType" value="1" />
					<input type="button" id="submited" class="identy" value="保存" />
					<input type="button" id="cancel" class="cancel" value="取消" />
				</form>
				</div>
				
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="resource/js/area.js" ></script>
	</body>
	<script type="text/javascript">
		 	$(function(){
				//校验	 		
				$("#submited").on('click',function(){
					var reg = /^[1-9]+[0-9]*$/;  //判断正整数 /^[1-9]+[0-9]*]*$/  
					var title = $("#title");
					var province= $("#province");
					var num = $("#num");
					var city = $("#city");
					var skillBigType = $("#skillBigType");
					var smalltype = $("#smalltype");
					var msg = "";
					console.log("————————————————————"+skillBigType.val());
					console.log("————————————————————"+smalltype.val());
					if($.trim(title.val()) == ""){
						msg="请写求职标题！";
						title.focus();
					}else if ($.trim(province.val()) == "") {
						msg="省份还没有选择！";
						province.focus();
					}else if ($.trim(city.val()) == "") {
						msg="城市还没有选择！";
						city.focus();
					}else if (!reg.test(num.val())) {//校验正整数数字
						msg="请填写正整数！";
						num.focus();
					}else if($.trim(skillBigType.val()) == ""){
						msg="工作技能类别还没有选择！";
						skillBigType.focus();
					}else if ($.trim(smalltype.val()) == ""){
						alert($.trim(smalltype.val()));
						msg="工作技能类型还没有选择！";
						smallType.focus();
					}
					if(msg!=""){
						alert(msg);
					}else{
						console.log("form");
						$("#addform").submit();
					}
				});
			});
		 	$("#cancel").on('click',function(){
		 		window.location.href="personRecruit.html";
		 	});
		</script>
</html>