package com.fengyun.web.controller;

import java.util.ArrayList;
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
import com.fengyun.web.db.playermodel.PayrollRecordModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.vo.TotalVo;
import com.fengyun.web.service.PayrollRecordService;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.TeamMemberService;
import com.fengyun.web.service.TeamService;
import com.fengyun.web.util.DateStringUtils;
import com.fengyun.web.util.ModelUtils;
import com.fengyun.web.util.PublicMethod;
import com.mongodb.BasicDBObject;

@Controller
public class PayrollRecordController {

	@Autowired
	private PayrollRecordService payrollRecordService;
	
	@Autowired
	private TeamMemberService teamMemberService;
	
	@Autowired
	private ProjectDepartmentService projectdepartmentService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private TeamService teamService;

	@Autowired
	private HttpServletRequest request;

	/**
	 * 显示工资发放列表
	 * 
	 * @param pageNow
	 * @param dataCount
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "payrollrecord_list", method = RequestMethod.GET)
	public ModelAndView payrollrecordList(int pageNow, long dataCount,
			int pageSize) {
		ModelAndView mav = new ModelAndView("/payrollrecord/payrollrecord_list");
		// if(dataCount == 0){
		// dataCount = payrollRecordService.countAllPayrollRecord(null);
		// }
		// mav.addObject("plist",
		// payrollRecordService.getPayrollRecordList(null,pageNow,pageSize));
		// mav.addObject("page", PageHandler.getPage(pageSize, pageNow,
		// dataCount));
		return mav;

	}

	@RequestMapping(value = "payrollrecord_list2", method = RequestMethod.POST)
	public ModelAndView payrollrecordlist2() {
		return toList();
	}

	private ModelAndView toList(){
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String userId = request.getParameter("uId");
		String pCode = request.getParameter("pCode");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String startDate1 = startDate.replace("-", "");
		String endDate1 = endDate.replace("-", "");
		
		ModelAndView mav = new ModelAndView("/payrollrecord/payrollrecord_list");
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
		if(StringUtils.isNotBlank(pCode)){
			queryObj.put("pCode", pCode);
		}
		ModelUtils.queryDate(startDate1, endDate1, queryObj,"payTime");
		dataCount = payrollRecordService.countAllPayrollRecord(queryObj);
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
		
		List<PayrollRecordModel> list = payrollRecordService.getPayrollRecordList(queryObj,pageNow,pageSize);
		String pName = null;
		String tName = null;
		if(list != null && !list.isEmpty()){
			for(PayrollRecordModel model:list){
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
		List<PayrollRecordModel> List = payrollRecordService.sortPayList(list);
		mav.addObject("plist", List);
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		mav.addObject("name", name);
		mav.addObject("code", code);
		mav.addObject("uId", userId);
		mav.addObject("startDate", startDate);
		mav.addObject("endDate", endDate);
		mav.addObject("pCode", pCode);
		
		return mav;
	}

	/**
	 * 新增工资发放记录
	 */
	@RequestMapping(value = "payrollrecord_add", method = RequestMethod.GET)
	public String payrollrecordAdd() {
		return "/payrollrecord/payrollrecord_add";
	}

	@RequestMapping(value = "payrollrecord_add2", method = RequestMethod.POST)
	public ModelAndView payrollrecordAdd2() {
		String pCode = request.getParameter("pCode");
		String userId = request.getParameter("userId");
		String code = request.getParameter("code");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String payTime = request.getParameter("payTime");
		String name = request.getParameter("name");
		
		int salary;
		if ("".equals(request.getParameter("salary"))) {
			salary = 0;
		} else {
			salary = Integer.parseInt(request.getParameter("salary"));
		}
		int realSalary;
		if ("".equals(request.getParameter("realSalary"))) {
			realSalary = 0;
		} else {
			realSalary = Integer.parseInt(request.getParameter("realSalary"));
		}
		int noSalary;
		if ("".equals(request.getParameter("noSalary"))) {
			noSalary = 0;
		} else {
			noSalary = Integer.parseInt(request.getParameter("noSalary"));
		}
		int tax;
		if ("".equals(request.getParameter("tax"))) {
			tax = 0;
		} else {
			tax = Integer.parseInt(request.getParameter("tax"));
		}
		int paytype = Integer.parseInt(request.getParameter("paytype"));
		String drawee = request.getParameter("drawee");
		String serial = request.getParameter("serial");
		boolean bln = payrollRecordService.addPayrollRecord(pCode, name,
				userId, code, startTime, endTime, salary, realSalary, noSalary,
				tax, drawee, paytype, serial, 1, payTime);
		ModelAndView mav = new ModelAndView("/payrollrecord/payrollrecord_list");
		return mav;
	}

