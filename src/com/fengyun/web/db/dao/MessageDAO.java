package com.fengyun.web.db.dao;

import java.util.List;

import org.bson.types.ObjectId;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.MessageModel;
import com.fengyun.web.db.playermodel.NoticeModel;
import com.mongodb.BasicDBObject;

/**
 * 一对一消息DAO层
 * @author hsx
 *
 */
public class MessageDAO {

	/** 公共sql **/
	private static final String tableName = Tables.Message;

	/**
	 * 新增
	 * @param messageModel
	 * @return
	 */
	public static boolean addMessage(MessageModel messageModel) {
		return MongoDBManager.insert(tableName, messageModel);
	}

	/**
	 * 根据发送者和接受者的UserId(手机号)删除
	 * @param sUserId
	 * @param rUserId
	 * @return
	 */
	public static boolean delMessage(String id) {
		return MongoDBManager.delete(tableName, id, null);
	}

	/**
	 * 根据发送者和接受者的UserId(手机号)查询
	 * @param sUserId
	 * @param rUserId
	 * @return
	 */
	public static MessageModel getByUserIds(String sUserId, String rUserId) {
		BasicDBObject fieldObj = new BasicDBObject(3);
		fieldObj.put("sendUserId", sUserId);
		fieldObj.put("receiveUserId", rUserId);
		return MongoDBManager.findOne(tableName, fieldObj);
	}

	/**
	 * 根据接受者的UserId(手机号)和是否已读查询 
	 * @param receiveUserId
	 * @param isRead
	 * @return
	 */
	public static List<MessageModel> getAllListByRUserIdAndIsRead(
			String receiveUserId, String isRead) {
		BasicDBObject fieldObj = new BasicDBObject(3);
		fieldObj.put("receiveUserId", receiveUserId);
		fieldObj.put("isRead", isRead);
		return MongoDBManager.find(tableName, fieldObj);
	}

	/**
	 * 根据接受者的UserId(手机号)查询 
	 * @param receiveUserId
	 * @return
	 */
	public static List<MessageModel> getAllListByRUserId(String receiveUserId) {
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("receiveUserId", receiveUserId);
		return MongoDBManager.find(tableName, fieldObj);
	}

	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public static MessageModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 修改
	 * @param messageModel
	 * @return
	 */
	public static boolean updateMessage(MessageModel messageModel) {
		return MongoDBManager.update(tableName, messageModel);
	}
	
	/**
	 * 分页查询
	 * @param queryObj
	 * @param row
	 * @param skip
	 * @return
	 */
	public static List<MessageModel> getAll(BasicDBObject queryObj,
			int row, int skip) {
		List<MessageModel> models = MongoDBManager.find(tableName,queryObj,row,skip);
		return models;
	}
	
	/**
	 * 查询每页条数
	 * @param queryObj
	 * @return
	 */
	public static long countAll(BasicDBObject queryObj) {
		return MongoDBManager.getCount(tableName,queryObj);
	}
	
	
	
}
