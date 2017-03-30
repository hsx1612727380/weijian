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
		<link rel="stylesheet" type="text/css" href="resource/css/operate/operateadd.css" />
		
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			<div class="detail">
				<div class="detailright">
				
					<form id="enterAndExit" action="operate_addenterandexit.html" method="post">
						<input type="hidden" name="token" value="${token}"/>
						<input type="hidden" name="id" value="${id}"/>
						<div id="hidden" >
							<label>班组/个人进退场记录</label>
							<span>
								<select id="type" name="type">
									<option value="2" <c:if test="${type==2}">selected</c:if> style="width:60px">班组</option>
									<option value="1" <c:if test="${type==1}">selected</c:if> style="width:60px">个人</option>
								</select>
							</span>
						</div>
						<div>
							<label>班组名称</label>
							<span>
								<select id="teamModel" name="tId" >
									<c:forEach items="${teamList}" var="teamModel">
										<option value="${teamModel.id}">${teamModel.name}</option>
									</c:forEach>
								</select>
							</span>
						</div>
						<div  class="name">
							<label>姓名</label>
							<!-- 如果添加 班组进退场直接将这个隐藏掉，如果是添加个人进退场，使用ajax根据type和选择的teamModel进行查询返回userList加载到选项上像上面的teamModel一样-->
							<select id="name" name="userId">
							</select>
							<!-- <span><input name="name" type="text" placeholder="请填写姓名！"/></span> -->
						</div>
						<!-- <div>
							<label>联系方式</label>
							<span><input name="cId" type="text" placeholder="请填写班组长注册时的手机号！"/></span>
						</div> -->
						<div>
							<label>性质</label>
							<span>
								<select id="eqtime" name="inOrOut"> <!-- 目前这个字段自用来通过js控制前端的页面 -->
									<option value="1">进场</option>
									<option value="0">退场</option>
								</select>
							</span>
						</div>
						<div class="enter">
							<label>进场时间</label>
							<span><input id="startTime" name="startTime" type="text" value="" placeholder="格式：2016-01-01"/></span>
						</div>
						<div class="quit">
							<div>
								<label>退场时间</label>
								<span><input name="endTime" type="text" value="" placeholder="格式：2016-01-01" /></span>
							</div>
							<div class="star">
								<label>技能</label>
								<span>
									<i class="starnone">★</i>
									<i class="starnone">★</i>
									<i class="starnone">★</i>
									<i class="starnone">★</i>
									<i class="starnone">★</i>
								</span>
							</div>
							<div class="star">
								<label>勤劳度</label>
								<span>
									<i class="starnone">★</i>
									<i class="starnone">★</i>
									<i class="starnone">★</i>
									<i class="starnone">★</i>
									<i class="starnone">★</i>
								</span>
							</div>
							<div class="star">
								<label>工作态度</label>
								<span>
									<i class="starnone">★</i>
									<i class="starnone">★</i>
									<i class="starnone">★</i>
									<i class="starnone">★</i>
									<i class="starnone">★</i>
								</span>
							</div>
							<div>
								<label>差评记录</label>
								<span>
									<input name="desc" type="text" />
								</span>
							</div>
						</div>
						<input type="submit" class="identy" value="保存" />
						<input type="reset" id="cancel" class="cancel" value="取消" />
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/operate/operateenter.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/operate/operateenteradd.js" type="text/javascript" charset="utf-8"></script>
		
	</body>
	<script type="text/javascript">
	$(function() {
		
		$("#hidden").hide();
		$("#cancel").on('click',function(){
			window.location.href="operate_enterandexit.html?id=${id}";
		});
		var type =$("#type").val();
		console.log("type : "+ type);
		if(type==2){//添加班组时在后台根据teamModel添加name属性，页面隐藏掉
			$(".name").hide();
		}else if(type==1){//添加个人进退场记录时 根据所选班组去后台请求team Member数据加载到选项中，供选择
			$("#teamModel").on('blur',function(){
				var tid = $('#teamModel option:selected').val();
				console.log("teamModel.name： "+teamModel);
				$.ajax({
					url : 'getTeamMember.html',
					type : 'post',
					dataType : 'text',
					data : {'tId' : tid},
					async : true,
					success : function(data){
						var dataarr=JSON.parse(data);
						$('#name').empty();
						for(var i=0; i<dataarr.length; i++){
							console.log(dataarr[i]);
							$('#name').prepend('<option value='+ dataarr[i].userId +'>' + dataarr[i].userName + '</option>');
						}
					},
					error : function(){
						alert("数据加载异常!");
					}
				});
			});
		}
	});
	</script>
</html>