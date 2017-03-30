package com.fengyun.web.db.playermodel;

import java.util.Date;

import mmo.common.data.db.BaseIdModel;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

public class AdminModel implements BaseIdModel {
	public String id;
	public String accountName;// 登录ID
	public String password;// 密码,MD5
	public String name;// 真实姓名
	public String mobile;// 联系手机号
	public String popedom;// 管理员权限,用逗号隔开,例如1,3,5,11表示有权限1和3和5
	public String address;  //管理员地址
	public String type;    //   2.不是超级管理员
	public Date createTime;//注册时间
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(7);
		if (id!= null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("accountName", this.accountName); 
		obj.put("password", this.password);
		obj.put("name", this.name);
		obj.put("mobile", this.mobile);
		obj.put("popedom", this.popedom);
		obj.put("createTime", this.createTime);
		obj.put("type", this.type);
		return obj;
	}
	


	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.accountName = result.getString("accountName");
		this.password = result.getString("password");
		this.name = result.getString("name");	
		this.mobile = result.getString("mobile");	
		this.popedom = result.getString("popedom");
		this.type = result.getString("type");
		this.createTime = (Date)result.get("createTime");
	}
		// TODO Auto-generated method stub
		
	
	

	@Override
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getaccountName() {
		return accountName;
	}


	public void setaccountName(String accountName) {
		this.accountName = accountName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAccountName() {
		return accountName;
	}



	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}



	public Date getCreateTime() {
		return createTime;
	}



	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getPopedom() {
		return popedom;
	}


	public void setPopedom(String popedom) {
		this.popedom = popedom;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
