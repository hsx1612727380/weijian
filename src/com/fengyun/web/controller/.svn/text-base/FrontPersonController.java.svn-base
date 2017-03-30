package com.fengyun.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.write.WriteException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.cache.page.PageHandler;
import com.fengyun.web.db.playermodel.AccrecordModel;
import com.fengyun.web.db.playermodel.AttendanceInfoModel;
import com.fengyun.web.db.playermodel.CommentsModel;
import com.fengyun.web.db.playermodel.CompanyModel;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.MessageModel;
import com.fengyun.web.db.playermodel.NoticeLogModel;
import com.fengyun.web.db.playermodel.NoticeModel;
import com.fengyun.web.db.playermodel.PayrollRecordModel;
import com.fengyun.web.db.playermodel.PersonModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.RequirementsModel;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.db.vo.SkillVo;
import com.fengyun.web.hardcode.ESessionKey;
import com.fengyun.web.hardcode.ETeamSkillSmallType;
import com.fengyun.web.hardcode.IMageUploadInfo;
import com.fengyun.web.hardcode.UserType;
import com.fengyun.web.service.AccrecordService;
import com.fengyun.web.service.AttendanceInfoService;
import com.fengyun.web.service.CommentsService;
import com.fengyun.web.service.CompanyService;
import com.fengyun.web.service.EquipmentService;
import com.fengyun.web.service.MaterialService;
import com.fengyun.web.service.NoticeService;
import com.fengyun.web.service.NoticeLogService;
import com.fengyun.web.service.PayrollRecordService;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.RequirementsService;
import com.fengyun.web.service.TeamMemberService;
import com.fengyun.web.service.TeamService;
import com.fengyun.web.service.UserService;
import com.fengyun.web.service.MessageService;
import com.fengyun.web.service.impl.TeamServicelmpl.ApplyIng;
import com.fengyun.web.util.ExportExcel;
import com.fengyun.web.util.ImageUpload;
import com.fengyun.web.util.NoRepeateSubmit;
import com.fengyun.web.util.PublicMethod;
import com.google.gson.Gson;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.mongodb.BasicDBObject;

/**
 * 前台用户个人中心 controller
 * 
 * @author zheng
 * 
 */
@Controller
public class FrontPersonController {

	@Autowired
	private UserService userService;

	@Autowired
	private ServletConfig config;

	@Autowired
	private PayrollRecordService payrollRecordService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private CommentsService commentsService;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private TeamService teamService;

	@Autowired
	private AttendanceInfoService attendanceInfoService;

	@Autowired
	private RequirementsService requirementsService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private TeamMemberService teamMemberService;

	@Autowired
	private AccrecordService accrecordService;

	@Autowired
	private PersonService personService;

	@Autowired
	private MaterialService materialService;

	@Autowired
	private EquipmentService equipmentService;

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private NoticeLogService noticeLogService;

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private ProjectDepartmentService projectDepartmentService;
	/**
	 * 个人中心信息 -- 个人信息
	 * 
	 * @author
	 * @return
	 */
	@RequestMapping(value = "person.html")
	public ModelAndView toUserInfo(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("index");
		String userType = (String) request.getSession().getAttribute(ESessionKey.UserType.key);
		if (org.apache.commons.lang.StringUtils.isNotBlank(userType)) {
			String userId = null;
			// 跳转公司页面
			if (userType.equals("3")) {
				userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
				mav = new ModelAndView("front_company/company");
				CompanyModel companyModel = companyService.getByUserId(userId);
				request.getSession().setAttribute(ESessionKey.ProjectId.key, companyModel.getId());
				if (companyModel != null) {
					mav.addObject("companyModel", companyModel);
				}
				// 项目负责人
			} else if (userType.equals("4")) {
				mav = new ModelAndView("operate/operate");
				userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
				ProjectModel projectModel = projectService.getProjectByUserId(userId);
				request.getSession().setAttribute(ESessionKey.ProjectId.key, projectModel.getId());
				if (projectModel != null) {
					mav.addObject("projectModel", projectModel);
				}
				// 材料商和设备商两种情况没有在这里处理。
			} else if ("1".equals(userType)) {// 跳转材料商个人中心
				System.out.println("userType=" + userType);
				// mav = new ModelAndView("front_material/material_info");
				mav = new ModelAndView(new RedirectView("material/info.html"));
				userId = (String) request.getSession().getAttribute("userId");
				MaterialModel materialModel = materialService.getByUserId(userId);
				mav.addObject("materialModel", materialModel);
			} else if ("2".equals(userType)) {// 跳转设备商个人中心
				System.out.println("userType=" + userType);
				// mav = new ModelAndView("front_material/material_info");
				// 重定向到新地址
				mav = new ModelAndView(new RedirectView("equipment/info.html"));
				userId = (String) request.getSession().getAttribute("userId");
				EquipmentModel equipmentModel = equipmentService.getByUserId(userId);
				mav.addObject("equipmentModel", equipmentModel);
				// 劳务班组、工人
			} else if ("0".equals(userType)) {
				userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
				UserModel model = userService.getByUserId(userId);
				mav = new ModelAndView("/front_person/person_info");
				String isLeader = (String) session.getAttribute(ESessionKey.IsLeader.key); //0个人用户 、1是班组长、2班组成员
				//查询已经加入的项目名称
				String projectName = userService.getInvolvedProjectName(userId,isLeader);
				// 个人评价
				List<CommentsModel> comments = commentsService.getListByIdAndType(userId, 1);
				mav.addObject("model", model);
				mav.addObject("comments", comments);
				mav.addObject("projectName", projectName);
			}
			Map<String, String> map = noticeService.getNMCount(userId);
			request.getSession().setAttribute("count", map.get("count"));
			request.getSession().setAttribute("unReadMessageCount", map.get("unReadMessageCount"));
			request.getSession().setAttribute("readMessageCount", map.get("readMessageCount"));
			request.getSession().setAttribute("unReadNoticeCount", map.get("unReadNoticeCount"));
			request.getSession().setAttribute("readNoticeCount", map.get("readNoticeCount"));
		}
		return mav;
	}

