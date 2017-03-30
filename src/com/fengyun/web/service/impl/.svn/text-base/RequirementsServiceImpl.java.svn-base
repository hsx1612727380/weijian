package com.fengyun.web.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.cache.page.PageHandler;
import com.fengyun.web.db.dao.EquipmentDAO;
import com.fengyun.web.db.dao.MaterialDAO;
import com.fengyun.web.db.dao.ProjectDAO;
import com.fengyun.web.db.dao.RequirementsDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.dao.TeamDAO;
import com.fengyun.web.db.dao.TeamMemberDAO;
import com.fengyun.web.db.dao.UserDAO;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.RequirementsModel;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.hardcode.ESessionKey;
import com.fengyun.web.service.RequirementsService;
import com.mongodb.BasicDBObject;

@Service
public class RequirementsServiceImpl implements RequirementsService {

	public long countAll(BasicDBObject queryObj) {
		return RequirementsDAO.countAll(queryObj);
	}

	@Override
	public List<RequirementsModel> getList(BasicDBObject queryObj, int pageNow,
			int pageSize) {
		if (pageNow <= 0)
			pageNow = 1;
		if (pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return RequirementsDAO.getAll(queryObj, pageSize, skip);
	}
	
	@Override
	public RequirementsModel getRecruitByTeamId(String tId,int type) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("rId", tId);
		queryObj.put("type", type);
		queryObj.put("teamType", 1);
		return RequirementsDAO.getOne(queryObj);
	}

	@Override
	public void persoonApplyTeam(String userId, String tId) {
		TeamMemberModel model = TeamMemberDAO.getByTIdAndUserId(tId, userId);
		if (model != null) {
			model.setStatus(1);
			TeamMemberDAO.updateStatus(model);

		} else {
			model = new TeamMemberModel();
			model.setStatus(1);
			model.settId(tId);
			model.setUserId(userId);
			TeamMemberDAO.insert(model);
		}

	}

	@Override
	public RequirementsModel getById(String id) {
		return RequirementsDAO.getById(id);
	}

	@Override
	public void delById(String id) {
		RequirementsDAO.delete(id);
	}

	@Override
	public void updateStatus(String id, int status) {
		// TODO Auto-generated method stub
		RequirementsModel model = RequirementsDAO.getById(id);
		if(model != null){
			RequirementsDAO.updateStatus(model, status);
		}
	}

	@Override
	public void addRecruitPerson(String title, String code,
			String skillBigType, String smalltype, String num, String province,
			String city,String street,String desc) {
		// TODO Auto-generated method stub
		//判断班组存在
		TeamModel tModel = TeamDAO.getByCode(Long.valueOf(code));
		if(tModel == null)
			return;
		RequirementsModel model = new RequirementsModel();
		model.setTitle(title);
		model.setrId(tModel.getId());
		model.setName(tModel.getName());
		model.setLeaderName(tModel.getLeaderName());
		model.setType(2);
		model.setUserType(2);
		model.setTeamType(1);
		model.setNum(Integer.valueOf(num));
		model.setSkillBigType(Integer.valueOf(skillBigType));
		model.setSkillSmallType(Integer.valueOf(smalltype));
		model.setProvince(province);
		model.setCity(city);
		model.setStatus(1);
		model.setDesc(desc);
		model.setStreet(street);
		RequirementsDAO.insert(model);
		
	}

	@Override
	public void addRecruitTeam(String title, String code, String skillBigType,
			String smalltype, String province, String city, String street,String desc) {
		// TODO Auto-generated method stub
		//判断项目存在
		ProjectModel pModel = ProjectDAO.getByPCode(code);
		if(pModel == null)
			return;
		RequirementsModel model = new RequirementsModel();
		model.setTitle(title);
		model.setrId(pModel.getId());
		model.setName(pModel.getName());
		model.setLeaderName(pModel.getLeaderName());
		model.setType(2);
		model.setUserType(3);
		model.setTeamType(1);
		model.setSkillBigType(Integer.valueOf(skillBigType));
		model.setSkillSmallType(Integer.valueOf(smalltype));
		model.setProvince(province);
		model.setCity(city);
		model.setStatus(1);
		model.setDesc(desc);
		model.setStreet(street);
		RequirementsDAO.insert(model);
	}

