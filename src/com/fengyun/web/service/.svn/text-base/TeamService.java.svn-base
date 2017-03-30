package com.fengyun.web.service;

import java.io.IOException;
import java.util.List;

import com.fengyun.web.db.dao.ProjectDAO;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.service.impl.TeamServicelmpl.ApplyIng;
import com.mongodb.BasicDBObject;

public interface TeamService {
	/**获取班组信息 @param id id为自动生成的主键
	 * 
	 * @param id
	 * @return
	 */
	public TeamModel getTeamById(String id);
	
	/** 新增班组 */
	public boolean addTeam(String name, String leaderName,
			String leaderMobile, int skillBigType, int skillSmallType,
			int status, String province, String city, String street);

	/** 删除班组 */
	public void delTeam(String id);

	/** 新增班组成员 */
	public boolean addTeamMember(String tId, String userId,int status);

	/** 删除班组成员 */
	public void delTeamMember(String tId,String userId);

	/**
	 * 列举班组列表信息
	 */
	public List<TeamModel> getTeamList(BasicDBObject queryObj, int pageNow,
			int pageSize);

	/**
	 * 新增
	 * 
	 * @param model
	 * @return
	 */
	public void insertTeam(TeamModel model);

	/**
	 * 邀请人员加入班组（通过用户ID）
	 */
	public void inviteTeamMember(String tId,String userId,int status);

	/** 
	 * 通过邀请，接受邀请 
	 * @param teamMemberId:班组成员id
	 * */
	public Boolean passTeamMember(String teamMemberId,int status);
	
	/**
	 * 拒绝班组的邀请
	 * @param teamMemberId
	 * @throws IOException
	 */
	public void rejectInvite(String teamMemberId);

	/** 查询某班组下的班组成员 */
	public List<UserModel> selectMember(String tId);

	/** 获取 班组总数 */
	public long countAllTeam(BasicDBObject queryObj);

	TeamModel getTeamByCode(long code);

	/**
	 * 通过用户信息查询到该用户的班组信息
	 * @param userId
	 * @return
	 */
	public TeamModel getTeamInfoByUserId(String userId);
	
	/**
	 * 通过班组id查询到该班组成员手机号列表,然后通过手机号一一查出userModel装入list集合返回
	 * @param userId
	 * @return
	 */
	public List<UserModel> getTeamMemberListBytId(String tId);

	
	/**
	 * 通过用户id （电话号码）到TeamModel中查询出该用户Id是否是班组长leaderMobile
	 * @param userId
	 * @return
	 */
	public TeamModel getTeamModelByUserId(String userId);
	
	/**
	 * 根据用户id和teamId返回用户状态*
	 **/
	public int findMemberStatus(String userId,String id);
	
	
	/**
	 * 根据班组号查询出班组名称
	 * @param teamCode
	 * @return
	 */
	public String getTeamNameByCode(String teamCode);
	
	/**
	 * 获得申请、历史申请、邀请的班组
	 * @author rkai
	 */
	public List<ApplyIng> personApply(String userId, int status,int pageSize, int pageNow);
	/**
	 * 统计符合条件的班组数
	 * @param userId
	 * @param i
	 * @return
	 */
	public int countUserIdByStatus(String userId, int i);

	/**
	 * 根据用户id和teamId返回班组成员信息*
	 **/
	public TeamMemberModel getTeamMemberByUserIdAndTId(String userId,String tId);

	/**
	 * 根据班组号查询出班组tId   
	 * @param teamCode
	 * @author zss 
	 * @return
	 */
	public String getTIdByCode(String teamCode);

	List<TeamMemberModel> getMemberListBytId(String tId);

	int findMemberBackbone(String userId, String id);

	/**根据文本查询名称或者负责人，街道地址符合搜索条件的班组*/
	public List<TeamModel> getSearchList(String text);

	/**
	 * 添加一个teamMoel
	 * @param teamModel
	 */
	public void addOneTeam(TeamModel teamModel);

	/**
	 * 通过班组长电话获取班组信息
	 * @param userId
	 * @return
	 */
	public TeamModel getTeamByLeaderMobile(String userId);

	List<TeamMemberModel> getTeamMemberByTId(String tId, int status);
	
	
	
	/**
	 * 通过班组名称查询班组信息
	 * @param name
	 * @return
	 */
	public TeamModel getTeamByName(String name);

	
	/**
	 * 修改班组
	 * @param model
	 */
	public void updateTeam(TeamModel model);

	/**
	 * 根据条件查询施工班组
	 * @param queryObj
	 * @return
	 */
	public List<TeamModel> getTeamList(BasicDBObject queryObj);


}
