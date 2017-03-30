package com.fengyun.web.controller;

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
import com.fengyun.web.db.playermodel.AccrecordModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.service.AccrecordService;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.TeamMemberService;
import com.fengyun.web.service.TeamService;
import com.fengyun.web.util.DateStringUtils;
import com.fengyun.web.util.ModelUtils;
import com.fengyun.web.util.PublicMethod;
import com.mongodb.BasicDBObject;



@Controller
public class AccrecordController {
	
	
	@Autowired
	private  AccrecordService accrecordService;
	
	@Autowired
	private  ProjectDepartmentService projectdepartmentService;
	
	@Autowired
	private  TeamMemberService teamMemberService;
	
	@Autowired
	private ProjectService projectService;

	@Autowired
	private TeamService teamService;
	
	@Autowired
	private  HttpServletRequest request;
	
	
	
	@RequestMapping(value="accrecord_list",method=RequestMethod.GET)
	public ModelAndView accrecordList(int pageNow,long dataCount,int pageSize){
		ModelAndView mav = new ModelAndView("/accrecord/accrecord_list");
//		if(dataCount == 0){
//			dataCount = accrecordService.countAllAccrecord(null);
//		}
//		mav.addObject("alist", accrecordService.getAccrecordList(null,pageNow,pageSize));
//		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
		
	}
	
	
	@RequestMapping(value="accrecord_list2",method=RequestMethod.POST)
	public ModelAndView accrecordlist2(){
		return toList();
	}
	

	private ModelAndView toList(){
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String pCode = request.getParameter("pCode");
		String userId = request.getParameter("userId");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String startDate1 = startDate.replace("-", "");
		String endDate1 = endDate.replace("-", "");
		
		ModelAndView mav = new ModelAndView("/accrecord/accrecord_list");
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(name)){
			queryObj.put("name", name);
		}
		if(StringUtils.isNotBlank(code)){
			queryObj.put("code", code);
		}
		if(StringUtils.isNotBlank(userId)){
			queryObj.put("userId", userId);
		}
		ModelUtils.queryDate(startDate1, endDate1, queryObj,"recordTime");
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
		
