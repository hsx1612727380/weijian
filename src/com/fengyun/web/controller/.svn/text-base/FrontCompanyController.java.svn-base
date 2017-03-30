package com.fengyun.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.cache.page.PageHandler;
import com.fengyun.web.db.playermodel.AptitudeModel;
import com.fengyun.web.db.playermodel.CompanyCompactModel;
import com.fengyun.web.db.playermodel.CompanyModel;
import com.fengyun.web.db.playermodel.EngineerModel;
import com.fengyun.web.db.playermodel.NoticeLogModel;
import com.fengyun.web.db.playermodel.NoticeModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.vo.AdlevelVo;
import com.fengyun.web.db.vo.TeamSkillSmallTypeVo;
import com.fengyun.web.hardcode.EAdlevel;
import com.fengyun.web.hardcode.ESessionKey;
import com.fengyun.web.hardcode.ETeamSkillSmallType;
import com.fengyun.web.hardcode.IMageUploadInfo;
import com.fengyun.web.hardcode.UserType;
import com.fengyun.web.service.AptitudeService;
import com.fengyun.web.service.CompanyCompactService;
import com.fengyun.web.service.CompanyService;
import com.fengyun.web.service.EngineerService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.UserService;
import com.fengyun.web.service.NoticeService;
import com.fengyun.web.service.NoticeLogService;
import com.fengyun.web.service.MessageService;
import com.fengyun.web.util.ImageUpload;
import com.fengyun.web.util.PublicMethod;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;

/**
 * 前台公司个人中心 controller
 * 
 * @author hsx
 * 
 */
@Controller
public class FrontCompanyController {

	@Autowired
	private ServletConfig config;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private AptitudeService aptitudeService;

	@Autowired
	private EngineerService engineerService;

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private CompanyCompactService companyCompactService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private NoticeLogService noticeLogService;
	
	@Autowired
	private MessageService messageService;

	@Autowired
	private HttpServletRequest request;

	/**
	 * 基础资料显示
	 * 
	 * @return
	 */
	@RequestMapping(value = "company_info.html", method = RequestMethod.GET)
	public ModelAndView compamyInfo() {
		ModelAndView mav = new ModelAndView("front_company/company_info");
		String userId = (String) request.getSession().getAttribute(
				ESessionKey.UserId.key);
		if (userId != null) {
			CompanyModel companyModel = companyService.getByUserId(userId);
			if (companyModel != null) {
				mav.addObject("companyModel", companyModel);
			}
		}
		return mav;
	}

	/**
	 * 公司基本资料修改页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "company_infoUpdate.html", method = RequestMethod.GET)
	public ModelAndView companyInfoUpdate() {
		ModelAndView mav = new ModelAndView("front_company/company_infoUpdate");
		String userId = (String) request.getSession().getAttribute(
				ESessionKey.UserId.key);
		if (userId != null) {
			CompanyModel companyModel = companyService.getByUserId(userId);
			if (companyModel != null) {
				mav.addObject("companyModel", companyModel);
			}
		}
		return mav;
	}

	/**
	 * 公司基本资料修改功能
	 * 
	 * @return
	 */
	@RequestMapping(value = "company_infoUpdate2.html", method = RequestMethod.POST)
	public String companyInfoUpdate2() {
		String id = request.getParameter("companyId").trim();
		String type = request.getParameter("type").trim();
		String name = request.getParameter("name").trim();
		String province = request.getParameter("province").trim();
		String city = request.getParameter("city").trim();
		String organization = request.getParameter("organization").trim();
		String regMoney = request.getParameter("regMoney").trim();
		String regType = request.getParameter("regType").trim();
		String leaderName = request.getParameter("leaderName").trim();
		String tel = request.getParameter("tel").trim();
		CompanyModel companyModel = companyService.getById(id);
		if (companyModel != null) {
			companyModel.setType(type);
			companyModel.setName(name);
			companyModel.setProvince(province);
			companyModel.setCity(city);
			companyModel.setOrganization(organization);
			companyModel.setRegMoney(regMoney);
			companyModel.setRegType(regType);
			companyModel.setLeaderName(leaderName);
			companyModel.setTel(tel);
			companyService.updateCompany(companyModel);
		}
		return "redirect:/company_info.html";
	}

