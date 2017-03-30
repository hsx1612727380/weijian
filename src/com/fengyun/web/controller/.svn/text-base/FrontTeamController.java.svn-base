package com.fengyun.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.bson.types.ObjectId;
import org.omg.PortableInterceptor.ForwardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.cache.page.PageHandler;
import com.fengyun.web.db.playermodel.CompanyModel;
import com.fengyun.web.db.playermodel.PersonModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.RequirementsModel;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.hardcode.ESessionKey;
import com.fengyun.web.service.CompanyService;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.RequirementsService;
import com.fengyun.web.service.TeamMemberService;
import com.fengyun.web.service.TeamService;
import com.fengyun.web.service.UserService;
import com.fengyun.web.util.NoRepeateSubmit;
import com.fengyun.web.util.PublicMethod;
import com.fengyun.web.util.TokenProccessor;
import com.mongodb.BasicDBObject;

@Controller
public class FrontTeamController {
	@Autowired
	private TeamService teamService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private TeamMemberService teamMemberService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectDepartmentService projectDepartmentService;
	@Autowired
	private RequirementsService requirementsService;
	@Autowired
	private PersonService personService;
	@Autowired
	private CompanyService companyService;

	/**
	 * 申请加入本班组的个人
	 * 
	 * @author rkai
	 * @return
	 */
	@RequestMapping(value = "applyTeamPersonForm.html")
	public ModelAndView applyTeamPersonForm(@RequestParam(value = "pageNow", defaultValue = "1") int pageNow,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize, @RequestParam(value = "dataCount", defaultValue = "0") int dataCount,
			@RequestParam(value = "pageCount", defaultValue = "0") int pageCount) {
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		TeamModel teamModel = teamService.getTeamModelByUserId(userId);
		String trd = teamModel.getId();
		List<TeamMemberModel> teamMemberList = teamMemberService.getTeamMemberByTrd(trd, 1, pageSize, pageNow);
		List<Map<String, Object>> tlist = new ArrayList<Map<String, Object>>();
		for (TeamMemberModel tt : teamMemberList) {
			Map<String, Object> map = new HashMap<String, Object>();
			UserModel umodel = userService.getByUserId(tt.getUserId());
			map.put("tmodel", umodel);
			map.put("temMemId", tt.getId());
			tlist.add(map);
		}
		ModelAndView mav = new ModelAndView("front_person/team_personApply");
		mav.addObject("tlist", tlist);
		if (dataCount == 0) {
			dataCount = teamMemberService.countMember(trd, 1);
		}
		if (dataCount % pageSize == 0)
			pageCount = dataCount / pageSize;
		else
			pageCount = dataCount / pageSize + 1;
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		page.setPageCount(pageCount);
		mav.addObject("page", page);
		return mav;
	}

	/**
	 * 同意个人加入班组
	 */
	@RequestMapping(value = "passPersonApply.html")
	public void passPersonApply(String teamMemberID, HttpServletResponse resp) throws IOException {
		System.out.println("------------------------teamMemberId:" + teamMemberID);
		TeamMemberModel model = teamMemberService.getById(teamMemberID);
		model.setStatus(3);
		teamMemberService.updateStatus(model);
	}

	/** 邀请加入的工人 */
	@RequestMapping(value = "TeamInvitePersonForm.html")
	public ModelAndView TeamInvitePersonForm(@RequestParam(value = "pageNow", defaultValue = "1") int pageNow,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize, @RequestParam(value = "dataCount", defaultValue = "0") int dataCount,
			@RequestParam(value = "pageCount", defaultValue = "0") int pageCount) throws IOException {
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		String tId = teamService.getTeamModelByUserId(userId).getId();
		List<TeamMemberModel> teamMemberList = teamMemberService.getTeamMemberByTrd(tId, 2, pageSize, pageNow);
		List<Map<String, Object>> tlist = new ArrayList<Map<String, Object>>();
		for (TeamMemberModel tt : teamMemberList) {
			Map<String, Object> map = new HashMap<String, Object>();
			UserModel umodel = userService.getByUserId(tt.getUserId());
			String temMemId = tt.getId();
			map.put("temMemId", temMemId);
			map.put("tmodel", umodel);
			tlist.add(map);
		}
		ModelAndView mav = new ModelAndView("front_person/team_invitePerson");
		if (dataCount == 0) {
			dataCount = teamMemberService.countMember(tId, 2);
		}
		if (dataCount % pageSize == 0)
			pageCount = dataCount / pageSize;
		else
			pageCount = dataCount / pageSize + 1;
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		page.setPageCount(pageCount);
		mav.addObject("tlist", tlist);
		mav.addObject("page", page);
		return mav;
	}

