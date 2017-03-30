<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
			<div class="detail">
				<div class="detailright">
					<form action="operate_updateCompact.html" method="post">
						<input type="hidden" name="token" value="${token}"/> 
						<input type="hidden" name="id" value="${compact.id}"/> 
						<input type="hidden" name="pId" value="${compact.pId}"/> 
						<div>
							<label>建设单位</label>
							<span><input type="text" name="company" value="${compact.company}"/></span>
						</div>
						<div>
							<label>工程名称</label>
							<span><input type="text" name="projectName" readonly value="${compact.projectName}"/></span>
						</div>
						<div>
							<label>合同编号</label>
							<span><input type="text" name="compactNum" value="${compact.compactNum}"/></span>
						</div>
						<div>
							<label>合同名称</label>
							<span><input type="text" name="compactName" value="${compact.compactName}"/></span>
						</div>
						<div>
							<label>合同类别</label>
							<span>
								<select name="compactType">
									<option value="">请选择</option>
									<option value="1" <c:if test="${compact.compactType==1}">selected</c:if>>材料合同</option>
									<option value="2" <c:if test="${compact.compactType==2}">selected</c:if>>用工合同</option>
									<option value="3" <c:if test="${compact.compactType==3}">selected</c:if>>设备租赁合同</option>
									<option value="4" <c:if test="${compact.compactType==4}">selected</c:if>>设备采购合同</option>
								</select>
							</span>
						</div>
						<div>
							<label>内容概述</label>
							<span><input type="text" name="compactBrief" value="${compact.compactBrief}"/></span>
						</div>
						<div>
							<label>供应商名称</label>
							<span><input type="text" name="supplier" value="${compact.supplier}"/></span>
						</div>
						<div>
							<label>总金额</label>
							<span><input type="text" name="amount" value="${compact.amount}"/></span>
						</div>
						<div>
							<label>签订日期</label>
							<span id="old">上次录入时间:
								<fmt:formatDate value="${compact.signDate}" type="date" pattern="yyyy-MM-dd"/>
								<input type="button" value="修改" onclick="newFunction()" style="width:60px"/>
							</span>
							<span id="new">
								<input class="laydate-icon" id="demo" name="signDate0" >
							</span>
						</div>
						<div>
							<label>备注</label>
							<span><input type="text" name="remark" value="${compact.remark}"/></span>
						</div>
						<div>
							<label>执行情况</label>
							<span><input type="text" name="excute" value="${compact.excute}"/></span>
						</div>
						<div>
							<label>发票</label>
							<span><input type="text" name="invoice" value="${compact.invoice}"/></span>
						</div>
						<div class="hide">
							<label>附件</label>
							<span><input type="text" name="attachment" value="${compact.attachment}"/></span>
						</div>
						<input type="submit" class="identy" value="更新" />
						<input type="button" class="cancel" id="cancel" value="取消" />
					</form>
				</div>
			</div>
			
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/laydate.js" type="text/javascript" charset="utf-8"></script>
	</body>
	<script type="text/javascript">
		$("#cancel").on('click',function(){
			window.location.href="operate_compact.html?id=${pId}";
		});
		$(".hide").hide();
		$("#new").hide();
		function newFunction(){
			$("#old").hide();
			$("#new").show();
		}
		
		laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
		laydate({elem:'#demo'});//绑定时间控件方法
		
	</script>
</html>