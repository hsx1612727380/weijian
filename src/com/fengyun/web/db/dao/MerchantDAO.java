package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.BaseIdModel;
import mmo.common.data.db.MongoDBManager;

import org.bson.types.ObjectId;


import com.fengyun.web.db.playermodel.MerchantModel;
import com.mongodb.BasicDBObject;

public class MerchantDAO {

	/** 公共sql **/
	private static final String tableName = Tables.Merchant;
	
	
	/**
	 * 查询某项目
	 * @param id
	 * @return
	 */
	public static MerchantModel getByTypeAndCode(int type,String code) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("type", type);
		queryObj.put("code", code);
		
		return MongoDBManager.findOne(tableName, queryObj);
	}
	/**
	 * 查询某供应商诚信档案信息
	 * @param id
	 * @return
	 */
	public static MerchantModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(MerchantModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	/**
	 * 获得所有项目
	 * @param id
	 * @return
	 */
	public static List<MerchantModel> getAll(BasicDBObject queryObj,int row,int skip) {
		List<MerchantModel> models = MongoDBManager.find(tableName,queryObj,row,skip);//
		return models;
	}
	
	public static long countAll(BasicDBObject queryObj){
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
	 * 更新保存model
	 * 
	 * @param model
	 */
	public static boolean update(MerchantModel model) {
		return MongoDBManager.update(tableName, model);
	}
	
	/**
	 * 更新部分字段
	 * @param id
	 * @param playerId
	 * @param fieldObj
	 * @return
	 */
	public static void update(String id, BasicDBObject fieldObj) {
		MongoDBManager.updateFields(tableName, id, fieldObj,null);
	}
	
	/**
	 * 根据一个查询对象获取到一个诚信档案记录
	 * @param queryObj
	 * @return
	 */
	public static MerchantModel getByQueryObj(BasicDBObject queryObj) {
		// TODO Auto-generated method stub
		MerchantModel model = MongoDBManager.findOne(tableName, queryObj);
		return model;
	}
	
	

}
