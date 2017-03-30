package com.fengyun.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.cache.page.PageHandler;
import com.fengyun.web.db.playermodel.CommentsModel;
import com.fengyun.web.db.playermodel.PersonModel;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.service.CommentsService;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.TeamService;
import com.mongodb.BasicDBObject;

@Controller
public class TeamCreditController {
	@Autowired
	private PersonService personService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private CommentsService commentsService;
	
	@Autowired
	private  HttpServletRequest request;
	
	
	
	/**
	 * 班组诚信档案列表
	 * @param pagesize 第几页
	 * @return
	 */
	@RequestMapping(value="teamCredit_list",method=RequestMethod.GET)
	public ModelAndView personlist(int pageNow,long dataCount,int pageSize){
		ModelAndView mav = new ModelAndView("/merchant/teamCredit_list");
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("type", 1);
		if(dataCount == 0){
			dataCount = personService.countAllPerson(queryObj);
		}
		mav.addObject("pslist", personService.getPersonList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		
		return mav;
	}
	
	@RequestMapping(value="teamCredit_list2",method=RequestMethod.POST)
	public ModelAndView teamCreditlist2(){
		return toList();
	}
	
	/**
	 * 返回查询列表
	 * @return
	 */
	private ModelAndView toList(){
		String teamName = request.getParameter("teamName");
		String teamCode = request.getParameter("teamCode");
		String name = request.getParameter("name");
		ModelAndView mav = new ModelAndView("/merchant/teamCredit_list");
		
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("type", 1);
		if(StringUtils.isNotBlank(teamName)){
			queryObj.put("teamName", teamName);
		}
		if(StringUtils.isNotBlank(teamCode)){
			queryObj.put("teamCode", teamCode);
		}
		if(StringUtils.isNotBlank(name)){
			queryObj.put("name", name);
		}
		long dataCount = personService.countAllPerson(queryObj);
		
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
		
		mav.addObject("pslist", personService.getPersonList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("name", name);
		mav.addObject("teamCode", teamCode);
		mav.addObject("teamName", teamName);
		return mav;
	}
	
	
	
	@RequestMapping(value="teamCredit_add",method=RequestMethod.GET)
	public String teamCreditAdd(){
		return "/merchant/teamCredit_add";
	}
	
	@RequestMapping(value="teamCredit_modify",method=RequestMethod.GET)
	public ModelAndView teamCreditModify(String id){
		ModelAndView mav = new ModelAndView("/merchant/teamCredit_modify");
		PersonModel model = personService.getById(id);
		if(model != null){
			mav.addObject("model", model);
			TeamModel tModel = teamService.getTeamById(model.getUserId());
			if(tModel != null)
				mav.addObject("tModel", tModel);
		
		}
		return mav;
	}
	
	@RequestMapping(value="teamCredit_modify2",method=RequestMethod.POST)
	public ModelAndView teamCreditModify2(){
		String id = request.getParameter("id");
		String gender = request.getParameter("gender");
		String national = request.getParameter("national");
		String education = request.getParameter("education");
		String birth = request.getParameter("birth");
		String age = request.getParameter("age");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String identity = request.getParameter("identity");
		String health = request.getParameter("health");
		String marriage = request.getParameter("marriage");
		String skillBigType = request.getParameter("skillBigType");
		String skillSmallType = request.getParameter("smalltype");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String jobstatus = request.getParameter("jobstatus");
		String integrity = request.getParameter("integrity");
		String bankcard = request.getParameter("bankcard");
		String address = request.getParameter("address");
		String guidelines = request.getParameter("guidelines");
		String safety = request.getParameter("safety");
		String contract = request.getParameter("contract");
		String worktime = request.getParameter("worktime");
		String unit = request.getParameter("unit");
		String experience = request.getParameter("experience");
		PersonModel model = personService.getById(id);
		if(model != null){
			model.setAddress(address);
			model.setAge(age);
			model.setBankcard(bankcard);
			model.setBirth(birth);
			model.setContract(contract);
			model.setEducation(education);
			model.setExperience(experience);
			model.setGender(gender);
			model.setHealth(health);
			model.setHeight(height);
			model.setIdentity(identity);
			model.setProvince(province);
			model.setCity(city);
			model.setJobstatus(jobstatus);
			model.setNational(national);
			model.setMarriage(marriage);
			model.setSafety(safety);
			model.setSkillBigType(skillBigType);
			model.setSkillSmallType(skillSmallType);
			model.setUnit(unit);
			model.setWeight(weight);
			model.setWorktime(worktime);
			model.setGuidelines(guidelines);
			model.setIntegrity(integrity);
			personService.updatePerson(model);
		}
		
		ModelAndView mav = new ModelAndView("/merchant/teamCredit_list");
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("type", 1);
		long dataCount = personService.countAllPerson(queryObj);
		mav.addObject("pslist", personService.getPersonList(queryObj,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	/**
	 * 管理员新增班组诚信档案
	 * @return
	 */
	@RequestMapping(value="teamCredit_add2",method=RequestMethod.POST)
	public ModelAndView teamCreditAdd2(){
		String teamCode = request.getParameter("teamCode");
		String teamName = request.getParameter("teamName");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String national = request.getParameter("national");
		String education = request.getParameter("education");
		String birth = request.getParameter("birth");
		String age = request.getParameter("age");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String identity = request.getParameter("identity");
		String health = request.getParameter("health");
		String marriage = request.getParameter("marriage");
		String skillBigType = request.getParameter("skillBigType");
		String skillSmallType = request.getParameter("smallType");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String jobstatus = request.getParameter("jobstatus");
		String integrity = request.getParameter("integrity");
		String bankcard = request.getParameter("bankcard");
		String address = request.getParameter("address");
		String guidelines = request.getParameter("guidelines");
		String safety = request.getParameter("safety");
		String contract = request.getParameter("contract");
		String worktime = request.getParameter("worktime");
		String unit = request.getParameter("unit");
		String experience = request.getParameter("experience");
//		String userId = request.getParameter("userId");
		TeamModel tModel = teamService.getTeamByCode(Long.valueOf(teamCode));
		if(tModel != null)
			personService.addPerson(1,teamCode,teamName,name, gender, national, education, birth, 
					age, height, weight, identity, health, marriage, skillBigType, skillSmallType,
					province,city, jobstatus, integrity, bankcard, address, guidelines, safety, contract, 
					worktime, unit, experience, tModel.getId(),null,null);
		
		ModelAndView mav = new ModelAndView("/merchant/teamCredit_list");
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("type", 1);
		long dataCount = personService.countAllPerson(queryObj);
		mav.addObject("pslist", personService.getPersonList(queryObj,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	/**
	 * 删除个人诚信档案
	 * @return
	 */
	@RequestMapping(value="teamCredit_del",method=RequestMethod.GET)
	public ModelAndView teamCreditDel(String id){
		personService.delPerson(id);
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("type", 1);
		long dataCount = personService.countAllPerson(queryObj);
		ModelAndView mav = new ModelAndView("/merchant/teamCredit_list");
		mav.addObject("pslist", personService.getPersonList(queryObj,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}

	/**
	 * 查看班组诚信档案表
	 * @param id
	 * @return
	 */
	@RequestMapping(value="teamCredit_form",method=RequestMethod.GET)
	public ModelAndView teamCreditForm(String id){
		ModelAndView mav = new ModelAndView("/merchant/teamCredit_form");
		PersonModel model = personService.getById(id);
		if(model != null){
			mav.addObject("model", model);
			TeamModel tModel = teamService.getTeamById(model.getUserId());
			if(tModel != null)
				mav.addObject("tModel", tModel);
				List<TeamMemberModel> teamMemberModels = teamService.getMemberListBytId(model.getUserId());
				List<UserModel> userModels = teamService.selectMember(model.getUserId());
				ArrayList<Object> list = new ArrayList<Object>();
				if(userModels != null && !userModels.isEmpty()){
					for (UserModel usmodel : userModels) {
						Map<String, Object> map=new HashMap<String, Object>();
						String useId =model.getUserId();
						int backbone =teamService.findMemberBackbone(id,useId);
						map.put("model", model);
						map.put("backbone", backbone);
						list.add(map);
					}
				} else{
					System.out.println("^^^^^^^^^^^^^^^^99999999999");
				}
				if(list != null){
					for(Object obj :list){
						System.out.println(obj);
					}
				} else {
					System.out.println("++++++++++++##############");
				}
				mav.addObject("mlist", list);
//			commentsService.addComments("2015年1月", "2016年2月", "广州花园酒店项目", "", 
//					2, 2, 5, "基本达到要求", 1, "13648032295");
//			
//			commentsService.addComments("2016年3月", "2016年10月", "广州天地花园项目", "", 
//					2, 2, 2, "偶尔会迟到早退", 1, "13648032295");
//			
//			commentsService.addComments("2014年6月", "2016年1月", "广州花园酒店项目", "", 
//					5, 5, 5, "勤奋刻苦，作风顽强", 1, "13829254840");
//			
//			commentsService.addComments("2016年3月", "2016年7月", "广州天地花园项目", "", 
//					5, 2, 5, "按时完成交待任务", 1, "13829254840");
//			
//			commentsService.addComments("2015年1月", "2016年2月", "广州花园酒店项目", "", 
//					5, 5, 5, "提供的材料质量非常不错，保证了工程进度", 3, "580f2ce2e4b06307f567102f");
//			
//			commentsService.addComments("2016年3月", "2016年10月", "广州天地花园项目", "", 
//					5, 5, 5, "非常好", 3, "580f2ce2e4b06307f567102f");
//			
//			commentsService.addComments("2014年6月", "2016年1月", "广州花园酒店项目", "", 
//					2, 5, 2, "基本达到要求，偶尔会延迟", 4, "58098999e4b0b99e3a72c907");
//			
//			commentsService.addComments("2016年3月", "2016年7月", "广州天地花园项目", "", 
//					2, 2, 5, "个别设备提供不够及时", 4, "58098999e4b0b99e3a72c907");
//			
//			commentsService.addComments("2014年6月", "2016年1月", "广州花园酒店项目", "", 
//					5, 5, 5, "非常好", 4, "580836f6e4b003c5492d8718");
//			
//			commentsService.addComments("2016年3月", "2016年7月", "广州天地花园项目", "", 
//					2, 5, 5, "诚信设备商提供方！！", 4, "580836f6e4b003c5492d8718");
			
			// 班组评价
			List<CommentsModel> comments = commentsService.getListByIdAndType(model.getUserId(),
					2);
			mav.addObject("comments", comments);
		}
		
		return mav;
	}
	
	/**
	 * 查看班组骨干成员列表
	 */
	/**
	@RequestMapping(value = "teambackbone_list", method = RequestMethod.GET)
	public ModelAndView teamBackbonelist(String id) {
		ModelAndView mav = new ModelAndView("/team/teambackbone_list");
		List<UserModel> userModels = teamService.selectMember(id);
		TeamModel tModel = teamService.getTeamById(id);
		mav.addObject("mlist", userModels);
		long dataCount = 0;
		if (userModels != null)
			dataCount = userModels.size();
		mav.addObject("page", PageHandler.getPage(50, 1, dataCount));
		if (tModel != null) {
			mav.addObject("name", tModel.getName());
			mav.addObject("tId", tModel.getId());
			mav.addObject("userId", tModel.getLeaderMobile());// 班组长
		}
		

		return mav;
	}
	
	*/
	
	
	
	
	

}
