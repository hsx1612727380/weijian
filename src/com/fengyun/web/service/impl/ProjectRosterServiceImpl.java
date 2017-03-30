package com.fengyun.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.db.dao.ProjectRosterDao;
import com.fengyun.web.db.playermodel.ProjectRosterModel;
import com.fengyun.web.service.ProjectRosterService;
import com.mongodb.BasicDBObject;

/**
 * 项目花名册Service层接口
 * 
 * @author hsx
 * 
 */
@Service
public class ProjectRosterServiceImpl implements ProjectRosterService {

	/**
	 * 根据项目的ID查询项目花名册的所有人（分页查询）
	 */
	@Override
	public List<ProjectRosterModel> getAllByPId(Page page, String projectId) {
		int pageNow = page.getPageNow();
		int pageSize = page.getPageSize();
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = 10;
		int skip = (pageNow - 1) * pageSize;
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("pId", projectId);
		return ProjectRosterDao.getAllByPId(queryObj, pageSize, skip);
	}

	/**
	 * 新增数据
	 */
	@Override
	public boolean addProjectRoster(ProjectRosterModel projectRosterModel) {
		return ProjectRosterDao.addProjectRoster(projectRosterModel);
	}

	/**
	 * 项目花名册验证用户的身份证是否注册过
	 */
	@Override
	public String regRosterIdentity(String identity) {
		String result = "0";
		ProjectRosterModel projectRosterModel = ProjectRosterDao.getByIdentity(identity);
		if (projectRosterModel != null) { // 查询到result为"1"，否则为"0"
			result = "1";
		}
		return result;
	}

	/**
	 * 项目花名册验证用户的手机号是否注册过
	 */
	@Override
	public String regRosterPhone(String phone) {
		String result = "0";
		ProjectRosterModel projectRosterModel = ProjectRosterDao.getByPhone(phone);
		if (projectRosterModel != null) { // 查询到result为"1"，否则为"0"
			result = "1";
		}
		return result;
	}

	/**
	 * 根据项目的ID查询项目花名册的所有人的个数
	 */
	@Override
	public Long getCountByPId(String projectId) {
		return ProjectRosterDao.getCountByPId(projectId);
	}

}
