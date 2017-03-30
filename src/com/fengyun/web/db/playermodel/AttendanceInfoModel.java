package com.fengyun.web.db.playermodel;

import java.util.Date;

import mmo.common.data.db.BaseIdModel;

import org.bson.types.ObjectId;

import com.fengyun.web.util.DateStringUtils;
import com.mongodb.BasicDBObject;

/**
 * 考勤信息
 * 
 * @author wangqi
 * 
 */

public class AttendanceInfoModel implements BaseIdModel {

	private String id;
	private String pCode; // 项目编号
	private String name; // 姓名
	private String userId;// 手机号
	private String code; // 班组编号
	private Date startDate;// 开始时间
	private Date endDate; // 结束时间
	private int confirm;// 是否确认 1.已确认 ，0.未确认
	private double workTime;// 工时
	//
	private String pName;// 项目名称
	private String tName;// 班组名称

	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(5);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("pCode", this.pCode);
		obj.put("name", this.name);
		obj.put("userId", this.userId);
		obj.put("startDate", this.startDate);
		obj.put("endDate", this.endDate);
		obj.put("confirm", this.confirm);
		obj.put("workTime", this.workTime);
		obj.put("code", this.code);
		obj.put("pName", this.pName);
		obj.put("tName", this.tName);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.pCode = result.getString("pCode");
		this.tName = result.getString("tName");
		this.confirm = result.getInt("confirm");
		this.code = result.getString("code");
		this.pName = result.getString("pName");
		this.name = result.getString("name");
		this.userId = result.getString("userId");
		this.startDate = (Date) result.get("startDate");
		this.endDate = (Date) result.get("endDate");
		this.workTime = (Double) result.get("workTime");
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getConfirm() {
		return confirm;
	}

	public void setConfirm(int confirm) {
		this.confirm = confirm;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getWorkTime() {
		return workTime;
	}

	public void setWorkTime(double workTime) {
		this.workTime = workTime;
	}

	public String getStartDateStr() {
		if(this.startDate != null)
			return DateStringUtils.format(this.startDate);
		return  "";
	}

	public String getEndDateStr() {
		if(this.endDate != null)
			return DateStringUtils.format(this.endDate);
		return  "";
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

}
