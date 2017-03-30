package com.fengyun.web.db.playermodel;



import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;


/**
 * 公司行为
 * @author 13794
 *
 */
public class BehaviorModel implements BaseIdModel {
	
	private String id;  
	private String code;  //公司编号
	private String title;     //标题
	private int type;    //行为类型:1.良好行为，2.不良行为，3.欠薪行为
	private String behaviorTime;    //行为时间
	private String content;      //行为内容
	
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(5);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("title", this.title);
		obj.put("code", this.code);
		obj.put("type", this.type);
		obj.put("behaviorTime", this.behaviorTime);
		obj.put("content", this.content);
		return obj;
	}
	
	
	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.title = result.getString("title");
		this.code = result.getString("code");
		this.type = result.getInt("type", 0);
		this.behaviorTime = result.getString("behaviorTime");
		this.content = result.getString("content");
				
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getBehaviorTime() {
		return behaviorTime;
	}


	public void setBehaviorTime(String behaviorTime) {
		this.behaviorTime = behaviorTime;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	
	

}
