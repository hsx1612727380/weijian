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
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.MaterialTradModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.service.MaterialService;
import com.fengyun.web.service.MaterialTradService;
import com.fengyun.web.service.MerchantService;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.UserService;
import com.fengyun.web.util.PublicMethod;
import com.mongodb.BasicDBObject;

@Controller
public class MaterialController {

	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MaterialTradService materialTradService;
	
	@Autowired
	private  HttpServletRequest request;
	
	/**
	 * 
	 * @param pagesize 第几页
	 * @return
	 */
	@RequestMapping(value="material_list",method=RequestMethod.GET)
	public ModelAndView materiallist(int pageNow,long dataCount,int pageSize){
		ModelAndView mav = new ModelAndView("/enterprise/material_list");
		if(dataCount == 0){
			dataCount = materialService.countAllMaterial(null);
		}
		mav.addObject("mlist", materialService.getMaterialList(null,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}
	
	@RequestMapping(value="material_list2",method=RequestMethod.POST)
	public ModelAndView materiallist2(){
		return toList();
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
		ModelAndView mav = new ModelAndView("/enterprise/material_list");
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
//			Pattern pattern = Pattern.compile(".*" + leaderName  + ".*",Pattern.CASE_INSENSITIVE);
//			queryObj.put("leaderName", pattern);
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
			dataCount = materialService.countAllMaterial(queryObj);
//		}else{
//			dataCount = Integer.valueOf(dataCountStr);
//		}
		String pageNowStr = request.getParameter("pageNow");
		System.out.println("pageNow:" + pageNowStr);
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 0;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		mav.addObject("mlist", materialService.getMaterialList(queryObj,pageNow,pageSize));
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
	 * 审核材料商
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="material_pass",method=RequestMethod.GET)
	public ModelAndView materialPass(String id){
		MaterialModel mmodel =materialService.getById(id);
		if(mmodel.getCode() != null){
			materialService.materialPass(id);
		}
		return toList();
	}
	
	@RequestMapping(value="material_add",method=RequestMethod.GET)
	public String materialAdd(){
		return "/enterprise/material_add";
	}
	
	
	
	
	/**
	 * 修改材料商
	 * @param id
	 * @return
	 */
	@RequestMapping(value="material_modify",method=RequestMethod.GET)
	public ModelAndView material(String id){
		ModelAndView mav = new ModelAndView("/enterprise/material_modify");
		MaterialModel model = materialService.getById(id);
		if(model != null)
			mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value="material_modify2",method=RequestMethod.POST)
	public ModelAndView materialModify2(){
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String leaderName = request.getParameter("leaderName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String shopName = request.getParameter("shopName");
		String licence = request.getParameter("licence");
		String regcapital = request.getParameter("regcapital");
		String establishDate = request.getParameter("establishDate");
		if(StringUtils.isBlank(code)){
			ModelAndView mav = new ModelAndView("/enterprise/material_modify");
			MaterialModel model = materialService.getById(id);
			if(model != null)
				mav.addObject("model", model);
			return mav;
		}
		MaterialModel mmodel =materialService.getByCode(code);
		if(mmodel != null && !mmodel.getId().equals(id)){
			ModelAndView mav = new ModelAndView("/enterprise/material_modify");
			MaterialModel model = materialService.getById(id);
			if(model != null)
				mav.addObject("model", model);
			return mav;
		}
		MaterialModel model = materialService.getById(id);
		if(model != null){
			model.setName(name);
			model.setCode(code);
			model.setUserId(model.getUserId());
			model.setLeaderName(leaderName);
			model.setProvince(province);
			model.setCity(city);
			model.setShopName(shopName);
			model.setStreet(street);
			model.setLicence(licence);
			model.setRegcapital(regcapital);
			model.setEstablishDate(establishDate);
			materialService.updateMaterial(model);
		}
		
		ModelAndView mav = new ModelAndView("/enterprise/material_list");
		long dataCount = materialService.countAllMaterial(null);
		mav.addObject("mlist", materialService.getMaterialList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	/**
	 * 新增材料商
	 * @return
	 */
	@RequestMapping(value="material_add2",method=RequestMethod.POST)
	public ModelAndView materialAdd2(){
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String userId = request.getParameter("userId");
		String leaderName = request.getParameter("leaderName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String shopName = request.getParameter("shopName");
		//后来添加的3个字段
		String licence = request.getParameter("licence");
		String regcapital = request.getParameter("regcapital");
		String establishDate = request.getParameter("establishDate");
		UserModel umodel = userService.getByUserId(userId);
		if(umodel == null){
			UserModel usmodel = new UserModel();
			usmodel.setUserId(userId);
			usmodel.setUserName(leaderName);
			usmodel.setUserPassword("123456");
			usmodel.setUserType("1");
			userService.addUser(usmodel);
			personService.initialPerson(userId);
		}
		MaterialModel materialmodel = materialService.getByName(name);
		boolean bl = true;
		if(materialmodel != null){
			ModelAndView mav = new ModelAndView("/enterprise/material_add");
			bl=false;
			System.out.println("#####################:"+bl);
			mav.addObject("bl", bl);
			return mav;
		}
		boolean bln = materialService.addMaterial(shopName, name, code,licence,regcapital,establishDate, userId, leaderName, province, city, street,1);
		MaterialModel materialModel = materialService.getByName(name);
		if(materialModel!=null){
			merchantService.insertMaterial(materialModel);
		}
		ModelAndView mav = new ModelAndView("/enterprise/material_list");
		long dataCount = materialService.countAllMaterial(null);
		mav.addObject("mlist", materialService.getMaterialList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	/**
	 * 删除材料商
	 * @return
	 */
	@RequestMapping(value="material_del",method=RequestMethod.GET)
	public ModelAndView materialDel(String id){
		materialService.delMaterial(id);
		ModelAndView mav = new ModelAndView("/enterprise/material_list");
		long dataCount = materialService.countAllMaterial(null);
		mav.addObject("mlist", materialService.getMaterialList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	
	//////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 材料商出入库记录
	 */
	
	@RequestMapping(value="materialTrad_list",method=RequestMethod.GET)
	public ModelAndView materialTradlist(int pageNow,long dataCount,int pageSize){
		ModelAndView mav = new ModelAndView("/enterprise/materialTrad_list");
		if(dataCount == 0){
			dataCount = materialTradService.countAllMaterialTrad(null);
		}
		mav.addObject("mtlist", materialTradService.getMaterialTradList(null,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}
	
	@RequestMapping(value="materialTrad_list2",method=RequestMethod.POST)
	public ModelAndView materialTradlist2(){
		return toTradList();
	}
	
	
	private ModelAndView toTradList(){
		String mName = request.getParameter("mName");
		String pName = request.getParameter("pName");
		String principal = request.getParameter("principal");
		String year = request.getParameter("YYYY");
		System.out.println("++++++++++++++++++++++"+year);
		String month = request.getParameter("MM");
		System.out.println("++++++++++++++++++++++"+month);
		String day = request.getParameter("DD");
		System.out.println("++++++++++++++++++++++"+day);
		ModelAndView mav = new ModelAndView("/enterprise/materialTrad_list");
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(mName)){
			queryObj.put("mName", mName);
		}
		if(StringUtils.isNotBlank(pName)){
			queryObj.put("pName", pName);
		}
		if(StringUtils.isNotBlank(principal)){
			queryObj.put("principal", principal);
		}
		if(StringUtils.isNotBlank(year)){
			queryObj.put("year", year);
		}
		if(StringUtils.isNotBlank(month)){
			queryObj.put("month", month);
		}
		if(StringUtils.isNotBlank(day)){
			queryObj.put("day", day);
		}
		if(queryObj.size() <= 0)
			queryObj = null;
			dataCount = materialTradService.countAllMaterialTrad(queryObj);
		String pageNowStr = request.getParameter("pageNow");
		System.out.println("pageNow:" + pageNowStr);
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 0;
		int pageNow = 0;
		if(StringUtils.isNotBlank(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		if(StringUtils.isNotBlank(pageNowStr)){
			pageNow = Integer.valueOf(pageNowStr);
		}
		
		mav.addObject("mtlist", materialTradService.getMaterialTradList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("mName", mName);
		mav.addObject("pName", pName);
		mav.addObject("principal", principal);
		mav.addObject("YYYY", year);
		mav.addObject("MM", month);
		mav.addObject("DD", day);
		return mav;
	}
	
	/**
	 * 新增出入库记录
	 */
	@RequestMapping(value="materialTrad_add",method=RequestMethod.GET)
	public String materialTradAdd(){
		return "/enterprise/materialTrad_add";
	}
	
	
	@RequestMapping(value="materialTrad_add2",method=RequestMethod.POST)
	public ModelAndView materialTradAdd2(){
		//获取材料商的机构代码
		String code =request.getParameter("code");
		
		MaterialModel  model = materialService.getByCode(code);
		String mCode;
		if(model !=null){
			 mCode  =model.getId();
		}else{
			ModelAndView mav = new ModelAndView("/enterprise/materialTrad_add");
			return mav;
		}
		//获取项目代号
		String pCode = request.getParameter("pCode");
		ProjectModel  model2 = projectService.getByPCode(pCode);
		String pId;
		if(model2 !=null){
			pId =model2.getId();
		}else {
			ModelAndView mav = new ModelAndView("/enterprise/materialTrad_add");
			return mav;
		}
		String mName = request.getParameter("mName");
		String pName = request.getParameter("pName");
		String itemName = request.getParameter("itemName");
		String principal = request.getParameter("principal");
		String year = request.getParameter("YYYY");
		String month = request.getParameter("MM");
		String day = request.getParameter("DD");
		String outTime = request.getParameter("outTime");
		String outNum = request.getParameter("outNum");
		String allease = request.getParameter("allease");
		
		int thispay;
		if("".equals(request.getParameter("thispay"))){
			thispay = 0;
		} else {
			thispay = Integer.parseInt(request.getParameter("thispay"));
		}
		int culapay;
		if("".equals(request.getParameter("culapay"))){
			culapay = 0;
		} else {
			culapay = Integer.parseInt(request.getParameter("culapay"));
		}
		int otherpay;
		if("".equals(request.getParameter("otherpay"))){
			otherpay = 0;
		} else {
			otherpay = Integer.parseInt(request.getParameter("otherpay"));
		}
		int restpay;
		if("".equals(request.getParameter("restpay"))){
			restpay = 0;
		} else {
			restpay = Integer.parseInt(request.getParameter("restpay"));
		}
		String invoice = request.getParameter("invoice");
		String note = request.getParameter("note");
		String drawee = request.getParameter("drawee");
		String payment = request.getParameter("payment");
		String serial = request.getParameter("serial");
		boolean bln = materialTradService.addMaterialTrad(mCode,pId,mName,pName,itemName,principal,year,month,day,outTime,outNum,allease,thispay,culapay,otherpay,restpay,invoice,note,drawee,payment,serial);
		ModelAndView mav = new ModelAndView("/enterprise/materialTrad_list");
		long dataCount = materialTradService.countAllMaterialTrad(null);
		mav.addObject("mtlist", materialTradService.getMaterialTradList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	/**
	 * 通过项目id和材料商id查询
	 */
	
	@RequestMapping(value="materialTrad_form",method=RequestMethod.GET)
	public ModelAndView materialTradForm(String id, String pId){
		String mId=id;
		System.out.println("+++++++++++++++++++++"+pId);
		ProjectModel pmodel  =projectService.getById(pId);
		String name = pmodel.getName();
		System.out.println("+++++++++++++++++++++"+name);
		MaterialModel mmodel = materialService.getById(id);
		ModelAndView mav = new ModelAndView("/enterprise/materialTrad_form");
		List<MaterialTradModel> list=materialTradService.getByMId(pId,mId);
		mav.addObject("mtlist", list);
		mav.addObject("pmodel", pmodel);
		mav.addObject("mmodel", mmodel);
		
		return mav;
	}
	
	
	
	
	
	/**
	 * 删除材料商出入库记录
	 * @return
	 */
	@RequestMapping(value="materialTrad_del",method=RequestMethod.GET)
	public ModelAndView materialTradDel(String id){
		materialTradService.delMaterialTrad(id);
		ModelAndView mav = new ModelAndView("/enterprise/materialTrad_list");
		long dataCount = materialTradService.countAllMaterialTrad(null);
		mav.addObject("mtlist", materialTradService.getMaterialTradList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	//////////////////////////////////////////////////////
	/**
	 * 后台材料商新增校验
	 */
	///////////////////////////////////////////////////////////////////////////////////
	/**
	 * 校验材料商code
	 * 
	 */
	@RequestMapping(value="verifyMaterialCode.html")
	public void verifyMaterialCode(HttpServletResponse response, String Code){
		int flag = 0;
		//判断该材料商编号是否存在 
		MaterialModel material = materialService.getByCode(Code);
		//存在
		if(material!=null){
			flag = 1;
		//不存在
		} else {
			flag = 2;
		}
		
		PublicMethod.objectToJson(flag, response);
		
	}
	
	/**
	 * 校验材料商负责人电话
	 * 
	 */
	@RequestMapping(value="verifyMaterialUserId.html")
	public void verifyMaterialUserId(HttpServletResponse response, String UserId){
		int flag = 0;
		//判断该材料商编号是否存在 
		MaterialModel material = materialService.getByUserId(UserId);
		//存在
		if(material!=null){
			flag = 1;
		//不存在
		} else {
			flag = 2;
		}
		
		PublicMethod.objectToJson(flag, response);
		
	}
	
	/**
	 * 校验材料商名称是否已经存在
	 * 
	 */
	@RequestMapping(value="verifyMaterialName.html")
	public void verifyMaterialName(HttpServletResponse response, String Name){
		String materialName;
		int flag = 0;
		try {
			//页面传来的值转换成utf-8
			materialName = new String(Name.getBytes("ISO8859-1"),"utf-8");
			//通过材料商名称查询
			MaterialModel material = materialService.getByName(materialName);
			//材料商存在，则名称不可用
			if(material!=null){
				flag = 1;
			//材料商不存在，则名称可用
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
