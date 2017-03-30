package com.fengyun.web.db.dao;

import java.util.List;

import org.bson.types.ObjectId;

import mmo.common.data.db.MongoDBManager;



import com.fengyun.web.db.playermodel.PayrollRecordModel;
import com.mongodb.BasicDBObject;

public class PayrollRecordDAO {
	
	/** 公共sql **/
	private static final String tableName = Tables.PayrollRecord;
	
	/**
	 * 插入新记录
	 * 
	 * @param model
	 */
	public synchronized static void insert(PayrollRecordModel model) {
		MongoDBManager.insert(tableName, model);
	}
	
	/**
	 * 获得所有项目
	 * @param id
	 * @return
	 */
	public static List<PayrollRecordModel> getAll(BasicDBObject queryObj,int row,int skip) {
		List<PayrollRecordModel> models = MongoDBManager.find(tableName,queryObj,row,skip);//
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
	public static boolean update(PayrollRecordModel model) {
		return MongoDBManager.update(tableName, model);
	}
	
	
	/**
	 * 查询某个人员工资发放记录
	 */
	public static PayrollRecordModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		
		return MongoDBManager.findOne(tableName, queryObj);
	}
	
	
	/**
	 * 查询某一个项目的工资发放记录
	 */
	public static List<PayrollRecordModel> getBypCode(String pCode) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("pCode", pCode);
		
		List<PayrollRecordModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}
	
	
	/**
	 * 查询某一个项目的某一个班组的工资发放记录
	 */
	public static List<PayrollRecordModel> getByPCodeANDcode(String pCode, String code) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("pCode", pCode);
		queryObj.put("code", code);
		List<PayrollRecordModel> models = MongoDBManager.find(tableName, queryObj);
		return models;
	}

	/**
	 * 前台页面获取工资记录列表(不分页操作)
	 * @param queryObj
	 * @return
	 */
	public static List<PayrollRecordModel> getPayrollRecordOneList(
			BasicDBObject queryObj) {
		return MongoDBManager.find(tableName, queryObj);
	}

	/**
	 * 查询某个月份的数据
	 * @param queryObj
	 * @return
	 */
	public static PayrollRecordModel getPayrollRecordOnly(BasicDBObject queryObj) {
		return MongoDBManager.findOne(tableName, queryObj);
	}

	/**
	 * 新增
	 * @param payrollRecordModel
	 * @return
	 */
	public static boolean addPayrollRecord(PayrollRecordModel payrollRecordModel) {
		return MongoDBManager.insert(tableName, payrollRecordModel);
	}

	/**
	 * 根据项目的code和施工班组的code查询记录数
	 * @param pCode
	 * @param tCode
	 * @return
	 */
	public static Long getCountByPCodeAndTCode(String pCode, String tCode) {
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("pCode", pCode);
		queryObj.put("code", tCode);
		return MongoDBManager.getCount(tableName, queryObj);
	}

	/**
	 * 分页查询
	 * @param queryObj
	 * @param pageSize
	 * @param skip
	 * @return
	 */
	public static List<PayrollRecordModel> getAllByPageAndPCodeAndTCode(
			BasicDBObject queryObj, int row, int skip) {
		return MongoDBManager.find(tableName, queryObj , row, skip);
	}

}
