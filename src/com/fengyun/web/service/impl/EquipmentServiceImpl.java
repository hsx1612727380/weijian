package com.fengyun.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.EquipmentDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.service.EquipmentService;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.ProjectService;
import com.mongodb.BasicDBObject;

@Service
public class EquipmentServiceImpl implements EquipmentService{

	
	@Autowired
	private ProjectDepartmentService projectDepartmentService;

	@Autowired
	private ProjectService projectService;
	
	@Override
	public boolean addEquipment(String shopName,String name, String code, String userId,
			String leaderName, String province, String city, String street,
			int status,String licence, String regcapital,String establishDate ) {
		//是否一个负责人只能负责一个公司
		
		//是否要判断重名
		
		//新建
		EquipmentModel model = new EquipmentModel();
		model.setShopName(shopName);
		model.setName(name);
		model.setCode(code);
		model.setUserId(userId);
		model.setLeaderName(leaderName);
		model.setProvince(province);
		model.setCity(city);
		model.setStreet(street);
		model.setCreateTime(new Date());
		model.setStatus(status);
		model.setLicence(licence);
		model.setRegcapital(regcapital);
		model.setEstablishDate(establishDate);
		try{
			EquipmentDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public List<EquipmentModel> getEquipmentList(BasicDBObject queryObj,
			int pageNow, int pageSize) {
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return EquipmentDAO.getAll(queryObj,pageSize, skip);
	}

	@Override
	public long countAllEquipment(BasicDBObject queryObj) {
		return EquipmentDAO.countAll(queryObj);
	}

	@Override
	public void delEquipment(String id) {
		EquipmentDAO.delete(id);
	}

	@Override
	public EquipmentModel getById(String id) {
		return EquipmentDAO.getById(id);
	}

	@Override
	public void updateEquipment(EquipmentModel model) {
		EquipmentDAO.update(model);
	}

	@Override
	public void equipmentPass(String id) {
		EquipmentModel model = getById(id);
		if(model != null){
			model.setStatus(1);
			EquipmentDAO.updateStatus(model);
		}
		
	}

	@Override
	public EquipmentModel getByCode(String code) {
		return EquipmentDAO.getByCode(code);
	}

	@Override
	public EquipmentModel getByUserId(String userId) {
		return EquipmentDAO.getByUserId(userId);
	}

	@Override
	public void initialEquipment(UserModel model) {
		// TODO Auto-generated method stub
		String userId=model.getUserId();
		String leaderName=model.getUserName();
		String shopName=null;
		String name=null;
		String code=null;
		String province=null;
		String city=null;
		String street=null;
		String licence=null;
		String regcapital=null;
		Date createTime=model.getCreateTime();
		String establishDate=null;
		int status=0;
		this.addEquipment(shopName, name, code, userId, leaderName, province, city, street, status, licence, regcapital, establishDate);
	}

	
	/**
	 * 根据名字查找设备商信息
	 */
	@Override
	public EquipmentModel getByName(String name) {
		// TODO Auto-generated method stub
		return EquipmentDAO.getByName(name);
	}

	/**
	 * 根据条件查询设备商
	 */
	@Override
	public List<EquipmentModel> getMaterialList(BasicDBObject queryObj) {
		return EquipmentDAO.getMaterialList(queryObj);
	}

	/**
	 * 通过供应商编码验证某个设备商是否已经注册过
	 */
	@Override
	public String regRosterEquipmentCode(String code) {
		String result = "0";
		EquipmentModel equipmentModel = EquipmentDAO.getByCode(code);
		if (equipmentModel != null) { // 查询到result为"1"，否则为"0"
			result = "1";
		}
		return result;
	}

	/**
	 * 通过手机号验证某个设备商是否已经注册过
	 */
	@Override
	public String regRosterEquipmentUserId(String userId) {
		String result = "0";
		EquipmentModel equipmentModel = EquipmentDAO.getByUserId(userId);
		if (equipmentModel != null) { // 查询到result为"1"，否则为"0"
			result = "1";
		}
		return result;
	}
	
	/**
	 * 获取已经参加过的或正在参加的项目list-zss
	 */
	@Override
	public List<ProjectModel> getCurrentProject(HttpSession session, int type, int status) {
		// TODO Auto-generated method stub
		String userId = (String) session.getAttribute("userId");
		EquipmentModel equipmentModel = this.getByUserId(userId);
		String vId = null;
		if(equipmentModel!=null){
			vId = equipmentModel.getId();
		}
		List<ProjectDepartmentModel> list = projectDepartmentService.getProjectByTIdStatus(vId,type,status);
		List<ProjectModel> pList = new ArrayList<ProjectModel>();
		for (ProjectDepartmentModel projectDepartment : list) {
			String pId = projectDepartment.getpId();
			ProjectModel projectModel = projectService.getById(pId);
			pList.add(projectModel);
		}
		return pList;
	}

	/**
	 * 新增设备商
	 */
	@Override
	public boolean addEquipment(EquipmentModel equipmentModel) {
		return EquipmentDAO.addMaterial(equipmentModel);
	}
}