	// ////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 某一个项目的工资发放记录查询
	 */

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "payrollrecord_project", method = RequestMethod.GET)
	public ModelAndView payrollrecordprojectList(String pCode) {
		String code = request.getParameter("code");
		ModelAndView mav = new ModelAndView("/payrollrecord/payrollrecord_project");
		long dataCount = 0;

		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(pCode)) {
			queryObj.put("pCode", pCode);
		}
		if (StringUtils.isNotBlank(code)) {
			queryObj.put("code", code);
		}
		
		dataCount = payrollRecordService.countAllPayrollRecord(queryObj);
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

		ProjectModel pmodel = projectService.getByPCode(pCode);
		if (pmodel != null){
			
			Object[] objs = projectService.getProjectDepartmentByPId(pmodel.getId());
			// 班组信息
			List<TeamModel> tlist = new ArrayList<TeamModel>();
			if (objs[0] != null) {
				tlist = (List<TeamModel>) objs[0];// 项目下的班组集合
			}
			List<List<PayrollRecordModel>> ptlist = new ArrayList<List<PayrollRecordModel>>();
			// 遍历，并且统计每个班组所有成员工资发放记录的集合
			for (TeamModel tmodel : tlist) {
				ptlist.add(payrollRecordService.getByPCodeANDcode(pCode,
						Long.toString(tmodel.getCode())));
	
			}
			// 每个班组的工资发放记录汇总 的集合
			List<TotalVo> tolist = new ArrayList<TotalVo>();
	
			//
			// TotalVo vo =new TotalVo();
	
			// PayrollRecordModel totalmodel = new PayrollRecordModel();
			for (int index = 0; index < ptlist.size(); index++) {
				TeamModel tModel = tlist.get(index);
				// 每个班组工资发放汇总的辅助类
				TotalVo vo = new TotalVo();
				vo.setName(tModel.getName());
				vo.setCode(tModel.getCode() + "");
				for (PayrollRecordModel model : ptlist.get(index)) {
					vo.setTotalSalary(vo.getTotalSalary() + model.getSalary());
					vo.setTotalRealSalary(vo.getTotalRealSalary()
							+ model.getRealSalary());
					vo.setTotalNoSalary(vo.getTotalNoSalary() + model.getNoSalary());
					vo.setTotalTax(vo.getTotalTax() + model.getTax());
				}
				tolist.add(vo);
			}
	
			mav.addObject("tolist", tolist);
	
			List<PayrollRecordModel> list = payrollRecordService.getPayrollRecordList(queryObj,pageNow,pageSize);
			//
			String tName = null;
			if(list != null && !list.isEmpty()){
				for(PayrollRecordModel model:list){
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
			mav.addObject("pplist", list);
			mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
			mav.addObject("pmodel", pmodel);
			mav.addObject("pCode", pCode);
			mav.addObject("code", code);
		}
		return mav;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "payrollrecord_project2", method = RequestMethod.POST)
	public ModelAndView payrollrecordprojectList2() {
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String pCode = request.getParameter("pCode");
		String userId = request.getParameter("uId");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		ModelAndView mav = new ModelAndView("/payrollrecord/payrollrecord_project");
		long dataCount = 0;

		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(pCode)) {
			queryObj.put("pCode", pCode);
		}
		if (StringUtils.isNotBlank(name)) {
			queryObj.put("name", name);
		}
		if (StringUtils.isNotBlank(code)) {
			queryObj.put("code", code);
		}
		if (StringUtils.isNotBlank(userId)) {
			queryObj.put("userId", userId);
		}
		ModelUtils.queryDate(startDate, endDate, queryObj,"payTime");
		
		dataCount = payrollRecordService.countAllPayrollRecord(queryObj);
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

		ProjectModel pmodel = projectService.getByPCode(pCode);
		if (pmodel != null){
			
			Object[] objs = projectService
					.getProjectDepartmentByPId(pmodel.getId());
			List<TeamModel> tlist = new ArrayList<TeamModel>();
			if (objs[0] != null) {
				tlist = (List<TeamModel>) objs[0];// 项目下的班组集合
			}
			List<List<PayrollRecordModel>> ptlist = new ArrayList<List<PayrollRecordModel>>();
			// 遍历，并且统计每个班组所有成员工资发放记录的集合
			for (TeamModel tmodel : tlist) {
				ptlist.add(payrollRecordService.getByPCodeANDcode(pCode,
						Long.toString(tmodel.getCode())));
	
			}
			// 每个班组的工资发放记录汇总 的集合
			List<TotalVo> tolist = new ArrayList<TotalVo>();
	
			//
			// TotalVo vo =new TotalVo();
	
			// PayrollRecordModel totalmodel = new PayrollRecordModel();
			for (int index = 0; index < ptlist.size(); index++) {
				TeamModel tModel = tlist.get(index);
				// 每个班组工资发放汇总的辅助类
				TotalVo vo = new TotalVo();
				vo.setName(tModel.getName());
				vo.setCode(tModel.getCode() + "");
				for (PayrollRecordModel model : ptlist.get(index)) {
					vo.setTotalSalary(vo.getTotalSalary() + model.getSalary());
					vo.setTotalRealSalary(vo.getTotalRealSalary()
							+ model.getRealSalary());
					vo.setTotalNoSalary(vo.getTotalNoSalary() + model.getNoSalary());
					vo.setTotalTax(vo.getTotalTax() + model.getTax());
				}
				tolist.add(vo);
			}
			mav.addObject("tolist", tolist);
			List<PayrollRecordModel> list = payrollRecordService.getPayrollRecordList(queryObj,pageNow,pageSize);
//			String code1 = null;
//			TeamModel teamModel1= teamService.getTeamByCode(Long.valueOf(code1));
			String pName = null;
			String tName = null;
			if(list != null && !list.isEmpty()){
				for(PayrollRecordModel model:list){
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
			mav.addObject("pplist", list);
			mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
			mav.addObject("pmodel", pmodel);
			mav.addObject("name", name);
			mav.addObject("code", code);
			mav.addObject("uId", userId);
			mav.addObject("startDate", startDate);
			mav.addObject("endDate", endDate);
			mav.addObject("pCode", pCode);
		}
		return mav;
	}
	
	
	/**
	 * 修改人员出入记录
	 */
	@RequestMapping(value="payrollrecord_modify",method=RequestMethod.GET)
	public ModelAndView payrollrecordModify(String id){
		ModelAndView mav = new ModelAndView("/payrollrecord/payrollrecord_modify");
		PayrollRecordModel model = payrollRecordService.getById(id);
		if(model != null)
			mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value="payrollrecord_modify2",method=RequestMethod.POST)
	public ModelAndView payrollrecordModify2(){
		String id = request.getParameter("id");
		String pCode = request.getParameter("pCode");
		String userId = request.getParameter("userId");
		String code = request.getParameter("code");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String payTime = request.getParameter("payTime");
		String name = request.getParameter("name");
		
		int salary;
		if ("".equals(request.getParameter("salary"))) {
			salary = 0;
		} else {
			salary = Integer.parseInt(request.getParameter("salary"));
		}
		int realSalary;
		if ("".equals(request.getParameter("realSalary"))) {
			realSalary = 0;
		} else {
			realSalary = Integer.parseInt(request.getParameter("realSalary"));
		}
		int noSalary;
		if ("".equals(request.getParameter("noSalary"))) {
			noSalary = 0;
		} else {
			noSalary = Integer.parseInt(request.getParameter("noSalary"));
		}
		int tax;
		if ("".equals(request.getParameter("tax"))) {
			tax = 0;
		} else {
			tax = Integer.parseInt(request.getParameter("tax"));
		}
		int paytype = Integer.parseInt(request.getParameter("paytype"));
		String drawee = request.getParameter("drawee");
		String serial = request.getParameter("serial");
		
		ModelAndView mav = null;
		ProjectModel pModel = projectService.getByPCode(pCode);
		//班组是否存在
		TeamModel tModel = teamService.getTeamByCode(Long.valueOf(code));
		if(pModel == null || tModel == null){
			mav = new ModelAndView("/payrollrecord/payrollrecord_modify");
			PayrollRecordModel model = payrollRecordService.getById(id);
			if(model != null)
				mav.addObject("model", model);
		}else{
			PayrollRecordModel model = payrollRecordService.getById(id);
			if(model != null){
				model.setPayTime(DateStringUtils.parse(payTime));
				model.setCode(code);
				model.setDrawee(drawee);
				model.setEndTime(endTime);
				model.setName(name);
				model.setNoSalary(noSalary);
				model.setPaytype(paytype);
				model.setpCode(pCode);
				model.setRealSalary(realSalary);
				model.setSalary(salary);
				model.setSerial(serial);
				model.setStartTime(startTime);
				model.setTax(tax);
				model.setUserId(userId);
				if(model.getPayTime() != null)
					payrollRecordService.updatePayrollRecord(model);
			}
			
			mav = new ModelAndView("/payrollrecord/payrollrecord_list");
		}
		
		return mav;
	}
	
	
	/**
	 * 删除人员出入记录
	 */
	@RequestMapping(value="payrollrecord_del",method=RequestMethod.GET)
	public ModelAndView accrecordDel(String id){
		payrollRecordService.delPayrollRecord(id);
		ModelAndView mav = new ModelAndView("/payrollrecord/payrollrecord_list");
		return mav;
	}
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * 新增工资发放校验
	 */
	///////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 校验项目是否存在
	 */
	@RequestMapping(value="payrollrecordProjectCode.html")
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
	@RequestMapping(value="payrollrecordTeamCode.html")
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
	@RequestMapping(value="payrollrecordTeamMemberUserId.html")
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
				flag =1;
			} else {
				flag =2;
			}
		}
		
		PublicMethod.objectToJson(flag, response);
	}
}
