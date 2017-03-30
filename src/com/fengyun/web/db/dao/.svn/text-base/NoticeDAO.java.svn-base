package com.fengyun.web.db.dao;

import java.util.List;

import org.bson.types.ObjectId;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.LawInsuModel;
import com.fengyun.web.db.playermodel.NoticeModel;
import com.mongodb.BasicDBObject;

/**
 * 公告消息DAO层
 * @author hsx
 *
 */
public class NoticeDAO {

	/** 公共sql **/
	private static final String tableName = Tables.Notice;
	
	/**
	 * 新增
	 * @param noticeModel
	 * @return
	 */
	public static boolean addNotice(NoticeModel noticeModel) {
		return MongoDBManager.insert(tableName, noticeModel);
	}

	/**
	 * 获取所有的公告消息
	 * @return
	 */
	public static List<NoticeModel> getAllList() {
		return MongoDBManager.find(tableName);
	}

	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public static NoticeModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return  MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 分页查询
	 * @param queryObj
	 * @param row
	 * @param skip
	 * @return
	 */
	public static List<NoticeModel> getAll(BasicDBObject queryObj,
			int row, int skip) {
		List<NoticeModel> models = MongoDBManager.find(tableName,queryObj,row,skip);
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