	/**
	 * 企业修改密码页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "company_infoPwdUpdate.html", method = RequestMethod.GET)
	public ModelAndView companyInfoPwdUpdate() {
		ModelAndView mav = new ModelAndView(
				"front_company/company_infoPwdUpdate");
		String userId = (String) request.getSession().getAttribute(
				ESessionKey.UserId.key);
		if (userId != null) {
			CompanyModel companyModel = companyService.getByUserId(userId);
			if (companyModel != null) {
				mav.addObject("companyModel", companyModel);
			}
		}
		return mav;
	}

	/**
	 * 企业修改密码功能
	 * 
	 * @return
	 */
	@RequestMapping(value = "company_infoPwdUpdate2.html", method = RequestMethod.POST)
	public String companyInfoPwdUpdate2() {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		CompanyModel companyModel = companyService.getByUserId(userId);
		if (companyModel != null) {
			companyModel.setPassword(password);
			companyService.updateCompany(companyModel);
		}
		return "redirect:/company_info.html";
	}

	/**
	 * 企业人员显示
	 * 
	 * @return
	 */
	@RequestMapping(value = "company_member.html", method = RequestMethod.GET)
	public ModelAndView companyMember() {
		ModelAndView mav = new ModelAndView("front_company/company_member");
		String userId = (String) request.getSession().getAttribute(
				ESessionKey.UserId.key);
		if (userId != null) {
			CompanyModel companyModel = companyService.getByUserId(userId);
			if (companyModel != null) {
				String code = companyModel.getCode();
				List<EngineerModel> engineerModels = engineerService
						.getByCode(code);
				if (engineerModels != null && !engineerModels.isEmpty()) {
					mav.addObject("engineerModels", engineerModels);
				}
			}
			mav.addObject("companyModel", companyModel);
		}
		return mav;
	}

	/**
	 * 跳转到企业人员新增页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "company_memberAdd.html", method = RequestMethod.GET)
	public ModelAndView companyMemberAdd() {
		ModelAndView mav = new ModelAndView("front_company/company_memberAdd");
		String userId = (String) request.getSession().getAttribute(
				ESessionKey.UserId.key);
		EngineerModel engineerModel = null;
		if (userId != null) {
			CompanyModel companyModel = companyService.getByUserId(userId);
			if (companyModel != null) {
				String code = companyModel.getCode();
				engineerModel = new EngineerModel();
				engineerModel.setCode(code);
			}
		}
		mav.addObject("engineerModel", engineerModel);
		return mav;
	}

	/**
	 * 企业人员新增功能
	 * 
	 * @return
	 */
	@RequestMapping(value = "company_memberAdd2.html", method = RequestMethod.POST)
	public String companyMemberAdd2() {
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String userId = request.getParameter("userId");
		String type = request.getParameter("type");
		String registration = request.getParameter("registration");
		String certificateorgan = request.getParameter("certificateorgan");
		String issuancedate = request.getParameter("issuancedate");
		String effectivedate = request.getParameter("effectivedate");
		engineerService.addEngineer(code, name, type, registration, userId,
				certificateorgan, issuancedate, effectivedate);
		return "redirect:/company_member.html";
	}

	/**
	 * 企业人员添加页面对手机号的校验
	 * 
	 * @param userId
	 */
	@RequestMapping(value = "company_addMemberUserIdRepCHeck.html", method = RequestMethod.POST)
	public void companyAddMemberUserIdRepCHeck(String userId,
			HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String flag = engineerService.addMobilRepCHeck(userId);
		out.print(flag);
		out.flush();
		out.close();
	}

	/**
	 * 企业人员修改页面对手机号的校验
	 * 
	 * @param userId
	 * @param id
	 */
	@RequestMapping(value = "company_modfiyMemberUserIdRepCHeck.html", method = RequestMethod.POST)
	public void companyModfiyMemberUserIdRepCHeck(String userId, String id,
			HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String flag = engineerService.modfiyMobilRepCHeck(userId, id);
		out.print(flag);
		out.flush();
		out.close();
	}

