package com.fengyun.web.db.playermodel;



import org.bson.types.ObjectId;


import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;

/*
 * 参建单位
 */
public class JoinBuildModel implements BaseIdModel {
	
	private String id;   
	private String pCode;    //项目代号
	private String jType;     //单位类型
	private String jName;     //单位名称
	private String jNum;      //组织机构代码
	private String leaderphone;   //公司负责人电话
	
	
	
	
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(5);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("pCode", this.pCode);
		obj.put("jType", this.jType);
		obj.put("jName", this.jName);
		obj.put("jNum", this.jNum);
		obj.put("leaderphone", this.leaderphone);
		
		return obj;
	}
	
	
	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.pCode = result.getString("pCode");
		this.jType = result.getString("jType");
		this.jName = result.getString("jName");
		this.jNum = result.getString("jNum");
		this.leaderphone = result.getString("leaderphone");
		
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


	public String getjType() {
		return jType;
	}


	public void setjType(String jType) {
		this.jType = jType;
	}


	public String getjName() {
		return jName;
	}


	public void setjName(String jName) {
		this.jName = jName;
	}


	public String getjNum() {
		return jNum;
	}


	public void setjNum(String jNum) {
		this.jNum = jNum;
	}


	public String getLeaderphone() {
		return leaderphone;
	}


	public void setLeaderphone(String leaderphone) {
		this.leaderphone = leaderphone;
	}

}
