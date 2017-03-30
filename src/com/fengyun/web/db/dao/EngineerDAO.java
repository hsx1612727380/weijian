package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import org.bson.types.ObjectId;

import com.fengyun.web.db.playermodel.EngineerModel;
import com.mongodb.BasicDBObject;

public class EngineerDAO {
	/** 公共sql **/
	private static final String tableName = Tables.Engineer;
	
	public static List<EngineerModel> getByCode(String code,int row, int skip) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("code", code);
		List<EngineerModel> models = MongoDBManager.find(tableName,queryObj,row,skip);//
		return models;
	}

	/**
	 *根据公司id查询
	 * @param 
	 * @return
	 */
	public static List<EngineerModel> getByCode(String code) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("code", code);
		
		List<EngineerModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}
	
	/**
	 *根据公司id查询
	 * @param 
	 * @return
	 */
	public static List<EngineerModel> getByUserId(String userId) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("userId", userId);
		
		List<EngineerModel> models = MongoDBManager.find(tableName, queryObj);
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
	public synchronized static void insert(EngineerModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public static EngineerModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	
	/**
	 * 更新保存model
	 * 
	 * @param model
	 */
	public static boolean update(EngineerModel model) {
		return MongoDBManager.update(tableName, model);
	}

	/**
	 * 查询所有注册人员信息
	 * @param queryObj
	 * @return
	 */
	public static List<EngineerModel> getPNameList(BasicDBObject queryObj) {
		List<EngineerModel> list = MongoDBManager.find(tableName, queryObj);
		return list;
	}
	
	/**
	 * 校验手机号是否被注册
	 * @param userId
	 * @return
	 */
	public static EngineerModel mobilRepCHeck(String mobilPhone) {
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("userId", mobilPhone);
		return MongoDBManager.findOne(tableName, fieldObj);
	}
	

}