	/**
	 * 跳转修改密码页面
	 * 
	 * @author rkai
	 * @return
	 */
	@RequestMapping(value = "modifyPassForm.html")
	public ModelAndView modifyPersonPassword() {
		ModelAndView mav = new ModelAndView("front_person/person_modifypassword");
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		UserModel model = userService.getByUserId(userId);
		mav.addObject("model", model);
		return mav;
	}

	/**
	 * 修改个人用户密码
	 * 
	 * @author rkai
	 * @param userId
	 * @param password
	 * @param response
	 */
	@RequestMapping(value = "modifyPassword.html")
	public String modifyPassword(String password, String userId) throws IOException {
		// 向service中查询出用户是否存在，如果存在返回 用户对象

		UserModel model = userService.getByUserId(userId);
		model.setUserPassword(password);
		userService.updateUser(model);
		return "redirect:/person.html";
	}

	/**
	 * 验证密码是否正确
	 * 
	 * @author rkai
	 */
	@RequestMapping(value = "chenkPassword.html", method = RequestMethod.POST)
	public void chenkPassword(String userId, String password, HttpServletResponse response) throws IOException {
		// 向service中查询出用户是否存在，如果存在返回 用户对象
		String str = "1";
		Object obj = userService.checkLogonByPhone(userId, password);
		if (obj == null)
			str = "0";
		PublicMethod.stringToWeb(str, response);
	}

	/**
	 * 个人资料修改
	 * 
	 * @author rkai
	 * @param userId
	 * @param password
	 * @param response
	 * @throws ServletException
	 * @throws SmartUploadException
	 */
	@RequestMapping(value = "personModify.html")
	public String personModify(HttpServletResponse response) throws IOException, ServletException, SmartUploadException {
		SmartUpload mySmartUpload = new SmartUpload();
		mySmartUpload.initialize(config, request, response);
		mySmartUpload.upload();
		String userId = mySmartUpload.getRequest().getParameter("userId");
		String userName = new String(mySmartUpload.getRequest().getParameter("userName").getBytes(), "utf-8");
		System.out.println("userName:" + userName);
		// mySmartUpload.getRequest().getParameter("userName");
		String userProvince = mySmartUpload.getRequest().getParameter("province");
		String userCity = mySmartUpload.getRequest().getParameter("userCity");
		String userStreet = mySmartUpload.getRequest().getParameter("userStreet");
		String userStatus = mySmartUpload.getRequest().getParameter("userStatus");
		String userIdentity = mySmartUpload.getRequest().getParameter("userIdentity");
		int age = Integer.valueOf(mySmartUpload.getRequest().getParameter("age"));
		String userSex = mySmartUpload.getRequest().getParameter("userSex");
		int skillBigType = Integer.valueOf(mySmartUpload.getRequest().getParameter("skillBigType"));
		int skillSmallType = Integer.valueOf(mySmartUpload.getRequest().getParameter("skillSmallType"));
		UserModel model = userService.getByUserId(userId);
		// 上传图片处理
		Files files = mySmartUpload.getFiles();
		String fileName = null;
		if (files.getSize() > 0) {
			File file = files.getFile(0);
			String countyCode = userIdentity.substring(0, 4);
			String filePath = IMageUploadInfo.BASEPATH.value + IMageUploadInfo.PERSONITENDITYBASEPATH.value + countyCode;
			fileName = userIdentity + "." + file.getFileExt().toLowerCase();// 身份证名称构成图片名称
			System.out.println("file.getFileExt():" + file.getFileExt().toLowerCase());
			ImageUpload imageUpload = new ImageUpload();
			imageUpload.imageUpload(file, fileName, filePath, config, request, response);
		}
		model.setUserName(userName);
		model.setUserStatus(userStatus);
		model.setAge(age);
		model.setUserSex(userSex);
		/*
		 * if (userCity != "" && userCity != null) {
		 * model.setUserProvince(userProvince); model.setUserCity(userCity);
		 * model.setUserStreet(userStreet); // if
		 * (!userCity.equals("")&&!userCity.equals(null)) { }
		 */
		if (userCity != null && !"".equals(userCity)) {
			model.setUserProvince(userProvince);
			model.setUserCity(userCity);
			model.setUserStreet(userStreet);
		}
		if (fileName != null) {
			model.setIdentityImageName(fileName);
			System.out.println(model.getIdentityImageName());
		}
		model.setUserIdentity(userIdentity);
		model.setSkillBigType(skillBigType);
		model.setSkillSmallType(skillSmallType);
		userService.updateUser(model);
		return "redirect:/person.html";
	}

