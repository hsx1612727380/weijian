package com.fengyun.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.db.playermodel.MessageModel;
import com.mongodb.BasicDBObject;

/**
 * 一对一消息Service接口
 * @author hsx
 *
 */
public interface MessageService {

	/**
	 * 新增
	 * @param messageModle
	 * @return
	 */
	boolean addMessage(MessageModel messageModle);
	
	/**
	 * 返回用户的要在页面上存放的数据
	 * @param mav
	 * @param userId
	 * @param userType
	 * @return
	 */
	ModelAndView showMessage(ModelAndView mav, String userId, int userType);

	/**
	 * 根据发送者和接受者的UserId(手机号)删除
	 * @param sUserId
	 * @param rUserId
	 * @return
	 */
	boolean delMessageByUserIds(String sUserId, String rUserId);

	/**
	 * 根据接受者的UserId(手机号)和是否已读查询 
	 * @param receiveUserId
	 * @param isRead
	 * @return
	 */
	List<MessageModel> getAllListByRUserIdAndIsRead(String receiveUserId, String isRead);

	/**
	 * 据接受者的UserId(手机号)查询 
	 * @param receiveUserId
	 * @return
	 */
	List<MessageModel> getAllListByRUserId(String receiveUserId);

	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	MessageModel getById(String id);

	/**
	 * 修改
	 * @param messageModel
	 * @return
	 */
	boolean updateMessage(MessageModel messageModel);
	
	/**
	 * 后台消息列表分页
	 * @param queryObj
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	List<MessageModel> getMessageList(BasicDBObject queryObj, int pageNow,
			int pageSize);
	
	/**
	 * 计算后台每页消息条数
	 * @param queryObj
	 * @return
	 */
	long countAllMessage(BasicDBObject queryObj);

	/**
	 * 新增
	 * @param rUserId
	 * @param rUserType
	 * @param sUserId
	 * @param sUserType
	 * @param messageTitle
	 * @param isFeedback
	 * @return
	 */
	boolean addMessageByParms(String rUserId, String rUserType, String sUserId,
			String sUserType, String messageTitle, String isFeedback);

	/**
	 * 页面要显示的内容
	 * @param isRead - 是否已读（页面的标志和数据库中的字段）
	 * @param mav - ModelAndView
	 * @param userId - 当前用户的UserId
	 * @param userType - 当前用户的类型
	 * @param isLeader - 是否是班组长（这个字段只有userType是0时才有其值，其他时为null）
	 */
	Map<String, Object> getShowMessageHasMap(String isRead, ModelAndView mav, String userId, 
			String userType, String isLeader);

	/**
	 * 修改Message的是否已读状态
	 * @param messageId
	 * @return
	 */
	boolean updateIsRead(String messageId);

}
