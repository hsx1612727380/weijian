package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.db.playermodel.NoticeLogModel;

/**
 * 公告消息是否被读取Service接口
 * @author hsx
 *
 */
public interface NoticeLogService {

	/**
	 * 新增
	 * @param noticeLogModel
	 * @return
	 */
	boolean addNoticeLog(NoticeLogModel noticeLogModel);

	/**
	 * 根据用户的UserID(手机号)
	 * @param userId
	 * @return
	 */
	List<NoticeLogModel> getListByUserId(String userId);

	/**
	 * 根据公告的ID和用户的userID(手机号)查询
	 * @param nId
	 * @param userId
	 * @return
	 */
	NoticeLogModel getByNoticeIdAndUserId(String noticeId, String userId);

	/**
	 * 更新
	 * @param noticeLogModel
	 */
	boolean updateNoticeLog(NoticeLogModel noticeLogModel);
	
}
