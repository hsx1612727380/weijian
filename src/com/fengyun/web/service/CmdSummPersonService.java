package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.db.playermodel.CmdSummPersonModel;

public interface CmdSummPersonService {
	
	/**
	 * 通过汇总Id查询明细表
	 * @param cmdId
	 * @return
	 */
	List<CmdSummPersonModel> getByCmd(String cmdId);
	
	/**
	 * 新增明细数据
	 * @return
	 */
	boolean addCmdSummPerson(String cmdId, String pId, int teamtype,
			String name, String userId, String account, String voucher,
			String inTime, String outTime, String safe, String attendance,
			String access, String identity, String workContent, int count,
			int salary, int deduct, int realSalary, int noSalary, String flag,
			String note, String tId, String payTime, String drawee,
			int paytype, String pName, int year, int month);

	/**
	 * 根据汇总表的ID、班组ID、班组类型、年份和月份进行查询
	 * @param cmdId
	 * @param tId
	 * @param teamtype
	 * @param year
	 * @param month
	 * @return
	 */
	List<CmdSummPersonModel> getByCmdIdAndTIdAndTeamTypeAndYearMonth(
			String cmdId, String tId, int teamtype, int year, int month);

	/**
	 * 检查某个员工在该月只有一条记录
	 * @param cmdId
	 * @param pId
	 * @param tId
	 * @param userId
	 * @param teamtype
	 * @param year
	 * @param month
	 * @return
	 */
	CmdSummPersonModel isRecordExist(String cmdId, String pId, String tId,
			String userId, int teamtype, int year, int month);

	/**
	 * 新增
	 * @param cmdSummPersonModel
	 * @return
	 */
	boolean addCmdSummPerson(CmdSummPersonModel cmdSummPersonModel);

	
}
