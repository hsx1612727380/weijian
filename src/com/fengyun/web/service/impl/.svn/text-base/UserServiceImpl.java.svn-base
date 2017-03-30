package com.fengyun.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.CompanyDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.dao.UserDAO;
import com.fengyun.web.db.playermodel.CompanyModel;
import com.fengyun.web.db.playermodel.PersonModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.RequirementsModel;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.RequirementsService;
import com.fengyun.web.service.TeamMemberService;
import com.fengyun.web.service.TeamService;
import com.fengyun.web.service.UserService;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

@Service
public class UserServiceImpl implements UserService {
	

	@Autowired
	private TeamService teamService;
	
	@Autowired
	private TeamMemberService teamMemberService;
	
	@Autowired
	private ProjectDepartmentService projectDepartmentService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private RequirementsService requirementsService;
	
	/**
	 * 通过userId和password查询得到一个company对象
	 * 如果公司用户未查到，再去查询普通用户
	 */
	@Override
	public Object checkLogonByPhone(String userId, String password ) {
		// TODO Auto-generated method stub
		//通过userId和password查询得到一个company对象
		Object obj = getCompanyModel(userId, password);
		//如果公司用户未查到，再去查询普通用户
		if(obj == null ){
			obj=UserDAO.checkLogonByPhone(userId,password);
		}
		System.out.println("用户userService中查到的对象："+obj);
		return obj;
	}
	
	/**
	 * 通过userIdentity和password查询得到一个company对象
	 */
	@Override
	public Object checkLogonByIdentity(String userIdentity, String password ) {
		// TODO Auto-generated method stub
		//通过userId和password查询得到一个company对象
		Object obj = UserDAO.checkLogonByIdentity(userIdentity,password);
		return obj;
	}

	/**
	 * 通过userId和password查询得到一个company对象
	 * @param userId
	 * @param password
	 * @return
	 */
	public CompanyModel getCompanyModel(String userId, String password){
		return CompanyDAO.getModelByUserIdAndPassword(userId, password);
	}
	
	@Override
	public List<UserModel> listUser(int row, int skip) {
		// TODO Auto-generated method stub
		return UserDAO.listAdmin(row, skip);
	}

	@Override
	public void addUser(UserModel userModel) {
		UserDAO.addUser(userModel);
	}

	
	@Override
	public String mobilRepCHeck(String mobilPhone) {
		String isRep = "0";
		if (UserDAO.mobilRepCHeck(mobilPhone) == null) {
			isRep = "1";
		}
		// TODO Auto-generated method stub
		return isRep;
	}

	@Override
	public List<UserModel> getUserList(BasicDBObject queryObj, int pageNow,
			int pageSize) {
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return UserDAO.getAll(queryObj,pageSize, skip);
	}

	@Override
	public long countAllUser(BasicDBObject queryObj) {
		return UserDAO.countAll(queryObj);
	}

	@Override
	public void delUser(String id) {
		UserDAO.delete(id);
	}

	@Override
	public UserModel getByUserId(String userId) {
		return UserDAO.getByUserId(userId);
	}


	@Override
	public void updateUser(UserModel model) {
		// TODO Auto-generated method stub
		UserDAO.update(model);
		
	}

	@Override
	public List<UserModel> getSearchList(String text) {
		Pattern pattern = Pattern.compile(".*"+text+".*", Pattern.CASE_INSENSITIVE);
		BasicDBObject queryObj = new BasicDBObject(5);
		
		BasicDBList values = new BasicDBList();
	    values.add(new BasicDBObject("userName", pattern));
	    values.add(new BasicDBObject("userStreet", pattern)); 
	    queryObj.put("$or", values); 
	    return UserDAO.getByQueryObj(queryObj);
	}

	/**
	 * 统计符合条件的用户数量 -zss
	 */
	@Override
	public long countUserByConditions(
			String userId, String userProvince, String userStatus, int reliableStar, String userType) {
		// TODO Auto-generated method stub 
		BasicDBObject queryObj = createQueryObj(
				userId, userProvince,userStatus,reliableStar,userType);
		long countAll = UserDAO.countAll(queryObj);
		return countAll;
	}
	
