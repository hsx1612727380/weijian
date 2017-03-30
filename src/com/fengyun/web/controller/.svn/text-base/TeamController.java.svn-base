package com.fengyun.web.controller;


import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.cache.page.PageHandler;
import com.fengyun.web.db.playermodel.CommentsModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.db.vo.SkillVo;
import com.fengyun.web.hardcode.ETeamSkillSmallType;
import com.fengyun.web.service.CommentsService;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.TeamMemberService;
import com.fengyun.web.service.TeamService;
import com.fengyun.web.service.UserService;
import com.fengyun.web.util.PublicMethod;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;

@Controller
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	
	@Autowired
	private TeamMemberService teamMemberService;
	
	@Autowired
	private PersonService personService;
	
	
	@Autowired
	private UserService userService;

	@Autowired
	private CommentsService commentsService;
	@Autowired
	private ProjectDepartmentService projectdepartmentService;


	@Autowired
	private HttpServletRequest request;

	/**
	 * 班组列表
	 * 
	 * @param pagesize
	 *            第几页
	 * @return
	 */
	@RequestMapping(value = "team_list", method = RequestMethod.GET)
	public ModelAndView teamlist(int pageNow, long dataCount, int pageSize) {
		ModelAndView mav = new ModelAndView("/team/team_list");
		if (dataCount == 0) {
			dataCount = teamService.countAllTeam(null);
		}
		mav.addObject("tlist", teamService.getTeamList(null, pageNow, pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
//		teamService.inviteTeamMember("58082c8be4b003c5492d8715", "13648032295",1);
//		teamService.inviteTeamMember("58082c8be4b003c5492d8715", "13548092235",1);
//		
//		
//		teamService.inviteTeamMember("580f327fe4b06307f5671037", "13829254840",1);
		return mav;

	}

	@RequestMapping(value = "team_list2", method = RequestMethod.POST)
	public ModelAndView teamlist2() {
		return toList();
	}

	/**
	 * 返回查询列表
	 * 
	 * @return
	 */
	private ModelAndView toList() {
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String leaderName = request.getParameter("leaderName");
		String leaderMobile = request.getParameter("leaderMobile");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		ModelAndView mav = new ModelAndView("/team/team_list");
		// String dataCountStr = request.getParameter("dataCount");
		long dataCount = 0;

		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(name)) {
			queryObj.put("name", name);
		}
		if (StringUtils.isNotBlank(code)) {
			queryObj.put("code", code);
		}
		if (StringUtils.isNotBlank(leaderName)) {
			queryObj.put("leaderName", leaderName);
		}
		if (StringUtils.isNotBlank(leaderMobile)) {
			queryObj.put("leaderMobile", leaderMobile);
		}
		if (StringUtils.isNotBlank(province)) {
			queryObj.put("province", province);
		}
		if (StringUtils.isNotBlank(city)) {
			queryObj.put("city", city);
		}
		if (queryObj.size() <= 0)
			queryObj = null;

		// if(dataCountStr == null || "".equals(dataCountStr)){
		dataCount = teamService.countAllTeam(queryObj);
		// }else{
		// dataCount = Integer.valueOf(dataCountStr);
		// }
		String pageNowStr = request.getParameter("pageNow");
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 0;
		int pageNow = 0;
		if (StringUtils.isNotBlank(pageSizeStr)) {
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if (StringUtils.isNotBlank(pageNowStr)) {
			pageNow = Integer.valueOf(pageNowStr);
		}

		mav.addObject("tlist",
				teamService.getTeamList(queryObj, pageNow, pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));

		mav.addObject("name", name);
		mav.addObject("code", code);
		mav.addObject("leaderName", leaderName);
		mav.addObject("leaderMobile", leaderMobile);
		mav.addObject("province", province);
		mav.addObject("city", city);
		return mav;
	}

	/**
	 * 管理员新增班组
	 * 
	 * @return
	 */
	@RequestMapping(value = "team_add", method = RequestMethod.GET)
	public String teamAdd() {
		return "/team/team_add";
	}

	@RequestMapping(value = "team_add2", method = RequestMethod.POST)
	public ModelAndView teamAdd2() {
		String name = request.getParameter("name");
		TeamModel teammodel = teamService.getTeamByName(name);
		boolean bl =true; 
		if(teammodel != null){
			ModelAndView mav = new ModelAndView("/team/team_add");
			bl= false;
			mav.addObject("bl", bl);
			return mav;
		}
		String leaderName = request.getParameter("leaderName");
		String leaderMobile = request.getParameter("leaderMobile");
		UserModel usermodel = userService.getByUserId(leaderMobile);
		//判断该用户是否存在
		if(usermodel == null){
			UserModel umodel = new UserModel();
			umodel.setUserName(leaderName);
			umodel.setUserId(leaderMobile);
			umodel.setUserPassword("123456");
			userService.addUser(umodel);
			personService.initialPerson(leaderMobile);
			
		}
		int skillBigType = Integer.parseInt(request
				.getParameter("skillBigType"));
		int skillSmallType = 0;
		String skillSmallTypeStr = request.getParameter("smalltype");
		if (StringUtils.isNotBlank(skillSmallTypeStr))
			skillSmallType = Integer.parseInt(skillSmallTypeStr);
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		boolean bln = teamService.addTeam(name, leaderName, leaderMobile,
				skillBigType, skillSmallType, 0, province, city, street);
		
		TeamModel teamModel = teamService.getTeamByName(name);
		if(teamModel!=null){
			personService.insert(teamModel);
		}
		ModelAndView mav = new ModelAndView("/team/team_list");
		long dataCount = teamService.countAllTeam(null);
		mav.addObject("tlist", teamService.getTeamList(null, 1, 0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}

	
	
	/**
	 * 删除班组
	 * 
	 * @return
	 */
	@RequestMapping(value = "team_del", method = RequestMethod.GET)
	public ModelAndView teamDel(String id) {
		List<TeamMemberModel> tmlist = teamService.getTeamMemberByTId(id, 3);
		List<ProjectDepartmentModel> pdlist1 = projectdepartmentService.getProjectByTIdStatus(id, 1, 3);
		List<ProjectDepartmentModel> pdlist2 = projectdepartmentService.getProjectByTIdStatus(id, 1, 4);
		if(tmlist.size() == 0 && pdlist1.size() == 0 && pdlist2.size() == 0){
			teamService.delTeam(id);
		}
		ModelAndView mav = new ModelAndView("/team/team_list");
		mav.addObject("tlist", teamService.getTeamList(null, 1, 0));
		mav.addObject("page",
				PageHandler.getPage(0, 1, teamService.countAllTeam(null)));
		return mav;
	}

	/**
	 * 班组成员列表
	 * 
	 * @param id
	 *            班组ID
	 * @return
	 */
	@RequestMapping(value = "team_memberlist", method = RequestMethod.GET)
	public ModelAndView teamMemberlist(String id) {
		System.out.println("1111111111111111++++++++++++:"+id);
		ModelAndView mav = new ModelAndView("/team/teamMember_list");
		//通过班组id获取班组成员对应的用户集合
		List<UserModel> userModels = teamService.selectMember(id);
		//新建一个集合
		ArrayList<Object> list = new ArrayList<Object>();
		//如果班组成员集合对应的用户集合不为空
		if(userModels != null && !userModels.isEmpty()){
			for (UserModel model : userModels) {
				//遍历用户集合，并且与班组成员model中的骨干确立一一对应关系
				Map<String, Object> map=new HashMap<String, Object>();
				String useId =model.getUserId();
				int backbone =teamService.findMemberBackbone(id,useId);
				map.put("model", model);
				map.put("backbone", backbone);
				list.add(map);
			}
		} 
		if(list != null){
			mav.addObject("mlist", list);
		} 
		TeamModel tModel = teamService.getTeamById(id);
		mav.addObject("id", id);
		long dataCount = 0;
		if (userModels != null)
			dataCount = userModels.size();
		mav.addObject("page", PageHandler.getPage(50, 1, dataCount));
		if (tModel != null) {
			mav.addObject("name", tModel.getName());
			mav.addObject("tId", tModel.getId());
			mav.addObject("userId", tModel.getLeaderMobile());// 班组长
		}
		
		
		
		
		// 个人评价
		List<CommentsModel> comments = commentsService
				.getListByIdAndType(id, 2);
		mav.addObject("comments", comments);

		return mav;
	}
	/**
	 * 查询用户是否在班组
	 */
	@RequestMapping(value = "team_memberlist2", method = RequestMethod.POST)
	public ModelAndView teamMemberlist2(String id){
		//从页面获取的用户电话号码
		String userId = request.getParameter("userId");
		
		System.out.println("444444444444444444++++++++++:"+userId);
		//通过号码获取用户的信息
		UserModel usermodel = userService.getByUserId(userId);
		boolean canInvite = true;//是否可邀请 
		//判断该用户是否存在
		if(usermodel != null){
//			//获取该班组的所有成员
//			List<TeamMemberModel> teamMemberModels = teamService.getMemberListBytId(id);
//			//遍历该班组，对比该用户是否在该班组
//			boolean bl=true;
//			for(TeamMemberModel teamMembermodel : teamMemberModels){
//				if(userId.equals(teamMembermodel.getUserId())){
//					bl= true;
//				}
//			}
			
			
			//先判断该用户在不在班组中
			List<TeamMemberModel> teamMemberList = teamMemberService.getByTeamMemberIdAndStatus(userId, 3);
			if(teamMemberList.isEmpty()){
				canInvite = true;
			} else {
				canInvite = false;
			}
//			//该用户不能被邀请班组
//			TeamMemberModel teammembermodel = teamMemberService.getByUserIdAndtId(userId,id);
//			
//			if(teammembermodel != null && teammembermodel.getStatus() == 3){
//				canInvite = false;
//			}
			
			
			
		}
		ModelAndView mav = teamMemberlist(id);
		mav.addObject("usermodel", usermodel);
		mav.addObject("canInvite", canInvite);
		return mav;
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 邀请成员加入班组
	 */
	@RequestMapping(value = "teammember_invite", method = RequestMethod.GET)
	public ModelAndView teamMemberInvite(String id,String userId) {
		System.out.println("1111111111111111++++++++++++:"+id);
		Date date = new Date();
		//在班组成员表中加入该用户
		teamMemberService.insert(id, userId, date, 3, 0);
		UserModel usermodel = userService.getByUserId(userId);
		if(usermodel != null){
			usermodel.setUserStatus("2");
			userService.updateUser(usermodel);
		}
		ModelAndView mav = new ModelAndView("/team/teamMember_list");
		List<UserModel> userModels = teamService.selectMember(id);
		ArrayList<Object> list = new ArrayList<Object>();
		if(userModels != null && !userModels.isEmpty()){
			for (UserModel model : userModels) {
				Map<String, Object> map=new HashMap<String, Object>();
				String useId =model.getUserId();
				int backbone =teamService.findMemberBackbone(id,useId);
				map.put("model", model);
				map.put("backbone", backbone);
				list.add(map);
			}
		} 
		if(list != null){
			for(Object obj :list){
				System.out.println(obj);
			}
		} 
		TeamModel tModel = teamService.getTeamById(id);
		mav.addObject("id", id);
		mav.addObject("mlist", list);
		long dataCount = 0;
		if (userModels != null)
			dataCount = userModels.size();
		mav.addObject("page", PageHandler.getPage(50, 1, dataCount));
		if (tModel != null) {
			mav.addObject("name", tModel.getName());
			mav.addObject("tId", tModel.getId());
			mav.addObject("userId", tModel.getLeaderMobile());// 班组长
		
			
		}
		// 个人评价
		List<CommentsModel> comments = commentsService
					.getListByIdAndType(id, 2);
		mav.addObject("comments", comments);

		return mav;
		}
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 删除班组成员
	 * 
	 * @return
	 */
	@RequestMapping(value = "team_del_user", method = RequestMethod.GET)
	public ModelAndView teamDelUser(String id, String userId) {
		TeamModel tModel = teamService.getTeamById(id);
		boolean bl = true;
		if(tModel != null){
			if(userId.equals(tModel.getLeaderMobile())){
				bl =false;
			} else {
				teamService.delTeamMember(id, userId);
			}
		}
		ModelAndView mav = new ModelAndView("/team/teamMember_list");
		List<UserModel> userModels = teamService.selectMember(id);
		ArrayList<Object> list = new ArrayList<Object>();
		if(userModels != null && !userModels.isEmpty()){
			for (UserModel model : userModels) {
				Map<String, Object> map=new HashMap<String, Object>();
				String useId =model.getUserId();
				int backbone =teamService.findMemberBackbone(id,useId);
				map.put("model", model);
				map.put("backbone", backbone);
				list.add(map);
			}
		} 
		if(list != null){
			for(Object obj :list){
				System.out.println(obj);
			}
		} 
		
		mav.addObject("id", id);
		mav.addObject("mlist", list);
		long dataCount = 0;
		if (userModels != null)
			dataCount = userModels.size();
		mav.addObject("page", PageHandler.getPage(50, 1, dataCount));
		if (tModel != null) {
			mav.addObject("name", tModel.getName());
			mav.addObject("tId", tModel.getId());
			mav.addObject("userId", tModel.getLeaderMobile());// 班组长
		
			
		}
		// 个人评价
		List<CommentsModel> comments = commentsService
					.getListByIdAndType(id, 2);
		mav.addObject("comments", comments);

		return mav;
	}

	@RequestMapping(value = "team_getSmallSkillType", method = RequestMethod.POST)
	public void getSmallSkillType(String skillBigType,
			HttpServletResponse response) throws IOException {
		int skillBig = 1;
		if(StringUtils.isNotBlank(skillBigType))
			skillBig = Integer.valueOf(skillBigType);
		response.setContentType("text/html;charset=UTF-8");
		response.setContentType("UTF-8");
		
		List<ETeamSkillSmallType> sksmList = ETeamSkillSmallType
				.getSkillSmallTypeId(skillBig);
		List<SkillVo> skillList = new ArrayList<SkillVo>();
		if (sksmList != null)
			for (ETeamSkillSmallType e : sksmList) {

				SkillVo skillModel = new SkillVo();
				skillModel.setSkillType(e.id);
				skillModel.setSkillName(e.desc);
				skillList.add(skillModel);
			}
		Gson gson = new Gson();
		String jsonarray = gson.toJson(skillList);
		String json = jsonarray.toString();
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 后台班组注册校验
	 */
	////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 校验班组长电话是否已经存在
	 */
	@RequestMapping(value="verifyTeamLeaderMobile.html" )
	public void verifyTeamLeaderMoblie(HttpServletResponse response, String leaderMobile){
		int flag = 0;
		//判断该用户是否成立过班组
		TeamModel team = teamService.getTeamByLeaderMobile(leaderMobile);
		//成立过
		if(team!=null){
			flag = 1;
		//没成立过
		} else {
			flag = 2;
		}
		
		PublicMethod.objectToJson(flag, response);
	}
	
	
	
	
	/**
	 * 校验班组名称是否已经存在
	 * 
	 */
	@RequestMapping(value="verifyTeamName.html")
	public void verifyTeamName(HttpServletResponse response, String TeamName){
		String tName;
		int flag = 0;
		try {
			//页面传来的值转换成utf-8
			tName = new String(TeamName.getBytes("ISO8859-1"),"utf-8");
			//通过班组名称查询班组
			TeamModel team = teamService.getTeamByName(tName);
			//班组存在，则名称不可用
			if(team!=null){
				flag = 1;
			//班组不存在，则名称可用
			} else {
				flag = 2;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PublicMethod.objectToJson(flag, response);
		
	}
	
	
	
}
