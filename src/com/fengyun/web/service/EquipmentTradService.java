package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.db.playermodel.EquipmentTradModel;
import com.mongodb.BasicDBObject;

public interface EquipmentTradService {
	
	
	List<EquipmentTradModel> getEquipmentTradList(BasicDBObject queryObj,int pageNow,int pageSize);
	
	
	/**
	 * 记录出入库记录条数
	 * @param queryObj
	 * @return
	 */
	long countAllEquipmentTrad(BasicDBObject queryObj);
	
	
	
	
	/**
	 * 删除设备商出入库记录
	 */
	void delEquipmentTrad(String id);

	/**
	 * 新增记录
	 * @param eName
	 * @param pName
	 * @param toolName
	 * @param principal
	 * @param year
	 * @param month
	 * @param day
	 * @param thisrent
	 * @param allrent
	 * @param thispay
	 * @param culapay
	 * @param otherpay
	 * @param restpay
	 * @param invoice
	 * @param note
	 * @param drawee
	 * @param payment
	 * @param serial
	 * @return
	 */
	boolean addEquipmentTrad(String eId,String pId, String eName, String pName,
			String toolName, String principal, String year, String month,
			String day, int thisrent, int allrent, int thispay, int culapay,
			int otherpay, int restpay, String invoice, String note,
			String drawee, String payment, String serial);


	List<EquipmentTradModel> getByEId(String pId, String eId);

	/**
	 * 条件分页查询出入口记录条数
	 * @param pName
	 * @param year
	 * @param month
	 * @param eId
	 * @return
	 */
	Long countEquipmentTrad(String pName, String year, String month, String eId);

	/**
	 * 条件分页查询出入口记录
	 * @param pName
	 * @param year
	 * @param month
	 * @param eId
	 * @param page
	 * @return
	 */
	List<EquipmentTradModel> getEquipmentTradList(String pName, String year,
			String month, String eId, Page page);




	
	

}
