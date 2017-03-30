<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" type="text/css" href="../resource/css/normalize.css"/>
<link rel="stylesheet" type="text/css" href="../resource/css/common.css" />
<link rel="stylesheet" type="text/css" href="../resource/css/front_equipment/idequip.css" />
<link rel="stylesheet" type="text/css" href="../resource/css/front_equipment/equipAttendance.css" />
<link rel="stylesheet" type="text/css" href="../resource/css/tabfooter.css" />	

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
					<div class="intitle">设备供应</div>
					<div class="addbtn">新增</div>
				</div>
				<div class="derightbottom">
					<table border="0" cellspacing="1" cellpadding="0">
						<tr>
							<th colspan="16">供应信息</th>
						</tr>
						<tr>
							<td>公司名称</td>
							<td>班组类型</td>
							<td>设备名称</td>
							<td>提供租赁地区</td>
							<td>诚信度</td>
							<td>联系方式</td>
							<td>公司地址</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${requirementsList}" var="requirement">
						<tr>
							<td>${requirement.name}</td>
							<td>设备班组</td>
							<td>${requirement.shopName}</td>
							<td>${requirement.provinceStr}${requirement.cityStr}</td>
							<td>
								<c:forEach begin="1" end="${equipmentModel.reliableStar}">
								   <span><img src="../resource/images/u662.png"/></span>
								</c:forEach>
							</td>
							<td>${equipmentModel.userId}</td>
							<td>${equipmentModel.provinceChn}${equipmentModel.cityChn}${equipmentModel.countyChn}</td>
							<td style="width:100px">
								<div style="margin-top:0;margin-left:15px" class="modifybtn">
									<a style="color:white" href="deleteSupply.html?id=${requirement.id}">删除</a>
								</div>
							</td>
						</tr>
						</c:forEach>
					</table>
				<div class="tabfooter">
					<form action="equipmentSupply.html" method="post">
						<button value="1" name="pageNow">首页</button>
						<button value="${page.prePage}" name="pageNow">上一页</button>
						<span>当前有</span>
						<span>${page.pageNow}</span><span>/</span><span>${page.pageCount}</span>
						<span>页</span>
						<button value="${page.nextPage}" name="pageNow">下一页</button>
						<button value="${page.lastPage}" name="pageNow">尾页</button>
					</form>
				</div>
				</div>
			</div>
		</div>
		<form class="addform" action="addSupply.html" method="post">
			<input type="hidden" name="rId" value="${equipmentModel.id}"/>
			<input type="hidden" name="leaderName" value="${equipmentModel.leaderName}"/>
			<table class="basedetail">
				<tr>
					<td class="intitle">发布设备供应信息</td>
				</tr>
				<tr>
					<td>供应商名称</td>
					<td>
						<span>
						<input  name="name" readonly type="text" value="${equipmentModel.name}" />
						</span>
					</td>
				</tr>
				<tr>
					<td>班组类型</td>
					<td>
						<span>设备班组	</span>
					</td>
				</tr>
				<tr>
					<td>设备名称</td>
					<td><input  name="shopName" type="text" /></td>
				</tr>
				<tr>
					<td>提供租赁地区</td>
					<td>
						<select id="province" onchange="setCity(this.value);getArea();" name="province" >
                              <option >--请选择省份--</option>
                        </select>
                        <select id="city" onchange="setCounty(this.value);getArea();" name="city" >
                              <option>--请选择城市--</option>
                        </select>
					</td>
				</tr>
				<tr>
					<td>备注</td>
					<td><input  name="desc" type="text" /></td>
				</tr>
			</table>
			<div class="columnthree">
				<input class="cancel" type="submit" value="保存" />
				<input class="cancel addcancel" type="button" value="取消" />
			</div>
		</form>
	</div>
	<jsp:include page="../down.jsp" flush="true" />
	<div class="mask"></div>
	<script src="../resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="../resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	<script src="../resource/js/front_equipment/idequip.js" type="text/javascript" charset="utf-8"></script>
	<script src="../resource/js/front_equipment/equipsupply.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/area.js" type="text/javascript" ></script>
</body>

</html>