package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import org.bson.types.ObjectId;

import com.fengyun.web.db.playermodel.MaterialModel;
import com.mongodb.BasicDBObject;

public class MaterialDAO {

	/** 公共sql **/
	private static final String tableName = Tables.Material;
	
	
	/**
	 * 查询某项目
	 * @param id
	 * @return
	 */
	public static MaterialModel getByUserId(String userId) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("userId", userId);
		
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 查询某项目
	 * @param id
	 * @return
	 */
	public static MaterialModel getByCode(String code) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("code", code);
		
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 查询某公司信息
	 * @param id
	 * @return
	 */
	public static MaterialModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(MaterialModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	/**
	 * 获得所有项目
	 * @param id
	 * @return
	 */
	public static List<MaterialModel> getAll(BasicDBObject queryObj,int row,int skip) {
		List<MaterialModel> models = MongoDBManager.find(tableName,queryObj,row,skip);//
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
	public static boolean update(MaterialModel model) {
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
	public static void updateStatus(MaterialModel model) {
		//生产json格式
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("status", model.getStatus());
		
		update(model.getId(), fieldObj);
	}
	
	
	/**
	 * 根据材料商名称查询
	 * @param name
	 * @return
	 */
	public static MaterialModel getByName(String name) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("name",name);
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 根据条件查询材料商
	 * @param queryObj
	 * @return
	 */
	public static List<MaterialModel> getMaterialList(BasicDBObject queryObj) {
		return MongoDBManager.find(tableName, queryObj);
	}

	/**
	 * 新增材料商
	 * @param materialModel
	 * @return
	 */
	public static boolean addMaterial(MaterialModel materialModel) {
		return MongoDBManager.insert(tableName, materialModel);
	}
}
