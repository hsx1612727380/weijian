package com.fengyun.web.db.playermodel;

import java.util.Date;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;

/**
 * 公告消息是否被读取
 * @author hsx
 *
 */
public class NoticeLogModel implements BaseIdModel  {

	private String id;
	private String userId; // 用户的ID： 用户(工人或班组长)、材料商、设备商、公司负责人、项目负责人
	private String noticeId; // 公告的ID
	private Date readTime; // 用户读取的时间
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(20);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("userId", this.userId);
		obj.put("noticeId", this.noticeId);
		obj.put("readTime", this.readTime);
		return obj;
	}
	
	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.userId = result.getString("userId");
		this.noticeId = result.getString("noticeId");
		this.readTime = (Date) result.get("readTime");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public Date getReadTime() {
		return readTime;
	}
	
	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}
	
}
