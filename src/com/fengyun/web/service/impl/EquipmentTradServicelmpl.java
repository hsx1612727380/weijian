package com.fengyun.web.service.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.db.dao.EquipmentTradDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.playermodel.EquipmentTradModel;
import com.fengyun.web.db.playermodel.MaterialTradModel;
import com.fengyun.web.service.EquipmentTradService;
import com.mongodb.BasicDBObject;

@Service
public class EquipmentTradServicelmpl implements EquipmentTradService {
	
	@Override
	public List<EquipmentTradModel> getEquipmentTradList(BasicDBObject queryObj,int pageNow,int pageSize) {
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return EquipmentTradDAO.getAll(queryObj,pageSize, skip);
	}

	@Override
	public long countAllEquipmentTrad(BasicDBObject queryObj) {
		return EquipmentTradDAO.countAll(queryObj);
	}
	
	/**
	 * 删除设备商出入库记录
	 */
	@Override
	public void delEquipmentTrad(String id) {
		EquipmentTradDAO.delete(id);
	}
	
	
	/**
	 * 新增设备商出入库记录
	 */
	@Override
	public boolean addEquipmentTrad(String eId,String pId,String eName,String pName, String toolName, String principal, String year, String month, String day, int thisrent, int allrent,
			int thispay, int culapay, int otherpay, int restpay, String invoice, String note, String drawee, String payment, String serial) {
		EquipmentTradModel model = new EquipmentTradModel();
		model.setpId(pId);
		model.seteId(eId);
		model.seteName(eName);
		model.setpName(pName);
		model.setToolName(toolName);
		model.setPrincipal(principal);
		model.setYear(year);
		model.setMonth(month);
		model.setThisrent(thisrent);
		model.setAllrent(allrent);
		model.setThispay(thispay);
		model.setCulapay(culapay);
		model.setOtherpay(otherpay);
		model.setRestpay(restpay);
		model.setInvoice(invoice);
		model.setNote(note);
		model.setDrawee(drawee);
		model.setPayment(payment);
		model.setSerial(serial);
		try{
			EquipmentTradDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * 通过项目Id，设备商id
	 */
	@Override
	public List<EquipmentTradModel> getByEId(String pId, String eId) {
		return EquipmentTradDAO.getByEId(pId,eId);
	}
	



	
	
	/**
	 * 统计材料商id为mId的设备商的出入库记录
	 * @param mId
	 * @return
	 */
	@Override
	public Long countEquipmentTrad(String pName,String year,String month,String eId) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = getQueryObject(pName, year, month, eId);
		long count = this.countAllEquipmentTrad(queryObj);
		return count;
	}
	
	/**
	 * 封装前台的查询条件到queryObj中
	 * @param pName
	 * @param year
	 * @param month
	 * @param mId
	 * @return
	 */
	public BasicDBObject getQueryObject(String pName, String year,
			String month, String eId) {
		BasicDBObject queryObj = new BasicDBObject(5);
		if(!StringUtils.isEmpty(pName)){
			Pattern pNamePattern = Pattern.compile(".*" + pName + ".*",
					Pattern.CASE_INSENSITIVE);
			queryObj.put("pName", pNamePattern);
		}
		if(!StringUtils.isEmpty(year)){
			queryObj.put("year", year);
		}
		if(!StringUtils.isEmpty(month)){
			queryObj.put("month", month);
		}
		queryObj.put("eId", eId);
		return queryObj;
	}

	/**
	 * 分页查询材料商的id为mId的材料商的出入库记录
	 * @param mId
	 * @param page
	 * @return
	 */
	@Override
	public List<EquipmentTradModel> getEquipmentTradList(String pName,String year,String month,String eId, Page page) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = getQueryObject(pName, year, month, eId);
		List<EquipmentTradModel> materialTradList = this.getEquipmentTradList(queryObj, page.getPageNow(), page.getPageSize());
		return materialTradList;
	}

	
	
	
	
	
	
	

}
