<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_person/person_left_handler.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/idperson.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/personGroup.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/group.css"/>
		<link rel="stylesheet" type="text/css" href="resource/css/tabfooter.css" />
	</head>
	<script type="text/javascript">
		function myfunction()
		{
			var userStatus=$("#userStatus").val();
			if(userStatus==2)
			{
				alert("您已经加入了班组，暂时不能发布新的求职");
				return false;
			}
			return true;
		};
	</script>
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
				<span>认证状态：已认证</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>角色：个人</span>
				&nbsp;&nbsp;&nbsp;&nbsp;<font color="darkblue">个人求职</font>
			</div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
				<div class="detailright" >
					<div class="add" style="margin-left:0;width:95px">
						<a href="toPersonResume.html" style="color:white">
							<span  onclick="return myfunction()">新增个人求职</span>
							<input type="hidden" value="${userModel.userStatus }" id="userStatus"/>
						</a>
					</div>
					<table class="teammen" border="0" cellspacing="1" cellpadding="0">
						<tr>
							<td>序号</td>
							<td>姓名</td>
							<td>标题</td>
							<td>技能</td>
							<td>求职区域</td>
							<td>&nbsp;诚&nbsp;信&nbsp;度&nbsp;</td>
							<td>联系方式</td>
							<td>个人地址</td>
							<td>持证情况</td>
							<td>备注</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${requirementList}" var="requirement" varStatus="status">
							<tr>
								<td>${status.index+1}</td>
								<td>${requirement.name}</td>
								<td>${requirement.title}</td>
								<td>${requirement.skillBigTypeName}-${requirement.skillSmallTypeName}</td>
								<td>${requirement.provinceStr}-${requirement.cityStr}</td>
								<td>
									<c:forEach begin="1" end="${userModel.reliableStar}">
										<span><img src="resource/images/u662.png" /></span> 
									</c:forEach>
								</td>
								<td>${requirement.rId}</td>
								<td>${userModel.userProvinceStr}-${userModel.userCityStr}</td>
								<td>${userModel.credential}</td>
								<td>${requirement.desc}</td>
								
								<td>
									<div class="invite"><a href="cancelPersonResume.html?id=${requirement.id}"><font style="width:80px" color="white">撤销</font></a></div>
								</td>
							</tr>
						</c:forEach>
					</table>
					<div class="tabfooter">
						<form action="personResume.html" method="post">
							<div class="footerl">
								<span>每页：</span>
								<input type="text" value="${page.pageSize}" name="pageSize" style="width:40px"/>
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
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>