	//构建查询对象 -zss
	private BasicDBObject createQueryObj(String userId, String userProvince, String userStatus, int reliableStar, String userType) {
		BasicDBObject queryObj = new BasicDBObject(6);
		queryObj.put("userStatus", userStatus);
		if(StringUtils.isNotEmpty(userId)){
			queryObj.put("userId", userId);
		}
		if(StringUtils.isNotEmpty(userProvince)&&!"000000".equals(userProvince)){
			queryObj.put("userProvince", userProvince);
		}
		if((reliableStar>0)&&(reliableStar<6)){
			queryObj.put("reliableStar", reliableStar);
		}
		queryObj.put("userType", userType);
		return queryObj;
	}

	/**
	 * 获取符合条件的用户list -zss
	 */
	@Override
	public List<UserModel> getUserListByConditions(HttpSession session, String userId, String userProvince,
			String userStatus, int reliableStar, String userType, int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		BasicDBObject queryObj = createQueryObj(
				userId, userProvince, userStatus,reliableStar,userType);
		List<UserModel> list = UserDAO.getAll(queryObj, pageSize, skip);
		
		TeamModel teamModel = teamService.getTeamByLeaderMobile(String.valueOf(session.getAttribute("userId")));
//		List<UserModel> list2 = teamService.getTeamMemberListBytId(teamModel.getId());//不需要了，因为在班组中的工人都已经在职了，查不到。
//		挨个对比、剔除已在班组中的工人。即teamMember中有的都要剔除
		Iterator<UserModel> iterator1 = list.iterator();
		while(iterator1.hasNext()){
			UserModel next = iterator1.next();
			String userid = next.getUserId();
			TeamMemberModel teamMemberModel = teamMemberService.getByUserId(userid);
			if(teamMemberModel!=null){//如果在teamMemberModel中查到了这个人，说明已经加入班组了，就剔除
				iterator1.remove();
			}
		}
		
		return list;
	}

	/**
	 * 企业中心添加项目负责人联系方式时判断是否注册，如果没有注册，给其注册，如果是普通用户，将其修改为项目负责人
	 * @param userId
	 * @param leaderName
	 * @return
	 */
	@Override
	public String regCompanyProjectUserId(String userId, String leaderName) {
		String result = "0";
		UserModel userModel = UserDAO.getByUserId(userId);
		if (userModel == null) {
			userModel = new UserModel();
			userModel.setUserId(userId);
			userModel.setUserName(leaderName);
			userModel.setUserType("4");
			userModel.setUserPassword("123456");
			userModel.setCreateTime(new Date());
			UserDAO.insert(userModel);
			result = "1";
		} else {
			String userType = userModel.getUserType();
			if ("0".equals(userType)) {
				userModel.setUserType("4");
				UserDAO.update(userModel);
				result = "1";
			}
		}
		return result;
	}

	@Override
	public int identityRep(String identity, String userId) {
		// TODO Auto-generated method stub
		int isRep=0;
		UserModel model=UserDAO.getUserByUseridAndIdentity(identity, userId);
		if(UserDAO.getUserByUseridAndIdentity(identity, userId)!=null)
		{
			isRep=1;
		}
		return isRep;
	}

	@Override
	public int identityHaveReg(String identity) {
		// TODO Auto-generated method stub
		int isRep=0;
		if(UserDAO.getUserByIdentity(identity)!=null)
		{
			isRep=1;
		}
		return isRep;
	}

