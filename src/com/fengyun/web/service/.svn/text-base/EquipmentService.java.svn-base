package com.fengyun.web.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.mongodb.BasicDBObject;

public interface EquipmentService {

	/** 新增公司 */
	boolean addEquipment(String shopName, String name, String code,
			String userId, String leaderName, String province, String city,
			String street, int status, String licence, String regcapital,
			String establishDate);
	
	/**获取所有项目*/
	public List<EquipmentModel> getEquipmentList(BasicDBObject queryObj,int pageNow,int pageSize);
	
	/**获取项目总数*/
	public long countAllEquipment(BasicDBObject queryObj);
	
	/**
	 * 删除项目
	 */
	public void delEquipment(String id);
	
	/**根据ID获取项目信息*/
	public EquipmentModel getById(String id);
	
	/**根据ID获取项目信息*/
	public EquipmentModel getByCode(String code);
	
	/**更新项目信息*/
	public void updateEquipment(EquipmentModel model);
	
	/**审核项目*/
	public void equipmentPass(String id);
	
	/**根据手机号查找设备商信息*/
	public EquipmentModel getByUserId(String userId);
	/**
	 * 注册时添加一个设备商的初始信息 userId和leaderName
	 * @param model
	 */
	void initialEquipment(UserModel model);
	
	/**
	 * 根据名字查找设备商信息
	 * @param name
	 * @return
	 */
	public EquipmentModel getByName(String name);

	/**
	 * 根据条件查询设备商
	 * @param queryObj
	 * @return
	 */
	List<EquipmentModel> getMaterialList(BasicDBObject queryObj);

	/**
	 * 通过供应商编码验证某个设备商是否已经注册过
	 * @param code
	 * @return
	 */
	String regRosterEquipmentCode(String code);

	/**
	 * 通过手机号验证某个设备商是否已经注册过
	 * @param userId
	 * @return
	 */
	String regRosterEquipmentUserId(String userId);

	
	/**
	 * 获取已经参加过的或正在参加的项目list
	 * @param session
	 * @return
	 */
	public List<ProjectModel> getCurrentProject(HttpSession session, int type,int status);

	/**
	 * 新增设备商
	 * @param equipmentModel
	 * @return
	 */
	public boolean addEquipment(EquipmentModel equipmentModel);
	
}
