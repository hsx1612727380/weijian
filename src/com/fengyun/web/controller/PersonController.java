package com.fengyun.web.controller;

import java.util.List;

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
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.service.CommentsService;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.UserService;
import com.mongodb.BasicDBObject;

@Controller
public class PersonController {
	@Autowired
	private PersonService personService;
	@Autowired
	private UserService userService;
	@Autowired
	private CommentsService commentsService;

	@Autowired
	private HttpServletRequest request;

	/**
	 * 个人诚信档案列表
	 * 
	 * @param pagesize
	 *            第几页
	 * @return
	 */
	@RequestMapping(value = "person_list", method = RequestMethod.GET)
	public ModelAndView personlist(int pageNow, long dataCount, int pageSize) {
		ModelAndView mav = new ModelAndView("/merchant/person_list");
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("type", 0);
		if (dataCount == 0) {
			dataCount = personService.countAllPerson(queryObj);
		}
		mav.addObject("pslist",
				personService.getPersonList(queryObj, pageNow, pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}

	@RequestMapping(value = "person_list2", method = RequestMethod.POST)
	public ModelAndView personlist2() {
		return toList();
	}

	/**
	 * 返回查询列表
	 * 
	 * @return
	 */
	private ModelAndView toList() {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String userId = request.getParameter("userId");
		ModelAndView mav = new ModelAndView("/merchant/person_list");

		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("type", 0);
		if (StringUtils.isNotBlank(name)) {
			queryObj.put("name", name);
		}
		if (StringUtils.isNotBlank(age)) {
			queryObj.put("age", age);
		}
		if (StringUtils.isNotBlank(userId)) {
			queryObj.put("userId", userId);
		}
		if (queryObj.size() <= 0)
			queryObj = null;

		long dataCount = personService.countAllPerson(queryObj);

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

		mav.addObject("pslist",
				personService.getPersonList(queryObj, pageNow, pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));

		mav.addObject("name", name);
		mav.addObject("age", age);
		mav.addObject("userId", userId);
		return mav;
	}

	@RequestMapping(value = "person_add", method = RequestMethod.GET)
	public String personAdd() {
		return "/merchant/person_add";
	}

	@RequestMapping(value = "person_modify", method = RequestMethod.GET)
	public ModelAndView personModify(String id) {
		ModelAndView mav = new ModelAndView("/merchant/person_modify");
		PersonModel model = personService.getById(id);
		if (model != null){
			mav.addObject("model", model);
			if(model != null){
				UserModel uModel = userService.getByUserId(model.getUserId());
				if(uModel != null)
					mav.addObject("uModel", uModel);
			}
		}
		return mav;
	}

	@RequestMapping(value = "person_modify2", method = RequestMethod.POST)
	public ModelAndView personModify2() {
		String id = request.getParameter("id");
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
		String skillSmallType = request.getParameter("skillSmallType");
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
		String entryTime = request.getParameter("entryTime");
		String exitTime = request.getParameter("exitTime");
		PersonModel model = personService.getById(id);
		if (model != null) {
			model.setName(name);
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
			model.setEntryTime(entryTime);
			model.setExitTime(exitTime);
			personService.updatePerson(model);
			UserModel usermodel = userService.getByUserId(model.getUserId());
			usermodel.setAge(Integer.valueOf(age));
			usermodel.setUserName(name);
			usermodel.setUserProvince(province);
			usermodel.setUserCity(city);
			usermodel.setSkillBigType(Integer.valueOf(skillBigType));
			usermodel.setSkillSmallType(Integer.valueOf(skillSmallType));
			userService.updateUser(usermodel);
		}
		
		ModelAndView mav = new ModelAndView("/merchant/person_list");
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("type", 0);
		long dataCount = personService.countAllPerson(queryObj);
		mav.addObject("pslist", personService.getPersonList(queryObj, 1, 0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}

	/**
	 * 管理员新增个人诚信档案
	 * 
	 * @return
	 */
	@RequestMapping(value = "person_add2", method = RequestMethod.POST)
	public ModelAndView personAdd2() {
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
		String userId = request.getParameter("userId");
		String entryTime = request.getParameter("entryTime");
		String exitTime = request.getParameter("exitTime");
		personService.addPerson(0, "", "", name, gender, national, education,
				birth, age, height, weight, identity, health, marriage,
				skillBigType, skillSmallType, province, city, jobstatus,
				integrity, bankcard, address, guidelines, safety, contract,
				worktime, unit, experience, userId, entryTime, exitTime);
		ModelAndView mav = new ModelAndView("/merchant/person_list");
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("type", 0);
		long dataCount = personService.countAllPerson(queryObj);
		mav.addObject("pslist", personService.getPersonList(queryObj, 1, 0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}

	/**
	 * 删除个人诚信档案
	 * 
	 * @return
	 */
	@RequestMapping(value = "person_del", method = RequestMethod.GET)
	public ModelAndView personDel(String id) {
		personService.delPerson(id);
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("type", 0);
		long dataCount = personService.countAllPerson(queryObj);
		ModelAndView mav = new ModelAndView("/merchant/person_list");
		mav.addObject("pslist", personService.getPersonList(queryObj, 1, 0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}

	/**
	 * 查看个人诚信档案表
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "person_form", method = RequestMethod.GET)
	public ModelAndView personformlist(String id) {
		ModelAndView mav = new ModelAndView("/merchant/person_form");
		PersonModel model = personService.getById(id);
		if (model != null) {
			mav.addObject("model", model);
			UserModel uModel = userService.getByUserId(model.getUserId());
			if (uModel != null) {
				mav.addObject("uModel", uModel);
				// 个人评价
				List<CommentsModel> comments = commentsService
						.getListByIdAndType(model.getUserId(), 1);
				mav.addObject("comments", comments);
			}
		}
		return mav;
	}

}
