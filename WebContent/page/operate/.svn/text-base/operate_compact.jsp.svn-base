<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.fengyun.web.hardcode.IMageUploadInfo"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/operate/operateneed.css" />
		
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<jsp:include page="operate_secondarytitle.jsp" flush="true" />
			<div class="operate clearfix">
				<form id="addform" action="operate_toAddCompact.html" method="post" >
					<input type="hidden" name="id" value="${projectModel.id}"/>
					<input type="hidden" id="visitAddress" value="<%=IMageUploadInfo.VISITADDRESS.value%>" />
					<input type="hidden" id="operateCompact" value="<%=IMageUploadInfo.OPERATECOMPACT.value%>" />
					<span>工程名称:</span>
					<input type="text" value="${projectModel.name}" readonly/>
					<div class="need" id="addnew">新增合同</div>
				</form>
			</div>
			<table class="condition" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th>序号</th>
					<th>建设单位</th>
					<th>工程名称</th>
					<th>合同名称</th>
					<th>合同类别</th>
					<th>合同内容</th>
					<th>合同编号</th>
					<th>供应商名称</th>
					<th>总金额</th>
					<th>签订日期</th>
					<th>附件</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${compactList}" var="compact" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${compact.company}</td>
					<td>${compact.projectName}</td>
					<td>${compact.compactName}</td>
					<td>
						<c:choose>
							<c:when test="${compact.compactType==1}">材料合同 </c:when> 
							<c:when test="${compact.compactType==2}">用工合同</c:when> 
							<c:when test="${compact.compactType==3}">设备租赁合同</c:when> 
							<c:when test="${compact.compactType==4}">设备采购合同</c:when> 
							<c:otherwise >其他</c:otherwise> 
						</c:choose>
					</td>
					<td>${compact.compactBrief}</td>
					<td>${compact.compactNum}</td>
					<td>${compact.supplier}</td>
					<td>${compact.amount}</td>
					<td><fmt:formatDate value="${compact.signDate}" type="date" pattern="yyyy-MM-dd"/></td>
					<td><!-- 上传合同图片或者查看合同图片 -->
						<input type="hidden" class="attachment" value="${compact.attachment}">
						<c:choose>
							<c:when test="${compact.attachment==null||compact.attachment == ''}">
								<form action="operate_uploadCompact.html?pId=${projectModel.id}&id=${compact.id}" method="post" enctype="multipart/form-data">
									<div class="files" style="float:left;margin-left:14px">
										<input style="background-image: url(../../../../resource/images/file.png);" type="file" name="attachment" />
									</div>
									<div class="submit" style="float:left;margin-left:4px">
										<input type="submit">
									</div>
								</form>
							</c:when>
							<c:when test="${compact.attachment!= null }">
								<div style="width:60px;font-size:14px;color:white;border-radius:3px;height:25px;line-height:25px">
									查看
									<input type="button" class="file" style="margin-left: 0;" />
									
								</div>
							</c:when>
							<c:otherwise >其他</c:otherwise> 
						</c:choose>
					</td>
					<td><i class="audit" style="display: inline-block;margin: 0;width: 60px;font-style: normal;"><a href="operate_editeCompact.html?id=${compact.id}&pId=${compact.pId}">修改</a></i></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_company/projectinvite.js" type="text/javascript" charset="utf-8"></script>
	</body>
	<script type="text/javascript">
		$("#needhide").hide();
		$("#addnew").on('click',function(){
			$("#addform").submit();
		});
	</script>
	<script>
		//查看上传的图片
		$('.file').on('click',function(){	
			var index=$(this).parent().parent().parent().children().first().html();
			console.log(index-1);
			var attachment=$(".attachment").eq(index-1).val();
			console.log(attachment);
			var operateCompact=$("#operateCompact").val();
			var visitAddress=$("#visitAddress").val();
			window.open(visitAddress+operateCompact+"${projectModel.id}\\"+attachment);	
		})
		
	</script>
</html>