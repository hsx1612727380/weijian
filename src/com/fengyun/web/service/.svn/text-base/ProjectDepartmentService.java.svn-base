package com.fengyun.web.service;

import java.util.List;
import java.util.Map;

import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
/** @author rkai */

public interface ProjectDepartmentService {
	
	public ProjectDepartmentModel getProjectDepartment(String pId, String vId, int type);
	
	/**
	 * 邀请班组
	 * 
	 * @param pId
	 *            项目ID
	 * @param vId
	 *            班组或材料设备商ID
	 * @param type
	 *            班组或材料设备商
	 */
	public void inviteProjectDepartment(String pId, String vId, int type,int status);

	/** 查找符合条件的ProjectDepartment */
	public List<ProjectDepartmentModel> getProjectDepartment(String vId,int
			status,int pageSie,int pageNow);
	
	/** 统计符合条件的项目数 */
	public int countMember(String vId, int status);
	
	/** 通过邀请，接受邀请 */
	public void passProjectDepartment(String id);
		
	
	/**更新项目班组状态*/
	public void updateProjectDepartmentStatus(ProjectDepartmentModel model);
	
	/**新增项目班组*/
	public void addProjectDepartment(ProjectDepartmentModel model);

	/**
	 * 查询项目中某个班组、供应商等的信息rki
	 * @param vid 邀请的ID,有可能是班组ID，材料商ID，设备商ID
	 * @param pid 项目ID
	 */
	public ProjectDepartmentModel getModelByTIdAndUserId(String vId,String pId);
	
	/**
	 * 通过id查找对象
	 */
	public  ProjectDepartmentModel getById(String id);
	/**
	 * 通过id删除项目成员
	 */
	public  void deleteById(String id);

	/**
	 * 通过班组类型type和用户关系状态来查找 与项目(pId)有相应关系的班组列表
	 * @param pId
	 * @param type
	 * @param status
	 * @return
	 */
	List<ProjectDepartmentModel> getTeamByPIdStatus(String pId, int type,
			int status);

	/**
	 * @param vId
	 * @param type
	 * @param status
	 * @return
	 */
	List<ProjectDepartmentModel> getProjectByTIdStatus(String vId, int type,
			int status);

	/**
	 * 根据项目的编号获取参与这个项目的所有班组 
	 * @param pId
	 * @param status
	 * @return
	 */
	public List<ProjectDepartmentModel> getByProjectId(String pId, int status);
	
	/**
	 * 修改项目的对应的班组信息
	 * @param model
	 */
	public void updateProjectDepartment(ProjectDepartmentModel model);


	/**
	 * 根据项目的ID、班组的ID和班组的类型查询
	 * @param pId - 项目的ID
	 * @param vId - 班组的ID（施工班组，材料商，设备商）
	 * @param type - 班组的类型
	 */
	public ProjectDepartmentModel selectByPIdAndVIdAndType(String pId, String vId, int type);

	/**
	 * 查询是否正在申请
	 * @param getpId
	 * @param vId 
	 * @param type
	 * @param status
	 * @return
	 */
	public ProjectDepartmentModel getApplied(String vId,String pId, int type, int status);


	/**
	 * 通过过往申请ProjectDepartment集合遍历查询出对应的project集合
	 * @param pastProjectDepartmentList
	 * @return
	 */
	public List<ProjectModel> getApplyProjectByTIdStatus(
			List<ProjectDepartmentModel> pastProjectDepartmentList);

	/**
	 * 将获取的projectModel集合和申请项目的集合对应拼装在一个map中
	 * @param pastProjectList
	 * @param pastProjectDepartmentList
	 * @return
	 */
	public Map<ProjectModel, ProjectDepartmentModel> getApplyInfo(
			List<ProjectModel> pastProjectList,
			List<ProjectDepartmentModel> pastProjectDepartmentList);

	/**
	 * 通过材料商的id查询到邀请该用户材料商的项目
	 * @param Id
	 * @param status2 
	 * @return
	 */
	public List<ProjectModel> getProjectInvatationList(String Id, int type, int status);

	/**
	 * 接受邀请
	 * @param pId
	 * @param userId 
	 * @param name 
	 */
	public void acceptOrRefuse(String pId, String userId, int type,int status);

	/**
	 * 审核通过/拒绝所有施工班组、材料商、设备商
	 * @param ids
	 * @param status
	 * @return
	 */
	public int projectDepartmentAll(String ids, int status);

	/**
	 * 根据班组的ID、项目的ID、班组的状态、班组的类别查询
	 * @param vId
	 * @param projectId
	 * @param status
	 * @param type
	 * @return
	 */
	public ProjectDepartmentModel getByVIdAndPIdAndStatusAndType(String vId,
			String projectId, int status, int type);

	/**
	 * 根据项目的ID，班组的ID、班组的类型查询
	 * @param pId
	 * @param vId
	 * @param type
	 * @return
	 */
	public ProjectDepartmentModel getByPIdAndVIdAndType(String pId, String vId,
			int type);

	/**
	 * 根据项目的ID，班组的ID、班组加入项目的状态
	 * @param vId
	 * @param pId
	 * @param status
	 * @return
	 */
	public ProjectDepartmentModel getByVIdAndPIdAndStatus(String vId,
			String pId, int status);


	/**通过项目id，vid查找ProjectDepartmentModel rkai
	 * 
	 * 
	 */
	public ProjectDepartmentModel getModelByTidAndVid(String vId,String pId);

	/**
	 * 根据项目的ID和班组的类型查询
	 * @param pId
	 * @param type
	 * @return
	 */
	public List<ProjectDepartmentModel> getByPIdAndType(String pId, int type);

	/**
	 * 只修改ProjectDepartmentModel中的Status
	 * @param projectDepartmentModel
	 */
	public boolean updatePDStatus(ProjectDepartmentModel projectDepartmentModel);

}
