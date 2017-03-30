package com.fengyun.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.OperateCompactDAO;
import com.fengyun.web.db.playermodel.OperateCompactModel;
import com.fengyun.web.service.OperateCompactService;

@Service
public class OperateCompactServiceImpl implements OperateCompactService{

	@Override
	public void add(OperateCompactModel compactModel) {
		OperateCompactDAO.add(compactModel);
		
	}

	@Override
	public List<OperateCompactModel> getCompactByPId(String id) {
		return OperateCompactDAO.getByPId(id);
	}

	@Override
	public OperateCompactModel getCompactById(String id) {
		OperateCompactModel compactModel = OperateCompactDAO.getById(id);
		return compactModel;
	}

	@Override
	public void upgrateOperateCompact(OperateCompactModel compactModel) {
		OperateCompactDAO.update(compactModel);
	}

	
	
	
}
