package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.NoticeLogModel;
import com.mongodb.BasicDBObject;

/**
 * 公告消息是否被读取DAO层
 * @author hsx
 *
 */
public class NoticeLogDAO {
	
	/** 公共sql **/
	private static final String tableName = Tables.NoticeLog;

	/**
	 * 新增
	 * @param noticeLogModel
	 * @return
	 */
	public static boolean addNoticeLog(NoticeLogModel noticeLogModel) {
		return MongoDBManager.insert(tableName, noticeLogModel);
	}

	/**
	 * 根据用户的UserID(手机号)
	 * @param userId
	 * @return
	 */
	public static List<NoticeLogModel> getListByUserId(String userId) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("userId", userId);
		return MongoDBManager.find(tableName, queryObj);
	}

	/**
	 * 根据公告的ID和用户的userID(手机号)查询
	 * @param noticeId
	 * @param userId
	 * @return
	 */
	public static NoticeLogModel getByNoticeIdAndUserId(String noticeId,
			String userId) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("noticeId", noticeId);
		queryObj.put("userId", userId);
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 更新
	 * @param noticeLogModel
	 * @return
	 */
	public static boolean updateNoticeLog(NoticeLogModel noticeLogModel) {
		return MongoDBManager.update(tableName, noticeLogModel);
	}

	
}
