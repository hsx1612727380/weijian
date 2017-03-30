<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="../resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="../resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="../resource/css/front_equipment/equipAddgroud.css" />
		<link rel="stylesheet" type="text/css" href="../resource/css/tabfooter.css" />		
		<script src="../resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				$("#search").on('click',function(){
					$("#form").submit();
				});
				$("#leaderName").hide();
			});
			function changeInput(){
				if($("#select").val()==0){
					console.log($("#select").val());
					$("#name").show();
					$("#leaderName").hide();
				}else {
					$("#name").hide();
					$("#leaderName").show();
				}
			}
			$(function(){
				var vid = '${materialModel.id}';//班组id
				var name = '${materialModel.name}';//班组名称
				console.log(vid+" "+name);
				$(".joinProject").on('click',function(){
					var index = $(this).index();
					console.log(index+" "+$(this).siblings().eq(0).html());
					var pid =$(this).siblings().eq(0).html();//项目id (获取第一个兄弟元素的html值)
					var status =$(this).siblings().eq(1).html();//申请状态status (获取第二个兄弟元素的html值)
					var pdId =$(this).siblings().eq(2).html();//申请id (获取第二个兄弟元素的html值)
					console.log(vid+" "+name+" "+pid);
					//String vId,String pId,int status, int type,String name, 
					if(name==null&&name==""){
						alert("请先完善材料商基本信息，如名称等，再进行此操作"); 
					}else{
						//异步提交 加入项目申请
						$.ajax({
							url : "joinProject.html",
							type : "POST",
							data : {vId : vid, pId : pid, status : status, type : 2, name : name,pdId : pdId},
							dataType : 'text',
							async : true,
							success : function(msg){
								alert(msg);
								//撤回操作需要刷新页面
								document.location.href = "materialJoinProject.html";
							},
							error:function(){
								alert("数据加载失败！");
							}
						});
					}
				});
				$(".cancelProject").on('click',function(){
					var index = $(this).index();
					console.log(index+" "+$(this).siblings().eq(0).html());
					var pid =$(this).siblings().eq(0).html();//项目id (获取第一个兄弟元素的html值)
					var status =$(this).siblings().eq(1).html();//申请状态status (获取第二个兄弟元素的html值)
					var pdId =$(this).siblings().eq(2).html();//申请id (获取第二个兄弟元素的html值)
					console.log(vid+" "+name+" "+pid);
					//String vId,String pId,int status, int type,String name, 
					if(name==null&&name==""){
						alert("请先完善材料商基本信息，如名称等，再进行此操作"); 
					}else{
						//异步提交 加入项目申请
						$.ajax({
							url : "cancelProject.html",
							type : "POST",
							data : {vId : vid, pId : pid, status : status, type : 2, name : name,pdId : pdId},
							dataType : 'text',
							async : true,
							success : function(msg){
								alert(msg);
								//撤回操作需要刷新页面
								document.location.href = "materialJoinProject.html";
							},
							error:function(){
								alert("数据加载失败！");
							}
						});
					}
				});
				
				 $("#tablecur").hide();
				 $("#past").on('click',function(){
						$("#tablepast").css('display','table');
						$("#tablecur").css('display','none');
					});
				 $("#current").on('click',function(){
					 $("#tablecur").css('display','table');
						$("#tablepast").css('display','none');
				});
				//省市搜索条件回显
			 	var p = "${province}";
				var c = "${city}";
				for (var i = 1; i <= document.getElementById("province").length; i++) {
					var docProvince = document.getElementById("province").options[i];
					if( (docProvince!=null)&& (docProvince.value== p)){
						document.getElementById("province").options[i].selected = true;
						 for(var j = 1; j <= document.getElementById("city").length; j++){
							var dcoCity = document.getElementById("city").options[i];
							if(dcoCity!=null && dcoCity.value == c){
								document.getElementById("city").options[i].selected = true;
								break;
							}
						}
					break;
					}
				} 
			});
			
		</script>
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>个人中心</span>
			</div>
		</div>
		<div class="content personal">
			<div class="autstate">
				<span>认证状态：</span><span>材料班组</span>
			</div>
			<div class="detail">
				<jsp:include page="material_left.jsp" flush="true" />
				<div class="detailright">
					<div class="persontitle">
						<div class="filetile">申请加入项目</div>
					</div>
					<div class="derighttop">
						<form id="form" action="materialJoinProject.html" method="post">
						<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>区域：
								<select id="province" onchange="setCity(this.value);getArea();" name="province" >
                              		<option value="">请选择省份</option>
                        		</select>
								<select id="city" onchange="setCounty(this.value);getArea();" name="city" >
		                            <option value="" selected="selected">请选择城市</option>
		                        </select>
							</td>
							<td>
								<select id="select" onchange="changeInput();">
									<option value='0' selected="selected">项目名称</option>
									<option value='1'>项目负责人</option>
								</select>
								<input id="name" name="name" type="text" style="width:180px" placeholder="按项目名称模糊搜索"/>
								<input id="leaderName" name="leaderName" style="width:180px" placeholder="按项目负责人名字模糊搜索"/>
							</td>
							<td><div id="search">查询</div></td>
						</tr>
						</table>
					</form>
					</div>
					<table class="addground" border="0" cellspacing="1" cellpadding="0">
						<tr>
							<td>项目名称</td>
							<td>项目负责人</td>
							<td>所在省</td>
							<td>所在市</td>
							<td>申请</td>
						</tr>
						<c:forEach items="${requirementList}" var="requirementModel">
						<tr>
							<td>${requirementModel.name}</td>
							<td>${requirementModel.leaderName}</td>
							<td>${requirementModel.provinceStr}</td>
							<td>${requirementModel.cityStr}</td>
							<td><!-- 因为这里是位于遍历循环中，因此标记元素只能用class而不能用id，否则动态遍历之后就会出现id重复错误，用id选择器拿不到元素 -->
								<span class="joinProject">申请</span>
								<span style="display:none">${requirementModel.rId}</span><!-- 发布招聘班组的项目的id -->
								<span style="display:none">1</span> <!-- status=1 申请，在数据库中标记为 status=1（申请） -->
								<span style="display:none"></span> <!-- projectDepartment id  -->
							</td>
						</tr>
						</c:forEach>
					</table>
						<div class="tabfooter">
							<form action="materialJoinProject.html" method="post">
								<div class="footerl">
									<span>每页：</span>
									<input type="text" value="${page.pageSize}" name="pageSize" style="width:30px"/>
									<span>条</span>
									<button>确定</button>
									<span>共有</span>
									<span class="footernum">${page.dataCount}</span>
									<span>条记录，当前有</span>
									<span>${page.pageNow}</span><span>/</span><span>${page.pageCount}</span>
									<span>页</span>
									<button value="1" name="pageNow">首页</button>
									<button value="${page.prePage}" name="pageNow">上一页</button>
									<button value="${page.nextPage}" name="pageNow">下一页</button>
									<button value="${page.lastPage}" name="pageNow">尾页</button>
								</div>
							</form>
						</div>
					<div class="apply clearfix">
						<div id="past" class="active">历史申请明细</div>
						<div id="current">正在申请</div> 
						<table id="tablepast" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td>项目名称</td>
								<td>所在省</td>
								<td>所在市</td>
								<td>项目负责人</td>
								<td>申请时间</td>
							</tr>
							<c:forEach items="${mapPast}" var="mapPast">
							<tr>
								<td>${mapPast.key.name}</td>
								<td>${mapPast.key.provinceChn}</td>
								<td>${mapPast.key.cityChn}</td>
								<td>${mapPast.key.name}</td>
								<td>${mapPast.value.createTimeStr}</td>
							</tr>
							</c:forEach>
						</table>
						<table id="tablecur" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td>项目名称</td>
								<td>所在省</td>
								<td>所在市</td>
								<td>项目负责人</td>
								<td>申请时间</td>
								<td>撤回申请</td>
							</tr>
							<c:forEach items="${mapCur}" var="mapCur">
							<tr class="addground">
								<td>${mapCur.key.name}</td>
								<td>${mapCur.key.provinceChn}</td>
								<td>${mapCur.key.cityChn}</td>
								<td>${mapCur.key.leaderName}</td>
								<td>${mapCur.value.createTimeStr}</td>
								<td>
									<span class="cancelProject">撤回</span>
									<span style="display:none">${mapCur.value.pId}</span>
									<span style="display:none">4</span> <!-- status=4 撤销申请，在数据库中标记为 status=4（结束） -->
									<span style="display:none">${mapCur.value.id}</span> <!-- projectDepartment id -->
								</td>
								
							</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="../resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="../resource/js/front_equipment/idequip.js" type="text/javascript" charset="utf-8"></script>
		<script src="../resource/js/area.js" type="text/javascript" ></script>
	</body>

</html>