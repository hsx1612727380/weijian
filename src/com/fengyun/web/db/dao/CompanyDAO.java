package com.fengyun.web.db.dao;

import java.util.List;

import mmo.common.data.db.MongoDBManager;

import org.bson.types.ObjectId;

import com.fengyun.web.db.playermodel.CompanyModel;
import com.mongodb.BasicDBObject;

public class CompanyDAO {

	/** 公共sql **/
	private static final String tableName = Tables.Company;
	
	
	
	/**
	 * 查询某公司
	 * @param id
	 * @return
	 */
	public static CompanyModel getByCode(String code) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("code", code);
		return MongoDBManager.findOne(tableName, queryObj);
	}
	/**
	 * 查询某公司信息
	 * @param id
	 * @return
	 */
	public static CompanyModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(CompanyModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	/**
	 * 获得所有项目
	 * @param id
	 * @return
	 */
	public static List<CompanyModel> getAll(BasicDBObject queryObj,int row,int skip) {
		List<CompanyModel> models = MongoDBManager.find(tableName,queryObj,row,skip);//
		return models;
	}
	
	public static long countAll(BasicDBObject queryObj){
		return MongoDBManager.getCount(tableName,queryObj);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public static void delete(String id){
		MongoDBManager.delete(tableName, id, null);
	}
	
	/**
	 * 更新保存model
	 * 
	 * @param model
	 */
	public static boolean update(CompanyModel model) {
		return MongoDBManager.update(tableName, model);
	}
	
	/**
	 * 更新部分字段
	 * @param id
	 * @param playerId
	 * @param fieldObj
	 * @return
	 */
	public static void update(String id, BasicDBObject fieldObj) {
		MongoDBManager.updateFields(tableName, id, fieldObj,null);
	}

	/**
	 * 审核通过
	 * @param model
	 */
	public static void updateStatus(CompanyModel model) {
		//生产json格式
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("status", model.getStatus());
		
		update(model.getId(), fieldObj);
	}
	public static CompanyModel mobilRepCHeck(String mobilPhone) {
		// TODO Auto-generated method stub
		BasicDBObject fieldObj = new BasicDBObject(2);
		fieldObj.put("userId",mobilPhone);
		return MongoDBManager.findOne(tableName, fieldObj);
	}
	/**
	 * 通过userId和password查询得到一个company对象
	 * @param userId
	 * @param password
	 * @return
	 */
	public static CompanyModel getModelByUserIdAndPassword(String userId, String password){
		BasicDBObject company = new BasicDBObject(2);
		company.put("userId", userId);
		company.put("password", password);
		CompanyModel theCompany = MongoDBManager.findOne(tableName, company);
		System.out.println("CompanyDao 中查询到的company对象："+theCompany);
		return theCompany;
	}
	
	
	public static CompanyModel getCompanyByOrganization(String organization){
		BasicDBObject company = new BasicDBObject(2);
		company.put("organization", organization);
		CompanyModel theCompany = MongoDBManager.findOne(tableName, company);
		return theCompany;
	}
	
	
	public static void addCompany(CompanyModel companyModel) {
		// TODO Auto-generated method stub
		MongoDBManager.insert(tableName, companyModel);
	}

	
	public static CompanyModel getByName(String name){
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("name",name);
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	/**
	 * 根据企业密码和id
	 * @param password
	 * @param id
	 * @return
	 */
	public static CompanyModel getByPasswordAndId(String password, String id) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("password", password);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	
}







