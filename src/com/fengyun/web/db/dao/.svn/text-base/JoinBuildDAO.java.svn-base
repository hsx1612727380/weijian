package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import org.bson.types.ObjectId;


import com.fengyun.web.db.playermodel.JoinBuildModel;
import com.mongodb.BasicDBObject;

public class JoinBuildDAO {
	private static final String tableName = Tables.JoinBuild;
	
	
	/**
	 *根据公司代码查询
	 * @param 
	 * @return
	 */
	public static List<JoinBuildModel> getBypCode(String pCode) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("pCode", pCode);
		
		List<JoinBuildModel> models = MongoDBManager.find(tableName, queryObj);
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
	public synchronized static void insert(JoinBuildModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public static JoinBuildModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	
	/**
	 * 更新保存model
	 * 
	 * @param model
	 */
	public static boolean update(JoinBuildModel model) {
		return MongoDBManager.update(tableName, model);
	}


	/**
	 * 校验手机号是否被注册
	 * @param userId
	 * @return
	 */
	public static Object mobilRepCHeck(String mobilPhone) {
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("leaderphone", mobilPhone);
		return MongoDBManager.findOne(tableName, fieldObj);
	}


	/**
	 * 根据公司编号代码和项目参建单位的手机号判断该手机是否被注册
	 * @param code
	 * @param leaderphone
	 * @return
	 */
	public static JoinBuildModel getJoinBuildByPCodeAndLeaderPhone(String code,
			String leaderphone) {
		BasicDBObject fieldObj = new BasicDBObject(3);
		fieldObj.put("pCode", code);
		fieldObj.put("leaderphone", leaderphone);
		return MongoDBManager.findOne(tableName, fieldObj);
	}

}
