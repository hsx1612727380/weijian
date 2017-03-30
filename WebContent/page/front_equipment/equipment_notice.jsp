<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/common.css" />
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
						<a href="equipment_message.html?isRead=1">已读<c:if test="${readMessageCount > 0 }">(${readMessageCount })</c:if></a>
						<a href="equipment_message.html?isRead=0">未读<c:if test="${unReadMessageCount > 0 }">(${unReadMessageCount })</c:if></a>
					</div>
				</div>
			</li>
			<li>
				<div data-index="${flag }">
					公告
					<div>
						<a href="equipment_notice.html?isRead=1">已读<c:if test="${readNoticeCount > 0 }">(${readNoticeCount })</c:if></a>
						<a href="equipment_notice.html?isRead=0">未读<c:if test="${unReadNoticeCount > 0 }">(${unReadNoticeCount })</c:if></a>
					</div>
				</div>
			</li>
		</ul>
		<ul class="info_r">
			<c:if test="${isRead == '0' }">
				<c:if test="${unReadNoticeCount > 0 }">
					<li  class="info_title"><div>未读公告消息<span>（共${unReadNoticeCount }条）</span></div></li>
					<c:forEach items="${unReadNoticeModels }" var="unReadNoticeModel">
						<li>
							<h4>系统公告</h4>
							<p class="info_detail">${unReadNoticeModel.noticeTitle }</p>
							<p class="info_mess">${unReadNoticeModel.createTimeStr }
								<a href="javascript://" class="mess_notice">
									<input type="hidden" value="${unReadNoticeModel.id }"/>
									<input type="hidden" value="${equipmentModel.id }"/>
									查看
								</a>
							</p>
						</li>
					</c:forEach>
					<div class="tabfooter">
						<form action="company_notice.html?isRead=0" method="post">
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
				<c:if test="${unReadNoticeCount <= 0 }">
					<li  class="info_title"><div>未读公告消息无</div></li>
				</c:if>
			</c:if>
			<c:if test="${isRead == '1' }">
				<c:if test="${readNoticeCount > 0 }">
				<li class="info_title"><div>已读公告消息<span>（共${readNoticeCount }条）</span></div></li>
				<c:forEach items="${readNoticeModels }" var="readNoticeModel">
				<li>
					<h4>系统公告</h4>
					<p class="info_detail">${readNoticeModel.noticeTitle }</p>
					<p class="info_mess">${readNoticeModel.createTimeStr }
						<a href="javascript://" class="mess_notice">
							<input type="hidden" value="${readNoticeModel.id }"/>
							<input type="hidden" value="${equipmentModel.id }"/>
							查看
						</a>
					</p>
					</li>
				</c:forEach>
				<div class="tabfooter">
					<form action="company_notice.html?isRead=1" method="post">
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
			<c:if test="${readNoticeCount <= 0 }">
				<li class="info_title"><div>已读公告消息无</div></li>
			</c:if>
			</c:if>
		</ul>
	</div>
		
	<jsp:include page="../down.jsp" flush="true" />
		
	<div class="mask"></div>
	<div class="notice">
		<p><span>×</span></p>
		<div class="noticeinfo">
			
		</div>
	</div>
		
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
		$('.info_r li:odd').css({ backgroundColor: '#F1F1F1' });
		$('.mess_notice').on('click', function() {
			var nId = $(this).children()[0].value;
			var eId = $(this).children()[1].value;
			getNoticeInfo(nId, eId); 
			$('.mask').show();
			$('.notice').show();
		})
		$('.notice span').on('click', function() {
			$('.mask').hide();
			$(this).parent().parent().hide();
			location.reload();
		})
		$('.info_cancel').on('click', function() {
			$('.mask').hide();
			$(this).parent().parent().hide();
		})
		$('.info_l div').on('click', function() {
			
			$(this).children('div').toggle();
		})

		
		function getNoticeInfo(obj, obj2) {
			$.ajax({
			    type : 'post',
			    url : 'equipment_noticeInfo.html',
			    dataType : 'text',
			    data : {"nId" : obj,
			    	"eId" : obj2},
			    success : function (date) {
			    	str = JSON.parse(date);
			    	var str1 = "<h3>系统公告</h3><p>"+str[0].noticeInfo+"</p>"
			    	$('.noticeinfo').html(str1);
			    },
			    error : function (xmlq, errq) {
			    	//alert("xmlq:"+xmlq+"errq:"+errq);
			    }
			});
		};
	</script>
</body>

</html>