	/**
	 * 跳转到申请班组页面
	 * 
	 * @author rkai mayu
	 * @return
	 */
	@RequestMapping(value = "personApplyTeamForm.html")
	public ModelAndView personApplyTeamForm(@RequestParam(value = "pageNow", defaultValue = "1") int pageNow,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize, @RequestParam(value = "dataCount", defaultValue = "0") int dataCount,
			@RequestParam(value = "pageCount", defaultValue = "0") int pageCount, HttpServletResponse resp) {
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		ModelAndView mav = new ModelAndView("/front_person/person_applyTeam");
		// 查询需求表，tyep=2,userType=2,status=1 @author mayu
		BasicDBObject obj = new BasicDBObject(4);
		obj.put("type", 2);
		obj.put("status", 1);
		obj.put("userType", 2);
		obj.put("teamType", 1);
		if (dataCount == 0) {
			dataCount = (int) requirementsService.countAll(obj);
		}
		// teamMemberService.countUserIdByStatu
		int existBl = teamService.countUserIdByStatus(userId, 3);
		mav.addObject("existBl", existBl);
		List<RequirementsModel> requiList = requirementsService.getList(obj, pageNow, pageSize);
		List<Map<String, Object>> supplyList = new ArrayList<Map<String, Object>>();
		for (RequirementsModel requireModel : requiList) {
			Map<String, Object> map = new HashMap<String, Object>();
			String teamId = requireModel.getrId();
			TeamModel teamModel = teamService.getTeamById(teamId);
			map.put("teamModel", teamModel);
			int status = teamService.findMemberStatus(teamId, userId);
			map.put("requireModel", requireModel);
			map.put("status", status);
			supplyList.add(map);
		}
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		pageCount = (dataCount % pageSize == 0) ? (dataCount / pageSize) : (dataCount / pageSize + 1);
		page.setPageCount(pageCount);
		mav.addObject("page", page);
		mav.addObject("tlist", supplyList);
		return mav;
	}

	/**
	 * 申请加入班组
	 * 
	 * @author rkai
	 * @return
	 */
	@RequestMapping(value = "personApplyTeam.html")
	public String personApplyTeam(String id, String userId, HttpServletResponse resp) {
		// int status = teamService.findMemberStatus(id, userId);
		// if (status == 0) {
		// status = 1;
		// teamService.addTeamMember(id, userId, status);
		// }
		// return null;
		System.out.println("id:" + id);
		System.out.println("userId:" + userId);
		TeamMemberModel tmModel = teamService.getTeamMemberByUserIdAndTId(userId, id);
		if (tmModel == null) {
			teamService.addTeamMember(id, userId, 1);
		} else {
			tmModel.setStatus(1);
			teamService.passTeamMember(tmModel.getId(), 1);
		}
		return null;
	}

	/**
	 * 正在申请的班组
	 */
	@RequestMapping(value = "personApplyIng.html")
	public void personApplyIng(@RequestParam(value = "pageNow", defaultValue = "1") int pageNow,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize, @RequestParam(value = "dataCount", defaultValue = "0") int dataCount,
			@RequestParam(value = "pageCount", defaultValue = "0") int pageCount, String userId, HttpServletResponse response) throws IOException {
		List<TeamMemberModel> teamMemberList = teamMemberService.getByTeamMemberIdAndStatus(userId, 1);
		List<Map<String, Object>> tlist = new ArrayList<>();
		for (TeamMemberModel teamMemberModel : teamMemberList) {
			Map<String, Object> map = new HashMap<String, Object>();
			TeamModel teamModel = teamService.getTeamById(teamMemberModel.gettId());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String createTime = formatter.format(teamMemberModel.getCreateTime());
			String teamMemberId = teamMemberModel.getId();
			map.put("createTime", createTime);
			map.put("teamModel", teamModel);
			map.put("teamMemberId", teamMemberId);
			tlist.add(map);
		}
		PublicMethod.objectToJson(tlist, response);
	}

