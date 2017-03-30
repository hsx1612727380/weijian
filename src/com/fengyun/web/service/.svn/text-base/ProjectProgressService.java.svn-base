package com.fengyun.web.service;

import java.util.Date;
import java.util.List;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.db.playermodel.ProjectProgressModel;

public interface ProjectProgressService {

	/**
	 * 统计当前工程下的所有工程各项进度记录
	 * @param pId
	 * @param endDateP 
	 * @param startDateP 
	 * @return
	 */
	Long countProjectProgress(String pId, String startDateP, String endDateP);

	boolean addOne(String pId,String unit,String unitPer, int allWork,int thisWeek,int accountWork,String plan, Date storageTime,String desc);
	
	/**
	 * 添加一条数据
	 * @param projectProgressModel
	 * @return
	 */
	boolean add(ProjectProgressModel projectProgressModel);

	/**
	 * 分页查询
	 * @param pageP
	 * @param pId
	 * @param endDateP 
	 * @param startDateP 
	 * @return
	 */
	List<ProjectProgressModel> getByPageAndpId(Page pageP, String pId, String startDateP, String endDateP);

	/**
	 * 通过id获取一个model
	 * @param id
	 * @return
	 */
	ProjectProgressModel getById(String id);

	/**
	 * 修改model
	 * @param projectProgress
	 */
	boolean updateProjectProgress(ProjectProgressModel projectProgress);
	
	
	
}
