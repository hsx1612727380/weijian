	package com.fengyun.web.db.playermodel;

import java.util.Date;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;

/**
 * 班组成员
 * 
 * @author wangqi
 * 
 */
public class TeamMemberModel implements BaseIdModel {

	private String id;
	private String tId;// 对应teammodel的id
	private String userId;// 用户ID
	private Date createTime = new Date();//
	private int status;// 1-申请中 2-邀请中 3-已加入 4 -已结束或离开
	private int backbone;    //是否是骨干班组成员 ：0-不是，1-是
	
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(23);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("tId", this.tId);
		obj.put("userId", this.userId);
		obj.put("createTime", this.createTime);
		obj.put("status", this.status);
		obj.put("backbone", this.backbone);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.tId = result.getString("tId");
		this.userId = result.getString("userId");
		this.createTime = (Date) result.get("createTime");
		this.status = result.getInt("status", 0);
		this.backbone = result.getInt("backbone", 0);
	}
	public int getBackbone() {
		return backbone;
	}

	public void setBackbone(int backbone) {
		this.backbone = backbone;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
