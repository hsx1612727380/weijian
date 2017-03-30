<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<link rel="stylesheet" type="text/css" href="../resource/css/front_equipment/equipFile.css" />
		<script type="text/javascript" charset="utf-8" src="../resource/js/jquery-1.12.3.min.js"></script>
		<script type="text/javascript">
			console.log('${merchantModel.id}');
			$(function(){
				$(".form").hide();
				$("#change").on('click',function(){
					$(".noform").hide();
					$(".form").show();
				});
				$("#update").on('click',function(){
					$("form").submit();
					$(".noform").show();
					$(".form").hide();
				});
			});
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
			<div class="autstate"><span>认证状态：</span><span>材料班组</span></div>
			<div class="detail">
				<jsp:include page="material_left.jsp" flush="true" />
				<div class="detailright">
					<div class="persontitle">
						<div class="filetile">材料供应商诚信档案</div>
						<div class="print" onclick="printit();">打印</div>
						<div id="change" class="update" >修改</div>
						<div id="update" class="update">更新</div>
					</div>
					<!--startprint-->
				<form action="updateMerchant.html" method="post">
					<input type="hidden" name="id" value="${merchantModel.id}"/>
					<%-- <input type="hidden" name="type" value="${merchantModel.type}"/> --%>
					<input type="hidden" name="code" value="${merchantModel.code}"/>
					<table border="0" cellspacing="1" cellpadding="5">
						<tr>
							<th colspan="6" class="thcenter">供应商资料</th>
						</tr>
						<tr>
							<th>材料名称：</th>
							<td> 
								<span class="noform">${merchantModel.itemname}</span>
								<span class="form" ><input name="itemname" type="text" value="${merchantModel.itemname}"/></span>
							</td>
							<th>供货地区:</th>
							<td>
								<span class="noform">${merchantModel.supply}</span>
								<span class="form" ><input name="supply" type="text" value="${merchantModel.supply}"/></span>
							</td>
							<th>是否公开档案:</th>
							<td colspan="2">
								<span class="noform">
									<c:if test="${merchantModel.open==0}">不公开</c:if>
									<c:if test="${merchantModel.open==1}">公开</c:if>
								</span>
								<span class="form">
									<select name="open">
										<option value=0 <c:if test="${merchantModel.open==0}">selected</c:if>>不公开</option>
										<option value=1 <c:if test="${merchantModel.open==1}">selected</c:if>>公开</option>
									</select>
								</span>
							</td>
						</tr>
						<tr>
							<th>供应商名称:</th>
							<td>
								<span class="noform">${merchantModel.supplier}</span>
								<span class="form"><input name="supplier" type="text" value="${merchantModel.supplier}"/></span>
							</td>
							<th>统一社会信用代码:</th>
							<td>
								<span class="noform" >${merchantModel.licence}</span>
								<span class="form" ><input name="licence" type="text" value="${merchantModel.licence}"/></span>
							</td>
							<th>成立日期:</th>
							<td>
								<span class="noform">${materialModel.establishDate}</span>
								<span class="form" ><input name="build" type="text" class="laydate-icon" id="demo" value="${merchantModel.build}"/></span>
							</td>
						</tr>
						<tr>
							<th>注册资金（万）:</th>
							<td>
								<span class="noform" >${materialModel.regcapital}</span><!-- class="noform" -->
								<span class="form" ><input name="regcapital" type="text" value="${materialModel.regcapital}"/></span>
							</td>
							<th>实缴（万）:</th>
							<td>
								<span class="noform">${merchantModel.paid}</span>
								<span class="form"><input name="paid" type="text" value="${merchantModel.paid}"/></span>
							</td>
							<th>电话/传真号:</th>
							<td>
								<span class="noform">${merchantModel.phone}</span>
								<span class="form" ><input name="phone" type="text" value="${merchantModel.phone}"/></span>
							</td>
						</tr>
						<tr>
							<th>邮箱:</th>
							<td>
								<span class="noform">${merchantModel.email}</span>
								<span class="form" ><input name="email" type="text" value="${merchantModel.email}"/></span>
							</td>
							<th>结算方式:</th>
							<td>
								<span class="noform">${merchantModel.paytype}</span>
								<span class="form" ><input name="paytype" type="text" value="${merchantModel.paytype}"/></span>
							</td>

							<th>初期应付（万）:</th>
							<td>
								<span class="noform">${merchantModel.cope}</span>
								<span class="form"><input name="cope" type="text" value="${merchantModel.cope}"/></span>
							</td>
						</tr>
						<tr>
							<th>注册地址:</th>
							<td>
								<span class="noform">${merchantModel.registeraddress}</span>
								<span class="form" ><input name="registeraddress" type="text" value="${merchantModel.registeraddress}"/></span>
							</td>
							<th>联系人:</th>
							<td>
								<span class="noform">${merchantModel.name}</span>
								<span class="form" ><input name="name" type="text" value="${merchantModel.name}"/></span>
							</td> 
							<th>联系人地址:</th>
							<td>
								<span class="noform">${merchantModel.address}</span>
								<span class="form" ><input name="address" type="text" value="${merchantModel.address}"/></span>
							</td>
						</tr> 
						<tr>
							<th>供应状态:</th>
							<td >
								<span class="noform">
									<c:if test="${merchantModel.status==0}">停供中</c:if>
									<c:if test="${merchantModel.status==1}">供应中</c:if>
								</span>
								<span class="form">
									<select name="status" >
										<option value=0 <c:if test="${merchantModel.status==0}">selected="selected"</c:if> >停供中</option>
										<option value=1 <c:if test="${merchantModel.status==1}">selected="selected"</c:if> >供应中</option>
									</select>
								</span>
							</td>
							<th>诚信度:</th>
							<td colspan="1">
								<c:forEach  begin="1" end="${materialModel.reliableStar}" >
									<span>
										<img src="../resource/images/u662.png" />
									</span>
								</c:forEach>
								<c:forEach begin="${materialModel.reliableStar+1}" end="5" >
								<span>
									<img src="../resource/images/u663.fw.png" />
								</span>
								</c:forEach>
							</td>
							<td>备注：</td>
							<td>
								<span class="noform">${merchantModel.note}</span>
								<span class="form" ><input name="note" type="text" value="${merchantModel.note}"/></span>
							</td>
						</tr> 
						<tr>
							<th colspan="6" class="thcenter">联系方式</th>
						</tr>
						<tr>
							<th>手机:</th>
							<td>
								<span class="noform">${merchantModel.mobile}</span>
								<span class="form" ><input name="mobile" type="text" value="${merchantModel.mobile}"/></span>
							</td>
							<th>QQ:</th>
							<td>
								<span class="noform">${merchantModel.qq}</span>
								<span class="form" ><input name="qq" type="text" value="${merchantModel.qq}"/></span>
							</td>
							<th>微信:</th>
							<td>
								<span class="noform">${merchantModel.wetchat}</span>
								<span class="form" ><input name="wetchat" type="text" value="${merchantModel.wetchat}"/></span>
							</td>
						</tr>
						<tr>
							<th colspan="6" class="thcenter">支付方式</th>
						</tr>
						<tr>
							<th>支付宝:</th>
							<td>
								<span class="noform">${merchantModel.paytreasure}</span>
								<span class="form" ><input name="paytreasure" type="text" value="${merchantModel.paytreasure}"/></span>
							</td>
							<th>开户行:</th>
							<td colspan="5" >
								<span class="noform">${merchantModel.depositBank}</span>
								<span class="form"><input name="depositBank" value="${merchantModel.depositBank}" type="text" placeholder="格式：xxx银行xxx支行"  style="width:350px"/></span>
							</td>
						</tr>
						<tr>
							<th>银行账号:</th>
							<td colspan="2">
								<span class="noform">${merchantModel.bankaccount}</span>
								<span class="form"><input name="bankaccount" type="text" value="${merchantModel.bankaccount}" style="width:260px"/></span>
							</td>
							<th>微信(支付):</th>
							<td colspan="2">
								<span class="noform">${merchantModel.payment}</span>
								<span class="form" ><input  name="payment" type="text" value="${merchantModel.payment}"/></span>
							</td>
						</tr><%-- --%>
					</table>
				</form>
					<div class="persontitle">
						<div class="filetile">项目供货评价</div>
					</div>
					<table class="assess" border="0" cellspacing="1" cellpadding="0">
						<tr>
							<td>项目名称</td>
							<td>起止时间</td>
							<td>质量</td>
							<td>价格</td>
							<td>售后</td>
							<td>备注</td>
						</tr>
						<c:forEach items="${comments}" var="comment" >
						<tr>
							<td>${comment.projectName}</td>
							<td>${comment.startTime}至${comment.endTime}</td>
							<td><c:forEach begin="1" end="${comment.scoreStr1}">
									   <span><img src="resource/images/u662.png"/></span>
									</c:forEach></td>
							<td><c:forEach begin="1" end="${comment.scoreStr2}">
									   <span><img src="resource/images/u662.png"/></span>
									</c:forEach></td>
							<td><c:forEach begin="1" end="${comment.scoreStr3}">
									   <span><img src="resource/images/u662.png"/></span>
									</c:forEach></td>
							<td>${comment.desc}</td>
						</tr>
						</c:forEach>
					</table>
					<!--endprint-->
				</div>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="<%=basePath%>resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>resource/js/front_equipment/idequip.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>resource/js/area.js" type="text/javascript" ></script>
		<script src="<%=basePath%>resource/js/laydate.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>resource/js/front_person/front_person_print.js" type="text/javascript"></script>
	</body>
	</body>
	<script type="text/javascript">
		laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
		laydate({elem:'#demo'});//绑定时间控件方法	
	</script>
	
</html>