package com.fengyun.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.CmdSummPersonDAO;
import com.fengyun.web.db.playermodel.CmdSummPersonModel;
import com.fengyun.web.service.CmdSummPersonService;
@Service
public class CmdSummPersonServicelmpl implements CmdSummPersonService {

	
	/**
	 * 通过汇总Id查询人工明细表
	 */
	@Override
	public List<CmdSummPersonModel> getByCmd(String cmdId) {
		return CmdSummPersonDAO.getByCmd(cmdId);
	}
	
	
	
	
	

	/**
	 * 根据汇总表的ID、班组ID、班组类型、年份和月份进行查询
	 */
	@Override
	public List<CmdSummPersonModel> getByCmdIdAndTIdAndTeamTypeAndYearMonth(
			String cmdId, String tId, int teamtype, int year, int month) {
		return CmdSummPersonDAO.getByCmdIdAndTIdAndTeamTypeAndYearMonth(cmdId, tId, teamtype, year, month);
	}

	/**
	 * 新增个人明细
	 */
	@Override
	public boolean addCmdSummPerson(String cmdId, String pId, int teamtype, String name,
			String userId, String account, String voucher, String inTime,
			String outTime, String safe, String attendance, String access,
			String identity, String workContent, int count, int salary,
			int deduct, int realSalary, int noSalary, String flag, String note,
			String tId, String payTime, String drawee, int paytype,
			String pName, int year, int month) {
		CmdSummPersonModel model = new CmdSummPersonModel();
		model.setCmdId(cmdId);
		model.setpId(pId);
		model.setTeamtype(teamtype);
		model.setName(name);
		model.setUserId(userId);
		model.setAccount(account);
		model.setVoucher(voucher);
		model.setInTime(inTime);
		model.setOutTime(outTime);
		model.setSafe(safe);
		model.setAttendance(attendance);
		model.setAccess(access);
		model.setIdentity(identity);
		model.setWorkContent(workContent);
		model.setCount(count);
		model.setSalary(salary);
		model.setDeduct(deduct);
		model.setRealSalary(realSalary);
		model.setNoSalary(noSalary);
		model.setFlag(flag);
		model.setNote(note);
		model.settId(tId);
		model.setPayTime(payTime);
		model.setPaytype(paytype);
		model.setDrawee(drawee);
		model.setpName(pName);
		model.setYear(year);
		model.setMonth(month);
		try{
			CmdSummPersonDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 检查某个员工在该月只有一条记录
	 */
	@Override
	public CmdSummPersonModel isRecordExist(String cmdId, String pId,
			String tId, String userId, int teamtype, int year, int month) {
		return CmdSummPersonDAO.isRecordExist(cmdId, pId, tId, userId, teamtype, year, month);
	}

	/**
	 * 新增
	 */
	@Override
	public boolean addCmdSummPerson(CmdSummPersonModel cmdSummPersonModel) {
		return CmdSummPersonDAO.addCmdSummPerson(cmdSummPersonModel);
	}






	
	
	
	

	

}
