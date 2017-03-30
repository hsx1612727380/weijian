package com.fengyun.web.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.RequirementsModel;
import com.mongodb.BasicDBObject;

public interface RequirementsService {

	public long countAll(BasicDBObject queryObj);
	/**列出一页符合条件的班组 rkai*/
	public List<RequirementsModel> getList(BasicDBObject queryObj,int pageNow,int pageSize);
	
//	public void add(String title,String rId,int type,int userType,int skillBigType,
//			int skillSmallType,String province,String city,String street,int teamType,String shopName,int num);
//	
	/**
	 * 根据班组ID获得班组招聘信息
	 * @param tId
	 * @return
	 */
	public RequirementsModel getRecruitByTeamId(String tId,int type);
	
	/**
	 * 个人申请班组成功
	 * @param userId
	 * @param tId
	 */
	public void persoonApplyTeam(String userId,String tId);
	
	/**
	 * 根据项目ID，招聘班组类型获取项目招聘信息
	 * @param userId
	 * @param tId
	 */
	public RequirementsModel getById(String id);
	
	/**
	 * 删除信息
	 * @param userId
	 * @param tId
	 */
	public void delById(String id);
	
	/**
	 * 删除信息
	 * @param userId
	 * @param tId
	 */
	public void updateStatus(String id,int status);

	/**
	 * 新增个人招聘信息
	 * @param title
	 * @param code
	 * @param skillBigType
	 * @param smalltype
	 * @param num
	 * @param province
	 * @param city
	 */
	void addRecruitPerson(String title ,String code,String skillBigType,String smalltype,
			String num ,String province ,String city,String street,String desc);
	
	/**
	 * 新增班组招聘信息
	 * @param title
	 * @param code
	 * @param skillBigType
	 * @param smalltype
	 * @param province
	 * @param city
	 * @param street
	 */
	void addRecruitTeam(String title ,String code,String skillBigType,String smalltype,
			String province ,String city,String street,String desc);
	
	/**
	 * 新增材料采购
	 * @param title
	 * @param code
	 * @param shopName
	 * @param province
	 * @param city
	 * @param street
	 */
	void addRecruitMaterial(String title ,String code,String shopName,
			String province ,String city,String street,String desc);
	
	/**
	 * 新增设备租赁
	 * @param title
	 * @param code
	 * @param shopName
	 * @param province
	 * @param city
	 * @param street
	 */
	void addRecruitEquip(String title ,String code,String shopName,
			String province ,String city,String street,String desc);
	
	/**
	 * 新增个人求职
	 * @param title
	 * @param userId
	 * @param skillBigType
	 * @param smalltype
	 * @param province
	 * @param city
	 * @param street
	 */
	void addJobPerson(String title ,String userId,String skillBigType,String smalltype,
			String province ,String city,String street,String desc);
	
	/**
	 * 班组求职
	 * @param title
	 * @param code
	 * @param skillBigType
	 * @param smalltype
	 * @param province
	 * @param city
	 * @param street
	 */
	void addJobTeam(String title ,String code,String skillBigType,String smalltype,
			String province ,String city,String street,String desc);
	
	/**
	 * 新增材料供应
	 * @param title
	 * @param code
	 * @param shopName
	 * @param province
	 * @param city
	 * @param street
	 */
	void addJobMaterial(String title ,String code,String shopName,
			String province ,String city,String street,String desc);
	
	/**
	 * 新增设备供应
	 * @param title
	 * @param code
	 * @param shopName
	 * @param province
	 * @param city
	 * @param street
	 */
	void addJobEquip(String title, String code, String shopName,
			String province, String city, String street,String desc);
	
	/**
	 * 提交对项目求职申请
	 * @param session
	 * @param requireModel
	 */
	public void saveApply(HttpSession session, RequirementsModel requireModel);
	
	/**
	 * 通过类型标记查询出 正在【招聘】的【项目】 -zss
	 * @param type == 2 
	 * @param userType == 3
	 * @param status ==1 招聘信息开放状态
	 * @param pageNow 
	 * @param pageSize 
	 * @param teamType 
	 * @return List<RequirementsModel>
	 */
	public Map<Page,List<RequirementsModel>> getRequirement( int pageSize, int pageNow, int type, int userType, int teamType, int status,String tId);
	
	/**
	 * 通过类型标记统计出 正在【招聘】的【项目】 -zss
	 * @param type
	 * @param userType 
	 * @param status 
	 * @param leaderName 
	 * @param name 
	 * @param city 
	 * @param province 
	 * @return
	 */
	public long count(int type, int userType,int teamType, int status, String province, String city, String name, String leaderName);

	/**
	 * 通过类型标记查询出 正在【招聘】的【项目】 -zss
	 * @param type == 2 
	 * @param userType == 3
	 * @param status ==1 招聘信息开放状态
	 * @param leaderName 
	 * @param name 
	 * @param city 
	 * @param province 
	 * @param pageNow 
	 * @param pageSize 
	 * @return List<RequirementsModel>
	 */
	public List<RequirementsModel> getRequirement(Page page, int type,int userType,int teamType, int status, String province, String city, String name, String leaderName);
	
	/**
	 * 添加一条材料供应信息 -zss
	 */
	public void addSupply(RequirementsModel requirementsModel);
	
	/**
	 * 查询一个材料商所有的材料供应信息
	 * @param rId
	 * @param leaderName
	 * @param teamType
	 * @param userType
	 * @param pageSize 
	 * @param pageNow 
	 * @param userType 
	 * @param type 
	 * @return
	 */
	public List<RequirementsModel> getRequirements(String rId,
			String leaderName, int teamType, int status, int type, int userType ,int pageNow, int pageSize);
	
	/**
	 * 统计发布的材料供应信息总条数
	 * @param rId
	 * @param leaderName
	 * @param teamType
	 * @param status
	 * @param userType 
	 * @param type 
	 * @return
	 */
	public long countSupplies(String rId, String leaderName, int teamType,
			int status, int type, int userType);
	
	/**
	 * 通过供应材料名称获取到一条数据
	 * @param shopName
	 * @param rId 
	 * @return
	 */
	public RequirementsModel getReqirement(String shopName, String rId);
	
	/**
	 * 根据Requirements中的标题等信息判断是否已经发布了这信息
	 * @param projectId
	 * @param title
	 * @param skillBigType
	 * @param skillSmallType
	 * @return
	 */
	public RequirementsModel getRequirementsByTitleAndSoOn(String projectId,
			String title, String skillBigType, String skillSmallType);
	
	/**
	 * 根据项目的ID和type和status的状态查询RequirementsModel
	 * @param projectId
	 * @param type 1-求职 2-招聘
	 * @param status // 状态 0表示关闭
	 * @return
	 */
	public List<RequirementsModel> getByRIdAndTypeAndStatus(String projectId, int type,
			int status,String rId);
	
	/**
	 * 添加RequirementsModel
	 * @param requirementsModel
	 */
	public void addRequirementsModel(RequirementsModel requirementsModel);
	
	/**
	 * 根据项目的ID和type和status的状态查询RequirementsModel
	 * @param projectId
	 * @param type 1-求职 2-招聘
	 * @param status // 状态 0表示关闭
	 * @param userType 班组类型：1-施工班组，2-材料商，3-设备商
	 * @return
	 */
	public List<RequirementsModel> getByRIdAndTypeAndStatusAndUserType(
			String projectId, int type, int status, int teamType);
	
	/**
	 * 新增一条记录
	 * @param requirementsModel
	 */
	public void addRequirementsTeamModel(RequirementsModel requirementsModel);
	
	
}
