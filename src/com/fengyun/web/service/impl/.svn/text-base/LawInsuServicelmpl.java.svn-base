package com.fengyun.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;


import com.fengyun.web.db.dao.LawInsuDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.playermodel.LawInsuModel;
import com.fengyun.web.service.LawInsuService;
import com.mongodb.BasicDBObject;
@Service
public class LawInsuServicelmpl implements LawInsuService {
	@Override
	public List<LawInsuModel> getLawInsuList(BasicDBObject queryObj,int pageNow,int pageSize) {
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return LawInsuDAO.getAll(queryObj,pageSize, skip);
	}

	@Override
	public long countAllLawInsu(BasicDBObject queryObj) {
		return LawInsuDAO.countAll(queryObj);
	}
	
	/**
	 * 删除法律保险
	 */
	@Override
	public void delLawInsu(String id) {
		LawInsuDAO.delete(id);
	}
	
	
	/**
	 * 新增法律保险
	 */
	@Override
	public boolean addLawInsu(String title,int lawtype,String note) {
		LawInsuModel model = new LawInsuModel();
		model.setNote(note);
		model.setTitle(title);
		model.setLawtype(lawtype);
		try{
			LawInsuDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * 查询法律保险
	 * @param id
	 * @return
	 */
	@Override
	public LawInsuModel getById(String id) {
		return LawInsuDAO.getById(id);
	}
	
	/**
	 * 修改法律保险
	 * @param model
	 */
	@Override
	public void updateLawInsu(LawInsuModel model) {
		LawInsuDAO.update(model);
	}

	@Override
	public List<LawInsuModel> getLawInsuList(int lawType) {
		// TODO Auto-generated method stub
		return LawInsuDAO.getListByType(lawType);
	}
	
	

}
