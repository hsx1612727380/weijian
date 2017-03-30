package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.RewardsAndPunishModel;
import com.mongodb.BasicDBObject;
/**
 * 
 * @author zheng
 *
 */
public class RewardsAndPunishDAO {

	/** 公共sql **/
	private static final String tableName = Tables.RewardsAndPunish;
	
	/**
	 * 添加一条记录
	 * @param model
	 */
	public static void insert(RewardsAndPunishModel model){
		MongoDBManager.insert(tableName, model);
	}
	
	/**
	 * 查询得到一条记录
	 * @param queryObj
	 * @return
	 */
	public static RewardsAndPunishModel getByModel(BasicDBObject queryObj){
		RewardsAndPunishModel model = MongoDBManager.findOne(tableName, queryObj);
		return model;
	}
	
	/**
	 * 查询所有记录列表
	 * @param queryObj
	 * @return
	 */
	public static List<RewardsAndPunishModel> getListByQueryObj(BasicDBObject queryObj){
		List<RewardsAndPunishModel> list = MongoDBManager.find(tableName, queryObj);
		return list;
	}
	
	/**
	 * 通过id删除一条记录
	 * @param id
	 * @return
	 */
	public static boolean deleteById(String id){
		return MongoDBManager.delete(tableName, id, null);
	}
	
}
