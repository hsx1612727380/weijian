package com.fengyun.web.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.RequirementsModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.mongodb.BasicDBObject;

public interface UserService {

	/**
	 * 公司用户个、人用户通过手机号查询方法
	 * @param userId
	 * @param password
	 * @return
	 */
	Object checkLogonByPhone(String userId, String password);
	
	/**
	 * 公司用户个、人用户通过身份证查询方法
	 * @param userId
	 * @param password
	 * @return
	 */
	Object checkLogonByIdentity(String userId, String password);

	/**
	 * 分页查询所有管理员
	 * 
	 * @param name
	 * @return
	 */
	List<UserModel> listUser(int row, int skip);

	/**新增用户*/
	void addUser(UserModel userModel);

	/**检测电话是否注册过，返回1：没注册过，返回0：注册过
	 */
	String mobilRepCHeck(String mobilPhone);

	/** 获取所有用户 */
	public List<UserModel> getUserList(BasicDBObject queryObj, int pageNow,
			int pageSize);

	/** 获取用户总数 */
	public long countAllUser(BasicDBObject queryObj);
	
	/**
	 * 删除用户
	 */
	public void delUser(String id);
	
	/**
	 * 根据用户ID获取用户信息
	 * @param userId
	 * @return
	 */
	public UserModel getByUserId(String userId);
	/**
	 * 更新用户资料
	 * @param model
	 */
	public void updateUser(UserModel model);

	/**根据文本查询名称或者负责人，街道地址符合搜索条件的个人*/
	public List<UserModel> getSearchList(String text);

	/**
	 * 统计符合条件的用户数量 -zss
	 * @param userId
	 * @param userProvince
	 * @param userStatus 
	 * @param string 
	 * @return
	 */
	long countUserByConditions(String userId, String userProvince, String userStatus, int reliableStar, String string);

	/**
	 * 查询符合条件的用户 -zss
	 * @param session 
	 * @param userId
	 * @param userProvince
	 * @param userStatus 
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	List<UserModel> getUserListByConditions(HttpSession session, String userId, String userProvince,
			String userStatus, int reliableStar, String userType, int pageNow, int pageSize);

	/**
	 * 企业中心添加项目负责人联系方式时判断是否注册，如果没有注册，给其注册，如果是普通用户，将其修改为项目负责人
	 * @param userId
	 * @param leaderName
	 * @return
	 */
	String regCompanyProjectUserId(String userId, String leaderName);

	

	/**
	 * 身份证号与等级的手机号是否一致,返回0：不一致，返回1：一致
	 */ 
	// 
	int identityRep(String identity, String userId);
	
	/**
	 * 身份证号码是否被注册过,返回0：身份证未被注册，返回1：身份证已注册
	 */ 
	int identityHaveReg(String identity);

	/**
	 * 通过userId查询出已经加入的项目的项目名称
	 * @param userId
	 * @param isLeader 
	 * @return
	 */
	String getInvolvedProjectName(String userId, String isLeader);

	/**
	 * 修改用工状态到已找到工作(工人、班组修改personModel表和userModel表中的用工状态，材料商设备商只修改userModel中的用工状态)
	 * 使用功能场景：用户（工人、班组、材料设备商）申请加入班组、项目（通过申请时）
	 * @param userId	传入要修改状态的用户的userId（注册手机号）
	 * @param userType 用户类别 0：用户  1：材料商  2：设备商 
	 * @param isLeader 如果是劳务班组长isLeder置为1，否则置为0
	 * @param getOrLose 1-找到了工作（修改状态为在职），0-失去工作（修改状态为找工作）
	 * 用工状态 1：正在找工作 ；2：在岗；3：在岗寻求更好的工作
	 * @return
	 */
	boolean changeJobStatus(String userId,String userType,String isLeader,int getOrLose);

	/**
	 * 判断用户是否存在User表中
	 * @param userId
	 * @return
	 */
	UserModel regUserIdExist(String userId);

	/**
	 * 到RequirementsModel表中查询已经发布的开放中的招聘信息
	 * @param session
	 * @return
	 */
	List<RequirementsModel> getTeamRecruiteList(HttpSession session);

	/**
	 * 添加发布一条班组招聘信息
	 * @param requirement
	 * @return
	 */
	boolean addRequirement(RequirementsModel requirement);

	/**
	 * 通过id删除一个招聘记录
	 * @param id
	 */
	void deleteById(String id);

	/**
	 * 
	 * @param session
	 * @param type
	 * @param status
	 * @return
	 */
	Map<ProjectModel,ProjectDepartmentModel> getCurrentProject(HttpSession session, int type, int status);

	/**
	 * 根据身份证查询User
	 * @param userIdentity
	 * @return
	 */
	UserModel getByUserIdentity(String userIdentity);
	
}
