package com.fengyun.web.service;

import java.util.List;


import com.fengyun.web.db.playermodel.CmdSummSupplierModel;
import com.mongodb.BasicDBObject;

public interface CmdSummSupplierService {
	
	/**
	 * 通过汇总Id查询明细
	 * @param cmdId
	 * @return
	 */
	List<CmdSummSupplierModel> getByCmd(String cmdId);

	boolean addCmdSummSupplier(String cmdId,String pId,String pName,int type,int teamtype,String tId,String tName, String principal, String cName,
			String account, String unit, int frequency, int num, int price,
			int subtotal, int thispay, int culapay, int otherpay, int restpay,
			int bgpayment, int budget, int receipt, int cumulative,
			String information, String invoice, String settlement,
			String using, String quality, String note,int year,int month);

	/**
	 * 根据汇总表的ID、材料商或设备商的ID、班组类型(1-本班组，2-劳务班组，3-专业班组)、班组类别(1-租赁方，2-材料商，3-设备商)、年份、月份查询
	 * @param cmdId
	 * @param tId
	 * @param teamtype
	 * @param type
	 * @param year
	 * @param month
	 * @return
	 */
	List<CmdSummSupplierModel> getByCmdIdAndTIdAndTeamTypeAndYearMonth(String cmdId,
			String tId, int teamtype, int type, int year, int month);

	/**
	 * 新增
	 * @param cmdSummSupplierModel
	 * @return
	 */
	boolean addCmdSummSupplier(CmdSummSupplierModel cmdSummSupplierModel);

}
