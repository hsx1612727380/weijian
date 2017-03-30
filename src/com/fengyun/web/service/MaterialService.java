package com.fengyun.web.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.mongodb.BasicDBObject;

public interface MaterialService {

	/**
	 * 新增材料公司
	 * 
	 * @param establishDate
	 */
	public boolean addMaterial(String shopName, String name, String code,
			String licence, String regcapital, String establishDate,
			String userId, String leaderName, String province, String city,
			String street, int status);

	/** 获取所有项目 */
	public List<MaterialModel> getMaterialList(BasicDBObject queryObj,
			int pageNow, int pageSize);

	/** 获取项目总数 */
	public long countAllMaterial(BasicDBObject queryObj);

	/**
	 * 删除项目
	 */
	public void delMaterial(String id);

	/** 根据ID获取项目信息 */
	public MaterialModel getById(String id);

	/** 根据ID获取项目信息 */
	public MaterialModel getByCode(String code);

	/** 更新项目信息 */
	public void updateMaterial(MaterialModel model);

	/** 审核项目 */
	public void materialPass(String id);

	/** 根据负责人手机号获取材料商信息 */
	public MaterialModel getByUserId(String userId);

	/**
	 * 注册时通过model添加一个material的初始信息
	 * @param model
	 */
	public void initialMaterial(UserModel model);
	
	
	/**
	 * 根据材料商名称查询
	 * @param name
	 * @return
	 */
	public MaterialModel getByName(String name);

	/**
	 * 根据条件查询材料商
	 * @param queryObj
	 * @return
	 */
	public List<MaterialModel> getMaterialList(BasicDBObject queryObj);

	/**
	 * 获取已经参加过的或正在参加的项目list
	 * @param session
	 * @return
	 */
	public List<ProjectModel> getCurrentProject(HttpSession session, int type,int status);

	/**
	 * 通过供应商编码验证某个材料商是否已经注册过
	 * @param code
	 * @return
	 */
	public String regRosterMaterialCode(String code);

	/**
	 * 通过手机号验证某个材料商是否已经注册过
	 * @param userId
	 * @return
	 */
	public String regRosterMaterialUserId(String userId);
	
	/**
	 * 新增材料商
	 * @param materialModel
	 * @return
	 */
	public boolean addMaterial(MaterialModel materialModel);

}
