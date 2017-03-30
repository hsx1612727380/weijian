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
					window.location.href="operate_schedule.html?id=${projectProgress.pId}";
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
					<form action="operate_updateProjectProgress.html" method="post">
						<div>
							<label>单位工程</label>
							<span><input type="text" name="unit" value="${projectProgress.unit}"/></span>
							<label>单位</label>
							<span><input type="text" name="unitPer" value="${projectProgress.unitPer}"/></span>
							<label>总工程量</label>
							<span><input type="text" name="allWork" value="${projectProgress.allWork}"/></span>
						</div>
						<div>
							<label>本周完成</label>
							<span><input type="text" name="thisWeek" value="${projectProgress.thisWeek}"/></span>
							<label>下期计划</label>
							<span><input type="text" name="plan" value="${projectProgress.plan}"/></span>
							<span><input type="text" name="accoutWork" value="${projectProgress.accoutWork}"/></span>
							<label>累计完成</label>
						</div>
						<div>
							<label>备注</label>
							<span><input type="text" name="desc" value="${projectProgress.desc}"/></span>
						</div>
						<input type="hidden" name="progress" value="${projectProgress.progress}"/>
						<input type="hidden" name="id" value="${projectProgress.id}"/>
						<input type="hidden" name="pId" value="${projectProgress.pId}"/>
						<div>
						</div>
						<input type="submit" class="identy" value="保存" />
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