	/**
	 * 获取(并返回)已加入的项目的名称
	 */
	@Override
	public String getInvolvedProjectName(String userId,String isLeader) {
		//如果是班组长就查出班组model记录，获取tId
		String tId = null;
		String pName = null;
		if("1".equals(isLeader)){//是班组长
			TeamModel teamModel = teamService.getTeamByLeaderMobile(userId);
			tId = teamModel.getId();
			//通过tId、type=1(班组)，status=3（已加入项目）到projectDepartment表中查出一个model
			ProjectDepartmentModel pdModel = projectDepartmentService.getByVIdAndPIdAndStatusAndType(tId, null, 3, 1);
			//(如果已经加入了项目pdModel不为空)就从pdModel中取出pId
			if(pdModel!=null){
				String pId = pdModel.getpId();
				//通过pId获取项目Model
				ProjectModel projectModel = projectService.getById(pId);
				//获取modelz中项目的名字
				pName = projectModel.getName();
			}
		}else if("0".equals(isLeader)||"2".equals(isLeader)){//对于未加入班组-0，所在项目显示空；非班组长的班组成员-2，就显示所在的班组名称
			
			TeamMemberModel teamMemberModel = teamMemberService.userIdExistInTeam(userId, tId, 3);//getByUserId(userId);
			if(teamMemberModel!=null){
				tId = teamMemberModel.gettId();
				TeamModel teamModel = teamService.getTeamById(tId);
				if(teamModel !=null){
					pName = teamModel.getName();
				}
			}
		}
		return pName;
	}

	
	@Override
	public boolean changeJobStatus(String userId, String userType, String isLeader, int getOrLose) {
		// TODO Auto-generated method stub
		if(userType=="0"){//工人、班组长
			if("1".equals(isLeader)){
				TeamModel teamModel = teamService.getTeamByLeaderMobile(userId);
				String tId = teamModel.getId();
				PersonModel personModel = personService.getById(tId);
				if(getOrLose==1){
					personModel.setJobstatus("2");
				}else if(getOrLose==0){
					personModel.setJobstatus("1");
				}
			}
			PersonModel personModel = personService.getById(userId);
			UserModel userModel = this.getByUserId(userId);
			if(getOrLose==1){
				personModel.setJobstatus("2");
				userModel.setUserStatus("2");
			}else if(getOrLose==0){
				personModel.setJobstatus("1");
				userModel.setUserStatus("1");
			}
		}else{//材料商、设备商
			UserModel userModel = this.getByUserId(userId);
			if(getOrLose==1){
				userModel.setUserStatus("2");
			}else if(getOrLose==0){
				userModel.setUserStatus("1");
			}
		}
		return true;
	}

	/**
	 * 根据用户ID查询User
	 */
	@Override
	public UserModel regUserIdExist(String userId) {
		return UserDAO.getByUserId(userId);
	}

	/**
	 * 通过班组id（rId）、信息类型int 2（招聘）、招聘状态int 1（开放）
	 */
	@Override
	public List<RequirementsModel> getTeamRecruiteList(HttpSession session) {
		// TODO Auto-generated method stub
		String userId = (String) session.getAttribute("userId"); 
		TeamModel teamModel = teamService.getTeamByLeaderMobile(userId);
		String tId = null;
		if(teamModel!=null){
			tId = teamModel.getId();
		}
		int type=2 , status=1;
		//如果需要分页查询的话
		//List<RequirementsModel> list = requirementsService.getRequirements(rId, null, -1, status, type, -1, rId, pageNow, pageSize)
		List<RequirementsModel> list = requirementsService.getByRIdAndTypeAndStatus(tId, type, status,tId);
		return list;
	}

	@Override
	public boolean addRequirement(RequirementsModel requirement) {
		// TODO Auto-generated method stub
		requirementsService.addRequirementsModel(requirement);
		return false;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		//requirementsService.delById(id);//物理删除
		requirementsService.updateStatus(id, 0);//逻辑删除
	}

	/**
	 * 获取已经参加过的或正在参加的项目list-zss
	 */
	@Override
	public Map<ProjectModel,ProjectDepartmentModel> getCurrentProject(HttpSession session, int type, int status) {
		// TODO Auto-generated method stub
		String userId = (String) session.getAttribute("userId");
		TeamModel teamModel = teamService.getTeamByLeaderMobile(userId);
		String vId = null;
		if(teamModel!=null){
			vId = teamModel.getId();
		}
		List<ProjectDepartmentModel> list = projectDepartmentService.getProjectByTIdStatus(vId,type,status);
		Map<ProjectModel,ProjectDepartmentModel> pMap = new HashMap();
		for (ProjectDepartmentModel projectDepartment : list) {
			String pId = projectDepartment.getpId();
			ProjectModel projectModel = projectService.getById(pId);
			pMap.put(projectModel,projectDepartment);
		}
		return pMap;
	}

	/**
	 * 根据身份证查询User
	 */
	@Override
	public UserModel getByUserIdentity(String userIdentity) {
		return UserDAO.getUserByIdentity(userIdentity);
	}
	
	
	
	
	
}