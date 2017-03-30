package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.db.playermodel.CompanyCompactModel;

/**
 * 公司合同管理Service接口
 * @author hsx
 *
 */
public interface CompanyCompactService {

	/**
	 * 根据公司code查询公司合同
	 * @param code
	 * @return
	 */
	List<CompanyCompactModel> getByCode(String code);

	/**
	 * 新增
	 * @param code
	 * @param projectName
	 * @param buildUnit
	 * @param compactPrice
	 * @param isTender
	 * @param isCompact
	 * @param isAchieveReport
	 * @param leaderName
	 * @param executiveInfo
	 * @param achieveWorkDate
	 * @param startWorkDate
	 */
	boolean addCompanyContract(String code, String projectName, String buildUnit,
			double compactPrice, int isTender, int isCompact,
			int isAchieveReport, String leaderName, String executiveInfo,
			String achieveWorkDate, String startWorkDate);

	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	CompanyCompactModel getById(String id);

	/**
	 * 修改
	 * @param companyCompactModel
	 */
	boolean updateCompanyCompact(CompanyCompactModel companyCompactModel);

	/**
	 * 根据项目名称查询
	 * @param pName
	 * @return
	 */
	CompanyCompactModel getByProjectName(String pName);

	/**
	 * 分页查询
	 * @param code
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	List<CompanyCompactModel> getCompanyCompactList(String code, int pageNow,
			int pageSize);

}
