package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;




import com.fengyun.web.db.playermodel.EquipmentTradModel;
import com.mongodb.BasicDBObject;

public class EquipmentTradDAO {
	/** 公共sql **/
	private static final String tableName = Tables.EquipmentTrad;

	public static List<EquipmentTradModel> getAll(BasicDBObject queryObj,
			int row, int skip) {
		List<EquipmentTradModel> models = MongoDBManager.find(tableName,queryObj,row,skip);
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
	public synchronized static void insert(EquipmentTradModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	
	/**
	 *根据项目id和设备商id查询
	 * @param code
	 * @return
	 */
	public static List<EquipmentTradModel> getByEId(String pId, String eId) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("pId", pId);
		queryObj.put("eId", eId);
		List<EquipmentTradModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}
	
	
	

}
