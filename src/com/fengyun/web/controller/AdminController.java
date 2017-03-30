package com.fengyun.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;


import javax.annotation.Resource;
import javax.management.MBeanException;
import javax.management.RuntimeOperationsException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.cache.page.PageHandler;
import com.fengyun.web.common.Config;

import com.fengyun.web.db.playermodel.AdminModel;
import com.fengyun.web.hardcode.ESessionKey;
import com.fengyun.web.service.AdminService;
import com.fengyun.web.util.PublicMethod;
import com.mongodb.BasicDBObject;
import com.opensymphony.xwork2.ActionContext;

@Controller
//@RequestMapping("/adminController")
public class AdminController  {
	


//	public AdminController() throws MBeanException, RuntimeOperationsException {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	@Resource(name="adminService")
	private AdminService adminService;
	

	
	@Autowired
	private  HttpServletRequest request;
	
	
	
	@RequestMapping(value="/admin_index")
	public ModelAndView admin_index(){
		ModelAndView mav = new ModelAndView("/admin/admin_index");
		return mav;
		
	}

	@RequestMapping(value="/admin_right")
	public String admin_right(){
		return "/admin/admin_right";
		
	}
	
	@RequestMapping(value="/findLoginName")
	public void findLoginName(){
		System.out.println("111111111111111111");
		AdminModel adminModel=adminService.findLoginName("123456");
		System.out.println(adminModel.getName());
		
	}
	