	/**
	 * 企业人员删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "company_memberDel.html", method = RequestMethod.GET)
	public String companyMemberDel(String id) {
		engineerService.delEngineer(id);
		return "redirect:/company_member.html";
	}

	/**
	 * 企业人员修改页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "company_memberUpdate.html", method = RequestMethod.GET)
	public ModelAndView companyMemberUpdate(String id) {
		ModelAndView mav = new ModelAndView(
				"front_company/company_memberUpdate");
		EngineerModel engineerModel = engineerService.getById(id);
		if (engineerModel != null) {
			mav.addObject("engineerModel", engineerModel);
		}
		return mav;
	}

	/**
	 * 企业人员修改功能
	 * 
	 * @return
	 */
	@RequestMapping(value = "company_memberupdate2.html", method = RequestMethod.POST)
	public String companyMemberupdate2() {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String userId = request.getParameter("userId");
		String type = request.getParameter("type");
		String registration = request.getParameter("registration");
		String certificateorgan = request.getParameter("certificateorgan");
		String issuancedate = request.getParameter("issuancedate");
		String effectivedate = request.getParameter("effectivedate");
		EngineerModel engineerModel = engineerService.getById(id);
		if (engineerModel != null) {
			engineerModel.setName(name);
			engineerModel.setUserId(userId);
			engineerModel.setType(type);
			engineerModel.setRegistration(registration);
			engineerModel.setCertificateorgan(certificateorgan);
			engineerModel.setIssuancedate(issuancedate);
			engineerModel.setEffectivedate(effectivedate);
			engineerService.updateEngineer(engineerModel);
		}
		return "redirect:/company_member.html";
	}

	/**
	 * 企业资质页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "company_credit.html", method = RequestMethod.GET)
	public ModelAndView companyCredit() {
		ModelAndView mav = new ModelAndView("front_company/company_credit");
		String userId = (String) request.getSession().getAttribute(
				ESessionKey.UserId.key);
		if (userId != null) {
			CompanyModel companyModel = companyService.getByUserId(userId);
			if (companyModel != null) {
				String code = companyModel.getCode();
				List<AptitudeModel> aptitudeModels = aptitudeService
						.getByCode(code);
				if (aptitudeModels != null && !aptitudeModels.isEmpty()) {
					mav.addObject("aptitudeModels", aptitudeModels);
				}
			}
			mav.addObject("companyModel", companyModel);
		}
		return mav;
	}

	/**
	 * 资质(信)的等级显示ajax
	 * 
	 * @param adType
	 * @param response
	 */
	@RequestMapping(value = "company_getAdType.html", method = RequestMethod.POST)
	public void companygetAdType(String adType, HttpServletResponse response) {
		int ad = Integer.valueOf(adType);
		response.setContentType("text/html;charset=UTF-8");
		response.setContentType("UTF-8");
		List<EAdlevel> eAdlevels = EAdlevel.getEAdlevelId(ad);
		List<AdlevelVo> adlevelVos = new ArrayList<AdlevelVo>();
		for (EAdlevel eAdlevel : eAdlevels) {
			AdlevelVo adlevelVo = new AdlevelVo();
			adlevelVo.setAdlevelType(eAdlevel.id);
			adlevelVo.setAdlevelName(eAdlevel.desc);
			adlevelVos.add(adlevelVo);
		}
		PublicMethod.objectToJson(adlevelVos, response);
	}
	
	/**
	 * 企业资质新增页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "company_creditAdd.html", method = RequestMethod.GET)
	public ModelAndView companyCreditAdd() {
		ModelAndView mav = new ModelAndView("front_company/company_creditAdd");
		String userId = (String) request.getSession().getAttribute(
				ESessionKey.UserId.key);
		AptitudeModel aptitudeModel = null;
		if (userId != null) {
			CompanyModel companyModel = companyService.getByUserId(userId);
			if (companyModel != null) {
				String code = companyModel.getCode();
				aptitudeModel = new AptitudeModel();
				aptitudeModel.setCode(code);
			}
		}
		mav.addObject("aptitudeModel", aptitudeModel);
		return mav;
	}

	/**
	 * 企业资质新增功能
	 * 
	 * @return
	 */
	@RequestMapping(value = "company_creditAdd2.html", method = RequestMethod.POST)
	public String companyCreditAdd2() {
		String code = request.getParameter("code").trim();
		String certificate = request.getParameter("certificate");
		int adtype = Integer.parseInt(request.getParameter("adtype").trim());
		int adlevel = Integer.parseInt(request.getParameter("adlevel").trim());
		String approval = request.getParameter("approval").trim();
		String approvalTime = request.getParameter("approvalTime").trim();
		String validity = request.getParameter("validity").trim();
		aptitudeService.addAptitude(code, certificate, adtype, adlevel,
				approval, approvalTime, validity);
		return "redirect:/company_credit.html";
	}

