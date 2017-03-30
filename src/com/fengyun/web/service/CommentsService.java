package com.fengyun.web.service;

import java.util.List;
import java.util.Map;

import com.fengyun.web.db.playermodel.CommentsModel;
import com.fengyun.web.db.playermodel.TeamModel;

public interface CommentsService {

	/**
	 * 获取项目对班组或者个人的评价
	 * @param id userId或者班组ID
	 * @param type 1-个人 2-班组
	 * @return
	 */
	public List<CommentsModel> getListByIdAndType(String cId,int type);
	
	/**
	 * 新增
	 * @param startTime
	 * @param endTime
	 * @param projectName
	 * @param teamName
	 * @param score1
	 * @param score2
	 * @param score3
	 * @param desc
	 * @param type
	 * @param cId
	 */
	public void addComments(String startTime,String endTime,String projectName,String teamName,
			String name, int score1,int score2,int score3,String desc,int type,String cId);

	/**
	 * 获取评价信息
	 * @param userId
	 * @param type
	 * @return
	 */
	public List<CommentsModel> getComments(String userId, int type);

	/**
	 * 通过班组信息插入班组诚信档案的基本信息
	 * @param team
	 */
//	public void insert(TeamModel team);
	
	/**
	 * 根据班组的ID、项目的ID和班组的类型查询评论
	 * @param vId - 班组的ID
	 * @param pId - 项目的ID
	 * @param type
	 * @return
	 */
	public CommentsModel getByVidAndPidAndType(String cId, String pId, int type);

	/**
	 * 根据班组的ID获取记录数
	 * @param vId
	 * @return
	 */
	public List<CommentsModel> getListByVId(String vId);

	/**
	 * 通过项目操作员的userId和 commentsModel的type获取到该项目下的所有的班组及其成员的进出场评价
	 * @param pId
	 * @param i
	 * @return
	 */
	public List<CommentsModel> getEAECommentByUserId(String pId, int type);

	/**
	 * 添加一个进出场细信息
	 * @param commentsModel
	 * @param inOrOut 
	 */
	public void addOneEnterAndExit(CommentsModel commentsModel, String inOrOut,String pId,int type);

	/**
	 * 将班组长的commentsModel和班组长的电话对应放入一个map中
	 * @param leaderList
	 * @return
	 */
	public Map<TeamModel, CommentsModel> getLeaderMap(
			List<CommentsModel> leaderList);

	/**
	 * 获取加入当前项目的班组
	 * @return
	 */
	public List<TeamModel> getTeamList(String id);

	/**
	 * 通过id删除一个进退场信息
	 * @param id
	 */
	public boolean deleteById(String id);
	
}
