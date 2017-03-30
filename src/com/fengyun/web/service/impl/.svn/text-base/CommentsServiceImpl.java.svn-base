package com.fengyun.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.CommentsDAO;
import com.fengyun.web.db.playermodel.CommentsModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.service.CommentsService;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.TeamService;
import com.mongodb.BasicDBObject;

@Service
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	private ProjectDepartmentService projectDepartmentService;
	
	@Autowired
	private TeamService teamService;
	
	@Override
	public List<CommentsModel> getListByIdAndType(String cId, int type) {
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("cId", cId);
		queryObj.put("type", type);
		return CommentsDAO.getAll(queryObj);
	}

	@Override
	public void addComments(String startTime, String endTime,
			String projectName, String teamName,String name, int score1, int score2,
			int score3, String desc, int type, String cId) {
		CommentsModel model = new CommentsModel();
		model.setStartTime(startTime);
		model.setEndTime(endTime);
		model.setProjectName(projectName);
		model.setTeamName(teamName);
		model.setScore1(score1);
		model.setScore2(score2);
		model.setScore3(score3);
		model.setDesc(desc);
		model.setType(type);
		model.setcId(cId);
		if(name!=null){
			model.setName(name);
		}
		CommentsDAO.insert(model);
	}

	/**
	 * 获取评价信息(个人)
	 * @param userId
	 * @param type
	 * @return
	 */
	@Override
	public List<CommentsModel> getComments(String userId, int type) {
		// TODO Auto-generated method stub
		TeamModel teamModel = teamService.getTeamModelByUserId(userId);
		List<CommentsModel> commentsModelList = new ArrayList<CommentsModel>();
		String cId = null;
		if(teamModel!=null){
			cId = teamModel.getId();
			commentsModelList = this.getCommentByIdAndType(cId, type);
		}
		return commentsModelList;
	}

	/**
	 * 通过cId和type查询 (班组)comments -zss
	 * @param cId
	 * @param type
	 */
	private List<CommentsModel> getCommentByIdAndType(String cId, int type) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("cId", cId);
		queryObj.put("type", type);
		List<CommentsModel> commentsModelList =  CommentsDAO.getAll(queryObj);
		return commentsModelList;
	}

	/**
	 * 根据班组的ID、项目的ID和班组的类型查询评论
	 */
	@Override
	public CommentsModel getByVidAndPidAndType(String cId, String pId,
			int type) {
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("cId", cId);
		queryObj.put("pId", pId);
		queryObj.put("type", type);
		CommentsModel commentsModel = CommentsDAO.getByVidAndPidAndType(queryObj);
		return commentsModel;
	}

	/**
	 * 根据班组的ID获取记录数
	 */
	@Override
	public List<CommentsModel> getListByVId(String vId) {
		return CommentsDAO.getListByVId(vId);
	}

	/**
	 * 通过项目操作员的userId和 commentsModel的type获取到该项目下的所有的班组及其成员的进出场评价
	 * EAE:EnterAndExit 进出场
	 */
	@Override
	public List<CommentsModel> getEAECommentByUserId(String pId, int type) {
		// TODO Auto-generated method stub
		List<CommentsModel> list = new ArrayList<CommentsModel>();
		//查询当前项目（pId）下的评价信息(包含进退场信息)
		BasicDBObject queryObj = new BasicDBObject(3);
		queryObj.put("type", type);
		queryObj.put("pId", pId);
		list = CommentsDAO.getAll(queryObj);
		return list;
	}

	/**
	 * 添加一个进出场信息
	 */
	@Override
	public void addOneEnterAndExit(CommentsModel commentsModel,String inOrOut, String pId, int type) {
		commentsModel.setpId(pId);
		commentsModel.setCreateTime(new Date());
		CommentsDAO.insert(commentsModel);
		if("0".equals(inOrOut)){//退场把projectDepartment表中的状态改为工程已结束或离开status=4
			ProjectDepartmentModel projectDepartmentModel = projectDepartmentService.getByPIdAndVIdAndType(pId, commentsModel.getcId(), type);
			if(projectDepartmentModel!=null){
				projectDepartmentModel.setStatus(4);
				projectDepartmentService.updateProjectDepartment(projectDepartmentModel);
			}
		}
	}

	/**
	 * 将班组长的commentsModel和班组长的电话对应放入一个map中
	 */
	@Override
	public Map<TeamModel, CommentsModel> getLeaderMap(List<CommentsModel> leaderList) {
		// TODO Auto-generated method stub
		Map<TeamModel, CommentsModel> map = new HashMap<TeamModel, CommentsModel>();
		for (CommentsModel commentsModel : leaderList) {
			String tId = (String)commentsModel.getcId();
			TeamModel teamModel = teamService.getTeamById(tId);
			map.put(teamModel, commentsModel);
		}
		return map;
	}

	@Override
	public List<TeamModel> getTeamList(String pId) {
		//查询加入项目的劳务班组
		List<ProjectDepartmentModel> projectDepartmentList = projectDepartmentService.getTeamByPIdStatus(pId, 1, 3);
		ArrayList<TeamModel> list = new ArrayList<TeamModel>();
		if(projectDepartmentList.size()!=0){
			//把询加入项目的劳务班组封装进list集合中。
			for (ProjectDepartmentModel projectDepartmentModel : projectDepartmentList) {
				TeamModel teamModel = teamService.getTeamById(projectDepartmentModel.getvId());
				if(teamModel!=null){
					list.add(teamModel);
				}
			}
		}
		return list;
	}

	@Override
	public boolean deleteById(String id) {
		// TODO Auto-generated method stub
		return CommentsDAO.deleteById(id);
	}

}