	/**
	 * 拒绝个人加入、撤销邀请 rkai
	 * 
	 * @param teamMemberId
	 * @throws IOException
	 */
	@RequestMapping(value = "rejectPersonApply.html")
	public void rejectInvite(String teamMemberId, HttpServletResponse response) throws IOException {
		teamService.rejectInvite(teamMemberId);
	}

	/**
	 * 同意加入项目
	 */
	@RequestMapping(value = "passProjectInveite.html")
	public void passProjectInvite(String proDepId, HttpServletResponse response) throws IOException {
		ProjectDepartmentModel model = projectDepartmentService.getById(proDepId);
		model.setStatus(3);
		projectDepartmentService.updateProjectDepartmentStatus(model);
	}

	/**
	 * 拒绝项目的邀请 rkai
	 * 
	 * @param teamMemberId
	 * @throws IOException
	 */
	@RequestMapping(value = "rejectProjectInvite.html")
	public void rejectProjectInvite(String proDepId, HttpServletResponse response) throws IOException {
		projectDepartmentService.deleteById(proDepId);
		PublicMethod.stringToWeb("拒绝成功", response);
	}

	/**
	 * 邀请我加入的项目
	 * 
	 * @author rkai
	 * @return
	 */
	@RequestMapping(value = "inviteTeamProjectForm.html")
	public ModelAndView inviteTeamProjectForm(@RequestParam(value = "pageNow", defaultValue = "1") int pageNow,
			@RequestParam(value = "pageSize", defaultValue = "2") int pageSize, @RequestParam(value = "dataCount", defaultValue = "0") int dataCount,
			@RequestParam(value = "pageCount", defaultValue = "0") int pageCount) {
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		TeamModel teamModel = teamService.getTeamModelByUserId(userId);
		String trd = teamModel.getId();
		List<ProjectDepartmentModel> departList = projectDepartmentService.getProjectDepartment(trd, 2, pageSize, pageNow);
		List<Map<String, Object>> projectList = new ArrayList<Map<String, Object>>();
		for (ProjectDepartmentModel tModel : departList) {
			Map<String, Object> map = new HashMap<String, Object>();
			ProjectModel pModel = projectService.getById(tModel.getpId());
			map.put("pModel", pModel);
			map.put("proDepId", tModel.getId());
			projectList.add(map);
		}
		ModelAndView mav = new ModelAndView("front_person/team_inviteProject");
		mav.addObject("tlist", projectList);
		if (dataCount == 0) {
			dataCount = projectDepartmentService.countMember(trd, 1);
		}
		if (dataCount % pageSize == 0)
			pageCount = dataCount / pageSize;
		else
			pageCount = dataCount / pageSize + 1;
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		page.setPageCount(pageCount);
		mav.addObject("page", page);
		return mav;
	}

