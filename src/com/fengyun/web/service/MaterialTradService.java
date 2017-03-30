package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.db.playermodel.MaterialTradModel;
import com.mongodb.BasicDBObject;

public interface MaterialTradService {

	List<MaterialTradModel> getMaterialTradList(BasicDBObject queryObj,
			int pageNow, int pageSize);

	long countAllMaterialTrad(BasicDBObject queryObj);

	boolean addMaterialTrad(String mCode,String pId,String mName, String pName, String itemName,
			String principal, String year, String month, String day,
			String outTime, String outNum, String allease, int thispay,
			int culapay, int otherpay, int restpay, String invoice,
			String note, String drawee, String payment, String serial);

	List<MaterialTradModel> getByMId(String pId, String mCode);

	void delMaterialTrad(String id);
	
	/**
	 * 统计材料商id为mId的设备商的出入库记录
	 * @param mId
	 * @return
	 */
	Long countMaterialTrad(String pName,String year,String month,String mId);

	/**
	 * 分页查询材料商的id为mId的设备商的出入库记录
	 * @param mId
	 * @param page
	 * @return
	 */
	List<MaterialTradModel> getMaterialTradList(String pName,String year,String month,String mId, Page page);

}
