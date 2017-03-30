package com.fengyun.web.db.playermodel;

import java.util.Date;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;
import mmo.common.utils.DateStringUtils;

/**
 * 法律保险
 * @author 13794
 *
 */
public class LawInsuModel implements BaseIdModel {
	
	private String id;
	private String title;    //标题
	private int lawtype;    //类型   1-金融保险，2-法律咨询  
	private Date createTime = new Date();// 创建时间
	private String note;     //记录
	private String createTimeStr;

	
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(5);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("title", this.title);
		obj.put("lawtype", this.lawtype);
		obj.put("note", this.note);
		obj.put("createTime", this.createTime);
		return obj;
	}
	
	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.title = result.getString("title");
		this.lawtype = result.getInt("lawtype", 0);
		this.note = result.getString("note");
		this.createTime = (Date)result.get("createTime");
				
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLawtype() {
		return lawtype;
	}

	public void setLawtype(int lawtype) {
		this.lawtype = lawtype;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeStr() {
		return DateStringUtils.format(this.createTime);
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