		//
		List<AccrecordModel> list = accrecordService.getAccrecordList(queryObj,pageNow,pageSize);
		//
		String pName = null;
		String tName = null;
		if(list != null && !list.isEmpty()){
			for(AccrecordModel model:list){
				if(pName == null){
					ProjectModel pModel = projectService.getByPCode(pCode);
					if(pModel != null)
						pName = pModel.getName();
					else
						pName = "";
				}
				model.setpName(pName);
				if(code == null){
					TeamModel tModel = teamService.getTeamByCode(Long.valueOf(model.getCode()));
					if(tModel != null)
						model.settName(tModel.getName());
				}else{
					if(tName == null){
						TeamModel tModel = teamService.getTeamByCode(Long.valueOf(model.getCode()));
						if(tModel != null){
							tName = tModel.getName();
						}else{
							tName = "";
						}
					}
					model.settName(tName);
				}
			}
		}
		//按照时间排序
		List<AccrecordModel> List = accrecordService.sortAccrecordList(list);
		mav.addObject("alist", list);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		mav.addObject("name", name);
		mav.addObject("code", code);
		mav.addObject("userId", userId);
		mav.addObject("endDate", endDate);
		mav.addObject("pCode", pCode);
		return mav;
	}
	
	/**
	 * 新增人员出入记录
	 */
	@RequestMapping(value="accrecord_add",method=RequestMethod.GET)
	public String accrecordAdd(){
		return "/accrecord/accrecord_add";
	}
	
	
	@RequestMapping(value="accrecord_add2",method=RequestMethod.POST)
	public ModelAndView accrecordAdd2(){
		String pCode =request.getParameter("pCode");
		String userId =request.getParameter("userId");
		String code = request.getParameter("code");
		String recordTime = request.getParameter("recordTime");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		
		boolean bln = accrecordService.addAccrecord(pCode,userId,code,recordTime,1,name,Integer.valueOf(type));
		ModelAndView mav = new ModelAndView("/accrecord/accrecord_list");
		return mav;
	}
	
	
	
	/**
	 * 修改人员出入记录
	 */
	@RequestMapping(value="accrecord_modify",method=RequestMethod.GET)
	public ModelAndView accrecordModify(String id){
		ModelAndView mav = new ModelAndView("/accrecord/accrecord_modify");
		AccrecordModel model = accrecordService.getById(id);
		if(model != null)
			mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value="accrecord_modify2",method=RequestMethod.POST)
	public ModelAndView accrecordModify2(){
		String id = request.getParameter("id");
		String pCode =request.getParameter("pCode");
		String userId =request.getParameter("userId");
		String code = request.getParameter("code");
		String recordTime = request.getParameter("recordTime");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		
		ModelAndView mav = null;
		ProjectModel pModel = projectService.getByPCode(pCode);
		//班组是否存在
		TeamModel tModel = teamService.getTeamByCode(Long.valueOf(code));
		if(pModel == null || tModel == null){
			mav = new ModelAndView("/accrecord/accrecord_modify");
			AccrecordModel model = accrecordService.getById(id);
			if(model != null)
				mav.addObject("model", model);
		}else{
			AccrecordModel model = accrecordService.getById(id);
			if(model != null){
				model.setCode(code);
				model.setName(name);
				model.setpCode(pCode);
				model.setRecordTime(DateStringUtils.parse(recordTime));
				model.setUserId(userId);
				model.setType(Integer.valueOf(type));
				if(model.getRecordTime() != null)
					accrecordService.updateAccrecord(model);
			}
			
			mav = new ModelAndView("/accrecord/accrecord_list");
		}
		
		return mav;
	}
	
	
	/**
	 * 删除人员出入记录
	 */
	@RequestMapping(value="accrecord_del",method=RequestMethod.GET)
	public ModelAndView accrecordDel(String id){
		accrecordService.delAccrecord(id);
		ModelAndView mav = new ModelAndView("/accrecord/accrecord_list");
		long dataCount = accrecordService.countAllAccrecord(null);
		mav.addObject("alist", accrecordService.getAccrecordList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}

	
	/**
	 * 某一个项目的考勤记录查询
	 * author:wq
	 */
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="accrecord_project",method=RequestMethod.GET)
	public ModelAndView accrecordprojectList(String pCode){
		String code = request.getParameter("code");
		ModelAndView mav = new ModelAndView("/accrecord/accrecord_project");
		long dataCount = 0;
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(pCode)){
			queryObj.put("pCode", pCode);
		}
		if(StringUtils.isNotBlank(code)){
			queryObj.put("code", code);
		}
		if(queryObj.size() <= 0)
			queryObj = null;
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
		
		
		ProjectModel pmodel = projectService.getByPCode(pCode);
		if(pmodel != null){
			//mav.addObject("model", pmodel);
			Object[] objs = projectService.getProjectDepartmentByPId(pmodel.getId());
			//班组信息
			if(objs[0] != null)
				mav.addObject("teams", (List<TeamModel>)objs[0]);
			List<AccrecordModel> attlist = accrecordService.getAccrecordList(queryObj, pageNow, pageSize);
			String tName = null;
			if(attlist != null && !attlist.isEmpty()){
				for(AccrecordModel model:attlist){
					if(code == null){
						TeamModel tModel = teamService.getTeamByCode(Long.valueOf(model.getCode()));
						if(tModel != null)
							model.settName(tModel.getName());
					}else{
						if(tName == null){
							TeamModel tModel = teamService.getTeamByCode(Long.valueOf(model.getCode()));
							if(tModel != null){
								tName = tModel.getName();
							}else{
								tName = "";
							}
						}
						model.settName(tName);
					}
				}
			}
			mav.addObject("aplist", attlist);
			mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
			mav.addObject("pmodel", pmodel);
		}
		mav.addObject("code", code);
		mav.addObject("pCode", pCode);
		return mav;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="accrecord_project2",method=RequestMethod.POST)
	public ModelAndView accrecordprojectList2(){
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String pCode = request.getParameter("pCode");
		String userId = request.getParameter("uId");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		ModelAndView mav = new ModelAndView("/attendanceInfo/attendanceInfo_project");
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(pCode)){
			queryObj.put("pCode", pCode);
		}
		if(StringUtils.isNotBlank(name)){
			queryObj.put("name", name);
		}
		if(StringUtils.isNotBlank(code)){
			queryObj.put("code", code);
		}
		if(StringUtils.isNotBlank(userId)){
			queryObj.put("userId", userId);
		}
		ModelUtils.queryDate(startDate, endDate, queryObj,"recordTime");
		
		if(queryObj.size() <= 0)
			queryObj = null;
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
		
		ProjectModel pmodel = projectService.getByPCode(pCode);
		if(pmodel != null){
		//	mav.addObject("model", pmodel);
			Object[] objs = projectService.getProjectDepartmentByPId(pmodel.getId());
			//班组信息
			if(objs[0] != null)
				mav.addObject("teams", (List<TeamModel>)objs[0]);
			List<AccrecordModel> attlist = accrecordService.getAccrecordList(queryObj, pageNow, pageSize);
			String tName = null;
			if(attlist != null && !attlist.isEmpty()){
				for(AccrecordModel model:attlist){
					if(code == null){
						TeamModel tModel = teamService.getTeamByCode(Long.valueOf(model.getCode()));
						if(tModel != null)
							model.settName(tModel.getName());
					}else{
						if(tName == null){
							TeamModel tModel = teamService.getTeamByCode(Long.valueOf(model.getCode()));
							if(tModel != null){
								tName = tModel.getName();
							}else{
								tName = "";
							}
						}
						model.settName(tName);
					}
				}
			}
			mav.addObject("aplist", attlist);
			mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
			mav.addObject("pmodel", pmodel);
			mav.addObject("name", name);
			mav.addObject("code", code);
			mav.addObject("pCode", pCode);
			mav.addObject("uId", userId);
		}
		mav.addObject("startDate", startDate);
		mav.addObject("endDate", endDate);
		return mav;
	}
	/////////////////////////////////////////////////////
	/**
	 * 新增人员出入校验
	 */
	///////////////////////////////////////////////////////
	/**
	 * 校验项目是否存在
	 */
	@RequestMapping(value="accrecordProjectCode.html")
	public void attendanceInfoProjectCode(HttpServletResponse response,String pCode){
		int flag = 0;
		//通过项目编号查询项目
		ProjectModel project = projectService.getByPCode(pCode);
		//可用
		if(project!=null){
			flag = 1;
		//不可用
		} else {
			flag = 2;
		}
		PublicMethod.objectToJson(flag, response);
	}
	
	/**
	 * 校验班组是否在项目下
	 */
	@RequestMapping(value="accrecordTeamCode.html")
	public void attendanceInfoTeamCode(HttpServletResponse response,String tCode,String pCode){
		int flag = 0;
		//通过项目编号查询项目
		ProjectModel project = projectService.getByPCode(pCode);
		//通过班组编号查询班组
		TeamModel team = teamService.getTeamByCode(Long.valueOf(tCode));
		//判断班组是否存在
		if(team==null){
			flag = 6;
		}else{
			String tId = team.getId();
			//判断项目存不存在
			//不存在
			if(project==null){
				flag = 4;
			} else {
				List<ProjectDepartmentModel> list = projectdepartmentService.getTeamByPIdStatus(project.getId(), 1, 3);
				//判断该项目下当前有没有班组
				if(list.isEmpty()){
					flag = 5;
				} else {
					//遍历项目的的班组id
					for(ProjectDepartmentModel model : list){
						//班组在项目下
						if(tId.equals(model.getvId())){
							flag = 1;
						//班组不在项目下
						} else {
							flag = 2;
						}
					
					}
				}
			}
		}
		
		PublicMethod.objectToJson(flag, response);
	}
	
	
	/**
	 * 校验用户是否是该班组的成员
	 */
	@RequestMapping(value="accrecordTeamMemberUserId.html")
	public void attendanceInfoTeamMemberUserId(HttpServletResponse response,String tCode,String UserId){
		int flag =0;
		
		 
		//通过查询电话查询班组
		TeamMemberModel teamMember = teamMemberService.getByUserId(UserId);
		//判断用户是否在班组中
		if(teamMember == null){
			flag =4;
		} else {
			TeamModel team = teamService.getTeamByCode(Long.valueOf(tCode));
			if((team.getId()).equals(teamMember.getId())){
				flag =1; 
			} else {
				flag =2;
			}
		}
		
		PublicMethod.objectToJson(flag, response);
	}
}
