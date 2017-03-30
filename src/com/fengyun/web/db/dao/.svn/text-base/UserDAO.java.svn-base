package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.KeyPersonModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.mongodb.BasicDBObject;

public class UserDAO {

	public final static String FLAG_SEPARATOR = "_";

	/** 公共sql **/
	private static final String tableName = Tables.User;

	static {
		
	}

	/**
	 * 是否放置内存
	 * @param userId
	 * @param put2Mem
	 * @return
	 */
	public static UserModel getByUserId(String userId) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("userId", userId);
		UserModel model = MongoDBManager.findOne(tableName, queryObj);
		return model;
	}

	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(UserModel model) {
		MongoDBManager.insert(tableName, model);
	}

	/**
	 * 更新保存model
	 * 
	 * @param model
	 */
	public static boolean update(UserModel model) {
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

	public static void updateStatus(UserModel model) {
		//生产json格式
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("userStatus", model.getUserStatus());
		
		update(model.getId(), fieldObj);
	}

	

	/**
	 * 获取所有角色model
	 * 
	 * @param userId
	 * @return
	 */
	public static List<UserModel> getAll(int row ,int skip) {
		List<UserModel> models = MongoDBManager.find(tableName,null, row, skip);//
		return models;
	}

	public static List<UserModel> listAdmin(int row, int skip) {
		// TODO Auto-generated method stub
		List<UserModel> listUser = MongoDBManager.find(tableName,null,row,skip);//
		return listUser;
	}

	public static void addUser(UserModel userModel) {
		// TODO Auto-generated method stub
		MongoDBManager.insert(tableName, userModel);
	}

	public static UserModel mobilRepCHeck(String mobilPhone) {
		// TODO Auto-generated method stub
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("userId",mobilPhone);
		return MongoDBManager.findOne(tableName, fieldObj);
	}

	public static UserModel checkLogonByPhone(String userId, String password) {
		// TODO Auto-generated method stub
		BasicDBObject fieldObj = new BasicDBObject(3);
		fieldObj.put("userId",userId);
		fieldObj.put("userPassword",password);
		UserModel user = MongoDBManager.findOne(tableName, fieldObj);
		return user;
	}
	
	//根据身份证号和电话号码查找用户
	public static UserModel getUserByUseridAndIdentity(String identity, String userId) {
		// TODO Auto-generated method stub
		BasicDBObject fieldObj = new BasicDBObject(3);
		fieldObj.put("userId",userId);
		fieldObj.put("userIdentity",identity);
		UserModel user = MongoDBManager.findOne(tableName, fieldObj);
		return user;
	}
	
	/**
	 * 根据身份证号获取用户
	 * @param userIdentity
	 * @param password
	 * @return
	 */
	public static UserModel getUserByIdentity(String identity) {
		// TODO Auto-generated method stub
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("userIdentity",identity);
		UserModel user = MongoDBManager.findOne(tableName, fieldObj);
		return user;
	}
	
	public static UserModel checkLogonByIdentity(String userIdentity, String password) {
		// TODO Auto-generated method stub
		BasicDBObject fieldObj = new BasicDBObject(3);
		fieldObj.put("userIdentity",userIdentity);
		fieldObj.put("userPassword",password);
		UserModel user = MongoDBManager.findOne(tableName, fieldObj);
		return user;
	}
	

	/**
	 * 获得所有用户
	 * @param id
	 * @return
	 */
	public static List<UserModel> getAll(BasicDBObject queryObj,int row,int skip) {
		List<UserModel> models = MongoDBManager.find(tableName, queryObj, row, skip);//
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

	public static void updateUserType(UserModel model) {
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("userType", model.getUserType());
		
		update(model.getId(), fieldObj);
	}
	
	/**
	 * 根据查询条件获得所有个人
	 * 
	 * @param id
	 * @return
	 */
	public static List<UserModel> getByQueryObj(BasicDBObject queryObj) {
		List<UserModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}

	public static UserModel getByIdentity(String identity) {
		// TODO Auto-generated method stub
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("identity",identity);
		UserModel user = MongoDBManager.findOne(tableName, fieldObj);
		return user;
	}

}