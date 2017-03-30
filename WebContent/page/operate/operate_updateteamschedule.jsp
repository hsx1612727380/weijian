<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>乐建平台</title>
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/operate/operatedemandadd.css" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				$(".cancel").on('click',function(){
					window.location.href="operate_schedule.html?id=${teamSchedule.pId}";
				});
			});
			
			
		</script>
	</head>

	<body>
		<jsp:include page="../top.jsp" flush="true" />
		<jsp:include page="operate_top.jsp" flush="true" />
		<div class="content personal">
			<div class="detail">
				<div class="detailright">
					<form action="operate_updateTeamSchedule.html" method="post">
						<div>
							<label>班组名称</label>
							<span>
								<input type="text" name="teamName" value="${teamSchedule.teamName}"/>
							</span>
							<label>班组类型</label>
							<span>
								<select name="type">
									<option value=0 <c:if test="${teamSchedule.type==0}">selected</c:if> >施工班组</option> 
									<option value=1 <c:if test="${teamSchedule.type==1}">selected</c:if> >材料班组</option>
									<option value=2 <c:if test="${teamSchedule.type==2}">selected</c:if> >设备班组</option>
								</select>
							</span>
							<label>合同价（万)</label>
							<span><input type="text" name="price" value="${teamSchedule.price}"/></span>
						</div>
						<div>
							<label>预付款</label>
							<span><input type="text" name="prepaid" value="${teamSchedule.prepaid}"/></span>
							<label>次数</label>
							<span><input type="text" name="times" value="${teamSchedule.times}"/></span>
							<label>总工程量</label>
							<span><input type="text" name="allWork" value="${teamSchedule.allWork}"/></span>
						</div>
						<div>
							<label>本次工程量</label>
							<span><input type="text" name="thisWork" value="${teamSchedule.thisWork}"/></span>
							<label>累计工程量</label>
							<span><input type="text" name="accoutWork" value="${teamSchedule.accoutWork}"/></span>
							<label>本次付款</label>
							<span><input type="text" name="thisPay" value="${teamSchedule.thisPay}"/></span>
						</div>
						<div>
							<label>累计付款</label>
							<span><input type="text" name="addupPay" value="${teamSchedule.addupPay}"/></span>
							<label>已付工资</label>
							<span><input type="text" name="paid" value="${teamSchedule.paid}"/></span>
							<label>未付工资</label>
							<span><input type="text" name="remainPay" value="${teamSchedule.remainPay}"/></span>
						</div>
						<div>
							<label>结算情况</label>
							<span><input type="text" name="balance" value="${teamSchedule.balance}"/></span>
							<label>备注</label>
							<span><input type="text" name="desc" value="${teamSchedule.desc}"/></span>
							<label>单位</label>
							<span><input type="text" name="unit" value="${teamSchedule.unit}"/></span>
						</div>
						<div>
							<label>注意：</label>
							<span><font color="red">*所有款项均以(万元)为单位*</font></span>
						</div>
						<input type="hidden" name="progress" value="${teamSchedule.progress}"/>
						<input type="hidden" name="id" value="${teamSchedule.id}"/>
						<input type="hidden" name="pId" value="${teamSchedule.pId}"/>
						<input type="hidden" name="tId" value="${teamSchedule.tId}"/>
						<div>
						</div>
						<input type="submit" class="identy" value="保存" />
						<input type="reset" class="cancel" value="取消" />
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="../down.jsp" flush="true" />
		<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
		<script src="resource/js/front_person/idperson.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>