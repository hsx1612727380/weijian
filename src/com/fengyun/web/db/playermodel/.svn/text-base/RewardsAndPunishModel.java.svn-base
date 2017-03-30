package com.fengyun.web.db.playermodel;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;

public class RewardsAndPunishModel  implements BaseIdModel {
	
	private String id;
	private String pId;//项目Id
	private int type ; //0--个人，1--班组
	private String code;//班组编号
	private String teamName;//班组名称
	private String name ;//(type=0时 ) 工人姓名,(type=1时) 班组长姓名
	private String userId;//联系方式
	private String character;//性质
	private String measure;//措施（奖惩措施）
	
	@Override
	public BasicDBObject getBasicDBObject() {
		// TODO Auto-generated method stub
		BasicDBObject obj = new BasicDBObject(8);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("pId", this.pId);
		obj.put("type", this.type);
		obj.put("code", this.code);
		obj.put("teamName", this.teamName);
		obj.put("name", this.name);
		obj.put("userId", this.userId);
		obj.put("character", this.character);
		obj.put("measure", this.measure);
		return obj;
	}
	
	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.pId = result.getString("pId");
		this.type = result.getInt("type");
		this.code = result.getString("code");
		this.teamName = result.getString("teamName");
		this.name = result.getString("name");
		this.userId = result.getString("userId");
		this.character = result.getString("character");
		this.measure = result.getString("measure");
	}
	
	@Override
	public String getId() {
		return id;
	}
	@Override
	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}
	
}
