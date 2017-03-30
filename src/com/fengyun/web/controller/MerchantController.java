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
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.MerchantModel;
import com.fengyun.web.service.CommentsService;
import com.fengyun.web.service.EquipmentService;
import com.fengyun.web.service.MaterialService;
import com.fengyun.web.service.MerchantService;
import com.mongodb.BasicDBObject;

@Controller
public class MerchantController {

	@Autowired
	private MerchantService merchantService;

	@Autowired
	private CommentsService commentsService;

	@Autowired
	private MaterialService materialService;

	@Autowired
	private EquipmentService equipmentService;

	@Autowired
	private HttpServletRequest request;

	/**
	 * 
	 * 
	 * @param pagesize
	 *            第几页
	 * @return
	 */
	@RequestMapping(value = "merchant_list", method = RequestMethod.GET)
	public ModelAndView merchantlist(int pageNow, long dataCount, int pageSize) {
		ModelAndView mav = new ModelAndView("/merchant/merchant_list");
		if (dataCount == 0) {
			dataCount = merchantService.countAllMerchant(null);
		}
		mav.addObject("malist",
				merchantService.getMerchantList(null, pageNow, pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));

		// commentsService.addComments("2014年2月", "2014年10月", "广州大学城中心体育馆主体工程",
		// "",
		// 5, 5, 5, "按时按质", 3, "580072c8c5f658f9e12b633e");
		//
		// commentsService.addComments("2015年1月", "2016年2月", "小洲村改造工程", "",
		// 2, 2, 5, "基本达到要求", 3, "580072c8c5f658f9e12b633e");
		//
		// commentsService.addComments("2016年3月", "2016年10月", "街道报警装备升级", "",
		// 2, 2, 2, "", 3, "580072c8c5f658f9e12b633e");
		//
		// commentsService.addComments("2014年2月", "2014年10月", "广州大学城中心体育馆主体工程",
		// "",
		// 5, 5, 5, "按时按质", 4, "5800738fc5f658f9e12b633f");
		//
		// commentsService.addComments("2015年1月", "2016年2月", "小洲村改造工程", "",
		// 2, 2, 5, "基本达到要求", 4, "5800738fc5f658f9e12b633f");
		//
		// commentsService.addComments("2016年3月", "2016年10月", "街道报警装备升级", "",
		// 2, 2, 2, "", 4, "5800738fc5f658f9e12b633f");
		//
		return mav;
		
	}

	@RequestMapping(value = "merchant_list2", method = RequestMethod.POST)
	public ModelAndView merchantlist2() {
		return toList();
	}

	/**
	 * 返回查询列表
	 * 
	 * @return
	 */
	private ModelAndView toList() {
		String supplier = request.getParameter("supplier");
		String licence = request.getParameter("licence");
		String build = request.getParameter("build");
		String registercapital = request.getParameter("registercapital");
		String registeraddress = request.getParameter("registeraddress");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String identification = request.getParameter("identification");
		String phone = request.getParameter("phone");
		String qq = request.getParameter("qq");
		String wetchat = request.getParameter("wetchat");
		String note = request.getParameter("note");
		ModelAndView mav = new ModelAndView("/merchant/merchant_list");
		// String dataCountStr = request.getParameter("dataCount");
		long dataCount = 0;

		BasicDBObject queryObj = new BasicDBObject();
		if (StringUtils.isNotBlank(supplier)) {
			queryObj.put("supplier", supplier);
		}
		if (StringUtils.isNotBlank(licence)) {
			queryObj.put("licence", licence);
		}
		if (StringUtils.isNotBlank(build)) {
			queryObj.put("build", build);
		}
		if (StringUtils.isNotBlank(registercapital)) {
			queryObj.put("registercapital", registercapital);
		}
		if (StringUtils.isNotBlank(registeraddress)) {
			queryObj.put("registeraddress", registeraddress);
		}
		if (StringUtils.isNotBlank(name)) {
			queryObj.put("name", name);
		}
		if (StringUtils.isNotBlank(address)) {
			queryObj.put("address", address);
		}
		if (StringUtils.isNotBlank(email)) {
			queryObj.put("email", email);
		}
		if (StringUtils.isNotBlank(identification)) {
			queryObj.put("identification", identification);
		}
		if (StringUtils.isNotBlank(phone)) {
			queryObj.put("phone", phone);
		}
		if (StringUtils.isNotBlank(qq)) {
			queryObj.put("qq", qq);
		}
		if (StringUtils.isNotBlank(wetchat)) {
			queryObj.put("wetchat", wetchat);
		}
		if (StringUtils.isNotBlank(note)) {
			queryObj.put("note", note);
		}
		if (queryObj.size() <= 0)
			queryObj = null;

		// if(dataCountStr == null || "".equals(dataCountStr)){
		dataCount = merchantService.countAllMerchant(queryObj);
		// }else{
		// dataCount = Integer.valueOf(dataCountStr);
		// }
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

		mav.addObject("malist",
				merchantService.getMerchantList(queryObj, pageNow, pageSize));
		mav.addObject("page", PageHandler.getPage(pageSize, pageNow, dataCount));

		mav.addObject("supplier", supplier);
		mav.addObject("licence", licence);
		mav.addObject("build", build);
		mav.addObject("registercapital", registercapital);
		mav.addObject("registeraddress", registeraddress);
		mav.addObject("name", name);
		mav.addObject("address", address);
		mav.addObject("email", email);
		mav.addObject("identification", identification);
		mav.addObject("phone", phone);
		mav.addObject("qq", qq);
		mav.addObject("wetchat", wetchat);
		mav.addObject("note", note);
		return mav;
	}

