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
					<form method="post" action="operate_reportTeamDetailAdd2.html">
						<input id="cmdId" type="hidden" name="cmdId" value="${cmdId }"/>
						<input id="pId" type="hidden" name="pId" value="${pId}"/>
						<input id="tId" type="hidden" name="tId" value="${tId}"/>
						<input id="teamtype" type="hidden" name="teamtype" value="${teamtype }"/>
						<input id="year" type="hidden" name="year" value="${year }"/>
						<input id="month" type="hidden" name="month" value="${month }"/>
						<div>
							<label>手机号</label>
							<span id="userIdIsExist"><input id="userId" type="text" name="userId" placeholder="必填"/></span>
						</div>
						<div>
							<label>付款人</label>
							<span><input type="text" name="drawee"/></span>
							<label>发放时间</label>
							<span><input type="text" name="payTime"/>如：2018-08-12</span>
						</div>
						<div>
							<label>支付方式</label>
							<span>
								<select name="paytype">
									<option value="1">支付宝</option>
									<option value="2">微信</option>
									<option value="3">银行卡</option>
									<option value="4">现金</option>
								</select>
							</span>
							<label>支付帐号</label>
							<span><input type="text" name="account"/></span>
						</div>
						<div>
							<label>支付凭证</label>
							<span><input type="text" name="voucher"/></span>
							<label>是否安全教育</label>
							<span><input type="text" name="safe"/></span>
						</div>
						<div>
							<label>进场时间</label>
							<span><input type="text" name="inTime"/></span>
							<label>退场时间</label>
							<span><input type="text" name="outTime"/></span>
						</div>
						<div>
							<label>出入记录</label>
							<span><input type="text" name="access"/></span>
							<label>考勤记录</label>
							<span><input type="text" name="attendance"/></span>
						</div>
						<div>
							<label>工作内容</label>
							<span><input type="text" name="workContent"/></span>
						</div>
						<div>
							<label>次数</label>
							<span><input type="text" name="count"/></span>
							
							<label>应发工资</label>
							<span><input type="text" name="salary"/></span>
						</div>
						<div>
							<label>扣款</label>
							<span><input type="text" name="deduct"/></span>
							<label>实发工资</label>
							<span><input type="text" name="realSalary"/></span>
						</div>
						<div>
							<label>未付工资</label>
							<span><input type="text" name="noSalary"/></span>
							<label>签名指纹</label>
							<span><input type="text" name="flag"/></span>
						</div>
						<div>
							<label>备注</label>
							<span><input type="text" name="note"/></span>
						</div>
						<input id="addReportTeamDetailSubmit" type="submit" class="identy" value="添加" />
						<input type="reset"class="cancel" value="取消" />
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/operate/reportTeamDetailAdd.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>