package com.fengyun.web.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.AccrecordDAO;
import com.fengyun.web.db.dao.ProjectDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.dao.TeamDAO;
import com.fengyun.web.db.playermodel.AccrecordModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.service.AccrecordService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.util.DateStringUtils;
import com.fengyun.web.util.ModelUtils;
import com.mongodb.BasicDBObject;


@Service
public class AccrecordServicelmpl implements AccrecordService {
	
	@Autowired
	private ProjectService projectService;
	
	/**
	 * 新增
	 */
	@Override
	public boolean addAccrecord(String pCode,String userId, String code, String recordTime, 
			int confirm, String name,int type) {
		//判断项目是否存在
		ProjectModel pModel = ProjectDAO.getByPCode(pCode);
		if(pModel == null)
			return false;
		//班组是否存在
		TeamModel tModel = TeamDAO.getByCode(Long.valueOf(code));
		if(tModel == null)
			return false;
		AccrecordModel model = new AccrecordModel();
		model.setpCode(pCode);
		model.setUserId(userId);
		model.setCode(code);
		model.setRecordTime(DateStringUtils.parse(recordTime));
		model.setConfirm(confirm);
		model.setName(name);
		model.setType(type);
		model.setpName(pModel.getName());
		model.settName(tModel.getName());
		if(model.getRecordTime() == null)
			return false;
		try{
			AccrecordDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * 显示考勤信息列表
	 */
	@Override
	public List<AccrecordModel> getAccrecordList(BasicDBObject queryObj,
			int pageNow, int pageSize) {
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return AccrecordDAO.getAll(queryObj,pageSize, skip);
	}

	@Override
	public long countAllAccrecord(BasicDBObject queryObj) {
		// TODO Auto-generated method stub
		return AccrecordDAO.countAll(queryObj);
	}

	@Override
	public void delAccrecord(String id) {
		// TODO Auto-generated method stub
		AccrecordDAO.delete(id);
	}

	@Override
	public AccrecordModel getById(String id) {
		// TODO Auto-generated method stub
		return AccrecordDAO.getById(id);
	}

	@Override
	public void updateAccrecord(AccrecordModel model) {
		// TODO Auto-generated method stub
		AccrecordDAO.update(model);
	}
	
	/**
	 * 通过项目code
	 */
	@Override
	public List<AccrecordModel> getBypCode(String pCode) {
		return AccrecordDAO.getBypCode(pCode);
	}

	@Override
	public long countPersonIORecord(String teamCode, String name, String pName,
			String startDate, String endDate,int type) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = getQueryObject(teamCode, pName, name, startDate, endDate,type);
		return this.countAllAccrecord(queryObj);
	}
	//构建查询对象
	public BasicDBObject getQueryObject(String teamCode, String pName,
			String name, String startDate, String endDate,int type) {
		BasicDBObject queryObj = new BasicDBObject(5);
		if(StringUtils.isNotBlank(teamCode)){
			queryObj.put("code", teamCode);
		}
		if(StringUtils.isNotBlank(pName)){//将pName转换成pCode
			ProjectModel projectModel = projectService.getByName(pName);
			queryObj.put("pCode", projectModel.getpCode());
		}
		if(StringUtils.isNotBlank(name)){
			queryObj.put("name", name);
		}
		if(type!=-1){
			queryObj.put("type", type);
		}
		if(StringUtils.isNotBlank(startDate)&&StringUtils.isNotBlank(endDate)){
			ModelUtils.queryDate(startDate, endDate, queryObj,"recordTime");
		}
		return queryObj;
	}
	
	@Override
	public List<AccrecordModel> getPersonIORecordListByPage(
			String teamCode, int pageNow, int pageSize, String name,String pName,
			String startDate, String endDate,int type) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = getQueryObject(teamCode, pName, name, startDate, endDate, type);
		List<AccrecordModel> list = this.getAccrecordList(queryObj, pageNow, pageSize);
		for (AccrecordModel accrecordModel : list) {
			ProjectModel pModel = projectService.getByPCode(accrecordModel.getpCode());
			if(pModel != null)
				accrecordModel.setpName(pModel.getName());
		}
		return list;
	}
	@Override
	public List<AccrecordModel> sortAccrecordList(List<AccrecordModel> list) {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<AccrecordModel>(){  
			  
            /*  
             * int compare(Student o1, Student o2) 返回一个基本类型的整型，  
             * 返回负数表示：o1 小于o2，  
             * 返回0 表示：o1和o2相等，  
             * 返回正数表示：o1大于o2。  
             */  
			@Override
			public int compare(AccrecordModel acc1,
					AccrecordModel acc2) {
				// TODO Auto-generated method stub
				 //按照startDate进行升序排列  \
				Date date = new Date();
                if(acc1.getRecordTime().getTime()>acc2.getRecordTime().getTime()){  
                    return 1;  
                }  
                if(acc1.getRecordTime().getTime()==acc2.getRecordTime().getTime()){  
                    return 0;  
                }  
                return -1;  
			}  
        });   
		
		return list;
	}

	/**
	 * 新增
	 */
	@Override
	public boolean addAccrecord(AccrecordModel accrecordModel) {
		return AccrecordDAO.addAccrecord(accrecordModel);
	}

	/**
	 * 根据查询条件查询出入记录
	 */
	@Override
	public List<AccrecordModel> getList(BasicDBObject queryObj) {
		return AccrecordDAO.getList(queryObj);
	}
	
	
	
}
