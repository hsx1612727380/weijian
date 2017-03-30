<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>新增公司</title>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/table.css" />

	</head>

	<body>
	<form action="company_add2.html" method="post">
				<div class='search clearfix'>
					<h3>公司管理</h3>
					<span class="datum">公司管理>>新增公司</span>
					<table border="0" cellspacing="0" cellpadding="0" style="display:table;margin:0 auto;">
					<tr>
						<td><label for="uid">公司代码:</label></td>
						<td style="color:red"><input id="Code" class="inp" type="text" name="code" placeholder="请输入公司代码" /><span>*必须填写</span></td>
					</tr>
					<tr>
						<td><label for="uid">公司名称:</label></td>
						<td style="color:red"><input id="CompanyName" class="inp" type="text" name="name" placeholder="请输入公司名称" /><span>*必须填写</span></td>
					</tr>
					<tr>
						<td><label for="uid">联系方式:</label></td>
						<td><input class="inp" type="text" name="tel" /></td>
					</tr>
					<tr>
						<td><label for="uid">注册类型:</label></td>
						<td>
							<select name="regType">
							    <option value="内资企业">内资企业</option>
							    <option value="国有企业" >&nbsp;&nbsp;&nbsp;&nbsp;国有企业 </option>
							    <option value="集体企业" >&nbsp;&nbsp;&nbsp;&nbsp;集体企业 </option>
							    <option value="股份合作企业" >&nbsp;&nbsp;&nbsp;&nbsp;股份合作企业</option>
							    <option value="联营企业" >&nbsp;&nbsp;&nbsp;&nbsp;联营企业</option>
							    <option value="有限责任公司" >&nbsp;&nbsp;&nbsp;&nbsp;有限责任公司</option>
							    <option value="股份有限公司" >&nbsp;&nbsp;&nbsp;&nbsp;股份有限公司 </option>
							    <option value="私营企业" >&nbsp;&nbsp;&nbsp;&nbsp;私营企业</option>
							    <option value="其他企业" >&nbsp;&nbsp;&nbsp;&nbsp;其他企业 </option>
							               
							    <option value="港、澳、台商投资企业" >港、澳、台商投资企业  </option>
							    <option value="合资经营企业(港或澳、台资)" >&nbsp;&nbsp;&nbsp;&nbsp;合资经营企业(港或澳、台资) </option>
							    <option value="合作经营企业(港或澳、台资)" >&nbsp;&nbsp;&nbsp;&nbsp;合作经营企业(港或澳、台资) </option>
							    <option value="港、澳、台商独资经营企业" >&nbsp;&nbsp;&nbsp;&nbsp;港、澳、台商独资经营企业 </option>
							    <option value="港、澳、台商投资股份有限公司" >&nbsp;&nbsp;&nbsp;&nbsp;港、澳、台商投资股份有限公司   </option>
							    
							    <option value="外商投资企业" >外商投资企业  </option>
							    <option value="中外合资经营企业" >&nbsp;&nbsp;&nbsp;&nbsp;中外合资经营企业 </option>
							    <option value="中外合作经营企业" >&nbsp;&nbsp;&nbsp;&nbsp;中外合作经营企业  </option>
							    <option value="外资企业" >&nbsp;&nbsp;&nbsp;&nbsp;外资企业 </option>
							    <option value="外商投资股份有限公司" >&nbsp;&nbsp;&nbsp;&nbsp;外商投资股份有限公司</option>
           					</select>
						</td>
					</tr>
					<tr>
						<td><label for="name">注册资金(万):</label></td>
						<td><input class="inp" type="text" name="regMoney" /></td>
					</tr>
					<tr>
						<td><label for="uid">统一社会信用代码:</label></td>
						<td style="color:red"><input id="organization" class="inp" type="text" name="organization" placeholder="请输入统一社会信用代码"/><span>*必须填写，且为18位</span></td>
					</tr>
					<tr>
						<td><label for="uid">公司类型:</label></td>
						<td>
							<select name="type">
							    <option value="建筑公司" >建筑公司</option>
							    <option value="劳务公司" >劳务公司</option>
							    <option value="设计公司" >设计公司</option>
							    <option value="监理公司" >监理公司</option>
							    <option value="审图公司" >审图公司</option>
							    <option value="其他" >其他</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label for="name">负责人:</label></td>
						<td style="color:red"><input class="inp" type="text" name="leaderName" placeholder="请输入负责人姓名" /></td>
					</tr>
					<tr>
						<td><label for="gender">负责人手机号:</label></td>
						<td style="color:red"><input id="UserId" class="inp" type="text" name="userId" placeholder="请输入负责人电话" /><span>*必须填写</span></td>
					</tr>
					<tr>
						<td><label for="province">省份:</label></td>
						<td><select id="province" onchange="setCity(this.value);getArea();" name="province" style="width: 96px" runat="server" >
                              <option value="${province}" selected="selected">--请选择省份--</option>
                    		</select></td>
				</tr>
				<tr>
						<td><label for="city">城市:</label></td>
						<td><select id="city" onchange="setCounty(this.value);getArea();" name="city" style="width: 96px" runat="server">
                              <option value="${city}" selected="selected">--请选择城市--</option>
                            </select></td>
				</tr>
				
				<tr>
					<td><label for="street">详细地址:</label></td>
					<td><input class="inp" type="text" name="street" /></td>
				</tr>
					
					<tr>
						<td></td>
						<td><button class="add">添加</button></td>
					</tr>
				</table>
				
				</div>
				
				<div class="footer clearfix">
				
				</div>
				
				
			</div>
		</div>
		</form>
	</body>
	<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/area.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="resource/js/company_add_check.js" charset="utf-8"></script>
	<script src="resource/js/input.js" type="text/javascript" charset="utf-8"></script>

</html>


