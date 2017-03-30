<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>设备商出入库记录</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />

	</head>
	<script type="text/javascript">
		
	</script>
	<body>

				<div class='search clearfix'>
					<h3>设备商管理</h3>
					<span class="datum">设备商管理>>设备商出入库记录</span>
					<form name="reg_testdate" action="equipmentTrad_list2.html" method="post">
					<table border="0px" cellspacing="0px" cellpadding="0px">
						<tr>
							<td><label for="eName">设备商名称:</label></td>
							<td><input class="inp" type="text" name="eName" value="${eName}"/></td>
							<td><label for="pName">项目名称:</label></td>
							<td><input class="inp" type="text" name="pName" value="${pName}"/></td>
							<td><label for="principal">经办人:</label></td>
							<td><input class="inp" type="text" name="principal" value="${principal}"/></td>
						</tr>
						<tr>
								<td><label for="year">年:</label></td>
								<td>
									<select name="year" >
									<option value="">--请选择：年--</option>
									<option value="2016" <c:if test="${year=='2016'}">selected</c:if>>2016</option>
									<option value="2017" <c:if test="${year=='2017'}">selected</c:if>>2017</option>
									<option value="2018" <c:if test="${year=='2018'}">selected</c:if>>2018</option>
									<option value="2019" <c:if test="${year=='2019'}">selected</c:if>>2019</option>
									<option value="2020" <c:if test="${year=='2020'}">selected</c:if>>2020</option>
									<option value="2021" <c:if test="${year=='2021'}">selected</c:if>>2021</option>
									<option value="2022" <c:if test="${year=='2022'}">selected</c:if>>2022</option>
									<option value="2023" <c:if test="${year=='2023'}">selected</c:if>>2023</option>
									</select>
								</td>
								<td><label for="month">月:</label></td>
								<td>
									<select name="month" >
									<option value="">--请选择：月--</option>
									<option value="1" <c:if test="${month=='1'}">selected</c:if>>1</option>
									<option value="2" <c:if test="${month=='2'}">selected</c:if>>2</option>
									<option value="3" <c:if test="${month=='3'}">selected</c:if>>3</option>
									<option value="4" <c:if test="${month=='4'}">selected</c:if>>4</option>
									<option value="5" <c:if test="${month=='5'}">selected</c:if>>5</option>
									<option value="6" <c:if test="${month=='6'}">selected</c:if>>6</option>
									<option value="7" <c:if test="${month=='7'}">selected</c:if>>7</option>
									<option value="8" <c:if test="${month=='8'}">selected</c:if>>8</option>
									<option value="9" <c:if test="${month=='9'}">selected</c:if>>9</option>
									<option value="10" <c:if test="${month=='10'}">selected</c:if>>10</option>
									<option value="11" <c:if test="${month=='11'}">selected</c:if>>11</option>
									<option value="12" <c:if test="${month=='12'}">selected</c:if>>12</option>
									</select>	
								</td>
							</tr>
					</table>
					<br />
					<button class="query">查询</button>
					
					
					
				</div>
				<div class="ifamelayout">
					<table id="mytable" class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
					<thead>
						<tr>
							<th>项目名称</th>
							<th>设备商名称</th>
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
							<th>备注</th>
							<th>付款人</th>
							<th>付款方式</th>
							<th>流水号</th>
							<th>操作</th>
						</tr>
						</thead>
						<tbody>	
						<c:forEach items="${etlist}" var="model"> 
						<tr>
							<td>${model.pName}</td>
							<td>${model.eName}</td>
							<td>${model.toolName}</td>
							<td>${model.principal}</td>
							<td>${model.year}${model.month}${model.day}</td>
							<td>${model.thisrent}</td>
							<td>${model.allrent}</td>
							<td>${model.thispay}</td>
							<td>${model.culapay}</td>
							<td>${model.otherpay}</td>
							<td>${model.restpay}</td>
							<td>${model.invoice}</td>
							<td>${model.note}</td>
							<td>${model.drawee}</td>
							<td>${model.payment}</td>
							<td>${model.serial}</td>
							<td>
								<span class="del">
									<a href="javascript:if(confirm('确实要删除${model.eName}吗?'))location='equipmentTrad_del.html?id=${model.id}'" style="color:white">删除</a>
								</span>
							</td>
						</tr>
						</c:forEach>
						</tbody>
					</table>
					<div class="delnote" id="delnote">
						<p>确定删除信息？</p>
						<button class="sure" >确定</button>
						<button class="cancel">取消</button>
					</div>
					
					
					
				</div>
				<div class="footer clearfix">
					<div class="footerl">
						<span>每页：</span>
						<input type="text" value="20" name="pageSize"/>
						<span>条</span>
						<button>确定</button>
						<span>共有</span>
						<span class="footernum">${page.dataCount}</span>
						<span>条记录，当前有</span>
						<span>${page.pageNow}</span><span>/</span><span>${page.pageCount}</span>
						<span>页</span>
					</div>
					<input type="hidden" name="dataCount" value="${page.dataCount}"> 
					<div class="footerr">
						<button value="1" name="pageNow">首页</button>
						<button value="${page.prePage}" name="pageNow">上一页</button>
						<button value="${page.nextPage}" name="pageNow">下一页</button>
						<button value="${page.lastPage}" name="pageNow">尾页</button>
					</div>

				</div>
			</div>
			</form>
		</div>

	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="resource/js/area.js"></script>
	<script src="resource/js/time.js" type="text/javascript" charset="utf-8"></script>
	<script language="JavaScript" type="text/javascript" src="resource/js/jquery.tablesorter.min.js"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	$("#mytable").tablesorter();
	</script>
</html>