	@Override
	public void addRecruitMaterial(String title, String code, String shopName,
			String province, String city, String street,String desc) {
		// TODO Auto-generated method stub
		//判断项目存在
		ProjectModel pModel = ProjectDAO.getByPCode(code);
		if(pModel == null)
			return;
		RequirementsModel model = new RequirementsModel();
		model.setTitle(title);
		model.setrId(pModel.getId());
		model.setName(pModel.getName());
		model.setLeaderName(pModel.getLeaderName());
		model.setType(2);
		model.setUserType(3);
		model.setTeamType(2);
		model.setShopName(shopName);
		model.setProvince(province);
		model.setCity(city);
		model.setStatus(1);
		model.setDesc(desc);
		model.setStreet(street);
		RequirementsDAO.insert(model);
	}

	@Override
	public void addRecruitEquip(String title, String code, String shopName,
			String province, String city, String street,String desc) {
		// TODO Auto-generated method stub
		//判断项目存在
		ProjectModel pModel = ProjectDAO.getByPCode(code);
		if(pModel == null)
			return;
		RequirementsModel model = new RequirementsModel();
		model.setTitle(title);
		model.setrId(pModel.getId());
		model.setName(pModel.getName());
		model.setLeaderName(pModel.getLeaderName());
		model.setType(2);
		model.setUserType(3);
		model.setTeamType(3);
		model.setShopName(shopName);
		model.setProvince(province);
		model.setCity(city);
		model.setStatus(1);
		model.setDesc(desc);
		model.setStreet(street);
		RequirementsDAO.insert(model);
	}

	@Override
	public void addJobPerson(String title, String userId, String skillBigType,
			String smalltype, String province, String city, String street,String desc) {
		// TODO Auto-generated method stub
		//查询是否存在该用户
		UserModel uModel = UserDAO.getByUserId(userId);
		if(uModel == null)
			return;
		RequirementsModel model = new RequirementsModel();
		model.setTitle(title);
		model.setrId(userId);
		model.setName(uModel.getUserName());
		model.setType(1);
		model.setUserType(1);
		model.setSkillBigType(Integer.valueOf(skillBigType));
		model.setSkillSmallType(Integer.valueOf(smalltype));
		model.setProvince(province);
		model.setCity(city);
		model.setStatus(1);
		model.setDesc(desc);
		model.setStreet(street);
		RequirementsDAO.insert(model);
	}

	@Override
	public void addJobTeam(String title, String code, String skillBigType,
			String smalltype, String province, String city, String street,String desc) {
		// TODO Auto-generated method stub
		//判断班组存在
		TeamModel tModel = TeamDAO.getByCode(Long.valueOf(code));
		if(tModel == null)
			return;
		RequirementsModel model = new RequirementsModel();
		model.setTitle(title);
		model.setrId(tModel.getId());
		model.setName(tModel.getName());
		model.setLeaderName(tModel.getLeaderName());
		model.setType(1);
		model.setUserType(2);
		model.setTeamType(1);
		model.setSkillBigType(Integer.valueOf(skillBigType));
		model.setSkillSmallType(Integer.valueOf(smalltype));
		model.setProvince(province);
		model.setCity(city);
		model.setStatus(1);
		model.setDesc(desc);
		model.setStreet(street);
		RequirementsDAO.insert(model);
	}

	@Override
	public void addJobMaterial(String title, String code, String shopName,
			String province, String city, String street,String desc) {
		// TODO Auto-generated method stub
		//判断材料商存在
		MaterialModel mModel = MaterialDAO.getByCode(code);
		if(mModel == null)
			return;
		RequirementsModel model = new RequirementsModel();
		model.setTitle(title);
		model.setrId(mModel.getId());
		model.setName(mModel.getName());
		model.setLeaderName(mModel.getLeaderName());
		model.setType(1);
		model.setUserType(2);
		model.setTeamType(2);
		model.setShopName(shopName);
		model.setProvince(province);
		model.setCity(city);
		model.setStatus(1);
		model.setDesc(desc);
		model.setStreet(street);
		RequirementsDAO.insert(model);
	}
	
	@Override
	public void addJobEquip(String title, String code, String shopName,
			String province, String city, String street,String desc) {
		// TODO Auto-generated method stub
		//判断材料商存在
		EquipmentModel eModel = EquipmentDAO.getByCode(code);
		if(eModel == null)
			return;
		RequirementsModel model = new RequirementsModel();
		model.setTitle(title);
		model.setrId(eModel.getId());
		model.setName(eModel.getName());
		model.setLeaderName(eModel.getLeaderName());
		model.setType(1);
		model.setUserType(2);
		model.setTeamType(3);
		model.setShopName(shopName);
		model.setProvince(province);
		model.setCity(city);
		model.setStatus(1);
		model.setDesc(desc);
		model.setStreet(street);
		RequirementsDAO.insert(model);
	}

