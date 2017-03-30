package com.fengyun.web.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.MerchantDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.MerchantModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.service.EquipmentService;
import com.fengyun.web.service.MaterialService;
import com.fengyun.web.service.MerchantService;
import com.mongodb.BasicDBObject;

@Service
public class MerchantServicelmpl implements MerchantService {

	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private MaterialService materialService;

	@Override
	public boolean addMerchant(String supplier, String licence, String build, String registercapital, String registeraddress, String name, String address,
			String email, String identification, String phone, String qq, String wetchat, String note, String supply, String payment, String paytreasure,
			String bankaccount, String itemname, String paid, String paytype, String cope, String mobile, String code, int type, int status,
			String depositBank, int open) {
		MerchantModel model = new MerchantModel();
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
		model.setSupply(supply);
		model.setPayment(payment);
		model.setPaytreasure(paytreasure);
		model.setPaytreasure(paytreasure);
		model.setNote(note);
		model.setItemname(itemname);
		model.setPaid(paid);
		model.setPaytype(paytype);
		model.setCope(cope);
		model.setMobile(mobile);
		model.setCode(code);
		model.setType(type);
		model.setStatus(status);
		model.setDepositBank(depositBank);
		model.setOpen(open);
		try {
			MerchantDAO.insert(model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<MerchantModel> getMerchantList(BasicDBObject queryObj, int pageNow, int pageSize) {
		if (pageNow <= 0)
			pageNow = 1;
		if (pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return MerchantDAO.getAll(queryObj, pageSize, skip);
	}

	@Override
	public long countAllMerchant(BasicDBObject queryObj) {
		return MerchantDAO.countAll(queryObj);
	}

	@Override
	public void delMerchant(String id) {
		MerchantDAO.delete(id);
	}

	@Override
	public MerchantModel getById(String id) {
		return MerchantDAO.getById(id);
	}

	@Override
	public void updateMerchant(MerchantModel merchantModel) {
		MerchantModel model = null;
		EquipmentModel equipmentModel = null;
		MaterialModel materialModel = null;
		if (merchantModel != null) {
			model = this.getById(merchantModel.getId());
		}
		if (StringUtils.isNotBlank(merchantModel.getSupplier())) {
			model.setSupplier(merchantModel.getSupplier());
		}
		if (StringUtils.isNotBlank(merchantModel.getlicence())) {
			model.setlicence(merchantModel.getlicence());
			// 【个人信息-社会统一信用代码】和【诚信档案-社会统一信用代码】 不在同一个表中，更新一边时，
			// 要同时在代码中更新另一边以保持数据统一性。
			if (StringUtils.isNotBlank((merchantModel.getMobile()))&&model.getType()==1) {
				materialModel = materialService.getByUserId(merchantModel.getMobile());
				if (materialModel != null) {
					materialModel.setLicence(merchantModel.getlicence());
				}
				materialService.updateMaterial(materialModel);
			}else if (StringUtils.isNotBlank((merchantModel.getMobile()))&&model.getType()==2) {
				equipmentModel = equipmentService.getByUserId(merchantModel.getMobile());
				if (equipmentModel != null) {
					equipmentModel.setLicence(merchantModel.getlicence());
				}
				equipmentService.updateEquipment(equipmentModel);
			}
		}
		if (StringUtils.isNotBlank(merchantModel.getBuild())) {
			model.setBuild(merchantModel.getBuild());
			
			if (StringUtils.isNotBlank((merchantModel.getMobile()))&&model.getType()==1) {
				materialModel = materialService.getByUserId(merchantModel.getMobile());
				if (materialModel != null) {
					materialModel.setEstablishDate(merchantModel.getBuild());
				}
				materialService.updateMaterial(materialModel);
			}else if (StringUtils.isNotBlank((merchantModel.getMobile()))&&model.getType()==2) {
				equipmentModel = equipmentService.getByUserId(merchantModel.getMobile());
				if (equipmentModel != null) {
					equipmentModel.setEstablishDate(merchantModel.getBuild());
				}
				equipmentService.updateEquipment(equipmentModel);
			}
			
			
		}
		if (StringUtils.isNotBlank(merchantModel.getRegistercapital())) {
			model.setRegistercapital(merchantModel.getRegistercapital());
			//
			if (StringUtils.isNotBlank((merchantModel.getMobile()))&&model.getType()==1) {
				materialModel = materialService.getByUserId(merchantModel.getMobile());
				if (materialModel != null) {
					materialModel.setRegcapital(merchantModel.getRegistercapital());
				}
				materialService.updateMaterial(materialModel);
			}else if (StringUtils.isNotBlank((merchantModel.getMobile()))&&model.getType()==2) {
				equipmentModel = equipmentService.getByUserId(merchantModel.getMobile());
				if (equipmentModel != null) {
					equipmentModel.setRegcapital(merchantModel.getRegistercapital());
				}
				equipmentService.updateEquipment(equipmentModel);
			}
		}
		if (StringUtils.isNotBlank(merchantModel.getRegisteraddress())) {
			model.setRegisteraddress(merchantModel.getRegisteraddress());
		}
		if (StringUtils.isNotBlank(merchantModel.getName())) {
			model.setName(merchantModel.getName());
		}
		if (StringUtils.isNotBlank(merchantModel.getAddress())) {
			model.setAddress(merchantModel.getAddress());
		}
		if (StringUtils.isNotBlank(merchantModel.getEmail())) {
			model.setEmail(merchantModel.getEmail());
		}
		if (StringUtils.isNotBlank(merchantModel.getIdentification())) {
			model.setIdentification(merchantModel.getIdentification());
		}
		if (StringUtils.isNotBlank(merchantModel.getPhone())) {
			model.setPhone(merchantModel.getPhone());
		}
		if (StringUtils.isNotBlank(merchantModel.getQq())) {
			model.setQq(merchantModel.getQq());
		}
		if (StringUtils.isNotBlank(merchantModel.getWetchat())) {
			model.setWetchat(merchantModel.getWetchat());
		}
		if (StringUtils.isNotBlank(merchantModel.getSupply())) {
			model.setSupply(merchantModel.getSupply());
		}
		if (StringUtils.isNotBlank(merchantModel.getPayment())) {
			model.setPayment(merchantModel.getPayment());
		}
		if (StringUtils.isNotBlank(merchantModel.getPaytreasure())) {
			model.setPaytreasure(merchantModel.getPaytreasure());
		}
		if (StringUtils.isNotBlank(merchantModel.getPaytreasure())) {
			model.setPaytreasure(merchantModel.getPaytreasure());
		}
		if (StringUtils.isNotBlank(merchantModel.getNote())) {
			model.setNote(merchantModel.getNote());
		}
		if (StringUtils.isNotBlank(merchantModel.getItemname())) {
			model.setItemname(merchantModel.getItemname());
		}
		if (StringUtils.isNotBlank(merchantModel.getPaid())) {
			model.setPaid(merchantModel.getPaid());
		}
		if (StringUtils.isNotBlank(merchantModel.getPaytype())) {
			model.setPaytype(merchantModel.getPaytype());
		}
		if (StringUtils.isNotBlank(merchantModel.getCope())) {
			model.setCope(merchantModel.getCope());
		}
		if (StringUtils.isNotBlank(merchantModel.getMobile())) {
			model.setMobile(merchantModel.getMobile());
		}
		if (StringUtils.isNotBlank(merchantModel.getCode())) {
			model.setCode(merchantModel.getCode());
		}
		if (merchantModel.getStatus() != model.getStatus()) {
			model.setStatus(merchantModel.getStatus());
		}
		if (StringUtils.isNotBlank(merchantModel.getDepositBank())) {
			model.setDepositBank(merchantModel.getDepositBank());
		}
		if (merchantModel.getOpen() != model.getOpen()) {
			model.setOpen(merchantModel.getOpen());
		}
		MerchantDAO.update(model);
	}

	@Override
	public MerchantModel getByTypeAndCode(int type, String code) {

		return MerchantDAO.getByTypeAndCode(type, code);
	}

	@Override
	public void initialMerchant(UserModel model, HttpSession session) {
		// TODO Auto-generated method stub

		this.addMerchant(null, null, null, null, null, model.getUserName(), null, null, model.getUserIdentity(), null, null, null, null, null, null, null,
				null, null, null, null, null, model.getUserId(), null, Integer.parseInt((String) session.getAttribute("type")), 1, null, 0);

	}

	@Override
	public MerchantModel getByUserId(String userId) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("mobile", userId);
		MerchantModel merchantModel = MerchantDAO.getByQueryObj(queryObj);
		return merchantModel;
	}

	/**
	 * 通过设备商信息添加设备商诚信档案的基本信息
	 * 
	 * @param team
	 */
	@Override
	public void insertEquipment(EquipmentModel equipment) {
		// TODO Auto-generated method stub
		MerchantModel model = new MerchantModel();
		// 1、添加设备商基本信息
		model.setSupplier(equipment.getName());
		model.setCode(equipment.getCode());
		model.setlicence(equipment.getLicence());
		model.setBuild(equipment.getEstablishDate());
		model.setRegistercapital(equipment.getRegcapital());
		model.setName(equipment.getLeaderName());
		model.setMobile(equipment.getUserId());
		model.setType(2);
		MerchantDAO.insert(model);
		return;

		// String name = request.getParameter("name");
		// String code = request.getParameter("code");
		// String userId = request.getParameter("userId");
		// String leaderName = request.getParameter("leaderName");
		// String province = request.getParameter("province");
		// String city = request.getParameter("city");
		// String street = request.getParameter("street");
		// String shopName = request.getParameter("shopName");
		// String licence = request.getParameter("licence");
		// String regcapital = request.getParameter("regcapital");
		// String establishDate = request.getParameter("establishDate");
		// //////////////////////////////////////////////////////////////
		// String supplier = request.getParameter("supplier");
		// String licence = request.getParameter("licence");
		// String build = request.getParameter("build");
		// String registercapital = request.getParameter("registercapital");
		// String registeraddress = request.getParameter("registeraddress");
		// String name = request.getParameter("name");
		// String address = request.getParameter("address");
		// String email = request.getParameter("email");
		// String identification = request.getParameter("identification");
		// String phone = request.getParameter("phone");
		// String qq = request.getParameter("qq");
		// String wetchat = request.getParameter("wetchat");
		// String note = request.getParameter("note");
		// String supply = request.getParameter("supply");
		// String payment = request.getParameter("payment");
		// String paytreasure = request.getParameter("paytreasure");
		// String bankaccount = request.getParameter("bankaccount");
		// String itemname = request.getParameter("itemname");
		// String paid = request.getParameter("paid");
		// String paytype = request.getParameter("paytype");
		// String cope = request.getParameter("cope");
		// String mobile = request.getParameter("mobile");
		// String code = request.getParameter("code");
		// String typeStr = request.getParameter("type");
		// //新增三个字段（2016.11.22）
		// String depositBank = request.getParameter("depositBank");
		// int status = Integer.valueOf(request.getParameter("status"));
		// int open = Integer.valueOf(request.getParameter("open"));
	}

	/**
	 * 通过材料商信息添加材料商诚信档案的基本信息
	 * 
	 * @param team
	 */
	@Override
	public void insertMaterial(MaterialModel material) {
		// TODO Auto-generated method stub
		MerchantModel model = new MerchantModel();
		// 1、添加材料商基本信息
		model.setSupplier(material.getName());
		model.setCode(material.getCode());
		model.setlicence(material.getLicence());
		model.setBuild(material.getEstablishDate());
		model.setRegistercapital(material.getRegcapital());
		model.setName(material.getLeaderName());
		model.setMobile(material.getUserId());
		model.setType(1);
		MerchantDAO.insert(model);
		return;

	}

}
