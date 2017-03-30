package com.fengyun.web.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


import com.fengyun.web.db.dao.BehaviorDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.playermodel.BehaviorModel;
import com.fengyun.web.service.BehaviorService;
import com.mongodb.BasicDBObject;


@Service
public class BehaviorServicelmpl implements BehaviorService {
	
	/**
	 * 新增
	 */
	@Override
	public boolean addBehavior(String code,String title, int type, String behaviorTime, String content) {
		BehaviorModel model = new BehaviorModel();
		model.setBehaviorTime(behaviorTime);
		model.setCode(code);
		model.setContent(content);
		model.setTitle(title);
		model.setType(type);
		try{
			BehaviorDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	
	

	

	@Override
	public void delBehavior(String id) {
		// TODO Auto-generated method stub
		BehaviorDAO.delete(id);
	}

	@Override
	public BehaviorModel getById(String id) {
		// TODO Auto-generated method stub
		return BehaviorDAO.getById(id);
	}

	@Override
	public void updateBehavior(BehaviorModel model) {
		// TODO Auto-generated method stub
		BehaviorDAO.update(model);
	}
	
	/**
	 * 通过公司code
	 */
	@Override
	public List<BehaviorModel> getBycode(String code) {
		return BehaviorDAO.getBycode(code);
	}

}
