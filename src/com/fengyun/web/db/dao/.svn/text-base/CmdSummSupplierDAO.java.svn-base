package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import org.bson.types.ObjectId;

import com.fengyun.web.db.playermodel.CmdSummPersonModel;
import com.fengyun.web.db.playermodel.CmdSummSupplierModel;
import com.mongodb.BasicDBObject;

public class CmdSummSupplierDAO {	
private static final String tableName = Tables.CmdSummSupplier;
	
	/**
	 * 查询某供应商汇总表
	 * @param code
	 * @return
	 */
	public static CmdSummSupplierModel getByCode(String code) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("code", code);
		
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	
	public static List<CmdSummSupplierModel> getByTime(int year, int month , String pCode) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("year", year);
		queryObj.put("month", month);
		queryObj.put("pCode", pCode);
		List<CmdSummSupplierModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}
	
	
	public static List<CmdSummSupplierModel> getByCmd(String cmdId) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("cmdId", cmdId);
		List<CmdSummSupplierModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static CmdSummSupplierModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(CmdSummSupplierModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	/**
	 * 获得所有项目
	 * @param id
	 * @return
	 */
	public static List<CmdSummSupplierModel> getAll(BasicDBObject queryObj,int row,int skip) {
		List<CmdSummSupplierModel> models = MongoDBManager.find(tableName,queryObj,row,skip);//
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
	public static boolean update(CmdSummSupplierModel model) {
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
	
	
	public static List<CmdSummSupplierModel> getBypCode(String pCode) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("pCode", pCode);
		List<CmdSummSupplierModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}

	/**
	 * 根据汇总表的ID、材料商或设备商的ID、班组类型(1-本班组，2-劳务班组，3-专业班组)、班组类别(1-租赁方，2-材料商，3-设备商)、年份、月份查询
	 * @param cmdId
	 * @param tId
	 * @param teamtype
	 * @param type
	 * @param year
	 * @param month
	 * @return
	 */
	public static List<CmdSummSupplierModel> getByCmdIdAndTIdAndTeamTypeAndYearMonth(
			String cmdId, String tId, int teamtype, int type, int year,
			int month) {
		BasicDBObject queryObj = new BasicDBObject(7);
		queryObj.put("cmdId", cmdId);
		queryObj.put("tId", tId);
		queryObj.put("teamtype", teamtype);
		queryObj.put("type", type);
		queryObj.put("year", year);
		queryObj.put("month", month);
		return MongoDBManager.find(tableName, queryObj);
	}

	/**
	 * 新增
	 * @param cmdSummSupplierModel
	 * @return
	 */
	public static boolean addCmdSummSupplier(
			CmdSummSupplierModel cmdSummSupplierModel) {
		return MongoDBManager.insert(tableName, cmdSummSupplierModel);
	}
	
	
	

}
