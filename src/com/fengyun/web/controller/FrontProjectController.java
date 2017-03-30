package com.fengyun.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.cache.page.PageHandler;
import com.fengyun.web.common.Config;
import com.fengyun.web.db.playermodel.AccrecordModel;
import com.fengyun.web.db.playermodel.AttendanceInfoModel;
import com.fengyun.web.db.playermodel.CmdSummModel;
import com.fengyun.web.db.playermodel.CmdSummPersonModel;
import com.fengyun.web.db.playermodel.CmdSummSupplierModel;
import com.fengyun.web.db.playermodel.CommentsModel;
import com.fengyun.web.db.playermodel.CompanyModel;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.JoinBuildModel;
import com.fengyun.web.db.playermodel.KeyPersonModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.MessageModel;
import com.fengyun.web.db.playermodel.NoticeLogModel;
import com.fengyun.web.db.playermodel.NoticeModel;
import com.fengyun.web.db.playermodel.OperateCompactModel;
import com.fengyun.web.db.playermodel.PayrollRecordModel;
import com.fengyun.web.db.playermodel.PersonModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.ProjectProgressModel;
import com.fengyun.web.db.playermodel.ProjectRosterModel;
import com.fengyun.web.db.playermodel.RequirementsModel;
import com.fengyun.web.db.playermodel.RewardsAndPunishModel;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.TeamScheduleModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.db.vo.EquipmentCommentVo;
import com.fengyun.web.db.vo.MaterialCommentVo;
import com.fengyun.web.db.vo.MaterialEquipmentRosterVo;
import com.fengyun.web.db.vo.RequirementsVo;
import com.fengyun.web.db.vo.TeamAttendenceInfoVo;
import com.fengyun.web.db.vo.TeamCommentVo;
import com.fengyun.web.db.vo.TeamSkillSmallTypeVo;
import com.fengyun.web.db.vo.UserCmdSummDetailVo;
import com.fengyun.web.db.vo.UserTeamRosterVo;
import com.fengyun.web.hardcode.ESessionKey;
import com.fengyun.web.hardcode.ETeamSkillSmallType;
import com.fengyun.web.hardcode.IMageUploadInfo;
import com.fengyun.web.hardcode.UserType;
import com.fengyun.web.service.AccrecordService;
import com.fengyun.web.service.AttendanceInfoService;
import com.fengyun.web.service.CmdSummPersonService;
import com.fengyun.web.service.CmdSummService;
import com.fengyun.web.service.CmdSummSupplierService;
import com.fengyun.web.service.CommentsService;
import com.fengyun.web.service.CompanyService;
import com.fengyun.web.service.EquipmentService;
import com.fengyun.web.service.JoinBuildService;
import com.fengyun.web.service.KeyPersonService;
import com.fengyun.web.service.MaterialService;
import com.fengyun.web.service.OperateCompactService;
import com.fengyun.web.service.PayrollRecordService;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.ProjectProgressService;
import com.fengyun.web.service.ProjectRosterService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.RequirementsService;
import com.fengyun.web.service.RewardsAndPunishService;
import com.fengyun.web.service.TeamMemberService;
import com.fengyun.web.service.TeamScheduleService;
import com.fengyun.web.service.TeamService;
import com.fengyun.web.service.UserService;
import com.fengyun.web.service.NoticeService;
import com.fengyun.web.service.NoticeLogService;
import com.fengyun.web.service.MessageService;
import com.fengyun.web.util.DateStringUtils;
import com.fengyun.web.util.DownLoadExcelTemplateUtil;
import com.fengyun.web.util.ExportExcel;
import com.fengyun.web.util.ImageUpload;
import com.fengyun.web.util.ImportExcel;
import com.fengyun.web.util.ModelUtils;
import com.fengyun.web.util.NoRepeateSubmit;
import com.fengyun.web.util.PublicMethod;
import com.fengyun.web.util.StringIsNull;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.mongodb.BasicDBObject;

/**
 * 前台公司个人中心 controller
 * 
 */
@Controller
//@RequestMapping(value="project")
public class FrontProjectController {
	
	@Autowired
	private  ServletConfig config;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired 
	private AttendanceInfoService attendanceInfoService;
	
	@Autowired
	private PayrollRecordService payrollRecordService;
	
	@Autowired
	private AccrecordService accrecordService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private ProjectDepartmentService projectDepartmentService;
	
	@Autowired
	private CommentsService commentsService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private RequirementsService requirementsService;
	
	@Autowired
	private JoinBuildService joinBuildService;
	
	@Autowired
	private KeyPersonService keyPersonService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private RewardsAndPunishService rewardsAndPunishService;	
	
	@Autowired
	private UserService userService;	
	
	@Autowired
	private TeamMemberService teamMemberService;	
	
	@Autowired
	private TeamScheduleService teamScheduleService;	
	
	@Autowired
	private ProjectProgressService projectProgressService;	
	
	@Autowired
	private CmdSummService cmdSummService;
	
	@Autowired
	private CmdSummPersonService cmdSummPersonService;
	
	@Autowired
	private CmdSummSupplierService cmdSummSupplierService;
	
	@Autowired
	private ProjectRosterService projectRosterService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private OperateCompactService operateCompactService;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private NoticeLogService noticeLogService;
	
	@Autowired
	private MessageService messageService;
	
	/**
	 * 跳转到项目注册页面
	 */ 
	@RequestMapping(value="front_project_regForm.html",method=RequestMethod.GET)
	public String project_regForm(){
		return "front_project/front_project_regsiter";
	}
	
	/**
	 * 项目注册
	 */ 
	@RequestMapping(value="front_project_register.html")
	public ModelAndView project_register(HttpSession session, ProjectModel projectModel){
		ModelAndView mav = new ModelAndView("operate/operate");
		String userId = projectModel.getUserId();
		Map<String, String> map = noticeService.getNMCount(userId);
		request.getSession().setAttribute("count", map.get("count"));
		request.getSession().setAttribute("unReadMessageCount", map.get("unReadMessageCount"));
		request.getSession().setAttribute("readMessageCount", map.get("readMessageCount"));
		request.getSession().setAttribute("unReadNoticeCount", map.get("unReadNoticeCount"));
		request.getSession().setAttribute("readNoticeCount", map.get("readNoticeCount"));
		return projectService.registerProjectRegister(projectModel, mav);
	}
	
	/**
	 * 进入项目信息页
	 */
	@RequestMapping(value="projectInfo.html")
	public ModelAndView projectInfo(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("operate/operate");
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		ProjectModel projectModel = projectService.getProjectByUserId(userId);
		if (projectModel != null) {
			request.getSession().setAttribute(ESessionKey.ProjectId.key,projectModel.getId());
			request.getSession().setAttribute(ESessionKey.ProjectName.key,projectModel.getName());
			mav.addObject("projectModel", projectModel);
		}
		return mav;
	}
	
	/**
	 * 跳转到考勤记录页面
	 * @param id
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "operate_attendence.html", method = RequestMethod.GET)
	public ModelAndView operateAttendence(String id, String result) {
		ModelAndView mav = new ModelAndView("operate/operate_attendence");
		ProjectModel projectModel = projectService.getById(id);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		List<ProjectDepartmentModel> projectDepartmentModels = new ArrayList<ProjectDepartmentModel>();
		List<ProjectDepartmentModel> pdModels = projectDepartmentService.getByPIdAndType(id, 1); // 1表示type为施工班组
		if (pdModels != null && !pdModels.isEmpty()) {
			for (ProjectDepartmentModel projectDepartmentModel : pdModels) {
				if (projectDepartmentModel.getLabel() != null && projectDepartmentModel.getLabel() != "") {
					projectDepartmentModels.add(projectDepartmentModel);
				}
			}
		}
		if (projectDepartmentModels != null && !projectDepartmentModels.isEmpty()) {
			mav.addObject("projectDepartmentModels", projectDepartmentModels);
		}
		mav.addObject("result", result);
		return mav;
	}
	
	/**
	 * 考勤页面的搜索功能
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_getAttendenceRecord.html", method = RequestMethod.POST)
	public ModelAndView operateGetAttendenceRecord(String projectId) {
		ModelAndView mav = new ModelAndView("operate/operate_attendence");
		ProjectModel projectModel = projectService.getById(projectId);
		String pCode = null;
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
			pCode = projectModel.getpCode();
		}
		String workMonth = request.getParameter("workMonth").trim();
		String teamMemberName = request.getParameter("teamMemberName").trim();
		String teamName = request.getParameter("teamName").trim();
		String startDateStr = workMonth + "01";
		String endDateStr = workMonth + "31";
		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(pCode)) {
			queryObj.put("pCode", pCode);
		}
		if (StringUtils.isNotBlank(teamMemberName)) {
			queryObj.put("name", teamMemberName);
		}
		if (StringUtils.isNotBlank(teamName)) {
			queryObj.put("tName", teamName);
		}
		queryObj.put("confirm", 1);
		ModelUtils.queryDate(startDateStr, endDateStr, queryObj);
		List<TeamMemberModel> teamMemberModels = new ArrayList<TeamMemberModel>();
		if (teamMemberName == null || teamMemberName.isEmpty()) { // 班组
			List<AttendanceInfoModel> aiModels = attendanceInfoService.getAttendanceInfoRecordOneList(queryObj);
			if (aiModels != null && !aiModels.isEmpty()) { //按照时间和班组名称能查询到值
				String code = aiModels.get(0).getCode();
				TeamModel teamModel = null;
				if (code != null && code.length() >= 0) {
					teamModel = teamService.getTeamByCode(Long.parseLong(code));
				}
				String teamId = null;
				if (teamModel != null) {
					teamId = teamModel.getId();
					teamMemberModels = teamMemberService.getBytIdAndStatus(teamId, 3); // 3是属性status，表示这个用户还在这个班组中
				}
				TeamAttendenceInfoVo teamAttendenceInfoVo = null;
				List<TeamAttendenceInfoVo> teamAttendenceInfoVos = new ArrayList<TeamAttendenceInfoVo>();
				List<AttendanceInfoModel> oneUserLists = new ArrayList<AttendanceInfoModel>(); // 某一个人有多少条记录的集合
				if (teamMemberModels != null && !teamMemberModels.isEmpty()) {
					for (int i = 0; i < teamMemberModels.size(); i++) {
						teamAttendenceInfoVo = new TeamAttendenceInfoVo();
						teamAttendenceInfoVo.setTeamName(teamMemberName);
						String teamMemberUserId = teamMemberModels.get(i).getUserId();
						UserModel userModel = null;
						if (teamMemberUserId != null && teamMemberUserId.length() >= 0) {
							userModel = userService.getByUserId(teamMemberUserId);
						}
						if (userModel != null) {
							teamAttendenceInfoVo.setTeamMemberName(userModel.getUserName());
						}
						queryObj.put("userId", teamMemberUserId);
						oneUserLists = attendanceInfoService.getAttendanceInfoRecordOneList(queryObj);
						if (oneUserLists != null && !oneUserLists.isEmpty()) {
							int[] arr = new int[31];
							for (AttendanceInfoModel attendanceInfoModel : oneUserLists) {
								Date date = attendanceInfoModel.getStartDate();
								@SuppressWarnings("deprecation")
								int day = date.getDate() - 1;
								arr[day] = 1;
							}
							teamAttendenceInfoVo.setArr(arr);
						}
						teamAttendenceInfoVos.add(teamAttendenceInfoVo);
					}
				}
				if (teamAttendenceInfoVos != null && !teamAttendenceInfoVos.isEmpty()) {
					mav.addObject("teamAttendenceInfoVos", teamAttendenceInfoVos);
				}
			}
			else { //按照时间和班组名称不能查询到值，防止与之前的queryObj冲突，重新写一个方法（按照班组名称、pCode、confirm查询）
				List<AttendanceInfoModel> attInfoModels = attendanceInfoService.getListByTeamName(pCode, 1, teamName);
				if (attInfoModels != null && !attInfoModels.isEmpty()) {
					String code = attInfoModels.get(0).getCode();
					TeamModel teamModel = null;
					if (code != null && code.length() >= 0) {
						teamModel = teamService.getTeamByCode(Long.parseLong(code));
					}
					String teamId = null;
					if (teamModel != null) {
						teamId = teamModel.getId();
						teamMemberModels = teamMemberService.getBytIdAndStatus(teamId, 3); // 3是属性status，表示这个用户还在这个班组中
					}
				}
				TeamAttendenceInfoVo teamAttendenceInfoVo = null;
				List<TeamAttendenceInfoVo> teamAttendenceInfoVos = new ArrayList<TeamAttendenceInfoVo>();
				if (teamMemberModels != null && !teamMemberModels.isEmpty()) {
					for (int i = 0; i < teamMemberModels.size(); i++) {
						teamAttendenceInfoVo = new TeamAttendenceInfoVo();
						teamAttendenceInfoVo.setTeamName(teamMemberName);
						String teamMemberUserId = teamMemberModels.get(i).getUserId();
						UserModel userModel = null;
						if (teamMemberUserId != null && teamMemberUserId.length() >= 0) {
							userModel = userService.getByUserId(teamMemberUserId);
						}
						if (userModel != null) {
							teamAttendenceInfoVo.setTeamMemberName(userModel.getUserName());
						}
						int[] arr = new int[31];
						teamAttendenceInfoVo.setArr(arr);
						teamAttendenceInfoVos.add(teamAttendenceInfoVo);
					}
				}
				if (teamAttendenceInfoVos != null && !teamAttendenceInfoVos.isEmpty()) {
					mav.addObject("teamAttendenceInfoVos", teamAttendenceInfoVos);
				}
			}
		}
		else { // 个人姓名
			List<AttendanceInfoModel> attendanceInfoModels = new ArrayList<AttendanceInfoModel>();
			List<AttendanceInfoModel> aiModels = attendanceInfoService.getAttendanceInfoRecordOneList(queryObj);
			if (aiModels != null && !aiModels.isEmpty()) {
				for (AttendanceInfoModel attendanceInfoModel : aiModels) {
					TeamModel teamModel = teamService.getTeamByCode(Long.parseLong(attendanceInfoModel.getCode()));
					if (teamModel != null) {
						attendanceInfoModel.settName(teamModel.getName());
					}
					attendanceInfoModels.add(attendanceInfoModel);
				}
			}
			if (attendanceInfoModels != null && !attendanceInfoModels.isEmpty()) {
				mav.addObject("attendanceInfoModels", attendanceInfoModels);
			}
			mav.addObject("teamMemberName", teamMemberName);
		}
		mav.addObject("teamName", teamName);
		mav.addObject("workMonth", workMonth);
		mav.addObject("projectId", projectId);
		mav.addObject("pCode", pCode);
		return mav;
	}
	
	/**
	 * 根据班组名称标签查询考勤记录
	 * @param tId
	 * @param pId
	 * @return
	 */
	@RequestMapping(value = "operate_attendenceLabel.html")
	public ModelAndView operateAttendenceLabel(String tId, String pId) {
		ModelAndView mav = new ModelAndView("operate/operate_attendence");
		String tCode = null;
		TeamModel teamModel = teamService.getTeamById(tId);
		if (teamModel != null) {
			tCode = teamModel.getCode() + "";
		}
		String pCode = null;
		ProjectModel projectModel = projectService.getById(pId);
		if (projectModel != null) {
			pCode = projectModel.getpCode();
			mav.addObject("projectModel", projectModel);
		}
		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(pCode)) {
			queryObj.put("pCode", pCode);
		}
		if (StringUtils.isNotBlank(pCode)) {
			queryObj.put("code", tCode);
		}
		queryObj.put("confirm", 1);
		List<AttendanceInfoModel> aiModels = attendanceInfoService.getAttendanceInfoRecordOneList(queryObj);
		if (aiModels != null && !aiModels.isEmpty()) { 
			String[] startTimes = new String[aiModels.size()];
			int k = 0;
			for (AttendanceInfoModel aiModel : aiModels) {
				startTimes[k] = aiModel.getStartDateStr();
				System.out.println(k + " " + startTimes[k]);
				k++;
			}
			String maxStartTime = startTimes[0];
			for (int j = 0; j < startTimes.length; j++) {
				if (maxStartTime.compareTo(startTimes[j]) < 0) {
					maxStartTime = startTimes[j];
				}
			}
			String workMonth = maxStartTime.substring(0, 4) + maxStartTime.substring(5, 7);
			String startDateStr = workMonth + "01";
			String endDateStr = workMonth + "31";
			ModelUtils.queryDate(startDateStr, endDateStr, queryObj);
			List<AttendanceInfoModel> aiModel1s = attendanceInfoService.getAttendanceInfoRecordOneList(queryObj);
			if (aiModel1s != null && !aiModel1s.isEmpty()) { //按照时间和班组名称能查询到值
				String code = aiModels.get(0).getCode();
				TeamModel teamModel1 = null;
				List<TeamMemberModel> teamMemberModels = new ArrayList<TeamMemberModel>();
				if (code != null && code.length() >= 0) {
					teamModel1 = teamService.getTeamByCode(Long.parseLong(code));
				}
				String teamId = null;
				if (teamModel != null) {
					teamId = teamModel.getId();
					teamMemberModels = teamMemberService.getBytIdAndStatus(teamId, 3); // 3是属性status，表示这个用户还在这个班组中
				}
				TeamAttendenceInfoVo teamAttendenceInfoVo = null;
				List<TeamAttendenceInfoVo> teamAttendenceInfoVos = new ArrayList<TeamAttendenceInfoVo>();
				List<AttendanceInfoModel> oneUserLists = new ArrayList<AttendanceInfoModel>(); // 某一个人有多少条记录的集合
				if (teamMemberModels != null && !teamMemberModels.isEmpty()) {
					for (int i = 0; i < teamMemberModels.size(); i++) {
						teamAttendenceInfoVo = new TeamAttendenceInfoVo();
						teamAttendenceInfoVo.setTeamName(teamModel1.getName());
						String teamMemberUserId = teamMemberModels.get(i).getUserId();
						UserModel userModel = null;
						if (teamMemberUserId != null && teamMemberUserId.length() >= 0) {
							userModel = userService.getByUserId(teamMemberUserId);
						}
						if (userModel != null) {
							teamAttendenceInfoVo.setTeamMemberName(userModel.getUserName());
						}
						queryObj.put("userId", teamMemberUserId);
						oneUserLists = attendanceInfoService.getAttendanceInfoRecordOneList(queryObj);
						if (oneUserLists != null && !oneUserLists.isEmpty()) {
							int[] arr = new int[31];
							for (AttendanceInfoModel attendanceInfoModel : oneUserLists) {
								Date date = attendanceInfoModel.getStartDate();
								@SuppressWarnings("deprecation")
								int day = date.getDate() - 1;
								arr[day] = 1;
							}
							teamAttendenceInfoVo.setArr(arr);
						}
						teamAttendenceInfoVos.add(teamAttendenceInfoVo);
					}
				}
				if (teamAttendenceInfoVos != null && !teamAttendenceInfoVos.isEmpty()) {
					mav.addObject("LabelTeamAttendenceInfoVos", teamAttendenceInfoVos);
				}
			}
			mav.addObject("workYearMonth", workMonth);
		}
		mav.addObject("label", "label");
		return mav;
	}
	
	// TODO 考勤打印
	
	// 班组考勤页面的Excel导出 rkai
	@RequestMapping(value = "operate_teamAttendenceRecordToExcel.html", method = RequestMethod.GET)
	public void teamAttendenceRecordToExcel(HttpServletResponse response,
			String projectId, String workMonth, String pCode)
			throws UnsupportedEncodingException
	{
		String teamName = new String(request.getParameter("teamName").getBytes(
				"iso-8859-1"), "utf-8");
		ModelAndView mav = new ModelAndView("operate/operate_attendence");
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null)
		{
			mav.addObject("projectModel", projectModel);
			pCode = projectModel.getpCode();
		}
		String teamMemberName = null;
		String startDateStr = workMonth + "01";
		String endDateStr = workMonth + "31";
		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(pCode))
		{
			queryObj.put("pCode", pCode);
		}
		if (StringUtils.isNotBlank(teamMemberName))
		{
			queryObj.put("name", teamMemberName);
		}
		if (StringUtils.isNotBlank(teamName))
		{
			queryObj.put("tName", teamName);
		}
		queryObj.put("confirm", 1);
		ModelUtils.queryDate(startDateStr, endDateStr, queryObj);
		List<TeamMemberModel> teamMemberModels = new ArrayList<TeamMemberModel>();
		List<TeamAttendenceInfoVo> teamAttendenceInfoVos = new ArrayList<TeamAttendenceInfoVo>();
		if (teamMemberName == null || teamMemberName.isEmpty())
		{ // 班组
			List<AttendanceInfoModel> aiModels = attendanceInfoService
					.getAttendanceInfoRecordOneList(queryObj);
			if (aiModels != null && !aiModels.isEmpty())
			{ // 按照时间和班组名称能查询到值
				String code = aiModels.get(0).getCode();
				TeamModel teamModel = null;
				if (code != null && code.length() >= 0)
				{
					teamModel = teamService.getTeamByCode(Long.parseLong(code));
				}
				String teamId = null;
				if (teamModel != null)
				{
					teamId = teamModel.getId();
					teamMemberModels = teamMemberService.getBytIdAndStatus(
							teamId, 3); // 3是属性status，表示这个用户还在这个班组中
				}
				TeamAttendenceInfoVo teamAttendenceInfoVo = null;
				List<AttendanceInfoModel> oneUserLists = new ArrayList<AttendanceInfoModel>(); // 某一个人有多少条记录的集合
				if (teamMemberModels != null && !teamMemberModels.isEmpty())
				{
					for (int i = 0; i < teamMemberModels.size(); i++)
					{
						teamAttendenceInfoVo = new TeamAttendenceInfoVo();
						teamAttendenceInfoVo.setTeamName(teamMemberName);
						String teamMemberUserId = teamMemberModels.get(i)
								.getUserId();
						UserModel userModel = null;
						if (teamMemberUserId != null
								&& teamMemberUserId.length() >= 0)
						{
							userModel = userService
									.getByUserId(teamMemberUserId);
						}
						if (userModel != null)
						{
							teamAttendenceInfoVo.setTeamMemberName(userModel
									.getUserName());
						}
						queryObj.put("userId", teamMemberUserId);
						oneUserLists = attendanceInfoService
								.getAttendanceInfoRecordOneList(queryObj);
						if (oneUserLists != null && !oneUserLists.isEmpty())
						{
							int[] arr = new int[31];
							for (AttendanceInfoModel attendanceInfoModel : oneUserLists)
							{
								Date date = attendanceInfoModel.getStartDate();
								@SuppressWarnings("deprecation")
								int day = date.getDate() - 1;
								arr[day] = 1;
							}
							teamAttendenceInfoVo.setArr(arr);
							teamAttendenceInfoVo.setTeamName(teamName);
						}
						teamAttendenceInfoVos.add(teamAttendenceInfoVo);
					}
				}
				if (teamAttendenceInfoVos != null
						&& !teamAttendenceInfoVos.isEmpty())
				{
					mav.addObject("teamAttendenceInfoVos",
							teamAttendenceInfoVos);
				}
			} else
			{ // 按照时间和班组名称不能查询到值，防止与之前的queryObj冲突，重新写一个方法（按照班组名称、pCode、confirm查询）
				List<AttendanceInfoModel> attInfoModels = attendanceInfoService
						.getListByTeamName(pCode, 1, teamName);
				if (attInfoModels != null && !attInfoModels.isEmpty())
				{
					String code = attInfoModels.get(0).getCode();
					TeamModel teamModel = null;
					if (code != null && code.length() >= 0)
					{
						teamModel = teamService.getTeamByCode(Long
								.parseLong(code));
					}
					String teamId = null;
					if (teamModel != null)
					{
						teamId = teamModel.getId();
						teamMemberModels = teamMemberService.getBytIdAndStatus(
								teamId, 3); // 3是属性status，表示这个用户还在这个班组中
					}
				}
				TeamAttendenceInfoVo teamAttendenceInfoVo = null;
				if (teamMemberModels != null && !teamMemberModels.isEmpty())
				{
					for (int i = 0; i < teamMemberModels.size(); i++)
					{
						teamAttendenceInfoVo = new TeamAttendenceInfoVo();
						teamAttendenceInfoVo.setTeamName(teamMemberName);
						String teamMemberUserId = teamMemberModels.get(i)
								.getUserId();
						UserModel userModel = null;
						if (teamMemberUserId != null
								&& teamMemberUserId.length() >= 0)
						{
							userModel = userService
									.getByUserId(teamMemberUserId);
						}
						if (userModel != null)
						{
							teamAttendenceInfoVo.setTeamMemberName(userModel
									.getUserName());
						}
						int[] arr = new int[31];
						teamAttendenceInfoVo.setArr(arr);
						teamAttendenceInfoVo.setTeamName(teamName);
						teamAttendenceInfoVos.add(teamAttendenceInfoVo);
					}
				}
				if (teamAttendenceInfoVos != null
						&& !teamAttendenceInfoVos.isEmpty())
				{
					mav.addObject("teamAttendenceInfoVos",
							teamAttendenceInfoVos);
				}
			}
		}
		// 处理teamAttendenceInfoVos集合
		Iterator<TeamAttendenceInfoVo> it = teamAttendenceInfoVos.iterator();
		List<AttendenceToExcel> attendenceToExcelList = new ArrayList<AttendenceToExcel>();
		while (it.hasNext())
		{
			TeamAttendenceInfoVo teamAttendenceInfoVoModel = it.next();
			int a[] = null;
			AttendenceToExcel attendenceToExcel = new AttendenceToExcel();
			attendenceToExcel.setTeamName(teamName);
			attendenceToExcel.setTeamMemberName(teamAttendenceInfoVoModel
					.getTeamMemberName());
			if (teamAttendenceInfoVoModel.getArr() != null)
			{
				a = teamAttendenceInfoVoModel.getArr();
				int a0 = a[0];
				int a1 = a[1];
				int a2 = a[2];
				int a3 = a[3];
				int a4 = a[4];
				int a5 = a[5];
				int a6 = a[6];
				int a7 = a[7];
				int a8 = a[8];
				int a9 = a[9];
				int a10 = a[10];
				int a11 = a[11];
				int a12 = a[12];
				int a13 = a[13];
				int a14 = a[14];
				int a15 = a[15];
				int a16 = a[16];
				int a17 = a[17];
				int a18 = a[18];
				int a19 = a[19];
				int a20 = a[20];
				int a21 = a[21];
				int a22 = a[22];
				int a23 = a[23];
				int a24 = a[24];
				int a25 = a[25];
				int a26 = a[26];
				int a27 = a[27];
				int a28 = a[28];
				int a29 = a[29];
				int a30 = a[30];
				attendenceToExcel.setA0(a0);
				attendenceToExcel.setA1(a1);
				attendenceToExcel.setA2(a2);
				attendenceToExcel.setA3(a3);
				attendenceToExcel.setA4(a4);
				attendenceToExcel.setA5(a5);
				attendenceToExcel.setA5(a5);
				attendenceToExcel.setA6(a6);
				attendenceToExcel.setA7(a7);
				attendenceToExcel.setA8(a8);
				attendenceToExcel.setA9(a9);
				attendenceToExcel.setA10(a10);
				attendenceToExcel.setA11(a11);
				attendenceToExcel.setA11(a11);
				attendenceToExcel.setA12(a12);
				attendenceToExcel.setA13(a13);
				attendenceToExcel.setA14(a14);
				attendenceToExcel.setA15(a15);
				attendenceToExcel.setA15(a15);
				attendenceToExcel.setA16(a16);
				attendenceToExcel.setA17(a17);
				attendenceToExcel.setA18(a18);
				attendenceToExcel.setA19(a19);
				attendenceToExcel.setA20(a20);
				attendenceToExcel.setA21(a21);
				attendenceToExcel.setA22(a22);
				attendenceToExcel.setA23(a23);
				attendenceToExcel.setA24(a24);
				attendenceToExcel.setA25(a25);
				attendenceToExcel.setA25(a25);
				attendenceToExcel.setA26(a26);
				attendenceToExcel.setA27(a27);
				attendenceToExcel.setA28(a28);
				attendenceToExcel.setA29(a29);
				attendenceToExcel.setA30(a30);
				attendenceToExcelList.add(attendenceToExcel);
			} else
			{
				attendenceToExcelList.add(attendenceToExcel);
			}
		}
		// 表头
		String[] tTitle =
		{ "序号", "班组名称", "姓名", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
				"20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
				"30", "31" };
		String[] dateFiled =
		{ "payTime" };// 需要转化时间格式的字段名
		Date ctime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String currentTime = formatter.format(ctime);
		String fileName = teamName + "考勤记录表" + currentTime;
		String tableName = "teamAttendenceRecordToExcel";
		int needIndex[] =
		{ 100, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
				18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 };// 需要输入excel表格的字段及次序
		try
		{
			ExportExcel.recoredExportExcel(response, tableName, tTitle,
					fileName, needIndex, attendenceToExcelList, dateFiled);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// 成员考勤记录导出到Excel rkai
	@RequestMapping(value = "operate_teamMemberAttendenceRecordToExcel.html", method = RequestMethod.GET)
	public void teamMemberAttendenceRecordToExcel(HttpServletResponse response,
			String projectId, String workMonth, String pCode)
			throws UnsupportedEncodingException
	{
		ModelAndView mav = new ModelAndView("operate/operate_attendence");
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null)
		{
			mav.addObject("projectModel", projectModel);
			pCode = projectModel.getpCode();
		}
		String teamName = new String(request.getParameter("teamName").getBytes(
				"iso-8859-1"), "utf-8");
		String teamMemberName = new String(request.getParameter(
				"teamMemberName").getBytes("iso-8859-1"), "utf-8");
		String startDateStr = workMonth + "01";
		String endDateStr = workMonth + "31";
		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(pCode))
		{
			queryObj.put("pCode", pCode);
		}
		if (StringUtils.isNotBlank(teamMemberName))
		{
			queryObj.put("name", teamMemberName);
		}
		if (StringUtils.isNotBlank(teamName))
		{
			queryObj.put("tName", teamName);
		}
		queryObj.put("confirm", 1);
		ModelUtils.queryDate(startDateStr, endDateStr, queryObj);
		// 个人姓名
		List<AttendanceInfoModel> attendanceInfoModels = new ArrayList<AttendanceInfoModel>();
		List<AttendanceInfoModel> aiModels = attendanceInfoService
				.getAttendanceInfoRecordOneList(queryObj);
		if (aiModels != null && !aiModels.isEmpty())
		{
			for (AttendanceInfoModel attendanceInfoModel : aiModels)
			{
				TeamModel teamModel = teamService.getTeamByCode(Long
						.parseLong(attendanceInfoModel.getCode()));
				if (teamModel != null)
				{
					attendanceInfoModel.setpName(teamName);
					attendanceInfoModel.settName(projectModel.getName());
				}
				attendanceInfoModels.add(attendanceInfoModel);
			}
		}
		// 表头
		String[] tTitle =
		{ "序号", "项目名称", "姓名", "日期", "开始时间", "结束时间" };
		String[] dateFiled =
		{ "startDate", "endDate" };// 需要转化时间格式的字段名
		Date ctime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String currentTime = formatter.format(ctime);
		String fileName = teamMemberName + "考勤记录表" + currentTime;
		String tableName = "teamMemberAttendenceRecordToExcel";
		int needIndex[] =
			{ 100,10,2, 6, 5, 6 };
		try
		{
			ExportExcel.recoredExportExcel(response, tableName, tTitle,
					fileName, needIndex, attendanceInfoModels, dateFiled);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

   class AttendenceToExcel
   {
	   String teamName;
	   String teamMemberName;
	   int a0=2; int a1=2;int a2=2;int a3=2;int a4=2;int a5=2;int a6=2;int a7=2;int a8=2;int a9=2;int a10=2;
	   int a11=2;int a12=2;int a13=2;int a14=2;int a15=2;int a16=2;int a17=2;int a18=2;int a19=2;int a20=2;
	   int a21=2;int a22=2;int a23=2;int a24=2;int a25=2;int a26=2;int a27=2;int a28=2;int a29=2;int a30=2;
	   public int getA0(){return a0;};public void setA0(int a0){this.a0 = a0;}public String getTeamName(){return teamName;}public void setTeamName(String teamName){this.teamName = teamName;}public String getTeamMemberName(){return teamMemberName;}public void setTeamMemberName(String teamMemberName){this.teamMemberName = teamMemberName;}public int getA1(){return a1;}public void setA1(int a1){this.a1 = a1;}public int getA2(){return a2;}public void setA2(int a2){this.a2 = a2;}public int getA3(){return a3;}public void setA3(int a3){this.a3 = a3;}public int getA4(){return a4;}public void setA4(int a4){this.a4 = a4;}public int getA5(){return a5;}public void setA5(int a5){this.a5 = a5;}public int getA6(){return a6;}public void setA6(int a6){this.a6 = a6;}public int getA7(){return a7;}public void setA7(int a7){this.a7 = a7;}public int getA8(){return a8;}public void setA8(int a8){this.a8 = a8;}public int getA9(){return a9;}public void setA9(int a9){this.a9 = a9;}public int getA10(){return a10;}public void setA10(int a10){this.a10 = a10;}public int getA11(){return a11;}public void setA11(int a11){this.a11 = a11;}public int getA12(){return a12;}public void setA12(int a12){this.a12 = a12;}public int getA13(){return a13;}public void setA13(int a13){this.a13 = a13;}public int getA14(){return a14;}public void setA14(int a14){this.a14 = a14;}public int getA15(){return a15;}public void setA15(int a15){this.a15 = a15;}public int getA16(){return a16;}public void setA16(int a16){this.a16 = a16;}public int getA17(){return a17;}public void setA17(int a17){this.a17 = a17;}public int getA18(){return a18;}public void setA18(int a18){this.a18 = a18;}public int getA19(){return a19;}public void setA19(int a19){this.a19 = a19;}public int getA20(){return a20;}public void setA20(int a20){this.a20 = a20;}public int getA21(){return a21;}public void setA21(int a21){this.a21 = a21;}public int getA22(){return a22;}public void setA22(int a22){this.a22 = a22;}public int getA23(){return a23;}public void setA23(int a23){this.a23 = a23;}public int getA24(){return a24;}public void setA24(int a24){this.a24 = a24;}public int getA25(){return a25;}public void setA25(int a25){this.a25 = a25;}public int getA26(){return a26;}public void setA26(int a26){this.a26 = a26;}public int getA27(){return a27;}public void setA27(int a27){this.a27 = a27;}public int getA28(){return a28;}public void setA28(int a28){this.a28 = a28;}public int getA29(){return a29;}public void setA29(int a29){this.a29 = a29;}public int getA30(){return a30;}public void setA30(int a30){this.a30 = a30;}
   }
		
   /**
    * 获取考勤记录的EXCEL模板文件
    * @param request
    * @param response
    */
    @RequestMapping(value = "operate_attendenceDownloadExcel.html", method = RequestMethod.GET)
    public void operateAttendenceDownloadExcel(HttpServletRequest request, HttpServletResponse response) {
    	String filePath = Config.getInstance().getRootPath() + "exceltemplate/recordAttendence.xml";
    	DownLoadExcelTemplateUtil.getExcelTemplate(filePath, request, response);
    }
   
    /**
     * 考勤记录的导入功能
     * @param pCode
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "operate_attendenceImportExcel.html", method = RequestMethod.POST)
    public ModelAndView operateAttendenceImportExcel(String pCode, HttpServletRequest request, HttpServletResponse response) {
    	String result = "0";
    	String projectId = null;
    	String projectName = null;
    	ProjectModel projectModel = projectService.getByPCode(pCode);
    	if (projectModel != null) {
    		projectId = projectModel.getId();
    		projectName = projectModel.getName();
    	}
    	String filePath = request.getSession().getServletContext().getRealPath("\\resource\\execl\\import\\record_attendence") + "\\" + projectId;
    	String fileName = ImportExcel.createDateExcel(filePath, config, request, response);
    	AttendanceInfoModel attendanceInfoModel = null;
    	List<AttendanceInfoModel> attendanceInfoModels = new ArrayList<AttendanceInfoModel>();
    	Workbook workbook = null;
    	int count = -1; // 用于判断是否为空的EXCEL
    	try {
    		workbook = Workbook.getWorkbook(new java.io.File(filePath + "\\" + fileName)); // 创建Workbook	
    		Sheet sheet = workbook.getSheet(0);	// 获取第一个工作簿Sheet
    		if (!("考勤记录导入".equals(sheet.getCell(0, 0).getContents().trim()) && "工人手机号".equals(sheet.getCell(0, 1).getContents().trim()) &&
    				"班组名称".equals(sheet.getCell(1, 1).getContents().trim()) && "开始时间".equals(sheet.getCell(2, 1).getContents().trim()) && 
    				"结束时间".equals(sheet.getCell(3, 1).getContents().trim()) && "工时".equals(sheet.getCell(4, 1).getContents().trim()))) { // 判断导入模板是否正确
    			result = "8";
    		} else {
    			for (int i = 2; i < sheet.getRows(); i++) {	// 获取数据
    				count++;
    				if ("".equals(sheet.getCell(0, i).getContents().trim()) && "".equals(sheet.getCell(1, i).getContents().trim()) && 
    						"".equals(sheet.getCell(2, i).getContents().trim()) && "".equals(sheet.getCell(3, i).getContents().trim()) && 
    						"".equals(sheet.getCell(4, i).getContents().trim())) { // 模板外
    					break;
    				}
    				if ("".equals(sheet.getCell(0, i).getContents().trim()) && "".equals(sheet.getCell(1, i).getContents().trim()) && 
    						("1900/1/0  0:00:00".equals(sheet.getCell(2, i).getContents().trim()) || "1899-12-30 12:00:00".equals(sheet.getCell(2, i).getContents().trim())) && 
    						("1900/1/0  0:00:00".equals(sheet.getCell(3, i).getContents().trim()) || "1899-12-30 12:00:00".equals(sheet.getCell(3, i).getContents().trim())) && 
    						"0".equals(sheet.getCell(4, i).getContents().trim())) { // 模板内
    					break;
    				}
    				if ("".equals(sheet.getCell(0, i).getContents().trim()) || "".equals(sheet.getCell(1, i).getContents().trim()) || 
    						"".equals(sheet.getCell(2, i).getContents().trim()) || "".equals(sheet.getCell(3, i).getContents().trim()) || 
    						"".equals(sheet.getCell(4, i).getContents().trim())) { // 验证数据的完整性
    					result = "1";
    					break;
    				} else {
    					String userId = sheet.getCell(0, i).getContents().trim();
    					Pattern regUserIdPattern = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$");
    					Matcher regUserIdMatcher = regUserIdPattern.matcher(userId);
    					if (!regUserIdMatcher.matches()) { // 验证手机号输入是否正确
    						result = "2";
    						break;
    					} else {
    						UserModel isExistuserModel = userService.getByUserId(userId);
    						if (isExistuserModel == null) { // 判断这个用户是否已经注册,
    							result = "3";
    							break;
    						} else {
    							String name = isExistuserModel.getUserName();
    							String teamName = sheet.getCell(1, i).getContents().trim(); // 班组名称唯一
    							String tId = null;
    							String code = null;
    							TeamModel teamModel = teamService.getTeamByName(teamName);
    							if (teamModel == null) { // 判断班组是否存在
    								result = "4";
    								break;
    							} else {
    								tId = teamModel.getId();
    								code = teamModel.getCode() + "";
    								TeamMemberModel isExistTeamMemberModel = teamMemberService.userIdExistInTeam(userId, tId, 3); // 3表示这个工人在这个班组中
    								if (isExistTeamMemberModel == null) {  // 表示这个工人不在当前的班组中
    									result = "5";
    									break;
    								} else {
    									// 在AttendenceInfoModel中判断是否已存在某条记录，即一个工人在一天只能有一条记录，根据数据库中所有字段没有办法判断，这里暂时不判断
    									String startDate = sheet.getCell(2, i).getContents().trim();
    									String endDate = sheet.getCell(3, i).getContents().trim();
    									String startDateStr = startDate.substring(0, 10);
    									String endDateStr = endDate.substring(0, 10);
    									Pattern ymdPattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
    									Matcher ymdStartMatcher = ymdPattern.matcher(startDateStr);
    									Matcher ymdEndMatcher = ymdPattern.matcher(endDateStr);
    									if (!ymdStartMatcher.matches() || !ymdEndMatcher.matches()) { //1900-01-00可能变成1900/1/0，导致不能正确截取
    										result = "6";
    										break;
    									} else {
    										attendanceInfoModel = new AttendanceInfoModel();
    										attendanceInfoModel.setpCode(pCode);
    										attendanceInfoModel.setName(name);
    										attendanceInfoModel.setUserId(userId);
    										attendanceInfoModel.setCode(code);
    										long start = ((DateCell) sheet.getCell(2, i)).getDate().getTime() - (8*60*60*1000); // 时区问题，这里剑8个小时
    										long end = ((DateCell) sheet.getCell(3, i)).getDate().getTime() - (8*60*60*1000);
    										attendanceInfoModel.setStartDate(new Date(start));
    										attendanceInfoModel.setEndDate(new Date(end));
    										attendanceInfoModel.setConfirm(1);
    										attendanceInfoModel.setWorkTime(Integer.parseInt(sheet.getCell(4, i).getContents().trim()));
    										attendanceInfoModel.setpName(projectName);
    										attendanceInfoModel.settName(teamName);
    										attendanceInfoModels.add(attendanceInfoModel);
    									}
    								}
    							}
    						}
    					}
    				}
    			}
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	if (count == 0 && !"1".equals(result) && !"2".equals(result) && !"3".equals(result) && !"4".equals(result) && !"5".equals(result) && !"6".equals(result) && !"7".equals(result)) {
    		result = "7";
    	}
    	if ("0".equals(result)) {
    		if (attendanceInfoModels != null && !attendanceInfoModels.isEmpty()) {
    			for (AttendanceInfoModel attendanceInfoModel2 : attendanceInfoModels) {
    				attendanceInfoService.addAttendanceInfo(attendanceInfoModel2);
    			}
    		}
    	}
    	return operateAttendence(projectId, result);
    }
   
	/**
	 * 跳转到工资发放记录页面
	 * @param id
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "operate_salary.html", method = RequestMethod.GET)
	public ModelAndView operateSalary(String id, String result) {
		ModelAndView mav = new ModelAndView("operate/operate_salary");
		ProjectModel projectModel = projectService.getById(id);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		List<ProjectDepartmentModel> projectDepartmentModels = new ArrayList<ProjectDepartmentModel>();
		List<ProjectDepartmentModel> pdModels = projectDepartmentService.getByPIdAndType(id, 1); // 1表示type为施工班组
		if (pdModels != null && !pdModels.isEmpty()) {
			for (ProjectDepartmentModel projectDepartmentModel : pdModels) {
				if (projectDepartmentModel.getLabel() != null && projectDepartmentModel.getLabel() != "") {
					projectDepartmentModels.add(projectDepartmentModel);
				}
			}
		}
		if (projectDepartmentModels != null && !projectDepartmentModels.isEmpty()) {
			mav.addObject("projectDepartmentModels", projectDepartmentModels);
		}
		mav.addObject("result", result);
		return mav;
	}
	
	/**
	 * 根据班组的标签查询这个班组的工资发放记录
	 * @param tId
	 * @param pId
	 * @return
	 */
	@RequestMapping(value = "operate_salaryLabel.html")
	public ModelAndView operateSalaryLabel(String tId, String pId) {
		ModelAndView mav = new ModelAndView("operate/operate_salary");
		ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getByVIdAndPIdAndStatusAndType(tId, pId, 3, 1); // 3为status表示加入，1为type表示施工班组
		if (projectDepartmentModel != null) {
			mav.addObject("projectDepartmentModel", projectDepartmentModel);
		}
		String tCode = null;
		TeamModel teamModel = teamService.getTeamById(tId);
		if (teamModel != null) {
			tCode = teamModel.getCode() + "";
		}
		String pCode = null;
		ProjectModel projectModel = projectService.getById(pId);
		if (projectModel != null) {
			pCode = projectModel.getpCode();
			mav.addObject("projectModel", projectModel);
		}
		Long dataCount = payrollRecordService.getCountByPCodeAndTCode(pCode, tCode);
		int pageNow = 1;
		if (request.getParameter("pageNow") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNow"));
		}
		if (request.getParameter("pageNowPre") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowPre"));
		}
		if (request.getParameter("pageNowNext") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowNext"));
		}
		if (request.getParameter("pageNowLast") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowLast"));
		}
		int pageSize = 30; //一页显示几条记录,默认30条
		if (request.getParameter("pageSizeTotal") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSizeTotal"));
		}
		int pageCount = 0;
		if (dataCount % pageSize == 0) {
			pageCount = (int) (dataCount / pageSize); 
		} else {
			pageCount = (int) (dataCount / pageSize + 1);
		}
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		if (page != null) {
			mav.addObject("page", page);
			List<PayrollRecordModel> payrollRecordModels = payrollRecordService.getAllByPageAndPCodeAndTCode(page, pCode, tCode);
			if (payrollRecordModels != null && !payrollRecordModels.isEmpty()) {
				mav.addObject("LabelPayrollRecordModels", payrollRecordModels);
			}
		}
		mav.addObject("label", "label");
		mav.addObject("pageCount", pageCount);
		return mav;
	}
	
	/**
	 * 工资发放记录页面的搜索功能
	 * 
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_getSalaryRecord.html", method = RequestMethod.POST)
	public ModelAndView operateGetSalaryRecord(String projectId,String workMonth,String teamMemberName,String teamName) {
		ModelAndView mav = new ModelAndView("operate/operate_salary");
		try {
			teamMemberName = new String(teamMemberName.getBytes(), "utf-8");
			teamName = new String(teamName.getBytes(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ProjectModel projectModel = projectService.getById(projectId);
		String pCode = null;
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
			pCode = projectModel.getpCode();
		}
		workMonth=workMonth.trim();
		teamMemberName=teamMemberName.trim();
		teamName=teamName.trim();
		String startDateStr = workMonth + "01";
		String endDateStr = workMonth + "31";
		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(pCode)) {
			queryObj.put("pCode", pCode);
		}
		if (StringUtils.isNotBlank(teamMemberName)) {
			queryObj.put("name", teamMemberName);
		}
		if (StringUtils.isNotBlank(teamName)) {
			queryObj.put("tName", teamName);
		}
		queryObj.put("confirm", 1);
		ModelUtils.queryDate(startDateStr, endDateStr, queryObj, "payTime");
		List<PayrollRecordModel> prModels = payrollRecordService
				.getPayrollRecordOneList(queryObj);
		List<PayrollRecordModel> payrollRecordModels = new ArrayList<PayrollRecordModel>();
		if (prModels != null && !prModels.isEmpty()) {
			for (PayrollRecordModel payrollRecordModel : prModels) {
				TeamModel teamModel = teamService.getTeamByCode(Long
						.parseLong(payrollRecordModel.getCode()));
				if (teamModel != null) {
					payrollRecordModel.settName(teamModel.getName());
				}
				payrollRecordModels.add(payrollRecordModel);
			}
		}
		if (payrollRecordModels != null && !payrollRecordModels.isEmpty()) {
			mav.addObject("payrollRecordModels", payrollRecordModels);
		}
		mav.addObject("workMonth", workMonth);
		mav.addObject("teamMemberName", teamMemberName);
		mav.addObject("teamName", teamName);
		// 存储搜索条件
		mav.addObject("projectId", projectId);
		mav.addObject("pCode", pCode);
		return mav;
	}

	// TODO 工资发放页面打印
	
	// 工资发放页面导出Excel rkai
	// 1 根据搜索条件查到List 2 根据list打印
	@RequestMapping(value = "salry_toExcle.html", method = RequestMethod.GET)
	public void salryToExcel(HttpServletResponse response,String workMonth, String projectId)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String teamMemberName = request.getParameter("teamMemberName");
		String teamName = new String(request.getParameter("teamName").getBytes(
				"iso-8859-1"), "utf-8");
		String pCode = request.getParameter("pCode");
		String startDateStr = workMonth + "01";
		String endDateStr = workMonth + "31";
		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(pCode)) {
			queryObj.put("pCode", pCode);
		}
		if (StringUtils.isNotBlank(teamMemberName)) {
			queryObj.put("name", teamMemberName);
		}
		if (StringUtils.isNotBlank(teamName)) {
			queryObj.put("tName", teamName);
		}
		queryObj.put("confirm", 1);
		ModelUtils.queryDate(startDateStr, endDateStr, queryObj, "payTime");
		List<PayrollRecordModel> prModels = payrollRecordService
				.getPayrollRecordOneList(queryObj);
		List<PayrollRecordModel> payrollRecordModels = new ArrayList<PayrollRecordModel>();
		if (prModels != null && !prModels.isEmpty()) {
			for (PayrollRecordModel payrollRecordModel : prModels) {
				TeamModel teamModel = teamService.getTeamByCode(Long
						.parseLong(payrollRecordModel.getCode()));
				if (teamModel != null) {
					payrollRecordModel.settName(teamModel.getName());
				}
				payrollRecordModels.add(payrollRecordModel);
			}
		}
		// 表头
		String[] tTitle = {"序号", "班组名称", "姓名", "发放日期", "应发金额", 
				            "个人所得税", "实发金额", "欠发金额", "付款人", 
				            "付款方式", "流水号", "收账人账号"};
		String[] dateFiled = { "payTime" };// 需要转化时间格式的字段名
		Date ctime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String currentTime = formatter.format(ctime); 
		String fileName = teamName + "工资发放表 " + currentTime;
		String tableName = "payrollRecrd";
		int needIndex[] = {100,18,2,15,7,10,8,9,11,12,13,16};//需要输入excel表格的字段及次序
		try {
			ExportExcel.recoredExportExcel(response, tableName,tTitle, fileName,needIndex, payrollRecordModels,
					dateFiled);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//工资条附件上传
	@SuppressWarnings("static-access")
	@RequestMapping(value = "operate_uploadSalaryImage.html", method = RequestMethod.POST)
	public String uploadSalaryImage(HttpServletRequest request, HttpServletResponse response,
			String projectId,String workMonth) throws ServletException, IOException
	{
		String projectUserId=request.getParameter("projectUserId");
		String payrollRecordId=request.getParameter("payrollRecordId");
		String teamName = new String(request.getParameter("teamName").getBytes(),"utf-8"); 
		String teamMemberName = new String(request.getParameter("teamMemberName").getBytes(), "utf-8");
		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(config, request, response);
		try{
			smartUpload.upload();
		}catch(Exception e){
			e.printStackTrace();
		}
        Files files = smartUpload.getFiles();
		File file = files.getFile(0);
		String fileExt=file.getFileExt();
		Date dateCurrentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("YYMMddHHmmss");
		String currentTime = formatter.format(dateCurrentTime); 
		String fileName=currentTime+"."+fileExt.toLowerCase();//现有时间加登陆者手机号组成图片名称
		String filePath=IMageUploadInfo.BASEPATH.value+IMageUploadInfo.SARYPATH.value+projectUserId;
		new ImageUpload().imageUpload(file, fileName, filePath, config, request, response);
		PayrollRecordModel payrollRecordModel=payrollRecordService.getById(payrollRecordId);
		payrollRecordModel.setImageName(fileName);
		payrollRecordService.updatePayrollRecord(payrollRecordModel);
		request.setAttribute("projectId",projectId);  
		request.setAttribute("teamMemberName",teamMemberName);  
		request.setAttribute("workMonth",workMonth);  
		request.setAttribute("teamName",teamName);  
		return "forward:operate_getSalaryRecord.html";
	}
	
	/**
	 * 获取工资发放记录的EXCEL模板文件
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "operate_salaryDownloadExcel.html", method = RequestMethod.GET)
	public void operateSalaryDownloadExcel(HttpServletRequest request, HttpServletResponse response) {
		String filePath = Config.getInstance().getRootPath() + "exceltemplate/recordSalary.xml";
		DownLoadExcelTemplateUtil.getExcelTemplate(filePath, request, response);
	}
	
	/**
	 * 工资发放记录的导入功能
	 * @param pCode
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "operate_salaryImportExcel.html", method = RequestMethod.POST)
	public ModelAndView operateSalaryImportExcel(String pCode, HttpServletRequest request, HttpServletResponse response) {
		String result = "0";
		String projectId = null;
		String projectName = null;
		ProjectModel projectModel = projectService.getByPCode(pCode);
		if (projectModel != null) {
			projectId = projectModel.getId();
			projectName = projectModel.getName();
		}
		String filePath = request.getSession().getServletContext().getRealPath("\\resource\\execl\\import\\record_salary") + "\\" + projectId;
		String fileName = ImportExcel.createDateExcel(filePath, config, request, response);
		PayrollRecordModel payrollRecordModel = null;
		List<PayrollRecordModel> payrollRecordModels = new ArrayList<PayrollRecordModel>();
		Workbook workbook = null;
		int count = -1; // 用于判断是否为空的EXCEL
		try {
			workbook = Workbook.getWorkbook(new java.io.File(filePath + "\\" + fileName)); // 创建Workbook	
			Sheet sheet = workbook.getSheet(0);	// 获取第一个工作簿Sheet
			if (!("工资发放记录导入".equals(sheet.getCell(0, 0).getContents().trim()) && "工人手机号".equals(sheet.getCell(0, 1).getContents().trim()) &&
					"班组名称".equals(sheet.getCell(1, 1).getContents().trim()) && "开始时间".equals(sheet.getCell(2, 1).getContents().trim()) &&
					"结束时间".equals(sheet.getCell(3, 1).getContents().trim()) && "应发金额".equals(sheet.getCell(4, 1).getContents().trim()) && 
					"个人所得税".equals(sheet.getCell(5, 1).getContents().trim()) && "实发金额".equals(sheet.getCell(6, 1).getContents().trim()) && 
					"欠发金额".equals(sheet.getCell(7, 1).getContents().trim()) && "付款人".equals(sheet.getCell(8, 1).getContents().trim()) &&
					"付款方式".equals(sheet.getCell(9, 1).getContents().trim()) && "流水号".equals(sheet.getCell(10, 1).getContents().trim()) && 
					"发放日期".equals(sheet.getCell(11, 1).getContents().trim()) && "收款人账号".equals(sheet.getCell(12, 1).getContents().trim()))) { // 判断导入模板是否正确
				result = "9";
			} else {
				for (int i = 2; i < sheet.getRows(); i++) {	// 获取数据
					count++;
					if ("".equals(sheet.getCell(0, i).getContents().trim()) && "".equals(sheet.getCell(1, i).getContents().trim()) && 
							"".equals(sheet.getCell(2, i).getContents().trim()) && "".equals(sheet.getCell(3, i).getContents().trim()) && 
							"".equals(sheet.getCell(4, i).getContents().trim()) && "".equals(sheet.getCell(5, i).getContents().trim()) &&
							"".equals(sheet.getCell(6, i).getContents().trim()) && "".equals(sheet.getCell(7, i).getContents().trim()) &&
							"".equals(sheet.getCell(8, i).getContents().trim()) && "".equals(sheet.getCell(9, i).getContents().trim()) &&
							"".equals(sheet.getCell(10, i).getContents().trim()) && "".equals(sheet.getCell(11, i).getContents().trim()) &&
							"".equals(sheet.getCell(12, i).getContents().trim())) { // 模板外
						break;
					}
					if ("".equals(sheet.getCell(0, i).getContents().trim()) && "".equals(sheet.getCell(1, i).getContents().trim()) && 
							("1900/1/0".equals(sheet.getCell(2, i).getContents().trim()) || "1899-12-30".equals(sheet.getCell(2, i).getContents().trim())) && 
							("1900/1/0".equals(sheet.getCell(3, i).getContents().trim()) || "1899-12-30".equals(sheet.getCell(3, i).getContents().trim())) && 
							"0".equals(sheet.getCell(4, i).getContents().trim()) && "0".equals(sheet.getCell(5, i).getContents().trim()) && 
							"0".equals(sheet.getCell(6, i).getContents().trim()) && "0".equals(sheet.getCell(7, i).getContents().trim()) && 
							"".equals(sheet.getCell(8, i).getContents().trim()) && "".equals(sheet.getCell(9, i).getContents().trim()) && 
							"".equals(sheet.getCell(10, i).getContents().trim()) &&
							("1900/1/0  0:00:00".equals(sheet.getCell(11, i).getContents().trim()) || "1899-12-30 12:00:00".equals(sheet.getCell(11, i).getContents().trim())) && 
							"".equals(sheet.getCell(12, i).getContents().trim())) { // 模板内
						break;
					}
					if ("".equals(sheet.getCell(0, i).getContents().trim()) || "".equals(sheet.getCell(1, i).getContents().trim()) || 
							"".equals(sheet.getCell(2, i).getContents().trim()) || "".equals(sheet.getCell(3, i).getContents().trim()) || 
							"".equals(sheet.getCell(4, i).getContents().trim()) || "".equals(sheet.getCell(5, i).getContents().trim()) ||
							"".equals(sheet.getCell(6, i).getContents().trim()) || "".equals(sheet.getCell(7, i).getContents().trim()) ||
							"".equals(sheet.getCell(8, i).getContents().trim()) || "".equals(sheet.getCell(9, i).getContents().trim()) ||
							"".equals(sheet.getCell(10, i).getContents().trim()) || "".equals(sheet.getCell(11, i).getContents().trim()) ||
							"".equals(sheet.getCell(12, i).getContents().trim())) { // 验证数据的完整性
						result = "1";
						break;
					} else {
						String userId = sheet.getCell(0, i).getContents().trim();
						Pattern regUserIdPattern = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$");
						Matcher regUserIdMatcher = regUserIdPattern.matcher(userId);
						if (!regUserIdMatcher.matches()) { // 验证手机号输入是否正确
							result = "2";
							break;
						} else {
							UserModel isExistuserModel = userService.getByUserId(userId);
							if (isExistuserModel == null) { // 判断这个用户是否已经注册,
								result = "3";
								break;
							} else {
								String name = isExistuserModel.getUserName();
								String teamName = sheet.getCell(1, i).getContents().trim(); // 班组名称唯一
								String tId = null;
								String code = null;
								TeamModel teamModel = teamService.getTeamByName(teamName);
								if (teamModel == null) { // 判断班组是否存在
									result = "4";
									break;
								} else {
									tId = teamModel.getId();
									code = teamModel.getCode() + "";
									TeamMemberModel isExistTeamMemberModel = teamMemberService.userIdExistInTeam(userId, tId, 3); // 3表示这个工人在这个班组中
									if (isExistTeamMemberModel == null) {  // 表示这个工人不在当前的班组中
										result = "5";
										break;
									} else {
										// 在PayrollRecordModel中判断是否已存在某条记录
										String startDateStr = sheet.getCell(2, i).getContents().trim();
										String endDateStr = sheet.getCell(3, i).getContents().trim();
										String payTime = sheet.getCell(11, i).getContents().trim();
										String payTimeStr = payTime.substring(0, 10);
										Pattern ymdPattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
										Matcher ymdStartMatcher = ymdPattern.matcher(startDateStr);
										Matcher ymdEndMatcher = ymdPattern.matcher(endDateStr);
										Matcher payTimeMatcher = ymdPattern.matcher(payTimeStr);
										if (!ymdStartMatcher.matches() || !ymdEndMatcher.matches() || !payTimeMatcher.matches()) { //1900-01-00可能变成1900/1/0，导致不能正确截取
											result = "6";
											break;
										} else {
											String startDate = startDateStr.substring(0, 4) + startDateStr.substring(5, 7) + startDateStr.substring(8, 10);
											String endDate = endDateStr.substring(0, 4) + endDateStr.substring(5, 7) + endDateStr.substring(8, 10);
											String payMonth = payTime.substring(0, 4) + payTime.substring(5, 7);
											BasicDBObject queryObj = new BasicDBObject();
											queryObj.put("pCode", pCode);
											queryObj.put("confirm", 1);
											queryObj.put("code", code);
											queryObj.put("userId", userId);
											ModelUtils.queryDate(payMonth + "01", payMonth + "31", queryObj, "payTime");
											PayrollRecordModel isExistPayrollRecordModel = payrollRecordService.getPayrollRecordOnly(queryObj);
											if (isExistPayrollRecordModel != null) { // 判断某个用户的这个月的记录是否已经存在
												result = "7";
												break;
											} else {
												payrollRecordModel = new PayrollRecordModel();
												payrollRecordModel.setpCode(pCode);
												payrollRecordModel.setName(name);
												payrollRecordModel.setUserId(userId);
												payrollRecordModel.setCode(code);
												payrollRecordModel.setStartTime(startDate);
												payrollRecordModel.setEndTime(endDate);
												payrollRecordModel.setSalary(Integer.parseInt(sheet.getCell(4, i).getContents().trim()));
												payrollRecordModel.setRealSalary(Integer.parseInt(sheet.getCell(6, i).getContents().trim()));
												payrollRecordModel.setNoSalary(Integer.parseInt(sheet.getCell(7, i).getContents().trim()));
												payrollRecordModel.setTax(Integer.parseInt(sheet.getCell(5, i).getContents().trim()));
												payrollRecordModel.setDrawee(sheet.getCell(8, i).getContents().trim());
												if ("支付宝".equals(sheet.getCell(9, i).getContents().trim())) {
													payrollRecordModel.setPaytype(1);
												} else if ("微信".equals(sheet.getCell(9, i).getContents().trim())) {
													payrollRecordModel.setPaytype(2);
												} else if ("银行卡".equals(sheet.getCell(9, i).getContents().trim())) {
													payrollRecordModel.setPaytype(3);
												} else {
													payrollRecordModel.setPaytype(4);
												}
												payrollRecordModel.setSerial(sheet.getCell(10, i).getContents().trim());
												payrollRecordModel.setConfirm(1);
												long payTimeDate = ((DateCell) sheet.getCell(11, i)).getDate().getTime() - (8*60*60*1000);
												payrollRecordModel.setPayTime(new Date(payTimeDate));
												payrollRecordModel.setPayAccont(sheet.getCell(12, i).getContents().trim());
												payrollRecordModel.setpName(projectName);
												payrollRecordModel.settName(teamName);
												payrollRecordModels.add(payrollRecordModel);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count == 0 && !"1".equals(result) && !"2".equals(result) && !"3".equals(result) && !"4".equals(result) && !"5".equals(result) && !"6".equals(result) && !"7".equals(result)) {
			result = "8";
		}
		if ("0".equals(result)) {
			if (payrollRecordModels != null && !payrollRecordModels.isEmpty()) {
				for (PayrollRecordModel payrollRecordModel2 : payrollRecordModels) {
					payrollRecordService.addPayrollRecord(payrollRecordModel2);
				}
			}
		}
		return operateSalary(projectId ,result);
	}
	
	/**
	 * 跳转到出入记录页面
	 * @param id
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "operate_accrecord.html", method = RequestMethod.GET)
	public ModelAndView operateAccrecord(String id, String result) {
		ModelAndView mav = new ModelAndView("operate/operate_accrecord");
		ProjectModel projectModel = projectService.getById(id);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		mav.addObject("result", result);
		return mav;
	}
	
	/**
	 * 出入记录页面的搜索功能
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_getAccRecord.html", method = RequestMethod.POST)
	public ModelAndView operateGetAccRecord(String projectId) {
		ModelAndView mav = new ModelAndView("operate/operate_accrecord");
		ProjectModel projectModel = projectService.getById(projectId);
		String pCode = null;
		long dataCount = 0;
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
			pCode = projectModel.getpCode();
		}
		String workMonth = request.getParameter("workMonth").trim();
		String teamMemberName = request.getParameter("teamMemberName").trim();
		String teamName = request.getParameter("teamName").trim();
		String startDateStr = workMonth + "01";
		String endDateStr = workMonth + "31";
		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(pCode)) {
			queryObj.put("pCode", pCode);
		}
		if (StringUtils.isNotBlank(teamMemberName)) {
			queryObj.put("name", teamMemberName);
		}
		if (StringUtils.isNotBlank(teamName)) {
			queryObj.put("tName", teamName);
		}
		queryObj.put("confirm", 1);
		ModelUtils.queryDate(startDateStr, endDateStr, queryObj, "recordTime");
		dataCount = accrecordService.countAllAccrecord(queryObj);
		List<AccrecordModel> models = new ArrayList<AccrecordModel>();
		List<AccrecordModel> aModels = accrecordService.getList(queryObj);
		if (aModels != null && !aModels.isEmpty()) {
			for (AccrecordModel accrecordModel : aModels) {
				TeamModel teamModel = teamService.getTeamByCode(Long.parseLong(accrecordModel.getCode()));
				if (teamModel != null) {
					accrecordModel.settName(teamModel.getName());
				}
				models.add(accrecordModel);
			}
		}
		int pageNow = 1;
		if (request.getParameter("pageNowSelect") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowSelect"));
		}
		if (request.getParameter("pageNowFirst") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowFirst"));
		}
		if (request.getParameter("pageNowPre") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowPre"));
		}
		if (request.getParameter("pageNowNext") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowNext"));
		}
		if (request.getParameter("pageNowLast") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowLast"));
		}
		int pageSize = 20; //一页显示几条记录,默认20条
		if (request.getParameter("pageSizeTotal") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSizeTotal"));
		}
		int pageCount = 0;
		if (dataCount % pageSize == 0) {
			pageCount = (int) (dataCount / pageSize); 
		} else {
			pageCount = (int) (dataCount / pageSize + 1);
		}
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		if (page != null) {
			mav.addObject("page", page);
			List<AccrecordModel> accrecordModels = new ArrayList<AccrecordModel>();
			if (pageNow * pageSize < dataCount) {
				accrecordModels = models.subList((pageNow - 1) * pageSize, pageNow * pageSize);
			}
			else {
				accrecordModels = models.subList((pageNow - 1) * pageSize, (int) dataCount);
			}
			if (accrecordModels != null && !accrecordModels.isEmpty()) {
				mav.addObject("accrecordModels", accrecordModels);
			}
		}
		mav.addObject("workMonth", workMonth);
		mav.addObject("teamMemberName", teamMemberName);
		mav.addObject("teamName", teamName);
		mav.addObject("pCode", pCode);
		mav.addObject("projectId", projectId);
		mav.addObject("pageCount", pageCount);
		return mav;
	}
	
	// TODO 出入页面打印
	
	//出入页面导出Excel	rkai
	@RequestMapping(value = "accRecord.html", method = RequestMethod.GET)
	public void accRecordToExcel(HttpServletResponse response,
			String pCode,String workMonth,String teamMemberName,String projectId) throws UnsupportedEncodingException
	{
		String teamName = new String(request.getParameter("teamName").getBytes(
				"iso-8859-1"), "utf-8");
		ProjectModel projectModel = projectService.getById(projectId);
		String projectName=projectModel.getName();
		@SuppressWarnings("unused")
		long dataCount = 0;
		String startDateStr = workMonth + "01";
		String endDateStr = workMonth + "31";
		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(pCode)) {
			queryObj.put("pCode", pCode);
		}
		if (StringUtils.isNotBlank(teamMemberName)) {
			queryObj.put("name", teamMemberName);
		}
		if (StringUtils.isNotBlank(teamName)) {
			queryObj.put("tName", teamName);
		}
		queryObj.put("confirm", 1);
		ModelUtils.queryDate(startDateStr, endDateStr, queryObj, "recordTime");
		dataCount = accrecordService.countAllAccrecord(queryObj);
		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 0;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		List<AccrecordModel> accrecordModels = new ArrayList<AccrecordModel>();
		List<AccrecordModel> aModels = accrecordService.getAccrecordList(queryObj, pageNow, pageSize);
		if (aModels != null && !aModels.isEmpty()) {
			for (AccrecordModel accrecordModel : aModels) {
				TeamModel teamModel = teamService.getTeamByCode(Long.parseLong(accrecordModel.getCode()));
				if (teamModel != null) {
					accrecordModel.settName(teamModel.getName());
					accrecordModel.setpName(projectName);
				}
				accrecordModels.add(accrecordModel);
			}
		}
		// 表头 项目名称	班组名称	姓名	出入时间	进场/离场
		String[] tTitle = { "序号","项目名称", "班组名称", "姓名", "出入时间", 
				            "进场/离场"};
		String[] dateFiled = { "recordTime" };// 需要转化时间格式的字段名
		Date ctime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String currentTime = formatter.format(ctime); 
		String fileName=teamName+"出入记录"+currentTime;
		String tableName="accRecord";
		int needIndex[]={100,8,9,2,5,7};//需要输入excel表格的字段及次序
		try {
			ExportExcel.recoredExportExcel(response, tableName,tTitle, fileName,needIndex, accrecordModels,
					dateFiled);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 出入记录的EXCEL模板文件
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "operate_accrecordDownloadExcel.html", method = RequestMethod.GET)
	public void operateAccrecordDownloadExcel(HttpServletRequest request, HttpServletResponse response) {
		String filePath = Config.getInstance().getRootPath() + "exceltemplate/recordAccrecord.xml";
		DownLoadExcelTemplateUtil.getExcelTemplate(filePath, request, response);
	}
	
	/**
	 * 出入记录的导入功能
	 * @param pCodec
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "operate_accrecordImportExcel.html", method = RequestMethod.POST)
	public ModelAndView operateAccrecordImportExcel(String pCode, HttpServletRequest request, HttpServletResponse response) {
		String result = "0";
		String projectId = null;
		String projectName = null;
		ProjectModel projectModel = projectService.getByPCode(pCode);
		if (projectModel != null) {
			projectId = projectModel.getId();
			projectName = projectModel.getName();
		}
		String filePath = request.getSession().getServletContext().getRealPath("\\resource\\execl\\import\\record_accrecord") + "\\" + projectId;
		String fileName = ImportExcel.createDateExcel(filePath, config, request, response);
		AccrecordModel accrecordModel = null;
		List<AccrecordModel> accrecordModels = new ArrayList<AccrecordModel>();
		Workbook workbook = null;
		int count = -1; // 用于判断是否为空的EXCEL
		try {
			workbook = Workbook.getWorkbook(new java.io.File(filePath + "\\" + fileName)); // 创建Workbook	
			Sheet sheet = workbook.getSheet(0);	// 获取第一个工作簿Sheet
			if (!("进退场记录导入".equals(sheet.getCell(0, 0).getContents().trim()) && "工人手机号".equals(sheet.getCell(0, 1).getContents().trim()) &&
					"班组名称".equals(sheet.getCell(1, 1).getContents().trim()) && "打卡时间".equals(sheet.getCell(2, 1).getContents().trim()) &&
					"进退场".equals(sheet.getCell(3, 1).getContents().trim()))) { // 判断导入模板是否正确
				result = "8";
			} else {
				for (int i = 2; i < sheet.getRows(); i++) {	// 获取数据
					count++;
					if ("".equals(sheet.getCell(0, i).getContents().trim()) && "".equals(sheet.getCell(1, i).getContents().trim()) && 
							"".equals(sheet.getCell(2, i).getContents().trim()) && "".equals(sheet.getCell(3, i).getContents().trim())) { // 模板外
						break;
					}
					if ("".equals(sheet.getCell(0, i).getContents().trim()) && "".equals(sheet.getCell(1, i).getContents().trim()) && 
							("1900/1/0  0:00:00".equals(sheet.getCell(2, i).getContents().trim()) || "1899-12-30 12:00:00".equals(sheet.getCell(2, i).getContents().trim())) && 
							"".equals(sheet.getCell(3, i).getContents().trim())) { // 模板内
						break;
					}
					if ("".equals(sheet.getCell(0, i).getContents().trim()) || "".equals(sheet.getCell(1, i).getContents().trim()) || 
							"".equals(sheet.getCell(2, i).getContents().trim()) || "".equals(sheet.getCell(3, i).getContents().trim())) { // 验证数据的完整性
						result = "1";
						break;
					} else {
						String userId = sheet.getCell(0, i).getContents().trim();
						Pattern regUserIdPattern = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$");
						Matcher regUserIdMatcher = regUserIdPattern.matcher(userId);
						if (!regUserIdMatcher.matches()) { // 验证手机号输入是否正确
							result = "2";
							break;
						} else {
							UserModel isExistuserModel = userService.getByUserId(userId);
							if (isExistuserModel == null) { // 判断这个用户是否已经注册,
								result = "3";
								break;
							} else {
								String name = isExistuserModel.getUserName();
								String teamName = sheet.getCell(1, i).getContents().trim(); // 班组名称唯一
								String tId = null;
								String code = null;
								TeamModel teamModel = teamService.getTeamByName(teamName);
								if (teamModel == null) { // 判断班组是否存在
									result = "4";
									break;
								} else {
									tId = teamModel.getId();
									code = teamModel.getCode() + "";
									TeamMemberModel isExistTeamMemberModel = teamMemberService.userIdExistInTeam(userId, tId, 3); // 3表示这个工人在这个班组中
									if (isExistTeamMemberModel == null) {  // 表示这个工人不在当前的班组中
										result = "5";
										break;
									} else {
										// 一个工人一天可能有好几次进退场，这里不用某天判断是否存在进退场记录
										String recordTime = sheet.getCell(2, i).getContents().trim();
										String recordTimeStr = recordTime.substring(0, 10);
										Pattern ymdPattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
										Matcher payTimeMatcher = ymdPattern.matcher(recordTimeStr);
										if (!payTimeMatcher.matches()) { //1900-01-00可能变成1900/1/0，导致不能正确截取
											result = "6";
											break;
										} else {
											accrecordModel = new AccrecordModel();
											accrecordModel.setpCode(pCode);
											accrecordModel.setName(name);
											accrecordModel.setUserId(userId);
											accrecordModel.setCode(code);
											long recordTimeDate = ((DateCell) sheet.getCell(2, i)).getDate().getTime() - (8*60*60*1000);
											accrecordModel.setRecordTime(new Date(recordTimeDate));
											accrecordModel.setConfirm(1);
											if ("进场".equals(sheet.getCell(3, i).getContents().trim())) {
												accrecordModel.setType(0);
											} else {
												accrecordModel.setType(1);
											}
											accrecordModel.setpName(projectName);
											accrecordModel.settName(teamName);
											accrecordModels.add(accrecordModel);
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count == 0 && !"1".equals(result) && !"2".equals(result) && !"3".equals(result) && !"4".equals(result) && !"5".equals(result) && !"6".equals(result)) {
			result = "7";
		}
		if ("0".equals(result)) {
			if (accrecordModels != null && !accrecordModels.isEmpty()) {
				for (AccrecordModel accrecordModel2 : accrecordModels) {
					accrecordService.addAccrecord(accrecordModel2);
				}
			}
		}
		return operateAccrecord(projectId ,result);
	}
	
	// 项目操作员—奖惩
	/**
	 * 项目奖惩-zss
	 * @return
	 */
	@RequestMapping(value="operate_rewardsandpunish.html")
	public ModelAndView rewardsAndPunish(String id){
		//rewardsAndPunishService.add(0, "pId", "code", "name","teamName", "userId", "character", "measure");
		List<RewardsAndPunishModel> leaderList = rewardsAndPunishService.getListByPId(id, 1);
		List<RewardsAndPunishModel> workerList = rewardsAndPunishService.getListByPId(id, 0);
		ModelAndView mav = new ModelAndView("operate/operate_rewardsandpunish");
		mav.addObject("leaderList", leaderList);
		mav.addObject("workerList", workerList);
		ProjectModel projectModel = projectService.getById(id);
		mav.addObject("projectModel", projectModel);
		return mav;
	}
	
	/**
	 * 项目奖惩--根据id删除一条奖惩信息-zss
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="deleteOne.html")
	public String deleteRewardsAndPunish(String id,HttpSession session, String pId){
		rewardsAndPunishService.deleteById(id);
		return "redirect:operate_rewardsandpunish.html?id="+pId;
	}
	
	/**
	 * 跳转到添加奖惩信息页面 -zss
	 * @return
	 */
	@RequestMapping(value="toAddRewardsAndPunish.html")
	public ModelAndView toAddRewardsAndPunish(int type,HttpSession session,String pId){
		//跳转到页面之前，生成一个token令牌并存入session			//----------token---------------
		NoRepeateSubmit.createSession(request);				//----------token---------------
		ModelAndView mav = new ModelAndView("operate/operate_addrewardsandpunish");
		List<TeamModel> teamList = rewardsAndPunishService.getTeamList(session);
		mav.addObject("type", type);
		mav.addObject("teamList", teamList);
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		ProjectModel projectModel = null;
		if (userId != null) {
			projectModel = projectService.getByUserId(userId);
			if (projectModel != null) {
				mav.addObject("projectModel", projectModel);
			}
		}
		return mav;
	}
	
	/**
	 * 添加一个奖惩记录-zss
	 * @param rewardsAndPunishModel
	 * @return
	 */
	@RequestMapping(value="addRewardsAndPunish.html")
	public String addRewardsAndPunish(RewardsAndPunishModel rewardsAndPunishModel,HttpSession session, String token,String pId){
		
		//判断是否重复提交
		boolean isRepeat = NoRepeateSubmit.isRepeatSubmit(request,token);//----------token---------------
		if(isRepeat){//如果重复提交了，直接返回								//----------token---------------
			return "redirect:operate_rewardsandpunish.html?id="+pId;	//----------token---------------
		}																//----------token---------------
		//非重复提交，清除session中的token,执行添加代码						//----------token---------------
		request.getSession().removeAttribute("token");					//----------token---------------
		rewardsAndPunishService.addRewardsAndPunish(rewardsAndPunishModel, session);
//		rewardsAndPunishService.add(1, "pId", "code", "name","teamName", "userId", "character", "measure");
		return "redirect:operate_rewardsandpunish.html?id="+pId;	
	}
	
	/**
	 * 项目信息页面
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_info.html", method = RequestMethod.GET)
	public ModelAndView operateInfo(String id) {
		ModelAndView mav = new ModelAndView("operate/operate_info");
		ProjectModel projectModel = projectService.getById(id);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		return mav;
	}
	
	/**
	 * 项目-班组管理页面
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_team.html", method = RequestMethod.GET)
	public ModelAndView operateTeam(String id) {
		ModelAndView mav = new ModelAndView("operate/operate_team");
		ProjectModel projectModel = projectService.getById(id);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		List<ProjectDepartmentModel> projectDepartmentModels = projectDepartmentService.getByProjectId(id, 3);
		CommentsModel commentsModel = null;
		TeamModel teamModel = null;
		TeamCommentVo teamCommentVo = null;
		List<TeamCommentVo> teamCommentVos = new ArrayList<TeamCommentVo>();
		MaterialModel materialModel = null;
		MaterialCommentVo materialCommentVo = null;
		List<MaterialCommentVo> materialCommentVos = new ArrayList<MaterialCommentVo>();
		EquipmentModel equipmentModel = null;
		EquipmentCommentVo equipmentCommentVo = null;
		List<EquipmentCommentVo> equipmentCommentVos = new ArrayList<EquipmentCommentVo>();
		if (projectDepartmentModels != null ) {
			for (ProjectDepartmentModel projectDepartmentModel : projectDepartmentModels) {
				if (1 == projectDepartmentModel.getType()) { // 施工班组
					teamCommentVo = new TeamCommentVo();
					teamModel = teamService.getTeamById(projectDepartmentModel.getVId());
					commentsModel = commentsService.getByVidAndPidAndType(projectDepartmentModel.getVId(), projectDepartmentModel.getPId(), 1);
					if (teamCommentVo != null) {
						teamCommentVo.setTeamModel(teamModel);
						teamCommentVo.setCommentsModel(commentsModel);
						teamCommentVo.setProjectDepartmentModel(projectDepartmentModel);
						teamCommentVos.add(teamCommentVo);
					}
					if (teamCommentVos != null && !teamCommentVos.isEmpty()) {
						mav.addObject("teamCommentVos", teamCommentVos);
					}
				}
				if (2 == projectDepartmentModel.getType()) { // 材料商
					materialCommentVo = new MaterialCommentVo();
					materialModel = materialService.getById(projectDepartmentModel.getVId());
					commentsModel = commentsService.getByVidAndPidAndType(projectDepartmentModel.getVId(), projectDepartmentModel.getPId(), 2);
					if (materialModel != null) {
						materialCommentVo.setMaterialModel(materialModel);
						materialCommentVo.setCommentsModel(commentsModel);
						materialCommentVo.setProjectDepartmentModel(projectDepartmentModel);
						materialCommentVos.add(materialCommentVo);
					}
					if (materialCommentVos != null && !materialCommentVos.isEmpty()) {
						mav.addObject("materialCommentVos", materialCommentVos);
					}
				}
				if (3 == projectDepartmentModel.getType()) { // 设备商
					equipmentCommentVo = new EquipmentCommentVo();
					equipmentModel = equipmentService.getById(projectDepartmentModel.getVId());
					commentsModel = commentsService.getByVidAndPidAndType(projectDepartmentModel.getVId(), projectDepartmentModel.getPId(), 3);
					if (equipmentModel != null) {
						equipmentCommentVo.setEquipmentModel(equipmentModel);
						equipmentCommentVo.setCommentsModel(commentsModel);
						equipmentCommentVo.setProjectDepartmentModel(projectDepartmentModel);
						equipmentCommentVos.add(equipmentCommentVo);
					}
					if (equipmentCommentVos != null && !equipmentCommentVos.isEmpty()) {
						mav.addObject("equipmentCommentVos", equipmentCommentVos);
					}
				}
			}
		}
		return mav;
	}
	
	/**
	 * 操作员修改项目的对应的标签
	 * @param projectDepartmentId
	 * @param pId
	 * @return
	 */
	@RequestMapping(value = "operate_tmeUpdateLabel.html", method = RequestMethod.POST)
	public ModelAndView operateTmeUpdateLabel(String projectDepartmentId, String pId) {
		String label = request.getParameter("label");
		ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getById(projectDepartmentId);
		if (projectDepartmentModel != null) {
			projectDepartmentModel.setLabel(label);
			projectDepartmentService.updateProjectDepartment(projectDepartmentModel);
		}
		return operateTeam(pId);
	}
	
	/**
	 * 点击班组、材料商、设备商名称显示其对应的花名册
	 * @param pdId
	 * @param response
	 */
	@RequestMapping(value = "operate_tmeShow.html", method = RequestMethod.POST)
	public void operateTmeShow(String pdId, String teamName, String teamLeaderName, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		UserTeamRosterVo userTeamRosterVo = null;
		List<UserTeamRosterVo> userTeamRosterVos = new ArrayList<UserTeamRosterVo>();
		ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getById(pdId);
		if (projectDepartmentModel != null) {
			String teamId = projectDepartmentModel.getVId();
			List<TeamMemberModel> teamMemberModels = teamMemberService.getBytIdAndStatus(teamId, 3); // 3表示status是User已加入Team状态
			if (teamMemberModels != null && !teamMemberModels.isEmpty()) {
				for (TeamMemberModel teamMemberModel : teamMemberModels) {
					userTeamRosterVo = new UserTeamRosterVo();
					TeamModel teamModel = teamService.getTeamById(teamMemberModel.gettId());
					userTeamRosterVo.setName(teamModel.getName());
					UserModel userModel = userService.getByUserId(teamMemberModel.getUserId());
					userTeamRosterVo.setUserModel(userModel);
					userTeamRosterVos.add(userTeamRosterVo);
				}
			}
		}
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("teamName", teamName);
		jsonObject1.put("teamLeaderName", teamLeaderName);
		jsonObjects.add(jsonObject1);
		if (userTeamRosterVos != null && !userTeamRosterVos.isEmpty()) {
			for (int i = 0; i < userTeamRosterVos.size(); i++) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("index", i + 1);
				jsonObject.put("userName", StringIsNull.isNull(userTeamRosterVos.get(i).getUserModel().getUserName()));
				if ("1".equals(userTeamRosterVos.get(i).getUserModel().getUserSex())) {
					jsonObject.put("userSex", "男");
				} else if ("2".equals(userTeamRosterVos.get(i).getUserModel().getUserSex())) {
					jsonObject.put("userSex", "女");
				} else {
					jsonObject.put("userSex", "");
				}
				jsonObject.put("skillBigTypeName", StringIsNull.isNull(userTeamRosterVos.get(i).getUserModel().getSkillBigTypeName()));
				jsonObject.put("userIdentity", StringIsNull.isNull(userTeamRosterVos.get(i).getUserModel().getUserIdentity()));
				jsonObject.put("userStreet", StringIsNull.isNull(userTeamRosterVos.get(i).getUserModel().getUserStreet()));
				jsonObject.put("userId", StringIsNull.isNull(userTeamRosterVos.get(i).getUserModel().getUserId()));
				jsonObjects.add(jsonObject);
			}
		}
		out.print(jsonObjects);
		out.flush();
		out.close();
	}
	
	/**
	 * 安全交底页面
	 * @param projectDepartmentId
	 * @return
	 */
	@RequestMapping(value = "operate_tmeSC.html", method = RequestMethod.GET)
	public ModelAndView operateTmeSC(String projectDepartmentId) {
		ModelAndView mav = new ModelAndView("operate/operate_tmeSC");
		ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getById(projectDepartmentId);
		if (projectDepartmentModel != null) {
			String tmeName = null;
			ProjectModel projectModel = projectService.getById(projectDepartmentModel.getPId());
			if (projectModel != null) {
				mav.addObject("projectModel", projectModel);
			}
			if (1 == projectDepartmentModel.getType()) {
				TeamModel teamModel = teamService.getTeamById(projectDepartmentModel.getVId());
				if (teamModel != null) {
					tmeName = teamModel.getName();
				}
			} else if (2 == projectDepartmentModel.getType()) {
				MaterialModel materialModel = materialService.getById(projectDepartmentModel.getVId());
				if (materialModel != null) {
					tmeName = materialModel.getName();
				}
			} else if (3 == projectDepartmentModel.getType()) {
				EquipmentModel equipmentModel = equipmentService.getById(projectDepartmentModel.getVId());
				if (equipmentModel != null) {
					tmeName = equipmentModel.getName();
				}
			}
			mav.addObject("tmeName", tmeName);
			mav.addObject("projectDepartmentModel", projectDepartmentModel);
		}
		return mav;
	}
	
	/**
	 * 班组信息安全交底附件功能
	 * @param response
	 * @param projectDepartmentId
	 * @return
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "operate_securityUploadImage.html", method = RequestMethod.POST)
	public ModelAndView operateSecurityUploadImage(HttpServletResponse response, String projectDepartmentId) {
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
			String filePath = IMageUploadInfo.BASEPATH.value + IMageUploadInfo.TMESECURITYCLARIFICAITON.value + projectDepartmentId;
			new ImageUpload().imageUpload(file, fileName, filePath, config, request, response);
			ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getById(projectDepartmentId);
			if (projectDepartmentModel != null) {
				projectDepartmentModel.setSecurityClarificaiton(fileName);
				projectDepartmentModel.setSecurityDate((new SimpleDateFormat("yyyy年MM月dd日")).format(dateCurrentTime));
				projectDepartmentService.updateProjectDepartment(projectDepartmentModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return operateTmeSC(projectDepartmentId);
	}
	
	/**
	 * 质量交底页面
	 * @param projectDepartmentId
	 * @return
	 */
	@RequestMapping(value = "operate_tmeQC.html", method = RequestMethod.GET)
	public ModelAndView operateTmeQC(String projectDepartmentId) {
		ModelAndView mav = new ModelAndView("operate/operate_tmeQC");
		ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getById(projectDepartmentId);
		if (projectDepartmentModel != null) {
			String tmeName = null;
			ProjectModel projectModel = projectService.getById(projectDepartmentModel.getPId());
			if (projectModel != null) {
				mav.addObject("projectModel", projectModel);
			}
			if (1 == projectDepartmentModel.getType()) {
				TeamModel teamModel = teamService.getTeamById(projectDepartmentModel.getVId());
				if (teamModel != null) {
					tmeName = teamModel.getName();
				}
			} else if (2 == projectDepartmentModel.getType()) {
				MaterialModel materialModel = materialService.getById(projectDepartmentModel.getVId());
				if (materialModel != null) {
					tmeName = materialModel.getName();
				}
			} else if (3 == projectDepartmentModel.getType()) {
				EquipmentModel equipmentModel = equipmentService.getById(projectDepartmentModel.getVId());
				if (equipmentModel != null) {
					tmeName = equipmentModel.getName();
				}
			}
			mav.addObject("tmeName", tmeName);
			mav.addObject("projectDepartmentModel", projectDepartmentModel);
		}
		return mav;
	}
	
	/**
	 * 班组信息质量交底附件功能
	 * @param response
	 * @param projectDepartmentId
	 * @return
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "operate_qualityUploadImage.html", method = RequestMethod.POST)
	public ModelAndView operateQualityUploadImage(HttpServletResponse response, String projectDepartmentId) {
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
			String filePath = IMageUploadInfo.BASEPATH.value + IMageUploadInfo.TMEQUALITYCLARIFICAITON.value + projectDepartmentId;
			ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getById(projectDepartmentId);
			if (projectDepartmentModel != null) {
				projectDepartmentModel.setQualityClarificaiton(fileName);
				projectDepartmentModel.setQualityDate((new SimpleDateFormat("yyyy年MM月dd日")).format(dateCurrentTime));
				projectDepartmentService.updateProjectDepartment(projectDepartmentModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return operateTmeQC(projectDepartmentId);
	}
	
	/**
	 * 班组管理删除施工班组
	 * @param vId
	 * @param pId
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "operate_delTeam.html", method = RequestMethod.GET)
	public ModelAndView operateDelTeam(String vId, String pId, int type) {
		ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.selectByPIdAndVIdAndType(pId, vId, type);
		if (projectDepartmentModel != null) {
			projectDepartmentService.deleteById(projectDepartmentModel.getId());
		}
		return operateTeam(pId);
	}
	
	/**
	 * 班组管理删除材料商
	 * @param vId
	 * @param pId
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "operate_delMaterial.html", method = RequestMethod.GET)
	public ModelAndView operateDelMaterial(String vId, String pId, int type) {
		ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.selectByPIdAndVIdAndType(pId, vId, type);
		if (projectDepartmentModel != null) {
			projectDepartmentService.deleteById(projectDepartmentModel.getId());
		}
		return operateTeam(pId);
	}
	
	/**
	 * 班组管理删除设备商
	 * @param vId
	 * @param pId
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "operate_delEquipment.html", method = RequestMethod.GET)
	public ModelAndView operateDelEquipment(String vId, String pId, int type) {
		ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.selectByPIdAndVIdAndType(pId, vId, type);
		if (projectDepartmentModel != null) {
			projectDepartmentService.deleteById(projectDepartmentModel.getId());
		}
		return operateTeam(pId);
	}
	
	/**
	 * 班组管理页面跳转到招聘施工班组页面
	 * @param projectId
	 * @return
	 */
	// 页面删除了这个按钮，下面这个代码没有用到，不建议删除页面，万一以后要用呢
	@RequestMapping(value = "operate_teamRecruit.html", method = RequestMethod.GET)
	public ModelAndView operateTeamRecruit(String projectId) {
		ModelAndView mav = new ModelAndView("operate/operate_teamRecruit");
		ProjectModel projectModel = projectService.getById(projectId);
		CompanyModel companyModel = null;
		RequirementsModel requirementsModel = null;
		if (projectModel != null) {
			String peojectCode = projectModel.getCode();
			companyModel = companyService.getByCode(peojectCode);
			requirementsModel = new RequirementsModel(); 
			mav.addObject("projectModel", projectModel);
		}
		if (companyModel != null) {
			mav.addObject("companyModel", companyModel);
		}
		if (requirementsModel != null) {
			mav.addObject("requirementsModel", requirementsModel);
		}
		return mav;
	}
	
	/**
	 * 获取施工班组的小技能类型
	 * @param skillBigType
	 * @param response
	 */
	// 页面删除了这个按钮，下面这个代码没有用到
	@RequestMapping(value = "operate_getTeamSkillSmallType.html", method = RequestMethod.POST)
	public void operateGetTeamSkillSmallType(String skillBigType, HttpServletResponse response) {
		int sbt = Integer.valueOf(skillBigType);
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
		PublicMethod.objectToJson(teamSkillSmallTypeVos,response);
	}
	
	/**
	 * 发布招聘班组的添加功能
	 * @return
	 */
	// 页面删除了这个按钮，下面这个代码没有用到
	@RequestMapping(value = "operate_teamRecruit2.html", method = RequestMethod.POST)
	public ModelAndView operateTeamRecruit2() {
		String projectId = request.getParameter("projectId");
		String title = request.getParameter("title");
		String skillBigType = request.getParameter("skillBigType");
		String skillSmallType = request.getParameter("skillSmallType");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String desc = request.getParameter("desc");
		String pCode = null;
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			pCode = projectModel.getpCode();
		}
		requirementsService.addRecruitTeam(title, pCode, skillBigType, skillSmallType, province, city, null, desc);
		return operateTeam(projectId);
	}
	
	/**
	 * 班组管理跳转到添加材料采购页面
	 * @return
	 */
	// 页面删除了这个按钮，下面这个代码没有用到
	@RequestMapping(value = "operate_materialRecruit.html", method = RequestMethod.GET)
	public ModelAndView operateMaterialRecruit(String projectId) {
		ModelAndView mav = new ModelAndView("operate/operate_materialRecruit");
		ProjectModel projectModel = projectService.getById(projectId);
		CompanyModel companyModel = null;
		if (projectModel != null) {
			String peojectCode = projectModel.getCode();
			companyModel = companyService.getByCode(peojectCode);
			mav.addObject("projectModel", projectModel);
		}
		if (companyModel != null) {
			mav.addObject("companyModel", companyModel);
		}
		return mav;
	}
	
	/**
	 * 发布材料采购的添加功能
	 * @return
	 */
	// 页面删除了这个按钮，下面这个代码没有用到
	@RequestMapping(value = "operate_materialRecruit2.html", method = RequestMethod.POST)
	public ModelAndView operateMaterialRecruit2() {
		String projectId = request.getParameter("projectId");
		String title = request.getParameter("title");
		String shopName = request.getParameter("shopName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String desc = request.getParameter("desc");
		String pCode = null;
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			pCode = projectModel.getpCode();
		}
		requirementsService.addRecruitMaterial(title, pCode, shopName, province, city, null, desc);
		return operateTeam(projectId);
	}
	
	/**
	 * 班组管理跳转到添加设备租赁页面
	 * @return
	 */
	// 页面删除了这个按钮，下面这个代码没有用到
	@RequestMapping(value = "operate_equipmentRecruit.html", method = RequestMethod.GET)
	public ModelAndView operateEquipmentRecruit(String projectId) {
		ModelAndView mav = new ModelAndView("operate/operate_equipmentRecruit");
		ProjectModel projectModel = projectService.getById(projectId);
		CompanyModel companyModel = null;
		if (projectModel != null) {
			String peojectCode = projectModel.getCode();
			companyModel = companyService.getByCode(peojectCode);
			mav.addObject("projectModel", projectModel);
		}
		if (companyModel != null) {
			mav.addObject("companyModel", companyModel);
		}
		return mav;
	}
	
	/**
	 * 发布设备租赁的添加功能
	 * @return
	 */
	// 页面删除了这个按钮，下面这个代码没有用到
	@RequestMapping(value = "operate_equipmentRecruit2.html", method = RequestMethod.POST)
	public ModelAndView operateEquipmentRecruit2() {
		String projectId = request.getParameter("projectId");
		String title = request.getParameter("title");
		String shopName = request.getParameter("shopName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String desc = request.getParameter("desc");
		String pCode = null;
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			pCode = projectModel.getpCode();
		}
		requirementsService.addRecruitEquip(title, pCode, shopName, province, city, null, desc);
		return operateTeam(projectId);
	}
	
	/**
	 * 邀请班组的显示页面
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_inviteTeam.html", method = RequestMethod.GET)
	public ModelAndView operateInviteTeam(String projectId) {
		ModelAndView mav = new ModelAndView("operate/operate_inviteTeam");
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		List<ProjectDepartmentModel> projectDepartmentModels = projectDepartmentService.getByProjectId(projectId, 2);
		TeamModel teamModel = null;
		int teamStarNum = 0;
		TeamCommentVo teamCommentVo = null;
		List<TeamCommentVo> teamCommentVos = new ArrayList<TeamCommentVo>();
		MaterialModel materialModel = null;
		int materialStarNum = 0;
		MaterialCommentVo materialCommentVo = null;
		List<MaterialCommentVo> materialCommentVos = new ArrayList<MaterialCommentVo>();
		EquipmentModel equipmentModel = null;
		int equipmentStarNum = 0;
		EquipmentCommentVo equipmentCommentVo = null;
		List<EquipmentCommentVo> equipmentCommentVos = new ArrayList<EquipmentCommentVo>();
		List<CommentsModel> commentsModels = new ArrayList<CommentsModel>();
		if (projectDepartmentModels != null) {
			for (ProjectDepartmentModel projectDepartmentModel : projectDepartmentModels) {
				if (1 == projectDepartmentModel.getType()) { // 施工班组
					teamCommentVo = new TeamCommentVo();
					teamModel = teamService.getTeamById(projectDepartmentModel.getVId());
					commentsModels = commentsService.getListByVId(projectDepartmentModel.getVId()); // 考虑多个对其的评论
					if (commentsModels != null) {
						int totalScore = 60;
						for (CommentsModel commentModel : commentsModels) {
							totalScore = totalScore + commentModel.getScore1() + commentModel.getScore2() + commentModel.getScore3();
						}
						teamStarNum = ModelUtils.score2star(totalScore);
					}
					else {
						teamStarNum = 3;
					}
					if (teamModel != null) {
						teamCommentVo.setProjectDepartmentModel(projectDepartmentModel);
						teamCommentVo.setTeamModel(teamModel);
						teamCommentVo.setStarNum(teamStarNum);
						teamCommentVos.add(teamCommentVo);
					}
					if (teamCommentVos != null && !teamCommentVos.isEmpty()) {
						mav.addObject("teamCommentVos", teamCommentVos);
					}
				}
				if (2 == projectDepartmentModel.getType()) { // 材料商
					materialCommentVo = new MaterialCommentVo();
					materialModel = materialService.getById(projectDepartmentModel.getVId());
					commentsModels = commentsService.getListByVId(projectDepartmentModel.getVId());
					if (commentsModels != null) {
						int totalSocre = 60;
						for (CommentsModel commentsModel : commentsModels) {
							totalSocre = totalSocre + commentsModel.getScore1() + commentsModel.getScore2() + commentsModel.getScore3();
						}
						materialStarNum = ModelUtils.score2star(totalSocre);
					}
					else {
						materialStarNum = 3;
					}
					if (materialModel != null) {
						materialCommentVo.setProjectDepartmentModel(projectDepartmentModel);
						materialCommentVo.setMaterialModel(materialModel);
						materialCommentVo.setStarNum(materialStarNum);
						materialCommentVos.add(materialCommentVo);
					}
					if (materialCommentVos != null && !materialCommentVos.isEmpty()) {
						mav.addObject("materialCommentVos", materialCommentVos);
					}
				}
				if (3 == projectDepartmentModel.getType()) { // 设备商
					equipmentCommentVo = new EquipmentCommentVo();
					equipmentModel = equipmentService.getById(projectDepartmentModel.getVId());
					commentsModels = commentsService.getListByVId(projectDepartmentModel.getVId());
					if (commentsModels != null) {
						int totalScore = 60;
						for (CommentsModel commentsModel : commentsModels) {
							totalScore = totalScore + commentsModel.getScore1() + commentsModel.getScore2() + commentsModel.getScore3();
						}
						equipmentStarNum = ModelUtils.score2star(totalScore);
					}
					else {
						equipmentStarNum = 3;
					}
					if (equipmentModel != null) {
						equipmentCommentVo.setProjectDepartmentModel(projectDepartmentModel);
						equipmentCommentVo.setEquipmentModel(equipmentModel);
						equipmentCommentVo.setStarNum(equipmentStarNum);
						equipmentCommentVos.add(equipmentCommentVo);
					}
					if (equipmentCommentVos != null && !equipmentCommentVos.isEmpty()) {
						mav.addObject("equipmentCommentVos", equipmentCommentVos);
					}
				}
			}
		}
		return mav;
	}
	
	/**
	 * 撤销对某个施工班组的邀请
	 * @param pdmId
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_delInviteTeam.html", method = RequestMethod.GET)
	public ModelAndView operateDelInviteTeam(String pdmId, String projectId, String sUserId, String rUserId) {
		ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getById(pdmId);
		if (projectDepartmentModel != null) {
			projectDepartmentModel.setStatus(0);
			projectDepartmentService.updatePDStatus(projectDepartmentModel);
		}
		messageService.delMessageByUserIds(sUserId, rUserId);
		return operateInviteTeam(projectId);
	}
	
	/**
	 * 撤销对某个材料商的邀请
	 * @param pdmId
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_delInviteMaterial.html", method = RequestMethod.GET)
	public ModelAndView operateDelInviteMaterial(String pdmId, String projectId, String sUserId, String rUserId) {
		ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getById(pdmId);
		if (projectDepartmentModel != null) {
			projectDepartmentModel.setStatus(0);
			projectDepartmentService.updatePDStatus(projectDepartmentModel);
		}
		messageService.delMessageByUserIds(sUserId, rUserId);
		return operateInviteTeam(projectId);
	}
	
	/**
	 * 撤销对某个设备商的邀请
	 * @param pdmId
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_delInviteEquipment.html", method = RequestMethod.GET)
	public ModelAndView operateDelInviteEquipment(String pdmId, String projectId, String sUserId, String rUserId) {
		ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getById(pdmId);
		if (projectDepartmentModel != null) {
			projectDepartmentModel.setStatus(0);
			projectDepartmentService.updatePDStatus(projectDepartmentModel);
		}
		messageService.delMessageByUserIds(sUserId, rUserId);
		return operateInviteTeam(projectId);
	}
	
	/**
	 * 已邀请的页面跳转到邀请页面
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_addInviteTeam.html", method = RequestMethod.GET)
	public ModelAndView operateAddInviteTeam(String projectId) {
		ModelAndView mav = new ModelAndView("operate/operate_addInviteTeam");
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		return mav;
	}
	
	/**
	 * 按条件搜索需要邀请的班组
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_searchTeam.html", method = RequestMethod.POST)
	public ModelAndView operateSearchTeam(String projectId) {
		ModelAndView mav = new ModelAndView("operate/operate_addInviteTeam");
		int teamType = Integer.parseInt(request.getParameter("teamType"));
		List<TeamModel> teamModels = new ArrayList<TeamModel>();
		List<MaterialModel> materialModels = new ArrayList<MaterialModel>();
		List<EquipmentModel> equipmentModels = new ArrayList<EquipmentModel>();
		RequirementsVo requirementsVo = null;
		List<RequirementsVo> requirementsTeamVos = new ArrayList<RequirementsVo>();
		List<RequirementsVo> requirementsMaterialVos = new ArrayList<RequirementsVo>();
		List<RequirementsVo> requirementsEquipmentVos = new ArrayList<RequirementsVo>();
		ProjectDepartmentModel projectDepartmentModel2 = null;
		ProjectDepartmentModel projectDepartmentModel3 = null;
		BasicDBObject queryObj = null;
		//目前只在TeamModel中关联status查询，在MaterialModel、EquipmentModel不关联查询status查询
		if (teamType == 1) { 
			queryObj = new BasicDBObject();
			queryObj.put("status", 0);
			String teamSkillBigType = request.getParameter("teamSkillBigType");
			if ("请选择技能类别".equals(teamSkillBigType)) {
				teamSkillBigType = null;
			}
			if (teamSkillBigType != null) {
				int skillBigType = Integer.parseInt(teamSkillBigType);
				queryObj.put("skillBigType", skillBigType);
				teamModels = teamService.getTeamList(queryObj);
				String teamSkillSmallType = request.getParameter("teamSkillSmallType");
				if ("请选择技能类型".equals(teamSkillSmallType)) {
					teamSkillSmallType = null;
				}
				if (teamSkillSmallType != null) {
					queryObj.put("skillSmallType", Integer.parseInt(teamSkillSmallType));
					teamModels = teamService.getTeamList(queryObj);
				}
			}
			if (teamModels != null && !teamModels.isEmpty()) {
				for (TeamModel teamModel : teamModels) {
					projectDepartmentModel2 = projectDepartmentService.getByVIdAndPIdAndStatusAndType(teamModel.getId(), projectId, 2, 1); //表示这个施工班组已经邀请中
					projectDepartmentModel3 = projectDepartmentService.getByVIdAndPIdAndStatusAndType(teamModel.getId(), projectId, 3, 1); //表示这个施工班组已经加入
					if (projectDepartmentModel2 == null && projectDepartmentModel3 == null) {
						requirementsVo = new RequirementsVo();
						requirementsVo.setTeamModel(teamModel);
						int teamStarNum = 0;
						List<CommentsModel> commentsModels = commentsService.getListByVId(teamModel.getId()); 
						if (commentsModels != null) {
							int totalScore = 60;
							for (CommentsModel commentModel : commentsModels) {
								totalScore = totalScore + commentModel.getScore1() + commentModel.getScore2() + commentModel.getScore3();
							}
							teamStarNum = ModelUtils.score2star(totalScore);
						}
						else {
							teamStarNum = 3;
						}
						requirementsVo.setStarNum(teamStarNum);
						requirementsTeamVos.add(requirementsVo);
					}
				}
			}
			if (requirementsTeamVos != null && !requirementsTeamVos.isEmpty()) {
				mav.addObject("requirementsTeamVos", requirementsTeamVos);
			}
		}
		else if (teamType == 2) {
			queryObj = new BasicDBObject();
			String shopName = request.getParameter("shopName").trim();
			if ("".equals(shopName)) { 
				shopName = null;
			}
			String province = request.getParameter("province");
			if ("请选择省份".equals(province)) {
				province = null;
			}
			String city = request.getParameter("city");
			if ("请选择城市".equals(city)) {
				city = null;
			}
			if (shopName != null && province == null) {
				queryObj.put("shopName", shopName);
				materialModels = materialService.getMaterialList(queryObj);
			}
			if (shopName != null && province != null) {
				queryObj.put("province", province);
				materialModels = materialService.getMaterialList(queryObj);
				if (city != null) {
					queryObj.put("city", city);
					materialModels = materialService.getMaterialList(queryObj);
				}
			}
			if (materialModels != null && !materialModels.isEmpty()) {
				for (MaterialModel materialModel : materialModels) {
					projectDepartmentModel2 = projectDepartmentService.getByVIdAndPIdAndStatusAndType(materialModel.getId(), projectId, 2, 2); //表示这个材料商已经被邀请
					projectDepartmentModel3 = projectDepartmentService.getByVIdAndPIdAndStatusAndType(materialModel.getId(), projectId, 3, 2); //表示这个材料商已经被邀请
					if (projectDepartmentModel2 == null && projectDepartmentModel3 == null) {
						requirementsVo = new RequirementsVo();
						requirementsVo.setMaterialModel(materialModel);
						int teamStarNum = 0;
						List<CommentsModel> commentsModels = commentsService.getListByVId(materialModel.getId()); 
						if (commentsModels != null) {
							int totalScore = 60;
							for (CommentsModel commentModel : commentsModels) {
								totalScore = totalScore + commentModel.getScore1() + commentModel.getScore2() + commentModel.getScore3();
							}
							teamStarNum = ModelUtils.score2star(totalScore);
						}
						else {
							teamStarNum = 3;
						}
						requirementsVo.setStarNum(teamStarNum);
						requirementsMaterialVos.add(requirementsVo);
					}
				}
			}
			if (requirementsMaterialVos != null && !requirementsMaterialVos.isEmpty()) {
				mav.addObject("requirementsMaterialVos", requirementsMaterialVos);
			}
		}
		else {
			queryObj = new BasicDBObject();
			String shopName = request.getParameter("shopName").trim();
			if ("".equals(shopName)) { 
				shopName = null;
			}
			String province = request.getParameter("province");
			if ("请选择省份".equals(province)) {
				province = null;
			}
			String city = request.getParameter("city");
			if ("请选择城市".equals(city)) {
				city = null;
			}
			if (shopName != null && province == null) {
				queryObj.put("shopName", shopName);
				equipmentModels = equipmentService.getMaterialList(queryObj);
			}
			if (shopName != null && province != null) {
				queryObj.put("province", province);
				equipmentModels = equipmentService.getMaterialList(queryObj);
				if (city != null) {
					queryObj.put("city", city);
					equipmentModels = equipmentService.getMaterialList(queryObj);
				}
			}
			if (equipmentModels != null && !equipmentModels.isEmpty()) {
				for (EquipmentModel equipmentModel : equipmentModels) {
					projectDepartmentModel2 = projectDepartmentService.getByVIdAndPIdAndStatusAndType(equipmentModel.getId(), projectId, 2, 3); //表示这个设备商已经被邀请
					projectDepartmentModel3 = projectDepartmentService.getByVIdAndPIdAndStatusAndType(equipmentModel.getId(), projectId, 3, 3); //表示这个设备商已经被邀请
					if (projectDepartmentModel2 == null && projectDepartmentModel3 == null) {
						requirementsVo = new RequirementsVo();
						requirementsVo.setEquipmentModel(equipmentModel);
						int teamStarNum = 0;
						List<CommentsModel> commentsModels = commentsService.getListByVId(equipmentModel.getId()); 
						if (commentsModels != null) {
							int totalScore = 60;
							for (CommentsModel commentModel : commentsModels) {
								totalScore = totalScore + commentModel.getScore1() + commentModel.getScore2() + commentModel.getScore3();
							}
							teamStarNum = ModelUtils.score2star(totalScore);
						}
						else {
							teamStarNum = 3;
						}
						requirementsVo.setStarNum(teamStarNum);
						requirementsEquipmentVos.add(requirementsVo);
					}
				}
			}
			if (requirementsEquipmentVos != null && !requirementsEquipmentVos.isEmpty()) {
				mav.addObject("requirementsEquipmentVos", requirementsEquipmentVos);
			}
		}
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		mav.addObject("teamType", teamType);
		return mav;
	}
	
	/**
	 * 邀请某个班组
	 * @param vId
	 * @param projectId
	 * @param teamType
	 * @param requirementsId
	 */
	@RequestMapping(value = "operate_inviteOneTeam.html", method = RequestMethod.GET)
	public ModelAndView operateInviteOneTeam(String vId, String projectId, String teamType, String sUserId, String rUserId) {
		ProjectDepartmentModel pdModel = projectDepartmentService.getByVIdAndPIdAndStatus(vId, projectId, 0);
		if (pdModel != null) {
			pdModel.setStatus(2);
			projectDepartmentService.updateProjectDepartment(pdModel); //添加到ProjectDepartment中，关联起来
		} else {
			ProjectDepartmentModel projectDepartmentModel = new ProjectDepartmentModel();
			int teamTypeNum = Integer.parseInt(teamType);
			projectDepartmentModel.setVId(vId);
			projectDepartmentModel.setPId(projectId);
			projectDepartmentModel.setStatus(2);
			projectDepartmentModel.setType(teamTypeNum);
			projectDepartmentModel.setCreateTime(new Date());
			TeamModel teamModel = teamService.getTeamById(vId);
			if (teamModel != null) {
				projectDepartmentModel.setName(teamModel.getName());
			}
			projectDepartmentService.addProjectDepartment(projectDepartmentModel); //添加到ProjectDepartment中，关联起来
		}
		messageService.addMessageByParms(rUserId, UserType.PersonType.desc, sUserId, UserType.OperateType.desc, "邀请您的班组参加该项目", "0"); // 0表示其反馈的信息，isFeedback 
		return operateInviteTeam(projectId);
	}
	
	/**
	 * 邀请某个材料商
	 * @param vId
	 * @param projectId
	 * @param teamType
	 * @return
	 */
	@RequestMapping(value = "operate_inviteOneMaterial.html", method = RequestMethod.GET)
	public ModelAndView operateInviteOneMaterial(String vId, String projectId, String teamType, String sUserId, String rUserId) {
		ProjectDepartmentModel pdModel = projectDepartmentService.getByVIdAndPIdAndStatus(vId, projectId, 0);
		if (pdModel != null) {
			pdModel.setStatus(2);
			projectDepartmentService.updateProjectDepartment(pdModel); //添加到ProjectDepartment中，关联起来
		} else {
			ProjectDepartmentModel projectDepartmentModel = new ProjectDepartmentModel();
			int teamTypeNum = Integer.parseInt(teamType);
			projectDepartmentModel.setVId(vId);
			projectDepartmentModel.setPId(projectId);
			projectDepartmentModel.setStatus(2);
			projectDepartmentModel.setType(teamTypeNum);
			projectDepartmentModel.setCreateTime(new Date());
			MaterialModel materialModel = materialService.getById(vId);
			if (materialModel != null) {
				projectDepartmentModel.setName(materialModel.getName());
			}
			projectDepartmentService.addProjectDepartment(projectDepartmentModel); //添加到ProjectDepartment中，关联起来
		}
		messageService.addMessageByParms(rUserId, UserType.MaterialType.desc, sUserId, UserType.OperateType.desc, "邀请您的班组参加该项目", "0"); 
		return operateInviteTeam(projectId);
	}
	
	/**
	 * 邀请某个设备商
	 * @param vId
	 * @param projectId
	 * @param teamType
	 * @return
	 */
	@RequestMapping(value = "operate_inviteOneEquipment.html", method = RequestMethod.GET)
	public ModelAndView operateInviteOneEquipment(String vId, String projectId, String teamType, String sUserId, String rUserId) {
		ProjectDepartmentModel pdModel = projectDepartmentService.getByVIdAndPIdAndStatus(vId, projectId, 0);
		if (pdModel != null) {
			pdModel.setStatus(2);
			projectDepartmentService.updateProjectDepartment(pdModel); //添加到ProjectDepartment中，关联起来
		} else {
			ProjectDepartmentModel projectDepartmentModel = new ProjectDepartmentModel();
			int teamTypeNum = Integer.parseInt(teamType);
			projectDepartmentModel.setVId(vId);
			projectDepartmentModel.setPId(projectId);
			projectDepartmentModel.setStatus(2);
			projectDepartmentModel.setType(teamTypeNum);
			projectDepartmentModel.setCreateTime(new Date());
			EquipmentModel equipmentModel = equipmentService.getById(vId);
			if (equipmentModel != null) {
				projectDepartmentModel.setName(equipmentModel.getName());
			}
			projectDepartmentService.addProjectDepartment(projectDepartmentModel); //添加到ProjectDepartment中，关联起来
		}
		messageService.addMessageByParms(rUserId, UserType.EquipmentType.desc, sUserId, UserType.OperateType.desc, "邀请您的班组参加该项目", "0"); 
		return operateInviteTeam(projectId);
	}
	
	/**
	 * 跳转到审核班组页面
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_auditTeam.html", method = RequestMethod.GET)
	public ModelAndView projectToAuditTeam(String projectId) {
		ModelAndView mav = new ModelAndView("operate/operate_auditTeam");
		List<ProjectDepartmentModel> projectDepartmentModels = projectDepartmentService.getByProjectId(projectId, 1); // 1表示status字段 - 申请中
		TeamModel teamModel = null;
		int teamStarNum = 0;
		TeamCommentVo teamCommentVo = null;
		List<TeamCommentVo> teamCommentVos = new ArrayList<TeamCommentVo>();
		MaterialModel materialModel = null;
		int materialStarNum = 0;
		MaterialCommentVo materialCommentVo = null;
		List<MaterialCommentVo> materialCommentVos = new ArrayList<MaterialCommentVo>();
		EquipmentModel equipmentModel = null;
		int equipmentStarNum = 0;
		EquipmentCommentVo equipmentCommentVo = null;
		List<EquipmentCommentVo> equipmentCommentVos = new ArrayList<EquipmentCommentVo>();
		List<CommentsModel> commentsModels = new ArrayList<CommentsModel>();
		if (projectDepartmentModels != null) {
			for (ProjectDepartmentModel projectDepartmentModel : projectDepartmentModels) {
				if (1 == projectDepartmentModel.getType()) { // 施工班组
					teamCommentVo = new TeamCommentVo();
					teamModel = teamService.getTeamById(projectDepartmentModel.getVId());
					commentsModels = commentsService.getListByVId(projectDepartmentModel.getVId()); 
					if (commentsModels != null) {
						int totalScore = 60;
						for (CommentsModel commentModel : commentsModels) {
							totalScore = totalScore + commentModel.getScore1() + commentModel.getScore2() + commentModel.getScore3();
						}
						teamStarNum = ModelUtils.score2star(totalScore);
					}
					else {
						teamStarNum = 3;
					}
					if (teamModel != null) {
						teamCommentVo.setProjectDepartmentModel(projectDepartmentModel);
						teamCommentVo.setTeamModel(teamModel);
						teamCommentVo.setStarNum(teamStarNum);
						teamCommentVos.add(teamCommentVo);
					}
					if (teamCommentVos != null && !teamCommentVos.isEmpty()) {
						mav.addObject("teamCommentVos", teamCommentVos);
					}
				}
				if (2 == projectDepartmentModel.getType()) { // 材料商
					materialCommentVo = new MaterialCommentVo();
					materialModel = materialService.getById(projectDepartmentModel.getVId());
					commentsModels = commentsService.getListByVId(projectDepartmentModel.getVId());
					if (commentsModels != null) {
						int totalSocre = 60;
						for (CommentsModel commentsModel : commentsModels) {
							totalSocre = totalSocre + commentsModel.getScore1() + commentsModel.getScore2() + commentsModel.getScore3();
						}
						materialStarNum = ModelUtils.score2star(totalSocre);
					}
					else {
						materialStarNum = 3;
					}
					if (materialModel != null) {
						materialCommentVo.setProjectDepartmentModel(projectDepartmentModel);
						materialCommentVo.setMaterialModel(materialModel);
						materialCommentVo.setStarNum(materialStarNum);
						materialCommentVos.add(materialCommentVo);
					}
					if (materialCommentVos != null && !materialCommentVos.isEmpty()) {
						mav.addObject("materialCommentVos", materialCommentVos);
					}
				}
				if (3 == projectDepartmentModel.getType()) { // 设备商
					equipmentCommentVo = new EquipmentCommentVo();
					equipmentModel = equipmentService.getById(projectDepartmentModel.getVId());
					commentsModels = commentsService.getListByVId(projectDepartmentModel.getVId());
					if (commentsModels != null) {
						int totalScore = 60;
						for (CommentsModel commentsModel : commentsModels) {
							totalScore = totalScore + commentsModel.getScore1() + commentsModel.getScore2() + commentsModel.getScore3();
						}
						equipmentStarNum = ModelUtils.score2star(totalScore);
					}
					else {
						equipmentStarNum = 3;
					}
					if (equipmentModel != null) {
						equipmentCommentVo.setProjectDepartmentModel(projectDepartmentModel);
						equipmentCommentVo.setEquipmentModel(equipmentModel);
						equipmentCommentVo.setStarNum(equipmentStarNum);
						equipmentCommentVos.add(equipmentCommentVo);
					}
					if (equipmentCommentVos != null && !equipmentCommentVos.isEmpty()) {
						mav.addObject("equipmentCommentVos", equipmentCommentVos);
					}
				}
			}
		}
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		return mav;
	}
	
	/**
	 * 对某个施工班组的申请表示通过
	 * @param pdmId - projectDepartmentModel的ID
	 * @param projectId - Project的ID
	 * @return
	 */
	@RequestMapping(value = "operate_teamAgree.html", method = RequestMethod.GET)
	public ModelAndView operateTeamAgree(String pdmId, String projectId) {
		return projectDepartmentAgreeOrReject(pdmId, projectId, 3);
	}
	
	/**
	 * 对某个施工班组的申请表示拒绝
	 * @param pdmId - projectDepartmentModel的ID
	 * @param projectId - Project的ID
	 * @return
	 */
	@RequestMapping(value = "operate_teamReject.html", method = RequestMethod.GET)
	public ModelAndView operateTeamReject(String pdmId, String projectId) {
		return projectDepartmentAgreeOrReject(pdmId, projectId, 0);
	}
	
	/**
	 * 对多个施工班组的申请表示通过（批量申请）
	 * @param ids 多个施工班组的ID
	 * @param response
	 */
	@RequestMapping(value = "operate_teamAgreeAll.html", method = RequestMethod.POST)
	public void operateTeamAgreeAll(String ids, HttpServletResponse response) {
		projectDepartmentAgreeOrRejectAll(ids, response, 3);
	}
	
	/**
	 * 对多个施工班组的申请表示拒绝（批量申请）
	 * @param ids 多个施工班组的ID
	 * @param response
	 */
	@RequestMapping(value = "operate_teamRejectAll.html", method = RequestMethod.POST)
	public void operateTeamRejectAll(String ids, HttpServletResponse response) {
		projectDepartmentAgreeOrRejectAll(ids, response, 0);
	}
	
	/**
	 * 对某个材料商的申请表示通过
	 * @param pdmId
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_materialAgree.html", method = RequestMethod.GET)
	public ModelAndView operateMaterialAgree(String pdmId, String projectId) {
		return projectDepartmentAgreeOrReject(pdmId, projectId, 3);
	}
	
	/**
	 * 对某个材料商的申请表示拒绝
	 * @param pdmId
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_materialReject.html", method = RequestMethod.GET)
	public ModelAndView operateMaterialReject(String pdmId, String projectId) {
		return projectDepartmentAgreeOrReject(pdmId, projectId, 0);
	}
	
	/**
	 * 对多个材料商的申请表示通过（批量申请）
	 * @param ids
	 * @param response
	 */
	@RequestMapping(value = "operate_materialAgreeAll.html", method = RequestMethod.POST)
	public void operateMaterialAgreeAll(String ids, HttpServletResponse response) {
		projectDepartmentAgreeOrRejectAll(ids, response, 3);
	}
	
	/**
	 * 对多个拒绝的申请表示拒绝（批量申请）
	 * @param ids
	 * @param response
	 */
	@RequestMapping(value = "operate_materialRejectAll.html", method = RequestMethod.POST)
	public void operateMaterialRejectAll(String ids, HttpServletResponse response) {
		projectDepartmentAgreeOrRejectAll(ids, response, 0);
	}
	
	/**
	 * 对某个设备商的申请表示通过
	 * @param pdmId
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_equipmentAgree.html", method = RequestMethod.GET)
	public ModelAndView operateEquipmentAgree(String pdmId, String projectId) {
		return projectDepartmentAgreeOrReject(pdmId, projectId, 3);
	}
	
	/**
	 * 对某个设备商的申请表示拒绝
	 * @param pdmId
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_equipmentReject.html", method = RequestMethod.GET)
	public ModelAndView operateEquipmentReject(String pdmId, String projectId) {
		return projectDepartmentAgreeOrReject(pdmId, projectId, 0);
	}
	
	/**
	 * 对多个设备商的申请表示同意（批量申请）
	 * @param ids
	 * @param response
	 */
	@RequestMapping(value = "operate_equipmentAgreeAll.html", method = RequestMethod.POST)
	public void operateEquipmentAgreeAll(String ids, HttpServletResponse response) {
		projectDepartmentAgreeOrRejectAll(ids, response, 3);
	}
	
	/**
	 * 对多个设备商的申请表示拒绝（批量申请）
	 * @param ids
	 * @param response
	 */
	@RequestMapping(value = "operate_equipmentRejectAll.html", method = RequestMethod.POST)
	public void operateEquipmentRejectAll(String ids, HttpServletResponse response) {
		projectDepartmentAgreeOrRejectAll(ids, response, 0);
	}
	
	/**
	 * 跳转到已审核班组页面
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_leaveTeam.html", method = RequestMethod.GET)
	public ModelAndView operateLeaveTeam(String projectId) {
		ModelAndView mav = new ModelAndView("operate/operate_leaveTeam");
		List<ProjectDepartmentModel> projectDepartmentModels = projectDepartmentService.getByProjectId(projectId, 4); // 4表示status字段 - 已结束或离开
		TeamModel teamModel = null;
		int teamStarNum = 0;
		TeamCommentVo teamCommentVo = null;
		List<TeamCommentVo> teamCommentVos = new ArrayList<TeamCommentVo>();
		MaterialModel materialModel = null;
		int materialStarNum = 0;
		MaterialCommentVo materialCommentVo = null;
		List<MaterialCommentVo> materialCommentVos = new ArrayList<MaterialCommentVo>();
		EquipmentModel equipmentModel = null;
		int equipmentStarNum = 0;
		EquipmentCommentVo equipmentCommentVo = null;
		List<EquipmentCommentVo> equipmentCommentVos = new ArrayList<EquipmentCommentVo>();
		List<CommentsModel> commentsModels = new ArrayList<CommentsModel>();
		if (projectDepartmentModels != null && !projectDepartmentModels.isEmpty()) {
			for (ProjectDepartmentModel projectDepartmentModel : projectDepartmentModels) {
				if (1 == projectDepartmentModel.getType()) { // 施工班组
					teamCommentVo = new TeamCommentVo();
					teamModel = teamService.getTeamById(projectDepartmentModel.getVId());
					commentsModels = commentsService.getListByVId(projectDepartmentModel.getVId());
					if (commentsModels != null) {
						int totalScore = 60;
						for (CommentsModel commentModel : commentsModels) {
							totalScore = totalScore + commentModel.getScore1() + commentModel.getScore2() + commentModel.getScore3();
						}
						teamStarNum = ModelUtils.score2star(totalScore);
					} else {
						teamStarNum = 3;
					}
					if (teamModel != null) {
						teamCommentVo.setProjectDepartmentModel(projectDepartmentModel);
						teamCommentVo.setTeamModel(teamModel);
						teamCommentVo.setStarNum(teamStarNum);
						teamCommentVos.add(teamCommentVo);
					}
					if (teamCommentVos != null && !teamCommentVos.isEmpty()) {
						mav.addObject("teamCommentVos", teamCommentVos);
					}
				}
				if (2 == projectDepartmentModel.getType()) { // 材料商
					materialCommentVo = new MaterialCommentVo();
					materialModel = materialService.getById(projectDepartmentModel.getVId());
					commentsModels = commentsService.getListByVId(projectDepartmentModel.getVId());
					if (commentsModels != null) {
						int totalSocre = 60;
						for (CommentsModel commentsModel : commentsModels) {
							totalSocre = totalSocre + commentsModel.getScore1() + commentsModel.getScore2() + commentsModel.getScore3();
						}
						materialStarNum = ModelUtils.score2star(totalSocre);
					}
					else {
						materialStarNum = 3;
					}
					if (materialModel != null) {
						materialCommentVo.setProjectDepartmentModel(projectDepartmentModel);
						materialCommentVo.setMaterialModel(materialModel);
						materialCommentVo.setStarNum(materialStarNum);
						materialCommentVos.add(materialCommentVo);
					}
					if (materialCommentVos != null && !materialCommentVos.isEmpty()) {
						mav.addObject("materialCommentVos", materialCommentVos);
					}
				}
				if (3 == projectDepartmentModel.getType()) { // 设备商
					equipmentCommentVo = new EquipmentCommentVo();
					equipmentModel = equipmentService.getById(projectDepartmentModel.getVId());
					commentsModels = commentsService.getListByVId(projectDepartmentModel.getVId());
					if (commentsModels != null) {
						int totalScore = 60;
						for (CommentsModel commentsModel : commentsModels) {
							totalScore = totalScore + commentsModel.getScore1() + commentsModel.getScore2() + commentsModel.getScore3();
						}
						equipmentStarNum = ModelUtils.score2star(totalScore);
					}
					else {
						equipmentStarNum = 3;
					}
					if (equipmentModel != null) {
						equipmentCommentVo.setProjectDepartmentModel(projectDepartmentModel);
						equipmentCommentVo.setEquipmentModel(equipmentModel);
						equipmentCommentVo.setStarNum(equipmentStarNum);
						equipmentCommentVos.add(equipmentCommentVo);
					}
					if (equipmentCommentVos != null && !equipmentCommentVos.isEmpty()) {
						mav.addObject("equipmentCommentVos", equipmentCommentVos);
					}
				}
			}
		}
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		return mav;
	}
	
	/**
	 * 跳转到已发布用工需求页面
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_need.html", method = RequestMethod.GET)
	public ModelAndView operateNeed(String id) {
		ModelAndView mav = new ModelAndView("operate/operate_need");
		ProjectModel projectModel = projectService.getById(id);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		List<RequirementsModel> requirementsTeamModels = requirementsService.getByRIdAndTypeAndStatusAndUserType(id, 2, 1, 1); //2表示邀请（招聘）, 1表示这个信息还有效，没有关闭,最后一个1表示是施工班组
		if (requirementsTeamModels != null && !requirementsTeamModels.isEmpty()) {
			mav.addObject("requirementsTeamModels", requirementsTeamModels);
		}
		List<RequirementsModel> requirementsMaterialModels = requirementsService.getByRIdAndTypeAndStatusAndUserType(id, 2, 1, 2); //2表示邀请（招聘）, 1表示这个信息还有效，没有关闭,最后一个2表示是材料商
		if (requirementsMaterialModels != null && !requirementsMaterialModels.isEmpty()) {
			mav.addObject("requirementsMaterialModels", requirementsMaterialModels);
		}
		List<RequirementsModel> requirementsEquipmentModels = requirementsService.getByRIdAndTypeAndStatusAndUserType(id, 2, 1, 3); //2表示邀请（招聘）, 1表示这个信息还有效，没有关闭,最后一个3表示是设备商
		if (requirementsEquipmentModels != null && !requirementsEquipmentModels.isEmpty()) {
			mav.addObject("requirementsEquipmentModels", requirementsEquipmentModels);
		}
		return mav;
	}
	
	/**
	 * 已发布的用工需求页面跳转到添加页面
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_addNeed.html", method = RequestMethod.GET)
	public ModelAndView operateAddNeed(String projectId) {
		ModelAndView mav = new ModelAndView("operate/operate_addNeed");
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		RequirementsModel requirementsModel = new RequirementsModel();
		mav.addObject("requirementsModel", requirementsModel);
		return mav;
	}
	
	/**
	 * 新增用工需求功能
	 * @return
	 */
	@RequestMapping(value = "operate_addNeed2.html ", method = RequestMethod.POST)
	public ModelAndView operateAddNeed2() {
		String projectId = request.getParameter("projectId");
		String userId = request.getParameter("userId");
		String title = request.getParameter("title");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String desc = request.getParameter("desc");
		int teamType = Integer.parseInt(request.getParameter("teamType"));
		RequirementsModel requirementsModel = new RequirementsModel();
		if (teamType == 1) {
			int skillBigType = Integer.parseInt(request.getParameter("skillBigType"));
			int skillSmallType = Integer.parseInt(request.getParameter("skillSmallType"));
			requirementsModel.setSkillBigType(skillBigType);
			requirementsModel.setSkillSmallType(skillSmallType);
		}
		else if(teamType == 2) {
			String shopName = request.getParameter("shopNameMaterial");
			requirementsModel.setShopName(shopName);
		}
		else {
			String shopName = request.getParameter("shopNameEquip");
			requirementsModel.setShopName(shopName);
		}
		requirementsModel.setTitle(title);
		requirementsModel.setProvince(province);
		requirementsModel.setCity(city);
		requirementsModel.setStreet(street);
		requirementsModel.setDesc(desc);
		requirementsModel.setTeamType(teamType);
		requirementsModel.setType(2);
		requirementsModel.setUserType(3);
		requirementsModel.setrId(projectId);
		requirementsModel.setStatus(1);
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			requirementsModel.setName(projectModel.getName());
			requirementsModel.setLeaderName(projectModel.getLeaderName());
		}
		requirementsService.addRequirementsModel(requirementsModel);
		return operateNeed(projectId);
	}
	
	/**
	 * 已发布用工需求施工班组记录进行撤销操作
	 * @param id
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_delTeamNeed.html", method = RequestMethod.GET)
	public ModelAndView operateDelNeed(String id, String projectId) {
		requirementsService.updateStatus(id, 0);
		return operateNeed(projectId);
	}

	/**
	 * 已发布用工需求材料商记录进行撤销操作
	 * @param id
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_delMaterialNeed.html", method = RequestMethod.GET)
	public ModelAndView operateDelMaterialNeed(String id, String projectId) {
		requirementsService.updateStatus(id, 0);
		return operateNeed(projectId);
	}
	
	/**
	 * 已发布用工需求设备商记录进行撤销操作
	 * @param id
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_delEquipmentNeed.html", method = RequestMethod.GET)
	public ModelAndView operateDelEquipmentNeed(String id, String projectId) {
		requirementsService.updateStatus(id, 0);
		return operateNeed(projectId);
	}
	
	/**
	 * 跳转到项目管理页面
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value = "operate_manage.html", method = RequestMethod.GET)
	public ModelAndView operateManage(String id) {
		ModelAndView mav = new ModelAndView("operate/operate_manage");
		ProjectModel projectModel = projectService.getById(id);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		List<JoinBuildModel> joinBuildModels = new ArrayList<JoinBuildModel>();
		List<KeyPersonModel> keyPersonModels = new ArrayList<KeyPersonModel>();
		if (projectModel != null) {
			joinBuildModels = joinBuildService.getBypCode(projectModel.getpCode());
			keyPersonModels = keyPersonService.getBypCode(projectModel.getpCode());
			mav.addObject("projectModel", projectModel);
		}
		if (joinBuildModels != null && !joinBuildModels.isEmpty()) {
			mav.addObject("joinBuildModels", joinBuildModels);
		}
		if (keyPersonModels != null && !keyPersonModels.isEmpty()) {
			mav.addObject("keyPersonModels", keyPersonModels);
		}
		return mav;
	}
	
	/**
	 * 企业中心项目详情的修改
	 * @return
	 */
	@RequestMapping(value = "operate_modfiyProject2.html", method = RequestMethod.POST)
	public ModelAndView operateModfiyProject2() {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int price = 0;
		if(!"".equals(request.getParameter("price"))){
			price = Integer.parseInt(request.getParameter("price"));
		}
		int prepaid = 0;
		if(!"".equals(request.getParameter("prepaid"))){
			prepaid = Integer.parseInt(request.getParameter("prepaid"));
		}
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String leaderName = request.getParameter("leaderName");
		String userId = request.getParameter("userId");
		String status = request.getParameter("status");
		int times = 0;
		if (!"".equals(request.getParameter("times"))) {
			times = Integer.parseInt(request.getParameter("times"));
		}
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
		ProjectModel projectModel = projectService.getById(id);
		if (projectModel != null) {
			projectModel.setName(name);
			projectModel.setPrice(price);
			projectModel.setProvince(province);
			projectModel.setCity(city);
			projectModel.setStreet(street);
			projectModel.setPrepaid(prepaid);
			projectModel.setLeaderName(leaderName);
			projectModel.setUserId(userId);
			projectModel.setTimes(times);
			projectModel.setStatus(Integer.valueOf(status));
			projectModel.setProgress(progress);
			projectModel.setProjectTitanic(projectTitanic);
			projectModel.setProjectlevel(projectlevel);
			projectModel.setProjectorgan(projectorgan);
			projectModel.setProvinceCode(provinceCode);
			projectModel.setReplytime(replytime);
			projectModel.setTotalarea(totalarea);
			projectModel.setPurpose(purpose);
			projectModel.setNature(nature);
			projectModel.setWorktime(worktime);
			projectModel.setType(type);
			projectService.updateProject(projectModel);
		}
		return operateManage(id);
	}
	
	/**
	 * 判断项目负责人的联系方式有没有被注册
	 * @param userId
	 * @param leaderName
	 * @param response
	 */
	@RequestMapping(value = "operate_projectUserIdReg.html", method = RequestMethod.POST)
	public void companyProjectUserIdReg(String userId, String leaderName, HttpServletResponse response) {
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
	 * 项目环节的添加与修改（若为空则是添加，若有值则是修改）
	 * @return
	 */
	@RequestMapping(value = "operate_addOrModfiyProject2.html", method = RequestMethod.POST)
	public ModelAndView operateAddOrModfiyProject2() {
		String id = request.getParameter("id");
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
		ProjectModel projectModel = projectService.getById(id);
		if (projectModel != null) {
			projectModel.setpro("1", num1);
			projectModel.setpro("2", num2);
			projectModel.setpro("3", num3);
			projectModel.setpro("4", num4);
			projectModel.setpro("5", num5);
			projectModel.setpro("6", num6);
			projectModel.setpro("7", num7);
			projectModel.setpro("8", num8);
			projectModel.setpro("9", num9);
			projectModel.setpro("10", num10);
			projectModel.setpro("11", num11);
			projectService.updateProject(projectModel);
		}
		return operateManage(id);
	}
	
	/**
	 * 项目详细添加参建单位
	 * @return
	 */
	@RequestMapping(value = "operate_addBuildUnit.html", method = RequestMethod.POST)
	public ModelAndView operateAddBuildUnit() {
		String id = request.getParameter("id");
		String code = request.getParameter("pCode");
		String jType = request.getParameter("jType");
		String jName = request.getParameter("jName");
		String jNum = request.getParameter("jNum");
		String leaderphone = request.getParameter("leaderphone");
		JoinBuildModel joinBuildModel = joinBuildService.getJoinBuildByPCodeAndLeaderPhone(code, leaderphone);
		if (joinBuildModel == null) {
			joinBuildService.addJoinBuild(code, jType, jName, jNum, leaderphone);
			CompanyModel companyModel = new CompanyModel();
			companyModel.setUserId(leaderphone);
			companyModel.setName(jName);
			companyModel.setCode(jNum);
			companyModel.setPassword("123456");
			companyService.addCompany(companyModel);
		}
		return operateManage(id);
	}
	
	/**
	 * 项目详细修改参建单位
	 * @return
	 */
	@RequestMapping(value = "operate_modfiyBuildUnit.html", method = RequestMethod.POST)
	public ModelAndView operateModfiyBuildUnit() {
		String id = request.getParameter("id");
		String code = request.getParameter("pCode");
		String jName = request.getParameter("jName");
		String jType = request.getParameter("jType");
		String jNum = request.getParameter("jNum");
		String leaderphone = request.getParameter("leaderphone");
		JoinBuildModel joinBuildModel = joinBuildService.getJoinBuildByPCodeAndLeaderPhone(code, leaderphone);
		if (joinBuildModel != null) {
			joinBuildModel.setjName(jName);
			joinBuildModel.setjType(jType);
			joinBuildModel.setjNum(jNum);
			joinBuildModel.setLeaderphone(leaderphone);
			joinBuildService.updateJoinBuild(joinBuildModel);
		}
		CompanyModel companyModel = companyService.getByUserId(leaderphone);
		if (companyModel != null) {
			companyModel.setUserId(leaderphone);
			companyModel.setName(jName);
			companyModel.setCode(jNum);
			companyService.updateCompany(companyModel);
		}
		return operateManage(id);
	}
	
	/**
	 * JoinBuild添加页面对手机号的校验
	 * @param leaderphone
	 * @param response
	 */
	@RequestMapping(value = "operate_joinBuildAddLeaderphoneRepCHeck.html", method = RequestMethod.POST)
	public void operateJoinBuildAddLeaderphoneRepCHeck(String leaderphone, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String flag = joinBuildService.addMobilRepCHeck(leaderphone);
		out.print(flag);
		out.flush();
		out.close();
	}
	
	/**
	 * JoinBuild修改页面对手机号的校验
	 * @param leaderphone
	 * @param id
	 * @param response
	 */
	@RequestMapping(value = "operate_joinBuildModefiyLeaderphoneRepCHeck.html", method = RequestMethod.POST)
	public void operateJoinBuildModefiyLeaderphoneRepCHeck(String leaderphone, String id, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String flag = joinBuildService.modfiyMobilRepCHeck(leaderphone, id);
		out.print(flag);
		out.flush();
		out.close();
	}
	
	/**
	 * 关键人员岗位的添加功能
	 * @return
	 */
	@RequestMapping(value = "operate_addStaffPosition.html", method = RequestMethod.POST)
	public ModelAndView operateAddStaffPosition() {
		String id = request.getParameter("id");
		String code = request.getParameter("pCode");
		String name = request.getParameter("name");
		String cName = request.getParameter("cName");
		String phone = request.getParameter("phone");
		String role = request.getParameter("role");
		KeyPersonModel keyPersonModel = keyPersonService.getKeyPersonByPCodeAndPhone(code, phone);
		if (keyPersonModel == null) {
			keyPersonService.addKeyPerson(code, name, cName, phone, role);
			UserModel userModel = new UserModel();
			userModel.setUserName(name);
			userModel.setUserId(phone);
			userModel.setUserPassword("123456");
			userService.addUser(userModel);
		}
		return operateManage(id);
	}
	
	/**
	 * 关键人员岗位的修改功能
	 * @return
	 */
	@RequestMapping(value = "operate_modfiyStaffPosition.html", method = RequestMethod.POST)
	public ModelAndView operateModfiyStaffPosition() {
		String id = request.getParameter("id");
		String keyPersonId = request.getParameter("keyPersonId");
		String name = request.getParameter("kname");
		String cName = request.getParameter("cName");
		String role = request.getParameter("role");
		String phone = request.getParameter("phone");
		KeyPersonModel keyPersonModel = keyPersonService.getById(keyPersonId);
		if (keyPersonModel != null) {
			keyPersonModel.setName(name);
			keyPersonModel.setcName(cName);
			keyPersonModel.setRole(role);
			keyPersonModel.setPhone(phone);
			keyPersonService.updateKeyPerson(keyPersonModel);
		}
		UserModel userModel = userService.getByUserId(phone);
		if (userModel != null) {
			userModel.setUserName(name);
			userModel.setUserId(phone);
			userService.updateUser(userModel);
		}
		return operateManage(id);
	}
	
	/**
	 * KeyPerson添加页面对手机号的校验
	 * @param phone
	 */
	@RequestMapping(value = "operate_keyPersonAddPhoneRepCHeck.html", method = RequestMethod.POST)
	public void operateKeyPersonAddPhoneRepCHeck(String phone, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String flag = keyPersonService.addMobilRepCHeck(phone);
		out.print(flag);
		out.flush();
		out.close();
	}
	
	/**
	 * KeyPerson修改页面对手机号的校验
	 * @param phone
	 * @param id
	 * @param response
	 */
	@RequestMapping(value = "operate_keyPersonModefiyPhoneRepCHeck.html", method = RequestMethod.POST)
	public void operateKeyPersonModefiyPhoneRepCHeck(String phone, String id, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String flag = keyPersonService.modfiyMobilRepCHeck(phone, id);
		out.print(flag);
		out.flush();
		out.close();
	}
	
	/**
	 * 项目描述的修改功能
	 * @return
	 */
	//TODO 项目规模 修改功能 CSS样式问题  
	@RequestMapping(value = "operate_modfiyProjectNote.html", method = RequestMethod.POST)
	public ModelAndView operateModfiyProjectNote() {
		String id = request.getParameter("id");
		String pCode = request.getParameter("pCode");
		ProjectModel projectModel = projectService.getByPCode(pCode);
		String note = request.getParameter("note");
		projectModel.setNote(note);
		projectService.updateProject(projectModel);
		return operateManage(id);
	}
	
	/**
	 * 跳转到统计报表页面
	 * @return
	 */
	@RequestMapping(value = "operate_report.html", method = RequestMethod.GET)
	public ModelAndView operateReport(String id) {
		ModelAndView mav = new ModelAndView("operate/operate_report");
		ProjectModel projectModel = projectService.getById(id);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		return mav;
	}
		
	/**
	 * 查询并显示各种报表
	 * @param projectId
	 * @param flag
	 * @return
	 */
	@RequestMapping(value = "operate_getReport.html", method = RequestMethod.POST)
	public ModelAndView operateGetReport(String projectId, String flag, String result) { // flag作为是跳转到那个表的标志，result作为导入是否成功的标志
		ModelAndView mav = new ModelAndView("operate/operate_report");
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		String conSelect = request.getParameter("conSelect");
		if ("1".equals(conSelect)) { // 人工、材料、设备验工计价汇总表
			int year = 0;
			int month = 0;
			String searchDate = request.getParameter("searchDate");
			if (searchDate != null && searchDate.length() == 6) {
				String searchDateYear = searchDate.substring(0, 4);
				year = Integer.parseInt(searchDateYear);
				String searchDateMonth = searchDate.substring(4, 6);
				month = Integer.parseInt(searchDateMonth);
			}
			// 施工班组-人工费
			List<CmdSummModel> cmdSummTotalEmployeeModels = new ArrayList<CmdSummModel>();
			List<CmdSummModel> cmdSummBenEmployeeModels = cmdSummService.getByTimeAndTypeAndTeamtype(year, month, projectId, 1, 1); //施工班组 本班组
			if (cmdSummBenEmployeeModels != null && !cmdSummBenEmployeeModels.isEmpty()) {
				CmdSummModel teamBenCmdSummModel = getTeamCmdSummModel(cmdSummBenEmployeeModels);
				if (teamBenCmdSummModel != null) {
					cmdSummTotalEmployeeModels.add(teamBenCmdSummModel);
					mav.addObject("teamBenCmdSummModel", teamBenCmdSummModel);
				}
			}
			List<CmdSummModel> cmdSummLaoEmployeeModels = cmdSummService.getByTimeAndTypeAndTeamtype(year, month, projectId, 1, 2); //施工班组 劳务班组
			if (cmdSummLaoEmployeeModels != null && !cmdSummLaoEmployeeModels.isEmpty()) {
				CmdSummModel teamLaoCmdSummModel = getTeamCmdSummModel(cmdSummLaoEmployeeModels);
				if (teamLaoCmdSummModel != null) {
					cmdSummTotalEmployeeModels.add(teamLaoCmdSummModel);
					mav.addObject("teamLaoCmdSummModel", teamLaoCmdSummModel);
				}
			}
			List<CmdSummModel> cmdSummZhuEmployeeModels = cmdSummService.getByTimeAndTypeAndTeamtype(year, month, projectId, 1, 3); //施工班组 专业班组
			if (cmdSummZhuEmployeeModels != null && !cmdSummZhuEmployeeModels.isEmpty()) {
				CmdSummModel teamZhuCmdSummModel = getTeamCmdSummModel(cmdSummZhuEmployeeModels);
				if (teamZhuCmdSummModel != null) {
					cmdSummTotalEmployeeModels.add(teamZhuCmdSummModel);
					mav.addObject("teamZhuCmdSummModel", teamZhuCmdSummModel);
				}
			}
			if (cmdSummTotalEmployeeModels != null && !cmdSummTotalEmployeeModels.isEmpty()) {
				CmdSummModel cmdSummTotalEmployeeModel = getTeamCmdSummModel(cmdSummTotalEmployeeModels);
				if (cmdSummTotalEmployeeModel != null) {
					mav.addObject("cmdSummTotalEmployeeModel", cmdSummTotalEmployeeModel);
				}
			}
			//材料商 - 费用
			List<CmdSummModel> cmdSummTotalMaterialModels = new ArrayList<CmdSummModel>();
			List<CmdSummModel> cmdSummBenMaterialModels = cmdSummService.getByTimeAndTypeAndTeamtype(year, month, projectId, 2, 1); // 材料商 本班组
			if (cmdSummBenMaterialModels != null && !cmdSummBenMaterialModels.isEmpty()) {
				CmdSummModel materialBenCmdSummModel = getMECmdSummModel(cmdSummBenMaterialModels);
				if (materialBenCmdSummModel != null) {
					cmdSummTotalMaterialModels.add(materialBenCmdSummModel);
					mav.addObject("materialBenCmdSummModel", materialBenCmdSummModel);
				}
			}
			List<CmdSummModel> cmdSummLaoMaterialModels = cmdSummService.getByTimeAndTypeAndTeamtype(year, month, projectId, 2, 2); // 材料商 劳务班组
			if (cmdSummLaoMaterialModels != null && !cmdSummLaoMaterialModels.isEmpty()) {
				CmdSummModel materialLaoCmdSummModel = getMECmdSummModel(cmdSummLaoMaterialModels);
				if (materialLaoCmdSummModel != null) {
					cmdSummTotalMaterialModels.add(materialLaoCmdSummModel);
					mav.addObject("materialLaoCmdSummModel", materialLaoCmdSummModel);
				}
			}
			List<CmdSummModel> cmdSummZhuMaterialModels = cmdSummService.getByTimeAndTypeAndTeamtype(year, month, projectId, 2, 3); // 材料商 本班组
			if (cmdSummZhuMaterialModels != null && !cmdSummZhuMaterialModels.isEmpty()) {
				CmdSummModel materialZhuCmdSummModel = getMECmdSummModel(cmdSummZhuMaterialModels);
				if (materialZhuCmdSummModel != null) {
					cmdSummTotalMaterialModels.add(materialZhuCmdSummModel);
					mav.addObject("materialZhuCmdSummModel", materialZhuCmdSummModel);
				}
			}
			if (cmdSummTotalMaterialModels != null && !cmdSummTotalMaterialModels.isEmpty()) {
				CmdSummModel cmdSummTotalMaterialModel = getMECmdSummModel(cmdSummTotalMaterialModels);
				if (cmdSummTotalMaterialModel != null) {
					mav.addObject("cmdSummTotalMaterialModel", cmdSummTotalMaterialModel);
				}
			}
			//设备商 - 费用
			List<CmdSummModel> cmdSummTotalEquipmentModels = new ArrayList<CmdSummModel>();
			List<CmdSummModel> cmdSummBenEquipmentModels = cmdSummService.getByTimeAndTypeAndTeamtype(year, month, projectId, 3, 1); // 设备商 本班组
			if (cmdSummBenEquipmentModels != null && !cmdSummBenEquipmentModels.isEmpty()) {
				CmdSummModel equipmentBenCmdSummModel = getMECmdSummModel(cmdSummBenEquipmentModels);
				if (equipmentBenCmdSummModel != null) {
					cmdSummTotalEquipmentModels.add(equipmentBenCmdSummModel);
					mav.addObject("equipmentBenCmdSummModel", equipmentBenCmdSummModel);
				}
			}
			List<CmdSummModel> cmdSummLaoEquipmentModels = cmdSummService.getByTimeAndTypeAndTeamtype(year, month, projectId, 3, 2); // 设备商 劳务班组
			if (cmdSummLaoEquipmentModels != null && !cmdSummLaoEquipmentModels.isEmpty()) {
				CmdSummModel equipmentLaoCmdSummModel = getMECmdSummModel(cmdSummLaoEquipmentModels);
				if (equipmentLaoCmdSummModel != null) {
					cmdSummTotalEquipmentModels.add(equipmentLaoCmdSummModel);
					mav.addObject("equipmentLaoCmdSummModel", equipmentLaoCmdSummModel);
				}
			}
			List<CmdSummModel> cmdSummZhuEquipmentModels = cmdSummService.getByTimeAndTypeAndTeamtype(year, month, projectId, 3, 3); // 设备商 本班组
			if (cmdSummZhuEquipmentModels != null && !cmdSummZhuEquipmentModels.isEmpty()) {
				CmdSummModel equipmentZhuCmdSummModel = getMECmdSummModel(cmdSummZhuEquipmentModels);
				if (equipmentZhuCmdSummModel != null) {
					cmdSummTotalEquipmentModels.add(equipmentZhuCmdSummModel);
					mav.addObject("equipmentZhuCmdSummModel", equipmentZhuCmdSummModel);
				}
			}
			if (cmdSummTotalEquipmentModels != null && !cmdSummTotalEquipmentModels.isEmpty()) {
				CmdSummModel cmdSummTotalEquipmentModel = getMECmdSummModel(cmdSummTotalMaterialModels);
				if (cmdSummTotalEquipmentModel != null) {
					mav.addObject("cmdSummTotalEquipmentModel", cmdSummTotalEquipmentModel);
				}
			}
			mav.addObject("year", year);
			mav.addObject("month", month);
			mav.addObject("searchDate", searchDate);
		}
		else if ("2".equals(conSelect) || "2".equals(flag)) { // 项目花名册
			Long dataCount = projectRosterService.getCountByPId(projectId); // 统计当前工程下的所有人员
			int pageNow = 1;
			// 下面的分页代码有带改进
			if (request.getParameter("pageNowSelect") != null) {
				pageNow = Integer.parseInt(request.getParameter("pageNowSelect"));
			}
			if (request.getParameter("pageNowFirst") != null) {
				pageNow = Integer.parseInt(request.getParameter("pageNowFirst"));
			}
			if (request.getParameter("pageNowPre") != null) {
				pageNow = Integer.parseInt(request.getParameter("pageNowPre"));
			}
			if (request.getParameter("pageNowNext") != null) {
				pageNow = Integer.parseInt(request.getParameter("pageNowNext"));
			}
			if (request.getParameter("pageNowLast") != null) {
				pageNow = Integer.parseInt(request.getParameter("pageNowLast"));
			}
			int pageSize = 10; //一页显示几条记录,默认10条
			if (request.getParameter("pageSizeTotal") != null) {
				pageSize = Integer.parseInt(request.getParameter("pageSizeTotal"));
			}
			Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
			if (page != null) {
				mav.addObject("page", page);
				List<ProjectRosterModel> projectRosterModels = projectRosterService.getAllByPId(page, projectId);
				if (projectRosterModels != null && !projectRosterModels.isEmpty()) {
					mav.addObject("projectRosterModels", projectRosterModels);
				}
			}
		}
		else if ("3".equals(conSelect) || "3".equals(flag)) { // 工人花名册
			List<ProjectDepartmentModel> projectDepartmentModels = projectDepartmentService.getTeamByPIdStatus(projectId, 1, 3); //1表是type是施工班组,3表示ststus是Team已加入Project状态
			UserTeamRosterVo userTeamRosterVo = null;
			List<UserTeamRosterVo> userTeamRosterVos = new ArrayList<UserTeamRosterVo>();
			List<TeamMemberModel> teamMemberModels = new ArrayList<TeamMemberModel>();
			if (projectDepartmentModels != null && !projectDepartmentModels.isEmpty()) {
				for (ProjectDepartmentModel projectDepartmentModel : projectDepartmentModels) {
					teamMemberModels = teamMemberService.getBytIdAndStatus(projectDepartmentModel.getVId(), 3); // 3表示status是User已加入Team状态
					if (teamMemberModels != null && !teamMemberModels.isEmpty()) {
						for (TeamMemberModel teamMemberModel : teamMemberModels) {
							userTeamRosterVo = new UserTeamRosterVo();
							TeamModel teamModel = teamService.getTeamById(teamMemberModel.gettId());
							userTeamRosterVo.setName(teamModel.getName());
							UserModel userModel = userService.getByUserId(teamMemberModel.getUserId());
							userTeamRosterVo.setUserModel(userModel);
							userTeamRosterVos.add(userTeamRosterVo);
						}
					}
				}
			}
			int count =  userTeamRosterVos.size();
			Long dataCount = (long) count;
			int pageNow = 1;
			if (request.getParameter("pageNowSelect") != null) {
				pageNow = Integer.parseInt(request.getParameter("pageNowSelect"));
			}
			if (request.getParameter("pageNowFirst") != null) {
				pageNow = Integer.parseInt(request.getParameter("pageNowFirst"));
			}
			if (request.getParameter("pageNowPre") != null) {
				pageNow = Integer.parseInt(request.getParameter("pageNowPre"));
			}
			if (request.getParameter("pageNowNext") != null) {
				pageNow = Integer.parseInt(request.getParameter("pageNowNext"));
			}
			if (request.getParameter("pageNowLast") != null) {
				pageNow = Integer.parseInt(request.getParameter("pageNowLast"));
			}
			int pageSize = 10; //一页显示几条记录,默认10条
			if (request.getParameter("pageSizeTotal") != null) {
				pageSize = Integer.parseInt(request.getParameter("pageSizeTotal"));
			}
			Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
			if (page != null) {
				mav.addObject("page", page);
				List<UserTeamRosterVo> showUserTeamRosterVos = new ArrayList<UserTeamRosterVo>();
				if (pageNow * pageSize < dataCount) {
					showUserTeamRosterVos = userTeamRosterVos.subList((pageNow - 1) * pageSize, pageNow * pageSize);
				}
				else {
					showUserTeamRosterVos = userTeamRosterVos.subList((pageNow - 1) * pageSize, count);
				}
				if (showUserTeamRosterVos != null && !showUserTeamRosterVos.isEmpty()) {
					mav.addObject("showUserTeamRosterVos", showUserTeamRosterVos);
				}
			}
		}
		else if ("4".equals(conSelect) || "4".equals(flag)) { // 供应商花名册
			MaterialModel materialModel = null;
			EquipmentModel equipmentModel = null;
			MaterialEquipmentRosterVo materialEquipmentRosterVo = null;
			List<MaterialEquipmentRosterVo> materialEquipmentRosterVos = new ArrayList<MaterialEquipmentRosterVo>();
			List<ProjectDepartmentModel> materialProjectDepartmentModels = projectDepartmentService.getTeamByPIdStatus(projectId, 2, 3); //2表是type是材料商,3表示ststus是Team已加入Project状态
			if (materialProjectDepartmentModels != null && !materialProjectDepartmentModels.isEmpty()) {
				for (ProjectDepartmentModel projectDepartmentModel : materialProjectDepartmentModels) {
					materialModel = materialService.getById(projectDepartmentModel.getvId());
					materialEquipmentRosterVo = new MaterialEquipmentRosterVo();
					materialEquipmentRosterVo.setType(projectDepartmentModel.getType());
					materialEquipmentRosterVo.setMaterialModel(materialModel);
					materialEquipmentRosterVos.add(materialEquipmentRosterVo);
				}
			}
			List<ProjectDepartmentModel> equipmentProjectDepartmentModels = projectDepartmentService.getTeamByPIdStatus(projectId, 3, 3); //3表是type是设备商,3表示ststus是Team已加入Project状态
			if (equipmentProjectDepartmentModels != null && !equipmentProjectDepartmentModels.isEmpty()) {
				for (ProjectDepartmentModel projectDepartmentModel : equipmentProjectDepartmentModels) {
					equipmentModel = equipmentService.getById(projectDepartmentModel.getvId());
					materialEquipmentRosterVo = new MaterialEquipmentRosterVo();
					materialEquipmentRosterVo.setType(projectDepartmentModel.getType());
					materialEquipmentRosterVo.setEquipmentModel(equipmentModel);
					materialEquipmentRosterVos.add(materialEquipmentRosterVo);
				}
			}
			int count =  materialEquipmentRosterVos.size();
			Long dataCount = (long) count;
			int pageNow = 1;
			if (request.getParameter("pageNowSelect") != null) {
				pageNow = Integer.parseInt(request.getParameter("pageNowSelect"));
			}
			if (request.getParameter("pageNowFirst") != null) {
				pageNow = Integer.parseInt(request.getParameter("pageNowFirst"));
			}
			if (request.getParameter("pageNowPre") != null) {
				pageNow = Integer.parseInt(request.getParameter("pageNowPre"));
			}
			if (request.getParameter("pageNowNext") != null) {
				pageNow = Integer.parseInt(request.getParameter("pageNowNext"));
			}
			if (request.getParameter("pageNowLast") != null) {
				pageNow = Integer.parseInt(request.getParameter("pageNowLast"));
			}
			int pageSize = 10; //一页显示几条记录,默认10条
			if (request.getParameter("pageSizeTotal") != null) {
				pageSize = Integer.parseInt(request.getParameter("pageSizeTotal"));
			}
			Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
			if (page != null) {
				mav.addObject("page", page);
				List<MaterialEquipmentRosterVo> showMERosterVos = new ArrayList<MaterialEquipmentRosterVo>();
				if (pageNow * pageSize < dataCount) {
					showMERosterVos = materialEquipmentRosterVos.subList((pageNow - 1) * pageSize, pageNow * pageSize);
				}
				else {
					showMERosterVos = materialEquipmentRosterVos.subList((pageNow - 1) * pageSize, count);
				}
				if (showMERosterVos != null && !showMERosterVos.isEmpty()) {
					mav.addObject("showMERosterVos", showMERosterVos);
				}
			}
		}
		if ("0".equals(flag)) {
			mav.addObject("flag", conSelect); // flag用于 页面+JS判读用
		}
		else {
			mav.addObject("flag", flag);
		}
		mav.addObject("result", result);
		return mav;
	}
	
	/**
	 * 跳转到新增项目花名册页面
	 * @param projectId
	 * @param flag
	 * @return
	 */
	@RequestMapping(value = "operate_posterProjectAdd.html", method = RequestMethod.GET)
	public ModelAndView operatePosterProjectAdd(String projectId, String flag) {
		ModelAndView mav = new ModelAndView("operate/operate_posterProjectAdd"); 
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		mav.addObject("flag", flag);
		return mav;
	}
	
	/**
	 * 项目花名册的新增功能
	 * @return
	 */
	@RequestMapping(value = "operate_posterProjectAdd2.html", method = RequestMethod.POST)
	public ModelAndView operatePosterProjectAdd2() {
		String flag = request.getParameter("flag"); // 标志跳转作用
		String pId = request.getParameter("pId");
		String name = request.getParameter("name");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String position = request.getParameter("position");
		String identity = request.getParameter("identity");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		ProjectRosterModel projectRosterModel = new ProjectRosterModel();
		projectRosterModel.setpId(pId);
		projectRosterModel.setName(name);
		projectRosterModel.setSex(sex);
		projectRosterModel.setPosition(position);
		projectRosterModel.setIdentity(identity);
		projectRosterModel.setAddress(address);
		projectRosterModel.setPhone(phone);
		projectRosterService.addProjectRoster(projectRosterModel);
		return operateGetReport(pId, flag, "0");
	}
	
	/**
	 * 项目花名册验证用户的身份证是否注册过
	 * @param identity
	 * @param response
	 */
	@RequestMapping(value = "operate_posterIdentityReg.html", method = RequestMethod.POST)
	public void operatePosterIdentityReg(String identity, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String flag = projectRosterService.regRosterIdentity(identity);
		out.print(flag);
		out.flush();
		out.close();
	}
	
	/**
	 * 项目花名册验证用户的手机号是否注册过
	 * @param phone
	 * @param response
	 */
	@RequestMapping(value = "operate_posterPhoneReg.html", method = RequestMethod.POST)
	public void operatePosterPhoneReg(String phone, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String flag = projectRosterService.regRosterPhone(phone);
		out.print(flag);
		out.flush();
		out.close();
	}
	
	// operate_posterIdentityAndPhoneReg.html  这个方法没有用到
	@RequestMapping(value = "operate_posterIdentityAndPhoneReg.html", method = RequestMethod.POST)
	public void operatePosterIdentityAndPhoneReg(String identity, String phone, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String flag1 = projectRosterService.regRosterIdentity(identity);
		String flag2 = projectRosterService.regRosterPhone(phone);
		JSONObject json = new JSONObject();
		JSONArray jsonMembers = new JSONArray();  
		JSONObject member1 = new JSONObject();  
		member1.put("flag", flag1);
		JSONObject member2 = new JSONObject();  
		member2.put("flag", flag2);
		jsonMembers.put(member1);
		jsonMembers.put(member2);
		json.put("key", jsonMembers);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 获取项目花名册的EXCEL模板文件
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "operate_posterProjectDownloadExcel.html", method = RequestMethod.GET)
	public void operatePosterProjectDownloadExcel(HttpServletRequest request, HttpServletResponse response) {
		String filePath = Config.getInstance().getRootPath() + "exceltemplate/rosterProject.xml";
		DownLoadExcelTemplateUtil.getExcelTemplate(filePath, request, response);
	}
	
	/**
	 * 项目花名册的导入功能
	 * @param projectId
	 * @param flag
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "operate_posterProjectImportExcel.html", method = RequestMethod.POST)
	public ModelAndView operatePosterProjectImportExcel(String projectId, String flag, HttpServletRequest request, HttpServletResponse response) {
		String result = "0";
		String filePath = request.getSession().getServletContext().getRealPath("\\resource\\execl\\import\\poster_project") + "\\" + projectId;
		String fileName = ImportExcel.createDateExcel(filePath, config, request, response);
		ProjectRosterModel projectRosterModel = null;
		List<ProjectRosterModel> projectRosterModels = new ArrayList<ProjectRosterModel>();
		Workbook workbook = null;
		int count = -1; // 用于判断是否为空的EXCEL
		try {
		   	workbook = Workbook.getWorkbook(new java.io.File(filePath + "\\" + fileName)); // 创建Workbook	
		   	Sheet sheet = workbook.getSheet(0);	// 获取第一个工作簿Sheet
		   	if (!("项目花名册导入".equals(sheet.getCell(0, 0).getContents().trim()) && "姓名".equals(sheet.getCell(0, 1).getContents().trim()) &&
		   			"性别".equals(sheet.getCell(1, 1).getContents().trim()) && "职位".equals(sheet.getCell(2, 1).getContents().trim()) &&
		   			"身份证号".equals(sheet.getCell(3, 1).getContents().trim()) && "住址".equals(sheet.getCell(4, 1).getContents().trim()) &&
		   			"手机号".equals(sheet.getCell(5, 1).getContents().trim()))) {
		   		result = "5";
		   	}
		   	else {
			   	for (int i = 2; i < sheet.getRows(); i++) {	// 获取数据
			   		count++;
		   			projectRosterModel = new ProjectRosterModel();
		   			projectRosterModel.setpId(projectId);
		   			if ("".equals(sheet.getCell(0, i).getContents().trim()) && "".equals(sheet.getCell(1, i).getContents().trim()) && 
		   					"".equals(sheet.getCell(2, i).getContents().trim()) && "".equals(sheet.getCell(3, i).getContents().trim()) && 
		   					"".equals(sheet.getCell(4, i).getContents().trim()) && "".equals(sheet.getCell(5, i).getContents().trim())) { // 如果某一行为空，跳出，因为模板可能有7行，而数据只有2行
		   				break;
		   			}
		   			if ("".equals(sheet.getCell(0, i).getContents().trim()) || "".equals(sheet.getCell(1, i).getContents().trim()) || 
		   					"".equals(sheet.getCell(2, i).getContents().trim()) || "".equals(sheet.getCell(3, i).getContents().trim()) || 
		   					"".equals(sheet.getCell(4, i).getContents().trim()) || "".equals(sheet.getCell(5, i).getContents().trim())) { // 验证数据的完整性
		   				result = "1";
		   				break;
		   			} else {
		   				String identity = sheet.getCell(3, i).getContents().trim();
		   				Pattern regIdentityPattern = Pattern.compile("(\\d{14}[0-9]|X|x)|(\\d{17}[0-9]|X|x)");
		   				Matcher regIdentityMatcher = regIdentityPattern.matcher(identity);
		   				String phone = sheet.getCell(5, i).getContents().trim();
		   				Pattern regPhonePattern = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$");
		   				Matcher regPhoneMatcher = regPhonePattern.matcher(phone);
		   				if (!regIdentityMatcher.matches() || !regPhoneMatcher.matches()) { // Identity是否合法和phone是否合法
		   					result = "2";
		   					break;
		   				} else {
		   					String isExistIdentity = projectRosterService.regRosterIdentity(identity); // 是否已经存在这个身份证号
		   					String isExistPhone = projectRosterService.regRosterPhone(phone); // 否已经存在这个这个手机号
		   					if ("1".equals(isExistIdentity) || "1".equals(isExistPhone)) { // Identity是否存在和phone是否存在
		   						result = "3";
		   						break;
		   					} else {
		   						projectRosterModel.setName(sheet.getCell(0, i).getContents().trim());
		   						if ("男".equals(sheet.getCell(1, i).getContents().trim())) {
		   							projectRosterModel.setSex(1);
		   						} else {
		   							projectRosterModel.setSex(2);
		   						}
		   		   				projectRosterModel.setPosition(sheet.getCell(2, i).getContents().trim());
		   						projectRosterModel.setIdentity(identity);
		   						projectRosterModel.setAddress(sheet.getCell(4, i).getContents().trim());
		   		   				projectRosterModel.setPhone(phone);
		   		   				projectRosterModels.add(projectRosterModel);
		   					}
		   				}
		   			}
			   	}
		   	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count == 0 && !"1".equals(result) && !"2".equals(result) && !"3".equals(result)) {
			result = "4";
		} 
		if ("0".equals(result)) { // 只要导入的数据有一处错误，所有数据都导入失败
			if (projectRosterModels != null && !projectRosterModels.isEmpty()) {
				for (ProjectRosterModel projectRosterModel2 : projectRosterModels) {
					projectRosterService.addProjectRoster(projectRosterModel2);
				}
			}
		}
		return operateGetReport(projectId, flag, result);
	}
		
	/**
	 * 跳转到新增工人花名册页面
	 * @param projectId
	 * @param flag
	 * @return
	 */
	@RequestMapping(value = "operate_posterUserAdd.html", method = RequestMethod.GET)
	public ModelAndView operatePosterUserAdd(String projectId, String flag) {
		ModelAndView mav = new ModelAndView("operate/operate_posterUserAdd"); 
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		List<ProjectDepartmentModel> projectDepartmentModels = projectDepartmentService.getByProjectId(projectId, 3); // 3是status表示该Team是已加入该Project的
		List<TeamModel> teamModels = new ArrayList<TeamModel>();
		if (projectDepartmentModels != null && !projectDepartmentModels.isEmpty()) {
			for (ProjectDepartmentModel projectDepartmentModel : projectDepartmentModels) {
				TeamModel teamModel = teamService.getTeamById(projectDepartmentModel.getvId());
				if (teamModel != null) {
					teamModels.add(teamModel);
				}
			}
		}
		if (teamModels != null && !teamModels.isEmpty()) {
			mav.addObject("teamModels", teamModels);
		}
		mav.addObject("flag", flag);
		return mav;
	}
	
	/**
	 * 新增工人花名册功能
	 * @return
	 */
	@RequestMapping(value = "operate_posterUserAdd2.html", method = RequestMethod.POST)
	public ModelAndView operatePosterUserAdd2() {
		String flag = request.getParameter("flag"); // 标志跳转作用
		String pId = request.getParameter("pId");
		String teamId = request.getParameter("teamName"); // 班组名称（唯一）其实这里拿到的班组的ID
		String userName = request.getParameter("userName"); // 工人名称
		String userSex = request.getParameter("userSex");
		int skillBigType = Integer.parseInt(request.getParameter("skillBigType"));
		int skillSmallType = Integer.parseInt(request.getParameter("skillSmallType"));
		String userIdentity = request.getParameter("userIdentity");
		String userProvince = request.getParameter("userProvince");
		String userCity = request.getParameter("userCity");
		String userStreet = request.getParameter("userStreet");
		String userId = request.getParameter("userId");
		UserModel userModel = new UserModel();
		userModel.setUserId(userId);
		userModel.setUserName(userName);
		userModel.setUserType("0");
		userModel.setUserProvince(userProvince);
		userModel.setUserCity(userCity);
		userModel.setUserStreet(userStreet);
		userModel.setUserPassword("123456");
		userModel.setUserSex(userSex);
		userModel.setUserStatus("2"); // 用工状态 2：在岗
		userModel.setUserIdentity(userIdentity);
		userModel.setSkillBigType(skillBigType);
		userModel.setSkillSmallType(skillSmallType);
		userService.addUser(userModel);
		TeamModel teamModel = teamService.getTeamById(teamId);
		if (teamModel != null) {
			TeamMemberModel teamMemberModel = new TeamMemberModel();
			teamMemberModel.settId(teamModel.getId());
			teamMemberModel.setUserId(userId);
			teamMemberModel.setStatus(3); // 3-已加入 
			teamMemberService.addTeamMember(teamMemberModel);
		}
		return operateGetReport(pId, flag, "0");
	}
	
	/**
	 * 获取用工花名册的EXCEL模板文件
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "operate_posterUserDownloadExcel.html", method = RequestMethod.GET)
	public void operatePosterUserDownloadExcel(HttpServletRequest request, HttpServletResponse response) {
		String filePath = Config.getInstance().getRootPath() + "exceltemplate/rosterUser.xml";
		DownLoadExcelTemplateUtil.getExcelTemplate(filePath, request, response);
	}
	
	/**
	 * 用工花名册的导入功能
	 * @param projectId
	 * @param flag
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "operate_posterUserImportExcel.html", method = RequestMethod.POST)
	public ModelAndView operatePosterUserImportExcel(String projectId, String flag, HttpServletRequest request, HttpServletResponse response) {
		String result = "0";
		String filePath = request.getSession().getServletContext().getRealPath("\\resource\\execl\\import\\poster_user") + "\\" + projectId;
		String fileName = ImportExcel.createDateExcel(filePath, config, request, response);
		String teamId = null;
		UserModel userModel = null;
		List<UserModel> userModels = new ArrayList<UserModel>();
		TeamMemberModel teamMemberModel = null;
		Workbook workbook = null;
		int count = -1;
		try {
			workbook = Workbook.getWorkbook(new java.io.File(filePath + "\\" + fileName)); // 创建Workbook
			Sheet sheet = workbook.getSheet(0); // 获取第一个工作簿Sheet
			if (!("工人花名册导入".equals(sheet.getCell(0, 0).getContents().trim()) && "班组名称".equals(sheet.getCell(0, 1).getContents().trim()) &&
		   			"姓名".equals(sheet.getCell(1, 1).getContents().trim()) && "性别".equals(sheet.getCell(2, 1).getContents().trim()) &&
		   			"技术类别".equals(sheet.getCell(3, 1).getContents().trim()) && "身份证号".equals(sheet.getCell(4, 1).getContents().trim()) && 
		   			"住址".equals(sheet.getCell(5, 1).getContents().trim()) && "手机号".equals(sheet.getCell(6, 1).getContents().trim()))) {
		   		result = "7";
		   	} else {
				for (int i = 2; i < sheet.getRows(); i++) { // 获取数据
					count++;
					userModel = new UserModel();
					if ("".equals(sheet.getCell(0, i).getContents().trim()) && "".equals(sheet.getCell(1, i).getContents().trim()) && 
							"".equals(sheet.getCell(2, i).getContents().trim()) && "".equals(sheet.getCell(3, i).getContents().trim()) && 
							"".equals(sheet.getCell(4, i).getContents().trim()) && "".equals(sheet.getCell(5, i).getContents().trim()) &&
							"".equals(sheet.getCell(6, i).getContents().trim())) { // 如果某一行为空，跳出，因为模板可能有7行，而数据只有2行
						break;
					}
					if ("".equals(sheet.getCell(0, i).getContents().trim()) || "".equals(sheet.getCell(1, i).getContents().trim()) || 
							"".equals(sheet.getCell(2, i).getContents().trim()) || "".equals(sheet.getCell(3, i).getContents().trim()) || 
							"".equals(sheet.getCell(4, i).getContents().trim()) || "".equals(sheet.getCell(5, i).getContents().trim()) || 
							"".equals(sheet.getCell(6, i).getContents().trim())) { // 验证数据的完整性
						result = "1";
						break;
					} else {
						String teamName = sheet.getCell(0, i).getContents().trim();
						// 判断这个班组是否存在这个项目下，根据班组名称进行判断，因为班组名称唯一
						TeamModel teamModel = teamService.getTeamByName(teamName);
						if (teamModel != null) {
							teamId = teamModel.getId();
							ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getByVIdAndPIdAndStatus(teamId, projectId, 3); // 3表示status，是班组已加入这个项目
							if (projectDepartmentModel == null) { // 查到了这个施工班组，但是这个施工班组跟当前项目没有关系
								result = "3";
								break;
							}
						} else { // 没有查到这个施工班组，表示这个施工班组不存在team表中
							result = "2";
							break;
						}
						String identity = sheet.getCell(4, i).getContents().trim();
						Pattern regIdentityPattern = Pattern.compile("(\\d{14}[0-9]|X|x)|(\\d{17}[0-9]|X|x)");
						Matcher regIdentityMatcher = regIdentityPattern.matcher(identity);
						String userId = sheet.getCell(6, i).getContents().trim();
						Pattern regUserIdPattern = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$");
						Matcher regUserIdMatcher = regUserIdPattern.matcher(userId);
						if (!regIdentityMatcher.matches() || !regUserIdMatcher.matches()) { // Identity是否合法和userId是否合法
							result = "4";
							break;
						} else {
							int isExistIdentity = userService.identityHaveReg(identity); // 是否已经存在这个身份证号
							UserModel isExistUserId = userService.regUserIdExist(userId); // 否已经存在这个这个手机号
							if ((isExistIdentity == 1) || (isExistUserId != null)) { // Identity是否存在和userId是否存在
								result = "5";
								break;
							} else {
								userModel.setUserId(sheet.getCell(6, i).getContents().trim());
								userModel.setUserName(sheet.getCell(1, i).getContents().trim());
								userModel.setUserStreet(sheet.getCell(5, i).getContents().trim());
								if ("男".equals(sheet.getCell(2, i).getContents().trim())) {
									userModel.setUserSex("1");
								} else {
									userModel.setUserSex("2");
								}
								userModel.setUserStatus("2"); // 用工状态为2，因为该工人在这个施工班组下，这个施工班组在这个项目下(施工班组的状态为3)
								userModel.setUserIdentity(identity);
								if ("土建".equals(sheet.getCell(3, i).getContents().trim())) {
									userModel.setSkillBigType(1);
								} else if ("管理".equals(sheet.getCell(3, i).getContents().trim())) {
									userModel.setSkillBigType(2);
								} else if ("安装".equals(sheet.getCell(3, i).getContents().trim())) {
									userModel.setSkillBigType(3);
								} else {
									userModel.setSkillBigType(4);
								}
								userModels.add(userModel);
							}
						}
					}
				}
		   	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count == 0 && !"1".equals(result) && !"2".equals(result) && !"3".equals(result) && !"4".equals(result) && !"5".equals(result)) {
			result = "6";
		} 
		if ("0".equals(result)) { // 只要导入的数据有一处错误，所有数据都导入失败
			if (userModels != null && !userModels.isEmpty()) {
				for (UserModel userModel2 : userModels) {
					userService.addUser(userModel2);
					teamMemberModel = new TeamMemberModel();
					teamMemberModel.settId(teamId);
					teamMemberModel.setUserId(userModel2.getUserId());
					teamMemberModel.setStatus(3); // status,3：工人已加入班组
					teamMemberModel.setBackbone(0); // 非骨干成员
					teamMemberService.addTeamMember(teamMemberModel);
				}
			}
		}
		return operateGetReport(projectId, flag, result);
	}
	
	/**
	 * 工人花名册验证用户的身份证是否注册过
	 * @param userIdentity
	 * @param response
	 */
	@RequestMapping(value = "operate_posterUserIdentityReg.html", method = RequestMethod.POST)
	public void operatePosterUserIdentityReg(String userIdentity, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int flag = userService.identityHaveReg(userIdentity); // 身份证号码是否被注册过,返回0：身份证未被注册，返回1：身份证已注册
		out.print(flag);
		out.flush();
		out.close();
	}
	
	/**
	 * 工人花名册验证用户的手机号是否注册过
	 * @param userId
	 * @param response
	 */
	@RequestMapping(value = "operate_posterUserIdReg.html", method = RequestMethod.POST)
	public void operatePosterUserIdReg(String userId, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		UserModel userModel = userService.regUserIdExist(userId);
		int flag = 0;
		if (userModel != null) {
			flag = 1; // 1表示手机号已经注册，0表示手机号没有被注册
		}
		out.print(flag);
		out.flush();
		out.close();
	}
	
	/**
	 * 跳转供应商花名册的新增页面
	 * @param projectId
	 * @param flag
	 * @return
	 */
	@RequestMapping(value = "operate_posterMEAdd.html", method = RequestMethod.GET)
	public ModelAndView operate_posterMEAdd(String projectId, String flag) {
		ModelAndView mav = new ModelAndView("operate/operate_posterMEAdd");
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		mav.addObject("flag", flag);
		return mav;
	}
	
	/**
	 * 供应商花名册的新增功能
	 * @return
	 */
	@RequestMapping(value = "operate_posterMEAdd2.html", method = RequestMethod.POST)
	public ModelAndView operatePosterMEAdd2() {
		String flag = request.getParameter("flag"); // 标志跳转作用
		String pId = request.getParameter("pId");
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String licence = request.getParameter("licence");
		int type = Integer.parseInt(request.getParameter("type"));
		String shopName = request.getParameter("shopName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String leaderName = request.getParameter("leaderName");
		String userId = request.getParameter("userId");
		int status = 1;  // 表示已经审核
		ProjectDepartmentModel projectDepartmentModel = null;
		MaterialModel existByCodeMaterialModel = materialService.getByCode(code);
		EquipmentModel existByCodeEquipmentModel = equipmentService.getByCode(code);
		if (existByCodeMaterialModel != null && existByCodeEquipmentModel == null) {
			projectDepartmentModel = projectDepartmentService.getByPIdAndVIdAndType(pId, existByCodeMaterialModel.getId(), 2); //2是type，表示材料商
			if (projectDepartmentModel != null) {
				projectDepartmentModel.setStatus(3);
				projectDepartmentService.updateProjectDepartment(projectDepartmentModel);
			}
		}
		if (existByCodeMaterialModel == null && existByCodeEquipmentModel != null) {
			projectDepartmentModel = projectDepartmentService.getByPIdAndVIdAndType(pId, existByCodeEquipmentModel.getId(), 3); //3是type，表示设备商
			if (projectDepartmentModel != null) {
				projectDepartmentModel.setStatus(3);
				projectDepartmentService.updateProjectDepartment(projectDepartmentModel);
			}
		}
		MaterialModel existByUserIdMaterialModel = materialService.getByUserId(userId);
		EquipmentModel existByUserIdEquipmentModel = equipmentService.getByUserId(userId);
		if (existByUserIdMaterialModel != null && existByUserIdEquipmentModel == null) {
			projectDepartmentModel = projectDepartmentService.getByPIdAndVIdAndType(pId, existByUserIdMaterialModel.getId(), 2); //2是type，表示材料商
			if (projectDepartmentModel != null) {
				projectDepartmentModel.setStatus(3);
				projectDepartmentService.updateProjectDepartment(projectDepartmentModel);
			}
		}
		if (existByUserIdMaterialModel == null && existByUserIdEquipmentModel != null) {
			projectDepartmentModel = projectDepartmentService.getByPIdAndVIdAndType(pId, existByUserIdEquipmentModel.getId(), 3); //3是type，表示设备商
			if (projectDepartmentModel != null) {
				projectDepartmentModel.setStatus(3);
				projectDepartmentService.updateProjectDepartment(projectDepartmentModel);
			}
		}
		if (existByCodeMaterialModel == null && existByUserIdMaterialModel == null && existByCodeEquipmentModel == null && existByUserIdEquipmentModel == null) {
			if (type == 2) { // 材料商
				materialService.addMaterial(shopName, name, code, licence, "", "", userId, leaderName, province, city, street, status);
				MaterialModel materialModel = materialService.getByCode(code);
				projectDepartmentModel = new ProjectDepartmentModel();
				projectDepartmentModel.setvId(materialModel.getId());
				projectDepartmentModel.setPId(pId);
				projectDepartmentModel.setStatus(3); // 3表示已加入
				projectDepartmentModel.setType(2); // 2表示材料商
				projectDepartmentModel.setCreateTime(new Date());
				projectDepartmentModel.setName(materialModel.getName());
				projectDepartmentService.addProjectDepartment(projectDepartmentModel);
			}
			else if (type == 3) { // 设备商
				equipmentService.addEquipment(shopName, name, code, userId, leaderName, province, city, street, status, licence, "", "");
				EquipmentModel equipmentModel = equipmentService.getByCode(code);
				projectDepartmentModel = new ProjectDepartmentModel();
				projectDepartmentModel.setvId(equipmentModel.getId());
				projectDepartmentModel.setPId(pId);
				projectDepartmentModel.setStatus(3); // 3表示已加入
				projectDepartmentModel.setType(3); // 3表示设备商
				projectDepartmentModel.setCreateTime(new Date());
				projectDepartmentModel.setName(equipmentModel.getName());
				projectDepartmentService.addProjectDepartment(projectDepartmentModel);
			}
		}
		return operateGetReport(pId, flag, "0");
	}
	
	/**
	 * 通过供应商编码验证某个供应商(材料商/设备商)是否已经注册过
	 * @param code
	 * @param type
	 * @param pId
	 * @param response
	 */
	@RequestMapping(value = "operate_posterMECodeReg.html", method = RequestMethod.POST)
	public void operatePosterMECodeReg(String code, String type, String pId, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String flag = null; //1表示供应商已经注册；0表示没有注册
		int typeInt = Integer.parseInt(type);
		if (typeInt == 2) {
			flag = materialService.regRosterMaterialCode(code);
		} else if (typeInt == 3) {
			flag = equipmentService.regRosterEquipmentCode(code);
		}
		MaterialModel materialModel = materialService.getByCode(code);
		if (materialModel != null) {
			ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getByVIdAndPIdAndStatus(materialModel.getId(), pId, 3); //3是status
			if (projectDepartmentModel != null) {
				flag = "2";
			}
		}
		EquipmentModel equipmentModel = equipmentService.getByCode(code);
		if (equipmentModel != null) {
			ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getByVIdAndPIdAndStatus(equipmentModel.getId(), pId, 3); //3是status
			if (projectDepartmentModel != null) {
				flag = "2";
			}
		}
		out.print(flag);
		out.flush();
		out.close();
	}

	/**
	 * 通过手机号验证某个供应商(材料商/设备商)是否已经注册过
	 * @param userId
	 * @param type
	 * @param response
	 */
	@RequestMapping(value = "operate_posterMEUserIdReg.html", method = RequestMethod.POST)
	public void operatePosterMEUserIdReg(String userId, String type, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String flag = null; // 1表示供应商已经注册；0表示没有注册
		int typeInt = Integer.parseInt(type);
		if (typeInt == 2) {
			flag = materialService.regRosterMaterialUserId(userId);
		}
		else if (typeInt == 3) {
			flag = equipmentService.regRosterEquipmentUserId(userId);
		}
		out.print(flag);
		out.flush();
		out.close();
	}
	
	/**
	 * 获取供应商花名册的EXCEL模板文件
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "operate_posterMEDownloadExcel.html", method = RequestMethod.GET)
	public void operatePosterMEDownloadExcel(HttpServletRequest request, HttpServletResponse response) {
		String filePath = Config.getInstance().getRootPath() + "exceltemplate/rosterME.xml";
		DownLoadExcelTemplateUtil.getExcelTemplate(filePath, request, response);
	}
	
	/**
	 * 供应商花名册的导入功能
	 * @param projectId
	 * @param flag
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "operate_posterMEImportExcel.html", method = RequestMethod.POST)
	public ModelAndView operatePosterMEImportExcel(String projectId, String flag, HttpServletRequest request, HttpServletResponse response) {
		String result = "0";
		String filePath = request.getSession().getServletContext().getRealPath("\\resource\\execl\\import\\poster_me") + "\\" + projectId;
		String fileName = ImportExcel.createDateExcel(filePath, config, request, response);
		MaterialModel materialModel = null;
		List<MaterialModel> materialModels = new ArrayList<MaterialModel>();
		EquipmentModel equipmentModel = null;
		List<EquipmentModel> equipmentModels = new ArrayList<EquipmentModel>();
		ProjectDepartmentModel projectDepartmentModel = null;
		Workbook workbook = null;
		int count = -1;
		try {
			workbook = Workbook.getWorkbook(new java.io.File(filePath + "\\" + fileName));
			Sheet sheet = workbook.getSheet(0);
			System.out.println(sheet.getCell(0, 0).getContents().trim());
			if (!("供应商花名册导入".equals(sheet.getCell(0, 0).getContents().trim()) && "供应商类型".equals(sheet.getCell(0, 1).getContents().trim()) &&
		   			"供应商名称".equals(sheet.getCell(1, 1).getContents().trim()) && "供应商机构代码".equals(sheet.getCell(2, 1).getContents().trim()) &&
		   			"统一社会信用代码".equals(sheet.getCell(3, 1).getContents().trim()) && "供应材料或设备名称".equals(sheet.getCell(4, 1).getContents().trim()) && 
		   			"街道地址".equals(sheet.getCell(5, 1).getContents().trim()) && "联系人".equals(sheet.getCell(6, 1).getContents().trim()) &&
		   			"手机号".equals(sheet.getCell(7, 1).getContents().trim()))) {
		   		result = "6";
		   	} else {
				for (int i = 2; i < sheet.getRows(); i++) {
					count++;
					if ("".equals(sheet.getCell(0, i).getContents().trim()) && "".equals(sheet.getCell(1, i).getContents().trim()) && 
							"".equals(sheet.getCell(2, i).getContents().trim()) && "".equals(sheet.getCell(3, i).getContents().trim()) && 
							"".equals(sheet.getCell(4, i).getContents().trim()) && "".equals(sheet.getCell(5, i).getContents().trim()) &&
							"".equals(sheet.getCell(6, i).getContents().trim()) && "".equals(sheet.getCell(7, i).getContents().trim())) { // 如果某一行为空，跳出，因为模板可能有7行，而数据只有2行
						break;
					}
					if ("".equals(sheet.getCell(0, i).getContents().trim()) || "".equals(sheet.getCell(1, i).getContents().trim()) || 
							"".equals(sheet.getCell(2, i).getContents().trim()) || "".equals(sheet.getCell(3, i).getContents().trim()) || 
							"".equals(sheet.getCell(4, i).getContents().trim()) || "".equals(sheet.getCell(5, i).getContents().trim()) ||
							"".equals(sheet.getCell(6, i).getContents().trim()) || "".equals(sheet.getCell(7, i).getContents().trim())) { // 验证数据的完整性
						result = "1";
						break;
					} else {
						if ("材料商".equals(sheet.getCell(0, i).getContents().trim())) {
							String code = sheet.getCell(2, i).getContents().trim();
							String isExistCode = materialService.regRosterMaterialCode(code);
							if ("1".equals(isExistCode)) { // 材料商的机构代码已经存在
								result = "2";
								break;
							} else {
								String userId = sheet.getCell(7, i).getContents().trim();
								Pattern regUserIdPattern = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$");
								Matcher regUserIdMatcher = regUserIdPattern.matcher(userId);
								if (!regUserIdMatcher.matches()) { // 手机号是否输入合法
									result = "3";
									break;
								} else {
									String isExistUserId = materialService.regRosterMaterialUserId(userId);
									if ("1".equals(isExistUserId)) { // 手机号已注册
										result = "4";
										break;
									} else {
										materialModel = new MaterialModel();
										materialModel.setName(sheet.getCell(1, i).getContents().trim());
										materialModel.setCode(code);
										materialModel.setLicence(sheet.getCell(3, i).getContents().trim());
										materialModel.setUserId(userId);
										materialModel.setLeaderName(sheet.getCell(6, i).getContents().trim());
										materialModel.setStreet(sheet.getCell(5, i).getContents().trim());
										materialModel.setStatus(1); // 已审核
										materialModel.setShopName(sheet.getCell(4, i).getContents().trim());
										materialModels.add(materialModel);
									}
								}
							}
						} else {
							String code = sheet.getCell(2, i).getContents().trim();
							String isExistCode = equipmentService.regRosterEquipmentCode(code);
							if ("1".equals(isExistCode)) { // 设备商的机构代码已经存在
								result = "2";
								break;
							} else {
								String userId = sheet.getCell(7, i).getContents().trim();
								Pattern regUserIdPattern = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$");
								Matcher regUserIdMatcher = regUserIdPattern.matcher(userId);
								if (!regUserIdMatcher.matches()) { // 手机号是否输入合法
									result = "3";
									break;
								} else {
									String isExistUserId = equipmentService.regRosterEquipmentUserId(userId);
									if ("1".equals(isExistUserId)) {
										result = "4";
										break;
									} else {
										equipmentModel = new EquipmentModel();
										equipmentModel.setName(sheet.getCell(1, i).getContents().trim());
										equipmentModel.setCode(code);
										equipmentModel.setLicence(sheet.getCell(3, i).getContents().trim());
										equipmentModel.setUserId(userId);
										equipmentModel.setLeaderName(sheet.getCell(6, i).getContents().trim());
										equipmentModel.setStreet(sheet.getCell(5, i).getContents().trim());
										equipmentModel.setStatus(1); // 已审核
										equipmentModel.setShopName(sheet.getCell(4, i).getContents().trim());
										equipmentModels.add(equipmentModel);
									}
								}
							}
						}
					}
				}
		   	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count == 0 && !"1".equals(result) && !"2".equals(result) && !"3".equals(result) && !"4".equals(result)) {
			result = "5";
		} 
		if ("0".equals(result)) {
			if (materialModels != null && !materialModels.isEmpty()) {
				for (MaterialModel materialModel2 : materialModels) {
					materialService.addMaterial(materialModel2);
					projectDepartmentModel = new ProjectDepartmentModel();
					projectDepartmentModel.setvId(materialModel2.getId());
					projectDepartmentModel.setpId(projectId);
					projectDepartmentModel.setStatus(3); // 材料商加入项目
					projectDepartmentModel.setType(2); // 表示材料商
					projectDepartmentModel.setName(materialModel2.getName());
					projectDepartmentModel.setCategory(1); // 默认为本班组
					projectDepartmentService.addProjectDepartment(projectDepartmentModel);
				}
			}
			if (equipmentModels != null && !equipmentModels.isEmpty()) {
				for (EquipmentModel equipmentModel2 : equipmentModels) {
					equipmentService.addEquipment(equipmentModel2);
					projectDepartmentModel = new ProjectDepartmentModel();
					projectDepartmentModel.setvId(equipmentModel2.getId());
					projectDepartmentModel.setpId(projectId);
					projectDepartmentModel.setStatus(3); // 设备商加入项目
					projectDepartmentModel.setType(3); // 表示设备商
					projectDepartmentModel.setName(equipmentModel2.getName());
					projectDepartmentModel.setCategory(1); // 默认为本班组
					projectDepartmentService.addProjectDepartment(projectDepartmentModel);
				}
			}
		}
		return operateGetReport(projectId, flag, result);
	}
	
	/**
	 * 跳转到显示所有施工班组的汇总页面
	 * @param year
	 * @param month
	 * @param projectId
	 * @param type - 施工班组
	 * @param result - 用于导入是否成功
	 * @return
	 */
	@RequestMapping(value = "operate_reportTeamList.html", method = RequestMethod.GET)
	public ModelAndView operateReportTeamList(String year, String month, String projectId, String type, String result) {
		ModelAndView mav = new ModelAndView("operate/operate_reportTeamList");
		getCmdSummModels(mav, Integer.parseInt(year), Integer.parseInt(month), projectId, Integer.parseInt(type), result);
		return mav;
	}
	
	/**
	 * 跳转到显示所有材料商的汇总页面
	 * @param year
	 * @param month
	 * @param projectId
	 * @param type - 材料商
	 * @param result - 用于判断导入是否成功
	 * @return
	 */
	@RequestMapping(value = "operate_reportMaterialList.html", method = RequestMethod.GET)
	public ModelAndView operateReportMaterialList(String year, String month, String projectId, String type, String result) {
		ModelAndView mav = new ModelAndView("operate/operate_reportMaterialList");
		getCmdSummModels(mav, Integer.parseInt(year), Integer.parseInt(month), projectId, Integer.parseInt(type), result);
		return mav;
	}
	
	/**
	 * 跳转到显示所有设备商的汇总页面
	 * @param year
	 * @param month
	 * @param projectId
	 * @param type - 设备商
	 * @param result - 用于判断导入是否成功
	 * @return
	 */
	@RequestMapping(value = "operate_reportEquipmentList.html", method = RequestMethod.GET)
	public ModelAndView operateReportEquipmentList(String year, String month, String projectId, String type, String result) {
		ModelAndView mav = new ModelAndView("operate/operate_reportEquipmentList");
		getCmdSummModels(mav, Integer.parseInt(year), Integer.parseInt(month), projectId, Integer.parseInt(type), result);
		return mav;
	}
	
	/**
	 * 施工班组新增明显表页面
	 * @param cmdSummId
	 * @param teamId
	 * @param teamtype
	 * @return
	 */
	@RequestMapping(value = "operate_reportTeamAdd.html", method = RequestMethod.GET)
	public ModelAndView operateReportTeamDetailAdd(String projectId, String teamtype, String type) {
		ModelAndView mav = new ModelAndView("operate/operate_reportTeamAdd");
		mav.addObject("projectId", projectId);
		mav.addObject("type", type);
		return mav;
	}
	
	/**
	 * 施工班组新增一个班组明显表数据功能
	 * @return
	 */
	@RequestMapping(value = "operate_reportTeamAdd2.html", method = RequestMethod.POST)
	public ModelAndView operateReportTeamAdd2() {
		String projectId = request.getParameter("projectId");
		ProjectModel projectModel = projectService.getById(projectId);
		String pName = null;
		if (projectModel != null) {
			pName = projectModel.getName();
		}
		int teamtype = Integer.parseInt(request.getParameter("teamtype"));
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String teamCode = request.getParameter("teamCode");
		int type = 1; // 班组类别：施工班组
		String tId = null; // 班组ID
		String tName = null; // 班组名称
		TeamModel teamModel = teamService.getTeamByCode(Long.parseLong(teamCode));
		if (teamModel != null) {
			tId = teamModel.getId();
			tName = teamModel.getName();
		}
		int bgpayment = 0;
		if (!"".equals(request.getParameter("bgpayment"))) {
			bgpayment = Integer.parseInt(request.getParameter("bgpayment"));
		}
		int contractPrice = 0;
		if (!"".equals(request.getParameter("contractPrice"))) {
			contractPrice = Integer.parseInt(request.getParameter("contractPrice"));
		}
		String unit = request.getParameter("unit");
		int frequency = 0;
		if (!"".equals(request.getParameter("frequency"))) {
			frequency = Integer.parseInt(request.getParameter("frequency"));
		}
		int nowTotal = 0;
		if (!"".equals(request.getParameter("nowTotal"))) {
			nowTotal = Integer.parseInt(request.getParameter("nowTotal"));
		}
		int total = 0;
		if (!"".equals(request.getParameter("total"))) {
			total = Integer.parseInt(request.getParameter("total"));
		}
		int culPercentage = 0;
		if (!"".equals(request.getParameter("culPercentage"))) {
			culPercentage = Integer.parseInt(request.getParameter("culPercentage"));
		}
		int percentage = 0;
		if (!"".equals(request.getParameter("percentage"))) {
			percentage = Integer.parseInt(request.getParameter("percentage"));
		}
		int thispay = 0;
		if (!"".equals(request.getParameter("thispay"))) {
			thispay = Integer.parseInt(request.getParameter("thispay"));
		}
		int culapay = 0;
		if (!"".equals(request.getParameter("culapay"))) {
			culapay = Integer.parseInt(request.getParameter("culapay"));
		}
		int thisSalary = 0;
		if (!"".equals(request.getParameter("thisSalary"))) {
			thisSalary = Integer.parseInt(request.getParameter("thisSalary"));
		}
		int noSalary = 0;
		if (!"".equals(request.getParameter("noSalary"))) {
			noSalary = Integer.parseInt(request.getParameter("noSalary"));
		}
		int remain = 0;
		if (!"".equals(request.getParameter("remain"))) {
			remain = Integer.parseInt(request.getParameter("remain"));
		}
		int deposit = 0;
		if (!"".equals(request.getParameter("deposit"))) {
			deposit = Integer.parseInt(request.getParameter("deposit"));
		}
		String settlement = request.getParameter("settlement");
		String note = request.getParameter("note");
		cmdSummService.addPersonCmdSumm(projectId, pName, tId, type, teamtype, tName, contractPrice, bgpayment, 
				frequency, unit, total, nowTotal, percentage, thispay, culapay, thisSalary, noSalary, settlement, 
				note, Integer.parseInt(year), Integer.parseInt(month), remain, deposit, culPercentage);
		return operateReportTeamList(year, month, projectId, type + "", "0");
	}
	
	/**
	 * 添加施工班组汇总时检查施工班组是否存在Team中 与 一个施工班组在一个项目中的一个月在汇总表中只能存在一条记录，检查是否已经存在
	 * @param projectId
	 * @param code
	 * @param year
	 * @param month
	 * @param response
	 */
	@RequestMapping(value = "operate_addReportTeamAndCmdRepCHeck.html", method = RequestMethod.POST)
	public void operateAddReportTeamAndCmdRepCHeck(String projectId, String code, String year, String month, String type, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String flag = "3";
		int typeInt = Integer.parseInt(type);
		if (typeInt == 1) { // 施工班组
			TeamModel teamModel = teamService.getTeamByCode(Long.parseLong(code));
			if (teamModel != null) {
				flag = "2";
				CmdSummModel cmdSummModel = cmdSummService.cmdSummRepCHeck(projectId, teamModel.getId(), Integer.parseInt(year), Integer.parseInt(month));
				if (cmdSummModel != null) {
					flag = "1";
				}
				else {
					flag = "0";
				}
			}
		}
		else if (typeInt == 2) { // 材料商
			MaterialModel materialModel = materialService.getByCode(code);
			if (materialModel != null) {
				flag = "2";
				CmdSummModel cmdSummModel = cmdSummService.cmdSummRepCHeck(projectId, materialModel.getId(), Integer.parseInt(year), Integer.parseInt(month));
				if (cmdSummModel != null) {
					flag = "1";
				}
				else {
					flag = "0";
				}
			}
		}
		else if (typeInt == 3) { // 设备商
			EquipmentModel equipmentModel = equipmentService.getByCode(code);
			if (equipmentModel != null) {
				flag = "2";
				CmdSummModel cmdSummModel = cmdSummService.cmdSummRepCHeck(projectId, equipmentModel.getId(), Integer.parseInt(year), Integer.parseInt(month));
				if (cmdSummModel != null) {
					flag = "1";
				}
				else {
					flag = "0";
				}
			}
		}
		out.print(flag);
		out.flush();
		out.close();
	}
	
	/**
	 * 显示施工班明细数据
	 * @param projectId
	 * @param cmdId
	 * @param tId
	 * @param teamtype
	 * @param year
	 * @param month
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "operate_reportTeamDetailList.html", method = RequestMethod.GET)
	public ModelAndView operateReportTeamDetailList(String projectId, String cmdId, String tId, String teamtype, String year, String month, String result) {
		ModelAndView mav = new ModelAndView("operate/operate_reportTeamDetailList");
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		List<TeamMemberModel> teamMemberModels = new ArrayList<TeamMemberModel>();
		List<CmdSummPersonModel> cmdSummPersonModels = new ArrayList<CmdSummPersonModel>();
		UserCmdSummDetailVo userCmdSummDetailVo = null;
		List<UserCmdSummDetailVo> userCmdSummDetailVos = new ArrayList<UserCmdSummDetailVo>();
		TeamModel teamModel = teamService.getTeamById(tId);
		if (teamModel != null) {
			mav.addObject("teamModel", teamModel);
			teamMemberModels = teamMemberService.getBytIdAndStatus(tId, 3); // 3表是状态status是已加入班组
			if (teamMemberModels != null && !teamMemberModels.isEmpty()) {
				for (TeamMemberModel teamMemberModel : teamMemberModels) {
					String userId = teamMemberModel.getUserId();
					UserModel userModel = userService.getByUserId(userId);
					if (userModel != null) {
						userCmdSummDetailVo = new UserCmdSummDetailVo();
						userCmdSummDetailVo.setUserModel(userModel);
						cmdSummPersonModels = cmdSummPersonService.getByCmdIdAndTIdAndTeamTypeAndYearMonth(cmdId, tId, Integer.parseInt(teamtype), Integer.parseInt(year), Integer.parseInt(month));
						if (cmdSummPersonModels != null && !cmdSummPersonModels.isEmpty()) {
							for (CmdSummPersonModel cmdSummPersonModel : cmdSummPersonModels) {
								String uId = cmdSummPersonModel.getUserId();
								if (uId.equals(userId)) {
									userCmdSummDetailVo.setCmdSummPersonModel(cmdSummPersonModel);
								}
							}
						}
						userCmdSummDetailVos.add(userCmdSummDetailVo);
					}
				}
			}
		}
		if (userCmdSummDetailVos != null && !userCmdSummDetailVos.isEmpty()) {
			mav.addObject("userCmdSummDetailVos", userCmdSummDetailVos);
		}
		mav.addObject("pId", projectId);
		mav.addObject("cmdId", cmdId);
		mav.addObject("tId", tId);
		mav.addObject("teamtype", teamtype);
		mav.addObject("year", year);
		mav.addObject("month", month);
		mav.addObject("result", result);
		return mav;
	}
	
	/**
	 * 班组个人明细页面跳转到个人新增明细页面
	 * @param cmdId
	 * @param pId
	 * @param tId
	 * @param teamtype
	 * @param year
	 * @param month
	 * @return
	 */
	@RequestMapping(value = "operate_reportTeamDetailAdd.html", method = RequestMethod.GET)
	public ModelAndView operateReportTeamDetailAdd(String cmdId, String pId, String tId, String teamtype, String year, String month) {
		ModelAndView mav = new ModelAndView("operate/operate_reportTeamDetailAdd");
		mav.addObject("cmdId", cmdId);
		mav.addObject("pId", pId);
		mav.addObject("tId", tId);
		mav.addObject("teamtype", teamtype);
		mav.addObject("year", year);
		mav.addObject("month", month);
		return mav;
	}
	
	// TODO 添加    各种时间格式、手机号校验、不在User表中 不能加入、不在Team表中 不能加入、该员工本月在是否已经存在记录 -- 明细 （出来了时间没有统一，其他的都完成了校验）
	// TODO 出入记录、考情记录、某些信息不能手工录入的，而是需要通过计算获得
	/**
	 * 个人新增明细功能
	 * @return
	 */
	@RequestMapping(value = "operate_reportTeamDetailAdd2.html", method = RequestMethod.POST)
	public ModelAndView operateReportTeamDetailAdd2() {
		String cmdId = request.getParameter("cmdId");
		String pId = request.getParameter("pId");
		String tId = request.getParameter("tId");
		String teamtype = request.getParameter("teamtype");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String pName = null; // 项目的名称
		ProjectModel projectModel = projectService.getById(pId);
		if (projectModel != null) {
			pName = projectModel.getName();
		}
		String userId = request.getParameter("userId");
		String name = null; // 班组成员的名称
		String identity = null; // 班组成员的身份证号
		UserModel userModel = userService.getByUserId(userId);
		if (userModel != null) {
			name = userModel.getUserName();
			identity = userModel.getUserIdentity();
		}
		String drawee = request.getParameter("drawee");
		String payTime = request.getParameter("payTime");
		int paytype = Integer.parseInt(request.getParameter("paytype"));
		String account = request.getParameter("account");
		String voucher = request.getParameter("voucher");
		String safe = request.getParameter("safe");
		String inTime = request.getParameter("inTime");
		String outTime = request.getParameter("outTime");
		String access = request.getParameter("access");
		String attendance = request.getParameter("attendance");
		String workContent = request.getParameter("workContent");
		int count = 0;
		if (!"".equals(request.getParameter("count"))) {
			count = Integer.parseInt(request.getParameter("count"));
		}
		int salary = 0;
		if (!"".equals(request.getParameter("salary"))) {
			salary = Integer.parseInt(request.getParameter("salary"));
		}
		int deduct = 0;
		if (!"".equals(request.getParameter("deduct"))) {
			deduct = Integer.parseInt(request.getParameter("deduct"));
		}
		int realSalary = 0;
		if (!"".equals(request.getParameter("realSalary"))) {
			realSalary = Integer.parseInt(request.getParameter("realSalary"));
		}
		int noSalary = 0;
		if (!"".equals(request.getParameter("noSalary"))) {
			noSalary = Integer.parseInt(request.getParameter("noSalary"));
		}
		String flag = request.getParameter("flag");
		String note = request.getParameter("note");
		cmdSummPersonService.addCmdSummPerson(cmdId, pId, Integer.parseInt(teamtype), name, userId, account, voucher, inTime, outTime, safe, attendance, access, identity, workContent, count, salary, deduct, realSalary, noSalary, flag, note, tId, payTime, drawee, paytype, pName, Integer.parseInt(year), Integer.parseInt(month));
		return operateReportTeamDetailList(pId, cmdId, tId, teamtype, year, month, "0");
	}
	
	/**
	 * 判断用户是否在存在User表中，还需判断用户是否与对应的Team相关联，还需判断添加的记录在本月份已经存在
	 * @param userId
	 * @param tId
	 * @param response
	 */
	@RequestMapping(value = "operate_isUserExist.html", method = RequestMethod.POST)
	public void operateIsUserExist(String cmdId, String pId, String tId, String userId, String teamtype, String year, String month, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String flag = "0"; // 用户不存在
		UserModel userModel = userService.regUserIdExist(userId); // 判断该用户是否存在User表中
		if (userModel != null) {
			flag = "1"; // 用户存在
			TeamMemberModel teamMemberModel = teamMemberService.userIdExistInTeam(userId, tId, 3); // 3表示字段status是已加入的状态       判断查到该用户是加入当前的班组
			if (teamMemberModel != null) {
				flag = "3"; // 用户存在班组中，status为3
				CmdSummPersonModel cmdSummPersonModel = cmdSummPersonService.isRecordExist(cmdId, pId, tId, userId, Integer.parseInt(teamtype), Integer.parseInt(year), Integer.parseInt(month));
				if (cmdSummPersonModel != null) {
					flag = "4"; // 当前的年月的记录已经存在
				}
				else {
					flag = "5"; // 当前的年月的记录不存在
				}
			}
			else {
				flag = "2"; // 用户不存在班组中
			}
		}
		out.print(flag);
		out.flush();
		out.close();
	}
	
	/**
	 * 人工费用（施工班组）本班组汇总表的导出功能
	 * @param response
	 * @param year
	 * @param month
	 * @param projectId
	 */
	@RequestMapping(value = "operate_reportBenTeamListToExcel.html", method = RequestMethod.GET)
	public void operateReportBenTeamListToExcel(HttpServletResponse response, String year, String month, String projectId) {
		getTeamRecoredExportExcel(response, year, month, projectId, 1, 1); // 第一个1表示施工班组type，第二个1表示本班组teamType
	}
	
	/**
	 * 人工费用（施工班组）劳务班组汇总表的导出功能
	 * @param response
	 * @param year
	 * @param month
	 * @param projectId
	 */
	@RequestMapping(value = "operate_reportLaoTeamListToExcel.html", method = RequestMethod.GET)
	public void operateReportLaoTeamListToExcel(HttpServletResponse response, String year, String month, String projectId) {
		getTeamRecoredExportExcel(response, year, month, projectId, 1, 2); // 1表示施工班组type，2表示劳务班组teamType
	}
	
	/**
	 * 人工费用（施工班组）专业班组汇总表的导出功能
	 * @param response
	 * @param year
	 * @param month
	 * @param projectId
	 */
	@RequestMapping(value = "operate_reportZhuTeamListToExcel.html", method = RequestMethod.GET)
	public void operate_reportZhuTeamListToExcel(HttpServletResponse response, String year, String month, String projectId) {
		getTeamRecoredExportExcel(response, year, month, projectId, 1, 3); // 1表示施工班组type，3表示专业班组teamType
	}
	
	/**
	 * 施工班组汇总表的EXCEL模板文件
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "operate_reportTeamDownloadExcel.html", method = RequestMethod.GET)
	public void operateReportTeamDownloadExcel(HttpServletRequest request, HttpServletResponse response) {
		String filePath = Config.getInstance().getRootPath() + "exceltemplate/reportTeam.xml";
		DownLoadExcelTemplateUtil.getExcelTemplate(filePath, request, response);
	}
	
	/**
	 * 施工班组汇总表的导入功能
	 * @param projectId
	 * @param flag
	 * @param year
	 * @param month
	 * @param teamtype
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "operate_reportTeamImportExcel.html", method = RequestMethod.POST)
	public ModelAndView operateReportTeamImportExcel(String projectId, String flag, String year, String month, String teamtype, HttpServletRequest request, HttpServletResponse response) {
		String result = "0";
		String filePath = request.getSession().getServletContext().getRealPath("\\resource\\execl\\import\\report_teamsum") + "\\" + projectId;
		String fileName = ImportExcel.createDateExcel(filePath, config, request, response);
		CmdSummModel cmdSummModel = null;
		List<CmdSummModel> cmdSummModels = new ArrayList<CmdSummModel>();
		Workbook workbook = null;
		int count = -1;
		String projectName = null;
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			projectName = projectModel.getName();
		}
		try {
			workbook = Workbook.getWorkbook(new java.io.File(filePath + "\\" + fileName));
			Sheet sheet = workbook.getSheet(0);
			if (!("施工班组汇总表导入".equals(sheet.getCell(0, 0).getContents().trim()) && "名称".equals(sheet.getCell(0, 1).getContents().trim()) &&
					"合同价(万)".equals(sheet.getCell(1, 1).getContents().trim()) && "预付款(万)".equals(sheet.getCell(2, 1).getContents().trim()) &&
					"次数".equals(sheet.getCell(3, 1).getContents().trim()) && "单位".equals(sheet.getCell(4, 1).getContents().trim()) &&
					"总工程量".equals(sheet.getCell(5, 1).getContents().trim()) && "本次工程量".equals(sheet.getCell(6, 1).getContents().trim()) &&
					"累计完成%".equals(sheet.getCell(7, 1).getContents().trim()) && "本次付款".equals(sheet.getCell(8, 1).getContents().trim()) &&
					"累计付款".equals(sheet.getCell(9, 1).getContents().trim()) && "余额".equals(sheet.getCell(10, 1).getContents().trim()) &&
					"累计付款%".equals(sheet.getCell(11, 1).getContents().trim()) && "押金".equals(sheet.getCell(12, 1).getContents().trim()) &&
					"已付工资".equals(sheet.getCell(13, 1).getContents().trim()) && "未付工资".equals(sheet.getCell(14, 1).getContents().trim()) &&
					"结算情况".equals(sheet.getCell(15, 1).getContents().trim()) && "备注".equals(sheet.getCell(16, 1).getContents().trim()))) {
				result = "5";
			}
			else {
				for (int i = 2; i < sheet.getRows(); i++) {
					count++;
					if ("".equals(sheet.getCell(0, i).getContents().trim()) && "".equals(sheet.getCell(1, i).getContents().trim()) && 
							"".equals(sheet.getCell(2, i).getContents().trim()) && "".equals(sheet.getCell(3, i).getContents().trim()) && 
							"".equals(sheet.getCell(4, i).getContents().trim()) && "".equals(sheet.getCell(5, i).getContents().trim()) &&
							"".equals(sheet.getCell(6, i).getContents().trim()) && "".equals(sheet.getCell(7, i).getContents().trim()) &&
							"".equals(sheet.getCell(8, i).getContents().trim()) && "".equals(sheet.getCell(9, i).getContents().trim()) &&
							"".equals(sheet.getCell(10, i).getContents().trim()) && "".equals(sheet.getCell(11, i).getContents().trim()) &&
							"".equals(sheet.getCell(12, i).getContents().trim()) && "".equals(sheet.getCell(13, i).getContents().trim()) &&
							"".equals(sheet.getCell(14, i).getContents().trim()) && "".equals(sheet.getCell(15, i).getContents().trim()) &&
							"".equals(sheet.getCell(16, i).getContents().trim())) { // 如果某一行为空，跳出，因为模板可能有7行，而数据只有2行，这里是不具有模板数据而言的
						break;
					}
					if ("".equals(sheet.getCell(0, i).getContents().trim()) && "0".equals(sheet.getCell(1, i).getContents().trim()) && 
							"0".equals(sheet.getCell(2, i).getContents().trim()) && "0".equals(sheet.getCell(3, i).getContents().trim()) && 
							"".equals(sheet.getCell(4, i).getContents().trim()) && "0".equals(sheet.getCell(5, i).getContents().trim()) &&
							"0".equals(sheet.getCell(6, i).getContents().trim()) && "0".equals(sheet.getCell(7, i).getContents().trim()) &&
							"0".equals(sheet.getCell(8, i).getContents().trim()) && "0".equals(sheet.getCell(9, i).getContents().trim()) &&
							"0".equals(sheet.getCell(10, i).getContents().trim()) && "0".equals(sheet.getCell(11, i).getContents().trim()) &&
							"0".equals(sheet.getCell(12, i).getContents().trim()) && "0".equals(sheet.getCell(13, i).getContents().trim()) &&
							"0".equals(sheet.getCell(14, i).getContents().trim()) && "".equals(sheet.getCell(15, i).getContents().trim()) &&
							"".equals(sheet.getCell(16, i).getContents().trim())) {  //验证数据的完整性,其他数据可以为空，或者设置默认值，但是默认值为0，这里是对前几条模板数据的
						break;
					} 
					if ("".equals(sheet.getCell(0, i).getContents().trim()) || "".equals(sheet.getCell(1, i).getContents().trim()) || 
							"".equals(sheet.getCell(2, i).getContents().trim()) || "".equals(sheet.getCell(3, i).getContents().trim()) || 
							"".equals(sheet.getCell(4, i).getContents().trim()) || "".equals(sheet.getCell(5, i).getContents().trim()) ||
							"".equals(sheet.getCell(6, i).getContents().trim()) || "".equals(sheet.getCell(7, i).getContents().trim()) ||
							"".equals(sheet.getCell(8, i).getContents().trim()) || "".equals(sheet.getCell(9, i).getContents().trim()) ||
							"".equals(sheet.getCell(10, i).getContents().trim()) || "".equals(sheet.getCell(11, i).getContents().trim()) ||
							"".equals(sheet.getCell(12, i).getContents().trim()) || "".equals(sheet.getCell(13, i).getContents().trim()) ||
							"".equals(sheet.getCell(14, i).getContents().trim())) {  //验证数据的完整性
						result = "1";
						break;
					} else { 
						String teamName = sheet.getCell(0, i).getContents().trim();
						TeamModel isExistTeamName = teamService.getTeamByName(teamName);
						if (isExistTeamName == null) { // Team本身不存在
							result = "2";
							break;
						} else { 
							// 这里没有做施工班组与项目的关系，因为可能做的是前几个的数据，但是当前施工班组已经离开了该项目
							CmdSummModel isExistCmdSummModel = cmdSummService.getByTimeAndTypesAndIds(Integer.parseInt(year), Integer.parseInt(month), 1, Integer.parseInt(teamtype), projectId, isExistTeamName.getId()); // 1为施工班组类型type
							if (isExistCmdSummModel != null) { // 这个月份这个施工班组的数据已经存在
								result = "3";
								break;
							} else {
								cmdSummModel = new CmdSummModel();
								cmdSummModel.setpId(projectId);
								cmdSummModel.setpName(projectName);
								cmdSummModel.settId(isExistTeamName.getId());
								cmdSummModel.setType(1); // 表示施工班组
								cmdSummModel.setTeamtype(Integer.parseInt(teamtype));
								cmdSummModel.settName(teamName);
								cmdSummModel.setContractPrice(Integer.parseInt(sheet.getCell(1, i).getContents().trim()));
								cmdSummModel.setBgpayment(Integer.parseInt(sheet.getCell(2, i).getContents().trim()));
								cmdSummModel.setFrequency(Integer.parseInt(sheet.getCell(3, i).getContents().trim()));
								cmdSummModel.setUnit(sheet.getCell(4, i).getContents().trim());
								cmdSummModel.setTotal(Integer.parseInt(sheet.getCell(5, i).getContents().trim()));
								cmdSummModel.setNowTotal(Integer.parseInt(sheet.getCell(6, i).getContents().trim()));
								cmdSummModel.setPercentage(Integer.parseInt(sheet.getCell(7, i).getContents().trim()));
								cmdSummModel.setThispay(Integer.parseInt(sheet.getCell(8, i).getContents().trim()));
								cmdSummModel.setCulapay(Integer.parseInt(sheet.getCell(9, i).getContents().trim()));
								cmdSummModel.setRemain(Integer.parseInt(sheet.getCell(10, i).getContents().trim()));
								cmdSummModel.setCulPercentage(Integer.parseInt(sheet.getCell(11, i).getContents().trim()));
								cmdSummModel.setDeposit(Integer.parseInt(sheet.getCell(12, i).getContents().trim()));
								cmdSummModel.setThisSalary(Integer.parseInt(sheet.getCell(13, i).getContents().trim()));
								cmdSummModel.setNoSalary(Integer.parseInt(sheet.getCell(14, i).getContents().trim()));
								cmdSummModel.setSettlement(sheet.getCell(15, i).getContents().trim());
								cmdSummModel.setNote(sheet.getCell(16, i).getContents().trim());
								cmdSummModel.setYear(Integer.parseInt(year));
								cmdSummModel.setMonth(Integer.parseInt(month));
								cmdSummModels.add(cmdSummModel);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count == 0 && !"1".equals(result) && !"2".equals(result) && !"3".equals(result)) {
			result = "4";
		}
		if ("0".equals(result)) {
			if (cmdSummModels != null && !cmdSummModels.isEmpty()) {
				for (CmdSummModel cmdSummModel2 : cmdSummModels) {
					cmdSummService.addCmdSumm(cmdSummModel2);
				}
			}
		} else {
			if ("1".equals(teamtype)) {
				result = teamtype + result;
			} else if ("2".equals(teamtype)) {
				result = teamtype + result;
			} else if ("3".equals(teamtype)) {
				result = teamtype + result;
			}
		}
		return operateReportTeamList(year, month, projectId, "1", result);
	}
	
	/**
	 * 主要人工(施工班组下的成员)验工计价明细表导出功能 - 这里是直接套用原有的model（原有的model中有name和identity，如果没有需要自己写个class类）
	 * @param response
	 * @param year
	 * @param month
	 * @param projectId
	 * @param tId
	 * @param cmdId
	 * @param teamtype
	 */
	@RequestMapping(value = "operate_reportTeamDetailListToExcel.html", method = RequestMethod.GET)
	public void operateReportTeamDetailListToExcel(HttpServletResponse response, String year, String month, String projectId, String tId, String cmdId, String teamtype) {
		List<TeamMemberModel> teamMemberModels = new ArrayList<TeamMemberModel>();
		List<CmdSummPersonModel> cmdSummPersonModels = new ArrayList<CmdSummPersonModel>();
		UserCmdSummDetailVo userCmdSummDetailVo = null;
		List<UserCmdSummDetailVo> userCmdSummDetailVos = new ArrayList<UserCmdSummDetailVo>();
		TeamModel teamModel = teamService.getTeamById(tId);
		if (teamModel != null) {
			teamMemberModels = teamMemberService.getBytIdAndStatus(tId, 3); // 3表是状态status是已加入班组
			if (teamMemberModels != null && !teamMemberModels.isEmpty()) {
				for (TeamMemberModel teamMemberModel : teamMemberModels) {
					String userId = teamMemberModel.getUserId();
					UserModel userModel = userService.getByUserId(userId);
					if (userModel != null) {
						userCmdSummDetailVo = new UserCmdSummDetailVo();
						userCmdSummDetailVo.setUserModel(userModel);
						cmdSummPersonModels = cmdSummPersonService.getByCmdIdAndTIdAndTeamTypeAndYearMonth(cmdId, tId, Integer.parseInt(teamtype), Integer.parseInt(year), Integer.parseInt(month));
						if (cmdSummPersonModels != null && !cmdSummPersonModels.isEmpty()) {
							for (CmdSummPersonModel cmdSummPersonModel : cmdSummPersonModels) {
								String uId = cmdSummPersonModel.getUserId();
								if (uId.equals(userId)) {
									userCmdSummDetailVo.setCmdSummPersonModel(cmdSummPersonModel);
								}
							}
						}
						userCmdSummDetailVos.add(userCmdSummDetailVo);
					}
				}
			}
		}
		if (userCmdSummDetailVos != null && !userCmdSummDetailVos.isEmpty()) {
			Iterator<UserCmdSummDetailVo> it = userCmdSummDetailVos.iterator();
			List<CmdSummPersonModel> cmdSummPersonModelToExcels = new ArrayList<CmdSummPersonModel>();
			while (it.hasNext()) {
				UserCmdSummDetailVo userCmdSummDetailVoToExcel = it.next();
				CmdSummPersonModel cmdSummPersonModelToExcel = new CmdSummPersonModel();
				cmdSummPersonModelToExcel.setName(userCmdSummDetailVoToExcel.getUserModel().getUserName());
				if (userCmdSummDetailVoToExcel.getUserModel().getUserIdentity() == null) {
					cmdSummPersonModelToExcel.setIdentity("");
				} else {
					cmdSummPersonModelToExcel.setIdentity(userCmdSummDetailVoToExcel.getUserModel().getUserIdentity());
				}
				if (userCmdSummDetailVoToExcel.getCmdSummPersonModel() != null) {
					if (userCmdSummDetailVoToExcel.getCmdSummPersonModel().getAccount() != null) {
						cmdSummPersonModelToExcel.setAccount(userCmdSummDetailVoToExcel.getCmdSummPersonModel().getAccount());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummPersonModel().getVoucher() != null) {
						cmdSummPersonModelToExcel.setVoucher(userCmdSummDetailVoToExcel.getCmdSummPersonModel().getVoucher());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummPersonModel().getInTime() != null) {
						cmdSummPersonModelToExcel.setInTime(userCmdSummDetailVoToExcel.getCmdSummPersonModel().getInTime());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummPersonModel().getSafe() != null) {
						cmdSummPersonModelToExcel.setSafe(userCmdSummDetailVoToExcel.getCmdSummPersonModel().getSafe());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummPersonModel().getOutTime() != null) {
						cmdSummPersonModelToExcel.setOutTime(userCmdSummDetailVoToExcel.getCmdSummPersonModel().getOutTime());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummPersonModel().getAccess() != null) {
						cmdSummPersonModelToExcel.setAccess(userCmdSummDetailVoToExcel.getCmdSummPersonModel().getAccess());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummPersonModel().getAttendance() != null) {
						cmdSummPersonModelToExcel.setAttendance(userCmdSummDetailVoToExcel.getCmdSummPersonModel().getAttendance());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummPersonModel().getWorkContent() != null) {
						cmdSummPersonModelToExcel.setWorkContent(userCmdSummDetailVoToExcel.getCmdSummPersonModel().getWorkContent());
					}
					if ((Integer)userCmdSummDetailVoToExcel.getCmdSummPersonModel().getCount() != null) {
						cmdSummPersonModelToExcel.setCount(userCmdSummDetailVoToExcel.getCmdSummPersonModel().getCount());
					}
					if ((Integer)userCmdSummDetailVoToExcel.getCmdSummPersonModel().getSalary() != null) {
						cmdSummPersonModelToExcel.setSalary(userCmdSummDetailVoToExcel.getCmdSummPersonModel().getSalary());
					}
					if ((Integer)userCmdSummDetailVoToExcel.getCmdSummPersonModel().getDeduct() != null) {
						cmdSummPersonModelToExcel.setDeduct(userCmdSummDetailVoToExcel.getCmdSummPersonModel().getDeduct());
					}
					if ((Integer)userCmdSummDetailVoToExcel.getCmdSummPersonModel().getRealSalary() != null) {
						cmdSummPersonModelToExcel.setRealSalary(userCmdSummDetailVoToExcel.getCmdSummPersonModel().getRealSalary());
					}
					if ((Integer)userCmdSummDetailVoToExcel.getCmdSummPersonModel().getNoSalary() != null) {
						cmdSummPersonModelToExcel.setNoSalary(userCmdSummDetailVoToExcel.getCmdSummPersonModel().getNoSalary());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummPersonModel().getFlag() != null) {
						cmdSummPersonModelToExcel.setFlag(userCmdSummDetailVoToExcel.getCmdSummPersonModel().getFlag());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummPersonModel().getNote() != null) {
						cmdSummPersonModelToExcel.setNote(userCmdSummDetailVoToExcel.getCmdSummPersonModel().getNote());
					}
				}
				cmdSummPersonModelToExcels.add(cmdSummPersonModelToExcel);
			}
			String[] tTitle = {"序号", "名称", "身份证号码", "支付账号", "支付凭证", "进场时间", "是否安全教育", 
					"退场时间", "出入记录", "考勤记录", "工作内容", "次数", "应发工资", "扣款", "实发工资",
					"未付工资", "签名指纹", "备注"};
			String[] dateFiled = {""};
			ProjectModel projectModel = projectService.getById(projectId);
			String projectName = null;
			if (projectModel != null) {
				projectName = projectModel.getName();
			}
			String teamName = teamModel.getName();
			Date ctime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			String currentTime = formatter.format(ctime);
			String fileName = projectName + year + "年" + month + "月" + teamName + "的人工验工计价明细表" + currentTime;
			String tableName = "cmdSummPerson";
			int needIndex[] = {100, 4, 17, 7, 8, 9, 11, 10, 13, 12, 18, 19, 20, 21, 22, 23, 24, 25};
			if (cmdSummPersonModelToExcels != null && !cmdSummPersonModelToExcels.isEmpty()) {
				try {
					ExportExcel.recoredExportExcel(response, tableName, tTitle, fileName, needIndex, cmdSummPersonModelToExcels, dateFiled);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 施工班组明细表的导入EXCEL模板文件
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "operate_reportTeamDetailDownloadExcel.html", method = RequestMethod.GET)
	public void operateReportTeamDetailDownloadExcel(HttpServletRequest request, HttpServletResponse response) {
		String filePath = Config.getInstance().getRootPath() + "exceltemplate/reportTeamDetail.xml";
		DownLoadExcelTemplateUtil.getExcelTemplate(filePath, request, response);
	}
	
	/**
	 * 施工班组明细表的导入功能
	 * @param cmdId
	 * @param pId
	 * @param tId
	 * @param teamtype
	 * @param flag
	 * @param year
	 * @param month
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "operate_reportTeamDetailImportExcel.html", method = RequestMethod.POST)
	public ModelAndView operate_reportTeamDetailDownloadExcel(String cmdId, String pId, String tId, String teamtype, String flag, String year, String month, HttpServletRequest request, HttpServletResponse response) {
		String result = "0";
		String filePath = request.getSession().getServletContext().getRealPath("\\resource\\execl\\import\\report_teamdetail") + "\\" + pId;
		String fileName = ImportExcel.createDateExcel(filePath, config, request, response);
		CmdSummPersonModel cmdSummPersonModel = null;
		List<CmdSummPersonModel> cmdSummPersonModels = new ArrayList<CmdSummPersonModel>();
		Workbook workbook = null;
		int count = -1;
		String projectName = null;
		ProjectModel projectModel = projectService.getById(pId);
		if (projectModel != null) {
			projectName = projectModel.getName();
		}
		try {
			workbook = Workbook.getWorkbook(new java.io.File(filePath + "\\" + fileName));
			Sheet sheet = workbook.getSheet(0);
			if (!("施工班组明细表导入".equals(sheet.getCell(0, 0).getContents().trim()) && "身份证号码".equals(sheet.getCell(0, 1).getContents().trim()) &&
					"支付方式".equals(sheet.getCell(1, 1).getContents().trim()) && "支付账号".equals(sheet.getCell(2, 1).getContents().trim()) &&
					"支付凭证".equals(sheet.getCell(3, 1).getContents().trim()) && "进场时间".equals(sheet.getCell(4, 1).getContents().trim()) &&
					"是否安全教育".equals(sheet.getCell(5, 1).getContents().trim()) && "退场时间".equals(sheet.getCell(6, 1).getContents().trim()) &&
					"出入记录".equals(sheet.getCell(7, 1).getContents().trim()) && "考勤记录".equals(sheet.getCell(8, 1).getContents().trim()) &&
					"工作内容".equals(sheet.getCell(9, 1).getContents().trim()) && "次数".equals(sheet.getCell(10, 1).getContents().trim()) &&
					"应发工资".equals(sheet.getCell(11, 1).getContents().trim()) && "扣款".equals(sheet.getCell(12, 1).getContents().trim()) &&
					"实发工资".equals(sheet.getCell(13, 1).getContents().trim()) && "未付工资".equals(sheet.getCell(14, 1).getContents().trim()) &&
					"付款人".equals(sheet.getCell(15, 1).getContents().trim()) && "发放日期".equals(sheet.getCell(16, 1).getContents().trim()) &&
					"是否签名".equals(sheet.getCell(17, 1).getContents().trim()) && "备注".equals(sheet.getCell(18, 1).getContents().trim()))) {
				result = "8";
			} else {
				for (int i = 2; i < sheet.getRows(); i++) {
					count++;
					if ("".equals(sheet.getCell(0, i).getContents().trim()) && "".equals(sheet.getCell(1, i).getContents().trim()) && 
							"".equals(sheet.getCell(2, i).getContents().trim()) && "".equals(sheet.getCell(3, i).getContents().trim()) && 
							"".equals(sheet.getCell(4, i).getContents().trim()) && "".equals(sheet.getCell(5, i).getContents().trim()) &&
							"".equals(sheet.getCell(6, i).getContents().trim()) && "".equals(sheet.getCell(7, i).getContents().trim()) &&
							"".equals(sheet.getCell(8, i).getContents().trim()) && "".equals(sheet.getCell(9, i).getContents().trim()) &&
							"".equals(sheet.getCell(10, i).getContents().trim()) && "".equals(sheet.getCell(11, i).getContents().trim()) &&
							"".equals(sheet.getCell(12, i).getContents().trim()) && "".equals(sheet.getCell(13, i).getContents().trim()) &&
							"".equals(sheet.getCell(14, i).getContents().trim()) && "".equals(sheet.getCell(15, i).getContents().trim()) &&
							"".equals(sheet.getCell(16, i).getContents().trim()) && "".equals(sheet.getCell(17, i).getContents().trim()) &&
							"".equals(sheet.getCell(18, i).getContents().trim())) { // 如果某一行为空，跳出，因为模板可能有7行，而数据只有2行，这里是不具有模板数据而言的- 模板外
						break;
					}
					if ("".equals(sheet.getCell(0, i).getContents().trim()) && "".equals(sheet.getCell(1, i).getContents().trim()) && 
							"".equals(sheet.getCell(2, i).getContents().trim()) && "".equals(sheet.getCell(3, i).getContents().trim()) && 
							("1900/1/0  0:00:00".equals(sheet.getCell(4, i).getContents().trim()) || "1899-12-30 12:00:00".equals(sheet.getCell(4, i).getContents().trim())) && 
							"".equals(sheet.getCell(5, i).getContents().trim()) &&
							("1900/1/0  0:00:00".equals(sheet.getCell(6, i).getContents().trim()) || "1899-12-30 12:00:00".equals(sheet.getCell(6, i).getContents().trim())) &&
							"".equals(sheet.getCell(7, i).getContents().trim()) && "".equals(sheet.getCell(8, i).getContents().trim()) && 
							"".equals(sheet.getCell(9, i).getContents().trim()) && "0".equals(sheet.getCell(10, i).getContents().trim()) && 
							"0".equals(sheet.getCell(11, i).getContents().trim()) && "0".equals(sheet.getCell(12, i).getContents().trim()) && 
							"0".equals(sheet.getCell(13, i).getContents().trim()) && "0".equals(sheet.getCell(14, i).getContents().trim()) && 
							"".equals(sheet.getCell(15, i).getContents().trim()) && 
							("1900/1/0".equals(sheet.getCell(16, i).getContents().trim()) || "1899-12-30".equals(sheet.getCell(16, i).getContents().trim())) &&
							"".equals(sheet.getCell(17, i).getContents().trim()) && "".equals(sheet.getCell(18, i).getContents().trim())) { // 如果某一行为空，跳出，因为模板可能有7行，而数据只有2行，这里是不具有模板数据而言的- 模板内
						break;
					}
					if ("".equals(sheet.getCell(0, i).getContents().trim()) || "".equals(sheet.getCell(1, i).getContents().trim()) || 
							"".equals(sheet.getCell(2, i).getContents().trim()) || "".equals(sheet.getCell(3, i).getContents().trim()) || 
							"".equals(sheet.getCell(4, i).getContents().trim()) || "".equals(sheet.getCell(5, i).getContents().trim()) ||
							"".equals(sheet.getCell(6, i).getContents().trim()) || "".equals(sheet.getCell(7, i).getContents().trim()) ||
							"".equals(sheet.getCell(8, i).getContents().trim()) || "".equals(sheet.getCell(9, i).getContents().trim()) ||
							"".equals(sheet.getCell(10, i).getContents().trim()) || "".equals(sheet.getCell(11, i).getContents().trim()) ||
							"".equals(sheet.getCell(12, i).getContents().trim()) || "".equals(sheet.getCell(13, i).getContents().trim()) ||
							"".equals(sheet.getCell(14, i).getContents().trim()) || "".equals(sheet.getCell(15, i).getContents().trim()) ||
							"".equals(sheet.getCell(16, i).getContents().trim()) || "".equals(sheet.getCell(17, i).getContents().trim())) { // 验证数据的完整性
						result = "1";
						break;
					} else {
						String userIdentity = sheet.getCell(0, i).getContents().trim();
						Pattern regIdentityPattern = Pattern.compile("(\\d{14}[0-9]|X|x)|(\\d{17}[0-9]|X|x)");
		   				Matcher regIdentityMatcher = regIdentityPattern.matcher(userIdentity);
		   				if (!regIdentityMatcher.matches()){
		   					result = "2";
		   					break;
		   				} else {
							UserModel isExistUserModel = userService.getByUserIdentity(userIdentity);
							if (isExistUserModel == null) { // 表示这个工人不存在
								result = "3";
								break;
							} else {
								String userId = isExistUserModel.getUserId();
								TeamMemberModel isExistTeamMemberModel = teamMemberService.userIdExistInTeam(userId, tId, 3); // 3表示这个工人在这个班组中
								if (isExistTeamMemberModel == null) { // 表示这个工人不在当前的班组中
									result = "4";
									break;
								} else {
									CmdSummPersonModel isExistCmdSummPersonModel = cmdSummPersonService.isRecordExist(cmdId, pId, tId, userId, Integer.parseInt(teamtype), Integer.parseInt(year), Integer.parseInt(month));
									if (isExistCmdSummPersonModel != null) { // 表是这个月的数据已经存在
										result = "5";
										break;
									} else {
										Pattern ymdPattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
										String startDateStr = sheet.getCell(4, i).getContents().trim();
										String endDateStr = sheet.getCell(6, i).getContents().trim();
										String payTime = sheet.getCell(16, i).getContents().trim();
										String payTimeStr = payTime.substring(0, 10);
										Matcher ymdStartMatcher = ymdPattern.matcher(startDateStr);
										Matcher ymdEndMatcher = ymdPattern.matcher(endDateStr);
										Matcher payTimeMatcher = ymdPattern.matcher(payTimeStr);
										if (!ymdStartMatcher.matches() || !ymdEndMatcher.matches() || !payTimeMatcher.matches()) { //1900-01-00可能变成1900/1/0，导致不能正确截取
											result = "6";
											break;
										} else {
											cmdSummPersonModel = new CmdSummPersonModel();
											cmdSummPersonModel.setCmdId(cmdId);
											cmdSummPersonModel.setpId(pId);
											cmdSummPersonModel.settId(tId);
											cmdSummPersonModel.setName(isExistUserModel.getUserName());
											cmdSummPersonModel.setpName(projectName);
											cmdSummPersonModel.setUserId(userId);
											cmdSummPersonModel.setAccount(sheet.getCell(2, i).getContents().trim());
											cmdSummPersonModel.setVoucher(sheet.getCell(3, i).getContents().trim());
											long start = ((DateCell) sheet.getCell(4, i)).getDate().getTime() - (8*60*60*1000); 
											long end = ((DateCell) sheet.getCell(6, i)).getDate().getTime() - (8*60*60*1000);
											SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
											cmdSummPersonModel.setInTime(sdf.format(new Date(start)));
											cmdSummPersonModel.setOutTime(sdf.format(new Date(end)));
											cmdSummPersonModel.setSafe(sheet.getCell(5, i).getContents().trim());
											cmdSummPersonModel.setAttendance(sheet.getCell(7, i).getContents().trim());
											cmdSummPersonModel.setAccess(sheet.getCell(8, i).getContents().trim());
											cmdSummPersonModel.setTeamtype(Integer.parseInt(teamtype));
											cmdSummPersonModel.setYear(Integer.parseInt(year));
											cmdSummPersonModel.setMonth(Integer.parseInt(month));
											cmdSummPersonModel.setIdentity(userIdentity);
											cmdSummPersonModel.setWorkContent(sheet.getCell(9, i).getContents().trim());
											cmdSummPersonModel.setCount(Integer.parseInt(sheet.getCell(10, i).getContents().trim()));
											cmdSummPersonModel.setSalary(Integer.parseInt(sheet.getCell(11, i).getContents().trim()));
											cmdSummPersonModel.setDeduct(Integer.parseInt(sheet.getCell(12, i).getContents().trim()));
											cmdSummPersonModel.setRealSalary(Integer.parseInt(sheet.getCell(13, i).getContents().trim()));
											cmdSummPersonModel.setNoSalary(Integer.parseInt(sheet.getCell(14, i).getContents().trim()));
											cmdSummPersonModel.setFlag(sheet.getCell(17, i).getContents().trim());
											cmdSummPersonModel.setNote(sheet.getCell(18, i).getContents().trim());
											cmdSummPersonModel.setDrawee(sheet.getCell(15, i).getContents().trim());
											cmdSummPersonModel.setPayTime(sheet.getCell(16, i).getContents().trim());
											cmdSummPersonModels.add(cmdSummPersonModel);
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count == 0 && !"1".equals(result) && !"2".equals(result) && !"3".equals(result) && !"4".equals(result) && !"5".equals(result) && !"6".equals(result)) {
			result = "7";
		}
		if ("0".equals(result)) {
			if (cmdSummPersonModels != null && !cmdSummPersonModels.isEmpty()) {
				for (CmdSummPersonModel cmdSummPersonModel2 : cmdSummPersonModels) {
					cmdSummPersonService.addCmdSummPerson(cmdSummPersonModel2);
				}
			}
		} 
		return operateReportTeamDetailList(pId, cmdId, tId, teamtype, year, month, result);
	}
	
	/**
	 * 跳转到材料商或设备商新增一个材料商汇总表页面
	 * @param projectId
	 * @param teamtype
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "operate_reportMEAdd.html", method = RequestMethod.GET)
	public ModelAndView operateReportMEAdd(String projectId, String teamtype, String type) {
		ModelAndView mav = new ModelAndView("operate/operate_reportMEAdd");
		mav.addObject("projectId", projectId);
		mav.addObject("teamtype", teamtype);
		mav.addObject("type", type);
		return mav;
	}
	
	/**
	 * 材料商或设备商新增一个材料商汇总表功能
	 * @return
	 */
	@RequestMapping(value = "operate_reportMEAdd2.html", method = RequestMethod.POST)
	public ModelAndView operateReportMEAdd2() {
		String projectId = request.getParameter("projectId");
		ProjectModel projectModel = projectService.getById(projectId);
		String pName = null;
		if (projectModel != null) {
			pName = projectModel.getName();
		}
		int teamtype = Integer.parseInt(request.getParameter("teamtype"));
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String mECode = request.getParameter("mECode");
		int type = 2; // 班组类别：材料商
		if (request.getParameter("type") != "") {
			type = Integer.parseInt(request.getParameter("type"));
		}
		String tId = null; // 班组ID
		String tName = null; // 班组名称
		if (type == 2) {
			MaterialModel materialModel = materialService.getByCode(mECode);
			if (materialModel != null) {
				tId = materialModel.getId();
				tName = materialModel.getName();
			}
		}
		else if (type == 3) {
			EquipmentModel equipmentModel = equipmentService.getByCode(mECode);
			if (equipmentModel != null) {
				tId = equipmentModel.getId();
				tName = equipmentModel.getName();
			}
		}
		int bgpayment = 0;
		if (!"".equals(request.getParameter("bgpayment"))) {
			bgpayment = Integer.parseInt(request.getParameter("bgpayment"));
		}
		int contractPrice = 0;
		if (!"".equals(request.getParameter("contractPrice"))) {
			contractPrice = Integer.parseInt(request.getParameter("contractPrice"));
		}
		String principal = request.getParameter("principal");
		String account = request.getParameter("account");
		String unit = request.getParameter("unit");
		int frequency = 0;
		if (!"".equals(request.getParameter("frequency"))) {
			frequency = Integer.parseInt(request.getParameter("frequency"));
		}
		int nowTotal = 0;
		if (!"".equals(request.getParameter("nowTotal"))) {
			nowTotal = Integer.parseInt(request.getParameter("nowTotal"));
		}
		int total = 0;
		if (!"".equals(request.getParameter("total"))) {
			total = Integer.parseInt(request.getParameter("total"));
		}
		int culPercentage = 0;
		if (!"".equals(request.getParameter("culPercentage"))) {
			culPercentage = Integer.parseInt(request.getParameter("culPercentage"));
		}
		int percentage = 0;
		if (!"".equals(request.getParameter("percentage"))) {
			percentage = Integer.parseInt(request.getParameter("percentage"));
		}
		int thispay = 0;
		if (!"".equals(request.getParameter("thispay"))) {
			thispay = Integer.parseInt(request.getParameter("thispay"));
		}
		int culapay = 0;
		if (!"".equals(request.getParameter("culapay"))) {
			culapay = Integer.parseInt(request.getParameter("culapay"));
		}
		int budget = 0;
		if (!"".equals(request.getParameter("budget"))) {
			budget = Integer.parseInt(request.getParameter("budget"));
		}
		int num = 0;
		if (!"".equals(request.getParameter("num"))) {
			num = Integer.parseInt(request.getParameter("num"));
		}
		int price = 0;
		if (!"".equals(request.getParameter("price"))) {
			price = Integer.parseInt(request.getParameter("price"));
		}
		int subtotal = 0;
		if (!"".equals(request.getParameter("subtotal"))) {
			subtotal = Integer.parseInt(request.getParameter("subtotal"));
		}
		int receipt = 0;
		if (!"".equals(request.getParameter("receipt"))) {
			receipt = Integer.parseInt(request.getParameter("receipt"));
		}
		int cumulative = 0;
		if (!"".equals(request.getParameter("cumulative"))) {
			cumulative = Integer.parseInt(request.getParameter("cumulative"));
		}
		int otherpay = 0;
		if (!"".equals(request.getParameter("otherpay"))) {
			otherpay = Integer.parseInt(request.getParameter("otherpay"));
		}
		int restpay = 0;
		if (!"".equals(request.getParameter("restpay"))) {
			restpay = Integer.parseInt(request.getParameter("restpay"));
		}
		int remain = 0;
		if (!"".equals(request.getParameter("remain"))) {
			remain = Integer.parseInt(request.getParameter("remain"));
		}
		int deposit = 0;
		if (!"".equals(request.getParameter("deposit"))) {
			deposit = Integer.parseInt(request.getParameter("deposit"));
		}
		String settlement = request.getParameter("settlement");
		String invoice = request.getParameter("invoice");
		String note = request.getParameter("note");
		cmdSummService.addSupplierCmdSumm(projectId, pName, tId, type, teamtype, tName, principal, account, unit, frequency, budget, num, price, subtotal, bgpayment, receipt, cumulative, thispay, culapay, otherpay, restpay, settlement, note, Integer.parseInt(year), Integer.parseInt(month), contractPrice, total, nowTotal, percentage, remain, culPercentage, deposit, invoice);
		if (type == 2) {
			return operateReportMaterialList(year, month, projectId, (type + ""), "0");
		}
		else {
			return operateReportEquipmentList(year, month, projectId, (type + ""), "0");
		}
	}
	
	/**
	 * 跳转到材料商或者设备商的明细列表
	 * @param projectId
	 * @param cmdId
	 * @param tId
	 * @param teamtype - 班组类型：1-本班组，2-劳务班组，3-专业班组
	 * @param type - 班组类别： 1-租赁方，2-材料商，3-设备商
	 * @param year
	 * @param month
	 * @return
	 */
	@RequestMapping(value = "operate_reportMEDetailList.html", method = RequestMethod.GET)
	public ModelAndView operateReportMEDetailList(String projectId, String cmdId, String tId, String teamtype, String type, String year, String month, String result) {
		ModelAndView mav = new ModelAndView("operate/operate_reportMEDetailList");
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		List<CmdSummSupplierModel> cmdSummSupplierModels = new ArrayList<CmdSummSupplierModel>();
		UserCmdSummDetailVo userCmdSummDetailVo = null;
		List<UserCmdSummDetailVo> userCmdSummDetailVos = new ArrayList<UserCmdSummDetailVo>();
		int typeInt = Integer.parseInt(type); 
		if (typeInt == 2) { // 材料商
			MaterialModel materialModel = materialService.getById(tId);
			if (materialModel != null) {
				mav.addObject("materialModel", materialModel);
				cmdSummSupplierModels = cmdSummSupplierService.getByCmdIdAndTIdAndTeamTypeAndYearMonth(cmdId, tId, Integer.parseInt(teamtype), Integer.parseInt(type), Integer.parseInt(year), Integer.parseInt(month));
				if (cmdSummSupplierModels != null && !cmdSummSupplierModels.isEmpty()) {
					for (CmdSummSupplierModel cmdSummSupplierModel : cmdSummSupplierModels) {
						userCmdSummDetailVo = new UserCmdSummDetailVo();
						userCmdSummDetailVo.setMaterialModel(materialModel);
						userCmdSummDetailVo.setCmdSummSupplierModel(cmdSummSupplierModel);
						userCmdSummDetailVos.add(userCmdSummDetailVo);
					}
				}
			}
		}
		else { // typeInt只能为3，为设备商
			EquipmentModel equipmentModel = equipmentService.getById(tId);
			if (equipmentModel != null) {
				mav.addObject("equipmentModel", equipmentModel);
				cmdSummSupplierModels = cmdSummSupplierService.getByCmdIdAndTIdAndTeamTypeAndYearMonth(cmdId, tId, Integer.parseInt(teamtype), Integer.parseInt(type), Integer.parseInt(year), Integer.parseInt(month));
				if (cmdSummSupplierModels != null && !cmdSummSupplierModels.isEmpty()) {
					for (CmdSummSupplierModel cmdSummSupplierModel : cmdSummSupplierModels) {
						userCmdSummDetailVo = new UserCmdSummDetailVo();
						userCmdSummDetailVo.setEquipmentModel(equipmentModel);
						userCmdSummDetailVo.setCmdSummSupplierModel(cmdSummSupplierModel);
						userCmdSummDetailVos.add(userCmdSummDetailVo);
					}
				}
			}
		}
		if (userCmdSummDetailVos != null && !userCmdSummDetailVos.isEmpty()) {
			mav.addObject("userCmdSummDetailVos", userCmdSummDetailVos);
		}
		mav.addObject("pId", projectId);
		mav.addObject("cmdId", cmdId);
		mav.addObject("tId", tId);
		mav.addObject("teamtype", teamtype);
		mav.addObject("type", type);
		mav.addObject("year", year);
		mav.addObject("month", month);
		mav.addObject("result", result);
		return mav;
	}
	
	/**
	 * 供应商主要明细表的导出功能
	 * @param response
	 * @param year
	 * @param month
	 * @param projectId
	 * @param cmdId
	 * @param tId
	 * @param teamtype
	 * @param type
	 */
	@RequestMapping(value = "operate_reportMEDetailListToExcel.html", method = RequestMethod.GET)
	public void operateReportMEDetailListToExcel(HttpServletResponse response, String year, String month, String projectId, String cmdId, String tId, String teamtype, String type) {
		List<CmdSummSupplierModel> cmdSummSupplierModels = new ArrayList<CmdSummSupplierModel>();
		UserCmdSummDetailVo userCmdSummDetailVo = null;
		List<UserCmdSummDetailVo> userCmdSummDetailVos = new ArrayList<UserCmdSummDetailVo>();
		int typeInt = Integer.parseInt(type); 
		if (typeInt == 2) { // 材料商
			MaterialModel materialModel = materialService.getById(tId);
			if (materialModel != null) {
				cmdSummSupplierModels = cmdSummSupplierService.getByCmdIdAndTIdAndTeamTypeAndYearMonth(cmdId, tId, Integer.parseInt(teamtype), Integer.parseInt(type), Integer.parseInt(year), Integer.parseInt(month));
				if (cmdSummSupplierModels != null && !cmdSummSupplierModels.isEmpty()) {
					for (CmdSummSupplierModel cmdSummSupplierModel : cmdSummSupplierModels) {
						userCmdSummDetailVo = new UserCmdSummDetailVo();
						userCmdSummDetailVo.setMaterialModel(materialModel);
						userCmdSummDetailVo.setCmdSummSupplierModel(cmdSummSupplierModel);
						userCmdSummDetailVos.add(userCmdSummDetailVo);
					}
				}
			}
		} else { // typeInt只能为3，为设备商
			EquipmentModel equipmentModel = equipmentService.getById(tId);
			if (equipmentModel != null) {
				cmdSummSupplierModels = cmdSummSupplierService.getByCmdIdAndTIdAndTeamTypeAndYearMonth(cmdId, tId, Integer.parseInt(teamtype), Integer.parseInt(type), Integer.parseInt(year), Integer.parseInt(month));
				if (cmdSummSupplierModels != null && !cmdSummSupplierModels.isEmpty()) {
					for (CmdSummSupplierModel cmdSummSupplierModel : cmdSummSupplierModels) {
						userCmdSummDetailVo = new UserCmdSummDetailVo();
						userCmdSummDetailVo.setEquipmentModel(equipmentModel);
						userCmdSummDetailVo.setCmdSummSupplierModel(cmdSummSupplierModel);
						userCmdSummDetailVos.add(userCmdSummDetailVo);
					}
				}
			}
		}
		if (userCmdSummDetailVos != null && !userCmdSummDetailVos.isEmpty()) {
			Iterator<UserCmdSummDetailVo> it = userCmdSummDetailVos.iterator();
			List<CmdSummSupplierModel> cmdSummSupplierModelToExcels = new ArrayList<CmdSummSupplierModel>();
			while (it.hasNext()) {
				UserCmdSummDetailVo userCmdSummDetailVoToExcel = it.next();
				CmdSummSupplierModel cmdSummSupplierModelToExcel = new CmdSummSupplierModel();
				if (userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getType() == 2) { // typeInt只能为2，为材料商
					cmdSummSupplierModelToExcel.settName(userCmdSummDetailVoToExcel.getMaterialModel().getName());
				} else { // typeInt只能为3，为设备商
					cmdSummSupplierModelToExcel.settName(userCmdSummDetailVoToExcel.getEquipmentModel().getName());
				}
				if (userCmdSummDetailVoToExcel.getCmdSummSupplierModel() != null) {
					if (userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getPrincipal() != null) {
						cmdSummSupplierModelToExcel.setPrincipal(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getPrincipal());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getcName() != null) {
						cmdSummSupplierModelToExcel.setcName(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getcName());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getAccount() != null) {
						cmdSummSupplierModelToExcel.setAccount(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getAccount());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getUnit() != null) {
						cmdSummSupplierModelToExcel.setUnit(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getUnit());
					}
					if ((Integer) userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getFrequency() != null) {
						cmdSummSupplierModelToExcel.setFrequency(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getFrequency());
					}
					if ((Integer) userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getBudget() != null) {
						cmdSummSupplierModelToExcel.setBudget(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getBudget());
					}
					if ((Integer) userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getNum() != null) {
						cmdSummSupplierModelToExcel.setNum(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getNum());
					}
					if ((Integer) userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getPrice() != null) {
						cmdSummSupplierModelToExcel.setPrice(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getPrice());
					}
					if ((Integer) userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getSubtotal() != null) {
						cmdSummSupplierModelToExcel.setSubtotal(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getSubtotal());
					}
					if ((Integer) userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getBgpayment() != null) {
						cmdSummSupplierModelToExcel.setBgpayment(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getBgpayment());
					}
					if ((Integer) userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getReceipt() != null) {
						cmdSummSupplierModelToExcel.setReceipt(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getReceipt());
					}
					if ((Integer) userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getCumulative() != null) {
						cmdSummSupplierModelToExcel.setCumulative(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getCumulative());
					}
					if ((Integer) userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getThispay() != null) {
						cmdSummSupplierModelToExcel.setThispay(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getThispay());
					}
					if ((Integer) userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getCulapay() != null) {
						cmdSummSupplierModelToExcel.setCulapay(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getCulapay());
					}
					if ((Integer) userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getOtherpay() != null) {
						cmdSummSupplierModelToExcel.setOtherpay(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getOtherpay());
					}
					if ((Integer) userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getRestpay() != null) {
						cmdSummSupplierModelToExcel.setRestpay(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getRestpay());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getInformation() != null) {
						cmdSummSupplierModelToExcel.setInformation(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getInformation());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getInvoice() != null) {
						cmdSummSupplierModelToExcel.setInvoice(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getInvoice());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getSettlement() != null) {
						cmdSummSupplierModelToExcel.setSettlement(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getSettlement());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getUsing() != null) {
						cmdSummSupplierModelToExcel.setUsing(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getUsing());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getQuality() != null) {
						cmdSummSupplierModelToExcel.setQuality(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getQuality());
					}
					if (userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getNote() != null) {
						cmdSummSupplierModelToExcel.setNote(userCmdSummDetailVoToExcel.getCmdSummSupplierModel().getNote());
					}
				}
				cmdSummSupplierModelToExcels.add(cmdSummSupplierModelToExcel);
			}
			String[] tTitle = {"序号", "供应商", "经办人", "名称/规格/型号", "支付账号和凭证", "单位", "次数", "预算量", "数量", 
					"单价", "小计", "预付款", "本次入库量", "累计入库量", "本次付款", "累计付款", "其它款", "余款", "资料情况", 
					"发票情况", "结算情况", "用途", "质量", "备注"};
			String[] dateFiled = {""};
			ProjectModel projectModel = projectService.getById(projectId);
			String projectName = null;
			if (projectModel != null) {
				projectName = projectModel.getName();
			}
			Date ctime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			String currentTime = formatter.format(ctime);
			String fileName = projectName + year + "年" + month + "月";
			String tName = null;
			if (typeInt == 2) {
				MaterialModel materialModel = materialService.getById(tId);
				if (materialModel != null) {
					tName = materialModel.getName();
				}
				fileName += tName + "的材料";
			} else {
				EquipmentModel equipmentModel = equipmentService.getById(tId);
				if (equipmentModel != null) {
					tName = equipmentModel.getName();
				}
				fileName += tName + "的设备";
			}
			fileName += "验工计价明细表" + currentTime;
			String tableName = "cmdSummSupplier";
			int needIndex[] = {100, 7, 8, 9, 10, 11, 12, 36, 13, 14, 15, 35, 37, 38, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
			if (cmdSummSupplierModelToExcels != null && !cmdSummSupplierModelToExcels.isEmpty()) {
				try {
					ExportExcel.recoredExportExcel(response, tableName, tTitle, fileName, needIndex, cmdSummSupplierModelToExcels, dateFiled);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 跳转到材料商或设备商明细表的新增页面
	 * @param cmdId
	 * @param pId
	 * @param tId
	 * @param teamtype - 班组类型：1-本班组，2-劳务班组，3-专业班组
	 * @param type - 班组类别： 1-租赁方，2-材料商，3-设备商
	 * @param year
	 * @param month
	 * @return
	 */
	@RequestMapping(value = "operate_reportMEDetailAdd.html", method = RequestMethod.GET)
	public ModelAndView operateReportMEDetailAdd(String cmdId, String pId, String tId, String teamtype, String type, String year, String month) {
		ModelAndView mav = new ModelAndView("operate/operate_reportMEDetailAdd");
		int typeInt = Integer.parseInt(type);
		if (typeInt == 2) { // 2表示为材料商
			MaterialModel materialModel = materialService.getById(tId);
			if (materialModel != null) {
				mav.addObject("materialModel", materialModel);
			}
		}
		else if (typeInt == 3) { // 3表示为设备商
			EquipmentModel equipmentModel = equipmentService.getById(tId);
			if (equipmentModel != null) {
				mav.addObject("equipmentModel", equipmentModel);
			}
		}
		mav.addObject("cmdId", cmdId);
		mav.addObject("pId", pId);
		mav.addObject("tId", tId);
		mav.addObject("teamtype", teamtype);
		mav.addObject("type", type);
		mav.addObject("year", year);
		mav.addObject("month", month);
		return mav;
	}
	
	/**
	 * 材料商或设备商明细表的新增功能
	 * @return
	 */
	@RequestMapping(value = "operate_reportMEDetailAdd2.html", method = RequestMethod.POST)
	public ModelAndView operateReportMEDetailAdd2() {
		String cmdId = request.getParameter("cmdId");
		String pId = request.getParameter("pId");
		String tId = request.getParameter("tId");
		String teamtype = request.getParameter("teamtype");
		String type = request.getParameter("type");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String pName = null; // 项目的名称
		ProjectModel projectModel = projectService.getById(pId);
		if (projectModel != null) {
			pName = projectModel.getName();
		}
		String tName = null;
		int typeInt = Integer.parseInt(type);
		if (typeInt == 2) { // 材料商
			MaterialModel materialModel = materialService.getById(tId);
			if (materialModel != null) {
				tName = materialModel.getName();
			}
		}
		else if (typeInt == 3) { //设备商 
			EquipmentModel equipmentModel = equipmentService.getById(tId);
			if (equipmentModel != null) {
				tName = equipmentModel.getName();
			}
		}
		String principal = request.getParameter("principal");
		String cName = request.getParameter("cName");
		String account = request.getParameter("account");
		String unit = request.getParameter("unit");
		int frequency = 0;
		if (request.getParameter("frequency") != "") {
			frequency = Integer.parseInt(request.getParameter("frequency"));
		}
		int budget = 0;
		if (request.getParameter("budget") != "") {
			budget = Integer.parseInt(request.getParameter("budget"));
		}
		int num = 0;
		if (request.getParameter("num") != "") {
			num = Integer.parseInt(request.getParameter("num"));
		}
		int price = 0;
		if (request.getParameter("price") != "") {
			price = Integer.parseInt(request.getParameter("price"));
		}
		int subtotal = 0;
		if (request.getParameter("subtotal") != "") {
			subtotal = Integer.parseInt(request.getParameter("subtotal"));
		}
		int receipt = 0;
		if (request.getParameter("receipt") != "") {
			receipt = Integer.parseInt(request.getParameter("receipt"));
		}
		int cumulative = 0;
		if (request.getParameter("cumulative") != "") {
			cumulative = Integer.parseInt(request.getParameter("cumulative"));
		}
		int thispay = 0;
		if (request.getParameter("thispay") != "") {
			thispay = Integer.parseInt(request.getParameter("thispay"));
		}
		int culapay = 0;
		if (request.getParameter("culapay") != "") {
			culapay = Integer.parseInt(request.getParameter("culapay"));
		}
		int otherpay = 0;
		if (request.getParameter("otherpay") != "") {
			otherpay = Integer.parseInt(request.getParameter("otherpay"));
		}
		int restpay = 0;
		if (request.getParameter("restpay") != "") {
			restpay = Integer.parseInt(request.getParameter("restpay"));
		}
		int bgpayment = 0;
		if (request.getParameter("bgpayment") != "") {
			bgpayment = Integer.parseInt(request.getParameter("bgpayment"));
		}
		String information = request.getParameter("information");
		String invoice = request.getParameter("invoice");
		String settlement = request.getParameter("settlement");
		String using = request.getParameter("using");
		String quality = request.getParameter("quality");
		String note = request.getParameter("note");
		cmdSummSupplierService.addCmdSummSupplier(cmdId, pId, pName, typeInt, Integer.parseInt(teamtype), tId, tName, principal, cName, account, unit, frequency, num, price, subtotal, thispay, culapay, otherpay, restpay, bgpayment, budget, receipt, cumulative, information, invoice, settlement, using, quality, note, Integer.parseInt(year), Integer.parseInt(month));
		return operateReportMEDetailList(pId, cmdId, tId, teamtype, type, year, month, "0");
	}
	
	/**
	 * 材料费用（材料商）本班组汇总表的导出功能
	 * @param response
	 * @param year
	 * @param month
	 * @param projectId
	 */
	@RequestMapping(value = "operate_reportBenMaterialListToExcel.html", method = RequestMethod.GET)
	public void operateReportBenMaterialListToExcel(HttpServletResponse response, String year, String month, String projectId) {
		getMERecoredExportExcel(response, year, month, projectId, 2, 1); // 2表示材料商type，1表示本班组teamType
	}
	
	/**
	 * 材料费用（材料商）劳务班组汇总表的导出功能
	 * @param response
	 * @param year
	 * @param month
	 * @param projectId
	 */
	@RequestMapping(value = "operate_reportLaoMaterialListToExcel.html", method = RequestMethod.GET)
	public void operateReportLaoMaterialListToExcel(HttpServletResponse response, String year, String month, String projectId) {
		getMERecoredExportExcel(response, year, month, projectId, 2, 2); // 第一个2表示材料商type，第二个2表示劳务班组teamType
	}
	
	/**
	 * 材料费用（材料商）专业班组汇总表的导出功能
	 * @param response
	 * @param year
	 * @param month
	 * @param projectId
	 */
	@RequestMapping(value = "operate_reportZhuMaterialListToExcel.html", method = RequestMethod.GET)
	public void operateReportZhuMaterialListToExcel(HttpServletResponse response, String year, String month, String projectId) {
		getMERecoredExportExcel(response, year, month, projectId, 2, 3); // 2表示材料商type，2表示专业班组teamType
	}
	
	/**
	 * 设备费用（材料商）本班组汇总表的导出功能
	 * @param response
	 * @param year
	 * @param month
	 * @param projectId
	 */
	@RequestMapping(value = "operate_reportBenEquipmentListToExcel.html", method = RequestMethod.GET)
	public void operateReportBenEquipmentListToExcel(HttpServletResponse response, String year, String month, String projectId) {
		getMERecoredExportExcel(response, year, month, projectId, 3, 1); // 3表示设备商type，1表示本班组teamType
	}
	
	/**
	 * 设备费用（材料商）劳务班组汇总表的导出功能
	 * @param response
	 * @param year
	 * @param month
	 * @param projectId
	 */
	@RequestMapping(value = "operate_reportLaoEquipmentListToExcel.html", method = RequestMethod.GET)
	public void operateReportLaoEquipmentListToExcel(HttpServletResponse response, String year, String month, String projectId) {
		getMERecoredExportExcel(response, year, month, projectId, 3, 2); // 3表示设备商type，2表示劳务班组teamType
	}
	
	/**
	 * 设备费用（材料商）专业班组汇总表的导出功能
	 * @param response
	 * @param year
	 * @param month
	 * @param projectId
	 */
	@RequestMapping(value = "operate_reportZhuEquipmentListToExcel.html", method = RequestMethod.GET)
	public void operateReportZhuEquipmentListToExcel(HttpServletResponse response, String year, String month, String projectId) {
		getMERecoredExportExcel(response, year, month, projectId, 3, 3); // 第一个3表示设备商type，第二个3表示专业班组teamType
	}
	
	/**
	 * 供应商(材料/设备商)汇总表的EXCEL模板文件
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "operate_reportMEDownloadExcel.html", method = RequestMethod.GET)
	public void operateReportMEDownloadExcel(HttpServletRequest request, HttpServletResponse response) {
		String filePath = Config.getInstance().getRootPath() + "exceltemplate/reportME.xml";
		DownLoadExcelTemplateUtil.getExcelTemplate(filePath, request, response);
	}
	
	/**
	 * 供应商(材料/设备商)汇总表的导入功能
	 * @param projectId
	 * @param flag
	 * @param type
	 * @param year
	 * @param month
	 * @param teamtype
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "operate_reportMEImportExcel.html", method = RequestMethod.POST)
	public ModelAndView operateReportMEImportExcel(String projectId, String flag, String type, String year, String month, String teamtype, HttpServletRequest request, HttpServletResponse response) {
		String result = "0";
		String filePath = request.getSession().getServletContext().getRealPath("\\resource\\execl\\import\\report_mesum") + "\\" + projectId;
		String fileName = ImportExcel.createDateExcel(filePath, config, request, response);
		CmdSummModel cmdSummModel = null;
		List<CmdSummModel> cmdSummModels = new ArrayList<CmdSummModel>();
		Workbook workbook = null;
		int count = -1;
		String projectName = null;
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			projectName = projectModel.getName();
		}
		try {
			workbook = Workbook.getWorkbook(new java.io.File(filePath + "\\" + fileName));
			Sheet sheet = workbook.getSheet(0);
			if (!("供应商(材料商、设备商)汇总表导入".equals(sheet.getCell(0, 0).getContents().trim()) && "供应商名称".equals(sheet.getCell(0, 1).getContents().trim()) &&
					"委托或经办人".equals(sheet.getCell(1, 1).getContents().trim()) && "支付帐号及凭证".equals(sheet.getCell(2, 1).getContents().trim()) &&
					"单位".equals(sheet.getCell(3, 1).getContents().trim()) && "次数".equals(sheet.getCell(4, 1).getContents().trim()) &&
					"预算量".equals(sheet.getCell(5, 1).getContents().trim()) && "合同价(万)".equals(sheet.getCell(6, 1).getContents().trim()) &&
					"数量".equals(sheet.getCell(7, 1).getContents().trim()) && "单价".equals(sheet.getCell(8, 1).getContents().trim()) &&
					"小计".equals(sheet.getCell(9, 1).getContents().trim()) && "预付款(万)".equals(sheet.getCell(10, 1).getContents().trim()) &&
					"本次工程量".equals(sheet.getCell(11, 1).getContents().trim()) && "总工程量".equals(sheet.getCell(12, 1).getContents().trim()) &&
					"累计完成工程量%".equals(sheet.getCell(13, 1).getContents().trim()) && "本次入库量".equals(sheet.getCell(14, 1).getContents().trim()) &&
					"累计入库量".equals(sheet.getCell(15, 1).getContents().trim()) && "本次付款".equals(sheet.getCell(16, 1).getContents().trim()) &&
					"累计付款".equals(sheet.getCell(17, 1).getContents().trim()) && "累计付款百分比%".equals(sheet.getCell(18, 1).getContents().trim()) &&
					"其他款".equals(sheet.getCell(19, 1).getContents().trim()) && "余款".equals(sheet.getCell(20, 1).getContents().trim()) &&
					"余额".equals(sheet.getCell(21, 1).getContents().trim()) && "押金".equals(sheet.getCell(22, 1).getContents().trim()) &&
					"结算情况".equals(sheet.getCell(23, 1).getContents().trim()) && "发票情况".equals(sheet.getCell(24, 1).getContents().trim()) &&
					"备注".equals(sheet.getCell(25, 1).getContents().trim()))) {
				result = "5";
			} else {
				for (int i = 2; i < sheet.getRows(); i++) {
					count++;
					if ("".equals(sheet.getCell(0, i).getContents().trim()) && "".equals(sheet.getCell(1, i).getContents().trim()) && 
							"".equals(sheet.getCell(2, i).getContents().trim()) && "".equals(sheet.getCell(3, i).getContents().trim()) && 
							"".equals(sheet.getCell(4, i).getContents().trim()) && "".equals(sheet.getCell(5, i).getContents().trim()) &&
							"".equals(sheet.getCell(6, i).getContents().trim()) && "".equals(sheet.getCell(7, i).getContents().trim()) &&
							"".equals(sheet.getCell(8, i).getContents().trim()) && "".equals(sheet.getCell(9, i).getContents().trim()) &&
							"".equals(sheet.getCell(10, i).getContents().trim()) && "".equals(sheet.getCell(11, i).getContents().trim()) &&
							"".equals(sheet.getCell(12, i).getContents().trim()) && "".equals(sheet.getCell(13, i).getContents().trim()) &&
							"".equals(sheet.getCell(14, i).getContents().trim()) && "".equals(sheet.getCell(15, i).getContents().trim()) &&
							"".equals(sheet.getCell(16, i).getContents().trim()) && "".equals(sheet.getCell(17, i).getContents().trim()) &&
							"".equals(sheet.getCell(18, i).getContents().trim()) && "".equals(sheet.getCell(19, i).getContents().trim()) &&
							"".equals(sheet.getCell(20, i).getContents().trim()) && "".equals(sheet.getCell(21, i).getContents().trim()) &&
							"".equals(sheet.getCell(22, i).getContents().trim()) && "".equals(sheet.getCell(23, i).getContents().trim()) &&
							"".equals(sheet.getCell(24, i).getContents().trim()) && "".equals(sheet.getCell(25, i).getContents().trim())) { // 如果某一行为空，跳出，因为模板可能有7行，而数据只有2行，这里是不具有模板数据而言的
						break;
					}
					if ("".equals(sheet.getCell(0, i).getContents().trim()) && "".equals(sheet.getCell(1, i).getContents().trim()) && 
							"".equals(sheet.getCell(2, i).getContents().trim()) && "".equals(sheet.getCell(3, i).getContents().trim()) &&
							"0".equals(sheet.getCell(4, i).getContents().trim()) && "0".equals(sheet.getCell(5, i).getContents().trim()) &&
							"0".equals(sheet.getCell(6, i).getContents().trim()) && "0".equals(sheet.getCell(7, i).getContents().trim()) &&
							"0".equals(sheet.getCell(8, i).getContents().trim()) && "0".equals(sheet.getCell(9, i).getContents().trim()) &&
							"0".equals(sheet.getCell(10, i).getContents().trim()) && "0".equals(sheet.getCell(11, i).getContents().trim()) &&
							"0".equals(sheet.getCell(12, i).getContents().trim()) && "0".equals(sheet.getCell(13, i).getContents().trim()) &&
							"0".equals(sheet.getCell(14, i).getContents().trim()) && "0".equals(sheet.getCell(15, i).getContents().trim()) &&
							"0".equals(sheet.getCell(16, i).getContents().trim()) && "0".equals(sheet.getCell(17, i).getContents().trim()) &&
							"0".equals(sheet.getCell(18, i).getContents().trim()) && "0".equals(sheet.getCell(19, i).getContents().trim()) &&
							"0".equals(sheet.getCell(20, i).getContents().trim()) && "0".equals(sheet.getCell(21, i).getContents().trim()) &&
							"0".equals(sheet.getCell(22, i).getContents().trim()) && "".equals(sheet.getCell(23, i).getContents().trim()) &&
							"".equals(sheet.getCell(24, i).getContents().trim()) && "".equals(sheet.getCell(25, i).getContents().trim())) {  //验证数据的完整性,其他数据可以为空，或者设置默认值，但是默认值为0，这里是对前几条模板数据的
						break;
					} 
					if ("".equals(sheet.getCell(0, i).getContents().trim()) || "".equals(sheet.getCell(1, i).getContents().trim()) || 
							"".equals(sheet.getCell(2, i).getContents().trim()) || "".equals(sheet.getCell(3, i).getContents().trim()) || 
							"".equals(sheet.getCell(4, i).getContents().trim()) || "".equals(sheet.getCell(5, i).getContents().trim()) ||
							"".equals(sheet.getCell(6, i).getContents().trim()) || "".equals(sheet.getCell(7, i).getContents().trim()) ||
							"".equals(sheet.getCell(8, i).getContents().trim()) || "".equals(sheet.getCell(9, i).getContents().trim()) ||
							"".equals(sheet.getCell(10, i).getContents().trim()) || "".equals(sheet.getCell(11, i).getContents().trim()) ||
							"".equals(sheet.getCell(12, i).getContents().trim()) || "".equals(sheet.getCell(13, i).getContents().trim()) ||
							"".equals(sheet.getCell(14, i).getContents().trim()) || "".equals(sheet.getCell(15, i).getContents().trim()) ||
							"".equals(sheet.getCell(16, i).getContents().trim()) || "".equals(sheet.getCell(17, i).getContents().trim()) ||
							"".equals(sheet.getCell(18, i).getContents().trim()) || "".equals(sheet.getCell(19, i).getContents().trim()) ||
							"".equals(sheet.getCell(20, i).getContents().trim()) || "".equals(sheet.getCell(21, i).getContents().trim()) ||
							"".equals(sheet.getCell(22, i).getContents().trim())) {  //验证数据的完整性
						result = "1";
						break;
					} else { 
						if ("2".equals(type)) { // 材料商
							String materialName = sheet.getCell(0, i).getContents().trim();
							MaterialModel isExistMaterialName = materialService.getByName(materialName);
							if (isExistMaterialName == null) { // 材料商Material本身不存在
								result = "2";
								break;
							} else {
								// 不验证材料商与施工班组的关系
								CmdSummModel isExistCmdSummModel = cmdSummService.getByTimeAndTypesAndIds(Integer.parseInt(year), Integer.parseInt(month), 2, Integer.parseInt(teamtype), projectId, isExistMaterialName.getId()); // 2表示材料商type
								if (isExistCmdSummModel != null) { // 这个月份这个材料商的数据已经存在
									result = "3";
									break;
								} else {
									cmdSummModel = new CmdSummModel();
									cmdSummModel.setpId(projectId);
									cmdSummModel.setpName(projectName);
									cmdSummModel.settId(isExistMaterialName.getId());
									cmdSummModel.setType(2); // 设置为材料商类型
									cmdSummModel.setTeamtype(Integer.parseInt(teamtype));
									cmdSummModel.settName(materialName);
									cmdSummModel.setContractPrice(Integer.parseInt(sheet.getCell(6, i).getContents().trim()));
									cmdSummModel.setBgpayment(Integer.parseInt(sheet.getCell(10, i).getContents().trim()));
									cmdSummModel.setFrequency(Integer.parseInt(sheet.getCell(4, i).getContents().trim()));
									cmdSummModel.setUnit(sheet.getCell(3, i).getContents().trim());
									cmdSummModel.setTotal(Integer.parseInt(sheet.getCell(12, i).getContents().trim()));
									cmdSummModel.setNowTotal(Integer.parseInt(sheet.getCell(11, i).getContents().trim()));
									cmdSummModel.setPercentage(Integer.parseInt(sheet.getCell(13, i).getContents().trim()));
									cmdSummModel.setThispay(Integer.parseInt(sheet.getCell(16, i).getContents().trim()));
									cmdSummModel.setCulapay(Integer.parseInt(sheet.getCell(17, i).getContents().trim()));
									cmdSummModel.setRemain(Integer.parseInt(sheet.getCell(21, i).getContents().trim()));
									cmdSummModel.setCulPercentage(Integer.parseInt(sheet.getCell(18, i).getContents().trim()));
									cmdSummModel.setDeposit(Integer.parseInt(sheet.getCell(22, i).getContents().trim()));
									cmdSummModel.setSettlement(sheet.getCell(23, i).getContents().trim());
									cmdSummModel.setNote(sheet.getCell(25, i).getContents().trim());
									cmdSummModel.setYear(Integer.parseInt(year));
									cmdSummModel.setMonth(Integer.parseInt(month));
									cmdSummModel.setPrincipal(sheet.getCell(1, i).getContents().trim());
									cmdSummModel.setAccount(sheet.getCell(2, i).getContents().trim());
									cmdSummModel.setBudget(Integer.parseInt(sheet.getCell(5, i).getContents().trim()));
									cmdSummModel.setNum(Integer.parseInt(sheet.getCell(7, i).getContents().trim()));
									cmdSummModel.setPrice(Integer.parseInt(sheet.getCell(8, i).getContents().trim()));
									cmdSummModel.setSubtotal(Integer.parseInt(sheet.getCell(9, i).getContents().trim()));
									cmdSummModel.setReceipt(Integer.parseInt(sheet.getCell(14, i).getContents().trim()));
									cmdSummModel.setCumulative(Integer.parseInt(sheet.getCell(15, i).getContents().trim()));
									cmdSummModel.setOtherpay(Integer.parseInt(sheet.getCell(19, i).getContents().trim()));
									cmdSummModel.setRestpay(Integer.parseInt(sheet.getCell(20, i).getContents().trim()));
									cmdSummModel.setInvoice(sheet.getCell(24, i).getContents().trim());
									cmdSummModels.add(cmdSummModel);
								}
							}
						} else { // 设备商
							String EquipmentName = sheet.getCell(0, i).getContents().trim();
							EquipmentModel isExistEquipmentName = equipmentService.getByName(EquipmentName);
							if (isExistEquipmentName == null) { // 材料商Material本身不存在
								result = "2";
								break;
							} else {
								CmdSummModel isExistCmdSummModel = cmdSummService.getByTimeAndTypesAndIds(Integer.parseInt(year), Integer.parseInt(month), 3, Integer.parseInt(teamtype), projectId, isExistEquipmentName.getId()); // 3表示设备商type
								if (isExistCmdSummModel != null) { // 这个月份这个设备商的数据已经存在
									result = "3";
									break;
								} else {
									cmdSummModel = new CmdSummModel();
									cmdSummModel.setpId(projectId);
									cmdSummModel.setpName(projectName);
									cmdSummModel.settId(isExistEquipmentName.getId());
									cmdSummModel.setType(3); // 设置为设备商类型
									cmdSummModel.setTeamtype(Integer.parseInt(teamtype));
									cmdSummModel.settName(EquipmentName);
									cmdSummModel.setContractPrice(Integer.parseInt(sheet.getCell(6, i).getContents().trim()));
									cmdSummModel.setBgpayment(Integer.parseInt(sheet.getCell(10, i).getContents().trim()));
									cmdSummModel.setFrequency(Integer.parseInt(sheet.getCell(4, i).getContents().trim()));
									cmdSummModel.setUnit(sheet.getCell(3, i).getContents().trim());
									cmdSummModel.setTotal(Integer.parseInt(sheet.getCell(12, i).getContents().trim()));
									cmdSummModel.setNowTotal(Integer.parseInt(sheet.getCell(11, i).getContents().trim()));
									cmdSummModel.setPercentage(Integer.parseInt(sheet.getCell(13, i).getContents().trim()));
									cmdSummModel.setThispay(Integer.parseInt(sheet.getCell(16, i).getContents().trim()));
									cmdSummModel.setCulapay(Integer.parseInt(sheet.getCell(17, i).getContents().trim()));
									cmdSummModel.setRemain(Integer.parseInt(sheet.getCell(21, i).getContents().trim()));
									cmdSummModel.setCulPercentage(Integer.parseInt(sheet.getCell(18, i).getContents().trim()));
									cmdSummModel.setDeposit(Integer.parseInt(sheet.getCell(22, i).getContents().trim()));
									cmdSummModel.setSettlement(sheet.getCell(23, i).getContents().trim());
									cmdSummModel.setNote(sheet.getCell(25, i).getContents().trim());
									cmdSummModel.setYear(Integer.parseInt(year));
									cmdSummModel.setMonth(Integer.parseInt(month));
									cmdSummModel.setPrincipal(sheet.getCell(1, i).getContents().trim());
									cmdSummModel.setAccount(sheet.getCell(2, i).getContents().trim());
									cmdSummModel.setBudget(Integer.parseInt(sheet.getCell(5, i).getContents().trim()));
									cmdSummModel.setNum(Integer.parseInt(sheet.getCell(7, i).getContents().trim()));
									cmdSummModel.setPrice(Integer.parseInt(sheet.getCell(8, i).getContents().trim()));
									cmdSummModel.setSubtotal(Integer.parseInt(sheet.getCell(9, i).getContents().trim()));
									cmdSummModel.setReceipt(Integer.parseInt(sheet.getCell(14, i).getContents().trim()));
									cmdSummModel.setCumulative(Integer.parseInt(sheet.getCell(15, i).getContents().trim()));
									cmdSummModel.setOtherpay(Integer.parseInt(sheet.getCell(19, i).getContents().trim()));
									cmdSummModel.setRestpay(Integer.parseInt(sheet.getCell(20, i).getContents().trim()));
									cmdSummModel.setInvoice(sheet.getCell(24, i).getContents().trim());
									cmdSummModels.add(cmdSummModel);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count == 0 && !"1".equals(result) && !"2".equals(result) && !"3".equals(result)) {
			result = "4";
		}
		if ("0".equals(result)) {
			if (cmdSummModels != null && !cmdSummModels.isEmpty()) {
				for (CmdSummModel cmdSummModel2 : cmdSummModels) {
					cmdSummService.addCmdSumm(cmdSummModel2);
				}
			}
		} else {
			if ("1".equals(teamtype)) { // 用于区别本班组、劳务班组、专业班组的导入错误输出结果
				result = teamtype + result;
			} else if ("2".equals(teamtype)) {
				result = teamtype + result;
			} else if ("3".equals(teamtype)) {
				result = teamtype + result;
			}
		}
		if ("2".equals(type)) { // 材料商
			return operateReportMaterialList(year, month, projectId, type, result);
		} else { // 设备商
			return operateReportEquipmentList(year, month, projectId, type, result);
		}
	}
	
	/**
	 * 供应商(材料或者设备商)明细表下载EXCEL模板文件
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "operate_reportMEDetailDownloadExcel.html", method = RequestMethod.GET)
	public void operateReportMEDetailDownloadExcel(HttpServletRequest request, HttpServletResponse response) {
		String filePath = Config.getInstance().getRootPath() + "exceltemplate/reportMEDetail.xml";
		DownLoadExcelTemplateUtil.getExcelTemplate(filePath, request, response);
	}
	
	/**
	 * 供应商(材料或者设备商)明细表导入功能
	 * @param cmdId
	 * @param pId
	 * @param tId
	 * @param type
	 * @param teamtype
	 * @param year
	 * @param month
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "operate_reportMEDetailImportExcel.html", method = RequestMethod.POST)
	public ModelAndView operate_reportMEDetailImportExcel(String cmdId, String pId, String tId, String type, String teamtype, String year, String month, HttpServletRequest request, HttpServletResponse response) {
		String result = "0";
		String filePath = request.getSession().getServletContext().getRealPath("\\resource\\execl\\import\\report_medetail") + "\\" + pId;
		String fileName = ImportExcel.createDateExcel(filePath, config, request, response);
		CmdSummSupplierModel cmdSummSupplierModel = null;
		List<CmdSummSupplierModel> cmdSummSupplierModels = new ArrayList<CmdSummSupplierModel>();
		Workbook workbook = null;
		int count = -1;
		String projectName = null;
		String tName = null;
		ProjectModel projectModel = projectService.getById(pId);
		if (projectModel != null) {
			projectName = projectModel.getName();
		}
		if ("2".equals(type)) { // 材料商
			MaterialModel materialModel = materialService.getById(tId);
			if (materialModel != null) {
				tName = materialModel.getName();
			}
		} else { // 设备商
			EquipmentModel equipmentModel = equipmentService.getById(tId);
			if (equipmentModel != null) {
				tName = equipmentModel.getName();
			}
		}
		try {
			workbook = Workbook.getWorkbook(new java.io.File(filePath + "\\" + fileName));
			Sheet sheet = workbook.getSheet(0);
			if (!("供应商(材料或设备商)明细表导入".equals(sheet.getCell(0, 0).getContents().trim()) && "经办人".equals(sheet.getCell(0, 1).getContents().trim()) &&
					"名称或规格或型号".equals(sheet.getCell(1, 1).getContents().trim()) && "支付账号和凭证".equals(sheet.getCell(2, 1).getContents().trim()) &&
					"单位".equals(sheet.getCell(3, 1).getContents().trim()) && "次数".equals(sheet.getCell(4, 1).getContents().trim()) &&
					"预算量".equals(sheet.getCell(5, 1).getContents().trim()) && "数量".equals(sheet.getCell(6, 1).getContents().trim()) &&
					"单价".equals(sheet.getCell(7, 1).getContents().trim()) && "小计".equals(sheet.getCell(8, 1).getContents().trim()) &&
					"预付款".equals(sheet.getCell(9, 1).getContents().trim()) && "本次入库量".equals(sheet.getCell(10, 1).getContents().trim()) &&
					"累计入库量".equals(sheet.getCell(11, 1).getContents().trim()) && "本次付款".equals(sheet.getCell(12, 1).getContents().trim()) &&
					"累计付款".equals(sheet.getCell(13, 1).getContents().trim()) && "其他款".equals(sheet.getCell(14, 1).getContents().trim()) &&
					"余款".equals(sheet.getCell(15, 1).getContents().trim()) && "资料情况".equals(sheet.getCell(16, 1).getContents().trim()) &&
					"发票情况".equals(sheet.getCell(17, 1).getContents().trim()) && "结算情况".equals(sheet.getCell(18, 1).getContents().trim()) &&
					"用途".equals(sheet.getCell(19, 1).getContents().trim()) && "质量".equals(sheet.getCell(20, 1).getContents().trim()) &&
					"备注".equals(sheet.getCell(21, 1).getContents().trim()))) {
				result = "3";
			} else {
				for (int i = 2; i < sheet.getRows(); i++) {
					count++;
					if ("".equals(sheet.getCell(0, i).getContents().trim()) && "".equals(sheet.getCell(1, i).getContents().trim()) && 
							"".equals(sheet.getCell(2, i).getContents().trim()) && "".equals(sheet.getCell(3, i).getContents().trim()) && 
							"".equals(sheet.getCell(4, i).getContents().trim()) && "".equals(sheet.getCell(5, i).getContents().trim()) &&
							"".equals(sheet.getCell(6, i).getContents().trim()) && "".equals(sheet.getCell(7, i).getContents().trim()) &&
							"".equals(sheet.getCell(8, i).getContents().trim()) && "".equals(sheet.getCell(9, i).getContents().trim()) &&
							"".equals(sheet.getCell(10, i).getContents().trim()) && "".equals(sheet.getCell(11, i).getContents().trim()) &&
							"".equals(sheet.getCell(12, i).getContents().trim()) && "".equals(sheet.getCell(13, i).getContents().trim()) &&
							"".equals(sheet.getCell(14, i).getContents().trim()) && "".equals(sheet.getCell(15, i).getContents().trim()) &&
							"".equals(sheet.getCell(16, i).getContents().trim()) && "".equals(sheet.getCell(17, i).getContents().trim()) &&
							"".equals(sheet.getCell(18, i).getContents().trim()) && "".equals(sheet.getCell(19, i).getContents().trim()) &&
							"".equals(sheet.getCell(20, i).getContents().trim()) && "".equals(sheet.getCell(21, i).getContents().trim())) { // 模板外
						break;
					}
					if ("".equals(sheet.getCell(0, i).getContents().trim()) && "".equals(sheet.getCell(1, i).getContents().trim()) && 
							"".equals(sheet.getCell(2, i).getContents().trim()) && "".equals(sheet.getCell(3, i).getContents().trim()) && 
							"0".equals(sheet.getCell(4, i).getContents().trim()) && "0".equals(sheet.getCell(5, i).getContents().trim()) &&
							"0".equals(sheet.getCell(6, i).getContents().trim()) && "0".equals(sheet.getCell(7, i).getContents().trim()) &&
							"0".equals(sheet.getCell(8, i).getContents().trim()) && "0".equals(sheet.getCell(9, i).getContents().trim()) &&
							"0".equals(sheet.getCell(10, i).getContents().trim()) && "0".equals(sheet.getCell(11, i).getContents().trim()) &&
							"0".equals(sheet.getCell(12, i).getContents().trim()) && "0".equals(sheet.getCell(13, i).getContents().trim()) &&
							"0".equals(sheet.getCell(14, i).getContents().trim()) && "0".equals(sheet.getCell(15, i).getContents().trim()) &&
							"".equals(sheet.getCell(16, i).getContents().trim()) && "".equals(sheet.getCell(17, i).getContents().trim()) &&
							"".equals(sheet.getCell(18, i).getContents().trim()) && "".equals(sheet.getCell(19, i).getContents().trim()) &&
							"".equals(sheet.getCell(20, i).getContents().trim()) && "".equals(sheet.getCell(21, i).getContents().trim())) { // 模板内
						break;
					}
					if ("".equals(sheet.getCell(0, i).getContents().trim()) || "".equals(sheet.getCell(1, i).getContents().trim()) || 
							"".equals(sheet.getCell(2, i).getContents().trim()) || "".equals(sheet.getCell(3, i).getContents().trim()) || 
							"".equals(sheet.getCell(4, i).getContents().trim()) || "".equals(sheet.getCell(5, i).getContents().trim()) ||
							"".equals(sheet.getCell(6, i).getContents().trim()) || "".equals(sheet.getCell(7, i).getContents().trim()) ||
							"".equals(sheet.getCell(8, i).getContents().trim()) || "".equals(sheet.getCell(9, i).getContents().trim()) ||
							"".equals(sheet.getCell(10, i).getContents().trim()) || "".equals(sheet.getCell(11, i).getContents().trim()) ||
							"".equals(sheet.getCell(12, i).getContents().trim()) || "".equals(sheet.getCell(13, i).getContents().trim()) ||
							"".equals(sheet.getCell(14, i).getContents().trim()) || "".equals(sheet.getCell(15, i).getContents().trim())) {  //验证数据的完整性
						result = "1";
						break;
					} else {
						cmdSummSupplierModel = new CmdSummSupplierModel();
						cmdSummSupplierModel.setCmdId(cmdId);
						cmdSummSupplierModel.setpId(pId);
						cmdSummSupplierModel.setpName(projectName);
						cmdSummSupplierModel.settId(tId);
						cmdSummSupplierModel.setType(Integer.parseInt(type));
						cmdSummSupplierModel.setTeamtype(Integer.parseInt(teamtype));
						cmdSummSupplierModel.settName(tName);
						cmdSummSupplierModel.setPrincipal(sheet.getCell(0, i).getContents().trim());
						cmdSummSupplierModel.setcName(sheet.getCell(1, i).getContents().trim());
						cmdSummSupplierModel.setAccount(sheet.getCell(2, i).getContents().trim());
						cmdSummSupplierModel.setUnit(sheet.getCell(3, i).getContents().trim());
						cmdSummSupplierModel.setFrequency(Integer.parseInt(sheet.getCell(4, i).getContents().trim()));
						cmdSummSupplierModel.setNum(Integer.parseInt(sheet.getCell(6, i).getContents().trim()));
						cmdSummSupplierModel.setPrice(Integer.parseInt(sheet.getCell(7, i).getContents().trim()));
						cmdSummSupplierModel.setSubtotal(Integer.parseInt(sheet.getCell(8, i).getContents().trim()));
						cmdSummSupplierModel.setThispay(Integer.parseInt(sheet.getCell(12, i).getContents().trim()));
						cmdSummSupplierModel.setCulapay(Integer.parseInt(sheet.getCell(13, i).getContents().trim()));
						cmdSummSupplierModel.setOtherpay(Integer.parseInt(sheet.getCell(14, i).getContents().trim()));
						cmdSummSupplierModel.setRestpay(Integer.parseInt(sheet.getCell(15, i).getContents().trim()));
						cmdSummSupplierModel.setInformation(sheet.getCell(16, i).getContents().trim());
						cmdSummSupplierModel.setInvoice(sheet.getCell(17, i).getContents().trim());
						cmdSummSupplierModel.setSettlement(sheet.getCell(18, i).getContents().trim());
						cmdSummSupplierModel.setUsing(sheet.getCell(19, i).getContents().trim());
						cmdSummSupplierModel.setQuality(sheet.getCell(20, i).getContents().trim());
						cmdSummSupplierModel.setNote(sheet.getCell(21, i).getContents().trim());
						cmdSummSupplierModel.setYear(Integer.parseInt(year));
						cmdSummSupplierModel.setMonth(Integer.parseInt(month));
						cmdSummSupplierModel.setBgpayment(Integer.parseInt(sheet.getCell(9, i).getContents().trim()));
						cmdSummSupplierModel.setBudget(Integer.parseInt(sheet.getCell(5, i).getContents().trim()));
						cmdSummSupplierModel.setReceipt(Integer.parseInt(sheet.getCell(10, i).getContents().trim()));
						cmdSummSupplierModel.setCumulative(Integer.parseInt(sheet.getCell(11, i).getContents().trim()));
						cmdSummSupplierModels.add(cmdSummSupplierModel);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count == 0 && !"1".equals(result)) {
			result = "2";
		}
		if ("0".equals(result)) {
			if (cmdSummSupplierModels != null && !cmdSummSupplierModels.isEmpty()) {
				for (CmdSummSupplierModel cmdSummSupplierModel2 : cmdSummSupplierModels) {
					cmdSummSupplierService.addCmdSummSupplier(cmdSummSupplierModel2);
				}
			}
		}
		return operateReportMEDetailList(pId, cmdId, tId, teamtype, type, year, month, result);
	}
	
	//-------------------------------------------------
	/**
	 * 人工费用（施工班组）汇总表的导出功能[本班组、劳务班组、专业班组]
	 * @param response
	 * @param year
	 * @param month
	 * @param projectId
	 * @param type - 1施工班组、2材料商、3设备商
	 * @param teamtype - 1本班组、2劳务班组、3专业班组
	 */
	private void getTeamRecoredExportExcel(HttpServletResponse response, String year, String month, String projectId, int type, int teamtype) {
		List<CmdSummModel> cmdSummModels = cmdSummService.getByTimeAndTypeAndTeamtype(Integer.parseInt(year), Integer.parseInt(month), projectId, type, teamtype);
		String[] tTitle = {"序号", "名称", "合同价(万)", "预付款(万)", "次数", "单位", "总工程量", "本次工程量", "累计完成%", "本次付款", "累计付款", "已付工资", "未付工资", "结算情况", "备注"};
		String[] dateFiled = { "cmdSummTime" };
		Date ctime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String currentTime = formatter.format(ctime);
		ProjectModel projectModel = projectService.getById(projectId);
		String projectName = null;
		if (projectModel != null) {
			projectName = projectModel.getName();
		}
		String fileName = projectName + year + "年" + month;
		if (teamtype == 1) {
			fileName += "月的主要本班组人工费验工计价汇总表" + currentTime;
		}
		else if (teamtype == 2) {
			fileName += "月的主要劳务班组人工费验工计价汇总表" + currentTime;
		}
		else if (teamtype == 3) {
			fileName += "月的主要专业班组人工费验工计价汇总表" + currentTime;
		}
		String tableName = "cmdSumm";
		int[] needIndex = {100, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 24, 25, 20, 21}; // 这里是根据对应的model中属性相对位置顺序排序的
		if (cmdSummModels != null && !cmdSummModels.isEmpty()) {
			try {
				ExportExcel.recoredExportExcel(response, tableName, tTitle, fileName, needIndex, cmdSummModels, dateFiled);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 材料费用（材料商）汇总表的导出功能
	 * @param response
	 * @param year
	 * @param month
	 * @param projectId
	 * @param type - 1施工班组、2材料商、3设备商
	 * @param teamtype - 1本班组、2劳务班组、3专业班组
	 */
	private void getMERecoredExportExcel(HttpServletResponse response, String year, String month, String projectId, int type, int teamtype) {
		List<CmdSummModel> cmdSummModels = cmdSummService.getByTimeAndTypeAndTeamtype(Integer.parseInt(year), Integer.parseInt(month), projectId, type, teamtype); // 第一个1表示施工班组type，第二个1表示本班组teamType
		String[] tTitle = {"序号", "供应商", "委托/经办人", "支付帐号及凭证", "单位", "次数", "预算量", "数量", "单价", "小计", "预付款", "本次入库量", "累计入库量", "本次付款", "累计付款", "其他款", "余款", "结算情况", "发票情况", "备注"};
		String[] dateFiled = {"cmdSummTime"};
		Date ctime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String currentTime = formatter.format(ctime);
		ProjectModel projectModel = projectService.getById(projectId);
		String projectName = null;
		if (projectModel != null) {
			projectName = projectModel.getName();
		}
		String fileName = projectName + year + "年" + month;
		if (teamtype == 1) {
			fileName += "月的主要本班组材料费验工计价汇总表" + currentTime;
		}
		else if (teamtype == 2) {
			fileName += "月的主要劳务班组材料费验工计价汇总表" + currentTime;
		}
		else if (teamtype == 3) {
			fileName += "月的主要专业班组材料费验工计价汇总表" + currentTime;
		}
		String tableName = "cmdSumm";
		int[] needIndex = {100, 7, 26, 27, 11, 10, 28, 29, 30, 31, 9, 32, 33, 15, 16, 34, 35, 20, 36, 21};
		if (cmdSummModels != null && !cmdSummModels.isEmpty()) {
			try {
				ExportExcel.recoredExportExcel(response, tableName, tTitle, fileName, needIndex, cmdSummModels, dateFiled);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 修改ProjectDepartment中某个记录status的值
	 * @param pdmId
	 * @param projectId
	 * @param status
	 * @return
	 */
	private ModelAndView projectDepartmentAgreeOrReject(String pdmId, String projectId, int status) {
		ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getById(pdmId);
		if (projectDepartmentModel != null) {
			projectDepartmentModel.setStatus(status);
			projectDepartmentService.updateProjectDepartmentStatus(projectDepartmentModel);
		}
		return projectToAuditTeam(projectId);
	}
	
	/**
	 * 修改ProjectDepartment中某一个或者多个记录status的值
	 * @param ids
	 * @param response
	 * @param status
	 */
	private void projectDepartmentAgreeOrRejectAll(String ids, HttpServletResponse response, int status) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int flag = projectDepartmentService.projectDepartmentAll(ids, status);
		out.print(flag);
		out.flush();
		out.close();
	}
	
	/**
	 * 重新创建一个CmdSummModel，因为要累计(这里为施工班组Team)
	 * @param cmdSummModels
	 * @return
	 */
	private CmdSummModel getTeamCmdSummModel(List<CmdSummModel> cmdSummModels) {
		CmdSummModel showCmdSummModel = new CmdSummModel();
		int contractPrice = 0;
		int bgpayment = 0;
		int frequency = 0;
		int total = 0;
		int nowTotal = 0;
		int percentage = 0;
		int thispay = 0;
		int culapay = 0;
		int remain = 0;
		int culPercentage = 0;
		int deposit = 0;
		// 有一定的统一，这里只取第一个，且不需要累计（没有意义）
		String settlement = cmdSummModels.get(0).getSettlement(); 
		String note = cmdSummModels.get(0).getNote();
		String unit = cmdSummModels.get(0).getUnit();
		for (CmdSummModel cmdSummModel : cmdSummModels) {
			contractPrice += cmdSummModel.getContractPrice();
			bgpayment += cmdSummModel.getBgpayment();
			frequency += cmdSummModel.getFrequency();
			total += cmdSummModel.getTotal();
			nowTotal += cmdSummModel.getNowTotal();
			percentage += cmdSummModel.getPercentage();
			thispay += cmdSummModel.getThispay();
			culapay += cmdSummModel.getCulapay();
			remain += cmdSummModel.getRemain();
			culPercentage += cmdSummModel.getCulPercentage();
			deposit += cmdSummModel.getDeposit();
		}
		percentage /= cmdSummModels.size();
		culPercentage /= cmdSummModels.size();
		showCmdSummModel.setContractPrice(contractPrice);
		showCmdSummModel.setBgpayment(bgpayment);
		showCmdSummModel.setFrequency(frequency);
		showCmdSummModel.setTotal(total);
		showCmdSummModel.setNowTotal(nowTotal);
		showCmdSummModel.setPercentage(percentage);
		showCmdSummModel.setThispay(thispay);
		showCmdSummModel.setCulapay(culapay);
		showCmdSummModel.setRemain(remain);
		showCmdSummModel.setCulPercentage(culPercentage);
		showCmdSummModel.setDeposit(deposit);
		showCmdSummModel.setSettlement(settlement);
		showCmdSummModel.setNote(note);
		showCmdSummModel.setUnit(unit);
		return showCmdSummModel;
	}
	
	/**
	 * 重新创建一个CmdSummModel，因为要累计(这里为材料商和设备商)
	 * @param cmdSummModels
	 * @return
	 */
	private CmdSummModel getMECmdSummModel(List<CmdSummModel> cmdSummModels) {
		CmdSummModel showCmdSummModel = new CmdSummModel();
		int frequency = 0;
		int budget = 0;
		int num = 0;
		int price = 0;
		int subtotal = 0;
		int bgpayment = 0;
		int receipt = 0;
		int cumulative = 0;
		int thispay = 0;
		int culapay = 0;
		int otherpay = 0;
		int restpay = 0;
		int contractPrice = 0;
		int total = 0;
		int nowTotal = 0;
		int percentage = 0;
		int remain = 0;
		int culPercentage = 0;
		int deposit = 0;
		// 有一定的统一，这里只取第一个，且不需要累计（没有意义）
		String settlement = cmdSummModels.get(0).getSettlement(); 
		String note = cmdSummModels.get(0).getNote();
		String unit = cmdSummModels.get(0).getUnit();
		for (CmdSummModel cmdSummModel : cmdSummModels) {
			frequency += cmdSummModel.getFrequency();
			budget += cmdSummModel.getBudget();
			num += cmdSummModel.getNum();
			price += cmdSummModel.getPrice();
			subtotal += cmdSummModel.getSubtotal();
			bgpayment += cmdSummModel.getBgpayment();
			receipt += cmdSummModel.getReceipt();
			cumulative += cmdSummModel.getCumulative();
			thispay += cmdSummModel.getThispay();
			culapay += cmdSummModel.getCulapay();
			otherpay += cmdSummModel.getOtherpay();
			restpay += cmdSummModel.getRestpay();
			contractPrice += cmdSummModel.getContractPrice();
			total += cmdSummModel.getTotal();
			nowTotal += cmdSummModel.getNowTotal();
			remain += cmdSummModel.getRemain();
			percentage += cmdSummModel.getPercentage();
			culPercentage += cmdSummModel.getCulPercentage();
			deposit += cmdSummModel.getDeposit();
		}
		percentage /= cmdSummModels.size();
		culPercentage /= cmdSummModels.size();
		showCmdSummModel.setContractPrice(contractPrice);
		showCmdSummModel.setFrequency(frequency);
		showCmdSummModel.setBudget(budget);
		showCmdSummModel.setNum(num);
		showCmdSummModel.setPrice(price);
		showCmdSummModel.setSubtotal(subtotal);
		showCmdSummModel.setBgpayment(bgpayment);
		showCmdSummModel.setReceipt(receipt);
		showCmdSummModel.setCumulative(cumulative);
		showCmdSummModel.setThispay(thispay);
		showCmdSummModel.setCulapay(culapay);
		showCmdSummModel.setOtherpay(otherpay);
		showCmdSummModel.setRestpay(restpay);
		showCmdSummModel.setSettlement(settlement);
		showCmdSummModel.setNote(note);
		showCmdSummModel.setUnit(unit);
		showCmdSummModel.setTotal(total);
		showCmdSummModel.setNowTotal(nowTotal);
		showCmdSummModel.setRemain(remain);
		showCmdSummModel.setPercentage(percentage);
		showCmdSummModel.setCulPercentage(culPercentage);
		showCmdSummModel.setDeposit(deposit);
		return showCmdSummModel;
	}
	
	/**
	 * 分别获取施工班组、材料商、设备商汇总表各自的model
	 */
	private void getCmdSummModels(ModelAndView mav, int year, int month, String projectId, int type, String result) {
		ProjectModel projectModel = projectService.getById(projectId);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		if (type == 1) { // 施工班组
			List<CmdSummModel> benCmdSummModels = cmdSummService.getByTimeAndTypeAndTeamtype(year, month, projectId, type, 1); // 本班组
			if (benCmdSummModels != null && !benCmdSummModels.isEmpty()) {
				mav.addObject("benCmdSummModels", benCmdSummModels);
				CmdSummModel benTotalCmdSummModel = getTeamCmdSummModel(benCmdSummModels);
				if (benTotalCmdSummModel != null) {
					mav.addObject("benTotalCmdSummModel", benTotalCmdSummModel);
				}
			}
			List<CmdSummModel> laoCmdSummModels = cmdSummService.getByTimeAndTypeAndTeamtype(year, month, projectId, type, 2); // 劳务班组
			if (laoCmdSummModels != null && !laoCmdSummModels.isEmpty()) {
				mav.addObject("laoCmdSummModels", laoCmdSummModels);
				CmdSummModel laoTotalCmdSummModel = getTeamCmdSummModel(laoCmdSummModels);
				if (laoTotalCmdSummModel != null) {
					mav.addObject("laoTotalCmdSummModel", laoTotalCmdSummModel);
				}
			}
			List<CmdSummModel> zhuCmdSummModels = cmdSummService.getByTimeAndTypeAndTeamtype(year, month, projectId, type, 3); // 专业班组
			if (zhuCmdSummModels != null && !zhuCmdSummModels.isEmpty()) {
				mav.addObject("zhuCmdSummModels", zhuCmdSummModels);
				CmdSummModel zhuTotalCmdSummModel = getTeamCmdSummModel(zhuCmdSummModels);
				if (zhuTotalCmdSummModel != null) {
					mav.addObject("zhuTotalCmdSummModel", zhuTotalCmdSummModel);
				}
			}
		}
		else { // 材料商或者是设备商
			List<CmdSummModel> benCmdSummModels = cmdSummService.getByTimeAndTypeAndTeamtype(year, month, projectId, type, 1); // 本班组
			if (benCmdSummModels != null && !benCmdSummModels.isEmpty()) {
				mav.addObject("benCmdSummModels", benCmdSummModels);
				CmdSummModel benTotalCmdSummModel = getMECmdSummModel(benCmdSummModels);
				if (benTotalCmdSummModel != null) {
					mav.addObject("benTotalCmdSummModel", benTotalCmdSummModel);
				}
			}
			List<CmdSummModel> laoCmdSummModels = cmdSummService.getByTimeAndTypeAndTeamtype(year, month, projectId, type, 2); // 劳务班组
			if (laoCmdSummModels != null && !laoCmdSummModels.isEmpty()) {
				mav.addObject("laoCmdSummModels", laoCmdSummModels);
				CmdSummModel laoTotalCmdSummModel = getMECmdSummModel(laoCmdSummModels);
				if (laoTotalCmdSummModel != null) {
					mav.addObject("laoTotalCmdSummModel", laoTotalCmdSummModel);
				}
			}
			List<CmdSummModel> zhuCmdSummModels = cmdSummService.getByTimeAndTypeAndTeamtype(year, month, projectId, type, 3); // 专业班组
			if (zhuCmdSummModels != null && !zhuCmdSummModels.isEmpty()) {
				mav.addObject("zhuCmdSummModels", zhuCmdSummModels);
				CmdSummModel zhuTotalCmdSummModel = getMECmdSummModel(zhuCmdSummModels);
				if (zhuTotalCmdSummModel != null) {
					mav.addObject("zhuTotalCmdSummModel", zhuTotalCmdSummModel);
				}
			}
		}
		mav.addObject("year", year);
		mav.addObject("month", month);
		mav.addObject("result", result);
	}
	
	//----------------------------------------------------------------------------------
	
	/**
	 * 项目工人班组进退场-zss
	 * @return
	 */
	@RequestMapping(value="operate_enterandexit.html")
	public ModelAndView enterAndExit( String id){
		//commentsService.addComments(startTime, endTime, projectName, teamName, score1, score2, score3, desc, type, cId)
		ProjectModel projectModel = projectService.getById(id);
		List<CommentsModel> leaderList = commentsService.getEAECommentByUserId(id,2);  //type=2班组
		Map<TeamModel,CommentsModel> leaderMap = commentsService.getLeaderMap(leaderList);
		List<CommentsModel> workerList = commentsService.getEAECommentByUserId(id,1);	//type=1个人
		ModelAndView mav = new ModelAndView("operate/operate_enterandexit");
		mav.addObject("leaderMap", leaderMap);
		mav.addObject("workerList", workerList);
		mav.addObject("id", id);
		mav.addObject("projectModel", projectModel);
		return mav;
	}
	
	/**
	 * 转发到添加进退场-zss
	 * @param userId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="operate_toaddenterandexit.html")
	public ModelAndView toAddEnterAndExit(String userId, int type,HttpSession session,String id){
		//跳转到页面之前，生成一个token令牌并存入session			//----------token---------------
		NoRepeateSubmit.createSession(request);				//----------token---------------
		ModelAndView mav = new ModelAndView("operate/operate_addenterandexit");
//		String pId = (String) session.getAttribute(ESessionKey.ProjectId.key);
		ProjectModel projectModel = projectService.getById(id);
		if (projectModel != null) {
			mav.addObject("projectModel", projectModel);
		}
		//查询出加入本项目的所有班组,返回页面供项目操作员添加
		List<TeamModel> teamList = commentsService.getTeamList(id);
		mav.addObject("userId", userId);
		mav.addObject("type", type);
		mav.addObject("teamList", teamList);
		mav.addObject("id", id);
		return mav;
	}
	
	/**
	 * 异步请求获取班组所有成员，返回到页面加载到选择框中
	 * @param teamModel
	 */
	@RequestMapping(value="getTeamMember.html")
	public void getTeamMember(HttpServletResponse response, String tId){
		System.out.println("tid: "+tId);
		List<TeamMemberModel> memberList = teamService.getMemberListBytId(tId);
		List<UserModel> userList = new ArrayList<UserModel>();
		for (TeamMemberModel teamMemberModel : memberList) {
			UserModel user = userService.getByUserId(teamMemberModel.getUserId());
			userList.add(user);
		}
		PublicMethod.objectToJson(userList, response);
	}
	
	/**
	 * 添加进退场-zss
	 * @param commentsModel
	 * inOrOut == 0--退场   1--进场
	 * @return
	 */
	@RequestMapping(value="operate_addenterandexit.html")
	public String addEnterAndExit(CommentsModel commentsModel, String tId, String userId, String inOrOut,String token,String id){
		//判断是否重复提交
		boolean isRepeat = NoRepeateSubmit.isRepeatSubmit(request,token);//----------token----------
		if(isRepeat){//如果重复提交了，直接返回							//----------token---------------
			return "redirect:operate_enterandexit.html?id="+id;		//-----token--------------------
		}															//----------token---------------
		//非重复提交，清除session中的token,执行添加代码					//----------token---------------
		request.getSession().removeAttribute("token");				//----------token---------------
		int type = commentsModel.getType();
		TeamModel teamModel = teamService.getTeamById(tId);
		commentsModel.setTeamName(teamModel.getName());
		commentsModel.setId(null);
		if(type==2){//班组长
			commentsModel.setcId(teamModel.getId());
			commentsModel.setName(teamModel.getLeaderName());
			this.personInAndOut(commentsModel, tId, inOrOut);
			commentsService.addOneEnterAndExit(commentsModel,inOrOut,id,type);
		}else if(type==1){//个人
			UserModel userModel = userService.getByUserId(userId);
			commentsModel.setcId(userModel.getUserId());
			commentsModel.setName(userModel.getUserName());
			this.personInAndOut(commentsModel, userId, inOrOut);
			commentsService.addOneEnterAndExit(commentsModel,inOrOut,id,type);
		}
		return 	"redirect:operate_enterandexit.html?id="+id;
	}

	/**
	 * 同时将进退场信息添加person表（诚信档案）中
	 * @param commentsModel
	 * @param userId
	 * @param inOrOut
	 */
	private void personInAndOut(CommentsModel commentsModel, String userId, String inOrOut) {
		PersonModel personModel = personService.getByUserId(userId);
		if("1".equals(inOrOut)){
			if(personModel!=null){
				personModel.setEntryTime(commentsModel.getStartTime());
			}
		}else if("0".equals(inOrOut)){
			if(personModel!=null){
				personModel.setEntryTime(commentsModel.getEndTime());
			}
		}
	}
	
	/**
	 * 删除一条进\退场记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deleteOneEAE.html")
	public String deleteOneEAE(String id, String pId){
		commentsService.deleteById(id);
		return 	"redirect:operate_enterandexit.html?id="+pId;
	}
	
	/**
	 * 项目进度（schedule） -zss
	 * 项目进度 分页显示项目以及各个班组进度信息
	 * @param session
	 * @param pageNowT
	 * @param pageSizeT
	 * @param pageNowP
	 * @param pageSizeP
	 * @param printT
	 * @param pringtP
	 * @return
	 */
	@RequestMapping(value="operate_schedule.html")
	public ModelAndView toSchedule(HttpSession session, HttpServletResponse response, String id,
			@RequestParam(value = "pageNowT", defaultValue = "1") int pageNowT,
			@RequestParam(value = "pageSizeT", defaultValue = "10") int pageSizeT,
			@RequestParam(value = "pageNowP", defaultValue = "1") int pageNowP,
			@RequestParam(value = "pageSizeP", defaultValue = "10") int pageSizeP,
			@RequestParam(value = "startDateT", defaultValue = "2010-01-01") String startDateT,	//默认开始时间是2010年01月01日
			@RequestParam(value = "endDateT", defaultValue = "2100-01-01") String endDateT,		//默认结束时间是2100年01月01日
			@RequestParam(value = "startDateP", defaultValue = "2010-01-01") String startDateP,
  			@RequestParam(value = "endDateP", defaultValue = "2100-01-01") String endDateP,
			@RequestParam(value = "printT", defaultValue = "0")String printT,//导出excel请求  默认为0不导出，为1时导出tList,为2时导出pList
			@RequestParam(value = "printP", defaultValue = "0")String printP//当点击 导出是发送“1”到后台来
		){
//		String pId = (String) session.getAttribute(ESessionKey.ProjectId.key);
		System.out.println("id="+id);
		ProjectModel projectModel = projectService.getById(id);//查询出该项目的基本信息
		//添加数据
//		teamScheduleService.addOne(pId,"57ff38c0c5f679bdfdc06eb4","木工班组1","0","单位", 1234.00,123.00,3,1222.00,1230.00,1230.00,4.00,1000,200,400,"已结算",new Date(),"备注");
//		projectProgressService.addOne(pId, "平方面","单位",19873,123,2344,"10%", new Date(),"备注");
		//分页查询出该项目下的所有班组工作任务进度记录列表
		Long dataCountT = teamScheduleService.countTeamSchedule(id, startDateT, endDateT);//统计当前工程下的所有班组进度记录
		Long dataCountP = projectProgressService.countProjectProgress(id, startDateP,endDateP);
		Page pageT = PageHandler.getPage(pageSizeT, pageNowT, dataCountT);
		Page pageP = PageHandler.getPage(pageSizeP, pageNowP, dataCountP);
		List<TeamScheduleModel> tList = teamScheduleService.getByPageAndpId(pageT,id,startDateT,endDateT);
		List<ProjectProgressModel> pList = projectProgressService.getByPageAndpId(pageP,id,startDateP,endDateP);
		//导出excel
		String[] dateFiled = {"storageTime"};//需要转化时间格式的字段名
		if("1".equals(printT)){//tList
			//表头
			String[] tTitle = {"班组名称","班组类型(0劳务1材料2设备)","合同价","预付款","次数","本次付","已付","累计付","未付","总任务量","本次工程量","累计工程量","进度百分比","结算","存档时间","备注","单位"};	
			try {

				ExportExcel.exportExcel(response, tTitle, "班组任务进度表", tList,3,dateFiled);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if("2".equals(printT)){//pList
			String[] pTitle = {"单位工程","单位","总工程量","本周完成","累计完成","进度百分比","下期计划","存档时间","备注"};
			try {
				ExportExcel.exportExcel(response, pTitle, "工程各项进度表", pList,2,dateFiled);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ModelAndView mav = new ModelAndView("operate/operate_schedule");
		mav.addObject("projectModel", projectModel);
		mav.addObject("pList", pList);
		mav.addObject("id", id);
		mav.addObject("tList", tList);
		mav.addObject("pageT", pageT);
		mav.addObject("pageP", pageP);
		mav.addObject("startDateT", startDateT);
		mav.addObject("endDateT", endDateT);
		mav.addObject("startDateP", startDateP);
		mav.addObject("endDateP", endDateP);
		
		return mav;
	}
	
	/**
	 * 转到修改班组任务进度
	 * @param id
	 * @return
	 */
	@RequestMapping(value="operate_toUpdateTeamSchedule.html")
	public ModelAndView toUpdateTeamSchedule(String id){
		//根据id查出该班组的进度信息，然后进行会显到修改页面中。
		TeamScheduleModel teamSchedule = teamScheduleService.getById(id);
		ModelAndView mav = new ModelAndView("operate/operate_updateteamschedule");
		mav.addObject("teamSchedule", teamSchedule);
		return mav;
	}
	
	/**
	 * 修改班组任务进度
	 * @param id
	 * @return
	 */
	@RequestMapping(value="operate_updateTeamSchedule.html")
	public String updateTeamSchedule(TeamScheduleModel teamSchedule){
		//根据id查出该班组的进度信息，然后进行会显到修改页面中。
		teamScheduleService.updateTeamScheduleModel(teamSchedule);
		return "redirect:operate_schedule.html?id="+teamSchedule.getpId();
	}
	
	/**
	 * 转到添加班组任务进度
	 * @param id
	 * @return
	 */
	@RequestMapping(value="operate_toAddTeamSchedule.html")
	public ModelAndView toAddTeamSchedule(String pId){
		
		//跳转到页面之前，生成一个token令牌并存入session			//----------token---------------
		NoRepeateSubmit.createSession(request);				//----------token---------------
		
		//根据pId到Department表中查出加入该项目的班组的list
		int status = 3;//已经加入项目的状态
		List<TeamModel> teamList = teamScheduleService.getTeamList(pId,status);
		
		ModelAndView mav = new ModelAndView("operate/operate_addteamschedule");
		mav.addObject("pId", pId);
		mav.addObject("teamList", teamList);
		return mav;
	}
	
	/**
	 * 添加班组任务进度
	 * @param id
	 * @return
	 */
	@RequestMapping(value="operate_addTeamSchedule.html")
	public String  addTeamSchedule(TeamScheduleModel teamSchedule, String token){
		//判断是否重复提交
		boolean isRepeat = NoRepeateSubmit.isRepeatSubmit(request,token);//----------token---------------
		if(isRepeat){//如果重复提交，直接返回							//----------token---------------
			return "redirect:operate_schedule.html?id="+teamSchedule.getpId();						//----------token---------------
		}																//----------token---------------
		//非重复提交，清除session中的token,执行添加代码					//----------token---------------
		request.getSession().removeAttribute("token");					//----------token---------------
		
		String[] split = teamSchedule.getTeamName().split(",");
		teamSchedule.setTeamName(split[0]);
		teamSchedule.settId(split[1]);
		teamScheduleService.addTeamSchedule(teamSchedule);
		
		return "redirect:operate_schedule.html?id="+teamSchedule.getpId();
	}
	

	/**
	 * 转到修改工程各项进度
	 * @param id
	 * @return
	 */
	@RequestMapping(value="operate_toUpdateProjectProgress.html")
	public ModelAndView toUpdateProjectprogress(String id){
		//根据id查出该班组的进度信息，然后进行会显到修改页面中。
		ProjectProgressModel projectProgress= projectProgressService.getById(id);
		ModelAndView mav = new ModelAndView("operate/operate_updaterpojectprogress");
		mav.addObject("projectProgress", projectProgress);
		return mav;
	}
	
	/**
	 * 修改工程各项进度
	 * @param id
	 * @return
	 */
	@RequestMapping(value="operate_updateProjectProgress.html")
	public String updateProjectprogress(ProjectProgressModel projectProgress){
		//根据id查出该班组的进度信息，然后进行会显到修改页面中。
		projectProgressService.updateProjectProgress(projectProgress);
		return "redirect:operate_schedule.html?id="+projectProgress.getpId();
	}
	
	/**
	 * 转到添加工程各项进度
	 * @param id
	 * @return
	 */
	@RequestMapping(value="operate_toAddProjectProgress.html")
	public ModelAndView toAddProjectProgress(String pId){
		
		//跳转到页面之前，生成一个token令牌并存入session					//----------token---------------
		NoRepeateSubmit.createSession(request);						//----------token---------------
		//根据pId到Department表中查出加入该项目的班组的list
		ModelAndView mav = new ModelAndView("operate/operate_addprojectprogress");
		mav.addObject("pId", pId);
		return mav;
	}
	
	/**
	 * 添加工程各项进度
	 * @param id
	 * @return
	 */
	@RequestMapping(value="operate_addProjectProgress.html")
	public String  addProjectProgress(ProjectProgressModel projectProgress, String token){
		
		//判断是否重复提交
		boolean isRepeat = NoRepeateSubmit.isRepeatSubmit(request,token);//----------token---------
		if(isRepeat){//如果重复提交了，直接返回							//----------token---------------
			return "redirect:operate_schedule.html?id="+projectProgress.getpId(); //---------token--
		}															//----------token---------------
		//非重复提交，清除session中的token,执行添加代码					//----------token---------------
		request.getSession().removeAttribute("token");				//----------token---------------
		projectProgressService.add(projectProgress);
		return "redirect:operate_schedule.html?id="+projectProgress.getpId();
	}
	
	/**
	 * 项目操作员——合同管理
	 * @author zss
	 * @return
	 */
	@RequestMapping(value="operate_compact.html")
	public ModelAndView operateCompact(String id){
		ModelAndView mav = new ModelAndView("operate/operate_compact");
		/*OperateCompactModel compactModel = new OperateCompactModel();//添加一条数据
		compactModel.setpId(id);
		compactModel.setAmount(500);
		compactModel.setAttachment("附件url");
		compactModel.setCompactBrief("合同概要");
		compactModel.setCompactName("合同名称");
		compactModel.setCompactNum("合同编号");
		compactModel.setCompactType("1-材料 2-用工 3-设备租赁 4-设备采购");
		compactModel.setCompany("建设单位");
		compactModel.setProjectName("工程名称");
		compactModel.setSignDate(new Date());
		compactModel.setSupplier("供应商");
		compactModel.setExcute("正在执行");
		compactModel.setRemark("备注");
		compactModel.setInvoice("发票");
		
		operateCompactService.add(compactModel);*/
		
		List<OperateCompactModel> compactList = operateCompactService.getCompactByPId(id);
		mav.addObject("compactList", compactList);
		ProjectModel projectModel = projectService.getById(id);//查询出该项目的基本信息
		mav.addObject("projectModel", projectModel);
		return mav;
	}

	/**
	 * 跳转到添加项目合同  zss
	 * @param id 
	 * @return
	 */
	@RequestMapping(value="operate_toAddCompact.html")
	public ModelAndView toAddOperateCompact(String id, String compactType){
		ModelAndView mav = new ModelAndView("operate/operate_addcompact");
		//跳转到页面之前，生成一个token令牌并存入session					//----------token---------------
		NoRepeateSubmit.createSession(request);						//----------token---------------
		ProjectModel projectModel = projectService.getById(id);//查询出该项目的基本信息
		mav.addObject("projectModel", projectModel);
		return mav;
	}
	
	/**
	 * 添加项目合同 zss
	 * @param projectId
	 * @param operateCompactModel
	 * @return
	 */
	@RequestMapping(value="operate_addCompact.html")
	public String addOperateCompact(String token, String signDate0, OperateCompactModel operateCompactModel){
		//判断是否重复提交
		boolean isRepeat = NoRepeateSubmit.isRepeatSubmit(request,token);//----------token---------------
		if(isRepeat){//如果重复提交了，直接返回								//----------token---------------
			return "redirect:operate_compact.html?id="+operateCompactModel.getpId();	
		}															
		//非重复提交，清除session中的token,执行添加代码				
		request.getSession().removeAttribute("token");	
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(StringUtils.isNotBlank(signDate0)){
				operateCompactModel.setSignDate(sdf.parse(signDate0));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		operateCompactService.add(operateCompactModel);
		return "redirect:operate_compact.html?id="+operateCompactModel.getpId();
	}
	
	/**
	 * 更新合同-zss
	 * @param id
	 * @param pId
	 * @return
	 */
	@RequestMapping(value="operate_editeCompact.html")
	public ModelAndView editeOperateCompact(String id, String pId){
		ModelAndView mav = new ModelAndView("operate/operate_editecompact");
		//查询出指定id的model
		OperateCompactModel compact = operateCompactService.getCompactById(id);
		mav.addObject("compact", compact);
		mav.addObject("pId", pId);
		return mav;
	}
	
	/**
	 * 执行更新-zss
	 * @param compact
	 * @param signDate0
	 * @return
	 */
	@RequestMapping(value="operate_updateCompact.html")
	public String editeOperateCompact(OperateCompactModel compact,String signDate0){
		if(StringUtils.isNotBlank(signDate0)){
			compact.setSignDate(DateStringUtils.parseYMD(signDate0));
		}else {
			OperateCompactModel compactModel = operateCompactService.getCompactById(compact.getId());
			compact.setSignDate(compactModel.getSignDate());
		}
		operateCompactService.upgrateOperateCompact(compact);
		return "redirect:operate_compact.html?id="+compact.getpId();
	}
	
	 /**
	  * 上传合同图片-zss
	  * @param response
	  * @return
	  */
	@RequestMapping(value="operate_uploadCompact.html")
	public String uploadCompact(HttpServletResponse response,String pId, String id){
		
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
			String attachment = currentTime + "." + fileExt.toLowerCase();
			String filePath = IMageUploadInfo.BASEPATH.value + IMageUploadInfo.OPERATECOMPACT.value + pId;
			new ImageUpload().imageUpload(file, attachment, filePath, config, request, response);
			//查询出指定id的model
			OperateCompactModel compactModel = operateCompactService.getCompactById(id);
			compactModel.setAttachment(attachment);//设置附件合同图片名称
			operateCompactService.upgrateOperateCompact(compactModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:operate_compact.html?id="+pId;
	}
	
	/**
	 * 消息公告列表页面
	 * @param isRead
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "operate_notice.html")
	public ModelAndView operateNotice(String isRead, String userId) {
		ModelAndView mav = new ModelAndView("operate/operate_notice");
		Map<String, Object> map = noticeService.getShowNoticeHasMap(isRead, mav, userId, UserType.OperateType.desc, null);
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
	 * @param oId
	 * @return
	 */
	@RequestMapping(value = "operate_noticeInfo.html", method = RequestMethod.POST)
	public void operateNoticeInfo(String nId, String pId, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<JSONObject> jsonObjects = noticeService.getNoticeInfo(nId, pId, UserType.OperateType.desc, null);
		out.print(jsonObjects);
		out.flush();
		out.close();
	}
	
	/**
	 * 一对一消息列表页面
	 * @param isRead
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "operate_message.html")
	public ModelAndView operateMessage(String isRead, String userId) {
		ModelAndView mav = new ModelAndView("operate/operate_message");
		Map<String, Object> map = messageService.getShowMessageHasMap(isRead, mav, userId, UserType.OperateType.desc, null);  
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
	@RequestMapping(value = "operate_messageIsRead.html", method = RequestMethod.POST)
	public void operateMessageIsRead(String messageId, HttpServletResponse response) {
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
	
}

