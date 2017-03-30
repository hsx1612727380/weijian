package com.fengyun.web.service.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;


import com.fengyun.web.cache.page.Page;
import com.fengyun.web.db.dao.CmdSummDAO;
import com.fengyun.web.db.dao.EquipmentTradDAO;
import com.fengyun.web.db.dao.MaterialTradDAO;
import com.fengyun.web.db.dao.Tables;

import com.fengyun.web.db.playermodel.CmdSummModel;
import com.fengyun.web.db.playermodel.EquipmentTradModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.MaterialTradModel;
import com.fengyun.web.service.MaterialTradService;
import com.mongodb.BasicDBObject;

@Service
public class MaterialTradServicelmpl implements MaterialTradService {

	@Override
	public List<MaterialTradModel> getMaterialTradList(BasicDBObject queryObj,int pageNow,int pageSize) {
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return MaterialTradDAO.getAll(queryObj,pageSize, skip);
	}

	@Override
	public long countAllMaterialTrad(BasicDBObject queryObj) {
		return MaterialTradDAO.countAll(queryObj);
	}
	
	
	/**
	 * 删除设备商出入库记录
	 */
	@Override
	public void delMaterialTrad(String id) {
		MaterialTradDAO.delete(id);
	}
	
	
	/**
	 * 新增材料商出入库记录
	 */
	@Override
	public boolean addMaterialTrad(String mId,String pId,String mName,String pName, String itemName, String principal, String year, String month, String day, String outTime, String  outNum, String allease,
			int thispay, int culapay, int otherpay, int restpay, String invoice, String note, String drawee, String payment, String serial) {
		MaterialTradModel model = new MaterialTradModel();
		model.setmId(mId);
		model.setpId(pId);
		model.setmName(mName);
		model.setpName(pName);
		model.setItemName(itemName);
		model.setPrincipal(principal);
		model.setYear(year);
		model.setMonth(month);
		model.setDay(day);
		model.setOutNum(outNum);
		model.setOutTime(outTime);
		model.setAllease(allease);
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
			MaterialTradDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * 通过项目Id，材料商id
	 */
	@Override
	public List<MaterialTradModel> getByMId(String pId, String mId) {
		return MaterialTradDAO.getByMId(pId,mId);
	}

	/**
	 * 统计材料商id为mId的设备商的出入库记录
	 * @param mId
	 * @return
	 */
	@Override
	public Long countMaterialTrad(String pName,String year,String month,String mId) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = getQueryObject(pName, year, month, mId);
		long count = this.countAllMaterialTrad(queryObj);
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
			String month, String mId) {
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
		queryObj.put("mId", mId);
		return queryObj;
	}

	/**
	 * 分页查询材料商的id为mId的材料商的出入库记录
	 * @param mId
	 * @param page
	 * @return
	 */
	@Override
	public List<MaterialTradModel> getMaterialTradList(String pName,String year,String month,String mId, Page page) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = getQueryObject(pName, year, month, mId);
		List<MaterialTradModel> materialTradList = this.getMaterialTradList(queryObj, page.getPageNow(), page.getPageSize());
		return materialTradList;
	}

}
