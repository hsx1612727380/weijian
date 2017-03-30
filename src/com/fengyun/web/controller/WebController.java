package com.fengyun.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.cache.page.PageHandler;
import com.fengyun.web.db.playermodel.CompanyModel;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.LawInsuModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.RequirementsModel;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.hardcode.ESessionKey;
import com.fengyun.web.service.AptitudeService;
import com.fengyun.web.service.BidInfoService;
import com.fengyun.web.service.CompanyService;
import com.fengyun.web.service.EngineerService;
import com.fengyun.web.service.EquipmentService;
import com.fengyun.web.service.JoinBuildService;
import com.fengyun.web.service.KeyPersonService;
import com.fengyun.web.service.LawInsuService;
import com.fengyun.web.service.MaterialService;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.RequirementsService;
import com.fengyun.web.service.TeamService;
import com.fengyun.web.service.UserService;
import com.mongodb.BasicDBObject;

/**
 * 前端显示控制
 * @author user
 *
 */
@Controller
public class WebController  {

	@Autowired
	private  HttpServletRequest request;
	
	@Autowired
	private UserService userService;
	
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
	
	@Autowired
	private RequirementsService requirementsService;
	
	@Autowired
	private BidInfoService bidInfoService;
	
	@Autowired
	private LawInsuService lawInsuService;
	
	@Autowired
	private AptitudeService aptitudeService;
	
	@Autowired
	private EngineerService engineerService;
	
	@Autowired
	private JoinBuildService joinBuildService;
	
	@Autowired
	private KeyPersonService keyPersonService;
	
	@Autowired
	private ProjectDepartmentService projectDepartmentService;
	
	/**
	 * 公司列表
	 * @return
	 */
	@RequestMapping(value="web_company_list.html")
	public ModelAndView web_company_list(){
		ModelAndView mav = new ModelAndView("/web/company/web_company_list");
		//
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(name)){
//			queryObj.put("name", name);
			Pattern pattern = Pattern.compile(".*" + name  + ".*",Pattern.CASE_INSENSITIVE);
			queryObj.put("name", pattern);
		}
		if(StringUtils.isNotBlank(type)){
			queryObj.put("type", type);
		}
		if(StringUtils.isNotBlank(province)){
			queryObj.put("province", province);
		}
		if(StringUtils.isNotBlank(city)){
			queryObj.put("city", city);
		}
		queryObj.put("status", 2);//前台只能查看已审核过的公司信息

