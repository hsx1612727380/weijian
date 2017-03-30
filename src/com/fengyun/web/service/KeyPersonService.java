package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.db.playermodel.KeyPersonModel;

public interface KeyPersonService {

	KeyPersonModel getById(String id);

	void updateKeyPerson(KeyPersonModel model);

	void delKeyPerson(String id);

	List<KeyPersonModel> getBypCode(String pCode);

	

	

	boolean addKeyPerson(String pCode, String name, String cName, String phone,
			String role);

	/**
	 * 根据公司编号代码和关键人员岗位的手机号判断该手机是否被注册
	 * @param code
	 * @param phone
	 * @return
	 */
	KeyPersonModel getKeyPersonByPCodeAndPhone(String code, String phone);

	/**
	 * KeyPerson添加页面对手机号的校验
	 * @param phone
	 * @return
	 */
	String addMobilRepCHeck(String phone);

	/**
	 * KeyPerson修改页面对手机号的校验
	 * @param phone
	 * @param id
	 * @return
	 */
	String modfiyMobilRepCHeck(String phone, String id);

}
