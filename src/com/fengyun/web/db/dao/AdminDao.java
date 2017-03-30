package com.fengyun.web.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.AdminModel;
import com.fengyun.web.db.playermodel.CompanyModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.mongodb.BasicDBObject;

public class AdminDao {

	/** 公共sql **/
	private static final String tableName = Tables.Admin;
	
	
	/**
	 * 查询某项目
	 * @param id
	 * @return
	 */
	public static AdminModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", id);
		return MongoDBManager.findOne(tableName, queryObj);
	}
	/**
	 * 查询用户名是否存在
	 * @param id
	 * @return
	 */
	public static AdminModel findUsername(String accountName) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("accountName", accountName);
		return MongoDBManager.findOne(tableName, queryObj);
	}
	/**
	 * 查询id
	 * @param id
	 * @return
	 */
	public static AdminModel findAdminById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	/**
	 * 查询密码
	 * @param id
	 * @return
	 */
	public static AdminModel findPassword(String accountName, String password) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("accountName", accountName);
		queryObj.put("password", password);
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(AdminModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	/**
	 * 插入管理员
	 * 
	 * @param model
	 */
	public synchronized static void addAdmin(AdminModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	/**
	 * 获得所有项目
	 * @param id
	 * @return
	 */
	public static List<ProjectModel> getAll(int row,int skip) {
		List<ProjectModel> models = MongoDBManager.find(tableName,null,row,skip);//
		return models;
	}

	/**
	 * 删除管理员
	 * @param id
	 * @return
	 */
	public static void delAdmin(String id) {
		MongoDBManager.delete(tableName, id, null);
	}
	public static AdminModel searchAdminByName(String name) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("name", name);
		return MongoDBManager.findOne(tableName, queryObj);
	}

	public static List<AdminModel> listAdmin(int row,int skip) {
		// TODO Auto-generated method stub
		List<AdminModel> listAdmin = MongoDBManager.find(tableName,null,row,skip);//
		return listAdmin;
	}
	public static void updateAdmin(AdminModel admin) {
		// TODO Auto-generated method stub
		MongoDBManager.update(tableName, admin);
		
	}
	public static long countAllAdmin(BasicDBObject queryObj) {
		return MongoDBManager.getCount(tableName,queryObj);
	}
	public static List<AdminModel> getAdminList(BasicDBObject queryObj,int skip, int pageSize) {
		return MongoDBManager.find(tableName, queryObj,pageSize, skip) ;
	}
	
	
	/**
	 * 通过accountName和password查询得到一个company对象
	 * @param accountName
	 * @param password
	 * @return
	 */
	public static AdminModel getModelByAccountNameAndPassword(String accountName, String password){
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("accountName", accountName);
		queryObj.put("password", password);
		AdminModel theAdmin = MongoDBManager.findOne(tableName, queryObj);
		return theAdmin;
	}
	
	
	public static AdminModel getByAccountName(String accountName) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("accountName", accountName);
		AdminModel model = MongoDBManager.findOne(tableName, queryObj);
		return model;
	}
}
