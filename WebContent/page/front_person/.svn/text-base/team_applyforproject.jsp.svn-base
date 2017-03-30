<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/teamAttendance.css" />
		<script type="text/javascript">
			function skillBigType1(){
				//获取技能小类型 动态追加
		 		$.ajax({
		 		    type : 'post',
		 		    url : 'team_getSmallSkillType.html',
		 		    dataType : 'text',
		 		    data : $('#skillBigType').serialize(),
		 		    async: true,
		 		    success : function (date) {
		 		    	var msg = eval("("+date+")");   
		 		    	$('#smalltype').empty();//先清空原来的option,再添加新的上去
		 		    	for(var i=0;i<msg.length;i++){
		 		    		if(smalltype == msg[i].skillType ){
		 			    		$('#smalltype').prepend('<option selected='+'"true"'+'value="' + msg[i].skillType + '">' + msg[i].skillName + '</option>');
		 		    		}else{
		 			    		$('#smalltype').prepend('<option value="' + msg[i].skillType + '">' + msg[i].skillName + '</option>');
		 		    		}
		 		    	};
		 		    },
		 		    error : function (xmlq, errq) {
		 		    	alert("xmlq:"+xmlq+"  errq:"+errq);
		 		    }
		 		});
			};
		</script>
	</head>
		
	<body>
		<input id="isLeader" type="hidden" value='${isLeader}'/> 
		<jsp:include page="../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>个人中心</span>
			</div>
		</div>
		<div class="content personal">
			<div class="autstate">
				<span>认证状态：</span><span>已认证 &nbsp;&nbsp;&nbsp;</span>
				<span>角色：</span><span>班组长</span>&nbsp;&nbsp;&nbsp;&nbsp;<font color="darkblue">发布求职</font>
			</div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
				<div class="detailright">
					<div class="derighttop clearfix">
						<div><a href="toApplyAdd.html"><font color="white">新增班组求职</font></a></div>
					</div>
					<div class="derightbottom">
						<table class="assess" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td>序号</td>
								<td>班组</td>
								<td>班长</td>
								<td>求职标题</td>
								<td>技能类型</td>
								<td>诚信星级</td>
								<td>联系方式</td>
								<td>求职地址</td>
								<td>备注</td>
								<td>撤销</td>
							</tr>
							<c:forEach items="${requirementList}" var="requirement" varStatus="status">
								<tr>
									<td>${ status.index + 1}</td>
									<td>${teamModel.name}</td>
									<td>${teamModel.leaderName}</td>
									<td>${requirement.title}</td>
									<td>${requirement.skillBigTypeName}-${requirement.skillSmallTypeName}</td>
									<td>
										<c:forEach begin="1" end="${teamModel.reliableStar}">
											<span><img src="resource/images/u662.png" /></span> 
										</c:forEach>
										<c:forEach begin="${teamModel.reliableStar}" end="4">
											<span><img src="resource/images/u663.fw.png" /></span> 
										</c:forEach>
									</td>
									<td>${teamModel.leaderMobile}</td>
									<td>${requirement.provinceStr}${requirement.cityStr}</td>
									<td>${requirement.desc}</td>
									<td><div class="delete"><a href="deleteApplyNote.html?id=${requirement.id}" ><font color="white">撤销</font></a></div></td> 
								</tr>
							</c:forEach>
						</table>
					</div>
						<div class="tabfooter">
						<form action="teamApplyForProject.html" method="post">
							<div class="footerl">
								<span>每页：</span>
								<input type="text" value="${page.pageSize}" name="pageSize" style="width:30px"/>
								<span>条</span>
								<button>确定</button>
								<span>共有</span>
								<span class="footernum">${page.dataCount}</span>
								<span>条记录，当前有</span>
								<span>${page.pageNow}</span><span>/</span><span>${page.pageCount}</span>
								<span>页</span>
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
		<script type="text/javascript" src="resource/js/team_add.js" charset="utf-8"></script>
		<script type="text/javascript" src="resource/js/area.js" ></script>
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>