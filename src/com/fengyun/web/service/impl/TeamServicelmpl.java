package com.fengyun.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.dao.TeamDAO;
import com.fengyun.web.db.dao.TeamMemberDAO;
import com.fengyun.web.db.dao.UserDAO;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.service.TeamService;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

@Service(value = "teamService")
public class TeamServicelmpl implements TeamService {

	
	
	/**
	 * 新增
	 */
	@Override
	public boolean addTeam(String name, String leaderName,
			String leaderMobile, int skillBigType, int skillSmallType,
			int status, String province, String city, String street) {
		//查询是否有该用户
		UserModel userModel = UserDAO.getByUserId(leaderMobile);
		if(userModel == null){
			//加入系统用户
			userModel = new UserModel();
			userModel.setUserId(leaderMobile);
			userModel.setUserName(leaderName);
			UserDAO.insert(userModel);
		}
			
		TeamModel model = new TeamModel();
		model.setName(name);
		model.setLeaderName(leaderName);
		model.setLeaderMobile(leaderMobile);
		model.setSkillBigType(skillBigType);
		model.setSkillSmallType(skillSmallType);
		model.setStatus(status);
		model.setProvince(province);
		model.setCity(city);
		model.setStreet(street);
		model.setCreateTime(new Date());
		try {
			TeamDAO.insert(model);
			
			//把班组长加到班组成员里面来
			TeamMemberModel memberModel = new TeamMemberModel();
			memberModel.settId(model.getId());
			memberModel.setUserId(leaderMobile);
			memberModel.setStatus(3);
			TeamMemberDAO.insert(memberModel);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	/**
	 * 删除班组
	 */

	@Override
	public void delTeam(String id) {
		//先删除班组成员
		List<TeamMemberModel> teamMembers = TeamMemberDAO.getByTId(id);
		if(teamMembers != null && teamMembers.size() > 0){
			for(TeamMemberModel model:teamMembers){
				TeamMemberDAO.delete(model.getId());
			}
		}
		//再删除班组Model
		TeamDAO.delete(id);
	}

	/**
	 * 新增班组成员
	 */
	@Override
	public boolean addTeamMember(String id, String userId,int status) {
		// 是否可以加入多个班组(保留)
		try {
			// 查询班组是否存在
			
			TeamModel model = (TeamModel) TeamDAO.getById(id);
			if (model == null)
				return false;
			TeamMemberModel memberModel = new TeamMemberModel();
			memberModel.settId(id);
			memberModel.setStatus(status);
			memberModel.setUserId(userId);
			memberModel.setCreateTime(new Date());
			TeamMemberDAO.insert(memberModel);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 从teamMember中删除班组成员，同时将被删除的userModel的userStatus状态由2（在职）改成1（找工作）
	 */
	@Override
	public void delTeamMember(String tId, String userId) {
		TeamMemberModel model = TeamMemberDAO.getByTIdAndUserId(tId, userId);
		//删除TeamMember表中的成员
		TeamMemberDAO.delete(model.getId());
		UserModel userModel = UserDAO.getByUserId(userId);
		userModel.setUserStatus("1");
		//修改userModel的userStatus
		UserDAO.update(userModel);
	}
	
	@Override
	public List<TeamModel> getTeamList(BasicDBObject queryObj, int pageNow,
			int pageSize) {
		if (pageNow <= 0)
			pageNow = 1;
		if (pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		List<TeamModel> list = TeamDAO.getAll(queryObj, pageSize, skip);
		//统计班组人数
		if(list != null && !list.isEmpty()){
			for(TeamModel model:list){
				model.setNum(TeamMemberDAO.countMember(model.getId(), 3));
			}
		}
		return list;
	}

	/**
	 * 新增（以对象的形式）
	 */
	@Override
	public void insertTeam(TeamModel model) {
		TeamDAO.insert(model);
	}

	/**
	 * 邀请人员加入班组
	 */
	@Override
	public void inviteTeamMember(String tId, String userId, int status) {
		// 57fc8f2f4e2847dd95e3c8bc
		TeamMemberModel model = new TeamMemberModel();
		model.settId(tId);
		model.setUserId(userId);
		model.setStatus(status);
		TeamMemberDAO.insert(model);
	}

	
	@Override
	public Boolean passTeamMember(String teamMemberId,int status) {
		return TeamMemberDAO.updateTeamMemberStatus(teamMemberId,status);
	}

	/**
	 * 查询班组下的班组成员
	 */
	@Override
	public List<UserModel> selectMember(String tId) {
		List<TeamMemberModel> members = TeamMemberDAO.getByTId(tId);
		if (members != null && members.size() > 0) {
			List<UserModel> userList = new ArrayList<UserModel>();
			for (TeamMemberModel tModel : members) {
				UserModel uModel = UserDAO.getByUserId(tModel.getUserId()
						.trim());
				if (uModel != null)
					userList.add(uModel);
			}
			return userList;
		}
		return null;
	}

	@Override
	public long countAllTeam(BasicDBObject queryObj) {
		return TeamDAO.countAll(queryObj);
	}

	@Override
	public TeamModel getTeamById(String id) {
		return TeamDAO.getById(id);
	}
	
	
	@Override
	public TeamModel getTeamByCode(long code) {
		return TeamDAO.getByCode(code);
	}

	/**
	 * 查看班组成员
	 * 通过班组id查询到该班组成员手机号列表,然后通过手机号一一查出userModel装入list集合返回
	 * userIdList-->tmModelList-->userModelList
	 * @param userId
	 * @return
	 */
	@Override
	public List<UserModel> getTeamMemberListBytId(String tId) {
		// TODO Auto-generated method stub
		List<UserModel> userModelList = new ArrayList<UserModel>();
		//查询所有tId班组号相同的teamModel对象集合list
		List<TeamMemberModel> tmModelList = TeamMemberDAO.getByTIdAndStatus3(tId);
		//将teamModel对象一一取出 装入userIdList
		for(int i=0;i<tmModelList.size();i++){
			String userId = tmModelList.get(i).getUserId();
			UserModel userModel = UserDAO.getByUserId(userId);
			userModelList.add(userModel);
		}
		return userModelList;
	}
	
	@Override
	public List<TeamMemberModel> getMemberListBytId(String tId){
		List<TeamMemberModel> list = TeamMemberDAO.getByMemberTId(tId);
		
		
		return list;
	}
	
	
	

	@Override
	public int findMemberStatus(String id,String userId) {
		// TODO Auto-generated method stub
		TeamMemberModel model=TeamMemberDAO.getByTIdAndUserId(id, userId);
		if(model!=null)
		{
			return model.getStatus();
		}
		return 0;
	}
	
	
	@Override
	public int findMemberBackbone(String userId,String id) {
		// TODO Auto-generated method stub
		TeamMemberModel model=TeamMemberDAO.getByTIdAndUserId(id, userId);
		if(model!=null)
		{
			return model.getBackbone();
		}
		return 0;
	}

	/**
	 * 
	 * 通过登录用户的userId(电话号码)到班组team表中查询出是否是班组长，返回teamModel
	 */
	@Override
	public TeamModel getTeamModelByUserId(String userId) {
		// TODO Auto-generated method stub
		TeamModel teamModel = TeamDAO.getByLeaderMobile(userId);
		return teamModel;
	}


	
	@Override
	public List<ApplyIng> personApply(String userId,int status,int pageSize, int pageNow)  {
		int skip=(pageNow-1)*pageSize;
		List<TeamMemberModel> applyIngList=TeamMemberDAO.getApplyTeam(userId,status,pageSize,skip);
		List<ApplyIng> tlist= new ArrayList<ApplyIng>();
		for(TeamMemberModel model:applyIngList)
		{
			TeamModel teamModel=this.getTeamById(model.gettId()); 
			ApplyIng applytIng=new ApplyIng();
			applytIng.setCreateTime(model.getCreateTime());
			applytIng.setTeamMemberID(model.getId());
			applytIng.settModel(teamModel);
			tlist.add(applytIng);
		}
		return tlist;
	}
	
	/**
	 * * 内部辅助类 记录正在申请的班组
	 * @author rkai
	 
	 */
	public class ApplyIng{
		TeamModel tModel;
		Date createTime;//注册时间
		String teamMemberID;//班组成员id
		public String getTeamMemberID() {
			return teamMemberID;
		}
		public void setTeamMemberID(String teamMemberID) {
			this.teamMemberID = teamMemberID;
		}
		public TeamModel gettModel() {
			return tModel;
		}
		public void settModel(TeamModel tModel) {
			this.tModel = tModel;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
	
		
	}
	
	/**
	 * 查询出班组名称
	 * @param teamCode
	 * @return
	 */
	@Override
	public String getTeamNameByCode(String teamCode) {
		// TODO Auto-generated method stub
		TeamModel teamModel= null;
		if(!StringUtils.isEmpty(teamCode)){
			teamModel = this.getTeamByCode(Long.valueOf(teamCode));
		}
		String teamName = null;
		if (teamModel!=null) {
			teamName = teamModel.getName();
		}
		return teamName; 
	}


	/**
	 * 通过用户信息查询到该用户的班组信息
	 * @param userId
	 * @return
	 */
	@Override
	public TeamModel getTeamInfoByUserId(String userId) {
		// TODO Auto-generated method stub
		//通过班组长的电话在team表中查出来该班组的信息
		TeamModel teamModel  = TeamDAO.getByLeaderMobile(userId);
		return teamModel;
	}

	@Override
	public void rejectInvite(String teamMemberId) {
		// TODO Auto-generated method stub
		TeamMemberDAO.delete(teamMemberId);
	}

	@Override
	public TeamMemberModel getTeamMemberByUserIdAndTId(String userId, String tId) {
		// TODO Auto-generated method stub
		return TeamMemberDAO.getByTIdAndUserId(tId, userId);
	}

	/**
	 * 根据班组号查询出班组tId   
	 * @param teamCode
	 * @author zss 
	 * @return
	 */
	@Override
	public String getTIdByCode(String teamCode) {
		// TODO Auto-generated method stub
		TeamModel teamModel= null;
		if(!StringUtils.isEmpty(teamCode)){
			teamModel = this.getTeamByCode(Long.valueOf(teamCode));
		}
		String tId = null;
		if (teamModel!=null) {
			tId = teamModel.getId();
		}
		return tId; 
	}
	
	@Override
	public int countUserIdByStatus(String userId, int status) {
		// TODO Auto-generated method stub
		return (int) TeamMemberDAO.countUserIdByStatus(userId, status);
	}

	@Override
	public List<TeamModel> getSearchList(String text) {
		Pattern pattern = Pattern.compile(".*"+text+".*", Pattern.CASE_INSENSITIVE);
		BasicDBObject queryObj = new BasicDBObject(5);
		
		BasicDBList values = new BasicDBList();  
	    values.add(new BasicDBObject("name", pattern));
	    values.add(new BasicDBObject("leaderName", pattern)); 
	    values.add(new BasicDBObject("street", pattern)); 
	    queryObj.put("$or", values); 
	    return TeamDAO.getByQueryObj(queryObj);
	}
	

	/**
	 * 添加一个新班组信息
	 */
	@Override
	public void addOneTeam(TeamModel teamModel) {
		// TODO Auto-generated method stub
		this.addTeam( teamModel.getName(),  teamModel.getLeaderName(),
				teamModel.getLeaderMobile(),  teamModel.getSkillBigType(),  teamModel.getSkillSmallType(),
				teamModel.getStatus(), teamModel.getProvince(), teamModel.getCity(), teamModel.getStreet());
		
	}

	/**
	 * 通过班长的的电话号leadrMoil（就是userId）查询这个班组信息。
	 * 
	 */
	@Override
	public TeamModel getTeamByLeaderMobile(String userId) {
		// TODO Auto-generated method stub
		TeamModel teamModel = TeamDAO.getTeamByUserId(userId);
		return teamModel;
	}
	
	/**
	 * 通过班组id查询班组下某状态的成员
	 */
	@Override
	public List<TeamMemberModel> getTeamMemberByTId(String tId,int status ){
		return TeamMemberDAO.getByTId(tId, status);
	}
	
	/**
	 * 通过班组名称查询班组信息
	 */
	@Override
	public TeamModel getTeamByName(String name) {
		
		return TeamDAO.getTeamByName(name);
	}

	/**
	 * 修改班组
	 */
	@Override
	public void updateTeam(TeamModel model) {
		 TeamDAO.update(model);
		
	}

	/**
	 * 根据条件查询施工班组
	 */
	@Override
	public List<TeamModel> getTeamList(BasicDBObject queryObj) {
		return TeamDAO.getTeamList(queryObj);
	}

	
	
}
