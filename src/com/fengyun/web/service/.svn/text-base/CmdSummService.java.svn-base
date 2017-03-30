package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.db.playermodel.CmdSummModel;
import com.fengyun.web.db.vo.TimeVo;

public interface CmdSummService {


	List<CmdSummModel> getBypId(String pId);

	boolean addCmdSumm(String pId, String pName, String tId, int type,
			int teamtype, String tName, int contractPrice, int bgpayment,
			int frequency, String unit, int total, int nowTotal,
			int percentage, int thispay, int culapay, int remain,
			int culPercentage, int deposit, String settlement, String note,
			int year, int month);

	List<CmdSummModel> getByTime(int year, int month ,String pId);

	

	List<CmdSummModel> getByType(int year, int month, String pId, int type);

	
	CmdSummModel getById(String id);
	

	

	 boolean addPersonCmdSumm(String pId, String pName, String tId,
			int type, int teamtype, String tName, int contractPrice,
			int bgpayment, int frequency, String unit, int total, int nowTotal,
			int percentage, int thispay, int culapay, int thisSalary,
			int noSalary, String settlement, String note, int year, int month,
			int remain, int deposit,int culPercentage);

	

	boolean addSupplierCmdSumm(String pId, String pName, String tId,
			int type, int teamtype, String tName, String principal,
			String account, String unit, int frequency, int budget, int num,
			int price, int subtotal, int bgpayment, int receipt,
			int cumulative, int thispay, int culapay, int otherpay,
			int restpay, String settlement, String note, int year, int month,
			int contractPrice, int total, int nowTotal, int percentage,
			int remain, int culPercentage, int deposit,String invoice);

	 /**
	  * 获取汇总时间列表
	  * @param code
	  * @return
	  */
	public List<TimeVo> getCmdTime(String pId);

	/**
	 * 根据时间、项目的ID和班组的类型查询
	 * @param year
	 * @param month
	 * @param projectId
	 * @param type
	 * @param teamType
	 * @return
	 */
	List<CmdSummModel> getByTimeAndTypeAndTeamtype(int year, int month, String projectId, int type, int teamType);

	/**
	 * 一个施工班组(材料商、设备商)在一个项目中的一个月在汇总表中只能存在一条记录，检查是否已经存在
	 * @param projectId
	 * @param tId
	 * @param year
	 * @param month
	 * @return
	 */
	CmdSummModel cmdSummRepCHeck(String projectId, String tId, int year, int month);

	/**
	 * 新增
	 * @param cmdSummModel
	 * @return
	 */
	boolean addCmdSumm(CmdSummModel cmdSummModel);

	/**
	 * 根据时间、班组类别、班组类型、项目的ID、班组的ID查询 - 判断这个时间班组的数据是否存在
	 * @param year
	 * @param month
	 * @param type
	 * @param teamtype
	 * @param projectId
	 * @param vId
	 * @return
	 */
	CmdSummModel getByTimeAndTypesAndIds(int year, int month, int type,
			int teamtype, String projectId, String vId);

}
