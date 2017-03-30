<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operateadd.css" />
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			
			<div class="detail">
				<div class="detailright">
					<form method="post" action="operate_posterMEAdd2.html">
						<input id="mePId" type="hidden" name="pId" value="${projectModel.id }"/>
						<input type="hidden" name="flag" value="${flag }"/>
						<div>
							<label>项目名称</label>
							<span>${projectModel.name }</span>
						</div>
						<div>
							<label>供应商类型</label>
							<select id="type" name="type">
								<option value="2">材料商</option>
								<option value="3">设备商</option>
							</select>
						</div>
						<div>
							<label>供应商名称</label>
							<span><input id="name" type="text" name="name" placeholder="必填"/></span>
						</div>
						<div>
							<label>供应商机构代码</label>
							<span id="posterCode"><input id="code" type="text" name="code" placeholder="必填"/></span>
						</div>
						<div>
							<label>统一社会信用代码</label>
							<span><input id="licence" type="text" name="licence" placeholder="必填"/></span>
						</div>
						<div>
							<label>供应材料/设备名称</label>
							<span><input id="shopName" type="text" name="shopName" placeholder="必填"/></span>
						</div>
						<div>
							<label>省份</label>
							<span>
								<select id="province" onchange="setCity(this.value);getArea();" name="province" runat="server">
									<option value="" selected="selected">--请选择省份--</option>
								</select>
							</span>
						</div>
						<div>
							<label>城市</label>
							<span>
								<select id="city" onchange="setCounty(this.value);getArea();" name="city" runat="server">
									<option value="" selected="selected">--请选择城市--</option>
								</select>
							</span>
						</div>
						<div>
							<label>街道</label>
							<span><input id="street" type="text" name="street" placeholder="必填"/></span>
						</div>
						<div>
							<label>联系人</label>
							<span><input id="leaderName" type="text" name="leaderName" placeholder="必填"/></span>
						</div>
						<div>
							<label>联系方式</label>
							<span id="posterUserId"><input id="userId" type="text" name="userId" placeholder="必填"/></span>
						</div>
						<input id="projectMEAddSubmit" type="submit" class="identy" value="保存" />
						<input type="reset"class="cancel" value="取消" />
					</form>
				</div>
			</div>
			
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/area.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/operate/posterMEAdd.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>