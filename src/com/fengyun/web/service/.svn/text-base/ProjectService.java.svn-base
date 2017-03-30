package com.fengyun.web.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.mongodb.BasicDBObject;

public interface ProjectService {

	/** 是否创建过项目 */
	public ProjectModel getProjectByUserId(String userId);

	/** 新增项目 */
	boolean addProject(String identity,String companyType,String name, String code, String pCode, String userId, 
			String leaderName, String province, String city, String street, int price,
			int prepaid, int check, String lonlat, String lonlat2, String allWork, 
			String accWork, String provinceCode, String type, String projectTitanic, 
			String projectlevel, String projectorgan, String replytime, String investment,
			String totalarea, String scale, String nature, String purpose, String worktime,
			String thsWork,int times,String unit,String buildUnit);

	
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

	/** 通过邀请，接受邀请 */
	public void passProjectDepartment(String id);
	
	/**获取所有项目*/
	public List<ProjectModel> getProjectList(BasicDBObject queryObj,int pageNow,int pageSize);
	
	/**获取项目总数*/
	public long countAllProject(BasicDBObject queryObj);
	
	/**
	 * 删除项目
	 */
	public void delProject(String id);
	
	/**根据ID获取项目信息*/
	public ProjectModel getById(String id);
	
	/**根据pCode获取项目信息*/
	public ProjectModel getByPCode(String pCode);
	
	/**更新项目信息*/
	public void updateProject(ProjectModel model);
	
	/**审核项目*/
	public void projectPass(String id);
	
	/**根据项目ID获取班组，材料商，设备商信息(已邀请)*/
	public Object[] getProjectDepartmentByPId(String pId);
	
	/**更新项目班组状态*/
	public void updateProjectDepartmentStatus(ProjectDepartmentModel model);
	
	/**新增项目班组*/
	public void addProjectDepartment(ProjectDepartmentModel model);

	/**
	 * 模糊查询项目名称 -zss
	 * @param pName
	 * @return
	 */
	public List<ProjectModel> getPNameList(String pName);
	
	/**根据文本查询名称或者负责人，街道地址符合搜索条件的项目*/
	public List<ProjectModel> getSearchList(String text);

	/**
	 * 根据公司代码查询公司所有的项目
	 * @param companyCode
	 * @return
	 */
	public List<ProjectModel> getByCode(String companyCode);

	/**
	 * 前台页面添加
	 */
	public boolean frontAddProject(String name, String code, String pCode,
			String allWork, String thsWork, String accWork, String userId,
			String leaderName, int times, String province, String city,
			String street, int price, int prepaid, String status, int progress,
			String projectTitanic, String projectlevel, String projectorgan,
			String provinceCode, String replytime, String totalarea,
			String purpose, String nature, String worktime, String type,
			String unit, int check, String lonlat, String lonlat2);

	
	/**项目注册*/
	public ModelAndView registerProjectRegister(ProjectModel projectModel, ModelAndView mav);
	
	
	/**
	 * 通过项目名称查询项目
	 * @param name
	 * @return
	 */
	public ProjectModel getByName(String name);
	
	
	/**
	 * 通过项目负责人电话查询项目
	 * @param userId
	 * @return
	 */
	public ProjectModel getByUserId(String userId);
	
	/**
	 * 判断施工班组是否已经加入项目
	 * @param tId
	 * @return true已经加入  false未加入
	 */
	public boolean teamJoinProject(String tId);

}
