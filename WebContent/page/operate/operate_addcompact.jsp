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
					<form  action="operate_addCompact.html" method="post">
						<input type="hidden" name="pId" value="${projectModel.id}"/> 
						<input type="hidden" name="token" value="${token}"/> 
						<div>
							<label>建设单位</label>
							<span><input type="text" name="company" value=""/></span>
						</div>
						<div>
							<label>工程名称</label>
							<span><input type="text" name="projectName" readonly value="${projectModel.name}"/></span>
						</div>
						<div>
							<label>合同编号</label>
							<span><input type="text" name="compactNum" value=""/></span>
						</div>
						<div>
							<label>合同名称</label>
							<span><input type="text" name="compactName" value=""/></span>
						</div>
						<div>
							<label>合同类别</label>
							<span>
								<select name="compactType">
									<option value="">请选择</option>
									<option value="1">材料合同</option>
									<option value="2">用工合同</option>
									<option value="3">设备租赁合同</option>
									<option value="4">设备采购合同</option>
								</select>
							</span>
						</div>
						<div>
							<label>内容概述</label>
							<span><input type="text" name="compactBrief" value=""/></span>
						</div>
						<div>
							<label>供应商名称</label>
							<span><input type="text" name="supplier" value=""/></span>
						</div>
						 <div>
							<label>总金额</label>
							<span><input type="text" id="amount" name="amount" value="0.0" placeholder="填写金额数字!"/></span>
						</div>
						<div>
							<label>签订日期</label>
							<span><input class="laydate-icon" id="demo" name="signDate0" value="2016-6-25"></span>
						</div>
						<div>
							<label>备注</label>
							<span><input type="text" name="remark" value=""/></span>
						</div>
						<div>
							<label>执行情况</label>
							<span><input type="text" name="excute" value=""/></span>
						</div>
						<div>
							<label>发票</label>
							<span><input type="text" name="invoice" value=""/></span>
						</div>
					<%-- <div>
							<label>附件</label>
							<span class="files"><input name="attachment" type="file" />上传</span>
						</div> --%>
						<input id="submit1" class="identy" value="保存" />
						<input type="reset" class="cancel"  value="取消" />
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
		$(".cancel").on('click',function(){
			window.location.href="operate_compact.html?id=${projectModel.id}";
		});
		
		laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
		laydate({elem:'#demo'});//绑定时间控件方法
		
		$("#submit1").on('click',function(){
			var msg = null;
			if(!/^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/.test($("#amount").val())){
				msg = "请填写正确的金额数字！"
				$("#amount").focus();
			}
			if(msg!=null){
				alert(msg);
			}else{
				$("form").submit();
			}
		});
	</script>
</html>