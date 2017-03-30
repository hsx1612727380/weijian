<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<title>公司项目列表</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/records.css" />
		<style>
			.querytable th{
				color:white
			}
		</style>
	</head>
	
	<body>
				<h3>公司管理</h3>
					<span class="datum">公司管理>>${companyName}</span>
					<table></table>
					<br/>
					<span>公司资质与资信</span>
					<span class="del">
						<a href="aptitude_add.html?code=${code}&cName=${companyName}" style="color:white">新增</a>
					</span>
					<form>
					<table class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
						<tr>
							<th>证书编号</th>
							<th>资质资信类别</th>
							<th>资质资信等级</th>
							<th>审批机关</th>
							<th>资质最新批准日期</th>
							<th>资质有效期</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${alist}" var="model"> 
						<tr>
							<td>${model.certificate}</td>
							<td>${model.adtypeName}</td>
							<td>${model.adlevelName}</td>
							<td>${model.approval}</td>
							<td>${model.approvalTime}</td>
							<td>${model.validity}</td>
							<td>
								<span class="items">
									<a href="aptitude_modify.html?id=${model.id}" style="color:white">修改</a>
								</span>
								
								<span class="add">
									<a href="aptitude_del.html?id=${model.id}" style="color:white">删除</a>
								</span>
							</td>
						</tr>
						</c:forEach>
					</table>
					</form>
					<br/>
					<span class="datum">公司行为</span>
					<span class="del">
						<a href="behavior_add.html?code=${code}&cName=${companyName}" style="color:white">新增</a>
					</span>
					<form>
					<table class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
						<tr>
							<th>标题</th>
							<th>行为类型</th>
							<th>行为时间</th>
							<th>行为内容</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${blist}" var="model"> 
						<tr>
							<td>${model.title}</td>
							<td>
							<c:if test="${model.type=='1'}">良好行为</c:if>
							<c:if test="${model.type=='2'}">不良行为</c:if>
							<c:if test="${model.type=='3'}">欠薪行为</c:if>
							</td>
							<td>${model.behaviorTime}</td>
							<td>${model.content}</td>
							<td>
								<span class="items">
									<a href="behavior_modify.html?id=${model.id}" style="color:white">修改</a>
								</span>
								
								<span class="add">
									<a href="behavior_del.html?id=${model.id}" style="color:white">删除</a>
								</span>
							</td>
						</tr>
						</c:forEach>
					</table>
					</form>
					<br/>
					<span class="datum">公司注册人员</span>
					<span class="del">
						<a href="engineer_add.html?code=${code}&cName=${companyName}" style="color:white">新增</a>
					</span>
					<form>
					<table class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
						<tr>
							<th>注册人员姓名</th>
							<th>手机号</th>
							<th>注册类别</th>
							<th>注册编号</th>
							<th>发证机关</th>
							<th>签发日期</th>
							<th>有效日期</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${elist}" var="model"> 
						<tr>
							<td>${model.name}</td>
							<td>${model.userId}</td>
							<td>${model.type}</td>
							<td>${model.registration}</td>
							<td>${model.certificateorgan}</td>
							<td>${model.issuancedate}</td>
							<td>${model.effectivedate}</td>
							<td>
								<span class="items">
									<a href="engineer_modify.html?id=${model.id}" style="color:white">修改</a>
								</span>
								
								<span class="add">
									<a href="engineer_del.html?id=${model.id}" style="color:white">删除</a>
								</span>
							</td>
						</tr>
						</c:forEach>
					</table>
					</form>
				

				<div>
					<br/>
					<span class="datum">公司项目列表</span>
					<span class="del">
						<a href="project_add.html?code=${code}&cName=${companyName}" style="color:white">新增</a>
					</span>
					<form action="company_projectlist2.html" method="post">
					<table class="querytable" border="1px" cellspacing="0" cellpadding="3px" style="text-align: center;">
						<tr>
							<th>项目名称</th>
							<th>负责人</th>
							<th>省份</th>
							<th>城市</th>
							<th>合同价(万)</th>
							<th>预付款(万)</th>
							<th>完成度</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${plist}" var="model"> 
						<tr>
							<td><a href="project_info.html?code=${model.code}&id=${model.id}" style="color:blue">${model.name}</a></td>
							<td>${model.leaderName}</td>
							<td>${model.provinceChn}</td>
							<td>${model.cityChn}</td>
							<td>${model.price}</td>
							<td>${model.prepaid}</td>
							<td>${model.progress}%</td>
							<td><c:choose>
							   <c:when test="${model.check== '1'}">  
							        已审核       
							   </c:when>
							   <c:otherwise> 
							    未审核
							   </c:otherwise>
							</c:choose></td>
							<td>
								<span class="items">
									<a href="project_info.html?code=${model.code}&id=${model.id}" style="color:white">详情</a>
								</span>
								
								<span class="add">
									<a href="project_modify.html?id=${model.id}" style="color:white">修改</a>
								</span>
							&nbsp;&nbsp;
							<!--  
								<span class="del">
									<a href="javascript:if(confirm('确实要删除${model.name}吗?'))location='project_del.html?id=${model.id}'" style="color:white">删除</a>
								</span>
								-->
							</td>
						</tr>
						</c:forEach>
						
					</table>
					
					
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
</html>


