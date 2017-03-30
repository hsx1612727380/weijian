package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import org.apache.commons.lang.StringUtils;
import org.bson.types.ObjectId;

import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.mongodb.BasicDBObject;

public class TeamMemberDAO {

	private static final String tableName = Tables.TeamMember;
	
	/**
	 * 根据班组id删除班组成员
	 * @param id
	 */

	public static void delete(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		MongoDBManager.delete(tableName, id, null);
		
	}
	
	/**
	 * 新增班组成员
	 */
	public synchronized static void insert(TeamMemberModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	/**
	 * 通过id查询班组中某个成员信息
	 */
	public static TeamMemberModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 通过班组长电话号码查询班组
	 */
	public static TeamMemberModel getByUserId(String userId) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("userId", userId);
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 查询班组中某个成员信息
	 */
	public static TeamMemberModel getByTIdAndUserId(String tId,String userId) {
		BasicDBObject queryObj = new BasicDBObject(3);
		if(StringUtils.isNotBlank(tId)){
			queryObj.put("tId", tId);
		}
		queryObj.put("userId", userId);
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 查询某个班组中正在申请的成员的信息
	 */
	public static List<TeamMemberModel> getByTId(String tId){
		return getByTId(tId,3);
	}
	
	/**
	 * 查询已进入班组的成员的list
	 * @param tId
	 * @return
	 */
	public static List<TeamMemberModel> getByTIdAndStatus3(String tId){
		return getByTId(tId,3);
	}
	
	/**
	 * 查询某个班组中成员的信息
	 */
	public static List<TeamMemberModel> getByTId(String tId,int status){
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("tId", tId);
		queryObj.put("status", status);
		return MongoDBManager.find(tableName, queryObj);
	}
	/**
	 * 正在招聘的班组
	 * @param userId
	 * @param status
	 * @param pageSize
	 * @param skip
	 * @return
	 */
	public static List<TeamMemberModel> getApplyTeam(String userId,int status,int pageSize,int skip) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("userId", userId);
		queryObj.put("status",status);
//		return MongoDBManager.find(tableName, queryObj);
		return MongoDBManager.find(tableName, queryObj, pageSize, skip);
	}
	/**
	 * 查找符合条件的成员（申请中、已加入等）
	 */
	public static List<TeamMemberModel> getTeamMemberByTrd(String tId, int status, int pageSize,int skip) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("tId", tId);
		//status表示 不使用status这个字段
		if(status!=0){
			queryObj.put("status",status);
		}
//		return MongoDBManager.find(tableName, queryObj);
		List list=MongoDBManager.find(tableName, queryObj, pageSize, skip);
		return list;
	}
	
	
	/**
	 *申请本班组的个人
	 * @param userId
	 * @param status
	 * @param pageSize
	 * @param skip
	 * @return
	 */
	public static List<TeamMemberModel> applyTeamPerson(String userId,int status,int pageSize,int skip) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("tId", userId);
		queryObj.put("status",status);
//		return MongoDBManager.find(tableName, queryObj);
		return MongoDBManager.find(tableName, queryObj, pageSize, skip);
	}
	
	/**
	 * 统计班里某个状态的成员
	 */
	public static long countMember(String tId,int status){
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("tId", tId);
		queryObj.put("status", status);
		return MongoDBManager.getCount(tableName, queryObj);
	}
	/**
	 * 统计某工人的
	 */
	public static long countUserIdByStatus(String userId,int status){
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("userId", userId);
		queryObj.put("status", status);
		return MongoDBManager.getCount(tableName, queryObj);
	}
	
	public static long countMember(String tId){
		return countMember(tId,3);
	}
	
	/**
	 * 通过用户名从teamMeamber中获取到用户所在的 班组id
	 * @param userId
	 */
//	public static String getTeamIdByUserId(String userId) {
//		// TODO Auto-generated method stub
//		BasicDBObject queryObj = new BasicDBObject(3);
//		queryObj.put("userId", userId);
//		TeamMemberModel teamMemberModel = MongoDBManager.findOne(tableName, queryObj);
//		String teamId = teamMemberModel.gettId();
//		return teamId;
//	}

	/**
	 * 更新保存model
	 * 
	 * @param model
	 */
	public static boolean update(TeamMemberModel model) {
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

	public static void updateStatus(TeamMemberModel model) {
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("status", model.getStatus());
		update(model.getId(), fieldObj);
	}
	
	/**
	 * 修改TeamMember表班组成员转态
	 * @param userId
	 */
	public static Boolean updateTeamMemberStatus(String teamMemberId,int status) {
		// TODO Auto-generated method stub               
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("status", status);
		return MongoDBManager.updateFields(tableName, teamMemberId, queryObj, null);
	}
	
	
	/**
	 * 查询某个班组中成员的信息
	 */
	public static List<TeamMemberModel> getByMemberTId(String tId){
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("tId", tId);
		return MongoDBManager.find(tableName, queryObj);
	}

	public static List<TeamMemberModel> getByTeamMemberIdAndStatus(String userId,
			int status) {
		
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("userId", userId);
		queryObj.put("status", status);
		return MongoDBManager.find(tableName, queryObj);
	}

	/**
	 * 根据用户的班组ID和其状态查询
	 * @param teamId
	 * @param status
	 * @return
	 */
	public static List<TeamMemberModel> getBytIdAndStatus(String teamId, int status) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("tId", teamId);
		queryObj.put("status", status);
		return MongoDBManager.find(tableName, queryObj);
	}

	/**
	 * 根据用户的ID，班组的ID，以及用户与班组之间的关系进行查询
	 * @param userId
	 * @param tId
	 * @param status
	 * @return
	 */
	public static TeamMemberModel getByUserIdAndTIdAndStatus(String userId,
			String tId, int status) {
		BasicDBObject queryObj = new BasicDBObject(4);
		queryObj.put("userId", userId);
		if(StringUtils.isNotBlank(tId)){
			queryObj.put("tId", tId);
		}
		if(status!=-1){
			queryObj.put("status", status);
		}
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	public static void addTeamMember(TeamMemberModel teamMemberModel) {
		// TODO Auto-generated method stub
		MongoDBManager.insert(tableName, teamMemberModel);
	}

}
