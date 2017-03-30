<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>设备商列表</title>
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

				
				<div class="ifamelayout">
				<tr>
				<td colspan="16" style="text-align: left;"> <b>项目名称:${pmodel.name}
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;设备商名称：${emodel.name}</b></td>
				</tr>
					<table id="mytable" class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
					<thead>
						<tr>
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

	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="resource/js/area.js"></script>
	<script language="JavaScript" type="text/javascript" src="resource/js/jquery.tablesorter.min.js"></script>
	<script type="text/javascript">
	$("#mytable").tablesorter();
	</script>
</html>


