package com.fengyun.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.write.WriteException;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.cache.page.PageHandler;
import com.fengyun.web.db.playermodel.CommentsModel;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.EquipmentTradModel;
import com.fengyun.web.db.playermodel.MerchantModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.RequirementsModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.db.vo.ProjectVo;
import com.fengyun.web.hardcode.ESessionKey;
import com.fengyun.web.hardcode.IMageUploadInfo;
import com.fengyun.web.hardcode.UserType;
import com.fengyun.web.service.CommentsService;
import com.fengyun.web.service.EquipmentService;
import com.fengyun.web.service.EquipmentTradService;
import com.fengyun.web.service.MerchantService;
import com.fengyun.web.service.MessageService;
import com.fengyun.web.service.NoticeService;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.RequirementsService;
import com.fengyun.web.service.UserService;
import com.fengyun.web.util.ExportExcel;
import com.fengyun.web.util.ImageUpload;
import com.fengyun.web.util.PublicMethod;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * 前台设备商controller
 * 
 * @author zhengss
 * 
 */
@Controller
@RequestMapping(value = "equipment")
public class FrontEquipmentController {

	@Autowired
	public HttpSession session;

	@Autowired
	private EquipmentService equipmentService;

	@Autowired
	private CommentsService commentsService;

	@Autowired
	private MerchantService merchantService;

	@Autowired
	private EquipmentTradService equipmentTradService;

	@Autowired
	private RequirementsService requirementsService;

	@Autowired
	private ProjectDepartmentService projectDepartmentService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserService userService;

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private ServletConfig config;

	@Autowired
	private HttpServletRequest request;

	/**
	 * 个人中心--设备商-信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "info.html")
	public ModelAndView toEquipmentInfo() {
		System.out.println("进入equipment");
		ModelAndView mav = new ModelAndView("front_equipment/equipment_info");
		String userId = (String) session.getAttribute("userId");
		EquipmentModel equipmentModel = equipmentService.getByUserId(userId);
		mav.addObject("equipmentModel", equipmentModel);
		return mav;
	}

	/**
	 * 更新用户信息
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "updateInfo.html")
	public ModelAndView modifyInfo(EquipmentModel model) {
		ModelAndView mav = new ModelAndView("front_equipment/equipment_info");

		String userId = (String) session.getAttribute("userId");
		EquipmentModel equipmentModel = equipmentService.getByUserId(userId);
		MerchantModel merchantModel = merchantService.getByUserId(userId);
		if (StringUtils.isNotBlank(model.getEstablishDate())) {
			equipmentModel.setEstablishDate(model.getEstablishDate());
			merchantModel.setBuild(model.getEstablishDate());
		}

		if (StringUtils.isNotBlank(model.getLicence())) {
			equipmentModel.setLicence(model.getLicence());
			// 【个人信息-社会统一信用代码】和【诚信档案-社会统一信用代码】 不在同一个表中，
			// 更新一边时，要同时在代码中更新另一边以保持数据统一性。
			
			if (merchantModel != null) {
				merchantModel.setlicence(model.getLicence());
			}
		}

		if (StringUtils.isNotBlank(model.getName())) {
			equipmentModel.setName(model.getName());
		}

		if (StringUtils.isNotBlank(model.getShopName())) {
			equipmentModel.setShopName(model.getShopName());
		}

		if (StringUtils.isNotBlank(model.getLeaderName())) {
			equipmentModel.setLeaderName(model.getLeaderName());
		}

		if (StringUtils.isNotBlank(model.getLicence())) {
			equipmentModel.setLicence(model.getLicence());
		}

		if (StringUtils.isNotBlank(model.getRegcapital())) {
			equipmentModel.setRegcapital(model.getRegcapital());
			
			if (merchantModel != null) {
				merchantModel.setRegistercapital(model.getRegcapital());
			}
		}

		if (StringUtils.isNotBlank(model.getProvince())) {
			equipmentModel.setProvince(model.getProvince());
		}

		if (StringUtils.isNotBlank(model.getCity())) {
			equipmentModel.setCity(model.getCity());
		}
		if (StringUtils.isNotBlank(model.getStreet())) {
			equipmentModel.setStreet(model.getStreet());
		}

		if (StringUtils.isNotBlank(model.getUserId())) {
			equipmentModel.setUserId(model.getUserId());
		}
		equipmentModel.setScore(model.getScore());
		
		merchantService.updateMerchant(merchantModel);
		equipmentService.updateEquipment(equipmentModel);
		mav.addObject("equipmentModel", equipmentModel);
		return mav;
	}

	/**
	 * 个人中心--设备商-进入修改密码
	 * 
	 * @return
	 */
	@RequestMapping(value = "equipmentModifyPassword.html")
	public ModelAndView modifyPassword() {
		ModelAndView mav = new ModelAndView("front_equipment/equipment_modifypassword");
		return mav;
	}