	/**
	 * 企业资质删除功能
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "company_creditDel.html", method = RequestMethod.GET)
	public String companyAptitudeDel(String id) {
		aptitudeService.delAptitude(id);
		return "redirect:/company_credit.html";
	}

	/**
	 * 企业资质修改页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "company_creditUpdate.html", method = RequestMethod.GET)
	public ModelAndView companyAptitudeUpdate(String id) {
		ModelAndView mav = new ModelAndView(
				"front_company/company_creditUpdate");
		AptitudeModel aptitudeModel = aptitudeService.getById(id);
		if (aptitudeModel != null) {
			mav.addObject("aptitudeModel", aptitudeModel);
		}
		return mav;
	}

	/**
	 * 企业资质修改功能
	 * 
	 * @return
	 */
	@RequestMapping(value = "company_creditUpdate2.html", method = RequestMethod.POST)
	public String companyCreditUpdate2() {
		String id = request.getParameter("id").trim();
		String certificate = request.getParameter("certificate").trim();
		int adtype = Integer.parseInt(request.getParameter("adtype").trim());
		int adlevel = Integer.parseInt(request.getParameter("adlevel").trim());
		String approval = request.getParameter("approval").trim();
		String approvalTime = request.getParameter("approvalTime").trim();
		String validity = request.getParameter("validity").trim();
		AptitudeModel aptitudeModel = aptitudeService.getById(id);
		if (aptitudeModel != null) {
			aptitudeModel.setCertificate(certificate);
			aptitudeModel.setAdtype(adtype);
			aptitudeModel.setAdlevel(adlevel);
			aptitudeModel.setApproval(approval);
			aptitudeModel.setApprovalTime(approvalTime);
			aptitudeModel.setValidity(validity);
			aptitudeService.updateAptitude(aptitudeModel);
		}
		return "redirect:/company_credit.html";
	}

	/**
	 * 企业信息页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "company_project.html", method = RequestMethod.GET)
	public ModelAndView companyProject() {
		ModelAndView mav = new ModelAndView("front_company/company_project");
		String userId = (String) request.getSession().getAttribute(
				ESessionKey.UserId.key);
		if (userId != null) {
			CompanyModel companyModel = companyService.getByUserId(userId);
			if (companyModel != null) {
				String code = companyModel.getCode();
				List<ProjectModel> projectModels = projectService
						.getByCode(code);
				if (projectModels != null && !projectModels.isEmpty()) {
					mav.addObject("projectModels", projectModels);
				}
			}
			mav.addObject("companyModel", companyModel);
		}
		return mav;
	}

	/**
	 * 企业信息新增页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "company_projectAdd.html", method = RequestMethod.GET)
	public ModelAndView companyProjectAdd() {
		ModelAndView mav = new ModelAndView("front_company/company_projectAdd");
		String userId = (String) request.getSession().getAttribute(
				ESessionKey.UserId.key);
		ProjectModel projectModel = null;
		if (userId != null) {
			CompanyModel companyModel = companyService.getByUserId(userId);
			if (companyModel != null) {
				String code = companyModel.getCode();
				projectModel = new ProjectModel();
				projectModel.setCode(code);
			}
		}
		mav.addObject("projectModel", projectModel);
		return mav;
	}

	/**
	 * 企业信息新增功能
	 * 
	 * @return
	 */
	@RequestMapping(value = "company_projectAdd2.html", method = RequestMethod.POST)
	public String companyprojectAdd2() {
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String pCode = request.getParameter("pCode");
		int price = 0;
		if (!"".equals(request.getParameter("price"))) {
			price = Integer.parseInt(request.getParameter("price"));
		}
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String allWork = request.getParameter("allWork");
		String thsWork = request.getParameter("thsWork");
		String accWork = request.getParameter("accWork");
		int prepaid = 0;
		if (!"".equals(request.getParameter("prepaid"))) {
			prepaid = Integer.parseInt(request.getParameter("prepaid"));
		}
		String leaderName = request.getParameter("leaderName");
		String userId = request.getParameter("userId");
		int times = 0;
		if (!"".equals(request.getParameter("times"))) {
			times = Integer.parseInt(request.getParameter("times"));
		}
		String status = request.getParameter("status");
		int progress = 0;
		if (!"".equals(request.getParameter("progress"))) {
			progress = Integer.parseInt(request.getParameter("progress"));
		}
		String projectTitanic = request.getParameter("projectTitanic");
		String projectlevel = request.getParameter("projectlevel");
		String projectorgan = request.getParameter("projectorgan");
		String provinceCode = request.getParameter("provinceCode");
		String replytime = request.getParameter("replytime");
		String totalarea = request.getParameter("totalarea");
		String purpose = request.getParameter("purpose");
		String nature = request.getParameter("nature");
		String worktime = request.getParameter("worktime");
		String type = request.getParameter("type");
		String unit = request.getParameter("unit");
		String lonlat = request.getParameter("lonlat");
		String lonlat2 = request.getParameter("lonlat2");
		int check = 0;
		projectService.frontAddProject(name, code, pCode, allWork, thsWork,
				accWork, userId, leaderName, times, province, city, street,
				price, prepaid, status, progress, projectTitanic, projectlevel,
				projectorgan, provinceCode, replytime, totalarea, purpose,
				nature, worktime, type, unit, check, lonlat, lonlat2);
		return "redirect:/company_project.html";
	}

