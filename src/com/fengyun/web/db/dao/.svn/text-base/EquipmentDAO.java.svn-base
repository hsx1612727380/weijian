package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import org.bson.types.ObjectId;

import com.fengyun.web.db.playermodel.EquipmentModel;
import com.mongodb.BasicDBObject;

public class EquipmentDAO {

	/** 公共sql **/
	private static final String tableName = Tables.Equipment;
	
	/**
	 * 查询某公司
	 * @param code
	 * @return
	 */
	public static EquipmentModel getByUserId(String userId) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("userId", userId);
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 查询某公司
	 * @param code
	 * @return
	 */
	public static EquipmentModel getByCode(String code) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("code", code);
		
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 查询某公司信息
	 * @param id
	 * @return
	 */
	public static EquipmentModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	
	
	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(EquipmentModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	/**
	 * 获得所有项目
	 * @param id
	 * @return
	 */
	public static List<EquipmentModel> getAll(BasicDBObject queryObj,int row,int skip) {
		List<EquipmentModel> models = MongoDBManager.find(tableName,queryObj,row,skip);//
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
	public static boolean update(EquipmentModel model) {
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
	public static void updateStatus(EquipmentModel model) {
		//生产json格式
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("status", model.getStatus());
		
		update(model.getId(), fieldObj);
	}
	
	/**
	 * 根据设备商名称查找设备商信息
	 * @param name
	 * @return
	 */
	public static EquipmentModel getByName(String name) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("name",name);
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 根据条件查询设备商
	 * @param queryObj
	 * @return
	 */
	public static List<EquipmentModel> getMaterialList(BasicDBObject queryObj) {
		return MongoDBManager.find(tableName, queryObj);
	}

	/**
	 * 新增设备商
	 * @param equipmentModel
	 * @return
	 */
	public static boolean addMaterial(EquipmentModel equipmentModel) {
		return MongoDBManager.insert(tableName, equipmentModel);
	}
}
