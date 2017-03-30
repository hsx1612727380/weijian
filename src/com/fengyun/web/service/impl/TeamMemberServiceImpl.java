package com.fengyun.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.dao.TeamMemberDAO;
import com.fengyun.web.db.dao.UserDAO;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.service.TeamMemberService;
import com.fengyun.web.service.TeamService;
import com.mongodb.BasicDBObject;



@Service(value="teamMemberService")
public class TeamMemberServiceImpl implements TeamMemberService{

	@Autowired
	private TeamService teamService;
	
	@Override
	public List<TeamMemberModel> getTeamMemberByTrd(String tId,int status,
			int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		if (pageNow <= 0)
			pageNow = 1;
		if (pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return TeamMemberDAO.getTeamMemberByTrd(tId,status,pageSize,skip);
	}

	@Override
	public int countMember(String tId, int status) {
		// TODO Auto-generated method stub
		return (int) TeamMemberDAO.countMember(tId,status);
	}

	/**
	 * 班组长邀请的工人  信息添加
	 * 在班组号为tId的 teammember中插入该工人的数据 
	 * @author zhengss
	 * @param tId
	 * @param userId
	 * @param createTime
	 * @param status = 3 ;(邀请中)
	 * @param backBone = 0； （非骨干成员）
	 */
	@Override
	public void insert(String tId, String userId, Date createTime, int status,
			int backBone) {
		// TODO Auto-generated method stub
		TeamMemberModel teamMemberModel = new TeamMemberModel();
		if(StringUtils.isNotEmpty(tId)){
			teamMemberModel.settId(tId);
		}
		teamMemberModel.setUserId(userId);
		teamMemberModel.setCreateTime(createTime);
		teamMemberModel.setStatus(status);
		teamMemberModel.setBackbone(backBone);
		
		TeamMemberDAO.insert(teamMemberModel);
	}

	@Override
	public void updateStatus(TeamMemberModel model) {
		// TODO Auto-generated method stub
		TeamMemberDAO.updateStatus(model);
	}

	@Override
	public TeamMemberModel getById(String id) {
		// TODO Auto-generated method stub
		return TeamMemberDAO.getById(id);
	}

	/**
	 * 邀请工人 -zss
	 */
	public String inviteWorker(String userId, String teamUserId,HttpServletRequest request) {
		String tId = teamService.getTeamInfoByUserId(teamUserId).getId();
		//查询本班组已经邀请过等待回复的工人Parameters:tId status	pageSize pageNow  
		//要借助getTeamMemberByTrd方法查出所有，因此将pagesize设置成很大的数字 
		List<TeamMemberModel>  invitedWorker = this.getTeamMemberByTrd(tId, 0, 1000, 1);
		boolean flag = false;
		String msg = "已发出邀请！";
		for (TeamMemberModel teamMemberModel : invitedWorker) {
			if(userId.equals(teamMemberModel.getUserId())){
				flag = true;
				//如果对方的status
				if(1==teamMemberModel.getStatus()){
					msg = "对方正在申请加入本班组，请到‘工人申请列表’模块‘接受申请’";
				}else if(2==teamMemberModel.getStatus()){
					msg = "您已邀请过该用户！";
				}else if(3==teamMemberModel.getStatus()){
					msg = "该用户已在本班组！";
				}
			}
		}
		if(flag){
			request.setAttribute("msg", msg);
		}else{
			//如果未邀请过则 执行邀请操作
			this.insert(tId,userId,new Date(),2 ,0);
		}
		return msg;
	}

	@Override
	public TeamMemberModel getByUserId(String userId) {
		// TODO Auto-generated method stub
		return TeamMemberDAO.getByUserId(userId);
	}

	@Override
	public TeamMemberModel getByUserIdAndtId(String userId, String id) {
		// TODO Auto-generated method stub
		return TeamMemberDAO.getByTIdAndUserId(id, userId);
	}

	
	@Override
	public List<TeamMemberModel> getByTeamMemberIdAndStatus(String userId, int status) {
		// TODO Auto-generated method stub
		return TeamMemberDAO.getByTeamMemberIdAndStatus(userId, status);
	}

	/**
	 * 根据用户的班组ID和其状态查询
	 */
	@Override
	public List<TeamMemberModel> getBytIdAndStatus(String teamId, int status) {
		return TeamMemberDAO.getBytIdAndStatus(teamId, status);
	}

	/**
	 * 根据用户的ID、班组的ID、状态status查询用户是否存在班组中
	 */
	@Override
	public TeamMemberModel userIdExistInTeam(String userId, String tId, int status) {
		return TeamMemberDAO.getByUserIdAndTIdAndStatus(userId, tId, status);
	}
	
	/**
	 * 新增
	 */
	@Override
	public void addTeamMember(TeamMemberModel teamMemberModel) {
		TeamMemberDAO.addTeamMember(teamMemberModel);
	}




	
}
