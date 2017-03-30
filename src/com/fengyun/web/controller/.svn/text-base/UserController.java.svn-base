package com.fengyun.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.cache.SysData;
import com.fengyun.web.cache.page.PageHandler;
import com.fengyun.web.db.playermodel.CommentsModel;
import com.fengyun.web.db.playermodel.CompanyModel;
import com.fengyun.web.db.playermodel.MessageModel;
import com.fengyun.web.db.playermodel.NoticeLogModel;
import com.fengyun.web.db.playermodel.NoticeModel;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.hardcode.ESessionKey;
import com.fengyun.web.service.CommentsService;
import com.fengyun.web.service.CompanyService;
import com.fengyun.web.service.EquipmentService;
import com.fengyun.web.service.MaterialService;
import com.fengyun.web.service.MerchantService;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.TeamMemberService;
import com.fengyun.web.service.TeamService;
import com.fengyun.web.service.UserService;
import com.fengyun.web.service.NoticeService;
import com.fengyun.web.service.NoticeLogService;
import com.fengyun.web.service.MessageService;
import com.fengyun.web.util.PublicMethod;
import com.mongodb.BasicDBObject;

/***
 *软凯
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private MaterialService materialService;

	@Autowired
	private CommentsService commentsService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private PersonService personService;
	
	@Autowired 
	private NoticeService noticeService;
	
	@Autowired
	private NoticeLogService noticeLogService;
	
	@Autowired
	private MessageService messageService;

	@Autowired
	public UserController(UserService service) {
		this.userService = service;
	}
	
	@Autowired
	public TeamService teamService;

	@Autowired
	public CompanyService companyService ;
	
	@Autowired
	public MerchantService merchantService ;
	
	@Autowired
	public TeamMemberService teamMemberService ;
	
	/**
	 * 跳转到登录页面-zss
	 * @return login.jsp
	 */
	@RequestMapping(value = "toLogin.html")
	public String toLogin() {
		return "login";
	}
	
	
	/**
	 * 用户登录 -zss
	 * 注解配置，只允许POST提交到该方法
	 * @param userId
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "login.html",method=RequestMethod.POST )
	public void userLogin( String userId, String password,HttpServletResponse response) {
		userId = userId.replace(" ","");//去除空格
		password = password.replace(" ","");//去除空格
		System.out.println("-----------------------------------------------:");
		System.out.println("userId:"+userId);
		Object obj=null;
		//根据usrid长度，11位的是手机号码，18位的是身份证号码
		if(userId.length()==11)
		{ 
			obj= userService.checkLogonByPhone(userId, password);//向service中查询出用户是否存在，如果存在返回 用户对象
		}
		if(userId.length()==18)
		{ 
			obj= userService.checkLogonByIdentity(userId, password);//向service中查询出用户是否存在，如果存在返回 用户对象
		}
		//通过用户id （电话号码）到TeamModel中查询出该用户是否是班组长
		TeamModel teamModel = teamService.getTeamModelByUserId(userId);
		TeamMemberModel teamMember = teamMemberService.userIdExistInTeam(userId, null, 3);
		System.out.println("UserController中的userLogin方法查到用户信息："+obj+"   查到teamModel信息："+teamModel);//调试打印语句 
		try {
			//根据用户类型和登录成功与否做标记分别返回到Session中和和写回页面
			writeBack(response, obj, teamModel,teamMember);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 返回登录状态标记 和 登录用户（用户在session中）
	 * 设置四种整型标记 type	：普通用户--0		材料商--1		设备商--2		公司--3	项目操作员--4
	 * 是否为班组长 标记 ；String isLeader="0"  	非班组长、非班组成员--0（默认）		是班组长--1   	是班组成员、非班组长--2
	 * @param response , Object obj是查询到的用户的model
	 * @throws IOException
	 * respData 作为ajax请求的返回数据 data 数据内容为"1"标记用户登录成功,为"0"标记用户登录失败。
	 */
	private void writeBack(HttpServletResponse response ,Object obj, TeamModel teamModel,TeamMemberModel teamMember) throws IOException {
		String respData = "1";//代表登录成功（默认）
		String isLeader = "0"; //是否是班长 标记(0:非班组长，非班组成员，1：是班组长，2：班组成员，但非班组长)
		PrintWriter out = response.getWriter();
		if(obj!=null )
		{	
			//判断是公司登录还是个人登录，并把用户名和userId和用户类型标记--type 存入到 session中
			if(obj instanceof CompanyModel){
				CompanyModel user = (CompanyModel)obj;
				user.setLastLogin(new Date());//更新最后登录时间
				user.setLoginTimes(user.getLoginTimes()+1);//登录次数加一
				companyService.updateCompany(user);		//更新用户最后登录时间和登录次数字段
				
				System.out.println("公司用户登录！"+"用户名是："+user.getName()+"--用户id是："+user.getUserId()+"--用户类型是："+user.getType());
				request.getSession().setAttribute(ESessionKey.UserId.key,user.getUserId());//将用户id存放到session中，作为已登录标记
				request.getSession().setAttribute(ESessionKey.UserName.key, user.getName()); //将用户名存放到request中，传递到前台
				request.getSession().setAttribute(ESessionKey.UserType.key,"3"); // type :3 公司用户标记。  如果调用user.getType()可以获取到公司类型名
				request.getSession().setAttribute(ESessionKey.IsLeader.key, isLeader);		 	 //是班组长标记 是 （"1"）/ 否（"0"）
				request.getSession().setMaxInactiveInterval(1 * 60 * 60); 	//设置登录过期时间一个小时
				
			}else{
				if(teamModel!=null)//如果查到了相应的班组model说明该用户是班组长
				{
					isLeader = "1";
					request.getSession().setAttribute(ESessionKey.TeamCode.key,teamModel.getCode());
				}else if(teamModel==null&&teamMember!=null){//如果teamModel为0，但teamMember不为0，说明是班组成员，非班组长
					isLeader = "2";
				}
				UserModel user = (UserModel)obj;
				
				user.setLastLogin(new Date());//更新最后登录时间
				user.setLoginTimes(user.getLoginTimes()+1);//登录次数加一
				userService.updateUser(user); 			//更新用户最后登录时间和登录次数字段
				
				System.out.println("普通用户登录！"+"用户名是："+user.getUserName()+"--用户id是："+user.getUserId()
						+"--用户类型是："+user.getUserType()+"--isLeader: "+isLeader);
				request.getSession().setAttribute(ESessionKey.UserId.key,user.getUserId());//将用户id存放到session中，作为已登录标记
				request.getSession().setAttribute(ESessionKey.UserName.key, user.getUserName()); //将用户名存放到request中，传递到前台
				request.getSession().setAttribute(ESessionKey.UserType.key, user.getUserType()); //将用户类型存入到session中
				request.getSession().setAttribute(ESessionKey.IsLeader.key, isLeader);		 	 //是班组长标记 是 （"1"）/ 否（"0"），班组成员非班组长（"2"）
			}
		}else{
			respData = "0";//代表登录失败
		}
		out.write(respData); //out.print(respData);也可以使用  
		out.flush();
		out.close();
	}
	
	/**
	 * 校验用户是否存在
	 */
	@RequestMapping(value="isUser.html")
	public void isUser(String userId,HttpServletResponse response){
		userId = userId.replace(" ","");
		UserModel user = userService.getByUserId(userId);
		CompanyModel company = companyService.getByUserId(userId);
		String data = "0";
		if(user!=null||company!=null){
			data="1";
		}
		PublicMethod.stringToWeb(data, response);
	}
	
	/**
	 * 用户注销登录-zss
	 * @return
	 */
	@RequestMapping("logout")
	public ModelAndView logout() {
		request.getSession().invalidate();
		////创建模型跟视图，用于渲染页面。并且指定要返回的页面为home页面 
		ModelAndView mav = new ModelAndView("index");
		//缓存首页数据
		mav.addObject("companys",SysData.getIndexPage().getCompanys());//公司
		mav.addObject("projects",SysData.getIndexPage().getProjects());//项目
		mav.addObject("t2ulist",SysData.getIndexPage().getT2ulist());// 班组招聘
		mav.addObject("p2tlist",SysData.getIndexPage().getP2tlist());// 项目招聘施工班组
		mav.addObject("u2tlist",SysData.getIndexPage().getU2tlist());// 个人求职
		mav.addObject("t2plist",SysData.getIndexPage().getT2plist());// 班组求职
		mav.addObject("p2mlist",SysData.getIndexPage().getP2mlist());// 材料采购
		mav.addObject("p2elist",SysData.getIndexPage().getP2elist());// 设备租赁
		mav.addObject("m2plist",SysData.getIndexPage().getM2plist());// 材料供应
		mav.addObject("e2plist",SysData.getIndexPage().getE2plist());// 设备供应
		
		return mav;
	}


	/**
	 * 查询出用户列表
	 * @return
	 */
	@RequestMapping("listUser")
	public ModelAndView listUser() {
		ModelAndView mav = new ModelAndView("user/user_list");
		List<UserModel> userList = userService.listUser(0, 0);
		System.out.println("userList.size():" + userList.size());
		return mav;
	}



	/**
	 * 跳转到注册页面
	 * @return
	 */
	@RequestMapping("from_RegFrom.html")
	public String fromRegFrom() {
		return "reg";
	}
	

	/**
	 * 用户注册
	 * 
	 * @param userModel
	 * @return
	 */
	@RequestMapping("front_user_register.html")
	public String frontUserRegister(UserModel model) {
		model.setCreateTime(new Date());
		HttpSession session =request.getSession();
		userService.addUser(model);
		session.setAttribute("user", model);
		session.setAttribute(ESessionKey.UserId.key,model.getUserId());//将用户id存放到session中，作为已登录标记
		session.setAttribute(ESessionKey.UserType.key,model.getUserType()); // type :3 公司用户标记。  如果调用user.getType()可以获取到公司类型名
		session.setAttribute(ESessionKey.IsLeader.key, "0");		 	 //是班组长标记 是 （"1"）/ 否（"0"），班组成员非班组长（"2"）
		session.setAttribute(ESessionKey.UserName.key, model.getUserName());		 	 //用户名
		
		String userId = model.getUserId();
		Map<String, String> map = noticeService.getNMCount(userId);
		request.getSession().setAttribute("count", map.get("count"));
		request.getSession().setAttribute("unReadMessageCount", map.get("unReadMessageCount"));
		request.getSession().setAttribute("readMessageCount", map.get("readMessageCount"));
		request.getSession().setAttribute("unReadNoticeCount", map.get("unReadNoticeCount"));
		request.getSession().setAttribute("readNoticeCount", map.get("readNoticeCount"));
		
		if((model.getUserType()).equals("0")){//如果是个人（工人、施工班组）
			personService.initialPerson(model.getUserId());		//初始化 诚信档案表
//			return "redirect:person.html";
		}else if(model.getUserType().equals("1")){				//初始化material表
			materialService.initialMaterial(model);				//初始化基本信息
			merchantService.initialMerchant(model,session);		//初始化诚信档案
			return "redirect:material/info.html";		//跳转到填写基本信息页面
		}else if(model.getUserType().equals("2")){			//初始化equipment表
			equipmentService.initialEquipment(model);			//初始化基本信息
			merchantService.initialMerchant(model,session);		//初始化诚信档案
			return "redirect:equipment/info.html";			//跳转到填写基本信息页面
		}
//		return "index.html";
		
		return "redirect:person.html";
		//return mav;
	}

	/**
	 * 检查用户手机号是否注册过
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("mobilRepCHeck.html")
	public void mobilRepCHeck(String userId, HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();
		out.print(userService.mobilRepCHeck(userId));
		out.flush();
		out.close();
	}

	/**
	 * 用戶列表
	 * @param pagesize 第几页
	 * @return
	 */
	@RequestMapping(value="user_list",method=RequestMethod.GET)
	public ModelAndView userlist(int pageNow,long dataCount,int pageSize){
		ModelAndView mav = new ModelAndView("/user/user_list");
		if(dataCount == 0){
			dataCount = userService.countAllUser(null);
		}
		mav.addObject("ulist", userService.getUserList(null,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}
	
	/**
	 * 用户列表提交
	 * @return
	 */
	@RequestMapping(value="user_list_submit",method=RequestMethod.POST)
	public ModelAndView userlistSubmit(){
		return toList();
	}
	
	/**
	 * 返回查询列表
	 * @return
	 */
	private ModelAndView toList(){
		String userName = request.getParameter("name");
		String userId = request.getParameter("uId");
		String skillSmallType = request.getParameter("skillSmallType");
		String userStatus = request.getParameter("userStatus");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		ModelAndView mav = new ModelAndView("/user/user_list");
//		String dataCountStr = request.getParameter("dataCount");
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(userName)){
			queryObj.put("userName", userName);
		}
		if(StringUtils.isNotBlank(userId)){
			queryObj.put("userId", userId);
		}
		if(StringUtils.isNotBlank(skillSmallType)){
			queryObj.put("skillSmallType", skillSmallType);
		}
		if(StringUtils.isNotBlank(userStatus)){
			queryObj.put("userStatus", userStatus);
		}
		if(StringUtils.isNotBlank(province)){
			queryObj.put("userProvince", province);
		}
		if(StringUtils.isNotBlank(city)){
			queryObj.put("userCity", city);
		}
		if(queryObj.size() <= 0)
			queryObj = null;
		
		dataCount = userService.countAllUser(queryObj);

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
		
		mav.addObject("ulist", userService.getUserList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		mav.addObject("name", userName);
		mav.addObject("skillSmallType", skillSmallType);
		mav.addObject("uId", userId);
		mav.addObject("userStatus", userStatus);
		mav.addObject("province", province);
		mav.addObject("city", city);
		return mav;
	}
	
	@RequestMapping(value="user_add",method=RequestMethod.GET)
	public String userAdd(){
		return "/user/user_add";
	}
	
	/**
	 * 管理员新增用户
	 * @return
	 */
	@RequestMapping(value="user_add_submit",method=RequestMethod.POST)
	public ModelAndView userAddSumbit(){
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userType = request.getParameter("userType");
		String userProvince = request.getParameter("userProvince");
		String userCity = request.getParameter("userCity");
		String userStreet = request.getParameter("userStreet");
		String userPassword = request.getParameter("userPassword");
		String userStatus = request.getParameter("userStatus");
		String userIdentity = request.getParameter("userIdentity");
		String skillBigType = request.getParameter("skillBigType");
		String skillSmallType = request.getParameter("skillSmallType");
		if(!userId.equals("(^[1][358][0-9]{9}$)")){
			ModelAndView mav = new ModelAndView("/user/user_add");
			return mav;
		}
		
		UserModel userModel = userService.getByUserId(userId);
		//判断手机号是否重复
		if(userModel == null){
			userModel = new UserModel();
			userModel.setUserId(userId);
			userModel.setUserName(userName);
			userModel.setUserType(userType);
			userModel.setUserProvince(userProvince);
			userModel.setUserCity(userCity);
			userModel.setUserStreet(userStreet);
			userModel.setUserPassword(userPassword);
			userModel.setUserStatus(userStatus);
			userModel.setUserIdentity(userIdentity);
			Calendar calendar = Calendar.getInstance();
			int year = calendar.get(calendar.YEAR); 
			System.out.println(year);
			int birthYear = Integer.valueOf(userIdentity.substring(6, 10)); 
			int age = year - birthYear;
			userModel.setAge(age);
			int bit17 = Integer.parseInt(userIdentity.substring(14,17));
			if(bit17>=0&&bit17%2==1){
				userModel.setUserSex("1"); //1--男 2--女
			}else{
				userModel.setUserSex("2");
			}
			
			
			if(StringUtils.isNotBlank(skillBigType))
				userModel.setSkillBigType(Integer.valueOf(skillBigType));
			if(StringUtils.isNotBlank(skillSmallType))
				userModel.setSkillSmallType(Integer.valueOf(skillSmallType));
			userService.addUser(userModel);
			
			if((userModel.getUserType()).equals("0")){//如果是个人（工人、施工班组）
				personService.initialPerson(userModel.getUserId());//初始化 诚信档案表
			}else if(userModel.getUserType().equals("1")){	//初始化material	表
				materialService.initialMaterial(userModel);
			}else if(userModel.getUserType().equals("2")){	//初始化equipment表
				equipmentService.initialEquipment(userModel);
			}
		}
		
		
		
		
		//
		ModelAndView mav = new ModelAndView("/user/user_list");
		long dataCount = userService.countAllUser(null);
		mav.addObject("ulist", userService.getUserList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	/**
	 * 删除项目
	 * @return
	 */
	@RequestMapping(value="user_del",method=RequestMethod.GET)
	public ModelAndView userDel(String id){
		userService.delUser(id);
		ModelAndView mav = new ModelAndView("/user/user_list");
		long dataCount = userService.countAllUser(null);
		mav.addObject("ulist", userService.getUserList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	/**
	 * 个人详细资料
	 * @return
	 */
	@RequestMapping(value="user_info",method=RequestMethod.GET)
	public ModelAndView userInfo(String userId){
		UserModel model = userService.getByUserId(userId);
		ModelAndView mav = new ModelAndView("/user/user_info");
		mav.addObject("model", model);
		//个人评价
		List<CommentsModel> comments = commentsService.getListByIdAndType(userId, 1);
		mav.addObject("comments",comments);
		return mav;
	}
}