	/**
	 * 跳转到申请页面
	 * 
	 * @author rkai mayu
	 * @return
	 */
	@RequestMapping(value = "recruitTeamProjectForm.html")
	public ModelAndView personApplyTeamForm(@RequestParam(value = "pageNow", defaultValue = "1") int pageNow,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize, 
			@RequestParam(value = "dataCount", defaultValue = "0") int dataCount,
			@RequestParam(value = "pageCount", defaultValue = "0") int pageCount, 
			String pName, 
			@RequestParam(value = "skillBigType", defaultValue = "0")int skillBigType, 
			@RequestParam(value = "skillSmallType", defaultValue = "0")int skillSmallType) {
		String userId = (String) request.getSession().getAttribute(ESessionKey.UserId.key);
		ModelAndView mav = new ModelAndView("/front_person/team_applyProject");
		// 查询需求表，tyep=2,userType=2,status=1
		if (StringUtils.isNotBlank(pName)) {
			try {
				pName = new String(pName.getBytes("iso8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		BasicDBObject obj = new BasicDBObject(4);
		obj.put("type", 2);
		obj.put("status", 1);
		obj.put("userType", 3);
		obj.put("teamType", 1);
		if (StringUtils.isNotBlank(pName)) {
			ProjectModel projectModel = projectService.getByName(pName);
			if(projectModel!=null){
				obj.put("rId", projectModel.getId());
			}
		}
		if (0!=skillBigType) {
			obj.put("skillBigType", skillBigType);
		}
		if (0!=skillSmallType) {
			obj.put("skillSmallType", skillSmallType);
		}
		if (dataCount == 0) {
			dataCount = (int) requirementsService.countAll(obj);
		}
		List<RequirementsModel> requiList = requirementsService.getList(obj, pageNow, pageSize);
		List<Map<String, Object>> tlist = new ArrayList<Map<String, Object>>();
		for (RequirementsModel requireModel : requiList) {
			Map<String, Object> map = new HashMap<String, Object>();
			String projectId = requireModel.getrId();
			ProjectModel projectModel = projectService.getById(projectId);
			String vId = teamService.getTeamModelByUserId(userId).getId();
			// String vId=teamMemberService.getByUserId(userId).getId();
			ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getModelByTIdAndUserId(vId, projectId);
			int status = 0;
			if (projectDepartmentModel != null) {
				status = projectDepartmentModel.getStatus();
			}
			map.put("projectModel", projectModel);
			map.put("status", status);
			map.put("requireModel", requireModel);
			tlist.add(map);
		}
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		pageCount = (dataCount % pageSize == 0) ? (dataCount / pageSize) : (dataCount / pageSize + 1);
		page.setPageCount(pageCount);
		mav.addObject("page", page);
		mav.addObject("tlist", tlist);
		// 回显查询条件数据
		mav.addObject("pName", pName);
		mav.addObject("skillBigType", skillBigType);
		mav.addObject("skillSmallType", skillSmallType);
		return mav;
	}

	/**
	 * 申请加入项目 vId邀请的id，pId 项目id
	 * 
	 * @param id
	 *            ：项目id userId班长id
	 */
	@RequestMapping(value = "teamApplyProject.html")
	public String teamApplyProject(String pId, String userId, HttpServletResponse response) {

		// String vId=teamMemberService.getByUserId(userId).getId();
		// String vId=teamMemberService.getByUserId(userId).getId();
		String vId = teamService.getTeamByLeaderMobile(userId).getId();
		System.out.println(projectService.getById(pId).getName());
		ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getModelByTIdAndUserId(vId, pId);// vId邀请的id，pId
																													// 项目id
		if (projectDepartmentModel == null) {
			ProjectDepartmentModel model1 = new ProjectDepartmentModel();
			model1.setpId(pId);
			model1.setvId(vId);
			model1.setType(1);
			model1.setStatus(1);
			projectDepartmentService.addProjectDepartment(model1);
		}
		return null;
	}

	/**
	 * 跳转到创建班组 -zss 判断如果该用户不是班组长，不在任何班组中，就可以创建班组 否则返回msg 提示信息: "你是班组长" 或
	 * " 你已经是班组成员"
	 * 
	 * @param session
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "createTeam.html")
	public ModelAndView toCreateTeam() {
		// 1、个人用户 （判断非班组成员）可以创建 班组（不在teammember表中）
		// 这里的userId实际上作为班组长的leaderMobile字段查询
		// 对班组成员,isleader=2 前台已经隐藏了这个功能选项，如果隐藏失败通过msg非空到前台控制更新按钮隐藏。
		String userId = (String) request.getSession().getAttribute("userId");
		TeamMemberModel teamMember = teamMemberService.userIdExistInTeam(userId, null, 3);// 查询是否已经加入到班组中。
		ModelAndView mav = null;
		if (teamMember == null) {
			mav = new ModelAndView("/front_person/person_createteam");
		} else {
			mav = new ModelAndView(new RedirectView("person.html"));
			// mav.addObject("msg", "目前一个人只能创建或加入一个班组");//在只转发视图的情况下可能不能带对象到页面。
		}
		return mav;
	}

	/**
	 * ajax检查班组名称是否被占用，是返回“1”，否返回“0”
	 */
	@RequestMapping(value = "checkTeamName.html")
	public void checkTeamName(HttpServletResponse response, String name) {
		String name1 = null;
		try {
			name1 = new String(name.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		TeamModel teamModel = teamService.getTeamByName(name1);
		if (teamModel != null) {
			PublicMethod.stringToWeb("1", response);
		} else {
			PublicMethod.stringToWeb("0", response);
		}
	}

	/**
	 * 保存创建的班组 -zss 否则返回msg 提示信息: "您是班组长" 或 " 您已经是班组成员"
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "saveCreatedTeam.html")
	public String saveCreatedTeam(HttpSession session, TeamModel teamModel) {
		System.out.println("teamModel.name：" + teamModel.getName());
		// 2、在team中加入已创建班组的信息（填写team表的班组信息）
		String userId = String.valueOf(session.getAttribute("userId"));
		TeamMemberModel teamMember = teamMemberService.userIdExistInTeam(userId, null, 3);// 查询是否已经加入到班组中。
		if (teamMember != null) {
			session.setAttribute(ESessionKey.IsLeader.key, "2");
			return "redirect:person.html";
		}
		teamModel.setScore(60);
		teamModel.setStatus(0);
		teamModel.setCreateTime(new Date());
		// 3、在teamMember中加入已创建班组的班组长（班组成员）信息 status设置为3 已加入班组。
		teamService.addOneTeam(teamModel);
		TeamModel team = teamService.getTeamByLeaderMobile(userId);
		// 4、填写诚信档案基本信息
		personService.insert(team);// 初始化创建班组诚信档案
		// 5、完成以后让session失效，跳转到登录界面。提示重新登录。
		session.setAttribute(ESessionKey.UserId.key, userId);
		session.setAttribute(ESessionKey.UserType.key, "0");
		session.setAttribute(ESessionKey.IsLeader.key, "1");
		session.setAttribute(ESessionKey.TeamCode.key, team.getCode());
		return "redirect:person.html";
	}

	/**
	 * 班组长邀请成员 -zss
	 * 
	 * @return
	 */
	@RequestMapping(value = "invitePerson.html")
	public ModelAndView invitePerson(HttpSession session, String userId, String userProvince,
			@RequestParam(value = "reliableStar", defaultValue = "0") int reliableStar, @RequestParam(value = "pageNow", defaultValue = "1") int pageNow,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		// 获取班组长的userId
		String teamUserId = String.valueOf(session.getAttribute("userId"));
		TeamModel tModel = teamService.getTeamByLeaderMobile(teamUserId);
		if (tModel == null)
			return null;
		// 分页显示： 先查到userModel数量count 参数： String userId, String
		// userProvince,userType=0
		Page page = getPage(userId, userProvince, reliableStar, pageNow, pageSize);
		// 根据skillbigtype和skillsmalltype查userModel表 得到一个List<UserModel>
		String userStatus = "1";// 对应user Model中的找工作状态
		List<UserModel> userList = userService.getUserListByConditions(session, userId, userProvince, userStatus, reliableStar, "0", page.getPageNow(),
				page.getPageSize());
		// 去除班组长自身
		/*
		 * Iterator<UserModel> iterator = userList.iterator();
		 * while(iterator.hasNext()) { UserModel userModel = iterator.next();
		 * if(teamUserId.equals(userModel.getUserId())){
		 * iterator.remove();//使用这个方法可以避免concurrent...Exception......
		 * //userList.remove(userModel);
		 * page.setDataCount(page.getDataCount()-1); } }
		 */
		// page.setDataCount(userList.size());
		ModelAndView mav = new ModelAndView("front_person/leader_inviteworker");
		mav.addObject("page", page);
		mav.addObject("userList", userList);
		return mav;
	}

	public Page getPage(String userId, String userProvince, int reliableStar, int pageNow, int pageSize) {
		String userStatus = "1";// 对应user Model中的找工作状态
		long dataCount = userService.countUserByConditions(userId, userProvince, userStatus, reliableStar, "0");
		// 获取分页类：page
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		return page;
	}

	/**
	 * 邀请工人 在teamMember表中添加所邀请（userId）用户的信息。 String tId;// 对应teammodel的id String
	 * userId;// 用户ID Date createTime = new Date(); int status;// 1-申请中 2-邀请中
	 * 3-已加入 4 -已结束或离开 int backbone; //是否是骨干班组成员 ：0-不是，1-是
	 * 
	 * @param session
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "invite.html")
	public void inviteWorker(HttpSession session, HttpServletResponse response, HttpServletRequest request, String userId) {
		// 获取班组长的userId
		String teamUserId = String.valueOf(session.getAttribute("userId"));
		// 邀请工人
		String msg = teamMemberService.inviteWorker(userId, teamUserId, request);
		// 邀请完回到原页面 等待班组长邀请下一个工人（页面不跳转）
		// mav = new ModelAndView("redirect:invitePerson.html");
		// mav = new ModelAndView("forward:invitePerson.html");
		// return mav ;//"forward:invitePerson.html";
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.write(msg);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 班组对项目求职 -zss 跳转到对项目 发布求职页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "teamApplyForProject.html")
	public ModelAndView applyProject(HttpSession session, @RequestParam(value = "pageNow", defaultValue = "1") int pageNow,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		System.out.println("班组对项目求职 -方法");
		String userId = (String) session.getAttribute("userId");
		// 查询出班组的model（地址要显示出来）
		TeamModel teamModel = teamService.getTeamByLeaderMobile(userId);
		// 分页查询出已【本班组】发过的求职信息 type=1(1-求职 2-招聘) userType =2 1-个人 2-班组
		// 3-项目,teamType=1; 1-施工班组 2-材料班组 3-设备班组 ; status = 1; 状态 0表示关闭
		int type = 1, userType = 2, teamType = 1, status = 1;
		Map<Page, List<RequirementsModel>> requirementListMap = requirementsService.getRequirement(pageSize, pageNow, type, userType, teamType, status,
				teamModel.getId());
		Set<Page> pageSet = requirementListMap.keySet();
		Page page = pageSet.iterator().next();
		List<RequirementsModel> requirementList = requirementListMap.get(page);

		ModelAndView mav = new ModelAndView("front_person/team_applyforproject");

		mav.addObject("requirementList", requirementList);
		mav.addObject("page", page);
		mav.addObject("teamModel", teamModel);
		return mav;
	}

	/**
	 * 跳转到新增求职页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toApplyAdd.html")
	public ModelAndView toApplyAdd(HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		// 查询出班组的model（地址要显示出来）
		TeamModel teamModel = teamService.getTeamByLeaderMobile(userId);
		PersonModel personModel = personService.getByUserId(userId);

		// 跳转到添加页面之前 生成一个token令牌并存入session
		NoRepeateSubmit.createSession(request); // ----------token---------------

		ModelAndView mav = new ModelAndView("front_person/team_applyadd");
		mav.addObject("teamModel", teamModel);
		mav.addObject("personModel", personModel);
		return mav;
	}

	/**
	 * 提交求职申请
	 * 
	 * @param session
	 * @param requireModel
	 * @return
	 */
	@RequestMapping(value = "applyforproject.html")
	public String saveApply(HttpSession session, RequirementsModel requireModel, String token) {
		System.out.println("提交求职申请");
		// 判断是否重复提交
		boolean isRepeat = NoRepeateSubmit.isRepeatSubmit(request, token);// ----------token---------------
		if (isRepeat) {// 如果重复提交了，直接返回 //----------token---------------
			return "forward:teamApplyForProject.html"; // ----------token---------------
		} // ----------token---------------
		// 非重复提交，清除session中的token,执行添加代码 //----------token---------------
		request.getSession().removeAttribute("token"); // ----------token---------------

		// 提交对项目的求职申请
		requirementsService.saveApply(session, requireModel);
		return "redirect:teamApplyForProject.html";
	}

	/**
	 * 删除 已发布的【对项目】求职信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteApplyNote.html")
	public String deleteApplyNote(String id) {
		requirementsService.delById(id);
		return "redirect:teamApplyForProject.html";
	}

	/**
	 * 招聘项目详情 rkai
	 * 
	 * @return
	 */
	@RequestMapping(value = "team_projectInfo.html")
	public ModelAndView team_projectInfo() {
		String projectId = request.getParameter("projectId");
		String requireId = request.getParameter("requireId");
		RequirementsModel requireModel = requirementsService.getById(requireId);
		// String desc=requireModel.getDesc();
		ProjectModel projectModel = projectService.getById(projectId);
		CompanyModel companyModel = companyService.getByCode(projectModel.getCode());
		ModelAndView mav = new ModelAndView("front_person/team_projectInfo");
		mav.addObject("projectModel", projectModel);
		mav.addObject("requireModel", requireModel);
		mav.addObject("companyModel", companyModel);
		return mav;
	}

	// TODO 班组招聘工人
	/**
	 * 班组长发布招聘工人 -zss
	 * 
	 * @return
	 */
	@RequestMapping(value = "personRecruit.html")
	public ModelAndView teamRecruitWroker(HttpSession session) {
		// 到RequirementsModel表中通过班组id（rId）、信息类型int 2（招聘）、招聘状态int
		// 1（开放）查询已经发布的招聘信息
		List<RequirementsModel> requirementsList = userService.getTeamRecruiteList(session);
		String userId = (String) session.getAttribute("userId");
		// 查询出班组的model（地址要显示出来）
		TeamModel teamModel = teamService.getTeamByLeaderMobile(userId);
		ModelAndView mav = new ModelAndView("front_person/team_recruit");
		mav.addObject("requirementsList", requirementsList);
		mav.addObject("teamModel", teamModel);

		return mav;
	}

	/**
	 * 跳转到班组发布招聘页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "personToAddRecruit.html")
	public ModelAndView toAddTeamRecruit(HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		// 查询出班组的model（地址要显示出来）
		TeamModel teamModel = teamService.getTeamByLeaderMobile(userId);

		// 跳转到添加页面之前 生成一个token令牌并存入session
		NoRepeateSubmit.createSession(request); // ----------token---------------

		// 跳转到添加页面
		ModelAndView mav = new ModelAndView("front_person/team_addrecruit");
		mav.addObject("teamModel", teamModel);
		return mav;
	}

	/**
	 * 班组发布招聘
	 * 
	 * @return
	 */
	@RequestMapping(value = "personAddRecruit.html")
	public String addTeamRecruit(RequirementsModel requirement, String num, String token) {
		requirement.setNum(Integer.parseInt(num));
		// 判断是否重复提交
		boolean isRepeat = NoRepeateSubmit.isRepeatSubmit(request, token);// ----------token---------------
		if (isRepeat) {// 如果重复提交了，直接返回 //----------token---------------
			return "forward:personRecruit.html"; // ----------token---------------
		}
		// 非重复提交，清除session中的token,执行添加代码
		request.getSession().removeAttribute("token"); // ----------token---------------

		requirement.setCreateTime(new Date());
		userService.addRequirement(requirement);
		return "redirect:personRecruit.html";
	}

	/**
	 * 删除一条招聘信息(逻辑删除)
	 * 
	 * @return
	 */
	@RequestMapping(value = "personDeleteRecruit.html")
	public String deleteTeamRecruit(@RequestParam(value = "id") String id) {
		userService.deleteById(id);

		return "forward:personRecruit.html";
	}

}