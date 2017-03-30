package com.fengyun.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.NoticeLogDAO;
import com.fengyun.web.db.playermodel.NoticeLogModel;
import com.fengyun.web.service.NoticeLogService;

/**
 * 公告消息是否被读取Service实现类
 * @author hsx
 *
 */
@Service
public class NoticeLogServiceImpl implements NoticeLogService {

	/**
	 * 新增
	 */
	@Override
	public boolean addNoticeLog(NoticeLogModel noticeLogModel) {
		return NoticeLogDAO.addNoticeLog(noticeLogModel);
	}

	/**
	 * 根据用户的UserID(手机号)
	 */
	@Override
	public List<NoticeLogModel> getListByUserId(String userId) {
		return NoticeLogDAO.getListByUserId(userId);
	}

	/**
	 * 根据公告的ID和用户的userID(手机号)查询
	 */
	@Override
	public NoticeLogModel getByNoticeIdAndUserId(String noticeId, String userId) {
		return NoticeLogDAO.getByNoticeIdAndUserId(noticeId, userId);
	}

	/**
	 * 更新
	 */
	@Override
	public boolean updateNoticeLog(NoticeLogModel noticeLogModel) {
		return NoticeLogDAO.updateNoticeLog(noticeLogModel);
	}
	
}
