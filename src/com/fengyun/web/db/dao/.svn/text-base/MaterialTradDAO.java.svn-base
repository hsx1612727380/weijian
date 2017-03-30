package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;



import com.fengyun.web.db.playermodel.MaterialTradModel;
import com.mongodb.BasicDBObject;

public class MaterialTradDAO {
	/** 公共sql **/
	private static final String tableName = Tables.MaterialTrad;
	

	public static List<MaterialTradModel> getAll(BasicDBObject queryObj,
			int row, int skip) {
		List<MaterialTradModel> models = MongoDBManager.find(tableName,queryObj,row,skip);
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
	public synchronized static void insert(MaterialTradModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	
	/**
	 *根据项目id和材料商id查询
	 * @param code
	 * @return
	 */
	public static List<MaterialTradModel> getByMId(String pId, String mId) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("pId", pId);
		queryObj.put("mId", mId);
		List<MaterialTradModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}

}
