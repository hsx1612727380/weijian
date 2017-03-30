package com.fengyun.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.cache.page.Page;
import com.fengyun.web.cache.page.PageHandler;
import com.fengyun.web.db.dao.MessageDAO;
import com.fengyun.web.db.dao.NoticeDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.playermodel.CompanyModel;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.MessageModel;
import com.fengyun.web.db.playermodel.NoticeLogModel;
import com.fengyun.web.db.playermodel.NoticeModel;
import com.fengyun.web.db.playermodel.PersonModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.hardcode.ESessionKey;
import com.fengyun.web.service.CompanyService;
import com.fengyun.web.service.EquipmentService;
import com.fengyun.web.service.MaterialService;
import com.fengyun.web.service.MessageService;
import com.fengyun.web.service.NoticeLogService;
import com.fengyun.web.service.NoticeService;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.TeamService;
import com.mongodb.BasicDBObject;

/**
 * 一对一消息Service实现类
 * @author hsx
 *
 */
@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private NoticeLogService noticeLogService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private PersonService personService;
	
	/**
	 * 新增
	 */
	@Override
	public boolean addMessage(MessageModel messageModel) {
		return MessageDAO.addMessage(messageModel);
	}

	/**
	 * 返回用户的要在页面上存放的数据
	 */
	@Override
	public ModelAndView showMessage(ModelAndView mav, String userId, int userType) {
		String isRead = "0";
		if (userType == 0) { // 个人或者是班组长
			String isLeader = (String) request.getSession().getAttribute(ESessionKey.IsLeader.key);
			if ("0".equals(isLeader) || "2".equals(isLeader)) {
				PersonModel personModel = personService.getByUserId(userId);
				if (personModel != null) {
					mav.addObject("personModel", personModel);
				}
			} else if ("1".equals(isLeader)) {
				TeamModel teamModel = teamService.getTeamByLeaderMobile(userId);
				if (teamModel != null) {
					mav.addObject("teamModel", teamModel);
				}
			}
			mav.addObject("isLeader", isLeader);
		} else if (userType == 1) { // 材料商
			 MaterialModel materialModel = materialService.getByUserId(userId);
			 if (materialModel != null) {
				 mav.addObject("materialModel", materialModel);
			 }
		} else if (userType == 2) { // 设备商
			EquipmentModel equipmentModel = equipmentService.getByUserId(userId);
			if (equipmentModel != null) {
				mav.addObject("equipmentModel", equipmentModel);
			}
		} else if (userType == 3) { // 公司
			CompanyModel companyModel = companyService.getByUserId(userId);
			if (companyModel != null) {
				mav.addObject("companyModel", companyModel);
			}
		} else if (userType == 4) { // 操作员
			ProjectModel projectModel = projectService.getProjectByUserId(userId);
			if (projectModel != null) {
				mav.addObject("projectModel", projectModel);
			}
		}
		List<MessageModel> mModels = getAllListByRUserId(userId);
		int unReadMessageCount = 0; // 未读的一对一信息记录数
		int readMessageCount = 0; // 已读的一对一信息记录数
		List<MessageModel> unReadModels = new ArrayList<MessageModel>();
		List<MessageModel> readModels = new ArrayList<MessageModel>();
		if (mModels != null && !mModels.isEmpty()) {
			for (MessageModel messageModel : mModels) {
				if ("0".equals(messageModel.getIsRead())) {
					unReadMessageCount++;
					unReadModels.add(messageModel);
				} else if ("1".equals(messageModel.getIsRead())) {
					readMessageCount++;
					readModels.add(messageModel);
				}
			}
		}
		int pageNow = 1; 
		int pageCount = 0;
		int pageSize = 10; // 每页显示10条
		int dataCount = 0;
		if (request.getParameter("pageNowFirst") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowFirst"));
		}
		if (request.getParameter("pageNowPre") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowPre"));
		}
		if (request.getParameter("pageNowNext") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowNext"));
		}
		if (request.getParameter("pageNowLast") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowLast"));
		}
		if ("1".equals(isRead)) { 
			dataCount = readMessageCount;
		} else if ("0".equals(isRead)) {
			dataCount = unReadMessageCount; 
		}
		if (dataCount % pageSize == 0) {
			pageCount = (int) (dataCount / pageSize); 
		} else {
			pageCount = (int) (dataCount / pageSize + 1);
		}
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		if (page != null) {
			mav.addObject("page", page);
			List<MessageModel> unReadMessageModels = new ArrayList<MessageModel>();
			List<MessageModel> readMessageModels = new ArrayList<MessageModel>();
			if (pageNow * pageSize < dataCount) { 
				if ("0".equals(isRead)) {
					unReadMessageModels = unReadModels.subList((pageNow - 1) * pageSize, pageNow * pageSize);
				} else if ("1".equals(isRead)) {
					readMessageModels = readModels.subList((pageNow - 1) * pageSize, pageNow * pageSize);
				}
			} else {
				if ("0".equals(isRead)) {
					unReadMessageModels = unReadModels.subList((pageNow - 1) * pageSize, (int) dataCount);
				} else if ("1".equals(isRead)) {
					readMessageModels = readModels.subList((pageNow - 1) * pageSize, (int) dataCount);
				}
			}
			if (unReadMessageModels != null && !unReadMessageModels.isEmpty()) {
				mav.addObject("unReadMessageModels", unReadMessageModels);
			}
			if (readMessageModels != null && !readMessageModels.isEmpty()) {
				mav.addObject("readMessageModels", readMessageModels);
			}
		}
		int unReadNoticeCount = Integer.parseInt((String) request.getSession().getAttribute("unReadNoticeCount"));
		int readNoticeCount = Integer.parseInt((String) request.getSession().getAttribute("readNoticeCount"));
		request.getSession().setAttribute("count", (unReadNoticeCount + unReadMessageCount) + "");
		request.getSession().setAttribute("unReadNoticeCount", (unReadNoticeCount + ""));
		request.getSession().setAttribute("readNoticeCount", (readNoticeCount + ""));
		request.getSession().setAttribute("unReadMessageCount", (unReadMessageCount + ""));
		request.getSession().setAttribute("readMessageCount", (readMessageCount + ""));
		mav.addObject("pageCount", pageCount);
		mav.addObject("isRead", isRead);
		mav.addObject("flag", 1);
		return mav;
	}

	/**
	 * 根据发送者和接受者的UserId(手机号)删除
	 */
	@Override
	public boolean delMessageByUserIds(String sUserId, String rUserId) {
		boolean result = false;
		MessageModel messageModel = MessageDAO.getByUserIds(sUserId, rUserId);
		if (messageModel != null) {
			result = MessageDAO.delMessage(messageModel.getId());
		}
		return result;
	}

	/**
	 * 根据接受者的UserId(手机号)和是否已读查询 
	 */
	@Override
	public List<MessageModel> getAllListByRUserIdAndIsRead(String receiveUserId,
			String isRead) {
		return MessageDAO.getAllListByRUserIdAndIsRead(receiveUserId, isRead);
	}

	/**
	 * 据接受者的UserId(手机号)查询 
	 */
	@Override
	public List<MessageModel> getAllListByRUserId(String receiveUserId) {
		return MessageDAO.getAllListByRUserId(receiveUserId);
	}

	/**
	 * 根据ID查询
	 */
	@Override
	public MessageModel getById(String id) {
		return MessageDAO.getById(id);
	}

	/**
	 * 修改
	 */
	@Override
	public boolean updateMessage(MessageModel messageModel) {
		return MessageDAO.updateMessage(messageModel);
	}

	/**
	 * 新增
	 */
	@Override
	public boolean addMessageByParms(String rUserId, String rUserType,
			String sUserId, String sUserType, String messageTitle, String isFeedback) {
		MessageModel messageModel = new MessageModel();
		messageModel.setReceiveUserId(rUserId);
		messageModel.setReceiveUserType(rUserType); 
		messageModel.setSendUserId(sUserId);
		if ("4".equals(sUserType)) {
			ProjectModel projectModel = projectService.getByUserId(sUserId);
			if (projectModel != null) {
				messageModel.setSendUserName(projectModel.getName());
			}
		} else if ("3".equals(sUserType)) {
			CompanyModel companyModel = companyService.getByUserId(sUserId);
			if (companyModel != null) {
				messageModel.setSendUserName(companyModel.getName());
			}
		} else if ("2".equals(sUserType)) {
			EquipmentModel equipmentModel = equipmentService.getByUserId(sUserId);
			if (equipmentModel != null) {
				messageModel.setSendUserName(equipmentModel.getName());
			}
		} else if ("1".equals(sUserType)) {
			MaterialModel materialModel = materialService.getByUserId(sUserId);
			if (materialModel != null) {
				messageModel.setSendUserName(materialModel.getName());
			}
		} else if ("0".equals(sUserType)) {
			TeamModel teamModel = teamService.getTeamByLeaderMobile(sUserId);
			if (teamModel != null) {
				messageModel.setSendUserName(teamModel.getName());
			}
		}
		messageModel.setSendUserType(sUserType); 
		messageModel.setCreateTime(new Date());
		messageModel.setMessageTitle(messageTitle);
		messageModel.setIsRead("0");
		messageModel.setIsAdmin("1");
		messageModel.setIsFeedback(isFeedback);
		MessageDAO.addMessage(messageModel);
		return false;
	}

	/**
	 * 页面要显示的内容
	 */
	@Override
	public Map<String, Object> getShowMessageHasMap(String isRead, ModelAndView mav, 
			String userId,  String userType, String isLeader) {
		if ("0".equals(userType)) {
			if (isLeader != null) {
				if ("0".equals(isLeader) || "2".equals(isLeader)) {
					PersonModel personModel = personService.getByUserId(userId);
					if (personModel != null) {
						mav.addObject("personModel", personModel);
					}
				} else if ("1".equals(isLeader)) {
					TeamModel teamModel = teamService.getTeamByLeaderMobile(userId);
					if (teamModel != null) {
						mav.addObject("teamModel", teamModel);
					}
				}
			}
		} else if ("1".equals(userType)) {
			MaterialModel materialModel = materialService.getByUserId(userId);
			if (materialModel != null) {
				mav.addObject("materialModel", materialModel);
			}
		} else if ("2".equals(userType)) {
			EquipmentModel equipmentModel = equipmentService.getByUserId(userId);
			if (equipmentModel != null) {
				mav.addObject("equipmentModel", equipmentModel);
			}
		} else if ("3".equals(userType)) {
			CompanyModel companyModel = companyService.getByUserId(userId);
			if (companyModel != null) {
				mav.addObject("companyModel", companyModel);
			}
		} else if ("4".equals(userType)) {
			ProjectModel projectModel = projectService.getByUserId(userId);
			if (projectModel != null) {
				mav.addObject("projectModel", projectModel);
			}
		}
		int pageNow = 1; 
		int pageCount = 0;
		int pageSize = 10; // 每页显示10条
		int dataCount = 0;
		if (request.getParameter("pageNowFirst") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowFirst"));
		}
		if (request.getParameter("pageNowPre") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowPre"));
		}
		if (request.getParameter("pageNowNext") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowNext"));
		}
		if (request.getParameter("pageNowLast") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNowLast"));
		}
		List<MessageModel> mModels = MessageDAO.getAllListByRUserId(userId);
		int unReadMessageCount = 0; // 未读的一对一信息记录数
		int readMessageCount = 0; // 已读的一对一信息记录数
		List<MessageModel> unReadModels = new ArrayList<MessageModel>();
		List<MessageModel> readModels = new ArrayList<MessageModel>();
		if (mModels != null && !mModels.isEmpty()) {
			for (MessageModel messageModel : mModels) {
				if ("0".equals(messageModel.getIsRead())) {
					unReadMessageCount++;
					unReadModels.add(messageModel);
				} else if ("1".equals(messageModel.getIsRead())) {
					readMessageCount++;
					readModels.add(messageModel);
				}
			}
		}
		if ("1".equals(isRead)) { 
			dataCount = readMessageCount;
		} else if ("0".equals(isRead)) {
			dataCount = unReadMessageCount; 
		}
		if (dataCount % pageSize == 0) {
			pageCount = (int) (dataCount / pageSize); 
		} else {
			pageCount = (int) (dataCount / pageSize + 1);
		}
		Page page = PageHandler.getPage(pageSize, pageNow, dataCount);
		if (page != null) {
			mav.addObject("page", page);
			List<MessageModel> unReadMessageModels = new ArrayList<MessageModel>();
			List<MessageModel> readMessageModels = new ArrayList<MessageModel>();
			if (pageNow * pageSize < dataCount) { 
				if ("0".equals(isRead)) {
					unReadMessageModels = unReadModels.subList((pageNow - 1) * pageSize, pageNow * pageSize);
				} else if ("1".equals(isRead)) {
					readMessageModels = readModels.subList((pageNow - 1) * pageSize, pageNow * pageSize);
				}
			} else {
				if ("0".equals(isRead)) {
					unReadMessageModels = unReadModels.subList((pageNow - 1) * pageSize, (int) dataCount);
				} else if ("1".equals(isRead)) {
					readMessageModels = readModels.subList((pageNow - 1) * pageSize, (int) dataCount);
				}
			}
			if (unReadMessageModels != null && !unReadMessageModels.isEmpty()) {
				mav.addObject("unReadMessageModels", unReadMessageModels);
			}
			if (readMessageModels != null && !readMessageModels.isEmpty()) {
				mav.addObject("readMessageModels", readMessageModels);
			}
		}
		mav.addObject("pageCount", pageCount);
		mav.addObject("isRead", isRead);
		mav.addObject("flag", 1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("readMessageCount", readMessageCount);
		map.put("unReadMessageCount", unReadMessageCount);
		map.put("mav", mav);
		return map;
	}

	/**
	 * 修改Message的是否已读状态
	 */
	@Override
	public boolean updateIsRead(String messageId) {
		boolean result = false;
		MessageModel messageModel = MessageDAO.getById(messageId);
		if (messageModel != null) {
			if("0".equals(messageModel.getIsRead())) {
				messageModel.setIsRead("1");
			}
			result = MessageDAO.updateMessage(messageModel);
		}
		return result;
	}
	
	//////////////////////////////////////////////////////////////
	/**
	 * 后台消息列表分页
	 */
	@Override
	public List<MessageModel> getMessageList(BasicDBObject queryObj,int pageNow,int pageSize) {
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return MessageDAO.getAll(queryObj,pageSize, skip);
	}

	@Override
	public long countAllMessage(BasicDBObject queryObj) {
		return MessageDAO.countAll(queryObj);
	}

}
