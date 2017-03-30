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
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/personGroup.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/group.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/tabfooter.css" />
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				var userList = '${userList}';
				console.log(userList);
				//console.log("userId:"+userId);
				$(".invite").on('click',function(){
					var index = $(this).parent().index();
					var userid=$(this).parent().siblings().eq(index-3).html();
					console.log(userid);
					$.ajax({
							type: "GET",
							url : "invite.html",
							data : {userId : userid},
							dataType : 'text',
							async: true,
							success : function(msg){
								alert(msg);
								location.reload(true);
							},
							error:function(){
								alert("数据加载失败！");
							}
					});
				});
				
			});
			function search(){
				$('#formtable').submit();
				$('#formtable').ser
			}	
			
			$("select [name='reliableStar']").on("change",function showOptionSelected(){
				alert($(this).children().attr("selected",true));
			});
		
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
				<span>角色：</span><span>班组长</span>&nbsp;&nbsp;<font color="darkblue">您的位置     :   个人中心>班组及成员>邀请工人</font>
			</div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
				<div class="detailright">
					<div class="groupform">邀请工人：</div>
					<form id="formtable" action="invitePerson.html" >
					<table class="mensearch" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>地区省份</td>
							<td>
								<select name="userProvince" id="province" onchange="setCity(this.value);getArea();" runat="server">
			                        <option value="000000"></option>
			                   	</select>
							</td>
							<td>手机号码</td>
							<td><input name="userId"  type="text" /></td>
							<%-- <td>
								<td>诚信度</td>
								<select name="reliableStar" value="${user.reliableStar}"  >
									<option value=0>-星级值-</option>
									<option value=1>1星</option>
									<option value=2>2星</option>
									<option value=3>3星</option>
									<option value=4>4星</option>
									<option value=5>5星</option>
								</select>
							</td> --%>
							<td><div class="search" onclick="search()">搜索 </div></td>
							<!-- <td><input type="submit" value="提交"/></td> -->
						</tr>
					</table>
					</form>
					<table  class="teammen" border="0" cellspacing="1" cellpadding="0">
						<tr>
							<th colspan="5" style="background: rgb(219, 229, 241);">可邀请的工人</th>
						</tr>
						<tr>
							<th>姓名</th>
							<th>手机号码</th>
							<th>求职地区</th>
							<th>诚信度</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${userList}"  var="user">
							<tr>
								<td>${user.userName}</td>
								<td>${user.userId}</td>
								<td>${user.userProvinceStr}</td>
								<td>
									<c:forEach begin="1" end="${user.reliableStar}">
										<span><img src='resource/images/u662.png'/></span>
									</c:forEach>
									<c:forEach begin="${user.reliableStar+1}" end="5">
										<span><img src='resource/images/u663.fw.png'/></span>
									</c:forEach>
								</td>
								<td>
									<div class="invite">
										<a style="color:white">邀请</a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
					
					<div class="tabfooter">
					<form action="invitePerson.html" method="post">
						<div class="footerl">
							<span>每页：</span>
							<input type="text" value="${page.pageSize}" name="pageSize" style="width:30px"/>
							<span>条</span>
							<button>确定</button>
							<span>[共有</span>
							<span class="footernum">${page.dataCount}</span>
							<span>条记录，当前有</span>
							<span>${page.pageNow}</span><span>/</span><span>${page.pageCount}</span>
							<span>页]</span>
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
		 <script type="text/javascript" src="resource/js/area.js" ></script>
	</body>

</html>