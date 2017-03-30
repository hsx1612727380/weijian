package com.fengyun.web.service;

import java.util.Date;
import java.util.List;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.TeamScheduleModel;

public interface TeamScheduleService {

	/**
	 * 统计当前工程下的所有班组进度记录
	 * @param pId
	 * @param endDateT 
	 * @param startDateT 
	 * @return
	 */
	Long countTeamSchedule(String pId, String startDateT, String endDateT);

	/**
	 * 添加一条数据
	 * @param pId
	 * @param string
	 * @param string2
	 * @param d
	 * @param e
	 * @param i
	 * @param f
	 * @param g
	 * @param h
	 * @param j
	 * @param k
	 * @param l
	 * @param m
	 * @param string3
	 * @param date
	 * @param string4
	 */
	boolean addOne(String pId, String tId, String teamName, String string2, String unit, double d, double e,
			int i, double f, double g, double h, double j, int k, int l, int m,
			String string3, Date date, String string4);

	boolean add(TeamScheduleModel teamScheduleModel);

	/**
	 * 分页查询当前工程下的班组进度记录
	 * @param pageT
	 * @param pId
	 * @param endT 
	 * @param startT 
	 * @return
	 */
	List<TeamScheduleModel> getByPageAndpId(Page pageT, String pId, String startT, String endT);

	/**
	 * 通过id查询到一个model
	 * @param id
	 * @return
	 */
	TeamScheduleModel getById(String id);

	/**
	 * 更新
	 * @param teamSchedule
	 */
	boolean updateTeamScheduleModel(TeamScheduleModel teamSchedule);

	/**
	 * 通过pId和status=3获取到加入该项目的班组列表
	 * @param pId
	 * @param status
	 * @return
	 */
	List<TeamModel> getTeamList(String pId, int status);

	/**
	 * 前台新增
	 * @param teamSchedule
	 */
	void addTeamSchedule(TeamScheduleModel teamSchedule);
	
}
