package com.fengyun.web.service;


import java.util.List;

import com.fengyun.web.db.playermodel.AptitudeModel;
import com.mongodb.BasicDBObject;

public interface AptitudeService {

	

	void delAptitude(String id);

	void updateAptitude(AptitudeModel model);

	
	List<AptitudeModel> getByCode(String code);

	AptitudeModel getById(String id);

	boolean addAptitude(String code, String certificate,
			int adtype, int adlevel, String approval, String approvalTime,
			String validity);

	
}
