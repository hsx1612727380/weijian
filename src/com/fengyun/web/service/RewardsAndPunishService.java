package com.fengyun.web.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.fengyun.web.db.playermodel.RewardsAndPunishModel;
import com.fengyun.web.db.playermodel.TeamModel;
/**
 * 
 * @author zheng
 *
 */
public interface RewardsAndPunishService {

	/**
	 * 添加一个奖惩记录
	 * @param type
	 * @param code
	 * @param name
	 * @param userId
	 * @param character
	 * @param measure
	 */
	public void add(int type,String pId,String code, String name, String teamName, String userId,String character, String measure);
	
	/**
	 * 通过项目pId获取该项目下的所有type类型的奖惩信息列表
	 * @param type
	 * @param pId
	 * @return
	 */
	public List<RewardsAndPunishModel> getListByPId(String pId,int type);
	
	/**
	 * 通过userId查询到一个model
	 * @param userId
	 * @return
	 */
	public RewardsAndPunishModel getByUserId(String userId);
	
	/**
	 * 通过userId删除
	 * @param id
	 * @return
	 */
	public boolean deleteById(String id);

	/**
	 * 添加一条记录
	 * @param rewardsAndPunishModel
	 */
	public void addRewardsAndPunish(RewardsAndPunishModel rewardsAndPunishModel,HttpSession session);

	/**
	 * 通过当前用户获取到项目下的班组列表
	 * @param session
	 * @return
	 */
	public List<TeamModel> getTeamList(HttpSession session);
	
	
	
}
