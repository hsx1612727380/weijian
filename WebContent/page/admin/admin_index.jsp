<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="resource/css/silder.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resource/css/form.css" />
	</head>

<body>
		<div class="layout clearfix">
			<div class="nav">
				<h1>乐建平台后台系统</h1>
					<span>
                       	 登录id：<a>${accountName}</a>
                        <a href="backgroundlogout.html">登出</a>
                    </span>
			</div>
			<div class="bodyleft">
				<ul id="accordion" class="accordion">
					<li id='datashow' data-show="${adminpopedom}">
						<div class="link"><i class="fa fa-paint-brush"></i>公司管理<i class="fa fa-chevron-down"></i></div>
						<ul class="submenu">
							<li>
								<a href="company_list.html?pageNow=1&pageSize=20&dataCount=0">公司列表</a>
							</li>
							<li>
								<a href="company_add.html">新增公司</a>
							</li>
						</ul>
						<div class="link"><i class="fa fa-paint-brush"></i>项目管理<i class="fa fa-chevron-down"></i></div>
						<ul class="submenu">
							<li>
								<a href="project_list.html?pageNow=1&pageSize=20&dataCount=0">项目列表</a>
							</li>
							<li>
								<a href="project_add.html">新增项目</a>
							</li>
						</ul>
						<div class="link"><i class="fa fa-paint-brush"></i>班组管理<i class="fa fa-chevron-down"></i></div>
						<ul class="submenu">
							<li>
								<a href="team_list.html?pageNow=1&pageSize=20&dataCount=0">班组列表</a>
							</li>
							<li>
								<a href="team_add.html">新增班组</a>
							</li>
						</ul>
						<div class="link"><i class="fa fa-paint-brush"></i>材料商管理<i class="fa fa-chevron-down"></i></div>
						<ul class="submenu">
							<li>
								<a href="material_list.html?pageNow=1&pageSize=20&dataCount=0">材料商列表</a>
							</li>
							<li>
								<a href="material_add.html">新增材料商</a>
							</li>
							<li>
								<a href="materialTrad_list.html?pageNow=1&pageSize=20&dataCount=0">材料商出入库记录</a>
							</li>
							<li>
								<a href="materialTrad_add.html">新增材料商出入库记录</a>
							</li>
						</ul>
						<div class="link"><i class="fa fa-paint-brush"></i>设备商管理<i class="fa fa-chevron-down"></i></div>
						<ul class="submenu">
							<li>
								<a href="equipment_list.html?pageNow=1&pageSize=20&dataCount=0">设备商列表</a>
							</li>
							<li>
								<a href="equipment_add.html">新增设备商</a>
							</li>
							<li>
								<a href="equipmentTrad_list.html?pageNow=1&pageSize=20&dataCount=0">设备商出入库记录</a>
							</li>
							<li>
								<a href="equipmentTrad_add.html">新增设备商出入库记录</a>
							</li>
						</ul>
						<div class="link"><i class="fa fa-paint-brush"></i>诚信档案<i class="fa fa-chevron-down"></i></div>
						<ul class="submenu">
							<li>
								<a href="merchant_list.html?pageNow=1&pageSize=20&dataCount=0">供应商诚信档案列表</a>
							</li>
							<li>
								<a href="merchant_add.html">新增供应商诚信档案</a>
							</li>
							<li>
								<a href="teamCredit_list.html?pageNow=1&pageSize=20&dataCount=0">班组诚信档案列表</a>
							</li>
							<li>
								<a href="teamCredit_add.html">新增班组诚信档案</a>
							</li>
							<li>
								<a href="person_list.html?pageNow=1&pageSize=20&dataCount=0">个人诚信档案列表</a>
							</li>
							<li>
								<a href="person_add.html">新增个人诚信档案</a>
							</li>
						</ul>
						<div class="link"><i class="fa fa-paint-brush"></i>考勤和人员出入管理<i class="fa fa-chevron-down"></i></div>
						<ul class="submenu">
							<li>
								<a href="attendanceInfo_list.html?pageNow=1&pageSize=20&dataCount=0">考勤信息列表</a>
							</li>
							<li>
								<a href="attendanceInfo_add.html">新增考勤记录</a>
							</li>
							<li>
								<a href="accrecord_list.html?pageNow=1&pageSize=20&dataCount=0">人员出入记录列表</a>
							</li>
							<li>
								<a href="accrecord_add.html">新增人员出入记录</a>
							</li>
						</ul>
						<div class="link"><i class="fa fa-paint-brush"></i>工资发放管理<i class="fa fa-chevron-down"></i></div>
						<ul class="submenu">
							<li>
								<a href="payrollrecord_list.html?pageNow=1&pageSize=20&dataCount=0">工资发放列表</a>
							</li>
							<li>
								<a href="payrollrecord_add.html">新增工资发放记录</a>
							</li>
						</ul>
						<div class="link"><i class="fa fa-paint-brush"></i>用户管理<i class="fa fa-chevron-down"></i></div>
						<ul class="submenu">
							<li>
								<a href="user_list.html?pageNow=1&pageSize=20&dataCount=0">用户列表</a>
							</li>
							<li>
								<a href="user_add.html">添加用户</a>
							</li>
						</ul>
						<div class="link"><i class="fa fa-paint-brush"></i>招聘<i class="fa fa-chevron-down"></i></div>
						<ul class="submenu">
							<li>
								<a href="recruit_person_list.html">个人招聘</a>
							</li>
							<li>
								<a href="recruit_team_list.html">招聘班组</a>
							</li>
							<li>
								<a href="recruit_material_list.html">材料采购</a>
							</li>
							<li>
								<a href="recruit_equip_list.html">设备租赁</a>
							</li>
						</ul>
						<div class="link"><i class="fa fa-paint-brush"></i>求职<i class="fa fa-chevron-down"></i></div>
						<ul class="submenu">
							<li>
								<a href="job_person_list.html">个人求职</a>
							</li>
							<li>
								<a href="job_team_list.html">班组求职</a>
							</li>
							<li>
								<a href="job_material_list.html">材料供应</a>
							</li>
							<li>
								<a href="job_equip_list.html">设备供应</a>
							</li>
						</ul>
						<div class="link"><i class="fa fa-paint-brush"></i>管理员管理<i class="fa fa-chevron-down"></i></div>
						<ul class="submenu">
							<li>
								<a href="listAdmin.html?pageNow=1&pageSize=20&dataCount=0">查看管理员</a>
							</li>
							<li>
								<a href="admin_addForm.html">添加管理员	</a>
							</li>
						</ul>
						<div class="link"><i class="fa fa-paint-brush"></i>招标/行业动态<i class="fa fa-chevron-down"></i></div>
						<ul class="submenu">
							<li>
								<a href="bidInfo_list.html?pageNow=1&pageSize=20&dataCount=0">招标/行业动态列表</a>
							</li>
							<li>
								<a href="bidInfo_add.html">添加招标/行业动态</a>
							</li>
						</ul>
						<div class="link"><i class="fa fa-paint-brush"></i>法律咨询与保险<i class="fa fa-chevron-down"></i></div>
						<ul class="submenu">
							<li>
								<a href="lawInsu_list.html?pageNow=1&pageSize=20&dataCount=0">查看列表</a>
							</li>
							<li>
								<a href="lawInsu_add.html">添加咨询或保险</a>
							</li>
						</ul>
						<div class="link"><i class="fa fa-paint-brush"></i>消息与公告<i class="fa fa-chevron-down"></i></div>
						<ul class="submenu">
							<li>
								<a href="notice_list.html?pageNow=1&pageSize=20&dataCount=0">查看公告列表</a>
							</li>
							<li>
								<a href="notice_add.html">发布公告</a>
							</li>
							<li>
								<a href="message_list.html?pageNow=1&pageSize=20&dataCount=0">查看消息列表</a>
							</li>
							<li>
								<a href="message_add.html">发布消息</a>
							</li>
						</ul>
						<div class="link"><i class="fa fa-paint-brush"></i>管理员个人信息及权限<i class="fa fa-chevron-down"></i></div>
						<ul class="submenu">
							<li>
								<a href="checkAdmin.html?id=${adminId}">查看及修改个人资料</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="bodyright">
				<iframe src="admin_right.html" border="0" frameborder="0"></iframe>
			</div>
		</div>
	</body>

<script src="resource/js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="resource/js/silder.js" type="text/javascript" charset="utf-8"></script>
<script src="resource/js/main.js" type="text/javascript" charset="utf-8"></script>
<script>
	var showlist=$('#datashow').data('show').trim().split(',');
	$('#datashow div').hide();
	for(var i=0;i<showlist.length;i++){
		$('#datashow div').eq(showlist[i]*1-1).show();
	}
</script>