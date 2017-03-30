package com.fengyun.web.db.dao;

import java.util.Date;
import java.util.List;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.ProjectProgressModel;
import com.fengyun.web.util.DateStringUtils;
import com.mongodb.BasicDBObject;

public class ProjectProgressDAO {

	/** 对应表名 **/
	private static final String tableName = Tables.ProjectProgress;

	/**
	 * 统计
	 * @param pId
	 * @return
	 */
	public static Long countAll(String pId,String startDateP,String endDateP) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("pId", pId);
		
		startDateP =startDateP.replace("-", "")+"000000";
		endDateP = endDateP.replace("-", "")+"235959";
		
		Date startP = DateStringUtils.parseYMDS(startDateP);
		Date endP = DateStringUtils.parseYMDS(endDateP);
		
		BasicDBObject dateTime = new BasicDBObject("$gte",startP);
		dateTime.append("$lte",endP);
		queryObj.put("storageTime", dateTime);
		return MongoDBManager.getCount(tableName, queryObj);
	}
	
	/**
	 * 通过model插入一条记录
	 * @param projectProgressModel
	 * @return
	 */
	public static boolean insert(ProjectProgressModel projectProgressModel){
		return MongoDBManager.insert(tableName, projectProgressModel);
	}
	
	/**
	 * 分页查询
	 * @param queryObj
	 * @param row
	 * @param skip
	 * @return
	 */
	public static List<ProjectProgressModel> getAll(BasicDBObject queryObj,int row,int skip) {
		List<ProjectProgressModel> list = MongoDBManager.find(tableName,queryObj,row,skip);
		return list;
	}

	/**
	 * 通过queryObj获取一个model
	 * @param queryObj
	 * @return
	 */
	public static ProjectProgressModel getByQueryObj(BasicDBObject queryObj) {
		// TODO Auto-generated method stub
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 更新一个model
	 * @param projectProgress
	 * @return
	 */
	public static boolean update(ProjectProgressModel projectProgress) {
		// TODO Auto-generated method stub
		return MongoDBManager.update(tableName, projectProgress);
	}
}
