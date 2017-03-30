package com.fengyun.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.cache.page.PageHandler;
import com.fengyun.web.db.dao.TeamMemberDAO;
import com.fengyun.web.db.playermodel.CompanyModel;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.RequirementsModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.service.CompanyService;
import com.fengyun.web.service.EquipmentService;
import com.fengyun.web.service.MaterialService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.RequirementsService;
import com.fengyun.web.service.TeamService;
import com.mongodb.BasicDBObject;

@Controller
public class RequirementsController {

	@Autowired
	private RequirementsService requirementsService;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private TeamService teamService;

	@Autowired
	private MaterialService materialService;

	@Autowired
	private EquipmentService equipmentService;

	// ///////////////////////////////////////求职////////////////////////////////////////////////////
	/**
	 * 设备供应
	 * 
	 * @return
	 */
	@RequestMapping(value = "job_equip_list")
	public ModelAndView job_equip_list() {
		String name = request.getParameter("name");
		String shopName = request.getParameter("shopName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(name)) {
			queryObj.put("name", name);
		}
		if (StringUtils.isNotBlank(shopName)) {
			queryObj.put("shopName", shopName);
		}
		if (StringUtils.isNotBlank(province)) {
			queryObj.put("province", province);
		}
		if (StringUtils.isNotBlank(city)) {
			queryObj.put("city", city);
		}

		ModelAndView mav = getJobEquipMAV(queryObj);

		mav.addObject("name", name);
		mav.addObject("shopName", shopName);
		mav.addObject("province", province);
		mav.addObject("city", city);

		return mav;
	}

