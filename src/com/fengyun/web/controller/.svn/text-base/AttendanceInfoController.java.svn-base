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
import com.fengyun.web.db.playermodel.AttendanceInfoModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.service.AttendanceInfoService;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.TeamMemberService;
import com.fengyun.web.service.TeamService;
import com.fengyun.web.util.DateStringUtils;
import com.fengyun.web.util.ModelUtils;
import com.fengyun.web.util.PublicMethod;
import com.mongodb.BasicDBObject;

@Controller
public class AttendanceInfoController {

	@Autowired
	private AttendanceInfoService attendanceInfoService;
	
	@Autowired
	private TeamMemberService teamMemberService;
	
	
	@Autowired
	private ProjectDepartmentService projectdepartmentService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private  HttpServletRequest request;
	
	
	@RequestMapping(value="attendanceInfo_list",method=RequestMethod.GET)
	public ModelAndView attendanceInfoList(int pageNow,long dataCount,int pageSize){
		ModelAndView mav = new ModelAndView("/attendanceInfo/attendanceInfo_list");
//		if(dataCount == 0){
//			dataCount = attendanceInfoService.countAllAttendanceInfo(null);
//		}
//		mav.addObject("alist", attendanceInfoService.getAttendanceInfoList(null,pageNow,pageSize));
//		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
		
	}
	
	
	@RequestMapping(value="attendanceInfo_list2",method=RequestMethod.POST)
	public ModelAndView attendanceInfolist2(){
		return toList();
	}
	

	private ModelAndView toList(){
		String pCode = request.getParameter("pCode");
		String code = request.getParameter("code");
		String userId = request.getParameter("uId");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		System.out.println("22222222222222++++++++:startDate"+startDate);
		ModelAndView mav = new ModelAndView("/attendanceInfo/attendanceInfo_list");
		long dataCount = 0;
		String startDate1 = startDate.replace("-", "");
		String endDate1 = endDate.replace("-", "");
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(pCode)){
			queryObj.put("pCode", pCode);
		}
		if(StringUtils.isNotBlank(code)){
			queryObj.put("code", code);
		}
		if(StringUtils.isNotBlank(userId)){
			queryObj.put("userId", userId);
		}
		ModelUtils.queryDate(startDate1, endDate1, queryObj);
		
		if(queryObj.size() <= 0)
			queryObj = null;
		dataCount = attendanceInfoService.countAllAttendanceInfo(queryObj);
		
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
		List<AttendanceInfoModel> attlist = attendanceInfoService.getAttendanceInfoList(queryObj, pageNow, pageSize);
		
