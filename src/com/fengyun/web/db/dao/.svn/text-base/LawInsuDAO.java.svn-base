package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import org.bson.types.ObjectId;


import com.fengyun.web.db.playermodel.LawInsuModel;
import com.mongodb.BasicDBObject;

public class LawInsuDAO {
	/** 公共sql **/
	private static final String tableName = Tables.LawInsu;

	public static List<LawInsuModel> getAll(BasicDBObject queryObj,
			int row, int skip) {
		List<LawInsuModel> models = MongoDBManager.find(tableName,queryObj,row,skip);
		return models;
	}
	
	public static long countAll(BasicDBObject queryObj) {
		
		return MongoDBManager.getCount(tableName,queryObj);
	}
	
	
	
	/**
	 * 删除
	 * @param id
	 */
	public static void delete(String id){
		MongoDBManager.delete(tableName, id, null);
	}
	
	
	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(LawInsuModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	
	/**
	 * 查询法律保险
	 * @param id
	 * @return
	 */
	public static LawInsuModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	
	/**
	 * 更新保存model
	 * 
	 * @param model
	 */
	public static boolean update(LawInsuModel model) {
		return MongoDBManager.update(tableName, model);
	}
	
	/**
	 * 获得某类型信息
	 * @param lawtype
	 * @return
	 */
	public static List<LawInsuModel> getListByType(int lawtype) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("lawtype", lawtype);
		return MongoDBManager.find(tableName,queryObj);
	}

}