	/*
	
	*//**
	 * 历史申请的班组
	 * 
	 * @author rkai
	 */
	/*
	 * @RequestMapping(value = "personApplyed.html") public void personApplyed(
	 * 
	 * @RequestParam(value = "pageNow", defaultValue = "1") int pageNow,
	 * 
	 * @RequestParam(value = "pageSize", defaultValue = "2") int pageSize,
	 * 
	 * @RequestParam(value = "dataCount", defaultValue = "0") int dataCount,
	 * 
	 * @RequestParam(value = "pageCount", defaultValue = "0") int pageCount,
	 * String userId, HttpServletResponse response) throws IOException {
	 * List<ApplyIng> tlist = teamService.personApply(userId, 4, pageSize,
	 * pageNow); if (dataCount == 0) { dataCount =
	 * teamService.countUserIdByStatus(userId, 2); } if (dataCount % pageSize ==
	 * 0) pageCount = dataCount / pageSize; else pageCount = dataCount /
	 * pageSize + 1; Page page = PageHandler.getPage(pageSize, pageNow,
	 * dataCount); page.setPageCount(pageCount);
	 * PublicMethod.objectToJson(tlist, response); }
	 */

	/**
	 * 邀請的班组
	 * 
	 * @author rkai
	 */
	@RequestMapping(value = "personInvite.html")
	public ModelAndView personTeamInvite(@RequestParam(value = "pageNow", defaultValue = "1") int pageNow,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize, @RequestParam(value = "dataCount", defaultValue = "0") int dataCount,
			@RequestParam(value = "pageCount", defaultValue = "0") int pageCount) throws IOException {
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		List<ApplyIng> tlist = teamService.personApply(userId, 2, pageSize, pageNow);
		ModelAndView mav = new ModelAndView("front_person/person_invite");
		if (dataCount == 0) {
			dataCount = teamService.countUserIdByStatus(userId, 2);
		}
		if (dataCount % pageSize == 0)
			pageCount = dataCount / pageSize;
		else
			pageCount = dataCount / pageSize + 1;
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		page.setPageCount(pageCount);
		mav.addObject("tlist", tlist);
		mav.addObject("tlist", tlist);
		mav.addObject("page", page);
		return mav;
	}

	/**
	 * 工人同意接受班组邀请@author rkai  
	 * 接受邀请的时候 将teamMember中的status状态改成已加入班组状态status=3  --zss
	 */
	@RequestMapping(value = "passInveite.html")
	public void passTeamMember(String teamMemberId, HttpServletResponse response) throws IOException {
		Boolean b = teamService.passTeamMember(teamMemberId, 3);
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		UserModel userModel = userService.getByUserId(userId);
		userModel.setUserStatus("2");
		userService.updateUser(userModel);
		TeamMemberModel teamMemberModel = teamMemberService.getByUserId(userId);
		teamMemberModel.setStatus(3);
		teamMemberService.updateStatus(teamMemberModel);
		//同时将session中的isLeader改成2（已加入班组的非班组长）
		request.getSession().setAttribute(ESessionKey.IsLeader.key, "2");
		PublicMethod.objectToJson(b, response);
	}

	/**
	 * 拒绝班组的邀请 撤销申请 rkai
	 * 
	 * @param teamMemberId
	 * @throws IOException
	 */
	@RequestMapping(value = "rejectInvite.html")
	public String rejectInvite(String teamMemberId) throws IOException {
		teamService.rejectInvite(teamMemberId);
		return "redirect:/personApplyTeamForm.html";
	}

	/**
	 * 个人中心 -- 班组 zss
	 * 
	 * @return
	 */
	@RequestMapping(value = "personGroup.html")
	public ModelAndView personGroup(HttpSession session, String msg) {
		ModelAndView mav = new ModelAndView("front_person/person_group");
		// 从session中获取登录用户的信息
		String type = (String) session.getAttribute("type");
		String userId = (String) session.getAttribute("userId");
		System.out.println("用户type:" + type + "  userId:" + userId);

		TeamModel teamModel = teamService.getTeamInfoByUserId(userId);
		String tId = null;
		if (teamModel != null) {
			tId = teamModel.getId();
		}
		List<UserModel> uerModelList = teamService.getTeamMemberListBytId(tId);
		mav.addObject("teamModel", teamModel);
		mav.addObject("uerModelList", uerModelList);
		mav.addObject("msg", msg);
		return mav;
	}

	/**
	 * 班组长踢人（移除班组）
	 * 
	 * @param session
	 * @param userId
	 *            要被踢出班组的userId
	 */
	@RequestMapping(value = "deleteMember")
	public String deleteMember(HttpSession session, String userId, HttpServletResponse response) {
		String leaderUserId = String.valueOf(session.getAttribute("userId"));
		TeamModel teamModel = teamService.getTeamInfoByUserId(leaderUserId);
		// 踢人（删除班组中的userId这个用户）
		// 首先判断是否是班组长，不是班组长才能移出班组
		TeamModel isleaderMobile = teamService.getTeamByLeaderMobile(userId);
		String msg = "移出成功！";
		if (isleaderMobile == null) {
			teamService.delTeamMember(teamModel.getId(), userId);
		}
		// 转发到查询班组成员方法
		return "forward:personGroup.html?msg=班组长不能把自己移出班组！";
	}

