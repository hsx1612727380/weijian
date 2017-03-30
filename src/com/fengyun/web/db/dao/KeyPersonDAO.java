package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import org.bson.types.ObjectId;

import com.fengyun.web.db.playermodel.KeyPersonModel;
import com.mongodb.BasicDBObject;

public class KeyPersonDAO {
	private static final String tableName = Tables.KeyPerson;

	/**
	 * 根据公司代码查询
	 * 
	 * @param
	 * @return
	 */
	public static List<KeyPersonModel> getBypCode(String pCode) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("pCode", pCode);

		List<KeyPersonModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public static void delete(String id) {
		MongoDBManager.delete(tableName, id, null);
	}

	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(KeyPersonModel model) {
		MongoDBManager.insert(tableName, model);
	}

	/**
	 * 查询
	 * 
	 * @param id
	 * @return
	 */
	public static KeyPersonModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 更新保存model
	 * 
	 * @param model
	 */
	public static boolean update(KeyPersonModel model) {
		return MongoDBManager.update(tableName, model);
	}

	/**
	 * 根据公司编号代码和关键人员岗位的手机号判断该手机是否被注册
	 * 
	 * @param code
	 * @param phone
	 * @return
	 */
	public static KeyPersonModel getKeyPersonByPCodeAndPhone(String code,
			String phone) {
		BasicDBObject fieldObj = new BasicDBObject(3);
		fieldObj.put("pCode", code);
		fieldObj.put("phone", phone);
		return MongoDBManager.findOne(tableName, fieldObj);
	}

	/**
	 * 校验手机号是否被注册
	 * 
	 * @param phone
	 * @return
	 */
	public static Object mobilRepCHeck(String phone) {
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("phone", phone);
		return MongoDBManager.findOne(tableName, fieldObj);
	}

}
