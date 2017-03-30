package com.fengyun.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.CmdSummDAO;
import com.fengyun.web.db.playermodel.CmdSummModel;
import com.fengyun.web.db.vo.TimeVo;
import com.fengyun.web.service.CmdSummService;
import com.mongodb.BasicDBObject;



@Service
public class CmdSummServicelmpl implements CmdSummService {

	/**
	 * 通过项目id查询汇总表
	 */
	@Override
	public List<CmdSummModel> getBypId(String pId) {
		return CmdSummDAO.getBypId(pId,null);
	}
	

	@Override
	public CmdSummModel getById(String id) {
		return CmdSummDAO.getById(id);
	}
	
	/**
	 * 通过项目Id，时间，供货类型
	 */
	@Override
	public List<CmdSummModel> getByType(int year, int month, String pId , int type) {
		return CmdSummDAO.getByType(year,month,pId,type);
	}
	
	
	/**
	 * 通过项目Id和时间查询汇总信息
	 */
	@Override
	public List<CmdSummModel> getByTime(int year, int month ,String pId) {
		return CmdSummDAO.getByTime(year, month ,pId);
	}
	
	
	/**
	 * 新增汇总信息
	 */
	@Override
	public boolean addCmdSumm(String pId, String pName, String tId, int type, int teamtype, String tName, int contractPrice,
			int bgpayment,int frequency , String unit, int total, int nowTotal, int percentage, int thispay, int culapay,
			int remain, int culPercentage, int deposit, String settlement, String note, int year, int month) {
		CmdSummModel model = new CmdSummModel();
		model.setpId(pId);
		model.setpName(pName);
		model.settId(tId);
		model.setType(type);
		model.setTeamtype(teamtype);
		model.settName(tName);
		model.setContractPrice(contractPrice);
		model.setBgpayment(bgpayment);
		model.setFrequency(frequency);
		model.setUnit(unit);
		model.setTotal(total);
		model.setNowTotal(nowTotal);
		model.setPercentage(percentage);
		model.setThispay(thispay);
		model.setCulapay(culapay);
		model.setRemain(remain);
		model.setCulPercentage(culPercentage);
		model.setDeposit(deposit);
		model.setSettlement(settlement);
		model.setNote(note);
		model.setYear(year);
		model.setMonth(month);
		try{
			CmdSummDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 新增人工汇总信息
	 */
	@Override
	public boolean addPersonCmdSumm(String pId, String pName, String tId, int type, int teamtype, String tName, int contractPrice,
			int bgpayment,int frequency , String unit, int total, int nowTotal, int percentage, int thispay, int culapay,
			int thisSalary, int noSalary, String settlement, String note, int year, int month, int remain ,int deposit,int culPercentage) {
		CmdSummModel model = new CmdSummModel();
		model.setpId(pId);
		model.setpName(pName);
		model.settId(tId);
		model.setType(type);
		model.setTeamtype(teamtype);
		model.settName(tName);
		model.setContractPrice(contractPrice);
		model.setBgpayment(bgpayment);
		model.setFrequency(frequency);
		model.setUnit(unit);
		model.setTotal(total);
		model.setNowTotal(nowTotal);
		model.setPercentage(percentage);
		model.setThispay(thispay);
		model.setCulapay(culapay);
		model.setThisSalary(thisSalary);
		model.setNoSalary(noSalary);
		model.setSettlement(settlement);
		model.setNote(note);
		model.setYear(year);
		model.setMonth(month);
		model.setRemain(remain);
		model.setDeposit(deposit);
		model.setCulPercentage(culPercentage);
		try{
			CmdSummDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 新增供应商汇总信息
	 */
	@Override
	public boolean addSupplierCmdSumm(String pId, String pName, String tId, int type, int teamtype, String tName, String principal,
			String account,String unit,int frequency , int budget, int num, int price, int subtotal, int bgpayment,
			int receipt, int cumulative, int thispay, int culapay ,int otherpay,int restpay,String settlement, String note, int year,int month,
			int contractPrice,int total,int nowTotal,int percentage,int remain,int culPercentage,int deposit,String invoice) {
		CmdSummModel model = new CmdSummModel();
		model.setpId(pId);
		model.setpName(pName);
		model.settId(tId);
		model.setType(type);
		model.setTeamtype(teamtype);
		model.settName(tName);
		model.setPrincipal(principal);
		model.setAccount(account);
		model.setFrequency(frequency);
		model.setUnit(unit);
		model.setBudget(budget);
		model.setNum(num);
		model.setPrice(price);
		model.setThispay(thispay);
		model.setCulapay(culapay);
		model.setSubtotal(subtotal);
		model.setBgpayment(bgpayment);
		model.setSettlement(settlement);
		model.setNote(note);
		model.setYear(year);
		model.setMonth(month);
		model.setReceipt(receipt);
		model.setCumulative(cumulative);
		model.setOtherpay(otherpay);
		model.setRestpay(restpay);
		model.setContractPrice(contractPrice);
		model.setTotal(total);
		model.setNowTotal(nowTotal);
		model.setPercentage(percentage);
		model.setRemain(remain);
		model.setCulPercentage(culPercentage);
		model.setDeposit(deposit);
		model.setInvoice(invoice);
		try{
			CmdSummDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	@Override
	public List<TimeVo> getCmdTime(String pId) {
		BasicDBObject order = new BasicDBObject(3);
		order.put("year", -1);
		order.put("month", -1);
		
		List<CmdSummModel> cmdModels = CmdSummDAO.getBypId(pId,order);
		List<String> list = new ArrayList<String>();
		List<TimeVo> tModels = new ArrayList<TimeVo>();
		if(cmdModels != null && cmdModels.size() > 0){
			for(CmdSummModel model:cmdModels){
				if(list.contains("" + model.getYear() + model.getMonth()))
					continue;
				list.add("" + model.getYear() + model.getMonth());
				tModels.add(new TimeVo(model.getYear(),model.getMonth()));
			}
		}
		return tModels;
	}

	/**
	 * 根据时间、项目的ID和班组的类型查询
	 */
	@Override
	public List<CmdSummModel> getByTimeAndTypeAndTeamtype(int year, int month,
			String projectId, int type, int teamType) {
		return CmdSummDAO.getByTimeAndTypeAndTeamtype(year, month ,projectId, type, teamType);
	}

	/**
	 * 一个施工班组(材料商、设备商)在一个项目中的一个月在汇总表中只能存在一条记录，检查是否已经存在
	 */
	@Override
	public CmdSummModel cmdSummRepCHeck(String projectId, String tId, int year, int month) {
		return CmdSummDAO.cmdSummRepCHeck(projectId, tId, year, month);
	}

	/**
	 * 新增
	 */
	@Override
	public boolean addCmdSumm(CmdSummModel cmdSummModel) {
		return CmdSummDAO.addCmdSumm(cmdSummModel);
	}

	/**
	 * 根据时间、班组类别、班组类型、项目的ID、班组的ID查询 - 判断这个时间班组的数据是否存在
	 */
	@Override
	public CmdSummModel getByTimeAndTypesAndIds(int year, int month, int type,
			int teamtype, String projectId, String vId) {
		return CmdSummDAO.getByTimeAndTypesAndIds(year, month, type, teamtype, projectId, vId);
	}

	
	
	

}