	/**
	 * author zss 翻页查询当前班组的出勤信息列表 （复用该方法）
	 * 
	 * @return
	 */
	@RequestMapping(value = "personAttendance.html")
	public ModelAndView personAttendance(HttpSession session, HttpServletResponse response, String name, String pName, String startDate, String endDate,
			@RequestParam(value = "pageNow", defaultValue = "1") int pageNow, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, String export) {
		System.out.println("进来personAttendance方法接收的参数：" + name + " " + startDate + " " + endDate);
		ModelAndView mav = new ModelAndView("front_person/person_attendance");
		String teamCode = String.valueOf(session.getAttribute("teamCode"));
		// 根据班组号查询出班组名称 (通过modelAndView发回页面)
		String teamName = teamService.getTeamNameByCode(teamCode);
		// attendanceInfoService.addAttendanceInfo("80005", "18910012002",
		// "90001", "20160812103000", "20160812183000", 1, teamName, 600.5);
		// 根据班组号和查询条件 查询到当前班组的出勤记录数
		long dataCount = attendanceInfoService.countAttendanceInfo(teamCode, pName, name, startDate, endDate);
		// 创建一个分页page对象
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		// 根据用户所在班组号 分页查询班组出勤信息列表（每页默认显示10条）
		List<AttendanceInfoModel> attendanceList = attendanceInfoService.getAtdInfoListByPage(teamCode, page.getPageNow(), page.getPageSize(), pName, name,
				startDate, endDate);
		List<AttendanceInfoModel> attendanceInfoList = attendanceInfoService.getAtdInfoList(attendanceList);
		mav.addObject("teamName", teamName);
		mav.addObject("page", page);
		mav.addObject("attendanceInfoList", attendanceInfoList);

		String[] Title = { "项目名称", "姓名", "工人电话", "开始日期", "结束日期", "工时", "确认与否" }; // 导出excel的表头
		String fileName = teamName + "--考勤记录"; // 导出excel的文件名
		String[] dateFieldNames = { "endDate", "startDate" }; // 需要转换时间格式的字段的名字数组
																// */
		int[] needIndex = { 9, 2, 3, 5, 6, 8, 7 };
		if ("1".equals(export)) {
			try {
				ExportExcel.recoredExportExcel(response, "AttendanceInfo", Title, fileName, needIndex, attendanceInfoList, dateFieldNames);
			} catch (WriteException | IOException e) {
				e.printStackTrace();
			}
		}

		// 查询表单数据回显
		mav.addObject("name", name);
		mav.addObject("pName", pName);
		mav.addObject("endDate", endDate);
		mav.addObject("startDate", startDate);
		return mav;
	}

	/**
	 * 个人中心 -- 出入记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "personIORecord.html")
	public ModelAndView personIORecord(HttpSession session, String name, String startDate, String endDate, String pName, HttpServletResponse response,
			@RequestParam(value = "type", defaultValue = "-1") int type, @RequestParam(value = "pageNow", defaultValue = "1") int pageNow,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize, String export) {

		ModelAndView mav = new ModelAndView("front_person/person_IORecord");
		List<AccrecordModel> accrecordModelList = new ArrayList<AccrecordModel>();
		String teamCode = String.valueOf(session.getAttribute("teamCode"));
		// 根据班组号查询出班组名称 (通过modelAndView发回页面)
		String teamName = teamService.getTeamNameByCode(teamCode);
		// 根据班组号和查询条件 查询到当前班组的出勤记录数
		long dataCount = accrecordService.countPersonIORecord(teamCode, name, pName, startDate, endDate, type);
		// 创建一个分页page对象
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		// 根据用户所在班组号 分页查询班组出勤信息列表（每页默认显示20条）
		accrecordModelList = accrecordService.getPersonIORecordListByPage(teamCode, page.getPageNow(), page.getPageSize(), name, pName, startDate, endDate,
				type);
		mav.addObject("teamName", teamName);
		mav.addObject("page", page);
		mav.addObject("accrecordModelList", accrecordModelList);

		String[] Title = { "项目名称", "姓名", "工人电话", "进\\出时间", "进\\退场", "确认与否" }; // 导出excel的表头
		String fileName = teamName + "--出入记录"; // 导出excel的文件名
		String[] dateFieldNames = { "recordTime" }; // 需要转换时间格式的字段的名字数组 */
		int[] needIndex = { 8, 2, 3, 5, 7, 6 };
		if ("1".equals(export)) {
			try {
				ExportExcel.recoredExportExcel(response, "accRecord", Title, fileName, needIndex, accrecordModelList, dateFieldNames);
			} catch (WriteException | IOException e) {
				e.printStackTrace();
			}
		}

