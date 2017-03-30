package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.db.playermodel.BidInfoModel;
import com.mongodb.BasicDBObject;

public interface BidInfoService {

	List<BidInfoModel> getBidInfoList(BasicDBObject queryObj, int pageNow,
			int pageSize);

	long countAllBidInfo(BasicDBObject queryObj);

	void delBidInfo(String id);

	boolean addBidInfo(String title, String URL, int bidtype);

	void updateBidInfo(BidInfoModel model);

	BidInfoModel getById(String id);

}
