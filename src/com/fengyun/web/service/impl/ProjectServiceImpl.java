package com.fengyun.web.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.db.dao.EquipmentDAO;
import com.fengyun.web.db.dao.MaterialDAO;
import com.fengyun.web.db.dao.ProjectDAO;
import com.fengyun.web.db.dao.ProjectDepartmentDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.dao.TeamDAO;
import com.fengyun.web.db.dao.UserDAO;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.hardcode.ESessionKey;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.UserService;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private UserService userService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private PersonService personService;

	@Override
	public ProjectModel getProjectByUserId(String userId) {
		return ProjectDAO.getByUserId(userId);
	}

	@Override
	public boolean addProject(String identity, String companyType, String name,
			String code, String pCode, String userId, String leaderName,
			String province, String city, String street, int price,
			int prepaid, int check, String lonlat, String lonlat2,
			String allWork, String accWork, String provinceCode, String type,
			String projectTitanic, String projectlevel, String projectorgan,
			String replytime, String investment, String totalarea,
			String scale, String nature, String purpose, String worktime,
			String thsWork, int times, String unit, String buildUnit) {
		// 是否一个负责人只能负责一个项目

		// 是否要判断重名
		ProjectModel model = null;
		if (StringUtils.isNotBlank(pCode)) {
			model = ProjectDAO.getByPCode(pCode);
			if (model != null)
				return false;
		}
		// 新建
		model = new ProjectModel();
		model.setName(name);
		model.setIdentity(identity);
		model.setCode(code);
		model.setpCode(pCode);
		model.setUserId(userId);
		model.setLeaderName(leaderName);
		model.setProvince(province);
		model.setCity(city);
		model.setStreet(street);
		model.setCreateTime(new Date());
		model.setCheck(check);
		model.setPrice(price);
		model.setPrepaid(prepaid);
		model.setLongitude(lonlat);
		model.setLatitude(lonlat2);
		model.setAllWork(allWork);
		model.setAccWork(accWork);
		model.setProvinceCode(provinceCode);
		model.setType(type);
		model.setProjectTitanic(projectTitanic);
		model.setProjectlevel(projectlevel);
		model.setProjectorgan(projectorgan);
		model.setReplytime(replytime);
		model.setInvestment(investment);
		model.setTotalarea(totalarea);
		model.setScale(scale);
		model.setNature(nature);
		model.setPurpose(purpose);
		model.setWorktime(worktime);
		model.setThsWork(thsWork);
		model.setTimes(times);
		model.setUnit(unit);
		model.setBuildUnit(buildUnit);
		try {
			ProjectDAO.insert(model);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		// 创建项目负责人
		UserModel userModel = UserDAO.getByUserId(userId);
		if (userModel == null) {
			String userPassword = identity.substring(12);// 身份证后6位作为密码
			String sex = identity.substring(16, 18);
			int age = identityToAge(identity);
			userModel = new UserModel();
			userModel.setUserPassword(userPassword);
			Date createTime = new Date();
			userModel.setCreateTime(createTime);
			userModel.setUserIdentity(identity);
			userModel.setUserType("4");
			userModel.setUserId(userId);
			userModel.setUserProvince(province);
			userModel.setUserCity(city);
			userModel.setUserName(leaderName);
			userService.addUser(userModel);
		} else {
			userModel.setUserType("4");
			if (userModel.getUserIdentity() == null) {
				String sex = identity.substring(16, 18);
				int age = identityToAge(identity);
				userModel.setUserSex(sex);
				userModel.setAge(age);
			}
			UserDAO.updateUserType(userModel);
		}
		return true;
	}

	@Override
	public void inviteProjectDepartment(String pId, String vId, int type,
			int status) {
		// TODO Auto-generated method stub
		// 是否已经被邀请或者通过
		ProjectDepartmentModel pmModel = ProjectDepartmentDAO.getByTypeAndId(
				vId, pId, type);
		if (pmModel != null)
			return;

		// 邀请成功
		pmModel = new ProjectDepartmentModel();
		pmModel.setVId(vId);
		pmModel.setPId(pId);
		pmModel.setStatus(status);
		pmModel.setType(type);

		try {
			ProjectDepartmentDAO.insert(pmModel);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void passProjectDepartment(String id) {
		// TODO Auto-generated method stub
		try {
			ProjectDepartmentModel pmModel = ProjectDepartmentDAO.getById(id);
			if (pmModel != null) {
				pmModel.setStatus(1);// 审核通过
				ProjectDepartmentDAO.updateStatus(pmModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ProjectModel> getProjectList(BasicDBObject queryObj,
			int pageNow, int pageSize) {
		if (pageNow <= 0)
			pageNow = 1;
		if (pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return ProjectDAO.getAll(queryObj, pageSize, skip);
	}

	@Override
	public long countAllProject(BasicDBObject queryObj) {
		return ProjectDAO.countAll(queryObj);
	}

	@Override
	public void delProject(String id) {
		//如果项目已经开始，不能删除
		ProjectModel model = ProjectDAO.getById(id);
		if(model != null && model.getStatus() == 0 )
			ProjectDAO.delete(id);
	}

	@Override
	public ProjectModel getById(String id) {
		return ProjectDAO.getById(id);
	}

	@Override
	public void updateProject(ProjectModel model) {
		ProjectDAO.update(model);
	}

	@Override
	public void projectPass(String id) {
		ProjectModel model = getById(id);
		// 需填写编号才能审核
		if (model != null && StringUtils.isNotBlank(model.getpCode())) {
			model.setCheck(1);
			ProjectDAO.updateCheck(model);
		}
	}

	@Override
	public Object[] getProjectDepartmentByPId(String pId) {
		Object[] objs = new Object[3];
		List<ProjectDepartmentModel> models = ProjectDepartmentDAO
				.getByPIdStatus(pId,3);
		if (models != null && models.size() > 0) {
			List<TeamModel> teams = new ArrayList<TeamModel>(10);
			List<MaterialModel> materials = new ArrayList<MaterialModel>(10);
			List<EquipmentModel> equips = new ArrayList<EquipmentModel>(10);
			for (ProjectDepartmentModel model : models) {
				// 班组
				if (model.getType() == 1) {
					TeamModel tModel = TeamDAO.getById(model.getVId());
					if (tModel != null)
						teams.add(tModel);
					// 材料
				} else if (model.getType() == 2) {
					MaterialModel mModel = MaterialDAO.getById(model.getVId());
					if (mModel != null)
						materials.add(mModel);
					// 设备
				} else if (model.getType() == 3) {
					EquipmentModel eModel = EquipmentDAO
							.getById(model.getVId());
					if (eModel != null)
						equips.add(eModel);
				}
			}
			objs[0] = teams;
			objs[1] = materials;
			objs[2] = equips;
		}
		return objs;
	}

	@Override
	public ProjectModel getByPCode(String pCode) {
		// TODO Auto-generated method stub
		return ProjectDAO.getByPCode(pCode);
	}

	@Override
	public ProjectDepartmentModel getProjectDepartment(String pId, String vId,
			int type) {
		// TODO Auto-generated method stub
		return ProjectDepartmentDAO.getByTypeAndId(pId, vId, type);
	}

	@Override
	public void updateProjectDepartmentStatus(ProjectDepartmentModel model) {
		// TODO Auto-generated method stub
		ProjectDepartmentDAO.updateStatus(model);
	}

	@Override
	public void addProjectDepartment(ProjectDepartmentModel model) {
		// TODO Auto-generated method stub
		ProjectDepartmentDAO.insert(model);
	}

	/**
	 * 模糊查询项目名称-zss
	 */
	@Override
	public List<ProjectModel> getPNameList(String name) {
		// TODO Auto-generated method stub
		Pattern namePattern = Pattern.compile(".*" + name + ".*",
				Pattern.CASE_INSENSITIVE);
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("name", namePattern);
		List<ProjectModel> list = ProjectDAO.getPNameList(queryObj);
		/*
		 * List<String> pNameList = new ArrayList<String>(); for(ProjectModel
		 * pMOdel: list){ String pName = pMOdel.getName(); pNameList.add(pName);
		 * }
		 */
		return list;
	}

	/**
	 * 方案1查询时间447m,64,78,38,71,or查询662,47,24,0,0
	 */
	@Override
	public List<ProjectModel> getSearchList(String text) {

		BasicDBObject queryObj = new BasicDBObject(3);
		Pattern pattern = Pattern.compile(".*" + text + ".*",
				Pattern.CASE_INSENSITIVE);
		List<ProjectModel> result = new ArrayList<ProjectModel>();

		// Set<String> idList = new HashSet<String>();
		// queryObj.put("name", pattern);
		// queryObj.put("check", 1);
		//
		// List<ProjectModel> list1 = ProjectDAO.getPNameList(queryObj);
		// for(ProjectModel model:list1){
		// if(idList.contains(model.getId()))
		// continue;
		// result.add(model);
		// idList.add(model.getId());
		// }
		// queryObj.clear();
		//
		// queryObj.put("leaderName", pattern);
		// queryObj.put("check", 1);
		// List<ProjectModel> list2 = ProjectDAO.getPNameList(queryObj);
		// for(ProjectModel model:list2){
		// if(idList.contains(model.getId()))
		// continue;
		// result.add(model);
		// idList.add(model.getId());
		// }
		// queryObj.clear();
		//
		// queryObj.put("street", pattern);
		// queryObj.put("check", 1);
		// List<ProjectModel> list3 = ProjectDAO.getPNameList(queryObj);
		// for(ProjectModel model:list3){
		// if(idList.contains(model.getId()))
		// continue;
		// result.add(model);
		// idList.add(model.getId());
		// }

		// /////////////////or查询//////////////////////
		BasicDBList values = new BasicDBList();
		values.add(new BasicDBObject("name", pattern));
		values.add(new BasicDBObject("leaderName", pattern));
		values.add(new BasicDBObject("street", pattern));
		queryObj.put("$or", values);
		queryObj.put("check", 1);
		result = ProjectDAO.getPNameList(queryObj);

		return result;
	}

	@Override
	public List<ProjectModel> getByCode(String code) {
		return ProjectDAO.getByCode(code);
	}

	@Override
	public boolean frontAddProject(String name, String code,
			String pCode, String allWork, String thsWork, String accWork,
			String userId, String leaderName, int times, String province,
			String city, String street, int price, int prepaid, String status,
			int progress, String projectTitanic, String projectlevel,
			String projectorgan, String provinceCode, String replytime,
			String totalarea, String purpose, String nature, String worktime,
			String type, String unit, int check, String lonlat,
			String lonlat2) {
		// 是否要判断重名
		ProjectModel model = ProjectDAO.getByPCode(pCode);
		if (model != null)
			return false;
		// 新建
		model = new ProjectModel();
		model.setName(name);
		model.setCode(code);
		model.setpCode(pCode);
		model.setAllWork(allWork);
		model.setThsWork(thsWork);
		model.setAccWork(accWork);
		model.setUserId(userId);
		model.setLeaderName(leaderName);
		model.setTimes(times);
		model.setProvince(province);
		model.setCity(city);
		model.setStreet(street);
		model.setPrice(price);
		model.setPrepaid(prepaid);
		model.setStatus(Integer.valueOf(status));
		model.setProgress(progress);
		model.setProjectTitanic(projectTitanic);
		model.setProjectlevel(projectlevel);
		model.setProjectorgan(projectorgan);
		model.setProvinceCode(provinceCode);
		model.setReplytime(replytime);
		model.setTotalarea(totalarea);
		model.setPurpose(purpose);
		model.setNature(nature);
		model.setWorktime(worktime);
		model.setType(type);
		model.setUnit(unit);
		model.setCheck(check);
		model.setLongitude(lonlat);
		model.setLatitude(lonlat2);
		model.setCreateTime(new Date());
		try {
			ProjectDAO.insert(model);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		// 创建项目负责人
		UserModel userModel = UserDAO.getByUserId(userId);
		if (userModel == null) {
			userModel = new UserModel();
			userModel.setUserId(userId);
			userModel.setUserType("4");
			UserDAO.insert(userModel);
		} else {
			userModel.setUserType("4");
			UserDAO.updateUserType(userModel);
		}
		return true;
	}

	@Override
	public ModelAndView registerProjectRegister(ProjectModel projectModel, ModelAndView mav) {
		String name = projectModel.getName();
		String code = projectModel.getCode();
		String pCode = projectModel.getpCode();
		String userId = projectModel.getUserId();
		String leaderName = projectModel.getLeaderName();
		String province = projectModel.getProvince();
		String city = projectModel.getCity();
		String street = projectModel.getStreet();
		int price = projectModel.getPrice();
		int prepaid = projectModel.getPrepaid();
		int check = projectModel.getCheck();
		String lonlat = null;
		String lonlat2 = null;
		String companyType = projectModel.getCompanyType();
		String allWork = projectModel.getAllWork();
		String accWork = projectModel.getAccWork();
		String provinceCode = projectModel.getProvinceCode();
		String type = projectModel.getType();
		String projectTitanic = projectModel.getProjectTitanic();
		String projectlevel = projectModel.getProjectlevel();
		String projectorgan = projectModel.getProjectorgan();
		String replytime = projectModel.getReplytime();
		String investment = projectModel.getInvestment();
		String totalarea = projectModel.getTotalarea();
		String scale = projectModel.getScale();
		String nature = projectModel.getNature();
		String purpose = projectModel.getPurpose();
		String worktime = projectModel.getWorktime();
		String thsWork = projectModel.getThsWork();
		int times = projectModel.getTimes();
		String unit = projectModel.getUnit();
		String buildUnit = projectModel.getBuildUnit();
		String identity = projectModel.getIdentity();

		boolean b = this.addProject(identity, companyType, name, code, pCode,
				userId, leaderName, province, city, street, price, prepaid,
				check, lonlat, lonlat2, allWork, accWork, provinceCode, type,
				projectTitanic, projectlevel, projectorgan, replytime,
				investment, totalarea, scale, nature, purpose, worktime,
				thsWork, times, unit, buildUnit);
//		System.out.println("---------------------------b:" + b);
		String userType="4";
		 request.getSession().setAttribute(ESessionKey.UserId.key,userId);//将用户id存放到session中，作为已登录标记
		 request.getSession().setAttribute(ESessionKey.UserType.key,userType); //type :4 项目负责人用户标记。 
		 //addProject方法已经新增过user
//		 UserModel userModel = new UserModel();
//		 userModel.setUserName(leaderName);
//		 userModel.setUserId(userId);
//		 userModel.setUserIdentity(identity);
//		 userModel.setUserPassword(identity.substring(12));
//		 userModel.setUserType(userType);
//		 //初始化用户基本信息和诚信档案基本信息
//		 userService.addUser(userModel);
		 personService.initialUser(leaderName,userId,identity,userType);
		 ProjectModel pModel = ProjectDAO.getByUserId(userId);
		 mav.addObject("projectModel", pModel);
		 return mav;
	}

	// 根据身份证号，求出年龄
	private int identityToAge(String IdNO) {
		int leh = IdNO.length();
		String dates = "";
		if (leh == 18) {
		//	int se = Integer.valueOf(IdNO.substring(leh - 1)) % 2;
			dates = IdNO.substring(6, 10);
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String year = df.format(new Date());
			int u = Integer.parseInt(year) - Integer.parseInt(dates);
			return u;
		} else {
			dates = IdNO.substring(6, 8);
			return Integer.parseInt(dates);
		}
	}
	
	
	
	/**
	 * 通过项目名称查询项目
	 */
	@Override
	public ProjectModel getByName(String name) {
		return ProjectDAO.getByName(name);
	}
	
	/**
	 * 通过项目负责人电话查询项目
	 */
	@Override
	public ProjectModel getByUserId(String userId) {
		// TODO Auto-generated method stub
		return ProjectDAO.getByUserId(userId);
	}

	@Override
	public boolean teamJoinProject(String tId) {
		// TODO Auto-generated method stub
		List<ProjectDepartmentModel> list = ProjectDepartmentDAO.getProjectByTId(tId, 1, 3);
		if(list != null && list.size() > 0)
			return true;
		return false;
	}

}