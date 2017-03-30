package com.fengyun.web.db.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.bson.types.ObjectId;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.mongodb.BasicDBObject;
/**rkai*/
public class ProjectDepartmentDAO {

	/** 公共sql **/
	private static final String tableName = Tables.ProjectDepartment;
	
	
	public static ProjectDepartmentModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 根据项目ID，班组ID，类型获取项目相关信息
	 * @param pId
	 * @param vId
	 * @param type
	 * @return
	 */
	public static ProjectDepartmentModel getByTypeAndId(String pId, String vId, int type) {
		BasicDBObject queryObj = new BasicDBObject(4);
		queryObj.put("pId", pId);
		queryObj.put("vId", vId);
		queryObj.put("type", type);
		
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(ProjectDepartmentModel model) {
		MongoDBManager.insert(tableName, model);
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
	 * 更新状态
	 * @param model
	 */
	public static void updateStatus(ProjectDepartmentModel model) {
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("status", model.getStatus());
		
		update(model.getId(), fieldObj);
	}
	
	/**
	 * 根据项目ID获取项目的班组，材料，设备商信息
	 * @param pId
	 * @return
	 */
	public static List<ProjectDepartmentModel> getByPIdStatus(String pId,int status) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("pId", pId);
		queryObj.put("status", status);
		
		List<ProjectDepartmentModel> models = MongoDBManager.find(tableName, queryObj);//
		return models;
	}
	
	
	/**
	 * 查找符合条件的成员（申请中、已加入等）
	 */
	public static List<ProjectDepartmentModel> getProjectDepartment(String vId,
			int status, int pageSize, int skip) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("vId", vId);
		queryObj.put("status",status);
//		return MongoDBManager.find(tableName, queryObj);
		List list=MongoDBManager.find(tableName, queryObj, pageSize, skip);
		return list;
	}

	/**
	 * 统计符合条件的项目数
	 * @param vId
	 * @param status
	 * @return
	 */
	public static int countMember(String vId, int status) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("vId", vId);//vId邀请的id，pId  项目id
		queryObj.put("status", status);
		return (int) MongoDBManager.getCount(tableName, queryObj);
	}
	
	/**
	 * 查询项目中某个班组、供应商等的信息rki
	 * @param vid 邀请的ID,有可能是班组ID，材料商ID，设备商ID
	 * @param pid 项目ID
	 */
	public static ProjectDepartmentModel getModelByTidAndVid(String vId,String pId) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("vId", vId);
		queryObj.put("pId", pId);
		return MongoDBManager.findOne(tableName, queryObj);
	}

//	/**
//	 * 根据id删除项目成员
//	 * @param id
//	 */
//	public static void deleteById(String id) {
//		BasicDBObject queryObj = new BasicDBObject(2);
//		queryObj.put("_id", new ObjectId(id));
//		MongoDBManager.delete(tableName, id, null);
//		
//	}
	/**
	 * 根据项目id获取项目下的所有班组信息
	 */
	public static List<ProjectDepartmentModel> getTeamByPId(String pId,int type,int status){
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("pId", pId);
		queryObj.put("type", type);
		queryObj.put("status", status);
		List<ProjectDepartmentModel> models = MongoDBManager.find(tableName, queryObj);//
		return models;
	}
	
	
	/**
	 * 根据班组id获取加入过的项目
	 */
	public static List<ProjectDepartmentModel> getProjectByTId(String vId,int type,int status){
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("vId", vId);
		queryObj.put("type", type);
		queryObj.put("status", status);
		List<ProjectDepartmentModel> models = MongoDBManager.find(tableName, queryObj);//
		return models;
	}
	
	/*public static void update(String id, BasicDBObject fieldObj) {
		MongoDBManager.updateFields(tableName, id, fieldObj,null);
	}*/
	public static void updateModel(ProjectDepartmentModel model) {
		MongoDBManager.update(tableName, model);
	}
	
	/**
	 * 根据项目的ID、班组的ID和班组的类型查询
	 * @param pId
	 * @param vId
	 * @param type
	 * @return
	 */
	public static ProjectDepartmentModel selectByPIdAndVIdAndType(String pId, String vId,
			int type) {
		BasicDBObject queryObj = new BasicDBObject(4);
		queryObj.put("pId", pId);
		queryObj.put("vId", vId);
		queryObj.put("type", type);
		return MongoDBManager.findOne(tableName, queryObj);
	}
	/**
	 * 查询一个项目
	 */
	public static ProjectDepartmentModel getByQueryObj(BasicDBObject queryObj) {
		// TODO Auto-generated method stub
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 根据项目的编号获取参与这个项目的所有班组 或者 审核中的status 1 2 3 4
	 * @param pId
	 * @return
	 */
	public static List<ProjectDepartmentModel> getByPId(String pId, int status) {
		return getByPIdStatus(pId, status);
	}

	/**
	 * 根据班组的ID、项目的ID、班组的状态、班组的类别查询
	 * @param vId
	 * @param projectId 不需要这个查询条件时置为null
	 * @param status
	 * @param type
	 * @return
	 */
	public static ProjectDepartmentModel getByVIdAndPIdAndStatusAndType(
			String vId, String projectId, int status, int type) {
		BasicDBObject queryObj = new BasicDBObject(5);
		queryObj.put("vId", vId);
		if(StringUtils.isNotBlank(projectId)){
			queryObj.put("pId", projectId);
		}
		queryObj.put("status", status);
		queryObj.put("type", type);
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 根据项目的ID，班组的ID、班组的类型查询
	 * @param pId
	 * @param vId
	 * @param type
	 * @return
	 */
	public static ProjectDepartmentModel getByPIdAndVIdAndType(String pId,
			String vId, int type) {
		BasicDBObject queryObj = new BasicDBObject(4);
		queryObj.put("pId", pId);
		queryObj.put("vId", vId);
		queryObj.put("type", type);
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 根据项目的ID，班组的ID、班组加入项目的状态
	 * @param vId
	 * @param pId
	 * @param status
	 * @return
	 */
	public static ProjectDepartmentModel getByPIdAndVIdAndStatus(String vId,
			String pId, int status) {
		BasicDBObject queryObj = new BasicDBObject(4);
		queryObj.put("vId", vId);
		queryObj.put("pId", pId);
		queryObj.put("status", status);
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 根据项目的ID和班组的类型查询
	 * @param pId
	 * @param type
	 * @return
	 */
	public static List<ProjectDepartmentModel> getByPIdAndType(String pId,
			int type) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("pId", pId);
		queryObj.put("type", type);
		return MongoDBManager.find(tableName, queryObj);
	}

}
