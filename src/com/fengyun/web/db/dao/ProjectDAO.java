package com.fengyun.web.db.dao;

import java.util.List;
import java.util.regex.Pattern;

import mmo.common.data.db.MongoDBManager;

import org.bson.types.ObjectId;

import com.fengyun.web.db.playermodel.ProjectModel;
import com.mongodb.BasicDBObject;

public class ProjectDAO {

	/** 公共sql **/
	private static final String tableName = Tables.Project;
	
	/**
	 * 查询某负责的所有项目
	 * @param userId
	 * @return
	 */
	public static ProjectModel getByUserId(String userId) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("userId", userId);
		
		return MongoDBManager.findOne(tableName, queryObj);
	}
	/**
	 * 查询某项目
	 * @param id
	 * @return
	 */
	public static ProjectModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		ProjectModel  projectModel=MongoDBManager.findOne(tableName, queryObj);
		return projectModel;
	}
	
	/**
	 * 查询某项目
	 * @param pCode
	 * @return
	 */
	public static ProjectModel getByPCode(String pCode) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("pCode", pCode);
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(ProjectModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	/**
	 * 获得所有项目
	 * @param id
	 * @return
	 */
	public static List<ProjectModel> getAll(BasicDBObject queryObj,int row,int skip) {
		List<ProjectModel> models = MongoDBManager.find(tableName,queryObj,row,skip);//
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
	public static boolean update(ProjectModel model) {
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
	 * 审核通过
	 * @param model
	 */
	public static void updateCheck(ProjectModel model) {
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("check", model.getCheck());
		
		update(model.getId(), fieldObj);
	}
	
	/**
	 *更新状态
	 * @param model
	 */
	public static void updateStatus(ProjectModel model) {
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("status", model.getStatus());
		
		update(model.getId(), fieldObj);
	}

	/**
	 * 查询所有的项目list-zss
	 * @param queryObj
	 * @return
	 */
	public static List<ProjectModel> getPNameList(BasicDBObject queryObj) {
		// TODO Auto-generated method stub
		List<ProjectModel> list = MongoDBManager.find(tableName, queryObj);
		return list;
	}

	public static List<ProjectModel> getByCode(String code) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("code", code);
		
		List<ProjectModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}
	
	/**
	 * 通过项目名称模糊查询项目
	 * @param name
	 * @return
	 */
	public static ProjectModel getByName(String name) {
		BasicDBObject queryObj = new BasicDBObject(2);
		Pattern namePattern = Pattern.compile(".*" + name + ".*",Pattern.CASE_INSENSITIVE);
		queryObj.put("name", namePattern);
		return MongoDBManager.findOne(tableName, queryObj);
	}
}