	/**
	 * 判断企业的联系方式有没有被注册
	 * 
	 * @param userId
	 * @param leaderName
	 * @param response
	 */
	@RequestMapping(value = "company_projectUserIdReg.html", method = RequestMethod.POST)
	public void companyProjectUserIdReg(String userId, String leaderName,
			HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String flag = userService.regCompanyProjectUserId(userId, leaderName);
		out.print(flag);
		out.flush();
		out.close();
	}

	/**
	 * 企业项目删除功能
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "company_projectDel.html", method = RequestMethod.GET)
	public String companyProjectDel(String id) {
		projectService.delProject(id);
		return "redirect:/company_project.html";
	}

	/**
	 * 项目信息页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "company_projectDetail.html", method = RequestMethod.GET)
	public ModelAndView companyProjectDetail(String id) {
		ModelAndView mav = new ModelAndView("operate/operate");
		ProjectModel projectModel = projectService.getById(id);
		request.getSession().setAttribute(ESessionKey.ProjectId.key,
				projectModel.getId());
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		return mav;
	}

	/**
	 * 企业合同页面
	 * @return
	 */
	@RequestMapping(value = "company_compact.html", method = RequestMethod.GET)
	public ModelAndView companyContract() {
		ModelAndView mav = new ModelAndView("front_company/company_compact");
		String userId = (String) request.getSession().getAttribute(
				ESessionKey.UserId.key);
		if (userId != null) {
			CompanyModel companyModel = companyService.getByUserId(userId);
			if (companyModel != null) {
				String code = companyModel.getCode();
				List<CompanyCompactModel> companyCompactModels = companyCompactService.getByCode(code);
				if (companyCompactModels != null && !companyCompactModels.isEmpty()) {
					mav.addObject("companyCompactModels", companyCompactModels);
				}
				mav.addObject("companyModel", companyModel);
			}
		}
		return mav;
	}
	
	/**
	 * 企业合同新增页面
	 * @return
	 */
	@RequestMapping(value = "company_compactAdd.html", method = RequestMethod.GET)
	public ModelAndView companyCompactAdd() {
		ModelAndView mav = new ModelAndView("front_company/company_compactAdd");
		String userId = (String) request.getSession().getAttribute(
				ESessionKey.UserId.key);
		CompanyCompactModel companyCompactModel = null;
		if (userId != null) {
			CompanyModel companyModel = companyService.getByUserId(userId);
			if (companyModel != null) {
				String code = companyModel.getCode();
				companyCompactModel = new CompanyCompactModel();
				companyCompactModel.setCode(code);
			}
		}
		mav.addObject("companyCompactModel", companyCompactModel);
		return mav;
	}
	
