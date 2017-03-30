package com.fengyun.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;


import com.fengyun.web.db.dao.JoinBuildDAO;
import com.fengyun.web.db.playermodel.JoinBuildModel;
import com.fengyun.web.service.JoinBuildService;
@Service
public class JoinBuildServicelmpl implements JoinBuildService {
	
	/**
	 * 通过公司code
	 */
	@Override
	public List<JoinBuildModel> getBypCode(String pCode) {
		return JoinBuildDAO.getBypCode(pCode);
	}
	
	
	/**
	 * 删除
	 */
	@Override
	public void delJoinBuild(String id) {
		JoinBuildDAO.delete(id);
	}
	
	
	/**
	 * 新增
	 */
	@Override
	public boolean addJoinBuild(String pCode,String jType,String jName, String jNum, String leaderphone) {
		JoinBuildModel model = new JoinBuildModel();
		model.setpCode(pCode);
		model.setjType(jType);
		model.setjName(jName);
		model.setjNum(jNum);
		model.setLeaderphone(leaderphone);
		try{
			JoinBuildDAO.insert(model);
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
	public void updateJoinBuild(JoinBuildModel model) {
		JoinBuildDAO.update(model);
	}
	
	@Override
	public JoinBuildModel getById(String id){
		return JoinBuildDAO.getById(id);
	}


	/**
	 * JoinBuild添加页面对手机号的校验
	 */
	@Override
	public String addMobilRepCHeck(String leaderphone) {
		String isRep = "0";
		if (JoinBuildDAO.mobilRepCHeck(leaderphone) == null) {
			isRep = "1";
		}
		return isRep;
	}

	/**
	 * JoinBuild修改页面对手机号的校验
	 */
	@Override
	public String modfiyMobilRepCHeck(String leaderphone, String id) {
		String isRep = "0";
		if (JoinBuildDAO.mobilRepCHeck(leaderphone) == null) {
			isRep = "1";
		}
		else {
			JoinBuildModel joinBuildModel = JoinBuildDAO.getById(id);
			if (leaderphone.equals(joinBuildModel.getLeaderphone())) {
				isRep = "1";
			}
		}
		return isRep;
	}

	/**
	 * 根据公司编号代码和项目参建单位的手机号判断该手机是否被注册
	 */
	@Override
	public JoinBuildModel getJoinBuildByPCodeAndLeaderPhone(String code,
			String leaderphone) {
		return JoinBuildDAO.getJoinBuildByPCodeAndLeaderPhone(code, leaderphone);
	}


}
