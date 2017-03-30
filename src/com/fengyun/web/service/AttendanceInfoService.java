package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.db.playermodel.AttendanceInfoModel;
import com.mongodb.BasicDBObject;

public interface AttendanceInfoService {
	/** 新增考勤记录 */
	boolean addAttendanceInfo(String pCode, String userId, String code,
			String startDate, String endDate, int confirm, String name,double workTime);

	/** 获取考勤信息总数 */
	public long countAllAttendanceInfo(BasicDBObject queryObj);

	/**
	 * 删除考勤信息
	 */
	public void delAttendanceInfo(String id);

	/** 根据ID获取考勤信息 */
	public AttendanceInfoModel getById(String id);

	/** 更新考勤信息 */
	public void updateAttendanceInfo(AttendanceInfoModel model);

	
	
	public AttendanceInfoModel getByMonth(String month);
	
	/**
	 * 获取出勤信息列表 
	 * @param queryObj
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	List<AttendanceInfoModel> getAttendanceInfoList(BasicDBObject queryObj,
			int pageNow, int pageSize);

	/**
	 * 前台 根据用户id分页查询出勤信息列表-zss
	 * @param userId
	 * @param pageSize 每次查询多少行 （页大小）
	 * @param pageNow 从多少行开始查
	 * @param name
	 * @param year
	 * @param month
	 * @return
	 */
	public List<AttendanceInfoModel> getAtdInfoListByPage(
			String teamCode, int pageNow, int pageSize, 
			String name, String pName, String startDate, String endDate);

	/**
	 * 第一次进入时 根据班组code统计当前班组的出勤信息条数 -zss
	 * 条件查询时，统计特定人员、特定时间的出勤信息条数
	 * @param teamCode
	 * @param name
	 * @param year
	 * @param month
	 * @return
	 */
	public long countAttendanceInfo(String teamCode, String pName, String name, String startDate,
			String endDate);

	List<AttendanceInfoModel> getBypCode(String pCode);

	/**
	 * 获取带有项目名称的list
	 * @param attendanceList
	 * @return
	 */
	List<AttendanceInfoModel> getAtdInfoList(
			List<AttendanceInfoModel> attendanceList);

	/**
	 * 查询考勤记录
	 * @param queryObj
	 * @return
	 */
	List<AttendanceInfoModel> getAttentenceList(BasicDBObject queryObj);

	/**
	 * 获取考勤记录（不分页操作）
	 * @param queryObj
	 * @return
	 */
	List<AttendanceInfoModel> getAttendanceInfoRecordOneList(
			BasicDBObject queryObj);

	/**
	 * 按照班组名称、pCode、confirm查询
	 * @param pCode
	 * @param confirm
	 * @param teamName
	 * @return
	 */
	List<AttendanceInfoModel> getListByTeamName(String pCode, int confirm,
			String teamName);

	/**
	 * 将集合根据其中的AttendanceInfoModel的开始时间字段排序
	 * @param attlist
	 * @return
	 */
	List<AttendanceInfoModel> sortAttList(List<AttendanceInfoModel> attlist);

	/**
	 * 新增
	 * @param attendanceInfoModel
	 */
	boolean addAttendanceInfo(AttendanceInfoModel attendanceInfoModel);

	/**
	 * 根据项目的Code和施工班组的Code分页查询
	 * @param page
	 * @param pCode
	 * @param tCode
	 * @return
	 */
	List<AttendanceInfoModel> getAllByPageAndPCodeAndTCode(Page page,
			String pCode, String tCode);

}
