<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css"/>
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/index1.css" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/index.js" type="text/javascript" charset="utf-8"></script>
		
		<script type="text/javascript">
			// Session中的userId非空时，将登录和注册字样改为 userName您好！
			$(this).ready(function(){
				var userName = '${userName}';
				var userId = '${userId}';
				var userType = '${type}';
				var isLeader = '${isLeader}';
				console.log(userName);
				console.log(userId);
				console.log(userType);
				console.log(isLeader);
				
				if(userName != null && userName != ""){
					$("#login").find('a').hide();
					if(userType=="0"){//个人用户
						$("#login").html("<a class='user' href='person.html'>您好!&nbsp;"+userName+"</a><div class='logout clearfix' id='logout'><a href='user_message1.html'>消息</a><a href='logout.html'>注销</a></div>"); 
					}else if(userType=="1"){//材料商
						$("#login").html("<a class='user' href='material/info.html'>您好!&nbsp;"+userName+"</a><div class='logout clearfix' id='logout'><a href='material/message1.html'>消息</a><a href='logout.html'>注销</a></div>"); 
					}else if(userType=="2"){//设备商
						$("#login").html("<a class='user' href='equipment/info.html'>您好!&nbsp;"+userName+"</a><div class='logout clearfix' id='logout'><a href='equipment/message1.html'>消息</a><a href='logout.html'>注销</a></div>"); 
					}else if(userType=="3"){//公司 
						$("#login").html("<a class='user' href='person.html'>您好!&nbsp;"+userName+"</a><div class='logout clearfix' id='logout'><a href='company_message1.html'>消息</a><a href='logout.html'>注销</a></div>"); 
					}else if(userType=="4"){//项目负责人 
						$("#login").html("<a class='user' href='projectInfo.html'>您好!&nbsp;"+userName+"</a><div class='logout clearfix' id='logout'><a href='operate_message1.html'>消息</a><a href='logout.html'>注销</a></div>"); 
					} 
					//$("#logout").show();
				}
				else if(userId != null && userId !=""){
					$("#login").find('a').hide();
					if(userType=="0"){//个人用户
						$("#login").html("<a class='user' href='person.html'>您好!&nbsp;"+userId+"</a><div class='logout clearfix' id='logout'><a href='user_message1.html'>消息</a><a href='logout.html'>注销</a></div>"); 
					}else if(userType=="1"){//材料商
						$("#login").html("<a class='user' href='material/info.html'>您好!&nbsp;"+userId+"</a><div class='logout clearfix' id='logout'><a href='material/message1.html'>消息</a><a href='logout.html'>注销</a></div>"); 
					}else if(userType=="2"){//设备商
						$("#login").html("<a class='user' href='equipment/info.html'>您好!&nbsp;"+userId+"</a><div class='logout clearfix' id='logout'><a href='equipment/message1.html'>消息</a><a href='logout.html'>注销</a></div>"); 
					}else if(userType=="3"){//公司
						$("#login").html("<a class='user' href='person.html'>您好!&nbsp;"+userId+"</a><div class='logout clearfix' id='logout'><a href='company_message1.html'>消息</a><a href='logout.html'>注销</a></div>"); 
					}else if(userType=="4"){//项目负责人 
						$("#login").html("<a class='user' href='projectInfo.html'>您好!&nbsp;"+userId+"</a><div class='logout clearfix' id='logout'><a href='operate_message1.html'>消息</a><a href='logout.html'>注销</a></div>"); 
					}
					//$("#logout").show();
				}
			});
		</script>
		<script>
			$(function(){
				$('.user').on('mouseover', function() {
					$('.logout').show();
				});
				$('.logout').on('mouseleave', function() {
					$('.logout').hide();
				});
			})
		</script>
	</head>

	<body>
		<div class="content clearfix navbox">
			<div class="nav clearfix" id="nav clearfix" >
				<h1><a href="index.html"></a></h1>
				
				<form name="form1" action="web_search.html" method="post">
				<div class="searchbar" id="searchbar">
					<div class="searchsel" id="searchsel">
						
						<select name="type" style="height:30px;width:100px">
						    <option value="1" >工程信息</option>
						    <option value="2" >施工队伍</option>
						    <option value="3" >个人劳务</option>
						    
						</select>
						
					</div>
					<div class="searchcol"><input type="text" name="text"/></div>
					<button>搜索</button>
				</div>
				</form>
				<div class="login" id='login'>
					<a href="from_RegFrom.html">注册</a>
					<a href="toLogin.html">登录</a>
					<div class='logout' id='logout'>
						<!-- <a href="logout.html">注销</a>
						<a href="logout.html">公告</a>
						<a href="logout.html">退出</a> -->
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="wrap" id="wrap">
				<div class="slide content" id="slide">
					<ul>
						<li>
							<a href="person.html">
								<img src="resource/images/slide1.png" alt="" />
							</a>
							<p>个人中心</p>
						</li>
						<li>
							<a href="web_project_list.html"><img src="resource/images/slide2.png" alt="" /></a>
							<p>项目信息</p>
						</li>
						<li>
							<a href="persontoteam.html"><img src="resource/images/slide3.png" alt="" /></a>
							<p>需求信息</p>
						</li>
						<li>
							<a href="web_company_list.html"><img src="resource/images/slide4.png" alt="" /></a>
							<p>公司信息</p>
						</li>
						<li>
							<a href="web_team_list.html"><img src="resource/images/slide5.png" alt="" /></a>
							<p>班组信息</p>
						</li>
					</ul>
					<div class="arrow" id="arrow">
						<a href="javascript:;" class="prev" id="arrLeft"></a>
						<a href="javascript:;" class="next" id="arrRight"></a>
					</div>
				</div>
			</div>
			<div class="abstract content clearfix">
				<div class="abdetail clearfix">
					<div class="block">
						<div class="blocktop">
							<img src="resource/images/title_ico1.gif"/>
							<span class="blocktitle">工程信息</span>
						</div>
						<div class="blockbottom clearfix">
							<div class="blockbotr">
								<div class="bbotrt">
									<span>公司信息</span><a href="web_company_list.html">更多<img src="resource/images/more1.png" /></a>
								</div>
								<ul>
									<c:forEach items="${companys}" var="model"> 
										<li><a href="web_company_info.html?id=${model.id}">${model.name}</a><span>${model.createTimeMD}</span></li>
									</c:forEach>
								</ul>
							</div>
							<div class="blockbotl">
								<div class="bbotlt">
									<span>项目信息</span><a href="web_project_list.html">更多<img src="resource/images/more1.png" /></a>
								</div>
								<ul>
									<c:forEach items="${projects}" var="model"> 
										<li><a href="web_project_info.html?id=${model.id}">${model.name}</a><span>${model.createTimeMD}</span></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
					<div class="block">
						<div class="blocktop">
							<img src="resource/images/title_ico5.gif"/>
							<span class="blocktitle">招聘信息</span>
						</div>
						<div class="blockbottom clearfix">
							<div class="blockbotr">
								<div class="bbotrt">
									<span>班组招聘个人</span><a href="persontoteam.html">更多<img src="resource/images/more1.png" /></a>
								</div>
								<ul>
									<c:forEach items="${t2ulist}" var="model"> 
										<li><a href="recruit_person.html?tId=${model.rId}&id=${model.id}">${model.title}</a><span>${model.createTimeMD}</span></li>
									</c:forEach>
								</ul>
							</div>
							<div class="blockbotl">
								<div class="bbotlt">
									<span>项目招聘班组</span><a href="teamtoproject.html?teamType=1">更多<img src="resource/images/more1.png" /></a>
								</div>
								<ul>
									<c:forEach items="${p2tlist}" var="model">
										<li><a href="recruit_team.html?pId=${model.rId}&id=${model.id}">${model.title}</a><span>${model.createTimeMD}</span></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
					<div class="block">
						<div class="blocktop">
							<img src="resource/images/title_ico4.gif"/>
							<span class="blocktitle">求职信息</span>
						</div>
						<div class="blockbottom clearfix">
							<div class="blockbotr">
								<div class="bbotrt">
									<span>个人求职</span><a href="teamtoperson.html">更多<img src="resource/images/more1.png" /></a>
								</div>
								<ul>
									<c:forEach items="${u2tlist}" var="model">
										<li><a href="job_person.html?userId=${model.rId}&id=${model.id}">${model.name}</a><span>${model.createTimeMD}</span></li>
									</c:forEach>
								</ul>
							</div>
							<div class="blockbotl">
								<div class="bbotlt">
									<span>班组求职</span><a href="projecttoteam.html">更多<img src="resource/images/more1.png" /></a>
								</div>
								<ul>
									<c:forEach items="${t2plist}" var="model">
										<li><a href="job_team.html?tId=${model.rId}&id=${model.id}">${model.title}</a><span>${model.createTimeMD}</span></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
					<div class="block">
						<div class="blocktop">
							<img src="resource/images/title_ico3.gif"/>
							<span class="blocktitle">采购与租赁信息</span>
						</div>
						<div class="blockbottom clearfix">
							<div class="blockbotr">
								<div class="bbotrt">
									<span>项目采购材料</span><a href="teamtoproject.html?teamType=2">更多<img src="resource/images/more1.png" /></a>
								</div>
								<ul>
									<c:forEach items="${p2mlist}" var="model">
										<li><a href="recruit_material.html?pId=${model.rId}&id=${model.id}">${model.title}</a><span>${model.createTimeMD}</span></li>
									</c:forEach>
								</ul>
							</div>
							<div class="blockbotl">
								<div class="bbotlt">
									<span>项目求租设备</span><a href="teamtoproject.html?teamType=3">更多<img src="resource/images/more1.png" /></a>
								</div>
								<ul>
									<c:forEach items="${p2elist}" var="model">
										<li><a href="recruit_equip.html?pId=${model.rId}&id=${model.id}">${model.title}</a><span>${model.createTimeMD}</span></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
					<div class="block">
						<div class="blocktop">
							<img src="resource/images/title_ico2.gif"/>
							<span class="blocktitle">工程信息</span>
						</div>
						<div class="blockbottom clearfix">
							<div class="blockbotr">
								<div class="bbotrt">
									<span>材料商供应信息</span><a href="projecttomaterial.html">更多<img src="resource/images/more1.png" /></a>
								</div>
								<ul>
									<c:forEach items="${m2plist}" var="model">
										<li><a href="job_material.html?mId=${model.rId}&id=${model.id}">${model.materialModel.name}</a><span>${model.createTimeMD}</span></li>
									</c:forEach>
								</ul>
							</div>
							<div class="blockbotl">
								<div class="bbotlt">
									<span>设备商供应信息</span><a href="projecttoequipment.html">更多<img src="resource/images/more1.png" /></a>
								</div>
								<ul>
									<c:forEach items="${e2plist}" var="model">
										<li><a href="job_equip.html?eId=${model.rId}&id=${model.id}">${model.equipmentModel.name}</a><span>${model.createTimeMD}</span></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	<jsp:include page="down.jsp" flush="true" />
		
	</body>

</html>