		dataCount = companyService.countAllCompany(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		mav.addObject("clist", companyService.getCompanyList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("name", name);
		mav.addObject("type", type);
		mav.addObject("province", province);
		mav.addObject("city", city);
		return mav;
		
	}
	
	/**
	 * 项目列表
	 * @return
	 */
	@RequestMapping(value="web_project_list.html")
	public ModelAndView web_project_list(){
		ModelAndView mav = new ModelAndView("/web/project/web_project_list");
		//
		String name = request.getParameter("name");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String status = request.getParameter("status");
		
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(name)){
//			queryObj.put("name", name);
			Pattern pattern = Pattern.compile(".*" + name  + ".*",Pattern.CASE_INSENSITIVE);
			queryObj.put("name", pattern);
		}
		if(StringUtils.isNotBlank(province)){
			queryObj.put("province", province);
		}
		if(StringUtils.isNotBlank(city)){
			queryObj.put("city", city);
		}
		if(StringUtils.isNotBlank(status)){
			queryObj.put("status", status);
		}
		queryObj.put("check", 1);//前台只能查看已审核过的公司信息

		dataCount = projectService.countAllProject(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		List<ProjectModel> list = projectService.getProjectList(queryObj,pageNow,pageSize);
		if(list != null && !list.isEmpty()){
			for(ProjectModel model:list){
				model.setCompanyModel(companyService.getByCode(model.getCode()));
			}
		}
		
		mav.addObject("clist", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("name", name);
		mav.addObject("status", status);
		mav.addObject("province", province);
		mav.addObject("city", city);
		return mav;
		
	}
	
	/**
	 * 班组列表
	 * @return
	 */
	@RequestMapping(value="web_team_list.html")
	public ModelAndView web_team_list(){
		ModelAndView mav = new ModelAndView("/web/team/web_team_list");
		String name = request.getParameter("name");
		String skillBigType = request.getParameter("skillBigType");
		String smalltype = request.getParameter("smalltype");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String status = request.getParameter("status");
		
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(name)){
			Pattern pattern = Pattern.compile(".*" + name  + ".*",Pattern.CASE_INSENSITIVE);
			queryObj.put("name", pattern);
		}
		if(StringUtils.isNotBlank(province)){
			queryObj.put("province", province);
		}
		if(StringUtils.isNotBlank(city)){
			queryObj.put("city", city);
		}
		if(StringUtils.isNotBlank(status)){
			queryObj.put("status", status);
		}
		if(StringUtils.isNotBlank(skillBigType)){
			queryObj.put("skillBigType", Integer.valueOf(skillBigType));
		}
		if(StringUtils.isNotBlank(smalltype)){
			queryObj.put("skillSmallType", Integer.valueOf(smalltype));
		}
		dataCount = teamService.countAllTeam(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		mav.addObject("clist", teamService.getTeamList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("name", name);
		mav.addObject("status", status);
		mav.addObject("province", province);
		mav.addObject("city", city);
		mav.addObject("skillBigType", skillBigType);
		mav.addObject("smalltype", smalltype);
		
		return mav;
		
	}
	
	/**
	 * 材料商列表
	 * @return
	 */
	@RequestMapping(value="web_material_list.html")
	public ModelAndView web_material_list(){
		ModelAndView mav = new ModelAndView("/web/team/web_material_list");
		
		String shopName = request.getParameter("shopName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String status = request.getParameter("status");
		
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(shopName)){
			Pattern pattern = Pattern.compile(".*" + shopName  + ".*",Pattern.CASE_INSENSITIVE);
			queryObj.put("shopName", pattern);
		}
		if(StringUtils.isNotBlank(province)){
			queryObj.put("province", province);
		}
		if(StringUtils.isNotBlank(city)){
			queryObj.put("city", city);
		}
		if(StringUtils.isNotBlank(status)){
			queryObj.put("status", Integer.valueOf(status));
		}
		dataCount = materialService.countAllMaterial(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		mav.addObject("clist", materialService.getMaterialList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("shopName", shopName);
		mav.addObject("status", status);
		mav.addObject("province", province);
		mav.addObject("city", city);
		return mav;
		
	}
	
	/**
	 * 设备商列表
	 * @return
	 */
	@RequestMapping(value="web_equip_list.html")
	public ModelAndView web_equip_list(){
		ModelAndView mav = new ModelAndView("/web/team/web_equip_list");
		
		String shopName = request.getParameter("shopName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String status = request.getParameter("status");
		
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(shopName)){
			Pattern pattern = Pattern.compile(".*" + shopName  + ".*",Pattern.CASE_INSENSITIVE);
			queryObj.put("shopName", pattern);
		}
		if(StringUtils.isNotBlank(province)){
			queryObj.put("province", province);
		}
		if(StringUtils.isNotBlank(city)){
			queryObj.put("city", city);
		}
		if(StringUtils.isNotBlank(status)){
			queryObj.put("status", Integer.valueOf(status));
		}
		dataCount = equipmentService.countAllEquipment(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		mav.addObject("clist", equipmentService.getEquipmentList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("shopName", shopName);
		mav.addObject("status", status);
		mav.addObject("province", province);
		mav.addObject("city", city);
		
		return mav;
		
	}
	
	/**
	 * 个人找班组
	 * @return
	 */
	@RequestMapping(value="persontoteam.html")
	public ModelAndView persontoteam(){
		ModelAndView mav = new ModelAndView("/web/job/persontoteam");
		String name = request.getParameter("name");
		String skillBigType = request.getParameter("skillBigType");
		String smalltype = request.getParameter("smalltype");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(name)){
			Pattern pattern = Pattern.compile(".*" + name  + ".*",Pattern.CASE_INSENSITIVE);
			queryObj.put("name", pattern);
		}
		if(StringUtils.isNotBlank(province)){
			queryObj.put("province", province);
		}
		if(StringUtils.isNotBlank(city)){
			queryObj.put("city", city);
		}
		if(StringUtils.isNotBlank(skillBigType)){
			queryObj.put("skillBigType", Integer.valueOf(skillBigType));
		}
		if(StringUtils.isNotBlank(smalltype)){
			queryObj.put("skillSmallType", Integer.valueOf(smalltype));
		}
		
		queryObj.put("status", 1);
		queryObj.put("type", 2);
		queryObj.put("userType", 2);
		queryObj.put("teamType", 1);
		
		dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		List<RequirementsModel> list = requirementsService.getList(queryObj,pageNow,pageSize);
		if(list != null && !list.isEmpty()){
			for(RequirementsModel model:list){
				TeamModel tModel = teamService.getTeamById(model.getrId());
				if(tModel != null)
					model.setTeamModel(tModel);
			}
		}
		
		mav.addObject("clist", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("name", name);
		mav.addObject("province", province);
		mav.addObject("city", city);
		mav.addObject("skillBigType", skillBigType);
		mav.addObject("smalltype", smalltype);
		
		return mav;
		
	}
	
	/**
	 * 班组找项目
	 * @return
	 */
	@RequestMapping(value="teamtoproject.html")
	public ModelAndView teamtoproject(){
		ModelAndView mav = new ModelAndView("/web/job/teamtoproject");
		String name = request.getParameter("name");
		String skillBigType = request.getParameter("skillBigType");
		String smalltype = request.getParameter("smalltype");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String teamTypeStr = request.getParameter("teamType");
		if(StringUtils.isBlank(teamTypeStr))
			teamTypeStr = "1";//默认施工班组
		
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(name)){
			Pattern pattern = Pattern.compile(".*" + name  + ".*",Pattern.CASE_INSENSITIVE);
			queryObj.put("name", pattern);
		}
		if(StringUtils.isNotBlank(province)){
			queryObj.put("province", province);
		}
		if(StringUtils.isNotBlank(city)){
			queryObj.put("city", city);
		}
		if(StringUtils.isNotBlank(skillBigType) && teamTypeStr.equals("1")){
			queryObj.put("skillBigType", Integer.valueOf(skillBigType));
		}
		if(StringUtils.isNotBlank(smalltype) && teamTypeStr.equals("1")){
			queryObj.put("skillSmallType", Integer.valueOf(smalltype));
		}
		queryObj.put("teamType", Integer.valueOf(teamTypeStr));
		queryObj.put("status", 1);
		queryObj.put("type", 2);
		queryObj.put("userType", 3);
		
		dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		List<RequirementsModel> list = requirementsService.getList(queryObj,pageNow,pageSize);
		if(list != null && !list.isEmpty()){
			for(RequirementsModel model:list){
				ProjectModel pModel = projectService.getById(model.getrId());
				if(pModel != null){
					model.setpModel(pModel);
					CompanyModel cModel = companyService.getByCode(pModel.getCode());
					if(cModel != null)
						model.setcModel(cModel);
				}
			}
		}
		
		mav.addObject("clist", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("name", name);
		mav.addObject("province", province);
		mav.addObject("city", city);
		mav.addObject("skillBigType", skillBigType);
		mav.addObject("smalltype", smalltype);
		mav.addObject("teamType", teamTypeStr);
		
		return mav;
		
	}
	
	/**
	 * 项目找班组
	 * @return
	 */
	@RequestMapping(value="projecttoteam.html")
	public ModelAndView projecttoteam(){
		ModelAndView mav = new ModelAndView("/web/job/projecttoteam");
		String name = request.getParameter("name");
		String skillBigType = request.getParameter("skillBigType");
		String smalltype = request.getParameter("smalltype");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(name)){
			Pattern pattern = Pattern.compile(".*" + name  + ".*",Pattern.CASE_INSENSITIVE);
			queryObj.put("name", pattern);
		}
		if(StringUtils.isNotBlank(province)){
			queryObj.put("province", province);
		}
		if(StringUtils.isNotBlank(city)){
			queryObj.put("city", city);
		}
		if(StringUtils.isNotBlank(skillBigType)){
			queryObj.put("skillBigType", Integer.valueOf(skillBigType));
		}
		if(StringUtils.isNotBlank(smalltype)){
			queryObj.put("skillSmallType", Integer.valueOf(smalltype));
		}
		queryObj.put("status", 1);
		queryObj.put("type", 1);
		queryObj.put("userType", 2);
		queryObj.put("teamType", 1);
		
		dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		List<RequirementsModel> list = requirementsService.getList(queryObj,pageNow,pageSize);
		if(list != null && !list.isEmpty()){
			for(RequirementsModel model:list){
				TeamModel tModel = teamService.getTeamById(model.getrId());
				if(tModel != null)
					model.setTeamModel(tModel);
			}
		}
		
		mav.addObject("clist", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("name", name);
		mav.addObject("province", province);
		mav.addObject("city", city);
		mav.addObject("skillBigType", skillBigType);
		mav.addObject("smalltype", smalltype);
		
		return mav;
		
	}
	
	/**
	 * 班组找个人
	 * @return
	 */
	@RequestMapping(value="teamtoperson.html")
	public ModelAndView teamtoperson(){
		ModelAndView mav = new ModelAndView("/web/job/teamtoperson");
		String name = request.getParameter("name");
		String skillBigType = request.getParameter("skillBigType");
		String smalltype = request.getParameter("smalltype");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(name)){
			Pattern pattern = Pattern.compile(".*" + name  + ".*",Pattern.CASE_INSENSITIVE);
			queryObj.put("name", pattern);
		}
		if(StringUtils.isNotBlank(province)){
			queryObj.put("province", province);
		}
		if(StringUtils.isNotBlank(city)){
			queryObj.put("city", city);
		}
		if(StringUtils.isNotBlank(skillBigType)){
			queryObj.put("skillBigType", Integer.valueOf(skillBigType));
		}
		if(StringUtils.isNotBlank(smalltype)){
			queryObj.put("skillSmallType", Integer.valueOf(smalltype));
		}
		queryObj.put("status", 1);
		queryObj.put("type", 1);
		queryObj.put("userType", 1);
		
		dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		List<RequirementsModel> list = requirementsService.getList(queryObj,pageNow,pageSize);
		if(list != null && !list.isEmpty()){
			for(RequirementsModel model:list){
				UserModel uModel = userService.getByUserId(model.getrId());
				if(uModel != null)
					model.setUserModel(uModel);
			}
		}
		
		mav.addObject("clist", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("name", name);
		mav.addObject("province", province);
		mav.addObject("city", city);
		mav.addObject("skillBigType", skillBigType);
		mav.addObject("smalltype", smalltype);
		
		return mav;
		
	}
	
	/**
	 * 项目找材料
	 * @return
	 */
	@RequestMapping(value="projecttomaterial.html")
	public ModelAndView projecttomaterial(){
		ModelAndView mav = new ModelAndView("/web/job/projecttomaterial");
		String shopName = request.getParameter("shopName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(shopName)){
			Pattern pattern = Pattern.compile(".*" + shopName  + ".*",Pattern.CASE_INSENSITIVE);
			queryObj.put("shopName", pattern);
		}
		if(StringUtils.isNotBlank(province)){
			queryObj.put("province", province);
		}
		if(StringUtils.isNotBlank(city)){
			queryObj.put("city", city);
		}
		queryObj.put("status", 1);
		queryObj.put("type", 1);
		queryObj.put("userType", 2);
		queryObj.put("teamType", 2);
		
		dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		List<RequirementsModel> list = requirementsService.getList(queryObj,pageNow,pageSize);
		if(list != null && !list.isEmpty()){
			for(RequirementsModel model:list){
				MaterialModel materialModel = materialService.getById(model.getrId());
				if(materialModel != null)
					model.setMaterialModel(materialModel);
			}
		}
		
		mav.addObject("clist", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("shopName", shopName);
		mav.addObject("province", province);
		mav.addObject("city", city);
		
		return mav;
		
	}
	
	/**
	 * 项目找设备
	 * @return
	 */
	@RequestMapping(value="projecttoequipment.html")
	public ModelAndView projecttoequipment(){
		ModelAndView mav = new ModelAndView("/web/job/projecttoequipment");
		String shopName = request.getParameter("shopName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(shopName)){
			Pattern pattern = Pattern.compile(".*" + shopName  + ".*",Pattern.CASE_INSENSITIVE);
			queryObj.put("shopName", pattern);
		}
		if(StringUtils.isNotBlank(province)){
			queryObj.put("province", province);
		}
		if(StringUtils.isNotBlank(city)){
			queryObj.put("city", city);
		}
		queryObj.put("status", 1);
		queryObj.put("type", 1);
		queryObj.put("userType", 2);
		queryObj.put("teamType", 3);
		
		dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		List<RequirementsModel> list = requirementsService.getList(queryObj,pageNow,pageSize);
		if(list != null && !list.isEmpty()){
			for(RequirementsModel model:list){
				EquipmentModel equipmentModel = equipmentService.getById(model.getrId());
				if(equipmentModel != null)
					model.setEquipmentModel(equipmentModel);
			}
		}
		
		mav.addObject("clist", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("shopName", shopName);
		mav.addObject("province", province);
		mav.addObject("city", city);
		
		return mav;
		
	}
	
	/**
	 * 个人申请班组
	 * @return
	 */
	@RequestMapping(value="personapplyteam.html")
	public ModelAndView personApplyTeam(){
		String msg = doPersonApplyTeam();
		
		
		ModelAndView mav = new ModelAndView("/web/job/persontoteam");
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("status", 1);
		queryObj.put("type", 2);
		queryObj.put("userType", 2);
		queryObj.put("teamType", 1);
		
		dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		List<RequirementsModel> list = requirementsService.getList(queryObj,pageNow,pageSize);
		if(list != null && !list.isEmpty()){
			for(RequirementsModel model2:list){
				TeamModel tModel = teamService.getTeamById(model2.getrId());
				if(tModel != null)
					model2.setTeamModel(tModel);
			}
		}
		
		mav.addObject("msg", msg);
		mav.addObject("clist", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		return mav;
	}
	
	/**
	 * 申请班组逻辑
	 * @return
	 */
	private String doPersonApplyTeam(){
		String id = request.getParameter("id");//班组ID
		RequirementsModel model = requirementsService.getById(id);
		//判断是否已经还在招聘中
		if(model == null || model.getStatus() == 0){
			return "该班组已经招聘满员了噢！请再找找其他班组吧~";
		}
		String tId = model.getrId();
		//班组ID为空
		if(StringUtils.isBlank(tId)){
			return null;
		}
		String userId = (String)request.getSession().getAttribute(ESessionKey.UserId.key);
		//有没有登录过
		if(StringUtils.isBlank(userId)){
			return "您还没有登录,请登录后再操作！";
		}
		//判断是否个人用户
		String userType = (String)request.getSession().getAttribute(ESessionKey.UserType.key);
		if(StringUtils.isBlank(userType) || !userType.equals("0")){
			return "您是工人才可以申请班组噢！";
		}
		//判断是否班组长
		TeamModel teamModel = teamService.getTeamByLeaderMobile(userId);
		if(teamModel != null){
			return "您已经是班组长，没有权限申请班组噢！";
		}
		
		//是否已经加入其它班组
		int count = teamService.countUserIdByStatus(userId, 3);
		if(count > 0)
			return "你已经加入其它班组，不能重复申请";
		
		//判断是否已经申请过
		int status = teamService.findMemberStatus(userId, tId);
		if(status == 1){
			return "您已经申请过该班组了！";
		}else if(status == 2){
			return "该班组已经邀请你加入,记得通过哦！";
		}else if(status == 3){
			return "您已经加入该班组了，不需要重复申请";
		}
		requirementsService.persoonApplyTeam(userId, tId);
		return "申请成功";
			
	}
	
	/**
	 * 班组申请项目
	 * @return
	 */
	@RequestMapping(value="teamapplyproject.html")
	public ModelAndView teamApplyProject(){
		int[] arg = new int[1];
		String msg = doTeamApplyProject(arg);
		
		ModelAndView mav = new ModelAndView("/web/job/teamtoproject");
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("status", 1);
		queryObj.put("type", 2);
		queryObj.put("userType", 3);
		queryObj.put("teamType", arg[0]);
		
		dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		List<RequirementsModel> list = requirementsService.getList(queryObj,pageNow,pageSize);
		if(list != null && list.size() > 0)
		for(RequirementsModel model:list){
			ProjectModel pModel = projectService.getById(model.getrId());
			if(pModel != null){
				model.setpModel(pModel);
				CompanyModel cModel = companyService.getByCode(pModel.getCode());
				if(cModel != null)
					model.setcModel(cModel);
			}
		}
		
		mav.addObject("msg", msg);
		mav.addObject("clist", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		mav.addObject("teamType", arg[0] + "");
		
		return mav;
	}
	
	/**
	 * 申请项目逻辑
	 * @return
	 */
	private String doTeamApplyProject(int[] arg){
		String id = request.getParameter("id");//招聘ID
		String userId = (String)request.getSession().getAttribute(ESessionKey.UserId.key);
		//有没有登录过
		if(StringUtils.isBlank(userId)){
			return "您还没有登录,请登录后再操作！";
		}
		//判断是否个人用户
		String userType = (String)request.getSession().getAttribute(ESessionKey.UserType.key);
		if(StringUtils.isBlank(userType)){
			return null;
		}
		//判断是否已经还在招聘中
		RequirementsModel model = requirementsService.getById(id);
		if(model == null || model.getStatus() == 0){
			return "该招聘信息已经过期！请再找找其他项目吧~";
		}
		//判断班组类型
		arg[0] = model.getTeamType();
		//施工班组
		if(model.getTeamType() == 1){
			//是否班组长
			TeamModel tModel = teamService.getTeamModelByUserId(userId);
			if(tModel == null){
				return "您还不是班组长，不能申请项目噢!";
			}
			//是否已经在其他项目中
			if(projectService.teamJoinProject(tModel.getId()))
				return "您的班组已经加入其它项目,不能重复申请";
			
			//是否重复申请
			ProjectDepartmentModel pdModel = projectService.getProjectDepartment(model.getrId(),tModel.getId(),1);
			if(pdModel != null){
				if(pdModel.getStatus() == 1)
					return "您已经申请过该项目了";
				if(pdModel.getStatus() == 2)
					return "该项目已经邀请您的施工班组了，赶快通过吧！";
				if(pdModel.getStatus() == 3)
					return "您的施工班组已经在该项目里了，不需要重复申请";
				pdModel.setStatus(1);
				projectService.updateProjectDepartmentStatus(pdModel);
			}else{
				pdModel = new ProjectDepartmentModel();
				pdModel.setPId(model.getrId());
				pdModel.setStatus(1);
				pdModel.setVId(tModel.getId());
				pdModel.setType(1);
				projectService.addProjectDepartment(pdModel);
			}
		//材料班组		
		}else if(model.getTeamType() == 2){
			//是否材料商
			MaterialModel mModel = materialService.getByUserId(userId);
			if(mModel == null)
				return "对不起,您不符合招聘需求,请先创建材料班组信息";
			//是否已经在其他项目中
			
			//是否重复申请
			ProjectDepartmentModel pdModel = projectService.getProjectDepartment(model.getrId(),mModel.getId(),2);
			if(pdModel != null){
				if(pdModel.getStatus() == 1)
					return "您已经申请过该项目了";
				if(pdModel.getStatus() == 2)
					return "该项目已经邀请您的材料班组了，赶快通过吧！";
				if(pdModel.getStatus() == 3)
					return "您的材料班组已经在该项目里了，不需要重复申请";
				pdModel.setStatus(1);
				projectService.updateProjectDepartmentStatus(pdModel);
			}else{
				//申请成功
				pdModel = new ProjectDepartmentModel();
				pdModel.setPId(model.getrId());
				pdModel.setStatus(1);
				pdModel.setVId(mModel.getId());
				pdModel.setType(2);
				projectService.addProjectDepartment(pdModel);
			}
			
		}else if(model.getTeamType() == 3){
			//是否设备商
			EquipmentModel eModel = equipmentService.getByUserId(userId);
			if(eModel == null)
				return "对不起,您不符合招聘需求,请先创建设备班组信息";
			//是否已经在其他项目中
			
			//是否重复申请
			ProjectDepartmentModel pdModel = projectService.getProjectDepartment(model.getrId(),eModel.getId(),3);
			if(pdModel != null){
				if(pdModel.getStatus() == 1)
					return "您已经申请过该项目了";
				if(pdModel.getStatus() == 2)
					return "该项目已经邀请您的设备班组了，赶快通过吧！";
				if(pdModel.getStatus() == 3)
					return "您的设备班组已经在该项目里了，不需要重复申请";
				pdModel.setStatus(1);
				projectService.updateProjectDepartmentStatus(pdModel);
			}else{
				pdModel = new ProjectDepartmentModel();
				pdModel.setPId(model.getrId());
				pdModel.setStatus(1);
				pdModel.setVId(eModel.getId());
				pdModel.setType(3);
				projectService.addProjectDepartment(pdModel);
			}
		}
		
		return "申请成功！";
	}
	
	
	
	/**
	 * 班组邀请个人
	 * @return
	 */
	@RequestMapping(value="teamapplyperson.html")
	public ModelAndView teamApplyPerson(){
		String msg = doTeamApplyPerson();
		
		ModelAndView mav = new ModelAndView("/web/job/teamtoperson");
		
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		
		queryObj.put("status", 1);
		queryObj.put("type", 1);
		queryObj.put("userType", 1);
		
		dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		List<RequirementsModel> list = requirementsService.getList(queryObj,pageNow,pageSize);
		if(list != null && !list.isEmpty()){
			for(RequirementsModel model:list){
				UserModel uModel = userService.getByUserId(model.getrId());
				if(uModel != null)
					model.setUserModel(uModel);
			}
		}
		
		mav.addObject("clist", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		mav.addObject("msg", msg);
		return mav;
		
	}
	
	private String doTeamApplyPerson(){
		String id = request.getParameter("id");//被邀请人ID
		String userId = (String)request.getSession().getAttribute(ESessionKey.UserId.key);
		//有没有登录过
		if(StringUtils.isBlank(userId)){
			return "您还没有登录,请登录后再操作！";
		}
		String userType = (String)request.getSession().getAttribute(ESessionKey.UserType.key);
		if(StringUtils.isBlank(userType)){
			return null;
		}
		//是否班组长
		TeamModel tModel = teamService.getTeamModelByUserId(userId);
		if(!userType.equals("0") || tModel == null){
			return "您还不是班组长，没有权限邀请工人!";
		}
		//是否已经加入其它班组
		if(teamService.countUserIdByStatus(id, 3) > 0){
			return "该工人已经加入其它班组，不能邀请!";
		}
		
		//是否已经在班组里
		TeamMemberModel tmModel = teamService.getTeamMemberByUserIdAndTId(id, tModel.getId());
		if(tmModel != null){
			if(tmModel.getStatus() == 1)
				return "该用户已经在您的申请列表里面,赶快去通过吧!";
			if(tmModel.getStatus() == 2)
				return "您已经邀请过了";
			if(tmModel.getStatus() == 3)
				return "该经在您班组里";
			tmModel.setStatus(2);
			teamService.passTeamMember(tmModel.getId(),3);
		}else{
			teamService.addTeamMember(tModel.getId(), id, 2);
		}
		
		return "邀请成功！";
	}
	
	
	/**
	 * 项目邀请施工班组
	 * @return
	 */
	@RequestMapping(value="projectapplyteam.html")
	public ModelAndView projectApplyTeam(){
		String msg = doProjectApplyTeam();
		ModelAndView mav = new ModelAndView("/web/job/projecttoteam");
		
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("status", 1);
		queryObj.put("type", 1);
		queryObj.put("userType", 2);
		queryObj.put("teamType", 1);
		
		dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		List<RequirementsModel> list = requirementsService.getList(queryObj,pageNow,pageSize);
		if(list != null && !list.isEmpty()){
			for(RequirementsModel model:list){
				TeamModel tModel = teamService.getTeamById(model.getrId());
				if(tModel != null)
					model.setTeamModel(tModel);
			}
		}
		
		mav.addObject("clist", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		mav.addObject("msg", msg);
		return mav;
		
	}
	
	private String doProjectApplyTeam(){
		String tId = request.getParameter("tId");//班组ID
		String userId = (String)request.getSession().getAttribute(ESessionKey.UserId.key);
		//有没有登录过
		if(StringUtils.isBlank(userId)){
			return "您还没有登录,请登录后再操作！";
		}
		//判断是否项目负责人
		String userType = (String)request.getSession().getAttribute(ESessionKey.UserType.key);
		if(StringUtils.isBlank(userType)){
			return null;
		}
		//是否项目负责人
		ProjectModel pModel = projectService.getProjectByUserId(userId);
		if(pModel == null){
			return "您还不是项目负责人，不能邀请班组";
		}
		//是否已经在其他项目中
		if(projectService.teamJoinProject(tId)){
			return "该班组已经加入其它项目，不能邀请";
		}
		
		//是否重复申请
		ProjectDepartmentModel pdModel = projectService.getProjectDepartment(pModel.getId(),tId,1);
		if(pdModel != null){
			if(pdModel.getStatus() == 1)
				return "您已经申请过该项目了";
			if(pdModel.getStatus() == 2)
				return "该项目已经邀请您的设备班组了，赶快通过吧！";
			if(pdModel.getStatus() == 3)
				return "您的设备班组已经在该项目里了，不需要重复申请";
			pdModel.setStatus(1);
			projectService.updateProjectDepartmentStatus(pdModel);
		}else{
			pdModel = new ProjectDepartmentModel();
			pdModel.setPId(pModel.getId());
			pdModel.setStatus(2);
			pdModel.setVId(tId);
			pdModel.setType(1);
			projectService.addProjectDepartment(pdModel);
		}
		
		
		return "邀请成功！";
	}
	
	
	
	
	/**
	 * 项目邀请材料班组
	 * @return
	 */
	@RequestMapping(value="projectapplymaterail.html")
	public ModelAndView projectApplyMaterial(){
		String msg = doProjectMaterial();
		ModelAndView mav = new ModelAndView("/web/job/projecttomaterial");
		
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("status", 1);
		queryObj.put("type", 1);
		queryObj.put("userType", 2);
		queryObj.put("teamType", 2);
		
		dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		List<RequirementsModel> list = requirementsService.getList(queryObj,pageNow,pageSize);
		if(list != null && !list.isEmpty()){
			for(RequirementsModel model:list){
				MaterialModel materialModel = materialService.getById(model.getrId());
				if(materialModel != null)
					model.setMaterialModel(materialModel);
			}
		}
		
		mav.addObject("clist", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		mav.addObject("msg", msg);
		return mav;
		
	}
	
	private String doProjectMaterial(){
		String rId = request.getParameter("rId");//材料商ID
		String userId = (String)request.getSession().getAttribute(ESessionKey.UserId.key);
		//有没有登录过
		if(StringUtils.isBlank(userId)){
			return "您还没有登录,请登录后再操作！";
		}
		//判断是否项目负责人
		String userType = (String)request.getSession().getAttribute(ESessionKey.UserType.key);
		if(StringUtils.isBlank(userType)){
			return null;
		}
		//是否项目负责人
		ProjectModel pModel = projectService.getProjectByUserId(userId);
		if(pModel == null){
			return "您还不是项目负责人，不能邀请班组";
		}
		//是否已经在其他项目中
		
		//是否重复申请
		ProjectDepartmentModel pdModel = projectService.getProjectDepartment(pModel.getId(),rId,2);
		if(pdModel != null){
			if(pdModel.getStatus() == 1)
				return "您已经申请过该项目了";
			if(pdModel.getStatus() == 2)
				return "该项目已经邀请您的设备班组了，赶快通过吧！";
			if(pdModel.getStatus() == 3)
				return "您的设备班组已经在该项目里了，不需要重复申请";
			pdModel.setStatus(1);
			projectService.updateProjectDepartmentStatus(pdModel);
		}else{
			pdModel = new ProjectDepartmentModel();
			pdModel.setPId(pModel.getId());
			pdModel.setStatus(2);
			pdModel.setVId(rId);
			pdModel.setType(2);
			projectService.addProjectDepartment(pdModel);
		}
		
		
		return "邀请成功！";
	}
	
	
	
	/**
	 * 项目邀请设备班组
	 * @return
	 */
	@RequestMapping(value="projectapplyequipment.html")
	public ModelAndView projectApplyEquipment(){
		String msg = doProjectEquipment();
		ModelAndView mav = new ModelAndView("/web/job/projecttoequipment");
		
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("status", 1);
		queryObj.put("type", 1);
		queryObj.put("userType", 2);
		queryObj.put("teamType", 3);
		
		dataCount = requirementsService.countAll(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		List<RequirementsModel> list = requirementsService.getList(queryObj,pageNow,pageSize);
		if(list != null && !list.isEmpty()){
			for(RequirementsModel model:list){
				EquipmentModel equipmentModel = equipmentService.getById(model.getrId());
				if(equipmentModel != null)
					model.setEquipmentModel(equipmentModel);
			}
		}
		
		mav.addObject("clist", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		mav.addObject("msg", msg);
		return mav;
		
	}
	
	private String doProjectEquipment(){
		String rId = request.getParameter("rId");//材料商ID
		String userId = (String)request.getSession().getAttribute(ESessionKey.UserId.key);
		//有没有登录过
		if(StringUtils.isBlank(userId)){
			return "您还没有登录,请登录后再操作！";
		}
		//判断是否项目负责人
		String userType = (String)request.getSession().getAttribute(ESessionKey.UserType.key);
		if(StringUtils.isBlank(userType)){
			return null;
		}
		//是否项目负责人
		ProjectModel pModel = projectService.getProjectByUserId(userId);
		if(pModel == null){
			return "您还不是项目负责人，不能邀请班组";
		}
		//是否已经在其他项目中
		
		//是否重复申请
		ProjectDepartmentModel pdModel = projectService.getProjectDepartment(pModel.getId(),rId,3);
		if(pdModel != null){
			if(pdModel.getStatus() == 1)
				return "您已经申请过该项目了";
			if(pdModel.getStatus() == 2)
				return "该项目已经邀请您的设备班组了，赶快通过吧！";
			if(pdModel.getStatus() == 3)
				return "您的设备班组已经在该项目里了，不需要重复申请";
			pdModel.setStatus(1);
			projectService.updateProjectDepartmentStatus(pdModel);
		}else{
			pdModel = new ProjectDepartmentModel();
			pdModel.setPId(pModel.getId());
			pdModel.setStatus(2);
			pdModel.setVId(rId);
			pdModel.setType(3);
			projectService.addProjectDepartment(pdModel);
		}
		
		
		return "邀请成功！";
	}
	
	/////////////////////////////////////////////////////////////
	/**
	 * 行业动态列表
	 * @return
	 */
	@RequestMapping(value="industry_list.html")
	public ModelAndView industry_list(){
		ModelAndView mav = new ModelAndView("/web/other/industry_list");
		//
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("bidtype", 2);//行业动态

		dataCount = bidInfoService.countAllBidInfo(queryObj);

		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 8;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		mav.addObject("clist", bidInfoService.getBidInfoList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		return mav;
		
	}
	
	/**
	 * 招投标列表
	 * @return
	 */
	@RequestMapping(value="tender_list.html")
	public ModelAndView tender_list(){
		ModelAndView mav = new ModelAndView("/web/other/tender_list");
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("bidtype", 1);//招投标信息

		mav.addObject("clist", bidInfoService.getBidInfoList(queryObj,1,50));
		return mav;
		
	}
	
	/**
	 * 查询个人信息
	 * @return
	 */
	@RequestMapping(value="web_person_info.html")
	public ModelAndView web_person_info(){
		ModelAndView mav = new ModelAndView("/web/info/personinfo");
		String userId = request.getParameter("userId");//
		UserModel uModel = userService.getByUserId(userId);
		if(uModel != null){
			mav.addObject("uModel",uModel);
		}
		
		return mav;
		
	}
	
	/**
	 * 查询班组信息
	 * @return
	 */
	@RequestMapping(value="web_team_info.html")
	public ModelAndView web_team_info(){
		ModelAndView mav = new ModelAndView("/web/info/teaminfo");
		String tId = request.getParameter("tId");//
		String type = request.getParameter("type");//null-信息 1-求职 2-招聘
		TeamModel tModel = teamService.getTeamById(tId);
		if(tModel != null){
			mav.addObject("tModel",tModel);
			if(StringUtils.isNotBlank(type)){
				//获得招聘信息
				RequirementsModel rModel = requirementsService.getRecruitByTeamId(tId,Integer.valueOf(type));
				if(rModel != null)
					mav.addObject("rModel",rModel);
			}
		}
		mav.addObject("type",type);
		return mav;
		
	}
	
	/**
	 * 查询材料商信息
	 * @return
	 */
	@RequestMapping(value="web_material_info.html")
	public ModelAndView web_material_info(){
		ModelAndView mav = new ModelAndView("/web/info/materialinfo");
		String id = request.getParameter("id");//
		MaterialModel mModel = materialService.getById(id);
		if(mModel != null){
			mav.addObject("mModel",mModel);
		}
		
		return mav;
		
	}
	
	/**
	 * 查询材料商信息
	 * @return
	 */
	@RequestMapping(value="web_equip_info.html")
	public ModelAndView web_equip_info(){
		ModelAndView mav = new ModelAndView("/web/info/equipinfo");
		String id = request.getParameter("id");//
		EquipmentModel eModel = equipmentService.getById(id);
		if(eModel != null){
			mav.addObject("eModel",eModel);
		}
		
		return mav;
		
	}
	
	/////////////////////////////////////////////////
	/**
	 * 首页搜索
	 * @return
	 */
	@RequestMapping(value="web_search.html")
	public ModelAndView web_search(){
		ModelAndView mav = new ModelAndView("/search");
		String type = request.getParameter("type");//1-项目 2-班组 3-个人
		String text = request.getParameter("text");//
		if(type == null || "".equals(type))
			return null;
		switch(type){
			case "1":mav.addObject("pList",projectService.getSearchList(text));break;
			case "2":mav.addObject("tList",teamService.getSearchList(text));break;
			case "3":mav.addObject("uList",userService.getSearchList(text));break;
		}
		
		mav.addObject("type",type);
		mav.addObject("text",text);
		return mav;
	}
	
	/**
	 * 法律咨询
	 * @return
	 */
	@RequestMapping(value="web_lawer.html")
	public ModelAndView web_lawer(){
		ModelAndView mav = new ModelAndView("/web/other/lawer");
		mav.addObject("list",lawInsuService.getLawInsuList(2));
		return mav;
	}
	
	/**
	 * 金融保险
	 * @return
	 */
	@RequestMapping(value="web_insurance.html")
	public ModelAndView web_insurance(){
		ModelAndView mav = new ModelAndView("/web/other/insurance");
		mav.addObject("list",lawInsuService.getLawInsuList(1));
		return mav;
	}
	
	/**
	 * 查看金融或咨询信息
	 * @return
	 */
	@RequestMapping(value="web_lawer_info.html")
	public ModelAndView web_lawer_info(){
		ModelAndView mav = new ModelAndView("/web/other/lawer_info");
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		LawInsuModel model = lawInsuService.getById(id);
		
		mav.addObject("type", type);
		mav.addObject("model",model);
		return mav;
	}
	
	/**
	 * 查看公司信息
	 * @return
	 */
	@RequestMapping(value="web_company_info.html")
	public ModelAndView web_company_info(){
		ModelAndView mav = new ModelAndView("/web/company/web_company_info");
		String id = request.getParameter("id");
		String userId = request.getParameter("userId");
		CompanyModel model = null;
		if(StringUtils.isNotBlank(id))
			model = companyService.getById(id);
		if(model == null){
			model = companyService.getByUserId(userId);
		}
		
		mav.addObject("model",model);
		//获取公司项目
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("code", model.getCode());
		mav.addObject("plist", projectService.getProjectList(queryObj,1,0));
		//获取企业资质
		//List<AptitudeModel> atModels = aptitudeService.getByCode(model.getCode());
		mav.addObject("atlist",aptitudeService.getByCode(model.getCode()));
		//获取注册人员
		mav.addObject("enlist",engineerService.getByCode(model.getCode(),3,0));
		
		return mav;
	}
	
	/**
	 * 查看项目信息
	 * @return
	 */
	@RequestMapping(value="web_project_info.html")
	public ModelAndView web_project_info(){
		ModelAndView mav = new ModelAndView("/web/project/web_project_info");
		String id = request.getParameter("id");
		ProjectModel model = projectService.getById(id);
		mav.addObject("model",model);
		//公司信息
		CompanyModel cmodel = companyService.getByCode(model.getCode());
		mav.addObject("cmodel",cmodel);
		//参见单位
		mav.addObject("jList",joinBuildService.getBypCode(model.getpCode()));
		//关键岗位人员
		mav.addObject("pList",keyPersonService.getBypCode(model.getpCode()));
		return mav;
	}
	///////////////////////////////////////////////////////////////////////
	/**
	 * 查询个人求职信息
	 * @return
	 */
	@RequestMapping(value="job_person.html")
	public ModelAndView job_person(){
		ModelAndView mav = new ModelAndView("/web/info/job_person");
		String userId = request.getParameter("userId");//
		String id = request.getParameter("id");//
		UserModel uModel = userService.getByUserId(userId);
		if(uModel != null){
			mav.addObject("uModel",uModel);
			//查询求职信息
			RequirementsModel model = requirementsService.getById(id);
			mav.addObject("model",model);
			//持证情况
			mav.addObject("engineer", engineerService.getByUserId(userId));
		}
		
		return mav;
		
	}
	
	/**
	 * 查询班组求职信息
	 * @return
	 */
	@RequestMapping(value="job_team.html")
	public ModelAndView job_team(){
		ModelAndView mav = new ModelAndView("/web/info/job_team");
		String tId = request.getParameter("tId");//
		TeamModel tModel = teamService.getTeamById(tId);
		String id = request.getParameter("id");//
		if(tModel != null){
			mav.addObject("tModel",tModel);
			//获得求职信息
			RequirementsModel rModel = requirementsService.getById(id);
			if(rModel != null)
				mav.addObject("rModel",rModel);
			//获得班组成员
			List<UserModel> userList = teamService.getTeamMemberListBytId(tId);
			mav.addObject("userList",userList);
			//获取以往工程
			List<ProjectModel> plist = new ArrayList<ProjectModel>();
			List<ProjectDepartmentModel> pdlist = projectDepartmentService.getProjectByTIdStatus(tModel.getId(), 1, 4);
			if(pdlist != null && pdlist.size() > 0){
				for(ProjectDepartmentModel pdModel:pdlist){
					ProjectModel pModel = projectService.getById(pdModel.getpId());
					plist.add(pModel);
				}
				mav.addObject("plist", plist);
			}
			
			
		}
		return mav;
		
	}
	
	/**
	 * 查询材料商求职信息
	 * @return
	 */
	@RequestMapping(value="job_material.html")
	public ModelAndView job_material(){
		ModelAndView mav = new ModelAndView("/web/info/job_material");
		String mId = request.getParameter("mId");//
		String id = request.getParameter("id");//
		MaterialModel mModel = materialService.getById(mId);
		if(mModel != null){
			mav.addObject("mModel",mModel);
			//获得求职信息
			RequirementsModel rModel = requirementsService.getById(id);
			if(rModel != null)
				mav.addObject("rModel",rModel);
			//获取以往工程
			List<ProjectModel> plist = new ArrayList<ProjectModel>();
			List<ProjectDepartmentModel> pdlist = projectDepartmentService.getProjectByTIdStatus(mModel.getId(), 2, 4);
			if(pdlist != null && pdlist.size() > 0){
				for(ProjectDepartmentModel pdModel:pdlist){
					ProjectModel pModel = projectService.getById(pdModel.getpId());
					plist.add(pModel);
				}
				mav.addObject("plist", plist);
			}
		}
		return mav;
		
	}
	
	/**
	 * 查询设备商求职信息
	 * @return
	 */
	@RequestMapping(value="job_equip.html")
	public ModelAndView job_equip(){
		ModelAndView mav = new ModelAndView("/web/info/job_equip");
		String eId = request.getParameter("eId");//
		String id = request.getParameter("id");//
		EquipmentModel eModel = equipmentService.getById(eId);
		if(eModel != null){
			mav.addObject("eModel",eModel);
			//获得求职信息
			RequirementsModel rModel = requirementsService.getById(id);
			if(rModel != null)
				mav.addObject("rModel",rModel);
			//获取以往工程
			List<ProjectModel> plist = new ArrayList<ProjectModel>();
			List<ProjectDepartmentModel> pdlist = projectDepartmentService.getProjectByTIdStatus(eModel.getId(), 3, 4);
			if(pdlist != null && pdlist.size() > 0){
				for(ProjectDepartmentModel pdModel:pdlist){
					ProjectModel pModel = projectService.getById(pdModel.getpId());
					plist.add(pModel);
				}
				mav.addObject("plist", plist);
			}
		}
		return mav;
		
	}
	
	/**
	 * 查询班组招聘信息
	 * @return
	 */
	@RequestMapping(value="recruit_person.html")
	public ModelAndView recruit_person(){
		ModelAndView mav = new ModelAndView("/web/info/recruit_person");
		String tId = request.getParameter("tId");//
		TeamModel tModel = teamService.getTeamById(tId);
		String id = request.getParameter("id");//
		if(tModel != null){
			mav.addObject("tModel",tModel);
			//获得求职信息
			RequirementsModel rModel = requirementsService.getById(id);
			if(rModel != null)
				mav.addObject("rModel",rModel);
		}
		return mav;
		
	}
	
	/**
	 * 查询项目招聘信息
	 * @return
	 */
	@RequestMapping(value="recruit_team.html")
	public ModelAndView recruit_team(){
		ModelAndView mav = new ModelAndView("/web/info/recruit_team");
		String pId = request.getParameter("pId");//
		String id = request.getParameter("id");//
		ProjectModel pModel = projectService.getById(pId);
		if(pModel != null){
			mav.addObject("pModel",pModel);
			//获得求职信息
			RequirementsModel rModel = requirementsService.getById(id);
			if(rModel != null)
				mav.addObject("rModel",rModel);
		}
		return mav;
		
	}
	
	/**
	 * 查询项目材料采购信息
	 * @return
	 */
	@RequestMapping(value="recruit_material.html")
	public ModelAndView recruit_material(){
		ModelAndView mav = new ModelAndView("/web/info/recruit_material");
		String pId = request.getParameter("pId");//
		String id = request.getParameter("id");//
		ProjectModel pModel = projectService.getById(pId);
		if(pModel != null){
			mav.addObject("pModel",pModel);
			//获得求职信息
			RequirementsModel rModel = requirementsService.getById(id);
			if(rModel != null)
				mav.addObject("rModel",rModel);
		}
		return mav;
		
	}
	
	/**
	 * 查询项目设备租赁信息
	 * @return
	 */
	@RequestMapping(value="recruit_equip.html")
	public ModelAndView recruit_equip(){
		ModelAndView mav = new ModelAndView("/web/info/recruit_equip");
		String pId = request.getParameter("pId");//
		String id = request.getParameter("id");//
		ProjectModel pModel = projectService.getById(pId);
		if(pModel != null){
			mav.addObject("pModel",pModel);
			//获得求职信息
			RequirementsModel rModel = requirementsService.getById(id);
			if(rModel != null)
				mav.addObject("rModel",rModel);
		}
		return mav;
		
	}
	
}