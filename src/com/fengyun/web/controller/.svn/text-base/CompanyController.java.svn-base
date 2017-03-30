package com.fengyun.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
import com.fengyun.web.db.playermodel.CompanyModel;
import com.fengyun.web.db.playermodel.NoticeLogModel;
import com.fengyun.web.db.playermodel.NoticeModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.service.CompanyService;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.UserService;
import com.fengyun.web.service.NoticeService;
import com.fengyun.web.service.NoticeLogService;
import com.fengyun.web.util.PublicMethod;
import com.mongodb.BasicDBObject;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private NoticeLogService noticeLogService;
	
	@Autowired
	private  HttpServletRequest request;
	
	/**company_mobilRepCHeck
	 * 公司注册
	 */
	@RequestMapping("front_company_regiter.html")
	public String frontCompanyRegiter(CompanyModel model, HttpServletResponse response) {
		model.setCreateTime(new Date());
		String userId=model.getUserId();
		UserModel userModel=userService.getByUserId(userId);
		if(userModel!=null)
		{
			userModel.setUserType("3");
			userService.updateUser(userModel);
		}
		if(userModel==null)
		{
			UserModel userModel1=new UserModel();
			userModel1.setUserName(model.getLeaderName());
			userModel1.setUserId(model.getUserId());
			userService.addUser(userModel1);
		}
		companyService.regCompany(model);
		request.getSession().setAttribute("user", model);
		request.getSession().setAttribute("userName", model.getName());
		request.getSession().setAttribute("type", "3");
		request.getSession().setAttribute("userId", model.getUserId());
		Map<String, String> map = noticeService.getNMCount(userId);
		request.getSession().setAttribute("count", map.get("count"));
		request.getSession().setAttribute("unReadMessageCount", map.get("unReadMessageCount"));
		request.getSession().setAttribute("readMessageCount", map.get("readMessageCount"));
		request.getSession().setAttribute("unReadNoticeCount", map.get("unReadNoticeCount"));
		request.getSession().setAttribute("readNoticeCount", map.get("readNoticeCount"));
		return "forward:person.html";
	}
	
	/**
	 * 检查用户手机号是否注册过
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("company_mobilRepCHeck.html")
	public void mobilRepCHeck(String userId, HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();
		System.out.println("userId:"+userId);
		//返回0 表示重复，1不重复
		int ifRepost=0;
		UserModel usermodel=userService.getByUserId(userId);
		if(usermodel==null)
		{
			ifRepost=1;
		}
		out.print(ifRepost);
		out.flush();
		out.close();
	}
	
	/**
	 * 公司列表
	 * @param pagesize 第几页
	 * @return
	 */
	@RequestMapping(value="company_list",method=RequestMethod.GET)
	public ModelAndView companylist(int pageNow,long dataCount,int pageSize){
		ModelAndView mav = new ModelAndView("/company/company_list");
		if(dataCount == 0){
			dataCount = companyService.countAllCompany(null);
		}
		mav.addObject("clist", companyService.getCompanyList(null,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}
	
	@RequestMapping(value="company_list2",method=RequestMethod.POST)
	public ModelAndView companylist2(){
		return toList();
	}
	
	
	@RequestMapping(value="front_company_regForm.html",method=RequestMethod.GET)
	public String company_regForm(){
		return "company/front_company_regsiter";
	}
	
	/**
	 * 返回查询列表
	 * @return
	 */
	private ModelAndView toList(){
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String userId = request.getParameter("uId");
		String leaderName = request.getParameter("leaderName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		ModelAndView mav = new ModelAndView("/company/company_list");
//		String dataCountStr = request.getParameter("dataCount");
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(name)){
			queryObj.put("name", name);
		}
		if(StringUtils.isNotBlank(code)){
			queryObj.put("code", code);
		}
		if(StringUtils.isNotBlank(leaderName)){
			queryObj.put("leaderName", leaderName);
		}
		if(StringUtils.isNotBlank(userId)){
			queryObj.put("userId", userId);
		}
		if(StringUtils.isNotBlank(province)){
			queryObj.put("province", province);
		}
		if(StringUtils.isNotBlank(city)){
			queryObj.put("city", city);
		}
		if(queryObj.size() <= 0)
			queryObj = null;
		
//		if(dataCountStr == null || "".equals(dataCountStr)){
			dataCount = companyService.countAllCompany(queryObj);
//		}else{
//			dataCount = Integer.valueOf(dataCountStr);
//		}
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
		
		mav.addObject("clist", companyService.getCompanyList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		
		mav.addObject("name", name);
		mav.addObject("code", code);
		mav.addObject("uId", userId);
		mav.addObject("leaderName", leaderName);
		mav.addObject("province", province);
		mav.addObject("city", city);
		return mav;
	}
	
	/**
	 * 公司审核
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="company_pass",method=RequestMethod.GET)
	public ModelAndView companyPass(String id){
		CompanyModel companymodel = companyService.getById(id);
		boolean pass = true;
		if(companymodel!=null){
			if(StringUtils.isNotBlank(companymodel.getCode())){
				pass = true;
			} else {
				pass = false;
			}
		}
		companyService.companyPass(id);
		return toList();
	}
	
	@RequestMapping(value="company_add",method=RequestMethod.GET)
	public String projectAdd(){
		return "/company/company_add";
	}
	
	@RequestMapping(value="company_modify",method=RequestMethod.GET)
	public ModelAndView projectModify(String id){
		ModelAndView mav = new ModelAndView("/company/company_modify");
		CompanyModel model = companyService.getById(id);
		if(model != null)
			mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value="company_modify2",method=RequestMethod.POST)
	public ModelAndView companyModify2(){
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String userId = request.getParameter("userId");
		String leaderName = request.getParameter("leaderName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String type = request.getParameter("type");
		String regType = request.getParameter("regType");
		String regMoney = request.getParameter("regMoney");
		String tel = request.getParameter("tel");
		String organization = request.getParameter("organization");
		//code为空，返回错误
		
		//if(code.equals(thismodel.getCode()),判断是否修改了code
			//如果是,判断是否与数据库其他编号重复
				//如果是，返回错误
				
				//如果不是，修改成功
			//如果不是，修改成功
		if(StringUtils.isBlank(code)){
			ModelAndView mav = new ModelAndView("/company/company_modify");
			CompanyModel model = companyService.getById(id);
			if(model != null)
				mav.addObject("model", model);
			return mav;//返回修改页面
			
		}
			

		CompanyModel cmodel =companyService.getByCode(code);
		if(cmodel != null && !cmodel.getId().equals(id)){
			ModelAndView mav = new ModelAndView("/company/company_modify");
			CompanyModel model = companyService.getById(id);
			if(model != null)
				mav.addObject("model", model);
			return mav;//返回修改页面
			
		} else {
			CompanyModel model = companyService.getById(id);
			if(model != null){
			    model.setName(name);
				model.setCode(code);
			    model.setUserId(userId);
				model.setLeaderName(leaderName);
				model.setProvince(province);
				model.setCity(city);
 			    model.setStreet(street);
				model.setType(type);
				model.setRegType(regType);
				model.setRegMoney(regMoney);
				model.setOrganization(organization);
				companyService.updateCompany(model);
			}
		
			ModelAndView mav = new ModelAndView("/company/company_list");
			long dataCount = companyService.countAllCompany(null);
			mav.addObject("clist", companyService.getCompanyList(null,1,0));
			mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
			return mav;// 修改成功页面
		}
		
		
//		CompanyModel thismodel =companyService.getById(id);
//		if(code.equals(thismodel.getCode())== false){
//		CompanyModel cmodel =companyService.getByCode(code);
//		if(cmodel == null){
//			CompanyModel model = companyService.getById(id);
//			if(model != null){
//				model.setName(name);
//				model.setCode(code);
//				model.setUserId(userId);
//				model.setLeaderName(leaderName);
//				model.setProvince(province);
//				model.setCity(city);
//				model.setStreet(street);
//				model.setType(type);
//				model.setRegType(regType);
//				model.setRegMoney(regMoney);
//				model.setOrganization(organization);
//				companyService.updateCompany(model);
//			}
//		
//			ModelAndView mav = new ModelAndView("/company/company_list");
//			long dataCount = companyService.countAllCompany(null);
//			mav.addObject("clist", companyService.getCompanyList(null,1,0));
//			mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
//			return mav;
//		} else{
//			ModelAndView mav = new ModelAndView("/company/company_modify");
//			CompanyModel model = companyService.getById(id);
//			if(model != null)
//				mav.addObject("model", model);
//			return mav;
//			}
//		} else {
//			CompanyModel model = companyService.getById(id);
//			if(model != null){
//				model.setName(name);
//				model.setCode(code);
//				model.setUserId(userId);
//				model.setLeaderName(leaderName);
//				model.setProvince(province);
//				model.setCity(city);
//				model.setStreet(street);
//				model.setType(type);
//				model.setRegType(regType);
//				model.setRegMoney(regMoney);
//				model.setOrganization(organization);
//				companyService.updateCompany(model);
//			}
//		
//			ModelAndView mav = new ModelAndView("/company/company_list");
//			long dataCount = companyService.countAllCompany(null);
//			mav.addObject("clist", companyService.getCompanyList(null,1,0));
//			mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
//			return mav;
//		}
	}
	
	
	/**
	 * 管理员新增公司
	 * @return
	 */
	@RequestMapping(value="company_add2",method=RequestMethod.POST)
	public ModelAndView companyAdd2(){
		String name = request.getParameter("name");
		CompanyModel companymodel = companyService.getByName(name);
		if(companymodel != null){
			ModelAndView mav = new ModelAndView("/company/company_add");
			return mav;
		}
		String code = request.getParameter("code");
		String userId = request.getParameter("userId");
		String leaderName = request.getParameter("leaderName");
		//通过用户电话查询
		UserModel usermodel = userService.getByUserId(userId);
		//判断该用户是否存在
		if(usermodel == null){
			UserModel umodel = new UserModel();
			umodel.setUserName(leaderName);
			umodel.setUserId(userId);
			umodel.setUserPassword("123456");
			userService.addUser(umodel);
			personService.initialPerson(userId);
		}
		
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String tel = request.getParameter("tel");
		String street = request.getParameter("street");
		String type = request.getParameter("type");
		String regType = request.getParameter("regType");
		String regMoney = request.getParameter("regMoney");
		String organization = request.getParameter("organization");
		CompanyModel cmodel = companyService.getByCode(code);
		String result;
		if(cmodel == null){
		boolean bln = companyService.addCompany(name, code, userId, leaderName, province, city, street,type,2,
				regType,regMoney,organization,tel);
		ModelAndView mav = new ModelAndView("/company/company_list");
		long dataCount = companyService.countAllCompany(null);
		mav.addObject("clist", companyService.getCompanyList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
		} else {
			result="1";
			ModelAndView mav = new ModelAndView("/company/company_add");
			mav.addObject("result", result);
			return mav;
		}
		//
		
	}
	
	/**
	 * 删除公司
	 * @return
	 */
	@RequestMapping(value="company_del",method=RequestMethod.GET)
	public ModelAndView companyDel(String id){
		CompanyModel cmodel = companyService.getById(id);
		String code =cmodel.getCode();
		List<ProjectModel> plist =projectService.getByCode(code);
		System.out.println("+++++++++++++++++++++++-------------------------"+plist);
		if(plist.size() == 0){
		companyService.delCompany(id);
		}
		ModelAndView mav = new ModelAndView("/company/company_list");
		long dataCount = companyService.countAllCompany(null);
		mav.addObject("clist", companyService.getCompanyList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * 公司新增校验
	 */
	/////////////////////////////////////////////////////////////////////////////////
	/**
	 * 校验公司代码是否存在
	 */
	@RequestMapping(value="verifyCompanyCode.html")
	public void verifyCompanyCode(HttpServletResponse response, String Code){
		int flag = 0;
		//通过查询代号判断公司是否存在
		CompanyModel company = companyService.getByCode(Code);
		//公司存在
		if(company!=null){
			flag = 1;
		//公司不存在
		} else {
			flag = 2;
		}
		PublicMethod.objectToJson(flag, response);
	}
	
	
	
	/**
	 * 校验公司名称是否已经存在
	 * 
	 */
	@RequestMapping(value="verifyCompanyName.html")
	public void verifyCompanyName(HttpServletResponse response, String CompanyName){
		String cName;
		int flag = 0;
		try {
			//页面传来的值转换成utf-8
			cName = new String(CompanyName.getBytes("ISO8859-1"),"utf-8");
			//通过公司名称查询公司
			CompanyModel company = companyService.getByName(cName);
			//公司存在，则名称不可用
			if(company!=null){
				flag = 1;
			//公司不存在，则名称可用
			} else {
				flag = 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PublicMethod.objectToJson(flag, response);
		
	}
	
	
	/**
	 * 校验负责人电话是否存在
	 */
	@RequestMapping(value="verifyCompanyUserId.html" )
	public void verifyCompanyUserId(HttpServletResponse response, String UserId){
		int flag = 0;
		//判断该用户是否成立过公司
		CompanyModel company = companyService.getByUserId(UserId);
		//成立过
		if(company!=null){
			flag = 1;
		//没成立过
		} else {
			flag = 2;
		}
		
		PublicMethod.objectToJson(flag, response);
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 公司修改校验
	 */
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 修改公司代码校验
	 */
	@RequestMapping(value="modifyCompanyCode.html" )
	public void modifyCompanyCode(HttpServletResponse response,String Code){
		int flag = 0;
		//如果修改了，判断新公司代码是否可用
		CompanyModel company = companyService.getByCode(Code);
		//不可用
		if(company!=null){
			flag = 1;
		//可用
		} else {
			flag = 2;
		}
		PublicMethod.objectToJson(flag, response);
	}
	
	
	
	/**
	 * 修改公司名称校验
	 */
	@RequestMapping(value="modifyCompanyName.html")
	public void modifyCompanyName(HttpServletResponse response,String CompanyName){
		int flag = 0;
		//如果修改了，判断新公司名称是否可用
		CompanyModel company = companyService.getByName(CompanyName);
		//不可用
		if(company!=null){
			flag = 1;
		//可用
		} else {
			flag = 2; 
		}
		PublicMethod.objectToJson(flag, response);
	}
	
	
	/**
	 * 修改公司负责人校验
	 */
	@RequestMapping(value="modifyCompanyUserId.html")
	public void modifyCompanyUserId(HttpServletResponse response,String UserId){
		int flag = 0;
		//如果修改了，判断新的负责人电话是否存在
		CompanyModel company = companyService.getByUserId(UserId);
		//不可用
		if(company!=null){
			flag = 1;
		//可用
		} else {
			flag = 2;
		}
		PublicMethod.objectToJson(flag, response);
	}
	
	
	
	
}
