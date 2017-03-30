package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.db.playermodel.AccrecordModel;
import com.mongodb.BasicDBObject;

public interface AccrecordService {
	/** 新增人员出入记录 */
	boolean addAccrecord(String pCode, String userId, String code,
			String recordTime, int confirm,String name,int type);

	/** 获取人员出入记录总数 */
	public long countAllAccrecord(BasicDBObject queryObj);

	/**
	 * 删除人员出入记录
	 */
	public void delAccrecord(String id);

	/** 根据ID获取人员出入记录 */
	public AccrecordModel getById(String id);

	/** 更新人员出入记录 */
	public void updateAccrecord(AccrecordModel model);

	
	
	
	
	/**
	 * 获取人员出入记录列表 
	 * @param queryObj
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */

	List<AccrecordModel> getAccrecordList(BasicDBObject queryObj, int pageNow,
			int pageSize);

	List<AccrecordModel> getBypCode(String pCode);

	/**
	 * 统计人员出入记录条数
	 * @param teamCode
	 * @param name
	 * @param pName
	 * @param startDate
	 * @param endDate
	 * @param type 
	 * @return
	 */
	long countPersonIORecord(String teamCode, String name, String pName,
			String startDate, String endDate, int type);

	/**
	 * 查询人员出入记录列表
	 * @param teamCode
	 * @param pageNow
	 * @param pageSize
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @param type 
	 * @return
	 */
	List<AccrecordModel> getPersonIORecordListByPage(String teamCode,
			int pageNow, int pageSize, String name, String pName, String startDate,
			String endDate, int type);

	List<AccrecordModel> sortAccrecordList(List<AccrecordModel> list);

	/**
	 * 新增
	 * @param accrecordModel
	 */
	boolean addAccrecord(AccrecordModel accrecordModel);

	/**
	 * 根据查询条件查询出入记录
	 * @param queryObj
	 * @return
	 */
	List<AccrecordModel> getList(BasicDBObject queryObj);

	

	

}
