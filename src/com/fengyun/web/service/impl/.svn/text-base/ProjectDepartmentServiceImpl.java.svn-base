package com.fengyun.web.service.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.ProjectDepartmentDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.dao.TeamDAO;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.service.EquipmentService;
import com.fengyun.web.service.MaterialService;
import com.fengyun.web.service.ProjectDepartmentService;
import com.fengyun.web.service.ProjectService;
import com.mongodb.BasicDBObject;

@Service
public class ProjectDepartmentServiceImpl implements ProjectDepartmentService{

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private EquipmentService equipmentService;
	
	@Override
	public void inviteProjectDepartment(String pId, String vId, int type,int status) {
		// TODO Auto-generated method stub
		//是否已经被邀请或者通过
		ProjectDepartmentModel pmModel = ProjectDepartmentDAO.getByTypeAndId(vId, pId, type);
		if(pmModel != null)
			return;
		
		//邀请成功
		pmModel = new ProjectDepartmentModel();
		pmModel.setVId(vId);
		pmModel.setPId(pId);
		pmModel.setStatus(status);
		pmModel.setType(type);
		
		try{
			ProjectDepartmentDAO.insert(pmModel);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void passProjectDepartment(String id) {
		// TODO Auto-generated method stub
		try{
			ProjectDepartmentModel pmModel = ProjectDepartmentDAO.getById(id);
			if(pmModel != null){
				pmModel.setStatus(1);//审核通过
				ProjectDepartmentDAO.updateStatus(pmModel);
				//如果是施工班组，则将班组工作状态进行修改
				if(pmModel.getType() == 1){
					TeamModel teamModel = TeamDAO.getById(pmModel.getvId());
					if(teamModel != null){
						teamModel.setStatus(1);
						TeamDAO.updateStatus(teamModel);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	@Override
	public ProjectDepartmentModel getProjectDepartment(String pId, String vId, int type) {
		// TODO Auto-generated method stub
		return ProjectDepartmentDAO.getByTypeAndId(pId, vId, type);
	}

	@Override
	public void updateProjectDepartmentStatus(ProjectDepartmentModel model) {
		// TODO Auto-generated method stub
		ProjectDepartmentDAO.updateStatus(model);
		//如果是施工班组，则将班组工作状态进行修改
		if(model.getType() == 1){
			TeamModel teamModel = TeamDAO.getById(model.getvId());
			if(teamModel != null){
				if(teamModel.getStatus()==0)
				{
					teamModel.setStatus(1);
					TeamDAO.updateStatus(teamModel);
				}
			}
		}
	}

	/**
	 * 新增成员
	 */
	@Override
	public void addProjectDepartment(ProjectDepartmentModel model) {
		// TODO Auto-generated method stub
		ProjectDepartmentDAO.insert(model);
	}

	@Override
	public List<ProjectDepartmentModel> getProjectDepartment(String vId,
			int status, int pageSize, int pageNow) {
		if (pageNow <= 0)
			pageNow = 1;
		if (pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return ProjectDepartmentDAO.getProjectDepartment(vId,status,pageSize,skip);
	}

	@Override
	public int countMember(String vId, int status) {
		// TODO Auto-generated method stub
		return ProjectDepartmentDAO.countMember(vId,status);
	}

	@Override
	public ProjectDepartmentModel getModelByTIdAndUserId(String vId, String pId) {
		// TODO Auto-generated method stub
		ProjectDepartmentModel model= ProjectDepartmentDAO.getModelByTidAndVid(vId,pId);
		 return model;
	}

	@Override
	public ProjectDepartmentModel getById(String id) {
		// TODO Auto-generated method stub
		return ProjectDepartmentDAO.getById(id);
	}

	@Override
	public void deleteById(String id) {
		//暂时取消物理删除，把状态置为0
		// ProjectDepartmentDAO.deleteById(id);
		ProjectDepartmentModel model = getById(id);
		if(model != null){
			model.setStatus(0);
			ProjectDepartmentDAO.updateStatus(model);
			//如果是施工班组，则将班组工作状态进行修改
			if(model.getType() == 1){
				TeamModel teamModel = TeamDAO.getById(model.getvId());
				if(teamModel != null){
					teamModel.setStatus(0);
					TeamDAO.updateStatus(teamModel);
				}
			}
		}
	}
	
	
	/**
	 * 通过项目id查询所有已加入的班组
	 */
	@Override
	public List<ProjectDepartmentModel> getTeamByPIdStatus(String pId,int type,int status){
		return ProjectDepartmentDAO.getTeamByPId(pId, type, status);
	}
	
	
	/**
	 * 通过班组id查询所有项目
	 */
	@Override
	public List<ProjectDepartmentModel> getProjectByTIdStatus(String vId, int type, int status){
		return ProjectDepartmentDAO.getProjectByTId(vId, type, status);
	}

	/**
	 * 修改项目的对应的班组信息
	 */
	@Override
	public void updateProjectDepartment(ProjectDepartmentModel model) {
		ProjectDepartmentDAO.updateModel(model);
	}

	/**
	 * 根据项目的ID、班组的ID和班组的类型查询
	 */
	@Override
	public ProjectDepartmentModel selectByPIdAndVIdAndType(String pId, String vId, int type) {
		return ProjectDepartmentDAO.selectByPIdAndVIdAndType(pId, vId, type);
	}

	
	@Override
	public ProjectDepartmentModel getApplied(String vId, String pId, int type,
			int status) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject(5);
		queryObj.put("vId", vId);
		queryObj.put("pId", pId);
		queryObj.put("type", type);
		queryObj.put("status", status);
		ProjectDepartmentModel departmentModel = ProjectDepartmentDAO.getByQueryObj(queryObj);
		return departmentModel;
	}

	/**
	 * 
	 */
	@Override
	public List<ProjectModel> getApplyProjectByTIdStatus(
			List<ProjectDepartmentModel> pastProjectDepartmentList) {
		// TODO Auto-generated method stub
		List<ProjectModel> list = new LinkedList<ProjectModel>();
		for (ProjectDepartmentModel ProjectDepart : pastProjectDepartmentList) {
			ProjectModel model = projectService.getById(ProjectDepart.getpId());
			list.add(model);
		}
		return list;
	}

	/**
	 * 将获取的projectModel集合和申请项目的集合对应拼装在一个map中
	 * @param pastProjectList
	 * @param pastProjectDepartmentList
	 * @return
	 */
	@Override
	public Map<ProjectModel, ProjectDepartmentModel> getApplyInfo(
			List<ProjectModel> pastProjectList,
			List<ProjectDepartmentModel> pastProjectDepartmentList) {
		// TODO Auto-generated method stub
		Map<ProjectModel,ProjectDepartmentModel> map = new HashMap<ProjectModel, ProjectDepartmentModel>();
		for (ProjectModel projectModel : pastProjectList) {
			for (ProjectDepartmentModel projectDepartmentModel : pastProjectDepartmentList) {
				if(projectDepartmentModel.getpId().equals(projectModel.getId())){
					map.put(projectModel, projectDepartmentModel);
				}
			}
		}
		return map;
	}

	@Override
	public List<ProjectModel> getProjectInvatationList(String Id,int type, int status) {
		// TODO Auto-generated method stub
		//vId 、type=2/3、status=2 (邀请中)
		List<ProjectDepartmentModel> list = this.getProjectByTIdStatus(Id, type, status);
		List<ProjectModel> projectList = new LinkedList<ProjectModel>();
		for (ProjectDepartmentModel projectDepartment : list) {
			ProjectModel model = projectService.getById(projectDepartment.getpId());
			projectList.add(model);
		}
		return projectList;
	}

	/**
	 * 【 接受\拒绝 】邀请
	 * @param pId
	 */
	@Override
	public void acceptOrRefuse(String pId, String userId, int type, int status) {
		// TODO Auto-generated method stub
		String vId = null;
		if(type==2){//材料商
			MaterialModel materialModel = materialService.getByUserId(userId);
			vId = materialModel.getId();
		}else if(type==3){//设备商
			EquipmentModel equipmentModel = equipmentService.getByUserId(userId);
			vId = equipmentModel.getId();
		}
		ProjectDepartmentModel pdModel = this.getApplied(vId, pId, type, 2);//查询正在邀请的 status为2
		ProjectDepartmentModel departmentModel = new ProjectDepartmentModel();
		if(pdModel!=null){
			departmentModel.setId(pdModel.getId());
			departmentModel.setpId(pId);
			departmentModel.setvId(vId);
			departmentModel.setType(type);
			departmentModel.setStatus(status);
			if(status==3){ //接受邀请
				this.updateProjectDepartment(departmentModel);
			}else if(status==4){//拒绝邀请 直接删除邀请记录
				this.deleteById(pdModel.getId());
			}
		}
	}

	/**
	 * 根据项目的编号获取参与这个项目的所有班组 
	 */
	@Override
	public List<ProjectDepartmentModel> getByProjectId(String pId, int status) {
		return ProjectDepartmentDAO.getByPId(pId, status);
	}

	/**
	 * 审核通过所有施工班组
	 */
	@Override
	public int projectDepartmentAll(String ids, int status) {
		int result = 0;
		ProjectDepartmentModel projectDepartmentModel = null;
		if (ids == null || ids.length() <= 0) {
			result = 0;
		}
		else {
			String[] pdmId = ids.split("&");
			if (pdmId != null) {
				for (int i = 0; i < pdmId.length; i++) {
					projectDepartmentModel = ProjectDepartmentDAO.getById(pdmId[i]);
					if (projectDepartmentModel != null) {
//						projectDepartmentModel.setStatus(status);
//						ProjectDepartmentDAO.updateStatus(projectDepartmentModel);
						this.updateProjectDepartmentStatus(projectDepartmentModel);
					}
				}
				result = 1;
			}
		}
		return result;
	}

	/**
	 * 根据班组的ID、项目的ID、班组的状态、班组的类别查询
	 */
	@Override
	public ProjectDepartmentModel getByVIdAndPIdAndStatusAndType(String vId,
			String projectId, int status, int type) {
		return ProjectDepartmentDAO.getByVIdAndPIdAndStatusAndType(vId, projectId, status, type);
	}

	/**
	 * 根据项目的ID，班组的ID、班组的类型查询
	 */
	@Override
	public ProjectDepartmentModel getByPIdAndVIdAndType(String pId, String vId,
			int type) {
		return ProjectDepartmentDAO.getByPIdAndVIdAndType(pId, vId, type);
	}

	/**
	 * 根据项目的ID，班组的ID、班组加入项目的状态
	 */
	@Override
	public ProjectDepartmentModel getByVIdAndPIdAndStatus(String vId,
			String pId, int status) {
		return ProjectDepartmentDAO.getByPIdAndVIdAndStatus(vId, pId, status);
	}

	@Override
	public ProjectDepartmentModel getModelByTidAndVid(String vId, String pId)
	{
		// TODO Auto-generated method stub
		return ProjectDepartmentDAO.getModelByTidAndVid(vId,pId);
	}

	/**
	 * 根据项目的ID和班组的类型查询
	 */
	@Override
	public List<ProjectDepartmentModel> getByPIdAndType(String pId, int type) {
		return ProjectDepartmentDAO.getByPIdAndType(pId, type);
	}

	/**
	 * 只修改ProjectDepartmentModel中的Status
	 */
	@Override
	public boolean updatePDStatus(ProjectDepartmentModel projectDepartmentModel) {
		ProjectDepartmentDAO.updateStatus(projectDepartmentModel);
		return false;
	}
	


}
