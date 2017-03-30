package com.fengyun.web.service.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.db.dao.TeamDAO;
import com.fengyun.web.db.dao.TeamScheduleDAO;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.TeamScheduleModel;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.TeamScheduleService;
import com.fengyun.web.service.TeamService;
import com.fengyun.web.util.DateStringUtils;
import com.mongodb.BasicDBObject;
import com.mysql.jdbc.StringUtils;

@Service
public class TeamScheduleServiceImpl implements TeamScheduleService {
	
	@Autowired
	private ProjectDepartmentService projectDepartmentService;
	
	@Override
	public Long countTeamSchedule(String pId, String startDateP,String endDateP) {
		// TODO Auto-generated method stub
		return TeamScheduleDAO.countAll(pId,startDateP, endDateP);
	}

	@Override
	public boolean addOne(String pId, String tId, String teamName, String type, String unit, double price,
			double prepaid, int times, double thisPay, double addupPay, double paid, double remainPay, int allWork,
			int thisWork, int accoutWork, String balance, Date storageTime, String desc) {
		// TODO Auto-generated method stub
		TeamScheduleModel scheduleModel = new TeamScheduleModel();
		scheduleModel.setpId(pId);
		scheduleModel.settId(tId);
		scheduleModel.setTeamName(teamName);
		scheduleModel.setType(type);
		scheduleModel.setUnit(unit);
		scheduleModel.setPrice(price);
		scheduleModel.setPrepaid(prepaid);
		scheduleModel.setTimes(times);
		scheduleModel.setThisPay(thisPay);
		scheduleModel.setAddupPay(addupPay);
		scheduleModel.setPaid(paid);
		scheduleModel.setRemainPay(remainPay);
		scheduleModel.setAllWork(allWork);
		scheduleModel.setThisWork(thisWork);
		scheduleModel.setAccoutWork(accoutWork);
		//计算并转化百分比
		double progre = 0;
		if(allWork!=0){
			progre = ((float)accoutWork) / ((float)allWork);
		}
		NumberFormat numPercent = NumberFormat.getPercentInstance();
		numPercent.setMaximumIntegerDigits(3);//最多保留三位整数部分
		numPercent.setMaximumFractionDigits(2);//最多保留两位小数
		String progress = numPercent.format(progre);
		scheduleModel.setProgress(progress);
		
		scheduleModel.setBalance(balance);
		scheduleModel.setStorageTime(storageTime);
		scheduleModel.setDesc(desc);
		return add(scheduleModel);
	}

	@Override
	public boolean add(TeamScheduleModel teamScheduleModel) {
		// TODO Auto-generated method stub
		return TeamScheduleDAO.insertOne(teamScheduleModel);
	}

	/**
	 * 分页查询
	 */
	@Override
	public List<TeamScheduleModel> getByPageAndpId(Page pageT, String pId,String startDateT,String endDateT){
		// TODO Auto-generated method stub
		int pageNow = pageT.getPageNow();
		int pageSize = pageT.getPageSize();
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = 10;
		int skip = (pageNow - 1) * pageSize;
		
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("pId", pId);
		BasicDBObject dateTime = null;
		if(org.apache.commons.lang.StringUtils.isNotBlank(startDateT)){
			startDateT =startDateT.replace("-", "")+"000000";
			Date startT = DateStringUtils.parseYMDS(startDateT);
			dateTime = new BasicDBObject("$gte",startT);
		}
		if(org.apache.commons.lang.StringUtils.isNotBlank(endDateT)){
			endDateT = endDateT.replace("-", "")+"235959";
			Date endT = DateStringUtils.parseYMDS(endDateT);
			dateTime.append("$lte",endT);
		}
		queryObj.put("storageTime", dateTime);
		//每页查询pageSize行，从skip行记录开始查
		List<TeamScheduleModel> list = TeamScheduleDAO.getAll(queryObj, pageSize, skip);
		return list;
	}

	@Override
	public TeamScheduleModel getById(String id) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("_id", new ObjectId(id));
		TeamScheduleModel model = TeamScheduleDAO.getByQueryObj(queryObj);
		
		return model;
	}

	@Override
	public boolean updateTeamScheduleModel(TeamScheduleModel teamSchedule) {
		// TODO Auto-generated method stub
		teamSchedule.setStorageTime(new Date());
		return TeamScheduleDAO.update(teamSchedule);
	}

	@Override
	public List<TeamModel> getTeamList(String pId, int status) {
		// TODO Auto-generated method stub
		List<ProjectDepartmentModel> list = projectDepartmentService.getByProjectId(pId, 3);
		List<TeamModel> teamList = new ArrayList<TeamModel>();
		for (ProjectDepartmentModel projectDepartmentModel : list) {
			String tId = projectDepartmentModel.getVId();//获取参与到项目的班组id（包括材料班组和设备班组）
			TeamModel teamModel = TeamDAO.getById(tId);//到劳务班组查询
			if(teamModel!=null){//不为空的都是劳务班组，加入teamList中
				teamList.add(teamModel);
			}
		}
		return teamList;
	}

	@Override
	public void addTeamSchedule(TeamScheduleModel teamSchedule) {
		// TODO Auto-generated method stub
		teamSchedule.setStorageTime(new Date());
		int accoutWork = teamSchedule.getAccoutWork();
		int allWork = teamSchedule.getAllWork();
		//计算并转化百分比
		double progre = 0;
		if(allWork!=0){
			progre = ((float)accoutWork) / ((float)allWork);
		}
		NumberFormat numPercent = NumberFormat.getPercentInstance();
		numPercent.setMaximumIntegerDigits(3);//最多保留三位整数部分
		numPercent.setMaximumFractionDigits(2);//最多保留两位小数
		String progress = numPercent.format(progre);
		teamSchedule.setProgress(progress);
		this.add(teamSchedule);
	}
	
	

}
