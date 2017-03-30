package com.fengyun.web.db.playermodel;

import java.util.Date;

import mmo.common.data.db.BaseIdModel;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
/**
 * 工程进度表
 * @author zheng
 *
 */
public class ProjectProgressModel implements BaseIdModel {

	private String id;
	private String pId;		//项目id
	private String unit; // 单位工程	
	private String unitPer; // 单位
	private int allWork; // 总工程量
	private int thisWeek; // 本周完成
	private int accoutWork; // 累计完成
	private String progress;// 进度百分比（计算得出）
	private String plan;// 下期计划百分比  （添加时直接填写）
	//进度百分比  = (String)NumberFormat.getPercentInstance().setMaximumFractionDigits(2).format(累计工作量/总工程量 )
	private Date storageTime;// 存档日期
	private String desc;	 //备注
	
	@Override
	public BasicDBObject getBasicDBObject() {
		// TODO Auto-generated method stub
		BasicDBObject obj = new BasicDBObject(20);
		if(id!=null)
			obj.put("_id",new ObjectId(this.id));
		obj.put("pId", this.pId);
		obj.put("unit", this.unit);
		obj.put("unitPer", this.unitPer);
		obj.put("allWork", this.allWork);
		obj.put("thisWeek", this.thisWeek);
		obj.put("accoutWork", this.accoutWork);
		obj.put("progress", this.progress);
		obj.put("plan", this.plan);
		obj.put("storageTime", this.storageTime);
		obj.put("desc", this.desc);
		return obj;
	}
	
	@Override
	public void toModel(BasicDBObject result) {
		// TODO Auto-generated method stub
		this.id = result.getString("_id");
		this.pId = result.getString("pId");
		this.unit = result.getString("unit");
		this.unitPer = result.getString("unitPer");
		this.allWork = result.getInt("allWork");
		this.thisWeek = result.getInt("thisWeek");
		this.accoutWork = result.getInt("accoutWork");
		this.progress = result.getString("progress");
		this.plan = result.getString("plan");
		this.storageTime = (Date) result.get("storageTime");
		this.desc = result.getString("desc");
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id= id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getUnitPer() {
		return unitPer;
	}

	public void setUnitPer(String unitPer) {
		this.unitPer = unitPer;
	}

	public int getAllWork() {
		return allWork;
	}

	public void setAllWork(int allWork) {
		this.allWork = allWork;
	}

	public int getThisWeek() {
		return thisWeek;
	}

	public void setThisWeek(int thisWeek) {
		this.thisWeek = thisWeek;
	}

	public int getAccoutWork() {
		return accoutWork;
	}

	public void setAccoutWork(int accoutWork) {
		this.accoutWork = accoutWork;
	}

	/**
	 * 进度百分比是由 累计工作量和总工作量计算转换成百分比字符串的
	 * @return
	 */
	public String getProgress() {
//		float progre = accoutWork / allWork;
//		NumberFormat numPercent = NumberFormat.getPercentInstance();
//		numPercent.setMinimumFractionDigits(2);//保留两位小数
//		String progress = numPercent.format(progre);
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
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

	

}
