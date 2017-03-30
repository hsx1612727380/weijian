package com.fengyun.web.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fengyun.web.db.playermodel.TeamMemberModel;

public interface TeamMemberService {
	/**
	 * 查找符合条件的成员（申请中、已加入等）
	 */
	public List<TeamMemberModel> getTeamMemberByTrd(String tId,int status ,int pageSize,int pageNow);
	/**
	 * 统计符合条件的班组成员人数（申请中、已加入等）
	 */
	public int countMember(String trd, int i);
	
	/**
	 * 班组长邀请的工人  信息添加
	 * 在班组号为tId的 teammember中插入该工人的数据 
	 * @author zhengss
	 * @param tId
	 * @param userId
	 * @param date 
	 * @param status = 3 ;(邀请中)
	 * @param backBone = 0； （非骨干成员）
	 */
	public void insert(String tId, String userId, Date date, int status, int backBone);
	
	/**
	 * 更新班组成员的邀请状态（如：剔除、同意加入、邀请等）
	 */
	public void updateStatus(TeamMemberModel model);
	
	/**
	 * 通过id查找TeamMemberModel
	 * @param id
	 * @return
	 */
	public TeamMemberModel getById(String id);

	/**
	 * 邀请工人-zss
	 */
	public String inviteWorker(String userId, String teamUserId, HttpServletRequest request);
	
	/**
	 * 通过班组长电话号码查询班组
	 */
	public TeamMemberModel getByUserId(String userId);
	
	
	/**
	 * 通过班组成员电话和班组id查询班组成员
	 * @param userId
	 * @param id
	 * @return
	 */
	public TeamMemberModel getByUserIdAndtId(String userId, String id);
	
	
	/**
	 * 通过班组成员电话和转态
	 * @param userId
	 * @param id
	 * @return
	 */
	public List<TeamMemberModel> getByTeamMemberIdAndStatus(String userId, int status);
	
	/**
	 * 根据用户的班组ID和其状态查询
	 * @param teamId
	 * @param status
	 * @return
	 */
	public List<TeamMemberModel> getBytIdAndStatus(String teamId, int status);
	
	/**
	 * 判断某个用户是否有当前的班组有关系，即user是否存在Team中
	 * @param userId
	 * @param tId 不加这个条件就是置为null
	 * @param status 1-申请中 2-邀请中 3-已加入 4 -已结束或离开  如果不适用这个字段写-1
	 * @return
	 */
	public TeamMemberModel userIdExistInTeam(String userId, String tId, int status);
	
	/**
	 * 新增
	 * @param teamMemberModel
	 */
	public void addTeamMember(TeamMemberModel teamMemberModel);
	
	
}
