package com.fengyun.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.MaterialTradModel;
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
import com.fengyun.web.service.MaterialService;
import com.fengyun.web.service.MaterialTradService;
import com.fengyun.web.service.MerchantService;
import com.fengyun.web.service.MessageService;
import com.fengyun.web.service.NoticeService;
import com.fengyun.web.service.ProjectDepartmentService;
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
 * 
 * @author zhengss
 * 
 */
@Controller
@RequestMapping(value = "material")
public class FrontMaterialController {

	@Autowired
	public HttpSession session;

	@Autowired
	private MaterialService materialService;

	@Autowired
	private CommentsService commentsService;

	@Autowired
	private MerchantService merchantService;

	@Autowired
	private MaterialTradService materialTradService;

	@Autowired
	private RequirementsService requirementsService;

	@Autowired
	private ProjectDepartmentService projectDepartmentService;

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
	 * 个人中心--材料商-信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "info.html")
	public ModelAndView toMaterialInfo() {
		System.out.println("进入material");
		ModelAndView mav = new ModelAndView("front_material/material_info");
		String userId = (String) session.getAttribute("userId");
		MaterialModel materialModel = materialService.getByUserId(userId);
		mav.addObject("materialModel", materialModel);
		return mav;
	}

	/**
	 * 更新用户信息
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "updateInfo.html")
	public ModelAndView modifyInfo(MaterialModel model) {
		ModelAndView mav = new ModelAndView("front_material/material_info");

		String userId = (String) session.getAttribute("userId");
		MaterialModel materialModel = materialService.getByUserId(userId);
		MerchantModel merchantModel = merchantService.getByUserId(userId);
		if (StringUtils.isNotBlank(model.getEstablishDate())) {
			materialModel.setEstablishDate(model.getEstablishDate());
			merchantModel.setBuild(model.getEstablishDate());
		}
		if (StringUtils.isNotBlank(model.getLicence())) {
			materialModel.setLicence(model.getLicence());
			// 【个人信息-社会统一信用代码】和【诚信档案-社会统一信用代码】 不在同一个表中，
			// 更新一边时，要同时在代码中更新另一边以保持数据统一性。
			if (merchantModel != null) {
				merchantModel.setlicence(model.getLicence());
			}
		}

		if (StringUtils.isNotBlank(model.getName())) {
			materialModel.setName(model.getName());
		}

		if (StringUtils.isNotBlank(model.getShopName())) {
			materialModel.setShopName(model.getShopName());
		}

		if (StringUtils.isNotBlank(model.getLeaderName())) {
			materialModel.setLeaderName(model.getLeaderName());
		}

		if (StringUtils.isNotBlank(model.getLicence())) {
			materialModel.setLicence(model.getLicence());
		}

		if (StringUtils.isNotBlank(model.getRegcapital())) {
			materialModel.setRegcapital(model.getRegcapital());

			if (merchantModel != null) {
				merchantModel.setRegistercapital(model.getRegcapital());
			}
		}
		
		if (StringUtils.isNotBlank(model.getProvince())) {
			materialModel.setProvince(model.getProvince());
		}

		if (StringUtils.isNotBlank(model.getCity())) {
			materialModel.setCity(model.getCity());
		}
		if (StringUtils.isNotBlank(model.getStreet())) {
			materialModel.setStreet(model.getStreet());
		}

		if (StringUtils.isNotBlank(model.getUserId())) {
			materialModel.setUserId(model.getUserId());
		}

		materialModel.setScore(model.getScore());
		merchantService.updateMerchant(merchantModel);
		materialService.updateMaterial(materialModel);
		mav.addObject("materialModel", materialModel);
		return mav;
	}

	/**
	 * 个人中心--材料商-修改密码
	 * 
	 * @return
	 */
	@RequestMapping(value = "materialModifyPassword.html")
	public ModelAndView modifyPassword() {
		System.out.println("进入material");
		ModelAndView mav = new ModelAndView("front_material/material_modifypassword");

		return mav;
	}

	/**
	 * 个人中心--材料商-修改密码下一步
	 * 
	 * @return
	 */
	/*
	 * @RequestMapping(value="materialPasswordNext.html") public ModelAndView
	 * passwordNext(){ System.out.println("进入material"); ModelAndView mav = new
	 * ModelAndView("front_material/material_passwordnext");
	 * 
	 * return mav; }
	 */

	/**
	 * 修改材料商密码
	 * 
	 * @author rkai
	 * @param userId
	 * @param password
	 * @param response
	 */
	@RequestMapping(value = "modifyPassword.html")
	public String modifyMaterialPassword(String userId, String password) throws IOException {
		// 向service中查询出用户是否存在，如果存在返回 用户对象
		UserModel model = userService.getByUserId(userId);
		model.setUserPassword(password);
		userService.updateUser(model);
		return "redirect:info.html";
	}

	/**
	 * 个人中心--材料商-诚信档案
	 * 
	 * @return
	 */
	@RequestMapping(value = "materialFile.html")
	public ModelAndView materialFile(HttpSession session) {
		ModelAndView mav = new ModelAndView("front_material/material_file");
		String userId = (String) session.getAttribute("userId");
		String tp = (String) session.getAttribute("type");
		int type = Integer.valueOf(tp);
		MaterialModel materialModel = materialService.getByUserId(userId);
		MerchantModel merchantModel = null;
		// if(materialModel.getCode()!=null){
		// 注册为材料商班组以后未经审核时material表中没有code数据，需要人工审核添加code和其他信息。
		merchantModel = merchantService.getByUserId(userId);// userId对应merchant中的mobile
		// }
		List<CommentsModel> comments = commentsService.getListByIdAndType(userId, type);
		mav.addObject("materialModel", materialModel);
		mav.addObject("merchantModel", merchantModel);
		mav.addObject("comments", comments);
		return mav;
	}

	/**
	 * 更新诚信档案
	 * 
	 * @param session
	 * @param merchantModel
	 * @return
	 */
	@RequestMapping(value = "updateMerchant.html")
	public String updateFile(MerchantModel merchantModel) {
		merchantService.updateMerchant(merchantModel);
		return "redirect:materialFile.html";
	}

	/**
	 * 个人中心--材料商-出库记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "materialLog.html")
	public ModelAndView materialLog(String pName, String year, String month, String export, HttpServletResponse response,
			@RequestParam(value = "pageNow", defaultValue = "1") int pageNow, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		// materialTradService.addMaterialTrad("57fb014fcdf0098b95443e81",
		// "57e8bdcafe169e076ad087b8",
		// "广州烨阳建材有限公司", "深圳湾创新科技中心", "PUC", "周方同", "2016", "10", "12",
		// "20160810", "1000", "20000",
		// 10000, 50000, 62232, 45632, "发票号", "备注", "刘梅", "银行转账",
		// "流水号：1231654613");
		ModelAndView mav = new ModelAndView("front_material/material_log");
		MaterialModel materialModel = materialService.getByUserId((String) session.getAttribute("userId"));
		String mId = materialModel.getId();
		Long dataCount = materialTradService.countMaterialTrad(pName, year, month, mId);
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		List<MaterialTradModel> materialTradModelList = materialTradService.getMaterialTradList(pName, year, month, mId, page);
		mav.addObject("materialTradModelList", materialTradModelList);
		MaterialTradModel model = null;
		if (materialTradModelList.size() > 0) {
			model = materialTradModelList.get(0);
		}
		String mName = null;
		if (model != null) {
			mName = model.getmName();
		}
		// 回显
		mav.addObject("year", year);
		mav.addObject("month", month);
		mav.addObject("pName", pName);
		mav.addObject("mName", mName);
		mav.addObject("page", page);
		String[] Title = { "项目名称", "材料名称", "经办人", "出库日期", "出库量", "累计出库", "本次付款", "累计付款", "其他款", "余款", "发票", "备注", "付款人", "付款方式", "流水号" };// 导出excel的表头
		String fileName = mName + "-出入库记录"; // 导出excel的文件名
		String[] dateFieldNames = {}; // 需要转换时间格式的字段的名字数组
		int[] needIndex = { 4, 5, 6, 7, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };
		if ("1".equals(export)) {
			try {
				ExportExcel.recoredExportExcel(response, "materialTrad", Title, fileName, needIndex, materialTradModelList, dateFieldNames);
			} catch (WriteException | IOException e) {
				e.printStackTrace();
			}
		}
		return mav;
	}

	/**
	 * 个人中心--材料商-申请加入项目
	 * 
	 * @return
	 */
	@RequestMapping(value = "materialJoinProject.html")
	public ModelAndView materialJoinProject(String province, String city, String name, String leaderName,
			@RequestParam(value = "pageNow", defaultValue = "1") int pageNow, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		// 通过requirements表中的type=2（招聘）和userType=3(1-个人 2-班组 3-项目)
		// teamType=2(1-施工班组 2-材料班组 3-设备班组) ,status=1(1招聘信息开放 0表示关闭)【分页】
		// 查询正在招聘的所有的项目
		int type = 2, userType = 3, teamType = 2, status = 1;
		long count = requirementsService.count(type, userType, teamType, status, province, city, name, leaderName);
		Page page = PageHandler.getPage(pageSize, pageNow, count);
		List<RequirementsModel> requirementList = requirementsService.getRequirement(page, type, userType, teamType, status, province, city, name, leaderName);
		MaterialModel materialModel = materialService.getByUserId((String) session.getAttribute("userId"));
		ModelAndView mav = new ModelAndView("front_material/material_joinproject");
		// 查询【历史申请明细】 和 【正在申请】 的项目 参数：项目id、status=4（已离开或结束）（type=2 ）
		String mId = materialModel.getId();
		Map<ProjectModel, ProjectDepartmentModel> mapPast = getApplyInfoInMap(mId, 2, 4);
		Map<ProjectModel, ProjectDepartmentModel> mapCur = getApplyInfoInMap(mId, 2, 1);
		mav.addObject("requirementList", requirementList); // 发布了招聘信息的【项目列表】
		mav.addObject("materialModel", materialModel);// 当前【材料商信息】
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
	 *            材料商id
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
	 * 个人中心--材料商-邀请列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "materialInvite.html")
	public ModelAndView materialInvite(HttpSession session) {
		ModelAndView mav = new ModelAndView("front_material/material_invite");
		// 通过Session取得userId
		String userId = (String) session.getAttribute("userId");
		// 通过userId到material表中查到材料商Id
		MaterialModel mModel = materialService.getByUserId(userId);
		// 通过材料商id和status==2到Projectdepartment表中查询出邀请当前用户材料商的项目管理碰到ModelList
		// 使用项目ModelList(中的pId到项目中查出邀请我的项目列表)
		int type = 2;// 班组类型：1-班组 2-材料 3-设备
		int status = 2;// 状态--1申请中，2邀请中 3-已加入 4-已结束或离开
		List<ProjectModel> projectList = projectDepartmentService.getProjectInvatationList(mModel.getId(), type, status);
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
		// String pName;
		// pName = new String(name.getBytes("ISO8859-1"),"UTF-8");
		if (flag == 1) {// 接受邀请，把projectDepartment表中的（邀请）状态标记status更改为 3（已加入）
			projectDepartmentService.acceptOrRefuse(pId, userId, 2, 3);
		} else if (flag == 0) {// 拒绝邀请，把projectDepartment表中的（邀请）状态标记status更改为
								// 4（过往记录）
			projectDepartmentService.acceptOrRefuse(pId, userId, 2, 4);
		}
		ModelAndView mav = new ModelAndView("front_material/material_invite");
		String msg = "操作成功";
		mav.addObject("msg", msg);
		return mav;
	}

	/**
	 * 个人中心--材料商-材料供应
	 * 
	 * @return
	 */
	@RequestMapping(value = "materialSupply.html")
	public ModelAndView materialSupply(@RequestParam(value = "pageNow", defaultValue = "1") int pageNow,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		ModelAndView mav = new ModelAndView("front_material/material_supply");
		int teamType = 2;// 1-施工班组 2-材料班组 3-设备班组
		int status = 1;// 状态 0表示关闭
		int type = 1;// 发布材料（材料求职）
		int userType = 2;// 班组
		String userId = (String) session.getAttribute("userId");
		MaterialModel materialModel = materialService.getByUserId(userId);
		String rId = materialModel.getId();
		String leaderName = materialModel.getLeaderName();
		long dataCount = requirementsService.countSupplies(rId, leaderName, teamType, status, type, userType);
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		List<RequirementsModel> requirementsList = requirementsService.getRequirements(rId, leaderName, teamType, status, type, userType, pageNow, pageSize);
		mav.addObject("requirementsList", requirementsList);
		mav.addObject("materialModel", materialModel);
		mav.addObject("page", page);
		return mav;
	}

	/**
	 * 添加一条发布的材料供应信息
	 * 
	 * @param session
	 * @param supplyArea
	 * @param shopName
	 * @return
	 */
	@RequestMapping(value = "addSupply.html")
	public String addSupply(RequirementsModel requirementsModel) {
		int teamType = 2;// 1-施工班组 2-材料班组 3-设备班组
		int status = 1;// 状态 0表示关闭
		int type = 1;// 发布材料（材料求职）
		int userType = 2;// 班组
		requirementsModel.setTeamType(teamType);
		requirementsModel.setStatus(status);
		requirementsModel.setType(type);
		requirementsModel.setUserType(userType);
		requirementsService.addSupply(requirementsModel);
		return "redirect:materialSupply.html";
	}

	/**
	 * 更改发布的材料供应信息
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
		ModelAndView mav = new ModelAndView("front_material/material_supply");
		String userId = (String) session.getAttribute("userId");
		MaterialModel materialModel = materialService.getByUserId(userId);
		RequirementsModel requirementsModel = requirementsService.getReqirement(shopName, rId);
		mav.addObject("materialModel", materialModel);
		mav.addObject("requirementsModel", requirementsModel);
		return mav;
	}

	/**
	 * 删除一条记录
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteSupply.html", method = { RequestMethod.POST, RequestMethod.GET })
	public String deleteSupply(String id) {
		requirementsService.delById(id);
		return "redirect: materialSupply.html";
	}

	/**
	 * 合作的工程项目 rkai
	 * 
	 * @return
	 */
	@RequestMapping(value = "materialPast.html")
	public ModelAndView materialProjectRecord(HttpSession session) {
		List<ProjectModel> currentList = materialService.getCurrentProject(session, 2, 3);
		List<ProjectVo> projectVotList = new ArrayList<ProjectVo>();
		String userId = (String) session.getAttribute("userId");
		MaterialModel materialModel = materialService.getByUserId(userId);
		String vId = materialModel.getId();
		Iterator<ProjectModel> it = currentList.iterator();
		while (it.hasNext()) {
			ProjectModel projectModel = it.next();
			String pId = projectModel.getId();
			ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getModelByTidAndVid(vId, pId);
			ProjectVo projectVo = new ProjectVo();
			projectVo.setImageName(projectDepartmentModel.getImageName());
			projectVo.setRemark(projectDepartmentModel.getRemark());
			projectVo.setProjectModel(projectModel);
			projectVotList.add(projectVo);
		}
		List<ProjectModel> pastList = materialService.getCurrentProject(session, 2, 4);
		ModelAndView mav = new ModelAndView("front_material/material_project");
		mav.addObject("projectVotList", projectVotList);
		mav.addObject("pastList", pastList);
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
		System.out.println("projectId:" + projectId);
		// String filePath=basePath+"\\images\\front_material\\"+projectId;
		String filePath = IMageUploadInfo.BASEPATH.value + IMageUploadInfo.MATERIALPROJECTPATH.value + projectId;
		ImageUpload imageUpload = new ImageUpload();
		imageUpload.imageUpload(file, fileName, filePath, config, request, response);
		MaterialModel materialModel = materialService.getByUserId(userId);
		String vId = materialModel.getId();
		ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getModelByTidAndVid(vId, projectId);
		projectDepartmentModel.setImageName(fileName);
		projectDepartmentService.updateProjectDepartment(projectDepartmentModel);
		return "redirect: materialPast.html";
	}

	/**
	 * 一对一消息列表页面
	 * 
	 * @param isRead
	 * @return
	 */
	@RequestMapping(value = "material_message.html")
	public ModelAndView materialMessage(String isRead) {
		ModelAndView mav = new ModelAndView("front_material/material_message");
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		Map<String, Object> map = messageService.getShowMessageHasMap(isRead, mav, userId, UserType.MaterialType.desc, null);
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
	@RequestMapping(value = "material_messageIsRead.html", method = RequestMethod.POST)
	public void materialMessageIsRead(String messageId, HttpServletResponse response) {
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
	@RequestMapping(value = "material_notice.html")
	public ModelAndView materialNotice(String isRead) {
		ModelAndView mav = new ModelAndView("front_material/material_notice");
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		Map<String, Object> map = noticeService.getShowNoticeHasMap(isRead, mav, userId, UserType.MaterialType.desc, null);
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
	 * @param mId
	 * @return
	 */
	@RequestMapping(value = "material_noticeInfo.html", method = RequestMethod.POST)
	public void materialNoticeInfo(String nId, String mId, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<JSONObject> jsonObjects = noticeService.getNoticeInfo(nId, mId, UserType.MaterialType.desc, null);
		out.print(jsonObjects);
		out.flush();
		out.close();
	}

}
