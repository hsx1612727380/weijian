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
					<form action="operate_reportMEAdd2.html" method="post">
						<input id="projectId" type="hidden" name="projectId" value="${projectId }"/>
						<input type="hidden" name="teamtype" value="${teamtype }"/>
						<input id="type" type="hidden" name="type" value="${type }"/>
						<div>
							<label>班组编号<span style="color: red;">*</span></label>
							<span id="mEAndSummRepCHeck"><input id="mECode" type="text" name="mECode" placeholder="必填"/></span>
						</div>
						<div>
							<label>年<span style="color: red;">*</span></label>
							<span>
								<select name="year" id="year">
									<option value="请选择年份">==请选择年份==</option>
									<option value="2016">2016</option>
									<option value="2017">2017</option>
									<option value="2018">2018</option>
									<option value="2019">2019</option>
									<option value="2020">2020</option>
									<option value="2021">2021</option>
									<option value="2022">2022</option>
									<option value="2023">2023</option>
									<option value="2024">2024</option>
									<option value="2025">2025</option>
									<option value="2026">2026</option>
									<option value="2027">2027</option>
									<option value="2028">2028</option>
									<option value="2029">2029</option>
									<option value="2030">2030</option>
								</select>
							</span>
							<label>月<span style="color: red;">*</span></label>
							<span id="existCmdSumm">
								<select name="month" id="month">
									<option value="请选择月份">==请选择月份==</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
								</select>
							</span>
						</div>
						<div>
							<label>预付款(万)</label>
							<span><input type="text" name="bgpayment"/></span>
							<label>合同价(万)</label>
							<span><input type="text" name="contractPrice"/></span>
						</div>
						<div>
							<label>委托/经办人</label>
							<span><input type="text" name="principal"/></span>
							<label>支付帐号及凭证</label>
							<span><input type="text" name="account"/></span>
						</div>
						<div>
							<label>单位</label>
							<span><input type="text" name="unit"/></span>
							<label>次数</label>
							<span><input type="text" name="frequency"/></span>
						</div>
						<div>
							<label>本次工程量</label>
							<span><input type="text" name="nowTotal"/></span>
							<label>总工程量</label>
							<span><input type="text" name="total"/></span>
						</div>
						<div>
							<label>累计付款百分比%</label>
							<span><input type="text" name="culPercentage"/></span>
							<label>累计完成%</label>
							<span><input type="text" name="percentage"/></span>
						</div>
						<div>
							<label>本次付款</label>
							<span><input type="text" name="thispay"/></span>
							<label>累计付款</label>
							<span><input type="text" name="culapay"/></span>
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
							<label>其他款</label>
							<span><input type="text" name="otherpay"/></span>
							<label>余款</label>
							<span><input type="text" name="restpay"/></span>
						</div>
						<div>
							<label>余额</label>
							<span><input type="text" name="remain"/></span>
							<label>押金</label>
							<span><input type="text" name="deposit"/></span>
						</div>
						<div>
							<label>结算情况</label>
							<span><input type="text" name="settlement"/></span>
							<label>发票情况</label>
							<span><input type="text" name="invoice"/></span>
						</div>
						<div>
							<label>备注</label>
							<span><input type="text" name="note"/></span>
						</div>
						<input id="addReportMESubmit" type="submit" class="identy" value="添加" />
						<input type="reset"class="cancel" value="取消" />
					</form>
				</div>
			</div>
		</div>
		<br>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/operate/reportMEAdd.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>