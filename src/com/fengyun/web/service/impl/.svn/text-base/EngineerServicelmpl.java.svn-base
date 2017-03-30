package com.fengyun.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.EngineerDAO;
import com.fengyun.web.db.playermodel.EngineerModel;
import com.fengyun.web.service.EngineerService;

@Service
public class EngineerServicelmpl implements EngineerService {
	/**
	 * 通过公司code
	 */
	@Override
	public List<EngineerModel> getByCode(String code) {
		return EngineerDAO.getByCode(code);
	}
	
	
	/**
	 * 删除
	 */
	@Override
	public void delEngineer(String id) {
		EngineerDAO.delete(id);
	}
	
	
	/**
	 * 新增
	 */
	@Override
	public boolean addEngineer(String code,String name,String type,String registration,String userId, String certificateorgan, String issuancedate, String effectivedate) {
		EngineerModel model = new EngineerModel();
		model.setUserId(userId);
		model.setName(name);
		model.setType(type);
		model.setRegistration(registration);
		model.setCode(code);
		model.setCertificateorgan(certificateorgan);
		model.setIssuancedate(issuancedate);
		model.setEffectivedate(effectivedate);
		try{
			EngineerDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	
	/**
	 * 修改
	 */
	@Override
	public void updateEngineer(EngineerModel model) {
		EngineerDAO.update(model);
	}
	
	@Override
	public EngineerModel getById(String id){
		return EngineerDAO.getById(id);
	}

	/**
	 * 验证手机号是否已经注册过了
	 */
	@Override
	public String addMobilRepCHeck(String userId) {
		String isRep = "0";
		if (EngineerDAO.mobilRepCHeck(userId) == null) {
			isRep = "1";
		}
		return isRep;
	}

	/**
	 * 修改页面验证手机号是否已经注册过了
	 */
	@Override
	public String modfiyMobilRepCHeck(String userId, String id) {
		String isRep = "0";
		if (EngineerDAO.mobilRepCHeck(userId) == null) {
			isRep = "1";
		}
		else {
			EngineerModel engineerModel = EngineerDAO.getById(id);
			if (userId.equals(engineerModel.getUserId())) {
				isRep = "1";
			}
		}
		return isRep;
	}
	
	@Override
	public List<EngineerModel> getByCode(String code, int row, int skip) {
		// TODO Auto-generated method stub
		return EngineerDAO.getByCode(code, row, skip);
	}


	@Override
	public List<EngineerModel> getByUserId(String userId) {
		// TODO Auto-generated method stub
		return EngineerDAO.getByUserId(userId);
	}

}
