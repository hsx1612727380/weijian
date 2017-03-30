package com.fengyun.web.db.dao;

import java.util.List;

import org.bson.types.ObjectId;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.CmdSummModel;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.mongodb.BasicDBObject;



public class CmdSummDAO {
	private static final String tableName = Tables.CmdSumm;
	
	/**
	 * 查询某供应商汇总表
	 * @param code
	 * @return
	 */
	public static CmdSummModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	
	public static List<CmdSummModel> getByTime(int year, int month , String pId) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("year", year);
		queryObj.put("month", month);
		queryObj.put("pId", pId);
		List<CmdSummModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	
	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(CmdSummModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	/**
	 * 获得所有项目
	 * @param id
	 * @return
	 */
	public static List<CmdSummModel> getAll(BasicDBObject queryObj,int row,int skip) {
		List<CmdSummModel> models = MongoDBManager.find(tableName,queryObj,row,skip);//
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
	public static boolean update(CmdSummModel model) {
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
	
	
	public static List<CmdSummModel> getBypId(String pId,BasicDBObject order) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("pId", pId);
		List<CmdSummModel> models = MongoDBManager.find(tableName, queryObj,order);
		return models;
	}
	public static List<CmdSummModel> getByType(int year, int month, String pId , int type) {
		BasicDBObject queryObj = new BasicDBObject(5);
		queryObj.put("year", year);
		queryObj.put("month", month);
		queryObj.put("pId", pId);
		queryObj.put("type", type);
		List<CmdSummModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}

	/**
	 * 根据时间、项目的ID和班组的类型查询
	 * @param year
	 * @param month
	 * @param projectId
	 * @param type
	 * @param teamType
	 * @return
	 */
	public static List<CmdSummModel> getByTimeAndTypeAndTeamtype(int year, int month,
			String projectId, int type, int teamType) {
		BasicDBObject queryObj = new BasicDBObject(6);
		queryObj.put("year", year);
		queryObj.put("month", month);
		queryObj.put("pId", projectId);
		queryObj.put("type", type);
		queryObj.put("teamtype", teamType);
		return MongoDBManager.find(tableName, queryObj);
	}

	/**
	 * 一个施工班组(材料商、设备商)在一个项目中的一个月在汇总表中只能存在一条记录，检查是否已经存在
	 * @param projectId
	 * @param tId
	 * @param year
	 * @param month
	 * @return
	 */
	public static CmdSummModel cmdSummRepCHeck(String projectId, String tId, int year, int month) {
		BasicDBObject queryObj = new BasicDBObject(5);
		queryObj.put("pId", projectId);
		queryObj.put("tId", tId);
		queryObj.put("year", year);
		queryObj.put("month", month);
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 新增
	 * @param cmdSummModel
	 * @return
	 */
	public static boolean addCmdSumm(CmdSummModel cmdSummModel) {
		return MongoDBManager.insert(tableName, cmdSummModel);
	}

	/**
	 * 根据时间、班组类别、班组类型、项目的ID、班组的ID查询 - 判断这个时间班组的数据是否存在
	 * @param year
	 * @param month
	 * @param type
	 * @param teamtype
	 * @param projectId
	 * @param vId
	 * @return
	 */
	public static CmdSummModel getByTimeAndTypesAndIds(int year, int month,
			int type, int teamtype, String projectId, String vId) {
		BasicDBObject queryObj = new BasicDBObject(7);
		queryObj.put("year", year);
		queryObj.put("month", month);
		queryObj.put("type", type);
		queryObj.put("teamtype", teamtype);
		queryObj.put("pId", projectId);
		queryObj.put("tId", vId);
		return MongoDBManager.findOne(tableName, queryObj);
	}


	
	
	
	

}
