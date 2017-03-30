package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.db.playermodel.AdminModel;
import com.mongodb.BasicDBObject;

public interface AdminService {
	/**
	 * 查询用户名是否存在
	 * 
	 * @param userName
	 * @return
	 */
	AdminModel findLoginName(String userName);

	/**
	 * 查询密码是否正确
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	AdminModel findPassword(String accountName, String password);

	/**
	 * 增加管理员
	 * 
	 * @param model
	 * @return
	 */
	boolean addAdmin(AdminModel model);

	/**
	 * 查询姓名
	 * 
	 * @param name
	 * @return
	 */
	AdminModel searchAdminByName(String name);
/*
	*//**
	 * 分页查询所有管理员
	 * 
	 * @param name
	 * @return
	 *//*
	List<AdminModel> listAdmin(int row, int skip);*/

	
	void delAdmin(String id);

	AdminModel showAdmin(String id);


	void updateAdmin(AdminModel admin);

	/**
	 * 计算管理员总数量
	 * @return
	 */
	long countAllAdmin(BasicDBObject queryObj);

	/**
	 * 分页查询管理员
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	List<AdminModel> getAdminList(BasicDBObject queryObj,int pageNow, int pageSize);

	AdminModel findAdminById(String id);

	Object checkLogonByAccountName(String accountName, String password);

	AdminModel getByAccountName(String accountName);

}
