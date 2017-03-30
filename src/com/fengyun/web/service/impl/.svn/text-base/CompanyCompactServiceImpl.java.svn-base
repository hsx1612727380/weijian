package com.fengyun.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.CompanyCompactDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.playermodel.CompanyCompactModel;
import com.fengyun.web.service.CompanyCompactService;

/**
 * 公司合同管理Service实现类
 * @author hsx
 *
 */
@Service
public class CompanyCompactServiceImpl implements CompanyCompactService {

	/**
	 * 根据公司code查询公司合同
	 */
	@Override
	public List<CompanyCompactModel> getByCode(String code) {
		return CompanyCompactDAO.getByCode(code);
	}

	/**
	 * 新增
	 */
	@Override
	public boolean addCompanyContract(String code, String projectName,
			String buildUnit, double compactPrice, int isTender, int isCompact,
			int isAchieveReport, String leaderName, String executiveInfo,
			String achieveWorkDate, String startWorkDate) {
		CompanyCompactModel model = new CompanyCompactModel();
		model.setCode(code);
		model.setProjectName(projectName);
		model.setBuildUnit(buildUnit);
		model.setCompactPrice(compactPrice);
		model.setIsTender(isTender);
		model.setIsCompact(isCompact);
		model.setIsAchieveReport(isAchieveReport);
		model.setLeaderName(leaderName);
		model.setExecutiveInfo(executiveInfo);
		model.setAchieveWorkDate(achieveWorkDate);
		model.setStartWorkDate(startWorkDate);
		try {
			CompanyCompactDAO.insert(model);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 根据ID查询
	 */
	@Override
	public CompanyCompactModel getById(String id) {
		return CompanyCompactDAO.getById(id);
	}

	/**
	 * 修改
	 */
	@Override
	public boolean updateCompanyCompact(CompanyCompactModel companyCompactModel) {
		return CompanyCompactDAO.update(companyCompactModel);
	}

	/**
	 * 根据项目名称查询
	 */
	@Override
	public CompanyCompactModel getByProjectName(String pName) {
		return CompanyCompactDAO.getByProjectName(pName);
	}

	/**
	 * 分页查询
	 */
	@Override
	public List<CompanyCompactModel> getCompanyCompactList(String code,
			int pageNow, int pageSize) {
		if(pageNow <= 0) {
			pageNow = 1;
		}
		if(pageSize <= 0) {
			pageSize = Tables.PAGENUM;
		}
		int skip = (pageNow - 1) * pageSize;
		return CompanyCompactDAO.getCompanyCompactList(code, skip, pageSize);
	}
	
}
