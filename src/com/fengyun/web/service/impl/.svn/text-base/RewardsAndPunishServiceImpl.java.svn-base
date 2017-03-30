package com.fengyun.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.RewardsAndPunishDAO;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.RewardsAndPunishModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.mongodb.BasicDBObject;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.RewardsAndPunishService;
import com.fengyun.web.service.TeamService;
/**
 * 
 * @author zheng
 * 此service中的RAP简写代表RewardsAndPunishModel
 */
@Service
public class RewardsAndPunishServiceImpl implements RewardsAndPunishService {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProjectDepartmentService projectDepartmentService;
	
	@Autowired
	private TeamService teamService;
	
	@Override
	public void add(int type, String pId, String code, String name, String teamName,String userId,
			String character, String measure) {
		// TODO Auto-generated method stub
		RewardsAndPunishModel model = new RewardsAndPunishModel();
		model.setpId(pId);
		model.setType(type);
		model.setCode( code);
		model.setUserId( userId);
		model.setName( name);
		model.setTeamName( teamName);
		model.setCharacter( character);
		model.setMeasure( measure);
		RewardsAndPunishDAO.insert(model);
	}

	@Override
	public List<RewardsAndPunishModel> getListByPId(String pId, int type) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("pId", pId);
		queryObj.put("type", type);
		return RewardsAndPunishDAO.getListByQueryObj(queryObj);
	}

	@Override
	public RewardsAndPunishModel getByUserId(String userId) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("userId", userId);
		return RewardsAndPunishDAO.getByModel(queryObj);
	}

	@Override
	public boolean deleteById(String id) {
		// TODO Auto-generated method stub
		return RewardsAndPunishDAO.deleteById(id);
	}

	@Override
	public void addRewardsAndPunish(RewardsAndPunishModel rewardsAndPunishModel,HttpSession session) {
		// TODO Auto-generated method stub
		String userId = (String)session.getAttribute("userId");
		ProjectModel model = projectService.getProjectByUserId(userId);
		
		this.add(rewardsAndPunishModel.getType(), model.getId(),"code", rewardsAndPunishModel.getName(), rewardsAndPunishModel.getTeamName(), rewardsAndPunishModel.getUserId(), rewardsAndPunishModel.getCharacter(), rewardsAndPunishModel.getMeasure());
	}

	@Override
	public List<TeamModel> getTeamList(HttpSession session) {
		// TODO Auto-generated method stub
		String userId = (String)session.getAttribute("userId");
		ProjectModel projectModel = projectService.getProjectByUserId(userId);
		String pId = projectModel.getId();
		//查询出这个项目下的所有的班组列表
		List<ProjectDepartmentModel> projectDepartmentList = projectDepartmentService.getByProjectId(pId, 3);
		ArrayList<TeamModel> teamList = new ArrayList<TeamModel>();
		for (ProjectDepartmentModel projectDepartment : projectDepartmentList) {
			TeamModel teamModel = teamService.getTeamById(projectDepartment.getvId());
			if(teamModel!=null ){
				teamList.add(teamModel);
			}
		}
		return teamList;
	}
}
