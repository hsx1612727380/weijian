package com.fengyun.web.service;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.db.playermodel.NoticeModel;
import com.fengyun.web.hardcode.UserType;
import com.mongodb.BasicDBObject;

/**
 * 公告消息服务接口
 * @author hsx
 *
 */
public interface NoticeService {

	/**
	 * 新增
	 * @param noticeModel
	 * @return
	 */
	boolean addNotice(NoticeModel noticeModel);

	/**
	 * 获取所有的公告消息
	 * @return
	 */
	List<NoticeModel> getAllList();

	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	NoticeModel getById(String id);

	/**
	 * 获取要做页面显示Notice信息
	 * @param isRead - 是否已读（页面的标志）
	 * @param mav - ModelAndView
	 * @param userId - 当前用户的UserId 
	 * @param userType - 当前的用户的类型
	 * @param isLeader - 是否是班组长（这个字段只有userType是0时才有其值，其他时为null）
	 * @return
	 */
	Map<String, Object> getShowNoticeHasMap(String isRead, ModelAndView mav,
			String userId, String userType, String isLeader);

	/**
	 * 获取某个公告的具体内容
	 * @param nId - Notice的ID
	 * @param id - 用户、班组长、材料商、设备商、操作员、企业的ID
	 * @param userType - 当前用户的类型
	 * @param isLeader - 是否是班组长（这个字段只有userType是0时才有其值，其他时为null）
	 * @return
	 */
	List<JSONObject> getNoticeInfo(String nId, String id, String userType,
			String isLeader);
	
	/**
	 * 后台公告列表分页
	 * @param queryObj
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	List<NoticeModel> getNoticeList(BasicDBObject queryObj, int pageNow,
			int pageSize);
	
	/**
	 * 计算每页公告条数
	 * @param queryObj
	 * @return
	 */
	long countAllNotice(BasicDBObject queryObj);

	/**
	 * 登陆或注册时获取的消息的总数
	 * @param userId
	 * @return
	 */
	Map<String, String> getNMCount(String userId);
	
}