	/**
	 * 个人中心--设备商-修改密码
	 * 
	 * @author rkai
	 * @param userId
	 * @param password
	 * @param response
	 */
	@RequestMapping(value = "modifyPassword.html")
	public String modifyEquipmentPassword(String userId, String password) throws IOException {
		// 向service中查询出用户是否存在，如果存在返回 用户对象
		UserModel model = userService.getByUserId(userId);
		model.setUserPassword(password);
		userService.updateUser(model);
		return "redirect:info.html";
	}

	/**
	 * 个人中心--设备商-诚信档案
	 * 
	 * @return
	 */
	@RequestMapping(value = "equipmentFile.html")
	public ModelAndView equipmentFile(HttpSession session) {
		ModelAndView mav = new ModelAndView("front_equipment/equipment_file");
		String userId = (String) session.getAttribute("userId");
		String tp = (String) session.getAttribute("type");
		int type = Integer.valueOf(tp);
		EquipmentModel equipmentModel = equipmentService.getByUserId(userId);
		MerchantModel merchantModel = null;
		// if(equipmentModel.getCode()!=null){
		// 注册为设备商班组以后未经审核时equipment表中没有code数据，需要人工审核添加code和其他信息。
		merchantModel = merchantService.getByUserId(userId);// userId对应merchant中的mobile
		// }
		List<CommentsModel> comments = commentsService.getListByIdAndType(userId, type);
		mav.addObject("equipmentModel", equipmentModel);
		mav.addObject("merchantModel", merchantModel);
		mav.addObject("comments", comments);
		return mav;
	}

	/**
	 * 更新诚信档案
	 * 
	 * @param merchantModel
	 * @return
	 */
	@RequestMapping(value = "updateMerchant.html")
	public String updateFile(MerchantModel merchantModel) {
		merchantService.updateMerchant(merchantModel);
		return "redirect:equipmentFile.html";
	}

	/**
	 * 个人中心--设备商-出库记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "equipmentLog.html")
	public ModelAndView equipmentLog(String pName, String year, String month, String export, HttpServletResponse response,
			@RequestParam(value = "pageNow", defaultValue = "1") int pageNow, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		equipmentTradService.addEquipmentTrad("583fbb9418d6945ea56adc5d", "58048a3a59e92cc73f6468e6", "广州建苑建筑设备有限公司", "广州塔维护项目", "塔机", "钱文忠", "2016", "10",
				"12", 1, 5, 10000, 20000, 0, 0, "发票情况", "note备注", "刘梅", "银行转账", "流水号：1231654613");
		ModelAndView mav = new ModelAndView("front_equipment/equipment_log");
		EquipmentModel equipmentModel = equipmentService.getByUserId((String) session.getAttribute("userId"));
		String eId = equipmentModel.getId();
		Long dataCount = equipmentTradService.countEquipmentTrad(pName, year, month, eId);
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		List<EquipmentTradModel> equipmentTradModelList = equipmentTradService.getEquipmentTradList(pName, year, month, eId, page);
		mav.addObject("equipmentTradModelList", equipmentTradModelList);

		EquipmentTradModel model = null;
		if (equipmentTradModelList.size() > 0) {
			model = equipmentTradModelList.get(0);
		}
		String eName = null;
		if (model != null) {
			eName = model.geteName();
		}
		// 回显
		mav.addObject("year", year);
		mav.addObject("month", month);
		mav.addObject("pName", pName);
		mav.addObject("eName", eName);
		mav.addObject("page", page);

		String[] Title = { "项目名称", "设备名称", "经办人", "出租日期", "本次租赁", "累计租赁", "本次付款", "累计付款", "其他款", "余款", "发票", "付款人", "付款方式", "流水号", "备注" };// 导出excel的表头
		String fileName = eName + "-租赁记录"; // 导出excel的文件名
		String[] dateFieldNames = {}; // 需要转换时间格式的字段的名字数组 */
		int[] needIndex = { 4, 5, 6, 7, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };
		if ("1".equals(export)) {
			try {
				ExportExcel.recoredExportExcel(response, "equipmentTrad", Title, fileName, needIndex, equipmentTradModelList, dateFieldNames);
			} catch (WriteException | IOException e) {
				e.printStackTrace();
			}
		}

