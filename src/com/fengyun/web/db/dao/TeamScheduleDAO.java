package com.fengyun.web.db.dao;

import java.util.Date;
import java.util.List;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.TeamScheduleModel;
import com.fengyun.web.util.DateStringUtils;
import com.mongodb.BasicDBObject;

public class TeamScheduleDAO {

	/** 对应表名 **/
	private static final String tableName = Tables.TeamSchedule;
	
	/**
	 * 查询列表通用方法
	 * @param queryObj
	 * @return
	 */
	public static List<TeamScheduleModel> getListByQueryObj(BasicDBObject queryObj){
		return MongoDBManager.find(tableName, queryObj);
	}
	
	/**
	 * 通过model插入一条记录
	 * @param teamScheduleModel
	 * @return 
	 */
	public static boolean insertOne(TeamScheduleModel teamScheduleModel){
		return MongoDBManager.insert(tableName, teamScheduleModel);
	}

	/**
	 * 统计全部记录条数
	 * @param pId
	 * @return
	 */
	public static Long countAll(String pId,String startDateT,String endDateT) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("pId", pId);
		
		startDateT =startDateT.replace("-", "")+"000000";
		endDateT = endDateT.replace("-", "")+"235959";
		
		Date startP = DateStringUtils.parseYMDS(startDateT);
		Date endP = DateStringUtils.parseYMDS(endDateT);
		
		BasicDBObject dateTime = new BasicDBObject("$gte",startP);
		dateTime.append("$lte",endP);
		queryObj.put("storageTime", dateTime);
		return MongoDBManager.getCount(tableName, queryObj);
	}
	
	/**
	 * 分页查询
	 * @param queryObj
	 * @param row
	 * @param skip
	 * @return
	 */
	public static List<TeamScheduleModel> getAll(BasicDBObject queryObj,int row,int skip) {
		List<TeamScheduleModel> list = MongoDBManager.find(tableName,queryObj,row,skip);
		return list;
	}

	/**
	 * 通过queryObj查询一个model
	 * @param queryObj
	 * @return
	 */
	public static TeamScheduleModel getByQueryObj(BasicDBObject queryObj) {
		// TODO Auto-generated method stub
		TeamScheduleModel model = MongoDBManager.findOne(tableName, queryObj);
		return model;
	}

	public static boolean update(TeamScheduleModel teamSchedule) {
		// TODO Auto-generated method stub
		return MongoDBManager.update(tableName, teamSchedule);
	}
	
}
