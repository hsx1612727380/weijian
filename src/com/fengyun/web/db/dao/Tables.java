package com.fengyun.web.db.dao;

/**
 * 数据库表名
 * 
 */
public class Tables {

	public static final int PAGENUM = 20;// 默认每页显示20行数据
	/** 用户数据表 **/
	public static final String User = "User";
	/** 考勤信息表 **/
	public static final String AttendanceInfo = "AttendanceInfo";
	/** 材料（设备）汇总表 **/
	public static final String CmdSumm = "CmdSumm";
	/** 设备商信息表 **/
	public static final String Equipment = "Equipment";
	/** 材料商信息表 **/
	public static final String Material = "Material";
	/** 班组表 **/
	public static final String Team = "Team";
	/** 班组成员表 **/
	public static final String TeamMember = "TeamMember";
	/** 材料（设备）商诚信档案表 **/
	public static final String Merchant = "Merchant";
	/** 登录表 **/
	public static final String Admin = "Admin";
	/** 项目表 **/
	public static final String Project = "Project";
	/** 项目工程下班组及供应商管理 */
	public static final String ProjectDepartment = "ProjectDepartment";
	/** 公司 */
	public static final String Company = "Company";
	/** 个人诚信档案 */
	public static final String Person = "Person";
	/** 班组诚信档案 */
	public static final String TeamCredit = "TeamCredit";
	/** 评价表 */
	public static final String Comments = "Comments";
	/** 用工需求表 */
	public static final String Requirements = "Requirements";
	/**汇总个人明细表*/
	public static final String CmdSummPerson = "CmdSummPerson";
	/**汇总供应商明细表*/
	public static final String CmdSummSupplier = "CmdSummSupplier";
	/**材料商出入库记录*/
	public static final String MaterialTrad = "MaterialTrad";
	/**设备商出入库记录*/
	public static final String EquipmentTrad = "EquipmentTrad";
	/**招标信息*/
	public static final String BidInfo = "BidInfo";
	/**企业资质*/
	public static final String Aptitude = "Aptitude";
	/**注册人员*/
	public static final String Engineer = "Engineer";
	/**法律保险*/
	public static final String LawInsu = "LawInsu";
	/**参建单位*/
	public static final String JoinBuild = "JoinBuild";
	/**关键岗位人员*/
	public static final String KeyPerson = "KeyPerson";
	/**人员出入记录*/
	public static final String Accrecord = "Accrecord";
	/**工资发放记录*/
	public static final String PayrollRecord = "PayrollRecord";
	/**公司行为*/
	public static final String Behavior = "Behavior";
	/**项目奖惩( 班组、个人) 表*/
	public static final String RewardsAndPunish = "RewardsAndPunish";
	/**项目进度 表-班组进度*/
	public static final String TeamSchedule = "TeamSchedule";
	/**项目进度 表-各项工程进度*/
	public static final String ProjectProgress = "ProjectProgress";
	/**项目花名册表*/
	public static final String ProjectRoster = "ProjectRoster";
	/**项目合同管理*/
	public static final String ProjectCompact = "ProjectCompact";
	/**公司合同管理*/
	public static final String CompanyCompact = "CompanyCompact";
	/**一对一消息*/
	public static final String Message = "Message";
	/**公告消息*/
	public static final String Notice = "Notice";
	/**公告消息是否被读取*/
	public static final String NoticeLog = "NoticeLog";
}
