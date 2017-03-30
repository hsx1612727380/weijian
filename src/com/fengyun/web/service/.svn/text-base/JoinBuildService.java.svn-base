package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.db.playermodel.JoinBuildModel;
import com.fengyun.web.db.playermodel.ProjectModel;

public interface JoinBuildService {

	List<JoinBuildModel> getBypCode(String pCode);

	JoinBuildModel getById(String id);

	void updateJoinBuild(JoinBuildModel model);

	void delJoinBuild(String id);

	

	boolean addJoinBuild(String pCode, String jType, String jName, String jNum,
			String leaderphone);

	/**
	 * JoinBuild添加页面对手机号的校验
	 * @param leaderphone
	 * @return
	 */
	String addMobilRepCHeck(String leaderphone);
	
	/**
	 * JoinBuild修改页面对手机号的校验
	 * @param leaderphone
	 * @return
	 */
	String modfiyMobilRepCHeck(String leaderphone, String id);

	/**
	 * 根据公司编号代码和项目参建单位的手机号判断该手机是否被注册
	 * @param code
	 * @param leaderphone
	 * @return
	 */
	JoinBuildModel getJoinBuildByPCodeAndLeaderPhone(String code,
			String leaderphone);


}
