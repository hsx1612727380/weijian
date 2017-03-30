package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import org.bson.types.ObjectId;


import com.fengyun.web.db.playermodel.BehaviorModel;
import com.mongodb.BasicDBObject;

public class BehaviorDAO {
	/** 公共sql **/
	private static final String tableName = Tables.Behavior;
	
	/**
	 * 根据公司代号查询某一公司的所有行为
	 */
	public static List<BehaviorModel> getBycode(String code){
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("code", code);
		
		List<BehaviorModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
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
	public synchronized static void insert(BehaviorModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	
	/**
	 * 查询一条行为
	 * @param id
	 * @return
	 */
	public static BehaviorModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	
	/**
	 * 更新保存model
	 * 
	 * @param model
	 */
	public static boolean update(BehaviorModel model) {
		return MongoDBManager.update(tableName, model);
	}

}
