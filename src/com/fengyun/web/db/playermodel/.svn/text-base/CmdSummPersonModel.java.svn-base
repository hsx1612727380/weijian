package com.fengyun.web.db.playermodel;

import java.util.Date;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;

/**
 * 个人明细表
 * 
 * @author mayu
 * 
 */
public class CmdSummPersonModel implements BaseIdModel {

	private String id;
	private String cmdId;// 汇总ID
	private String pId;  //项目ID
	private String tId;// 班组ID
	private String name; //工人名字
	private String pName;// 项目名称
	private String userId;// 手机号
	private String account;// 支付账户
	private String voucher;// 支付凭证
	private String inTime;// 进场时间
	private String outTime;// 退场时间
	private String safe;// 是否安全教育
	private String attendance;// 考勤记录
	private String access;// 出入记录
	private int teamtype; // 班组类型
	private int year; // 年
	private int month; // 月
	private String identity; // 身份证号
	private String workContent;// 工作内容
	private int count;// 次数
	private int salary;// 应发工资
	private int deduct;// 扣款
	private int realSalary;// 实发工资
	private int noSalary;// 未付工资
	private String flag;// 是否签名
	private String note;// 备注
	private Date createTime = new Date();

	// ///////////////////////////
	private String drawee; // 付款人
	private int paytype; // 支付方式：1-支付宝 ， 2-微信， 3-银行卡，4-现金
	private String payTime; // 发放日期
	

	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(23);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("cmdId", this.cmdId);
		obj.put("pId", this.pId);
		obj.put("name", this.name);
		obj.put("userId", this.userId);
		obj.put("account", this.account);
		obj.put("voucher", this.voucher);
		obj.put("inTime", this.inTime);
		obj.put("outTime", this.outTime);
		obj.put("safe", this.safe);
		obj.put("attendance", this.attendance);
		obj.put("access", this.access);
		obj.put("workContent", this.workContent);
		obj.put("count", this.count);
		obj.put("salary", this.salary);
		obj.put("deduct", this.deduct);
		obj.put("realSalary", this.realSalary);
		obj.put("noSalary", this.noSalary);
		obj.put("flag", this.flag);
		obj.put("note", this.note);
		obj.put("createTime", this.createTime);
		obj.put("year", this.year);
		obj.put("month", this.month);
		obj.put("identity", this.identity);
		obj.put("teamtype", this.teamtype);
		obj.put("drawee", this.drawee);
		obj.put("paytype", this.paytype);
		obj.put("payTime", this.payTime);
		obj.put("tId", this.tId);
		obj.put("pName", this.pName);

		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.cmdId = result.getString("cmdId");
		this.pId = result.getString("pId");
		this.name = result.getString("name");
		this.userId = result.getString("userId");
		this.account = result.getString("account");
		this.voucher = result.getString("voucher");

		this.inTime = result.getString("inTime");
		this.outTime = result.getString("outTime");
		this.year = result.getInt("year");
		this.month = result.getInt("month");
		this.safe = result.getString("safe");
		this.attendance = result.getString("attendance");
		this.access = result.getString("access");
		this.workContent = result.getString("workContent");
		this.count = result.getInt("count", 0);
		this.salary = result.getInt("salary", 0);
		this.deduct = result.getInt("deduct", 0);
		this.realSalary = result.getInt("realSalary", 0);
		this.noSalary = result.getInt("noSalary", 0);
		this.flag = result.getString("flag");
		this.note = result.getString("note");
		this.createTime = (Date) result.get("createTime");
		this.identity = result.getString("identity");
		this.teamtype = result.getInt("teamtype", 0);
		this.tId = result.getString("tId");
		this.paytype = result.getInt("paytype", 0);
		this.payTime = result.getString("payTime");
		this.drawee = result.getString("drawee");
		this.pName = result.getString("pName");
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public int getTeamtype() {
		return teamtype;
	}

	public void setTeamtype(int teamtype) {
		this.teamtype = teamtype;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCmdId() {
		return cmdId;
	}

	public void setCmdId(String cmdId) {
		this.cmdId = cmdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getVoucher() {
		return voucher;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getSafe() {
		return safe;
	}

	public void setSafe(String safe) {
		this.safe = safe;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getDeduct() {
		return deduct;
	}

	public void setDeduct(int deduct) {
		this.deduct = deduct;
	}

	public int getRealSalary() {
		return realSalary;
	}

	public void setRealSalary(int realSalary) {
		this.realSalary = realSalary;
	}

	public int getNoSalary() {
		return noSalary;
	}

	public void setNoSalary(int noSalary) {
		this.noSalary = noSalary;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDrawee() {
		return drawee;
	}

	public void setDrawee(String drawee) {
		this.drawee = drawee;
	}

	public int getPaytype() {
		return paytype;
	}

	public void setPaytype(int paytype) {
		this.paytype = paytype;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

}
