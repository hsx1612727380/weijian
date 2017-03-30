package com.fengyun.web.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.CompanyDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.playermodel.CompanyModel;
import com.fengyun.web.service.CompanyService;
import com.mongodb.BasicDBObject;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Override
	public boolean addCompany(String name, String code, String userId,
			String leaderName, String province, String city, String street,
			String type,int status,String regType,String regMoney,String organization,String tel) {
		//是否一个负责人只能负责一个公司
		
		//是否要判断重名
		
		//新建
		CompanyModel model = new CompanyModel();
		model.setName(name);
		model.setCode(code);
		model.setUserId(userId);
		model.setLeaderName(leaderName);
		model.setProvince(province);
		model.setCity(city);
		model.setStreet(street);
		model.setCreateTime(new Date());
		model.setType(type);
		model.setStatus(status);
		model.setRegType(regType);
		model.setRegMoney(regMoney);
		model.setOrganization(organization);
		model.setTel(tel);
		try{
			CompanyDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public List<CompanyModel> getCompanyList(BasicDBObject queryObj,
			int pageNow, int pageSize) {
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return CompanyDAO.getAll(queryObj,pageSize, skip);
	}

	@Override
	public long countAllCompany(BasicDBObject queryObj) {
		return CompanyDAO.countAll(queryObj);
	}

	@Override
	public void delCompany(String id) {
		CompanyDAO.delete(id);
	}

	@Override
	public CompanyModel getById(String id) {
		return CompanyDAO.getById(id);
	}

	@Override
	public void updateCompany(CompanyModel model) {
		CompanyDAO.update(model);
	}

	@Override
	public void companyPass(String id) {
		CompanyModel model = getById(id);
		if(model != null && StringUtils.isNotBlank(model.getCode())){
			//需填写公司编号才能审核
			model.setStatus(2);
			CompanyDAO.updateStatus(model);
		}
	}

	@Override
	public CompanyModel getByCode(String code) {
		return CompanyDAO.getByCode(code);
	}
	
	public String mobilRepCHeck(String mobilPhone) {
		String isRep = "0";
		if (CompanyDAO.mobilRepCHeck(mobilPhone) == null) {
			isRep = "1";
		}
		// TODO Auto-generated method stub
		return isRep;
	}

	@Override
	public boolean regCompany(CompanyModel model) {
		// TODO Auto-generated method stub
		try{
			CompanyDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public CompanyModel getByUserId(String userId) {
		// TODO Auto-generated method stub
		return CompanyDAO.mobilRepCHeck(userId);
	}
	
	
	@Override
	public void addCompany(CompanyModel companyModel) {
		CompanyDAO.addCompany(companyModel);
	}
	
	/**
	 * 通过公司名称获取公司信息
	 */
	@Override
	public CompanyModel getByName(String name) {
		// TODO Auto-generated method stub
		return CompanyDAO.getByName(name);
	}

	@Override
	public CompanyModel getCompanyByOrganization(String organization)
	{
		// TODO Auto-generated method stub
		return CompanyDAO.getCompanyByOrganization(organization);
	}

	@Override
	public String companyModfiyCompanyPasswordRepCHeck(String password,
			String id) {
		String reg = "0";
		CompanyModel companyModel = CompanyDAO.getByPasswordAndId(password, id);
		if (companyModel != null) {
			reg = "1";
		}
		return reg;
	}
	
}
