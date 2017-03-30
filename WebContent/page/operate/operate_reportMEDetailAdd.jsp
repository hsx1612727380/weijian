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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operatedemand.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/operate/operatecostadd.css" />
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			<div class="detail">
				<div class="detailright">
					<form method="post" action="operate_reportMEDetailAdd2.html">
						<input id="cmdId" type="hidden" name="cmdId" value="${cmdId }"/>
						<input id="pId" type="hidden" name="pId" value="${pId}"/>
						<input id="tId" type="hidden" name="tId" value="${tId}"/>
						<input id="teamtype" type="hidden" name="teamtype" value="${teamtype }"/>
						<input id="type" type="hidden" name="type" value="${type }"/>
						<input id="year" type="hidden" name="year" value="${year }"/>
						<input id="month" type="hidden" name="month" value="${month }"/>
						<div>
							<label>供应商</label>
							<c:if test="${type == '2' }">
								<span><input type="text" name="tName" value="${materialModel.name }" disabled="true"/></span>
							</c:if>
							<c:if test="${type == '3' }">
								<span><input type="text" name="tName" value="${equipmentModel.name }" disabled="true"/></span>
							</c:if>
							<label>委托/经办人</label>
							<span><input type="text" name="principal"/></span>
						</div>
						<div>
							<label>名称/规格/型号</label>
							<span><input  type="text" name="cName"/></span>
							<label>支付帐号及凭证</label>
							<span><input type="text" name="account"/></span>
						</div>
						<div>
							<label>单位</label>
							<span><input  type="text" name="unit"/></span>
							<label>次数</label>
							<span><input type="text" name="frequency"/></span>
						</div>
						<div>
							<label>预算量</label>
							<span><input type="text" name="budget"/></span>
							<label>数量</label>
							<span><input type="text" name="num"/></span>
						</div>
						<div>
							<label>单价</label>
							<span><input type="text" name="price"/></span>
							<label>小计</label>
							<span><input type="text" name="subtotal"/></span>
						</div>
						<div>
							<label>本次入库量</label>
							<span><input type="text" name="receipt"/></span>
							<label>累计入库量</label>
							<span><input type="text" name="cumulative"/></span>
						</div>
						<div>
							<label>本次付款</label>
							<span><input type="text" name="thispay"/></span>
							<label>累计付款</label>
							<span><input type="text" name="culapay"/></span>
						</div>
						<div>
							<label>其他款</label>
							<span><input type="text" name="otherpay"/></span>
							<label>余款</label>
							<span><input type="text" name="restpay"/></span>
						</div>
						<div>
							<label>预付款</label>
							<span><input type="text" name="bgpayment"/></span>
							<label>资料情况</label>
							<span><input type="text" name="information"/></span>
						</div>
						<div>
							<label>发票情况</label>
							<span><input type="text" name="invoice"/></span>
							<label>结算情况</label>
							<span><input type="text" name="settlement"/></span>
						</div>
						<div>
							<label>用途</label>
							<span><input type="text" name="using"/></span>
							<label>质量</label>
							<span><input type="text" name="quality"/></span>
						</div>
						<div>
							<label>备注</label>
							<span><input type="text" name="note"/></span>
						</div>
						<input type="submit" class="identy" value="添加" />
						<input type="reset"class="cancel" value="取消" />
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/operate/reportMaterialDetailAdd.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>