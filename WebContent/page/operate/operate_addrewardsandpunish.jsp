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
		<link rel="stylesheet" type="text/css" href="resource/css/operate/operateadd.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/operate/newoperate.css" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<div class="detail">
				<div class="detailright">
					<form action="addRewardsAndPunish.html" method="post">
						<input type="hidden" name="token" value="${token}"/>
						<input type="hidden" name="pId" value="${projectModel.id}"/>
						<select name="type" id="type"><!-- 班组/个人类型 -->
							<option value="1" <c:if test="${type==1}">selected</c:if> style="width:60px">班组</option>
							<option value="0" <c:if test="${type==0}">selected</c:if> style="width:60px">个人</option>
						</select>
						<div>
							<label>班组名称</label>
							<span>
							<select name="teamName">
								<c:forEach items="${teamList}" var="team">
									<option value="${team.name}">${team.name}</option>
								</c:forEach>
							</select>
							</span>
						</div>
						<div>
							<label>姓名</label>
							<span><input type="text" name="name" /></span>
						</div>
						<div>
							<label>联系方式</label>
							<span><input type="text" name="userId" /></span>
						</div>
						<div>
							<label>性质</label>
							<span>
								<select name="character">
									<option value="奖励">奖励</option>
									<option value="惩罚">惩罚</option>
								</select>
							</span>
						</div>
						<div>
							<label>行为</label>
							<span><input type="text" name="measure"/></span>
						</div>
						<input type="submit" class="identy" value="保存" />
						<input id="cancel" type="reset" class="cancel" value="取消" />
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_company/identerprise.js" type="text/javascript" charset="utf-8"></script>
	</body>
<script type="text/javascript">
	$(function(){
		$("#type").hide();
		$("#cancel").on('click',function(){
			window.location.href="operate_rewardsandpunish.html?id=${projectModel.id}";
		});
	});
</script>
</html>