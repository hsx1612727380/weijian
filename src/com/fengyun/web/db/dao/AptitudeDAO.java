package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import org.bson.types.ObjectId;

import com.fengyun.web.db.playermodel.AptitudeModel;
import com.mongodb.BasicDBObject;

public class AptitudeDAO {
	/** 公共sql **/
	private static final String tableName = Tables.Aptitude;

	/**
	 *根据公司id查询
	 * @param 
	 * @return
	 */
	public static List<AptitudeModel> getByCode(String code) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("code", code);
		
		List<AptitudeModel> models = MongoDBManager.find(tableName, queryObj);
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
	public synchronized static void insert(AptitudeModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public static AptitudeModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	
	/**
	 * 更新保存model
	 * 
	 * @param model
	 */
	public static boolean update(AptitudeModel model) {
		return MongoDBManager.update(tableName, model);
	}


	/**
	 * 查询所有资质（资信信息）
	 * @param queryObj
	 * @return
	 */
	public static List<AptitudeModel> getPNameList(BasicDBObject queryObj) {
		List<AptitudeModel> list = MongoDBManager.find(tableName, queryObj);
		return list;
	}

}
