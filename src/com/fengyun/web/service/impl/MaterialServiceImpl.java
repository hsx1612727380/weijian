package com.fengyun.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.MaterialDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.service.MaterialService;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.ProjectService;
import com.mongodb.BasicDBObject;

@Service
public class MaterialServiceImpl implements MaterialService{
	
	@Autowired
	private ProjectDepartmentService projectDepartmentService;

	@Autowired
	private ProjectService projectService;
	
	@Override
	public boolean addMaterial(String shopName,String name, String code,
			                    String licence,String regcapital,String establishDate,String userId,
			String leaderName, String province, String city, String street,
			int status) {
		
		//新建
		MaterialModel model = new MaterialModel();
		model.setShopName(shopName);
		model.setName(name);
		model.setCode(code);
		model.setLicence(licence);
		model.setRegcapital(regcapital);
		model.setEstablishDate(regcapital);
		model.setUserId(userId);
		model.setLeaderName(leaderName);
		model.setProvince(province);
		model.setCity(city);
		model.setStreet(street);
		model.setCreateTime(new Date());
		model.setStatus(status);
		model.setEstablishDate(establishDate);
		try{
			MaterialDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<MaterialModel> getMaterialList(BasicDBObject queryObj,
			int pageNow, int pageSize) {
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return MaterialDAO.getAll(queryObj,pageSize, skip);
	}

	@Override
	public long countAllMaterial(BasicDBObject queryObj) {
		return MaterialDAO.countAll(queryObj);
	}

	@Override
	public void delMaterial(String id) {
		MaterialDAO.delete(id);
	}

	@Override
	public MaterialModel getById(String id) {
		return MaterialDAO.getById(id);
	}

	@Override
	public void updateMaterial(MaterialModel model) {
		MaterialDAO.update(model);
	}

	@Override
	public void materialPass(String id) {
		MaterialModel model = getById(id);
		if(model != null){
			model.setStatus(1);
			MaterialDAO.updateStatus(model);
		}
	}

	@Override
	public MaterialModel getByCode(String code) {
		return MaterialDAO.getByCode(code);
	}

	@Override
	public MaterialModel getByUserId(String userId) {
		// TODO Auto-generated method stub
		return MaterialDAO.getByUserId(userId);
	}

	@Override
	public void initialMaterial(UserModel model) {
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
//		Date createTime=model.getCreateTime();
		String establishDate=null;
		int status=0;
		this.addMaterial(shopName, name, code, licence, regcapital, establishDate, userId, leaderName, province, city, street, status);
	}

	@Override
	public MaterialModel getByName(String name) {
		// TODO Auto-generated method stub
		return MaterialDAO.getByName(name);
	}

	/**
	 * 根据条件查询材料商
	 */
	@Override
	public List<MaterialModel> getMaterialList(BasicDBObject queryObj) {
		return MaterialDAO.getMaterialList(queryObj);
	}

	/**
	 * 获取已经参加过的或正在参加的项目list
	 */
	@Override
	public List<ProjectModel> getCurrentProject(HttpSession session, int type, int status) {
		// TODO Auto-generated method stub
		String userId = (String) session.getAttribute("userId");
		MaterialModel materialModel = this.getByUserId(userId);
		String vId = null;
		if(materialModel!=null){
			vId = materialModel.getId();
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
	 * 通过供应商编码验证某个材料商是否已经注册过
	 */
	@Override
	public String regRosterMaterialCode(String code) {
		String result = "0";
		MaterialModel materialModel = MaterialDAO.getByCode(code);
		if (materialModel != null) { // 查询到result为"1"，否则为"0"
			result = "1";
		}
		return result;
	}

	/**
	 * 通过手机号验证某个材料商是否已经注册过
	 */
	@Override
	public String regRosterMaterialUserId(String userId) {
		String result = "0";
		MaterialModel materialModel = MaterialDAO.getByUserId(userId);
		if (materialModel != null) { // 查询到result为"1"，否则为"0"
			result = "1";
		}
		return result;
	}

	/**
	 * 新增材料商
	 */
	@Override
	public boolean addMaterial(MaterialModel materialModel) {
		return MaterialDAO.addMaterial(materialModel);
	}

}
