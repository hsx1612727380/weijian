package com.fengyun.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.AptitudeDAO;
import com.fengyun.web.db.playermodel.AptitudeModel;
import com.fengyun.web.service.AptitudeService;


@Service
public class AptitudeServicelmpl implements AptitudeService {
	
	/**
	 * 通过公司code
	 */
	@Override
	public List<AptitudeModel> getByCode(String code) {
		return AptitudeDAO.getByCode(code);
	}
	
	
	/**
	 * 删除
	 */
	@Override
	public void delAptitude(String id) {
		AptitudeDAO.delete(id);
	}
	
	
	/**
	 * 新增
	 */
	@Override
	public boolean addAptitude(String code, String certificate,int adtype,int adlevel,String approval,
			String approvalTime,String validity) {
		AptitudeModel model = new AptitudeModel();
		model.setAdlevel(adlevel);
		model.setAdtype(adtype);
		model.setApproval(approval);
		model.setApprovalTime(approvalTime);
		model.setCertificate(certificate);
		model.setCode(code);
		model.setValidity(validity);
		try{
			AptitudeDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	
	/**
	 * 修改
	 * @param model
	 */
	@Override
	public void updateAptitude(AptitudeModel model) {
		AptitudeDAO.update(model);
	}
	
	@Override
	public AptitudeModel getById(String id){
		return AptitudeDAO.getById(id);
	}
	
	
	

}
