package com.fengyun.web.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.BidInfoDAO;
import com.fengyun.web.db.dao.EquipmentDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.playermodel.BidInfoModel;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.service.BidInfoService;
import com.mongodb.BasicDBObject;
@Service
public class BidInfoServicelmpl implements BidInfoService {
	
	@Override
	public List<BidInfoModel> getBidInfoList(BasicDBObject queryObj,int pageNow,int pageSize) {
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return BidInfoDAO.getAll(queryObj,pageSize, skip);
	}

	@Override
	public long countAllBidInfo(BasicDBObject queryObj) {
		return BidInfoDAO.countAll(queryObj);
	}
	
	/**
	 * 删除招标信息
	 */
	@Override
	public void delBidInfo(String id) {
		BidInfoDAO.delete(id);
	}
	
	
	/**
	 * 新增招标信息
	 */
	@Override
	public boolean addBidInfo(String title,String URL,int bidtype) {
		BidInfoModel model = new BidInfoModel();
		model.setTitle(title);
		model.setURL(URL);
		model.setBidtype(bidtype);
		try{
			BidInfoDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * 查询招标信息
	 * @param id
	 * @return
	 */
	@Override
	public BidInfoModel getById(String id) {
		return BidInfoDAO.getById(id);
	}
	
	/**
	 * 修改招标信息
	 * @param model
	 */
	@Override
	public void updateBidInfo(BidInfoModel model) {
		BidInfoDAO.update(model);
	}

}
