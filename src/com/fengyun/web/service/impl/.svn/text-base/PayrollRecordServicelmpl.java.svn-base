package com.fengyun.web.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.db.dao.PayrollRecordDAO;
import com.fengyun.web.db.dao.ProjectDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.dao.TeamDAO;
import com.fengyun.web.db.playermodel.AttendanceInfoModel;
import com.fengyun.web.db.playermodel.PayrollRecordModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.service.PayrollRecordService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.util.DateStringUtils;
import com.fengyun.web.util.ModelUtils;
import com.mongodb.BasicDBObject;

@Service
public class PayrollRecordServicelmpl implements PayrollRecordService  {
	
	@Autowired
	private ProjectService projectService;
	
	/**
	 * 新增
	 */
	@Override
	public boolean addPayrollRecord(String pCode, String name, String userId, String code, String startTime, String endTime, int salary ,int realSalary, int noSalary,
			int tax, String drawee, int paytype, String serial, int confirm, String payTime) {
		//判断项目是否存在
		ProjectModel pModel = ProjectDAO.getByPCode(pCode);
		if(pModel == null)
			return false;
		//班组是否存在
		TeamModel tModel = TeamDAO.getByCode(Long.valueOf(code));
		if(tModel == null)
			return false;
		PayrollRecordModel model = new PayrollRecordModel();
		model.setPayTime(DateStringUtils.parse(payTime));
		if(model.getPayTime() == null)
			return false;
		model.setCode(code);
		model.setConfirm(confirm);
		model.setDrawee(drawee);
		model.setEndTime(endTime);
		model.setName(name);
		model.setNoSalary(noSalary);
		model.setPaytype(paytype);
		model.setpCode(pCode);
		model.setRealSalary(realSalary);
		model.setSalary(salary);
		model.setSerial(serial);
		model.setStartTime(startTime);
		model.setTax(tax);
		model.setUserId(userId);
		model.setpName(pModel.getName());
		model.settName(tModel.getName());
		try{
			PayrollRecordDAO.insert(model);
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
	public List<PayrollRecordModel> getPayrollRecordList(BasicDBObject queryObj,
			int pageNow, int pageSize) {
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return PayrollRecordDAO.getAll(queryObj,pageSize, skip);
	}

	@Override
	public long countAllPayrollRecord(BasicDBObject queryObj) {
		// TODO Auto-generated method stub
		return PayrollRecordDAO.countAll(queryObj);
	}

	@Override
	public void delPayrollRecord(String id) {
		// TODO Auto-generated method stub
		PayrollRecordDAO.delete(id);
	}

	@Override
	public PayrollRecordModel getById(String id) {
		// TODO Auto-generated method stub
		return PayrollRecordDAO.getById(id);
	}

	@Override
	public void updatePayrollRecord(PayrollRecordModel model) {
		// TODO Auto-generated method stub
		PayrollRecordDAO.update(model);
	}
	
	
	/**
	 * 通过项目code
	 */
	@Override
	public List<PayrollRecordModel> getBypCode(String pCode) {
		return PayrollRecordDAO.getBypCode(pCode);
	}
	
	/**
	 * 通过项目pCode和班组code
	 */
	@Override
	public List<PayrollRecordModel> getByPCodeANDcode(String pCode, String code) {
		return PayrollRecordDAO.getByPCodeANDcode(pCode,code);
	}

	
	/**
	 * 根据班组id和查询条件  查询到当前班组的工资记录条数 -zss
	 */
	@Override
	public long countPayRoll(String code, String name, String inTime, String outTime, String pName) {
		BasicDBObject queryObj = getQueryObj(code, name, inTime, outTime, pName);
		Long count = PayrollRecordDAO.countAll(queryObj);
		return count;
	}

	/**
	 * 构建查询Object
	 * @param tId
	 * @param name
	 * @param inTime
	 * @param outTime
	 * @param pName
	 * @return
	 */
	public BasicDBObject getQueryObj(String code, String name, String inTime,
			String outTime, String pName) {
		BasicDBObject queryObj = new BasicDBObject(5);
		if(!StringUtils.isEmpty(code)){
			queryObj.put("code", code);
		}
		if(!StringUtils.isEmpty(name)){
			queryObj.put("name", name);
		}
		if(!StringUtils.isEmpty(pName)){
			ProjectModel projectModel = projectService.getByName(pName);
			if(projectModel != null){
				queryObj.put("pCode", projectModel.getpCode());
			}
		}
		if(StringUtils.isNotBlank(inTime)&&StringUtils.isNotBlank(outTime)){
			ModelUtils.queryDate(inTime, outTime, queryObj, "payTime");
		}
		return queryObj;
	}

	/**
	 * 条件查询 工资发放列表  -zss
	 */
	@Override
	public List<PayrollRecordModel> getPayRollByPage(String code, int pageNow,
			int pageSize, String name, String inTime, String outTime,String pName) {
		// TODO Auto-generated method stub
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = 10;
		int skip = (pageNow - 1) * pageSize;
		BasicDBObject queryObj = getQueryObj(code, name, inTime, outTime, pName);
		List<PayrollRecordModel> list = PayrollRecordDAO.getAll(queryObj, pageSize, skip);
		//遍历查询 依次给冗余指端pName赋值
		for (PayrollRecordModel payrollRecordModel : list) {
			ProjectModel projectModel = projectService.getByPCode(payrollRecordModel.getpCode());
			if(projectModel != null)
				payrollRecordModel.setpName(projectModel.getName());
		}
		return list;
	}

	/**
	 * 前台页面获取工资记录列表(不分页操作)
	 */
	@Override
	public List<PayrollRecordModel> getPayrollRecordOneList(BasicDBObject queryObj) {
		return PayrollRecordDAO.getPayrollRecordOneList(queryObj);
	}
	
	
	/**
	 * 按时间顺序排序
	 * @param attlist
	 * @return
	 */
	@Override
	public List<PayrollRecordModel> sortPayList(List<PayrollRecordModel> list) {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<PayrollRecordModel>(){  
			  
            /*  
             * int compare(Student o1, Student o2) 返回一个基本类型的整型，  
             * 返回负数表示：o1 小于o2，  
             * 返回0 表示：o1和o2相等，  
             * 返回正数表示：o1大于o2。  
             */  
			@Override
			public int compare(PayrollRecordModel pay1,
					PayrollRecordModel pay2) {
				// TODO Auto-generated method stub
				 //按照startDate进行升序排列  \
				Date date = new Date();
                if(pay1.getPayTime().getTime()>pay2.getPayTime().getTime()){  
                    return 1;  
                }  
                if(pay1.getPayTime().getTime()==pay2.getPayTime().getTime()){  
                    return 0;  
                }  
                return -1;  
			}  
        });   
		
		return list;
	}

	/**
	 * 判断是否已经存在这个月的记录
	 */
	@Override
	public PayrollRecordModel getPayrollRecordOnly(BasicDBObject queryObj) {
		return PayrollRecordDAO.getPayrollRecordOnly(queryObj);
	}

	/**
	 * 新增
	 */
	@Override
	public boolean addPayrollRecord(PayrollRecordModel payrollRecordModel) {
		return PayrollRecordDAO.addPayrollRecord(payrollRecordModel);
	}

	/**
	 * 根据项目的code和施工班组的code查询记录数
	 */
	@Override
	public Long getCountByPCodeAndTCode(String pCode, String tCode) {
		return PayrollRecordDAO.getCountByPCodeAndTCode(pCode, tCode);
	}

	/**
	 * 根据项目的code和施工班组的code分页查询
	 */
	@Override
	public List<PayrollRecordModel> getAllByPageAndPCodeAndTCode(Page page,
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
		return PayrollRecordDAO.getAllByPageAndPCodeAndTCode(queryObj, pageSize, skip);
	}



}
