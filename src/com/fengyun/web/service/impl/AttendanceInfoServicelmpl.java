package com.fengyun.web.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.db.dao.AttendanceInfoDAO;
import com.fengyun.web.db.dao.ProjectDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.dao.TeamDAO;
import com.fengyun.web.db.playermodel.AttendanceInfoModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.service.AttendanceInfoService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.util.DateStringUtils;
import com.fengyun.web.util.ModelUtils;
import com.mongodb.BasicDBObject;

@Service
public class AttendanceInfoServicelmpl implements AttendanceInfoService {
	
	@Autowired
	private ProjectService projectService;
	
	/**
	 * 新增
	 */
	@Override
	public boolean addAttendanceInfo(String pCode ,String userId, String code, String startDate,
			String endDate, int confirm, String name,double workTime ) {
		//判断项目是否存在
		ProjectModel pModel = ProjectDAO.getByPCode(pCode);
		if(pModel == null)
			return false;
		//班组是否存在
		TeamModel tModel = TeamDAO.getByCode(Long.valueOf(code));
		if(tModel == null)
			return false;
		
		AttendanceInfoModel model = new AttendanceInfoModel();
		model.setpCode(pCode);
		model.setUserId(userId);
		model.setCode(code);
		model.setStartDate(DateStringUtils.parse(startDate));
		model.setEndDate(DateStringUtils.parse(endDate));
		model.setConfirm(confirm);
		model.setName(name);
		model.setWorkTime(workTime);
		model.setpName(pModel.getName());
		model.settName(tModel.getName());
		if(model.getStartDate() == null || model.getEndDate() == null)
			return false;
		try{
			AttendanceInfoDAO.insert(model);
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
	public List<AttendanceInfoModel> getAttendanceInfoList(BasicDBObject queryObj,
			int pageNow, int pageSize) {
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return AttendanceInfoDAO.getAll(queryObj,pageSize, skip);
	}

	@Override
	public long countAllAttendanceInfo(BasicDBObject queryObj) {
		// TODO Auto-generated method stub
		return AttendanceInfoDAO.countAll(queryObj);
	}

	@Override
	public void delAttendanceInfo(String id) {
		// TODO Auto-generated method stub
		AttendanceInfoDAO.delete(id);
	}

	@Override
	public AttendanceInfoModel getById(String id) {
		// TODO Auto-generated method stub
		return AttendanceInfoDAO.getById(id);
	}

	@Override
	public void updateAttendanceInfo(AttendanceInfoModel model) {
		// TODO Auto-generated method stub
		AttendanceInfoDAO.update(model);
	}

	@Override
	public AttendanceInfoModel getByMonth(String month) {
		// TODO Auto-generated method stub
		return AttendanceInfoDAO.getByMonth(month);
	}
	
	/**
	 * 通过项目code
	 */
	@Override
	public List<AttendanceInfoModel> getBypCode(String pCode) {
		return AttendanceInfoDAO.getBypCode(pCode);
	}
	
	/**
	 * author--zss 
	 * 前台功能
	 * 根据用户id分页查询出勤信息列表
	 * 每页查询pageSize行（默认设置成10行），从pageNow（当前页）开始查
	 * @param teamCode
	 * @param name
	 * @param year
	 * @param month
	 */
	@Override
	public List<AttendanceInfoModel> getAtdInfoListByPage(
			String teamCode, int pageNow, int pageSize,  String pName,
			String name, String startDate, String endDate) {
		// TODO Auto-generated method stub
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = 10;
		int skip = (pageNow - 1) * pageSize;
		
		BasicDBObject queryObj = getQueryObject(teamCode, pName, name,
				startDate, endDate);
		//每页查询pageSize行，从skip行记录开始查
		List<AttendanceInfoModel> list = AttendanceInfoDAO.getAll(queryObj, pageSize, skip);
		return list;
	}

	/**
	 * 构建查询条件
	 * @param teamCode
	 * @param pName
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public BasicDBObject getQueryObject(String teamCode, String pName,
			String name, String startDate, String endDate) {
		BasicDBObject queryObj = new BasicDBObject(5);
		if(StringUtils.isNotBlank(teamCode)){
			queryObj.put("code", teamCode);
		}
		if(StringUtils.isNotBlank(pName)){//将pName转换成pCode
			ProjectModel projectModel = projectService.getByName(pName);
			queryObj.put("pCode", projectModel.getpCode());
		}
		if(StringUtils.isNotBlank(name)){
			Pattern namePattern = Pattern.compile(".*" + name + ".*",
			Pattern.CASE_INSENSITIVE);
			queryObj.put("name", namePattern);
		}
		if(StringUtils.isNotBlank(startDate)&&StringUtils.isNotBlank(endDate)){
			ModelUtils.queryDate(startDate, endDate, queryObj);
		}
		return queryObj;
	}

	/**
	 * 根据班组code统计前班组的出勤信息-zss
	 * @param teamCode
	 * @param name
	 * @param year
	 * @param month
	 */
	@Override
	public long countAttendanceInfo(String teamCode, String pName, String name, String startDate,
			String endDate) {
		BasicDBObject queryObj = getQueryObject(teamCode, pName, name,
				startDate, endDate);
		return AttendanceInfoDAO.countAll(queryObj);
	}

	/**
	 * 获取出勤信息列表
	 */
	@Override
	public List<AttendanceInfoModel> getAtdInfoList(
			List<AttendanceInfoModel> attendanceList) {
		// TODO Auto-generated method stub
		for (AttendanceInfoModel attendanceInfoModel : attendanceList) {
			ProjectModel pModel = projectService.getByPCode(attendanceInfoModel.getpCode());
			if(pModel != null)
				attendanceInfoModel.setpName(pModel.getName());
		}
		return attendanceList;
	}

	/**
	 * 查询考勤记录
	 */
	@Override
	public List<AttendanceInfoModel> getAttentenceList(BasicDBObject queryObj) {
		return AttendanceInfoDAO.getAttentenceList(queryObj);
	}

	/**
	 * 获取考勤记录（不分页操作）
	 */
	@Override
	public List<AttendanceInfoModel> getAttendanceInfoRecordOneList(
			BasicDBObject queryObj) {
		return AttendanceInfoDAO.getAttendanceInfoRecordOneList(queryObj);
	}

	/**
	 * 按照班组名称、pCode、confirm查询
	 */
	@Override
	public List<AttendanceInfoModel> getListByTeamName(String pCode,
			int confirm, String teamName) {
		return AttendanceInfoDAO.getListByTeamName(pCode, confirm, teamName);
	}

	@Override
	public List<AttendanceInfoModel> sortAttList(List<AttendanceInfoModel> attlist) {
		// TODO Auto-generated method stub
		Collections.sort(attlist, new Comparator<AttendanceInfoModel>(){  
			  
            /*  
             * int compare(Student o1, Student o2) 返回一个基本类型的整型，  
             * 返回负数表示：o1 小于o2，  
             * 返回0 表示：o1和o2相等，  
             * 返回正数表示：o1大于o2。  
             */  
			@Override
			public int compare(AttendanceInfoModel att1,
					AttendanceInfoModel att2) {
				// TODO Auto-generated method stub
				 //按照startDate进行升序排列  \
				Date date = new Date();
                if(att1.getStartDate().getTime()>att2.getStartDate().getTime()){  
                    return 1;  
                }  
                if(att1.getStartDate().getTime()==att2.getStartDate().getTime()){  
                    return 0;  
                }  
                return -1;  
			}  
        });   
		
		return attlist;
	}

	/**
	 * 新增
	 */
	@Override
	public boolean addAttendanceInfo(AttendanceInfoModel attendanceInfoModel) {
		return AttendanceInfoDAO.addAttendanceInfo(attendanceInfoModel);
	}

	/**
	 * 根据项目的Code和施工班组的Code分页查询
	 */
	@Override
	public List<AttendanceInfoModel> getAllByPageAndPCodeAndTCode(Page page,
			String pCode, String tCode) {
		int pageNow = page.getPageNow();
		int pageSize = page.getPageSize();
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = 30;
		int skip = (pageNow - 1) * pageSize;
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("pCode", pCode);
		queryObj.put("code", tCode);
		return AttendanceInfoDAO.getAllByPageAndPCodeAndTCode(queryObj, pageSize, skip);
	}


}
