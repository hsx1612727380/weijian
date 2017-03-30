package com.fengyun.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.AdminDao;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.playermodel.AdminModel;
import com.fengyun.web.service.AdminService;
import com.mongodb.BasicDBObject;
@Service(value="adminService")
public class AdminServiceImpl implements AdminService{

	@Override
	public AdminModel findLoginName(String userName) {
		// TODO Auto-generated method stub
	
		AdminModel model=AdminDao.findUsername(userName);
		return model;
	}

	
	@Override
	public AdminModel findPassword(String userName, String password) {
		// TODO Auto-generated method stub
		AdminModel model=AdminDao.findPassword(userName, password);
		return model;
	}

	@Override
	public boolean addAdmin(AdminModel model) {
		// TODO Auto-generated method stub
		AdminDao.addAdmin(model);
		return false;
	}


	@Override
	public  AdminModel searchAdminByName(String name) {
		// TODO Auto-generated method stub
		return AdminDao.searchAdminByName(name);
	}

/*
	@Override
	public List<AdminModel> listAdmin(int row,int skip) {
		// TODO Auto-generated method stub
		return AdminDao.listAdmin(row, skip);
	}
*/

	@Override
	public void delAdmin(String id) {
		// TODO Auto-generated method stub
		AdminDao.delAdmin(id);
	}


	@Override
	public  AdminModel showAdmin(String id) {
		// TODO Auto-generated method stub
		AdminModel admin=AdminDao.findAdminById(id);
		return admin;
	}


	@Override
	public void updateAdmin(AdminModel admin) {
		// TODO Auto-generated method stub
		AdminDao.updateAdmin(admin);
	}


	@Override
	public long countAllAdmin(BasicDBObject queryObj) {
		// TODO Auto-generated method stub
		return AdminDao.countAllAdmin(queryObj);
	}


	@Override
	public List<AdminModel> getAdminList(BasicDBObject queryObj,int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		if(pageNow<=0)
			pageNow=1;
		if(pageSize <= 0)
			pageSize = Tables.PAGENUM; 
		int skip=(pageNow-1)*pageSize;
		return AdminDao.getAdminList(queryObj,skip,pageSize);
	}


	@Override
	public AdminModel findAdminById(String id) {
		// TODO Auto-generated method stub
		return AdminDao.findAdminById(id);
	}
	
	
	/**
	 * 通过accountName和password查询得到一个admin对象
	 */
	@Override
	public Object checkLogonByAccountName(String accountName, String password ) {
		// TODO Auto-generated method stub
		//通过accountName和password查询得到一个company对象
		Object obj = getAdminModel(accountName, password);
		return obj;
	}
	
	
	/**
	 * 通过accountName和password查询得到一个admin对象
	 * @param accountName
	 * @param password
	 * @return
	 */
	
	public AdminModel getAdminModel(String accountName, String password){
		return AdminDao.getModelByAccountNameAndPassword(accountName, password);
	}


	@Override
	public AdminModel getByAccountName(String accountName) {
		// TODO Auto-generated method stub
		return AdminDao.getByAccountName(accountName);
	}

	
}
