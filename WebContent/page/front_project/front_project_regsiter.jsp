<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8" />
<title>乐建平台</title>
<link rel="stylesheet" type="text/css"  href="<%=basePath%>/resource/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/front_person/idperson.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/signin.css" />
<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
		<jsp:include page="../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>项目注册</span>
			</div>
		</div>
		<div class="content personal">
			<form action="front_project_register.html" method="post">
				<div id="companytype">
					<label>区域</label>
					 省份<select id="province" onchange="setCity(this.value);getArea();" name="province"
								style="width: 128px;" runat="server">
								<option value="" selected="selected">--请选择省份--</option>
					</select>&nbsp;&nbsp;
					 地市<select id="city"
								onchange="setCounty(this.value);getArea();" name="userCity"
								style="width: 128px" runat="server">
								<option value="" selected="selected">--请选择城市--</option>
					</select>
					<span></span>
				</div>
				<div id="namediv">
					<label>项目名称</label>
					<input type="text" name="name" id="name" placeholder=""/>
					<span style="color:red">* 必填</span>
				</div>
				<div id="companytype">
					<label>公司类型</label>
					<select name="type" id="type">
						<option value="">请选择公司类型</option>
						<option value="0" >建筑公司</option>
					    <option value="1" >劳务公司</option>
					    <option value="2" >设计公司</option>
					    <option value="3" >监理公司</option>
					    <option value="4" >审图公司</option>
					    <option value="其他" >其他</option>
					</select>
					<span></span>
				</div>
					<div id="companyNamediv">
					<label>公司名称</label>
					<input type="text" name='companyName' id="companyName" placeholder=""/>
				</div>
				<div>
					<label>组织机构代码</label>
					<input type="text" name='code' id="code" placeholder="社会信用代码或营业执照号码"/>
				</div> 
				<div id="leaderNamediv">
					<label>联系人</label>
					<input type="text" name="leaderName"  id="leaderName" placeholder="必填"/>
					<span style="color:red">* 必填</span>
				</div> 	
				<div id="identitydiv">
					<label>联系人身份证</label>
					<input type="text" name="identity"  id="identity" placeholder="密码为身份证后六位"/>
					<span style="color:red" style="width: 96px;"  >* 必填</span>
			
				</div>
				<div id="userIdDiv">
					<label>手机号</label>
					<input type="text" name="userId" id="userId" placeholder="必填"/>
					<span style="color:red">* 必填</span>
				</div>
			
				<div class="sumbit">
					<input type="checkbox" class="checkbox"/>同意<a href="protocol.html">乐建平台注册协议</a>
					<br />
					<br />
					<input type="submit" id="submit" value="注册" disabled="disabled"/>
				</div>
				
				
			</form> 
		</div>
		<script src="<%=basePath%>/resource/js/area.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/front_project/project_reg.js" type="text/javascript" charset="utf-8"></script>
		 <jsp:include page="../down.jsp" flush="true" />
	</body>
</html>
