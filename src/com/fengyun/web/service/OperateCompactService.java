package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.db.playermodel.OperateCompactModel;


public interface OperateCompactService {

	/**
	 * 添加一个compactModel
	 * @param compactModel
	 */
	void add(OperateCompactModel compactModel);

	/**
	 * 通过projectId查询工程项目合同
	 * @param id
	 */
	List<OperateCompactModel> getCompactByPId(String id);

	/**
	 * 通过id查询出一条记录
	 * @param id
	 */
	OperateCompactModel getCompactById(String id);

	/**
	 * 更新合同记录
	 * @param compactModel
	 */
	void upgrateOperateCompact(OperateCompactModel compactModel);
	

}
