package com.fengyun.web.db.playermodel;

import java.util.Date;

import mmo.common.data.db.BaseIdModel;
import mmo.common.utils.DateStringUtils;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

/**
 * 公告消息
 * @author hsx
 *
 */
public class NoticeModel implements BaseIdModel {
	
	private String id;
	private Date beginTime; // 公告消息有效开始时间
	private Date endTime; // 公告消息有效结束时间
	private String noticeTitle; // 公告消息标题
	private String noticeInfo; // 公告消息内容
	private Date createTime; // 公告消息的创建时间
	private String createTimeStr;
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(20);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("beginTime", this.beginTime);
		obj.put("endTime", this.endTime);
		obj.put("noticeTitle", this.noticeTitle);
		obj.put("noticeInfo", this.noticeInfo);
		obj.put("createTime", this.createTime);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.beginTime = (Date) result.get("beginTime");
		this.endTime = (Date) result.get("endTime");
		this.noticeTitle = result.getString("noticeTitle");
		this.noticeInfo = result.getString("noticeInfo");
		this.createTime = (Date) result.get("createTime");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}
	
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	
	public String getNoticeInfo() {
		return noticeInfo;
	}

	public void setNoticeInfo(String noticeInfo) {
		this.noticeInfo = noticeInfo;
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
	
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	
}
