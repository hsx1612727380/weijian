package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.db.playermodel.ProjectRosterModel;

/**
 * 项目花名册Service层接口
 * 
 * @author hsx
 * 
 */
public interface ProjectRosterService {

	/**
	 * 根据项目的ID查询项目花名册的所有人
	 * @param page
	 * @param projectId
	 * @return
	 */
	List<ProjectRosterModel> getAllByPId(Page page, String projectId);
	
	/**
	 * 新增数据
	 * @param projectRosterModel
	 * @return
	 */
	boolean addProjectRoster(ProjectRosterModel projectRosterModel);

	/**
	 * 项目花名册验证用户的身份证是否注册过
	 * @param identity
	 * @return
	 */
	String regRosterIdentity(String identity);

	/**
	 * 项目花名册验证用户的手机号是否注册过
	 * @param phone
	 * @return
	 */
	String regRosterPhone(String phone);

	/**
	 * 根据项目的ID查询项目花名册的所有人的个数
	 * @param projectId
	 * @return
	 */
	Long getCountByPId(String projectId);

}
