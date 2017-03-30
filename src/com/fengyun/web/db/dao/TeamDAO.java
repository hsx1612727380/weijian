package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import org.bson.types.ObjectId;

import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.mongodb.BasicDBObject;

public class TeamDAO {

	private static final String tableName = Tables.Team;
	private static long autoId = 0;
	
	static{
		BasicDBObject orderObj = new BasicDBObject(2);
		orderObj.put("uid", -1);

		List<TeamModel> list = MongoDBManager.findByOrder(tableName, orderObj, 1);
		if (list != null && list.size() > 0) {
			autoId = list.get(0).getCode();
			if(autoId < 10000)
				autoId = 10000;
		}
	}
	
	/**
	 * 查询某班组
	 * 
	 * @param id
	 * @return
	 */
	public static TeamModel getByCode(long code) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("code", code);

		TeamModel  teamModel = MongoDBManager.findOne(tableName, queryObj);
		return teamModel;
	}

//	@Test
//	public void myTest(){
//		Object teamModel = this.getByCode(90001);
//	}
//	
	/**
	 * 新增班组
	 */
	public synchronized static void insert(TeamModel model) {
		int count = 0;
		do {
			autoId++;
			count++;

		} while (getByCode(autoId) != null && count < 50);

		model.setCode(autoId);
		MongoDBManager.insert(tableName, model);
	}

	/**
	 * 删除班组（通过id删除）
	 */
	public static void delete(String id) {

		MongoDBManager.delete(tableName, id, null);
	}

	/**
	 * 查询某班组
	 * 
	 * @param id
	 * @return
	 */
	public static TeamModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));

		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 根据长leaderMobile查询某班组信息
	 * 
	 * @param id
	 * @return
	 */
	public static TeamModel getByLeaderMobile(String leaderMobile) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("leaderMobile", leaderMobile);
		
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 获得所有班组
	 * 
	 * @param id
	 * @return
	 */
	public static List<TeamModel> getAll(BasicDBObject queryObj, int row,
			int skip) {
		List<TeamModel> models = MongoDBManager.find(tableName, queryObj, row,
				skip);
		return models;
	}

	/**
	 * 查询某班组下的所有成员
	 * 
	 * @param userId
	 * @return
	 */
	public static List<TeamMemberModel> getBytId(String tId) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("tId", tId);

		List<TeamMemberModel> models = MongoDBManager.find(tableName, queryObj);//
		return models;
	}

	public static long countAll(BasicDBObject queryObj) {
		return MongoDBManager.getCount(tableName, queryObj);
	}

	/**
	 * 根据查询条件获得所有班组
	 * 
	 * @param id
	 * @return
	 */
	public static List<TeamModel> getByQueryObj(BasicDBObject queryObj) {
		List<TeamModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}

	/**
	 * 通过班组长的电话好即userId查到这个班组的信息
	 * @param userId
	 * @return
	 */
	public static TeamModel getTeamByUserId(String userId) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("leaderMobile", userId);
		TeamModel teamModel = MongoDBManager.findOne(tableName, queryObj);
		return teamModel;
	}

	public static TeamModel getTeamByName(String name) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("name", name);
		
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 更新保存model
	 * 
	 * @param model
	 */
	public static boolean update(TeamModel model) {
		return MongoDBManager.update(tableName, model);
	}

	/**
	 * 根据条件查询施工班组
	 * @param queryObj
	 * @return
	 */
	public static List<TeamModel> getTeamList(BasicDBObject queryObj) {
		return MongoDBManager.find(tableName, queryObj);
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
	public static void updateStatus(TeamModel model) {
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("status", model.getStatus());
		
		update(model.getId(), fieldObj);
	}

}
