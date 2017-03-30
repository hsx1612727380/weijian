<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>

<head>
	<meta charset="utf-8" />
	<title>乐建平台</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/common.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/fcompany/identerprise.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/fcompany/projectappend.css" />
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=629Um5l2umNbmEo10SfHQjgM4cGtQe7b"></script>
</head>

<body>
	<jsp:include page="../top.jsp" flush="true" />
	<div class="title">
		<div class="content">
			<span>新增项目</span>
		</div>
	</div>
	<div class="content personal">
		<div class="detail">
			<div class="detailright">
				<form method="post" action="company_projectAdd2.html">
					<input type="hidden" name="code" value="${projectModel.code }"/>
					<div class="column">
						<div class="intitle">
							项目基本信息 <span>(<i class="red">*</i>为必填)</span>
						</div>
						<table class="basedetail" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<th><span class="red">*</span>项目名称</th>
								<td><input id="name" type="text" name="name"/></td>
								<th><span class="red">*</span>组织机构代码</th>
								<td><input id="pCode" type="text" name="pCode"/></td>
								<th><span class="red">*</span>合同价（万）</th>
								<td><input id="price" type="text" name="price"/></td>
							</tr>
							<tr>
								<th><span class="red">*</span>所在区域</th>
								<td>
									<select id="province" onchange="setCity(this.value);getArea();" name="province" style="width: 96px;" runat="server">
										<option value="" selected="selected">请选择省份</option>
									</select>
									<select id="city" onchange="setCounty(this.value);getArea();" name="city" style="width: 96px;" runat="server">
										<option value="" selected="selected">请选择城市</option>
									</select>
								</td>
								<th><span class="red">*</span>详细地址</th>
								<td colspan="3"><input id="street" type="text" name="street" style="width: 620px;" /></td>	
							</tr>
							<tr>
								<th><span class="red">*</span>总工程量</th>
								<td><input id="allWork" type="text" name="allWork"/></td>
								<th><span class="red">*</span>本次工程量</th>
								<td><input id="thsWork" type="text" name="thsWork"/></td>
								<th><span class="red">*</span>累计工程量</th>
								<td><input id="accWork" type="text" name="accWork"/></td>
							</tr>
							<tr>
								<th><span class="red">*</span>预付款</th>
								<td><input id="prepaid" type="text" name="prepaid"/></td>
								<th><span class="red">*</span>项目负责人</th>
								<td id="projectLeaderName"><input id="leaderName" type="text" name="leaderName"/></td>
								<th><span class="red">*</span>负责人联系方式</th>
								<td id="projectUserId"><input id="userId" type="text" name="userId"/></td>
							</tr>
							<tr>
								<th>次数</th>
								<td><input type="text" name="times"/></td>
								<!-- 默认的是公司名，后台自己拿数据添加就好 -->
								<!-- <th>单位</th>
								<td><input type="text" name="unit"/></td> -->
								<th>工程状态</th>
								<td>
									<select name="status">
										<option value="0">未开始</option>
										<option value="1">进行中</option>
										<option value="2">已完成</option>
									</select>
								</td>
								<th>累计完成比例</th>
								<td><input type="text" name="progress"/></td>
							</tr>
							<tr>
								<th>立项文号</th>
								<td><input type="text" name="projectTitanic"/></td>
								<th>立项级别</th>
								<td><input type="text" name="projectlevel"/></td>
								<th>立项批复机关</th>
								<td><input type="text" name="projectorgan"/></td>
							</tr>
							<tr>
								<th>省级项目编号</th>
								<td><input type="text" name="provinceCode"/></td>
								<td colspan="4" rowspan="8">
									<div id="container"></div>
								</td>
							</tr>
							<tr>
								<th>立项批复时间</th>
								<td><input type="text" name="replytime"/></td>
							</tr>
							<tr>
								<th>总面积/长度</th>
								<td><input type="text" name="totalarea"/></td>
							</tr>
							<tr>
								<th>工程用途</th>
								<td>
									<select name="purpose">
										<option value="">请选择工程用途</option>
										<option value="民用建筑">民用建筑</option>
										<option value="工业建筑">工业建筑</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>建设性质</th>
								<td>
									<select name="nature">
										<option value="">请选择建设性质</option>
										<option value="新建">新建</option>
										<option value="扩建">扩建</option>
										<option value="改建">改建</option>
										<option value="迁建">迁建</option>
										<option value="恢复">恢复</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>计划开工日期</th>
								<td><input type="text" name="worktime"/></td>
							</tr>
							<tr>
								<th>项目分类</th>
								<td>
									<select name="type">
										<option value="">请选择项目分类</option>
										<option value="房屋建筑工程">房屋建筑工程</option>
										<option value="冶炼工程">冶炼工程</option>
										<option value="矿山工程">矿山工程</option>
										<option value="化工石油工程">化工石油工程</option>
										<option value="水利水电工程">水利水电工程</option>
										<option value="电力工程">电力工程</option>
										<option value="农林工程">农林工程</option>
										<option value="铁路工程">铁路工程</option>
										<option value="公路工程">公路工程</option>
										<option value="港口与航道工程">港口与航道工程</option>
										<option value="航天航空工程">航天航空工程</option>
										<option value="通信工程">通信工程</option>
										<option value="市政公用工程">市政公用工程</option>
										<option value="机电安装工程">机电安装工程</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>单位</th>
								<td><input type="text" name="unit"/></td>
							</tr>
						</table>
					</div>
					<div>
						<!-- <label>经度</label> -->
						<input id="lonlat" name="lonlat" type="hidden" value="113.346715">
					</div>
					<div>
						<!-- <label>纬度</label> -->
						<input id="lonlat2" name="lonlat2" type="hidden" value="23.140517">
					</div>
					<div class="columnthree">
						<input id="addSubmit" class="cancel" type="submit" value="提交"/>
						<input class="cancel" type="reset" value="取消" />
						 <input class="cancel" type="button" value="返回" onclick="JavaScript:history.back(-1);" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../down.jsp" flush="true" />
		
	<script src="<%=basePath%>/resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/qianmain.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/area.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/map.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/resource/js/fcompany/companyProject.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>