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
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.EquipmentTradModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.service.EquipmentService;
import com.fengyun.web.service.EquipmentTradService;
import com.fengyun.web.service.MerchantService;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.UserService;
import com.fengyun.web.util.PublicMethod;
import com.mongodb.BasicDBObject;

@Controller
public class EquipmentController {

	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private EquipmentTradService equipmentTradService;
	
	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private  HttpServletRequest request;
	
	/**
	 * 项目列表
	 * @param pagesize 第几页
	 * @return
	 */
	@RequestMapping(value="equipment_list",method=RequestMethod.GET)
	public ModelAndView equipmentlist(int pageNow,long dataCount,int pageSize){
		ModelAndView mav = new ModelAndView("/enterprise/equipment_list");
		if(dataCount == 0){
			dataCount = equipmentService.countAllEquipment(null);
		}
		mav.addObject("elist", equipmentService.getEquipmentList(null,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}
	
	@RequestMapping(value="equipment_list2",method=RequestMethod.POST)
	public ModelAndView equipmentlist2(){
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
		ModelAndView mav = new ModelAndView("/enterprise/equipment_list");
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
			dataCount = equipmentService.countAllEquipment(queryObj);
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
		
		mav.addObject("elist", equipmentService.getEquipmentList(queryObj,pageNow,pageSize));
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
	 * 设备商审核
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="equipment_pass",method=RequestMethod.GET)
	public ModelAndView equipmentPass(String id){
		EquipmentModel emodel =equipmentService.getById(id);
		if(emodel.getCode() != null){
			equipmentService.equipmentPass(id);
		}
		return toList();
	}
	
	@RequestMapping(value="equipment_add",method=RequestMethod.GET)
	public String equipmentAdd(){
		return "/enterprise/equipment_add";
	}
	
	
	/**
	 * 修改设备商
	 * @param id
	 * @return
	 */
	@RequestMapping(value="equipment_modify",method=RequestMethod.GET)
	public ModelAndView equipmentModify(String id){
		ModelAndView mav = new ModelAndView("/enterprise/equipment_modify");
		EquipmentModel model = equipmentService.getById(id);
		if(model != null)
			mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value="equipment_modify2",method=RequestMethod.POST)
	public ModelAndView equipmentModify2(){
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
			ModelAndView mav = new ModelAndView("/enterprise/equipment_modify");
			EquipmentModel model = equipmentService.getById(id);
			if(model != null)
				mav.addObject("model", model);
			return mav;
		}
		EquipmentModel emodel =equipmentService.getByCode(code);
		if(emodel != null && !emodel.getId().equals(id)){
			ModelAndView mav = new ModelAndView("/enterprise/equipment_modify");
			EquipmentModel model = equipmentService.getById(id);
			if(model != null)
				mav.addObject("model", model);
			return mav;
		}
		EquipmentModel model = equipmentService.getById(id);
		if(model != null){
			model.setName(name);
			model.setCode(code);
			model.setUserId(model.getUserId());
			model.setLeaderName(leaderName);
			model.setProvince(province);
			model.setCity(city);
			model.setStreet(street);
			model.setShopName(shopName);
			model.setLicence(licence);
			model.setRegcapital(regcapital);
			model.setEstablishDate(establishDate);
			equipmentService.updateEquipment(model);
		}
		
		ModelAndView mav = new ModelAndView("/enterprise/equipment_list");
		long dataCount = equipmentService.countAllEquipment(null);
		mav.addObject("elist", equipmentService.getEquipmentList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	/**
	 * 新增设备商
	 * @return
	 */
	@RequestMapping(value="equipment_add2",method=RequestMethod.POST)
	public ModelAndView equipmentAdd2(){
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String userId = request.getParameter("userId");
		String leaderName = request.getParameter("leaderName");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String shopName = request.getParameter("shopName");
		String licence = request.getParameter("licence");
		String regcapital = request.getParameter("regcapital");
		String establishDate = request.getParameter("establishDate");
		
		UserModel umodel = userService.getByUserId(userId);
		if(umodel == null){
			UserModel usmodel = new UserModel();
			usmodel.setUserId(userId);
			usmodel.setUserName(leaderName);
			usmodel.setUserPassword("123456");
			usmodel.setUserType("2");
			userService.addUser(usmodel);
			personService.initialPerson(userId);
		}
		EquipmentModel equipmentmodel = equipmentService.getByName(name);
		boolean bl = true;
		if(equipmentmodel != null){
			ModelAndView mav = new ModelAndView("/enterprise/equipment_add");
			bl=false;
			System.out.println("#####################:"+bl);
			mav.addObject("bl", bl);
			return mav;
		}	else{
			boolean bln = equipmentService.addEquipment(shopName,name, code, userId, leaderName, province, city, street,1,licence,regcapital,establishDate);
			EquipmentModel equipmentModel = equipmentService.getByName(name);
			if(equipmentModel!=null){
				merchantService.insertEquipment(equipmentModel);
			}
			
			//
			ModelAndView mav = new ModelAndView("/enterprise/equipment_list");
			long dataCount = equipmentService.countAllEquipment(null);
			mav.addObject("elist", equipmentService.getEquipmentList(null,1,0));
			mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
			return mav;
		}
	}
	
	/**
	 * 删除设备商
	 * @return
	 */
	@RequestMapping(value="equipment_del",method=RequestMethod.GET)
	public ModelAndView equipmentDel(String id){
		equipmentService.delEquipment(id);
		ModelAndView mav = new ModelAndView("/enterprise/equipment_list");
		long dataCount = equipmentService.countAllEquipment(null);
		mav.addObject("elist", equipmentService.getEquipmentList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	
	
	

	//////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 设备商出入库记录
	 */
	@RequestMapping(value="equipmentTrad_list",method=RequestMethod.GET)
	public ModelAndView equipmentTradlist(int pageNow,long dataCount,int pageSize){
		ModelAndView mav = new ModelAndView("/enterprise/equipmentTrad_list");
		if(dataCount == 0){
			dataCount = equipmentTradService.countAllEquipmentTrad(null);
		}
		mav.addObject("etlist", equipmentTradService.getEquipmentTradList(null,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		return mav;
	}
	
	@RequestMapping(value="equipmentTrad_list2",method=RequestMethod.POST)
	public ModelAndView equipmentTradlist2(){
		return toTradList();
	}
	
	
	private ModelAndView toTradList(){
		String eName = request.getParameter("eName");
		String pName = request.getParameter("pName");
		String principal = request.getParameter("principal");
		String year = request.getParameter("YYYY");
		String month = request.getParameter("MM");
		String day = request.getParameter("DD");
		ModelAndView mav = new ModelAndView("/enterprise/equipmentTrad_list");
		long dataCount = 0;
		
		BasicDBObject queryObj = new BasicDBObject();
		if(StringUtils.isNotBlank(eName)){
			queryObj.put("eName", eName);
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
			dataCount = equipmentTradService.countAllEquipmentTrad(queryObj);
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
		
		mav.addObject("etlist", equipmentTradService.getEquipmentTradList(queryObj,pageNow,pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));
		
		mav.addObject("name", eName);
		mav.addObject("pName", pName);
		mav.addObject("principal", principal);
		mav.addObject("year", year);
		mav.addObject("month", month);
		mav.addObject("day", day);
		return mav;
	}
	
	
	/**
	 * 新增出入库记录
	 */
	@RequestMapping(value="equipmentTrad_add",method=RequestMethod.GET)
	public String equipmentTradAdd(){
		return "/enterprise/equipmentTrad_add";
	}
	
	
	@RequestMapping(value="equipmentTrad_add2",method=RequestMethod.POST)
	public ModelAndView equipmentTradAdd2(){
		//获取设备商的机构代码
		String code =request.getParameter("code");
		EquipmentModel  model = equipmentService.getByCode(code);
		String eId;
		if(model !=null){
			 eId  =model.getId();
		}else{
			ModelAndView mav = new ModelAndView("/enterprise/equipmentTrad_add");
			return mav;
		}
		//获取项目代号
		String pCode = request.getParameter("pCode");
		ProjectModel  model2 = projectService.getByPCode(pCode);
		String pId;
		if(model2 !=null){
			pId =model2.getId();
		}else {
			ModelAndView mav = new ModelAndView("/enterprise/equipmentTrad_add");
			return mav;
		}
		String eName = request.getParameter("eName");
		String pName = request.getParameter("pName");
		String toolName = request.getParameter("toolName");
		String principal = request.getParameter("principal");
		String year = request.getParameter("YYYY");
		String month = request.getParameter("MM");
		String day = request.getParameter("DD");
		int thisrent;
		if("".equals(request.getParameter("thisrent"))){
			thisrent = 0;
		} else {
			thisrent = Integer.parseInt(request.getParameter("restpay"));
		}
		int allrent;
		if("".equals(request.getParameter("allrent"))){
			allrent = 0;
		} else {
			allrent = Integer.parseInt(request.getParameter("allrent"));
		}
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
		boolean bln = equipmentTradService.addEquipmentTrad(eId,pId,eName,pName,toolName,principal,year,month,day,thisrent,allrent,thispay,culapay,otherpay,restpay,invoice,note,drawee,payment,serial);
		ModelAndView mav = new ModelAndView("/enterprise/equipmentTrad_list");
		long dataCount = equipmentTradService.countAllEquipmentTrad(null);
		mav.addObject("etlist", equipmentTradService.getEquipmentTradList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	
	/**
	 * 通过项目id和设备商id查询
	 */
	
	@RequestMapping(value="equipmentTrad_form",method=RequestMethod.GET)
	public ModelAndView equipmentTradForm(String id, String pId){
		String eId=id;
		System.out.println("+++++++++++++++++++++"+id);
		
		ProjectModel pmodel  =projectService.getById(pId);
		String name = pmodel.getName();
		System.out.println("+++++++++++++++++++++"+name);
		EquipmentModel emodel = equipmentService.getById(id);
		ModelAndView mav = new ModelAndView("/enterprise/equipmentTrad_form");
		List<EquipmentTradModel> list=equipmentTradService.getByEId(pId,eId);
		mav.addObject("etlist", list);
		mav.addObject("pmodel", pmodel);
		mav.addObject("emodel", emodel);
		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 删除设备商出入库记录
	 * @return
	 */
	@RequestMapping(value="equipmentTrad_del",method=RequestMethod.GET)
	public ModelAndView equipmentTradDel(String id){
		equipmentTradService.delEquipmentTrad(id);
		ModelAndView mav = new ModelAndView("/enterprise/equipmentTrad_list");
		long dataCount = equipmentTradService.countAllEquipmentTrad(null);
		mav.addObject("etlist", equipmentTradService.getEquipmentTradList(null,1,0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
	
	
	//////////////////////////////////////////////////////
	/**
	 * 后台设备商新增校验
	 */
	///////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="verifyEquipmentCode.html")
	public void verifyMaterialCode(HttpServletResponse response, String Code){
		int flag = 0;
		//判断该材料商编号是否存在 
		EquipmentModel equipment = equipmentService.getByCode(Code);
		//存在
		if(equipment!=null){
			flag = 1;
		//不存在
		} else {
			flag = 2;
		}
		
		PublicMethod.objectToJson(flag, response);
		
	}
	/**
	 * 校验设备商负责人电话
	 * 
	 */
	@RequestMapping(value="verifyEquipmentUserId.html")
	public void verifyEquipmentUserId(HttpServletResponse response, String UserId){
		int flag = 0;
		//判断该材料商编号是否存在 
		EquipmentModel equipment = equipmentService.getByUserId(UserId);
		//存在
		if(equipment!=null){
			flag = 1;
		//不存在
		} else {
			flag = 2;
		}
		
		PublicMethod.objectToJson(flag, response);
		
	}
	
	/**
	 * 校验设备商名称是否已经存在
	 * 
	 */
	@RequestMapping(value="verifyEquipmentName.html")
	public void verifyEquipmentName(HttpServletResponse response, String Name){
		String equipmentName;
		int flag = 0;
		try {
			//页面传来的值转换成utf-8
			equipmentName = new String(Name.getBytes("ISO8859-1"),"utf-8");
			//通过材料商名称查询
			EquipmentModel equipment = equipmentService.getByName(equipmentName);
			//材料商存在，则名称不可用
			if(equipment!=null){
				flag = 1;
			//材料商不存在，则名称可用
			} else {
				flag = 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PublicMethod.objectToJson(flag, response);
	}
	

}
