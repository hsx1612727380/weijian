package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.CommentsModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.mongodb.BasicDBObject;

public class CommentsDAO {

	/** 公共sql **/
	private static final String tableName = Tables.Comments;
	
	/**
	 * 获得所有评价
	 * @param id
	 * @return
	 */
	public static List<CommentsModel> getAll(BasicDBObject queryObj) {
		List<CommentsModel> models = MongoDBManager.find(tableName,queryObj);//
		return models;
	}
	
	public static long countAll(BasicDBObject queryObj){
		return MongoDBManager.getCount(tableName,queryObj);
	}
	
	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(CommentsModel model) {
		MongoDBManager.insert(tableName, model);
	}

	/**
	 * 根据班组的ID、项目的ID和班组的类型查询评论信息
	 * @param queryObj
	 * @return
	 */
	public static CommentsModel getByVidAndPidAndType(BasicDBObject queryObj) {
		CommentsModel commentsModel = MongoDBManager.findOne(tableName, queryObj);
		return commentsModel;
	}

	/**
	 * 根据班组的ID获取记录数
	 * @param vId
	 * @return
	 */
	public static List<CommentsModel> getListByVId(String vId) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("cId", vId);
		List<CommentsModel> commentsModels = MongoDBManager.find(tableName, queryObj);
		return commentsModels;
	}

	/**
	 * 删除一条信息
	 * @param id
	 * @return
	 */
	public static boolean deleteById(String id){
		return MongoDBManager.delete(tableName, id, null);
	}
}
