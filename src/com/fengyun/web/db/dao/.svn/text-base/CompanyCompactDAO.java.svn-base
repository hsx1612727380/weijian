package com.fengyun.web.db.dao;

import java.util.List;

import org.bson.types.ObjectId;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.CompanyCompactModel;
import com.mongodb.BasicDBObject;

/**
 * 公司合同的DAO层
 * @author hsx
 *
 */
public class CompanyCompactDAO {

	/** 公共sql **/
	private static final String tableName = Tables.CompanyCompact;
	
	/**
	 * 根据公司的code查询公司合同
	 * @param code
	 * @return
	 */
	public static List<CompanyCompactModel> getByCode(String code) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("code", code);
		return MongoDBManager.find(tableName, queryObj);
	}

	/**
	 * 新增
	 * @param model
	 */
	public synchronized static void insert(CompanyCompactModel model) {
		MongoDBManager.insert(tableName, model);
	}

	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public static CompanyCompactModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 修改并保存
	 * @param companyCompactModel
	 * @return
	 */
	public static boolean update(CompanyCompactModel companyCompactModel) {
		return MongoDBManager.update(tableName, companyCompactModel);
	}

	/**
	 * 根据项目名称查询
	 * @param pName
	 * @return
	 */
	public static CompanyCompactModel getByProjectName(String pName) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("projectName", pName);
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 分页查询
	 * @param code
	 * @param skip
	 * @param pageSize
	 * @return
	 */
	public static List<CompanyCompactModel> getCompanyCompactList(String code,
			int skip, int pageSize) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("code", code);
		return MongoDBManager.find(tableName, queryObj, pageSize, skip);
	}
	
}