		return mav;
	}

	/**
	 * 个人中心--设备商-申请加入项目
	 * 
	 * @return
	 */
	@RequestMapping(value = "equipmentJoinProject.html")
	public ModelAndView equipmentJoinProject(String province, String city, String name, String leaderName,
			@RequestParam(value = "pageNow", defaultValue = "1") int pageNow, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		// 通过requirements表中的type=2（1求职，2招聘）和userType=3(1-个人 2-班组 3-项目)
		// teamType=3(1-施工班组 2-材料班组 3-设备班组) ,status=1(1招聘信息开放 0表示关闭)【分页】
		// 查询正在招聘的所有的项目
		int type = 2, userType = 3, teamType = 3, status = 1;
		long count = requirementsService.count(type, userType, teamType, status, province, city, name, leaderName);
		Page page = PageHandler.getPage(pageSize, pageNow, count);
		List<RequirementsModel> requirementList = requirementsService.getRequirement(page, type, userType, teamType, status, province, city, name, leaderName);
		EquipmentModel equipmentModel = equipmentService.getByUserId((String) session.getAttribute("userId"));
		ModelAndView mav = new ModelAndView("front_equipment/equipment_joinproject");
		// 查询【历史申请明细】 和 【正在申请】 的项目 参数：项目id、status=4（已离开或结束）（type=3 ）
		String mId = equipmentModel.getId();
		Map<ProjectModel, ProjectDepartmentModel> mapPast = getApplyInfoInMap(mId, 3, 4);
		Map<ProjectModel, ProjectDepartmentModel> mapCur = getApplyInfoInMap(mId, 3, 1);
		mav.addObject("requirementList", requirementList); // 发布了招聘信息的【项目列表】
		mav.addObject("equipmentModel", equipmentModel);// 当前【设备商信息】
		mav.addObject("mapPast", mapPast);// 【历史申请明细】
		mav.addObject("mapCur", mapCur);// 【正在申请的】
		mav.addObject("page", page);
		// 回显搜索条件
		mav.addObject("province", province);
		mav.addObject("city", city);
		mav.addObject("name", name);
		mav.addObject("leaderName", leaderName);
		return mav;
	}

	/**
	 * 获取【过往申请记录/当前申请记录】以map集合的形式返回
	 * 
	 * @param mId
	 *            设备商id
	 * @param type
	 * @param status
	 * @return
	 */
	public Map<ProjectModel, ProjectDepartmentModel> getApplyInfoInMap(String mId, int type, int status) {
		List<ProjectDepartmentModel> projectDepartmentList = projectDepartmentService.getProjectByTIdStatus(mId, type, status);
		List<ProjectModel> pastProjectList = projectDepartmentService.getApplyProjectByTIdStatus(projectDepartmentList);
		Map<ProjectModel, ProjectDepartmentModel> map = projectDepartmentService.getApplyInfo(pastProjectList, projectDepartmentList);
		return map;
	}

	/**
	 * 异步提交申请加入项目
	 * 
	 * @return
	 */
	@RequestMapping(value = "joinProject.html")
	public void joinProject(HttpServletResponse response, ProjectDepartmentModel pdModel, String pdId) {
		// String vId,String pId,int status, int type,String name,Date
		// createDate;
		System.out.println(pdModel);
		pdModel.setCreateTime(new Date());
		String msg = null;
		// 1、首先根据异步提交的条件，查询有没有正在申请
		ProjectDepartmentModel applyModel = projectDepartmentService.getApplied(pdModel.getvId(), pdModel.getpId(), pdModel.getType(), 1);
		ProjectDepartmentModel oldModel = projectDepartmentService.getApplied(pdModel.getvId(), pdModel.getpId(), pdModel.getType(), 4);
		// 2、判断 （是否重复操作）
		if (applyModel != null) {
			msg = "您已提交过申请，正在申请中！";
		} else if (oldModel != null) {
			oldModel.setStatus(1);
			projectDepartmentService.updateProjectDepartment(oldModel);
			msg = "已提交申请！";
		} else if (pdModel.getStatus() == 1) {// 插入一条申请记录数据、返回 提示信息："已提交申请！"；
			projectDepartmentService.addProjectDepartment(pdModel);
			msg = "已提交申请！";
		}
		// 3、写回json数据
		PublicMethod.objectToJson(msg, response);
	}

	/**
	 * 异步请求 撤销申请加入项目
	 * 
	 * @return
	 */
	@RequestMapping(value = "cancelProject.html")
	public void cancelProject(HttpServletResponse response, ProjectDepartmentModel pdModel, String pdId) {
		// String vId,String pId,int status, int type,String name,Date
		// createDate;
		System.out.println(pdModel);
		pdModel.setCreateTime(new Date());
		String msg = null;
		// 1、首先根据异步提交的条件，查询有没有正在撤销
		// ProjectDepartmentModel applyModel =
		// projectDepartmentService.getApplied(pdModel.getvId(),pdModel.getpId(),
		// pdModel.getType(),1);
		pdModel.setId(pdId);
		projectDepartmentService.updateProjectDepartment(pdModel);
		msg = "已撤销申请！";
		// 2、写回json数据
		PublicMethod.objectToJson(msg, response);
	}

	/**
	 * 个人中心--设备商-邀请列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "equipmentInvite.html")
	public ModelAndView equipmentInvite(HttpSession session) {
		ModelAndView mav = new ModelAndView("front_equipment/equipment_invite");
		// 通过Session取得userId
		String userId = (String) session.getAttribute("userId");
		// 通过userId到equipment表中查到设备商Id
		EquipmentModel mModel = equipmentService.getByUserId(userId);
		// 通过设备商id和status==2到Projectdepartment表中查询出邀请当前用户设备商的项目管理到ModelList
		// 使用项目ModelList(中的pId到项目中查出邀请我的项目列表)
		int type = 3;// 班组类型：1-班组 2-材料 3-设备
		int status = 2;// 状态--1申请中，2邀请中 3-已加入 4-已结束或离开
		List<ProjectModel> projectList = projectDepartmentService.getProjectInvatationList(mModel.getId(), type, status);
		/*
		 * String gmtString = projectList.get(0).getCreateTime().toString();
		 * SimpleDateFormat myformat = new SimpleDateFormat("yyyy年MM月dd日");
		 * System.out.println("---时间是---："+gmtString); String formatDate =
		 * myformat.format(new Date());
		 * System.out.println("---当前时间是---："+formatDate);
		 */
		mav.addObject("projectList", projectList);
		return mav;
	}

	/**
	 * 接受/拒绝 邀请操作
	 * 
	 * @param session
	 * @param response
	 * @param pId
	 * @param flag
	 * @return
	 */
	@RequestMapping(value = "invationfeedback.html")
	public ModelAndView invationfeedback(HttpServletResponse response, String pId, int flag, String name) {
		// System.out.println(pId+"------"+flag );
		String userId = (String) session.getAttribute("userId");
		// String pName = null;

		// pName = new
		// String(name.getBytes("ISO8859-1"),"UTF-8");//这个在后台不需要使用，调试时可以看的直观些
		if (flag == 1) {// 接受邀请，把projectDepartment表中的（邀请）状态标记status更改为 3（已加入）
			projectDepartmentService.acceptOrRefuse(pId, userId, 3, 3);// type==3
																		// status==3
		} else if (flag == 0) {// 拒绝邀请，把projectDepartment表中的（邀请）状态标记status更改为
								// 4（过往记录）
			projectDepartmentService.acceptOrRefuse(pId, userId, 3, 4);// type==3
																		// status==4
		}
		ModelAndView mav = new ModelAndView("front_equipment/equipment_invite");
		String msg = "操作成功";
		mav.addObject("msg", msg);
		return mav;
	}

	/**
	 * 个人中心--设备商-设备
	 * 
	 * @return
	 */
	@RequestMapping(value = "equipmentSupply.html")
	public ModelAndView equipmentSupply(@RequestParam(value = "pageNow", defaultValue = "1") int pageNow,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		ModelAndView mav = new ModelAndView("front_equipment/equipment_supply");
		int teamType = 3;// 1-施工班组 2-设备班组 3-设备班组
		int status = 1;// 状态 0表示关闭
		int type = 1;// 发布材料（材料求职）
		int userType = 2;// 班组
		String userId = (String) session.getAttribute("userId");
		EquipmentModel equipmentModel = equipmentService.getByUserId(userId);
		String rId = equipmentModel.getId();
		String leaderName = equipmentModel.getLeaderName();
		long dataCount = requirementsService.countSupplies(rId, leaderName, teamType, status, type, userType);
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		List<RequirementsModel> requirementsList = requirementsService.getRequirements(rId, leaderName, teamType, status, type, userType, pageNow, pageSize);
		mav.addObject("requirementsList", requirementsList);
		mav.addObject("equipmentModel", equipmentModel);
		mav.addObject("page", page);
		return mav;
	}

	/**
	 * 添加一条发布的设备信息
	 * 
	 * @param session
	 * @param supplyArea
	 * @param shopName
	 * @return
	 */
	@RequestMapping(value = "addSupply.html")
	public String addSupply(RequirementsModel requirementsModel) {
		int teamType = 3;// 1-施工班组 2-设备班组 3-设备班组
		int status = 1;// 状态 0表示关闭
		int type = 1;// 发布材料（材料求职）
		int userType = 2;// 班组
		requirementsModel.setTeamType(teamType);
		requirementsModel.setStatus(status);
		requirementsModel.setType(type);
		requirementsModel.setUserType(userType);
		requirementsService.addSupply(requirementsModel);
		return "redirect:equipmentSupply.html";
	}

	/**
	 * 更改发布的设备信息
	 * 
	 * @param session
	 * @param shopName
	 * @return
	 */
	@RequestMapping(value = "toModifySupply.html", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView modifySupply(String shopName, String rId) {
		try {
			shopName = new String(shopName.getBytes("ISO8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("front_equipment/equipment_supply");
		String userId = (String) session.getAttribute("userId");
		EquipmentModel equipmentModel = equipmentService.getByUserId(userId);
		RequirementsModel requirementsModel = requirementsService.getReqirement(shopName, rId);

		mav.addObject("equipmentModel", equipmentModel);
		mav.addObject("requirementsModel", requirementsModel);
		return mav;
	}

	@RequestMapping(value = "deleteSupply.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String deleteSupply(String id) {
		requirementsService.delById(id);
		return "redirect: equipmentSupply.html";
	}

	/**
	 * 个人中心--设备商-合作的工程项目
	 * 
	 * @return
	 */
	@RequestMapping(value = "equipmentPast.html")
	public ModelAndView equipmentProjectRecord(HttpSession session) {
		// equipmentService.getCurrentProject(session,3,3);
		// List<ProjectModel> pastList =
		// equipmentService.getCurrentProject(session,3,4);
		String userId = (String) session.getAttribute("userId");
		EquipmentModel equipmentModel = equipmentService.getByUserId(userId);
		String vId = (String) equipmentModel.getId();
		// 通过手机号在projectDepartment表中得到过往工程xl
		List<ProjectDepartmentModel> currentList = projectDepartmentService.getProjectByTIdStatus(vId, 3, 3);
		ArrayList<ProjectVo> projectVoListCur = new ArrayList<>();
		for (ProjectDepartmentModel projectDepartmentModel : currentList) {
			ProjectVo projectVo = new ProjectVo();
			ProjectModel projectModel = projectService.getById(projectDepartmentModel.getpId());
			projectVo.setProjectModel(projectModel);
			projectVo.setRemark(projectDepartmentModel.getRemark());
			projectVo.setProjectId(projectDepartmentModel.getpId());
			projectVo.setImageName(projectDepartmentModel.getImageName());
			projectVo.setvId(vId);
			projectVoListCur.add(projectVo);
		}
		ModelAndView mav = new ModelAndView("front_equipment/equipment_project");
		mav.addObject("projectVoList", projectVoListCur);
		List<ProjectDepartmentModel> pastList = projectDepartmentService.getProjectByTIdStatus(vId, 3, 4);
		ArrayList<ProjectVo> projectVoListPast = new ArrayList<>();
		for (ProjectDepartmentModel projectDepartmentModel : pastList) {
			ProjectVo projectVo = new ProjectVo();
			ProjectModel projectModel = projectService.getById(projectDepartmentModel.getpId());
			projectVo.setProjectModel(projectModel);
			projectVo.setRemark(projectDepartmentModel.getRemark());
			projectVo.setProjectId(projectDepartmentModel.getpId());
			projectVo.setImageName(projectDepartmentModel.getImageName());
			projectVo.setvId(vId);
			projectVoListPast.add(projectVo);
		}
		mav.addObject("projectVoListPast", projectVoListPast);
		return mav;
	}

	/**
	 * 合作工程上传图片 rkai
	 * 
	 * @throws ServletException
	 * @throws IOException
	 * @throws SmartUploadException
	 * 
	 */
	@RequestMapping(value = "material_uploadImage.html")
	public String uploadImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, SmartUploadException, IOException {
		// 上传图片处理
		SmartUpload mySmartUpload = new SmartUpload();
		mySmartUpload.initialize(config, request, response);
		mySmartUpload.upload();
		Files files = mySmartUpload.getFiles();
		File file = files.getFile(0);
		String oldBasePath = request.getSession().getServletContext().getRealPath("");
		@SuppressWarnings("unused")
		String basePath = oldBasePath.substring(0, oldBasePath.lastIndexOf("\\"));
		String fileExt = files.getFile(0).getFileExt().toLowerCase();
		String userId = (String) session.getAttribute(ESessionKey.UserId.key);
		Date dateCurrentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("YYMMddHHmmss");
		String currentTime = formatter.format(dateCurrentTime);
		String fileName = userId + currentTime + "." + fileExt;// 现有时间加登陆者手机号组成图片名称
		String projectId = request.getParameter("projectId");
		String filePath = IMageUploadInfo.BASEPATH.value + IMageUploadInfo.EQUIPMENTPROJECTPATH.value + projectId;
		ImageUpload imageUpload = new ImageUpload();
		imageUpload.imageUpload(file, fileName, filePath, config, request, response);
		EquipmentModel equipmentModel = equipmentService.getByUserId(userId);
		String vId = equipmentModel.getId();
		ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getModelByTidAndVid(vId, projectId);
		projectDepartmentModel.setImageName(fileName);
		projectDepartmentService.updateProjectDepartment(projectDepartmentModel);
		return "redirect: equipmentPast.html";
	}

	/**
	 * 一对一消息列表页面
	 * 
	 * @param isRead
	 * @return
	 */
	@RequestMapping(value = "equipment_message.html")
	public ModelAndView equipmentMessage(String isRead) {
		ModelAndView mav = new ModelAndView("front_equipment/equipment_message");
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		Map<String, Object> map = messageService.getShowMessageHasMap(isRead, mav, userId, UserType.EquipmentType.desc, null);
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
	 * 
	 * @param messageId
	 * @param response
	 */
	@RequestMapping(value = "equipment_messageIsRead.html", method = RequestMethod.POST)
	public void equipmentMessageIsRead(String messageId, HttpServletResponse response) {
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

	/**
	 * 消息公告列表页面
	 * 
	 * @param isRead
	 * @return
	 */
	@RequestMapping(value = "equipment_notice.html")
	public ModelAndView equipmentNotice(String isRead) {
		ModelAndView mav = new ModelAndView("front_equipment/equipment_notice");
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		Map<String, Object> map = noticeService.getShowNoticeHasMap(isRead, mav, userId, UserType.EquipmentType.desc, null);
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
	 * 
	 * @param nId
	 * @param eId
	 * @return
	 */
	@RequestMapping(value = "equipment_noticeInfo.html", method = RequestMethod.POST)
	public void equipmentNoticeInfo(String nId, String eId, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<JSONObject> jsonObjects = noticeService.getNoticeInfo(nId, eId, UserType.EquipmentType.desc, null);
		out.print(jsonObjects);
		out.flush();
		out.close();
	}

}
