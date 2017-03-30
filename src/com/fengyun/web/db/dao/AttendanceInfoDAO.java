package com.fengyun.web.db.dao;

import java.util.List;


import org.bson.types.ObjectId;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.AttendanceInfoModel;
import com.mongodb.BasicDBObject;

public class AttendanceInfoDAO {
private static final String tableName = Tables.AttendanceInfo;
	
	
	/**
	 * 查询所有考勤信息
	 */
	public static List<AttendanceInfoModel> getAll(BasicDBObject queryObj,int row,int skip) {
		List<AttendanceInfoModel> models = MongoDBManager.find(tableName,queryObj,row,skip);
		return models;
	}
	
	
	
	/**
	 * 新增考勤信息
	 */
	public synchronized static void insert(AttendanceInfoModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	
	/**
	 * 查询某个考勤信息
	 */
	public static AttendanceInfoModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	
	public static AttendanceInfoModel getByMonth(String month) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("month", month);
		
		return MongoDBManager.findOne(tableName, queryObj);
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
	public static boolean update(AttendanceInfoModel model) {
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
	 * 查询某一个项目的考勤信息
	 */
	public static List<AttendanceInfoModel> getBypCode(String pCode) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("pCode", pCode);
		
		List<AttendanceInfoModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}

	/**
	 * 查询考勤记录
	 * @param queryObj
	 * @return
	 */
	public static List<AttendanceInfoModel> getAttentenceList(
			BasicDBObject queryObj) {
		return MongoDBManager.find(tableName, queryObj);
	}

	/**
	 * 获取考勤记录（不分页操作）
	 * @param queryObj
	 * @return
	 */
	public static List<AttendanceInfoModel> getAttendanceInfoRecordOneList(
			BasicDBObject queryObj) {
		return MongoDBManager.find(tableName, queryObj);
	}

	/**
	 * 按照班组名称、pCode、confirm查询
	 * @param pCode
	 * @param confirm
	 * @param teamName
	 * @return
	 */
	public static List<AttendanceInfoModel> getListByTeamName(String pCode,
			int confirm, String teamName) {
		BasicDBObject queryObj = new BasicDBObject(4);
		queryObj.put("pCode", pCode);
		queryObj.put("confirm", confirm);
		queryObj.put("tName", teamName);
		return MongoDBManager.find(tableName, queryObj);
	}

	/**
	 * 新增
	 * @param attendanceInfoModel
	 * @return
	 */
	public static boolean addAttendanceInfo(
			AttendanceInfoModel attendanceInfoModel) {
		return MongoDBManager.insert(tableName, attendanceInfoModel);
	}



	public static List<AttendanceInfoModel> getAllByPageAndPCodeAndTCode(
			BasicDBObject queryObj, int row, int skip) {
		return MongoDBManager.find(tableName, queryObj , row, skip);
	}

	
	
	
}
