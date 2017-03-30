package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.db.playermodel.CompanyModel;
import com.mongodb.BasicDBObject;

public interface CompanyService {

	/** 新增公司 */
	public boolean addCompany(String name, String code, String userId, String leaderName, String province, String city,
			String street,String type,int status,String regType,String regMoney,String organization,String tel);
	/**公司注册*/
	public boolean regCompany(CompanyModel model);
	
	/**获取所有公司*/
	public List<CompanyModel> getCompanyList(BasicDBObject queryObj,int pageNow,int pageSize);
	
	/**获取公司总数*/
	public long countAllCompany(BasicDBObject queryObj);
	
	/**
	 * 删除公司
	 */
	public void delCompany(String id);
	
	/**根据ID获取公司信息*/
	public CompanyModel getById(String id);
	
	/**更新公司信息*/
	public void updateCompany(CompanyModel model);
	
	/**审核公司*/
	public void companyPass(String id);
	
	/**根据公司代码*/
	public CompanyModel getByCode(String code);

	public String mobilRepCHeck(String userId);
	
	/**根据userId获取公司信息*/
	public CompanyModel getByUserId(String userId);
	
	
	public void addCompany(CompanyModel model);
	
	/**
	 * 通过公司名称获取公司信息
	 * @param name
	 * @return
	 */
	public CompanyModel getByName(String name);
	
	
	public CompanyModel getCompanyByOrganization(String organization);
	
	/**
	 * 判断企业账号的密码是否输入正确
	 * @param password
	 * @param id
	 * @return
	 */
	public String companyModfiyCompanyPasswordRepCHeck(String password,
			String id);
	
	
}
