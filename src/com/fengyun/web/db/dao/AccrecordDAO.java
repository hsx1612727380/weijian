package com.fengyun.web.db.dao;

import java.util.List;

import org.bson.types.ObjectId;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.AccrecordModel;
import com.mongodb.BasicDBObject;

public class AccrecordDAO {
	
	
	/** 公共sql **/
	private static final String tableName = Tables.Accrecord;
	
	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(AccrecordModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	/**
	 * 获得所有项目
	 * @param id
	 * @return
	 */
	public static List<AccrecordModel> getAll(BasicDBObject queryObj,int row,int skip) {
		List<AccrecordModel> models = MongoDBManager.find(tableName,queryObj,row,skip);//
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
	public static boolean update(AccrecordModel model) {
		return MongoDBManager.update(tableName, model);
	}
	
	
	/**
	 * 查询某个人员出入记录
	 */
	public static AccrecordModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	
	/**
	 * 查询某一个项目的人员出入记录
	 */
	public static List<AccrecordModel> getBypCode(String pCode) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("pCode", pCode);
		
		List<AccrecordModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}

	/**
	 * 新增
	 * @param accrecordModel
	 * @return
	 */
	public static boolean addAccrecord(AccrecordModel accrecordModel) {
		return MongoDBManager.insert(tableName, accrecordModel);
	}

	/**
	 * 根据查询条件查询出入记录
	 * @param queryObj
	 * @return
	 */
	public static List<AccrecordModel> getList(BasicDBObject queryObj) {
		return MongoDBManager.find(tableName, queryObj);
	}


}
