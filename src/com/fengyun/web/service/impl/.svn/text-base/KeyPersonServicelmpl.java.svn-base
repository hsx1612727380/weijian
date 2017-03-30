package com.fengyun.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.KeyPersonDAO;
import com.fengyun.web.db.playermodel.KeyPersonModel;
import com.fengyun.web.service.KeyPersonService;
@Service
public class KeyPersonServicelmpl implements KeyPersonService {
	/**
	 * 通过公司code
	 */
	@Override
	public List<KeyPersonModel> getBypCode(String pCode) {
		return  KeyPersonDAO.getBypCode(pCode);
	}
	
	
	/**
	 * 删除
	 */
	@Override
	public void delKeyPerson(String id) {
		 KeyPersonDAO.delete(id);
	}
	
	
	/**
	 * 新增
	 */
	@Override
	public boolean addKeyPerson(String pCode,String name,String cName,String phone ,String role) {
		KeyPersonModel model = new  KeyPersonModel();
		model.setpCode(pCode);
		model.setName(name);
		model.setcName(cName);
		model.setPhone(phone);
		model.setRole(role);
		try{
			KeyPersonDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	
	/**
	 * 修改
	 * @param model
	 */
	@Override
	public void updateKeyPerson(KeyPersonModel model) {
		KeyPersonDAO.update(model);
	}
	
	@Override
	public KeyPersonModel getById(String id){
		return KeyPersonDAO.getById(id);
	}

	/**
	 * 根据公司编号代码和关键人员岗位的手机号判断该手机是否被注册
	 */
	@Override
	public KeyPersonModel getKeyPersonByPCodeAndPhone(String code, String phone) {
		return KeyPersonDAO.getKeyPersonByPCodeAndPhone(code, phone);
	}

	/**
	 * KeyPerson添加页面对手机号的校验
	 */
	@Override
	public String addMobilRepCHeck(String phone) {
		String isRep = "0";
		if (KeyPersonDAO.mobilRepCHeck(phone) == null) {
			isRep = "1";
		}
		return isRep;
	}

	/**
	 * KeyPerson修改页面对手机号的校验
	 */
	@Override
	public String modfiyMobilRepCHeck(String phone, String id) {
		String isRep = "0";
		if (KeyPersonDAO.mobilRepCHeck(phone) == null) {
			isRep = "1";
		}
		else {
			KeyPersonModel keyPersonModel  = KeyPersonDAO.getById(id);
			if (phone.equals(keyPersonModel.getPhone())) {
				isRep = "1";
			}
		}
		return isRep;
	}
	

}
