<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/operate/operatedemandadd.css" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				$(".cancel").on('click',function(){
					window.location.href="operate_schedule.html?id=${pId}";
				});
				var msg = "";
				$("#save").on('click',function(){
					if(!/^[\d]+$/.test($.trim($("#allWork").val()))||$.trim($("#allWork").val())==""){
						
						//如果进入到这个判断条件就将光标锁定在当前输入框，直到输入正确不再进入此判断条件内
						$(this).focus();
						msg = "总工程量必填！";
						$(this).siblings().eq(0).html("<b><font color='red'>*</font></b>");
					}else if(!/^[\d]+$/.test($.trim($("#thisWork").val()))||$.trim($("#thisWork").val())==""){
						
						//如果进入到这个判断条件就将光标锁定在当前输入框，直到输入正确不再进入此判断条件内
						$(this).focus();
						msg = "请填写本次工程量！";
						$(this).siblings().eq(0).html("<b><font color='red'>*</font></b>");
						
					}else if(!/^[\d]+$/.test($.trim($("#accoutWork").val()))|| $.trim($("#accoutWork").val())==""){
						
						//如果进入到这个判断条件就将光标锁定在当前输入框，直到输入正确不再进入此判断条件内
						$(this).focus();
						msg = "请填写累计工程量！";
						$(this).siblings().eq(0).html("<b><font color='red'>*</font></b>");
					}else if(!/^[\d\.]+$/.test($.trim($("#price").val())) ||$.trim($("#price").val())==""){
						
						//如果进入到这个判断条件就将光标锁定在当前输入框，直到输入正确不再进入此判断条件内
						$(this).focus();
						msg = "请填写合同价！";
						$(this).siblings().eq(0).html("<b><font color='red'>*</font></b>");
					}else if(!/^[\d]+$/.test($.trim($("#times").val())) || $.trim($("#times").val())==""){
						
						//如果进入到这个判断条件就将光标锁定在当前输入框，直到输入正确不再进入此判断条件内
						$(this).focus();
						msg = "请填写次数！";
						$(this).siblings().eq(0).html("<b><font color='red'>*</font></b>");
					}else if(!/^[\d\.]+$/.test($.trim($("#prepaid").val())) || $.trim($("#prepaid").val())==""){
						
						//如果进入到这个判断条件就将光标锁定在当前输入框，直到输入正确不再进入此判断条件内
						$(this).focus();
						msg = "请填预付款！";
						$(this).siblings().eq(0).html("<b><font color='red'>*</font></b>");
					}else if(!/^[\d\.]+$/.test($.trim($("#thisPay").val())) || $.trim($("#thisPay").val())==""){
						
						//如果进入到这个判断条件就将光标锁定在当前输入框，直到输入正确不再进入此判断条件内
						$(this).focus();
						msg = "请填写本次付款！";
						$(this).siblings().eq(0).html("<b><font color='red'>*</font></b>");
					}else if(!/^[\d\.]+$/.test($.trim($("#addupPay").val())) || $.trim($("#addupPay").val())==""){
						
						//如果进入到这个判断条件就将光标锁定在当前输入框，直到输入正确不再进入此判断条件内
						$(this).focus();
						msg = "请填写累计付款！";
						$(this).siblings().eq(0).html("<b><font color='red'>*</font></b>");
					}else if(!/^[\d\.]+$/.test($.trim($("#paid").val())) || $.trim($("#paid").val())==""){
						
						//如果进入到这个判断条件就将光标锁定在当前输入框，直到输入正确不再进入此判断条件内
						$(this).focus();
						msg = "请填写已付款！";
						$(this).siblings().eq(0).html("<b><font color='red'>*</font></b>");
					}else if(!/^[\d\.]*$/.test($.trim($("#remainPay").val()))|| $.trim($("#remainPay").val())=="" ){
						//如果进入到这个判断条件就将光标锁定在当前输入框，直到输入正确不再进入此判断条件内
						$(this).focus();
						msg = "请填写未付款！";
						$(this).siblings().eq(0).html("<b><font color='red'>*</font></b>");
					}
					//alert(!/^[\d\.]+$/.test($.trim($("#remainPay").val())));
					if(msg!=""){
						alert(msg);
						//经过一次判断以后将msg清空
						msg="";
					}else{
						$("#operateForm").submit();
					}
				});
			});
		</script>
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<div class="detail">
				<div class="detailright">
					<form id="operateForm" action="operate_addTeamSchedule.html" method="post">
						<input type="hidden" name="token" value="${token}"/>
						<div>
							<label>班组名称</label>
							<span>
								<select name="teamName">
									<c:forEach items="${teamList}" var="team">
										<option value="${team.name},${team.id}">${team.name}</option>
									</c:forEach>
								</select>
							</span>
							<!-- <label>班组类型</label>
							<span>
								<select name="type">
									<option value=0>施工班组</option>
									<option value=1>材料班组</option>
									<option value=2>设备班组</option>
								</select>
							</span> -->
							<label>合同价</label>
							<span><input type="text" id="price"  name="price"  value="" placeholder="请输入金额数字（整数）"/><span></span></span>
							<label>预付款</label>
							<span><input type="text" id="prepaid"  name="prepaid" value="" placeholder="请输入金额数字"/><span></span></span>
						</div>
						<div>
							<label>次数</label>
							<span><input type="text" id="times"  name="times" value="" placeholder="请输入数量数字"/><span></span></span>
							<label>总工程量</label>
							<span><input type="text" id="allWork"  name="allWork" value="" placeholder="请输入数量数字"/><span></span></span>
							<label>本次工程量</label>
							<span><input type="text" id="thisWork"  name="thisWork" value="" placeholder="请输入数量数字"/><span></span></span>
						</div>
						<div>
							<label>累计工程量</label>
							<span><input type="text" id="accoutWork"  name="accoutWork" value="" placeholder="请输入数量数字"/><span></span></span>
							<label>本次付款</label>
							<span><input type="text" id="thisPay"   name="thisPay" value="" placeholder="请输入金额数字"/><span></span></span>
							<label>累计付款</label>
							<span><input type="text" id="addupPay"  name="addupPay" value="" placeholder="请输入金额数字"/><span></span></span>
						</div>
						<div>
							<label>已付工资</label>
							<span><input type="text" name="paid" id="paid"  value="" placeholder="请输入金额数字"/><span></span></span>
							<label>未付工资</label>
							<span><input type="text" name="remainPay" id="remainPay"  value="" placeholder="请输入金额数字"/><span></span></span>
							<label>结算情况</label>
							<span><input type="text" name="balance" value=""/></span>
						</div>
						<div>
							<label>备注</label>
							<span><input type="text" name="desc" value=""/></span>
							<label>单位</label>
							<span><input type="text" name="unit" value=""/></span>
							<label>注意：</label>
							<span><font color="red">*所有款项均以(万元)为单位*</font></span>
						</div>
						<input type="hidden" name="pId" value="${pId}"/>
						<input type="text" id="save" class="identy" value="保存" />
						<input type="reset" class="cancel" value="取消" />
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>