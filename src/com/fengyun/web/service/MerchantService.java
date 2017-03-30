package com.fengyun.web.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.MerchantModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.mongodb.BasicDBObject;

public interface MerchantService {

	/** 新增公司 
	 * @param open 
	 * @param depositBank 
	 * ...
	 */
	public boolean addMerchant(String supplier, String licence, String build,
			String registercapital, String registeraddress, String name,
			String address, String email, String identification, String phone,
			String qq, String wetchat, String note, String supply,
			String payment, String paytreasure, String bankaccount,
			String itemname, String paid, String paytype, String cope,
			String mobile, String code,  int type,int status, String depositBank, int open);

	/** 获取所有项目 */
	public List<MerchantModel> getMerchantList(BasicDBObject queryObj,
			int pageNow, int pageSize);

	/** 获取项目总数 */
	public long countAllMerchant(BasicDBObject queryObj);

	/**
	 * 删除项目
	 */
	public void delMerchant(String id);

	/** 根据ID获取项目信息 */
	public MerchantModel getById(String id);

	/** 更新项目信息 */
	public void updateMerchant(MerchantModel model);

	/**根据类型和代号获得供应商诚信度*/
	MerchantModel getByTypeAndCode(int type, String code);

	/**初始化【材料商/设备商】表*/
	public void initialMerchant(UserModel model,HttpSession session);

	/**
	 * 根据用户的userId查询该【材料/设备】班组对应诚信档案
	 * @param userId
	 * @return
	 */
	public MerchantModel getByUserId(String userId);

	void insertEquipment(EquipmentModel equipment);

	void insertMaterial(MaterialModel material);

}