	@RequestMapping(value = "merchant_add", method = RequestMethod.GET)
	public String merchantAdd() {
		return "/merchant/merchant_add";
	}

	@RequestMapping(value = "merchant_modify", method = RequestMethod.GET)
	public ModelAndView merchantModify(String id) {
		ModelAndView mav = new ModelAndView("/merchant/merchant_modify");
		MerchantModel model = merchantService.getById(id);
		if (model != null)
			mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "merchant_modify2", method = RequestMethod.POST)
	public ModelAndView merchantModify2() {
		String id = request.getParameter("id");
		String supplier = request.getParameter("supplier");
		String licence = request.getParameter("licence");
		String build = request.getParameter("build");
		String registercapital = request.getParameter("registercapital");
		String registeraddress = request.getParameter("registeraddress");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String identification = request.getParameter("identification");
		String phone = request.getParameter("phone");
		String qq = request.getParameter("qq");
		String wetchat = request.getParameter("wetchat");
		String note = request.getParameter("note");
		String supply = request.getParameter("supply");
		String payment = request.getParameter("payment");
		String paytreasure = request.getParameter("paytreasure");
		String bankaccount = request.getParameter("bankaccount");
		String itemname = request.getParameter("itemname");
		String paid = request.getParameter("paid");
		String paytype = request.getParameter("paytype");
		String cope = request.getParameter("cope");
		String code = request.getParameter("code");
		MerchantModel model = merchantService.getById(id);
		if (model != null) {
			model.setSupplier(supplier);
			model.setlicence(licence);
			model.setBuild(build);
			model.setRegistercapital(registercapital);
			model.setRegisteraddress(registeraddress);
			model.setName(name);
			model.setAddress(address);
			model.setEmail(email);
			model.setIdentification(identification);
			model.setPhone(phone);
			model.setQq(qq);
			model.setWetchat(wetchat);
			model.setNote(note);
			model.setSupply(supply);
			model.setPayment(payment);
			model.setPaytreasure(paytreasure);
			model.setPaytreasure(paytreasure);
			model.setItemname(itemname);
			model.setPaid(paid);
			model.setPaytype(paytype);
			model.setCope(cope);
			model.setBankaccount(bankaccount);
			model.setCode(code);
			merchantService.updateMerchant(model);
		}

		ModelAndView mav = new ModelAndView("/merchant/merchant_list");
		long dataCount = merchantService.countAllMerchant(null);
		mav.addObject("malist", merchantService.getMerchantList(null, 1, 0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}

	/**
	 * 管理员
	 * 
	 * @return
	 */
	@RequestMapping(value = "merchant_add2", method = RequestMethod.POST)
	public ModelAndView merchantAdd2() {
		String supplier = request.getParameter("supplier");
		String licence = request.getParameter("licence");
		String build = request.getParameter("build");
		String registercapital = request.getParameter("registercapital");
		String registeraddress = request.getParameter("registeraddress");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String identification = request.getParameter("identification");
		String phone = request.getParameter("phone");
		String qq = request.getParameter("qq");
		String wetchat = request.getParameter("wetchat");
		String note = request.getParameter("note");
		String supply = request.getParameter("supply");
		String payment = request.getParameter("payment");
		String paytreasure = request.getParameter("paytreasure");
		String bankaccount = request.getParameter("bankaccount");
		String itemname = request.getParameter("itemname");
		String paid = request.getParameter("paid");
		String paytype = request.getParameter("paytype");
		String cope = request.getParameter("cope");
		String mobile = request.getParameter("mobile");
		String code = request.getParameter("code");
		String typeStr = request.getParameter("type");
		//新增三个字段（2016.11.22）
		String depositBank = request.getParameter("depositBank");
		int status = Integer.valueOf(request.getParameter("status"));
		int open = Integer.valueOf(request.getParameter("open"));
		//判断新增的是材料商还是设备商
		//新增的为材料商
		if(Integer.valueOf(typeStr)==1){
			//通过材料商代号查询材料商信息
			MaterialModel  materialmodel = materialService.getByCode(code);
			//材料商不存在
			if(materialmodel == null){
				ModelAndView mav = new ModelAndView("/merchant/merchant_add");
				return mav;
			}
		//新增的为设备商	
		} else if(Integer.valueOf(typeStr)==2){
			//通过设备商代号查询设备商信息
			EquipmentModel equipmentmodel = equipmentService.getByCode(code);
			//设备商不存在
			if(equipmentmodel == null){
				ModelAndView mav = new ModelAndView("/merchant/merchant_add");
				return mav;
			}
		}
		
		
		int type = 1;
		if (StringUtils.isNotBlank(typeStr))
			type = Integer.valueOf(typeStr);
		boolean bln = merchantService.addMerchant(supplier, licence, build,
				registercapital, registeraddress, name, address, email,
				identification, phone, qq, wetchat, note, supply, payment,
				paytreasure, bankaccount, itemname, paid, paytype, cope,
				mobile, code, type,status,depositBank,open);
		//
		ModelAndView mav = new ModelAndView("/merchant/merchant_list");
		long dataCount = merchantService.countAllMerchant(null);
		mav.addObject("malist", merchantService.getMerchantList(null, 1, 0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}

	/**
	 * 供应商诚信档案列表
	 * 
	 * @param type
	 *            1-材料 2-设备
	 * @param code
	 *            公司代号
	 * @return
	 */
	@RequestMapping(value = "merchant_form", method = RequestMethod.GET)
	public ModelAndView merchantlist(int type, String code,String id) {
		ModelAndView mav = new ModelAndView("/merchant/merchant_form");
		MerchantModel model = merchantService.getByTypeAndCode(type, code);
		if (model != null) {
			mav.addObject("model", model);
			String cId = "";
			if (type == 1) {
				MaterialModel materialModel = materialService.getByCode(code);
				if (materialModel != null)
					cId = materialModel.getId();
			} else if (type == 2) {
				EquipmentModel equipmentModel = equipmentService
						.getByCode(code);
				if (equipmentModel != null)
					cId = equipmentModel.getId();
			}
			
		}
		
		// 项目评价
		List<CommentsModel> comments = commentsService.getListByIdAndType(
				id, type + 2);
		mav.addObject("comments", comments);
		return mav;
	}

	/**
	 * 删除诚信档案
	 * 
	 * @return
	 */
	@RequestMapping(value = "merchant_del", method = RequestMethod.GET)
	public ModelAndView materialDel(String id) {
		merchantService.delMerchant(id);
		ModelAndView mav = new ModelAndView("/merchant/merchant_list");
		long dataCount = merchantService.countAllMerchant(null);
		mav.addObject("malist", merchantService.getMerchantList(null, 1, 0));
		mav.addObject("page", PageHandler.getPage(0, 1, dataCount));
		return mav;
	}
}
