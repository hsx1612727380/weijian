package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.db.playermodel.EngineerModel;

public interface EngineerService {

	void updateEngineer(EngineerModel model);

	void delEngineer(String id);

	List<EngineerModel> getByCode(String code);
	
	EngineerModel getById(String id);
	
	boolean addEngineer(String code, String name, String type,
			String registration, String userId, String certificateorgan,
			String issuancedate, String effectivedate);

	/**
	 * 添加页面验证手机号是否已经注册过了
	 * @param userId
	 * @return
	 */
	String addMobilRepCHeck(String userId);

	/**
	 * 修改页面验证手机号是否已经注册过了
	 * @param userId
	 * @param id
	 * @return
	 */
	String modfiyMobilRepCHeck(String userId, String id);
	
	List<EngineerModel> getByCode(String code,int row,int skip);

	/**
	 * 获得该用户的证书列表
	 * @param userId
	 * @return
	 */
	List<EngineerModel> getByUserId(String userId);

}