		String pName = null;
		String tName = null;
		if(attlist != null && !attlist.isEmpty()){
			for(AttendanceInfoModel model:attlist){
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
//		//创建一个新集合
//		List<AttendanceInfoModel> timelist = new ArrayList<AttendanceInfoModel>();
//		//遍历考勤列表
//		if(attlist != null && !attlist.isEmpty()){
//			for(AttendanceInfoModel attendanceInfomodel : attlist){
//				//把开始时间和所在的model创建一一对应关系
////				Map<String,Object>  map = new HashMap<String,Object>();
////				String startDateStr =attendanceInfomodel.getStartDateStr();
////				map.put("attendanceInfomodel", attendanceInfomodel);
////				map.put("startDateStr", startDateStr);
////				list.add(map);
//			}
//		}
//		
//		
//		//把开始时间转化成int类型
//		//创建一个开始时间的集合
//		//将开始时间进行升序排列
//		//这样map集合所对应的的model也会进行排列
		//按照时间排序
		List<AttendanceInfoModel> attList = attendanceInfoService.sortAttList(attlist);
		mav.addObject("alist",attList );
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		mav.addObject("pCode", pCode);
		mav.addObject("code", code);
		mav.addObject("uId", userId);
		mav.addObject("startDate", startDate);
		mav.addObject("endDate", endDate);
		return mav;
	}
	
	/**
	 * 新增考勤记录
	 */
	@RequestMapping(value="attendanceInfo_add",method=RequestMethod.GET)
	public String attendanceInfoAdd(){
		return "/attendanceInfo/attendanceInfo_add";
	}
	
	
	@RequestMapping(value="attendanceInfo_add2",method=RequestMethod.POST)
	public ModelAndView attendanceInfoAdd2(){
		String pCode =request.getParameter("pCode");
		String userId =request.getParameter("userId");
		
		String code = request.getParameter("code");
		TeamModel teammodle= teamService.getTeamByCode(Long.valueOf(code));
		//判断班组是否存在
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String name = request.getParameter("name");
		String workTime = request.getParameter("workTime");
		boolean bln = attendanceInfoService.addAttendanceInfo(pCode,userId,code,startDate,endDate,1,name,Double.valueOf(workTime));
		if(!bln)
			return new ModelAndView("/attendanceInfo/attendanceInfo_add");
		ModelAndView mav = new ModelAndView("/attendanceInfo/attendanceInfo_list");
		return mav;
	}
	
	
	
	/**
	 * 修改考勤记录
	 * author:wq
	 */
	@RequestMapping(value="attendanceInfo_modify",method=RequestMethod.GET)
	public ModelAndView attendanceInfoModify(String id){
		ModelAndView mav = new ModelAndView("/attendanceInfo/attendanceInfo_modify");
		AttendanceInfoModel model = attendanceInfoService.getById(id);
		if(model != null)
			mav.addObject("model", model);
		return mav;
	}
	
	
	@RequestMapping(value="attendanceInfo_modify2",method=RequestMethod.POST)
	public ModelAndView attendanceInfoModify(){
		String id = request.getParameter("id");
		String pCode =request.getParameter("pCode");
		String userId =request.getParameter("userId");
		String code = request.getParameter("code");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String name = request.getParameter("name");
		String workTime = request.getParameter("workTime");
		//判断项目是否存在
		ModelAndView mav = null;
		ProjectModel pModel = projectService.getByPCode(pCode);
		//班组是否存在
		TeamModel tModel = teamService.getTeamByCode(Long.valueOf(code));
		if(pModel == null || tModel == null){
			mav = new ModelAndView("/attendanceInfo/attendanceInfo_modify");
			AttendanceInfoModel model = attendanceInfoService.getById(id);
			if(model != null)
				mav.addObject("model", model);
		}else{
			
			AttendanceInfoModel model = attendanceInfoService.getById(id);
			if(model != null){
				model.setpCode(pCode);
				model.setUserId(userId);
				model.setCode(code);
				model.setStartDate(DateStringUtils.parse(startDate));
				model.setEndDate(DateStringUtils.parse(endDate));
				model.setName(name);
				model.setWorkTime(Float.valueOf(workTime));
				if(model.getStartDate() != null && model.getEndDate() != null)
					attendanceInfoService.updateAttendanceInfo(model);
			}
			
			mav = new ModelAndView("/attendanceInfo/attendanceInfo_list");
		}
		
		return mav;
	}
	
	
	
	
	/**
	 * 删除考勤记录
	 */
	@RequestMapping(value="attendanceInfo_del",method=RequestMethod.GET)
	public ModelAndView delattendanceInfo(String id){
		attendanceInfoService.delAttendanceInfo(id);
		ModelAndView mav = new ModelAndView("/attendanceInfo/attendanceInfo_list");
//		long dataCount = attendanceInfoService.countAllAttendanceInfo(null);
//		mav.addObject("alist", attendanceInfoService.getAttendanceInfoList(null,1,0));
//		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav; 
		
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 某一个项目的考勤记录查询
	 * author:wq
	 */
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="attendanceInfo_project",method=RequestMethod.GET)
	public ModelAndView attendanceInfoprojectList(String pCode){
		String code = request.getParameter("code");
		ModelAndView mav = new ModelAndView("/attendanceInfo/attendanceInfo_project");
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
		dataCount = attendanceInfoService.countAllAttendanceInfo(queryObj);
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
			//
			
			List<AttendanceInfoModel> attlist = attendanceInfoService.getAttendanceInfoList(queryObj, pageNow, pageSize);
			String tName = null;
			if(attlist != null && !attlist.isEmpty()){
				for(AttendanceInfoModel model:attlist){
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
			//
			mav.addObject("aplist", attlist);
			mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
			mav.addObject("pmodel", pmodel);
		}
		mav.addObject("code", code);
		mav.addObject("pCode", pCode);
		return mav;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="attendanceInfo_project2",method=RequestMethod.POST)
	public ModelAndView attendanceInfoprojectList2(){
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
		ModelUtils.queryDate(startDate, endDate, queryObj);
		
		if(queryObj.size() <= 0)
			queryObj = null;
			dataCount = attendanceInfoService.countAllAttendanceInfo(queryObj);
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
			List<AttendanceInfoModel> attlist = attendanceInfoService.getAttendanceInfoList(queryObj, pageNow, pageSize);
			String tName = null;
			String pName = null;
			if(attlist != null && !attlist.isEmpty()){
				for(AttendanceInfoModel model:attlist){
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
	////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 新增考勤记录校验
	 */
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * 校验项目是否存在
	 */
	@RequestMapping(value="attendanceInfoProjectCode.html")
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
	@RequestMapping(value="attendanceInfoTeamCode.html")
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
	@RequestMapping(value="attendanceInfoTeamMemberUserId.html")
	public void attendanceInfoTeamMemberUserId(HttpServletResponse response,String tCode,String UserId){
		int flag =0;
		
		//通过查询电话查询班组
		TeamMemberModel teamMember = teamMemberService.getByUserId(UserId);
		//判断用户是否在班组中
		if(teamMember == null){
			flag =4;
		} else {
			TeamModel team = teamService.getTeamByCode(Long.valueOf(tCode));
			if((team.getId()).equals(teamMember.gettId())){
				flag = 1;
			} else {
				flag = 2;
			}
		}
		
		PublicMethod.objectToJson(flag, response);
	}
	
}
