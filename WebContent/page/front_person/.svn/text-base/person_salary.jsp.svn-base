<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_person/person_left_handler.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/front_person/personAttendance.css" />
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			function submitForm() {
				var inTime = document.getElementById('inTime').value;
				var outTime = document.getElementById('outTime').value;
				if((inTime!="" && inTime !=null)||(outTime!="" && outTime !=null)){
					if(/^\d{8}$/g.test(inTime)==false ) {
						alert('开始时间输入错误,请重新输入(8位日期数字,如:20160201)');
						return false;
					}
					if(/^\d{8}$/g.test(outTime)==false) {
						alert('结束时间输入错误,请重新输入(8位日期数字,如:20160201)');
						return false;
					}
					if(parseInt(outTime)<parseInt(inTime)){
						alert('开始时间不能大于结束时间');
						return false;
					}
					if(parseInt(outTime)>parseInt(inTime) + 10000){
						alert('时间间隔不能大于1年');
						return false;
					}
				}
				return document.form.submit(); //提交名字为form的表单
			}
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
				<span>角色：</span><span>班组长</span>&nbsp;&nbsp;&nbsp;&nbsp;<font color="darkblue">工资发放</font>
			</div>
			<div class="detail">
				<jsp:include page="person_left.jsp" flush="true" />
				<div class="detailright">
					<div class="derighttop clearfix">
						<form name="form" action="personSalary.html" method="post">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>项目名称</td>
								<td style="position:relative">
									<input style="width:160px" class="forsea" name=pName value="${pName}"/>
									<ul style="width:160px;position: absolute;background-color: white;margin:0;padding:0;" class="intelsearch">
									</ul>
								</td>
								<td>姓名</td>
								<td><input name="name" type="text" style="width:60px" value="${name}"/></td>
								<td>开始日期:
									<input id="inTime" name="inTime" value="${inTime}" placeholder="格式20160201" style="width:100px"/>
								</td>
								<td>结束日期:
									<input id="outTime" name="outTime" value="${outTime}" placeholder="格式20160201" style="width:100px"/>
								
									<%-- <select  name="outTime" style="width:90px" value="${outTime}">
										<option>201611</option>
									</select> --%>
								</td>
							</tr>
						</table>
						</form>
						<div onClick="submitForm()"><font color="white">搜索</font></div>
						<div onclick="printit();">打印</div> 
						<div><a href="personSalary.html?export=1" style="color:white">导出EXCEL</a></div>
					</div>
					<div class="derightbottom">
						<!--startprint-->
						<table border="0" cellspacing="1" cellpadding="0">
							<tr>
								<th colspan="10">工资发放记录</th>
							</tr>
							<tr>
								<td>项目名称</td>
								<td>姓名</td>
								<td>电话</td>
								<td>发放日期</td>
								<td>应发</td>
								<td>实发</td>
								<td>未发</td>
								<td>付款人</td>
								<td>付款方式</td>
								<td>流水号</td>
							</tr>
							<c:forEach items="${payRoll}" var="salary"  >
								<tr>
									<td>${salary.pName}</td>
									<td>${salary.name}</td>
									<td>${salary.userId}</td>
									<%-- <td>${salary.inTime}</td>
									<td>${salary.outTime}</td> --%>
									<td> <fmt:formatDate value='${salary.payTime}' type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<%-- <td>${salary.payTime}</td> --%>
									<td>${salary.salary}</td>
									<td>${salary.realSalary}</td>
									<td>${salary.noSalary}</td>
									<td>${salary.drawee}</td>
									<td>
										<c:if  test="${salary.paytype==1}"> 支付宝</c:if>
										<c:if  test="${salary.paytype==2}"> 微信</c:if>
										<c:if  test="${salary.paytype==3}"> 银行卡</c:if>
										<c:if  test="${salary.paytype==4}"> 现金</c:if>
									</td>
									<td>${salary.serial}</td>
								</tr>
							</c:forEach>
						</table>
						<div class="tabfooter">
							<form action="personSalary.html" method="post">
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
								</div>
								<input type="hidden" name="dataCount" value="${page.dataCount}">
								<div class="footer2">
									<button value="1" name="pageNow">首页</button>
									<button value="${page.prePage}" name="pageNow">上一页</button>
									<button value="${page.nextPage}" name="pageNow">下一页</button>
									<button value="${page.lastPage}" name="pageNow">尾页</button>
								</div>
							</form>
						</div>
						<!--endprint-->
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>resource/js/front_person/front_person_print.js" type="text/javascript"></script>
		<script type="text/javascript">
			$('.forsea').on('keyup',function(){
				var ks=$(this).val();
				$('.intelsearch').empty();
				console.log(typeof ks);
				if(ks){
					$.ajax({
						type : "post",
						url : "pNameList.html",
						async : true,
						data : {'pName':ks},
						success : function(date){
							var data1=JSON.parse(date);
							console.log(date);
							for(var i=0;i<data1.length;i++){
								console.log(data1[i]);
								var lis=document.createElement('li');
								lis.innerHTML=data1[i].name;
								$('.intelsearch').append(lis);
							}
						}
					});
				}
			});
			$('.intelsearch').on('click','li',function(){
				$('.forsea').val($(this).html());
			});
			$('.forsea').on('blur',function(){
				$('.intelsearch').hide();
			});
			$('.forsea').on('focus',function(){
				$('.intelsearch').show();
			});
		</script>
	
	</body>

</html>