<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="utf-8" />
	<title>乐建平台</title>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<!-- 针对不同的登录用户类型隐藏左侧菜单的js -->
	<script src="resource/js/front_person/person_left_handler.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
	<link rel="stylesheet" type="text/css" href="resource/css/front_person/personAddgroud.css" />
	<link rel="stylesheet" type="text/css" href="resource/css/tabfooter.css" />
	<link rel="stylesheet" type="text/css" href="resource/css/front_person/idperson.css" />
	<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		(function($) {
			$(function(){
				 $('.passInvite').on('click',function(){
// 					var teamMemberID=$('#teamMemberID').val();
					var proDepId=$(this).siblings('#proDepId').attr('value');
					if(!$(this).attr('demo')){
						$.ajax({
						    type : 'post',
						    url : 'passProjectInveite.html',
						    dataType : 'text',
						    data :{"proDepId": proDepId},
						    success : function (Date) {
						    	alert("您已同意加入该项目");
						    	window.location.href="inviteTeamProjectForm.html";
						    },
						    error : function (xmlq, errq) {
						    	alert("xmlq:"+xmlq);
						        alert(errq);
						    }
						});
					}
					
				})
			})
		})(jQuery)
</script>
<script type="text/javascript">
		(function($) {
			$(function(){
				 $('.rejectInvite').on('click',function(){
// 					var teamMemberID=$('#teamMemberID').val();
					var proDepId=$(this).siblings('#proDepId').attr('value');
					if(!$(this).attr('demo')){
						$.ajax({
						    type : 'post',
						    url : 'rejectProjectInvite.html',
						    dataType : 'text',
						    data :{"proDepId": proDepId},
						    success : function (Date) {
						    	alert("你已拒绝加入该项目");
						    	window.location.href="inviteTeamProjectForm.html";
						    },
						    error : function (xmlq, errq) {
						    	alert("xmlq:"+xmlq);
						        alert(errq);
						    }
						});
					}
					
				})
			})
		})(jQuery)
	</script>


</head>

<body>
	<input id="isLeader" type="hidden" value='${isLeader}' />
	<jsp:include page="../top.jsp" flush="true" />
	<div class="title">
		<div class="content">
			<span>个人中心</span>
		</div>
	</div>
	<div class="content personal">
		<div class="autstate">
				<span>认证状态：</span><span>已认证 &nbsp;&nbsp;&nbsp;</span>
				<span>角色：</span><span>班组长</span>&nbsp;&nbsp;&nbsp;&nbsp;<font color="darkblue">项目邀请列表</font>
			</div>
		<div class="detail">
			<jsp:include page="person_left.jsp" flush="true" />
			<div class="detailright">
				<table class="addground" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td>项目名称</td>
						<td>负责人名称</td>
						<td>负责人手机号</td>
						<td>项目地址</td>
						<td>操作</td>
						<input type="hidden" id="userIdVal" value="${userId }" />
					</tr>
					<c:forEach items="${tlist}" var="model">
						<tr>
							<td>${model.pModel.name}</td>
							<td>${model.pModel.leaderName}</td>
							<td>${model.pModel.userId}</td>
							<td>${model.pModel.provinceChn}${model.pModel.cityChn}${model.pModel.street}</td>
							<td><input type="hidden" value="${model.proDepId }"
								id="proDepId"> <span class="passInvite" id="passInvite">同意</span>
								<span id="rejectInvite" class="rejectInvite">拒绝</span></td>
						</tr>
					</c:forEach>
				</table>

				<div class="tabfooter">
					<form action="inviteTeamProjectForm.html" method="post">
						<div class="footerl">
							<span>每页：</span> <input type="text" value="${page.pageSize}"
								name="pageSize" style="width: 30px" /> <span>条</span>
							<button>确定</button>
							<span>共有</span> <span class="footernum">${page.dataCount}</span>
							<span>条记录，当前有</span> <span>${page.pageNow}</span><span>/</span><span>${page.pageCount}</span>
							<span>页</span>
						</div>
						<input type="hidden" name="dataCount" value="${page.dataCount}">
						<input type="hidden" name="pageCount" value="${page.pageCount}">
						<div class="footer2">
							<button value="1" name="pageNow">首页</button>
							<button value="${page.prePage}" name="pageNow">上一页</button>
							<button value="${page.nextPage}" name="pageNow">下一页</button>
							<button value="${page.lastPage}" name="pageNow">尾页</button>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
	<jsp:include page="../down.jsp" flush="true" />
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript"
		charset="utf-8"></script>
</body>

</html>