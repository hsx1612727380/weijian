package com.fengyun.web.db.playermodel;

import java.util.Date;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;
import mmo.common.utils.DateStringUtils;

/**
 * 消息Model
 * @author hsx
 *
 */
public class MessageModel implements BaseIdModel {

	private String id;
	private String receiveUserId; // 接受者的UserId
	private String receiveUserType; // 接受者的类型：0-用户(工人或班组长)，1-材料商，2-设备商，3-公司负责人，4-项目负责人
	private String sendUserId; // 发送者的UserId
	private String sendUserName; // 发送者的UserName
	private String sendUserType; // 发送者的类型：0-用户(工人或班组长)，1-材料商，2-设备商，3-公司负责人，4-项目负责人
	private Date createTime; // 创建消息的时间
	private String createTimeStr;
	private String messageTitle; // 消息标题
	private String messageInfo; // 消息内容
	private String isRead; // 消息是否已读：0-未读，1-已读（系统消息和收到消息）
	private String isAdmin; // 是后台管理员给用户发送的还是前台用户给用户发送的：后台管理员给用户发送的-0，前台用户给用户发送的-1
	private String isFeedback; // 反馈信息:0-开始的显示，有链接进去的，1-反馈的后信息
	
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(20);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("receiveUserId", this.receiveUserId);
		obj.put("receiveUserType", this.receiveUserType);
		obj.put("sendUserId", this.sendUserId);
		obj.put("sendUserName", this.sendUserName);
		obj.put("sendUserType", this.sendUserType);
		obj.put("createTime", this.createTime);
		obj.put("messageTitle", this.messageTitle);
		obj.put("messageInfo", this.messageInfo);
		obj.put("isRead", this.isRead);
		obj.put("isAdmin", this.isAdmin);
		obj.put("isFeedback", this.isFeedback);
		return obj;
	}
	
	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.receiveUserId = result.getString("receiveUserId");
		this.receiveUserType = result.getString("receiveUserType");
		this.sendUserId = result.getString("sendUserId");
		this.sendUserName = result.getString("sendUserName");
		this.sendUserType = result.getString("sendUserType");
		this.createTime = (Date) result.get("createTime");
		this.messageTitle = result.getString("messageTitle");
		this.messageInfo = result.getString("messageInfo");
		this.isRead = result.getString("isRead");
		this.isAdmin = result.getString("isAdmin");
		this.isFeedback = result.getString("isFeedback");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReceiveUserId() {
		return receiveUserId;
	}

	public void setReceiveUserId(String receiveUserId) {
		this.receiveUserId = receiveUserId;
	}

	public String getReceiveUserType() {
		return receiveUserType;
	}

	public void setReceiveUserType(String receiveUserType) {
		this.receiveUserType = receiveUserType;
	}

	public String getSendUserId() {
		return sendUserId;
	}

	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}
	
	public String getSendUserName() {
		return sendUserName;
	}
	
	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}

	public String getSendUserType() {
		return sendUserType;
	}

	public void setSendUserType(String sendUserType) {
		this.sendUserType = sendUserType;
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
	
	public String getMessageTitle() {
		return messageTitle;
	}
	
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}
	
	public String getIsAdmin() {
		return isAdmin;
	}
	
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getIsFeedback() {
		return isFeedback;
	}

	public void setIsFeedback(String isFeedback) {
		this.isFeedback = isFeedback;
	}
	
}
