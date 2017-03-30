package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import org.bson.types.ObjectId;


import com.fengyun.web.db.playermodel.CmdSummPersonModel;
import com.mongodb.BasicDBObject;

public class CmdSummPersonDAO {
	private static final String tableName = Tables.CmdSummPerson;
	
	/**
	 * 查询某供应商汇总表
	 * @param code
	 * @return
	 */
	public static CmdSummPersonModel getByCode(String code) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("code", code);
		
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	
	public static List<CmdSummPersonModel> getByTime(int year, int month , String pCode) {
		BasicDBObject queryObj = new BasicDBObject(4);
		queryObj.put("year", year);
		queryObj.put("month", month);
		queryObj.put("pCode", pCode);
		List<CmdSummPersonModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}
	
	
	
	public static List<CmdSummPersonModel> getByCmd(String cmdId) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("cmdId", cmdId);
		List<CmdSummPersonModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static CmdSummPersonModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(CmdSummPersonModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	/**
	 * 获得所有项目
	 * @param id
	 * @return
	 */
	public static List<CmdSummPersonModel> getAll(BasicDBObject queryObj,int row,int skip) {
		List<CmdSummPersonModel> models = MongoDBManager.find(tableName,queryObj,row,skip);//
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
	public static boolean update(CmdSummPersonModel model) {
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
	
	
	public static List<CmdSummPersonModel> getBypCode(String pCode) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("pCode", pCode);
		List<CmdSummPersonModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}

	/**
	 * 根据汇总表的ID、班组ID、班组类型、年份和月份进行查询
	 * @param cmdId
	 * @param tId
	 * @param teamtype
	 * @param year
	 * @param month
	 * @return
	 */
	public static List<CmdSummPersonModel> getByCmdIdAndTIdAndTeamTypeAndYearMonth(
			String cmdId, String tId, int teamtype, int year, int month) {
		BasicDBObject queryObj = new BasicDBObject(5);
		queryObj.put("cmdId", cmdId);
		queryObj.put("tId", tId);
		queryObj.put("teamtype", teamtype);
		queryObj.put("year", year);
		queryObj.put("month", month);
		return MongoDBManager.find(tableName, queryObj);
	}

	/**
	 * 检查某个员工在该月只有一条记录
	 * @param cmdId
	 * @param pId
	 * @param tId
	 * @param userId
	 * @param teamtype
	 * @param year
	 * @param month
	 * @return
	 */
	public static CmdSummPersonModel isRecordExist(String cmdId, String pId,
			String tId, String userId, int teamtype, int year, int month) {
		BasicDBObject queryObj = new BasicDBObject(8);
		queryObj.put("cmdId", cmdId);
		queryObj.put("pId", pId);
		queryObj.put("tId", tId);
		queryObj.put("userId", userId);
		queryObj.put("teamtype", teamtype);
		queryObj.put("year", year);
		queryObj.put("month", month);
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 新增
	 * @param cmdSummPersonModel
	 * @return
	 */
	public static boolean addCmdSummPerson(CmdSummPersonModel cmdSummPersonModel) {
		return MongoDBManager.insert(tableName, cmdSummPersonModel);
	}

}
