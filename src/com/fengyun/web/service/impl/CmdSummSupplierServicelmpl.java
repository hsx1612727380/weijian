package com.fengyun.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;



import com.fengyun.web.db.dao.CmdSummSupplierDAO;
import com.fengyun.web.db.dao.Tables;

import com.fengyun.web.db.playermodel.CmdSummSupplierModel;
import com.fengyun.web.service.CmdSummSupplierService;

@Service
public class CmdSummSupplierServicelmpl implements CmdSummSupplierService {
	private static final String tableName=Tables.CmdSummSupplier;
	
	
	/**
	 * 通过汇总id来查询
	 */
	@Override
	public List<CmdSummSupplierModel> getByCmd(String cmdId) {
		return CmdSummSupplierDAO.getByCmd(cmdId);
	}
	
	
	
	
	
	/**
	 * 新增供应商明细数据
	 * @return
	 */
	
	@Override
	public boolean addCmdSummSupplier(String cmdId,String pId,String pName,int type,int teamtype,String tId,String tName, String principal, String cName, String account, String unit, int frequency, int num,
			int price, int subtotal, int thispay, int culapay, int otherpay, int restpay, int bgpayment, int budget, int receipt,
			int cumulative, String information, String invoice, String settlement, String using, String quality, String note,int year,int month) {
		CmdSummSupplierModel model = new CmdSummSupplierModel();
		model.settName(tName);
		model.setPrincipal(principal);
		model.setcName(cName);
		model.setAccount(account);
		model.setUnit(unit);
		model.setFrequency(frequency);
		model.setNum(num);
		model.setPrice(price);
		model.setSubtotal(subtotal);
		model.setThispay(thispay);
		model.setCulapay(culapay);
		model.setOtherpay(otherpay);
		model.setRestpay(restpay);
		model.setBgpayment(bgpayment);
		model.setBudget(budget);
		model.setReceipt(receipt);
		model.setCumulative(cumulative);
		model.setInformation(information);
		model.setInvoice(invoice);
		model.setSettlement(settlement);
		model.setUsing(using);
		model.setQuality(quality);
		model.setNote(note);
		model.setYear(year);
		model.setMonth(month);
		model.setpId(pId);
		model.setType(type);
		model.setpName(pName);
		model.setCmdId(cmdId);
		model.settId(tId);
		model.setTeamtype(teamtype);
		
		try{
			CmdSummSupplierDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	/**
	 * 根据汇总表的ID、材料商或设备商的ID、班组类型(1-本班组，2-劳务班组，3-专业班组)、班组类别(1-租赁方，2-材料商，3-设备商)、年份、月份查询
	 */
	@Override
	public List<CmdSummSupplierModel> getByCmdIdAndTIdAndTeamTypeAndYearMonth(
			String cmdId, String tId, int teamtype, int type, int year,
			int month) {
		return CmdSummSupplierDAO.getByCmdIdAndTIdAndTeamTypeAndYearMonth(cmdId, tId, teamtype, type, year, month);
	}

	/**
	 * 新增
	 */
	@Override
	public boolean addCmdSummSupplier(CmdSummSupplierModel cmdSummSupplierModel) {
		return CmdSummSupplierDAO.addCmdSummSupplier(cmdSummSupplierModel);
	}
	

}
