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
				
				$("#save").on('click',function(){
					var msg="";
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
					}
					if(msg!="" && msg!=null){
						alert(msg);
						//经过一次判断以后将msg清空
						msg="";
					}else{
						$("#progressForm").submit();
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
					<form id="progressForm" action="operate_addProjectProgress.html" method="post">
						<input type="hidden" name="token" value="${token}"/>
						<div>
							<label>单位工程</label>
							<span><input type="text" name="unit" value=""/></span>
							<label>单位</label>
							<span><input type="text" name="unitPer" value=""/></span>
							<label>总工程量</label>
							<span><input type="text" id="allWork" class="num" name="allWork" value="" placeholder="请输入数量数字"/><span></span></span>
						</div>
						<div>
							<label>本周完成</label>
							<span><input type="text" id="thisWork" class="num" name="thisWeek" value="" placeholder="请输入数量数字"/><span></span></span>
							<label>下期计划</label>
							<span><input type="text" name="plan" value=""/></span>
							<label>累计完成</label>
							<span><input type="text" id="accoutWork" class="num" name="accoutWork" value="" placeholder="请输入数量数字"/><span></span></span>
						</div>
						<div>
							<label>备注</label>
							<span><input type="text" name="desc" value=""/></span>
						</div>
						<input type="hidden" name="pId" value="${pId}"/>
						<div>
						</div>
						<input id="save" class="identy" value="保存" />
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
	<script type="text/javascript">
		$(function(){
			
		});
	</script>
</html>