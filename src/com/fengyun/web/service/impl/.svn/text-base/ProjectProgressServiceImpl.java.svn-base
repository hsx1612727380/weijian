package com.fengyun.web.service.impl;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.db.dao.ProjectProgressDAO;
import com.fengyun.web.db.playermodel.ProjectProgressModel;
import com.fengyun.web.service.ProjectProgressService;
import com.fengyun.web.util.DateStringUtils;
import com.mongodb.BasicDBObject;
@Service
public class ProjectProgressServiceImpl implements ProjectProgressService {

	@Override
	public Long countProjectProgress(String pId, String startDateP,String endDateP) {
		// TODO Auto-generated method stub
		return ProjectProgressDAO.countAll(pId,startDateP, endDateP);
	}

	@Override
	public boolean addOne(String pId, String unit,String unitPer, int allWork, int thisWeek,
			int accoutWork, String plan, Date storageTime,String desc) {
		// TODO Auto-generated method stub
		ProjectProgressModel projectProgressModel = new ProjectProgressModel();
		projectProgressModel.setpId(pId);
		projectProgressModel.setUnit(unit);
		projectProgressModel.setUnitPer(unitPer);
		projectProgressModel.setAllWork(allWork);
		projectProgressModel.setThisWeek(thisWeek);
		projectProgressModel.setAccoutWork(accoutWork);
		//计算并转化百分比
		double progre = 0;
		if(allWork!=0){
			progre = ((float)accoutWork) / ((float)allWork);
		}
		NumberFormat numPercent = NumberFormat.getPercentInstance();
		numPercent.setMaximumIntegerDigits(3);//最多保留三位整数部分
		numPercent.setMaximumFractionDigits(2);//最多保留两位小数
		String progress = numPercent.format(progre);
		projectProgressModel.setProgress(progress);
		
		projectProgressModel.setPlan(plan);
		projectProgressModel.setStorageTime(storageTime);
		projectProgressModel.setDesc(desc);
		return add(projectProgressModel);
	}

	@Override
	public boolean add(ProjectProgressModel projectProgressModel) {
		// TODO Auto-generated method stub
		int accoutWork = projectProgressModel.getAccoutWork();
		int allWork = projectProgressModel.getAllWork();
		//计算并转化百分比
		double progre = 0;
		if(allWork!=0){
			progre = ((float)accoutWork) / ((float)allWork);
		}
		NumberFormat numPercent = NumberFormat.getPercentInstance();
		numPercent.setMaximumIntegerDigits(3);//最多保留三位整数部分
		numPercent.setMaximumFractionDigits(2);//最多保留两位小数
		String progress = numPercent.format(progre);
		projectProgressModel.setProgress(progress);
		projectProgressModel.setStorageTime(new Date());
		return ProjectProgressDAO.insert(projectProgressModel);
	}

	/**
	 * 分页查询
	 */
	@Override
	public List<ProjectProgressModel> getByPageAndpId(Page pageP, String pId,String startDateP,String endDateP) {
		// TODO Auto-generated method stub
		int pageNow = pageP.getPageNow();
		int pageSize = pageP.getPageSize();
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = 10;
		int skip = (pageNow - 1) * pageSize;
		
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("pId", pId);
		
		BasicDBObject dateTime = null;
		if(org.apache.commons.lang.StringUtils.isNotBlank(startDateP)){
			startDateP =startDateP.replace("-", "")+"000000";
			Date startP = DateStringUtils.parseYMDS(startDateP);
			dateTime = new BasicDBObject("$gte",startP);
		}
		if(org.apache.commons.lang.StringUtils.isNotBlank(endDateP)){
			endDateP = endDateP.replace("-", "")+"235959";
			Date endP = DateStringUtils.parseYMDS(endDateP);
			dateTime.append("$lte",endP);
		}
		queryObj.put("storageTime", dateTime);
		//每页查询pageSize行，从skip行记录开始查
		List<ProjectProgressModel> list = ProjectProgressDAO.getAll(queryObj, pageSize, skip);
		return list;
	}

	@Override
	public ProjectProgressModel getById(String id) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		ProjectProgressModel model = ProjectProgressDAO.getByQueryObj(queryObj);
		
		return model;
	}

	@Override
	public boolean updateProjectProgress(ProjectProgressModel projectProgress) {
		// TODO Auto-generated method stub
		projectProgress.setStorageTime(new Date());
		return ProjectProgressDAO.update(projectProgress);
	}
	
}
