package com.fengyun.web.db.playermodel;

import java.util.Date;

import org.bson.types.ObjectId;

import com.fengyun.web.util.DateStringUtils;
import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;

/**
 * 工资发放记录
 * 
 * @author 13794
 * 
 */
public class PayrollRecordModel implements BaseIdModel {

	private String id;
	private String pCode; // 项目编号
	private String name; // 姓名
	private String userId;// 手机号
	private String code; // 班组编号
	private String startTime;// 开始时间
	private String endTime; // 结束时间
	private int salary;// 应发工资
	private int realSalary;// 实发工资
	private int noSalary;// 未付工资
	private int tax; // 税款
	private String drawee; // 付款人
	private int paytype; // 支付方式：1-支付宝 ， 2-微信， 3-银行卡，4-现金
	private String serial; // 流水号
	private int confirm;// 是否确认 1.确认 ，2.没确认
	private Date payTime;// 发放时间
	private String payAccont; //收付款账号 银行卡账号、支付宝账号、微信号等
	
	//
	private String pName;// 项目名称
	private String tName;// 班组名称
	private String imageName;// 附件图片名称

	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(5);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("name", this.name);
		obj.put("userId", this.userId);
		obj.put("startTime", this.startTime);
		obj.put("endTime", this.endTime);
		obj.put("confirm", this.confirm);
		obj.put("payTime", this.payTime);
		obj.put("code", this.code);
		obj.put("pCode", this.pCode);
		obj.put("salary", this.salary);
		obj.put("realSalary", this.realSalary);
		obj.put("noSalary", this.noSalary);
		obj.put("drawee", this.drawee);
		obj.put("paytype", this.paytype);
		obj.put("serial", this.serial);
		obj.put("tax", this.tax);
		obj.put("pName", this.pName);
		obj.put("tName", this.tName);
		obj.put("imageName", this.imageName);
		obj.put("payAccont", this.payAccont);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.name = result.getString("name");
		this.userId = result.getString("userId");
		this.code = result.getString("code");
		this.payTime = (Date) result.get("payTime");
		this.confirm = result.getInt("confirm", 0);
		this.startTime = result.getString("startTime");
		this.endTime = result.getString("endTime");
		this.pCode = result.getString("pCode");
		this.serial = result.getString("serial");
		this.drawee = result.getString("drawee");
		this.salary = result.getInt("salary", 0);
		this.realSalary = result.getInt("realSalary", 0);
		this.noSalary = result.getInt("noSalary", 0);
		this.paytype = result.getInt("paytype", 0);
		this.tax = result.getInt("tax", 0);
		this.pName = result.getString("pName");
		this.tName = result.getString("tName");
		this.payAccont = result.getString("payAccont");
		this.imageName = result.getString("imageName");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getName() {
		return name;
	}

	public String getImageName()
	{
		return imageName;
	}

	public void setImageName(String imageName)
	{
		this.imageName = imageName;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
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

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public int getConfirm() {
		return confirm;
	}

	public void setConfirm(int confirm) {
		this.confirm = confirm;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	
	public String getPayTimeStr() {
		if(this.payTime != null)
			return DateStringUtils.format(this.payTime);
		return "";
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String getPayAccont() {
		return payAccont;
	}

	public void setPayAccont(String payAccont) {
		this.payAccont = payAccont;
	}
}