	/**
	 * 企业合同新增功能
	 * @return
	 */
	@RequestMapping(value = "company_compactAdd2.html", method = RequestMethod.POST)
	public String companyCompactAdd2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
		String code = request.getParameter("code");
		String projectName = request.getParameter("projectName");
		String buildUnit = request.getParameter("buildUnit");
		double compactPrice = Double.parseDouble(request.getParameter("compactPrice"));
		int isTender = Integer.parseInt(request.getParameter("isTender"));
		int isCompact = Integer.parseInt(request.getParameter("isCompact"));
		int isAchieveReport = Integer.parseInt(request.getParameter("isAchieveReport"));
		String leaderName = request.getParameter("leaderName");
		String executiveInfo = request.getParameter("executiveInfo");
		String achieveWorkDate = null;
		String startWorkDate = null;
		try {
			achieveWorkDate = sdf1.format(sdf.parse(request.getParameter("achieveWorkDate")));
			startWorkDate = sdf1.format(sdf.parse(request.getParameter("startWorkDate")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		companyCompactService.addCompanyContract(code, projectName, buildUnit, compactPrice, isTender, isCompact, isAchieveReport, leaderName, executiveInfo, achieveWorkDate, startWorkDate);
		return "redirect:/company_compact.html";
	}
	
	/**
	 * 企业合同修改页面
	 * @param id
	 * @param pName
	 * @return
	 */
	@RequestMapping(value = "company_compactUpdate.html", method = RequestMethod.GET)
	public ModelAndView companyCompactUpdate(String id, String pName) {
		ModelAndView mav = new ModelAndView("front_company/company_compactUpdate");
		CompanyCompactModel companyCompactModel = companyCompactService.getById(id);
		if (companyCompactModel != null) {
			mav.addObject("companyCompactModel", companyCompactModel);
		}
		mav.addObject("pName", pName);
		return mav;
	}
	
	/**
	 * 企业合同修改功能
	 * @return
	 */
	@RequestMapping(value = "company_compactUpdate2.html", method = RequestMethod.POST)
	public String companyCompactUpdate2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
		String id = request.getParameter("id");
		String pName = request.getParameter("pName");
		String projectName = request.getParameter("projectName");
		String buildUnit = request.getParameter("buildUnit");
		String achieveWorkDate = request.getParameter("achieveWorkDate");
		double compactPrice = Double.parseDouble(request.getParameter("compactPrice"));
		int isTender = Integer.parseInt(request.getParameter("isTender"));
		int isCompact = Integer.parseInt(request.getParameter("isCompact"));
		int isAchieveReport = Integer.parseInt(request.getParameter("isAchieveReport"));
		String startWorkDate = request.getParameter("startWorkDate");
		String leaderName = request.getParameter("leaderName");
		String executiveInfo = request.getParameter("executiveInfo");
		String eL = "[0-9]{4}年[0-9]{2}月[0-9]{2}日";
		Pattern pattern = Pattern.compile(eL);
		Matcher achieveWorkDateMatcher = pattern.matcher(achieveWorkDate); 
		Matcher startWorkDateMatcher = pattern.matcher(startWorkDate); 
		if (!achieveWorkDateMatcher.matches()) {
			try {
				achieveWorkDate = sdf1.format(sdf.parse(request.getParameter("achieveWorkDate")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (!startWorkDateMatcher.matches()) {
			try {
				startWorkDate = sdf1.format(sdf.parse(request.getParameter("startWorkDate")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		CompanyCompactModel companyCompactModel = companyCompactService.getById(id);
		if (companyCompactModel != null) {
			companyCompactModel.setProjectName(projectName);
			companyCompactModel.setBuildUnit(buildUnit);
			companyCompactModel.setAchieveWorkDate(achieveWorkDate);
			companyCompactModel.setCompactPrice(compactPrice);
			companyCompactModel.setIsTender(isTender);
			companyCompactModel.setIsCompact(isCompact);
			companyCompactModel.setIsAchieveReport(isAchieveReport);
			companyCompactModel.setStartWorkDate(startWorkDate);
			companyCompactModel.setLeaderName(leaderName);
			companyCompactModel.setExecutiveInfo(executiveInfo);
			companyCompactService.updateCompanyCompact(companyCompactModel);
		}
		if (pName == "") {
			return "redirect:/company_compact.html";
		} else {
			return "forward:/company_getCompact.html";
		}
	}
	
	/**
	 * 根据项目的名称查询该项目的合同
	 * @return
	 */
	@RequestMapping(value = "company_getCompact.html", method = RequestMethod.POST)
	public ModelAndView companyGetCompact() {
		ModelAndView mav = new ModelAndView("front_company/company_compact");
		String pName = request.getParameter("pName").trim();
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		if (userId != null) {
			CompanyModel companyModel = companyService.getByUserId(userId);
			if (companyModel != null) {
				if (pName == null || pName == "") {
					String code = companyModel.getCode();
					List<CompanyCompactModel> companyCompactModels = companyCompactService.getByCode(code);
					if (companyCompactModels != null && !companyCompactModels.isEmpty()) {
						mav.addObject("companyCompactModels", companyCompactModels);
					}
					pName = null;
				} else {
					CompanyCompactModel companyCompactModel = companyCompactService.getByProjectName(pName);
					if (companyCompactModel != null) {
						mav.addObject("companyCompactModel", companyCompactModel);
					}
				}
				mav.addObject("companyModel", companyModel);
			}
		}
		mav.addObject("pName", pName);
		return mav;
	}
	
	/**
	 * 企业合同附件功能
	 * @param response
	 * @param companyCompactId
	 * @param companyId
	 * @return
	 */
	@RequestMapping(value = "company_compactUploadImage.html", method = RequestMethod.POST)
	public String companyCompactUploadImage(HttpServletResponse response, String companyCompactId, String companyId) {
		SmartUpload smartUpload = new SmartUpload();
		try {
			smartUpload.initialize(config, request, response);
			smartUpload.upload();
			Files files = smartUpload.getFiles();
			File file = files.getFile(0);
			String fileExt = file.getFileExt();
			Date dateCurrentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("YYMMddHHmmss");
			String currentTime = formatter.format(dateCurrentTime); 
			String fileName = currentTime + "." + fileExt.toLowerCase();
			String filePath = IMageUploadInfo.BASEPATH.value + IMageUploadInfo.COMPANYCOMPACTPATH.value + companyId;
			new ImageUpload().imageUpload(file, fileName, filePath, config, request, response);
			CompanyCompactModel companyCompactModel = companyCompactService.getById(companyCompactId);
			if (companyCompactModel != null) {
				companyCompactModel.setAttachment(fileName);
				companyCompactService.updateCompanyCompact(companyCompactModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:company_compact.html";
	}
	
	/**
	 * 获取施工班组的小技能类型
	 * @param skillBigType
	 * @param response
	 */
	@RequestMapping(value = "project_getTeamSkillSmallType.html", method = RequestMethod.POST)
	public void projectGetTeamSkillSmallType(String skillBigType, HttpServletResponse response) {
		int sbt = 0;
		if (!"请选择技能类别".equals(skillBigType)) {
			sbt = Integer.valueOf(skillBigType);
		}
		response.setContentType("text/html;charset=UTF-8");
		response.setContentType("UTF-8");
		List<ETeamSkillSmallType> eTeamSkillSmallTypes = ETeamSkillSmallType.getSkillSmallTypeId(sbt);
		List<TeamSkillSmallTypeVo> teamSkillSmallTypeVos = new ArrayList<TeamSkillSmallTypeVo>();
		for (ETeamSkillSmallType eTeamSkillSmallType : eTeamSkillSmallTypes) {
			TeamSkillSmallTypeVo teamSkillSmallTypeVo = new TeamSkillSmallTypeVo();
			teamSkillSmallTypeVo.setTeamSkillSmallType(eTeamSkillSmallType.id);
			teamSkillSmallTypeVo.setTeamSkillSmallName(eTeamSkillSmallType.desc);
			teamSkillSmallTypeVos.add(teamSkillSmallTypeVo);
		}
		PublicMethod.objectToJson(teamSkillSmallTypeVos, response);
	}
	
	/**
	 * 消息公告列表页面
	 * @param isRead
	 * @return
	 */
	@RequestMapping(value = "company_notice.html")
	public ModelAndView companyNotice(String isRead) {
		ModelAndView mav = new ModelAndView("front_company/company_notice");
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		Map<String, Object> map = noticeService.getShowNoticeHasMap(isRead, mav, userId, UserType.CompanyType.desc, null);
		int unReadNoticeCount = (int) map.get("unReadNoticeCount");
		int readNoticeCount = (int) map.get("readNoticeCount");
		int unReadMessageCount = Integer.parseInt((String) request.getSession().getAttribute("unReadMessageCount"));
		int readMessageCount = Integer.parseInt((String) request.getSession().getAttribute("readMessageCount"));
		request.getSession().setAttribute("count", (unReadNoticeCount + unReadMessageCount) + "");
		request.getSession().setAttribute("unReadNoticeCount", (unReadNoticeCount + ""));
		request.getSession().setAttribute("readNoticeCount", (readNoticeCount + ""));
		request.getSession().setAttribute("unReadMessageCount", (unReadMessageCount + ""));
		request.getSession().setAttribute("readMessageCount", (readMessageCount + ""));
		return ((ModelAndView) map.get("mav"));
	}
	
	/**
	 * 公告的具体内容
	 * @param nId
	 * @param cId
	 * @return
	 */
	@RequestMapping(value = "company_noticeInfo.html", method = RequestMethod.POST)
	public void companyNoticeInfo(String nId, String cId, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<JSONObject> jsonObjects = noticeService.getNoticeInfo(nId, cId, UserType.CompanyType.desc, null);
		out.print(jsonObjects);
		out.flush();
		out.close();
	}
	
	/**
	 * 一对一消息列表页面
	 * @param isRead
	 * @return
	 */
	@RequestMapping(value = "company_message.html")
	public ModelAndView CompanyMessage(String isRead) {
		ModelAndView mav = new ModelAndView("front_company/company_message");
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		Map<String, Object> map = messageService.getShowMessageHasMap(isRead, mav, userId, UserType.CompanyType.desc, null);  
		int unReadMessageCount = (int) map.get("unReadMessageCount");
		int readMessageCount = (int) map.get("readMessageCount");
		int unReadNoticeCount = Integer.parseInt((String) request.getSession().getAttribute("unReadNoticeCount"));
		int readNoticeCount = Integer.parseInt((String) request.getSession().getAttribute("readNoticeCount"));
		request.getSession().setAttribute("count", (unReadNoticeCount + unReadMessageCount) + "");
		request.getSession().setAttribute("unReadNoticeCount", (unReadNoticeCount + ""));
		request.getSession().setAttribute("readNoticeCount", (readNoticeCount + ""));
		request.getSession().setAttribute("unReadMessageCount", (unReadMessageCount + ""));
		request.getSession().setAttribute("readMessageCount", (readMessageCount + ""));
		return ((ModelAndView) map.get("mav"));
	}
	
	/**
	 * 修改Message是否已读状态
	 * @param messageId
	 * @param response
	 */
	@RequestMapping(value = "company_messageIsRead.html", method = RequestMethod.POST)
	public void companyMessageIsRead(String messageId, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean result = messageService.updateIsRead(messageId);
		out.print(result);
		out.flush();
		out.close();
	}
	
	// --------------ruankai---------------------------------------------------
	
	/**
	 * 检查公司组织机构代码的唯一性
	 */
	@RequestMapping(value = "company_organizationRep.html")
	public void companyOrganizationRep(String organization,
			HttpServletResponse response) {
		CompanyModel companyModel = companyService
				.getCompanyByOrganization(organization);
		// 1：查询到表示有公司存在，重复 0：表示未重复
		if (companyModel == null) {
			PublicMethod.objectToJson(0, response);
		} else {
			PublicMethod.objectToJson(1, response);
		}
	}
	
	/**
	 * 检查公司名称的唯一性
	 */
	@RequestMapping(value = "company_nameRep.html")
	public void companyNameRep(String name, HttpServletResponse response) {
		CompanyModel companyModel = companyService.getByName(name);
		// 1：查询到表示有公司存在，重复 0：表示未重复
		if (companyModel == null) {
			PublicMethod.objectToJson(0, response);
		} else {
			PublicMethod.objectToJson(1, response);
		}
	}
}