package com.fengyun.web.db.playermodel;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;
/**
 * 注册工程师
 * @author 13794
 *
 */
public class EngineerModel implements BaseIdModel {
	
	
	
	//注册人员
	private String id;
	private String userId;    //手机号
	private String code;     //公司代号
	private String name;     //注册人员姓名
	private String type;      //注册类别
	private String registration;      //注册编号
	
	////////////////////////////////////////////////
	//新增字段
	private String certificateorgan;    //发证机关
	private String issuancedate;   //签发日期
	private String effectivedate;  //有效日期 
	
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(5);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("code", this.code);
		obj.put("name", this.name);
		obj.put("type", this.type);
		obj.put("userId", this.userId);
		obj.put("registration", this.registration);
		obj.put("certificateorgan", this.certificateorgan);
		obj.put("issuancedate", this.issuancedate);
		obj.put("effectivedate", this.effectivedate);
		
		return obj;
	}
	
	
	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.code = result.getString("code");
		this.name = result.getString("name");
		this.type = result.getString("type");
		this.userId = result.getString("userId");
		this.registration = result.getString("registration");
		this.certificateorgan = result.getString("certificateorgan");
		this.issuancedate = result.getString("issuancedate");
		this.effectivedate = result.getString("effectivedate");
		
		
	}


	public String getCertificateorgan() {
		return certificateorgan;
	}


	public void setCertificateorgan(String certificateorgan) {
		this.certificateorgan = certificateorgan;
	}


	public String getIssuancedate() {
		return issuancedate;
	}


	public void setIssuancedate(String issuancedate) {
		this.issuancedate = issuancedate;
	}


	public String getEffectivedate() {
		return effectivedate;
	}


	public void setEffectivedate(String effectivedate) {
		this.effectivedate = effectivedate;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getRegistration() {
		return registration;
	}


	public void setRegistration(String registration) {
		this.registration = registration;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