	private ModelAndView getJobEquipMAV(BasicDBObject queryObj) {
		ModelAndView mav = new ModelAndView("/requirements/job_equip_list");

		//
		queryObj.put("type", 1);
		queryObj.put("userType", 2);
		queryObj.put("teamType", 3);
		
		long dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 0;
		int pageNow = 1;
		if (StringUtils.isNotBlank(pageSizeStr)) {
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if (StringUtils.isNotBlank(pageNowStr)) {
			pageNow = Integer.valueOf(pageNowStr);
		}

		List<RequirementsModel> list = requirementsService.getList(queryObj,
				pageNow, pageSize);
		if (list != null && !list.isEmpty()) {
			for (RequirementsModel model : list) {
				EquipmentModel eModel = equipmentService.getById(model.getrId());
				if (eModel != null){
					model.setEquipmentModel(eModel);
				}
			}
		}
		mav.addObject("list", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}

	@RequestMapping(value = "job_equip_del")
	public ModelAndView job_equip_del() {
		String id = request.getParameter("id");
		requirementsService.delById(id);
		return getJobEquipMAV(new BasicDBObject());
	}

	@RequestMapping(value = "job_equip_close")
	public ModelAndView job_equip_close() {
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		requirementsService.updateStatus(id, Integer.valueOf(status));
		return getJobEquipMAV(new BasicDBObject());
	}

	@RequestMapping(value = "job_equip_add")
	public String job_equip_add() {
		return "/requirements/job_equip_add";
	}

	@RequestMapping(value = "job_equip_add2")
	public ModelAndView job_equip_add2() {
		String title = request.getParameter("title");
		String code = request.getParameter("code");
		String shopName = request.getParameter("shopName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String desc = request.getParameter("desc");
		requirementsService.addJobEquip(title, code, shopName,province, city, street,desc);
		return getJobEquipMAV(new BasicDBObject());
	}
	
	////////////////材料供应/////////////
	/**
	 * 
	 * 
	 * @return
	 */
	@RequestMapping(value = "job_material_list")
	public ModelAndView job_material_list() {
		String name = request.getParameter("name");
		String shopName = request.getParameter("shopName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(name)) {
			queryObj.put("name", name);
		}
		if (StringUtils.isNotBlank(shopName)) {
			queryObj.put("shopName", shopName);
		}
		if (StringUtils.isNotBlank(province)) {
			queryObj.put("province", province);
		}
		if (StringUtils.isNotBlank(city)) {
			queryObj.put("city", city);
		}

		ModelAndView mav = getJobMaterialMAV(queryObj);

		mav.addObject("name", name);
		mav.addObject("shopName", shopName);
		mav.addObject("province", province);
		mav.addObject("city", city);

		return mav;
	}

	private ModelAndView getJobMaterialMAV(BasicDBObject queryObj) {
		ModelAndView mav = new ModelAndView("/requirements/job_material_list");

		//
		queryObj.put("type", 1);
		queryObj.put("userType", 2);
		queryObj.put("teamType", 2);
		
		long dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 0;
		int pageNow = 1;
		if (StringUtils.isNotBlank(pageSizeStr)) {
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if (StringUtils.isNotBlank(pageNowStr)) {
			pageNow = Integer.valueOf(pageNowStr);
		}

		List<RequirementsModel> list = requirementsService.getList(queryObj,
				pageNow, pageSize);
		if (list != null && !list.isEmpty()) {
			for (RequirementsModel model : list) {
				MaterialModel mModel = materialService.getById(model.getrId());
				if (mModel != null){
					model.setMaterialModel(mModel);
				}
			}
		}
		mav.addObject("list", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}

	@RequestMapping(value = "job_material_del")
	public ModelAndView job_material_del() {
		String id = request.getParameter("id");
		requirementsService.delById(id);
		return getJobMaterialMAV(new BasicDBObject());
	}

	@RequestMapping(value = "job_material_close")
	public ModelAndView job_material_close() {
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		requirementsService.updateStatus(id, Integer.valueOf(status));
		return getJobMaterialMAV(new BasicDBObject());
	}

	@RequestMapping(value = "job_material_add")
	public String job_material_add() {
		return "/requirements/job_material_add";
	}

	@RequestMapping(value = "job_material_add2")
	public ModelAndView job_material_add2() {
		String title = request.getParameter("title");
		String code = request.getParameter("code");
		String shopName = request.getParameter("shopName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String desc = request.getParameter("desc");
		requirementsService.addJobMaterial(title, code, shopName,province, city, street,desc);
		return getJobMaterialMAV(new BasicDBObject());
	}
	
	///////////////班组求职/////////////
	/**
	 * 班组求职
	 * 
	 * @return
	 */
	@RequestMapping(value = "job_team_list")
	public ModelAndView job_team_list() {
		String name = request.getParameter("name");
		String skillBigType = request.getParameter("skillBigType");
		String smalltype = request.getParameter("smalltype");
		String leaderName = request.getParameter("leaderName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(name)) {
			queryObj.put("name", name);
		}
		if (StringUtils.isNotBlank(skillBigType)) {
			queryObj.put("skillBigType", skillBigType);
		}
		if (StringUtils.isNotBlank(smalltype)) {
			queryObj.put("skillSmallType", smalltype);
		}
		if (StringUtils.isNotBlank(leaderName)) {
			queryObj.put("leaderName", leaderName);
		}
		if (StringUtils.isNotBlank(province)) {
			queryObj.put("province", province);
		}
		if (StringUtils.isNotBlank(city)) {
			queryObj.put("city", city);
		}

		ModelAndView mav = getJobTeamMAV(queryObj);

		mav.addObject("name", name);
		mav.addObject("skillBigType", skillBigType);
		mav.addObject("smalltype", smalltype);
		mav.addObject("leaderName", leaderName);
		mav.addObject("province", province);
		mav.addObject("city", city);

		return mav;
	}

	private ModelAndView getJobTeamMAV(BasicDBObject queryObj) {
		ModelAndView mav = new ModelAndView("/requirements/job_team_list");

		//
		queryObj.put("type", 1);
		queryObj.put("userType", 2);
		queryObj.put("teamType", 1);
		
		long dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 0;
		int pageNow = 1;
		if (StringUtils.isNotBlank(pageSizeStr)) {
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if (StringUtils.isNotBlank(pageNowStr)) {
			pageNow = Integer.valueOf(pageNowStr);
		}

		List<RequirementsModel> list = requirementsService.getList(queryObj,
				pageNow, pageSize);
		if (list != null && !list.isEmpty()) {
			for (RequirementsModel model : list) {
				TeamModel tModel = teamService.getTeamById(model.getrId());
				if (tModel != null){
					tModel.setNum(TeamMemberDAO.countMember(model.getId(), 3));
					model.setTeamModel(tModel);
				}
			}
		}
		mav.addObject("list", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}

	@RequestMapping(value = "job_team_del")
	public ModelAndView job_team_del() {
		String id = request.getParameter("id");
		requirementsService.delById(id);
		return getJobTeamMAV(new BasicDBObject());
	}

	@RequestMapping(value = "job_team_close")
	public ModelAndView job_team_close() {
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		requirementsService.updateStatus(id, Integer.valueOf(status));
		return getJobTeamMAV(new BasicDBObject());
	}

	@RequestMapping(value = "job_team_add")
	public String job_team_add() {
		return "/requirements/job_team_add";
	}

	/**
	 * 添加班组求职
	 * 
	 * @param pagesize
	 *            第几页
	 * @return
	 */
	@RequestMapping(value = "job_team_add2")
	public ModelAndView job_team_add2() {
		String title = request.getParameter("title");
		String code = request.getParameter("code");
		String skillBigType = request.getParameter("skillBigType");
		String smalltype = request.getParameter("smalltype");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String desc = request.getParameter("desc");
		requirementsService.addJobTeam(title, code, skillBigType,
				smalltype, province, city, street,desc);
		return getJobTeamMAV(new BasicDBObject());
	}
	// ///////////求职个人////////
	/**
	 * 求职个人
	 * 
	 * @return
	 */
	@RequestMapping(value = "job_person_list")
	public ModelAndView job_person_list() {
		String name = request.getParameter("name");
		String skillBigType = request.getParameter("skillBigType");
		String smalltype = request.getParameter("smalltype");
		String userId = request.getParameter("userId");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(name)) {
			queryObj.put("name", name);
		}
		if (StringUtils.isNotBlank(skillBigType)) {
			queryObj.put("skillBigType", skillBigType);
		}
		if (StringUtils.isNotBlank(smalltype)) {
			queryObj.put("skillSmallType", smalltype);
		}
		if (StringUtils.isNotBlank(userId)) {
			queryObj.put("rId", userId);
		}
		if (StringUtils.isNotBlank(province)) {
			queryObj.put("province", province);
		}
		if (StringUtils.isNotBlank(city)) {
			queryObj.put("city", city);
		}

		ModelAndView mav = getJobPersonMAV(queryObj);

		mav.addObject("name", name);
		mav.addObject("skillBigType", skillBigType);
		mav.addObject("smalltype", smalltype);
		mav.addObject("userId", userId);
		mav.addObject("province", province);
		mav.addObject("city", city);

		return mav;
	}

	private ModelAndView getJobPersonMAV(BasicDBObject queryObj) {
		ModelAndView mav = new ModelAndView("/requirements/job_person_list");

		//
		queryObj.put("type", 1);
		queryObj.put("userType", 1);
		
		long dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 0;
		int pageNow = 1;
		if (StringUtils.isNotBlank(pageSizeStr)) {
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if (StringUtils.isNotBlank(pageNowStr)) {
			pageNow = Integer.valueOf(pageNowStr);
		}

		List<RequirementsModel> list = requirementsService.getList(queryObj,
				pageNow, pageSize);
		mav.addObject("list", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}

	@RequestMapping(value = "job_person_del")
	public ModelAndView job_person_del() {
		String id = request.getParameter("id");
		requirementsService.delById(id);
		return getJobPersonMAV(new BasicDBObject());
	}

	@RequestMapping(value = "job_person_close")
	public ModelAndView job_person_close() {
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		requirementsService.updateStatus(id, Integer.valueOf(status));
		return getJobPersonMAV(new BasicDBObject());
	}

	@RequestMapping(value = "job_person_add")
	public String job_person_add() {
		return "/requirements/job_person_add";
	}

	/**
	 * 添加个人求职
	 * 
	 * @param pagesize
	 *            第几页
	 * @return
	 */
	@RequestMapping(value = "job_person_add2")
	public ModelAndView job_person_add2() {
		String title = request.getParameter("title");
		String userId = request.getParameter("userId");
		String skillBigType = request.getParameter("skillBigType");
		String smalltype = request.getParameter("smalltype");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String desc = request.getParameter("desc");
		requirementsService.addJobPerson(title, userId, skillBigType,
				smalltype, province, city, street,desc);
		return getJobPersonMAV(new BasicDBObject());
	}
	
	
	// ///////////////////////////////////////招聘////////////////////////////////////////////////////
	// ///////////招聘个人////////
	/**
	 * 招聘个人
	 * 
	 * @param pagesize
	 *            第几页
	 * @return
	 */
	@RequestMapping(value = "recruit_person_list")
	public ModelAndView recruit_person_list() {
		String name = request.getParameter("name");
		String skillBigType = request.getParameter("skillBigType");
		String smalltype = request.getParameter("smalltype");
		String leaderName = request.getParameter("leaderName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(name)) {
			queryObj.put("name", name);
		}
		if (StringUtils.isNotBlank(skillBigType)) {
			queryObj.put("skillBigType", skillBigType);
		}
		if (StringUtils.isNotBlank(smalltype)) {
			queryObj.put("skillSmallType", smalltype);
		}
		if (StringUtils.isNotBlank(leaderName)) {
			queryObj.put("leaderName", leaderName);
		}
		if (StringUtils.isNotBlank(province)) {
			queryObj.put("province", province);
		}
		if (StringUtils.isNotBlank(city)) {
			queryObj.put("city", city);
		}

		ModelAndView mav = getRecruitPersonMAV(queryObj);

		mav.addObject("name", name);
		mav.addObject("skillBigType", skillBigType);
		mav.addObject("smalltype", smalltype);
		mav.addObject("leaderName", leaderName);
		mav.addObject("province", province);
		mav.addObject("city", city);

		return mav;
	}

	private ModelAndView getRecruitPersonMAV(BasicDBObject queryObj) {
		ModelAndView mav = new ModelAndView("/requirements/recruit_person_list");

		//
		queryObj.put("type", 2);
		queryObj.put("userType", 2);
		queryObj.put("teamType", 1);

		long dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 0;
		int pageNow = 1;
		if (StringUtils.isNotBlank(pageSizeStr)) {
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if (StringUtils.isNotBlank(pageNowStr)) {
			pageNow = Integer.valueOf(pageNowStr);
		}

		List<RequirementsModel> list = requirementsService.getList(queryObj,
				pageNow, pageSize);
		if (list != null && !list.isEmpty()) {
			for (RequirementsModel model : list) {
				TeamModel tModel = teamService.getTeamById(model.getrId());
				if (tModel != null)
					model.setTeamModel(tModel);
			}
		}

		mav.addObject("list", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}

	@RequestMapping(value = "recruit_person_del")
	public ModelAndView recruit_person_del() {
		String id = request.getParameter("id");
		requirementsService.delById(id);
		return getRecruitPersonMAV(new BasicDBObject());
	}

	@RequestMapping(value = "recruit_person_close")
	public ModelAndView recruit_person_close() {
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		requirementsService.updateStatus(id, Integer.valueOf(status));
		return getRecruitPersonMAV(new BasicDBObject());
	}

	@RequestMapping(value = "recruit_person_add")
	public String recruit_person_add() {
		return "/requirements/recruit_person_add";
	}

	/**
	 * 添加招聘个人
	 * 
	 * @param pagesize
	 *            第几页
	 * @return
	 */
	@RequestMapping(value = "recruit_person_add2")
	public ModelAndView recruit_person_add2() {
		String title = request.getParameter("title");
		String code = request.getParameter("code");
		String skillBigType = request.getParameter("skillBigType");
		String smalltype = request.getParameter("smalltype");
		String num = request.getParameter("num");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String desc = request.getParameter("desc");
		requirementsService.addRecruitPerson(title, code, skillBigType,
				smalltype, num, province, city, street,desc);
		return getRecruitPersonMAV(new BasicDBObject());
	}

	// ///////////招聘班组////////
	@RequestMapping(value = "recruit_team_list")
	public ModelAndView recruit_team_list() {
		String name = request.getParameter("name");
		String skillBigType = request.getParameter("skillBigType");
		String smalltype = request.getParameter("smalltype");
		String leaderName = request.getParameter("leaderName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(name)) {
			queryObj.put("name", name);
		}
		if (StringUtils.isNotBlank(skillBigType)) {
			queryObj.put("skillBigType", skillBigType);
		}
		if (StringUtils.isNotBlank(smalltype)) {
			queryObj.put("skillSmallType", smalltype);
		}
		if (StringUtils.isNotBlank(leaderName)) {
			queryObj.put("leaderName", leaderName);
		}
		if (StringUtils.isNotBlank(province)) {
			queryObj.put("province", province);
		}
		if (StringUtils.isNotBlank(city)) {
			queryObj.put("city", city);
		}

		ModelAndView mav = getRecruitTeamMAV(queryObj);

		mav.addObject("name", name);
		mav.addObject("skillBigType", skillBigType);
		mav.addObject("smalltype", smalltype);
		mav.addObject("leaderName", leaderName);
		mav.addObject("province", province);
		mav.addObject("city", city);

		return mav;
	}

	private ModelAndView getRecruitTeamMAV(BasicDBObject queryObj) {
		ModelAndView mav = new ModelAndView("/requirements/recruit_team_list");

		//
		queryObj.put("type", 2);
		queryObj.put("userType", 3);
		queryObj.put("teamType", 1);

		long dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 0;
		int pageNow = 1;
		if (StringUtils.isNotBlank(pageSizeStr)) {
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if (StringUtils.isNotBlank(pageNowStr)) {
			pageNow = Integer.valueOf(pageNowStr);
		}

		List<RequirementsModel> list = requirementsService.getList(queryObj,
				pageNow, pageSize);
		if (list != null && !list.isEmpty()) {
			for (RequirementsModel model : list) {
				ProjectModel pModel = projectService.getById(model.getrId());
				if (pModel != null)
					model.setpModel(pModel);
				CompanyModel cModel = companyService
						.getByCode(pModel.getCode());
				if (cModel != null)
					model.setcModel(cModel);
			}
		}

		mav.addObject("list", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}

	@RequestMapping(value = "recruit_team_del")
	public ModelAndView recruit_team_del() {
		String id = request.getParameter("id");
		requirementsService.delById(id);
		return getRecruitTeamMAV(new BasicDBObject());
	}

	@RequestMapping(value = "recruit_team_close")
	public ModelAndView recruit_team_close() {
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		requirementsService.updateStatus(id, Integer.valueOf(status));
		return getRecruitTeamMAV(new BasicDBObject());
	}

	@RequestMapping(value = "recruit_team_add")
	public String recruit_team_add() {
		return "/requirements/recruit_team_add";
	}

	/**
	 * 添加招聘班组
	 * 
	 * @param pagesize
	 *            第几页
	 * @return
	 */
	@RequestMapping(value = "recruit_team_add2")
	public ModelAndView recruit_team_add2() {
		String title = request.getParameter("title");
		String code = request.getParameter("code");
		String skillBigType = request.getParameter("skillBigType");
		String smalltype = request.getParameter("smalltype");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String desc = request.getParameter("desc");
		requirementsService.addRecruitTeam(title, code, skillBigType,
				smalltype, province, city, street,desc);
		return getRecruitTeamMAV(new BasicDBObject());
	}

	// ///////////////材料采购/////////////
	@RequestMapping(value = "recruit_material_list")
	public ModelAndView recruit_material_list() {
		String name = request.getParameter("name");
		String shopName = request.getParameter("shopName");
		String leaderName = request.getParameter("leaderName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(name)) {
			queryObj.put("name", name);
		}
		if (StringUtils.isNotBlank(shopName)) {
			queryObj.put("shopName", shopName);
		}
		if (StringUtils.isNotBlank(leaderName)) {
			queryObj.put("leaderName", leaderName);
		}
		if (StringUtils.isNotBlank(province)) {
			queryObj.put("province", province);
		}
		if (StringUtils.isNotBlank(city)) {
			queryObj.put("city", city);
		}

		ModelAndView mav = getRecruitMateriaMAV(queryObj);

		mav.addObject("name", name);
		mav.addObject("shopName", shopName);
		mav.addObject("leaderName", leaderName);
		mav.addObject("province", province);
		mav.addObject("city", city);

		return mav;
	}

	private ModelAndView getRecruitMateriaMAV(BasicDBObject queryObj) {
		ModelAndView mav = new ModelAndView(
				"/requirements/recruit_material_list");

		//
		queryObj.put("type", 2);
		queryObj.put("userType", 3);
		queryObj.put("teamType", 2);

		long dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 0;
		int pageNow = 1;
		if (StringUtils.isNotBlank(pageSizeStr)) {
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if (StringUtils.isNotBlank(pageNowStr)) {
			pageNow = Integer.valueOf(pageNowStr);
		}

		List<RequirementsModel> list = requirementsService.getList(queryObj,
				pageNow, pageSize);
		if (list != null && !list.isEmpty()) {
			for (RequirementsModel model : list) {
				ProjectModel pModel = projectService.getById(model.getrId());
				if (pModel != null)
					model.setpModel(pModel);
				CompanyModel cModel = companyService
						.getByCode(pModel.getCode());
				if (cModel != null)
					model.setcModel(cModel);
			}
		}

		mav.addObject("list", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}

	@RequestMapping(value = "recruit_material_del")
	public ModelAndView recruit_material_del() {
		String id = request.getParameter("id");
		requirementsService.delById(id);
		return getRecruitMateriaMAV(new BasicDBObject());
	}

	@RequestMapping(value = "recruit_material_close")
	public ModelAndView recruit_material_close() {
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		requirementsService.updateStatus(id, Integer.valueOf(status));
		return getRecruitMateriaMAV(new BasicDBObject());
	}

	@RequestMapping(value = "recruit_material_add")
	public String recruit_material_add() {
		return "/requirements/recruit_material_add";
	}

	/**
	 * 添加材料采购
	 * 
	 * @param pagesize
	 *            第几页
	 * @return
	 */
	@RequestMapping(value = "recruit_material_add2")
	public ModelAndView recruit_material_add2() {
		String title = request.getParameter("title");
		String code = request.getParameter("code");
		String shopName = request.getParameter("shopName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String desc = request.getParameter("desc");
		requirementsService.addRecruitMaterial(title, code, shopName, province,
				city, street,desc);
		return getRecruitMateriaMAV(new BasicDBObject());
	}

	// ///////////////设备租赁/////////////
	@RequestMapping(value = "recruit_equip_list")
	public ModelAndView recruit_equip_list() {
		String name = request.getParameter("name");
		String shopName = request.getParameter("shopName");
		String leaderName = request.getParameter("leaderName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(name)) {
			queryObj.put("name", name);
		}
		if (StringUtils.isNotBlank(shopName)) {
			queryObj.put("shopName", shopName);
		}
		if (StringUtils.isNotBlank(leaderName)) {
			queryObj.put("leaderName", leaderName);
		}
		if (StringUtils.isNotBlank(province)) {
			queryObj.put("province", province);
		}
		if (StringUtils.isNotBlank(city)) {
			queryObj.put("city", city);
		}

		ModelAndView mav = getRecruitEquipMAV(queryObj);

		mav.addObject("name", name);
		mav.addObject("shopName", shopName);
		mav.addObject("leaderName", leaderName);
		mav.addObject("province", province);
		mav.addObject("city", city);

		return mav;
	}

	private ModelAndView getRecruitEquipMAV(BasicDBObject queryObj) {
		ModelAndView mav = new ModelAndView(
				"/requirements/recruit_equip_list");

		//
		queryObj.put("type", 2);
		queryObj.put("userType", 3);
		queryObj.put("teamType", 3);

		long dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 0;
		int pageNow = 1;
		if (StringUtils.isNotBlank(pageSizeStr)) {
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if (StringUtils.isNotBlank(pageNowStr)) {
			pageNow = Integer.valueOf(pageNowStr);
		}

		List<RequirementsModel> list = requirementsService.getList(queryObj,
				pageNow, pageSize);
		if (list != null && !list.isEmpty()) {
			for (RequirementsModel model : list) {
				ProjectModel pModel = projectService.getById(model.getrId());
				if (pModel != null){
						model.setpModel(pModel);
					CompanyModel cModel = companyService
							.getByCode(pModel.getCode());
					if (cModel != null)
						model.setcModel(cModel);
				}
			}
		}

		mav.addObject("list", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}

	@RequestMapping(value = "recruit_equip_del")
	public ModelAndView recruit_equip_del() {
		String id = request.getParameter("id");
		requirementsService.delById(id);
		return getRecruitEquipMAV(new BasicDBObject());
	}

	@RequestMapping(value = "recruit_equip_close")
	public ModelAndView recruit_equip_close() {
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		requirementsService.updateStatus(id, Integer.valueOf(status));
		return getRecruitEquipMAV(new BasicDBObject());
	}

	@RequestMapping(value = "recruit_equip_add")
	public String recruit_equip_add() {
		return "/requirements/recruit_equip_add";
	}

	/**
	 * 添加材料采购
	 * 
	 * @param pagesize
	 *            第几页
	 * @return
	 */
	@RequestMapping(value = "recruit_equip_add2")
	public ModelAndView recruit_equip_add2() {
		String title = request.getParameter("title");
		String code = request.getParameter("code");
		String shopName = request.getParameter("shopName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String desc = request.getParameter("desc");
		requirementsService.addRecruitEquip(title, code, shopName, province,
				city, street,desc);
		return getRecruitEquipMAV(new BasicDBObject());
	}
}