	@RequestMapping(value="/savePersonUI",method=RequestMethod.GET)
	public ModelAndView savePersonUI(String userId){
		System.out.println("userId:" + userId);
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping("/adminLogin")
	public ModelAndView adminLogin(String accoutName,String password){
	      if(adminService.findLoginName(accoutName)!=null)
	      {
	    	  AdminModel adminModel=adminService.findPassword(accoutName,password);
	    	  if(adminModel!=null)
	    	  {
	    		  request.getSession().setAttribute("accoutName", accoutName);
	    		  ModelAndView mav = new ModelAndView("index");
	    		  return mav;
	    	  }
	      }
		  String failureMesg="密码或者账号错误！";
		  ModelAndView mavf = new ModelAndView(failureMesg);
		  return mavf;
	}
	
	@RequestMapping("admin_list.html")
	public ModelAndView addAdminSurevet(){
		return null;
	}
	
	
	   
	
	
	
	
	@RequestMapping("admin_addForm.html")
	public ModelAndView addAdminUI(){
		  ModelAndView mav= new ModelAndView("admin/admin_addForm");
		  return mav;
		}
	@RequestMapping("addAdmin")
	public String addAdmin(AdminModel adminModel){
		adminModel.setType("2");
		adminModel.setCreateTime(new Date());
	  adminService.addAdmin(adminModel);
	  return "redirect:/listAdmin.html?pageNow=1&pageSize=20&dataCount=0";
	}
//	@RequestMapping("searchAdminByName")
//	public String searchAdminByName(){
//	  String  name=request.getParameter("name");
//	  AdminModel admin=adminService.searchAdminByName(name);
//	  return "";
//	}
	@RequestMapping("listAdmin")
	public ModelAndView listAdmin()
			throws RuntimeOperationsException, MBeanException {
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(name)){
			queryObj.put("name", name);
		}
		if(StringUtils.isNotBlank(mobile)){
			queryObj.put("mobile", mobile);
		}
		queryObj.put("type", "2");
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
		
		long dataCount = adminService.countAllAdmin(queryObj);
		ModelAndView mav = new ModelAndView("admin/admin_list");
		mav.addObject("adminList", adminService.getAdminList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("name", name);
		mav.addObject("mobile", mobile);
		
		return mav;
	}
	/**
	 * 通過id刪除管理员
	 * 
	 * @param id
	 */
	@RequestMapping("delAdmin")
	public String delAdmin(String id){
		adminService.delAdmin(id);
		ModelAndView mav= new ModelAndView("admin/admin_list");
		return "redirect:/listAdmin.html?pageNow=1&pageSize=20&dataCount=0";
		}
	@RequestMapping("showAdmin.html")
	public ModelAndView showAdmin(String id){
		AdminModel admin=adminService.showAdmin(id);
		ModelAndView mav= new ModelAndView("admin/showAdmin");
		mav.addObject("admin",admin);
		return mav;
	}
	
	/**
	 * 更新管理员资料
	 * 更新管理员权限
	 * @param admin
	 * @return
	 */
	@RequestMapping("updateAdmin.html")
	public String updateAdmin(AdminModel admin){
		AdminModel admin1=adminService.findAdminById(admin.id);
		System.out.println(admin.name);
		admin1.setMobile(admin.mobile);
		admin1.setName(admin.name);
		admin1.setPassword(admin.password);
		admin1.setPopedom(admin.popedom);
		adminService.updateAdmin(admin1);
		ModelAndView mav= new ModelAndView("admin/showAdmin");
		mav.addObject("admin",admin1);
		return "redirect:/listAdmin.html?pageNow=1&pageSize=20&dataCount=0";
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////
	//管理员本人对自己信息的查询与修改
	////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 显示本人的基本信息及权限
	 */
	@RequestMapping("checkAdmin.html")
	public ModelAndView checkAdmin(String id){
		AdminModel admin = adminService.showAdmin(id);
		ModelAndView mav = new ModelAndView("admin/checkAdmin");
		mav.addObject("admin", admin);
		return mav;
	}
	
	
	/**
	 * 修改本人的基本信息
	 */
	@RequestMapping("showPersonAdmin.html")
	public ModelAndView showPersonAdmin(String id){
		AdminModel admin = adminService.showAdmin(id);
		System.out.print(admin.getaccountName());
		ModelAndView mav= new ModelAndView("admin/showPersonAdmin");
		mav.addObject("admin",admin);
		return mav;
	}
	
	
	
	@RequestMapping("updatePersonAdmin.html")
	public ModelAndView updatePersonAdmin(AdminModel admin){
		AdminModel admin1 = adminService.findAdminById(admin.id);
		admin1.setMobile(admin.mobile);
		admin1.setName(admin.name);
		admin1.setPassword(admin.password);
		adminService.updateAdmin(admin1);
		ModelAndView mav = new ModelAndView("admin/checkAdmin");
		mav.addObject("admin", admin1);
		return mav;
		
	}
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	//后台管理员登录
	////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 跳转到后台管理员登录页面
	 * @return login.jsp
	 */
	@RequestMapping(value = "toBackgroundLogin.html")
	public String toBackgroundLogin() {
//		ActionContext ac = ActionContext.getContext();
//		Map session = ac.getSession();
//		session.remove("accountName");
		return "background_login";
	}
	
	
	
	
	/**
	 * 管理员登录
	 * 注解配置，只允许POST提交到该方法
	 * @param admin
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "background_login.html",method=RequestMethod.POST )
	public void adminLogin( String accountName, String password,HttpServletResponse response) {
		accountName = accountName.replace(" ","");//去除空格
		password = password.replace(" ","");//去除空格
		System.out.print("账号是："+Config.getInstance().getAdminAccountName());
		//检验是管理员还是超级管理员
		//如果是超级管理员
		boolean bl = false;
		if(accountName.equals(Config.getInstance().getAdminAccountName())&& password.equals(Config.getInstance().getAdminPassword())){
			bl= true;
		}
		//如果是普通管理员
		Object obj=null;
		obj= adminService.checkLogonByAccountName(accountName, password);//向service中查询出管理员是否存在，如果存在返回 用户对象 
		try {
			//登录成功与否做标记分别返回到Session中和和写回页面
			writeBack(response, obj, bl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 返回登录状态标记 和 登录管理员（用管理员在session中）
	 * @param response , Object obj是查询到的管理员的model
	 * @throws IOException
	 * respData 作为ajax请求的返回数据 data 数据内容为"1"标记用户登录成功,为"0"标记用户登录失败。
	 */
	private void writeBack(HttpServletResponse response ,Object obj ,boolean bl) throws IOException {
		String respData = "1";//代表登录成功（默认）
		PrintWriter out = response.getWriter();
		if(obj!=null )
		{	
			AdminModel admin = (AdminModel)obj;
			request.getSession().setAttribute(ESessionKey.AdminId.key,admin.getId());
			request.getSession().setAttribute(ESessionKey.AccountName.key,admin.getAccountName());
			request.getSession().setAttribute(ESessionKey.AdminName.key,admin.getName());
			request.getSession().setAttribute(ESessionKey.AdminMobile.key,admin.getMobile());
			request.getSession().setAttribute(ESessionKey.AdminPopedom.key, admin.getPopedom());
		}else if(bl!= false){
			request.getSession().setAttribute(ESessionKey.AccountName.key,Config.getInstance().getAdminAccountName());
			request.getSession().setAttribute(ESessionKey.AdminPassword.key,Config.getInstance().getAdminPassword());
			request.getSession().setAttribute(ESessionKey.AdminName.key,Config.getInstance().getAdminName());
			request.getSession().setAttribute(ESessionKey.AdminMobile.key,Config.getInstance().getAdminMobile());
			request.getSession().setAttribute(ESessionKey.AdminPopedom.key, Config.getInstance().getAdminPopedom());
		}else {
			respData = "0";//代表登录失败
		}
		out.write(respData); //out.print(respData);也可以使用  
		out.flush();
		out.close();
	}
	
	
	
	
	/**
	 * 校验管理员是否存在
	 */
	@RequestMapping(value="isAdmin.html")
	public void isAdmin(String accountName,HttpServletResponse response){
		accountName = accountName.replace(" ","");
		AdminModel admin = adminService.getByAccountName(accountName);
		String data = "0";
		if(admin!=null){
			data="1";
		}
		PublicMethod.stringToWeb(data, response);
	}
	
	/**
	 * 管理员注销登录
	 * @return
	 */
	@RequestMapping("/backgroundlogout")
	public String backgroundlogout() {
		request.getSession().invalidate();
		return "background_login";
	}
	
	
	
	


	
}
