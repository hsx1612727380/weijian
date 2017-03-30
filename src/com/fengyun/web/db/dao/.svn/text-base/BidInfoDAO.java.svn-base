package com.fengyun.web.db.dao;

import java.util.List;

import org.bson.types.ObjectId;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.BidInfoModel;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.mongodb.BasicDBObject;

public class BidInfoDAO {
	/** 公共sql **/
	private static final String tableName = Tables.BidInfo;

	public static List<BidInfoModel> getAll(BasicDBObject queryObj,
			int row, int skip) {
		List<BidInfoModel> models = MongoDBManager.find(tableName,queryObj,row,skip);
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
	public synchronized static void insert(BidInfoModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	
	/**
	 * 查询招标信息
	 * @param id
	 * @return
	 */
	public static BidInfoModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	
	/**
	 * 更新保存model
	 * 
	 * @param model
	 */
	public static boolean update(BidInfoModel model) {
		return MongoDBManager.update(tableName, model);
	}

}
