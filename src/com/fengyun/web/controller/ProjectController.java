package com.fengyun.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.cache.page.PageHandler;
import com.fengyun.web.db.playermodel.AptitudeModel;
import com.fengyun.web.db.playermodel.BehaviorModel;
import com.fengyun.web.db.playermodel.CompanyModel;
import com.fengyun.web.db.playermodel.EngineerModel;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.JoinBuildModel;
import com.fengyun.web.db.playermodel.KeyPersonModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.db.vo.SkillVo;
import com.fengyun.web.hardcode.EAdlevel;
import com.fengyun.web.hardcode.ETeamSkillSmallType;
import com.fengyun.web.service.AptitudeService;
import com.fengyun.web.service.BehaviorService;
import com.fengyun.web.service.CompanyService;
import com.fengyun.web.service.EngineerService;
import com.fengyun.web.service.EquipmentService;
import com.fengyun.web.service.JoinBuildService;
import com.fengyun.web.service.KeyPersonService;
import com.fengyun.web.service.MaterialService;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.TeamService;
import com.fengyun.web.service.UserService;
import com.fengyun.web.util.PublicMethod;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProjectDepartmentService projectdepartmentService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private JoinBuildService joinBuildService;
	
	@Autowired
	private KeyPersonService keyPersonService;
	
	@Autowired
	private AptitudeService aptitudeService;
	
	
	@Autowired
	private PersonService personService;
	
	
	@Autowired
	private BehaviorService behaviorService;
	
	
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private EngineerService engineerService;
	
	@Autowired
	private TeamService teamService;
	
	
	@Autowired
	private MaterialService materialService;
	
	
	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private  HttpServletRequest request;
	
	/**
	 * 项目列表
	 * @param pagesize 第几页
	 * @return
	 */
	@RequestMapping(value="project_list",method=RequestMethod.GET)
	public ModelAndView projectlist(int pageNow,long dataCount,int pageSize){
		ModelAndView mav = new ModelAndView("/project/project_list");
		if(dataCount == 0){
			dataCount = projectService.countAllProject(null);
		}
		//for(ProjectModel model:list){
			//System.out.println(model.getProvinceChn());
		//}
		mav.addObject("plist", projectService.getProjectList(null,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}
	
	@RequestMapping(value="project_list2",method=RequestMethod.POST)
	public ModelAndView projectlist2(){
		return toList();
	}
	
	/**
	 * 返回查询列表
	 * @return
	 */
	private ModelAndView toList(){
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String userId = request.getParameter("uId");
		String leaderName = request.getParameter("leaderName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		ModelAndView mav = new ModelAndView("/project/project_list");
//		String dataCountStr = request.getParameter("dataCount");
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(name)){
			queryObj.put("name", name);
		}
		if(StringUtils.isNotBlank(code)){
			queryObj.put("code", code);
		}
		if(StringUtils.isNotBlank(leaderName)){
//			Pattern pattern = Pattern.compile(".*" + leaderName  + ".*",Pattern.CASE_INSENSITIVE);
//			queryObj.put("leaderName", pattern);
			queryObj.put("leaderName", leaderName);
		}
		if(StringUtils.isNotBlank(userId)){
			queryObj.put("userId", userId);
		}
		if(StringUtils.isNotBlank(province)){
			queryObj.put("province", province);
		}
		if(StringUtils.isNotBlank(city)){
			queryObj.put("city", city);
		}
		if(queryObj.size() <= 0)
			queryObj = null;
		
//		if(dataCountStr == null || "".equals(dataCountStr)){
			dataCount = projectService.countAllProject(queryObj);
//		}else{
//			dataCount = Integer.valueOf(dataCountStr);
//		}
		String pageNowStr = request.getParameter("pageNow");
		System.out.println("pageNow:" + pageNowStr);
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 0;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		mav.addObject("plist", projectService.getProjectList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("name", name);
		mav.addObject("code", code);
		mav.addObject("uId", userId);
		mav.addObject("leaderName", leaderName);
		mav.addObject("province", province);
		mav.addObject("city", city);
		return mav;
	}
	
	/**
	 * 项目审核
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="project_pass",method=RequestMethod.GET)
	public ModelAndView projectPass(String id){
		projectService.projectPass(id);
		return toList();
	}
	
	@RequestMapping(value="project_add",method=RequestMethod.GET)
	public String projectAdd(String code){
		request.setAttribute("code", code);
		return "/project/project_add";
	}
	
	@RequestMapping(value="project_modify",method=RequestMethod.GET)
	public ModelAndView projectModify(String id){
		ModelAndView mav = new ModelAndView("/project/project_modify");
		ProjectModel model = projectService.getById(id);
		if(model != null)
			mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value="project_modify2",method=RequestMethod.POST)
	public ModelAndView projectModify2(){
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String pCode = request.getParameter("pCode");
		String leaderName = request.getParameter("leaderName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		int price;
		if(request.getParameter("price") == ""){
			price = 0;
		} else {
			price = Integer.parseInt(request.getParameter("price"));
		}
		int prepaid;
		if(request.getParameter("prepaid") == ""){
			prepaid = 0;
		} else {
			prepaid = Integer.parseInt(request.getParameter("prepaid"));
		}
		String progress = request.getParameter("progress");
		String status = request.getParameter("status");
		String lonlat = request.getParameter("lonlat");
		String lonlat2 = request.getParameter("lonlat2");
		if(StringUtils.isBlank(pCode)){
			ModelAndView mav = new ModelAndView("/project/project_modify");
			ProjectModel model = projectService.getById(id);
			if(model != null)
				mav.addObject("model", model);
			return mav;//返回修改页面
			
		}
		ProjectModel model1 = projectService.getByPCode(pCode);
		if(model1 != null && !model1.getId().equals(id)){
			ModelAndView mav = new ModelAndView("/project/project_modify");
			ProjectModel model = projectService.getById(id);
			if(model != null)
				mav.addObject("model", model);
			return mav;//返回修改页面
			
		} else {
			ProjectModel model = projectService.getById(id);
			if(model != null){
				model.setName(name);
				model.setCode(code);
				model.setpCode(pCode);
				model.setLeaderName(leaderName);
				model.setProvince(province);
				model.setCity(city);
				model.setStreet(street);
				model.setPrice(price);
				model.setPrepaid(prepaid);
				model.setStatus(Integer.valueOf(status));
				model.setLongitude(lonlat);
				model.setLatitude(lonlat2);
				if(StringUtils.isNotBlank(progress))
					model.setProgress(Integer.valueOf(progress));
				projectService.updateProject(model);
			}
		
			ModelAndView mav = new ModelAndView("/project/project_list");
			long dataCount = projectService.countAllProject(null);
			mav.addObject("plist", projectService.getProjectList(null,1,0));
			mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
			return mav;// 修改成功页面
		}
		
		
		
		
	}
	
	/**
	 * 管理员新增项目
	 * @return
	 */
	@RequestMapping(value="project_add2",method=RequestMethod.POST)
	public ModelAndView projectAdd2(){
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		if(!userId.equals("(^[1][358][0-9]{9}$)")){
			ModelAndView mav = new ModelAndView("/project/project_add");
			return mav;
		}
		ProjectModel pmodel = projectService.getByName(name);
		if(pmodel != null){
			ModelAndView mav = new ModelAndView("/project/project_add");
			return mav;
		}
		String code = request.getParameter("code");
		
		String pCode = request.getParameter("pCode");
		String leaderName = request.getParameter("leaderName");
		
		String identity = request.getParameter("identity");
		UserModel  usermodel = userService.getByUserId(userId);
		if(usermodel==null){
			usermodel = new UserModel();
			usermodel.setUserName(leaderName);
			usermodel.setUserId(userId);
			usermodel.setUserIdentity(identity);
			usermodel.setUserPassword("123456");
			userService.addUser(usermodel);
			personService.initialPerson(userId);
		}
		
		//判断身份证号是否为空
		
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		int price;
		if("".equals(request.getParameter("price"))){
			price = 0;
		} else {
			price = Integer.parseInt(request.getParameter("price"));
		}
		int prepaid;
		if("".equals(request.getParameter("prepaid"))){
			prepaid = 0;
		} else {
			prepaid = Integer.parseInt(request.getParameter("prepaid"));
		}
		String lonlat = request.getParameter("lonlat");
		String lonlat2 = request.getParameter("lonlat2");
		String allWork = request.getParameter("allWork");
		String accWork = request.getParameter("accWork");
		String provinceCode = request.getParameter("provinceCode");
		String type = request.getParameter("type");
		String projectTitanic = request.getParameter("projectTitanic");
		String projectlevel = request.getParameter("projectlevel");
		String projectorgan = request.getParameter("projectorgan");
		String replytime = request.getParameter("replytime");
		String investment = request.getParameter("investment");
		String totalarea = request.getParameter("totalarea");
		String scale = request.getParameter("scale");
		String nature = request.getParameter("nature");
		String purpose = request.getParameter("purpose");
		String worktime = request.getParameter("worktime");
		String thswork = request.getParameter("thswork");
		String unit = request.getParameter("unit");
		String buildUnit = request.getParameter("buildUnit");
		String companyType = null;
		int times;
		if("".equals(request.getParameter("times"))){
			times = 0;
		} else {
			times = Integer.parseInt(request.getParameter("times"));
		}
		boolean bln = projectService.addProject(identity,companyType,name, code,pCode, userId, leaderName, 
				province, city, street,price,prepaid,1,lonlat,lonlat2,allWork,accWork,provinceCode,
				type,projectTitanic,projectlevel,projectorgan,replytime,investment,totalarea,
				scale,nature,purpose,worktime,thswork,times,unit,buildUnit);
		if(bln){
			ModelAndView mav = new ModelAndView("/project/project_list");
			long dataCount = projectService.countAllProject(null);
			mav.addObject("plist", projectService.getProjectList(null,1,0));
			mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
			return mav;
		}else{
			ModelAndView mav = new ModelAndView("/project/project_add");
			return mav;
		}
		//
		
		
	}
	
	/**
	 * 删除项目
	 * @return
	 */
	@RequestMapping(value="project_del",method=RequestMethod.GET)
	public ModelAndView projectDel(String id){
		ProjectModel pmodel = projectService.getById(id);
		List<ProjectDepartmentModel> plist = projectdepartmentService.getTeamByPIdStatus(id, 1, 3);
		if(pmodel.getStatus() == 0 && plist.size()== 0){
			projectService.delProject(id);
		}
		ModelAndView mav = new ModelAndView("/project/project_list");
		long dataCount = projectService.countAllProject(null);
		mav.addObject("plist", projectService.getProjectList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	//////////////////////////////////////////////////////////////////////////////
	/**
	 * 公司项目列表（公司资质与资信，注册人员）
	 * @param code 公司代号
	 * @return
	 */
	@RequestMapping(value="company_projectlist",method=RequestMethod.GET)
	public ModelAndView companyProjectlist(String code){
		BasicDBObject queryObj = new BasicDBObject();
		List<AptitudeModel> alist =aptitudeService.getByCode(code);
		List<EngineerModel> elist =engineerService.getByCode(code);
		List<BehaviorModel> blist =behaviorService.getBycode(code);
		queryObj.put("code", code);
		ModelAndView mav = new ModelAndView("/company/company_projectlist");
		long dataCount = projectService.countAllProject(queryObj);
		mav.addObject("plist", projectService.getProjectList(queryObj,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		mav.addObject("code", code);
		CompanyModel model = companyService.getByCode(code);
		if(model != null){
			mav.addObject("companyName", model.getName());
		}
		mav.addObject("alist", alist);
		mav.addObject("elist", elist);
		mav.addObject("blist", blist);
		return mav;
	}
	
	@RequestMapping(value="company_projectlist2",method=RequestMethod.POST)
	public ModelAndView companyProjectlist2(){
		return toCompanyList();
	}
	
	
	
	
	/**
	 * 新增公司资质与资信
	 * @param code
	 * @param cName
	 * @return
	 */
	@RequestMapping(value="aptitude_add",method=RequestMethod.GET)
	public String aptitudeAdd(String code,String cName){
		request.setAttribute("code", code);
		request.setAttribute("cName", cName);
		return "/company/aptitude_add";
	}
	
	
	@RequestMapping(value="aptitude_add2",method=RequestMethod.POST)
	public ModelAndView aptitudeAdd2(String code, String cName){
		BasicDBObject queryObj = new BasicDBObject();
		String certificate =request.getParameter("certificate");
		int adtype = Integer.parseInt(request.getParameter("adtype"));
		int adlevel = Integer.parseInt(request.getParameter("level"));
		String approval =request.getParameter("approval");
		String approvalTime =request.getParameter("approvalTime");
		String validity =request.getParameter("validity");
		boolean bln  =aptitudeService.addAptitude(code, certificate, adtype, adlevel, approval, approvalTime, validity);
		List<AptitudeModel> alist =aptitudeService.getByCode(code);
		List<EngineerModel> elist =engineerService.getByCode(code);
		List<BehaviorModel> blist =behaviorService.getBycode(code);
		queryObj.put("code", code);
		ModelAndView mav = new ModelAndView("/company/company_projectlist");
		long dataCount = projectService.countAllProject(queryObj);
		mav.addObject("plist", projectService.getProjectList(queryObj,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		mav.addObject("code", code);
		CompanyModel model = companyService.getByCode(code);
		if(model != null)
			mav.addObject("companyName", model.getName());
		mav.addObject("alist", alist);
		mav.addObject("elist", elist);
		mav.addObject("blist", blist);
		return mav;
		
	}
	
	
	
	
	
	
	/**
	 * 新增注册人员
	 * @param code
	 * @param cName
	 * @return
	 */
	@RequestMapping(value="engineer_add",method=RequestMethod.GET)
	public String engineerAdd(String code,String cName){
		request.setAttribute("code", code);
		request.setAttribute("cName", cName);
		return "/company/engineer_add";
	}
	
	@RequestMapping(value="engineer_add2",method=RequestMethod.POST)
	public ModelAndView engineerAdd2(String code,String cName){
		BasicDBObject queryObj = new BasicDBObject();
		String name =request.getParameter("name");
		String type =request.getParameter("type");
		String registration =request.getParameter("registration");
		String userId =request.getParameter("userId");
		String certificateorgan =request.getParameter("certificateorgan");
		String issuancedate =request.getParameter("issuancedate");
		String effectivedate =request.getParameter("effectivedate");
		UserModel umodel =userService.getByUserId(userId);
		if(umodel == null){
			UserModel model=new UserModel();
			model.setUserId(userId);
			model.setUserPassword("123456");
			model.setUserName(name);
			userService.addUser(model);
		}
		boolean bln = engineerService.addEngineer(code, name, type, registration,userId,certificateorgan,issuancedate,effectivedate);
		List<AptitudeModel> alist =aptitudeService.getByCode(code);
		List<EngineerModel> elist =engineerService.getByCode(code);
		List<BehaviorModel> blist =behaviorService.getBycode(code);
		queryObj.put("code", code);
		ModelAndView mav = new ModelAndView("/company/company_projectlist");
		long dataCount = projectService.countAllProject(queryObj);
		mav.addObject("plist", projectService.getProjectList(queryObj,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		mav.addObject("code", code);
		CompanyModel model = companyService.getByCode(code);
		if(model != null)
			mav.addObject("companyName", model.getName());
		mav.addObject("alist", alist);
		mav.addObject("elist", elist);
		mav.addObject("blist", blist);
		return mav;
		
	}
	
	
	
	/**
	 * 删除注册人员
	 * @param id
	 * @return
	 */
	@RequestMapping(value="engineer_del",method=RequestMethod.GET)
	public ModelAndView engineerDel(String id){
		BasicDBObject queryObj = new BasicDBObject();
		EngineerModel model =engineerService.getById(id);
		String code  =model.getCode();
		engineerService.delEngineer(id);
		
		List<AptitudeModel> alist =aptitudeService.getByCode(code);
		List<EngineerModel> elist =engineerService.getByCode(code);
		List<BehaviorModel> blist =behaviorService.getBycode(code);
		queryObj.put("code", code);
		ModelAndView mav = new ModelAndView("/company/company_projectlist");
		long dataCount = projectService.countAllProject(queryObj);
		mav.addObject("plist", projectService.getProjectList(queryObj,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		mav.addObject("code", code);
		CompanyModel cmodel = companyService.getByCode(code);
		if(cmodel != null)
			mav.addObject("companyName", cmodel.getName());
		mav.addObject("alist", alist);
		mav.addObject("elist", elist);
		mav.addObject("blist", blist);
		
		return mav;
	}
	
	
	
	
	
	
	
	
	/**
	 * 删除公司资质与资信
	 * @param id
	 * @return
	 */
	@RequestMapping(value="aptitude_del",method=RequestMethod.GET)
	public ModelAndView aptitudeDel(String id){
		BasicDBObject queryObj = new BasicDBObject();
		AptitudeModel model =aptitudeService.getById(id);
		String code =model.getCode();
		aptitudeService.delAptitude(id);
		
		
		List<AptitudeModel> alist =aptitudeService.getByCode(code);
		List<EngineerModel> elist =engineerService.getByCode(code);
		List<BehaviorModel> blist =behaviorService.getBycode(code);
		queryObj.put("code", code);
		ModelAndView mav = new ModelAndView("/company/company_projectlist");
		long dataCount = projectService.countAllProject(queryObj);
		mav.addObject("plist", projectService.getProjectList(queryObj,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		mav.addObject("code", code);
		CompanyModel cmodel = companyService.getByCode(code);
		if(cmodel != null)
			mav.addObject("companyName", cmodel.getName());
		mav.addObject("alist", alist);
		mav.addObject("elist", elist);
		mav.addObject("blist", blist);
		return mav;
	}
	
	
	/**
	 * 修改公司资质和资信
	 * @param id
	 * @return
	 */
	@RequestMapping(value="aptitude_modify",method=RequestMethod.GET)
	public ModelAndView aptitudeModify(String id){
		ModelAndView mav = new ModelAndView("/company/aptitude_modify");
		AptitudeModel model = aptitudeService.getById(id);
		if(model != null)
			mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value="aptitude_modify2",method=RequestMethod.POST)
	public ModelAndView aptitudeModify2(String code ,String id){
		BasicDBObject queryObj = new BasicDBObject();
		String certificate =request.getParameter("certificate");
		int adtype = Integer.parseInt(request.getParameter("adtype"));
		
		int adlevel = Integer.parseInt(request.getParameter("level"));
		String approval =request.getParameter("approval");
		String approvalTime =request.getParameter("approvalTime");
		String validity =request.getParameter("validity");
		CompanyModel cmodel = companyService.getByCode(code);
		String companyName =cmodel.getName();
		queryObj.put("code", code);
		ModelAndView mav = new ModelAndView("/company/company_projectlist");
		long dataCount = projectService.countAllProject(queryObj);
		mav.addObject("plist", projectService.getProjectList(queryObj,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		mav.addObject("code", code);
		AptitudeModel model = aptitudeService.getById(id);
		if(model != null){
			model.setCode(code);
			model.setCertificate(certificate);
			model.setAdtype(adtype);
			model.setAdlevel(adlevel);
			model.setApproval(approval);
			model.setApprovalTime(approvalTime);
			model.setValidity(validity);
			aptitudeService.updateAptitude(model);
		}
		List<AptitudeModel> alist =aptitudeService.getByCode(code);
		List<EngineerModel> elist =engineerService.getByCode(code);
		List<BehaviorModel> blist =behaviorService.getBycode(code);
		mav.addObject("alist", alist);
		mav.addObject("elist", elist);
		mav.addObject("blist", blist);
		mav.addObject("companyName", companyName);
		return mav;
	}
	
	
	/**
	 * 修改注册工程师
	 * @param id
	 * @return
	 */
	@RequestMapping(value="engineer_modify",method=RequestMethod.GET)
	public ModelAndView engineerModify(String id){
		ModelAndView mav = new ModelAndView("/company/engineer_modify");
		EngineerModel model = engineerService.getById(id);
		if(model != null)
			mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value="engineer_modify2",method=RequestMethod.POST)
	public ModelAndView engineerModify2(String code,String id){
		BasicDBObject queryObj = new BasicDBObject();
		String name =request.getParameter("name");
		String type =request.getParameter("type");
		String registration =request.getParameter("registration");
		String userId =request.getParameter("userId");
		String certificateorgan =request.getParameter("certificateorgan");
		String issuancedate =request.getParameter("issuancedate");
		String effectivedate =request.getParameter("effectivedate");
		EngineerModel model = engineerService.getById(id);
		if(model != null){
			model.setCode(code);
			model.setUserId(userId);
			model.setName(name);
			model.setType(type);
			model.setRegistration(registration);
			model.setCertificateorgan(certificateorgan);
			model.setIssuancedate(issuancedate);
			model.setEffectivedate(effectivedate);
			engineerService.updateEngineer(model);
		}
		CompanyModel cmodel = companyService.getByCode(code);
		queryObj.put("code", code);
		ModelAndView mav = new ModelAndView("/company/company_projectlist");
		long dataCount = projectService.countAllProject(queryObj);
		mav.addObject("plist", projectService.getProjectList(queryObj,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		mav.addObject("code", code);
		String companyName =cmodel.getName();
		List<AptitudeModel> alist =aptitudeService.getByCode(code);
		List<EngineerModel> elist =engineerService.getByCode(code);
		List<BehaviorModel> blist =behaviorService.getBycode(code);
		mav.addObject("alist", alist);
		mav.addObject("elist", elist);
		mav.addObject("blist", blist);
		mav.addObject("companyName", companyName);
		return mav;
	}
	
	/**
	 * 公司资质与资信中枚举类型的关联
	 * @param adtype
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "aptitude_getadlevel", method = RequestMethod.POST)
	public void getAdlevel(String adtype,
			HttpServletResponse response) throws IOException {
		int adnum = 1;
		if(StringUtils.isNotBlank(adtype))
			adnum = Integer.valueOf(adtype);
		response.setContentType("text/html;charset=UTF-8");
		response.setContentType("UTF-8");
		System.out.println("++++++++++++++--------"+adnum);
		List<EAdlevel> sksmList = EAdlevel.getEAdlevelId(adnum);
		List<SkillVo> skillList = new ArrayList<SkillVo>();
		if (sksmList != null)
			for (EAdlevel e : sksmList) {

				SkillVo skillModel = new SkillVo();
				skillModel.setSkillType(e.id);
				skillModel.setSkillName(e.desc);
				skillList.add(skillModel);
			}
		System.out.println("++++++++++++++--------"+skillList);
		Gson gson = new Gson();
		String jsonarray = gson.toJson(skillList);
		String json = jsonarray.toString();
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
	//////////////////////////////////////////////////////////////////////////////公司行为
	
	/**
	 * 新增公司行为
	 * @param code
	 * @param cName
	 * @return
	 */
	@RequestMapping(value="behavior_add",method=RequestMethod.GET)
	public String behaviorAdd(String code,String cName){
		request.setAttribute("code", code);
		request.setAttribute("cName", cName);
		return "/company/behavior_add";
	}
	
	
	@RequestMapping(value="behavior_add2",method=RequestMethod.POST)
	public ModelAndView behaviorAdd2(String code, String cName){
		BasicDBObject queryObj = new BasicDBObject();
		String title =request.getParameter("title");
		int type = Integer.parseInt(request.getParameter("type"));
		String behaviorTime =request.getParameter("behaviorTime");
		String content =request.getParameter("content");
		boolean bln  =behaviorService.addBehavior(code,title,type,behaviorTime,content);
		List<AptitudeModel> alist =aptitudeService.getByCode(code);
		List<EngineerModel> elist =engineerService.getByCode(code);
		List<BehaviorModel> blist =behaviorService.getBycode(code);
		queryObj.put("code", code);
		ModelAndView mav = new ModelAndView("/company/company_projectlist");
		long dataCount = projectService.countAllProject(queryObj);
		mav.addObject("plist", projectService.getProjectList(queryObj,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		mav.addObject("code", code);
		CompanyModel model = companyService.getByCode(code);
		if(model != null)
			mav.addObject("companyName", model.getName());
		mav.addObject("alist", alist);
		mav.addObject("elist", elist);
		mav.addObject("blist", blist);
		return mav;
		
	}
	
	
	
	/**
	 * 修改公司行为
	 * @param id
	 * @return
	 */
	@RequestMapping(value="behavior_modify",method=RequestMethod.GET)
	public ModelAndView behaviorModify(String id){
		ModelAndView mav = new ModelAndView("/company/behavior_modify");
		BehaviorModel model = behaviorService.getById(id);
		if(model != null)
			mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value="behavior_modify2",method=RequestMethod.POST)
	public ModelAndView behaviorModify2(String code ,String id){
		BasicDBObject queryObj = new BasicDBObject();
		String title =request.getParameter("title");
		int type = Integer.parseInt(request.getParameter("type"));
		String behaviorTime =request.getParameter("behaviorTime");
		String content =request.getParameter("content");
		CompanyModel cmodel = companyService.getByCode(code);
		String companyName =cmodel.getName();
		queryObj.put("code", code);
		ModelAndView mav = new ModelAndView("/company/company_projectlist");
		long dataCount = projectService.countAllProject(queryObj);
		mav.addObject("plist", projectService.getProjectList(queryObj,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		mav.addObject("code", code);
		BehaviorModel model = behaviorService.getById(id);
		if(model != null){
			model.setCode(code);
			model.setTitle(title);
			model.setType(type);
			model.setContent(content);
			model.setBehaviorTime(behaviorTime);
			behaviorService.updateBehavior(model);
		}
		List<AptitudeModel> alist =aptitudeService.getByCode(code);
		List<EngineerModel> elist =engineerService.getByCode(code);
		List<BehaviorModel> blist =behaviorService.getBycode(code);
		mav.addObject("alist", alist);
		mav.addObject("elist", elist);
		mav.addObject("blist", blist);
		mav.addObject("companyName", companyName);
		return mav;
	}
	
	
	
	
	
	/**
	 * 删除公司的行为
	 * @param id
	 * @return
	 */
	@RequestMapping(value="behavior_del",method=RequestMethod.GET)
	public ModelAndView behaviorDel(String id){
		BasicDBObject queryObj = new BasicDBObject();
		BehaviorModel model =behaviorService.getById(id);
		String code =model.getCode();
		behaviorService.delBehavior(id);
		List<AptitudeModel> alist =aptitudeService.getByCode(code);
		List<EngineerModel> elist =engineerService.getByCode(code);
		List<BehaviorModel> blist =behaviorService.getBycode(code);
		queryObj.put("code", code);
		ModelAndView mav = new ModelAndView("/company/company_projectlist");
		long dataCount = projectService.countAllProject(queryObj);
		mav.addObject("plist", projectService.getProjectList(queryObj,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		mav.addObject("code", code);
		CompanyModel cmodel = companyService.getByCode(code);
		if(cmodel != null)
			mav.addObject("companyName", cmodel.getName());
		mav.addObject("alist", alist);
		mav.addObject("elist", elist);
		mav.addObject("blist", blist);
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 返回查询列表
	 * @return
	 */
	private ModelAndView toCompanyList(){
		
		ModelAndView mav = new ModelAndView("/company/company_projectlist");
		String code = request.getParameter("code");
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("code", code);
		long dataCount = projectService.countAllProject(queryObj);
		
		String pageNowStr = request.getParameter("pageNow");
		System.out.println("pageNow:" + pageNowStr);
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 0;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		mav.addObject("plist", projectService.getProjectList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		mav.addObject("code", code);
		return mav;
	}
	/////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 根据项目ID获取项目班组，材料，设备商信息
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="project_info",method=RequestMethod.GET)
	public ModelAndView projectInfo(String id){
		String code = request.getParameter("code");//公司代码
		ModelAndView mav = new ModelAndView("/project/project_info");
		
		ProjectModel model = projectService.getById(id);
		String pCode = null;
		if(model != null){
			pCode = model.getpCode();
		}
		List<JoinBuildModel> jlist = joinBuildService.getBypCode(pCode);
		mav.addObject("jlist", jlist);
		List<KeyPersonModel> klist = keyPersonService.getBypCode(pCode);
		mav.addObject("klist", klist);
		if(model != null)
			mav.addObject("model", model);
		Object[] objs = projectService.getProjectDepartmentByPId(id);
		//班组信息
		if(objs[0] != null)
			mav.addObject("teams", (List<TeamModel>)objs[0]);
		//材料商信息
		if(objs[1] != null)
			mav.addObject("materials", (List<MaterialModel>)objs[1]);
		//设备商信息
		if(objs[2] != null)
			mav.addObject("equips", (List<EquipmentModel>)objs[2]);
//		projectService.inviteProjectDepartment(id, "58082c8be4b003c5492d8715", 1, 1);
//		projectService.inviteProjectDepartment(id, "580f327fe4b06307f5671037", 1, 1);
//		
//		projectService.inviteProjectDepartment(id, "5808328fe4b003c5492d8717", 2, 1);
//		projectService.inviteProjectDepartment(id, "580f2ce2e4b06307f567102f", 2, 1);
//		
//		projectService.inviteProjectDepartment(id, "58098999e4b0b99e3a72c907", 3, 1);
//		projectService.inviteProjectDepartment(id, "580836f6e4b003c5492d8718", 3, 1);
		
		String pId=id;
		mav.addObject("pCode", pCode);
		mav.addObject("pId", pId);
		return mav;
	}
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 新增参建单位
	 * @param pCode
	 * @return
	 */
	@RequestMapping(value="joinbuild_add",method=RequestMethod.GET)
	public String joinBuildAdd(String pCode){
		request.setAttribute("pCode", pCode);
		return "/project/joinbuild_add";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="joinbuild_add2",method=RequestMethod.POST)
	public ModelAndView joinBuildAdd2(String pCode){
		String jName =request.getParameter("jName");
		String jType =request.getParameter("jType");
		String leaderphone =request.getParameter("leaderphone");
		String jNum =request.getParameter("jNum");
		CompanyModel cmodel =companyService.getByUserId(leaderphone);
		if(cmodel == null){
			CompanyModel model=new CompanyModel();
			model.setUserId(leaderphone);
			model.setName(jName);
			model.setOrganization(jNum);
			companyService.addCompany(model);
			
		}
		boolean bln = joinBuildService.addJoinBuild(pCode,jType,jName,jNum,leaderphone);
		List<JoinBuildModel> jlist = joinBuildService.getBypCode(pCode);
		ModelAndView mav = new ModelAndView("/project/project_info");
		ProjectModel model = projectService.getByPCode(pCode);
		if(model != null)
			mav.addObject("model", model);
		Object[] objs = projectService.getProjectDepartmentByPId(model.getId());
		//班组信息
		if(objs[0] != null)
			mav.addObject("teams", (List<TeamModel>)objs[0]);
		//材料商信息
		if(objs[1] != null)
			mav.addObject("materials", (List<MaterialModel>)objs[1]);
		//设备商信息
		if(objs[2] != null)
			mav.addObject("equips", (List<EquipmentModel>)objs[2]);
		String pId=model.getId();
		mav.addObject("pCode", pCode);
		mav.addObject("pId", pId);
		mav.addObject("jlist", jlist);
		return mav;
		
	}
	
	/**
	 * 修改参建单位
	 * @param id
	 * @return
	 */
	@RequestMapping(value="joinbuild_modify",method=RequestMethod.GET)
	public ModelAndView joinBuildModify(String id){
		ModelAndView mav = new ModelAndView("/project/joinbuild_modify");
		JoinBuildModel model = joinBuildService.getById(id);
		if(model != null)
			mav.addObject("model", model);
		return mav;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="joinbuild_modify2",method=RequestMethod.POST)
	public ModelAndView joinBuildModify2(String id){
		String jName =request.getParameter("jName");
		String jType =request.getParameter("jType");
		String leaderphone =request.getParameter("leaderphone");
		String jNum =request.getParameter("jNum");
		JoinBuildModel jmodel = joinBuildService.getById(id);
		
		String pCode;
		if(jmodel != null){
			pCode =jmodel.getpCode();
			jmodel.setpCode(pCode);
			jmodel.setjName(jName);
			jmodel.setjType(jType);
			jmodel.setLeaderphone(leaderphone);
			jmodel.setjNum(jNum);
			joinBuildService.updateJoinBuild(jmodel);
		}
		List<JoinBuildModel> jlist = joinBuildService.getBypCode(jmodel.getpCode());
		ModelAndView mav = new ModelAndView("/project/project_info");
		ProjectModel model = projectService.getByPCode(jmodel.getpCode());
		if(model != null)
			mav.addObject("model", model);
		Object[] objs = projectService.getProjectDepartmentByPId(model.getId());
		//班组信息
		if(objs[0] != null)
			mav.addObject("teams", (List<TeamModel>)objs[0]);
		//材料商信息
		if(objs[1] != null)
			mav.addObject("materials", (List<MaterialModel>)objs[1]);
		//设备商信息
		if(objs[2] != null)
			mav.addObject("equips", (List<EquipmentModel>)objs[2]);
		String pId=model.getId();
		mav.addObject("pCode", jmodel.getpCode());
		mav.addObject("pId", pId);
		mav.addObject("jlist", jlist);
		return mav;
	}
	
	
	/*
	 * 删除参建单位
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="joinbuild_del",method=RequestMethod.GET)
	public ModelAndView joinBuildDel(String id){
		JoinBuildModel jmodel =joinBuildService.getById(id);
		String pCode =jmodel.getpCode();
		joinBuildService.delJoinBuild(id);
		
		
		List<JoinBuildModel> jlist = joinBuildService.getBypCode(pCode);
		ModelAndView mav = new ModelAndView("/project/project_info");
		ProjectModel model = projectService.getByPCode(pCode);
		if(model != null)
			mav.addObject("model", model);
		Object[] objs = projectService.getProjectDepartmentByPId(model.getId());
		//班组信息
		if(objs[0] != null)
			mav.addObject("teams", (List<TeamModel>)objs[0]);
		//材料商信息
		if(objs[1] != null)
			mav.addObject("materials", (List<MaterialModel>)objs[1]);
		//设备商信息
		if(objs[2] != null)
			mav.addObject("equips", (List<EquipmentModel>)objs[2]);
		String pId=model.getId();
		mav.addObject("pCode", pCode);
		mav.addObject("pId", pId);
		mav.addObject("jlist", jlist);
		return mav;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	/*
	 * 新增关键岗位人员
	 */
	@RequestMapping(value="keyperson_add",method=RequestMethod.GET)
	public String keyPersonAdd(String pCode){
		request.setAttribute("pCode", pCode);
		return "/project/keyperson_add";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="keyperson_add2",method=RequestMethod.POST)
	public ModelAndView keyPersonAdd2(String pCode){
		String name =request.getParameter("name");
		String cName =request.getParameter("cName");
		String phone =request.getParameter("phone");
		String role =request.getParameter("role");
		UserModel umodel =userService.getByUserId(phone);
		if(umodel == null){
			UserModel model = new UserModel();
			model.setUserName(name);
			model.setUserId(phone);
			model.setUserType("0");
			userService.addUser(model);
			
		}
		boolean bln = keyPersonService.addKeyPerson(pCode, name, cName, phone, role);
		List<KeyPersonModel> klist = keyPersonService.getBypCode(pCode);
		List<JoinBuildModel> jlist = joinBuildService.getBypCode(pCode);
		ModelAndView mav = new ModelAndView("/project/project_info");
		ProjectModel model = projectService.getByPCode(pCode);
		if(model != null)
			mav.addObject("model", model);
		Object[] objs = projectService.getProjectDepartmentByPId(model.getId());
		//班组信息
		if(objs[0] != null)
			mav.addObject("teams", (List<TeamModel>)objs[0]);
		//材料商信息
		if(objs[1] != null)
			mav.addObject("materials", (List<MaterialModel>)objs[1]);
		//设备商信息
		if(objs[2] != null)
			mav.addObject("equips", (List<EquipmentModel>)objs[2]);
		String pId=model.getId();
		mav.addObject("pCode", pCode);
		mav.addObject("pId", pId);
		mav.addObject("jlist", jlist);
		mav.addObject("klist", klist);
		return mav;
		
	}
	
	
	
	
	
	
	/**
	 * 修改关键岗位人员
	 * @param id
	 * @return
	 */
	@RequestMapping(value="keyperson_modify",method=RequestMethod.GET)
	public ModelAndView keyPersonModify(String id){
		ModelAndView mav = new ModelAndView("/project/keyperson_modify");
		KeyPersonModel model = keyPersonService.getById(id);
		if(model != null)
			mav.addObject("model", model);
		return mav;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="keyperson_modify2",method=RequestMethod.POST)
	public ModelAndView keyPersonModify2(String id){
		String name =request.getParameter("name");
		String cName =request.getParameter("cName");
		String phone =request.getParameter("phone");
		String role =request.getParameter("role");
		KeyPersonModel kmodel = keyPersonService.getById(id);
		String pCode = null;
		if(kmodel != null){
			pCode =kmodel.getpCode();
		} 
		if(kmodel != null){
			kmodel.setpCode(pCode);
			kmodel.setName(name);
			kmodel.setcName(cName);
			kmodel.setPhone(phone);
			kmodel.setRole(role);
			keyPersonService.updateKeyPerson(kmodel);
		}
		List<KeyPersonModel> klist = keyPersonService.getBypCode(pCode);
		List<JoinBuildModel> jlist = joinBuildService.getBypCode(pCode);
		ModelAndView mav = new ModelAndView("/project/project_info");
		ProjectModel model = projectService.getByPCode(pCode);
		if(model != null)
			mav.addObject("model", model);
		Object[] objs = projectService.getProjectDepartmentByPId(model.getId());
		//班组信息
		if(objs[0] != null)
			mav.addObject("teams", (List<TeamModel>)objs[0]);
		//材料商信息
		if(objs[1] != null)
			mav.addObject("materials", (List<MaterialModel>)objs[1]);
		//设备商信息
		if(objs[2] != null)
			mav.addObject("equips", (List<EquipmentModel>)objs[2]);
		String pId=model.getId();
		mav.addObject("pCode", pCode);
		mav.addObject("pId", pId);
		mav.addObject("jlist", jlist);
		mav.addObject("klist", klist);
		return mav;
	}
	
	
	
	/**
	 * 删除关键岗位人员
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="keyperson_del",method=RequestMethod.GET)
	public ModelAndView keyPersonDel(String id){
		KeyPersonModel kmodel = keyPersonService.getById(id);
		String pCode =kmodel.getpCode();
		keyPersonService.delKeyPerson(id);
		
		List<KeyPersonModel> klist = keyPersonService.getBypCode(pCode);
		List<JoinBuildModel> jlist = joinBuildService.getBypCode(pCode);
		ModelAndView mav = new ModelAndView("/project/project_info");
		ProjectModel model = projectService.getByPCode(pCode);
		if(model != null)
			mav.addObject("model", model);
		Object[] objs = projectService.getProjectDepartmentByPId(model.getId());
		//班组信息
		if(objs[0] != null)
			mav.addObject("teams", (List<TeamModel>)objs[0]);
		//材料商信息
		if(objs[1] != null)
			mav.addObject("materials", (List<MaterialModel>)objs[1]);
		//设备商信息
		if(objs[2] != null)
			mav.addObject("equips", (List<EquipmentModel>)objs[2]);
		String pId=model.getId();
		mav.addObject("pCode", pCode);
		mav.addObject("pId", pId);
		mav.addObject("jlist", jlist);
		mav.addObject("klist", klist);
		return mav;
	}
	//////////////////////////////////////////////////////////////////////////////
	/*
	 * 项目环节
	 */
	@RequestMapping(value="link_modify",method=RequestMethod.GET)
	public ModelAndView LinkModify(String id){
		ModelAndView mav = new ModelAndView("/project/link_modify");
		ProjectModel model = projectService.getById(id);
		if(model != null)
			mav.addObject("model", model);
		return mav;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="link_modify2",method=RequestMethod.POST)
	public ModelAndView LinkModify2(String id){
		String num1 =request.getParameter("num1");
		String num2 =request.getParameter("num2");
		String num3 =request.getParameter("num3");
		String num4 =request.getParameter("num4");
		String num5 =request.getParameter("num5");
		String num6 =request.getParameter("num6");
		String num7 =request.getParameter("num7");
		String num8 =request.getParameter("num8");
		String num9 =request.getParameter("num9");
		String num10 =request.getParameter("num10");
		String num11 =request.getParameter("num11");
		
		
		ProjectModel model = projectService.getById(id);
		String pCode = null;
		if(model != null){
			pCode =model.getpCode();
		}
		 
		List<KeyPersonModel> klist = keyPersonService.getBypCode(pCode);
		List<JoinBuildModel> jlist = joinBuildService.getBypCode(pCode);
		ModelAndView mav = new ModelAndView("/project/project_info");
		if(model != null){
			model.setpro("1",num1);
			model.setpro("2",num2);
			model.setpro("3",num3);
			model.setpro("4",num4);
			model.setpro("5",num5);
			model.setpro("6",num6);
			model.setpro("7",num7);
			model.setpro("8",num8);
			model.setpro("9",num9);
			model.setpro("10",num10);
			model.setpro("11",num11);
			projectService.updateProject(model);
		}
		mav.addObject("model", model);
		Object[] objs = projectService.getProjectDepartmentByPId(model.getId());
		//班组信息
		if(objs[0] != null)
			mav.addObject("teams", (List<TeamModel>)objs[0]);
		//材料商信息
		if(objs[1] != null)
			mav.addObject("materials", (List<MaterialModel>)objs[1]);
		//设备商信息
		if(objs[2] != null)
			mav.addObject("equips", (List<EquipmentModel>)objs[2]);
		String pId=model.getId();
		mav.addObject("pCode", pCode);
		mav.addObject("pId", pId);
		mav.addObject("jlist", jlist);
		mav.addObject("klist", klist);
		return mav;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 项目查询班组
	 */
	@RequestMapping(value="query_team",method=RequestMethod.POST)
	public ModelAndView queryTeam(String id){
		//从页面获取班组长的电话
		String leaderMobile = request.getParameter("leaderMobile");
		//通过班组长电话查出整个班组信息
		TeamModel teammodel = teamService.getTeamByLeaderMobile(leaderMobile);
		boolean canInvite = true;//是否可邀请 
		//判断该班组是否存在
		if(teammodel != null){
			ProjectDepartmentModel pdmodel = projectdepartmentService.getProjectDepartment(id, teammodel.getId(), 1);
			System.out.print("联系ID："+pdmodel.getId());
			if(pdmodel != null && pdmodel.getStatus() == 3){
				canInvite = false;
			}
		}
		ModelAndView mav = projectInfo(id);
		mav.addObject("canInvite", canInvite);
		mav.addObject("teammodel", teammodel);
		return mav;
	}
	
	
	/**
	 * 项目查询材料商
	 */
	@RequestMapping(value="query_material",method=RequestMethod.POST)
	public ModelAndView queryMaterial(String id){
		//从页面获取材料商负责人的电话
		String materialuserId = request.getParameter("materialuserId");
		//通过材料商负责人电话查出整个材料商信息
		MaterialModel materialmodel = materialService.getByUserId(materialuserId);
		boolean materialcanInvite = true;//是否可邀请 
		//判断该材料商是否存在
		if(materialmodel != null){
			ProjectDepartmentModel pdmodel = projectdepartmentService.getProjectDepartment(id, materialmodel.getId(), 2);
			if(pdmodel != null && pdmodel.getStatus() == 3){
				materialcanInvite = false;
			}
		}
		ModelAndView mav = projectInfo(id);
		mav.addObject("materialcanInvite", materialcanInvite);
		mav.addObject("materialmodel", materialmodel);
		return mav;
	}
	
	/**
	 * 项目查询设备商
	 */
	@RequestMapping(value="query_equipment",method=RequestMethod.POST)
	public ModelAndView queryEquipment(String id){
		//从页面获取设备商负责人的电话
		String equipmentuserId = request.getParameter("equipmentuserId");
		//通过设备商负责人电话查出整个设备商信息
		EquipmentModel equipmentmodel = equipmentService.getByUserId(equipmentuserId);
		boolean equipmentcanInvite = true;//是否可邀请 
		//判断该设备商是否存在
		if(equipmentmodel != null){
			ProjectDepartmentModel pdmodel = projectdepartmentService.getProjectDepartment(id, equipmentmodel.getId(), 3);
			System.out.print("联系ID："+pdmodel.getId());
			if(pdmodel != null && pdmodel.getStatus() == 3){
				equipmentcanInvite = false;
			}
		}
		ModelAndView mav = projectInfo(id);
		mav.addObject("equipmentcanInvite", equipmentcanInvite);
		mav.addObject("equipmentmodel", equipmentmodel);
		return mav;
	}
	
	/**
	 * 项目邀请班组
	 */
	@RequestMapping(value = "team_invite", method = RequestMethod.GET)
	public ModelAndView teamInvite(String id,String teamId) {
		//创建一个新的项目下班组信息
		ProjectDepartmentModel pdmodel = new ProjectDepartmentModel();
		
		pdmodel.setVId(teamId);   //存入班组id
		pdmodel.setPId(id);		  //存入项目id
		pdmodel.setStatus(3);     //存入状态为已经加入
		pdmodel.setType(1);       //类型为班组
		projectdepartmentService.addProjectDepartment(pdmodel);
		//通过teamId查询班组
		TeamModel tmodel = teamService.getTeamById(teamId);
		tmodel.setStatus(1);//状态置为工作状态
		teamService.updateTeam(tmodel);
		ModelAndView mav = projectInfo(id);
		return mav;
		
	}
	
	/**
	 * 项目邀请材料商
	 */
	@RequestMapping(value = "material_invite", method = RequestMethod.GET)
	public ModelAndView materialInvite(String id,String materialId) {
		//创建一个新的项目下材料商信息
		ProjectDepartmentModel pdmodel = new ProjectDepartmentModel();
		pdmodel.setVId(materialId);   //材料商id
		pdmodel.setPId(id);			  //项目id
		pdmodel.setStatus(3);         //已经在项目下
		pdmodel.setType(2);           //类型为材料商
		projectdepartmentService.addProjectDepartment(pdmodel);
		ModelAndView mav = projectInfo(id);
		return mav;
	}
	
	/**
	 * 项目邀请设备商
	 */
	@RequestMapping(value = "equipment_invite", method = RequestMethod.GET)
	public ModelAndView equipmentInvite(String id,String equipmentId) {
		//创建一个新的项目下设备商信息
		ProjectDepartmentModel pdmodel = new ProjectDepartmentModel();
		pdmodel.setVId(equipmentId);     //设备商id
		pdmodel.setPId(id);              //项目id8
		pdmodel.setStatus(3);            //已经在项目下
		pdmodel.setType(3);              //类型为设备商
		projectdepartmentService.addProjectDepartment(pdmodel);
		ModelAndView mav = projectInfo(id);
		return mav;
	}
	
	//////////////////////////////////////////////
	/**
	 * 后台项目新增校验
	 */
	///////////////////////////////////////////////////////
	/**
	 * 校验项目名称是否已经存在
	 * 
	 */
	@RequestMapping(value="verifyProjectName.html")
	public void verifyProjectName(HttpServletResponse response, String Name){
		String pName;
		int flag = 0;
		try {
			//页面传来的值转换成utf-8
			pName = new String(Name.getBytes("ISO8859-1"),"utf-8");
			//通过项目名称查询项目
			ProjectModel project = projectService.getByName(pName);
			//项目存在，则名称不可用
			if(project!=null){
				flag = 1;
			//项目不存在，则名称可用
			} else {
				flag = 2;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PublicMethod.objectToJson(flag, response);
		
	}
	
	
	
	
	/**
	 * 校验项目代码是否已经存在
	 * 
	 */
	@RequestMapping(value="verifyProjectpCode.html")
	public void verifyProjectpCode(HttpServletResponse response, String pCode){
		int flag = 0;
		//判断该项目编号是否存在
		ProjectModel project = projectService.getByPCode(pCode);
		//存在
		if(project!=null){
			flag = 1;
		//不存在
		} else {
			flag = 2;
		}
		
		PublicMethod.objectToJson(flag, response);
		
	}
	
	
	
	/**
	 * 校验项目负责人电话是否已经注册过
	 * 
	 */
	@RequestMapping(value="verifyProjectUserId.html")
	public void verifyProjectUserId(HttpServletResponse response, String UserId){
		int flag = 0;
		//判断该项目编号是否存在
		ProjectModel project = projectService.getByUserId(UserId);
		//存在
		if(project!=null){
			flag = 1;
		//不存在
		} else {
			flag = 2;
		}
		
		PublicMethod.objectToJson(flag, response);
		
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////
	/**
	 * 修改校验
	 */
	///////////////////////////////////////////////////////////////////////////
	/**
	 * 修改项目名称校验
	 */
	@RequestMapping(value="modifyProjectName.html")
	public void modifyProjectName(HttpServletResponse response,String Name){
		int flag = 0;
		//如果修改了，判断新项目名称是否可用
		ProjectModel project = projectService.getByName(Name);
		//不可用
		if(project!=null){
			flag = 1;
		//可用
		} else {
			flag = 2; 
		}
		PublicMethod.objectToJson(flag, response);
		
		
	}
	
	
	/**
	 * 修改项目代码校验
	 */
	@RequestMapping(value="modifyProjectpCode.html")
	public void modifyProjectpCode(HttpServletResponse response,String pCode){
		int flag = 0;
		//如果修改了，判断新项目编号是否可用
		ProjectModel project = projectService.getByPCode(pCode);
		//不可用
		if(project!=null){
			flag = 1;
		//可用
		} else {
			flag = 2;
		}
		PublicMethod.objectToJson(flag, response);
	}
	
	
	/**
	 * 修改项目负责人电话校验
	 */
	@RequestMapping(value="modifyProjectUserId.html" )
	public void modifyProjectUserId(HttpServletResponse response,String UserId){
		int flag = 0;
		//如果修改了，判断新项目负责人电话是否可用
		ProjectModel project = projectService.getByUserId(UserId);
		//不可用
		if(project!=null){
			flag = 1;
		//可用
		} else {
			flag = 2;
		}
		PublicMethod.objectToJson(flag, response);
	}
	
	
	
	
}
