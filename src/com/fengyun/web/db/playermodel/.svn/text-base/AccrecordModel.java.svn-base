package com.fengyun.web.db.playermodel;

import java.util.Date;

import org.bson.types.ObjectId;

import com.fengyun.web.util.DateStringUtils;
import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;

/**
 * 人员出入记录
 * 
 * @author 13794
 * 
 */
public class AccrecordModel implements BaseIdModel {

	private String id;
	private String pCode; // 项目编号
	private String name; // 姓名
	private String userId;// 手机号
	private String code; // 班组编号
	private Date recordTime;// 打卡时间
	private int confirm;// 是否确认 1.确认 ，2.没确认
	private int type; // 出入类型 0-进场 1=退场
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
		obj.put("recordTime", this.recordTime);
		obj.put("confirm", this.confirm);
		obj.put("type", this.type);
		obj.put("code", this.code);
		obj.put("pName", this.pName);
		obj.put("tName", this.tName);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.pCode = result.getString("pCode");
		this.name = result.getString("name");
		this.userId = result.getString("userId");
		this.code = result.getString("code");
		this.recordTime = (Date) result.get("recordTime");
		this.confirm = result.getInt("confirm");
		this.type = result.getInt("type");
		this.pName = result.getString("pName");
		this.tName = result.getString("tName");
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

	public Date getRecordTime() {
		return recordTime;
	}
	
	public String getRecordTimeStr() {
		if(this.recordTime != null)
			return DateStringUtils.format(this.recordTime);
		return "";
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public int getConfirm() {
		return confirm;
	}

	public void setConfirm(int confirm) {
		this.confirm = confirm;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