	/**
	 * 提交对项目求职申请
	 * @param session
	 * @param requireModel
	 */
	@Override
	public void saveApply(HttpSession session, RequirementsModel requireModel) {
		// TODO Auto-generated method stub
		String teamCode = String.valueOf(session.getAttribute(ESessionKey.TeamCode.key));
		Long code = Long.valueOf(teamCode);
		TeamModel teamModel = TeamDAO.getByCode(code);
		RequirementsModel model = new RequirementsModel();
		model.setTitle(requireModel.getTitle());
		model.setrId(teamModel.getId());
		model.setName(teamModel.getName());
		model.setLeaderName(teamModel.getLeaderName());
		model.setType(1);
		model.setUserType(2);
		model.setTeamType(1);
		model.setProvince(requireModel.getProvince());
		model.setCity(requireModel.getCity());
		model.setSkillBigType(requireModel.getSkillBigType());
		model.setSkillSmallType(requireModel.getSkillSmallType());
		model.setStatus(1);
		model.setCreateTime(new Date());
		model.setDesc(requireModel.getDesc());
		model.setStreet(requireModel.getStreet());
		RequirementsDAO.insert(model);
	}

	/**
	 * 通过类型标记查询出 【班组】正在【申请】的 项目
	 * @param type == 1 
	 * @param userType == 2
	 * @return List<RequirementsModel>
	 */
	@Override
	public Map<Page,List<RequirementsModel>> getRequirement(int pageSize,
			int pageNow,int type, int userType,int teamType,int status,String tId) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject(5);
		queryObj.put("type", type);
		queryObj.put("userType", userType);
		queryObj.put("teamType", teamType);
		queryObj.put("status", status);
		queryObj.put("rId", tId);
		Long dataCount = RequirementsDAO.countAll(queryObj);
		//每页10条数据，第1页开始
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		
		List<RequirementsModel> list = this.getList(queryObj, page.getPageNow(), page.getPageSize());
		Map<Page, List<RequirementsModel>> map = new HashMap<Page,List<RequirementsModel>>();
		map.put(page, list);
		return map;
	}

	/**
	 * 分页统计正在招聘（劳务班组/材料上/设备商）的项目
	 */
	@Override
	public long count(int type, int userType,int teamType,int status,
			String province, String city,String name,String leaderName) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = getQueryObj(type, userType, teamType, status,
				province, city, name, leaderName);
		Long dataCount = RequirementsDAO.countAll(queryObj);
		return dataCount;
	}

	public BasicDBObject getQueryObj(int type, int userType, int teamType,
			int status, String province, String city, String name,
			String leaderName) {
		BasicDBObject queryObj = new BasicDBObject(5);
		queryObj.put("type", type);
		queryObj.put("userType", userType);
		queryObj.put("teamType", teamType);
		queryObj.put("status", status);
		if(!StringUtils.isEmpty(province)){//项目所在省份
			queryObj.put("province", province);
		}
		if(!StringUtils.isEmpty(city)){
			queryObj.put("city", city);//项目所在城市
		}
		if(!StringUtils.isEmpty(name)){//项目名
			Pattern namePattern = Pattern.compile(".*" + name + ".*",Pattern.CASE_INSENSITIVE);
			queryObj.put("name", namePattern);
		}
		if(!StringUtils.isEmpty(leaderName)){//项目负责人名
			Pattern leaderNamePattern = Pattern.compile(".*" + leaderName + ".*",Pattern.CASE_INSENSITIVE);
			queryObj.put("leaderName", leaderNamePattern);
		}
		return queryObj;
	}
	
	/**
	 * 分页查询正在招聘（劳务班组/材料上/设备商）的项目
	 */
	@Override
	public List<RequirementsModel> getRequirement(Page page, int type,
			int userType,int teamType,int status,String province, String city, String name,
			String leaderName) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = getQueryObj(type, userType, teamType, status,
				province, city, name, leaderName);
		List<RequirementsModel> list = this.getList(queryObj, page.getPageNow(), page.getPageSize());
		return list;
	}

	/**
	 * 添加一条材料/设备供应信息
	 * @param rId
	 * @param userType
	 * @param status
	 * @param teamType
	 * @param leaderName
	 * @param province
	 * @param city
	 * @param shopName
	 */
	@Override
	public void addSupply(RequirementsModel requirements) {
		// TODO Auto-generated method stub
		RequirementsModel requirementModel = new RequirementsModel();
		requirementModel.setrId(requirements.getrId());
		requirementModel.setStatus(requirements.getStatus());
		requirementModel.setUserType(requirements.getUserType());
		requirementModel.setType(requirements.getType());
		requirementModel.setTeamType(requirements.getTeamType());
		requirementModel.setLeaderName(requirements.getLeaderName());
		requirementModel.setProvince(requirements.getProvince());
		requirementModel.setCity(requirements.getCity());
		requirementModel.setShopName(requirements.getShopName());
		requirementModel.setName(requirements.getName());
		requirementModel.setDesc(requirements.getDesc());
		requirementModel.setStreet(requirements.getStreet());
		
		RequirementsDAO.insert(requirementModel);
	}

	/**
	 * 统计发布的材料供应信息总条数
	 * @param rId
	 * @param leaderName
	 * @param teamType
	 * @param status
	 * @return
	 */
	@Override
	public long countSupplies(String rId, String leaderName, int teamType,
			int status,int type, int userType) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = getQueryObj(rId, leaderName, teamType, status,type,userType);
		long count = this.countAll(queryObj);
		return count;
	}

	public BasicDBObject getQueryObj(String rId, String leaderName,
			int teamType, int status,int type,int userType) {
		
		BasicDBObject queryObj = new BasicDBObject(5);
		queryObj.put("rId", rId);
		if(StringUtils.isNotBlank(leaderName)){
			queryObj.put("leaderName", leaderName);
		}
		if(teamType!=-1){
			queryObj.put("teamType", teamType);
		}
		if(status!=-1){
			queryObj.put("status", status);
		}
		if(type!=-1){
			queryObj.put("type", type);
		}
		if(userType!=-1){
			queryObj.put("userType", userType);
		}
		return queryObj;
	}
	
	/**
	* 查询一个材料商所有的材料供应信息
	* @param rId
	* @param leaderName
	* @param teamType
	* @param userType
	* @param status
	* @return
	*/
	@Override
	public List<RequirementsModel> getRequirements(String rId,
			String leaderName, int teamType, int status,int type,int userType, int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		
		
		BasicDBObject queryObj = getQueryObj(rId, leaderName,
				teamType,status,type,userType);
		List<RequirementsModel> list = this.getList(queryObj, pageNow, pageSize);
		return list;
	}

	/**
	 * 通过供应材料名称获取到一条数据
	 * @param shopName
	 * @return
	 */
	@Override
	public RequirementsModel getReqirement(String shopName,String rId) {
		// TODO Auto-generated method stub
		
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("shopName", shopName);
		queryObj.put("rId", rId);
		RequirementsModel requirementsModel = RequirementsDAO.getOne(queryObj);
		return requirementsModel;
	}
	
	/**
	 * 根据Requirements中的标题等信息判断是否已经发布了这信息
	 */
	@Override
	public RequirementsModel getRequirementsByTitleAndSoOn(String projectId,
			String title, String skillBigType, String skillSmallType) {
		return RequirementsDAO.getRequirementsByTitleAndSoOn(projectId, title, skillBigType, skillSmallType);
	}

	/**
	 * 根据项目的ID和type和status的状态查询RequirementsModel
	 */
	@Override
	public List<RequirementsModel> getByRIdAndTypeAndStatus(String projectId,
			int type, int status, String rId) {
		return RequirementsDAO.getByRIdAndTypeAndStatus(projectId, type, status);
	}

	/**
	 * 添加RequirementsModel
	 */
	@Override
	public void addRequirementsModel(RequirementsModel requirementsModel) {
		RequirementsDAO.insert(requirementsModel);
	}

	/**
	 * 根据项目的ID和type和status的状态查询RequirementsModel
	 */
	@Override
	public List<RequirementsModel> getByRIdAndTypeAndStatusAndUserType(
			String projectId, int type, int status, int teamType) {
		return RequirementsDAO.getByRIdAndTypeAndStatusAndUserType(projectId, type, status, teamType);
	}

	/**
	 * 新增一条记录
	 */
	@Override
	public void addRequirementsTeamModel(RequirementsModel requirementsModel) {
		RequirementsDAO.insert(requirementsModel);
	}

	
	
}
