package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.db.playermodel.LawInsuModel;
import com.mongodb.BasicDBObject;

public interface LawInsuService {

	List<LawInsuModel> getLawInsuList(BasicDBObject queryObj, int pageNow,
			int pageSize);

	long countAllLawInsu(BasicDBObject queryObj);

	void delLawInsu(String id);

	boolean addLawInsu(String title, int lawtype,String note);

	LawInsuModel getById(String id);

	void updateLawInsu(LawInsuModel model);

	List<LawInsuModel> getLawInsuList(int lawType);

}
