<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/operate/operatedemand.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/tabfooter.css" />
		
	</head>
	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<th>所在区域</th>
					<td>
						${projectModel.provinceChn} ${projectModel.cityChn}
					</td>
					<th>项目名称</th>
					<td>
						${projectModel.name} 
					</td>
					<th>合同价（万）</th>
					<td>
						${projectModel.price} 
					</td>
					<th>预付款（万）</th>
					<td>
						${projectModel.prepaid} 
					</td>
					<th>总工程量</th>
					<td>
						${projectModel.allWork} 
					</td>
					<th>工程状态</th>
					<td>
						<%-- <select name="status" disabled><!-- 不能修改 ，只能显示-->
							<option value=0 <c:if test="${projectModel.status==0}">selected</c:if> >未开始</option> 
							<option value=1 <c:if test="${projectModel.status==1}">selected</c:if> >进行中</option>
							<option value=2 <c:if test="${projectModel.status==2}">selected</c:if> >已完成</option>
						</select> --%>
						<c:choose> 
						  <c:when test="${projectModel.status==0}">未开始 </c:when> 
						  <c:when test="${projectModel.status==1}">进行中</c:when> 
						  <c:when test="${projectModel.status==2}">已完成</c:when> 
						  <c:otherwise >其他状态</c:otherwise> 
						</c:choose> 
					</td>
				</tr>
			</table>
			<div class="search">班组任务进度</div>
			<div class="batch clearfix">
				<div><a href="operate_toAddTeamSchedule.html?pId=${projectModel.id}"><font color="white">新增</font></a></div>
				<div onclick="printit1();">打印</div>
				<div><a href="operate_schedule.html?printT=1&pageSizeT=${pageT.pageSize}&startDateT=${startDateT}&endDateT=${endDateT}&id=${id}"><font color="white">导出EXCEL</font></a></div>
				<form action="operate_schedule.html" method="post">
					<div>
						<input type="hidden" name="id" value="${id}"/> 
						<label for="uid">开始时间:</label><input name="startDateT" value="${startDateT}" placeholder="请输入日期" class="inline laydate-icon" id="startT" style="width:200px; margin-right:10px;"/>
						<label for="uid">截至时间:</label><input name="endDateT" value="${endDateT}" placeholder="请输入日期" class="inline laydate-icon" id="endT" style="width:200px;">
						<input type="submit" value="搜索"/>
					</div>
				</form>
			</div>
			<div>
			<!--startprint1-->
				<table class="groud" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td style="width:15px">序号</td>
						<td>班组名称</td>
						<!-- <td>班组类型</td> -->
						<td>合同价</td>
						<td>预付款</td>
						<td>次数</td>
						<td>总任务量</td>
						<td><sub>本次</sub><br/><sup>工程量</sup></td>
						<td><sub>累计</sub><br/><sup>工程量</sup></td>
						<td>单位</td>
						<td><sub>进度</sub><br/><sup>百分比</sup></td>
						<td>本次付</td>
						<td>累计付</td>
						<td>已付</td>
						<td>未付</td>
						<td>结算</td>
						<td>存档时间</td>
						<td>备注</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${tList}" var="teamSchedule" varStatus="status">
						<tr>
							<td>${status.index+1}</td>
							<td>${teamSchedule.teamName}</td>
							<%-- <td>
								<c:choose> 
								  <c:when test="${teamSchedule.type==0}">施工班组</c:when> 
								  <c:when test="${teamSchedule.type==1}">材料班组</c:when> 
								  <c:when test="${teamSchedule.type==2}">设备班组</c:when> 
								  <c:otherwise >其他班组</c:otherwise> 
								</c:choose> 
							</td> --%>
							<td>${teamSchedule.price}</td>
							<td>${teamSchedule.prepaid}</td>
							<td>${teamSchedule.times}</td>
							<td>${teamSchedule.allWork}</td>
							<td>${teamSchedule.thisWork}</td>
							<td>${teamSchedule.accoutWork}</td>
							<td>${teamSchedule.unit}</td>
							<td>${teamSchedule.progress}</td>
							<td>${teamSchedule.thisPay}</td>
							<td>${teamSchedule.addupPay}</td>
							<td>${teamSchedule.paid}</td>
							<td>${teamSchedule.remainPay}</td>
							<td>${teamSchedule.balance}</td>
							<td><fmt:formatDate value="${teamSchedule.storageTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${teamSchedule.desc}</td>
							<td>
								<div class="amend"><a href="operate_toUpdateTeamSchedule.html?id=${teamSchedule.id}"><font color="white">修改</font></a></div>
							</td>
						</tr>
					</c:forEach>
				</table>
				<!--endprint1-->
			<form action="operate_schedule.html" method="post">
				<input type="hidden" name="id" value="${id}"/> 
				<div class="tabfooter">
					<div class="footerl">
						<span>每页：</span>
						<input type="text" value="${pageT.pageSize}" name="pageSizeT" style="width:30px"/>
						<span>条,第</span>
						<input type="text" value="${pageT.pageNow}" style="width:30px"/>
						<span>页</span>
						<button>确定</button>
						<span>共有</span>
						<span class="footernum">${pageT.dataCount}</span>
						<span>条记录，当前有</span>
						<span>${pageT.pageNow}</span><span>/</span><span>${pageT.pageCount}</span>
						<span>页</span>
						<button name="pageNow" value="1">首页</button>
						<button value="${pageT.prePage}" name="pageNowT">上一页</button>
						<button value="${pageT.nextPage}" name="pageNowT">下一页</button>
						<button value="${pageT.lastPage}" name="pageNowT">尾页</button>
					</div>
				</div>
			</form>
			</div>

			<div class="search">工程各项进度</div>
			<div class="batch clearfix">
				<div><a href="operate_toAddProjectProgress.html?pId=${projectModel.id}"><font color="white">新增</font></a></div>
				<div onclick="printit2();">打印</div>
				<div><a href="operate_schedule.html?printT=2&pageSizeP=${pageP.pageSize}&startDateP=${startDateP}&endDateP=${endDateP}&id=${id}"><font color="white">导出EXCEL</font></a></div>
				<form action="operate_schedule.html" method="post">
					<div>
						<input type="hidden" name="id" value="${id}"/> 
						<label for="uid">开始时间:</label><input name="startDateP" value="${startDateP}" placeholder="请输入日期" class="inline laydate-icon" id="startP" style="width:200px; margin-right:10px;"/>
						<label for="uid">截至时间:</label><input name="endDateP" value="${endDateP}" placeholder="请输入日期" class="inline laydate-icon" id="endP" style="width:200px;">
						<input id="div" type="submit" value="搜索"/>
					</div>
				</form>
			</div>
			<div>
			<!--startprint2-->
				<table class="groud" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td>序号</td>
						<td>单位工程</td>
						<td>单位</td>
						<td>总工程量</td>
						<td>本周完成</td>
						<td>累计完成</td>
						<td>进度百分比</td>
						<td>下期计划</td>
						<td>存档时间</td>
						<td>备注</td>
						<td>操作</td>
					</tr>
				<c:forEach items="${pList}" var="projectProgress" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${projectProgress.unit}</td>
						<td>${projectProgress.unitPer}</td>
						<td>${projectProgress.allWork}</td>
						<td>${projectProgress.thisWeek}</td>
						<td>${projectProgress.accoutWork}</td>
						<td>${projectProgress.progress}</td>
						<td>${projectProgress.plan}</td>
						<td><fmt:formatDate value="${projectProgress.storageTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td>${projectProgress.desc}</td>
						<td>
							<div class="amend"><a href="operate_toUpdateProjectProgress.html?id=${projectProgress.id}"><font color="white">修改</font></a></div>
						</td>
					</tr>
				</c:forEach>
				</table>
			<!--endprint2-->
			<form action="operate_schedule.html" method="post">
				<input type="hidden" name="id" value="${id}"/> 
				<div class="tabfooter">
					<div class="footerl">
						<span>每页：</span>
						<input type="text" value="${pageP.pageSize}" name="pageSizeP" style="width:30px"/>
						<span>条,第</span>
						<!-- 下面这个属性只需要显示不用提交不需要name属性，否则和下面的‘上一页’、‘下一页’重复提交同一个属性，会报错400 -->
						<input type="text" value="${pageP.pageNow}" style="width:30px"/>
						<span>页</span>
						<button>确定</button>
						<span>共有</span>
						<span class="footernum">${pageP.dataCount}</span>
						<span>条记录，当前有</span>
						<span>${pageP.pageNow}</span><span>/</span><span>${pageP.pageCount}</span>
						<span>页</span>
						<button value="1" name="pageNow">首页</button>
						<button value="${pageP.prePage}" name="pageNowP">上一页</button>
						<button value="${pageP.nextPage}" name="pageNowP">下一页</button>
						<button value="${pageP.lastPage}" name="pageNowP">尾页</button>
					</div>
				</div>
			</form>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/laydate.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>resource/js/front_person/front_person_print.js" type="text/javascript"></script>
		<script type="text/javascript">
			!function(){
				laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
				laydate({elem: '#startT'}); //绑定元素
				laydate({elem: '#startP'}); //绑定元素
				laydate({elem: '#endT'}); //绑定元素
				laydate({elem: '#endP'}); //绑定元素
			}();
		</script>
	</body>
</html>