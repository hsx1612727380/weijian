package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import org.bson.types.ObjectId;

import com.fengyun.web.db.playermodel.RequirementsModel;
import com.mongodb.BasicDBObject;

public class RequirementsDAO {

	/** 公共sql **/
	private static final String tableName = Tables.Requirements;
	
	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(RequirementsModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	/**
	 * 获取列表
	 * @param pId
	 * @return
	 */
	public static List<RequirementsModel> getAll(BasicDBObject queryObj,int row,int skip) {
		List<RequirementsModel> models = MongoDBManager.find(tableName, queryObj,row,skip);//
		return models;
	}
	

	public static long countAll(BasicDBObject queryObj){
		return MongoDBManager.getCount(tableName,queryObj);
	}
	
	/**
	 * 根据查询条件获取信息
	 * @param id
	 * @return
	 */
	public static RequirementsModel getOne(BasicDBObject queryObj) {
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 根据ID获取信息
	 * @param id
	 * @return
	 */
	public static RequirementsModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
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
	public static boolean update(RequirementsModel model) {
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
	 * 
	 * @param model
	 */
	public static void updateStatus(RequirementsModel model,int status) {
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("status", status);
		
		update(model.getId(), fieldObj);
	}

	/**
	 * 根据Requirements中的标题等信息判断是否已经发布了这信息
	 * @param projectId
	 * @param title
	 * @param skillBigType
	 * @param skillSmallType
	 * @return
	 */
	public static RequirementsModel getRequirementsByTitleAndSoOn(
			String projectId, String title, String skillBigType,
			String skillSmallType) {
		BasicDBObject fieldObj = new BasicDBObject(5);
		fieldObj.put("rId", projectId);
		fieldObj.put("title", title);
		fieldObj.put("skillBigType", skillBigType);
		fieldObj.put("skillSmallType", skillSmallType);
		return MongoDBManager.findOne(tableName, fieldObj);
	}

	/**
	 * 根据项目的ID和type和status的状态查询RequirementsModel
	 * @param projectId
	 * @param type 1-求职 2-招聘
	 * @param status // 状态 0表示关闭
	 * @return
	 */
	public static List<RequirementsModel> getByRIdAndTypeAndStatus(String projectId,
			int type, int status) {
		BasicDBObject fieldObj = new BasicDBObject(4);
		fieldObj.put("rId", projectId);
		fieldObj.put("type", type);
		fieldObj.put("status", status);
		return MongoDBManager.find(tableName, fieldObj);
	}

	/**
	 * 根据求职状态和班组类型、技能类别、技能类型查询
	 * @param type
	 * @param teamType
	 * @param teamSkillBigType
	 * @param teamSkillSmallType
	 * @return
	 */
	public static List<RequirementsModel> selectByTeamSelections(int type, int teamType, String teamSkillBigType, String teamSkillSmallType) {
		BasicDBObject fieldObj = new BasicDBObject(5);
		fieldObj.put("type", type);
		fieldObj.put("teamType", teamType);
		fieldObj.put("skillBigType", Integer.parseInt(teamSkillBigType));
		fieldObj.put("skillSmallType", Integer.parseInt(teamSkillSmallType));
		return MongoDBManager.find(tableName, fieldObj);
	}

	/**
	 * 根据项目的ID和type和status的状态查询RequirementsModel
	 * @param projectId
	 * @param type 1-求职 2-招聘
	 * @param status // 状态 0表示关闭
	 * @param userType 班组类型：1-施工班组，2-材料商，3-设备商
	 * @return
	 */
	public static List<RequirementsModel> getByRIdAndTypeAndStatusAndUserType(
			String projectId, int type, int status, int teamType) {
		BasicDBObject fieldObj = new BasicDBObject(5);
		fieldObj.put("rId", projectId);
		fieldObj.put("type", type);
		fieldObj.put("status", status);
		fieldObj.put("teamType", teamType);
		return MongoDBManager.find(tableName, fieldObj);
	}
	
}
