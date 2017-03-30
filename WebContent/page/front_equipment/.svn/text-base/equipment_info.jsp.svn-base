<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8" />
<title>乐建平台</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/normalize.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/front_equipment/idequip.css" />
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
			<span>认证状态：</span><span>设备商</span>
		</div>
		<div class="detail">
			<jsp:include page="equipment_left.jsp" flush="true" />
			<div class="detailright">
				<form action="updateInfo.html" method="post">
					<input name="id" type="hidden" value="${equipmentModel.id}">
					<input name="code" type="hidden" value="${equipmentModel.code}">
					<div>
						<label>供应商名称</label> <input name="name" type="text"  value="${equipmentModel.name}" placeholder="必填">
					</div>
					<div>
						<label>设备</label> <input name="shopName" type="text"  value="${equipmentModel.shopName}" placeholder="必填">
					</div>
					<div>
						<label>统一社会信用代码</label> <input name="licence" type="text" value="${equipmentModel.licence}" placeholder="填写这项可以提高可信度哦！" />
					</div>
					<%-- <div>
						<label>成立日期</label>
						<input type="text" name="establishDate" value="${equipmentModel.establishDate}" placeholder="格式示例：20160802"/>
					</div> --%>
					<div>
						<label>成立日期</label>
						<input name="establishDate" type="text" class="laydate-icon" id="demo" value="${equipmentModel.establishDate}" />
					</div>
					 <div>
						<label>注册资金（万）</label> <input name="regcapital" type="text" value="${equipmentModel.regcapital}"  placeholder="注册资金以万元计"/>
					</div>
					<div>
						<label>注册地址</label>
						<select id="province" onchange="setCity(this.value);getArea();" name="province" >
                              <option value="${equipmentModel.province}">--请选择省份--</option>
                        </select>
                    </div>
					<div>
                        <label>城市</label> 
                        <select id="city" onchange="setCounty(this.value);getArea();" name="city" >
                              <option value="${equipmentModel.city}" selected="selected">--请选择城市--</option>
                        </select>
                    </div>
					<div>
                        <label>街道</label>
                        <input name=street type="text" value="${equipmentModel.street}"  placeholder="具体街道地址"/>
					</div> 
					<div>
						<label>联系人</label> <input name="leaderName" type="text" value="${equipmentModel.leaderName}"  />
					</div>
					<div>
						<label>电话</label><input name="userId" readonly value="${equipmentModel.userId}" />
					</div>
					<div>
						<label>诚信度</label> 
						<input type="hidden" name="reliableStar" value="${equipmentModel.score}"/>
						<c:forEach  begin="1" end="${equipmentModel.reliableStar}" >
							<span>
								<img src="<%=basePath%>/resource/images/u662.png" />
							</span>
						</c:forEach>
						<c:forEach begin="${equipmentModel.reliableStar+1}" end="5" >
							<span>
								<img src="<%=basePath%>/resource/images/u663.fw.png" />
							</span>
						</c:forEach>
					</div>
					<input type="submit" class="identy" value="更新" />
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../down.jsp" flush="true" />
	<script src="<%=basePath%>resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>resource/js/area.js" type="text/javascript" ></script>
	<script src="<%=basePath%>resource/js/front_equipment/idequip.js"	type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>resource/js/laydate.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
		laydate({elem:'#demo'});//绑定时间控件方法	
	</script>
</body>
</html>