		// 查询表单回显数据
		mav.addObject("pName", pName);
		mav.addObject("name", name);
		mav.addObject("startDate", startDate);
		mav.addObject("endDate", endDate);
		mav.addObject("type", type);
		return mav;
	}

	/**
	 * 个人中心 -- 工资发放 author zss
	 * 
	 * @return
	 */
	@RequestMapping(value = "personSalary")
	public ModelAndView personSalary(HttpSession session, String name, String inTime,
			String outTime, String pName, HttpServletResponse response,
			@RequestParam(value = "pageNow", defaultValue = "1") int pageNow, 
			@RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
			@RequestParam(value = "dataCount", defaultValue = "0") long dataCount,
			String export) {
		System.out.println("personSalary方法接收的参数：" + name + " " + inTime + " " + outTime + " " + pName);
		ModelAndView mav = new ModelAndView("front_person/person_salary");
		String teamCode = String.valueOf(session.getAttribute("teamCode"));
		// 根据班组号查询出班组名称 (通过modelAndView发回页面)
		String teamName = teamService.getTeamNameByCode(teamCode);
		// 根据班组号查询出班组id (通过modelAndView发回页面)
		// String id = teamService.getTIdByCode(teamCode);
		// 根据班组id和查询条件 查询到当前班组的工资记录总条数
		if (dataCount == 0) {
			dataCount = payrollRecordService.countPayRoll(teamCode, name, inTime, outTime, pName);
		}
		// 创建一个分页page对象
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		// 根据用户所在班组号 分页查询班组出勤信息列表（每页默认显示20条）
		List<PayrollRecordModel> payRoll = payrollRecordService.getPayRollByPage(teamCode, page.getPageNow(), page.getPageSize(), name, inTime, outTime, pName);
		mav.addObject("teamName", teamName);
		mav.addObject("page", page);
		mav.addObject("payRoll", payRoll);
		String[] Title = { "项目编号", "姓名", "工人电话", "班组号", "进场", "退场时间", "工资", "实付", "未付", "交税", "班组长", "支付方式", "流水号", "确认1与否0", "发放日期", "收款账户", "项目名称", "班组名称" };// 导出excel的表头
		String fileName = teamName + "--工资发放记录"; // 导出excel的文件名
		String[] dateFieldNames = { "payTime" }; // 需要转换时间格式的字段的名字数组 */
		int[] needIndex = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
		if ("1".equals(export)) {
			try {
				ExportExcel.recoredExportExcel(response, "payrollRecrd", Title, fileName, needIndex, payRoll, dateFieldNames);
			} catch (WriteException | IOException e) {
				e.printStackTrace();
			}
		}
		// 查询表单回显数据
		mav.addObject("name", name);
		mav.addObject("pName", pName);
		mav.addObject("inTime", inTime);
		mav.addObject("outTime", outTime);
		return mav;
	}

	/**
	 * 模糊查询项目名称 -zss
	 * 
	 * @param pName
	 */
	@RequestMapping(value = "pNameList")
	public void getPNameList(HttpServletResponse response, String pName) {
		List<ProjectModel> pNameList = projectService.getPNameList(pName);

		response.setContentType("text/html;charset=UTF-8");
		System.out.println(pNameList);
		System.out.println("pName:-----" + pName);
		Gson gson = new Gson();
		String jsonarray = gson.toJson(pNameList);
		System.out.println(jsonarray);
		try {
			PrintWriter writer = response.getWriter();
			writer.print(jsonarray);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 个人中心 -- 个人诚信档案 -zss
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "personFile")
	public ModelAndView personFile(HttpSession session) {
		ModelAndView mav = new ModelAndView("front_person/person_file");
		String userId = (String) session.getAttribute("userId");
		PersonModel personModel = personService.getByUserId(userId);
		String type = String.valueOf(session.getAttribute("isLeader"));
		// 获取个人评价信息
		int type1 = 1;
		if ("0".equals(type) || "2".equals(type)) {
			type1 = 1;
		} else {
			type1 = 2;
		}
		List<CommentsModel> commentsModelList = commentsService.getListByIdAndType(userId, type1);
		mav.addObject("personModel", personModel);
		mav.addObject("commentsModelList", commentsModelList);
		return mav;
	}

	/**
	 * 个人中心 -- 班组诚信档案 -zss
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "teamFile")
	public ModelAndView teamFile(HttpSession session) {
		ModelAndView mav = new ModelAndView("front_person/team_file");
		// 通过teamCode来和type 字段 查询出 班组的信息（诚信档案）type就是isleader的值
		String teamCode = String.valueOf(session.getAttribute("teamCode"));
		String type = String.valueOf(session.getAttribute("isLeader"));
		String userId = (String) session.getAttribute("userId");
		if ("2".equals(type)) {
			type = "0";
		}
		PersonModel personModel = personService.getByTeamCodeAndType(teamCode, Integer.parseInt(type));
		// 获取班组评价信息
		List<CommentsModel> commentsModelList = commentsService.getComments(userId, Integer.parseInt(type) + 1);
		mav.addObject("personModel", personModel);
		mav.addObject("commentsModelList", commentsModelList);
		return mav;
	}

	/**
	 * 更新诚信档案基本信息(个人班组通用)
	 * 
	 * @param personModel
	 * @param teamCode
	 * @param teamName
	 * @return
	 */
	@RequestMapping(value = "updatePerson.html")
	public ModelAndView updatePerson(PersonModel pModel, HttpSession session) {
		System.out.println("------------进入updatePersonGroup方法了---------");
		// 由于session中【个人、班组长 0/材料商是1）】,personModel中【个人/班组长 （0/1）】这里是班组长要手动设置成1
		String isLeader = String.valueOf(session.getAttribute("isLeader"));
		ModelAndView mav = new ModelAndView();
		PersonModel model = new PersonModel();
		String teamCode = null;
		// PersonModel中的userId分为两种，班组的uId是tId，即班组的id,个人的是用户手机号即登录用的userId
		String userId = String.valueOf(session.getAttribute("userId"));
		if ("0".equals(isLeader) || "2".equals(isLeader)) {
			pModel.setType(0);
			mav = new ModelAndView("front_person/person_file");
			model = personService.getByUserId(userId);
		} else if ("1".equals(isLeader)) {
			pModel.setType(1);
			mav = new ModelAndView("front_person/team_file");
			teamCode = String.valueOf(pModel.getTeamCode());
			model = personService.getByTeamCodeAndType(teamCode, pModel.getType());

			// 将要修改的字段放入到从数据库查询出的model中
			model.setTeamName(pModel.getTeamName());
		}
		model.setName(pModel.getName());
		model.setSkillBigType(pModel.getSkillBigType());
		model.setSkillSmallType(pModel.getSkillSmallType());
		model.setGender(pModel.getGender());
		model.setNational(pModel.getNational());
		model.setEducation(pModel.getEducation());
		model.setAge(pModel.getAge());
		model.setMarriage(pModel.getMarriage());
		model.setHeight(pModel.getHeight());
		model.setWeight(pModel.getWeight());
		model.setHealth(pModel.getHealth());
		model.setWorktime(pModel.getWorktime());
		model.setJobstatus(pModel.getJobstatus());
		model.setBankcard(pModel.getBankcard());
		model.setAddress(pModel.getAddress());
		model.setProvince(pModel.getProvince());
		model.setCity(pModel.getCity());
		personService.updatePerson(model);
		PersonModel personModel = null;
		// 查出班组信息返回到页面
		if ("0".equals(isLeader) || "2".equals(isLeader)) {
			personModel = personService.getByUserId(userId);
		} else if ("1".equals(isLeader)) {
			personModel = personService.getByTeamCodeAndType(teamCode, pModel.getType());
		}
		mav.addObject("personModel", personModel);
		return mav;
	}

	/**
	 * 获取技能细分类型
	 * 
	 * @author rkai
	 * @param skillBigType
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "user_getSmallSkillType", method = RequestMethod.POST)
	public void getSmallSkillType(String skillBigType, HttpServletResponse response) throws IOException {
		int skillBig = Integer.valueOf(skillBigType);
		response.setContentType("text/html;charset=UTF-8");
		response.setContentType("UTF-8");

		List<ETeamSkillSmallType> sksmList = ETeamSkillSmallType.getSkillSmallTypeId(skillBig);
		List<SkillVo> skillList = new ArrayList<SkillVo>();
		if (sksmList != null)
			for (ETeamSkillSmallType e : sksmList) {
				SkillVo skillModel = new SkillVo();
				skillModel.setSkillType(e.id);
				skillModel.setSkillName(e.desc);
				skillList.add(skillModel);
			}
		PublicMethod.objectToJson(skillList, response);
	}

	/**
	 * 招聘班组详情 rkai
	 * 
	 * @return
	 */
	@RequestMapping(value = "person_teamInfo.html")
	public ModelAndView team_info() {
		String teamId = request.getParameter("teamId");
		String requireId = request.getParameter("requireId");
		RequirementsModel requireModel = requirementsService.getById(requireId);
		// String desc=requireModel.getDesc();
		TeamModel teamModel = teamService.getTeamById(teamId);// tamId _id
		ModelAndView mav = new ModelAndView("front_person/person_teamInfo");
		mav.addObject("teamModel", teamModel);
		mav.addObject("requireModel", requireModel);
		return mav;
	}

	/**
	 * 身份证号码是否与先前登记的一致
	 */
	//
	@RequestMapping(value = "identityRep.html")
	public void identityRep(String identity, String userId, HttpServletResponse response) {
		int isRep = userService.identityRep(identity, userId);
		System.out.println("isRep:" + isRep);
		PublicMethod.objectToJson(isRep, response);
	}

	/**
	 * 身份证号码否被注册过
	 */
	//
	@RequestMapping(value = "identityHaveReg.html")
	public void identityHaveReg(String identity, HttpServletResponse response) {
		int isRep = userService.identityHaveReg(identity);
		PublicMethod.objectToJson(isRep, response);
	}

	/**
	 * 班组参与过的或正在参与的工程项目
	 * 
	 * @return
	 */
	@RequestMapping(value = "teamProject.html")
	public ModelAndView teamProject(HttpSession session) {
		//TODO
		Map<ProjectModel,ProjectDepartmentModel> currentList = userService.getCurrentProject(session, 1, 3);
		Map<ProjectModel,ProjectDepartmentModel> pastList = userService.getCurrentProject(session, 1, 4);
		ModelAndView mav = new ModelAndView("front_person/team_pastproject");
		mav.addObject("currentList", currentList);
		mav.addObject("pastList", pastList);
		return mav;
	}

	/**
	 * 上传所做的工程图片
	 * 
	 * @return
	 */
	@RequestMapping(value="project_uploadImageName.html")
	public String uploadProjectPic(HttpServletResponse response, String id){
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
			String imageName = currentTime + "." + fileExt.toLowerCase();
			String filePath = IMageUploadInfo.BASEPATH.value + IMageUploadInfo.TEAMPROJECT.value + id;
			new ImageUpload().imageUpload(file, imageName, filePath, config, request, response);
			//查询出指定pId、tId的projectDepartmentModel
			ProjectDepartmentModel pdModel = projectDepartmentService.getById(id);
			pdModel.setImageName(imageName);//设置附件图片名称
			projectDepartmentService.updateProjectDepartment(pdModel);
			file.saveAs(filePath + "\\" + imageName, File.SAVEAS_PHYSICAL);//保存在tomcat安装路径所在磁盘的根目录下
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:teamProject.html";
	}

	/**
	 * 个人发布求职-zss
	 * 
	 * @return
	 */
	@RequestMapping(value = "personResume.html")
	public ModelAndView personResume(HttpSession session, @RequestParam(value = "pageNow", defaultValue = "1") int pageNow,
			@RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {
		String userId = (String) session.getAttribute("userId");
		UserModel userModel = userService.getByUserId(userId);

		long dataCount = requirementsService.countSupplies(userId, null, -1, 1, 1, 1);
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		List<RequirementsModel> requirementList = requirementsService.getRequirements(userId, null, -1, 1, 1, 1, pageNow, pageSize);
		ModelAndView mav = new ModelAndView("front_person/person_resume");
		mav.addObject("requirementList", requirementList);
		mav.addObject("userModel", userModel);
		mav.addObject("page", page);
		return mav;
	}

	/**
	 * 跳转到添加页面
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "toPersonResume.html")
	public ModelAndView toPersonResumeAdd(HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		UserModel userModel = userService.getByUserId(userId);

		// 跳转到页面之前，生成一个token令牌并存入session //----------token---------------
		NoRepeateSubmit.createSession(request); // ----------token---------------

		ModelAndView mav = new ModelAndView("front_person/person_resumeadd");
		mav.addObject("userModel", userModel);
		return mav;
	}

	/**
	 * 提交添加求职信息
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "personResumeAdd.html")
	public String personResumeAdd(HttpSession session, RequirementsModel requirementsModel, String credential, String token) {

		// 判断是否重复提交
		boolean isRepeat = NoRepeateSubmit.isRepeatSubmit(request, token);// ----------token--------
		if (isRepeat) {// 如果重复提交了，直接返回 //----------token--------
			return "forward:personResume.html"; // ----------token-------
		} // ----------token-------
		// 非重复提交，清除session中的token,执行添加代码 //----------token--------
		request.getSession().removeAttribute("token"); // ----------token-------

		requirementsModel.setCreateTime(new Date());
		userService.addRequirement(requirementsModel);
		String userId = (String) session.getAttribute("userId");
		UserModel userModel = userService.getByUserId(userId);
		userModel.setCredential(credential);
		// 将持证情况更新到userModel中
		userService.updateUser(userModel);
		return "redirect:personResume.html";
	}

	/**
	 * 撤销求职信息
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "cancelPersonResume.html")
	public String cancelResume(String id) {
		requirementsService.updateStatus(id, 0);// 关闭求职申请
		return "forward:personResume.html";
	}

	/**
	 * 一对一消息列表页面
	 * @param isRead
	 * @return
	 */
	@RequestMapping(value = "pt_message.html")
	public ModelAndView ptMessage(String isRead) {
		ModelAndView mav = new ModelAndView("front_person/pt_message");
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		String isLeader = (String) request.getSession().getAttribute(ESessionKey.IsLeader.key);
		Map<String, Object> map = messageService.getShowMessageHasMap(isRead, mav, userId, UserType.PersonType.desc, isLeader);  
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
	@RequestMapping(value = "pt_messageIsRead.html", method = RequestMethod.POST)
	public void ptMessageIsRead(String messageId, HttpServletResponse response) {
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
	 * @param isRead
	 * @return
	 */
	@RequestMapping(value = "pt_notice.html")
	public ModelAndView ptNotice(String isRead) {
		ModelAndView mav = new ModelAndView("front_person/pt_notice");
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		String isLeader = (String) request.getSession().getAttribute(ESessionKey.IsLeader.key);
		Map<String, Object> map = noticeService.getShowNoticeHasMap(isRead, mav, userId, UserType.PersonType.desc, isLeader);
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
	 * @param ptId
	 * @param isLeader
	 * @return
	 */
	@RequestMapping(value = "pt_noticeInfo.html", method = RequestMethod.POST)
	public void ptNoticeInfo(String nId, String ptId, String isLeader, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<JSONObject> jsonObjects = noticeService.getNoticeInfo(nId, ptId, UserType.PersonType.desc, isLeader);
		out.print(jsonObjects);
		out.flush();
		out.close();
	}

}
