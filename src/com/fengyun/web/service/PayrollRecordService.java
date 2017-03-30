package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.db.playermodel.PayrollRecordModel;
import com.mongodb.BasicDBObject;

public interface PayrollRecordService {

	void updatePayrollRecord(PayrollRecordModel model);

	PayrollRecordModel getById(String id);

	void delPayrollRecord(String id);

	long countAllPayrollRecord(BasicDBObject queryObj);

	List<PayrollRecordModel> getPayrollRecordList(BasicDBObject queryObj,
			int pageNow, int pageSize);

	boolean addPayrollRecord(String pCode, String name, String userId,
			String code, String startTime, String endTime, int salary,
			int realSalary, int noSalary, int tax, String drawee, int paytype,
			String serial, int confirm, String payTime);

	List<PayrollRecordModel> getBypCode(String pCode);

	List<PayrollRecordModel> getByPCodeANDcode(String pCode, String code);

	/**
	 * 根据班组id和查询条件  查询到当前班组的工资记录条数 
	 * @author zss
	 * @param tCode
	 * @param name
	 * @param inTime
	 * @param outTime
	 * @param pName 
	 * @return
	 */
	long countPayRoll(String tCode, String name, String inTime, String outTime, String pName);

	/**
	 * 根据班组id和查询条件  查询到当前班组的工资记录列表
	 * @author zss
	 * @param tCode
	 * @param name
	 * @param inTime
	 * @param outTime
	 * @param pName 
	 * @param pName 
	 * @return
	 */
	List<PayrollRecordModel> getPayRollByPage(String tCode, int pageNow,
		int pageSize, String name, String inTime, String outTime, String pName);

	/**
	 * 前台页面获取工资记录列表(不分页操作)
	 * @param queryObj
	 * @return
	 */
	List<PayrollRecordModel> getPayrollRecordOneList(BasicDBObject queryObj);

	List<PayrollRecordModel> sortPayList(List<PayrollRecordModel> paylist);
	
	/**
	 * 判断是否已经存在这个月的记录
	 * @param queryObj
	 * @return
	 */
	PayrollRecordModel getPayrollRecordOnly(BasicDBObject queryObj);

	/**
	 * 新增
	 * @param payrollRecordModel
	 * @return
	 */
	boolean addPayrollRecord(PayrollRecordModel payrollRecordModel);

	/**
	 * 根据项目的code和施工班组的code查询记录数
	 * @param pCode
	 * @param tCode
	 * @return
	 */
	Long getCountByPCodeAndTCode(String pCode, String tCode);

	/**
	 * 根据项目的code和施工班组的code分页查询
	 * @param page
	 * @param pCode
	 * @param tCode
	 * @return
	 */
	List<PayrollRecordModel> getAllByPageAndPCodeAndTCode(Page page,
			String pCode, String tCode);

}
