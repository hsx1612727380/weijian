<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/messageinfo.css"/>
		
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>个人中心</span>
			</div>
		</div>
		<div class="content personal">
			<ul class="info_l">
				<li>消息中心</li>
				<li>
					<div data-index="${flag }">
						收件箱
						<div>
							<a href="material_message.html?isRead=1">已读<c:if test="${readMessageCount > 0 }">(${readMessageCount })</c:if></a>
							<a href="material_message.html?isRead=0">未读<c:if test="${unReadMessageCount > 0 }">(${unReadMessageCount })</c:if></a>
						</div>
					</div>
				</li>
				<li>
					<div data-index="${flag }">
						公告
						<div>
							<a href="material_notice.html?isRead=1">已读<c:if test="${readNoticeCount > 0 }">(${readNoticeCount })</c:if></a>
							<a href="material_notice.html?isRead=0">未读<c:if test="${unReadNoticeCount > 0 }">(${unReadNoticeCount })</c:if></a>
						</div>
					</div>
				</li>
			</ul>
			<input type="hidden" name="unReadNoticeCount" value="${unReadNoticeCount }"/>
			<ul class="info_r">
				<c:if test="${isRead == '0' }">
					<c:if test="${unReadMessageCount > 0 }">
						<li  class="info_title"><div>未读<span>（共${unReadMessageCount }条）</span></div></li>
						<c:forEach items="${unReadMessageModels }" var="unReadMessageModel">
							<li>
								<h4>${unReadMessageModel.sendUserName }</h4>
								<p class="info_detail">${unReadMessageModel.messageTitle }</p>
								<p class="info_mess">${unReadMessageModel.createTimeStr }
									<a href="materialInvite.html" class="mess_notice">
										<input type="hidden" value="${unReadMessageModel.id }"/>
										查看
									</a>
								</p>
							</li>
						</c:forEach>
						<div class="tabfooter">
							<form action="operate_notice.html?isRead=0&id=${projectModel.id }&userId=${projectModel.userId }" method="post">
								<div class="footerl">
									<c:if test="${page.pageNow == 1}">[首页]&nbsp;&nbsp;&nbsp;&nbsp;[上一页]&nbsp;</c:if>
									<c:if test="${page.pageNow != 1}">
										<button value="1" name="pageNowFirst" style="color: blue;">[首页]</button>
										<button value="${page.prePage}" name="pageNowPre" style="color: blue;">[上一页]</button>
									</c:if>&nbsp;&nbsp;
									<span>当前有</span><span>${page.pageNow}</span>/<span class="footernum">${pageCount}</span><span>页</span>&nbsp;&nbsp;&nbsp;&nbsp;
									<c:if test="${page.pageNow == page.lastPage}">&nbsp;[下一页]&nbsp;&nbsp;&nbsp;&nbsp;[尾页]</c:if>
									<c:if test="${page.pageNow != page.lastPage}">
										<button value="${page.nextPage}" name="pageNowNext" style="color: blue;">[下一页]</button>
										<button value="${page.lastPage}" name="pageNowLast" style="color: blue;">[尾页]</button>
									</c:if>
								</div>
							</form>
						</div>
					</c:if>
					<c:if test="${unReadMessageCount <= 0 }">
						<li  class="info_title"><div>未读消息无</div></li>
					</c:if>
				</c:if>
				<c:if test="${isRead == '1' }">
					<c:if test="${readMessageCount > 0 }">
					<li class="info_title"><div>已读<span>（共${readMessageCount }条）</span></div></li>
					<c:forEach items="${readMessageModels }" var="readMessageModel">
					<li>
						<h4>${readMessageModel.sendUserName }</h4>
						<p class="info_detail">${readMessageModel.messageTitle }</p>
						<p class="info_mess">${readMessageModel.createTimeStr }
							<a href="materialInvite.html" class="mess_notice">
								<input type="hidden" value="${readMessageModel.id }"/>
								查看
							</a>
						</p>
						</li>
					</c:forEach>
					<div class="tabfooter">
						<form action="operate_notice.html?isRead=1&id=${projectModel.id }&userId=${projectModel.userId }" method="post">
							<div class="footerl">
								<c:if test="${page.pageNow == 1}">[首页]&nbsp;&nbsp;&nbsp;&nbsp;[上一页]&nbsp;</c:if>
								<c:if test="${page.pageNow != 1}">
									<button value="1" name="pageNowFirst" style="color: blue;">[首页]</button>
									<button value="${page.prePage}" name="pageNowPre" style="color: blue;">[上一页]</button>
								</c:if>&nbsp;&nbsp;
								<span>当前有</span><span>${page.pageNow}</span>/<span class="footernum">${pageCount}</span><span>页</span>&nbsp;&nbsp;&nbsp;&nbsp;
								<c:if test="${page.pageNow == page.lastPage}">&nbsp;[下一页]&nbsp;&nbsp;&nbsp;&nbsp;[尾页]</c:if>
								<c:if test="${page.pageNow != page.lastPage}">
									<button value="${page.nextPage}" name="pageNowNext" style="color: blue;">[下一页]</button>
									<button value="${page.lastPage}" name="pageNowLast" style="color: blue;">[尾页]</button>
								</c:if>
							</div>
						</form>
					</div>
				</c:if>
				<c:if test="${readMessageCount <= 0 }">
					<li class="info_title"><div>已读消息无</div></li>
				</c:if>
				</c:if>
			</ul>

		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		$('.info_l>li>div').eq(0).on('click',function(){
			var storge=window.localStorage;
			var flag1=+storge.getItem('flag1')||0;
			flag1= flag1? '0':'1';
			storge.setItem('flag1',flag1);
		})
		var flag1=+window.localStorage.getItem('flag1');
		if(flag1){
			$('.info_l>li>div').eq(0).children('div').show();
		}
		$('.info_l>li>div').eq(1).on('click',function(){
			var storge=window.localStorage;
			var flag2=+storge.getItem('flag2')||0;
			flag2= flag2? '0':'1';
			storge.setItem('flag2',flag2);
		})
		var flag2=+window.localStorage.getItem('flag2');
		if(flag2){
			$('.info_l>li>div').eq(1).children('div').show();
		}
		$('.info_l div').on('click', function() {
			$(this).children('div').toggle();
		})
		$('.mess_notice').on('click', function() {
			var messageId = $(this).children()[0].value;
			updateMessageIsRead(messageId); 
		})

		function updateMessageIsRead(obj) {
			$.ajax({
			    type : 'post',
			    url : 'material_messageIsRead.html',
			    dataType : 'text',
			    data : {"messageId" : obj},
			    success : function (date) {
			    	alert(date);
			    },
			    error : function (xmlq, errq) {
			    	//alert("xmlq:"+xmlq+"errq:"+errq);
			    }
			});
		};
	</script>
	</body>
</html>