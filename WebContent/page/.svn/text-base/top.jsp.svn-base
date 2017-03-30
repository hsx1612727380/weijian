<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/common.css" />

		<div class="navbox content clearfix">
			<div class="nav clearfix">
				<h1><a href="<%=basePath%>index.html"></a></h1>
				<ul class="navbar">
					<li>
						<div><a href="<%=basePath%>web_company_list.html">公司信息</a></div>
						<ul>
							<li>
								<a href="<%=basePath%>web_company_list.html">公司信息</a>
							</li>
						</ul>
					</li>
					<li>
						<div><a href="<%=basePath%>web_team_list.html">班组信息</a></div>
						<ul>
							<li>
								<a href="<%=basePath%>web_team_list.html">施工班组</a>
							</li>
							<li>
								<a href="<%=basePath%>web_material_list.html">材料班组</a>
							</li>
							<li>
								<a href="<%=basePath%>web_equip_list.html">设备班组</a>
							</li>
						</ul>
					</li>
					<li>
						<div><a href="<%=basePath%>web_project_list.html">项目信息</a></div>
						<ul>
							<li>
								<a href="<%=basePath%>web_project_list.html">项目信息</a>
							</li>
						</ul>
					</li>
					<li>
						<div>需求信息</div>
						<ul>
							<li>
								<a href="<%=basePath%>persontoteam.html">个人招聘</a>
							</li>
							<li>
								<a href="<%=basePath%>teamtoproject.html?teamType=1">班组招聘</a>
							</li>
							<li>
								<a href="<%=basePath%>teamtoproject.html?teamType=2">材料采购</a>
							</li>
							<li>
								<a href="<%=basePath%>teamtoproject.html?teamType=3">设备租赁</a>
							</li>
						</ul>
					</li>
					<li>
						<div>供应信息</div>
						<ul>
							<li>
								<a href="<%=basePath%>teamtoperson.html">个人求职</a>
							</li>
							<li>
								<a href="<%=basePath%>projecttoteam.html">班组求职</a>
							</li>
							<li>
								<a href="<%=basePath%>projecttomaterial.html">材料供应</a>
							</li>
							<li>
								<a href="<%=basePath%>projecttoequipment.html">设备供应</a>
							</li>
						</ul>
					</li>
					<li>
						<div>招投标</div>
						<ul>
							<li>
								<a href="<%=basePath%>tender_list.html">招标信息</a>
							</li>
							<li>
								<a href="<%=basePath%>industry_list.html">行业动态</a>
							</li>
						</ul>
					</li>
					<li>
						<div>法律保险</div>
						<ul>
							<li>
								<a href="<%=basePath%>web_insurance.html">金融保险</a>
							</li>
							<li>
								<a href="<%=basePath%>web_lawer.html">法律咨询</a>
							</li>
						</ul>
					</li>
					<li>
					    <% 
					    String userName = (String)request.getSession().getAttribute("userName"); 
					    String userId = (String)request.getSession().getAttribute("userId");
					    String userType = (String)request.getSession().getAttribute("type");
					    String count = (String) request.getSession().getAttribute("count");
					     if((userName == null || userName == "") && (userId == null || userId == "")){
					    %>
					    <!-- 未登录 -->
						<div class="log">
						<span><a href="<%=basePath%>toLogin.html">登陆</a></span><span><a href="<%=basePath%>from_RegFrom.html">注册</a></span>
						</div>
						<%}else{ %>
						<!-- 已登录 -->
						    <%
						    System.out.println("top页面打印的userType："+userType);
							if ("1".equals(userType)) {%>
								<div class="percenter">
									<a href='<%=basePath%>material/info.html'>个人中心</a><a class='count' href='<%=basePath%>material/message1.html'>(${count })</a>
								</div>
							<%}else if ("2".equals(userType)){ %>
								<div class="percenter">
									<a href='<%=basePath%>equipment/info.html'>个人中心</a><a class='count' href='<%=basePath%>equipment/message1.html'>(${count })</a>
								</div>
								
							<%} else if ("0".equals(userType)){ %> 
								<div class="percenter">
									<a href='<%=basePath%>person.html'>个人中心</a><a class='count' href='<%=basePath%>user_message1.html'>(${count })</a>
								</div>
							<%} else if ("3".equals(userType)) {%>
								<div class="percenter">
									<a href='<%=basePath%>person.html'>个人中心</a><a class='count' href='<%=basePath%>company_message1.html'>(${count })</a>
								</div>
							<% } else if ("4".equals(userType)) { %>
								<div class="percenter">
									<a href='<%=basePath%>person.html'>个人中心</a><a class='count' href='<%=basePath%>operate_message1.html'>(${count })</a>
								</div>
							<% } %>
						<div class='logout' id='logout'><a href="<%=basePath%>logout.html">注销</a></div>
						<%} %>
					</li>
				</ul>
			</div>
		</div>
<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>


