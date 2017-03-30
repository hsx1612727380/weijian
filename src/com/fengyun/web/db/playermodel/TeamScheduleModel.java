package com.fengyun.web.db.playermodel;

import java.util.Date;

import mmo.common.data.db.BaseIdModel;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

/**
 * 项目下的班组工作任务进度表
 * @author zheng
 *
 */
public class TeamScheduleModel implements BaseIdModel{

	private String id;
	private String pId;		//项目id
	private String tId;		//班组id(往数据库添加记录时，到ProjectDepartmentNodel中查询出加入该项目的班组的集合（name），共项目操作愿选择)
	private String teamName; //班组名称
	private String type;	//0-施工班组 1-材料班组 2-设备班组
	private double price;	// 合同价
	private double prepaid;	// 预付款
	private int times; 		// 次数
	
	private double thisPay;		//本次付
	private double addupPay;	//累计付
	private double paid;		//已付付
	private double remainPay;	//未付
	
	private int allWork; // 总任务量
	private int thisWork; // 本次工程量
	private int accoutWork; // 累计工作量
	private String progress;// 进度百分比
	//进度百分比  = (String)NumberFormat.getPercentInstance().setMaximumFractionDigits(2).format(累计工作量/总工程量 )
	private String balance;	// 结算情况
	private Date storageTime;// 存档日期
	private String desc;	//备注
	//
	private String unit; 	//单位
	
	@Override
	public BasicDBObject getBasicDBObject() {
		// TODO Auto-generated method stub
		BasicDBObject obj = new BasicDBObject(20);
		if(id!=null)
			obj.put("_id",new ObjectId(this.id));
		obj.put("pId", this.pId);
		obj.put("tId", this.tId);
		obj.put("teamName", this.teamName);
		obj.put("type", this.type);
		obj.put("price", this.price);
		obj.put("prepaid", this.prepaid);
		obj.put("times", this.times);
		obj.put("thisPay", this.thisPay);
		obj.put("addupPay", this.addupPay);
		obj.put("paid", this.paid);
		obj.put("remainPay", this.remainPay);
		obj.put("allWork", this.allWork);
		obj.put("thisWork", this.thisWork);
		obj.put("accoutWork", this.accoutWork);
		obj.put("progress", this.progress);
		obj.put("balance", this.balance);
		obj.put("storageTime", this.storageTime);
		obj.put("desc", this.desc);
		obj.put("unit", this.unit);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		// TODO Auto-generated method stub
		this.id = result.getString("_id");
		this.pId = result.getString("pId");
		this.teamName = result.getString("teamName");
		this.tId = result.getString("tId");
		this.type = result.getString("type");
		this.price = result.getDouble("price");
		this.prepaid = result.getDouble("prepaid");
		this.times = result.getInt("times");
		this.thisPay = result.getDouble("thisPay");
		this.addupPay = result.getDouble("addupPay");
		this.paid = result.getDouble("paid");
		this.remainPay = result.getDouble("remainPay");
		this.allWork = result.getInt("allWork");
		this.thisWork = result.getInt("thisWork");
		this.accoutWork = result.getInt("accoutWork");
		this.progress = result.getString("progress");
		this.balance = result.getString("balance");
		this.storageTime = (Date) result.get("storageTime");
		this.desc = result.getString("desc");
		this.unit = result.getString("unit");
	}
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrepaid() {
		return prepaid;
	}

	public void setPrepaid(double prepaid) {
		this.prepaid = prepaid;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public double getThisPay() {
		return thisPay;
	}

	public void setThisPay(double thisPay) {
		this.thisPay = thisPay;
	}

	public double getAddupPay() {
		return addupPay;
	}

	public void setAddupPay(double addupPay) {
		this.addupPay = addupPay;
	}

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}

	public double getRemainPay() {
		return remainPay;
	}

	public void setRemainPay(double remainPay) {
		this.remainPay = remainPay;
	}

	public Integer getAllWork() {
		return allWork;
	}

	public void setAllWork(Integer allWork) {
		this.allWork = allWork;
	}

	public int getThisWork() {
		return thisWork;
	}

	public void setThisWork(int thisWork) {
		this.thisWork = thisWork;
	}

	public int getAccoutWork() {
		return accoutWork;
	}

	public void setAccoutWork(int accoutWork) {
		this.accoutWork = accoutWork;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public Date getStorageTime() {
		return storageTime;
	}

	public void setStorageTime(Date storageTime) {
		this.storageTime = storageTime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
