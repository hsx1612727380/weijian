<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="../resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="../resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="../resource/css/front_equipment/equipAttendance.css" />
		<link rel="stylesheet" type="text/css" href="../resource/css/tabfooter.css" />
		<script src="../resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="../resource/js/front_equipment/idequip.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		 $(document).ready(function(){
				//var year1=new Date().getFullYear();//获取当前年份
				console.log($("#year"));
				for(var year = 2016; year<=2080; year++ ){
					$("#year").append("<option value="+year+">"+year+"</option>");
				}
				for(var month = 1; month<=12; month++ ){
					$("#month").append("<option value="+month+" >"+month+"</option>");
				}
				//回显
				var yearOts=$('#year').children();
				var monthOpts=$('#month').children();
				for(var i=0;i<=yearOts.length;i++){
					if(yearOts[i].value==='${year}'){
						yearOts[i].selected=true;
						
						for(var i=1;i<monthOpts.length;i++){
							if(monthOpts[i].value==='${month}'){
								monthOpts[i].selected=true;
								return;
							}
						}
						return;
					}
				}
				//调试信息
				$("a:contains('搜索')").click(function(){
					console.log($("#name").val()+" "+ $("#year").val()+" "+ $("#month").val());
					console.log("回显参数name："+'${pName}'+" year："+'${year}'+" month："+'${month}');
				});
			}); 
			 //表单提交函数
			 function submitForm() {
				return $("#form").submit(); //提交名字为form的表单
			}
		</script>
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<div class="title">
			<div class="content">
				<span>个人中心</span>
			</div>
		</div>
		<div class="content personal">
			<div class="autstate"><span>认证状态：</span><span>设备班组</span></div>
			<div class="detail">
				<jsp:include page="equipment_left.jsp" flush="true" />
				<div class="detailright">
					<div class="derighttop clearfix">
						<form id="form" action="equipmentLog.html"  method="post">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									设备商名称：<b>${eName}</b>
								</td>
								<td>年份</td>
								<td>
								<select id="year" style="width:60px" name="year" >
									<option></option>
								</select>
								</td>
								<td>月份</td>
								<td>
									<select id="month" style="width:60px" name="month" >
										<option></option>
									</select>
								</td>
								<td>项目名称：<input name="pName" value="${pName}" placeholder="输入项目名字词可分项目查询" type="text" style="width:200px"/></td>
							</tr>
						</table>
						</form>
						<div onClick="submitForm()"><font color="white">搜索</font></div>
						<div>打印</div>
						<div><a href="equipmentLog.html?export=1" style="color:white">导出EXCEL</a></div>
						
					</div>
					<div class="derightbottom">
						<table border="0" cellspacing="1" cellpadding="0">
							<tr>
								<th colspan="16">租凭记录</th>
							</tr>
							<tr>
								<th>项目名称</th>
								<th>设备名称</th>
								<th>经办人</th>
								<th>出租日期</th>
								<th>本期租赁</th>
								<th>累计租赁</th>
								<th>本次付款</th>
								<th>累计付款</th>
								<th>其它款</th>
								<th>余款</th>
								<th>发票</th>
								<th>付款人</th>
								<th>付款方式</th>
								<th>流水号</th>
								<th>备注</th>
							</tr>
							<c:forEach items="${equipmentTradModelList}" var="equipmentTradModel">
							<tr>
								<td>${equipmentTradModel.pName}</td>
								<td>${equipmentTradModel.toolName}</td>
								<td>${equipmentTradModel.principal}</td>
								<td>${equipmentTradModel.rentdate}</td>
								<td>${equipmentTradModel.thisrent}</td>
								<td>${equipmentTradModel.allrent}</td>
								<td>${equipmentTradModel.thispay}</td>
								<td>${equipmentTradModel.culapay}</td>
								<td>${equipmentTradModel.otherpay}</td>
								<td>${equipmentTradModel.restpay}</td>
								<td>${equipmentTradModel.invoice}</td>
								<td>${equipmentTradModel.drawee}</td>
								<td>${equipmentTradModel.payment}</td>
								<td>${equipmentTradModel.serial}</td>
								<td>${equipmentTradModel.note}</td>
							</tr>
							</c:forEach>
							
							
						</table>
				<div class="tabfooter">
					<form action="equipmentLog.html" method="post">
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
		</div>
		<jsp:include page="../down.jsp" flush="true" />
	</body>

</html>