package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.ProjectRosterModel;
import com.mongodb.BasicDBObject;

/**
 * 
 * @author hsx
 *
 */
public class ProjectRosterDao {
	
	/** 公共sql **/
	private static final String tableName = Tables.ProjectRoster;

	/**
	 * 查询项目花名册的所有人
	 * @return
	 */
	public static List<ProjectRosterModel> getAllByPId(BasicDBObject queryObj, int row, int skip) {
		return MongoDBManager.find(tableName, queryObj , row, skip);
	}

	/**
	 * 新增数据
	 * @param projectRosterModel
	 * @return
	 */
	public static boolean addProjectRoster(ProjectRosterModel projectRosterModel) {
		return MongoDBManager.insert(tableName,  projectRosterModel);
	}

	/**
	 * 根据项目花名册的身份证查询
	 * @param identity
	 * @return
	 */
	public static ProjectRosterModel getByIdentity(String identity) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("identity", identity);
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 根据项目花名册的手机号查询
	 * @param phone
	 * @return
	 */
	public static ProjectRosterModel getByPhone(String phone) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("phone", phone);
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 根据项目的ID查询项目花名册的所有人的个数
	 * @param projectId
	 * @return
	 */
	public static Long getCountByPId(String projectId) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("pId", projectId);
		return MongoDBManager.getCount(tableName, queryObj);
	}

}
